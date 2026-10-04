package com.samsung.android.support.senl.addons.base.model.instance;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import com.samsung.android.support.senl.addons.base.model.ILifeCycleController;
import com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel;
import com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p188i3.RunnableC12034a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001GB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J \u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0016H\u0016J \u0010(\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0016H\u0016J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0018H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\u0012\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u0018H\u0016J\u0012\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001dH\u0016J\b\u00109\u001a\u00020\u001dH\u0016J\b\u0010:\u001a\u00020\u001dH\u0016J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u0016H\u0016J\u0012\u0010=\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010?\u001a\u00020\u001dH\u0016J\b\u0010@\u001a\u00020\u001dH\u0016J\b\u0010A\u001a\u00020\u0016H\u0016J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001fH\u0016J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001fH\u0016J\b\u0010F\u001a\u00020\u001dH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/instance/AbsInstanceModel;", "Lcom/samsung/android/support/senl/addons/base/model/screen/AbsScreenModel;", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/ISDocSaveModel$OnProcessListener;", "handler", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;)V", "mDataHandler", "mLifeCycleController", "Lcom/samsung/android/support/senl/addons/base/model/ILifeCycleController;", "getMLifeCycleController", "()Lcom/samsung/android/support/senl/addons/base/model/ILifeCycleController;", "setMLifeCycleController", "(Lcom/samsung/android/support/senl/addons/base/model/ILifeCycleController;)V", "mSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "getMSettingsModel", "()Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "setMSettingsModel", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;)V", "mIsMultiwindow", "", "mCloseLevel", "", "mIsClosed", "mFinishHandler", "Landroid/os/Handler;", "setArgument", "", "argument", "Landroid/os/Bundle;", "setMultiwindow", "isMultiwindow", "setWindowType", "windowType", "onKeyUp", "keycode", "withCtrl", "withShift", "onKeyDown", "onBLEEvent", "eventId", "onDispatchEvent", "onCreate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBack", "setLifeCycleController", "controller", "onOptionItemSelected", "id", "setOptionChangeCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/addons/base/model/IBaseOptionItemControl$IOptionChangeCallback;", "onPause", "onResume", "onDestroyView", "onFinishDocumentByUser", "save", "setDataHandler", "getDataHandler", "requestClose", "close", "isClosed", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onLoadFromInstanceState", "inState", "pendingSaveForRecreatedView", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsInstanceModel extends AbsScreenModel implements IInstanceModel, ISDocSaveModel.OnProcessListener {
    private static final int CLOSE_LEVEL_ACTIVATED = 0;
    private static final int CLOSE_LEVEL_CLOSED_COMPLETED = 4;
    private static final int CLOSE_LEVEL_MODEL_CLOSED = 2;
    private static final int CLOSE_LEVEL_VIEWMODEL_CLOSED = 1;

    @NotNull
    private static final String TAG = Logger.createTag("AbsInstanceModel");
    private int mCloseLevel;

    @Nullable
    private IDataHandler mDataHandler;

    @Nullable
    private Handler mFinishHandler;
    private boolean mIsClosed;
    private boolean mIsMultiwindow;

    @Nullable
    private ILifeCycleController mLifeCycleController;

    @Nullable
    private SettingsModel mSettingsModel;

    public AbsInstanceModel(@NotNull IDataHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.mDataHandler = handler;
        this.mSettingsModel = new SettingsModel(this.mDataHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onDestroyView$lambda$0(AbsInstanceModel absInstanceModel) {
        if (absInstanceModel.mIsClosed) {
            return;
        }
        absInstanceModel.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel
    public void close() {
        this.mIsClosed = true;
        this.mCloseLevel = 4;
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            settingsModel.unregisterSpenActivationObserver();
            SettingsModel settingsModel2 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            settingsModel2.close();
            this.mSettingsModel = null;
        }
        this.mDataHandler = null;
        AbstractC6670b.m4761v(this.mCloseLevel, "close : ", TAG);
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    @Nullable
    /* JADX INFO: renamed from: getDataHandler, reason: from getter */
    public IDataHandler getMDataHandler() {
        return this.mDataHandler;
    }

    @Nullable
    public final ILifeCycleController getMLifeCycleController() {
        return this.mLifeCycleController;
    }

    @Nullable
    public final SettingsModel getMSettingsModel() {
        return this.mSettingsModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    /* JADX INFO: renamed from: isClosed, reason: from getter */
    public boolean getMIsClosed() {
        return this.mIsClosed;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    /* JADX INFO: renamed from: isMultiwindow, reason: from getter */
    public boolean getMIsMultiwindow() {
        return this.mIsMultiwindow;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.bleremote.IBLEListener
    public void onBLEEvent(int eventId) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public boolean onBack() {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            return settingsModel.hideShowingPopup();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        setOrientation(newConfig.orientation);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onCreate() {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.registerSpenActivationObserver();
        }
        Handler handler = this.mFinishHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mFinishHandler = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onDestroyView() {
        int i = this.mCloseLevel;
        if (i == 0) {
            this.mCloseLevel = 1;
        } else if (i == 2) {
            close();
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.mFinishHandler = handler;
        Intrinsics.checkNotNull(handler);
        handler.postDelayed(new RunnableC12034a(this, 15), AiSTTListView.USER_SCROLL_INTERVAL);
        AbstractC6670b.m4761v(this.mCloseLevel, "onDestroyView : ", TAG);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onDispatchEvent(int eventId) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onFinishDocumentByUser(boolean save) {
        Logger.m7100d(TAG, "onFinishDocumentByUser");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyDown(int keycode, boolean withCtrl, boolean withShift) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyUp(int keycode, boolean withCtrl, boolean withShift) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onLoadFromInstanceState(@NotNull Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.onLoadFromInstanceState(inState);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl
    public void onOptionItemSelected(int id) {
        AbstractC6670b.m4761v(id, "onOptionItemSelected : ", TAG);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onPause() {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.storeSettingPopupData();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onResume() {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.getSpenOnlyMode();
        }
        this.mCloseLevel = 0;
        AbstractC6670b.m4761v(0, "onResume : ", TAG);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.onSaveInstanceState(outState);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void pendingSaveForRecreatedView() {
    }

    public void requestClose() {
        int i = this.mCloseLevel;
        if (i == 0) {
            this.mCloseLevel = 2;
        } else if (i == 1) {
            close();
        }
        AbstractC6670b.m4761v(this.mCloseLevel, "requestClose : ", TAG);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void setArgument(@Nullable Bundle argument) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void setDataHandler(@Nullable IDataHandler handler) {
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            settingsModel.setSpenOnlyModeHandler(handler);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void setLifeCycleController(@Nullable ILifeCycleController controller) {
        this.mLifeCycleController = controller;
    }

    public final void setMLifeCycleController(@Nullable ILifeCycleController iLifeCycleController) {
        this.mLifeCycleController = iLifeCycleController;
    }

    public final void setMSettingsModel(@Nullable SettingsModel settingsModel) {
        this.mSettingsModel = settingsModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void setMultiwindow(boolean isMultiwindow) {
        if (this.mIsMultiwindow != isMultiwindow) {
            this.mIsMultiwindow = isMultiwindow;
            AbstractC6670b.m4764y("changed window type - is multiWindow ? ", TAG, isMultiwindow);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.IBaseOptionItemControl
    public void setOptionChangeCallback(@Nullable IBaseOptionItemControl.IOptionChangeCallback callback) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel, com.samsung.android.support.senl.addons.base.model.screen.IWindowMode
    public void setWindowType(int windowType) {
        super.setWindowType(windowType);
        if (getMWindowType() != 0) {
            setMultiwindow(true);
        }
    }
}
