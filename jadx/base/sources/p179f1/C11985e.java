package p179f1;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.CipherInputStream;
import net.lingala.zip4j.util.InternalZipConstants;
import p001A.AbstractC0000a;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p174d1.C11972a;
import p176e1.AbstractC11975a;
import p186h1.AbstractC12022c;
import p186h1.AbstractC12024e;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: f1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11985e extends AbstractC11975a {

    /* JADX INFO: renamed from: q */
    public static final String f8597q = "SS$".concat("RestoreNMemoTask");

    /* JADX INFO: renamed from: p */
    public final String f8598p;

    public C11985e(C11972a c11972a) {
        super(c11972a);
        int i = c11972a.f8542g;
        if ((i & 32) != 0) {
            this.f8558h = 32;
        } else if ((i & 8) != 0) {
            this.f8558h = 8;
        } else if ((i & 16) != 0) {
            this.f8558h = 16;
        }
        if (UserHandleCompat.getInstance().isSecureFolderMode()) {
            AbstractC0299q.m643n(f8597q, "Change sessionKey in Secure Folder Mode.");
            this.f8554d = "";
        }
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        this.f8598p = AbstractC0155m.m387b(C0148f.m352e(), "NMEMO");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: a */
    public final void mo13544a() {
        String str;
        if (this.f8560j) {
            str = this.f8552b;
        } else {
            String str2 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            str = C0148f.f428s;
        }
        AbstractC11975a.m13542d(new File(AbstractC0155m.m387b(str, "memo_rename.bk")), "encryptedFile");
        String str3 = this.f8598p;
        AbstractC11975a.m13542d(new File(AbstractC0155m.m387b(str3, "memo.zip")), "decryptedFile");
        AbstractC11975a.m13542d(new File(AbstractC0155m.m387b(str3, "memo.db")), "inMemoDbFile");
        String str4 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        File file = new File(C0148f.f428s);
        if (file.exists()) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e) {
                AbstractC0299q.m643n(f8597q, "clearSDocTempFiles. " + e.getMessage());
            }
        }
        AbstractC0147e.f419a.f435e = false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:6|(1:8)(1:9)|10|(3:155|(2:136|12)(2:151|24)|25)|(2:156|26)|(1:161)|(4:149|28|29|30)(22:138|37|38|153|39|40|(9:164|41|(6:43|158|44|45|(5:47|142|48|49|170)(1:169)|55)(1:168)|145|111|112|(1:126)|127|128)|61|140|62|143|63|64|166|65|(4:147|66|67|(3:69|163|70)(1:171))|78|(1:80)(1:82)|83|(0)|127|128)|34|145|111|112|(0)|127|128) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:138|37|38|(3:153|39|40)|(9:164|41|(6:43|158|44|45|(5:47|142|48|49|170)(1:169)|55)(1:168)|145|111|112|(1:126)|127|128)|61|140|62|143|63|64|166|65|(4:147|66|67|(3:69|163|70)(1:171))|78|(1:80)(1:82)|83|(0)|127|128) */
    /* JADX WARN: Can't wrap try/catch for region: R(22:138|37|38|153|39|40|(9:164|41|(6:43|158|44|45|(5:47|142|48|49|170)(1:169)|55)(1:168)|145|111|112|(1:126)|127|128)|61|140|62|143|63|64|166|65|(4:147|66|67|(3:69|163|70)(1:171))|78|(1:80)(1:82)|83|(0)|127|128) */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01cd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01e1, code lost:
    
        r8 = -4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0180, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0181, code lost:
    
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0184, code lost:
    
        r3 = false;
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0186, code lost:
    
        r10 = r18;
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x018b, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x018d, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x018f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0190, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0192, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d9 A[Catch: all -> 0x01e3, TryCatch #1 {all -> 0x01e3, blocks: (B:115:0x01cf, B:117:0x01d9, B:123:0x01e8), top: B:134:0x01cf }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f8  */
    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo13545c() throws Throwable {
        BufferedInputStream bufferedInputStream;
        boolean z;
        BufferedOutputStream bufferedOutputStream;
        CipherInputStream cipherInputStreamM15150j;
        CipherInputStream cipherInputStream;
        BufferedOutputStream bufferedOutputStream2;
        boolean z2;
        int i;
        String message;
        String str;
        File file;
        BufferedInputStream bufferedInputStream2;
        long length;
        BufferedOutputStream bufferedOutputStream3;
        byte[] bArr;
        long j;
        int i2;
        String str2 = this.f8598p;
        int i4 = this.f8558h;
        String str3 = f8597q;
        if (i4 == 16) {
            AbstractC0299q.m643n(str3, "Mask type is NMemo Update. Skip decryptAndUnzip.");
            return 0;
        }
        AbstractC0299q.m643n(str3, "Start decryptAndUnzip.");
        boolean z3 = this.f8560j;
        int i5 = z3 ? 8 : 32;
        int i6 = -1;
        try {
            if (z3) {
                try {
                    str = this.f8552b;
                } catch (Exception unused) {
                    z = false;
                    i = -1;
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                    cipherInputStreamM15150j = null;
                    m13551k(i, i5);
                    AbstractC11975a.m13541b(bufferedOutputStream);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                    z2 = z;
                    if (!z2) {
                    }
                    AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                    return i;
                }
            } else {
                try {
                    String str4 = C0148f.f420k;
                    AbstractC0147e.f419a.getClass();
                    str = C0148f.f428s;
                } catch (Exception unused2) {
                    z = false;
                    i = -1;
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                    cipherInputStreamM15150j = null;
                    m13551k(i, i5);
                    AbstractC11975a.m13541b(bufferedOutputStream);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                    z2 = z;
                    if (!z2) {
                    }
                    AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                    return i;
                }
            }
            file = new File(AbstractC0155m.m387b(str, "memo_rename.bk"));
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e = e;
            z = false;
            bufferedInputStream = null;
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            cipherInputStreamM15150j = AbstractC14517a.m15150j(this.f8556f, bufferedInputStream2, this.f8554d);
        } catch (IOException e2) {
            e = e2;
            z = false;
            bufferedInputStream = bufferedInputStream2;
            cipherInputStream = null;
            bufferedOutputStream2 = null;
            try {
                message = e.getMessage();
                if (TextUtils.isEmpty(message)) {
                    int i7 = -6;
                    m13551k(i7, i5);
                    AbstractC11975a.m13541b(bufferedOutputStream2);
                    AbstractC11975a.m13541b(bufferedInputStream);
                    AbstractC11975a.m13541b(cipherInputStream);
                    z2 = z;
                    i = i7;
                }
                if (!z2) {
                }
                AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                return i;
            } catch (Throwable th2) {
                th = th2;
                cipherInputStreamM15150j = cipherInputStream;
                bufferedOutputStream = bufferedOutputStream2;
                AbstractC11975a.m13541b(bufferedOutputStream);
                AbstractC11975a.m13541b(bufferedInputStream);
                AbstractC11975a.m13541b(cipherInputStreamM15150j);
                throw th;
            }
        } catch (Exception unused3) {
            z = false;
            bufferedInputStream = bufferedInputStream2;
            i = -1;
            bufferedOutputStream = null;
            cipherInputStreamM15150j = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = bufferedInputStream2;
            bufferedOutputStream = null;
            cipherInputStreamM15150j = null;
            AbstractC11975a.m13541b(bufferedOutputStream);
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            throw th;
        }
        try {
        } catch (IOException e3) {
            e = e3;
            z = false;
            bufferedInputStream = bufferedInputStream2;
            cipherInputStream = cipherInputStreamM15150j;
            bufferedOutputStream2 = null;
            message = e.getMessage();
            if (TextUtils.isEmpty(message)) {
            }
            if (!z2) {
            }
            AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
            return i;
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = bufferedInputStream2;
            bufferedOutputStream = null;
        }
        if (cipherInputStreamM15150j != null) {
            try {
                length = file.length();
                bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(AbstractC0155m.m387b(str2, "memo.zip")));
                try {
                    try {
                        bArr = new byte[10240];
                        j = 0;
                        i2 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        bufferedOutputStream2 = bufferedOutputStream3;
                    }
                } catch (IOException e5) {
                    e = e5;
                    z = false;
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                } catch (Exception unused4) {
                    z = false;
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                }
            } catch (Exception unused5) {
                z = false;
                bufferedInputStream = bufferedInputStream2;
                i = -1;
                bufferedOutputStream = null;
            }
            while (true) {
                try {
                    int i8 = cipherInputStreamM15150j.read(bArr);
                    if (i8 == i6) {
                        break;
                    }
                    try {
                        bufferedOutputStream3.write(bArr, 0, i8);
                        bufferedInputStream = bufferedInputStream2;
                        bufferedOutputStream2 = bufferedOutputStream3;
                        j += (long) i8;
                        if (i2 == 5000) {
                            try {
                                try {
                                    mo13550j((int) (((49 * j) / length) + 1));
                                    i2 = 0;
                                } catch (Throwable th6) {
                                    th = th6;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    AbstractC11975a.m13541b(bufferedOutputStream);
                                    AbstractC11975a.m13541b(bufferedInputStream);
                                    AbstractC11975a.m13541b(cipherInputStreamM15150j);
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e = e6;
                                cipherInputStream = cipherInputStreamM15150j;
                                z = false;
                                message = e.getMessage();
                                if (TextUtils.isEmpty(message)) {
                                }
                                if (!z2) {
                                }
                                AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                                return i;
                            } catch (Exception unused6) {
                                bufferedOutputStream = bufferedOutputStream2;
                                i = -1;
                                z = false;
                                m13551k(i, i5);
                                AbstractC11975a.m13541b(bufferedOutputStream);
                                AbstractC11975a.m13541b(bufferedInputStream);
                                AbstractC11975a.m13541b(cipherInputStreamM15150j);
                                z2 = z;
                                if (!z2) {
                                }
                                AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                                return i;
                            }
                        }
                        i2++;
                        bufferedInputStream2 = bufferedInputStream;
                        bufferedOutputStream3 = bufferedOutputStream2;
                        i6 = -1;
                    } catch (IOException e7) {
                        e = e7;
                        bufferedInputStream = bufferedInputStream2;
                        bufferedOutputStream2 = bufferedOutputStream3;
                    } catch (Exception unused7) {
                        bufferedInputStream = bufferedInputStream2;
                        bufferedOutputStream2 = bufferedOutputStream3;
                    }
                } catch (IOException e8) {
                    e = e8;
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                } catch (Exception unused8) {
                    bufferedInputStream = bufferedInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream3;
                }
                m13551k(i, i5);
                AbstractC11975a.m13541b(bufferedOutputStream);
                AbstractC11975a.m13541b(bufferedInputStream);
                AbstractC11975a.m13541b(cipherInputStreamM15150j);
                z2 = z;
                if (!z2) {
                    mo13550j(100);
                    m13551k(i, i5);
                }
                AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                return i;
            }
            bufferedInputStream = bufferedInputStream2;
            bufferedOutputStream2 = bufferedOutputStream3;
            AbstractC11975a.m13541b(bufferedOutputStream2);
            AbstractC11975a.m13541b(bufferedInputStream);
            File file2 = new File(AbstractC0155m.m387b(str2, "memo.zip"));
            File file3 = new File(str2);
            AbstractC0299q.m643n(str3, "Start unzip.");
            AbstractC12024e.m13704a(file2, file3, z3, 51, 90);
            AbstractC0299q.m643n(str3, "Finish unzip.");
            File file4 = new File(AbstractC0155m.m387b(str2, "memo.db"));
            String str5 = C0148f.f420k;
            AbstractC0147e.f419a.getClass();
            File file5 = new File(AbstractC0155m.m387b(C0148f.m349b(), "memo.db"));
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file4));
            BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(file5));
            while (true) {
                try {
                    try {
                        int i9 = bufferedInputStream3.read(bArr);
                        if (i9 == -1) {
                            break;
                        }
                        z = false;
                        try {
                            bufferedOutputStream4.write(bArr, 0, i9);
                        } catch (IOException e9) {
                            e = e9;
                            bufferedOutputStream2 = bufferedOutputStream4;
                            bufferedInputStream = bufferedInputStream3;
                            cipherInputStream = cipherInputStreamM15150j;
                            message = e.getMessage();
                            if (TextUtils.isEmpty(message)) {
                            }
                            if (!z2) {
                            }
                            AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                            return i;
                        } catch (Exception unused9) {
                            bufferedInputStream = bufferedInputStream3;
                            i = -1;
                            bufferedOutputStream = bufferedOutputStream4;
                            m13551k(i, i5);
                            AbstractC11975a.m13541b(bufferedOutputStream);
                            AbstractC11975a.m13541b(bufferedInputStream);
                            AbstractC11975a.m13541b(cipherInputStreamM15150j);
                            z2 = z;
                            if (!z2) {
                            }
                            AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
                            return i;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        bufferedInputStream = bufferedInputStream3;
                        bufferedOutputStream = bufferedOutputStream4;
                        AbstractC11975a.m13541b(bufferedOutputStream);
                        AbstractC11975a.m13541b(bufferedInputStream);
                        AbstractC11975a.m13541b(cipherInputStreamM15150j);
                        throw th;
                    }
                } catch (IOException e10) {
                    e = e10;
                    z = false;
                } catch (Exception unused10) {
                    z = false;
                }
            }
            z = false;
            AbstractC11975a.m13541b(bufferedInputStream3);
            AbstractC11975a.m13541b(bufferedOutputStream4);
            boolean zM13582m = z3 ? m13582m() : false;
            AbstractC11975a.m13541b(bufferedOutputStream4);
            AbstractC11975a.m13541b(bufferedInputStream3);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            i = 0;
            z2 = zM13582m;
            if (!z2) {
            }
            AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
            return i;
        }
        try {
            AbstractC0299q.m646q(str3, "is null.");
            AbstractC11975a.m13541b(bufferedInputStream2);
            AbstractC11975a.m13541b(bufferedInputStream2);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            return -6;
        } catch (Exception unused11) {
            z = false;
            i = -1;
            bufferedInputStream = bufferedInputStream2;
        }
        bufferedOutputStream = null;
        m13551k(i, i5);
        AbstractC11975a.m13541b(bufferedOutputStream);
        AbstractC11975a.m13541b(bufferedInputStream);
        AbstractC11975a.m13541b(cipherInputStreamM15150j);
        z2 = z;
        if (!z2) {
        }
        AbstractC0299q.m643n(str3, "Finish decryptAndUnzip. result : " + i);
        return i;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public final void mo13549i() {
        String str = this.f8552b;
        String str2 = this.f8598p;
        String str3 = f8597q;
        AbstractC0299q.m643n(str3, "prepare.");
        String str4 = C0148f.f420k;
        AbstractC0147e.f419a.f435e = true;
        if (this.f8558h == 16) {
            AbstractC0299q.m643n(str3, "Mask type is NMemo Update. Skip prepare.");
            return;
        }
        try {
            FileUtils.deleteFile(new File(str2));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("Failed to deleteFile mNMemoPath path. "), str3);
        }
        if ((this.f8557g & 8) != 0) {
            try {
                FileUtils.forceRenameTo(AbstractC0155m.m387b(str, "memo.bk"), AbstractC0155m.m387b(str, "memo_rename.bk"));
            } catch (IOException e2) {
                AbstractC0000a.m1B(e2, new StringBuilder("Failed to rename file. "), str3);
            }
        }
        AbstractC0147e.f419a.getClass();
        File file = new File(C0148f.m349b());
        if (!file.exists() && !file.mkdirs()) {
            AbstractC0299q.m646q(str3, "Failed to mkdirs databases path.");
        }
        File file2 = new File(str2);
        if (file2.exists() || file2.mkdirs()) {
            return;
        }
        AbstractC0299q.m646q(str3, "Failed to mkdirs nmemoFolder path.");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: j */
    public final void mo13550j(int i) {
        if (this.f8560j) {
            super.mo13550j(i);
        }
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: l */
    public final int mo13552l() {
        ArrayList arrayList;
        String str = f8597q;
        AbstractC0299q.m643n(str, "Start update.");
        int iM13655b = AbstractC12022c.m13655b();
        this.f8558h = iM13655b;
        int i = 0;
        if (iM13655b == 8) {
            return 0;
        }
        try {
            AbstractC0147e.f419a.getClass();
            List listNMemoGetMemoMetaData = C0322h.m670a().f823i.NMemoGetMemoMetaData(C0322h.m670a().f823i.createNMemoConverter(AbstractC0155m.m387b(C0148f.m349b(), "memo.db"), "SDocData/NMEMO/app_attach"));
            if (listNMemoGetMemoMetaData != null) {
                Iterator it = listNMemoGetMemoMetaData.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    arrayList = this.f8561k;
                    if (!zHasNext) {
                        break;
                    }
                    MemoMetaDataItem memoMetaDataItem = (MemoMetaDataItem) it.next();
                    AbstractC0299q.m643n(str, "Category Name : " + memoMetaDataItem.getCategoryName() + ", Order : " + memoMetaDataItem.getCategoryOrder());
                    ImportItem importItem = new ImportItem(11, memoMetaDataItem.getCategoryName(), memoMetaDataItem.getContent(), Long.parseLong(memoMetaDataItem.getLastModifiedAt()), memoMetaDataItem.getUuid());
                    importItem.setTitle(memoMetaDataItem.getTitle());
                    importItem.setDownloadCompleted(true);
                    importItem.setExtraObject(memoMetaDataItem);
                    arrayList.add(importItem);
                }
                AbstractC0299q.m643n(str, "End getMemoData. size : " + arrayList.size());
            }
        } catch (Exception e) {
            AbstractC6670b.m4762w(e, new StringBuilder("Exception decryptAndUnzipToNMemo "), str);
            i = -1;
            m13551k(-1, 16);
        }
        AbstractC0299q.m643n(str, "Finish update. result : " + i);
        return i;
    }

    /* JADX INFO: renamed from: m */
    public final boolean m13582m() throws IOException {
        File file = new File(AbstractC0155m.m387b(this.f8598p, "widgetPref.xml"));
        boolean zExists = file.exists();
        String str = f8597q;
        if (!zExists) {
            AbstractC0299q.m643n(str, "widgetPrefXml not exists.");
            return false;
        }
        AbstractC0299q.m643n(str, "widgetPrefXml exists.");
        List listNMemoGetMemoMetaData = C0322h.m670a().f823i.NMemoGetMemoMetaData(C0322h.m670a().f823i.createNMemoConverter("memo.db", "SDocData/NMEMO/app_attach"));
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, InternalZipConstants.CHARSET_UTF8));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        bufferedReader.close();
                        fileInputStream.close();
                        return true;
                    }
                    sb.append(line);
                    sb.append('\n');
                    if (line.contains("<string name=\"widgetID")) {
                        String string = sb.toString();
                        String strSubstring = string.substring(string.indexOf("<string name=\"widgetID") + 22, string.indexOf("\">"));
                        AbstractC0299q.m643n(str, "parseWidgetXML widgetID " + strSubstring);
                        String strSubstring2 = string.substring(string.indexOf("\">") + 2, string.indexOf("</string>"));
                        AbstractC0299q.m643n(str, "parseWidgetXML widgetUuid " + strSubstring2);
                        if (listNMemoGetMemoMetaData != null) {
                            Iterator it = listNMemoGetMemoMetaData.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    MemoMetaDataItem memoMetaDataItem = (MemoMetaDataItem) it.next();
                                    if (memoMetaDataItem.getUuid().equals(strSubstring2)) {
                                        ImportItem importItem = new ImportItem(11, memoMetaDataItem.getCategoryName(), memoMetaDataItem.getContent(), Long.parseLong(memoMetaDataItem.getLastModifiedAt()), memoMetaDataItem.getUuid());
                                        importItem.setTitle(memoMetaDataItem.getTitle());
                                        importItem.setDownloadCompleted(true);
                                        importItem.setExtraObject(memoMetaDataItem);
                                        importItem.setWidgetID(Integer.parseInt(strSubstring));
                                        this.f8561k.add(importItem);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    sb.replace(0, sb.length(), "");
                }
            } finally {
            }
        } finally {
        }
    }
}
