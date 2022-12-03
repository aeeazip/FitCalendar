package model;

public class Exerciser {
	private int exerciserId; // primary key
	private String id; // 사용자 계정 아이디
	private String nickname; // 사용자 계정 이름
	private String password; // 사용자 계정 비밀번호
	private String explanation; // 한 줄 소개
	private String speciality; // 운동 주종목
	private String personality; // 성격
	private String gender; // 성별
	private int point; // 포인트
	private int ranking; // 랭킹
	private String useMatchSvc; // 매칭 시스템 허용 유무
	private int maxMate; // 최대 fitmate 수 설정

	public int getExerciserId() {
		return exerciserId;
	}

	public void setExerciserId(int exerciserId) {
		this.exerciserId = exerciserId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getUseMatchSvc() {
		return useMatchSvc;
	}

	public void setUseMatchSvc(String useMatchSvc) {
		this.useMatchSvc = useMatchSvc;
	}

	public int getMaxMate() {
		return maxMate;
	}

	public void setMaxMate(int maxMate) {
		this.maxMate = maxMate;
	}

	public Exerciser(int exerciserId, String id, String nickname, String password, String explanation,
			String speciality, String personality, String gender, int point, String useMatchSvc,
			int maxMate) {
		super();
		this.exerciserId = exerciserId;
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.explanation = explanation;
		this.personality = personality;
		this.speciality = speciality;
		this.gender = gender;
		this.point = point;
		this.useMatchSvc = useMatchSvc;
		this.maxMate = maxMate;
	}

	public Exerciser(int exerciserId) {
		super();
		this.exerciserId = exerciserId;
	}

// register 시 사용할 생성자
	public Exerciser(String id, String password, String nickname, String explanation, String personality,
			String speciality, String gender) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.explanation = explanation;
		this.personality = personality;
		this.speciality = speciality;
		this.gender = gender;
	}

	public Exerciser(int exerciserId, String useMatchSvc, int maxMate) {
		super();
		this.exerciserId = exerciserId;
		this.useMatchSvc = useMatchSvc;
		this.maxMate = maxMate;
	}

	public Exerciser(String useMatchSvc) {
		super();
		this.useMatchSvc = useMatchSvc;
	}

	public Exerciser() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Exerciser [exerciserId=" + exerciserId + ", id=" + id + ", nickname=" + nickname + ", password="
				+ password + ", explanation=" + explanation + ", speciality=" + speciality + ", personality="
				+ personality + ", gender=" + gender + ", point=" + point + ", ranking=" + ranking + ", useMatchSvc="
				+ useMatchSvc + ", maxMate=" + maxMate + "]";
	}

	// 비밀번호 검사
	public boolean matchPassword(String pword) {
		if (pword == null) {
			return false;
		}
		return this.password.equals(pword);
	}

}