package com.hb.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hb.entity.Danmu;

/**
 * 
 * @author hb
 * 
 * @date 2016年1月13日 下午5:03:23
 */
public class RadioMessageAction extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		if ("/show".equals(path)) {
			String datas = getJsonString();
			PrintWriter out = response.getWriter();
			System.out.println(datas);
			out.println(datas);
		} else if ("/save".equals(path)) {
			// 单击发送按钮获得页面发送的数据
			String danmu = request.getParameter("danmu");
			// {
			// "text":"好人","color":"#ffffff","size":"1","position":"0","time":3}
			// System.out.println("danmu=" + danmu);
			JSONObject obj = JSONObject.fromObject(danmu);
			Danmu d = (Danmu) obj.toBean(obj, Danmu.class);
			System.out.println(d);
		}
	}

	private String getJsonString() {
		List<Danmu> list = new ArrayList<Danmu>();
		Danmu d1 = new Danmu();
		d1.setText("来自服务端");
		d1.setColor("red");
		d1.setPosition(0);
		d1.setSize(1);
		d1.setTime(2);

		Danmu d2 = new Danmu();
		d2.setText("太狗血了。。。");
		d2.setColor("white");
		d2.setPosition(0);
		d2.setSize(0);
		d2.setIsnew(0);
		d2.setTime(4);
		list.add(d1);
		list.add(d2);

		// JSONArray datas = JSONArray.fromObject(list);
		String datas = "[";
		for (Danmu d : list) {
			JSONObject obj = JSONObject.fromObject(d);
			datas += "'" + obj.toString() + "',";

		}
		datas = datas.substring(0, datas.length() - 1);
		datas += "]";

		return datas.toString();
	}
}
