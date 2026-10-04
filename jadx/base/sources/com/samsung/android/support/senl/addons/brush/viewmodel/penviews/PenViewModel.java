package com.samsung.android.support.senl.addons.brush.viewmodel.penviews;

import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.addons.base.model.pen.IPenModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\fH\u0014J\b\u0010\u001f\u001a\u00020\fH\u0014J\b\u0010 \u001a\u00020\fH\u0014J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020$H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/PenViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penviews/IPenViewModel;", "<init>", "()V", "mPenModel", "Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel;", "setPenModel", "penModel", "getColor", "", "setColor", "", "color", "getPenName", "", "setSelected", "selected", "", "isSelected", "getSize", "setSize", "size", "hasAlpha", "getAlpha", "", "setAlpha", "alphaColor", "getPenClass", "getPenSize", "clearModels", "closeSubViewModels", "closeCallbacks", "close", "getAlphaColor", "getInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PenViewModel extends AbsBaseViewModel implements IPenViewModel {

    @Nullable
    private IPenModel mPenModel;

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void close() {
        notifyChanged(IPenViewModel.INSTANCE.getOBSV_VM_PEN_DESTORYED());
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public float getAlpha() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getAlpha();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public int getAlphaColor() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getAlphaColor();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public int getColor() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getMColor();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    @NotNull
    public SpenSettingUIPenInfo getInfo() {
        SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
        String penClass = getPenClass();
        if (penClass == null) {
            penClass = "";
        }
        spenSettingUIPenInfo.name = penClass;
        spenSettingUIPenInfo.color = getAlphaColor();
        spenSettingUIPenInfo.sizeLevel = getSize() + 1;
        spenSettingUIPenInfo.particleDensity = getSize() + 1;
        return spenSettingUIPenInfo;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    @Nullable
    public String getPenClass() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getMPenClassName();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    @Nullable
    public String getPenName() {
        IPenModel iPenModel = this.mPenModel;
        if (iPenModel != null) {
            return iPenModel.getMPenType();
        }
        return null;
    }

    public final float getPenSize() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getPenSize();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public int getSize() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getMPenThickness();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public boolean hasAlpha() {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.hasAlpha();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public boolean isSelected() {
        IPenModel iPenModel = this.mPenModel;
        if (iPenModel != null) {
            return iPenModel.getMIsSelected();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public void setAlpha(int alphaColor) {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        iPenModel.setAlpha(((alphaColor >> 24) & 255) / 255.0f);
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public void setColor(int color) {
        IPenModel iPenModel = this.mPenModel;
        if (iPenModel != null) {
            iPenModel.setColor(color);
        }
    }

    @NotNull
    public final PenViewModel setPenModel(@NotNull IPenModel penModel) {
        Intrinsics.checkNotNullParameter(penModel, "penModel");
        this.mPenModel = penModel;
        return this;
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public void setSelected(boolean selected) {
        String obsv_vm_pen_reselected;
        if (selected) {
            IPenModel iPenModel = this.mPenModel;
            Intrinsics.checkNotNull(iPenModel);
            iPenModel.setEnabled(true);
        }
        IPenModel iPenModel2 = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel2);
        if (iPenModel2.getMIsSelected() != selected) {
            IPenModel iPenModel3 = this.mPenModel;
            Intrinsics.checkNotNull(iPenModel3);
            iPenModel3.setSelected(selected);
            obsv_vm_pen_reselected = IPenViewModel.INSTANCE.getOBSV_VM_PEN_CHANGED();
        } else {
            obsv_vm_pen_reselected = IPenViewModel.INSTANCE.getOBSV_VM_PEN_RESELECTED();
        }
        if (selected) {
            notifyChanged(obsv_vm_pen_reselected);
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penviews.IPenViewModel
    public void setSize(int size) {
        IPenModel iPenModel = this.mPenModel;
        Intrinsics.checkNotNull(iPenModel);
        iPenModel.setPenSize(size);
    }
}
