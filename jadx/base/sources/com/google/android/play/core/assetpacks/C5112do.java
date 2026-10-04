package com.google.android.play.core.assetpacks;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.common.C5146a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5195bq;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.do */
/* JADX INFO: loaded from: classes5.dex */
final class C5112do {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2839a = new C5157af("PatchSliceTaskHandler");

    /* JADX INFO: renamed from: b */
    private final C5045bb f2840b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC5215cj<InterfaceC5141w> f2841c;

    /* JADX INFO: renamed from: d */
    private final C5146a f2842d;

    public C5112do(C5045bb c5045bb, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, C5146a c5146a) {
        this.f2840b = c5045bb;
        this.f2841c = interfaceC5215cj;
        this.f2842d = c5146a;
    }

    /* JADX INFO: renamed from: a */
    public final void m3801a(C5111dn c5111dn) {
        File fileM3693a = this.f2840b.m3693a(c5111dn.f2756k, c5111dn.f2831a, c5111dn.f2832b);
        File file = new File(this.f2840b.m3700b(c5111dn.f2756k, c5111dn.f2831a, c5111dn.f2832b), c5111dn.f2836f);
        try {
            InputStream gZIPInputStream = c5111dn.f2838h;
            if (c5111dn.f2835e == 2) {
                gZIPInputStream = new GZIPInputStream(gZIPInputStream, 8192);
            }
            try {
                C5048be c5048be = new C5048be(fileM3693a, file);
                if (this.f2842d.m3858a()) {
                    File fileM3694a = this.f2840b.m3694a(c5111dn.f2756k, c5111dn.f2833c, c5111dn.f2834d, c5111dn.f2836f);
                    if (!fileM3694a.exists()) {
                        fileM3694a.mkdirs();
                    }
                    C5115dr c5115dr = new C5115dr(this.f2840b, c5111dn.f2756k, c5111dn.f2833c, c5111dn.f2834d, c5111dn.f2836f);
                    C5195bq.m3943a(c5048be, gZIPInputStream, new C5068by(fileM3694a, c5115dr), c5111dn.f2837g);
                    c5115dr.m3818b(0);
                } else {
                    File file2 = new File(this.f2840b.m3716f(c5111dn.f2756k, c5111dn.f2833c, c5111dn.f2834d, c5111dn.f2836f), "slice.zip.tmp");
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    C5195bq.m3943a(c5048be, gZIPInputStream, new FileOutputStream(file2), c5111dn.f2837g);
                    if (!file2.renameTo(this.f2840b.m3713e(c5111dn.f2756k, c5111dn.f2833c, c5111dn.f2834d, c5111dn.f2836f))) {
                        throw new C5065bv("Error moving patch for slice " + c5111dn.f2836f + " of pack " + c5111dn.f2756k + Extension.DOT, c5111dn.f2755j);
                    }
                }
                gZIPInputStream.close();
                if (this.f2842d.m3858a()) {
                    f2839a.m3878c("Patching and extraction finished for slice %s of pack %s.", c5111dn.f2836f, c5111dn.f2756k);
                } else {
                    f2839a.m3878c("Patching finished for slice %s of pack %s.", c5111dn.f2836f, c5111dn.f2756k);
                }
                this.f2841c.m3979a().mo3670a(c5111dn.f2755j, c5111dn.f2756k, c5111dn.f2836f, 0);
                try {
                    c5111dn.f2838h.close();
                } catch (IOException unused) {
                    f2839a.m3879d("Could not close file for slice %s of pack %s.", c5111dn.f2836f, c5111dn.f2756k);
                }
            } finally {
            }
        } catch (IOException e) {
            f2839a.m3877b("IOException during patching %s.", e.getMessage());
            throw new C5065bv(AbstractC0541b.m775q("Error patching slice ", c5111dn.f2836f, " of pack ", c5111dn.f2756k, Extension.DOT), e, c5111dn.f2755j);
        }
    }
}
