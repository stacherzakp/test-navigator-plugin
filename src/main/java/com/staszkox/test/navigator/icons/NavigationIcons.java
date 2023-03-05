package com.staszkox.test.navigator.icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

interface NavigationIcons {
    Icon testClassAvailable = IconLoader.getIcon("/icons/greenTest.png", NavigationIcons.class);
    Icon testClassNotAvailable = IconLoader.getIcon("/icons/redTest.png", NavigationIcons.class);
    Icon noTestsInTestClass = IconLoader.getIcon("/icons/yellowTest.png", NavigationIcons.class);
    Icon sourceClassAvailable = IconLoader.getIcon("/icons/greenSource.png", NavigationIcons.class);
    Icon sourceClassNotAvailable = IconLoader.getIcon("/icons/redSource.png", NavigationIcons.class);
}
