package com.samsung.android.support.senl.document.memoconverter;

import android.content.Context;
import android.util.ArrayMap;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.SNoteConverter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SPDConverter {
    private static final String TAG = "SPDConverter";
    private SNoteConverter mSNoteConverter;

    public SPDConverter(Context context) {
        this.mSNoteConverter = null;
        this.mSNoteConverter = new SNoteConverter(context);
        DocumentLogger.m7178d(TAG, "SPDConverter()");
    }

    public String convertToSDoc(String str, String str2, ArrayMap<String, Long> arrayMap) {
        return this.mSNoteConverter.convertSPDToSDoc(str, 0, str2, arrayMap);
    }

    public ArrayList<String> convertToSDocFile(String str, String str2) {
        return this.mSNoteConverter.convertSPDToSDocFile(str, str2);
    }

    public long getLastModifiedTime(String str) {
        return this.mSNoteConverter.getLastModifiedTime(str);
    }

    public boolean isAlreadyConverted(String str) {
        return this.mSNoteConverter.isAlreadyConverted(str);
    }

    public boolean isLocked(String str) {
        return this.mSNoteConverter.isSPDLocked(str);
    }

    public boolean isRightPassword(String str, String str2) {
        return this.mSNoteConverter.isRightSPDPassword(str, str2);
    }

    public void setFinishListener(FinishListener finishListener) {
        this.mSNoteConverter.setFinishListener(finishListener);
    }

    public void setKMemoProgressListener(ProgressListener progressListener) {
        this.mSNoteConverter.setKMemoProgressListener(progressListener);
    }

    public boolean setMaxPageCountForSDoc(int i) {
        return this.mSNoteConverter.setMaxPageCountForSDoc(i);
    }

    public void unlockSPD(String str, String str2, boolean z) throws Throwable {
        this.mSNoteConverter.unlockSPD(str, str2, z);
    }

    public String convertToSDoc(String str, int i) {
        return this.mSNoteConverter.convertSPDToSDoc(str, i, null, null);
    }
}
