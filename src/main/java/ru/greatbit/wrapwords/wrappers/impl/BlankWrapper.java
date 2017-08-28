package ru.greatbit.wrapwords.wrappers.impl;

import ru.greatbit.wrapwords.wrappers.BaseWrapper;

/**
 * Created by azee on 28.08.17.
 *
 * Used to wrap non-typed entities
 *
 */
public class BlankWrapper extends BaseWrapper {

    @Override
    public String convert(String source) {
        return source;
    }
}
