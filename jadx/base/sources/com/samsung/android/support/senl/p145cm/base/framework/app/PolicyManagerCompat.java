package com.samsung.android.support.senl.p145cm.base.framework.app;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.PolicyManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/PolicyManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsPolicyManagerCompatImplFactory$IPolicyManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsPolicyManagerCompatImplFactory$IPolicyManagerCompatImpl;)V", "isEdmPolicyAiEnabled", "", "context", "Landroid/content/Context;", "isEdmPolicyAiGrayout", "isEdmPolicyAiDrawingEnabled", "isEdmPolicyAiDrawingGrayout", "updateKnoxRestrictions", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PolicyManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static PolicyManagerCompat sInstance;

    @NotNull
    private final AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/PolicyManagerCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/PolicyManagerCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/PolicyManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized PolicyManagerCompat getInstance() {
            PolicyManagerCompat policyManagerCompat;
            try {
                if (PolicyManagerCompat.sInstance == null) {
                    PolicyManagerCompat.sInstance = new PolicyManagerCompat(new PolicyManagerCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                policyManagerCompat = PolicyManagerCompat.sInstance;
                Intrinsics.checkNotNull(policyManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.PolicyManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return policyManagerCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PolicyManagerCompat(AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl iPolicyManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iPolicyManagerCompatImpl);
    }

    public final boolean isEdmPolicyAiDrawingEnabled(@Nullable Context context) {
        return this.mImpl.isEdmPolicyAiDrawingEnabled(context);
    }

    public final boolean isEdmPolicyAiDrawingGrayout(@Nullable Context context) {
        return this.mImpl.isEdmPolicyAiDrawingGrayout(context);
    }

    public final boolean isEdmPolicyAiEnabled(@Nullable Context context) {
        return this.mImpl.isEdmPolicyAiEnabled(context);
    }

    public final boolean isEdmPolicyAiGrayout(@Nullable Context context) {
        return this.mImpl.isEdmPolicyAiGrayout(context);
    }

    public final void updateKnoxRestrictions(@Nullable Context context) {
        this.mImpl.updateKnoxRestrictions(context);
    }

    private PolicyManagerCompat(AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl iPolicyManagerCompatImpl) {
        this.mImpl = iPolicyManagerCompatImpl;
    }
}
