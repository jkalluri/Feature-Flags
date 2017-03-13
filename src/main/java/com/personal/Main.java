package com.personal;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.vsi.featuretoggle.model.Feature;
import com.vsi.featuretoggle.dao.MongoDAO;
import java.util.List;
import com.vsi.featuretoggle.service.ToggleService;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!!");

        //MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        //MongoOperations mongoOperation = MongoDAO.getMongoOperations();

        //MongoDAO dao = new MongoDAO();
        ToggleService service = new ToggleService();

        Feature feature = new Feature("BOPS", "Buy Online Pick in Store", true);

        // save
        //mongoOperation.save(feature);
        //dao.save(feature);
        service.createFeatureToggle(feature);

        // now toggle object got the created id.
        System.out.println("1. feature name: " + feature.getName());
        System.out.println("1. feature state: " + feature.isOn());

        // query to search feature toggle
        Query searchToggleQuery= new Query(Criteria.where("name").is("BOPS"));

        // find the saved feature again.
        //Feature savedFeature = dao.findByName(feature.getName());
        Feature savedFeature = service.getFeature(feature.getName());
        System.out.println("savedFeature: " + savedFeature);
        //Feature savedFeature = mongoOperation.findOne(searchToggleQuery, Feature.class);
        System.out.println("2. find - saved feature state: " + savedFeature.isOn());

        // update feature toggle
        //mongoOperation.updateFirst(searchToggleQuery,
          //      Update.update("state", false),Feature.class);

        savedFeature.setState(false);
        //dao.update(savedFeature);
        service.updateFeatureToggle(savedFeature);
        // find the updated user object
        //Feature updatedFeatureToggle = mongoOperation.findOne(searchToggleQuery, Feature.class);
        //Feature updatedFeatureToggle = dao.findByName(savedFeature.getName());
        Feature updatedFeatureToggle = service.getFeature(savedFeature.getName());

        System.out.println("3. updatedFeature state: " + updatedFeatureToggle.isOn());

        // delete
        //mongoOperation.remove(searchToggleQuery, Feature.class);

        //dao.delete(feature);
        service.deleteFeatureToggle(feature.getName());

        // List, it should be empty now.
        //List<Feature> listFeatures = mongoOperation.findAll(Feature.class);
        //List<Feature> listFeatures = dao.getAll();
        List<Feature> listFeatures = service.getAllFeatures();
        System.out.println("4. Number of Feature Toggles= " + listFeatures.size());
    }
}
