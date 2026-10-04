package com.samsung.android.app.notes.sync.contentsharing.importcore.strategy;

import android.content.Context;
import com.samsung.android.app.notes.sync.contentsharing.basecore.MdeSDocTask;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import java.util.ArrayList;
import p042J1.AbstractC0155m;
import p063P.InterfaceC0193b;
import p068Q.C0204a;
import p079T.AbstractC0299q;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MdeImportBaseTask extends MdeSDocTask {
    private static final String TAG = "MdeImportBaseTask";
    protected final Context mContext;
    protected ArrayList<C0204a> mErrorList;
    protected String mGroupId;
    protected InterfaceC0193b mListener;
    protected String mOwnerId;
    protected String mSpaceId;

    public MdeImportBaseTask(Context context, InterfaceC0193b interfaceC0193b, String str) {
        this.mContext = context;
        this.mListener = interfaceC0193b;
        this.mSpaceId = str;
    }

    public abstract ArrayList<C0204a> importProgress();

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Debugger.m8615i(TAG, "onCancelled()");
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mListener.onStart();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.basecore.MdeSDocTask
    public void stop() {
        synchronized (this) {
            this.mListener = null;
            Debugger.m8615i(TAG, "stop()");
            cancel(true);
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.basecore.MdeSDocTask, android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        Thread.currentThread().setName(TAG);
        try {
            SpenSdkInitializer.initialize(this.mContext);
            ArrayList<C0204a> arrayListImportProgress = importProgress();
            this.mErrorList = arrayListImportProgress;
            if (arrayListImportProgress == null) {
                throw new Exception("Error list is null!");
            }
            if (!arrayListImportProgress.isEmpty()) {
                synchronized (this) {
                    try {
                        InterfaceC0193b interfaceC0193b = this.mListener;
                        if (interfaceC0193b != null) {
                            interfaceC0193b.mo453d(this.mSpaceId, this.mErrorList);
                        }
                    } finally {
                    }
                }
                return null;
            }
        } catch (Exception e) {
            Debugger.m8608e(e);
            if (e instanceof ShareException) {
                this.mErrorList = AbstractC0299q.m653x(((ShareException) e).getExceptionCode());
            } else {
                ArrayList<C0204a> arrayList = new ArrayList<>();
                this.mErrorList = arrayList;
                arrayList.add(new C0204a("", 8));
            }
            synchronized (this) {
                try {
                    InterfaceC0193b interfaceC0193b2 = this.mListener;
                    if (interfaceC0193b2 != null) {
                        interfaceC0193b2.mo453d(this.mSpaceId, this.mErrorList);
                    }
                } finally {
                }
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r32) {
        super.onPostExecute(r32);
        Debugger.m8615i(TAG, "onPostExecute() v." + AbstractC0155m.m399n(this.mContext));
        synchronized (this) {
            try {
                if (this.mListener != null) {
                    Debugger.m8615i(TAG, "finish importing docs!");
                    ArrayList<C0204a> arrayList = this.mErrorList;
                    if (arrayList == null || arrayList.isEmpty()) {
                        Debugger.m8615i(TAG, "call onImportEnded()");
                        this.mListener.mo452a(this.mSpaceId);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8607d(TAG, "onPostExecute() ends");
    }
}
