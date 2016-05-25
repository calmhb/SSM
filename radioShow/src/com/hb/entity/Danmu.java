package com.hb.entity;

/**
 * 慕弹数据
 * 
 * @author hb
 * 
 * @date 2016年1月13日 下午2:53:29
 */
public class Danmu {
	private String text;// 弹幕文本内容。
	private String color;// 弹幕颜色。
	private int position;// 弹幕位置 “0”为滚动 “1” 为顶部 “2”为底部
	private int size;// 弹幕文字大小。 “0”为小字 ”1”为大字
	private int time;// 弹幕所出现的时间。 单位为”分秒“（及1/10秒，100毫秒）
	private int isnew;// 当出现该属性时（属性值可以任意），会认为这是用户新发的弹幕，从而弹幕在显示的时候会有边框。

	public Danmu() {
		super();
	}

	public Danmu(String text, String color, int position, int size, int time,
			int isnew) {
		super();
		this.text = text;
		this.color = color;
		this.position = position;
		this.size = size;
		this.time = time;
		this.isnew = isnew;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getIsnew() {
		return isnew;
	}

	public void setIsnew(int isnew) {
		this.isnew = isnew;
	}

}
