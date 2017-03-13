package com.vsi.featuretoggle.dao;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.vsi.featuretoggle.model.Feature;
import java.util.List;

public class MongoDAO implements ToggleDAO {
    public Feature save(Feature feature) {
        if(feature == null || feature.getName() == null) {
            return null;
        }
        MongoOperations operations  = MongoFactory.getMongoOperations();
        operations.save(feature);

        return feature;
    }

    public Feature findByName(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }
        Query searchToggleQuery= new Query(Criteria.where("name").is(name));
        MongoOperations operations = MongoFactory.getMongoOperations();
        return operations.findOne(searchToggleQuery, Feature.class);
    }

    public Feature update(Feature feature) {
        if(feature == null )
            return null;
        MongoOperations operations = MongoFactory.getMongoOperations();
        operations.save(feature);
        return feature;
    }

    public boolean delete(Feature feature) {
        if(feature == null)
            return false;

        MongoOperations operations = MongoFactory.getMongoOperations();
        Query query = new Query(Criteria.where("name").is(feature.getName()));
        operations.findAndRemove(query, Feature.class);
        return true;
    }

    public List<Feature> getAll() {
        MongoOperations operations = MongoFactory.getMongoOperations();
        return operations.findAll(Feature.class);
    }
}