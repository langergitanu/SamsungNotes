package com.samsung.android.support.senl.p148nt.app.sync.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.C6751f;
import com.samsung.android.app.notes.sync.saccount.AccountSamsungType;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import p042J1.AbstractC0146d;
import p042J1.C0145c;
import p044K.C0158a;
import p079T.C0283a;
import p207n1.C13540g;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SamsungAccountReceiver extends BroadcastReceiver {
    private static final String COMPLETE_SAMSUNG_ACCOUNT_SIGNIN_ACTION = "com.samsung.account.SAMSUNGACCOUNT_SIGNIN_COMPLETED";
    private static final String COMPLETE_SAMSUNG_ACCOUNT_SIGNOUT_ACTION = "com.samsung.account.SAMSUNGACCOUNT_SIGNOUT_COMPLETED";
    private static final String TAG = "SA/SamsungAccountReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8615i(TAG, "onReceive()");
        if (intent == null) {
            Debugger.m8609e(TAG, "[SA] Invalid params");
            return;
        }
        if (context == null) {
            Debugger.m8609e(TAG, "[SA] Invalid context");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        PostLaunchManager.getInstance().executeBaseLogic(301);
        if (!"com.samsung.account.SAMSUNGACCOUNT_SIGNIN_COMPLETED".equals(intent.getAction())) {
            if ("com.samsung.account.SAMSUNGACCOUNT_SIGNOUT_COMPLETED".equals(intent.getAction())) {
                Debugger.m8614f(TAG, "com.samsung.account.SAMSUNGACCOUNT_SIGNOUT_COMPLETED");
                C13541h.m14287e().m14290c();
                C13541h c13541hM14287e = C13541h.m14287e();
                if (((AccountSamsungType) c13541hM14287e.f9592e) == AccountSamsungType.LOCAL) {
                    ((C13540g) c13541hM14287e.f9588a).m14285a();
                } else {
                    Debugger.m8609e("SAccountManager", "[SA] onLoggedOut() : Not supported yet!");
                }
                AiActionStatus.resetAIFeatureInfo();
                return;
            }
            return;
        }
        Debugger.m8614f(TAG, "com.samsung.account.SAMSUNGACCOUNT_SIGNIN_COMPLETED");
        if (!SettingsCompat.getInstance().checkSetupWizardDone(applicationContext)) {
            Debugger.m8615i(TAG, "1. if the setup wizard is not finished!");
            C6751f c6751fM4890a = C6751f.m4890a(applicationContext);
            c6751fM4890a.getClass();
            Debugger.m8614f("GeneralManager", "signedInActionDuringSetupWizard()");
            C0158a.m407a().m417k();
            Context context2 = c6751fM4890a.f4139a;
            C0145c.m311S(context2, Boolean.valueOf(AbstractC0146d.m345d(context2)));
            return;
        }
        boolean z = false;
        if (applicationContext == null) {
            Debugger.m8609e("SyncSettingsUtil", "isFtuFirstOpen() : context is null!");
        } else {
            z = applicationContext.getSharedPreferences(Constants.APP_LAUNCH_PREFERENCE, 0).getBoolean(Constants.FIRST_TIME_USE, true);
            AbstractC4539a.m3215y("FTU_FIRST_OPEN is ", "SyncSettingsUtil", z);
        }
        if (z) {
            Debugger.m8615i(TAG, "2. Don't handle this if Samsung Note has been not executed yet");
            return;
        }
        new C0283a().m563e();
        C13541h.m14287e().m14290c();
        C13541h c13541hM14287e2 = C13541h.m14287e();
        if (((AccountSamsungType) c13541hM14287e2.f9592e) == AccountSamsungType.LOCAL) {
            ((C13540g) c13541hM14287e2.f9588a).m14285a();
        } else {
            Debugger.m8609e("SAccountManager", "[SA] onLoggedIn() : Not supported yet!");
        }
        if (C0145c.m295C(applicationContext) || C0158a.m407a().m417k() == AbstractC0146d.m345d(applicationContext)) {
            return;
        }
        Debugger.m8615i(TAG, "Change the sync enable mode by receiver");
        C6751f.m4890a(applicationContext).m4892c();
    }
}
