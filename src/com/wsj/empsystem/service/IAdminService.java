package com.wsj.empsystem.service;

import com.wsj.empsystem.bean.Administrator;

public interface IAdminService {
	//ÅĞ¶ÏÊÇ·ñµÇÂ¼
	boolean checkAdm(Administrator administrator);
	//×¢²á
	void insert(Administrator administrator);
	//ÅĞ¶ÏÊÇ·ñ´æÔÚ
	boolean exist(Administrator administrator);
	//É¾³ıÓÃ»§
	void delete(Administrator administrator);
}
