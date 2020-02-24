package com.lcx.spider.controller;

import com.lcx.spider.entity.Item;
import com.lcx.spider.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelectItemsController {
    @Autowired
    ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/searchItems", method = RequestMethod.POST)
    public Map searchItems(@RequestParam(name = "keyword") String keyword) {
        List<Item> items;
        Map<String, Object> result = new HashMap<>();

        if (keyword.contains("手机")) {
            items = itemService.selectPhonesNormal(keyword);
        } else if (keyword.contains("平板")) {
            items = itemService.selectTabletsNormal(keyword);
        } else if (keyword.contains("相机")) {
            items = itemService.selectCamerasNormal(keyword);
        } else if (keyword.contains("电视")) {
            items = itemService.selectTelevisionNormal(keyword);
        } else {
            result.put("code", 500);
            return result;
        }

        result.put("data", items);
        result.put("code", 200);
        return result;
    }
}
