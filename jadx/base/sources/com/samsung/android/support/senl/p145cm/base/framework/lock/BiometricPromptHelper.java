package com.samsung.android.support.senl.p145cm.base.framework.lock;

import android.hardware.biometrics.BiometricPrompt;
import com.samsung.android.support.senl.p145cm.base.framework.sem.lock.BiometricHelperImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/lock/BiometricPromptHelper;", "", "<init>", "()V", "TYPE_FINGERPRINT", "", "TYPE_FACE", "TYPE_IRIS", "TYPE_DEVICE_CUSTOM_SCAN", "setBiometricType", "Landroid/hardware/biometrics/BiometricPrompt$Builder;", "builder", "type", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BiometricPromptHelper {

    @NotNull
    public static final BiometricPromptHelper INSTANCE = new BiometricPromptHelper();
    public static final int TYPE_DEVICE_CUSTOM_SCAN = 8;
    public static final int TYPE_FACE = 2;
    public static final int TYPE_FINGERPRINT = 1;
    public static final int TYPE_IRIS = 4;

    private BiometricPromptHelper() {
    }

    @JvmStatic
    @Nullable
    public static final BiometricPrompt.Builder setBiometricType(@Nullable BiometricPrompt.Builder builder, int type) {
        return BiometricHelperImpl.INSTANCE.setBiometricType(builder, type);
    }
}
