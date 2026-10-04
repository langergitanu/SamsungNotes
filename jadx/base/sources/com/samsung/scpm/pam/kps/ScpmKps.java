package com.samsung.scpm.pam.kps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.samsung.scsp.pam.kps.lite.KpsApiContract;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import p122b2.C4192o;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScpmKps {
    private static final int ACTION_LENGTH = 64;
    private static final int KMX = 1;
    private static final int SKS = 2;
    private final String appId;
    private final Context context;
    private final BiFunction<String, Bundle, Bundle> controller;
    private final String tag = "[SCPMSDK][1.0.1101][ScpmKps]";

    /* JADX INFO: renamed from: com.samsung.scpm.pam.kps.ScpmKps$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C116201 extends BroadcastReceiver {
        final /* synthetic */ Consumer val$consumer;

        public C116201(Consumer consumer) {
            this.val$consumer = consumer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceive$0(Intent intent, Consumer consumer) {
            consumer.accept(new ScpmKpsResult(intent.getExtras()));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            context.unregisterReceiver(this);
            new Thread(new RunnableC11621a(intent, this.val$consumer)).start();
        }
    }

    public ScpmKps(Context context, String str, int i, BiFunction<String, Bundle, Bundle> biFunction) {
        this.context = context;
        this.appId = str;
        if (biFunction == null || i != 2) {
            this.controller = new C4192o(context, 1);
        } else {
            this.controller = biFunction;
        }
    }

    private void call(String str, Bundle bundle, Consumer<ScpmKpsResult> consumer) {
        Bundle bundle2 = Bundle.EMPTY;
        C116201 c116201 = new C116201(consumer);
        try {
            String strCreateActionName = createActionName();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(strCreateActionName);
            if (Build.VERSION.SDK_INT >= 33) {
                this.context.registerReceiver(c116201, intentFilter, 2);
            } else {
                this.context.registerReceiver(c116201, intentFilter);
            }
            bundle.putString("actionName", strCreateActionName);
            Log.i(this.tag, "call : Method = " + str + ", appId = " + this.appId);
            bundle.putString("appId", this.appId);
            bundle.putString("packageName", this.context.getPackageName());
            Bundle bundleApply = this.controller.apply(str, bundle);
            if (bundleApply != null) {
                bundle2 = bundleApply;
            }
        } catch (Throwable th) {
            Log.e(this.tag, "Unknown exception. " + th.getMessage());
        }
        ScpmKpsResult scpmKpsResult = new ScpmKpsResult(bundle2);
        if (scpmKpsResult.result == 2) {
            try {
                this.context.unregisterReceiver(c116201);
            } catch (Throwable th2) {
                Log.e(this.tag, "unregisterReceiver failed. " + th2.getMessage());
            }
            new Thread(new RunnableC11621a(consumer, scpmKpsResult)).start();
        }
    }

    private String createActionName() {
        byte[] bArr = new byte[64];
        new SecureRandom().nextBytes(bArr);
        return "com.samsung.scpm.pam.kps.".concat(new String(Base64.getEncoder().encode(bArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle lambda$new$0(Context context, String str, Bundle bundle) {
        return context.getContentResolver().call(ScpmKpsContract.URI, str, context.getPackageName(), bundle);
    }

    public void leave(String str, String str2, Consumer<ScpmKpsResult> consumer) {
        Bundle bundle = new Bundle();
        bundle.putString(KpsApiContract.Parameter.E2EE_GROUP_ID, str);
        bundle.putString(KpsApiContract.Parameter.RECOVERY_CODE, str2);
        call("leave", bundle, consumer);
    }

    public void requestKeySync(String str, String str2, Consumer<ScpmKpsResult> consumer) {
        Bundle bundle = new Bundle();
        bundle.putString(KpsApiContract.Parameter.E2EE_GROUP_ID, str);
        bundle.putString("serviceId", str2);
        call("requestKeySync", bundle, consumer);
    }
}
