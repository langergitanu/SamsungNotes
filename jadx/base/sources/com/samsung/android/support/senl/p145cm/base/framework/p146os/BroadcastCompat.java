package com.samsung.android.support.senl.p145cm.base.framework.p146os;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.microsoft.identity.common.java.WarningType;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0004\u0006\u0007\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat;", "", "<init>", "()V", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$ContextRegisterReceiverImpl;", "ContextRegisterReceiverImpl", "Legacy", "Tos", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BroadcastCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static BroadcastCompat mInstance;

    @Nullable
    private ContextRegisterReceiverImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J,\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J6\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J@\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$Companion;", "", "<init>", "()V", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat;", "registerReceiver", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "flags", "", "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final BroadcastCompat getInstance() {
            if (BroadcastCompat.mInstance == null) {
                BroadcastCompat.mInstance = new BroadcastCompat();
            }
            BroadcastCompat broadcastCompat = BroadcastCompat.mInstance;
            Intrinsics.checkNotNull(broadcastCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat");
            return broadcastCompat;
        }

        @Nullable
        public final Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @NotNull IntentFilter filter) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filter, "filter");
            ContextRegisterReceiverImpl contextRegisterReceiverImpl = getInstance().mImpl;
            if (contextRegisterReceiverImpl != null) {
                return contextRegisterReceiverImpl.registerReceiver(context, receiver, filter);
            }
            return null;
        }

        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @NotNull IntentFilter filter, int flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filter, "filter");
            ContextRegisterReceiverImpl contextRegisterReceiverImpl = getInstance().mImpl;
            if (contextRegisterReceiverImpl != null) {
                return contextRegisterReceiverImpl.registerReceiver(context, receiver, filter, flags);
            }
            return null;
        }

        @Nullable
        public final Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @NotNull IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filter, "filter");
            ContextRegisterReceiverImpl contextRegisterReceiverImpl = getInstance().mImpl;
            if (contextRegisterReceiverImpl != null) {
                return contextRegisterReceiverImpl.registerReceiver(context, receiver, filter, broadcastPermission, scheduler);
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @NotNull IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(filter, "filter");
            ContextRegisterReceiverImpl contextRegisterReceiverImpl = getInstance().mImpl;
            if (contextRegisterReceiverImpl != null) {
                return contextRegisterReceiverImpl.registerReceiver(context, receiver, filter, broadcastPermission, scheduler, flags);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J:\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&JB\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$ContextRegisterReceiverImpl;", "", "registerReceiver", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "flags", "", "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ContextRegisterReceiverImpl {
        @Nullable
        Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter);

        @Nullable
        Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, int flags);

        @Nullable
        Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler);

        @Nullable
        Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J.\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J:\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JB\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$Legacy;", "Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$ContextRegisterReceiverImpl;", "<init>", "()V", "registerReceiver", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "flags", "", "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Legacy implements ContextRegisterReceiverImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, int flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter, broadcastPermission, scheduler);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter, broadcastPermission, scheduler);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J.\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017J:\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017JB\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0017¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$Tos;", "Lcom/samsung/android/support/senl/cm/base/framework/os/BroadcastCompat$ContextRegisterReceiverImpl;", "<init>", "()V", "registerReceiver", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "receiver", "Landroid/content/BroadcastReceiver;", "filter", "Landroid/content/IntentFilter;", "flags", "", "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Tos implements ContextRegisterReceiverImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @SuppressLint({WarningType.NewApi})
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @SuppressLint({WarningType.NewApi})
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, int flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter, flags);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @SuppressLint({WarningType.NewApi})
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter, broadcastPermission, scheduler);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.os.BroadcastCompat.ContextRegisterReceiverImpl
        @SuppressLint({WarningType.NewApi})
        @Nullable
        public Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver receiver, @Nullable IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.registerReceiver(receiver, filter, broadcastPermission, scheduler, flags);
        }
    }

    public BroadcastCompat() {
        this.mImpl = Build.VERSION.SDK_INT >= 33 ? new Tos() : new Legacy();
    }

    @JvmStatic
    @Nullable
    public static final Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NotNull IntentFilter intentFilter, int i) {
        return INSTANCE.registerReceiver(context, broadcastReceiver, intentFilter, i);
    }

    @JvmStatic
    @Nullable
    public static final Intent registerReceiver(@NotNull Context context, @Nullable BroadcastReceiver broadcastReceiver, @NotNull IntentFilter intentFilter, @Nullable String str, @Nullable Handler handler, int i) {
        return INSTANCE.registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i);
    }
}
