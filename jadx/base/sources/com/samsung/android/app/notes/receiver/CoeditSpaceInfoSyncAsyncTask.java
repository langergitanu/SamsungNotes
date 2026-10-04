package com.samsung.android.app.notes.receiver;

import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p075S.AbstractC0267s;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditSpaceInfoSyncAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "CoeditSpaceInfoSyncAsyncTask";
    private final String mSpaceId;

    public CoeditSpaceInfoSyncAsyncTask(String str) {
        this.mSpaceId = str;
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        try {
            try {
                C6715o.m4808q().m4796c(3);
                AbstractC0267s.m548f(this.mSpaceId);
            } catch (Exception e) {
                Debugger.m8609e(TAG, "doInBackground, e : " + e.getMessage());
            }
            return null;
        } finally {
            C6715o.m4808q().m4797d(3, null);
        }
    }
}
