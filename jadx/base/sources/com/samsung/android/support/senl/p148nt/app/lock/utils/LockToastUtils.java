package com.samsung.android.support.senl.p148nt.app.lock.utils;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/lock/utils/LockToastUtils;", "", "<init>", "()V", "showBiometricChangeToast", "", "context", "Landroid/content/Context;", "hasFingerChanged", "", "hasIrisChanged", "showMultiWindowImpossibleToast", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LockToastUtils {

    @NotNull
    public static final LockToastUtils INSTANCE = new LockToastUtils();

    private LockToastUtils() {
    }

    @JvmStatic
    public static final void showBiometricChangeToast(@Nullable Context context, boolean hasFingerChanged, boolean hasIrisChanged) {
        if (context == null) {
            return;
        }
        if (hasFingerChanged && hasIrisChanged) {
            String string = context.getString(C8003R.string.lock_fingerprint_and_iris_changed_reset);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
        } else if (hasFingerChanged) {
            String string2 = context.getString(C8003R.string.lock_fingerprint_changed_reset);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ToastHandler.show(context, string2, 1);
        } else if (hasIrisChanged) {
            String string3 = context.getString(C8003R.string.lock_iris_changed_reset);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            ToastHandler.show(context, string3, 1);
        }
    }

    @JvmStatic
    public static final void showMultiWindowImpossibleToast(@Nullable Context context) {
        ToastHandler.show(context, C8003R.string.lock_not_support_multi_window, 0);
    }
}
