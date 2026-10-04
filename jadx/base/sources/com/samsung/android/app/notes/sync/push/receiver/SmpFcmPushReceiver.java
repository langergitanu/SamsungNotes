package com.samsung.android.app.notes.sync.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.app.notes.sync.push.base.PushRegState;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.C0158a;
import p195k1.C12969a;
import p202m1.AbstractC13528c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpFcmPushReceiver extends BroadcastReceiver {
    private static final String TAG = "SmpFcmPushReceiver";

    private void handleInitializationResult(Context context, Intent intent) {
        String str;
        int i = 0;
        boolean booleanExtra = intent.getBooleanExtra(SmpConstants.IS_SUCCESS, false);
        Debugger.m8615i(TAG, "[PUSH] SMP_INITIALIZE_RESULT_ACTION : " + booleanExtra);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            AbstractC13528c.m14278a(7);
            Debugger.m8609e(TAG, "[PUSH] appContext is null!");
            return;
        }
        if (booleanExtra) {
            AbstractC13528c.m14278a(5);
            Debugger.m8615i(TAG, "[PUSH] Succeed to initialize SMP!");
            C12969a c12969aM13872b = C12969a.m13872b(applicationContext);
            c12969aM13872b.getClass();
            if (C0158a.m407a().m414e()) {
                c12969aM13872b.m13880i();
                return;
            }
            return;
        }
        AbstractC13528c.m14278a(6);
        String stringExtra = intent.getStringExtra("error_code");
        Debugger.m8609e(TAG, "[PUSH] errorCode : " + stringExtra + " , errorMessage : " + intent.getStringExtra("error_message"));
        C12969a c12969aM13872b2 = C12969a.m13872b(applicationContext);
        c12969aM13872b2.getClass();
        StringBuilder sb = new StringBuilder("onSmpInitFailed() : errorCode = ");
        sb.append(stringExtra);
        sb.append(" , errorMsg = ");
        while (true) {
            if (i >= 7) {
                str = null;
                break;
            } else {
                if (AbstractC13528c.f9529a[i].equals(stringExtra)) {
                    str = AbstractC13528c.f9530b[i];
                    break;
                }
                i++;
            }
        }
        sb.append(str);
        Debugger.m8609e("PushManager", sb.toString());
        c12969aM13872b2.f9309c = PushRegState.NOT_REGISTERED;
    }

    private void handleRegistrationResult(Context context, Intent intent) {
        String str;
        int i = 0;
        boolean booleanExtra = intent.getBooleanExtra(SmpConstants.IS_SUCCESS, false);
        Debugger.m8615i(TAG, "[PUSH] PUSH_REGISTRATION_RESULT_ACTION : " + booleanExtra);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            AbstractC13528c.m14278a(10);
            Debugger.m8609e(TAG, "[PUSH] appContext is null!");
            return;
        }
        if (booleanExtra) {
            AbstractC13528c.m14278a(8);
            String stringExtra = intent.getStringExtra(SmpConstants.PUSH_TYPE);
            Debugger.m8615i(TAG, "[PUSH] Succeed to register SMP : " + stringExtra);
            String stringExtra2 = intent.getStringExtra(SmpConstants.PUSH_TOKEN);
            Debugger.m8616s(TAG, "[PUSH] SMP pushToken : " + stringExtra2);
            C12969a.m13872b(applicationContext).m13875d(stringExtra, stringExtra2);
            return;
        }
        AbstractC13528c.m14278a(9);
        String stringExtra3 = intent.getStringExtra(SmpConstants.PUSH_TYPE);
        String stringExtra4 = intent.getStringExtra("error_code");
        String stringExtra5 = intent.getStringExtra("error_message");
        StringBuilder sbM16m = AbstractC0000a.m16m("[PUSH] SMP pushType : ", stringExtra3, " , errorCode : ", stringExtra4, " , errorMessage : ");
        sbM16m.append(stringExtra5);
        Debugger.m8609e(TAG, sbM16m.toString());
        C12969a c12969aM13872b = C12969a.m13872b(applicationContext);
        c12969aM13872b.getClass();
        StringBuilder sbM15l = AbstractC0000a.m15l("onSmpRegFailed() : errorCode = ", stringExtra4, " , errorMsg = ");
        while (true) {
            if (i >= 7) {
                str = null;
                break;
            } else {
                if (AbstractC13528c.f9529a[i].equals(stringExtra4)) {
                    str = AbstractC13528c.f9530b[i];
                    break;
                }
                i++;
            }
        }
        sbM15l.append(str);
        Debugger.m8609e("PushManager", sbM15l.toString());
        C0145c.m310R("SMP_PREFERENCE", "smp_push_type", "");
        C0145c.m310R("SMP_PREFERENCE", "smp_push_token", "");
        C0145c.m310R("SMP_PREFERENCE", "smp_reg_last_error", stringExtra4);
        c12969aM13872b.f9309c = PushRegState.NOT_REGISTERED;
    }

    private void handleTokenChangedResult(Context context, Intent intent) {
        Debugger.m8615i(TAG, "[PUSH] handleTokenChangedResult()");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            Debugger.m8609e(TAG, "[PUSH] onTokenChanged() : appContext is null!");
            return;
        }
        String stringExtra = intent.getStringExtra(SmpConstants.PUSH_TOKEN);
        String stringExtra2 = intent.getStringExtra(SmpConstants.PUSH_TYPE);
        Debugger.m8615i(TAG, "[PUSH] pushType : " + stringExtra2);
        Debugger.m8616s(TAG, "[PUSH] pushToken : " + stringExtra);
        C12969a.m13872b(applicationContext).m13875d(stringExtra2, stringExtra);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8615i(TAG, "[PUSH] onReceive() : SMP init result");
        AbstractC13528c.m14278a(0);
        if (context == null) {
            Debugger.m8609e(TAG, "[PUSH] onReceive() : Invalid context");
            AbstractC13528c.m14278a(1);
            return;
        }
        if (intent == null) {
            Debugger.m8609e(TAG, "[PUSH] onReceive() : Invalid params");
            AbstractC13528c.m14278a(2);
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            Debugger.m8607d(TAG, "[PUSH] onReceive() : action is null or empty");
            AbstractC13528c.m14278a(3);
            return;
        }
        if (SmpConstants.SMP_INITIALIZE_RESULT_ACTION.equals(action)) {
            handleInitializationResult(context, intent);
            return;
        }
        if (SmpConstants.PUSH_REGISTRATION_RESULT_ACTION.equals(action)) {
            handleRegistrationResult(context, intent);
        } else if (SmpConstants.PUSH_TOKEN_CHANGED_ACTION.equals(action)) {
            handleTokenChangedResult(context, intent);
        } else {
            AbstractC13528c.m14278a(4);
            Debugger.m8615i(TAG, "[PUSH] not handled!");
        }
    }
}
