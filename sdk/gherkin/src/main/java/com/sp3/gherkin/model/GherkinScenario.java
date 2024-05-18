package com.sp3.gherkin.model;

public class GherkinScenario {
    private String featureFileUri;
    private String name;
    private String type;

    public GherkinScenario() {}

    public String getFeatureFileUri() {
        return featureFileUri;
    }

    public void setFeatureFileUri(String featureFileUri) {
        this.featureFileUri = featureFileUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
