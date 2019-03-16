package com.wsj.empsystem.bean;

/**
 * ����Ա��
 * ��������Աid���û�����������������
 * @author WangShuaiJie
 *
 */
public class Administrator {
	private int admId;
	private String admUserName;
	private String admPassword;

	public Administrator() {

	}

	public Administrator(String admUserName, String admPassword) {
		this.admUserName = admUserName;
		this.admPassword = admPassword;
	}

	public int getAdmId() {
		return admId;
	}

	public void setAdmId(int admId) {
		this.admId = admId;
	}

	public String getAdmUserName() {
		return admUserName;
	}

	public void setAdmUserName(String admUserName) {
		this.admUserName = admUserName;
	}

	public String getAdmPassword() {
		return admPassword;
	}

	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}

	@Override
	public String toString() {
		return "Adminstrator{" + "admId=" + admId + ", admUserName='" + admUserName + '\'' + ", admPassword='"
				+ admPassword + '\'' + '}';
	}
}
