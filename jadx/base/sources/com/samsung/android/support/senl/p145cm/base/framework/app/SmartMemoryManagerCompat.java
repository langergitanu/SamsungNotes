package com.samsung.android.support.senl.p145cm.base.framework.app;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.SmartMemoryManagerImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/SmartMemoryManagerCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;)V", "prepare", "", "context", "Landroid/content/Context;", "request", "type", "", "size", "release", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmartMemoryManagerCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MEMTYPE_CONTIGUOUS = 1;
    public static final int MEMTYPE_DEFAULT = 0;

    @NotNull
    private static final String TAG = "SmartMemoryManagerCompat";

    @Nullable
    private static SmartMemoryManagerCompat mInstance;

    @NotNull
    private final AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/SmartMemoryManagerCompat$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/SmartMemoryManagerCompat;", "MEMTYPE_DEFAULT", "", "MEMTYPE_CONTIGUOUS", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/SmartMemoryManagerCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized SmartMemoryManagerCompat getInstance() {
            SmartMemoryManagerCompat smartMemoryManagerCompat;
            try {
                if (SmartMemoryManagerCompat.mInstance == null) {
                    SmartMemoryManagerCompat.mInstance = new SmartMemoryManagerCompat(new SmartMemoryManagerImplFactory().create(DeviceInfo.isSemDevice() && SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500), null);
                }
                smartMemoryManagerCompat = SmartMemoryManagerCompat.mInstance;
                Intrinsics.checkNotNull(smartMemoryManagerCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.SmartMemoryManagerCompat");
            } catch (Throwable th) {
                throw th;
            }
            return smartMemoryManagerCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ SmartMemoryManagerCompat(AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl iSmartMemoryManagerCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iSmartMemoryManagerCompatImpl);
    }

    @NotNull
    public static final synchronized SmartMemoryManagerCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final void prepare(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mImpl.prepare(context);
    }

    public final void release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mImpl.release(context);
    }

    public final void request(@NotNull Context context, int type, int size) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mImpl.request(context, type, size);
    }

    private SmartMemoryManagerCompat(AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl iSmartMemoryManagerCompatImpl) {
        this.mImpl = iSmartMemoryManagerCompatImpl;
    }
}
