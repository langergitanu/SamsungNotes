package com.samsung.android.app.notes.receiver;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.SyncOption;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.ActivityManagerUtil;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p075S.C0260l;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditGroupAndSpaceSyncAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "CoeditGroupAndSpaceSyncAsyncTask";
    static final Executor mExecutor = AbstractC4539a.m3201k(TAG);
    private final Runnable mFinishedRunnable;
    private final String mGroupId;
    private final String mSpaceId;

    public CoeditGroupAndSpaceSyncAsyncTask(String str, String str2, Runnable runnable) {
        this.mGroupId = str;
        this.mSpaceId = str2;
        this.mFinishedRunnable = runnable;
    }

    public static void requestSync(String str, String str2, Runnable runnable) {
        new CoeditGroupAndSpaceSyncAsyncTask(str, str2, runnable).executeOnExecutor(mExecutor, new Void[0]);
    }

    private void requestSync(String str, String str2) throws ShareException {
        if (!TextUtils.isEmpty(str)) {
            AbstractC0254f.m538d(str);
        } else if (!ActivityManagerUtil.isAppInBackground(BaseUtils.getApplicationContext())) {
            AbstractC0254f.m540f();
        }
        if (!TextUtils.isEmpty(str2)) {
            AbstractC0267s.m547e(str2);
            return;
        }
        ShareApi shareApiM543a = AbstractC0267s.m543a();
        CompletableFuture completableFuture = new CompletableFuture();
        SyncOption syncOption = new SyncOption(SyncOption.SyncType.FULL_SYNC, false, false);
        synchronized (AbstractC0267s.f715a) {
            try {
                if (shareApiM543a.requestSync(syncOption, new C0260l(completableFuture)) != 1) {
                    Debugger.m8607d("SesShareApi", "requestSync. Request Failure!");
                    return;
                }
                try {
                } catch (InterruptedException e) {
                    Debugger.m8609e("SesShareApi", "InterruptedException : " + e.toString());
                } catch (TimeoutException e2) {
                    Debugger.m8609e("SesShareApi", "TimeoutException : " + e2.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        MainCoeditLogger.m7253i(TAG, "doInBackground#");
        if (C6715o.m4808q().m4801j()) {
            try {
                requestSync(this.mGroupId, this.mSpaceId);
            } catch (Exception e) {
                AbstractC4539a.m3204n(e, new StringBuilder("doInBackground#connected# "), TAG);
            }
        } else {
            try {
                try {
                    C6715o.m4808q().m4796c(3);
                    requestSync(this.mGroupId, this.mSpaceId);
                } catch (Exception e2) {
                    MainCoeditLogger.m7251e(TAG, "doInBackground# " + e2.getMessage());
                }
            } finally {
                C6715o.m4808q().m4797d(3, null);
            }
        }
        return null;
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
