package com.staszkox.test.navigator.configuration;

import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class TestNavigatorConfigurable implements SearchableConfigurable {
    private TestNavigatorConfigPanel configPanel;

    @NotNull
    @Override
    public String getId() {
        return "preference.TestNavigator";
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Test Navigator";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        String suffixes = String.join(", ", getConfig().getTestClassSuffixes());
        configPanel = new TestNavigatorConfigPanel(suffixes);
        return configPanel.getPanel();
    }

    @Override
    public boolean isModified() {
        String suffixesText = configPanel.getSuffixes();
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(suffixesText.trim())) {
            String currentConfig = String.join(", ", getConfig().getTestClassSuffixes());
            return !suffixesText.equals(currentConfig);
        }
        return false;
    }

    @Override
    public void apply() {
        String suffixesText = configPanel.getSuffixes();

        if (org.apache.commons.lang3.StringUtils.isNotEmpty(suffixesText.trim())) {
            List<String> suffixes = Arrays.stream(suffixesText.split(","))
                    .map(String::trim)
                    .filter(suffix -> !suffix.isEmpty())
                    .toList();
            getConfig().setTestClassSuffixes(suffixes);
        }
    }

    @Override
    public void reset() {
        String suffixesText = String.join(", ", getConfig().getTestClassSuffixes());
        configPanel.setSuffixes(suffixesText);
    }

    @Override
    public void disposeUIResources() {
        configPanel = null;
    }

    private TestNavigatorConfig getConfig() {
        return TestNavigatorConfig.getInstance();
    }
}
