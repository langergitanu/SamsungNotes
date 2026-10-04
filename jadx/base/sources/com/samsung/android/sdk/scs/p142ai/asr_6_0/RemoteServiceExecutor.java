package com.samsung.android.sdk.scs.p142ai.asr_6_0;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.scs.p140ai.sdkcommon.asr.ISpeechRecognizerService;
import com.samsung.android.scs.p140ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;
import com.samsung.android.sdk.scs.p142ai.asr_6_0.tasks.RecognitionTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class RemoteServiceExecutor extends ServiceExecutor {
    private static final String TAG = "RemoteServiceManager";
    private final Supplier<String> mActionResolver;
    private final String mPackageName;
    private ISpeechRecognizerService mService;

    @SuppressLint({WarningType.NewApi})
    public RemoteServiceExecutor(Context context) {
        super(context, 1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        String packageName = context.getPackageName();
        this.mPackageName = packageName;
        if (context.checkSelfPermission(SpeechRecognitionConst.SYSTEM_PERMISSION_BIND_SERVICE) != 0) {
            this.mActionResolver = new C7718f(1);
            return;
        }
        Log.i(TAG, "System permission has granted : " + packageName);
        this.mActionResolver = new C7718f(0);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof RecognitionTask) {
            ((RecognitionTask) runnable).active(this.mService);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    @SuppressLint({WarningType.NewApi})
    public Intent getServiceIntent() {
        Intent intent = new Intent(this.mActionResolver.get());
        intent.setPackage(BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
        intent.putExtra("caller_package", this.mPackageName);
        return intent;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.i(TAG, "onConnected");
        this.mService = ISpeechRecognizerService.Stub.asInterface(iBinder);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.i(TAG, "onDisconnected");
        this.mService = null;
    }
}
