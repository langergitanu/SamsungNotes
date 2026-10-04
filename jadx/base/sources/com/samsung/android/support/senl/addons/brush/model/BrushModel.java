package com.samsung.android.support.senl.addons.brush.model;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Size;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.IDataHandler;
import com.samsung.android.support.senl.addons.base.model.ILifeCycleController;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.model.color.IColorModelInjector;
import com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector;
import com.samsung.android.support.senl.addons.brush.model.pen.PenModelList;
import com.samsung.android.support.senl.addons.brush.model.pen.PenPluginManager;
import com.samsung.android.support.senl.addons.brush.util.BrushToastHandler;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0016H\u0002J\b\u0010,\u001a\u00020\u0016H\u0002J\u000e\u0010-\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020.J\u0018\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0002J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0016H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u0004\u0018\u000109J\n\u0010:\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010;\u001a\u0004\u0018\u00010<J\b\u0010=\u001a\u00020\bH\u0016J \u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0016J \u0010B\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0016J\b\u0010C\u001a\u00020\u0016H\u0002J\b\u0010D\u001a\u00020\u0016H\u0002J\u0010\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\bH\u0016J\b\u0010G\u001a\u00020\u0016H\u0016J\u0010\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020JH\u0016J\b\u0010M\u001a\u00020\u0016H\u0016J\u0010\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\u0014H\u0016J\b\u0010P\u001a\u00020\u0016H\u0016J\b\u0010Q\u001a\u00020\u0016H\u0016J\u0010\u0010R\u001a\u00020\u00162\u0006\u0010S\u001a\u00020\bH\u0016J\u0010\u0010T\u001a\u00020\u00162\u0006\u0010U\u001a\u00020\u0014H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/BrushModel;", "Lcom/samsung/android/support/senl/addons/brush/model/InstanceModel;", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel$IOnProcessListener;", "handler", "Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", CategoryConstants.Restored.UUID_PREFIX, "", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/IDataHandler;Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;Z)V", "mPenModelsManager", "Lcom/samsung/android/support/senl/addons/brush/model/BrushPenModelManager;", "mFacade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "mSaveModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushSaveModel;", "mIsOnFinish", "mIsSkipSaveNow", "mMinSize", "", "setPathInfo", "", "inPaintingDocPath", "", "inThumbnailPath", "outPaintingDocPath", "outThumbnailPath", "internalPath", "updateDisallowTouchDownArea", "enable", "navigationBarHeight", "setMenuSizeInjector", "Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;", "setDataHandler", "createSaveModel", "setContentScreenSize", "size", "Landroid/util/Size;", "setWindowSize", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "changMenuType", "updateToolType", "setInjector", "Lcom/samsung/android/support/senl/addons/brush/model/IBrushModelInjector;", "requestFinish", "isRemainedProcess", "isSaved", "onResume", "onPause", "onDestroyView", "getSpenFacade", "getSettingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "getPenModelList", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModelList;", "getSaveModel", "getColorModelsManager", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "onBack", "onKeyDown", "keycode", "withCtrl", "withShift", "onKeyUp", "undo", "redo", "onFinishDocumentByUser", "save", "close", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onLoadFromInstanceState", "inState", "pendingSaveForRecreatedView", "setRotation", "degree", "onStartSave", "onDocumentLoaded", "onCompleteAllProcess", "isSave", "setWindowType", "windowType", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushModel extends InstanceModel implements BrushSaveModel.IOnProcessListener {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushModel");

    @Nullable
    private BrushFacade mFacade;
    private boolean mIsOnFinish;
    private boolean mIsSkipSaveNow;
    private int mMinSize;

    @Nullable
    private BrushPenModelManager mPenModelsManager;

    @Nullable
    private BrushSaveModel mSaveModel;

    public BrushModel(@Nullable IDataHandler iDataHandler, @Nullable IColorModelInjector iColorModelInjector, boolean z) {
        super(iDataHandler);
        Logger.m7100d(TAG, "BrushModel : construct");
        BrushPenModelManager brushPenModelManager = new BrushPenModelManager(this, getMSettingsModel(), iColorModelInjector);
        this.mPenModelsManager = brushPenModelManager;
        this.mFacade = brushPenModelManager.getMFacade();
        createSaveModel(z);
        BrushPenModelManager brushPenModelManager2 = this.mPenModelsManager;
        if (brushPenModelManager2 != null) {
            brushPenModelManager2.setBrushModelListener(new BrushPenModelManager.BrushModelZoomListener() { // from class: com.samsung.android.support.senl.addons.brush.model.BrushModel.1
                @Override // com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager.BrushModelZoomListener
                public void notifyPenSelectionChange() {
                    BrushModel.this.notifyChanged(301);
                }
            });
        }
    }

    private final void changMenuType() {
        ILifeCycleController mLifeCycleController;
        if (getMLifeCycleController() == null || (mLifeCycleController = getMLifeCycleController()) == null || !mLifeCycleController.requestChangeView()) {
            return;
        }
        SettingsModel mSettingsModel = getMSettingsModel();
        Intrinsics.checkNotNull(mSettingsModel);
        mSettingsModel.recreateSetting();
        rotate();
    }

    private final void createSaveModel(boolean restored) {
        BrushSaveModel brushSaveModel = new BrushSaveModel(this.mFacade, restored);
        this.mSaveModel = brushSaveModel;
        brushSaveModel.setProcessListener(this);
    }

    private final void redo() {
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            Intrinsics.checkNotNull(brushFacade);
            if (brushFacade.isRedoable()) {
                if (getMSettingsModel() != null) {
                    SettingsModel mSettingsModel = getMSettingsModel();
                    Intrinsics.checkNotNull(mSettingsModel);
                    if (mSettingsModel.hasShown()) {
                        SettingsModel mSettingsModel2 = getMSettingsModel();
                        Intrinsics.checkNotNull(mSettingsModel2);
                        mSettingsModel2.clearAllPopupVisibility();
                    }
                }
                BrushFacade brushFacade2 = this.mFacade;
                Intrinsics.checkNotNull(brushFacade2);
                brushFacade2.redo();
            }
        }
    }

    private final void requestFinish(boolean isRemainedProcess, boolean isSaved) {
        if (!isRemainedProcess) {
            requestClose();
        }
        if (getMLifeCycleController() == null || this.mIsOnFinish) {
            return;
        }
        ILifeCycleController mLifeCycleController = getMLifeCycleController();
        Intrinsics.checkNotNull(mLifeCycleController);
        mLifeCycleController.requestFinish(isSaved);
        this.mIsOnFinish = true;
    }

    private final void undo() {
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            Intrinsics.checkNotNull(brushFacade);
            if (brushFacade.isUndoable()) {
                if (getMSettingsModel() != null) {
                    SettingsModel mSettingsModel = getMSettingsModel();
                    Intrinsics.checkNotNull(mSettingsModel);
                    if (mSettingsModel.hasShown()) {
                        SettingsModel mSettingsModel2 = getMSettingsModel();
                        Intrinsics.checkNotNull(mSettingsModel2);
                        mSettingsModel2.clearAllPopupVisibility();
                    }
                }
                BrushFacade brushFacade2 = this.mFacade;
                Intrinsics.checkNotNull(brushFacade2);
                brushFacade2.undo();
            }
        }
    }

    private final void updateToolType() {
        SettingsModel mSettingsModel = getMSettingsModel();
        if (mSettingsModel != null) {
            mSettingsModel.updateToolType();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel
    public void close() {
        this.mFacade = null;
        BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
        if (brushPenModelManager != null) {
            Intrinsics.checkNotNull(brushPenModelManager);
            brushPenModelManager.setBrushModelListener(null);
            BrushPenModelManager brushPenModelManager2 = this.mPenModelsManager;
            Intrinsics.checkNotNull(brushPenModelManager2);
            brushPenModelManager2.close();
            this.mPenModelsManager = null;
        }
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel != null) {
            Intrinsics.checkNotNull(brushSaveModel);
            brushSaveModel.setOnProcessListener(null);
            BrushSaveModel brushSaveModel2 = this.mSaveModel;
            Intrinsics.checkNotNull(brushSaveModel2);
            brushSaveModel2.close();
            this.mSaveModel = null;
        }
        PenPluginManager.INSTANCE.close();
        Logger.m7100d(TAG, "close");
        super.close();
    }

    @Nullable
    public final ColorModelsManager getColorModelsManager() {
        BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
        if (brushPenModelManager != null) {
            return brushPenModelManager.getMColorModelsManager();
        }
        return null;
    }

    @Nullable
    public final PenModelList getPenModelList() {
        BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
        if (brushPenModelManager != null) {
            return brushPenModelManager.getMPenModelList();
        }
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: getSaveModel, reason: from getter */
    public BrushSaveModel getMSaveModel() {
        return this.mSaveModel;
    }

    @Nullable
    public SettingsModel getSettingsModel() {
        return getMSettingsModel();
    }

    @Nullable
    /* JADX INFO: renamed from: getSpenFacade, reason: from getter */
    public BrushFacade getMFacade() {
        return this.mFacade;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.IKeyListener
    public boolean onBack() {
        Logger.m7100d(TAG, "onBack");
        if (super.onBack()) {
            return true;
        }
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel == null) {
            return false;
        }
        brushSaveModel.saveAsync(Boolean.FALSE);
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.ISDocSaveModel.OnProcessListener
    public void onCompleteAllProcess(boolean isSave) {
        AbstractC6670b.m4764y("onCompleteAllProcess ", TAG, isSave);
        requestFinish(false, isSave);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        changMenuType();
        updateToolType();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onDestroyView() {
        Logger.m7100d(TAG, "onDestroyView");
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel != null) {
            brushSaveModel.joinSave();
        }
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            brushFacade.clearViews();
        }
        BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
        if (brushPenModelManager != null) {
            brushPenModelManager.savePenInfo();
        }
        super.onDestroyView();
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveModel.IOnProcessListener
    public void onDocumentLoaded() {
        ILifeCycleController mLifeCycleController = getMLifeCycleController();
        if (mLifeCycleController != null) {
            mLifeCycleController.requestBlockUserInput(false);
        }
        if (this.mIsSkipSaveNow) {
            this.mIsSkipSaveNow = false;
            Logger.m7100d(TAG, "onDocumentLoaded : run skipped save");
            BrushSaveModel brushSaveModel = this.mSaveModel;
            if (brushSaveModel != null) {
                brushSaveModel.saveSync(Boolean.TRUE);
            }
        }
        Logger.m7100d(TAG, "onDocumentLoaded");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.IEventListener
    public void onFinishDocumentByUser(boolean save) {
        super.onFinishDocumentByUser(save);
        Logger.m7100d(TAG, "onFinishDocumentByUser, isOnFinish/save : " + this.mIsOnFinish + "/" + save);
        if (this.mIsOnFinish) {
            return;
        }
        if (save) {
            BrushSaveModel brushSaveModel = this.mSaveModel;
            Intrinsics.checkNotNull(brushSaveModel);
            if (brushSaveModel.isPaintingDocChanged()) {
                BrushSaveModel brushSaveModel2 = this.mSaveModel;
                Intrinsics.checkNotNull(brushSaveModel2);
                brushSaveModel2.joinSave();
                requestFinish(false, true);
                return;
            }
        }
        requestFinish(false, false);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyDown(int keycode, boolean withCtrl, boolean withShift) {
        if (withCtrl) {
            BrushFacade brushFacade = this.mFacade;
            if (brushFacade != null) {
                brushFacade.setMouseWheelZoomEnabled(true);
            }
            if (withShift) {
                if (keycode == 54) {
                    redo();
                    return;
                }
                return;
            }
            if (keycode != 48) {
                if (keycode == 53) {
                    redo();
                    return;
                } else {
                    if (keycode != 54) {
                        return;
                    }
                    undo();
                    return;
                }
            }
            if (getMSettingsModel() != null) {
                SettingsModel mSettingsModel = getMSettingsModel();
                Intrinsics.checkNotNull(mSettingsModel);
                if (mSettingsModel.getCurrentMode() != 2) {
                    SettingsModel mSettingsModel2 = getMSettingsModel();
                    Intrinsics.checkNotNull(mSettingsModel2);
                    mSettingsModel2.setMode(2);
                }
                SettingsModel mSettingsModel3 = getMSettingsModel();
                Intrinsics.checkNotNull(mSettingsModel3);
                Intrinsics.checkNotNull(getMSettingsModel());
                mSettingsModel3.setPenSettingVisibility(!r3.getPenSettingVisibility());
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.IKeyListener
    public void onKeyUp(int keycode, boolean withCtrl, boolean withShift) {
        BrushFacade brushFacade;
        if (withCtrl || (brushFacade = this.mFacade) == null) {
            return;
        }
        brushFacade.setMouseWheelZoomEnabled(false);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onLoadFromInstanceState(@NotNull Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
        super.onLoadFromInstanceState(inState);
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel != null) {
            brushSaveModel.onLoadFromInstanceState(inState);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onPause() {
        String str = TAG;
        BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
        Logger.m7104i(str, "onPause : " + (brushPenModelManager != null ? brushPenModelManager.getMBrushPenModel() : null));
        if (this.mIsSkipSaveNow) {
            BrushSaveModel brushSaveModel = this.mSaveModel;
            boolean z = false;
            if (brushSaveModel != null && brushSaveModel.updateDocumentWithoutSaving()) {
                z = true;
            }
            this.mIsSkipSaveNow = z;
            AbstractC6670b.m4764y("onPause : skip save - ", str, z);
        } else if (!this.mIsOnFinish) {
            BrushSaveModel brushSaveModel2 = this.mSaveModel;
            Intrinsics.checkNotNull(brushSaveModel2);
            brushSaveModel2.saveSync(Boolean.TRUE);
        }
        super.onPause();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void onResume() {
        super.onResume();
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade == null) {
            return;
        }
        Intrinsics.checkNotNull(brushFacade);
        if (!brushFacade.isDocLoaded() && getMLifeCycleController() != null) {
            ILifeCycleController mLifeCycleController = getMLifeCycleController();
            Intrinsics.checkNotNull(mLifeCycleController);
            mLifeCycleController.requestBlockUserInput(true);
        }
        BrushFacade brushFacade2 = this.mFacade;
        Intrinsics.checkNotNull(brushFacade2);
        brushFacade2.showCanvas();
        SettingsModel mSettingsModel = getMSettingsModel();
        Intrinsics.checkNotNull(mSettingsModel);
        if (mSettingsModel.isMode(2)) {
            BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
            Intrinsics.checkNotNull(brushPenModelManager);
            brushPenModelManager.updateCurrentPenInfo();
            String str = TAG;
            BrushPenModelManager brushPenModelManager2 = this.mPenModelsManager;
            Intrinsics.checkNotNull(brushPenModelManager2);
            Logger.m7104i(str, "onResume : " + brushPenModelManager2.getMBrushPenModel());
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
        Intrinsics.checkNotNull(brushPenModelManager);
        brushPenModelManager.savePenInfo();
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel != null) {
            brushSaveModel.onSaveInstanceState(outState);
        }
        BrushSaveModel brushSaveModel2 = this.mSaveModel;
        if (brushSaveModel2 != null) {
            brushSaveModel2.joinSave();
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveModel.IOnProcessListener
    public void onStartSave() {
        ILifeCycleController mLifeCycleController = getMLifeCycleController();
        if (mLifeCycleController != null) {
            mLifeCycleController.requestBlockUserInput(true);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void pendingSaveForRecreatedView() {
        this.mIsSkipSaveNow = true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel
    public boolean setContentScreenSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        boolean contentScreenSize = super.setContentScreenSize(size);
        if (this.mPenModelsManager != null && size.getWidth() != 0 && size.getHeight() != 0) {
            BrushPenModelManager brushPenModelManager = this.mPenModelsManager;
            Intrinsics.checkNotNull(brushPenModelManager);
            brushPenModelManager.setPenEraserInfo();
        }
        return contentScreenSize;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void setDataHandler(@Nullable IDataHandler handler) {
        super.setDataHandler(handler);
        createSaveModel(false);
    }

    public final void setInjector(@NotNull IBrushModelInjector injector) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel != null) {
            brushSaveModel.setThumbnailMargin(injector.getMThumbnailMargin().getHorizontal(), injector.getMThumbnailMargin().getVertical());
        }
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.InstanceModel
    public void setMenuSizeInjector(@NotNull IMenuSizeInjector injector) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        super.setMenuSizeInjector(injector);
        IMenuSizeInjector mMenuSize = getMMenuSize();
        this.mMinSize = mMenuSize != null ? mMenuSize.getMinWidth() : this.mMinSize;
    }

    public final void setPathInfo(@Nullable String inPaintingDocPath, @Nullable String inThumbnailPath, @Nullable String outPaintingDocPath, @Nullable String outThumbnailPath, @Nullable String internalPath) {
        BrushSaveModel brushSaveModel = this.mSaveModel;
        if (brushSaveModel != null) {
            brushSaveModel.setPathInfo(inPaintingDocPath, inThumbnailPath, outPaintingDocPath, outThumbnailPath, internalPath);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel, com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode
    public boolean setRotation(int degree) {
        BrushToastHandler.INSTANCE.setRotation(degree);
        return super.setRotation(degree);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel
    public boolean setWindowSize(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        if (TabletUtil.isTabletMode() && !this.mIsSkipSaveNow) {
            if (Intrinsics.areEqual(getMWindowSize(), size)) {
                return super.setWindowSize(size);
            }
            int iMin = Math.min(size.getWidth(), size.getHeight());
            if (TabletUtil.isTabletUi()) {
                if (iMin < this.mMinSize - 10) {
                    Logger.m7100d(TAG, "UI is must changed to Phone UI");
                    changMenuType();
                }
            } else if (iMin > this.mMinSize + 10) {
                Logger.m7100d(TAG, "UI is must changed to Tablet UI");
                changMenuType();
            }
        }
        return super.setWindowSize(size);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.AbsInstanceModel, com.samsung.android.support.senl.addons.base.model.screen.AbsScreenModel, com.samsung.android.support.senl.addons.base.model.screen.IWindowMode
    public void setWindowType(int windowType) {
        super.setWindowType(windowType);
        BrushFacade brushFacade = this.mFacade;
        Intrinsics.checkNotNull(brushFacade);
        brushFacade.enableFBR(windowType == 0);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel
    public void updateDisallowTouchDownArea(boolean enable, int navigationBarHeight) {
        if (enable) {
            AbstractC6670b.m4761v(navigationBarHeight, "setTouchMargin: ", TAG);
            BrushFacade brushFacade = this.mFacade;
            if (brushFacade != null) {
                brushFacade.updateDisallowTouchDownArea(navigationBarHeight);
                return;
            }
            return;
        }
        Logger.m7100d(TAG, "setTouchMargin: 0");
        BrushFacade brushFacade2 = this.mFacade;
        if (brushFacade2 != null) {
            brushFacade2.updateDisallowTouchDownArea(0);
        }
    }
}
