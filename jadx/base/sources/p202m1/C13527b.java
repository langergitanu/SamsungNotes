package p202m1;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.SmpFeature;
import com.samsung.android.sdk.smp.SmpInitOptions;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p020E.C0073a;

/* JADX INFO: renamed from: m1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13527b {

    /* JADX INFO: renamed from: a */
    public C0073a f9528a;

    /* JADX INFO: renamed from: a */
    public final void m14277a(Context context) {
        C0073a c0073a = this.f9528a;
        Debugger.m8615i("RegisterSmpUsingPam", "[PUSH] initializeSmp() start");
        if (!SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel()) {
            try {
                if (!FirebaseMessaging.getInstance().isAutoInitEnabled()) {
                    FirebaseMessaging.getInstance().setAutoInitEnabled(true);
                }
            } catch (Throwable th) {
                Debugger.m8609e("RegisterSmpUsingPam", "[PUSH] fail to enable the firebase : " + th);
                c0073a.m204j(-1);
                return;
            }
        }
        SmpInitOptions smpInitOptions = new SmpInitOptions();
        smpInitOptions.setEnableDebugLog(false);
        Debugger.m8607d("RegisterSmpUsingPam", "[PUSH] initializeSmp : Debug Log = false");
        smpInitOptions.setSppAppId("8938bd824975bfb2");
        smpInitOptions.setMultiProcessMode(false);
        try {
            SmpFeature.init(context, "FQcV4tcgRw", SmpConstants.PushModeForHkAndMo.FCM_PRIMARY_MODE, smpInitOptions);
            Debugger.m8615i("RegisterSmpUsingPam", "[PUSH] initializeSmp() : success");
        } catch (Exception unused) {
            Debugger.m8609e("RegisterSmpUsingPam", "[PUSH] initializeSmp : Exception = ");
            c0073a.m204j(-1);
        }
    }
}
