package com.wsj.empsystem.bean;

/**
 * ≈‡—µœ∏Ω⁄¿‡
 * 
 * @author WangShuaiJie
 *
 */
public class TrainType {
	// ≈‡—µœ∏Ω⁄id
	private int type_code;
	// ≈‡—µ√˚≥∆
	private String type_name;
	// ≈‡—µƒ⁄»›
	private String type_info;

	public TrainType() {
	}

	public int getType_code() {
		return type_code;
	}

	public void setType_code(int type_code) {
		this.type_code = type_code;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_info() {
		return type_info;
	}

	public void setType_info(String type_info) {
		this.type_info = type_info;
	}

	@Override
	public String toString() {
		return "TrainType{" + "type_code=" + type_code + ", type_name='" + type_name + '\'' + ", type_info='"
				+ type_info + '\'' + '}';
	}
}
