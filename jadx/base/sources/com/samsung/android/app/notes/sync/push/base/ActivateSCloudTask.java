package com.samsung.android.app.notes.sync.push.base;

import android.content.Context;
import android.os.AsyncTask;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p020E.C0073a;
import p042J1.C0145c;
import p199l1.InterfaceC13517a;
import p199l1.InterfaceC13518b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ActivateSCloudTask extends AsyncTask<String, Void, Void> {
    private static final String TAG = "ActivateSCloudTask";
    private boolean isActivated = false;
    private InterfaceC13517a mActivateMethod;
    private final Context mContext;
    private InterfaceC13518b mRegisterListener;

    public ActivateSCloudTask(Context context, InterfaceC13517a interfaceC13517a, InterfaceC13518b interfaceC13518b) {
        this.mContext = context;
        this.mActivateMethod = interfaceC13517a;
        this.mRegisterListener = interfaceC13518b;
    }

    private void activatePushToServerAsync() {
        Debugger.m8615i(TAG, "[PUSH] Try to activate push to server");
        try {
            ((C6907j) this.mActivateMethod).getClass();
            Debugger.m8615i("ActivatePushUsingPam", "[PUSH] activatePush()");
            boolean z = true;
            int[] iArr = {-1};
            if (SCloudPamHelper.updatePushInfoSync()) {
                iArr[0] = 0;
            } else {
                C0145c.m306N(-1, "SMP_PREFERENCE", "smp_activate_last_error");
            }
            if (iArr[0] != 0) {
                z = false;
            }
            this.isActivated = z;
        } catch (Exception e) {
            Debugger.m8609e(TAG, e.toString());
        }
        if (this.isActivated) {
            ((C0073a) this.mRegisterListener).m204j(0);
            Debugger.m8615i(TAG, "[PUSH] Success to activate push to server");
        } else {
            ((C0073a) this.mRegisterListener).m204j(-1);
            Debugger.m8609e(TAG, "[PUSH] Fail to activate push to server");
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        Debugger.m8615i(TAG, "onCancelled()");
        synchronized (this) {
            try {
                InterfaceC13518b interfaceC13518b = this.mRegisterListener;
                if (interfaceC13518b != null) {
                    if (this.isActivated) {
                        ((C0073a) interfaceC13518b).m204j(0);
                    } else {
                        ((C0073a) interfaceC13518b).m204j(-1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    public Void doInBackground(String... strArr) {
        Thread.currentThread().setName(TAG);
        activatePushToServerAsync();
        return null;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r2) {
        synchronized (this) {
            try {
                InterfaceC13518b interfaceC13518b = this.mRegisterListener;
                if (interfaceC13518b != null) {
                    if (this.isActivated) {
                        ((C0073a) interfaceC13518b).m204j(0);
                    } else {
                        ((C0073a) interfaceC13518b).m204j(-1);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8607d(TAG, "onPostExecute() ends");
    }
}
