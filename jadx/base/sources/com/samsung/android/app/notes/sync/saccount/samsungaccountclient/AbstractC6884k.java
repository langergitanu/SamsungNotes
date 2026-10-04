package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import android.content.Intent;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.service.C6888c;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6884k {

    /* JADX INFO: renamed from: a */
    public final C6888c f4422a;

    public AbstractC6884k() {
        this.f4422a = C6888c.m5085a();
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo5081a();

    /* JADX INFO: renamed from: b */
    public boolean mo5082b() {
        Debugger.m8615i(mo5081a(), "[SA] call connect()");
        C6888c c6888c = this.f4422a;
        c6888c.m5087c(c6888c.f4430c);
        Debugger.m8615i("SAccountService", "[SA] bindService()");
        Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_SERVICE");
        intent.setClassName("com.osp.app.signin", "com.msc.sa.service.RequestService");
        boolean zBindService = BaseUtils.getApplicationContext().bindService(intent, c6888c.f4434g, 1);
        if (!zBindService) {
            c6888c.m5087c(c6888c.f4429b);
            Debugger.m8609e(mo5081a(), "[SAE-1] connect() : fail to bind!");
        }
        return zBindService;
    }

    /* JADX INFO: renamed from: c */
    public void mo5083c() {
        C6888c c6888c = this.f4422a;
        Debugger.m8615i(mo5081a(), "[SA] call disConnect()");
        try {
            Debugger.m8615i("SAccountService", "[SA] unbindService()");
            try {
                BaseUtils.getApplicationContext().unbindService(c6888c.f4434g);
            } catch (Exception e) {
                Debugger.m8609e("SAccountService", "[SA] disConnectSamsungAccountService() : fail to unbind = " + e.toString());
            }
            c6888c.f4433f = null;
        } catch (Exception e2) {
            AbstractC0000a.m22s("[SA] disConnect() : fail to unbind = ", e2, mo5081a());
        }
        c6888c.m5087c(c6888c.f4429b);
    }

    /* JADX INFO: renamed from: d */
    public void m5084d() throws SAccountException {
        synchronized (this.f4422a) {
            try {
                if (this.f4422a.m5086b()) {
                    Debugger.m8615i("TaskBase", "[SA] waitSamsungAccountService() : Service is already connected");
                    return;
                }
                if (!this.f4422a.f4432e.mo5082b()) {
                    throw new SAccountException(PerfConstants.ScenarioConstants.SCENARIO_BROKERED_ACQUIRE_TOKEN_SILENTLY, "fail to bind service!");
                }
                int i = 1;
                while (!this.f4422a.m5086b()) {
                    try {
                        Thread.sleep(100L);
                    } catch (Exception unused) {
                    }
                    int i2 = i + 1;
                    if (i > 99) {
                        Debugger.m8609e("TaskBase", "[SAE-2] waitSamsungAccountService() : throw FAIL_SERVICE_TIMED_OUT!");
                        throw new SAccountException(TelemetryEventStrings.Api.BROKER_ACQUIRE_TOKEN_SILENT, "Service connection is timed out!");
                    }
                    i = i2;
                }
                Debugger.m8615i("TaskBase", "[SA] waitSamsungAccountService() : Service is connected");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractC6884k(C6888c c6888c) {
        this.f4422a = c6888c;
    }
}
