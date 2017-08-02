package com.java1234.action;


import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.java1234.dao.UserDao;
import com.java1234.model.User;
import com.java1234.util.DbUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private HttpServletRequest request;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public String isLogin()throws Exception{
		HttpSession session=request.getSession();
		Object object=session.getAttribute("loginUser");
		if(object==null || !(object instanceof User)){
			return "login";
		}else{
			return "main";
		}
	}
	
	public String login()throws Exception{
		HttpSession session=request.getSession();
		Connection con=dbUtil.getCon();
		User loginUser=userDao.login(con, user);
		if(loginUser!=null){
			session.setAttribute("loginUser", loginUser);
			return "main";
		}else{
			request.setAttribute("error", "用户名或密码错误！");
			return "login";
		}
	}
	
	public String loginOut()throws Exception{
		HttpSession session=request.getSession();
		session.removeAttribute("loginUser");
		return "loginOut";
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	
}
