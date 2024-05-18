package com.sp3.gherkin.model;

public class GherkinFeatureFile {
    private String uri;
    private GherkinFeature feature;

    public GherkinFeatureFile() {}

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public GherkinFeature getFeature() {
        return feature;
    }

    public void setFeature(GherkinFeature feature) {
        this.feature = feature;
    }
}
