package com.sp3.gherkin.parser;

import com.sp3.gherkin.model.GherkinFeatureFile;

public interface IFeatureFileParser {
    GherkinFeatureFile parse(String featureFilePath);
}
