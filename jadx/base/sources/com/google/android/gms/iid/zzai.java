package com.google.android.gms.iid;

import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zzai {

    @GuardedBy("SdkFlagFactory.class")
    private static zzai zzdd;

    public static synchronized zzai zzy() {
        try {
            if (zzdd == null) {
                zzdd = new zzac();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzdd;
    }

    public abstract zzaj<Boolean> zzd(String str, boolean z);
}
