package controller.record;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Exerciser;
import model.service.ExerciserManager;
import model.service.RecordManager;

public class WriteRecordController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(WriteRecordController.class);
	private static HttpSession session;
	String str;
	Exerciser exerciser;

	String title = null;
	String creationDate = null;
	int totalTime;
	int category;
	String routine = null;
	String diet = null;
	int shareOption;
	String photo = null;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();

		RecordManager recordManager = RecordManager.getInstance();
		ExerciserManager userManager = ExerciserManager.getInstance();

		if (request.getMethod().equals("GET")) {
			// GET request: 기록 등록 form 요청
			str = (String) session.getAttribute("id");
			exerciser = userManager.findExerciser(str);

			request.setAttribute("NickName", exerciser.getNickname());
			log.debug("RecordForm Request");
			return "/myRecord/recordForm.jsp"; // registerForm으로 이동
		}

		int exerciserId = exerciser.getExerciserId();

		boolean check = ServletFileUpload.isMultipartContent(request);   
		if(check) { 
			// 전송된 요청 메시지의 타입이 multipart 인지 여부를 체크한다. (multipart/form-data)
			// 아래와 같이 하면 Tomcat 내부에 복사된 프로젝트 밑에 upload 폴더가 생성됨 
			ServletContext context = request.getServletContext();
			String path = context.getRealPath("/upload");
			File dir = new File(path);

			if (!dir.exists()) dir.mkdir();  // 전송된 파일을 저장할 폴더 생성

			try {
				DiskFileItemFactory factory = new DiskFileItemFactory(); // 파일 전송에 대한 기본적인 설정 Factory 클래스를 생성한다.
				factory.setSizeThreshold(10 * 1024); // 메모리에 한번에 저장할 데이터의 크기를 10KB로 설정한다.
				factory.setRepository(dir); // 전송된 데이터의 내용을 저장할 폴더를 지정한다.                

				ServletFileUpload upload = new ServletFileUpload(factory); // Factory 클래스를 통해 실제 업로드 되는 내용을 처리할 객체를 선언한다.
				upload.setSizeMax(10 * 1024 * 1024); // 업로드 될 파일의 최대 용량을 10MB로 설정한다.
				upload.setHeaderEncoding("utf-8"); // 업로드 되는 내용의 인코딩 방식을 설정한다.

				List<FileItem> items = (List<FileItem>)upload.parseRequest(request); // upload 객체에 전송된 모든 데이터(요청 파라미터)를 Collection 객체에 담는다.

				for (int i = 0; i < items.size(); ++i) {
					FileItem item = (FileItem)items.get(i);            

					String value = item.getString("utf-8"); // 넘어온 값에 대한 한글 처리를 한다.               	
					
					if (item.isFormField()) {  // item이 일반 데이터인 경우                		
						if(item.getFieldName().equals("title")) title = value;// parameter 이름이 title이면 title 변수에 값을 저장한다.
						else if(item.getFieldName().equals("creationDate")) creationDate = value;
						else if(item.getFieldName().equals("totalTime")) totalTime = Integer.parseInt(value);
						else if(item.getFieldName().equals("category")) category = Integer.parseInt(value);
						else if(item.getFieldName().equals("routine")) routine = value;
						else if(item.getFieldName().equals("diet")) diet = value;
						else if(item.getFieldName().equals("shareOption")) shareOption = Integer.parseInt(value);
						
					}
					else {  // item이 파일인 경우   
						if (item.getFieldName().equals("photo")) {
							// parameter 이름이 picture이면 파일 저장을 한다.
							String oriFilename = item.getName();	// 파일 이름 획득 (자동 한글 처리 됨)
							if (oriFilename == null || oriFilename.trim().length() == 0) continue;
							// 파일이 전송되어 오지 않았다면 건너뜀

							// filename = oriFileName.substring(oriFileName.lastIndexOf("\\") + 1);                        					 
							// 파일 이름이 파일의 전체 경로까지 포함하기 때문에 이름 부분만 추출해야 한다.
							// 실제 C:\Web_Java\aaa.gif라고 하면 aaa.gif만 추출하기 위한 코드임

							photo = UUID.randomUUID().toString() + "_" 
									+ oriFilename.substring(oriFilename.lastIndexOf("\\") + 1);  
							// 파일 이름이 중복되지 않도록 UUID(Universally Unique IDentifier)를 생성해서 원래의 이름 앞에 붙임


							// 또는 아래와 같이 원래의 파일의 확장자만 추출해서 UUID와 함께 파일 이름 생성
							// filename = UUID.randomUUID().toString() 
							// 		+ oriFilename.substring(oriFilename.lastIndexOf("."));

							System.out.println("uploaded file: " + photo);

							File file = new File(dir, photo);
							item.write(file);
							// 파일을 upload 경로에 실제로 저장한다.
							// FileItem 객체로부터 바로 출력 저장할 수 있다.
						}
					}
				}

			} catch(SizeLimitExceededException e) {
				// 업로드 되는 파일의 크기가 지정된 최대 크기를 초과할 때 발생하는 예외처리
				e.printStackTrace();           
			} catch(FileUploadException e) {
				// 파일 업로드와 관련되어 발생할 수 있는 예외 처리
				e.printStackTrace();
			} catch(Exception e) {            
				e.printStackTrace();
			} 
		} 
		
		try {
			// 1. DB에 Record 정보 등록하기
			recordManager.insertRecord(title, creationDate, totalTime, category, routine, diet, photo, shareOption,
					exerciserId);
			// 2. 10 포인트 적립하기
			int result = userManager.updatePoint(exerciserId);
			System.out.println("57행:" + result);

			return "redirect:/myRecord/list"; // 성공 시 사용자 리스트 화면으로 redirect

		} catch (Exception e) { // 예외 발생 시 회원가입 form으로 forwarding
			request.setAttribute("createFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("exerciserId", exerciserId);
			return "/myRecord/recordForm.jsp";
		}
	}
}