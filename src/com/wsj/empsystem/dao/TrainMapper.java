package com.wsj.empsystem.dao;


import java.util.HashMap;
import java.util.List;

import com.wsj.empsystem.bean.Train;

public interface TrainMapper {
    List<Train> queryTrain(HashMap<String,Object> map);
    Integer sum();
    void deleteTrain(Integer id);
    void updateTrain(HashMap<String,Object>map);
    void insertTrain(HashMap<String,Object>map);
}
