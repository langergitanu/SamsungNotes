package com.microsoft.identity.common.java.util.ported;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class ObjectUtils {
    private static String TAG = "ObjectUtils";

    private ObjectUtils() {
    }

    public static boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void throwIfArgumentIsNull(@Nullable Object obj, @NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("argumentName is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("methodName is marked non-null but is null");
        }
        if (obj != null) {
            return;
        }
        Logger.error(AbstractC0622a.m1170p(TAG, str2, new StringBuilder()), str.concat(" is null."), null);
        throw new NullPointerException(str.concat(" is null."));
    }
}
