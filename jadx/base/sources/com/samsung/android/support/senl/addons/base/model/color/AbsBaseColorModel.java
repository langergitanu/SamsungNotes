package com.samsung.android.support.senl.addons.base.model.color;

import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001a\u0010\t\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/color/AbsBaseColorModel;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/color/IBaseColorModel;", "color", "", "<init>", "(I)V", "position", "(II)V", "mColor", "getMColor", "()I", "setMColor", "mPosition", "setColor", "", "getColor", "setPosition", "getPosition", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsBaseColorModel extends AbsBaseModel implements IBaseColorModel {
    private static final int UNKNOWN_MODE = -1048576;
    private int mColor;
    private int mPosition;

    public AbsBaseColorModel(int i) {
        this(i, -1048576);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    /* JADX INFO: renamed from: getColor, reason: from getter */
    public int getMColor() {
        return this.mColor;
    }

    public final int getMColor() {
        return this.mColor;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    /* JADX INFO: renamed from: getPosition, reason: from getter */
    public int getMPosition() {
        return this.mPosition;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    public void setColor(int color) {
        if (this.mColor != color) {
            this.mColor = color;
            notifyChanged(201);
        }
    }

    public final void setMColor(int i) {
        this.mColor = i;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.color.IBaseColorModel
    public void setPosition(int position) {
        this.mPosition = position;
    }

    public AbsBaseColorModel(int i, int i2) {
        this.mColor = i;
        this.mPosition = i2;
    }
}
