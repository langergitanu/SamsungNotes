package com.samsung.android.support.senl.p145cm.base.framework.app;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsKeyguardManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.KeyguardManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J \u0010\u0012\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/KeyguardManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsKeyguardManagerCompatImplFactory$IKeyguardManagerCompatImpl;)V", "isKeyguardLocked", "", "context", "Landroid/content/Context;", "defaultValue", "isKeyguardSecureOn", "requestDismissKeyguard", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", Profile.PhoneNumberData.TYPE_CALLBACK, "Landroid/app/KeyguardManager$KeyguardDismissCallback;", "semSetPendingIntentAfterUnlock", "p", "Landroid/app/PendingIntent;", "fillInIntent", "Landroid/content/Intent;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class KeyguardManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "KeyguardManagerCompat";

    @Nullable
    private static KeyguardManagerCompat mInstance;

    @NotNull
    private final AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/KeyguardManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/KeyguardManagerCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/KeyguardManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized KeyguardManagerCompat getInstance() {
            KeyguardManagerCompat keyguardManagerCompat;
            try {
                if (KeyguardManagerCompat.mInstance == null) {
                    KeyguardManagerCompat.mInstance = new KeyguardManagerCompat(new KeyguardManagerCompatImplFactory().create(DeviceInfo.isSemDevice()), null);
                }
                keyguardManagerCompat = KeyguardManagerCompat.mInstance;
                Intrinsics.checkNotNull(keyguardManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.KeyguardManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return keyguardManagerCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ KeyguardManagerCompat(AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl iKeyguardManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iKeyguardManagerCompatImpl);
    }

    public final boolean isKeyguardLocked(@Nullable Context context) {
        return isKeyguardLocked(context, false);
    }

    public final boolean isKeyguardSecureOn(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "isKeyguardSecureOn");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager != null && keyguardManager.isKeyguardLocked() && keyguardManager.isKeyguardSecure()) {
            Log.d(TAG, "isKeyguardSecureOn, true");
            return true;
        }
        companion.m7132d(TAG, "isKeyguardSecureOn, false");
        return false;
    }

    public final void requestDismissKeyguard(@Nullable Activity activity, @Nullable KeyguardManager.KeyguardDismissCallback callback) {
        if (activity == null) {
            return;
        }
        this.mImpl.requestDismissKeyguard(activity, callback);
    }

    public final void semSetPendingIntentAfterUnlock(@Nullable Context context, @NotNull PendingIntent p, @NotNull Intent fillInIntent) {
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(fillInIntent, "fillInIntent");
        if (context == null) {
            return;
        }
        this.mImpl.semSetPendingIntentAfterUnlock(context, p, fillInIntent);
    }

    private KeyguardManagerCompat(AbsKeyguardManagerCompatImplFactory.IKeyguardManagerCompatImpl iKeyguardManagerCompatImpl) {
        this.mImpl = iKeyguardManagerCompatImpl;
    }

    public final boolean isKeyguardLocked(@Nullable Context context, boolean defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "isKeyguardLocked");
        Object systemService = context.getSystemService("keyguard");
        KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
        if (keyguardManager == null || !keyguardManager.isKeyguardLocked()) {
            companion.m7132d(TAG, "isKeyguardLocked, false");
            return false;
        }
        Log.d(TAG, "isKeyguardLocked, true");
        return true;
    }
}
