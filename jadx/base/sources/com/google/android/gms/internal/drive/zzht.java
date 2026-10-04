package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
final class zzht extends com.google.android.gms.drive.metadata.internal.zzb {
    public zzht(String str, Collection collection, Collection collection2, int i) {
        super(str, collection, collection2, GmsVersion.VERSION_ORLA);
    }

    @Override // com.google.android.gms.drive.metadata.internal.zzb, com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zze */
    public final Boolean zzc(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getInteger(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED, i, i2) == 2);
    }
}
