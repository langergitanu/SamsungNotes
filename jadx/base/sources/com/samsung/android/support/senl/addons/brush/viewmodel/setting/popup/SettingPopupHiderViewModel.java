package com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup;

import android.view.MotionEvent;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.event.ITouchEvent;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\fH\u0014J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u0019\u001a\u00020\fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/setting/popup/SettingPopupHiderViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/AbsBaseViewModel;", "model", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;)V", "mModel", "mIsActived", "", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "perform", "", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "performTouch", "getData", "", "id", "", "hide", "getIsHide", "closeSubViewModels", "clearModels", "closeCallbacks", "close", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingPopupHiderViewModel extends AbsBaseViewModel {

    @NotNull
    private static final String BINDING_ID_IS_HIDE = "isHide";

    @NotNull
    private static final String TAG = Logger.createBrushTag("SettingPopupHiderViewModel");

    @Nullable
    private IBaseModel.Observer mCallback;
    private boolean mIsActived;

    @Nullable
    private SettingsModel mModel;

    public SettingPopupHiderViewModel(@Nullable SettingsModel settingsModel) {
        SettingsModel settingsModel2;
        SettingsModel settingsModel3;
        SettingsModel settingsModel4;
        IBaseModel.Observer observer = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.setting.popup.SettingPopupHiderViewModel$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                int iIntValue = id.intValue();
                boolean z = this.this$0.mIsActived;
                boolean z2 = false;
                if (iIntValue == 501) {
                    SettingPopupHiderViewModel settingPopupHiderViewModel = this.this$0;
                    SettingsModel settingsModel5 = settingPopupHiderViewModel.mModel;
                    if (settingsModel5 != null && settingsModel5.getPenSettingVisibility()) {
                        z2 = true;
                    }
                    settingPopupHiderViewModel.mIsActived = z2;
                } else if (iIntValue == 502) {
                    SettingPopupHiderViewModel settingPopupHiderViewModel2 = this.this$0;
                    SettingsModel settingsModel6 = settingPopupHiderViewModel2.mModel;
                    if (settingsModel6 != null && settingsModel6.getEraserSettingVisibility()) {
                        z2 = true;
                    }
                    settingPopupHiderViewModel2.mIsActived = z2;
                } else if (iIntValue == 504) {
                    SettingPopupHiderViewModel settingPopupHiderViewModel3 = this.this$0;
                    SettingsModel settingsModel7 = settingPopupHiderViewModel3.mModel;
                    if (settingsModel7 != null && settingsModel7.getColorGradationVisibility()) {
                        z2 = true;
                    }
                    settingPopupHiderViewModel3.mIsActived = z2;
                } else if (iIntValue == 506) {
                    SettingPopupHiderViewModel settingPopupHiderViewModel4 = this.this$0;
                    SettingsModel settingsModel8 = settingPopupHiderViewModel4.mModel;
                    if (settingsModel8 != null && settingsModel8.getPaletteSettingVisibility()) {
                        z2 = true;
                    }
                    settingPopupHiderViewModel4.mIsActived = z2;
                }
                if (!z || this.this$0.mIsActived) {
                    return;
                }
                this.this$0.notifyChanged("isHide");
            }
        };
        this.mCallback = observer;
        this.mModel = settingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(observer);
            settingsModel.addObserver(observer);
        }
        SettingsModel settingsModel5 = this.mModel;
        boolean z = true;
        if ((settingsModel5 == null || !settingsModel5.getPenSettingVisibility()) && (((settingsModel2 = this.mModel) == null || !settingsModel2.getEraserSettingVisibility()) && (((settingsModel3 = this.mModel) == null || !settingsModel3.getColorGradationVisibility()) && ((settingsModel4 = this.mModel) == null || !settingsModel4.getPaletteSettingVisibility())))) {
            z = false;
        }
        this.mIsActived = z;
    }

    private final void performTouch(IBaseViewModel.Action action) {
        MotionEvent mMotionEvent;
        ITouchEvent iTouchEvent = (ITouchEvent) action.getData();
        Integer numValueOf = (iTouchEvent == null || (mMotionEvent = iTouchEvent.getMMotionEvent()) == null) ? null : Integer.valueOf(mMotionEvent.getAction());
        if (((numValueOf != null && numValueOf.intValue() == 0) || (numValueOf != null && numValueOf.intValue() == 211)) && this.mIsActived) {
            Logger.m7100d(TAG, "onTouch : hide popups");
            hide();
            SystemLogManager systemLogManager = SystemLogManager.INSTANCE;
            SettingsModel settingsModel = this.mModel;
            Intrinsics.checkNotNull(settingsModel);
            systemLogManager.onBrushEraserSettingPopupClose(1, settingsModel.getEraserSettingVisibility());
        }
        action.setResult(Boolean.FALSE);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        SettingsModel settingsModel = this.mModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            IBaseModel.Observer observer = this.mCallback;
            Intrinsics.checkNotNull(observer);
            settingsModel.removeObserver(observer);
            this.mModel = null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void close() {
        this.mIsActived = false;
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallback = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        Logger.m7100d(TAG, "getData. " + id);
        return Intrinsics.areEqual(BINDING_ID_IS_HIDE, id) ? Boolean.valueOf(getIsHide()) : super.getData(id);
    }

    public final boolean getIsHide() {
        return !this.mIsActived;
    }

    public final void hide() {
        SettingsModel settingsModel = this.mModel;
        if (settingsModel == null) {
            return;
        }
        Intrinsics.checkNotNull(settingsModel);
        settingsModel.setPenSettingVisibility(false);
        SettingsModel settingsModel2 = this.mModel;
        Intrinsics.checkNotNull(settingsModel2);
        settingsModel2.setEraserSettingVisibility(false);
        SettingsModel settingsModel3 = this.mModel;
        Intrinsics.checkNotNull(settingsModel3);
        settingsModel3.setColorGradationVisibility(false);
        SettingsModel settingsModel4 = this.mModel;
        Intrinsics.checkNotNull(settingsModel4);
        settingsModel4.setPaletteSettingVisibility(false);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (Intrinsics.areEqual("action_touch", action != null ? action.getMTypeId() : null)) {
            performTouch(action);
        }
    }
}
