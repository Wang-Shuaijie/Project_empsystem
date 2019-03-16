package com.wsj.empsystem.dao;

import java.util.List;

import com.wsj.empsystem.bean.Page;

public interface BaseDao<T> {

    void insert(T film);

    int deleteById(Long id);
    
    int update(T dto);

    List<T> query(Page<T> dto);

}
