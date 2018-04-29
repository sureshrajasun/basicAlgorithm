package com.telepathylabs.assignment.solutions;

import com.telepathylabs.assignment.bean.Feature;
import com.telepathylabs.assignment.bean.Plan;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

public class BestPlanFinderTest {

    private static BestPlanFinder bestPlanFinder;

    @BeforeClass
    public static void populateValues(){
        bestPlanFinder = new BestPlanFinder();
        bestPlanFinder.setSelectedFeatures(new Feature[]{new Feature("Email"), new Feature("Hosting")});

        bestPlanFinder. setAllPlans(
                new Plan[]{
                        new Plan(
                                "Business",
                                10D,
                                new Feature[] {
                                        new Feature("Email"),
                                        new Feature("Hosting"),
                                        new Feature("Phone"),
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

    @Test
    public void testBestPlanFinder() {

        Optional<Plan> plan = bestPlanFinder.findBestPlan();
        assertEquals("Basic",plan.get().getName());

    }

    @Test
    public void testBestPlanFinderMatching() {
        bestPlanFinder.setSelectedFeatures(new Feature[]{ new Feature("Hosting")});
        Optional<Plan> plan = bestPlanFinder.findBestPlan();
        assertEquals("Basic",plan.get().getName());

    }

    @Test
    public void testBestPlanFinderNotMatching1() {
        bestPlanFinder.setSelectedFeatures(new Feature[]{new Feature("NOT FOUNT"), new Feature("Hosting")});
        Optional<Plan> plan = bestPlanFinder.findBestPlan();
        assertTrue(!plan.isPresent());

    }

    @Test
    public void testBestPlanFinderNotMatching2() {
        bestPlanFinder.setSelectedFeatures(new Feature[]{new Feature("Email")});
        Optional<Plan> plan = bestPlanFinder.findBestPlan();
        assertEquals("Free",plan.get().getName());

    }

}
