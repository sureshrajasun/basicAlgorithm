package com.telepathylabs.assignment.solutions;

import com.telepathylabs.assignment.bean.Feature;
import com.telepathylabs.assignment.bean.Plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BestPlanFinder {
	private Plan[] 		allPlans;                    // this is the list of plans available instantiated as per the above
	private Feature[] 	selectedFeatures;         // this is the list of features the user wants -> find
	
	private void setPlanDetailsAndFeaturesData() {
		
		setSelectedFeatures(new Feature[]{new Feature("SSL")});

		setAllPlans(
				new Plan[]{
	    			new Plan(
	    					"Business",
	    					10D,
	    					new Feature[] {
								new Feature("Email"),
								new Feature("Hosting"),
								new Feature("Phone"),
								new Feature("SSL"),
								new Feature("Cloud")
					}),
	    			new Plan(
	    					"Basic",
	    					5D,
	    					new Feature[] {
								new Feature("Email"),
								new Feature("SSL"),
								new Feature("Hosting")
	
					}),
	    			new Plan(
	    					"Free",
	    					0D,
	    					new Feature[] {
								new Feature("Email")
	    					})
				}
			);

	}

    public static void main(String[] args) {
    	
    	BestPlanFinder bestPlan = new BestPlanFinder();
    	
    	bestPlan.setPlanDetailsAndFeaturesData();
    	Optional<Plan> plan = bestPlan.findBestPlan();
    	
    	bestPlan.printBestPlan(plan);

    }
	/**
	 * @param plan
	 */
	private void printBestPlan(Optional<Plan> plan) {
		if(plan.isPresent()) {
    		System.out.println(String.format("For the selected feature(s) : %s",
    				Arrays.stream(getSelectedFeatures()).map(l -> l.getName()).collect(Collectors.toList()) ));
    		
    		System.out.println(String.format("The best plan is : %s", plan.get().getName()));
    	}else {
    		System.out.println(String.format("There is no best plan available for the Feature(s) : %s", 
    				Arrays.stream(getSelectedFeatures()).map(l -> l.getName()).collect(Collectors.toList()) ));
    	}
	}
	/**
	 * @param allPlans
	 * @param selectedFeatures
	 */
	public Optional<Plan> findBestPlan() {
		List<Plan> matchedPlans;
        
        matchedPlans = getAllPlansForFeatures(getAllPlans(), getSelectedFeatures());

        return getEffectivePlan(matchedPlans);
	}
	
	/**
	 * @param allPlans
	 * @param selectedFeatures
	 * @param matchedPlan
	 */
	private List<Plan> getAllPlansForFeatures(Plan[] allPlans, Feature[] selectedFeatures) {
		List<Plan> matchedPlans = new ArrayList();
		int numOfFeatures;
		int featuresMatched;
		for (Plan plan : allPlans){
            Feature[] features = plan.getFeatures();
            numOfFeatures = selectedFeatures.length;
            featuresMatched = 0;
            List<Feature> list = Arrays.asList(features);
            for(Feature feature : selectedFeatures){
                if(list.contains(feature)){
                    featuresMatched++;
                }
            }
            if(selectedFeatures.length == featuresMatched && featuresMatched <= numOfFeatures  ){
                matchedPlans.add(plan);
            }
        }
		return matchedPlans;
	}
	
	/**
	 * @param matchedPlans
	 */
	private Optional<Plan> getEffectivePlan(List<Plan> matchedPlans) {
		if(!matchedPlans.isEmpty()) {
        	final Comparator<Plan> comp = (p1, p2) -> Double.compare( p1.getCost(), p2.getCost());
        	return matchedPlans.stream().min(comp);
        }
		return Optional.empty();
	}

	public Plan[] getAllPlans() {
		return allPlans;
	}

	public void setAllPlans(Plan[] allPlans) {
		this.allPlans = allPlans;
	}

	public Feature[] getSelectedFeatures() {
		return selectedFeatures;
	}

	public void setSelectedFeatures(Feature[] selectedFeatures) {
		this.selectedFeatures = selectedFeatures;
	}

	
}
