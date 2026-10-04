package cz.msebera.android.httpclient.util;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Asserts {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void notBlank(CharSequence charSequence, String str) {
        if (TextUtils.isBlank(charSequence)) {
            throw new IllegalStateException(AbstractC0541b.m756B(str, " is blank"));
        }
    }

    public static void notEmpty(CharSequence charSequence, String str) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalStateException(AbstractC0541b.m756B(str, " is empty"));
        }
    }

    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalStateException(AbstractC0541b.m756B(str, " is null"));
        }
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static void check(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.format(str, obj));
        }
    }
}
