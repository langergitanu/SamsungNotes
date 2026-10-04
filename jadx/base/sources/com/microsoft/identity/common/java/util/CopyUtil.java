package com.microsoft.identity.common.java.util;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Arrays;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CopyUtil {
    @Nullable
    public static Date copyIfNotNull(@Nullable Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

    @Nullable
    public static char[] copyIfNotNull(@Nullable char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return Arrays.copyOf(cArr, cArr.length);
    }

    @Nullable
    public static byte[] copyIfNotNull(@Nullable byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
