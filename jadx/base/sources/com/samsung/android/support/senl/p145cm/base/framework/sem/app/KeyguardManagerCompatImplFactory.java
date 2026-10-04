package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/KeyguardManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;", "isSemDevice", "", "KeyguardManagerCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class KeyguardManagerCompatImplFactory extends AbsKeyguardManagerCompatImplFactory {

    @NotNull
    private static final String TAG = "KeyguardManagerCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/KeyguardManagerCompatImplFactory$KeyguardManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;", "<init>", "()V", "requestDismissKeyguard", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "semSetPendingIntentAfterUnlock", "context", "Landroid/content/Context;", "p", "Landroid/app/PendingIntent;", "fillInIntent", "Landroid/content/Intent;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class KeyguardManagerCompatSemImpl implements AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl
        public void requestDismissKeyguard(@Nullable Activity activity, @Nullable KeyguardManager.KeyguardDismissCallback callback) {
            Object systemService;
            LoggerBase.INSTANCE.m7132d(KeyguardManagerCompatImplFactory.TAG, "requestDismissKeyguard");
            if (activity != null) {
                try {
                    systemService = activity.getSystemService("keyguard");
                } catch (Exception e) {
                    LoggerBase.INSTANCE.m7133e(KeyguardManagerCompatImplFactory.TAG, "requestDismissKeyguard, exception " + e);
                    return;
                }
            } else {
                systemService = null;
            }
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            ((KeyguardManager) systemService).requestDismissKeyguard(activity, callback);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl
        public void semSetPendingIntentAfterUnlock(@NotNull Context context, @NotNull PendingIntent p, @NotNull Intent fillInIntent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(fillInIntent, "fillInIntent");
            LoggerBase.INSTANCE.m7132d(KeyguardManagerCompatImplFactory.TAG, "semSetPendingIntentAfterUnlock");
            Object systemService = context.getSystemService("keyguard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            ((KeyguardManager) systemService).semSetPendingIntentAfterUnlock(p, fillInIntent);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory
    @NotNull
    public AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl create(boolean isSemDevice) {
        return isSemDevice ? new KeyguardManagerCompatSemImpl() : super.create(isSemDevice);
    }
}
