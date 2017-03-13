package com.vsi.featuretoggle.service;

import com.vsi.featuretoggle.model.Feature;
import java.util.List;
import com.vsi.featuretoggle.dao.MongoDAO;
public class ToggleService {
    public List<Feature> getAllFeatures() {
        MongoDAO dao = new MongoDAO();
        return dao.getAll();
    }

    public boolean isFeatureOn(String featureName) {
        Feature feature = getFeature(featureName);
        if(feature != null)
            return feature.isOn();

        return false;
    }

    public Feature createFeatureToggle(Feature feature) {
        MongoDAO dao = new MongoDAO();
        dao.save(feature);
        return dao.findByName(feature.getName());
    }

    public Feature turnFeatureOn(String featureName) {
        MongoDAO dao = new MongoDAO();
        Feature feature = getFeature(featureName);
        if(feature != null) {
            feature.setState(true);
            dao.save(feature);
        }

        return dao.findByName(featureName);
    }

    public Feature turnFeatureOff(String featureName) {
        MongoDAO dao = new MongoDAO();
        Feature feature = getFeature(featureName);
        if(feature != null) {
            feature.setState(false);
            dao.save(feature);
        }
        return dao.findByName(featureName);

    }

    public Feature updateFeatureToggle(Feature feature) {
        MongoDAO dao = new MongoDAO();
        dao.save(feature);
        return dao.findByName(feature.getName());
    }

    public Feature deleteFeatureToggle(String featureName) {
        MongoDAO dao = new MongoDAO();
        Feature feature = dao.findByName(featureName);
        if(feature != null)
            dao.delete(feature);
        return feature;
    }

    public Feature getFeature(String featureName) {
        MongoDAO dao = new MongoDAO();
        return dao.findByName(featureName);
    }


}