package com.samsung.android.app.notes.sync.quota;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.network.networkutils.AbstractC6854e;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p002A0.C0008h;
import p042J1.AbstractC0146d;
import p234q1.C14434c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class QuotaServiceTask extends AsyncTask<Void, Void, C0008h> {
    private static final String TAG = "QT/QuotaServiceTask";
    protected final int mApp;
    protected String mAuthorization;
    protected final Context mContext;
    InterfaceC6872e mListener;

    public QuotaServiceTask(Context context, String str, InterfaceC6872e interfaceC6872e, int i) {
        this.mContext = context;
        this.mAuthorization = str;
        this.mListener = interfaceC6872e;
        this.mApp = i;
    }

    public String getRequestUrl() {
        return C14434c.m15043a().m15044b("/quota/v3/usage");
    }

    @Override // android.os.AsyncTask
    public C0008h doInBackground(Void... voidArr) {
        Debugger.m8615i(TAG, "try to get Quota");
        Thread.currentThread().setName("QuotaTask");
        String requestUrl = getRequestUrl();
        C0008h[] c0008hArr = {null};
        try {
            String str = this.mAuthorization;
            AbstractC6854e.m5026f(str, requestUrl, AbstractC0146d.m342a(str), new C6873f(this, c0008hArr));
        } catch (SyncException e) {
            Debugger.m8609e(TAG, e.getMessage());
        }
        if (this.mListener == null) {
            Debugger.m8615i(TAG, "no mListener");
        } else if (c0008hArr[0] == null) {
            Debugger.m8609e(TAG, "update ERROR_CODE_SERVER_ERROR!");
            this.mListener.mo5055a(201, 0L, 0L);
        } else {
            Debugger.m8607d(TAG, "update quota!");
            InterfaceC6872e interfaceC6872e = this.mListener;
            C0008h c0008h = c0008hArr[0];
            interfaceC6872e.mo5055a(0, c0008h.f37b, c0008h.f36a);
        }
        return c0008hArr[0];
    }
}
