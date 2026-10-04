package org.apache.commons.text.lookup;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class BiFunctionStringLookup<P, R> implements BiStringLookup<P> {
    private final BiFunction<String, P, R> biFunction;

    private BiFunctionStringLookup(BiFunction<String, P, R> biFunction) {
        this.biFunction = biFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$on$0(Map map, String str, Object obj) {
        return map.get(str);
    }

    /* JADX INFO: renamed from: on */
    public static <U, T> BiFunctionStringLookup<U, T> m14951on(BiFunction<String, U, T> biFunction) {
        return new BiFunctionStringLookup<>(biFunction);
    }

    @Override // org.apache.commons.text.lookup.StringLookup
    public String lookup(String str) {
        return lookup(str, null);
    }

    public String toString() {
        return super.toString() + " [function=" + this.biFunction + "]";
    }

    /* JADX INFO: renamed from: on */
    public static <U, T> BiFunctionStringLookup<U, T> m14950on(final Map<String, T> map) {
        return m14951on(new BiFunction() { // from class: org.apache.commons.text.lookup.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return BiFunctionStringLookup.lambda$on$0(map, (String) obj, obj2);
            }
        });
    }

    @Override // org.apache.commons.text.lookup.BiStringLookup
    public String lookup(String str, P p) {
        BiFunction<String, P, R> biFunction = this.biFunction;
        if (biFunction == null) {
            return null;
        }
        try {
            return Objects.toString(biFunction.apply(str, p), null);
        } catch (IllegalArgumentException | NullPointerException | SecurityException unused) {
            return null;
        }
    }
}
