package kr.or.bit.dto;
/*
create table memo(
		id varchar2(15) not null,
		email varchar2(20) not null,
		content varchar2(100)
	);
	
	select id, email, content from memo where id = ? 이걸하려하는거임 >>데이터 1건ㅇ르 담을 수 있는 클래스

	즉 동일구조로 설계해야함
DTO -> DB테이블 >> member field 명을 .... 자동화 코드 생략하고 사용가능


*/
public class memo {
	private String id;
	private String email;
	private String content;
	
	public memo() {}

	public memo(String id, String email, String content) {
		super();
		this.id = id;
		this.email = email;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "memo [id=" + id + ", email=" + email + ", content=" + content + "]";
	}
	
	

}
