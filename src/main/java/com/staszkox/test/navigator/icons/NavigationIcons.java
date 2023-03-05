package com.staszkox.test.navigator.icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

interface NavigationIcons {
    Icon testClassAvailable = IconLoader.getIcon("/icons/greenT.svg", NavigationIcons.class);
    Icon testClassNotAvailable = IconLoader.getIcon("/icons/redT.svg", NavigationIcons.class);
    Icon noTestsInTestClass = IconLoader.getIcon("/icons/yellowT.svg", NavigationIcons.class);
    Icon sourceClassAvailable = IconLoader.getIcon("/icons/greenS.svg", NavigationIcons.class);
    Icon sourceClassNotAvailable = IconLoader.getIcon("/icons/redS.svg", NavigationIcons.class);
}
