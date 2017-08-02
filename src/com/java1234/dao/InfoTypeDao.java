package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java1234.model.InfoType;

public class InfoTypeDao {

	public ArrayList<InfoType> getInfoTypeList(Connection con)throws Exception{
		ArrayList<InfoType> infoTypeList=new ArrayList<InfoType>();
		String sql="select * from infotype order by typeSign";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			InfoType infoType=new InfoType();
			infoType.setId(rs.getInt("id"));
			infoType.setTypeSign(rs.getInt("typeSign"));
			infoType.setTypeName(rs.getString("typeName"));
			infoTypeList.add(infoType);
		}
		return infoTypeList;
	}
}
