package com.samsung.android.support.senl.addons.brush.viewmodel.submenu;

import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.IEraserViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/submenu/SubMenuViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsUndoRedoViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IEraserViewModel;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/submenu/ISubMenuViewModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "mFacadeCallback", "getData", "", "id", "", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "onUndoClicked", "onRedoClicked", "setSettingsModel", "model", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "onEraserClick", "getEraserSelection", "", "closeSubViewModels", "clearModels", "closeCallbacks", "getEraserEnabled", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SubMenuViewModel extends AbsUndoRedoViewModel implements IEraserViewModel, ISubMenuViewModel {

    @NotNull
    private static final String BINDING_ID_ERASER_CLICK = "eraserClick";

    @NotNull
    private static final String BINDING_ID_ERASER_ENABLE = "eraserEnable";

    @NotNull
    private static final String BINDING_ID_ERASER_SELECTION = "eraserSelection";

    @NotNull
    private static final String TAG = Logger.createBrushTag("SubMenuViewModel");

    @Nullable
    private IBaseModel.Observer mCallback;

    @Nullable
    private IBaseModel.Observer mFacadeCallback;

    public SubMenuViewModel(@Nullable IFacade iFacade) {
        super(iFacade);
        this.mCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.submenu.SubMenuViewModel$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                if (id.intValue() == 402) {
                    this.this$0.notifyChanged("eraserSelection");
                }
            }
        };
        this.mFacadeCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.submenu.SubMenuViewModel$mFacadeCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                int iIntValue = id.intValue();
                if (iIntValue == 11500) {
                    this.this$0.notifyChanged("eraserEnable");
                    return;
                }
                if (iIntValue == 11002 || iIntValue == 11003 || iIntValue == 11004 || iIntValue == 11005) {
                    this.this$0.onObjectChanged(iIntValue);
                } else if (this.this$0.isObjectChanged(iIntValue)) {
                    this.this$0.notifyChanged("eraserEnable");
                }
            }
        };
        IFacade mFacade = getMFacade();
        if (mFacade != null) {
            mFacade.addObserver(this.mFacadeCallback);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel, com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        SettingsModel mSettingsModel = getMSettingsModel();
        if (mSettingsModel != null) {
            mSettingsModel.removeObserver(this.mCallback);
        }
        IFacade mFacade = getMFacade();
        if (mFacade != null) {
            mFacade.removeObserver(this.mFacadeCallback);
        }
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallback = null;
        this.mFacadeCallback = null;
        super.closeCallbacks();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_ERASER_ENABLE, id) ? Boolean.valueOf(getEraserEnabled()) : Intrinsics.areEqual(BINDING_ID_ERASER_SELECTION, id) ? Boolean.valueOf(getEraserSelection()) : super.getData(id);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IEraserViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean getEraserEnabled() {
        boolean z;
        SettingsModel mSettingsModel;
        if (getMFacade() != null) {
            IFacade mFacade = getMFacade();
            Intrinsics.checkNotNull(mFacade);
            if (mFacade.getObjectCount() != null) {
                IFacade mFacade2 = getMFacade();
                Intrinsics.checkNotNull(mFacade2);
                Integer objectCount = mFacade2.getObjectCount();
                Intrinsics.checkNotNull(objectCount);
                z = objectCount.intValue() > 0;
            }
        }
        if (!z && (mSettingsModel = getMSettingsModel()) != null && mSettingsModel.getCurrentMode() == 4) {
            SettingsModel mSettingsModel2 = getMSettingsModel();
            Intrinsics.checkNotNull(mSettingsModel2);
            mSettingsModel2.setMode(2);
        }
        return z;
    }

    public final boolean getEraserSelection() {
        SettingsModel mSettingsModel = getMSettingsModel();
        return mSettingsModel != null && mSettingsModel.getCurrentMode() == 4;
    }

    public final void onEraserClick() {
        Logger.m7100d(TAG, "onEraserClick");
        SettingsModel mSettingsModel = getMSettingsModel();
        boolean z = false;
        if (mSettingsModel != null && mSettingsModel.getCurrentMode() == 4 && Intrinsics.areEqual(isDrawing(), Boolean.FALSE)) {
            SettingsModel mSettingsModel2 = getMSettingsModel();
            if (mSettingsModel2 != null) {
                SettingsModel mSettingsModel3 = getMSettingsModel();
                mSettingsModel2.setEraserSettingVisibility((mSettingsModel3 == null || mSettingsModel3.getEraserSettingVisibility()) ? false : true);
            }
        } else {
            SettingsModel mSettingsModel4 = getMSettingsModel();
            if (mSettingsModel4 != null && mSettingsModel4.getPenSettingVisibility()) {
                SystemLogManager.INSTANCE.onBrushEraserSettingPopupClose(2, false);
            }
            SettingsModel mSettingsModel5 = getMSettingsModel();
            if (mSettingsModel5 != null && mSettingsModel5.getEraserSettingVisibility()) {
                SystemLogManager.INSTANCE.onBrushEraserSettingPopupClose(2, true);
            }
            SettingsModel mSettingsModel6 = getMSettingsModel();
            if (mSettingsModel6 != null) {
                mSettingsModel6.clearAllPopupVisibility();
            }
            SettingsModel mSettingsModel7 = getMSettingsModel();
            if (mSettingsModel7 != null) {
                mSettingsModel7.setMode(4);
            }
        }
        SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
        SettingsModel mSettingsModel8 = getMSettingsModel();
        if (mSettingsModel8 != null && mSettingsModel8.getEraserSettingVisibility()) {
            z = true;
        }
        systemLogManager.onEraserClicked(z);
        notifyChanged("erase_button_click");
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel, com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public void onRedoClicked() {
        super.onRedoClicked();
        SystemLogManager.INSTANCE.onRedoClicked();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel, com.samsung.android.support.senl.addons.base.viewmodel.IUndoRedoViewModel
    public void onUndoClicked() {
        super.onUndoClicked();
        SystemLogManager.INSTANCE.onUndoClicked();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (Intrinsics.areEqual(BINDING_ID_ERASER_CLICK, action != null ? action.getMBindId() : null)) {
            onEraserClick();
        }
        super.perform(action);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsUndoRedoViewModel
    public void setSettingsModel(@NotNull SettingsModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setSettingsModel(model);
        SettingsModel mSettingsModel = getMSettingsModel();
        if (mSettingsModel != null) {
            mSettingsModel.addObserver(this.mCallback);
        }
    }
}
