package com.lcx.spider.mapper;

import com.lcx.spider.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemMapper {
    public List<Item> selectPhonesNormal(String keyword);

    public List<Item> selectTabletsNormal(String keyword);

    public List<Item> selectCamerasNormal(String keyword);

    public List<Item> selectTelevisionNormal(String keyword);
}
