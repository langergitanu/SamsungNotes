package com.samsung.android.support.senl.addons.base.model.screen.rotation;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/RotationEvent;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationEvent;", "target", "", "<init>", "(I)V", "mTarget", "getTargetAngle", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class RotationEvent implements IRotationEvent {
    private int mTarget;

    public RotationEvent(int i) {
        this.mTarget = i;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationEvent
    /* JADX INFO: renamed from: getTargetAngle, reason: from getter */
    public int getMTarget() {
        return this.mTarget;
    }
}
