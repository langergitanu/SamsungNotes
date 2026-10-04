package com.samsung.android.support.senl.document.contract;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface DocumentDataContract {
    String addCategory(Context context, String str);

    void deleteSDoc(Context context, String str, boolean z);

    String getCategoryUUID(Context context, String str, boolean z);

    ArrayList<String> getNoteFilePathList(Context context, boolean z);

    String getSDocUUID(Context context, String str);

    boolean isExistingNote(Context context, String str);

    boolean saveDoc(Context context, DocumentSaveParamBuilder documentSaveParamBuilder);

    int setNoteFavorite(Context context, String str, boolean z);

    boolean setNoteLock(Context context, String str, boolean z);
}
