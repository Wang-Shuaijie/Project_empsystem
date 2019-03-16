package com.wsj.empsystem.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Administrator;
import com.wsj.empsystem.dao.AdmMapper;
import com.wsj.empsystem.service.IAdminService;

@Service
public class IAdminServiceImpl implements IAdminService{
	@Autowired
	private AdmMapper admMapper;
	
	@Override
	public boolean checkAdm(Administrator administrator) {
		// TODO Auto-generated method stub
		Administrator adm=admMapper.queryAdm(administrator);
		if(adm !=null && adm.getAdmPassword().equals(administrator.getAdmPassword())){
			return true;
		}
		return false;
	}

	@Override
	public void insert(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exist(Administrator administrator) {
		// TODO Auto-generated method stub
		Administrator adm = admMapper.queryAdm(administrator);
		if(adm != null){
			return true;
		}
		return false;
	}

	@Override
	public void delete(Administrator administrator) {
		// TODO Auto-generated method stub
		
	}

}
