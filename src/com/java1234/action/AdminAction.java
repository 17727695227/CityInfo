package com.java1234.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.java1234.dao.InfoDao;
import com.java1234.dao.InfoTypeDao;
import com.java1234.model.Info;
import com.java1234.model.InfoType;
import com.java1234.util.DbUtil;
import com.java1234.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DbUtil dbUtil=new DbUtil();
	private static InfoDao infoDao=new InfoDao();
	private HttpServletRequest request;
	private String payfor;
	private String state;
	private String typeId;
	private String delId;
	
	

	public String getPayfor() {
		return payfor;
	}

	public void setPayfor(String payfor) {
		this.payfor = payfor;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	

	public String getDelId() {
		return delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public String searchInfo()throws Exception{
		request.setAttribute("mainPage", "/pages/admin/info/searchInfo.jsp");
		StringBuffer sb=new StringBuffer("select * from info t1,infotype t2 where t1.typeId=t2.id ");
		if(!"all".equals(payfor)){
			sb.append(" and t1.payfor="+payfor);
		}
		if(!"all".equals(state)){
			sb.append(" and t1.state="+state);
		}
		sb.append(" and t1.typeId="+typeId+" order by t1.infoDate desc ");
		Connection con=dbUtil.getCon();
		ArrayList<Info> searchInfoList=infoDao.getInfoList(con, sb.toString());
		request.setAttribute("searchInfoList", searchInfoList);
		return "searchInfo";
	}
	
	public String deleteInfo()throws Exception{
		Connection con=dbUtil.getCon();
		int delNum=infoDao.deleteInfo(con, delId);
		boolean delFlag;
		if(delNum==1){
			delFlag=true;
		}else{
			delFlag=false;
		}
		ResponseUtil.write(delFlag);
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	
}
