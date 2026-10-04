package com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors;

import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/UIStatusMonitor;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/AbsStatusMonitor;", "Lcom/samsung/android/support/senl/nt/base/common/ActivityLifecycleTracker$ApplicationLifecycleCallback;", "<init>", "()V", "value", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "getValue", "()Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "release", "", "onApplicationCreated", "onApplicationForeground", "onApplicationBackground", "onApplicationIdle", "onApplicationRunningCritical", "Value", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class UIStatusMonitor extends AbsStatusMonitor implements ActivityLifecycleTracker.ApplicationLifecycleCallback {

    @NotNull
    private final IStatusMonitor.Value value = new Value();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/UIStatusMonitor$Value;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "<init>", "()V", "value", "", "getValue", "()I", "setValue", "(I)V", "type", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "getType", "()Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "getIntValue", "getFloatValue", "", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Value implements IStatusMonitor.Value {

        @NotNull
        private final IStatusMonitor.Value.Types type = IStatusMonitor.Value.Types.Integer;
        private int value;

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        /* JADX INFO: renamed from: getFloatValue */
        public float getValue() {
            return this.value;
        }

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        /* JADX INFO: renamed from: getIntValue, reason: from getter */
        public int getValue() {
            return this.value;
        }

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        @NotNull
        public IStatusMonitor.Value.Types getType() {
            return this.type;
        }

        public final int getValue() {
            return this.value;
        }

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        public void setIntValue(int i) {
            IStatusMonitor.Value.DefaultImpls.setIntValue(this, i);
        }

        public final void setValue(int i) {
            this.value = i;
        }
    }

    public UIStatusMonitor() {
        ApplicationManager.INSTANCE.getInstance().getActivityTracker().addOnApplicationLifecycleCallback(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor
    @NotNull
    public IStatusMonitor.Value getValue() {
        return this.value;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
    public void onApplicationBackground() {
        notifyChanged$ntModel_release();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
    public void onApplicationForeground() {
        notifyChanged$ntModel_release();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
    public void onApplicationIdle() {
        notifyChanged$ntModel_release();
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
    public void onApplicationRunningCritical() {
        notifyChanged$ntModel_release();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.AbsStatusMonitor
    public void release() {
        ApplicationManager.INSTANCE.getInstance().getActivityTracker().removeOnApplicationLifecycleCallback(this);
    }

    @Override // com.samsung.android.support.senl.nt.base.common.ActivityLifecycleTracker.ApplicationLifecycleCallback
    public void onApplicationCreated() {
    }
}
