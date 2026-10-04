package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.app.Activity;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsAiResultViewOnSidePanelCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AiResultViewOnSidePanelCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/AiResultViewOnSidePanelCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory$IAiResultViewOnSidePanelCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsAiResultViewOnSidePanelCompatImplFactory$IAiResultViewOnSidePanelCompatImpl;)V", "init", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "view", "Landroid/view/View;", "closeSidePanel", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultViewOnSidePanelCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static AiResultViewOnSidePanelCompat sInstance;

    @NotNull
    private final AbsAiResultViewOnSidePanelCompatImplFactory.IAiResultViewOnSidePanelCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/AiResultViewOnSidePanelCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/AiResultViewOnSidePanelCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/AiResultViewOnSidePanelCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized AiResultViewOnSidePanelCompat getInstance() {
            AiResultViewOnSidePanelCompat aiResultViewOnSidePanelCompat;
            try {
                if (AiResultViewOnSidePanelCompat.sInstance == null) {
                    AiResultViewOnSidePanelCompat.sInstance = new AiResultViewOnSidePanelCompat(new AiResultViewOnSidePanelCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                aiResultViewOnSidePanelCompat = AiResultViewOnSidePanelCompat.sInstance;
                Intrinsics.checkNotNull(aiResultViewOnSidePanelCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.AiResultViewOnSidePanelCompat");
            } catch (Throwable th) {
                throw th;
            }
            return aiResultViewOnSidePanelCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AiResultViewOnSidePanelCompat(AbsAiResultViewOnSidePanelCompatImplFactory.IAiResultViewOnSidePanelCompatImpl iAiResultViewOnSidePanelCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iAiResultViewOnSidePanelCompatImpl);
    }

    public final void closeSidePanel() {
        this.mImpl.closeSidePanel();
    }

    public final void init(@Nullable Activity activity, @Nullable View view) {
        this.mImpl.init(activity, view);
    }

    private AiResultViewOnSidePanelCompat(AbsAiResultViewOnSidePanelCompatImplFactory.IAiResultViewOnSidePanelCompatImpl iAiResultViewOnSidePanelCompatImpl) {
        this.mImpl = iAiResultViewOnSidePanelCompatImpl;
    }
}
