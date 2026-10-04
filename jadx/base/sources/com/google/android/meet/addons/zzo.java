package com.google.android.meet.addons;

import com.google.android.meet.addons.CoDoingState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzo extends CoDoingState.Builder {
    private byte[] zza;

    @Override // com.google.android.meet.addons.CoDoingState.Builder
    public final CoDoingState build() {
        byte[] bArr = this.zza;
        if (bArr != null) {
            return new zzq(bArr, null);
        }
        throw new IllegalStateException("Missing required properties: state");
    }

    @Override // com.google.android.meet.addons.CoDoingState.Builder
    public final CoDoingState.Builder setState(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Null state");
        }
        this.zza = bArr;
        return this;
    }
}
