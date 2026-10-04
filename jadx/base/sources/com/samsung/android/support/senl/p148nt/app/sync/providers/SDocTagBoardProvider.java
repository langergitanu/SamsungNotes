package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
class SDocTagBoardProvider {
    private static final String TAG = "SDocTagBoardProvider";
    private final Context mContext;

    public SDocTagBoardProvider(Context context) {
        this.mContext = context;
    }

    public Cursor getSdocDataForTagboard(String str, String[] strArr, String str2) {
        try {
            return NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentTagRepository().getDataForTagBoard(str, strArr, str2);
        } catch (SQLException e) {
            Logger.m8698e(TAG, "getSdocDataForTagboard(), e : " + e.getMessage());
            throw e;
        }
    }
}
