package org.apache.commons.collections4.functors;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class FunctorUtils {
    private FunctorUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R extends Function<I, O>, P extends Function<? super I, ? extends O>, I, O> R coerce(P p) {
        return p;
    }

    public static <T extends Consumer<?>> T[] copy(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Consumer[]) tArr.clone());
    }

    public static <T> Predicate<? super T>[] validate(Collection<? extends java.util.function.Predicate<? super T>> collection) {
        Objects.requireNonNull(collection, "predicates");
        Predicate<? super T>[] predicateArr = new Predicate[collection.size()];
        Iterator<? extends java.util.function.Predicate<? super T>> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            Predicate<? super T> predicate = (Predicate) it.next();
            predicateArr[i] = predicate;
            if (predicate == null) {
                throw new NullPointerException(AbstractC0541b.m767i(i, "predicates[", "]"));
            }
            i++;
        }
        return predicateArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <R extends java.util.function.Predicate<T>, P extends java.util.function.Predicate<? super T>, T> R coerce(P p) {
        return p;
    }

    public static <T extends java.util.function.Predicate<?>> T[] copy(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((java.util.function.Predicate[]) tArr.clone());
    }

    public static <T extends Function<?, ?>> T[] copy(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Function[]) tArr.clone());
    }

    public static void validate(Consumer<?>... consumerArr) {
        Objects.requireNonNull(consumerArr, "closures");
        for (int i = 0; i < consumerArr.length; i++) {
            if (consumerArr[i] == null) {
                throw new NullPointerException(AbstractC0541b.m767i(i, "closures[", "]"));
            }
        }
    }

    public static void validate(Function<?, ?>... functionArr) {
        Objects.requireNonNull(functionArr, "functions");
        for (int i = 0; i < functionArr.length; i++) {
            if (functionArr[i] == null) {
                throw new NullPointerException(AbstractC0541b.m767i(i, "functions[", "]"));
            }
        }
    }

    public static void validate(java.util.function.Predicate<?>... predicateArr) {
        Objects.requireNonNull(predicateArr, "predicates");
        for (int i = 0; i < predicateArr.length; i++) {
            if (predicateArr[i] == null) {
                throw new NullPointerException(AbstractC0541b.m767i(i, "predicates[", "]"));
            }
        }
    }
}
