package p186h1;

import android.os.Build;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import dalvik.system.ZipPathValidator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: h1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12024e {

    /* JADX INFO: renamed from: a */
    public static final String f8777a = "SS$".concat("MigrationZipUtils");

    /* JADX INFO: renamed from: a */
    public static void m13704a(File file, File file2, boolean z, int i, int i2) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Throwable th2;
        StringBuilder sb = new StringBuilder("unzip() - start, zipFile = [");
        sb.append(FileUtils.logPath(file.getAbsolutePath()));
        sb.append("], targetDir = [");
        sb.append(FileUtils.logPath(file2.getAbsolutePath() + "],  false, true"));
        String string = sb.toString();
        String str = f8777a;
        AbstractC0299q.m643n(str, string);
        if (Build.VERSION.SDK_INT >= 34) {
            AbstractC0299q.m643n(str, "clearCallbackForZipPathValidator clearCallback");
            ZipPathValidator.clearCallback();
        }
        long length = file.length();
        ArrayList arrayList = new ArrayList();
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2);
                    try {
                        ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream2);
                        long jM13705b = 0;
                        int i4 = i;
                        while (true) {
                            try {
                                try {
                                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                                    if (nextEntry == null) {
                                        break;
                                    }
                                    long j = length;
                                    String name = nextEntry.getName();
                                    fileInputStream = fileInputStream2;
                                    try {
                                        File file3 = new File(file2, name);
                                        if (file3.getCanonicalPath().startsWith(file2.getCanonicalPath())) {
                                            bufferedInputStream = bufferedInputStream2;
                                            arrayList.add(file3.getCanonicalPath());
                                            if (!nextEntry.isDirectory()) {
                                                File parentFile = file3.getParentFile();
                                                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                                                    AbstractC0299q.m643n(str, "unzip() - mkdirs failed 2. [" + FileUtils.logPath(parentFile.getCanonicalPath()) + "]");
                                                }
                                                jM13705b += m13705b(zipInputStream, file3, i4, z);
                                                AbstractC0299q.m603M(str, "unzip() - currentSize " + jM13705b);
                                                int i5 = (int) (((long) i) + ((((long) (i2 - i)) * jM13705b) / j));
                                                if (z) {
                                                    String str2 = C0148f.f420k;
                                                    AbstractC0147e.f419a.m367j(i5);
                                                }
                                                i4 = i5;
                                            } else if (!file3.getAbsoluteFile().mkdirs()) {
                                                AbstractC0299q.m643n(str, "unzip() - mkdirs failed 1. [" + FileUtils.logPath(file3.getCanonicalPath()) + "]");
                                            }
                                        } else {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("unzip() - invalid target path [");
                                            sb2.append(FileUtils.logPath(name));
                                            sb2.append("], size = [");
                                            bufferedInputStream = bufferedInputStream2;
                                            try {
                                                sb2.append(file3.length());
                                                sb2.append("]");
                                                AbstractC0299q.m646q(str, sb2.toString());
                                            } catch (Throwable th3) {
                                                th = th3;
                                                th2 = th;
                                                try {
                                                    zipInputStream.close();
                                                    throw th2;
                                                } catch (Throwable th4) {
                                                    th2.addSuppressed(th4);
                                                    throw th2;
                                                }
                                            }
                                        }
                                        length = j;
                                        fileInputStream2 = fileInputStream;
                                        bufferedInputStream2 = bufferedInputStream;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bufferedInputStream = bufferedInputStream2;
                                        th2 = th;
                                        zipInputStream.close();
                                        throw th2;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    Throwable th7 = th;
                                    try {
                                        bufferedInputStream.close();
                                        throw th7;
                                    } catch (Throwable th8) {
                                        th7.addSuppressed(th8);
                                        throw th7;
                                    }
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                fileInputStream = fileInputStream2;
                            }
                        }
                        FileInputStream fileInputStream3 = fileInputStream2;
                        BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
                        zipInputStream.close();
                        bufferedInputStream3.close();
                        fileInputStream3.close();
                        AbstractC0299q.m643n(str, "unzip() - end");
                        if (z) {
                            String str3 = C0148f.f420k;
                            AbstractC0147e.f419a.m367j(i2);
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        fileInputStream = fileInputStream2;
                        bufferedInputStream = bufferedInputStream2;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    fileInputStream = fileInputStream2;
                    th = th;
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th12) {
                        th.addSuppressed(th12);
                        throw th;
                    }
                }
            } catch (Throwable th13) {
                th = th13;
                th = th;
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            AbstractC0299q.m643n(str, "unzip() - Exception = " + FileUtils.logPath(file.getCanonicalPath()));
            throw e;
        }
    }

    /* JADX INFO: renamed from: b */
    public static long m13705b(ZipInputStream zipInputStream, File file, int i, boolean z) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        long j;
        int i2;
        String str = f8777a;
        file.getName();
        byte[] bArr = new byte[10240];
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            j = 0;
            i2 = 0;
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        while (true) {
            try {
                int i4 = zipInputStream.read(bArr);
                if (i4 == -1) {
                    bufferedOutputStream.flush();
                    AbstractC0299q.m643n(str, "unzip() - [" + FileUtils.logPath(file.getAbsolutePath()) + "], size = [" + file.length() + "]");
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    return j;
                }
                j += (long) i4;
                bufferedOutputStream.write(bArr, 0, i4);
                if (i2 == 5000) {
                    if (z) {
                        String str2 = C0148f.f420k;
                        AbstractC0147e.f419a.m367j(i);
                    }
                    i2 = 0;
                }
                i2++;
            } finally {
            }
            fileOutputStream.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m13706c(String str, String str2, ZipOutputStream zipOutputStream) {
        String str3 = "zipList : " + Logger.getEncode(str2);
        String str4 = f8777a;
        AbstractC0299q.m643n(str4, str3);
        byte[] bArr = new byte[10240];
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(AbstractC0155m.m387b(str, str2)));
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str2));
                    while (true) {
                        int i = bufferedInputStream.read(bArr);
                        if (i == -1) {
                            bufferedInputStream.close();
                            fileInputStream.close();
                            return;
                        }
                        zipOutputStream.write(bArr, 0, i);
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("Exception while zip list. "), str4);
        }
    }
}
