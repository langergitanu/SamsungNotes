package com.google.android.meet.addons;

import android.net.Uri;
import com.google.android.meet.addons.CollaborationStartingState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzx extends CollaborationStartingState.Builder {
    private String zza;
    private Uri zzb;
    private Uri zzc;

    @Override // com.google.android.meet.addons.CollaborationStartingState.Builder
    public final CollaborationStartingState autoBuild() {
        return new zzz(this.zza, this.zzb, this.zzc, null);
    }

    @Override // com.google.android.meet.addons.CollaborationStartingState.Builder
    public final CollaborationStartingState.Builder setAdditionalData(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.meet.addons.CollaborationStartingState.Builder
    public final CollaborationStartingState.Builder setMainStageUrl(Uri uri) {
        this.zzb = uri;
        return this;
    }

    @Override // com.google.android.meet.addons.CollaborationStartingState.Builder
    public final CollaborationStartingState.Builder setSidePanelUrl(Uri uri) {
        this.zzc = uri;
        return this;
    }
}
