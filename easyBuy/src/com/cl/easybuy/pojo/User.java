package com.cl.easybuy.pojo;

/**
 * ��װ�û���Ϣ
 * 
 * @author calm
 * 
 */
public class User {
	/**
	 * ����:�������������
	 */
	private Integer id;// ���
	private String username;// �û���
	private String pwd;// ����
	private int pro;// Ȩ��

	/**
	 * ������
	 */
	public User() {
	}

	public User(Integer id, String username, String pwd, int pro) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.pro = pro;
	}

	/**
	 * Ϊ�����ṩgetter��setter����
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getPro() {
		return pro;
	}

	public void setPro(int pro) {
		this.pro = pro;
	}

}
