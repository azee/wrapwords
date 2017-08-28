package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.BaseWrapper;

import static java.lang.String.format;

/**
 * Created by azee on 24.08.17.
 */
public class EntityWrapper extends BaseWrapper {

    @Override
    public String convert(String source) {
        return format("<strong>%s</strong>", source);
    }
}
