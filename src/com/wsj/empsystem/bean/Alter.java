package com.wsj.empsystem.bean;

import java.util.Date;

/**
 * Ա��������Ϣ��
 * @author WangShuaiJie
 *
 */
public class Alter {
	//������Ϣid
		private int alterId;
		//Ա����Ϣ
		private Staff staff;
		//���ʼʱ��
		private Date alter_btime;
		//�������ʱ��
		private Date alter_etime;
		//��������
		private String alter_content;

		public Alter() {
		
		}
		
		public int getAlterId() {
			return alterId;
		}

		public void setAlterId(int alterId) {
			this.alterId = alterId;
		}

		public Staff getStaff() {
			return staff;
		}

		public void setStaff(Staff staff) {
			this.staff = staff;
		}

		public Date getAlter_btime() {
			return alter_btime;
		}

		public void setAlter_btime(Date alter_bstate) {
			this.alter_btime = alter_bstate;
		}

		public Date getAlter_etime() {
			return alter_etime;
		}

		public void setAlter_etime(Date alter_etime) {
			this.alter_etime = alter_etime;
		}

		public String getAlter_content() {
			return alter_content;
		}

		public void setAlter_content(String alter_content) {
			this.alter_content = alter_content;
		}
}
