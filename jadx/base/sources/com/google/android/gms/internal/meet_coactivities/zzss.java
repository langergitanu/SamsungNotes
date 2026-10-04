package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.internal.meet_coactivities.zzss;
import com.google.android.gms.internal.meet_coactivities.zzsy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class zzss<MessageType extends zzsy<MessageType, BuilderType>, BuilderType extends zzss<MessageType, BuilderType>> extends zzqy<MessageType, BuilderType> {
    protected zzsy zza;
    private final zzsy zzb;

    public zzss(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzQ()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzD();
    }

    private static void zza(Object obj, Object obj2) {
        zzum.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuf
    public final /* synthetic */ zzue zzT() {
        throw null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuf
    public final boolean zzU() {
        return zzsy.zzP(this.zza, false);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzqy
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzss zzh() {
        zzss zzssVar = (zzss) this.zzb.zzi(5, null, null);
        zzssVar.zza = zzm();
        return zzssVar;
    }

    public final zzss zzj(zzsy zzsyVar) {
        if (!this.zzb.equals(zzsyVar)) {
            if (!this.zza.zzQ()) {
                zzp();
            }
            zza(this.zza, zzsyVar);
        }
        return this;
    }

    public final MessageType zzk() {
        MessageType messagetype = (MessageType) zzm();
        if (messagetype.zzU()) {
            return messagetype;
        }
        throw new zzvd(messagetype);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzud
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public MessageType zzm() {
        if (!this.zza.zzQ()) {
            return (MessageType) this.zza;
        }
        this.zza.zzL();
        return (MessageType) this.zza;
    }

    public final void zzo() {
        if (this.zza.zzQ()) {
            return;
        }
        zzp();
    }

    public void zzp() {
        zzsy zzsyVarZzD = this.zzb.zzD();
        zza(zzsyVarZzD, this.zza);
        this.zza = zzsyVarZzD;
    }
}
