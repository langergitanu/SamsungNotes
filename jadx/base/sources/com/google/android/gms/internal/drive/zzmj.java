package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzmj extends zzmi {
    public zzmj(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.drive.zzmi
    public final void zzbp() {
        if (!isImmutable()) {
            for (int i = 0; i < zzer(); i++) {
                Map.Entry entryZzaw = zzaw(i);
                if (((zzkd) entryZzaw.getKey()).zzcs()) {
                    entryZzaw.setValue(Collections.unmodifiableList((List) entryZzaw.getValue()));
                }
            }
            for (Map.Entry entry : zzes()) {
                if (((zzkd) entry.getKey()).zzcs()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbp();
    }
}
