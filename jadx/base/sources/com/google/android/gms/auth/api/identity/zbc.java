package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbc implements Api.ApiOptions.Optional {
    private final String zba;

    public zbc(String str) {
        this.zba = str;
    }

    public final boolean equals(@Nullable Object obj) {
        return obj instanceof zbc;
    }

    public final int hashCode() {
        return Objects.hashCode(zbc.class);
    }

    public final Bundle zba() {
        Bundle bundle = new Bundle();
        bundle.putString("session_id", this.zba);
        return bundle;
    }

    public final String zbb() {
        return this.zba;
    }
}
