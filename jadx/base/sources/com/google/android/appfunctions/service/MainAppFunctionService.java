package com.google.android.appfunctions.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CancellationSignal;
import android.p108os.OutcomeReceiver;
import androidx.annotation.RestrictTo;
import androidx.compose.p109ui.scrollcapture.C2223a;
import com.android.extensions.appfunctions.AppFunctionService;
import com.android.extensions.appfunctions.ExecuteAppFunctionRequest;
import com.google.android.appfunctions.AppFunctionException;
import com.google.android.appfunctions.ExecuteAppFunctionResponse;
import com.google.android.appfunctions.internal.Dependencies;
import com.google.android.appfunctions.internal.Dispatchers;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J4\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/google/android/appfunctions/service/MainAppFunctionService;", "Lcom/android/extensions/appfunctions/AppFunctionService;", "<init>", "()V", "appFunctionServiceDelegate", "Lcom/google/android/appfunctions/service/AppFunctionServiceDelegate;", "onCreate", "", "onExecuteFunction", "executeAppFunctionRequest", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionRequest;", "callingPackage", "", "cancellationSignal", "Landroid/os/CancellationSignal;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/os/OutcomeReceiver;", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "Lcom/android/extensions/appfunctions/AppFunctionException;", "onDestroy", "java.com.google.android.libraries.llm.appfunctions.appfunctions_appfunctions"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({WarningType.NewApi})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class MainAppFunctionService extends AppFunctionService {
    private AppFunctionServiceDelegate appFunctionServiceDelegate;

    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        CoroutineContext worker = dispatchers.getWorker();
        CoroutineContext main = dispatchers.getMain();
        Dependencies.Companion companion = Dependencies.INSTANCE;
        this.appFunctionServiceDelegate = new AppFunctionServiceDelegate(applicationContext, worker, main, companion.getInstance().m3126x5b5f78c7(), companion.getInstance().m3125x9661cda5());
    }

    public void onDestroy() {
        super.onDestroy();
        AppFunctionServiceDelegate appFunctionServiceDelegate = this.appFunctionServiceDelegate;
        if (appFunctionServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appFunctionServiceDelegate");
            appFunctionServiceDelegate = null;
        }
        appFunctionServiceDelegate.onDestroy();
    }

    public void onExecuteFunction(@NotNull ExecuteAppFunctionRequest executeAppFunctionRequest, @NotNull String callingPackage, @NotNull CancellationSignal cancellationSignal, @NotNull final OutcomeReceiver callback) {
        Intrinsics.checkNotNullParameter(executeAppFunctionRequest, "executeAppFunctionRequest");
        Intrinsics.checkNotNullParameter(callingPackage, "callingPackage");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppFunctionServiceDelegate appFunctionServiceDelegate = this.appFunctionServiceDelegate;
        if (appFunctionServiceDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appFunctionServiceDelegate");
            appFunctionServiceDelegate = null;
        }
        cancellationSignal.setOnCancelListener(new C2223a(appFunctionServiceDelegate.onExecuteFunction(com.google.android.appfunctions.ExecuteAppFunctionRequest.INSTANCE.fromPlatformClass(executeAppFunctionRequest), callingPackage, new OutcomeReceiver() { // from class: com.google.android.appfunctions.service.MainAppFunctionService$onExecuteFunction$appFunctionJob$1
            public void onError(AppFunctionException error) {
                Intrinsics.checkNotNullParameter(error, "error");
                callback.onError(error.toPlatformClass());
            }

            public void onResult(ExecuteAppFunctionResponse result) {
                Intrinsics.checkNotNullParameter(result, "result");
                callback.onResult(result.toPlatformClass());
            }
        }), 1));
    }
}
