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
public class Record {
	int recordId;
	String title;
	String creationDate;
	int totalTime;
	int category;
	String routine;
	String diet;
	String photo;
	int shareOption;
	int exerciserId;
}
