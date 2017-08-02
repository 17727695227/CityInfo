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
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DbUtil dbUtil=new DbUtil();
	private static InfoTypeDao infoTypeDao=new InfoTypeDao();
	private InfoDao infoDao=new InfoDao();
	private static ArrayList<InfoType> infoTypeList;
	private HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		Connection con=null;
		HttpSession session=request.getSession();
		con=dbUtil.getCon();
		// �ɷ���Ϣ
		String sql="select * from info t1,infotype t2 where t1.typeId=t2.id and t1.state=1 and t1.payfor=1 order by t1.infodate desc";
		ArrayList<Info> payinfoList=infoDao.getInfoList(con, sql);
		request.setAttribute("payinfoList", payinfoList);
		
		// �����Ϣ
		List allFreeList=new ArrayList();
		if(infoTypeList!=null && infoTypeList.size()!=0){
			for(int i=0;i<infoTypeList.size();i++){
				InfoType infoType=infoTypeList.get(i);
				String sql2="select * from info t1,infotype t2 where t1.typeId=t2.id and t1.state=1 and t1.payfor=0 and t1.typeId="+infoType.getId()+" order by t1.infodate desc limit 0,5";
				List<Info> oneSubList=infoDao.getInfoList(con, sql2);
				allFreeList.add(oneSubList);
			}			
		}
		request.setAttribute("allFreeList", allFreeList);
		
		session.setAttribute("infoTypeList", infoTypeList);
		return "index";
	}
	
	static{
		Connection con=null;
		try {
		    con=dbUtil.getCon();
			infoTypeList=infoTypeDao.getInfoTypeList(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	
}
