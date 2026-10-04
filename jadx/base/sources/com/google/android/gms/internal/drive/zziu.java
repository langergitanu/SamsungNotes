package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzit;
import com.google.android.gms.internal.drive.zziu;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zziu<MessageType extends zzit<MessageType, BuilderType>, BuilderType extends zziu<MessageType, BuilderType>> implements zzlr {
    public abstract BuilderType zza(MessageType messagetype);

    @Override // com.google.android.gms.internal.drive.zzlr
    public final /* synthetic */ zzlr zza(zzlq zzlqVar) {
        if (zzda().getClass().isInstance(zzlqVar)) {
            return zza((zzit) zzlqVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // 
    /* JADX INFO: renamed from: zzbn, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();
}
