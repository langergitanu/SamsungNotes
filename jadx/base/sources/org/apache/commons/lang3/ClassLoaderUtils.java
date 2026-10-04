package org.apache.commons.lang3;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ClassLoaderUtils {
    private static final URL[] EMPTY_URL_ARRAY = new URL[0];

    @Deprecated
    public ClassLoaderUtils() {
    }

    public static URL[] getSystemURLs() {
        return getURLs(ClassLoader.getSystemClassLoader());
    }

    public static URL[] getThreadURLs() {
        return getURLs(Thread.currentThread().getContextClassLoader());
    }

    private static URL[] getURLs(ClassLoader classLoader) {
        return classLoader instanceof URLClassLoader ? ((URLClassLoader) classLoader).getURLs() : EMPTY_URL_ARRAY;
    }

    public static String toString(ClassLoader classLoader) {
        return classLoader instanceof URLClassLoader ? toString((URLClassLoader) classLoader) : Objects.toString(classLoader);
    }

    public static String toString(URLClassLoader uRLClassLoader) {
        if (uRLClassLoader == null) {
            return "null";
        }
        return uRLClassLoader + Arrays.toString(uRLClassLoader.getURLs());
    }
}
