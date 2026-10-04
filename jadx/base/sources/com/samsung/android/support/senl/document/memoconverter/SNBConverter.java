package com.samsung.android.support.senl.document.memoconverter;

import android.content.Context;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.document.memoconverter.core.SNoteConverter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SNBConverter {
    private static final String TAG = "SNBConverter";
    private SNoteConverter mSnoteConverter;

    public SNBConverter(Context context) {
        this.mSnoteConverter = null;
        this.mSnoteConverter = new SNoteConverter(context);
        DocumentLogger.m7181i(TAG, "SNBConverter()");
    }

    public boolean convertToSDoc(String str, int i) {
        return this.mSnoteConverter.convertSNBToSDoc(str, i);
    }

    public ArrayList<String> convertToSDocFile(String str, String str2) {
        return this.mSnoteConverter.convertSNBToSDocFile(str, str2);
    }

    public String convertToSpdFile(String str, String str2) {
        return this.mSnoteConverter.snbTospd(str, str2);
    }

    public boolean isAlreadyConverted(String str) {
        return this.mSnoteConverter.isAlreadyConverted(str);
    }

    public boolean isLocked(String str) {
        return this.mSnoteConverter.isSNBLocked(str);
    }

    public boolean isRightPassword(String str, String str2) {
        return this.mSnoteConverter.isRightSnbPassword(str, str2);
    }

    public void setFinishListener(FinishListener finishListener) {
        this.mSnoteConverter.setFinishListener(finishListener);
    }

    public void unlockSNB(String str, String str2, boolean z) throws Throwable {
        this.mSnoteConverter.unlockSNB(str, str2, z);
    }
}
