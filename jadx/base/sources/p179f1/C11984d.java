package p179f1;

import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.document.memoconverter.LMemoConverter;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.CipherInputStream;
import p001A.AbstractC0000a;
import p010C.RunnableC0037b;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p174d1.C11972a;
import p176e1.AbstractC11975a;
import p186h1.AbstractC12024e;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: f1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11984d extends AbstractC11975a {

    /* JADX INFO: renamed from: q */
    public static final String f8595q = "SS$".concat("RestoreLMemoTask");

    /* JADX INFO: renamed from: p */
    public final String f8596p;

    public C11984d(C11972a c11972a) {
        super(c11972a);
        this.f8558h = 2;
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        this.f8596p = AbstractC0155m.m387b(C0148f.m352e(), "ETC");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: a */
    public final void mo13544a() {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.f436f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x014d  */
    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo13545c() throws Throwable {
        File file;
        CipherInputStream cipherInputStreamM15150j;
        File file2;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        int i;
        String str;
        String strM387b;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2;
        String str2 = this.f8596p;
        String str3 = f8595q;
        AbstractC0299q.m643n(str3, "Start decryptAndUnzip.");
        boolean z = this.f8560j;
        try {
            if (z) {
                str = this.f8552b;
            } else {
                String str4 = C0148f.f420k;
                AbstractC0147e.f419a.getClass();
                str = C0148f.f429t;
            }
            String strM387b2 = AbstractC0155m.m387b(str, "memo_rename.bk");
            strM387b = AbstractC0155m.m387b(str2, "sdoc.zip");
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(strM387b2));
            try {
                file2 = new File(strM387b2);
                try {
                    cipherInputStreamM15150j = AbstractC14517a.m15150j(this.f8556f, bufferedInputStream2, this.f8554d);
                } catch (Exception e) {
                    e = e;
                    bufferedInputStream = bufferedInputStream2;
                    file = null;
                    cipherInputStreamM15150j = null;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    file = null;
                    cipherInputStreamM15150j = null;
                }
                try {
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = bufferedInputStream2;
                    file = null;
                    bufferedOutputStream = null;
                    try {
                        AbstractC0299q.m646q(str3, "decryptAndUnzip Exception. " + e.getMessage());
                        i = !e.getMessage().contains("ENOSPC") ? -4 : -1;
                        AbstractC11975a.m13542d(file, "decryptedFile");
                        AbstractC11975a.m13542d(file2, "encryptedFile");
                        AbstractC11975a.m13541b(bufferedOutputStream);
                        AbstractC11975a.m13541b(cipherInputStreamM15150j);
                        AbstractC11975a.m13541b(bufferedInputStream);
                        AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        AbstractC11975a.m13542d(file, "decryptedFile");
                        AbstractC11975a.m13542d(file2, "encryptedFile");
                        AbstractC11975a.m13541b(bufferedOutputStream);
                        AbstractC11975a.m13541b(cipherInputStreamM15150j);
                        AbstractC11975a.m13541b(bufferedInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream2;
                    file = null;
                    bufferedOutputStream = null;
                    AbstractC11975a.m13542d(file, "decryptedFile");
                    AbstractC11975a.m13542d(file2, "encryptedFile");
                    AbstractC11975a.m13541b(bufferedOutputStream);
                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = bufferedInputStream2;
                file = null;
                cipherInputStreamM15150j = null;
                file2 = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = bufferedInputStream2;
                file = null;
                cipherInputStreamM15150j = null;
                file2 = null;
            }
        } catch (Exception e5) {
            e = e5;
            file = null;
            cipherInputStreamM15150j = null;
            file2 = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            file = null;
            cipherInputStreamM15150j = null;
            file2 = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
        if (cipherInputStreamM15150j == null) {
            AbstractC11975a.m13541b(bufferedInputStream2);
            AbstractC11975a.m13542d(file2, "encryptedFile");
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            AbstractC11975a.m13541b(bufferedInputStream2);
            return -6;
        }
        long length = file2.length();
        BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(strM387b));
        try {
            byte[] bArr = new byte[10240];
            i = 0;
            bufferedInputStream = bufferedInputStream2;
            int i2 = 0;
            while (true) {
                try {
                    int i4 = cipherInputStreamM15150j.read(bArr, 0, 10240);
                    if (i4 == -1) {
                        break;
                    }
                    bufferedOutputStream3.write(bArr, 0, i4);
                    if (i2 == 5000) {
                        long j = 0 / length;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        try {
                            mo13550j((int) (j + 1));
                            i2 = 0;
                        } catch (Exception e6) {
                            e = e6;
                            bufferedOutputStream = bufferedOutputStream2;
                            file = null;
                            AbstractC0299q.m646q(str3, "decryptAndUnzip Exception. " + e.getMessage());
                            if (!e.getMessage().contains("ENOSPC")) {
                            }
                            AbstractC11975a.m13542d(file, "decryptedFile");
                            AbstractC11975a.m13542d(file2, "encryptedFile");
                            AbstractC11975a.m13541b(bufferedOutputStream);
                            AbstractC11975a.m13541b(cipherInputStreamM15150j);
                            AbstractC11975a.m13541b(bufferedInputStream);
                            AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                            return i;
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedOutputStream = bufferedOutputStream2;
                            file = null;
                            AbstractC11975a.m13542d(file, "decryptedFile");
                            AbstractC11975a.m13542d(file2, "encryptedFile");
                            AbstractC11975a.m13541b(bufferedOutputStream);
                            AbstractC11975a.m13541b(cipherInputStreamM15150j);
                            AbstractC11975a.m13541b(bufferedInputStream);
                            throw th;
                        }
                    } else {
                        bufferedOutputStream2 = bufferedOutputStream3;
                    }
                    i2++;
                    bufferedOutputStream3 = bufferedOutputStream2;
                } catch (Exception e7) {
                    e = e7;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    bufferedOutputStream = bufferedOutputStream2;
                    file = null;
                    AbstractC0299q.m646q(str3, "decryptAndUnzip Exception. " + e.getMessage());
                    if (!e.getMessage().contains("ENOSPC")) {
                    }
                    AbstractC11975a.m13542d(file, "decryptedFile");
                    AbstractC11975a.m13542d(file2, "encryptedFile");
                    AbstractC11975a.m13541b(bufferedOutputStream);
                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                    return i;
                } catch (Throwable th7) {
                    th = th7;
                    bufferedOutputStream2 = bufferedOutputStream3;
                    bufferedOutputStream = bufferedOutputStream2;
                    file = null;
                    AbstractC11975a.m13542d(file, "decryptedFile");
                    AbstractC11975a.m13542d(file2, "encryptedFile");
                    AbstractC11975a.m13541b(bufferedOutputStream);
                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    throw th;
                }
            }
            bufferedOutputStream2 = bufferedOutputStream3;
            AbstractC11975a.m13541b(bufferedOutputStream2);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            AbstractC11975a.m13541b(bufferedInputStream);
            file = new File(strM387b);
        } catch (Exception e8) {
            e = e8;
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th8) {
            th = th8;
            bufferedInputStream = bufferedInputStream2;
        }
        try {
            File file3 = new File(str2);
            AbstractC0299q.m643n(str3, "Start unzip.");
            AbstractC12024e.m13704a(file, file3, z, 26, 50);
            AbstractC0299q.m643n(str3, "End unzip.");
            AbstractC11975a.m13542d(file, "decryptedFile");
            AbstractC11975a.m13542d(file2, "encryptedFile");
            AbstractC11975a.m13541b(bufferedOutputStream2);
        } catch (Exception e9) {
            e = e9;
            bufferedOutputStream = bufferedOutputStream2;
            AbstractC0299q.m646q(str3, "decryptAndUnzip Exception. " + e.getMessage());
            if (!e.getMessage().contains("ENOSPC")) {
            }
            AbstractC11975a.m13542d(file, "decryptedFile");
            AbstractC11975a.m13542d(file2, "encryptedFile");
            AbstractC11975a.m13541b(bufferedOutputStream);
        } catch (Throwable th9) {
            th = th9;
            bufferedOutputStream = bufferedOutputStream2;
            AbstractC11975a.m13542d(file, "decryptedFile");
            AbstractC11975a.m13542d(file2, "encryptedFile");
            AbstractC11975a.m13541b(bufferedOutputStream);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            AbstractC11975a.m13541b(bufferedInputStream);
            throw th;
        }
        AbstractC11975a.m13541b(cipherInputStreamM15150j);
        AbstractC11975a.m13541b(bufferedInputStream);
        AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
        return i;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public final void mo13549i() {
        String str = this.f8596p;
        String str2 = f8595q;
        AbstractC0299q.m643n(str2, "prepare.");
        String str3 = C0148f.f420k;
        AbstractC0147e.f419a.f436f = true;
        try {
            FileUtils.deleteFile(new File(str));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("Failed to deleteFile mEtcPath path. "), str2);
        }
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return;
        }
        AbstractC0299q.m646q(str2, "Failed to mkdirs mEtcPath path.");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: l */
    public final int mo13552l() throws Throwable {
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        int memoCount = LMemoConverter.getMemoCount(AbstractC0155m.m387b(C0148f.m352e(), "ETC"));
        if (memoCount <= 0) {
            AbstractC0299q.m646q(f8595q, "LMemo count 0.");
            return -1;
        }
        FolderManager.getInstance().executeOperation(new RunnableC0037b(this, 6));
        for (int i = 0; i < memoCount; i++) {
            this.f8561k.add(new ImportItem(35));
        }
        return 0;
    }
}
