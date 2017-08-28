package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.Wrapper;

import static java.lang.String.format;

/**
 * Created by azee on 24.08.17.
 */
public class EntityWrapper implements Wrapper {

    @Override
    public String wrap(String source) {
        return format("<strong>%s</strong>", source);
    }
}
