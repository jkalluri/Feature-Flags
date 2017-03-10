package com.vsi.featuretoggle.dao;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.vsi.featuretoggle.model.Feature;
import java.util.List;

public class MongoDAO {
    public void saveFeatureToggle(Feature feature) {
        if(feature == null || feature.getName() == null) {
            return;
        }
        MongoOperations operations  = MongoFactory.getMongoOperations();
        operations.save(feature);
    }

    public Feature getFeatureToggle(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }
        Query searchToggleQuery= new Query(Criteria.where("name").is(name));
        MongoOperations operations = MongoFactory.getMongoOperations();
        return operations.findOne(searchToggleQuery, Feature.class);
    }

    public void updateFeatureToggle(Feature feature) {
        if(feature == null )
            return;
        MongoOperations operations = MongoFactory.getMongoOperations();
        operations.save(feature);
    }

    public void deleteFeatureToggle(Feature feature) {
        if(feature == null)
            return;

        MongoOperations operations = MongoFactory.getMongoOperations();
        Query query = new Query(Criteria.where("name").is(feature.getName()));
        operations.findAndRemove(query, Feature.class);
    }

    public List<Feature> getAllFeatureToggles() {
        MongoOperations operations = MongoFactory.getMongoOperations();
        return operations.findAll(Feature.class);
    }
}