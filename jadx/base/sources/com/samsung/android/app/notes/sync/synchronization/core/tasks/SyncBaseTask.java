package com.samsung.android.app.notes.sync.synchronization.core.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.items.ImportItem;
import com.samsung.android.app.notes.sync.network.C6845j;
import com.samsung.android.app.notes.sync.p135db.C6734c;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.HashMap;
import java.util.List;
import p001A.AbstractC0000a;
import p003A1.C0012a;
import p003A1.C0013b;
import p010C.C0042g;
import p022E1.AbstractC0078d;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.C0099c;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p186h1.C12020a;
import p206n0.C13533a;
import p207n1.C13540g;
import p207n1.C13541h;
import p211o0.C13567a;
import p234q1.C14434c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SyncBaseTask extends AsyncTask<Void, Void, List<ImportItem>> {
    protected static final String TAG = "SyncBaseTask";
    protected static String mAccountGuid;
    protected final String mAuthorization;
    protected final Context mContext;
    protected int mErrorCode;
    public int mRequestType;
    protected C0012a mSyncInfoSDoc;
    protected C0077c mSyncInfoSDocx;
    protected C0013b mSyncOperationSDoc;
    protected C0082h mSyncOperationSDocx;
    protected InterfaceC6897a mSyncProgressListener;
    protected C0099c mSyncRequestInfo;
    private int mResultCode = 0;
    private int mCancelCode = 900;
    private int mStopCode = 100;

    public SyncBaseTask(Context context, String str, InterfaceC6897a interfaceC6897a, int i) {
        this.mContext = context;
        this.mAuthorization = str;
        this.mSyncProgressListener = interfaceC6897a;
        this.mRequestType = i;
    }

    private int checkCloudPreCondition() {
        Debugger.m8615i(TAG, "Start checkCloudPreCondition()");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (C0042g.m78a(this.mSyncInfoSDocx.f262e).m80c()) {
            printElapsedTime("checkCloudPreCondition()", jElapsedRealtime);
            return 119;
        }
        if (C0042g.m78a(this.mSyncInfoSDocx.f262e).m81d()) {
            printElapsedTime("checkCloudPreCondition()", jElapsedRealtime);
            return 120;
        }
        printElapsedTime("checkCloudPreCondition()", jElapsedRealtime);
        return 0;
    }

    private void checkDebugMode() {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleException(Exception exc) {
        if (exc instanceof SyncException) {
            SyncException syncException = (SyncException) exc;
            int exceptionCode = syncException.getExceptionCode();
            if (exceptionCode == 315) {
                int iM639l = AbstractC0299q.m639l(syncException);
                if (exceptionCode != iM639l) {
                    exceptionCode = iM639l;
                }
                Debugger.m8609e(TAG, "Sync failed because of server error, converted error = " + exceptionCode);
            } else if (exceptionCode == 351 || exceptionCode == 508 || exceptionCode == 509) {
                this.mResultCode = exceptionCode;
            } else if (exceptionCode != 907 && exceptionCode != 908) {
                switch (exceptionCode) {
                    case 902:
                        Debugger.m8615i(TAG, "handleException() : mStopCode = " + this.mStopCode);
                        if (this.mStopCode == 100) {
                            this.mCancelCode = exceptionCode;
                        } else {
                            C6907j c6907jM5142c = C6907j.m5142c();
                            int i = this.mStopCode;
                            c6907jM5142c.getClass();
                            this.mCancelCode = C6907j.m5141b(i);
                        }
                        break;
                }
            } else {
                this.mCancelCode = exceptionCode;
            }
            Debugger.m8613ef(TAG, "handleException() : ", syncException);
            this.mErrorCode = AbstractC0299q.m637k(exceptionCode);
        } else {
            Debugger.m8613ef(TAG, "Unknown exception : ", exc);
            this.mErrorCode = 1;
        }
        Debugger.m8609e(TAG, "handleException() : mResultCode = " + this.mResultCode + " , mCancelCode = " + this.mCancelCode + " , mErrorCode = " + this.mErrorCode);
    }

    private boolean initSyncInfo() {
        Context context = this.mContext;
        String str = this.mAuthorization;
        C0077c c0077c = new C0077c(context, str);
        c0077c.f269l = new HashMap();
        c0077c.f270m = new HashMap();
        c0077c.f271n = false;
        c0077c.f272o = null;
        c0077c.f265h = new C6903f(str);
        c0077c.f266i = new C6749r(context);
        c0077c.f267j = new C6734c(context);
        C12020a c12020a = new C12020a((char) 0, 8);
        c12020a.f8772b = new C13533a(context);
        c0077c.f268k = c12020a;
        this.mSyncInfoSDocx = c0077c;
        Context context2 = this.mContext;
        String str2 = this.mAuthorization;
        C0012a c0012a = new C0012a(context2, str2);
        c0012a.f67h = true;
        c0012a.f68i = true;
        c0012a.f70k = new HashMap();
        c0012a.f71l = new HashMap();
        c0012a.f72m = new HashMap();
        c0012a.f73n = new HashMap();
        c0012a.f74o = new HashMap();
        new HashMap();
        c0012a.f75p = new HashMap();
        c0012a.f76q = false;
        c0012a.f77r = false;
        c0012a.f78s = false;
        c0012a.f79t = false;
        c0012a.f80u = null;
        c0012a.f81v = null;
        c0012a.f82w = null;
        c0012a.f83x = null;
        c0012a.f84y = null;
        c0012a.f69j = new C6845j(str2, "O4vARCbQ3G");
        this.mSyncInfoSDoc = c0012a;
        return true;
    }

    private void initSyncOperation() {
        this.mSyncOperationSDocx = new C0082h(this.mSyncInfoSDocx);
        this.mSyncOperationSDoc = new C0013b(this.mSyncInfoSDoc);
    }

    private boolean isTaskCancelled() {
        return this.mCancelCode != 900;
    }

    private void onSyncEnded() {
        Debugger.m8615i(TAG, "onSyncEnded() : mResultCode = " + this.mResultCode + " , mCancelCode = " + this.mCancelCode + " , mErrorCode = " + this.mErrorCode);
        if (this.mRequestType == 1) {
            if (this.mErrorCode != 0) {
                Debugger.m8609e(TAG, "onSyncEnded() : fail!");
                InterfaceC6897a interfaceC6897a = this.mSyncProgressListener;
                if (interfaceC6897a != null) {
                    interfaceC6897a.mo5104a(this.mErrorCode, "SyncBaseTask.doInBackground");
                    return;
                }
                return;
            }
            if (isTaskCancelled()) {
                if (this.mSyncProgressListener != null) {
                    Debugger.m8615i(TAG, "onSyncEnded() : cancelled");
                    this.mSyncProgressListener.mo5107d(this.mCancelCode);
                    return;
                }
                return;
            }
            Debugger.m8615i(TAG, "onSyncEnded() : success");
            InterfaceC6897a interfaceC6897a2 = this.mSyncProgressListener;
            if (interfaceC6897a2 != null) {
                interfaceC6897a2.mo5108e(this.mResultCode);
            }
        }
    }

    private void printEdpState() {
        StringBuilder sb = new StringBuilder("[EDP] EDP is ");
        C13567a.m14371a().getClass();
        sb.append(C0145c.m331p("SyncEdp", "SyncEdpState", CoverStickerConstants.Category.NONE.NAME));
        Debugger.m8615i(TAG, sb.toString());
    }

    private void printElapsedTime(String str, long j) {
        StringBuilder sbM15l = AbstractC0000a.m15l("Finish ", str, ": et = ");
        sbM15l.append(SystemClock.elapsedRealtime() - j);
        Debugger.m8615i(TAG, sbM15l.toString());
    }

    private void printPreSyncInfo() {
        Debugger.m8615i(TAG, "Sync : v." + AbstractC0155m.m399n(this.mContext) + ", PowerSavingMode : " + DeviceUtils.isPowerSavingMode(this.mContext) + ", Unrestricted : " + C0145c.m340y() + ", Sync Time : " + this.mSyncInfoSDocx.f263f + ", Device Time : " + System.currentTimeMillis());
    }

    public void fillSyncInfo() {
        C0077c c0077c = this.mSyncInfoSDocx;
        this.mSyncOperationSDocx.getClass();
        c0077c.f263f = AbstractC0078d.m215b();
        this.mSyncInfoSDocx.f265h.m5130o(this.mSyncRequestInfo.f322a);
        this.mSyncInfoSDocx.f264g = this.mSyncRequestInfo;
    }

    public boolean initSyncTask() {
        if (!((C13540g) C13541h.m14287e().f9588a).m14285a()) {
            Debugger.m8609e(TAG, "No samsung account!");
            return false;
        }
        String strM14293g = C13541h.m14287e().m14293g();
        mAccountGuid = strM14293g;
        if (TextUtils.isEmpty(strM14293g)) {
            Debugger.m8609e(TAG, "No accountGuid!");
            return false;
        }
        if (!initSyncInfo()) {
            return false;
        }
        initSyncOperation();
        return true;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        Debugger.m8615i(TAG, "onCancelled() start : v." + AbstractC0155m.m399n(this.mContext) + ", mStopCode = " + this.mStopCode);
        if (this.mStopCode != 100) {
            C6907j c6907jM5142c = C6907j.m5142c();
            int i = this.mStopCode;
            c6907jM5142c.getClass();
            this.mCancelCode = C6907j.m5141b(i);
        }
        onSyncEnded();
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mSyncProgressListener.mo5106c();
    }

    public int performPreJobs() {
        if (!initSyncTask()) {
            return 1;
        }
        int iCheckCloudPreCondition = checkCloudPreCondition();
        if (iCheckCloudPreCondition != 0) {
            return iCheckCloudPreCondition;
        }
        fillSyncInfo();
        checkDebugMode();
        return 0;
    }

    public void printCurrentInfo() {
        if (AbstractC4539a.m3210t()) {
            printEdpState();
        }
        Debugger.m8615i(TAG, "domainUrl = " + C14434c.m15043a().m15044b(""));
        printPreSyncInfo();
    }

    public void setListener(InterfaceC6897a interfaceC6897a) {
        this.mSyncProgressListener = interfaceC6897a;
    }

    public void setRequestSyncInfo(C0099c c0099c) {
        Debugger.m8615i(TAG, "setRequestSyncInfo() : SyncMsgType = " + c0099c.f322a);
        this.mSyncRequestInfo = c0099c;
    }

    public void stop(int i) {
        Debugger.m8615i(TAG, "stop() : stopCode : " + i);
        cancel(true);
        this.mStopCode = i;
    }

    public abstract int syncProgress();

    @Override // android.os.AsyncTask
    public List<ImportItem> doInBackground(Void... voidArr) {
        Thread.currentThread().setName(TAG);
        this.mErrorCode = 0;
        try {
        } catch (Exception e) {
            handleException(e);
        }
        if (!SpenSdkInitializer.initialize(this.mContext)) {
            Debugger.m8612ef(TAG, "Before syncProgress() : fail to initialize!");
            this.mErrorCode = 1;
            return null;
        }
        if (this.mRequestType == 1) {
            Process.setThreadPriority(12);
            this.mErrorCode = syncProgress();
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(List<ImportItem> list) {
        super.onPostExecute(list);
        Debugger.m8615i(TAG, "onPostExecute() start : v." + AbstractC0155m.m399n(this.mContext));
        onSyncEnded();
    }
}
