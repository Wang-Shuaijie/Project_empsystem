package com.wsj.empsystem.dao;

import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.TrainType;

public interface TrainTypeMapper {
    List<TrainType> TrainCheck(HashMap<String,Object> map);
    List<TrainType> queryTrainType(HashMap<String,Object>map);
    TrainType findTrainTypeById(int id);
    Integer sum();
    void deleteTrainType(Integer id);
    void updateTrainType(HashMap<String,Object> map);
    void insertTrainType(HashMap<String,Object> map);
}
