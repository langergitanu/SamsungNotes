package com.samsung.android.support.senl.addons.brush.viewmodel;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.SimpleChangeListener;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.AbsLifeCycleObserver;
import com.samsung.android.support.senl.addons.brush.model.BrushModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.canvas.PreviewImageViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.panningbar.PanningBarViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.penup.PenupViewModel;
import com.samsung.android.support.senl.addons.brush.viewmodel.submenu.SubMenuViewModel;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u0010J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001dH\u0014J\b\u0010\"\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMainViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsLifeCycleObserver;", "model", "Lcom/samsung/android/support/senl/addons/brush/model/BrushModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/BrushModel;)V", "mModel", "mPenupVM", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penup/PenupViewModel;", "mPanningVM", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/panningbar/PanningBarViewModel;", "mSaveVM", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushSaveViewModel;", "mSubmenuVM", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/submenu/SubMenuViewModel;", "mPreviewVM", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/canvas/PreviewImageViewModel;", "getData", "", "id", "", "getPenupViewModel", "getPanningViewModel", "getSaveViewModel", "getSubMenuViewModel", "getPreviewImageViewModel", "popupChangeListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView$IChangeListener;", "setOrientation", "", "orientation", "", "onOptionItemSelected", "closeSubViewModels", "clearModels", "onBLEEvent", "eventId", "Companion", "SettingViewChangeListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushMainViewModel extends AbsLifeCycleObserver {

    @NotNull
    private static final String BINDING_ID_INFLATED = "inflated";

    @NotNull
    private static final String BINDING_ID_MAIN_VIEW_MODEL = "mainViewModel";

    @NotNull
    private static final String BINDING_ID_SETTING_POPUP_LISTENER = "settingPopupListener";

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushMainViewModel");

    @Nullable
    private BrushModel mModel;

    @Nullable
    private PanningBarViewModel mPanningVM;

    @Nullable
    private PenupViewModel mPenupVM;

    @Nullable
    private PreviewImageViewModel mPreviewVM;

    @Nullable
    private BrushSaveViewModel mSaveVM;

    @Nullable
    private SubMenuViewModel mSubmenuVM;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMainViewModel$SettingViewChangeListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/SimpleChangeListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/viewmodel/BrushMainViewModel;)V", "onClearAll", "", "onSpuitVisibilityChanged", "visible", "", "onColorPicked", "color", "", "x", "", "y", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class SettingViewChangeListener extends SimpleChangeListener {
        public SettingViewChangeListener() {
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.SimpleChangeListener, com.samsung.android.sdk.pen.setting.SpenSettingRemoverLayout.EventListener
        public void onClearAll() {
            SettingsModel settingsModel;
            Logger.m7100d(BrushMainViewModel.TAG, "onClearAll");
            IFacade mFacade = BrushMainViewModel.this.getMFacade();
            if (mFacade != null) {
                mFacade.clearAll();
            }
            BrushModel brushModel = BrushMainViewModel.this.mModel;
            if (brushModel != null && (settingsModel = brushModel.getSettingsModel()) != null) {
                settingsModel.setMode(2);
            }
            BrushMainViewModel.this.notifyChanged("erase_all_button_click");
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.SimpleChangeListener, com.samsung.android.sdk.pen.engine.SpenColorPickerListener
        public void onColorPicked(int color, float x, float y2) {
            Logger.m7100d(BrushMainViewModel.TAG, "onColorPicked. " + Integer.toHexString(color) + SQLKeyword.COMMA + x + "x" + y2);
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.SimpleChangeListener, com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ICommonSettingView.IChangeListener
        public void onSpuitVisibilityChanged(boolean visible) {
            AbstractC6670b.m4764y("onSpuitVisibilityChanged. ", BrushMainViewModel.TAG, visible);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrushMainViewModel(@NotNull BrushModel model) {
        super(model, model.getMFacade());
        Intrinsics.checkNotNullParameter(model, "model");
        Logger.m7100d(TAG, "construct");
        this.mModel = model;
        this.mPenupVM = new PenupViewModel(getMFacade());
        this.mPanningVM = new PanningBarViewModel(getMFacade(), null);
        this.mSaveVM = new BrushSaveViewModel(model.getMSaveModel());
        this.mSubmenuVM = new SubMenuViewModel(model.getMFacade());
        this.mPreviewVM = new PreviewImageViewModel(model.getMFacade());
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsModelControlViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        this.mModel = null;
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
        PenupViewModel penupViewModel = this.mPenupVM;
        if (penupViewModel != null) {
            penupViewModel.close();
        }
        this.mPenupVM = null;
        PanningBarViewModel panningBarViewModel = this.mPanningVM;
        if (panningBarViewModel != null) {
            panningBarViewModel.close();
        }
        this.mPanningVM = null;
        BrushSaveViewModel brushSaveViewModel = this.mSaveVM;
        if (brushSaveViewModel != null) {
            brushSaveViewModel.close();
        }
        this.mSaveVM = null;
        SubMenuViewModel subMenuViewModel = this.mSubmenuVM;
        if (subMenuViewModel != null) {
            subMenuViewModel.close();
        }
        this.mSubmenuVM = null;
        PreviewImageViewModel previewImageViewModel = this.mPreviewVM;
        if (previewImageViewModel != null) {
            previewImageViewModel.close();
        }
        this.mPreviewVM = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsLifeCycleObserver, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_INFLATED, id) ? getInflateCallback() : Intrinsics.areEqual(BINDING_ID_MAIN_VIEW_MODEL, id) ? this : Intrinsics.areEqual(BINDING_ID_SETTING_POPUP_LISTENER, id) ? popupChangeListener() : super.getData(id);
    }

    @NotNull
    public final PanningBarViewModel getPanningViewModel() {
        PanningBarViewModel panningBarViewModel = this.mPanningVM;
        Intrinsics.checkNotNull(panningBarViewModel);
        return panningBarViewModel;
    }

    @NotNull
    public final PenupViewModel getPenupViewModel() {
        PenupViewModel penupViewModel = this.mPenupVM;
        Intrinsics.checkNotNull(penupViewModel);
        return penupViewModel;
    }

    @NotNull
    public final PreviewImageViewModel getPreviewImageViewModel() {
        PreviewImageViewModel previewImageViewModel = this.mPreviewVM;
        Intrinsics.checkNotNull(previewImageViewModel);
        return previewImageViewModel;
    }

    @NotNull
    public final BrushSaveViewModel getSaveViewModel() {
        BrushSaveViewModel brushSaveViewModel = this.mSaveVM;
        Intrinsics.checkNotNull(brushSaveViewModel);
        return brushSaveViewModel;
    }

    @NotNull
    public final SubMenuViewModel getSubMenuViewModel() {
        SubMenuViewModel subMenuViewModel = this.mSubmenuVM;
        Intrinsics.checkNotNull(subMenuViewModel);
        return subMenuViewModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsLifeCycleObserver, com.samsung.android.support.senl.addons.base.model.bleremote.IBLEListener
    public void onBLEEvent(int eventId) {
        if (eventId == 0) {
            Logger.m7100d(TAG, "BLE_SINGLE_PRESS");
            notifyChanged("ble_single_press");
            return;
        }
        if (eventId == 1) {
            Logger.m7100d(TAG, "BLE_SINGLE_PRESS(SECOND)");
            notifyChanged("ble_single_press_type_2");
            return;
        }
        if (eventId != 100) {
            super.onBLEEvent(eventId);
            return;
        }
        String str = TAG;
        BrushModel brushModel = this.mModel;
        Intrinsics.checkNotNull(brushModel);
        SettingsModel settingsModel = brushModel.getSettingsModel();
        Intrinsics.checkNotNull(settingsModel);
        AbstractC6670b.m4761v(settingsModel.getCurrentMode(), "BLE_DOUBLE_PRESS. mode=", str);
        BrushModel brushModel2 = this.mModel;
        Intrinsics.checkNotNull(brushModel2);
        SettingsModel settingsModel2 = brushModel2.getSettingsModel();
        Intrinsics.checkNotNull(settingsModel2);
        if (settingsModel2.getCurrentMode() == 4) {
            BrushModel brushModel3 = this.mModel;
            Intrinsics.checkNotNull(brushModel3);
            SettingsModel settingsModel3 = brushModel3.getSettingsModel();
            Intrinsics.checkNotNull(settingsModel3);
            settingsModel3.setMode(2);
            notifyChanged("ble_double_press");
            return;
        }
        SubMenuViewModel subMenuViewModel = this.mSubmenuVM;
        if (subMenuViewModel != null) {
            Intrinsics.checkNotNull(subMenuViewModel);
            if (subMenuViewModel.getEraserEnabled()) {
                SubMenuViewModel subMenuViewModel2 = this.mSubmenuVM;
                Intrinsics.checkNotNull(subMenuViewModel2);
                subMenuViewModel2.onEraserClick();
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsLifeCycleObserver, com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl
    public void onOptionItemSelected(int id) {
        super.onOptionItemSelected(id);
        if (id == 3002) {
            SubMenuViewModel subMenuViewModel = this.mSubmenuVM;
            Intrinsics.checkNotNull(subMenuViewModel);
            subMenuViewModel.onUndoClicked();
        } else {
            if (id != 3003) {
                return;
            }
            SubMenuViewModel subMenuViewModel2 = this.mSubmenuVM;
            Intrinsics.checkNotNull(subMenuViewModel2);
            subMenuViewModel2.onRedoClicked();
        }
    }

    @Nullable
    public ISettingView.IChangeListener popupChangeListener() {
        return new SettingViewChangeListener();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.AbsLifeCycleObserver, com.samsung.android.support.senl.addons.base.model.screen.IOrientationMode
    public void setOrientation(int orientation) {
    }
}
