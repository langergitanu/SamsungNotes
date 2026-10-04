package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.al */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5028al extends BinderC5027ak<ParcelFileDescriptor> {
    public BinderC5028al(C5034ar c5034ar, C5345i<ParcelFileDescriptor> c5345i) {
        super(c5034ar, c5345i);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.play.core.assetpacks.BinderC5027ak, com.google.android.play.core.internal.InterfaceC5237u
    /* JADX INFO: renamed from: b */
    public final void mo3641b(Bundle bundle, Bundle bundle2) {
        super.mo3641b(bundle, bundle2);
        this.f2547a.m4201b((T) ((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor")));
    }
}
