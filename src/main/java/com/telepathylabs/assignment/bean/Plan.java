package com.telepathylabs.assignment.bean;

import com.telepathylabs.assignment.bean.Feature;

public class Plan {

    private String name;
    private double cost;
    private Feature[] features;

	public Plan(){}

	public Plan(String name, double cost, Feature[] features){
        this.name = name;
        this.cost = cost;
        this.features = features;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Feature[] getFeatures() {
		return features;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}

   

}
