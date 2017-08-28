package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.BaseWrapper;

import static java.lang.String.format;

/**
 * Created by azee on 28.08.17.
 */
public class LinkWrapper extends BaseWrapper{

    @Override
    public String convert(String source) {
        return format("<a href='%s'>%s</a>", source, source);
    }
}
