package com.staszkox.test.navigator.icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

interface NavigationIcons
{
    Icon testClassAvailable = IconLoader.getIcon("/icons/greenTest.png");
    Icon testClassNotAvailable = IconLoader.getIcon("/icons/redTest.png");
    Icon noTestsInTestClass = IconLoader.getIcon("/icons/yellowTest.png");
    Icon sourceClassAvailable = IconLoader.getIcon("/icons/greenSource.png");
    Icon sourceClassNotAvailable = IconLoader.getIcon("/icons/redSource.png");
}
