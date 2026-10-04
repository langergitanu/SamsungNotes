package com.google.android.play.core.assetpacks;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.zip.GZIPInputStream;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bt */
/* JADX INFO: loaded from: classes5.dex */
final class C5063bt {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2672a = new C5157af("ExtractChunkTaskHandler");

    /* JADX INFO: renamed from: b */
    private final byte[] f2673b = new byte[8192];

    /* JADX INFO: renamed from: c */
    private final C5045bb f2674c;

    /* JADX INFO: renamed from: d */
    private final InterfaceC5215cj<InterfaceC5141w> f2675d;

    /* JADX INFO: renamed from: e */
    private final InterfaceC5215cj<C5039aw> f2676e;

    /* JADX INFO: renamed from: f */
    private final C5069bz f2677f;

    public C5063bt(C5045bb c5045bb, InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj, InterfaceC5215cj<C5039aw> interfaceC5215cj2, C5069bz c5069bz) {
        this.f2674c = c5045bb;
        this.f2675d = interfaceC5215cj;
        this.f2676e = interfaceC5215cj2;
        this.f2677f = c5069bz;
    }

    /* JADX INFO: renamed from: b */
    private final File m3736b(C5062bs c5062bs) {
        File fileM3694a = this.f2674c.m3694a(c5062bs.f2756k, c5062bs.f2663a, c5062bs.f2664b, c5062bs.f2665c);
        if (!fileM3694a.exists()) {
            fileM3694a.mkdirs();
        }
        return fileM3694a;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0181  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3737a(C5062bs c5062bs) {
        InputStream sequenceInputStream;
        C5121dx c5121dxM3725a;
        File fileM3817b;
        long length;
        int iMin;
        int iMax;
        C5115dr c5115dr = new C5115dr(this.f2674c, c5062bs.f2756k, c5062bs.f2663a, c5062bs.f2664b, c5062bs.f2665c);
        File fileM3716f = this.f2674c.m3716f(c5062bs.f2756k, c5062bs.f2663a, c5062bs.f2664b, c5062bs.f2665c);
        if (!fileM3716f.exists()) {
            fileM3716f.mkdirs();
        }
        try {
            InputStream inputStream = c5062bs.f2671i;
            InputStream gZIPInputStream = c5062bs.f2666d != 1 ? inputStream : new GZIPInputStream(inputStream, this.f2673b.length);
            try {
                if (c5062bs.f2667e > 0) {
                    C5114dq c5114dqM3809a = c5115dr.m3809a();
                    int iM3806e = c5114dqM3809a.m3806e();
                    int i = c5062bs.f2667e;
                    if (iM3806e != i - 1) {
                        throw new C5065bv("Trying to resume with chunk number " + i + " when previously processed chunk was number " + c5114dqM3809a.m3806e() + Extension.DOT, c5062bs.f2755j);
                    }
                    int iM3802a = c5114dqM3809a.m3802a();
                    sequenceInputStream = null;
                    if (iM3802a == 1) {
                        f2672a.m3875a("Resuming zip entry from last chunk during file %s.", c5114dqM3809a.m3803b());
                        File file = new File(c5114dqM3809a.m3803b());
                        if (!file.exists()) {
                            throw new C5065bv("Partial file specified in checkpoint does not exist. Corrupt directory.", c5062bs.f2755j);
                        }
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                        randomAccessFile.seek(c5114dqM3809a.m3804c());
                        long jM3805d = c5114dqM3809a.m3805d();
                        do {
                            iMin = (int) Math.min(jM3805d, this.f2673b.length);
                            iMax = Math.max(gZIPInputStream.read(this.f2673b, 0, iMin), 0);
                            if (iMax > 0) {
                                randomAccessFile.write(this.f2673b, 0, iMax);
                            }
                            jM3805d -= (long) iMax;
                            if (jM3805d <= 0) {
                                break;
                            }
                        } while (iMax > 0);
                        long length2 = randomAccessFile.length();
                        randomAccessFile.close();
                        if (iMax != iMin) {
                            f2672a.m3875a("Chunk has ended while resuming the previous chunks file content.", new Object[0]);
                            c5115dr.m3813a(file.getCanonicalPath(), length2, jM3805d, c5062bs.f2667e);
                        } else {
                            sequenceInputStream = gZIPInputStream;
                        }
                    } else if (iM3802a == 2) {
                        f2672a.m3875a("Resuming zip entry from last chunk during local file header.", new Object[0]);
                        File fileM3708d = this.f2674c.m3708d(c5062bs.f2756k, c5062bs.f2663a, c5062bs.f2664b, c5062bs.f2665c);
                        if (!fileM3708d.exists()) {
                            throw new C5065bv("Checkpoint extension file not found.", c5062bs.f2755j);
                        }
                        sequenceInputStream = new SequenceInputStream(new FileInputStream(fileM3708d), gZIPInputStream);
                    } else {
                        if (iM3802a != 3) {
                            throw new C5065bv("Slice checkpoint file corrupt. Unexpected FileExtractionStatus " + c5114dqM3809a.m3802a() + Extension.DOT, c5062bs.f2755j);
                        }
                        f2672a.m3875a("Resuming central directory from last chunk.", new Object[0]);
                        c5115dr.m3812a(gZIPInputStream, c5114dqM3809a.m3804c());
                        if (!c5062bs.m3735a()) {
                            throw new C5065bv("Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB.", c5062bs.f2755j);
                        }
                    }
                }
                if (sequenceInputStream != null) {
                    C5056bm c5056bm = new C5056bm(sequenceInputStream);
                    File fileM3736b = m3736b(c5062bs);
                    do {
                        c5121dxM3725a = c5056bm.m3725a();
                        if (!c5121dxM3725a.m3832f() && !c5056bm.m3727c()) {
                            if (!c5121dxM3725a.m3828b() || c5121dxM3725a.m3827a()) {
                                c5115dr.m3816a(c5121dxM3725a.m3834h(), c5056bm);
                            } else {
                                c5115dr.m3814a(c5121dxM3725a.m3834h());
                                File file2 = new File(fileM3736b, c5121dxM3725a.m3829c());
                                file2.getParentFile().mkdirs();
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                int i2 = c5056bm.read(this.f2673b);
                                while (i2 > 0) {
                                    fileOutputStream.write(this.f2673b, 0, i2);
                                    i2 = c5056bm.read(this.f2673b);
                                }
                                fileOutputStream.close();
                            }
                        }
                        if (c5056bm.m3726b()) {
                            break;
                        }
                    } while (!c5056bm.m3727c());
                    if (c5056bm.m3727c()) {
                        f2672a.m3875a("Writing central directory metadata.", new Object[0]);
                        c5115dr.m3816a(c5121dxM3725a.m3834h(), sequenceInputStream);
                    }
                    if (!c5062bs.m3735a()) {
                        if (c5121dxM3725a.m3832f()) {
                            f2672a.m3875a("Writing slice checkpoint for partial local file header.", new Object[0]);
                            c5115dr.m3815a(c5121dxM3725a.m3834h(), c5062bs.f2667e);
                        } else if (c5056bm.m3727c()) {
                            f2672a.m3875a("Writing slice checkpoint for central directory.", new Object[0]);
                            c5115dr.m3810a(c5062bs.f2667e);
                        } else {
                            if (c5121dxM3725a.m3831e() == 0) {
                                f2672a.m3875a("Writing slice checkpoint for partial file.", new Object[0]);
                                fileM3817b = new File(m3736b(c5062bs), c5121dxM3725a.m3829c());
                                length = c5121dxM3725a.m3830d() - c5056bm.m3728d();
                                if (fileM3817b.length() != length) {
                                    throw new C5065bv("Partial file is of unexpected size.");
                                }
                            } else {
                                f2672a.m3875a("Writing slice checkpoint for partial unextractable file.", new Object[0]);
                                fileM3817b = c5115dr.m3817b();
                                length = fileM3817b.length();
                            }
                            c5115dr.m3813a(fileM3817b.getCanonicalPath(), length, c5056bm.m3728d(), c5062bs.f2667e);
                        }
                    }
                }
                gZIPInputStream.close();
                if (c5062bs.m3735a()) {
                    try {
                        c5115dr.m3818b(c5062bs.f2667e);
                    } catch (IOException e) {
                        f2672a.m3877b("Writing extraction finished checkpoint failed with %s.", e.getMessage());
                        throw new C5065bv("Writing extraction finished checkpoint failed.", e, c5062bs.f2755j);
                    }
                }
                f2672a.m3878c("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(c5062bs.f2667e), c5062bs.f2665c, c5062bs.f2756k, Integer.valueOf(c5062bs.f2755j));
                this.f2675d.m3979a().mo3670a(c5062bs.f2755j, c5062bs.f2756k, c5062bs.f2665c, c5062bs.f2667e);
                try {
                    c5062bs.f2671i.close();
                } catch (IOException unused) {
                    f2672a.m3879d("Could not close file for chunk %s of slice %s of pack %s.", Integer.valueOf(c5062bs.f2667e), c5062bs.f2665c, c5062bs.f2756k);
                }
                if (c5062bs.f2670h == 3) {
                    C5039aw c5039awM3979a = this.f2676e.m3979a();
                    String str = c5062bs.f2756k;
                    long j = c5062bs.f2669g;
                    c5039awM3979a.m3676a(AssetPackState.m3624a(str, 3, 0, j, j, this.f2677f.m3740a(str, c5062bs)));
                }
            } finally {
            }
        } catch (IOException e2) {
            f2672a.m3877b("IOException during extraction %s.", e2.getMessage());
            int i4 = c5062bs.f2667e;
            String str2 = c5062bs.f2665c;
            String str3 = c5062bs.f2756k;
            int i5 = c5062bs.f2755j;
            StringBuilder sbM1629s = AbstractC2322a.m1629s("Error extracting chunk ", i4, " of slice ", str2, " of pack ");
            sbM1629s.append(str3);
            sbM1629s.append(" of session ");
            sbM1629s.append(i5);
            sbM1629s.append(Extension.DOT);
            throw new C5065bv(sbM1629s.toString(), e2, c5062bs.f2755j);
        }
    }
}
