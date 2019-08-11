package com.staszkox.test.navigator.configuration;

import com.intellij.openapi.options.SearchableConfigurable;
import com.staszkox.test.navigator.files.utils.StringUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TestNavigatorConfigurable implements SearchableConfigurable {
    private TestNavigatorConfig config;
    private TestNavigatorConfigPanel configPanel;

    public TestNavigatorConfigurable(TestNavigatorConfig config) {
        this.config = config;
    }

    @NotNull
    @Override
    public String getId() {
        return "preference.TestNavigator";
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Test Navigator plugin";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        String suffixes = String.join(",", config.getTestClassSuffixes());
        configPanel = new TestNavigatorConfigPanel(suffixes);
        return configPanel.getPanel();
    }

    @Override
    public boolean isModified() {
        String alreadyConfigured = StringUtils.listToString(config.getTestClassSuffixes());
        return !configPanel.getSuffixes().equals(alreadyConfigured);
    }

    @Override
    public void apply() {
        String suffixes = configPanel.getSuffixes().replaceAll("\\s", "");
        config.setTestClassSuffixes(StringUtils.stringToList(suffixes, ","));
    }

    @Override
    public void reset() {
        configPanel.setSuffixes(StringUtils.listToString(config.getTestClassSuffixes()));
    }

    @Override
    public void disposeUIResources() {
        configPanel = null;
    }
}
