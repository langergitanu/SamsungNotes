package com.samsung.android.support.senl.addons.base.viewmodel;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Size;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl;
import com.samsung.android.support.senl.addons.base.model.ILifeCycleController;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer;
import com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenData;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0002KLB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J \u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J \u0010(\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020$H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010*\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020&H\u0016J\u0012\u0010/\u001a\u00020\u00152\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020$H\u0016J\b\u00104\u001a\u00020$H\u0016J\u0010\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020$H\u0016J\u0012\u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020$H\u0016J\u0012\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020\u00152\u0006\u0010?\u001a\u00020&H\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020$H\u0016J\b\u0010C\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020EH\u0016J\b\u0010G\u001a\u00020AH\u0016J\u0010\u0010H\u001a\u00020\u00152\u0006\u0010I\u001a\u00020JH\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsLifeCycleObserver;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsModelControlViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/IActivityLifeCycleObserver;", "model", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;)V", "mInstanceModel", "getMInstanceModel", "()Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "setMInstanceModel", "(Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;)V", "getData", "", "id", "", "getInflateCallback", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer$OnInflateCallback;", "onCreate", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onStart", "onResume", "onPause", "onStop", "onDestroyView", "onDestroy", "onKeyDown", "keycode", "", "withCtrl", "", "withShift", "onKeyUp", "onBLEEvent", "eventId", "onDispatchEvent", "onBack", "onMultiWindowModeChanged", "isInMultiWndowMode", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setOrientation", "orientation", "getOrientation", "setWindowType", "windowType", "setLifeCycleController", "control", "Lcom/samsung/android/support/senl/addons/base/model/ILifeCycleController;", "onOptionItemSelected", "setOptionChangeCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/addons/base/model/IBaseOptionItemControl$IOptionChangeCallback;", "onFinishDocumentByUser", "save", "getScreenSize", "Landroid/util/Size;", "getScreenResolution", "getContentScreenSize", "getContentResolution", "", "getWindowResolution", "getWindowSize", "updateScreenData", "data", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenData;", "Companion", "OnInflateCallback", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsLifeCycleObserver extends AbsModelControlViewModel implements IActivityLifeCycleObserver {

    @NotNull
    private static final String BINDING_ID_INFLATE_CALLBACK = "inflateCallback";

    @NotNull
    private static final String BINDING_ID_ORIENTATION = "orientation";

    @Nullable
    private IInstanceModel mInstanceModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsLifeCycleObserver$OnInflateCallback;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer$OnInflateCallback;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/viewmodel/AbsLifeCycleObserver;)V", "onInflated", "", "container", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class OnInflateCallback implements ICanvasContainer.OnInflateCallback {
        public OnInflateCallback() {
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer.OnInflateCallback
        public void onInflated(@Nullable ICanvasContainer container) {
            IInstanceModel mInstanceModel = AbsLifeCycleObserver.this.getMInstanceModel();
            Boolean boolValueOf = mInstanceModel != null ? Boolean.valueOf(mInstanceModel.getMIsClosed()) : null;
            Intrinsics.checkNotNull(boolValueOf);
            if (boolValueOf.booleanValue() || container == null) {
                return;
            }
            IFacade mFacade = AbsLifeCycleObserver.this.getMFacade();
            Intrinsics.checkNotNull(mFacade);
            mFacade.setCanvasContainer(container);
        }
    }

    public AbsLifeCycleObserver(@Nullable IInstanceModel iInstanceModel, @Nullable IFacade iFacade) {
        super(iFacade);
        this.mInstanceModel = iInstanceModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getContentResolution */
    public float getMContentResolution() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Float fValueOf = iInstanceModel != null ? Float.valueOf(iInstanceModel.getMContentResolution()) : null;
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getContentScreenSize */
    public Size getMContentScreenSize() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Size mContentScreenSize = iInstanceModel != null ? iInstanceModel.getMContentScreenSize() : null;
        Intrinsics.checkNotNull(mContentScreenSize);
        return mContentScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    @Nullable
    public Object getData(@Nullable String id) {
        return Intrinsics.areEqual(BINDING_ID_INFLATE_CALLBACK, id) ? getInflateCallback() : Intrinsics.areEqual("orientation", id) ? Integer.valueOf(getMOrientation()) : super.getData(id);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    @Nullable
    public ICanvasContainer.OnInflateCallback getInflateCallback() {
        return new OnInflateCallback();
    }

    @Nullable
    public final IInstanceModel getMInstanceModel() {
        return this.mInstanceModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IOrientationMode
    /* JADX INFO: renamed from: getOrientation */
    public int getMOrientation() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Integer numValueOf = iInstanceModel != null ? Integer.valueOf(iInstanceModel.getMOrientation()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getScreenResolution */
    public int getMDeviceScreenResolution() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Integer numValueOf = iInstanceModel != null ? Integer.valueOf(iInstanceModel.getMDeviceScreenResolution()) : null;
        Intrinsics.checkNotNull(numValueOf);
        return numValueOf.intValue();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getScreenSize */
    public Size getMDeviceScreenSize() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Size mDeviceScreenSize = iInstanceModel != null ? iInstanceModel.getMDeviceScreenSize() : null;
        Intrinsics.checkNotNull(mDeviceScreenSize);
        return mDeviceScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    /* JADX INFO: renamed from: getWindowResolution */
    public float getMWindowResolution() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Float fValueOf = iInstanceModel != null ? Float.valueOf(iInstanceModel.getMWindowResolution()) : null;
        Intrinsics.checkNotNull(fValueOf);
        return fValueOf.floatValue();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenData
    @NotNull
    /* JADX INFO: renamed from: getWindowSize */
    public Size getMWindowSize() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Size mWindowSize = iInstanceModel != null ? iInstanceModel.getMWindowSize() : null;
        Intrinsics.checkNotNull(mWindowSize);
        return mWindowSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.bleremote.IBLEListener
    public void onBLEEvent(int eventId) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onBLEEvent(eventId);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public boolean onBack() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        Boolean boolValueOf = iInstanceModel != null ? Boolean.valueOf(iInstanceModel.onBack()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        return boolValueOf.booleanValue();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        IInstanceModel iInstanceModel;
        if (newConfig == null || (iInstanceModel = this.mInstanceModel) == null) {
            return;
        }
        iInstanceModel.onConfigurationChanged(newConfig);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onCreate(@Nullable Intent intent, @Nullable Bundle savedInstanceState) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onCreate();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onDestroy() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onDestroyView() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onDestroyView();
        }
        this.mInstanceModel = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onDispatchEvent(int eventId) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onDispatchEvent(eventId);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onFinishDocumentByUser(boolean save) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onFinishDocumentByUser(save);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyDown(int keycode, boolean withCtrl, boolean withShift) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onKeyDown(keycode, withCtrl, withShift);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyUp(int keycode, boolean withCtrl, boolean withShift) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onKeyUp(keycode, withCtrl, withShift);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onMultiWindowModeChanged(boolean isInMultiWndowMode) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.setMultiwindow(isInMultiWndowMode);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl
    public void onOptionItemSelected(int id) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onOptionItemSelected(id);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onPause() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onPause();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onResume() {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.onResume();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onSaveInstanceState(@Nullable Bundle outState) {
        IInstanceModel iInstanceModel;
        if (outState == null || (iInstanceModel = this.mInstanceModel) == null) {
            return;
        }
        iInstanceModel.onSaveInstanceState(outState);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onStart() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver
    public void onStop() {
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.ILifeCycleObserver
    public void setLifeCycleController(@Nullable ILifeCycleController control) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.setLifeCycleController(control);
        }
    }

    public final void setMInstanceModel(@Nullable IInstanceModel iInstanceModel) {
        this.mInstanceModel = iInstanceModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl
    public void setOptionChangeCallback(@Nullable IBaseOptionItemControl.IOptionChangeCallback callback) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IOrientationMode
    public void setOrientation(int orientation) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.setOrientation(orientation);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IWindowMode
    public void setWindowType(int windowType) {
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.setWindowType(windowType);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.IScreenMode
    public void updateScreenData(@NotNull IScreenData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        IInstanceModel iInstanceModel = this.mInstanceModel;
        if (iInstanceModel != null) {
            iInstanceModel.updateScreenData(data);
        }
    }
}
