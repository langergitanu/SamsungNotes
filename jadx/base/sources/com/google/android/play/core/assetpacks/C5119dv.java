package com.google.android.play.core.assetpacks;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.internal.C5157af;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dv */
/* JADX INFO: loaded from: classes5.dex */
final class C5119dv {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2865a = new C5157af("VerifySliceTaskHandler");

    /* JADX INFO: renamed from: b */
    private final C5045bb f2866b;

    public C5119dv(C5045bb c5045bb) {
        this.f2866b = c5045bb;
    }

    /* JADX INFO: renamed from: a */
    public final void m3825a(C5118du c5118du) {
        File fileM3694a = this.f2866b.m3694a(c5118du.f2756k, c5118du.f2861a, c5118du.f2862b, c5118du.f2863c);
        if (!fileM3694a.exists()) {
            throw new C5065bv(AbstractC0541b.m773o("Cannot find unverified files for slice ", c5118du.f2863c, Extension.DOT), c5118du.f2755j);
        }
        m3824a(c5118du, fileM3694a);
        File fileM3701b = this.f2866b.m3701b(c5118du.f2756k, c5118du.f2861a, c5118du.f2862b, c5118du.f2863c);
        if (!fileM3701b.exists()) {
            fileM3701b.mkdirs();
        }
        if (!fileM3694a.renameTo(fileM3701b)) {
            throw new C5065bv(AbstractC0541b.m773o("Failed to move slice ", c5118du.f2863c, " after verification."), c5118du.f2755j);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m3824a(C5118du c5118du, File file) {
        try {
            File fileM3716f = this.f2866b.m3716f(c5118du.f2756k, c5118du.f2861a, c5118du.f2862b, c5118du.f2863c);
            if (!fileM3716f.exists()) {
                throw new C5065bv("Cannot find metadata files for slice " + c5118du.f2863c + Extension.DOT, c5118du.f2755j);
            }
            try {
                if (!C5099db.m3783a(C5117dt.m3822a(file, fileM3716f)).equals(c5118du.f2864d)) {
                    throw new C5065bv(AbstractC0541b.m773o("Verification failed for slice ", c5118du.f2863c, Extension.DOT), c5118du.f2755j);
                }
                f2865a.m3878c("Verification of slice %s of pack %s successful.", c5118du.f2863c, c5118du.f2756k);
            } catch (IOException e) {
                throw new C5065bv(AbstractC0541b.m773o("Could not digest file during verification for slice ", c5118du.f2863c, Extension.DOT), e, c5118du.f2755j);
            } catch (NoSuchAlgorithmException e2) {
                throw new C5065bv("SHA256 algorithm not supported.", e2, c5118du.f2755j);
            }
        } catch (IOException e3) {
            throw new C5065bv(AbstractC0541b.m773o("Could not reconstruct slice archive during verification for slice ", c5118du.f2863c, Extension.DOT), e3, c5118du.f2755j);
        }
    }
}
