package com.google.android.meet.addons;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.meet.addons.RecordingInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaf extends RecordingInfo {
    private final RecordingInfo.RecordingStatus zza;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RecordingInfo) {
            return this.zza.equals(((RecordingInfo) obj).status());
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    @Override // com.google.android.meet.addons.RecordingInfo
    public final RecordingInfo.RecordingStatus status() {
        return this.zza;
    }

    public final String toString() {
        return AbstractC0541b.m773o("RecordingInfo{status=", this.zza.toString(), "}");
    }
}
