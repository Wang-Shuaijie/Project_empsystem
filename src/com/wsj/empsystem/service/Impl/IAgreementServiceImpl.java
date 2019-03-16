package com.wsj.empsystem.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsj.empsystem.bean.Agreement;
import com.wsj.empsystem.dao.AgreementMapper;
import com.wsj.empsystem.exception.MyException;
import com.wsj.empsystem.service.IAgreementService;

@Service
public class IAgreementServiceImpl implements IAgreementService {
	@Autowired
	private AgreementMapper agreementMapper;

	@Override
	public void deleteAgr(Integer id) {
		// TODO Auto-generated method stub
		agreementMapper.deleteAgr(id);
	}

	@Override
	public void updateAgr(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		agreementMapper.updateAgr(map);
	}

	@Override
	public boolean AgrCheckByStaffId(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<Agreement> agreement =agreementMapper.AgrCheckByStaffId(map);
		if (agreement.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean AgrCheckByAgrId(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<Agreement> agreement =agreementMapper.AgrCheckByAgrId(map);
		if (agreement.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public void insertAgr(HashMap<String, Object> map) throws MyException {
		// TODO Auto-generated method stub
		agreementMapper.insertAgr(map);
	}

	@Override
	public Map<String, Object> findAgreement(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		map.put("name", name);
		List<Agreement> list=agreementMapper.queryAgr((HashMap<String, Object>) map);
		map.put("agreements", list);
		return map;
	}

}
