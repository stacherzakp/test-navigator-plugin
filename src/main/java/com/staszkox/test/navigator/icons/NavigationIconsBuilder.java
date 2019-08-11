package com.staszkox.test.navigator.icons;

import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.psi.PsiElement;

import javax.swing.*;

public enum NavigationIconsBuilder {
    TEST_CLASS_AVAILABLE(NavigationIcons.testClassAvailable, "Navigate to test class"),
    TEST_CLASS_NOT_AVAILABLE(NavigationIcons.testClassNotAvailable, "Missing test class or located in another package"),
    TEST_CLASS_HAS_NO_TESTS(NavigationIcons.noTestsInTestClass, "Test class has no tests or tests not recognized"),
    SOURCE_CLASS_AVAILABLE(NavigationIcons.sourceClassAvailable, "Navigate to source class"),
    SOURCE_CLASS_NOT_AVAILABLE(NavigationIcons.sourceClassNotAvailable, "Missing source class or located in another package");

    private final Icon icon;
    private final String tooltipText;

    NavigationIconsBuilder(Icon icon, String tooltipText) {
        this.icon = icon;
        this.tooltipText = tooltipText;
    }

    public NavigationGutterIconBuilder<PsiElement> forTarget(PsiElement target) {
        return NavigationGutterIconBuilder.create(icon)
                .setTooltipText(tooltipText)
                .setTargets(target);
    }
}
