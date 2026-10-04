package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.OnChangeListener;

/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzdj implements ChangeListener {
    private final OnChangeListener zzgi;

    private zzdj(OnChangeListener onChangeListener) {
        this.zzgi = onChangeListener;
    }

    public static ChangeListener zza(OnChangeListener onChangeListener) {
        return new zzdj(onChangeListener);
    }

    @Override // com.google.android.gms.drive.events.ChangeListener
    public final void onChange(ChangeEvent changeEvent) {
        this.zzgi.onChange(changeEvent);
    }
}
