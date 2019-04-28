package org.hg.dubbo.provider.mongodb.controller;

import com.mongodb.client.MongoCollection;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.hg.myframe.core.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huanggang6135@gmail.com
 * @Date 2019/4/17 14:57
 * @Desc
 * @Version 1.0
 **/
@RestController
@RequestMapping("mongodb")
@Api("mongodb操作接口")
public class MongodbController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @PostMapping("saveUser")
    @ApiOperation("保存用户")
    public String saveUser(String name, String password){
        Result<String> result = new Result<>();
        if(mongoTemplate.collectionExists("user")){
            mongoTemplate.createCollection("user");
        }
        MongoCollection<Document> user = mongoTemplate.getCollection("user");
        user.insertOne(new Document().append("name", name).append("password", password));
        return result.toJsonString();
    }
}
