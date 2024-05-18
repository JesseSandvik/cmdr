package com.sp3.gherkin.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureFireParserTest {
    private final String validFeatureFilePath = "src/test/resources/test.feature";
    private final FeatureFileParser featureFileParser = new FeatureFileParser();

    @Test
    void FEATURE_FILE_PARSER__parses_feature_file_uri() {
        String expected = validFeatureFilePath;
        String actual = featureFileParser.parse(validFeatureFilePath).getUri();
        assertEquals(expected, actual);
    }

    @Test
    void FEATURE_FILE_PARSER__parses_feature_name() {
        String expected = "Guess the word";
        String actual = featureFileParser.parse(validFeatureFilePath).getFeature().getName();
        assertEquals(expected, actual);
    }

    @Test
    void FEATURE_FILE_PARSER__parses_scenario_name() {
        String expected = "Maker starts a game";
        String actual = featureFileParser.parse(validFeatureFilePath).getFeature().getScenarios()[0].getName();
        assertEquals(expected, actual);
    }

    @Test
    void FEATURE_FILE_PARSER__parses_scenario_type() {
        String expected = "Scenario";
        String actual = featureFileParser.parse(validFeatureFilePath).getFeature().getScenarios()[0].getType();
        assertEquals(expected, actual);
    }
}
