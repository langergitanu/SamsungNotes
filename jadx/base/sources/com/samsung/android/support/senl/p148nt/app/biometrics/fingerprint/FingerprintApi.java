package com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint;

import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.base.common.util.LockPrefUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0010\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rJ*\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u0001`\u00182\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001a\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi;", "", "<init>", "()V", "type", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$ImplType;", "(Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$ImplType;)V", "mImplementation", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/IFingerprintApi;", "initImpl", "", "authenticate", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "cancelAuthenticate", "isDeviceAvailable", "", "hasEnrolledFingerprint", "hasChangedFingerprint", "getFingerprintUniqueId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "enableFingerprint", "registerFingerprint", "isUsingFingerprintManager", "()Z", "ImplType", "OnAuthenticationListener", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFingerprintApi.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FingerprintApi.kt\ncom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
public final class FingerprintApi {

    @NotNull
    private static final String INTENT_ACTION_REGISTER_FINGERPRINT = "com.samsung.settings.REGISTER_FINGERPRINT";

    @NotNull
    private static final String TAG = "FingerprintApi";

    @Nullable
    private IFingerprintApi mImplementation;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$ImplType;", "", "<init>", "(Ljava/lang/String;I)V", "OS_DEPENDENT", "BIOMETRIC_PROMPT", "FINGERPRINT_MANAGER", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ImplType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ImplType[] $VALUES;
        public static final ImplType OS_DEPENDENT = new ImplType("OS_DEPENDENT", 0);
        public static final ImplType BIOMETRIC_PROMPT = new ImplType("BIOMETRIC_PROMPT", 1);
        public static final ImplType FINGERPRINT_MANAGER = new ImplType("FINGERPRINT_MANAGER", 2);

        private static final /* synthetic */ ImplType[] $values() {
            return new ImplType[]{OS_DEPENDENT, BIOMETRIC_PROMPT, FINGERPRINT_MANAGER};
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
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener;", "", "onAuthenticationError", "", "errCode", "", "errString", "", "onAuthenticationHelp", "helpString", "onAuthenticationSucceeded", "onAuthenticationFailed", "onUsePasswordClicked", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnAuthenticationListener {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @JvmField
        public static final int PROMPT_ERROR_CANCELED;

        @JvmField
        public static final int PROMPT_ERROR_LOCKOUT;

        @JvmField
        public static final int PROMPT_ERROR_LOCKOUT_PERMANENT;

        @JvmField
        public static final int PROMPT_ERROR_TIMEOUT;

        @JvmField
        public static final int PROMPT_ERROR_USER_CANCELED;

        @JvmField
        public static final boolean isOverOrSameWithPOS;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001R\u0013\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi$OnAuthenticationListener$Companion;", "", "<init>", "()V", "isOverOrSameWithPOS", "", "PROMPT_ERROR_TIMEOUT", "", "PROMPT_ERROR_LOCKOUT", "PROMPT_ERROR_LOCKOUT_PERMANENT", "PROMPT_ERROR_CANCELED", "PROMPT_ERROR_USER_CANCELED", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }

        static {
            isOverOrSameWithPOS = Build.VERSION.SDK_INT >= 28;
            PROMPT_ERROR_TIMEOUT = 3;
            PROMPT_ERROR_LOCKOUT = 7;
            PROMPT_ERROR_LOCKOUT_PERMANENT = 9;
            PROMPT_ERROR_CANCELED = 5;
            PROMPT_ERROR_USER_CANCELED = 10;
        }

        void onAuthenticationError(int errCode, @NotNull CharSequence errString);

        void onAuthenticationFailed();

        void onAuthenticationHelp(@NotNull CharSequence helpString);

        void onAuthenticationSucceeded();

        void onUsePasswordClicked();
    }

    public FingerprintApi() {
        initImpl(ImplType.OS_DEPENDENT);
    }

    private final HashSet<String> getFingerprintUniqueId(Context context) {
        IFingerprintApi iFingerprintApi = this.mImplementation;
        if (iFingerprintApi != null) {
            return iFingerprintApi.getFingerprintId(context);
        }
        return null;
    }

    private final void initImpl(ImplType type) {
        if (type == ImplType.OS_DEPENDENT) {
            this.mImplementation = Build.VERSION.SDK_INT >= 28 ? new BiometricPromptImpl() : new FingerprintManagerImpl();
        } else if (type == ImplType.BIOMETRIC_PROMPT) {
            this.mImplementation = new BiometricPromptImpl();
        } else if (type == ImplType.FINGERPRINT_MANAGER) {
            this.mImplementation = new FingerprintManagerImpl();
        }
    }

    public final void authenticate(@Nullable Context context, @Nullable OnAuthenticationListener listener) {
        if (context == null || listener == null) {
            Logger.m8703w(TAG, "context/listener is null");
            return;
        }
        IFingerprintApi iFingerprintApi = this.mImplementation;
        if (iFingerprintApi != null) {
            iFingerprintApi.authenticate(context, listener);
        }
    }

    public final void cancelAuthenticate() {
        IFingerprintApi iFingerprintApi = this.mImplementation;
        if (iFingerprintApi != null) {
            iFingerprintApi.cancelAuthenticate();
        }
    }

    public final void enableFingerprint(@Nullable Context context) {
        LockPrefUtils.setPrefFingerprintChanged(context, false);
        HashSet<String> fingerprintUniqueId = getFingerprintUniqueId(context);
        if (context != null) {
            LockPrefUtils.setPrefFingerprintUniqueId(context, fingerprintUniqueId);
        }
        LockPrefUtils.setPrefUseFingerprint(context, true);
    }

    public final boolean hasChangedFingerprint(@Nullable Context context) {
        IFingerprintApi iFingerprintApi = this.mImplementation;
        if (iFingerprintApi != null) {
            return iFingerprintApi.hasChangedFingerprint(context);
        }
        return false;
    }

    public final boolean hasEnrolledFingerprint(@Nullable Context context) {
        FingerprintManager fingerprintManager = (FingerprintManager) (context != null ? context.getSystemService("fingerprint") : null);
        if (fingerprintManager != null) {
            return fingerprintManager.hasEnrolledFingerprints();
        }
        return false;
    }

    public final boolean isDeviceAvailable(@Nullable Context context) {
        Object systemService;
        if (context != null) {
            try {
                systemService = context.getSystemService("fingerprint");
            } catch (SecurityException e) {
                AbstractC4539a.m3214x("isDeviceAvailable ", e.getMessage(), TAG);
                return false;
            }
        } else {
            systemService = null;
        }
        FingerprintManager fingerprintManager = (FingerprintManager) systemService;
        if (fingerprintManager != null) {
            return fingerprintManager.isHardwareDetected();
        }
        return false;
    }

    public final boolean isUsingFingerprintManager() {
        return this.mImplementation instanceof FingerprintManagerImpl;
    }

    public final void registerFingerprint(@Nullable Context context) {
        Logger.m8697d(TAG, "startRegisterFingerprint");
        Intent intent = new Intent();
        intent.setAction(INTENT_ACTION_REGISTER_FINGERPRINT);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public FingerprintApi(@NotNull ImplType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        initImpl(type);
    }
}
