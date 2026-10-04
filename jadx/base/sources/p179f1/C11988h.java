package p179f1;

import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.crypto.CipherInputStream;
import p042J1.AbstractC0147e;
import p042J1.AbstractC0155m;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p176e1.AbstractC11975a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: f1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11988h extends AbstractC11975a {

    /* JADX INFO: renamed from: p */
    public static final String f8602p = "SS$".concat("RestoreTMemoTask");

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: a */
    public final void mo13544a() {
        AbstractC0299q.m643n(f8602p, "clear.");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: c */
    public final int mo13545c() throws Throwable {
        BufferedInputStream bufferedInputStream;
        CipherInputStream cipherInputStreamM15150j;
        byte[] bArr;
        String str = f8602p;
        AbstractC0299q.m643n(str, "Start decryptAndUnzip.");
        String str2 = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        String strM387b = AbstractC0155m.m387b(C0148f.f421l, "TMemo_rename.exml");
        String strM387b2 = AbstractC0155m.m387b(C0148f.f421l, "TMemo.xml");
        int i = -6;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(strM387b));
                try {
                    cipherInputStreamM15150j = AbstractC14517a.m15150j(this.f8556f, bufferedInputStream, this.f8554d);
                    try {
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cipherInputStreamM15150j = null;
                } catch (Throwable th) {
                    th = th;
                    cipherInputStreamM15150j = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream = null;
            cipherInputStreamM15150j = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            cipherInputStreamM15150j = null;
        }
        if (cipherInputStreamM15150j == null) {
            AbstractC0299q.m646q(str, "InputStream is null.");
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13542d(new File(strM387b), "encryptedFile");
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            return -6;
        }
        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(strM387b2));
        try {
            bArr = new byte[10240];
        } catch (Exception e5) {
            e = e5;
            bufferedOutputStream = bufferedOutputStream2;
            AbstractC0299q.m643n(str, "Exception encryptedTMemo " + e.getMessage());
            AbstractC11975a.m13542d(new File(strM387b), "encryptedFile");
            AbstractC11975a.m13541b(bufferedOutputStream);
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = bufferedOutputStream2;
            AbstractC11975a.m13542d(new File(strM387b), "encryptedFile");
            AbstractC11975a.m13541b(bufferedOutputStream);
            AbstractC11975a.m13541b(bufferedInputStream);
            AbstractC11975a.m13541b(cipherInputStreamM15150j);
            throw th;
        }
        while (true) {
            int i2 = cipherInputStreamM15150j.read(bArr, 0, 10240);
            if (i2 == -1) {
                break;
            }
            bufferedOutputStream2.write(bArr, 0, i2);
            AbstractC0299q.m643n(str, "Finish decryptAndUnzip. result : " + i);
            return i;
        }
        AbstractC11975a.m13541b(bufferedInputStream);
        AbstractC11975a.m13541b(cipherInputStreamM15150j);
        AbstractC11975a.m13541b(bufferedOutputStream2);
        ArrayList<MemoMetaDataItem> arrayListTMemoGetMemoMetaDataArray = C0322h.m670a().f823i.TMemoGetMemoMetaDataArray(C0322h.m670a().f823i.createTMemoConverter(), C0322h.m670a().f815a.getAppContext(), strM387b2);
        if (arrayListTMemoGetMemoMetaDataArray != null) {
            AbstractC0299q.m643n(str, "TMemo item count : " + arrayListTMemoGetMemoMetaDataArray.size());
            for (MemoMetaDataItem memoMetaDataItem : arrayListTMemoGetMemoMetaDataArray) {
                ImportItem importItem = new ImportItem(32);
                importItem.setTitle(memoMetaDataItem.getTitle());
                importItem.setDownloadCompleted(true);
                importItem.setExtraObject(memoMetaDataItem);
                this.f8561k.add(importItem);
            }
        }
        AbstractC11975a.m13542d(new File(strM387b), "encryptedFile");
        AbstractC11975a.m13541b(bufferedOutputStream2);
        AbstractC11975a.m13541b(bufferedInputStream);
        AbstractC11975a.m13541b(cipherInputStreamM15150j);
        i = 0;
        AbstractC0299q.m643n(str, "Finish decryptAndUnzip. result : " + i);
        return i;
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: i */
    public final void mo13549i() {
        AbstractC0299q.m643n(f8602p, "prepare.");
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: l */
    public final int mo13552l() {
        return 0;
    }
}
