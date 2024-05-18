package com.sp3.gherkin.parser;

import com.sp3.gherkin.model.GherkinFeatureFile;
import com.sp3.gherkin.model.GherkinFeature;
import com.sp3.gherkin.model.GherkinScenario;
import io.cucumber.gherkin.GherkinParser;
import io.cucumber.messages.types.Feature;
import io.cucumber.messages.types.GherkinDocument;
import io.cucumber.messages.types.Scenario;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FeatureFileParser implements IFeatureFileParser {

    private Object getFileContent(String path) {
        String fileContent;
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            fileContent = lines.collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }

    @Override
    public GherkinFeatureFile parse(String featureFilePath) {
        GherkinFeatureFile featureFile = new GherkinFeatureFile();
        String featureFileContent = (String) getFileContent(featureFilePath);

        GherkinParser gherkinParser = GherkinParser
                .builder()
                .includeSource(true)
                .includePickles(true)
                .includeGherkinDocument(true)
                .build();

        gherkinParser
                .parse(featureFilePath, featureFileContent.getBytes(StandardCharsets.UTF_8))
                .forEach(envelope -> {
                    if (envelope.getGherkinDocument().isPresent()) {
                        parseFeatureFile(envelope.getGherkinDocument().get(), featureFile);
                    }
                });

        return featureFile;
    }

    private void parseFeatureFile(GherkinDocument gherkinDocument, GherkinFeatureFile featureFile) {
        if (gherkinDocument.getUri().isPresent()) {
            featureFile.setUri(gherkinDocument.getUri().get());
        }

        if (gherkinDocument.getFeature().isPresent()) {
            parseFeature(gherkinDocument.getFeature().get(), featureFile);
        }
    }

    private void parseFeature(Feature feature, GherkinFeatureFile featureFile) {
        GherkinFeature gherkinFeature = new GherkinFeature();

        if (feature.getName() != null) {
            gherkinFeature.setName(feature.getName());
        }

        List<GherkinScenario> scenarios = new ArrayList<>();
        if (!feature.getChildren().isEmpty()) {

            feature.getChildren().forEach(child -> {
                if (child.getScenario().isPresent()) {
                    scenarios.add(parseScenario(child.getScenario().get(), featureFile.getUri()));
                }
            });
        }

        if (!scenarios.isEmpty()) {
            GherkinScenario[] gherkinFeatureScenarios = scenarios.toArray(new GherkinScenario[0]);
            gherkinFeature.setScenarios(gherkinFeatureScenarios);
        }

        featureFile.setFeature(gherkinFeature);
    }

    private GherkinScenario parseScenario(Scenario scenario, String featureFileUri) {
        GherkinScenario gherkinScenario = new GherkinScenario();
        gherkinScenario.setFeatureFileUri(featureFileUri);

        if (scenario.getName() != null) {
            gherkinScenario.setName(scenario.getName());
        }

        if (scenario.getKeyword() != null) {
            gherkinScenario.setType(scenario.getKeyword());
        }

        return gherkinScenario;
    }
}
