package com.staszkox.test.navigator.files.checkers;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestFileSuffix;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassTypeCheckerTest
{
    private PsiClass clazz = mock(PsiClass.class);

    @Test
    public void testTestClass()
    {
        String className = "Class" + TestFileSuffix.TEST_SUFFIX;
        when(clazz.getQualifiedName()).thenReturn(className);

        assertTrue(ClassTypeChecker.of(clazz).isTestClass());
        assertFalse(ClassTypeChecker.of(clazz).isSourceClass());
    }

    @Test
    public void testSourceClass()
    {
        String className = "Class";
        when(clazz.getQualifiedName()).thenReturn(className);

        assertFalse(ClassTypeChecker.of(clazz).isTestClass());
        assertTrue(ClassTypeChecker.of(clazz).isSourceClass());
    }
}