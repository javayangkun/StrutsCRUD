package com.struts2crud.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.struts2crud.bean.Page;
import com.struts2crud.bean.User;
import com.struts2crud.service.IUserService;
import com.struts2crud.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	//当前页,有set方法通过struts2框架可以从页面直接获得值
	private int p;

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	private static final long serialVersionUID = 1L;
	private User user = new User();

	public String save() {
		System.out.println("UserAction.save()" + user);
		return "find";
	}

	public String find() {
		IUserService userService = new UserServiceImpl();
		System.out.println(p);
		Page<User> pageDate = userService.findPageData(p, 5);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("page", pageDate);
		return "findUI";
	}

	@Override
	public User getModel() {
		return null;
	}

}
