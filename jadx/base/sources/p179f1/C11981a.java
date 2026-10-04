package p179f1;

import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.crypto.CipherInputStream;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p079T.AbstractC0299q;
import p176e1.AbstractC11975a;
import p186h1.AbstractC12024e;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: f1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11981a extends AbstractC11983c {

    /* JADX INFO: renamed from: v */
    public static final String f8586v = "SS$".concat("EntireRestoreDocTask");

    /* JADX INFO: renamed from: E */
    public final void m13561E() {
        String str = this.f8590p;
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (DocumentExtensionUtils.isSdocx(file.getAbsolutePath()) && !file.isDirectory() && file.getName().startsWith("b_")) {
                    File file2 = new File(AbstractC0155m.m387b(str, file.getName().substring(2)));
                    String str2 = "renameBackupFiles file. " + FileUtils.logPath(file.getName()) + " to " + FileUtils.logPath(file2.getName());
                    String str3 = f8586v;
                    AbstractC0299q.m643n(str3, str2);
                    if (!file.renameTo(file2)) {
                        AbstractC0299q.m646q(str3, "renameBackupFiles failed to rename file");
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:22|(2:67|23)|(9:24|(3:26|(2:28|74)(1:73)|33)(1:72)|61|49|(1:51)(1:52)|53|54|55|56)|34|65|35|36|55|56) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0131, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0135, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0136, code lost:
    
        r12 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0173 A[Catch: all -> 0x01be, TryCatch #10 {all -> 0x01be, blocks: (B:49:0x014c, B:53:0x0196, B:52:0x0173), top: B:61:0x014c }] */
    @Override // p179f1.AbstractC11983c, p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo13545c() throws Throwable {
        CipherInputStream cipherInputStreamM15150j;
        File file;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        File file2;
        int i;
        long length;
        long j;
        int i2;
        String str = this.f8590p;
        String str2 = "decryptAndUnzip storage size before decrypt " + StorageUtils.getAvailableInternalMemorySize();
        String str3 = f8586v;
        AbstractC0299q.m603M(str3, str2);
        if ((this.f8557g & 64) != 0) {
            AbstractC0299q.m643n(str3, "decryptAndUnzip retry do nothing in decryptAndUnzip");
            return 0;
        }
        File file3 = new File(AbstractC0155m.m387b(this.f8552b, "sdoc_rename.bk"));
        if (!file3.exists()) {
            AbstractC0299q.m646q(str3, "decryptAndUnzip no encryptedFile");
            return -6;
        }
        AbstractC0299q.m603M(str3, "decryptAndUnzip encryptedFile length " + file3.length());
        byte[] bArr = new byte[10240];
        int i4 = -1;
        try {
            length = file3.length();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
            try {
                cipherInputStreamM15150j = AbstractC14517a.m15150j(this.f8556f, bufferedInputStream, this.f8554d);
                try {
                } catch (Exception e) {
                    e = e;
                    bufferedOutputStream2 = null;
                    file2 = null;
                    try {
                        AbstractC0299q.m646q(str3, "decryptAndUnzip exception " + e.getMessage());
                        if (e.getMessage().contains("ENOSPC")) {
                        }
                        m13551k(i, this.f8558h);
                        AbstractC11975a.m13541b(bufferedOutputStream2);
                        AbstractC11975a.m13541b(cipherInputStreamM15150j);
                        AbstractC11975a.m13541b(bufferedInputStream);
                        AbstractC11975a.m13542d(file3, "encryptedFile");
                        AbstractC11975a.m13542d(file2, "zipIn");
                        AbstractC0299q.m643n(str3, "decryptAndUnzip finish decryptAndUnzip result " + i);
                        this.f8559i = i;
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        file = file2;
                        bufferedOutputStream = bufferedOutputStream2;
                        AbstractC11975a.m13541b(bufferedOutputStream);
                        AbstractC11975a.m13541b(cipherInputStreamM15150j);
                        AbstractC11975a.m13541b(bufferedInputStream);
                        AbstractC11975a.m13542d(file3, "encryptedFile");
                        AbstractC11975a.m13542d(file, "zipIn");
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    file = null;
                    bufferedOutputStream = null;
                    AbstractC11975a.m13541b(bufferedOutputStream);
                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    AbstractC11975a.m13542d(file3, "encryptedFile");
                    AbstractC11975a.m13542d(file, "zipIn");
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cipherInputStreamM15150j = null;
            } catch (Throwable th3) {
                th = th3;
                cipherInputStreamM15150j = null;
            }
        } catch (Exception e3) {
            e = e3;
            cipherInputStreamM15150j = null;
            bufferedOutputStream2 = null;
            file2 = null;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            cipherInputStreamM15150j = null;
            file = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
        if (cipherInputStreamM15150j == null) {
            AbstractC0299q.m646q(str3, "decryptAndUnzip is null");
            AbstractC11975a.m13541b(bufferedInputStream);
            m13551k(-6, this.f8558h);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13542d(file3, "encryptedFile");
            return -6;
        }
        bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(AbstractC0155m.m387b(str, "sdoc.zip")));
        try {
            AbstractC0299q.m643n(str3, "decryptAndUnzip start decrypt");
            j = 0;
            i2 = 0;
        } catch (Exception e5) {
            e = e5;
            file2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = bufferedOutputStream2;
            file = null;
            AbstractC11975a.m13541b(bufferedOutputStream);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13542d(file3, "encryptedFile");
            AbstractC11975a.m13542d(file, "zipIn");
            throw th;
        }
        while (true) {
            int i5 = cipherInputStreamM15150j.read(bArr);
            if (i5 == i4) {
                break;
            }
            bufferedOutputStream2.write(bArr, 0, i5);
            j += (long) i5;
            if (i2 == 5000) {
                mo13550j((int) (((49 * j) / length) + 1));
                i2 = 0;
            }
            i2++;
            i4 = -1;
            AbstractC0299q.m646q(str3, "decryptAndUnzip exception " + e.getMessage());
            if (e.getMessage().contains("ENOSPC")) {
                i = -4;
            } else {
                AbstractC0299q.m643n(str3, "decryptAndUnzip buffer[10240]" + Arrays.toString(bArr));
                i = -1;
            }
            m13551k(i, this.f8558h);
            AbstractC11975a.m13541b(bufferedOutputStream2);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13542d(file3, "encryptedFile");
            AbstractC11975a.m13542d(file2, "zipIn");
            AbstractC0299q.m643n(str3, "decryptAndUnzip finish decryptAndUnzip result " + i);
            this.f8559i = i;
            return i;
        }
        AbstractC11975a.m13541b(bufferedOutputStream2);
        AbstractC0299q.m643n(str3, "decryptAndUnzip end decrypt.");
        AbstractC11975a.m13541b(bufferedInputStream);
        AbstractC11975a.m13542d(file3, "encryptedFile");
        AbstractC0299q.m603M(str3, "decryptAndUnzip storage size before unzip " + StorageUtils.getAvailableInternalMemorySize());
        File file4 = new File(str);
        file = new File(AbstractC0155m.m387b(str, "sdoc.zip"));
        AbstractC12024e.m13704a(file, file4, this.f8560j, 51, 99);
        m13561E();
        AbstractC11975a.m13541b(bufferedOutputStream2);
        AbstractC11975a.m13541b(cipherInputStreamM15150j);
        AbstractC11975a.m13541b(bufferedInputStream);
        AbstractC11975a.m13542d(file3, "encryptedFile");
        AbstractC11975a.m13542d(file, "zipIn");
        i = 0;
        AbstractC0299q.m643n(str3, "decryptAndUnzip finish decryptAndUnzip result " + i);
        this.f8559i = i;
        return i;
    }

    @Override // p179f1.AbstractC11983c, p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public final void mo13549i() {
        String str = this.f8590p;
        String str2 = this.f8552b;
        String str3 = f8586v;
        AbstractC0299q.m643n(str3, "prepare");
        super.mo13549i();
        if ((this.f8557g & 64) != 0) {
            AbstractC0299q.m643n(str3, "prepare retry, do nothing in prepare");
            return;
        }
        try {
            FileUtils.forceRenameTo(AbstractC0155m.m387b(str2, "sdoc.bk"), AbstractC0155m.m387b(str2, "sdoc_rename.bk"));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("prepare failed to rename file sdoc.bk, "), str3);
        }
        try {
            FileUtils.deleteFile(new File(this.f8592r));
        } catch (IOException e2) {
            AbstractC0000a.m1B(e2, new StringBuilder("prepare failed to deleteFile mDbResotrePath "), str3);
        }
        try {
            FileUtils.deleteFile(new File(str));
        } catch (IOException e3) {
            AbstractC0000a.m1B(e3, new StringBuilder("prepare failed to deleteFile mSDocBnRPath "), str3);
        }
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return;
        }
        AbstractC0299q.m646q(str3, "prepare failed to mkdirs mSDocBnRPath path");
    }
}
