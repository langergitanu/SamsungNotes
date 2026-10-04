package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.ds */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class C5116ds implements FilenameFilter {

    /* JADX INFO: renamed from: a */
    static final FilenameFilter f2859a = new C5116ds();

    private C5116ds() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return C5117dt.f2860a.matcher(str).matches();
    }
}
