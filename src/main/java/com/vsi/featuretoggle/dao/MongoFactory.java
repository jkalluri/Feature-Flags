package com.vsi.featuretoggle.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class MongoFactory {
    private static MongoOperations mongoOperations = null;

    public static MongoOperations getMongoOperations() {
        if(mongoOperations == null) {
            ApplicationContext ctx = new GenericXmlApplicationContext("spring-config.xml");
            mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
        }
        return mongoOperations;
    }

}