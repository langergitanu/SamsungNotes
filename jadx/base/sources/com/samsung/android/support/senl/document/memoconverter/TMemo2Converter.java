package com.samsung.android.support.senl.document.memoconverter;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenInvalidPasswordException;
import com.samsung.android.support.senl.document.SDoc;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.delegator.AppDelegator;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.delegator.DocumentSaveSDoc;
import com.samsung.android.support.senl.document.memoconverter.core.Converter;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.document.memoconverter.core.SNoteConverter;
import com.samsung.android.support.senl.document.memoconverter.xml.XMLParser;
import com.samsung.android.support.senl.document.util.SDocUtil;
import java.io.File;
import java.util.Date;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class TMemo2Converter {
    public static final int ERROR_CODE_EXCEPTION = -1;
    public static final int ERROR_CODE_NOT_SUPPORTED = -2;
    public static final int ERROR_CODE_NO_FREE_SPACE = -4;
    public static final int ERROR_CODE_PROCESS_STOPPED = -5;
    public static final int ERROR_CODE_WRONG_PWD = -3;
    private static final String TAG = "TMemo2Converter";
    private Context mContext;
    private FinishListener mFinishListener = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CoreData {
        String cTime;
        String content;
        String mTime;
        String title;

        private CoreData() {
            this.title = "";
            this.content = "";
            this.cTime = "";
            this.mTime = "";
        }
    }

    public TMemo2Converter(Context context) {
        this.mContext = context;
        DocumentLogger.m7178d(TAG, "TMemo2Converter()");
    }

    private static void deleteFileItem(File file) {
        File[] fileArrListFiles;
        if (file != null) {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    deleteFileItem(file2);
                }
            }
            file.delete();
        }
    }

    private int getCoreData(String str, String str2, CoreData coreData) throws Throwable {
        String strM756B = AbstractC0541b.m756B(str, ConverterUtils.getTitle(str));
        File file = new File(strM756B);
        file.mkdir();
        int iUnzip = unzip(str, strM756B, str2);
        if (iUnzip != 0) {
            deleteFileItem(file);
            StringBuilder sbM778t = AbstractC0541b.m778t(iUnzip, "convertToSDoc : Fail unzip: ", "/");
            sbM778t.append(SDocUtil.logPath(str));
            DocumentLogger.m7181i(TAG, sbM778t.toString());
            return iUnzip;
        }
        XMLParser.getInstance().parseXMLContent(strM756B);
        XMLParser.getInstance().parseXMLSettings(strM756B);
        String content = XMLParser.getInstance().getContent();
        String templateType = XMLParser.getInstance().getTemplateType();
        long createdTime = XMLParser.getInstance().getCreatedTime();
        long modifiedTime = XMLParser.getInstance().getModifiedTime();
        if (createdTime <= 0) {
            DocumentLogger.m7179e(TAG, "No created Time!!");
            createdTime = new Date().getTime();
            modifiedTime = createdTime;
        }
        deleteFileItem(file);
        if (!templateType.equals("14")) {
            DocumentLogger.m7181i(TAG, "convertToSDoc : not supported template Type : ".concat(templateType));
            return -2;
        }
        coreData.content = ConverterUtils.handleNewLines("<p>" + content + "</p>").toString();
        coreData.cTime = AbstractC0622a.m1169o("", createdTime);
        coreData.mTime = AbstractC0622a.m1169o("", modifiedTime);
        return iUnzip;
    }

    private int unzip(String str, String str2, String str3) throws Throwable {
        try {
            ZipFile zipFile = new ZipFile(str);
            if (!zipFile.isEncrypted()) {
                zipFile.extractAll(str2);
                return 0;
            }
            if (str3 == null || str3.isEmpty()) {
                return -3;
            }
            zipFile.setPassword(str3);
            zipFile.extractAll(str2);
            return 0;
        } catch (ZipException e) {
            DocumentLogger.m7180e(TAG, "Exception during unzip: file is locked, corrupted or there is not enough space to extract.", e);
            if (e.getMessage().contains("Wrong Password")) {
                return -3;
            }
            return e.getMessage().contains("ENOSPC") ? -4 : -1;
        }
    }

    public int convertToSDoc(String str) {
        if (str == null) {
            DocumentLogger.m7179e(TAG, "snbPath is null");
            return -1;
        }
        if (!isLocked(str)) {
            return convertToSDoc(str, null);
        }
        long time = new Date().getTime();
        return SNoteConverter.saveLockFile(this.mContext, str, time, time, false, AppDelegator.getInstance().getLockTypeTMEMO(), null) != null ? 0 : -1;
    }

    public MemoMetaDataItem getMemoMetaData(String str, String str2) {
        if (str == null) {
            DocumentLogger.m7181i(TAG, "getMemoMetaData() - snbPath is null");
            return null;
        }
        if (!AbstractC2322a.m1607A(str)) {
            DocumentLogger.m7181i(TAG, "getMemoMetaData() - snbFile is not existed");
            return null;
        }
        CoreData coreData = new CoreData();
        if (getCoreData(str, str2, coreData) != 0) {
            DocumentLogger.m7181i(TAG, "Fail to get the memo meta data");
            return null;
        }
        MemoMetaDataItem memoMetaDataItem = new MemoMetaDataItem();
        memoMetaDataItem.setTitle(coreData.title);
        memoMetaDataItem.setCategoryName(null);
        memoMetaDataItem.setContent(coreData.content);
        memoMetaDataItem.setHasImage(false);
        memoMetaDataItem.setImageFile(null);
        memoMetaDataItem.setHasVoice(false);
        memoMetaDataItem.setIsFavorite(false);
        memoMetaDataItem.setLastModifiedAt("" + coreData.mTime);
        return memoMetaDataItem;
    }

    public boolean isLocked(String str) {
        try {
            return new ZipFile(str).isEncrypted();
        } catch (ZipException e) {
            DocumentLogger.m7180e(TAG, "Exception during isLocked(): ", e);
            return false;
        }
    }

    public boolean isRightPassword(String str, String str2) {
        DocumentLogger.m7181i(TAG, "isRightPassword : " + SDocUtil.logPath(str));
        String strM756B = AbstractC0541b.m756B(str, ConverterUtils.getTitle(str));
        File file = new File(strM756B);
        boolean z = false;
        if (!file.mkdir()) {
            DocumentLogger.m7179e(TAG, "isRightPassword() : Can't make directory( " + file + " )");
            return false;
        }
        try {
            try {
                ZipFile zipFile = new ZipFile(str);
                if (!zipFile.isEncrypted()) {
                    DocumentLogger.m7181i(TAG, "isRightPassword() It's unlocked");
                } else {
                    if (str2 == null || str2.isEmpty()) {
                        DocumentLogger.m7179e(TAG, "isRightPassword() Password is empty");
                        deleteFileItem(file);
                        return z;
                    }
                    zipFile.setPassword(str2);
                    zipFile.extractAll(strM756B);
                }
                z = true;
                deleteFileItem(file);
                return z;
            } catch (ZipException e) {
                DocumentLogger.m7180e(TAG, "Exception during unzip: file is locked, corrupted or there is not enough space to extract.", e);
                boolean z2 = !e.getMessage().contains("Wrong Password");
                deleteFileItem(file);
                return z2;
            }
        } catch (Throwable th) {
            deleteFileItem(file);
            throw th;
        }
    }

    public void setFinishListener(FinishListener finishListener) {
        this.mFinishListener = finishListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.samsung.android.support.senl.document.memoconverter.TMemo2Converter$1] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public void unlockTMEMO(String str, String str2, boolean z) throws Throwable {
        DocumentLogger.m7181i(TAG, "unlockTMEMO start : " + SDocUtil.logPath(str));
        String str3 = 0;
        str3 = 0;
        if (str == null) {
            DocumentLogger.m7179e(TAG, "unlockTMEMO : docUuid is null");
            FinishListener finishListener = this.mFinishListener;
            if (finishListener != null) {
                finishListener.onFinish(null, null, false);
            }
        }
        try {
            SDoc sDoc = new SDoc(this.mContext, str, null);
            String filePath = sDoc.getFilePath(0);
            if (filePath == null) {
                DocumentLogger.m7179e(TAG, "unlockTMEMO : snbPath is null");
                FinishListener finishListener2 = this.mFinishListener;
                if (finishListener2 != null) {
                    finishListener2.onFinish(null, null, false);
                    return;
                }
                return;
            }
            if (!isLocked(filePath)) {
                DocumentLogger.m7179e(TAG, "unlockTMEMO : snbPath is unlocked");
                FinishListener finishListener3 = this.mFinishListener;
                if (finishListener3 != null) {
                    finishListener3.onFinish(null, null, false);
                    return;
                }
                return;
            }
            String sDocUUID = AppDelegator.getInstance().getSDocUUID(this.mContext, str);
            CoreData coreData = new CoreData();
            getCoreData(filePath, str2, coreData);
            Converter.SDocData sDocData = new Converter.SDocData();
            sDocData.uuid = sDocUUID;
            sDocData.title = coreData.title;
            sDocData.content = coreData.content;
            sDocData.lastModifiedAt = coreData.mTime;
            sDocData.createdAt = coreData.cTime;
            String strCreateSDoc = Converter.createSDoc(this.mContext, sDocData, null, str);
            Converter.SDocDBData sDocDBData = new Converter.SDocDBData();
            sDocDBData.strippedContent = sDocData.content;
            sDocDBData.lastModifiedTime = sDocData.lastModifiedAt;
            sDoc.release(0);
            String strNewUUID = sDocUUID == null ? AppDelegator.getInstance().newUUID(this.mContext) : sDocUUID;
            boolean z2 = !AppDelegator.getInstance().isExistingNote(this.mContext, strNewUUID);
            String str4 = sDocDBData.category;
            if (str4 != null && str4.length() > 0) {
                str3 = sDocDBData.category;
            }
            if (z) {
                sDoc.setDocumentType(1);
            } else {
                sDoc.setDocumentType(0);
            }
            sDoc.save(strCreateSDoc, Long.parseLong(sDocData.createdAt), Long.parseLong(sDocData.lastModifiedAt));
            sDoc.close();
            DocumentSaveSDoc.saveSDoc(this.mContext, DocumentSaveSDoc.createBuilderInstance().setUuid(strNewUUID).setDocFilePath(strCreateSDoc).setCategoryUuid(str3).setSaveDoc(false).setNew(z2));
            AppDelegator.getInstance().setNoteLock(this.mContext, strNewUUID, z);
            if (sDocDBData.favorite != null) {
                AppDelegator.getInstance().setNoteFavorite(this.mContext, strNewUUID, sDocDBData.favorite.compareTo("1") == 0);
            }
            FinishListener finishListener4 = this.mFinishListener;
            if (finishListener4 != null) {
                finishListener4.onFinish(filePath, sDocUUID, true);
            }
        } catch (Exception e) {
            if (e instanceof SpenInvalidPasswordException) {
                throw new SpenInvalidPasswordException("invalid password");
            }
            DocumentLogger.m7179e(TAG, "unlockTMEMO fail " + e);
        }
    }

    private int convertToSDoc(String str, String str2) throws Throwable {
        CoreData coreData = new CoreData();
        int coreData2 = getCoreData(str, str2, coreData);
        if (coreData2 != 0) {
            DocumentLogger.m7181i(TAG, "Fail to get the memo meta data");
            if (coreData2 == -3) {
                throw new SpenInvalidPasswordException("ERROR_CODE_WRONG_PWD");
            }
        } else {
            Converter.SDocData sDocData = new Converter.SDocData();
            sDocData.uuid = AppDelegator.getInstance().newUUID(this.mContext);
            sDocData.title = coreData.title;
            sDocData.content = coreData.content;
            sDocData.lastModifiedAt = String.valueOf(coreData.mTime);
            sDocData.createdAt = String.valueOf(coreData.cTime);
            String strCreateSDoc = Converter.createSDoc(this.mContext, sDocData, null, null);
            Converter.SDocDBData sDocDBData = new Converter.SDocDBData();
            sDocDBData.strippedContent = sDocData.content;
            sDocDBData.lastModifiedTime = sDocData.lastModifiedAt;
            String sDocUUID = AppDelegator.getInstance().getSDocUUID(this.mContext, str);
            Converter.updateSDocDB(this.mContext, strCreateSDoc, sDocDBData, sDocUUID);
            FinishListener finishListener = this.mFinishListener;
            if (finishListener != null) {
                finishListener.onFinish(str, sDocUUID, true);
            }
        }
        return coreData2;
    }
}
