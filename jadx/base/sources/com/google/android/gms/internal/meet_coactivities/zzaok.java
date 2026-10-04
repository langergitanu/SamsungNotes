package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaok {
    private zzaok() {
    }

    public static Set zza(Map map) {
        Set setZzc = zzc(map, "nonFatalStatusCodes");
        if (setZzc == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(zzaay.class));
        }
        Verify.verify(!setZzc.contains(zzaay.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setZzc;
    }

    public static Set zzb(Map map) {
        Set setZzc = zzc(map, "retryableStatusCodes");
        Verify.verify(setZzc != null, "%s is required in retry policy", "retryableStatusCodes");
        Verify.verify(true ^ setZzc.contains(zzaay.OK), "%s must not contain OK", "retryableStatusCodes");
        return setZzc;
    }

    private static Set zzc(Map map, String str) {
        zzaay zzaayVarZza;
        List listZzg = zzaiu.zzg(map, str);
        if (listZzg == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(zzaay.class);
        for (Object obj : listZzg) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                int iIntValue = d.intValue();
                Verify.verify(((double) iIntValue) == d.doubleValue(), "Status code %s is not integral", obj);
                zzaayVarZza = zzabd.zzb(iIntValue).zza();
                Verify.verify(zzaayVarZza.zza() == d.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new VerifyException(AbstractC0541b.m774p("Can not convert status code ", String.valueOf(obj), " to Status.Code, because its type is ", String.valueOf(obj.getClass())));
                }
                try {
                    zzaayVarZza = (zzaay) Enum.valueOf(zzaay.class, (String) obj);
                } catch (IllegalArgumentException e) {
                    throw new VerifyException(AbstractC0541b.m773o("Status code ", String.valueOf(obj), " is not valid"), e);
                }
            }
            enumSetNoneOf.add(zzaayVarZza);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }
}
