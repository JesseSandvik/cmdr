package com.sp3.gherkin.model;

public class GherkinFeature {
    private String name;
    private GherkinScenario[] scenarios;

    public GherkinFeature() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GherkinScenario[] getScenarios() {
        return scenarios;
    }

    public void setScenarios(GherkinScenario[] scenarios) {
        this.scenarios = scenarios;
    }
}
