package p057N0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.synchronization.managers.C6900c;
import com.samsung.android.smartswitchfileshare.FileShareHelper;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentExtensionUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.CipherOutputStream;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p049L0.C0168a;
import p053M0.AbstractC0173a;
import p064P0.C0194a;
import p069Q0.C0209d;
import p079T.AbstractC0299q;
import p094X0.C0339a;
import p186h1.AbstractC12024e;
import p186h1.AbstractC12031l;
import p234q1.C14433b;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: N0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0182c extends AbstractC0173a {

    /* JADX INFO: renamed from: g */
    public static final String f568g = "SS$".concat("EntireBackupTask");

    /* JADX INFO: renamed from: e */
    public static void m439e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                AbstractC0000a.m1B(e, new StringBuilder("closeCloseable exception while closing stream "), f568g);
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m440k(File file, File file2, ZipOutputStream zipOutputStream, int i) throws Throwable {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bArr = new byte[1048576];
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            zipOutputStream.putNextEntry(new ZipEntry(file.getPath().substring(file2.getPath().length() + 1)));
            int i2 = 0;
            while (true) {
                int i4 = bufferedInputStream.read(bArr);
                if (i4 == -1) {
                    m439e(bufferedInputStream);
                    return;
                }
                zipOutputStream.write(bArr, 0, i4);
                if (i2 == 5000) {
                    String str = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m354i(i);
                    i2 = 0;
                }
                i2++;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedInputStream2 = bufferedInputStream;
            AbstractC0299q.m646q(f568g, "zipFile exception " + e.getMessage());
            m439e(bufferedInputStream2);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            m439e(bufferedInputStream2);
            throw th;
        }
    }

    /* JADX INFO: renamed from: l */
    public static void m441l(File file, File file2, ZipOutputStream zipOutputStream, int i) throws Throwable {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("zipFolder directory param is not a real folder in NormalBackupTask");
        }
        int length = file2.getPath().length() + 1;
        for (File file3 : fileArrListFiles) {
            if (file3.isDirectory()) {
                m441l(file3, file2, zipOutputStream, i);
            } else {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    try {
                        bArr = new byte[1048576];
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(file3.getPath().substring(length)));
                    int i2 = 0;
                    while (true) {
                        int i4 = bufferedInputStream.read(bArr);
                        if (i4 == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, i4);
                        if (i2 % 5000 == 0) {
                            String str = C0148f.f420k;
                            AbstractC0147e.f419a.getClass();
                            C0148f.m354i(i);
                        }
                        i2++;
                    }
                    m439e(bufferedInputStream);
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream2 = bufferedInputStream;
                    AbstractC0299q.m646q(f568g, "zipFolder exception. " + e.getMessage());
                    m439e(bufferedInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    m439e(bufferedInputStream2);
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[PHI: r0
      0x008a: PHI (r0v52 int) = (r0v47 int), (r0v49 int), (r0v49 int) binds: [B:21:0x0088, B:30:0x009f, B:28:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f8  */
    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo436a() throws Throwable {
        int i;
        String str;
        File file;
        int i2;
        int iCopy;
        StringBuilder sb;
        C0168a c0168a = this.f549a;
        Thread.currentThread().setName(C0182c.class.getSimpleName());
        String str2 = f568g;
        AbstractC0299q.m643n(str2, "EntireBackupTask start");
        this.f551c = true;
        try {
            FileUtils.deleteFile(new File(c0168a.f523k));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("EntireBackupTask failed to delete files in BnR path "), str2);
        }
        File file2 = new File(c0168a.f523k);
        if (!file2.exists() && !file2.mkdirs()) {
            AbstractC0299q.m646q(str2, "EntireBackupTask failed to mkdirs BnR path.");
        }
        AbstractC0299q.m643n(str2, "backupDocData " + Logger.getEncode(c0168a.f515c));
        if (!c0168a.f515c.endsWith("/")) {
            c0168a.f515c = AbstractC0622a.m1170p(c0168a.f515c, "/", new StringBuilder());
        }
        try {
            i = -5;
            if (this.f550b) {
                AbstractC0299q.m646q(str2, "backupDocData needToStop 1");
            } else {
                int iM445i = m445i();
                if (iM445i == 0) {
                    if (this.f550b) {
                        AbstractC0299q.m646q(str2, "backupDocData needToStop 2");
                    } else {
                        iM445i = m442f();
                        if (iM445i == 0 && this.f550b) {
                            AbstractC0299q.m646q(str2, "backupDocData needToStop 3");
                        } else {
                            i = iM445i;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            String message = e2.getMessage();
            AbstractC0299q.m646q(str2, "backupDocData exception case " + message);
            i = (TextUtils.isEmpty(message) || !message.contains("ENOSPC")) ? -1 : -4;
        }
        AbstractC0299q.m643n(str2, "EntireBackupTask " + i);
        C0180a c0180a = new C0180a(new int[]{81}, 0);
        Timer timer = new Timer();
        timer.schedule(c0180a, 0L, 5000L);
        AbstractC0299q.m643n(str2, "transferBackUpData");
        if (i == 0) {
            Context contextM435b = AbstractC0173a.m435b();
            Intent intent = c0168a.f513a;
            String str3 = c0168a.f515c;
            String str4 = AbstractC12031l.f8796a;
            if (AbstractC12031l.m13719i() && !SecureFolderConstants.SECURE_FOLDER_PACKAGE.equals(AbstractC14517a.m15160t(intent, "SOURCE"))) {
                File file3 = null;
                try {
                    file = new File(str3);
                } catch (Exception e3) {
                    e = e3;
                    str = "transferBackUpData ";
                    file = null;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    iCopy = new FileShareHelper(contextM435b.getApplicationContext(), str4).copy(new File(str3), intent);
                    try {
                        try {
                            sb = new StringBuilder("transferBackUpData size ");
                            str = "transferBackUpData ";
                        } catch (Exception e5) {
                            e = e5;
                            str = "transferBackUpData ";
                        }
                        try {
                            sb.append(FileUtils.getStorageSize(str3));
                            AbstractC0299q.m647r(str4, sb.toString());
                            AbstractC0299q.m643n(str4, "transferBackUpData srcFilePath/copyCount " + Logger.getEncode(str3) + iCopy);
                        } catch (Exception e6) {
                            e = e6;
                            AbstractC0299q.m646q(str4, str + e.getMessage());
                            AbstractC0299q.m643n(str4, "transferBackUpData srcFilePath/copyCount " + Logger.getEncode(str3) + iCopy);
                            if (file != null && iCopy > 0) {
                            }
                            timer.cancel();
                            String str5 = C0148f.f420k;
                            AbstractC0147e.f419a.getClass();
                            C0148f.m354i(100);
                            if (i == 0) {
                            }
                            this.f551c = false;
                            AbstractC0299q.m643n(str2, "EntireBackupTask finish");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i2 = iCopy;
                        file3 = file;
                        AbstractC0299q.m643n(str4, "transferBackUpData srcFilePath/copyCount " + Logger.getEncode(str3) + i2);
                        if (file3 != null && i2 > 0) {
                            try {
                                FileUtils.deleteFile(file3);
                            } catch (IOException unused) {
                                AbstractC0299q.m646q(str4, "transferBackUpData, delete srcFile exception");
                            }
                        }
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = "transferBackUpData ";
                    iCopy = 0;
                    AbstractC0299q.m646q(str4, str + e.getMessage());
                    AbstractC0299q.m643n(str4, "transferBackUpData srcFilePath/copyCount " + Logger.getEncode(str3) + iCopy);
                    if (file != null) {
                        try {
                            FileUtils.deleteFile(file);
                        } catch (IOException unused2) {
                            AbstractC0299q.m646q(str4, "transferBackUpData, delete srcFile exception");
                        }
                    }
                    timer.cancel();
                    String str52 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m354i(100);
                    if (i == 0) {
                    }
                    this.f551c = false;
                    AbstractC0299q.m643n(str2, "EntireBackupTask finish");
                } catch (Throwable th3) {
                    th = th3;
                    file3 = file;
                    i2 = 0;
                    AbstractC0299q.m643n(str4, "transferBackUpData srcFilePath/copyCount " + Logger.getEncode(str3) + i2);
                    if (file3 != null) {
                        FileUtils.deleteFile(file3);
                    }
                    throw th;
                }
                if (iCopy > 0) {
                    FileUtils.deleteFile(file);
                }
            }
        }
        timer.cancel();
        String str522 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m354i(100);
        if (i == 0) {
            C0148f.m357m(0, 0, c0168a.f516d, c0168a.f518f);
        } else if (i == -1) {
            C0148f.m357m(1, 1, c0168a.f516d, c0168a.f518f);
        } else if (i == -4) {
            C0148f.m357m(1, 2, c0168a.f516d, c0168a.f518f);
        } else if (i == 3) {
            C0148f.m357m(1, 3, c0168a.f516d, c0168a.f518f);
        }
        this.f551c = false;
        AbstractC0299q.m643n(str2, "EntireBackupTask finish");
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: c */
    public final void mo437c() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f439i = false;
        C14433b c14433b = this.f552d;
        if (c14433b != null) {
            c14433b.m15040r();
        }
    }

    @Override // p053M0.AbstractC0173a
    /* JADX INFO: renamed from: d */
    public final void mo438d() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f439i = true;
        C0148f.m354i(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m442f() throws Throwable {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        int i;
        CipherOutputStream cipherOutputStream;
        String str = f568g;
        AbstractC0299q.m643n(str, "encryptZipFile start");
        C0168a c0168a = this.f549a;
        File file = new File(AbstractC0155m.m387b(c0168a.f523k, "sdoc.zip"));
        if (!file.exists()) {
            AbstractC0299q.m646q(str, "encryptZipFile Zip file is not exist");
            return 3;
        }
        int i2 = -1;
        CipherOutputStream cipherOutputStreamM15151k = null;
        try {
            long length = file.length();
            byte[] bArr = new byte[1048576];
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                fileOutputStream = new FileOutputStream(AbstractC0155m.m387b(c0168a.f515c, "sdoc.bk"));
                try {
                    try {
                        cipherOutputStreamM15151k = AbstractC14517a.m15151k(c0168a.f519g, fileOutputStream, c0168a.f517e);
                        long j = 0;
                        int i4 = 0;
                        while (true) {
                            try {
                                int i5 = bufferedInputStream.read(bArr);
                                if (i5 == i2) {
                                    break;
                                }
                                cipherOutputStreamM15151k.write(bArr, 0, i5);
                                cipherOutputStream = cipherOutputStreamM15151k;
                                j += (long) i5;
                                if (i4 == 1000) {
                                    try {
                                        String str2 = C0148f.f420k;
                                        AbstractC0147e.f419a.getClass();
                                        C0148f.m354i((int) (((10 * j) / length) + 61));
                                        i4 = 0;
                                    } catch (Exception e) {
                                        e = e;
                                        cipherOutputStreamM15151k = cipherOutputStream;
                                        AbstractC0299q.m646q(str, "encryptZipFile exception " + e.getMessage());
                                        m439e(cipherOutputStreamM15151k);
                                        m439e(fileOutputStream);
                                        m439e(bufferedInputStream);
                                        i = -1;
                                        if (!file.delete()) {
                                        }
                                        FileUtils.deleteFile(new File(c0168a.f523k));
                                        AbstractC0299q.m643n(str, "encryptZipFile finish encryptZipFile result : " + i);
                                        return i;
                                    } catch (Throwable th) {
                                        th = th;
                                        cipherOutputStreamM15151k = cipherOutputStream;
                                        m439e(cipherOutputStreamM15151k);
                                        m439e(fileOutputStream);
                                        m439e(bufferedInputStream);
                                        throw th;
                                    }
                                }
                                i4++;
                                cipherOutputStreamM15151k = cipherOutputStream;
                                i2 = -1;
                            } catch (Exception e2) {
                                e = e2;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        cipherOutputStream = cipherOutputStreamM15151k;
                        String str3 = C0148f.f420k;
                        AbstractC0147e.f419a.getClass();
                        C0148f.m354i(71);
                        m439e(cipherOutputStream);
                        m439e(fileOutputStream);
                        m439e(bufferedInputStream);
                        i = 0;
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            fileOutputStream = null;
        }
        if (!file.delete()) {
            AbstractC0299q.m646q(str, "encryptZipFile failed to delete sdoc.zip");
        }
        try {
            FileUtils.deleteFile(new File(c0168a.f523k));
        } catch (IOException e7) {
            AbstractC0000a.m1B(e7, new StringBuilder("encryptZipFile failed to deleteFile BnR path "), str);
        }
        AbstractC0299q.m643n(str, "encryptZipFile finish encryptZipFile result : " + i);
        return i;
    }

    /* JADX INFO: renamed from: g */
    public final void m443g(ZipOutputStream zipOutputStream) throws Throwable {
        String filePath;
        String str = f568g;
        AbstractC0299q.m643n(str, "zipContentData start");
        Timer timer = new Timer();
        timer.schedule(new C0181b(56), 0L, 100000L);
        List<NotesContentEntity> allDataList = NotesDataRepositoryFactory.newInstance(AbstractC0173a.m435b()).createDocumentContentRepository().getAllDataList();
        timer.cancel();
        int size = allDataList.size();
        Iterator<NotesContentEntity> it = allDataList.iterator();
        int i = 0;
        int iM1611a = 56;
        while (it.hasNext()) {
            try {
                filePath = it.next().getFilePath();
            } catch (Exception e) {
                AbstractC6670b.m4762w(e, new StringBuilder("zipContentData _DATA no Data or void data "), str);
            }
            if (filePath.endsWith(".jpg") || filePath.endsWith(".png")) {
                AbstractC0299q.m643n(str, "zipContentData contentFilePath " + FileUtils.logPath(filePath));
                m440k(new File(filePath), new File(this.f549a.f520h), zipOutputStream, iM1611a);
                i++;
                iM1611a = AbstractC2322a.m1611a(i, 4, size, 56);
                String str2 = C0148f.f420k;
                AbstractC0147e.f419a.getClass();
                C0148f.m354i(iM1611a);
            }
        }
        String str3 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m354i(60);
        AbstractC0299q.m643n(str, "zipContentData finish");
    }

    /* JADX INFO: renamed from: h */
    public final void m444h(ZipOutputStream zipOutputStream) throws Throwable {
        String str = f568g;
        AbstractC0299q.m643n(str, "zipDatabases start");
        C0168a c0168a = this.f549a;
        File file = new File(c0168a.f525m);
        if (!file.exists() && !file.mkdirs()) {
            AbstractC0299q.m646q(str, "zipDatabases failed to mkdirs targetFolder path");
        }
        FileUtils.copyFile(new File(c0168a.f522j), file, true, false);
        m441l(file, new File(c0168a.f515c), zipOutputStream, 51);
        String str2 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m354i(55);
        AbstractC0299q.m643n(str, "zipDatabases finish");
    }

    /* JADX INFO: renamed from: i */
    public final int m445i() throws Throwable {
        ZipOutputStream zipOutputStream;
        C0168a c0168a = this.f549a;
        String str = f568g;
        AbstractC0299q.m603M(str, "zipDocDataFiles start");
        if (this.f553e.getAllPathList().isEmpty()) {
            return 3;
        }
        try {
            C6900c c6900c = new C6900c();
            C0194a c0194a = new C0194a();
            c0194a.f603a = AbstractC0173a.m435b();
            c0194a.f604b = c0168a.f529q;
            c0194a.f605c = c0168a.f515c;
            c0194a.f606d = c0168a.f524l;
            c6900c.m5111a(c0194a);
            C0339a.m671a(c0168a.f526n, c0168a.f527o);
        } catch (Exception e) {
            AbstractC0299q.m643n(str, "zipDocDataFiles failed to make backup files " + e.getMessage());
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(AbstractC0155m.m387b(c0168a.f523k, "sdoc.zip")))));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            zipOutputStream.setLevel(0);
            AbstractC12024e.m13706c(c0168a.f515c, "sdoc.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "category.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "categoryOder.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "hashtag.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "hashtagContent.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "preferences.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "hashtagNote4.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "bookMark.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "pageTemplate.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "cover.list", zipOutputStream);
            AbstractC12024e.m13706c(c0168a.f515c, "recentSearch.list", zipOutputStream);
            try {
                m441l(new File(c0168a.f524l), new File(c0168a.f515c), zipOutputStream, 40);
                m441l(new File(c0168a.f527o), new File(c0168a.f515c), zipOutputStream, 40);
            } catch (IOException e3) {
                AbstractC0299q.m646q(str, "zipDocDataFiles failed to make zip files " + e3.getMessage());
            }
            m446j(zipOutputStream);
            m444h(zipOutputStream);
            m443g(zipOutputStream);
            m439e(zipOutputStream);
        } catch (Exception e5) {
            e = e5;
            zipOutputStream2 = zipOutputStream;
            AbstractC0299q.m643n(str, "zipDocDataFiles failed to make zip files " + e.getMessage());
            m439e(zipOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            m439e(zipOutputStream2);
            throw th;
        }
        AbstractC0299q.m643n(str, "deleteTempBackupFiles start");
        if (!new File(AbstractC0155m.m387b(c0168a.f515c, "sdoc.list")).delete()) {
            AbstractC0299q.m646q(str, "deleteTempBackupFiles failed to delete SDOC_LIST");
        }
        if (!new File(AbstractC0155m.m387b(c0168a.f515c, "category.list")).delete()) {
            AbstractC0299q.m646q(str, "deleteTempBackupFiles failed to delete CATEGORY_LIST");
        }
        if (!new File(AbstractC0155m.m387b(c0168a.f515c, "categoryOder.list")).delete()) {
            AbstractC0299q.m646q(str, "deleteTempBackupFiles failed to delete CATEGORY_ORDER_LIST");
        }
        if (!new File(AbstractC0155m.m387b(c0168a.f515c, "preferences.list")).delete()) {
            AbstractC0299q.m646q(str, "deleteTempBackupFiles failed to delete PREFERENCE_LIST");
        }
        try {
            FileUtils.deleteFile(new File(c0168a.f524l));
        } catch (IOException e6) {
            AbstractC0000a.m1B(e6, new StringBuilder("deleteTempBackupFiles zipFiles Failed to deleteFile widgetIdFolder path "), str);
        }
        try {
            FileUtils.deleteFile(new File(c0168a.f525m));
        } catch (IOException e7) {
            AbstractC0000a.m1B(e7, new StringBuilder("deleteTempBackupFiles zipFiles Failed to deleteFile Databases_Restore_PATH path "), str);
        }
        File[] fileArrListFiles = new File(c0168a.f521i).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (DocumentExtensionUtils.isSdocx(file.getAbsolutePath()) && file.getName().startsWith("b_")) {
                    try {
                        FileUtils.deleteFile(file);
                    } catch (IOException e8) {
                        AbstractC0299q.m646q(str, "deleteTempBackupFiles failed to deleteFile " + file.getName() + ". " + e8.getMessage());
                    }
                }
            }
        }
        AbstractC0299q.m603M(str, "zipDocDataFiles finish");
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m446j(ZipOutputStream zipOutputStream) throws Throwable {
        char c;
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        String str = f568g;
        AbstractC0299q.m643n(str, "zipDocFiles start");
        Timer timer = new Timer();
        char c2 = PropertyUtils.MAPPED_DELIM;
        timer.schedule(new C0181b(40), 0L, 100000L);
        String str2 = C0209d.f640d;
        List<NotesDocumentEntity> notesForBackupExceptGenAi = this.f553e.getNotesForBackupExceptGenAi();
        timer.cancel();
        int size = notesForBackupExceptGenAi.size();
        C0168a c0168a = this.f549a;
        int length = new File(c0168a.f521i).getPath().length() + 1;
        Iterator<NotesDocumentEntity> it = notesForBackupExceptGenAi.iterator();
        BufferedInputStream bufferedInputStream2 = null;
        int i = 0;
        int i2 = 40;
        while (it.hasNext()) {
            String filePath = it.next().getFilePath();
            if (DocumentExtensionUtils.isSdocx(filePath)) {
                File file = new File(filePath);
                if (file.isDirectory()) {
                    c = c2;
                    String strM387b = AbstractC0155m.m387b(c0168a.f521i, "b_" + file.getName());
                    try {
                        DocumentCopyUtils.copy(AbstractC0173a.m435b(), filePath, strM387b);
                        filePath = strM387b;
                    } catch (Exception e) {
                        AbstractC6670b.m4762w(e, new StringBuilder("zipDocFiles failed to make zip file "), str);
                    }
                } else {
                    c = c2;
                }
            }
            File file2 = new File(filePath);
            if (file2.exists()) {
                try {
                    try {
                        bArr = new byte[1048576];
                        AbstractC0299q.m643n(str, "zipDocFiles noteFilePath " + FileUtils.logPath(filePath));
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(file2.getPath().substring(length)));
                    int i4 = 0;
                    while (true) {
                        int i5 = bufferedInputStream.read(bArr);
                        if (i5 == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, i5);
                        if (i4 == 5000) {
                            String str3 = C0148f.f420k;
                            AbstractC0147e.f419a.getClass();
                            C0148f.m354i(i2);
                            i4 = 0;
                        }
                        i4++;
                    }
                    i++;
                    i2 = ((i * 10) / size) + 40;
                    String str4 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    C0148f.m354i(i2);
                    m439e(bufferedInputStream);
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream2 = bufferedInputStream;
                    AbstractC0299q.m646q(str, "zipDocFiles exception " + e.getMessage());
                    m439e(bufferedInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    m439e(bufferedInputStream2);
                    throw th;
                }
            }
            c2 = c;
        }
        String str5 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m354i(50);
        AbstractC0299q.m643n(str, "zipDocFiles finish");
    }
}
