package com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p042J1.AbstractC0155m;
import p068Q.C0204a;
import p079T.AbstractC0299q;
import p083U.C0304a;
import p083U.C0305b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ShareBaseTask extends AsyncTask<Void, Void, Boolean> {
    private static final String TAG = "ShareBaseTask";
    protected final Context mContext;
    protected C0304a mDocShareInfo;
    protected C0305b mDocShareOperation;
    protected ArrayList<C0204a> mErrorList;
    protected InterfaceC6717a mListener;
    protected String mSpaceId;

    public ShareBaseTask(Context context, InterfaceC6717a interfaceC6717a, String str) {
        this.mContext = context;
        this.mListener = interfaceC6717a;
        this.mSpaceId = str;
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Debugger.m8615i(TAG, "onCancelled()");
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mListener.mo203f();
    }

    public abstract ArrayList<C0204a> shareProgress();

    public void stop() {
        synchronized (this) {
            this.mListener = null;
            Debugger.m8615i(TAG, "stop()");
            cancel(true);
        }
    }

    @Override // android.os.AsyncTask
    public Boolean doInBackground(Void... voidArr) {
        String str;
        StringBuilder sb;
        ArrayList<C0204a> arrayList;
        Thread.currentThread().setName(TAG);
        try {
            try {
                C6716p.m4809q().m4796c(3);
                if (C6716p.m4809q().m4801j()) {
                    this.mErrorList = shareProgress();
                } else {
                    ArrayList<C0204a> arrayList2 = new ArrayList<>();
                    this.mErrorList = arrayList2;
                    arrayList2.add(new C0204a("", 7));
                }
                arrayList = this.mErrorList;
            } catch (Exception e) {
                Debugger.m8608e(e);
                if (e instanceof ShareException) {
                    this.mErrorList = AbstractC0299q.m653x(((ShareException) e).getExceptionCode());
                } else {
                    ArrayList<C0204a> arrayList3 = new ArrayList<>();
                    this.mErrorList = arrayList3;
                    arrayList3.add(new C0204a("", 8));
                }
                synchronized (this) {
                    try {
                        InterfaceC6717a interfaceC6717a = this.mListener;
                        if (interfaceC6717a != null) {
                            interfaceC6717a.mo200b(this.mErrorList);
                        }
                        try {
                            C6716p.m4809q().m4797d(3, null);
                        } catch (Exception e2) {
                            e = e2;
                            str = TAG;
                            sb = new StringBuilder("fail to disconnect : ");
                            AbstractC0000a.m21r(e, sb, str);
                        }
                    } finally {
                    }
                }
            }
            if (arrayList == null) {
                throw new Exception("Error list is null!");
            }
            if (!arrayList.isEmpty()) {
                synchronized (this) {
                    try {
                        InterfaceC6717a interfaceC6717a2 = this.mListener;
                        if (interfaceC6717a2 != null) {
                            interfaceC6717a2.mo200b(this.mErrorList);
                        }
                    } finally {
                    }
                }
            }
            try {
                C6716p.m4809q().m4797d(3, null);
            } catch (Exception e3) {
                e = e3;
                str = TAG;
                sb = new StringBuilder("fail to disconnect : ");
                AbstractC0000a.m21r(e, sb, str);
            }
            return Boolean.TRUE;
        } catch (Throwable th) {
            try {
                C6716p.m4809q().m4797d(3, null);
            } catch (Exception e5) {
                AbstractC0000a.m21r(e5, new StringBuilder("fail to disconnect : "), TAG);
            }
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        Debugger.m8615i(TAG, "onPostExecute() v." + AbstractC0155m.m399n(this.mContext));
        synchronized (this) {
            try {
                if (this.mListener != null) {
                    Debugger.m8615i(TAG, "finish sharing docs!");
                    ArrayList<C0204a> arrayList = this.mErrorList;
                    if (arrayList == null || arrayList.isEmpty()) {
                        Debugger.m8615i(TAG, "call onShareEnded()");
                        this.mListener.mo201c();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8607d(TAG, "onPostExecute() ends");
    }
}
