package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: com.google.android.play.core.appupdate.r */
/* JADX INFO: loaded from: classes5.dex */
final class C5008r {

    /* JADX INFO: renamed from: a */
    private final Context f2456a;

    public C5008r(Context context) {
        this.f2456a = context;
    }

    /* JADX INFO: renamed from: a */
    public final long m3609a() {
        return m3608a(new File(this.f2456a.getFilesDir(), "assetpacks"));
    }

    /* JADX INFO: renamed from: a */
    private static long m3608a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        long jM3608a = 0;
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                jM3608a += m3608a(file2);
            }
        }
        return jM3608a;
    }
}
