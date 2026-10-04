package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.C5173av;
import com.google.android.play.core.internal.C5214ci;
import com.google.android.play.core.splitcompat.C5271p;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipException;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.db */
/* JADX INFO: loaded from: classes5.dex */
public final class C5099db {

    /* JADX INFO: renamed from: a */
    private static InterfaceC5016a f2796a;

    /* JADX INFO: renamed from: a */
    public static int m3779a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    /* JADX INFO: renamed from: b */
    public static long m3786b(byte[] bArr, int i) {
        return ((long) ((m3788c(bArr, i + 2) << 16) | m3788c(bArr, i))) & 4294967295L;
    }

    /* JADX INFO: renamed from: c */
    public static int m3788c(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0145, code lost:
    
        if (r0 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0147, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0148, code lost:
    
        r2 = r0.longValue();
        r0 = new byte[8];
        r4.seek(22 + r2);
        r4.readFully(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0172, code lost:
    
        return com.google.android.play.core.assetpacks.AssetLocation.m3617a(r16, ((r2 + 30) + ((long) m3788c(r0, 4))) + ((long) m3788c(r0, 6)), m3786b(r0, 0));
     */
    @Nullable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AssetLocation m3780a(String str, String str2) throws IOException {
        Long lValueOf;
        String str3 = str2;
        C5173av.m3913a(str != null, "Attempted to get file location from a null apk path.");
        C5173av.m3913a(str3 != null, "Attempted to get file location in apk " + str + " with a null file path.");
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        byte[] bArr = new byte[22];
        randomAccessFile.seek(randomAccessFile.length() + (-22));
        randomAccessFile.readFully(bArr);
        C5053bj c5053bjM3782a = m3779a(bArr, 0) == 1347093766 ? m3782a(bArr) : null;
        if (c5053bjM3782a == null) {
            long length = randomAccessFile.length();
            long jMax = (-22) + length;
            long j = length - 65558;
            if (j < 0) {
                j = 0;
            }
            int iMin = (int) Math.min(1024L, randomAccessFile.length());
            byte[] bArr2 = new byte[iMin];
            byte[] bArr3 = new byte[22];
            loop0: while (true) {
                jMax = Math.max((jMax - ((long) iMin)) + 3, j);
                randomAccessFile.seek(jMax);
                randomAccessFile.readFully(bArr2);
                int i = iMin - 4;
                while (i >= 0) {
                    byte b = bArr2[i];
                    int i2 = b != 5 ? b != 6 ? b != 75 ? b != 80 ? -1 : 0 : 1 : 3 : 2;
                    if (i2 >= 0 && i >= i2 && m3779a(bArr2, i - i2) == 1347093766) {
                        randomAccessFile.seek((jMax + ((long) i)) - ((long) i2));
                        randomAccessFile.readFully(bArr3);
                        c5053bjM3782a = m3782a(bArr3);
                        break loop0;
                    }
                    i -= 4;
                    str3 = str2;
                }
                if (jMax == j) {
                    throw new ZipException(AbstractC0541b.m772n("End Of Central Directory signature not found in APK ", str));
                }
                str3 = str2;
            }
        }
        long jM3788c = c5053bjM3782a.f2625a;
        byte[] bytes = str3.getBytes("UTF-8");
        byte[] bArr4 = new byte[46];
        byte[] bArr5 = new byte[str3.length()];
        int i4 = 0;
        while (true) {
            if (i4 >= c5053bjM3782a.f2626b) {
                lValueOf = null;
                break;
            }
            randomAccessFile.seek(jM3788c);
            randomAccessFile.readFully(bArr4);
            int iM3779a = m3779a(bArr4, 0);
            if (iM3779a != 1347092738) {
                throw new ZipException(String.format("Missing central directory file header signature when looking for file %s in APK %s. Read %d entries out of %d. Found %d instead of the header signature %d.", str3, str, Integer.valueOf(i4), Integer.valueOf(c5053bjM3782a.f2626b), Integer.valueOf(iM3779a), 1347092738));
            }
            randomAccessFile.seek(28 + jM3788c);
            int iM3788c = m3788c(bArr4, 28);
            if (iM3788c == str3.length()) {
                randomAccessFile.seek(46 + jM3788c);
                randomAccessFile.read(bArr5);
                if (Arrays.equals(bArr5, bytes)) {
                    lValueOf = Long.valueOf(m3786b(bArr4, 42));
                    break;
                }
            }
            jM3788c += (long) (m3788c(bArr4, 32) + m3788c(bArr4, 30) + iM3788c + 46);
            i4++;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3787b(@AssetPackStatus int i) {
        return i == 5 || i == 6 || i == 4;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m3789c(@AssetPackStatus int i) {
        return i == 2 || i == 7 || i == 3;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized InterfaceC5016a m3781a(Context context) {
        try {
            if (f2796a == null) {
                C5060bq c5060bq = new C5060bq(null);
                c5060bq.m3734a(new C5132n(C5271p.m4096a(context)));
                f2796a = c5060bq.m3733a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2796a;
    }

    /* JADX INFO: renamed from: a */
    private static C5053bj m3782a(byte[] bArr) {
        int iM3788c = m3788c(bArr, 10);
        m3786b(bArr, 12);
        return new C5053bj(m3786b(bArr, 16), iM3788c);
    }

    /* JADX INFO: renamed from: a */
    public static String m3783a(List<File> list) throws NoSuchAlgorithmException, IOException {
        int i;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        byte[] bArr = new byte[8192];
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            FileInputStream fileInputStream = new FileInputStream(it.next());
            do {
                try {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        C5214ci.m3978a(th, th2);
                    }
                    throw th;
                }
            } while (i != -1);
            fileInputStream.close();
        }
        return Base64.encodeToString(messageDigest.digest(), 11);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3784a(@AssetPackStatus int i) {
        return i == 1 || i == 7 || i == 2 || i == 3;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3785a(@AssetPackStatus int i, @AssetPackStatus int i2) {
        if (i == 5) {
            if (i2 != 5) {
                return true;
            }
            i = 5;
        }
        if (i == 6 && i2 != 6 && i2 != 5) {
            return true;
        }
        if (i != 4 || i2 == 4) {
            if (i == 3 && (i2 == 2 || i2 == 7 || i2 == 1 || i2 == 8)) {
                return true;
            }
            if (i == 2) {
                return i2 == 1 || i2 == 8;
            }
            return false;
        }
        return true;
    }
}
