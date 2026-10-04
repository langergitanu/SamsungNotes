package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyn {
    private List zza;
    private final zzvy zzb = zzvy.zza;
    private Object[][] zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

    public final zzyn zza(zzyo zzyoVar, Object obj) {
        Preconditions.checkNotNull(zzyoVar, "key");
        Preconditions.checkNotNull(obj, "value");
        int length = 0;
        while (true) {
            Object[][] objArr = this.zzc;
            if (length >= objArr.length) {
                length = -1;
                break;
            }
            if (zzyoVar.equals(objArr[length][0])) {
                break;
            }
            length++;
        }
        if (length == -1) {
            Object[][] objArr2 = this.zzc;
            int length2 = objArr2.length;
            Object[][] objArr3 = (Object[][]) Array.newInstance((Class<?>) Object.class, length2 + 1, 2);
            System.arraycopy(objArr2, 0, objArr3, 0, length2);
            this.zzc = objArr3;
            length = objArr3.length - 1;
        }
        this.zzc[length] = new Object[]{zzyoVar, obj};
        return this;
    }

    public final zzyn zzb(List list) {
        Preconditions.checkArgument(!list.isEmpty(), "addrs is empty");
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        return this;
    }

    public final zzyq zzc() {
        return new zzyq(this.zza, this.zzb, this.zzc, null);
    }
}
