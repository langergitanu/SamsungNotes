package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C5214ci;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dt */
/* JADX INFO: loaded from: classes5.dex */
final class C5117dt {

    /* JADX INFO: renamed from: a */
    private static final Pattern f2860a = Pattern.compile("[0-9]+-(NAM|LFH)\\.dat");

    /* JADX INFO: renamed from: a */
    public static List<File> m3822a(File file, File file2) throws IOException {
        File[] fileArr;
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file2.listFiles(C5116ds.f2859a);
        if (fileArrListFiles == null) {
            fileArr = new File[0];
        } else {
            File[] fileArr2 = new File[fileArrListFiles.length];
            for (File file3 : fileArrListFiles) {
                int i = Integer.parseInt(file3.getName().split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)[0]);
                if (i > fileArrListFiles.length || fileArr2[i] != null) {
                    throw new C5065bv("Metadata folder ordering corrupt.");
                }
                fileArr2[i] = file3;
            }
            fileArr = fileArr2;
        }
        for (File file4 : fileArr) {
            arrayList.add(file4);
            if (file4.getName().contains("LFH")) {
                FileInputStream fileInputStream = new FileInputStream(file4);
                try {
                    C5121dx c5121dxM3725a = new C5056bm(fileInputStream).m3725a();
                    if (c5121dxM3725a.m3829c() == null) {
                        throw new C5065bv("Metadata files corrupt. Could not read local file header.");
                    }
                    File file5 = new File(file, c5121dxM3725a.m3829c());
                    if (!file5.exists()) {
                        throw new C5065bv("Missing asset file " + file5.getCanonicalPath() + " during slice reconstruction.");
                    }
                    arrayList.add(file5);
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        C5214ci.m3978a(th, th2);
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }
}
