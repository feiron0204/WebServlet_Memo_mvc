package kr.or.bit.dao;
/*
1. db연결
2. CRUD 함수 생성(1개의 테이블에 대해서) >> memo
2.1 전체조회 : select id, email, content from memo
2.2 조건조회 : select id, email, content from memo where id=?(원칙 : id >>pk)
2.3 삽입    : insert into memo(id,email,content)values(?,?,?)
2.4 수정    : update memo set email=?, content=? where id=?
2.5 삭제    : delete from memo where id=?
기타 : Like 검색, 등등 필요에 따라서 ....
 
 

 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.SingletonHelper;

public class memodao {
	Connection conn=null;
	
	public memodao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	//전체조회 (구현하세요)
	public List<memo> getMemoList() throws SQLException{
		List<memo> m =new ArrayList<>();
		String query = "select * from memo";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			memo temp = new memo(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
			m.add(temp);
		}
		return m;
		/* 강사님해답
		 * PreparedStatement pstmt = null;
		 * String sql="select id, email, content from memo";
		 * pstmt = conn.prepareStatement(sql);
		 * ResultSet rs = pstmt.executeQuery();
		 * 
		 * List<memo> memolist = new ArrayList<memo>(); //POINT
		 * while(rs.next()){
		 * memo m = new memo();
		 * m.setid(rs.getString("id"));
		 * m.setemail(rs.getString("email"));
		 * m.setcontent(rs.getString("content"));
		 * memolist.add(m);
		 * }
		 * //[memo][memo][memo]......
		 * SingletonHelper.close(rs);
		 * SingletonHelper.close(pstmt);
		 * return memolist;
		 */
	}
	
	//조건조회
	public memo getMemoListById(String id){
		return null;
	}
	
	//삽입 (구현하세요)
	public int insertMemo(memo m) {//나중에 자동화..
		String query = "insert into memo(id, email,content)values(?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getContent());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		/*강사님 해답
		 * System.out.println(m.toString());
		 * int resultrow =0;
		 * 
		 * PreparedStatement pstmt = null;
		 * String sql = "insert into memo(id,email,content)values(?,?,?)";
		 * try{
		 * 		pstmt = conn.preparedStatement(sql);
		 * 		pstmt.setString(1,m.getId());
		 * 		pstmt.setString(2,m.getEmail());
		 * 		pstmt.setString(3.m.getContent());
		 * 		resultrow = pstmt.executeUpdate();
		 * }catch(Exception e){
		 * 		System.out.println(e.getMessage());
		 * }finally{
		 * 		SingletonHelper.close(pstmt);
		 * }
		 * 
		 * return resultrow;
		 * 
		 */
	}
	
	//수정
	public int updateMemo(memo m) {
		return 0;
	}
	
	//삭제
	public int deleteMemo(String id) {
		return 0;
	}
	
	//검색
	public memo idSearchByEmail(String email) {
		return null;
	}
}
