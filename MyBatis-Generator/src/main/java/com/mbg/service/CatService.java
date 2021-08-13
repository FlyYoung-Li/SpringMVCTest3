package com.mbg.service;

import com.mbg.entity.Cat;
import com.mbg.mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 李晓扬
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 20:56
 */
@Service
public class CatService {
    @Autowired(required = false)
    CatMapper catMapper;
//    因为原来，是自己定义的mapper，插入500条数据，而且是从页面发请求过来，进行添加的
   /* public void insert500(){
        List<Cat> cats = new ArrayList<Cat>();
        for (int i = 0; i < 500; i++) {
            cats.add(new Cat(null, UUID.randomUUID().toString().substring(0,5),"北京","A"));
        }
        catMapper.insertCats(cats);
    }

    public List<Cat> getCats() {

        List<Cat> cats = catMapper.getCats();
        return  cats;
    }*/
}
