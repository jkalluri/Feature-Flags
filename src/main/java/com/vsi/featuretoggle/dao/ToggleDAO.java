package com.vsi.featuretoggle.dao;


import com.vsi.featuretoggle.model.Feature;
import java.util.List;

public interface ToggleDAO {
    public abstract Feature save(Feature feature);

    public abstract Feature findByName(String featureName);

    public abstract List<Feature> getAll();

    public abstract Feature update(Feature feature);

    public abstract boolean delete(Feature feature);

}