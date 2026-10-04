package com.google.android.play.core.assetpacks;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.play.core.internal.C5157af;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.df */
/* JADX INFO: loaded from: classes5.dex */
final class C5103df {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2811a = new C5157af("MergeSliceTaskHandler");

    /* JADX INFO: renamed from: b */
    private final C5045bb f2812b;

    public C5103df(C5045bb c5045bb) {
        this.f2812b = c5045bb;
    }

    /* JADX INFO: renamed from: a */
    public final void m3797a(C5102de c5102de) {
        File fileM3701b = this.f2812b.m3701b(c5102de.f2756k, c5102de.f2808a, c5102de.f2809b, c5102de.f2810c);
        if (!fileM3701b.exists()) {
            throw new C5065bv(AbstractC0541b.m773o("Cannot find verified files for slice ", c5102de.f2810c, Extension.DOT), c5102de.f2755j);
        }
        File fileM3703c = this.f2812b.m3703c(c5102de.f2756k, c5102de.f2808a, c5102de.f2809b);
        if (!fileM3703c.exists()) {
            fileM3703c.mkdirs();
        }
        m3796a(fileM3701b, fileM3703c);
        try {
            this.f2812b.m3696a(c5102de.f2756k, c5102de.f2808a, c5102de.f2809b, this.f2812b.m3707d(c5102de.f2756k, c5102de.f2808a, c5102de.f2809b) + 1);
        } catch (IOException e) {
            f2811a.m3877b("Writing merge checkpoint failed with %s.", e.getMessage());
            throw new C5065bv("Writing merge checkpoint failed.", e, c5102de.f2755j);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3796a(File file, File file2) {
        if (!file.isDirectory()) {
            if (file2.exists()) {
                String strValueOf = String.valueOf(file2);
                throw new C5065bv(AbstractC0622a.m1170p("File clashing with existing file from other slice: ", strValueOf, new StringBuilder(strValueOf.length() + 51)));
            }
            if (file.renameTo(file2)) {
                return;
            }
            String strValueOf2 = String.valueOf(file);
            throw new C5065bv(AbstractC0622a.m1170p("Unable to move file: ", strValueOf2, new StringBuilder(strValueOf2.length() + 21)));
        }
        file2.mkdirs();
        for (File file3 : file.listFiles()) {
            m3796a(file3, new File(file2, file3.getName()));
        }
        if (file.delete()) {
            return;
        }
        String strValueOf3 = String.valueOf(file);
        throw new C5065bv(AbstractC0622a.m1170p("Unable to delete directory: ", strValueOf3, new StringBuilder(strValueOf3.length() + 28)));
    }
}
