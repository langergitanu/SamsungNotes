package com.samsung.android.sdk.smp.common.util;

import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.util.Pair;
import com.samsung.android.sdk.smp.SmpException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ApiValidationCheckUtil {
    private static void checkNullParameter(String str, Object obj) throws SmpException.NullArgumentException {
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj)) {
                throw new SmpException.NullArgumentException(AbstractC0541b.m756B(str, " is null"));
            }
        } else if (obj == null) {
            throw new SmpException.NullArgumentException(AbstractC0541b.m756B(str, " is null"));
        }
    }

    public static void checkSmpApiValidity() throws SmpException.IllegalStateException {
        if (!DeviceInfoUtil.isSupportCountryCode()) {
            throw new SmpException.IllegalStateException("The current country code is not supported on this sdk. should check the sdk that you are importing.");
        }
    }

    @SafeVarargs
    public static void checkSmpApiValidity(Pair<String, Object>... pairArr) throws SmpException.IllegalStateException, SmpException.NullArgumentException {
        checkSmpApiValidity();
        for (Pair<String, Object> pair : pairArr) {
            checkNullParameter(pair.first, pair.second);
        }
    }
}
