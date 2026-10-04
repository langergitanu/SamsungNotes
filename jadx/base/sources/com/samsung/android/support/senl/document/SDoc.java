package com.samsung.android.support.senl.document;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.document.component.SDocComponent;
import com.samsung.android.support.senl.document.component.SDocContent;
import com.samsung.android.support.senl.document.component.SDocDocument;
import com.samsung.android.support.senl.document.component.SDocEndTag;
import com.samsung.android.support.senl.document.component.SDocFileManager;
import com.samsung.android.support.senl.document.component.SDocSearchData;
import com.samsung.android.support.senl.document.data.ContentData;
import com.samsung.android.support.senl.document.data.ReminderData;
import com.samsung.android.support.senl.document.data.SearchData;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.exception.InsufficientStorageException;
import com.samsung.android.support.senl.document.exception.InvalidPasswordException;
import com.samsung.android.support.senl.document.exception.UnsupportedFileException;
import com.samsung.android.support.senl.document.util.FileUtil;
import com.samsung.android.support.senl.document.util.LockUtil;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.document.util.ZipUtil;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class SDoc {
    private static final int CACHE_STATE_EDIT = 1;
    private static final String CACHE_STATE_FILE = "state.dat";
    private static final int CACHE_STATE_NONE = 0;
    private static final int CACHE_STATE_OPEN = 2;
    private static final int COMPONENT_COUNT = 5;
    private static final String SDOC_BACKUP_EXTENSION = ".bak";
    private static final String SPenSDK30 = "SPenSDK30";
    private static final String TAG = "SDoc";
    private SDocComponent[] mComponentArray;
    private ArrayList<ArrayList<String>> mExtraZipFileList;
    private String mFilePath;
    private boolean mIsFirstSave;
    private SDocLocker mLocker;
    private boolean mRestoreUnsavedData;
    private String mRootDocDirPath;
    private SDocContent mSDocContent;
    private SDocDocument mSDocDocument;
    private SDocEndTag mSDocEndTag;
    private SDocFileManager mSDocFileManager;
    private int mSDocMode;
    private SDocSearchData mSDocSearchData;
    private ArrayList<String> mZipFileList;

    public SDoc(Context context) throws Throwable {
        this.mRootDocDirPath = null;
        this.mFilePath = null;
        this.mSDocContent = null;
        this.mSDocDocument = null;
        this.mSDocEndTag = null;
        this.mSDocFileManager = null;
        this.mSDocSearchData = null;
        this.mComponentArray = null;
        this.mZipFileList = null;
        this.mExtraZipFileList = null;
        this.mIsFirstSave = false;
        this.mRestoreUnsavedData = false;
        this.mSDocMode = 0;
        this.mLocker = null;
        DocumentLogger.m7178d(TAG, "SDoc(1) - start!");
        this.mIsFirstSave = true;
        construct(context, null);
        setCacheState(2);
    }

    private void checkCacheDirectory(Context context, String str) throws IOException {
        DocumentLogger.m7178d(TAG, "checkCacheDirectory() - start, fileFullPath = [" + SDocUtil.logPath(str) + "]");
        String rootCacheDirectoryPath = SDocFile.getRootCacheDirectoryPath(context);
        if (rootCacheDirectoryPath == null) {
            throw new IOException("checkCacheDirectory() - rootCacheDirPath is invalid. [null]");
        }
        File file = new File(rootCacheDirectoryPath);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException("checkCacheDirectory() - cannot create root cache directory.");
            }
            File file2 = new File(rootCacheDirectoryPath.concat("/.nomedia"));
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException unused) {
                    throw new IOException("checkCacheDirectory() - cannot create nomedia file.");
                }
            }
        }
        if (str == null) {
            StringBuilder sbM781w = AbstractC0541b.m781w(rootCacheDirectoryPath, "/");
            sbM781w.append(System.currentTimeMillis());
            this.mRootDocDirPath = sbM781w.toString();
        } else {
            StringBuilder sbM781w2 = AbstractC0541b.m781w(rootCacheDirectoryPath, "/");
            sbM781w2.append(SDocFile.convertPathToHashedName(str));
            this.mRootDocDirPath = sbM781w2.toString();
        }
        if (this.mSDocMode > 0) {
            this.mRootDocDirPath += "_" + this.mSDocMode;
        }
        DocumentLogger.m7178d(TAG, "checkCacheDirectory() - cacheDirPath = [" + SDocUtil.logPath(this.mRootDocDirPath) + "]");
        File file3 = new File(this.mRootDocDirPath);
        if (!file3.exists() && !file3.mkdirs()) {
            throw new IOException("checkCacheDirectory() - cannot create current document cache directory.");
        }
    }

    private void construct(Context context, String str) throws IOException {
        checkCacheDirectory(context, str);
        this.mComponentArray = new SDocComponent[5];
        this.mSDocContent = new SDocContent(this.mRootDocDirPath);
        this.mSDocDocument = new SDocDocument(this.mRootDocDirPath);
        this.mSDocEndTag = new SDocEndTag(this.mRootDocDirPath);
        this.mSDocFileManager = new SDocFileManager(this.mRootDocDirPath);
        SDocSearchData sDocSearchData = new SDocSearchData(this.mRootDocDirPath);
        this.mSDocSearchData = sDocSearchData;
        SDocComponent[] sDocComponentArr = this.mComponentArray;
        sDocComponentArr[0] = this.mSDocContent;
        sDocComponentArr[1] = this.mSDocDocument;
        sDocComponentArr[2] = this.mSDocFileManager;
        sDocComponentArr[3] = sDocSearchData;
        sDocComponentArr[4] = this.mSDocEndTag;
        this.mLocker = new SDocLocker(context);
        this.mZipFileList = new ArrayList<>();
        this.mExtraZipFileList = new ArrayList<>();
        String strM1170p = AbstractC0622a.m1170p(this.mRootDocDirPath, "/SPenSDK30", new StringBuilder());
        File file = new File(strM1170p);
        if (file.exists() || file.mkdir()) {
            return;
        }
        DocumentLogger.m7179e(TAG, "Fail to make spen sdk directory. [" + SDocUtil.logPath(strM1170p) + "]");
    }

    private static void discardDirectory(String str, long j) {
        if (str == null) {
            DocumentLogger.m7179e(TAG, "discardDirectory() - dirPath can not be null.");
            return;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            DocumentLogger.m7179e(TAG, "discardDirectory() - dirPath is invalid.");
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            DocumentLogger.m7179e(TAG, "discardDirectory() - child list is null.");
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                discardDirectory(str, j);
            }
            if (file2.lastModified() > j) {
                if (!file2.delete()) {
                    DocumentLogger.m7178d(TAG, "discardDirectory() - fail to delete file. [" + SDocUtil.logPath(file2.toString()) + "]");
                }
                DocumentLogger.m7178d(TAG, "discardDirectory() - [" + SDocUtil.logPath(file2.toString()) + "]");
            }
        }
    }

    private void load(Context context, String str, String str2) throws Throwable {
        boolean z;
        boolean z2;
        DocumentLogger.m7178d(TAG, "load() start! fileFullPath = [" + SDocUtil.logPath(str) + "]");
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("load() file doesn't exist. [")));
        }
        this.mSDocEndTag.parse(str, true);
        if (FileUtil.getAvailableInternalMemorySize() < this.mSDocEndTag.getUncompressedSize()) {
            DocumentLogger.m7181i(TAG, "load() - insufficient storage state, available memory space is  = [" + FileUtil.getAvailableInternalMemorySize() + "]");
            SDocFile.trimCache(context, 524288000);
            if (FileUtil.getAvailableInternalMemorySize() < this.mSDocEndTag.getUncompressedSize()) {
                throw new InsufficientStorageException("load() - internal storage is insufficient to open file.");
            }
        }
        if (this.mSDocEndTag.getDocumentType() == 1) {
            DocumentLogger.m7178d(TAG, "load() - Locked file [" + this.mSDocEndTag.getDocumentType() + "], [" + this.mSDocEndTag.getCurrentFormatVersion() + "], [" + this.mSDocEndTag.isEncrypted() + "]");
            if (str2 == null || !str2.equals(AppDelegator.getInstance().getExtraValueLockConfirmed())) {
                throw new InvalidPasswordException("load() - open locked file without confirmation");
            }
        }
        if (this.mSDocEndTag.isEncrypted()) {
            String str3 = this.mLocker.getUserCode()[0];
            if (str3 == null || str3.isEmpty()) {
                throw new InvalidPasswordException("load() - open locked file with no password");
            }
            String str4 = this.mRootDocDirPath + str.substring(str.lastIndexOf("/"), str.lastIndexOf(Extension.DOT)) + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
            LockUtil.decrypt(str, str4, str3);
            File file2 = new File(str4);
            if (!file2.exists()) {
                throw new InvalidPasswordException("load() - fail to unlock file");
            }
            try {
                new SDocEndTag(null).parse(str4, true);
                this.mSDocEndTag.removeEncryptionInfo();
                file = file2;
                z = true;
            } catch (UnsupportedFileException unused) {
                if (!file2.delete()) {
                    DocumentLogger.m7178d(TAG, "load() - fail to delete temporary file.");
                }
                throw new InvalidPasswordException("load() - decrypt fail. [" + this.mSDocEndTag.getCurrentFormatVersion() + "]");
            }
        } else {
            z = false;
        }
        File file3 = new File(this.mRootDocDirPath);
        if (!file3.exists() && !file3.mkdirs()) {
            throw new IOException(AbstractC6670b.m4743d(this.mRootDocDirPath, "]", new StringBuilder("load() - cannot create current document cache directory. [")));
        }
        if (this.mRestoreUnsavedData) {
            z2 = false;
        } else {
            String strM1170p = AbstractC0622a.m1170p(this.mRootDocDirPath, "/endtag.dat", new StringBuilder());
            DocumentLogger.m7181i(TAG, "load() - check EndTag in cache - [" + SDocUtil.logPath(strM1170p) + "]");
            if (new File(strM1170p).exists()) {
                DocumentLogger.m7181i(TAG, "load() - check EndTag...");
                SDocEndTag sDocEndTag = new SDocEndTag(file3.getPath());
                try {
                    sDocEndTag.readFile();
                    if (this.mSDocEndTag.getModifiedTime() == sDocEndTag.getModifiedTime()) {
                        DocumentLogger.m7181i(TAG, "load() - cache has same time.");
                        z2 = false;
                    }
                } catch (Exception unused2) {
                    DocumentLogger.m7179e(TAG, "load() - can't check cached tag modified time.");
                }
            }
            z2 = true;
        }
        ZipUtil.unzip(file, file3, false, z2);
        if (z && !file.delete()) {
            DocumentLogger.m7178d(TAG, "load() - fail to delete temporary file.");
        }
        for (int i = 0; i < 4; i++) {
            this.mComponentArray[i].readFile();
        }
        DocumentLogger.m7178d(TAG, "load() end, ct = [" + this.mSDocEndTag.getCreatedTime() + "], mt = [" + this.mSDocEndTag.getModifiedTime() + "]");
        StringBuilder sb = new StringBuilder("load() end, file revision = ");
        sb.append(this.mSDocEndTag.getFileRevision());
        DocumentLogger.m7178d(TAG, sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[Catch: IOException -> 0x004e, PHI: r4
      0x0073: PHI (r4v7 java.io.RandomAccessFile) = (r4v6 java.io.RandomAccessFile), (r4v8 java.io.RandomAccessFile) binds: [B:21:0x0071, B:25:0x008d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x004e, blocks: (B:11:0x004a, B:22:0x0073), top: B:42:0x0040 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setCacheState(int i) throws Throwable {
        RandomAccessFile randomAccessFile;
        String strM1170p = AbstractC0622a.m1170p(this.mRootDocDirPath, "/state.dat", new StringBuilder());
        File file = new File(strM1170p);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
                DocumentLogger.m7179e(TAG, "setCacheState() - Fail to create state.dat!! [" + SDocUtil.logPath(strM1170p) + "]");
                return;
            }
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(strM1170p, InternalZipConstants.WRITE_MODE);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    randomAccessFile.writeInt(i);
                    randomAccessFile.close();
                } catch (FileNotFoundException unused2) {
                    randomAccessFile2 = randomAccessFile;
                    DocumentLogger.m7179e(TAG, "setCacheState - Fail to create raf!! [" + SDocUtil.logPath(strM1170p) + "]");
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                } catch (IOException unused3) {
                    randomAccessFile2 = randomAccessFile;
                    DocumentLogger.m7179e(TAG, "setCacheState - Fail to writeInt()!! [" + SDocUtil.logPath(strM1170p) + "]");
                    if (randomAccessFile2 != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused4) {
                            DocumentLogger.m7179e(TAG, "setCacheState() - Fail to close raf.");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused5) {
            } catch (IOException unused6) {
            }
        } catch (IOException unused7) {
            DocumentLogger.m7179e(TAG, "setCacheState() - Fail to close raf.");
        }
    }

    public void addExtraZipFileList(ArrayList<String> arrayList) throws IOException {
        for (String str : arrayList) {
            if (!AbstractC2322a.m1607A(str)) {
                throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("addExtraZipFileList() - file is not exist!! [")));
            }
        }
        if (this.mExtraZipFileList.contains(arrayList)) {
            throw new IllegalArgumentException("addExtraZipFileList() - FilePathList is already contained!!!");
        }
        this.mExtraZipFileList.add(arrayList);
    }

    public int bind(String str) {
        return this.mSDocFileManager.bind(str);
    }

    public void clearBindData() {
        this.mSDocFileManager.clearBindData();
    }

    public void clearExtraZipFileList() {
        this.mExtraZipFileList.clear();
    }

    public void close() throws Throwable {
        DocumentLogger.m7178d(TAG, "close() start!");
        this.mSDocFileManager.close();
        this.mLocker = null;
        if (!this.mIsFirstSave) {
            long dirSize = SDocFile.getDirSize(new File(this.mRootDocDirPath));
            SDocFile.saveCacheSize(this.mRootDocDirPath, dirSize);
            DocumentLogger.m7178d(TAG, "close() - cache size : " + dirSize);
            setCacheState(0);
            return;
        }
        DocumentLogger.m7178d(TAG, "close() - not saved, delete cache directory. [" + SDocUtil.logPath(this.mRootDocDirPath) + "]");
        File file = new File(this.mRootDocDirPath);
        if (file.exists()) {
            FileUtil.deleteFile(file);
        }
    }

    public void discard() throws Throwable {
        DocumentLogger.m7178d(TAG, "discard() start!");
        long modifiedTime = this.mSDocEndTag.getModifiedTime();
        this.mSDocFileManager.discard(modifiedTime);
        discardDirectory(AbstractC0622a.m1170p(this.mRootDocDirPath, "/SPenSDK30", new StringBuilder()), modifiedTime);
        setCacheState(0);
    }

    public String getCachePath() {
        return this.mRootDocDirPath;
    }

    public ArrayList<ContentData> getContentData() {
        return this.mSDocContent.getContentData();
    }

    public long getCreatedTime() {
        return this.mSDocEndTag.getCreatedTime();
    }

    public int getDocumentType() {
        return this.mSDocEndTag.getDocumentType();
    }

    public byte[] getExtraDataByteArray(String str) {
        return this.mSDocDocument.getExtraDataByteArray(str);
    }

    public int getExtraDataInt(String str) {
        return this.mSDocDocument.getExtraDataInt(str);
    }

    public String getExtraDataString(String str) {
        return this.mSDocDocument.getExtraDataString(str);
    }

    public String getFilePath(int i) {
        return this.mSDocFileManager.getFilePath(i);
    }

    public long getModifiedTime() {
        return this.mSDocEndTag.getModifiedTime();
    }

    public ArrayList<ReminderData> getReminderData() {
        return this.mSDocEndTag.getCurrentFormatVersion() < 15 ? this.mSDocDocument.getReminderData() : this.mSDocEndTag.getReminderData();
    }

    public String getRepositoryPath() {
        return this.mSDocFileManager.getRepositoryPath();
    }

    public ArrayList<SearchData> getSearchData() {
        return this.mSDocSearchData.getSearchData();
    }

    public String getTitle() {
        return this.mSDocContent.getTitle();
    }

    public boolean isFavorite() {
        return this.mSDocEndTag.isFavorite();
    }

    public boolean isLocked() {
        return this.mSDocEndTag.getDocumentType() != 0;
    }

    public void lock() {
        DocumentLogger.m7178d(TAG, "lock()");
        if (this.mSDocEndTag.getDocumentType() <= 1) {
            this.mSDocEndTag.setDocumentType(1);
            return;
        }
        throw new IllegalStateException("lock() - invalid document type [" + this.mSDocEndTag.getDocumentType() + "]");
    }

    public void quickSave() throws Throwable {
        DocumentLogger.m7178d(TAG, "quickSave() start!");
        boolean z = false;
        for (int i = 0; i < 4; i++) {
            try {
                SDocComponent sDocComponent = this.mComponentArray[i];
                if (sDocComponent.isChanged()) {
                    sDocComponent.writeFile();
                    z = true;
                }
            } catch (IOException e) {
                for (int i2 = 0; i2 < 4; i2++) {
                    for (String str : this.mComponentArray[i2].getFileNames()) {
                        File file = new File(AbstractC0541b.m756B(str, SDOC_BACKUP_EXTENSION));
                        if (file.exists()) {
                            FileUtil.deleteFile(file);
                        }
                    }
                }
                throw new IOException("quickSave() - Fail to write sub data file. " + e.getMessage());
            }
        }
        for (int i4 = 0; i4 < 4; i4++) {
            for (String str2 : this.mComponentArray[i4].getFileNames()) {
                if (new File(AbstractC0541b.m756B(str2, SDOC_BACKUP_EXTENSION)).exists()) {
                    FileUtil.forceRenameTo(str2 + SDOC_BACKUP_EXTENSION, str2);
                }
            }
        }
        if (z) {
            setCacheState(1);
        }
        DocumentLogger.m7178d(TAG, "quickSave() end");
    }

    public void release(int i) {
        this.mSDocFileManager.release(i);
    }

    public void save(String str) throws Throwable {
        DocumentLogger.m7178d(TAG, "save1() start! fileFullPath = [" + SDocUtil.logPath(str) + "]");
        save(str, false);
    }

    public void setContentData(ArrayList<ContentData> arrayList) {
        this.mSDocContent.setContentData(arrayList);
    }

    public void setCursorPosition(int i) {
        this.mSDocDocument.setCursorPosition(i);
    }

    public void setDocumentType(int i) {
        this.mSDocEndTag.setDocumentType(i);
    }

    public void setExtraDataByteArray(String str, byte[] bArr) {
        this.mSDocDocument.setExtraDataByteArray(str, bArr);
    }

    public void setExtraDataInt(String str, Integer num) {
        this.mSDocDocument.setExtraDataInt(str, num);
    }

    public void setExtraDataString(String str, String str2) {
        this.mSDocDocument.setExtraDataString(str, str2);
    }

    public void setFavorite(boolean z) {
        this.mSDocEndTag.setFavorite(z);
    }

    public void setReminderData(ArrayList<ReminderData> arrayList) {
        this.mSDocEndTag.setReminderData(arrayList);
    }

    public void setSearchData(ArrayList<SearchData> arrayList) {
        this.mSDocSearchData.setSearchData(arrayList);
    }

    public void setTitle(String str) {
        this.mSDocContent.setTitle(str);
        this.mSDocEndTag.setTitle(str);
    }

    public void unlock() {
        DocumentLogger.m7178d(TAG, "unlock()");
        if (this.mSDocEndTag.getDocumentType() <= 1) {
            this.mSDocEndTag.setDocumentType(0);
            return;
        }
        throw new IllegalStateException("unlock() - invalid document type [" + this.mSDocEndTag.getDocumentType() + "]");
    }

    public int bind(int i) {
        return this.mSDocFileManager.bind(i);
    }

    public void release(String str) throws Throwable {
        try {
            this.mSDocFileManager.release(str);
        } catch (Exception e) {
            DocumentLogger.m7180e(TAG, "release() - filePath = [" + SDocUtil.logPath(str) + "]", e);
        }
    }

    public void save(String str, long j, long j2) throws Throwable {
        DocumentLogger.m7178d(TAG, "save2() start! fileFullPath = [" + SDocUtil.logPath(str) + "], created time = [" + j + "], modified time = [" + j2 + "]");
        save(str, false, j, j2);
    }

    public void save(String str, boolean z, long j, long j2) throws Throwable {
        DocumentLogger.m7178d(TAG, "save3() start! fileFullPath = [" + SDocUtil.logPath(str) + "], fixCache = [" + z + "],  created time = [" + j + "], modified time = [" + j2 + "]");
        if (j2 < 0) {
            throw new IllegalArgumentException(AbstractC1974b.m1317j(j2, "save3() - modified time [", "] is invalid."));
        }
        if (j >= 0) {
            this.mSDocEndTag.resetFileRevision();
            this.mSDocEndTag.setModifiedTime(j2);
            this.mSDocEndTag.setCreatedTime(j);
            save(str, z);
            return;
        }
        throw new IllegalArgumentException(AbstractC1974b.m1317j(j, "save3() - createdTime time [", "] is invalid."));
    }

    public SDoc(Context context, String str, String str2) {
        this(context, str, str2, false, 0);
        DocumentLogger.m7178d(TAG, "SDoc(3) end!");
    }

    public SDoc(Context context, String str, String str2, boolean z) {
        this(context, str, str2, z, 0);
        StringBuilder sb = new StringBuilder("SDoc(4) end!, fileFullPath = [");
        sb.append(SDocUtil.logPath(str));
        sb.append("], [");
        sb.append(str2 != null);
        sb.append("], restoreUnsavedData = [");
        sb.append(z);
        sb.append("]");
        DocumentLogger.m7178d(TAG, sb.toString());
    }

    public SDoc(Context context, String str, String str2, int i) {
        this(context, str, str2, false, i);
        StringBuilder sb = new StringBuilder("SDoc(5) end!, fileFullPath = [");
        sb.append(SDocUtil.logPath(str));
        sb.append("], [");
        sb.append(str2 != null);
        sb.append("], mode = [");
        sb.append(i);
        sb.append("]");
        DocumentLogger.m7178d(TAG, sb.toString());
    }

    private SDoc(Context context, String str, String str2, boolean z, int i) throws Throwable {
        this.mRootDocDirPath = null;
        this.mFilePath = null;
        this.mSDocContent = null;
        this.mSDocDocument = null;
        this.mSDocEndTag = null;
        this.mSDocFileManager = null;
        this.mSDocSearchData = null;
        this.mComponentArray = null;
        this.mZipFileList = null;
        this.mExtraZipFileList = null;
        this.mIsFirstSave = false;
        this.mRestoreUnsavedData = false;
        this.mSDocMode = 0;
        this.mLocker = null;
        StringBuilder sb = new StringBuilder("SDoc(0) start!, fileFullPath = [");
        sb.append(SDocUtil.logPath(str));
        sb.append("], [");
        AbstractC2821a.m2208C(sb, str2 != null, "], restoreUnsavedData = [", z, "] mode = [");
        sb.append(i);
        sb.append("]");
        DocumentLogger.m7178d(TAG, sb.toString());
        if (str == null) {
            throw new IOException("SDoc0() - fileFullPath is null");
        }
        if (i >= 0) {
            this.mSDocMode = i;
            File file = new File(str);
            if (!file.exists()) {
                DocumentLogger.m7178d(TAG, "SDoc file is not exist. [" + SDocUtil.logPath(str) + "]");
                String strConcat = str.concat(SDOC_BACKUP_EXTENSION);
                File file2 = new File(strConcat);
                if (file2.exists()) {
                    DocumentLogger.m7178d(TAG, "Find backup file. [" + SDocUtil.logPath(strConcat) + "]");
                    if (!file2.renameTo(file)) {
                        DocumentLogger.m7178d(TAG, "Fail to restore sdoc file. Force open. [" + SDocUtil.logPath(strConcat) + "]");
                        str = strConcat;
                    } else {
                        DocumentLogger.m7178d(TAG, "Success to restore sdoc file. [" + SDocUtil.logPath(str) + "]");
                    }
                }
            }
            construct(context, str);
            if (!file.exists()) {
                DocumentLogger.m7178d(TAG, "Make new file. [" + SDocUtil.logPath(str) + "]");
                this.mIsFirstSave = true;
            } else {
                this.mIsFirstSave = false;
                this.mRestoreUnsavedData = z;
                load(context, str, str2);
            }
            this.mFilePath = str;
            setCacheState(2);
            return;
        }
        throw new IOException("SDoc0() - mode is invalid. mode must be positive number.");
    }

    public void save(String str, boolean z) throws Throwable {
        DocumentLogger.m7178d(TAG, "save4() start! fileFullPath = [" + SDocUtil.logPath(str) + "], fixCache = [" + z + "]");
        save(str, z, true);
    }

    public void save(String str, long j, long j2, boolean z) throws Throwable {
        StringBuilder sb = new StringBuilder("save5() start! fileFullPath = [");
        sb.append(SDocUtil.logPath(str));
        sb.append("], created time = [");
        sb.append(j);
        AbstractC1038a.m1223x(sb, "], modified time = [", j2, "], checkStorage = [");
        sb.append(z);
        sb.append("]");
        DocumentLogger.m7178d(TAG, sb.toString());
        save(str, false, j, j2, z);
    }

    private void save(String str, boolean z, long j, long j2, boolean z2) throws Throwable {
        DocumentLogger.m7178d(TAG, "save0() start! fileFullPath = [" + SDocUtil.logPath(str) + "], fixCache = [" + z + "],  created time = [" + j + "], modified time = [" + j2 + "]");
        if (j2 < 0) {
            throw new IllegalArgumentException(AbstractC1974b.m1317j(j2, "save3() - modified time [", "] is invalid."));
        }
        if (j >= 0) {
            this.mSDocEndTag.resetFileRevision();
            this.mSDocEndTag.setModifiedTime(j2);
            this.mSDocEndTag.setCreatedTime(j);
            save(str, z, z2);
            return;
        }
        throw new IllegalArgumentException(AbstractC1974b.m1317j(j, "save3() - createdTime time [", "] is invalid."));
    }

    private void save(String str, boolean z, boolean z2) throws Throwable {
        DocumentLogger.m7178d(TAG, "save() start! fileFullPath = [" + SDocUtil.logPath(str) + "], fixCache = [" + z + "], checkStorage = [" + z2 + "]");
        String str2 = this.mFilePath;
        if (str2 != null && !str2.equals(str)) {
            this.mSDocEndTag.resetFileRevision();
            if (!z) {
                this.mIsFirstSave = true;
                this.mFilePath = null;
            }
        }
        boolean z3 = false;
        for (int i = 0; i < 4; i++) {
            try {
                SDocComponent sDocComponent = this.mComponentArray[i];
                if (sDocComponent.isChanged() || this.mIsFirstSave) {
                    sDocComponent.writeFile();
                    z3 = true;
                }
            } catch (IOException e) {
                for (SDocComponent sDocComponent2 : this.mComponentArray) {
                    for (String str3 : sDocComponent2.getFileNames()) {
                        File file = new File(AbstractC0541b.m756B(str3, SDOC_BACKUP_EXTENSION));
                        if (file.exists()) {
                            FileUtil.deleteFile(file);
                        }
                    }
                }
                throw new IOException("save() - Fail to write sub data file. " + e.getMessage());
            }
        }
        if (this.mSDocEndTag.isChanged() || z3 || this.mRestoreUnsavedData) {
            this.mSDocEndTag.increaseFileRevision();
            this.mSDocEndTag.writeFile();
        }
        for (SDocComponent sDocComponent3 : this.mComponentArray) {
            for (String str4 : sDocComponent3.getFileNames()) {
                if (new File(AbstractC0541b.m756B(str4, SDOC_BACKUP_EXTENSION)).exists()) {
                    FileUtil.forceRenameTo(str4 + SDOC_BACKUP_EXTENSION, str4);
                }
            }
        }
        this.mZipFileList.clear();
        for (SDocComponent sDocComponent4 : this.mComponentArray) {
            Collections.addAll(this.mZipFileList, sDocComponent4.getFileNames());
        }
        Iterator<String> it = this.mSDocFileManager.getAttachedFileList().iterator();
        while (it.hasNext()) {
            this.mZipFileList.add(it.next());
        }
        Iterator<ArrayList<String>> it2 = this.mExtraZipFileList.iterator();
        while (it2.hasNext()) {
            Iterator<String> it3 = it2.next().iterator();
            while (it3.hasNext()) {
                this.mZipFileList.add(it3.next());
            }
        }
        String str5 = this.mRootDocDirPath + str.substring(str.lastIndexOf("/"), str.lastIndexOf(Extension.DOT)) + "_" + System.currentTimeMillis() + DiskFileUpload.postfix;
        long jZip = ZipUtil.zip(this.mZipFileList, this.mRootDocDirPath, str5);
        this.mSDocEndTag.setUncompressedSize(jZip);
        SDocEndTag sDocEndTag = this.mSDocEndTag;
        sDocEndTag.setCreatedTime(sDocEndTag.getCreatedTime());
        SDocEndTag sDocEndTag2 = this.mSDocEndTag;
        sDocEndTag2.setModifiedTime(sDocEndTag2.getModifiedTime());
        this.mSDocEndTag.writeBytes(str5, true);
        if (this.mSDocEndTag.getDocumentType() == 1) {
            try {
                LockUtil.encrypt(str5, this.mLocker.getUserCode()[0]);
            } catch (Exception unused) {
                throw new IOException("save() - Fail to lock file");
            }
        }
        if (z2) {
            File file2 = new File(str5);
            if (file2.exists() && FileUtil.getAvailableInternalMemorySize() < file2.length() + jZip + 104857600) {
                DocumentLogger.m7178d(TAG, "delete temporary sdoc file, not enough memory for write DB.");
                if (!file2.delete()) {
                    DocumentLogger.m7178d(TAG, "save() - fail to delete temporary file.");
                }
                throw new InsufficientStorageException("No internal memory size for saving database.");
            }
        }
        File file3 = new File(str);
        if (file3.exists()) {
            File file4 = new File(str.concat(SDOC_BACKUP_EXTENSION));
            if (file4.exists()) {
                FileUtil.deleteFile(file4);
            }
            if (file3.renameTo(file4)) {
                File file5 = new File(str5);
                if (file5.exists()) {
                    if (file5.renameTo(file3)) {
                        if (file4.exists()) {
                            FileUtil.deleteFile(file4);
                        }
                    } else {
                        throw new IOException("save() - Fail to rename to output file.");
                    }
                } else {
                    throw new IOException("save() - Fail to find temp file.");
                }
            } else {
                throw new IOException("save() - Fail to rename origin file.");
            }
        } else {
            File file6 = new File(str5);
            if (file6.exists()) {
                if (!file6.renameTo(file3)) {
                    throw new IOException("save() - Fail to rename to output file.");
                }
            } else {
                throw new IOException("save() - Fail to find temp file.");
            }
        }
        if (this.mFilePath == null) {
            String strConvertPathToHashedName = SDocFile.convertPathToHashedName(str);
            String str6 = this.mRootDocDirPath;
            String strM756B = AbstractC0541b.m756B(str6.substring(0, str6.lastIndexOf(47) + 1), strConvertPathToHashedName);
            FileUtil.forceRenameTo(this.mRootDocDirPath, strM756B);
            DocumentLogger.m7178d(TAG, "save() - Change directory [" + SDocUtil.logPath(this.mRootDocDirPath) + "] -> [" + SDocUtil.logPath(strM756B) + "]");
            this.mRootDocDirPath = strM756B;
            if (this.mSDocMode > 0) {
                this.mRootDocDirPath += "_" + this.mSDocMode;
            }
            for (SDocComponent sDocComponent5 : this.mComponentArray) {
                sDocComponent5.changeCacheDir(this.mRootDocDirPath);
            }
        }
        DocumentLogger.m7178d(TAG, "save() file revision = " + this.mSDocEndTag.getFileRevision());
        DocumentLogger.m7178d(TAG, "save() modified time = " + this.mSDocEndTag.getModifiedTime());
        DocumentLogger.m7178d(TAG, "save() created time = " + this.mSDocEndTag.getCreatedTime());
        this.mIsFirstSave = false;
        this.mRestoreUnsavedData = false;
        if (!z) {
            this.mFilePath = str;
        }
        for (SDocComponent sDocComponent6 : this.mComponentArray) {
            sDocComponent6.resetIsChanged();
        }
        setCacheState(2);
        DocumentLogger.m7178d(TAG, "save() end");
    }
}
