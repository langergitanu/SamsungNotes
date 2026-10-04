package com.samsung.android.app.notes.sync.importing.core.types;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.samsung.android.app.notes.sync.constants.DocTypeConstants;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.smartswitchfileshare.Constants;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p001A.AbstractC0000a;
import p005A3.C0016a;
import p042J1.AbstractC0155m;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MemoLocalSync extends ImportBaseTask {
    private static final String PACKAGE_NAME = "com.samsung.android.app.memo";
    public static final String SESSION_KEY = "NMemoImportKEY";
    private static final String TAG = "MemoLocalSync";
    public static final boolean TEST_MODE = false;
    protected boolean mCompletedSuccessfully;
    protected MemoResponseReceiver mReceiver;
    protected final Object mWaitForCompleted;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MemoResponseReceiver extends BroadcastReceiver {
        public MemoResponseReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.sec.android.intent.action.RESPONSE_BACKUP_MEMO".equals(intent.getAction())) {
                MemoLocalSync memoLocalSync = MemoLocalSync.this;
                memoLocalSync.mCompletedSuccessfully = true;
                synchronized (memoLocalSync.mWaitForCompleted) {
                    Debugger.m8607d(MemoLocalSync.TAG, "onReceive() : receive RESPONSE_BACKUP_MEMO!");
                    MemoLocalSync.this.mWaitForCompleted.notify();
                }
            }
        }
    }

    public MemoLocalSync(Context context, ImportBaseTask.Listener listener, int i) {
        super(context, listener, DocTypeConstants.MEMO_LOCAL, i);
        this.mReceiver = new MemoResponseReceiver();
        this.mCompletedSuccessfully = false;
        this.mWaitForCompleted = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.samsung.android.app.notes.sync.importing.core.types.MemoLocalSync] */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r14v9 */
    private void decryptFile(String str, String str2, String str3) throws Throwable {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            Debugger.m8609e(TAG, "folder was not created");
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                str = new FileInputStream(new File((String) str));
                try {
                    str3 = decryptStream(str, str3);
                    if (str3 != 0) {
                        try {
                            fileOutputStream = new FileOutputStream(AbstractC0155m.m387b(str2, "memo.zip"));
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            byte[] bArr = new byte[16384];
                            while (true) {
                                int i = str3.read(bArr, 0, 16384);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            }
                            File file2 = new File(str2);
                            File file3 = new File(str2 + "memo.zip");
                            if (file3.exists()) {
                                C0322h.m670a().f816b.unzip(file3, file2, false, true);
                            } else {
                                Debugger.m8609e(TAG, "no memo.zip");
                            }
                            fileOutputStream2 = fileOutputStream;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream2 = fileOutputStream;
                            Debugger.m8609e(TAG, "decryptFile() - Exception " + e.getMessage());
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                    AbstractC0000a.m20q(e3, new StringBuilder("decryptFile, IOException, closing, newFos : "), TAG);
                                }
                            }
                            if (str3 != 0) {
                                try {
                                    str3.close();
                                } catch (IOException e5) {
                                    AbstractC0000a.m20q(e5, new StringBuilder("decryptFile. IOException, closing, is : "), TAG);
                                }
                            }
                            if (str != 0) {
                                try {
                                    str.close();
                                    return;
                                } catch (IOException e6) {
                                    e = e6;
                                    sb = new StringBuilder("decryptFile, IOException, closing, is : ");
                                    AbstractC0000a.m20q(e, sb, TAG);
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e7) {
                                    AbstractC0000a.m20q(e7, new StringBuilder("decryptFile, IOException, closing, newFos : "), TAG);
                                }
                            }
                            if (str3 != 0) {
                                try {
                                    str3.close();
                                } catch (IOException e8) {
                                    AbstractC0000a.m20q(e8, new StringBuilder("decryptFile. IOException, closing, is : "), TAG);
                                }
                            }
                            if (str == 0) {
                                throw th;
                            }
                            try {
                                str.close();
                                throw th;
                            } catch (IOException e9) {
                                AbstractC0000a.m20q(e9, new StringBuilder("decryptFile, IOException, closing, is : "), TAG);
                                throw th;
                            }
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e10) {
                            AbstractC0000a.m20q(e10, new StringBuilder("decryptFile, IOException, closing, newFos : "), TAG);
                        }
                    }
                    if (str3 != 0) {
                        try {
                            str3.close();
                        } catch (IOException e11) {
                            AbstractC0000a.m20q(e11, new StringBuilder("decryptFile. IOException, closing, is : "), TAG);
                        }
                    }
                    try {
                        str.close();
                    } catch (IOException e12) {
                        e = e12;
                        sb = new StringBuilder("decryptFile, IOException, closing, is : ");
                        AbstractC0000a.m20q(e, sb, TAG);
                    }
                } catch (Exception e13) {
                    e = e13;
                    str3 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str3 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e14) {
            e = e14;
            str = 0;
            str3 = 0;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
            str3 = 0;
        }
    }

    @Nullable
    private InputStream decryptStream(InputStream inputStream, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] bArr = new byte[cipher.getBlockSize()];
        if (inputStream.read(bArr) <= 0) {
            Debugger.m8609e(TAG, "decryptStream read fail");
            return null;
        }
        cipher.init(2, generateSHA256SecretKey(str), new IvParameterSpec(bArr));
        return new CipherInputStream(inputStream, cipher);
    }

    private SecretKeySpec generateSHA256SecretKey(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        byte[] bArr = new byte[16];
        System.arraycopy(messageDigest.digest(), 0, bArr, 0, 16);
        return new SecretKeySpec(bArr, AES256KeyLoader.AES_ALGORITHM);
    }

    private Intent getIntentForNMemoBackup(String str, String str2, boolean z) {
        Intent intent = new Intent("com.sec.android.intent.action.REQUEST_BACKUP_MEMO");
        intent.putExtra(Constants.SAVE_PATH_EXTRAS, str);
        intent.setPackage("com.samsung.android.app.memo");
        if (z) {
            intent.putExtra("ACTION", 0);
        } else {
            intent.putExtra("ACTION", 2);
        }
        intent.putExtra("SESSION_KEY", str2);
        intent.putExtra("SOURCE", "Notes");
        intent.putExtra("SECURITY_LEVEL", 0);
        return intent;
    }

    public static boolean isAppInstalled(Context context) {
        return CommonUtils.isPackageInstalledAndEnabled(context, "com.samsung.android.app.memo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyDirectory$1(File file, String[] strArr, File file2, int i) {
        try {
            copyDirectory(new File(file, strArr[i]), new File(file2, strArr[i].toLowerCase(Locale.getDefault())));
        } catch (IOException e) {
            AbstractC0000a.m20q(e, new StringBuilder("copyDirectory: IOException] "), TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getImportItems$0(ImportItem importItem, ImportItem importItem2) {
        String categoryOrder = importItem.getCategoryOrder();
        String categoryOrder2 = importItem2.getCategoryOrder();
        return Integer.compare(categoryOrder == null ? 65535 : Integer.parseInt(categoryOrder), categoryOrder2 != null ? Integer.parseInt(categoryOrder2) : 65535);
    }

    public void copyDirectory(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists() && !file2.mkdirs()) {
                throw new IOException("Can't create dir " + file2.getAbsolutePath());
            }
            String[] list = file.list();
            if (list != null) {
                IntStream.range(0, list.length).parallel().forEach(new C6775a(this, file, list, file2));
                return;
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Cannot create dir " + parentFile.getAbsolutePath());
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            fileOutputStream.close();
                            fileInputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            Debugger.m8609e(TAG, "Exception : copyDirectory() failed!");
            Debugger.m8609e(TAG, e.toString());
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void getImportItems() throws Throwable {
        Debugger.m8615i(TAG, "getImportItems() start");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (isAppInstalled(this.mContext)) {
            List<ImportItem> listLoadList = loadList();
            this.mResultList = listLoadList;
            listLoadList.sort(new C0016a(8));
            if (this.mListener != null) {
                int size = this.mResultList.size();
                int i = 0;
                while (i < size) {
                    ImportItem importItem = this.mResultList.get(i);
                    i++;
                    this.mListener.onUpdated(DocTypeConstants.MEMO_LOCAL, i, size, importItem);
                }
            }
        }
        if (this.mResultList == null) {
            Debugger.m8615i(TAG, "getImportItems(null) - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            return;
        }
        Debugger.m8615i(TAG, "getImportItems finish(" + this.mResultList.size() + ") - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " , size : " + this.mResultList.size());
    }

    public void importItems(List<ImportItem> list) throws Throwable {
        Debugger.m8615i(TAG, "startImport()[" + hashCode() + "]" + list.size());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ImportBaseTask.Listener listener = this.mListener;
        if (listener != null) {
            listener.onDownloaded(DocTypeConstants.MEMO_LOCAL, null, 1);
        }
        String absolutePath = this.mContext.getFilesDir().getAbsolutePath();
        String strSubstring = absolutePath.substring(0, absolutePath.lastIndexOf(47));
        String strM756B = AbstractC0541b.m756B(strSubstring, "/databases/memoimport.db");
        String strM756B2 = AbstractC0541b.m756B(strSubstring, "/databases/memoimport_org.db");
        File file = new File(strM756B);
        File file2 = new File(strM756B2);
        try {
            Debugger.m8615i(TAG, "Copy orgLocalDB to localDB!");
            AbstractC0155m.m388c(file2, file);
        } catch (IOException e) {
            Debugger.m8609e(TAG, e.getMessage());
            strM756B = strSubstring + "/databases/memoimport_org.db";
            Debugger.m8615i(TAG, "change localDBPath to orgLocalDBPath!");
        }
        Object objCreateNMemoConverter = C0322h.m670a().f823i.createNMemoConverter(strM756B, "files/NMemoImport");
        int size = list.size();
        for (int i = 0; i < size && !isCancelled(); i++) {
            if (!AbstractC0155m.m401p()) {
                throw new SyncException(323, "device storage is full!");
            }
            ImportItem importItem = list.get(i);
            try {
                ImportBaseTask.Listener listener2 = this.mListener;
                if (listener2 != null) {
                    listener2.onDownloaded(DocTypeConstants.MEMO_LOCAL, importItem, 1);
                }
                Debugger.m8615i(TAG, "convert " + (i + 1) + " / " + size);
                C0322h.m670a().f823i.NMemoConvertToSDoc(objCreateNMemoConverter, false, importItem.getServerKey(), C0322h.m670a().f823i.getNMemoValueConvertModeNormal());
                Debugger.m8615i(TAG, "succeed to convert");
                this.mSuccessfulList.add(importItem);
            } catch (Exception e2) {
                AbstractC0000a.m21r(e2, new StringBuilder("importItems() : "), TAG);
            }
        }
        if (file.exists() && !file.delete()) {
            Debugger.m8609e(TAG, "localDBFile.delete() fail");
        }
        Debugger.m8615i(TAG, "finish startImport()[" + hashCode() + "] - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
    }

    public List<ImportItem> loadList() throws Throwable {
        ArrayList arrayList = new ArrayList();
        String str = AbstractC0155m.m390e(this.mContext) + "/NMemoBackup/";
        File file = new File(str);
        String strM756B = AbstractC0541b.m756B(str, "memo.bk");
        File file2 = new File(strM756B);
        if (file2.exists()) {
            Debugger.m8607d(TAG, "try to delete memo.bk");
            if (!file2.delete()) {
                Debugger.m8609e(TAG, "memoBkFile.delete() failed");
            }
        }
        if (!file.exists()) {
            Debugger.m8607d(TAG, "try to create the NMemoBackup folder");
            if (!file.mkdirs()) {
                Debugger.m8609e(TAG, "localSavePathFile.mkdirs() failed");
            }
        }
        try {
            synchronized (this.mWaitForCompleted) {
                try {
                    this.mContext.registerReceiver(this.mReceiver, new IntentFilter("com.sec.android.intent.action.RESPONSE_BACKUP_MEMO"));
                    Intent intentForNMemoBackup = getIntentForNMemoBackup(str, SESSION_KEY, true);
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (i >= 3) {
                            break;
                        }
                        Debugger.m8607d(TAG, "loadList() : send a req intent to the Memo app : " + i2);
                        this.mContext.sendBroadcast(intentForNMemoBackup);
                        this.mWaitForCompleted.wait((long) (1800000 * i2));
                        if (this.mCompletedSuccessfully) {
                            break;
                        }
                        i = i2;
                    }
                } finally {
                }
            }
        } catch (InterruptedException e) {
            Debugger.m8609e(TAG, "NMemoBackup " + e.getMessage());
        }
        this.mContext.unregisterReceiver(this.mReceiver);
        if (!this.mCompletedSuccessfully) {
            Debugger.m8609e(TAG, "loadList() : fail to get the backup data from Memo!");
            return arrayList;
        }
        Debugger.m8615i(TAG, "loadList() : succeed to get the backup data from Memo");
        if (new File(strM756B).exists()) {
            Debugger.m8615i(TAG, "loadList() : decryptFile");
            decryptFile(strM756B, str, SESSION_KEY);
            String strM392g = AbstractC0155m.m392g(this.mContext);
            String strM756B2 = AbstractC0541b.m756B(strM392g.substring(0, strM392g.lastIndexOf(47)), "/databases/memoimport_org.db");
            File file3 = new File(AbstractC0155m.m392g(this.mContext) + "/NMemoImport/");
            File file4 = new File(AbstractC0541b.m756B(str, "memo.db"));
            File file5 = new File(AbstractC0541b.m756B(str, com.samsung.android.support.senl.p148nt.base.common.constants.Constants.DOCUMENT_ATTACHMENT_DIR_NAME));
            File file6 = new File(strM756B2);
            try {
                Debugger.m8615i(TAG, "loadList() : copy the db file");
                AbstractC0155m.m388c(file4, file6);
                if (file5.exists()) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    copyDirectory(file5, file3);
                    Debugger.m8615i(TAG, "Finish to copyDirectory() - elapsed time : " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                }
                Debugger.m8615i(TAG, "loadList() : start to NMemoConverter");
                List listNMemoGetMemoMetaData = C0322h.m670a().f823i.NMemoGetMemoMetaData(C0322h.m670a().f823i.createNMemoConverter(strM756B2, "files/NMemoImport"));
                if (listNMemoGetMemoMetaData != null) {
                    Debugger.m8615i(TAG, "loadList() : start to add importItem : " + listNMemoGetMemoMetaData.size());
                    int size = listNMemoGetMemoMetaData.size();
                    for (int i4 = 0; i4 < size && !isCancelled(); i4++) {
                        MemoMetaDataItem memoMetaDataItem = (MemoMetaDataItem) listNMemoGetMemoMetaData.get(i4);
                        ImportItem importItem = new ImportItem(11, memoMetaDataItem.getCategoryName(), memoMetaDataItem.getContent(), Long.parseLong(memoMetaDataItem.getLastModifiedAt()), memoMetaDataItem.getUuid());
                        importItem.setTitle(memoMetaDataItem.getTitle());
                        importItem.setDownloadCompleted(true);
                        importItem.setExtraObject(memoMetaDataItem);
                        importItem.setCategoryOrder(memoMetaDataItem.getCategoryOrder());
                        arrayList.add(importItem);
                    }
                }
                Debugger.m8615i(TAG, "loadList() : finish loadList");
            } catch (IOException e2) {
                Debugger.m8609e(TAG, e2.getMessage());
            }
        } else {
            Debugger.m8609e(TAG, "loadList() : there is no memo.bk");
        }
        return arrayList;
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void startImport() throws Throwable {
        Debugger.m8615i(TAG, "startImport()");
        importItems(this.mImportList);
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public void stop() {
        Debugger.m8615i(TAG, "stop()");
        super.stop();
        this.mContext.sendBroadcast(getIntentForNMemoBackup(AbstractC0155m.m390e(this.mContext) + "/NMemoBackup/", SESSION_KEY, false));
        synchronized (this.mWaitForCompleted) {
            this.mWaitForCompleted.notify();
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.core.tasks.ImportBaseTask
    public int syncProgress() {
        return 0;
    }

    public MemoLocalSync(Context context, ImportBaseTask.Listener listener, int i, List<ImportItem> list) {
        super(context, listener, DocTypeConstants.MEMO_LOCAL, i);
        this.mReceiver = new MemoResponseReceiver();
        this.mCompletedSuccessfully = false;
        this.mWaitForCompleted = new Object();
        this.mImportList = list;
    }
}
