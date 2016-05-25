package com.hb.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.hb.entity.Danmu;

public class TestObj {

	public static void main(String[] args) {
		List<Danmu> list = new ArrayList<Danmu>();
		Danmu d1 = new Danmu();
		d1.setText("来自服务端");
		d1.setColor("red");
		d1.setPosition(0);
		d1.setSize(1);
		d1.setTime(2);
		list.add(d1);

		Danmu d2 = new Danmu();
		d1.setText("太狗血了。。。");
		d1.setColor("black");
		d1.setPosition(0);
		d1.setSize(0);
		d1.setIsnew(0);
		d1.setTime(4);
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

		System.out.println(datas);
	}

}
