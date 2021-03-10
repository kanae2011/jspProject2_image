package com.webjjang.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.webjjang.image.vo.ImageVO;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class ImageDAO {

	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//3.이미지 등록
	public int write(ImageVO vo) throws Exception {
		int result = 0;
		try {
			
			con = DBInfo.getConnection();
			pstmt = con.prepareStatement(DBSQL.IMAGE_WRITE);
			
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setString(3,vo.getId());
			pstmt.setString(4,vo.getFileName());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("이미지 등록중 DB 처리 중 오류 발생");
		}finally{
			DBInfo.close(con, pstmt, rs);
		}
		return result;
	}
}
