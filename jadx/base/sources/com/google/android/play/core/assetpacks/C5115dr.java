package com.google.android.play.core.assetpacks;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5214ci;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.dr */
/* JADX INFO: loaded from: classes5.dex */
final class C5115dr {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2851a = new C5157af("SliceMetadataManager");

    /* JADX INFO: renamed from: c */
    private final C5045bb f2853c;

    /* JADX INFO: renamed from: d */
    private final String f2854d;

    /* JADX INFO: renamed from: e */
    private final int f2855e;

    /* JADX INFO: renamed from: f */
    private final long f2856f;

    /* JADX INFO: renamed from: g */
    private final String f2857g;

    /* JADX INFO: renamed from: b */
    private final byte[] f2852b = new byte[8192];

    /* JADX INFO: renamed from: h */
    private int f2858h = -1;

    public C5115dr(C5045bb c5045bb, String str, int i, long j, String str2) {
        this.f2853c = c5045bb;
        this.f2854d = str;
        this.f2855e = i;
        this.f2856f = j;
        this.f2857g = str2;
    }

    /* JADX INFO: renamed from: e */
    private final File m3807e() {
        File fileM3716f = this.f2853c.m3716f(this.f2854d, this.f2855e, this.f2856f, this.f2857g);
        if (!fileM3716f.exists()) {
            fileM3716f.mkdirs();
        }
        return fileM3716f;
    }

    /* JADX INFO: renamed from: f */
    private final File m3808f() throws IOException {
        File fileM3704c = this.f2853c.m3704c(this.f2854d, this.f2855e, this.f2856f, this.f2857g);
        fileM3704c.getParentFile().mkdirs();
        fileM3704c.createNewFile();
        return fileM3704c;
    }

    /* JADX INFO: renamed from: a */
    public final C5114dq m3809a() throws IOException {
        File fileM3704c = this.f2853c.m3704c(this.f2854d, this.f2855e, this.f2856f, this.f2857g);
        if (!fileM3704c.exists()) {
            throw new C5065bv("Slice checkpoint file does not exist.");
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(fileM3704c);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                throw new C5065bv("Slice checkpoint file corrupt.");
            }
            try {
                int i = Integer.parseInt(properties.getProperty("fileStatus"));
                String property = properties.getProperty("fileName");
                long j = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                long j2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                int i2 = Integer.parseInt(properties.getProperty("previousChunk"));
                this.f2858h = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                return new C5114dq(i, property, j, j2, i2);
            } catch (NumberFormatException e) {
                throw new C5065bv("Slice checkpoint file corrupt.", e);
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: b */
    public final File m3817b() {
        return new File(m3807e(), AbstractC2322a.m1615e(this.f2858h, "-NAM.dat"));
    }

    /* JADX INFO: renamed from: c */
    public final int m3820c() throws IOException {
        File fileM3704c = this.f2853c.m3704c(this.f2854d, this.f2855e, this.f2856f, this.f2857g);
        if (!fileM3704c.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(fileM3704c);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new C5065bv("Slice checkpoint file corrupt.");
        } finally {
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3821d() {
        File fileM3704c = this.f2853c.m3704c(this.f2854d, this.f2855e, this.f2856f, this.f2857g);
        if (!fileM3704c.exists()) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(fileM3704c);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") != null) {
                    return Integer.parseInt(properties.getProperty("fileStatus")) == 4;
                }
                f2851a.m3877b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                return false;
            } finally {
            }
        } catch (IOException e) {
            f2851a.m3877b("Could not read checkpoint while checking if extraction finished. %s", e);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3810a(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(m3817b().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f2858h));
        FileOutputStream fileOutputStream = new FileOutputStream(m3808f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3811a(long j, byte[] bArr, int i, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(m3817b(), InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3812a(InputStream inputStream, long j) throws IOException {
        int i;
        RandomAccessFile randomAccessFile = new RandomAccessFile(m3817b(), InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.seek(j);
            do {
                i = inputStream.read(this.f2852b);
                if (i > 0) {
                    randomAccessFile.write(this.f2852b, 0, i);
                }
            } while (i == this.f2852b.length);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3813a(String str, long j, long j2, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j));
        properties.put("remainingBytes", String.valueOf(j2));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f2858h));
        FileOutputStream fileOutputStream = new FileOutputStream(m3808f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3814a(byte[] bArr) {
        this.f2858h++;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(m3807e(), AbstractC2322a.m1615e(this.f2858h, "-LFH.dat")));
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new C5065bv("Could not write metadata file.", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3818b(int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f2858h));
        FileOutputStream fileOutputStream = new FileOutputStream(m3808f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3819b(byte[] bArr, int i) throws IOException {
        this.f2858h++;
        FileOutputStream fileOutputStream = new FileOutputStream(m3817b());
        try {
            fileOutputStream.write(bArr, 0, i);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3815a(byte[] bArr, int i) throws IOException {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.f2858h));
        FileOutputStream fileOutputStream = new FileOutputStream(m3808f());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            File fileM3708d = this.f2853c.m3708d(this.f2854d, this.f2855e, this.f2856f, this.f2857g);
            if (fileM3708d.exists()) {
                fileM3708d.delete();
            }
            fileOutputStream = new FileOutputStream(fileM3708d);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3816a(byte[] bArr, InputStream inputStream) throws IOException {
        this.f2858h++;
        FileOutputStream fileOutputStream = new FileOutputStream(m3817b());
        try {
            fileOutputStream.write(bArr);
            int i = inputStream.read(this.f2852b);
            while (i > 0) {
                fileOutputStream.write(this.f2852b, 0, i);
                i = inputStream.read(this.f2852b);
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }
}
