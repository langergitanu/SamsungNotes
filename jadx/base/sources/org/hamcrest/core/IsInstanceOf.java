package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IsInstanceOf extends DiagnosingMatcher<Object> {
    private final Class<?> expectedClass;
    private final Class<?> matchableClass;

    public IsInstanceOf(Class<?> cls) {
        this.expectedClass = cls;
        this.matchableClass = matchableClass(cls);
    }

    @Factory
    public static <T> Matcher<T> any(Class<T> cls) {
        return new IsInstanceOf(cls);
    }

    @Factory
    public static <T> Matcher<T> instanceOf(Class<?> cls) {
        return new IsInstanceOf(cls);
    }

    private static Class<?> matchableClass(Class<?> cls) {
        return Boolean.TYPE.equals(cls) ? Boolean.class : Byte.TYPE.equals(cls) ? Byte.class : Character.TYPE.equals(cls) ? Character.class : Double.TYPE.equals(cls) ? Double.class : Float.TYPE.equals(cls) ? Float.class : Integer.TYPE.equals(cls) ? Integer.class : Long.TYPE.equals(cls) ? Long.class : Short.TYPE.equals(cls) ? Short.class : cls;
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an instance of ").appendText(this.expectedClass.getName());
    }

    @Override // org.hamcrest.DiagnosingMatcher
    public boolean matches(Object obj, Description description) {
        if (obj == null) {
            description.appendText("null");
            return false;
        }
        if (this.matchableClass.isInstance(obj)) {
            return true;
        }
        description.appendValue(obj).appendText(" is a ".concat(obj.getClass().getName()));
        return false;
    }
}
