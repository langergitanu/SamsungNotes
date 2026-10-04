package com.samsung.android.app.notes.receiver;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import java.util.concurrent.Executor;
import p075S.AbstractC0254f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditGroupAndGroupMemberSyncRequestAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "CoeditGroupAndSpaceSyncAsyncTask";
    static final Executor mExecutor = AbstractC4539a.m3201k(TAG);
    private final Runnable mFinishedRunnable;
    private final String mGroupId;

    public CoeditGroupAndGroupMemberSyncRequestAsyncTask(String str, Runnable runnable) {
        this.mGroupId = str;
        this.mFinishedRunnable = runnable;
    }

    public static void requestSync(String str, Runnable runnable) {
        new CoeditGroupAndGroupMemberSyncRequestAsyncTask(str, runnable).executeOnExecutor(mExecutor, new Void[0]);
    }

    private void requestSync(String str) {
        AbstractC0254f.m540f();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC0254f.m538d(str);
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        MainCoeditLogger.m7253i(TAG, "doInBackground#");
        try {
            try {
                C6715o.m4808q().m4796c(3);
                requestSync(this.mGroupId);
            } catch (Exception e) {
                MainCoeditLogger.m7251e(TAG, "doInBackground# " + e.getMessage());
            }
            return null;
        } finally {
            C6715o.m4808q().m4797d(3, null);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        MainCoeditLogger.m7253i(TAG, "onPostExecute# " + this.mFinishedRunnable);
        Runnable runnable = this.mFinishedRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }
}
