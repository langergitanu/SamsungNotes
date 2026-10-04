package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;", "isSemDevice", "", "ISmartMemoryManagerCompatImpl", "SmartMemoryManagerCompatPurImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsSmartMemoryManagerImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;", "", "prepare", "", "context", "Landroid/content/Context;", "request", "type", "", "size", "release", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ISmartMemoryManagerCompatImpl {
        void prepare(@NotNull Context context);

        void release(@NotNull Context context);

        void request(@NotNull Context context, int type, int size);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$SmartMemoryManagerCompatPurImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsSmartMemoryManagerImplFactory$ISmartMemoryManagerCompatImpl;", "<init>", "()V", "prepare", "", "context", "Landroid/content/Context;", "request", "type", "", "size", "release", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SmartMemoryManagerCompatPurImpl implements ISmartMemoryManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl
        public void prepare(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl
        public void release(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsSmartMemoryManagerImplFactory.ISmartMemoryManagerCompatImpl
        public void request(@NotNull Context context, int type, int size) {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    @NotNull
    public ISmartMemoryManagerCompatImpl create(boolean isSemDevice) {
        return new SmartMemoryManagerCompatPurImpl();
    }
}
