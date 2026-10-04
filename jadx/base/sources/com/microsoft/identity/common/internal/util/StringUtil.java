package com.microsoft.identity.common.internal.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final class StringUtil {
    private static final String TAG = "StringUtil";

    private StringUtil() {
    }

    public static boolean containsSubString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(str2);
    }

    public static String convertSetToString(Set<String> set, String str) {
        if (set == null || set.isEmpty() || str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(str);
            sb.append(it.next());
        }
        return sb.toString();
    }

    @SuppressFBWarnings(justification = "This is actually a reference comparison", value = {"ES_COMPARING_PARAMETER_STRING_WITH_EQ"})
    public static boolean equalsIgnoreCase(@Nullable String str, @Nullable String str2) {
        if (str != str2) {
            return str != null && str.equalsIgnoreCase(str2);
        }
        return true;
    }

    public static Map.Entry<String, String> getTenantInfo(@NonNull String str) {
        String str2;
        String str3;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getTenantInfo", new StringBuilder());
        String[] strArrSplit = str.split(RemoteConstant.VERSION_DIVIDE);
        if (2 != strArrSplit.length || StringExtensions.isNullOrBlank(strArrSplit[0]) || StringExtensions.isNullOrBlank(strArrSplit[1])) {
            Logger.warn(strM1170p, "We had a home account id that could not be split correctly, We expected it to split into 2 parts but instead we had " + strArrSplit.length + " when splitting the string on dot ('.')");
            Logger.warnPII(strM1170p, "We had a home account id that could not be split correctly, Its value was: '" + str + "', and we expected it to split into 2 parts but instead we had " + strArrSplit.length + " when splitting the string on dot ('.')");
            str2 = null;
            str3 = null;
        } else {
            str2 = strArrSplit[0];
            str3 = strArrSplit[1];
        }
        return new AbstractMap.SimpleEntry(str2, str3);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String join(char c, @NonNull Iterable<String> iterable) {
        StringBuilder sb = new StringBuilder();
        char c2 = 0;
        for (String str : iterable) {
            if (c2 != 0) {
                sb.append(c2);
            }
            sb.append(str);
            c2 = c;
        }
        return sb.toString();
    }
}
