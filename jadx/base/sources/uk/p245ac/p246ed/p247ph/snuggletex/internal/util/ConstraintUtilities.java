package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ConstraintUtilities {
    public static void ensureNotNull(Object obj) {
        ensureNotNull(obj, "Object");
    }

    public static void ensureNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(AbstractC0541b.m756B(str, " must not be null"));
        }
    }
}
