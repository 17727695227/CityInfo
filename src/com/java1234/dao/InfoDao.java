package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java1234.model.Info;

public class InfoDao {

	public ArrayList<Info> getInfoList(Connection con,String sql)throws Exception{
		ArrayList<Info> infoList=new ArrayList<Info>();
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Info info=new Info();
			info.setId(rs.getInt("id"));
			info.setTypeId(rs.getInt("typeId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setLinkman(rs.getString("linkman"));
			info.setPhone(rs.getString("phone"));
			info.setEmail(rs.getString("email"));
			info.setInfoDate(rs.getDate("infoDate"));
			info.setState(rs.getInt("state"));
			info.setPayfor(rs.getInt("payfor"));
			info.setTypeName(rs.getString("typeName"));
			infoList.add(info);
		}
		return infoList;
	}
	
	public Info getInfoById(Connection con,String id)throws Exception{
		String sql="select * from info t1,infotype t2 where t1.typeId=t2.id and t1.id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs=pstmt.executeQuery();
		Info info=new Info();
		while(rs.next()){
			info.setId(rs.getInt("id"));
			info.setTypeId(rs.getInt("typeId"));
			info.setTitle(rs.getString("title"));
			info.setContent(rs.getString("content"));
			info.setLinkman(rs.getString("linkman"));
			info.setPhone(rs.getString("phone"));
			info.setEmail(rs.getString("email"));
			info.setInfoDate(rs.getDate("infoDate"));
			info.setState(rs.getInt("state"));
			info.setPayfor(rs.getInt("payfor"));
			info.setTypeName(rs.getString("typeName"));
		}
		return info;
	}
	
	public int addInfo(Connection con,Info info)throws Exception{
		String sql="insert into info values(null,?,?,?,?,?,?,now(),0,0)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, info.getTypeId());
		pstmt.setString(2, info.getTitle());
		pstmt.setString(3, info.getContent());
		pstmt.setString(4, info.getLinkman());
		pstmt.setString(5, info.getPhone());
		pstmt.setString(6, info.getEmail());
		return pstmt.executeUpdate();
	}
	
	public int deleteInfo(Connection con,String id)throws Exception{
		String sql="delete from info where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
}
