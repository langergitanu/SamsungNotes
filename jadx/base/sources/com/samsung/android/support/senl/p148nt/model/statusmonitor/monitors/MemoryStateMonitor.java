package com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors;

import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/MemoryStateMonitor;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/AbsStatusMonitor;", "<init>", "()V", "value", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "getValue", "()Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "release", "", Constants.ARG_UPDATE, "Value", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MemoryStateMonitor extends AbsStatusMonitor {

    @NotNull
    private final IStatusMonitor.Value value = new Value();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/MemoryStateMonitor$Value;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "<init>", "()V", "value", "", "getValue", "()F", "setValue", "(F)V", "type", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "getType", "()Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "getIntValue", "", "getFloatValue", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Value implements IStatusMonitor.Value {

        @NotNull
        private final IStatusMonitor.Value.Types type = IStatusMonitor.Value.Types.Integer;
        private float value;

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        /* JADX INFO: renamed from: getFloatValue, reason: from getter */
        public float getValue() {
            return this.value;
        }

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        public int getIntValue() {
            return (int) this.value;
        }

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        @NotNull
        public IStatusMonitor.Value.Types getType() {
            return this.type;
        }

        public final float getValue() {
            return this.value;
        }

        @Override // com.samsung.android.support.senl.nt.model.statusmonitor.monitors.IStatusMonitor.Value
        public void setIntValue(int i) {
            IStatusMonitor.Value.DefaultImpls.setIntValue(this, i);
        }

        public final void setValue(float f) {
            this.value = f;
        }
    }

    public MemoryStateMonitor() {
        update();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor
    @NotNull
    public IStatusMonitor.Value getValue() {
        return this.value;
    }

    public final void update() {
        notifyChanged$ntModel_release();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.AbsStatusMonitor
    public void release() {
    }
}
