package com.hb.mvc.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController implements Serializable {

	@ExceptionHandler
	// @ResponseBody
	public String execute(HttpServletRequest request, Exception ex) {
		request.setAttribute("ex", ex);
		request.setAttribute("message", ex.getMessage());
		// ���Ը��ݲ�ͬ���쳣���ͷ��ز�ͬ����ͼ��
		return "error";

	}
}
