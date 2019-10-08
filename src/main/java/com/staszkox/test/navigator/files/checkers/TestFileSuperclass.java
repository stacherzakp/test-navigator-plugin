package com.staszkox.test.navigator.files.checkers;

public enum TestFileSuperclass {

    SPOCK_SPECIFICATION("spock.lang.Specification"),
    GROOVY_TEST_CASE("groovy.util.GroovyTestCase");

    private final String superclass;

    TestFileSuperclass(String superclass) {
        this.superclass = superclass;
    }

    public String getSuperclass() {
        return superclass;
    }
}
