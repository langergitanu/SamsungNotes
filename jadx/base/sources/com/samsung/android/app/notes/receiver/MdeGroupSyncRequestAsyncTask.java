package com.samsung.android.app.notes.receiver;

import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.C6700n;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class MdeGroupSyncRequestAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "MdeGroupSyncRequestAsyncTask";
    private final String mGroupId;

    public MdeGroupSyncRequestAsyncTask(String str) {
        this.mGroupId = str;
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        try {
            try {
                C6716p.m4809q().m4796c(3);
                C6700n.m4785b().m4786a(this.mGroupId);
            } catch (Exception e) {
                Debugger.m8607d(TAG, e.getMessage());
            }
            return null;
        } finally {
            C6716p.m4809q().m4797d(3, null);
        }
    }
}
