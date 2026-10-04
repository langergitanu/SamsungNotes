package org.apache.commons.collections4;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public interface Predicate<T> extends java.util.function.Predicate<T> {
    boolean evaluate(T t);

    @Override // java.util.function.Predicate
    default boolean test(T t) {
        return evaluate(t);
    }
}
