package com.samsung.android.support.senl.addons.base.model.screen.rotation;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/RotationExtraEvent;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/RotationEvent;", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationExtraEvent;", "target", "", "data", "dataType", "<init>", "(III)V", "mExtraData", "mDataType", "getExtraData", "getExtraDataType", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RotationExtraEvent extends RotationEvent implements IRotationExtraEvent {
    private int mDataType;
    private int mExtraData;

    public RotationExtraEvent(int i, int i2, int i4) {
        super(i);
        this.mExtraData = i2;
        this.mDataType = i4;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationExtraEvent
    /* JADX INFO: renamed from: getExtraData, reason: from getter */
    public int getMExtraData() {
        return this.mExtraData;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationExtraEvent
    /* JADX INFO: renamed from: getExtraDataType, reason: from getter */
    public int getMDataType() {
        return this.mDataType;
    }
}
