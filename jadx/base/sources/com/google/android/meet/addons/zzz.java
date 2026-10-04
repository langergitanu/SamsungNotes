package com.google.android.meet.addons;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzz extends CollaborationStartingState {

    @Nullable
    private final String zza;

    @Nullable
    private final Uri zzb;

    @Nullable
    private final Uri zzc;

    public /* synthetic */ zzz(String str, Uri uri, Uri uri2, zzy zzyVar) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = uri2;
    }

    @Override // com.google.android.meet.addons.CollaborationStartingState
    @Nullable
    public final String additionalData() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CollaborationStartingState) {
            CollaborationStartingState collaborationStartingState = (CollaborationStartingState) obj;
            String str = this.zza;
            if (str != null ? str.equals(collaborationStartingState.additionalData()) : collaborationStartingState.additionalData() == null) {
                Uri uri = this.zzb;
                if (uri != null ? uri.equals(collaborationStartingState.mainStageUrl()) : collaborationStartingState.mainStageUrl() == null) {
                    Uri uri2 = this.zzc;
                    if (uri2 != null ? uri2.equals(collaborationStartingState.sidePanelUrl()) : collaborationStartingState.sidePanelUrl() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = str == null ? 0 : str.hashCode();
        Uri uri = this.zzb;
        int iHashCode2 = uri == null ? 0 : uri.hashCode();
        int i = iHashCode ^ 1000003;
        Uri uri2 = this.zzc;
        return (((i * 1000003) ^ iHashCode2) * 1000003) ^ (uri2 != null ? uri2.hashCode() : 0);
    }

    @Override // com.google.android.meet.addons.CollaborationStartingState
    @Nullable
    public final Uri mainStageUrl() {
        return this.zzb;
    }

    @Override // com.google.android.meet.addons.CollaborationStartingState
    @Nullable
    public final Uri sidePanelUrl() {
        return this.zzc;
    }

    public final String toString() {
        Uri uri = this.zzc;
        String strValueOf = String.valueOf(this.zzb);
        String strValueOf2 = String.valueOf(uri);
        StringBuilder sb = new StringBuilder("CollaborationStartingState{additionalData=");
        AbstractC2821a.m2207B(sb, this.zza, ", mainStageUrl=", strValueOf, ", sidePanelUrl=");
        return AbstractC0622a.m1170p(strValueOf2, "}", sb);
    }
}
