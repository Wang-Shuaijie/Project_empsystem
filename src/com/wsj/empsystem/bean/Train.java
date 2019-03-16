package com.wsj.empsystem.bean;

import java.util.Date;

/**
 * 
 * Ա����ѵ��Ϣ��
 * @author WangShuaiJie
 *
 */
public class Train {
	private int train_id;
	// ��ѵ����id
	private int type_code;
	// ��ѵϸ��
	private TrainType trainType;
	// Ա����Ϣ
	private Staff staff;
	// ��ѵ��ʼʱ��
	private Date train_btime;
	// ��ѵ����ʱ��
	private Date train_etime;
	// ��ѵ�ĵ�
	private String train_expense;
	// Ա��id
	private int p_id;

	public Train() {

	}

	public int getTrain_id() {
		return train_id;
	}

	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}

	public int getType_code() {
		return type_code;
	}

	public void setType_code(int type_code) {
		this.type_code = type_code;
	}

	public TrainType getTrainType() {
		return trainType;
	}

	public void setTrainType(TrainType trainType) {
		this.trainType = trainType;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getTrain_btime() {
		return train_btime;
	}

	public void setTrain_btime(Date train_btime) {
		this.train_btime = train_btime;
	}

	public Date getTrain_etime() {
		return train_etime;
	}

	public void setTrain_etime(Date train_etime) {
		this.train_etime = train_etime;
	}

	public String getTrain_expense() {
		return train_expense;
	}

	public void setTrain_expense(String train_expense) {
		this.train_expense = train_expense;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

}
