package com.wsj.empsystem.bean;

import java.util.Date;

/**
 * 员工合同类
 * @author WangShuaiJie
 *
 */
public class Agreement {
	private int agreement_id;//合同id
	private int p_id;//员工id
	private Date agreement_btime;//合同生效时间
	private String agreement_content;//合同具体内容
	private Staff staff;//员工信息
	
	public Agreement() {
		// TODO Auto-generated constructor stub
	}

	public int getAgreement_id() {
		return agreement_id;
	}

	public void setAgreement_id(int agreement_id) {
		this.agreement_id = agreement_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public Date getAgreement_btime() {
		return agreement_btime;
	}

	public void setAgreement_btime(Date agreement_btime) {
		this.agreement_btime = agreement_btime;
	}

	public String getAgreement_content() {
		return agreement_content;
	}

	public void setAgreement_content(String agreement_content) {
		this.agreement_content = agreement_content;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "Agreement [agreement_id=" + agreement_id + ", p_id=" + p_id + ", agreement_btime=" + agreement_btime
				+ ", agreement_content=" + agreement_content + ", staff=" + staff + "]";
	}	
	
}
