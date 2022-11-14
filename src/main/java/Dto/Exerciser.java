package main.java.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter							// getter
@Setter							// setter
@AllArgsConstructor				// 모든 필드를 파라미터 값으로 쓰는 생성자
@NoArgsConstructor				// default 생성자 
@ToString						// toString
public class Exerciser {
	private int exerciserId;	// primary key
	private String id;			// 사용자 계정 아이디
	private String nickname;	// 사용자 계정 이름
	private String password;	// 사용자 계정 비밀번호
	private String explanation;	// 한 줄 소개
	private String speciality;	// 운동 주종목
	private String personality;	// 성격
	private String gender;		// 성별
	private int point;			// 포인트
	private int ranking;		// 랭킹
	private int userMatchSvc;	// 매칭 시스템 허용 유무
}
