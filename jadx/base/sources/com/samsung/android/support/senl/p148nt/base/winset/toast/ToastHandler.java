package com.samsung.android.support.senl.p148nt.base.winset.toast;

import android.content.Context;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J$\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\"\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\"\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J$\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J$\u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J$\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007J\"\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007J\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/toast/ToastHandler;", "", "<init>", "()V", "LENGTH_LONG", "", "LENGTH_SHORT", Constants.IntentExtraValue.SHOW, "", "context", "Landroid/content/Context;", "message", "", XmlErrorCodes.DURATION, "resId", "showDirectly", "showToastOnFlipCoverScreen", "showEncodingLog", "showDefaultLayout", "isGravityBottom", "", "showContinuous", "cancelAll", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ToastHandler {

    @NotNull
    public static final ToastHandler INSTANCE = new ToastHandler();
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;

    private ToastHandler() {
    }

    @JvmStatic
    public static final void show(@Nullable Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (context == null) {
            return;
        }
        ToastHelper.show(context, message, duration, true);
    }

    @JvmStatic
    public static final void showContinuous(@Nullable Context context, @StringRes int resId, int duration) {
        if (context == null) {
            return;
        }
        ToastHelper.show(context, resId, duration, false);
    }

    @JvmStatic
    public static final void showDefaultLayout(@Nullable Context context, @Nullable String message, int duration) {
        if (context == null) {
            return;
        }
        ToastHelper.ToastParam toastParam = new ToastHelper.ToastParam();
        if (message != null) {
            toastParam.setMessage(message);
        }
        toastParam.setDuration(duration);
        toastParam.setIgnoreCustomLayout(true);
        ToastHelper.INSTANCE.show(context, toastParam);
    }

    @JvmStatic
    public static final void showDirectly(@Nullable Context context, @StringRes int resId, int duration) {
        if (context == null) {
            return;
        }
        ToastHelper.INSTANCE.showDirectly(context, resId, duration);
    }

    @JvmStatic
    public static final void showEncodingLog(@Nullable Context context, @Nullable String message, int duration) {
        if (context == null) {
            return;
        }
        ToastHelper.ToastParam toastParam = new ToastHelper.ToastParam();
        if (message != null) {
            toastParam.setMessage(message);
        }
        toastParam.setDuration(duration);
        toastParam.setEncodeLog(true);
        toastParam.setGravityBottom(true);
        ToastHelper.INSTANCE.show(context, toastParam);
    }

    @JvmStatic
    public static final void showToastOnFlipCoverScreen(@Nullable Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (context == null) {
            return;
        }
        ToastHelper.INSTANCE.showToastOnFlipCoverScreen(context, message, duration);
    }

    public final void cancelAll() {
        ToastHelper.INSTANCE.cancelAll();
    }

    @JvmStatic
    public static final void show(@Nullable Context context, @StringRes int resId, int duration) {
        if (context == null) {
            return;
        }
        ToastHelper.show(context, resId, duration, true);
    }

    @JvmStatic
    public static final void showContinuous(@Nullable Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (context == null) {
            return;
        }
        ToastHelper.show(context, message, duration, false);
    }

    @JvmStatic
    public static final void showDirectly(@Nullable Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (context == null) {
            return;
        }
        ToastHelper.INSTANCE.showDirectly(context, message, duration);
    }

    @JvmStatic
    public static final void show(@Nullable Context context, @Nullable String message, int duration, boolean isGravityBottom) {
        if (context == null) {
            return;
        }
        ToastHelper.ToastParam toastParam = new ToastHelper.ToastParam();
        if (message != null) {
            toastParam.setMessage(message);
        }
        toastParam.setDuration(duration);
        toastParam.setGravityBottom(isGravityBottom);
        ToastHelper.INSTANCE.show(context, toastParam);
    }
}
