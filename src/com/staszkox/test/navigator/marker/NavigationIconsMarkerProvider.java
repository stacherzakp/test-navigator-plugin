package com.staszkox.test.navigator.marker;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiIdentifier;
import com.staszkox.test.navigator.files.checkers.ClassContentChecker;
import com.staszkox.test.navigator.files.checkers.ClassTypeChecker;
import com.staszkox.test.navigator.files.finders.SourceFileFinder;
import com.staszkox.test.navigator.files.finders.TestFileFinder;
import com.staszkox.test.navigator.icons.NavigationIconsBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;

public class NavigationIconsMarkerProvider extends RelatedItemLineMarkerProvider
{
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result)
    {
        if (element instanceof PsiIdentifier && element.getParent() instanceof PsiClass)
        {
            PsiClass currentClass = (PsiClass) element.getParent();
            NavigationGutterIconBuilder<PsiElement> navigationIconBuilder = null;

            if (ClassTypeChecker.isSourceClass(currentClass))
            {
                Optional<PsiClass> testClass = TestFileFinder.forClass(currentClass).findFile();
                navigationIconBuilder = findIconForSourceClass(currentClass, testClass);
            }
            else if (ClassTypeChecker.isTestClass(currentClass))
            {
                Optional<PsiClass> sourceClass = SourceFileFinder.forClass(currentClass).findFile();
                navigationIconBuilder = findIconForTestClass(currentClass, sourceClass);
            }

            if (navigationIconBuilder != null)
            {
                result.add(navigationIconBuilder.createLineMarkerInfo(element));
            }
        }
    }

    private NavigationGutterIconBuilder<PsiElement> findIconForSourceClass(PsiClass sourceClass, Optional<PsiClass> testClass)
    {
        NavigationGutterIconBuilder<PsiElement> navigationIconBuilder;

        if (testClass.isPresent())
        {
            if (ClassContentChecker.hasTestCases(testClass.get()))
            {
                navigationIconBuilder = NavigationIconsBuilder.TEST_CLASS_AVAILABLE.forTarget(testClass.get());
            }
            else
            {
                navigationIconBuilder = NavigationIconsBuilder.TEST_CLASS_HAS_NO_TESTS.forTarget(testClass.get());
            }
        }
        else
        {
            navigationIconBuilder = NavigationIconsBuilder.TEST_CLASS_NOT_AVAILABLE.forTarget(sourceClass);
        }

        return navigationIconBuilder;
    }

    private NavigationGutterIconBuilder<PsiElement> findIconForTestClass(PsiClass testClass, Optional<PsiClass> sourceClass)
    {
        NavigationGutterIconBuilder<PsiElement> navigationIconBuilder;

        if (sourceClass.isPresent())
        {
            navigationIconBuilder = NavigationIconsBuilder.SOURCE_CLASS_AVAILABLE.forTarget(sourceClass.get());
        }
        else
        {
            navigationIconBuilder = NavigationIconsBuilder.SOURCE_CLASS_NOT_AVAILABLE.forTarget(testClass);
        }

        return navigationIconBuilder;
    }
}
