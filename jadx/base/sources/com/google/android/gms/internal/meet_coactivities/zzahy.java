package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahy {
    private final ArrayList zza = new ArrayList();

    public final String toString() {
        return this.zza.toString();
    }

    public final zzahy zza(@Nullable Object obj) {
        this.zza.add(String.valueOf(obj));
        return this;
    }

    public final zzahy zzb(String str, @Nullable Object obj) {
        this.zza.add(AbstractC0541b.m757C(str, MarketingConstants.REFERRER_DELIMITER_U003D, String.valueOf(obj)));
        return this;
    }
}
