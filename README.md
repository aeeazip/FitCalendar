# FitCalendar
데이터베이스프로그래밍 02분반 8팀 팔색조 

<br/>

## 서비스 소개
- **FitCalendar** : 운동 기록 공유 및 운동 메이트(Fit-Mate) 매칭 서비스
- 같이 운동하고 싶은 운동 메이트 혹은 배우고 싶은 운동 메이트를 매칭 받고 싶다면?
- 나의 운동 기록을 남길 수 있고 타인의 운동 기록을 보며 동기 부여를 받고 정보 공유를 받을 수 있는 서비스

<br/>

## 주요 기능
- 회원 관리: 회원가입, 회원탈퇴, 로그인, 로그아웃, 마이페이지
- 게시글 관리: 게시물 등록/수정/삭제, 전체 게시물 조회, 나의 게시물 조회
- 추천/매칭 관리: 다른 사용자 추천 및 매칭, 요천 상태 관리(수락/대기/거절), 사용자 간의 쪽지
- 포인트/랭킹 관리: 게시물 등록 시 포인트 지급, 추천/매칭 이용 시 포인트 차감, 포인트 기반 랭킹 부여
- 출석/통계 관리: Daily 출석 체크(포인트 지급), Weekly/Monthly 운동 횟수 통계, 최근 인바디 기록 비교

<br/>

## 기술 스택
- Java, HTML, CSS, JavaScript
- Eclipse, Oracle
- ERwin, SQL Developer
- JDBC, MyBatis, maven 기반 MVC 구조

<br/>

## 팀원
|한호정 (팀장)|양혜지 (팀원)|오인우 (팀원)|정채원 (팀원)|
|:------:|:---:|:------:|:---:|

<br/>

## 최종보고서
서비스 개요, 주요 기능 및 특징, 요구사항 분석(Use Case), 설계, 구현, 팀원별 업무 분담, 결론 및 소감<br/>[FitCalendar 최종보고서.pdf](https://github.com/Fit-Calendar/FitCalendar/files/10712964/02-08.pdf)

<br/>

## 발표 및 시연영상
https://www.youtube.com/watch?v=WFc9vY_7LyY

<br/>

## 테스트용 ID/PW
#### 주의사항 
  - 원하는 FitMate 정보 체크 시 (성별 : 여, 키 : 160-169, 몸무게 : 50-59, 체지방률 : 15-25, 원하는 운동 종목 : 헬스) 입력
  - FitMate 추천받기에 기입된 ID, PW로 로그인 -> FitMate 추천받기 -> 원하는 FitMate 정보 체크 -> FitMate 요청 보내기 or 재추천 받기 후 FitMate 요청 보내기
  - 요청 보낸 FitMate의 NICKNAME에 해당된 ID, PW로 로그인 -> 요청받은 FitMate -> 수락/거절
  - 아래 3개의 NICKNAME으로 FitMate 요청을 보냄
  - FitMate 요청 보내기, FitMate 수락/거절/메시지 기능 외 공통 기능은 모든 사용자에서 시연 가능

#### FitMate 추천받기
  - ID : hhj1030
  - PW : 123
  - NICKNAME : 호정
  
#### FitMate 수락/거절
- 1
  - ID : inuyang
  - PW : 0000
  - NICKNAME : 이누양
- 2
  - ID : hh123
  - PW : 123
  - NICKNAME : 호호
- 3
  - ID : hjhj
  - PW : 123
  - NICKNAME : 댕댕

<br/>

## Commit Message Convention
> 커밋태그: 내용 #이슈번호  

ex. `add: login 파일 추가 #20`

- 파일 추가 : add
- 버그 수정 : fix
- 리팩터링 : refactoring
- 파일 삭제 : remove
- 기능 추가 : feat
- 문서 수정 : docs
- 주석 추가 : comment
