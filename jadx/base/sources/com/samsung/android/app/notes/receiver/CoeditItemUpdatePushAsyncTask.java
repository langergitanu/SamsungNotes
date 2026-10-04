package com.samsung.android.app.notes.receiver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;
import p075S.AbstractC0267s;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditItemUpdatePushAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "CoeditItemUpdatePushAsyncTask";
    private final String mItemId;
    private final String mSpaceId;

    public CoeditItemUpdatePushAsyncTask(String str, String str2) {
        this.mSpaceId = str;
        this.mItemId = str2;
    }

    @Override // android.os.AsyncTask
    @SuppressLint({WarningType.NewApi})
    public Void doInBackground(Void... voidArr) {
        Context applicationContext;
        String uuidByItemId;
        if (!TextUtils.isEmpty(this.mSpaceId) && !TextUtils.isEmpty(this.mItemId)) {
            try {
                try {
                    C6715o.m4808q().m4796c(3);
                    applicationContext = BaseUtils.getApplicationContext();
                    try {
                        AbstractC0267s.m547e(this.mSpaceId);
                    } catch (Exception e) {
                        MainCoeditLogger.m7251e(TAG, "handleUpdateItem() " + e.getMessage());
                    }
                    uuidByItemId = new SyncNoteDataRepository().getUuidByItemId(this.mSpaceId, this.mItemId);
                } catch (Exception e2) {
                    Debugger.m8609e(TAG, "doInBackground, e : " + e2.getMessage());
                }
                if (TextUtils.isEmpty(uuidByItemId)) {
                    CoeditNoteUpDownloader.getInstance().requestDownload(this.mSpaceId, null);
                } else {
                    SharedItem sharedItemByItemId = SesCoeditShareReadResolver.getInstance().getSharedItemByItemId(applicationContext, this.mSpaceId, this.mItemId);
                    if (sharedItemByItemId == null) {
                        Debugger.m8609e(TAG, "doInBackground, item is null!");
                    } else {
                        new NoteDbResolver(uuidByItemId).updateTitleAndModifiedTime(sharedItemByItemId.getTitle(), sharedItemByItemId.getModifiedTime());
                    }
                }
                return null;
            } finally {
                C6715o.m4808q().m4797d(3, null);
            }
        }
        return null;
    }
}
