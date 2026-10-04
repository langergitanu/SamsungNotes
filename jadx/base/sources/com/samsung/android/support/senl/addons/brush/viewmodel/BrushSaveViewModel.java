package com.samsung.android.support.senl.addons.brush.viewmodel;

import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveModel;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0013\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0014J\b\u0010\u0011\u001a\u00020\tH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushSaveViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "mSaveModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel;)V", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "setSettingsModel", "", "model", "perform", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", BrushSaveViewModel.BINDING_ID_ON_SAVE, "closeSubViewModels", "clearModels", "closeCallbacks", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushSaveViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_ON_SAVE = "onSave";

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushSaveViewModel");

    @Nullable
    private BrushSaveModel mSaveModel;

    @Nullable
    private SettingsModel mSettingsModel;

    public BrushSaveViewModel(@Nullable BrushSaveModel brushSaveModel) {
        this.mSaveModel = brushSaveModel;
    }

    private final void onSave() {
        Logger.m7100d(TAG, "onClick : Done Button");
        BrushSaveModel brushSaveModel = this.mSaveModel;
        Intrinsics.checkNotNull(brushSaveModel);
        brushSaveModel.saveAsync(Boolean.FALSE);
        SystemLogManager.INSTANCE.onDoneClicked();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        if (this.mSaveModel != null) {
            this.mSaveModel = null;
        }
        if (this.mSettingsModel != null) {
            this.mSettingsModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (action != null && Intrinsics.areEqual(BINDING_ID_ON_SAVE, action.getMBindId())) {
            onSave();
        }
        super.perform(action);
    }

    public final void setSettingsModel(@Nullable SettingsModel model) {
        this.mSettingsModel = model;
    }
}
