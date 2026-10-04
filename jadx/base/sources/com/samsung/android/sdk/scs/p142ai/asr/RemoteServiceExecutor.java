package com.samsung.android.sdk.scs.p142ai.asr;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.scs.base.connection.ServiceExecutor;
import com.samsung.android.sdk.scs.base.feature.Feature;
import com.samsung.android.sdk.scs.base.utils.BaseConstants;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.scs.p142ai.asr.tasks.RecognitionTask;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ISpeechRecognizerService;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class RemoteServiceExecutor extends ServiceExecutor {
    private final String TAG;
    private final Supplier<String> mActionResolver;
    private final String mPackageName;
    private ISpeechRecognizerService mService;
    private volatile boolean mShouldDisconnectWhenIdle;
    private final List<Runnable> taskList;

    @SuppressLint({WarningType.NewApi})
    public RemoteServiceExecutor(Context context) {
        super(context, 2, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
        String str = "RemoteServiceExecutor@" + hashCode();
        this.TAG = str;
        this.mShouldDisconnectWhenIdle = false;
        this.taskList = new ArrayList();
        String packageName = context.getPackageName();
        this.mPackageName = packageName;
        if (context.checkSelfPermission(SpeechRecognitionConst.SYSTEM_PERMISSION_BIND_SERVICE) == 0) {
            Log.m6489i(str, "System permission has granted : " + packageName);
            this.mActionResolver = new C7692h(0);
        } else {
            this.mActionResolver = new C7692h(1);
        }
        Log.m6489i(str, "created");
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor, java.util.concurrent.ThreadPoolExecutor
    public void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (runnable instanceof RecognitionTask) {
            ((RecognitionTask) runnable).active(this.mService);
        }
        this.taskList.add(runnable);
    }

    public void checkAndDisconnectIfIdle() {
        int activeCount = getActiveCount();
        boolean zIsEmpty = this.taskList.isEmpty();
        if (!this.mShouldDisconnectWhenIdle || activeCount != 0 || !getQueue().isEmpty() || !zIsEmpty) {
            ASRLog.m6139i(this.TAG, "Task is on progress", this.taskList, Integer.valueOf(activeCount), Integer.valueOf(getQueue().size()));
            return;
        }
        Log.m6489i(this.TAG, "All tasks completed, start to deInit");
        this.mShouldDisconnectWhenIdle = false;
        deInit();
    }

    public void deInitWhenIdle(Runnable runnable) {
        Optional optionalOfNullable = Optional.ofNullable(runnable);
        List<Runnable> list = this.taskList;
        Objects.requireNonNull(list);
        if (((Boolean) optionalOfNullable.map(new C7685a(list, 1)).orElse(Boolean.FALSE)).booleanValue()) {
            deInitWhenIdle();
        } else {
            ASRLog.m6140w(this.TAG, "deInitWhenIdle ignored not exists", runnable, this.taskList);
        }
    }

    @Override // com.samsung.android.sdk.scs.base.connection.ServiceExecutor
    @SuppressLint({WarningType.NewApi})
    public Intent getServiceIntent() {
        Intent intent = new Intent(this.mActionResolver.get());
        if (Feature.isSIVSAvailableOSVersion(this.mContext)) {
            intent.setPackage(BaseConstants.PACKAGE_INFO.PACKAGE_SIVS_SERVICES);
        } else {
            intent.setPackage(BaseConstants.PACKAGE_INFO.PACKAGE_CORE_SERVICES);
        }
        intent.putExtra("caller_package", this.mPackageName);
        return intent;
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onConnected(ComponentName componentName, IBinder iBinder) {
        Log.m6489i(this.TAG, "onConnected");
        this.mService = ISpeechRecognizerService.Stub.asInterface(iBinder);
    }

    @Override // com.samsung.android.sdk.scs.base.connection.InternalServiceConnectionListener
    public void onDisconnected(ComponentName componentName) {
        Log.m6489i(this.TAG, "onDisconnected");
        this.mService = null;
    }

    public void deInitWhenIdle() {
        Log.m6489i(this.TAG, "deInitWhenIdle");
        this.mShouldDisconnectWhenIdle = true;
        checkAndDisconnectIfIdle();
    }
}
