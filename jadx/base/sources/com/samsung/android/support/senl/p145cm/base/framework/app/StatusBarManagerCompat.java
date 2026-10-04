package com.samsung.android.support.senl.p145cm.base.framework.app;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsStatusBarManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.StatusBarManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/StatusBarManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$IStatusBarManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsStatusBarManagerCompatImplFactory$IStatusBarManagerCompatImpl;)V", "disable", "", "context", "Landroid/content/Context;", "what", "", "collapsePanels", "disableExpand", "getDisableExpand", "()I", "disableNone", "getDisableNone", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StatusBarManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "StatusBarManagerCompat";

    @Nullable
    private static StatusBarManagerCompat mInstance;

    @NotNull
    private final AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/StatusBarManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/StatusBarManagerCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/StatusBarManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized StatusBarManagerCompat getInstance() {
            StatusBarManagerCompat statusBarManagerCompat;
            try {
                if (StatusBarManagerCompat.mInstance == null) {
                    StatusBarManagerCompat.mInstance = new StatusBarManagerCompat(new StatusBarManagerCompatImplFactory().create(DeviceInfo.isSemDevice()), null);
                }
                statusBarManagerCompat = StatusBarManagerCompat.mInstance;
                Intrinsics.checkNotNull(statusBarManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.StatusBarManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return statusBarManagerCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ StatusBarManagerCompat(AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl iStatusBarManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iStatusBarManagerCompatImpl);
    }

    public final void collapsePanels(@Nullable Context context) {
        if (context == null) {
            return;
        }
        this.mImpl.collapsePanels(context);
    }

    public final void disable(@Nullable Context context, int what) {
        if (context == null) {
            return;
        }
        this.mImpl.disable(context, what);
    }

    public final int getDisableExpand() {
        return this.mImpl.getDisableExpand();
    }

    public final int getDisableNone() {
        return this.mImpl.getDisableNone();
    }

    private StatusBarManagerCompat(AbsStatusBarManagerCompatImplFactory.IStatusBarManagerCompatImpl iStatusBarManagerCompatImpl) {
        this.mImpl = iStatusBarManagerCompatImpl;
    }
}
