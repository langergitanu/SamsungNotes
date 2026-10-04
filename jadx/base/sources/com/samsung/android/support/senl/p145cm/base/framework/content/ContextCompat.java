package com.samsung.android.support.senl.p145cm.base.framework.content;

import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.UserHandle;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fJ<\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000f¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/ContextCompat;", "", "<init>", "()V", "startServiceAsUser", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "makeLaunchBoundOption", "Landroid/app/ActivityOptions;", "rect", "Landroid/graphics/Rect;", "left", "", "top", "right", "bottom", "registerReceiver", "receiver", "Landroid/content/BroadcastReceiver;", "intentFilter", "Landroid/content/IntentFilter;", "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "flags", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ContextCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static ContextCompat mInstance;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/content/ContextCompat$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/content/ContextCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/content/ContextCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ContextCompat getInstance() {
            ContextCompat contextCompat;
            try {
                if (ContextCompat.mInstance == null) {
                    ContextCompat.mInstance = new ContextCompat();
                }
                contextCompat = ContextCompat.mInstance;
                Intrinsics.checkNotNull(contextCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.content.ContextCompat");
            } catch (Throwable th) {
                throw th;
            }
            return contextCompat;
        }

        private Companion() {
        }
    }

    @NotNull
    public final ActivityOptions makeLaunchBoundOption(@Nullable Rect rect) {
        ActivityOptions activityOptionsMakeBasic = ActivityOptions.makeBasic();
        activityOptionsMakeBasic.setLaunchBounds(rect);
        Intrinsics.checkNotNull(activityOptionsMakeBasic);
        return activityOptionsMakeBasic;
    }

    public final void registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @NotNull IntentFilter intentFilter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intentFilter, "intentFilter");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(receiver, intentFilter, broadcastPermission, scheduler, flags);
        } else {
            context.registerReceiver(receiver, intentFilter, broadcastPermission, scheduler);
        }
    }

    public final void startServiceAsUser(@Nullable Context context, @Nullable Intent intent) {
        Method method;
        if (context != null) {
            try {
                method = context.getClass().getMethod("startServiceAsUser", Intent.class, UserHandle.class);
            } catch (IllegalAccessException unused) {
                if (context != null) {
                    context.startService(intent);
                    return;
                }
                return;
            } catch (InstantiationException unused2) {
                if (context != null) {
                    context.startService(intent);
                    return;
                }
                return;
            } catch (NoSuchMethodException unused3) {
                if (context != null) {
                    context.startService(intent);
                    return;
                }
                return;
            } catch (InvocationTargetException unused4) {
                if (context != null) {
                    context.startService(intent);
                    return;
                }
                return;
            }
        } else {
            method = null;
        }
        Constructor constructor = UserHandle.class.getConstructor(Integer.TYPE);
        constructor.newInstance(-2);
        if (method != null) {
            method.invoke(context, intent, constructor.newInstance(-2));
        }
    }

    @NotNull
    public final ActivityOptions makeLaunchBoundOption(int left, int top, int right, int bottom) {
        return makeLaunchBoundOption(new Rect(left, top, right, bottom));
    }
}
