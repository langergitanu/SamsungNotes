package com.google.android.meet.addons;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzq extends CoDoingState {
    private final byte[] zza;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoDoingState)) {
            return false;
        }
        CoDoingState coDoingState = (CoDoingState) obj;
        return Arrays.equals(this.zza, coDoingState instanceof zzq ? ((zzq) coDoingState).zza : coDoingState.state());
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza) ^ 1000003;
    }

    @Override // com.google.android.meet.addons.CoDoingState
    public final byte[] state() {
        return this.zza;
    }

    public final String toString() {
        return AbstractC0541b.m773o("CoDoingState{state=", Arrays.toString(this.zza), "}");
    }
}
