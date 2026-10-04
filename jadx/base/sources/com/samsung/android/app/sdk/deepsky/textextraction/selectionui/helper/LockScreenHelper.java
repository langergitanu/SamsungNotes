package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/LockScreenHelper;", "", "()V", SearchConstants.TargetContents.TAG, "", "isScreenLocked", "", "keyguardManager", "Landroid/app/KeyguardManager;", "requestDismissKeyguard", "", "context", "Landroid/content/Context;", TelemetryEventStrings.Value.SUCCEEDED, "Lkotlin/Function0;", TelemetryEventStrings.Value.CANCELLED, "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LockScreenHelper {

    @NotNull
    public static final LockScreenHelper INSTANCE = new LockScreenHelper();

    @NotNull
    private static final String TAG = "LockScreenHelper";

    private LockScreenHelper() {
    }

    private final boolean isScreenLocked(KeyguardManager keyguardManager) {
        return keyguardManager.isKeyguardLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestDismissKeyguard$default(LockScreenHelper lockScreenHelper, Context context, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.LockScreenHelper.requestDismissKeyguard.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        lockScreenHelper.requestDismissKeyguard(context, function0, function02);
    }

    public final void requestDismissKeyguard(@NotNull Context context, @NotNull final Function0<Unit> succeeded, @NotNull final Function0<Unit> cancelled) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(succeeded, "succeeded");
        Intrinsics.checkNotNullParameter(cancelled, "cancelled");
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if (keyguardManager != null) {
            if (INSTANCE.isScreenLocked(keyguardManager)) {
                keyguardManager.requestDismissKeyguard((Activity) context, new KeyguardManager.KeyguardDismissCallback() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.LockScreenHelper$requestDismissKeyguard$2$1
                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissCancelled() {
                        LibLogger.m5432i("LockScreenHelper", "Lockscreen dismiss cancelled");
                        cancelled.invoke();
                    }

                    @Override // android.app.KeyguardManager.KeyguardDismissCallback
                    public void onDismissSucceeded() {
                        LibLogger.m5432i("LockScreenHelper", "Lockscreen dismiss succeeded");
                        succeeded.invoke();
                    }
                });
            } else {
                succeeded.invoke();
            }
        }
    }
}
