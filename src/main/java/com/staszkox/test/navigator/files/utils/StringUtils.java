package com.staszkox.test.navigator.files.utils;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringUtils
{
    public static String listToString(List<String> strings)
    {
        return Optional.ofNullable(strings).orElseGet(Lists::newArrayList).stream().collect(Collectors.joining(","));
    }

    public static List<String> stringToList(String string, String delimiter)
    {
        if (string != null && !"".equals(string))
        {
            return Arrays.asList(string.split(delimiter));
        }

        return Lists.newArrayList();
    }
}
