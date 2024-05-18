package com.sp3;

import com.sp3.gherkin.model.GherkinFeatureFile;
import com.sp3.gherkin.parser.FeatureFileParser;
import com.sp3.gherkin.parser.IFeatureFileParser;

public class Main {

    public static void main(String[] args) {
        String featureFileName = "test.feature";
        String featureFilePath = "src/main/resources/" + featureFileName;

        IFeatureFileParser featureFileParser = new FeatureFileParser();

        GherkinFeatureFile featureFile = featureFileParser.parse(featureFilePath);


        System.out.println(featureFile.getFeature().getScenarios()[1].getName());
    }
}