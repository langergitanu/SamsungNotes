package org.apache.commons.text.lookup;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class FunctionStringLookup<V> extends AbstractStringLookup {
    private final Function<String, V> function;

    private FunctionStringLookup(Function<String, V> function) {
        this.function = function;
    }

    /* JADX INFO: renamed from: on */
    public static <R> FunctionStringLookup<R> m14953on(Function<String, R> function) {
        return new FunctionStringLookup<>(function);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        Function<String, V> function = this.function;
        if (function == null) {
            return null;
        }
        try {
            return Objects.toString(function.apply(str), null);
        } catch (IllegalArgumentException | NullPointerException | SecurityException unused) {
            return null;
        }
    }

    public String toString() {
        return super.toString() + " [function=" + this.function + "]";
    }

    /* JADX INFO: renamed from: on */
    public static <V> FunctionStringLookup<V> m14952on(Map<String, V> map) {
        final Map map2 = StringLookupFactory.toMap(map);
        Objects.requireNonNull(map2);
        return m14953on(new Function() { // from class: org.apache.commons.text.lookup.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return map2.get((String) obj);
            }
        });
    }
}
