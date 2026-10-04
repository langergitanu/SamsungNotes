package com.samsung.android.sdk.smp;

import android.content.Context;
import android.content.Intent;
import androidx.core.util.Pair;
import com.samsung.android.sdk.smp.SmpException;
import com.samsung.android.sdk.smp.common.util.ApiValidationCheckUtil;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpAppReferrer {
    public static void clear(Context context, String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("key", str));
        SmpInterfaceImpl.clearAppReferrer(context, str);
    }

    public static void clearAll(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        SmpInterfaceImpl.clearAllAppReferrer(context);
    }

    public static String get(Context context, String str) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("key", str));
        return SmpInterfaceImpl.getAppReferrer(context, str);
    }

    public static Set<String> keySet(Context context) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context));
        return SmpInterfaceImpl.getAppReferrerKeySet(context);
    }

    public static Map<String, String> parseReferrer(Intent intent) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("landingIntent", intent));
        return SmpInterfaceImpl.getParsedReferrerMap(intent);
    }

    public static void set(Context context, String str, String str2) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("key", str));
        if (str2 == null) {
            str2 = "";
        }
        SmpInterfaceImpl.setAppReferrer(context, str, str2);
    }

    public static void set(Context context, Map<String, String> map) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        ApiValidationCheckUtil.checkSmpApiValidity(new Pair("context", context), new Pair("data", map));
        SmpInterfaceImpl.setAppReferrer(context, map);
    }
}
