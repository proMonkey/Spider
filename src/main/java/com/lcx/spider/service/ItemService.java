package com.lcx.spider.service;

import com.lcx.spider.entity.Item;
import com.lcx.spider.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemMapper itemMapper;

    public List<Item> selectPhonesNormal(String keyword){
        return itemMapper.selectPhonesNormal(keyword);
    };

    public List<Item> selectTabletsNormal(String keyword){
        return itemMapper.selectTabletsNormal(keyword);
    };

    public List<Item> selectCamerasNormal(String keyword){
        return itemMapper.selectCamerasNormal(keyword);
    };

    public List<Item> selectTelevisionNormal(String keyword){
        return itemMapper.selectTelevisionNormal(keyword);
    };
}
