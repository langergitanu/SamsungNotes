package com.samsung.android.support.senl.document.delegator;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.Spanned;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.reflect.DocumentDataContractImpl;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentWeb;
import com.samsung.android.support.senl.document.contract.DocumentContract;
import com.samsung.android.support.senl.document.contract.DocumentDataContract;
import com.samsung.android.support.senl.document.contract.DocumentSaveParamBuilder;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.p148nt.composer.reflect.DocumentContractImpl;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class AppDelegator {
    private static AppDelegator mInstance;
    private DocumentContract mContract;
    private DocumentDataContract mDataContract;

    private AppDelegator() {
        try {
            int i = DocumentContractImpl.f7348a;
            this.mContract = (DocumentContract) DocumentContractImpl.class.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
        }
        try {
            this.mDataContract = (DocumentDataContract) DocumentDataContractImpl.class.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e7) {
            e7.printStackTrace();
        } catch (IllegalAccessException e8) {
            e8.printStackTrace();
        } catch (InstantiationException e9) {
            e9.printStackTrace();
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
        }
    }

    public static synchronized AppDelegator getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new AppDelegator();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    public String addCategory(Context context, String str) {
        return this.mDataContract.addCategory(context, str);
    }

    public Spanned charUtils_fromHtml(String str) {
        return this.mContract.charUtils_fromHtml(str);
    }

    public void deleteSDoc(Context context, String str, boolean z) {
        this.mDataContract.deleteSDoc(context, str, z);
    }

    public boolean detourUtils_commitEditor(SharedPreferences.Editor editor) {
        return this.mContract.detourUtils_commitEditor(editor);
    }

    public String fileUtils_logPath(String str) {
        return this.mContract.fileUtils_logPath(str);
    }

    public String getCategoryUUID(Context context, String str, boolean z) {
        return this.mDataContract.getCategoryUUID(context, str, z);
    }

    public int getDocInitModeAppWidget() {
        return this.mContract.getDocInitModeAppWidget();
    }

    public String getExtraValueLockConfirmed() {
        return this.mContract.getExtraValueLockConfirmed();
    }

    public int getLockTypeSNB() {
        return this.mContract.getLockTypeSNB();
    }

    public int getLockTypeSPD() {
        return this.mContract.getLockTypeSPD();
    }

    public int getLockTypeTMEMO() {
        return this.mContract.getLockTypeTMEMO();
    }

    public int getMaxTextureSize() {
        return this.mContract.getMaxTextureSize();
    }

    public String getNoteFilePath(Context context) {
        return this.mContract.getNoteFilePath(context);
    }

    public ArrayList<String> getNoteFilePathList(Context context, boolean z) {
        return this.mDataContract.getNoteFilePathList(context, z);
    }

    public File getPrivateFile(@NonNull Context context, String str) {
        return this.mContract.getPrivateFile(context, str);
    }

    public String getSDocUUID(Context context, String str) {
        return this.mDataContract.getSDocUUID(context, str);
    }

    public Rect getScreenDimension(Context context) {
        return this.mContract.getScreenDimension(context);
    }

    public int getThumbnailCompressQuality() {
        return this.mContract.getThumbnailCompressQuality();
    }

    public File imageUtils_saveToCache(Context context, Bitmap bitmap, int i, int i2, int i4, int i5) {
        return this.mContract.imageUtils_saveToCache(context, bitmap, i, i2, i4, i5);
    }

    public boolean isAllActivityFinished() {
        return this.mContract.isAllActivityFinished();
    }

    public boolean isExistingNote(Context context, String str) {
        return this.mDataContract.isExistingNote(context, str);
    }

    public void logger_d(String str, String str2) {
        this.mContract.logger_d(str, str2);
    }

    public void logger_e(String str, String str2) {
        this.mContract.logger_e(str, str2);
    }

    public String logger_getEncode(String str) {
        return this.mContract.logger_getEncode(str);
    }

    public String logger_getLogFilePath(Context context) {
        return this.mContract.logger_getLogFilePath(context);
    }

    public void logger_i(String str, String str2) {
        this.mContract.logger_i(str, str2);
    }

    public void makeWebCardData(SpenContentWeb spenContentWeb, MemoMetaDataItem memoMetaDataItem) {
        this.mContract.makeWebCardData(spenContentWeb, memoMetaDataItem);
    }

    public String newUUID(@NonNull Context context) {
        return this.mContract.newUUID(context);
    }

    public boolean saveDoc(Context context, DocumentSaveParamBuilder documentSaveParamBuilder) {
        return this.mDataContract.saveDoc(context, documentSaveParamBuilder);
    }

    public int setNoteFavorite(Context context, String str, boolean z) {
        return this.mDataContract.setNoteFavorite(context, str, z);
    }

    public boolean setNoteLock(Context context, String str, boolean z) {
        return this.mDataContract.setNoteLock(context, str, z);
    }

    public void logger_e(String str, String str2, Throwable th) {
        this.mContract.logger_e(str, str2, th);
    }
}
