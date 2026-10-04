package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.content.Context;
import com.samsung.android.chimera.genie.SemMemRequest;
import com.samsung.android.chimera.genie.SemSmartMemoryManager;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/SmartMemoryManagerImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;", "isSemDevice", "", "SmartMemoryManagerCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SmartMemoryManagerImplFactory extends AbsSmartMemoryManagerImplFactory {

    @NotNull
    private static final String TAG = "AiSmartMemoryManagerImplFactory";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/SmartMemoryManagerImplFactory$SmartMemoryManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;", "<init>", "()V", "prepare", "", "context", "Landroid/content/Context;", "request", "type", "", "size", "release", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SmartMemoryManagerCompatSemImpl implements AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl
        public void prepare(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                SemSmartMemoryManager semSmartMemoryManager = SemSmartMemoryManager.getInstance(context);
                if (semSmartMemoryManager != null) {
                    semSmartMemoryManager.prepare();
                }
            } catch (NoClassDefFoundError unused) {
                LoggerBase.INSTANCE.m7133e(SmartMemoryManagerImplFactory.TAG, "not found prepare");
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl
        public void release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                SemSmartMemoryManager semSmartMemoryManager = SemSmartMemoryManager.getInstance(context);
                if (semSmartMemoryManager != null) {
                    semSmartMemoryManager.release();
                }
            } catch (NoClassDefFoundError unused) {
                LoggerBase.INSTANCE.m7133e(SmartMemoryManagerImplFactory.TAG, "not found release");
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl
        public void request(@NotNull Context context, int type, int size) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                SemSmartMemoryManager semSmartMemoryManager = SemSmartMemoryManager.getInstance(context);
                if (semSmartMemoryManager != null) {
                    semSmartMemoryManager.request(new SemMemRequest(type, size));
                }
            } catch (NoClassDefFoundError unused) {
                LoggerBase.INSTANCE.m7133e(SmartMemoryManagerImplFactory.TAG, "not found request");
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory
    @NotNull
    public AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl create(boolean isSemDevice) {
        return isSemDevice ? new SmartMemoryManagerCompatSemImpl() : super.create(isSemDevice);
    }
}
