package com.samsung.android.support.senl.addons.brush.viewmodel.menu;

import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.brush.model.color.IMenuColorModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u0019J\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0019J\u0010\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010!J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0012R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/ColorViewModel;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/menu/AbsSelectionViewModel;", "model", "Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/color/IMenuColorModel;Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;)V", "mModel", "mSettingModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "getData", "", "id", "", "getColor", "", "getDescription", "setModel", "", "setSettingModel", "settingModel", "isEnabled", "", "closeSubViewModels", "clearModels", "closeCallbacks", "isSelected", "getPosition", "getEnabled", "getHSV", "", "setSelected", "selected", "setEnabled", ColorViewModel.BINDING_ID_ENABLED, "setColor", "hsvColor", "color", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ColorViewModel extends AbsSelectionViewModel {

    @NotNull
    private static final String BINDING_ID_COLOR = "color";

    @NotNull
    private static final String BINDING_ID_DESCRIPTION = "description";

    @NotNull
    private static final String BINDING_ID_ENABLED = "enabled";

    @Nullable
    private IBaseModel.Observer mCallback;

    @Nullable
    private IMenuColorModel mModel;

    @Nullable
    private SettingsModel mSettingModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorViewModel(@NotNull IMenuColorModel model, @Nullable IScreenModel iScreenModel) {
        super(iScreenModel);
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNull(iScreenModel);
        this.mCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.menu.ColorViewModel$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                if (id.intValue() == 20001) {
                    ColorViewModel colorViewModel = this.this$0;
                    IMenuColorModel iMenuColorModel = colorViewModel.mModel;
                    boolean z = false;
                    if (iMenuColorModel != null && iMenuColorModel.isSelected()) {
                        z = true;
                    }
                    colorViewModel.select(z);
                }
            }
        };
        setModel(model);
        IMenuColorModel iMenuColorModel = this.mModel;
        boolean z = false;
        if (iMenuColorModel != null && iMenuColorModel.isSelected()) {
            z = true;
        }
        select(z);
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.AbsSelectionViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            Intrinsics.checkNotNull(iMenuColorModel);
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            iMenuColorModel.removeObserver(observer);
        }
        this.mSettingModel = null;
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.AbsSelectionViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallback = null;
        super.closeCallbacks();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    public final int getColor() {
        IMenuColorModel iMenuColorModel = this.mModel;
        Integer numValueOf = iMenuColorModel != null ? Integer.valueOf(iMenuColorModel.getMColor()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.menu.AbsSelectionViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        if (id != null) {
            int iHashCode = id.hashCode();
            if (iHashCode != -1724546052) {
                if (iHashCode != -1609594047) {
                    if (iHashCode == 94842723 && id.equals("color")) {
                        return Integer.valueOf(getColor());
                    }
                } else if (id.equals(BINDING_ID_ENABLED)) {
                    return Boolean.valueOf(getEnabled());
                }
            } else if (id.equals(BINDING_ID_DESCRIPTION)) {
                return getDescription();
            }
        }
        return super.getData(id);
    }

    @Nullable
    public final String getDescription() {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            return iMenuColorModel.getDescription();
        }
        return null;
    }

    public final boolean getEnabled() {
        IMenuColorModel iMenuColorModel = this.mModel;
        return iMenuColorModel != null && iMenuColorModel.isEnabled();
    }

    @Nullable
    public final float[] getHSV() {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            return iMenuColorModel.getMHSV();
        }
        return null;
    }

    public final int getPosition() {
        IMenuColorModel iMenuColorModel = this.mModel;
        Integer numValueOf = iMenuColorModel != null ? Integer.valueOf(iMenuColorModel.getMPosition()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    public final boolean isEnabled() {
        IMenuColorModel iMenuColorModel = this.mModel;
        return iMenuColorModel != null && iMenuColorModel.isEnabled();
    }

    public final boolean isSelected() {
        IMenuColorModel iMenuColorModel = this.mModel;
        return iMenuColorModel != null && iMenuColorModel.isSelected();
    }

    public final void setColor(@Nullable float[] hsvColor) {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            iMenuColorModel.setColor(hsvColor);
        }
    }

    public final void setEnabled(boolean enabled) {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            iMenuColorModel.setEnabled(enabled);
        }
    }

    public final void setModel(@Nullable IMenuColorModel model) {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            Intrinsics.checkNotNull(iMenuColorModel);
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            iMenuColorModel.removeObserver(observer);
        }
        this.mModel = model;
        Intrinsics.checkNotNull(model);
        IBaseModel.Observer observer2 = this.mCallback;
        Intrinsics.checkNotNull(observer2);
        model.addObserver(observer2);
        if (isEnabled()) {
            IMenuColorModel iMenuColorModel2 = this.mModel;
            Intrinsics.checkNotNull(iMenuColorModel2);
            select(iMenuColorModel2.isSelected());
        }
    }

    public final void setSelected(boolean selected) {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            iMenuColorModel.select(selected);
        }
    }

    public final void setSettingModel(@Nullable SettingsModel settingModel) {
        this.mSettingModel = settingModel;
    }

    public final void setColor(int color) {
        IMenuColorModel iMenuColorModel = this.mModel;
        if (iMenuColorModel != null) {
            iMenuColorModel.setColor(color);
        }
    }
}
