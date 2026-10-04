package com.samsung.android.support.senl.p148nt.app.biometrics.iris;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.camera.sdk.iris.SIrisManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0003!\"#B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\"\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi;", "", "<init>", "()V", "type", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$ImplType;", "(Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$ImplType;)V", "mImpl", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IIrisApiImpl;", "initImpl", "", "authenticate", "context", "Landroid/content/Context;", "preview", "Landroid/view/View;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$OnAuthenticationListener;", "cancelAuthenticate", "isDeviceAvailable", "", "hasEnrolledIris", "hasChangedIris", "hasChangedIrisP", "hasChangedIrisO", "enableIris", "getIrisId", "", "isRetryCase", "errCode", "", "isUsingIrisManager", "()Z", "ImplType", "OnAuthenticationListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class IrisApi {

    @NotNull
    private static final String TAG = "Biometrics$IrisApi";

    @Nullable
    private IIrisApiImpl mImpl;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$ImplType;", "", "<init>", "(Ljava/lang/String;I)V", "OS_DEPENDENT", "BIOMETRIC_PROMPT", "IRIS_MANAGER", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ImplType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ImplType[] $VALUES;
        public static final ImplType OS_DEPENDENT = new ImplType("OS_DEPENDENT", 0);
        public static final ImplType BIOMETRIC_PROMPT = new ImplType("BIOMETRIC_PROMPT", 1);
        public static final ImplType IRIS_MANAGER = new ImplType("IRIS_MANAGER", 2);

        private static final /* synthetic */ ImplType[] $values() {
            return new ImplType[]{OS_DEPENDENT, BIOMETRIC_PROMPT, IRIS_MANAGER};
        }

        static {
            ImplType[] implTypeArr$values = $values();
            $VALUES = implTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(implTypeArr$values);
        }

        private ImplType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ImplType> getEntries() {
            return $ENTRIES;
        }

        public static ImplType valueOf(String str) {
            return (ImplType) Enum.valueOf(ImplType.class, str);
        }

        public static ImplType[] values() {
            return (ImplType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$OnAuthenticationListener;", "", "onAuthenticationError", "", "errCode", "", "errString", "", "onAuthenticationHelp", "helpString", "onAuthenticationSucceeded", "onAuthenticationFailed", "onUsePasswordClicked", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnAuthenticationListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @JvmField
        public static final int ERROR_CANCELED;

        @JvmField
        public static final int ERROR_LOCKOUT;

        @JvmField
        public static final int ERROR_LOCKOUT_PERMANENT;

        @JvmField
        public static final int ERROR_TIMEOUT;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi$OnAuthenticationListener$Companion;", "", "<init>", "()V", "ERROR_TIMEOUT", "", "ERROR_LOCKOUT", "ERROR_LOCKOUT_PERMANENT", "ERROR_CANCELED", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        static {
            int i = Build.VERSION.SDK_INT;
            ERROR_TIMEOUT = i >= 29 ? 3 : 2;
            ERROR_LOCKOUT = i >= 29 ? 7 : 6;
            ERROR_LOCKOUT_PERMANENT = i >= 29 ? 9 : 16;
            ERROR_CANCELED = i >= 29 ? 5 : 4;
        }

        void onAuthenticationError(int errCode, @NotNull CharSequence errString);

        void onAuthenticationFailed();

        void onAuthenticationHelp(@NotNull CharSequence helpString);

        void onAuthenticationSucceeded();

        void onUsePasswordClicked();
    }

    public IrisApi() {
        initImpl(ImplType.OS_DEPENDENT);
    }

    private final String getIrisId(Context context) {
        IIrisApiImpl iIrisApiImpl = this.mImpl;
        if (iIrisApiImpl != null) {
            return iIrisApiImpl.getIrisId(context);
        }
        return null;
    }

    private final boolean hasChangedIrisO(Context context) {
        IIrisApiImpl iIrisApiImpl = this.mImpl;
        String irisId = iIrisApiImpl != null ? iIrisApiImpl.getIrisId(context) : null;
        if (irisId == null) {
            Logger.m8697d(TAG, "compareIrisUniqueID : getIrisId is null");
            return true;
        }
        String prefIrisUniqueId = LockPrefUtils.getPrefIrisUniqueId(context);
        if (prefIrisUniqueId == null) {
            Logger.m8697d(TAG, "compareIrisUniqueID : OriginalUniqueID is null");
            return true;
        }
        if (!Intrinsics.areEqual(prefIrisUniqueId, irisId)) {
            Logger.m8697d(TAG, "compareIrisUniqueID : not match");
            return true;
        }
        LockPrefUtils.setPrefIrisUniqueId(context, irisId);
        Logger.m8697d(TAG, "compareIrisUniqueID : match");
        return false;
    }

    private final boolean hasChangedIrisP(Context context) {
        if (LockPrefUtils.getPrefIrisChanged(context)) {
            LockPrefUtils.setPrefIrisChanged(context, false);
            return true;
        }
        Logger.m8697d(TAG, "hasChangedIrisP : false");
        return false;
    }

    private final void initImpl(ImplType type) {
        if (type == ImplType.OS_DEPENDENT) {
            this.mImpl = Build.VERSION.SDK_INT >= 29 ? new IrisBiometricPromptImpl() : new IrisManagerImpl();
            return;
        }
        if (type == ImplType.BIOMETRIC_PROMPT) {
            this.mImpl = new IrisBiometricPromptImpl();
        } else if (type == ImplType.IRIS_MANAGER) {
            this.mImpl = new IrisManagerImpl();
        } else {
            Logger.m8697d(TAG, "type error");
        }
    }

    public final void authenticate(@Nullable Context context, @Nullable View preview, @NotNull OnAuthenticationListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IIrisApiImpl iIrisApiImpl = this.mImpl;
        if (iIrisApiImpl != null) {
            iIrisApiImpl.authenticate(context, preview, listener);
        }
    }

    public final void cancelAuthenticate() {
        IIrisApiImpl iIrisApiImpl = this.mImpl;
        if (iIrisApiImpl != null) {
            iIrisApiImpl.cancelAuthenticate();
        }
    }

    public final void enableIris(@Nullable Context context) {
        LockPrefUtils.setPrefIrisChanged(context, false);
        String irisId = getIrisId(context);
        Intrinsics.checkNotNull(context);
        LockPrefUtils.setPrefIrisUniqueId(context, irisId);
        LockPrefUtils.setPrefUseIris(context, true);
    }

    public final boolean hasChangedIris(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT >= 28 ? hasChangedIrisP(context) : hasChangedIrisO(context);
    }

    public final boolean hasEnrolledIris(@Nullable Context context) {
        if (DeviceUtils.isPowerManageMode(context) || !PermissionHelper.isPermissionGrantedWithoutNotice(context, "com.samsung.android.camera.iris.permission.USE_IRIS")) {
            Logger.m8697d(TAG, "hasEnrolledIris : not supported");
            return false;
        }
        SIrisManager sIrisManager = SIrisManager.getSIrisManager(context);
        boolean zHasEnrolledIrises = sIrisManager != null ? sIrisManager.hasEnrolledIrises() : false;
        Logger.m8697d(TAG, "hasEnrolledIris " + zHasEnrolledIrises);
        return zHasEnrolledIrises;
    }

    public final boolean isDeviceAvailable(@Nullable Context context) {
        SIrisManager sIrisManager = SIrisManager.getSIrisManager(context);
        if (sIrisManager != null) {
            return sIrisManager.isHardwareDetected();
        }
        return false;
    }

    public final boolean isRetryCase(int errCode) {
        IIrisApiImpl iIrisApiImpl = this.mImpl;
        if (iIrisApiImpl != null) {
            return iIrisApiImpl.isRetryCase(errCode);
        }
        return false;
    }

    public final boolean isUsingIrisManager() {
        return this.mImpl instanceof IrisManagerImpl;
    }

    public IrisApi(@NotNull ImplType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        initImpl(type);
    }
}
