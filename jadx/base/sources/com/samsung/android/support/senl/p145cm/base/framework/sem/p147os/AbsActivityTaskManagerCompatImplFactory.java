package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.app.ActivityManager;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$SemActivityTaskManagerDelegateImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "TaskChangeCallback", "SemActivityTaskManagerDelegateImpl", "Pure", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsActivityTaskManagerCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$SemActivityTaskManagerDelegateImpl;", "", "registerTaskChangeCallback", "", "taskChangeCallback", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$TaskChangeCallback;", "unregisterTaskChangeCallback", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SemActivityTaskManagerDelegateImpl {
        void registerTaskChangeCallback(@Nullable TaskChangeCallback taskChangeCallback);

        void unregisterTaskChangeCallback(@Nullable TaskChangeCallback taskChangeCallback);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$TaskChangeCallback;", "", "onTaskMovedToBack", "", "runningTaskInfo", "Landroid/app/ActivityManager$RunningTaskInfo;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TaskChangeCallback {
        void onTaskMovedToBack(@Nullable ActivityManager.RunningTaskInfo runningTaskInfo);
    }

    @NotNull
    public SemActivityTaskManagerDelegateImpl create(int deviceType) {
        return new Pure();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$Pure;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$SemActivityTaskManagerDelegateImpl;", "<init>", "()V", "registerTaskChangeCallback", "", "taskChangeCallback", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsActivityTaskManagerCompatImplFactory$TaskChangeCallback;", "unregisterTaskChangeCallback", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Pure implements SemActivityTaskManagerDelegateImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsActivityTaskManagerCompatImplFactory.SemActivityTaskManagerDelegateImpl
        public void registerTaskChangeCallback(@Nullable TaskChangeCallback taskChangeCallback) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsActivityTaskManagerCompatImplFactory.SemActivityTaskManagerDelegateImpl
        public void unregisterTaskChangeCallback(@Nullable TaskChangeCallback taskChangeCallback) {
        }
    }
}
