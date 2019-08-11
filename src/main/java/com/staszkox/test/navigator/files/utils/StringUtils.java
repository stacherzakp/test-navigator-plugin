package com.staszkox.test.navigator.files.utils;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StringUtils {

    public static String listToString(List<String> strings) {
        List<String> stringsOrDefault = Optional.ofNullable(strings).orElseGet(Lists::newArrayList);
        return String.join(",", stringsOrDefault);
    }

    public static List<String> stringToList(String string, String delimiter) {
        if (org.apache.commons.lang3.StringUtils.isNotEmpty(string)) {
            return Arrays.asList(string.split(delimiter));
        }

        return Lists.newArrayList();
    }
}
