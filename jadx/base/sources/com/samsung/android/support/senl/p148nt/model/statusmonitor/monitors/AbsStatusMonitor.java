package com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\r\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\tJ\b\u0010\n\u001a\u00020\u0007H&R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/AbsStatusMonitor;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor;", "<init>", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$OnStatusChangeListener;", "setListener", "", "notifyChanged", "notifyChanged$ntModel_release", "release", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsStatusMonitor implements IStatusMonitor {

    @Nullable
    private IStatusMonitor.OnStatusChangeListener listener;

    @VisibleForTesting
    public final void notifyChanged$ntModel_release() {
        IStatusMonitor.OnStatusChangeListener onStatusChangeListener = this.listener;
        if (onStatusChangeListener != null) {
            onStatusChangeListener.onStateChanged(getValue());
        }
    }

    public abstract void release();

    @Override // com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor
    public void setListener(@Nullable IStatusMonitor.OnStatusChangeListener listener) {
        if (Intrinsics.areEqual(this.listener, listener)) {
            return;
        }
        this.listener = listener;
    }
}
