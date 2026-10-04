package org.apache.commons.lang3.function;

import java.util.function.Predicate;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Predicates {
    private static final Predicate<?> TRUE = new C0233e(19);
    private static final Predicate<?> FALSE = new C0233e(20);

    private Predicates() {
    }

    public static <T> Predicate<T> falsePredicate() {
        return (Predicate<T>) FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$1(Object obj) {
        return false;
    }

    public static <T> Predicate<T> truePredicate() {
        return (Predicate<T>) TRUE;
    }
}
