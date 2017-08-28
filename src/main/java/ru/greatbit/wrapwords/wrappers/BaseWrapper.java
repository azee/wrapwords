package ru.greatbit.wrapwords.wrappers;

/**
 * Created by azee on 28.08.17.
 */
public abstract class BaseWrapper implements Wrapper {

    @Override
    public final String wrap(String source) {
        if (source == null || "".equals(source)){
            return "";
        }
        return convert(source);
    }

    protected abstract String convert(String source);
}
