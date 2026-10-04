package com.samsung.android.support.senl.addons.brush.model;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.pen.IPenModel;
import com.samsung.android.support.senl.addons.base.model.setting.SettingsModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasScreenModel;
import com.samsung.android.support.senl.addons.brush.model.color.ColorModelsManager;
import com.samsung.android.support.senl.addons.brush.model.color.IColorModelInjector;
import com.samsung.android.support.senl.addons.brush.model.pen.PenModel;
import com.samsung.android.support.senl.addons.brush.model.pen.PenModelList;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002;<B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010#\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\u0012\u0010,\u001a\u00020$2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0017H\u0002J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u0010.\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u00010 J\u0006\u00107\u001a\u00020$J\u0006\u00108\u001a\u00020$J\u0006\u00109\u001a\u00020$J\u0006\u0010:\u001a\u00020$R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/BrushPenModelManager;", "", "model", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;", "settingsModel", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "injector", "Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;", "<init>", "(Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;Lcom/samsung/android/support/senl/addons/brush/model/color/IColorModelInjector;)V", "value", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "mFacade", "getMFacade", "()Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModelList;", "mPenModelList", "getMPenModelList", "()Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModelList;", "Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "mColorModelsManager", "getMColorModelsManager", "()Lcom/samsung/android/support/senl/addons/brush/model/color/ColorModelsManager;", "Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel;", "mBrushPenModel", "getMBrushPenModel", "()Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel;", "mSettingsModel", "mBrushPrevPenModel", "mRecentModel", "Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "mBrushModelListener", "Lcom/samsung/android/support/senl/addons/brush/model/BrushPenModelManager$BrushModelZoomListener;", "mIsPenChanged", "", "initialize", "", "mColorChangeCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "mEraserChangeCallback", "mSettingsCallback", "mPenListCallback", "mFacadeCallback", "addRecent", "updatePenModel", "updatePenInfo", "penModel", "makePenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "currentPenName", "", "getCurrentPenName", "()Ljava/lang/String;", "setBrushModelListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "savePenInfo", "updateCurrentPenInfo", "setPenEraserInfo", "close", "BrushModelZoomListener", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushPenModelManager {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushPenModelManager");

    @Nullable
    private BrushModelZoomListener mBrushModelListener;

    @Nullable
    private IPenModel mBrushPenModel;

    @Nullable
    private IPenModel mBrushPrevPenModel;

    @Nullable
    private ColorModelsManager mColorModelsManager;

    @Nullable
    private BrushFacade mFacade;
    private boolean mIsPenChanged;

    @Nullable
    private PenModelList mPenModelList;

    @Nullable
    private ColorModel mRecentModel;

    @Nullable
    private SettingsModel mSettingsModel;

    @Nullable
    private IBaseModel.Observer mColorChangeCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager$mColorChangeCallback$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            Integer id = info != null ? info.getId() : null;
            Intrinsics.checkNotNull(id);
            int iIntValue = id.intValue();
            if (iIntValue != 201) {
                if (iIntValue != 202) {
                    return;
                }
                SettingsModel settingsModel = this.this$0.mSettingsModel;
                Boolean boolValueOf = settingsModel != null ? Boolean.valueOf(settingsModel.isMode(4)) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    SettingsModel settingsModel2 = this.this$0.mSettingsModel;
                    Intrinsics.checkNotNull(settingsModel2);
                    settingsModel2.setMode(2);
                    return;
                }
                return;
            }
            SettingsModel settingsModel3 = this.this$0.mSettingsModel;
            Boolean boolValueOf2 = settingsModel3 != null ? Boolean.valueOf(settingsModel3.isMode(4)) : null;
            Intrinsics.checkNotNull(boolValueOf2);
            if (boolValueOf2.booleanValue()) {
                SettingsModel settingsModel4 = this.this$0.mSettingsModel;
                if (settingsModel4 != null) {
                    settingsModel4.setMode(2);
                }
                IPenModel mBrushPenModel = this.this$0.getMBrushPenModel();
                String mPenType = mBrushPenModel != null ? mBrushPenModel.getMPenType() : null;
                Intrinsics.checkNotNull(mPenType);
                if (!StringsKt.m14162r(mPenType, "Smudge") || this.this$0.mBrushPrevPenModel == null) {
                    return;
                }
                IPenModel mBrushPenModel2 = this.this$0.getMBrushPenModel();
                Intrinsics.checkNotNull(mBrushPenModel2);
                mBrushPenModel2.setSelected(false);
                BrushPenModelManager brushPenModelManager = this.this$0;
                brushPenModelManager.updatePenModel(brushPenModelManager.mBrushPrevPenModel);
                IPenModel mBrushPenModel3 = this.this$0.getMBrushPenModel();
                Intrinsics.checkNotNull(mBrushPenModel3);
                mBrushPenModel3.setSelected(true);
                this.this$0.mIsPenChanged = true;
                return;
            }
            IPenModel mBrushPenModel4 = this.this$0.getMBrushPenModel();
            Intrinsics.checkNotNull(mBrushPenModel4);
            if (!StringsKt.m14162r(mBrushPenModel4.getMPenType(), "Smudge")) {
                BrushPenModelManager brushPenModelManager2 = this.this$0;
                brushPenModelManager2.updatePenInfo(brushPenModelManager2.getMBrushPenModel());
                return;
            }
            if (this.this$0.mBrushPrevPenModel != null) {
                IPenModel mBrushPenModel5 = this.this$0.getMBrushPenModel();
                if (mBrushPenModel5 != null) {
                    mBrushPenModel5.setSelected(false);
                }
                if (Intrinsics.areEqual(this.this$0.mBrushPrevPenModel, this.this$0.getMBrushPenModel())) {
                    Logger.m7105w(BrushPenModelManager.TAG, "equal prev and current pen!");
                    BrushPenModelManager brushPenModelManager3 = this.this$0;
                    PenModelList mPenModelList = brushPenModelManager3.getMPenModelList();
                    brushPenModelManager3.updatePenModel(mPenModelList != null ? mPenModelList.getPenModel(0) : null);
                } else {
                    BrushPenModelManager brushPenModelManager4 = this.this$0;
                    brushPenModelManager4.updatePenModel(brushPenModelManager4.mBrushPrevPenModel);
                }
                IPenModel mBrushPenModel6 = this.this$0.getMBrushPenModel();
                if (mBrushPenModel6 != null) {
                    mBrushPenModel6.setSelected(true);
                }
                this.this$0.mIsPenChanged = true;
            }
        }
    };

    @Nullable
    private IBaseModel.Observer mEraserChangeCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager$mEraserChangeCallback$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            Integer id = info != null ? info.getId() : null;
            Intrinsics.checkNotNull(id);
            if (id.intValue() == 201) {
                BrushPenModelManager brushPenModelManager = this.this$0;
                PenModelList mPenModelList = brushPenModelManager.getMPenModelList();
                brushPenModelManager.updatePenInfo(mPenModelList != null ? mPenModelList.getMEraserPenModel() : null);
            }
        }
    };

    @Nullable
    private IBaseModel.Observer mSettingsCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager$mSettingsCallback$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            SettingsModel settingsModel;
            ColorModelsManager mColorModelsManager;
            Integer id = info != null ? info.getId() : null;
            Intrinsics.checkNotNull(id);
            int iIntValue = id.intValue();
            if (iIntValue != 402) {
                if (iIntValue != 505 || (settingsModel = this.this$0.mSettingsModel) == null || settingsModel.getColorPickerVisibility()) {
                    return;
                }
                BrushPenModelManager brushPenModelManager = this.this$0;
                IPenModel mBrushPenModel = this.this$0.getMBrushPenModel();
                Integer numValueOf = mBrushPenModel != null ? Integer.valueOf(mBrushPenModel.getMColor()) : null;
                Intrinsics.checkNotNull(numValueOf);
                int iIntValue2 = numValueOf.intValue();
                IPenModel mBrushPenModel2 = this.this$0.getMBrushPenModel();
                Integer numValueOf2 = mBrushPenModel2 != null ? Integer.valueOf(mBrushPenModel2.getMPosition()) : null;
                Intrinsics.checkNotNull(numValueOf2);
                brushPenModelManager.mRecentModel = new ColorModel(iIntValue2, numValueOf2.intValue());
                this.this$0.addRecent();
                if (this.this$0.mRecentModel == null || (mColorModelsManager = this.this$0.getMColorModelsManager()) == null) {
                    return;
                }
                ColorModel colorModel = this.this$0.mRecentModel;
                Intrinsics.checkNotNull(colorModel);
                mColorModelsManager.updateSelectPosition(colorModel);
                return;
            }
            SettingsModel settingsModel2 = this.this$0.mSettingsModel;
            if (settingsModel2 != null && settingsModel2.getCurrentMode() == 2) {
                if (this.this$0.getMBrushPenModel() != null) {
                    IPenModel mBrushPenModel3 = this.this$0.getMBrushPenModel();
                    Intrinsics.checkNotNull(mBrushPenModel3);
                    mBrushPenModel3.setSelected(true);
                    IPenModel mBrushPenModel4 = this.this$0.getMBrushPenModel();
                    Intrinsics.checkNotNull(mBrushPenModel4);
                    mBrushPenModel4.setEnabled(true);
                    BrushPenModelManager brushPenModelManager2 = this.this$0;
                    brushPenModelManager2.updatePenInfo(brushPenModelManager2.getMBrushPenModel());
                    return;
                }
                return;
            }
            SettingsModel settingsModel3 = this.this$0.mSettingsModel;
            if (settingsModel3 == null || settingsModel3.getCurrentMode() != 4) {
                return;
            }
            if (this.this$0.getMPenModelList() != null) {
                BrushPenModelManager brushPenModelManager3 = this.this$0;
                PenModelList mPenModelList = brushPenModelManager3.getMPenModelList();
                Intrinsics.checkNotNull(mPenModelList);
                brushPenModelManager3.updatePenInfo(mPenModelList.getMEraserPenModel());
            }
            IPenModel mBrushPenModel5 = this.this$0.getMBrushPenModel();
            if (mBrushPenModel5 != null) {
                mBrushPenModel5.setEnabled(false);
            }
        }
    };

    @Nullable
    private IBaseModel.Observer mPenListCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager$mPenListCallback$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            Integer id = info != null ? info.getId() : null;
            Intrinsics.checkNotNull(id);
            int iIntValue = id.intValue();
            int mPenThickness = 0;
            if (iIntValue != 301) {
                if (iIntValue != 302) {
                    return;
                }
                SettingsModel settingsModel = this.this$0.mSettingsModel;
                if (settingsModel == null || settingsModel.getCurrentMode() != 2) {
                    SettingsModel settingsModel2 = this.this$0.mSettingsModel;
                    if (settingsModel2 != null && settingsModel2.getCurrentMode() == 4) {
                        PenModelList mPenModelList = this.this$0.getMPenModelList();
                        PenModel mEraserPenModel = mPenModelList != null ? mPenModelList.getMEraserPenModel() : null;
                        Intrinsics.checkNotNull(mEraserPenModel);
                        mPenThickness = mEraserPenModel.getMPenThickness();
                        BrushPenModelManager brushPenModelManager = this.this$0;
                        PenModelList mPenModelList2 = brushPenModelManager.getMPenModelList();
                        brushPenModelManager.updatePenInfo(mPenModelList2 != null ? mPenModelList2.getMEraserPenModel() : null);
                    }
                } else {
                    IPenModel mBrushPenModel = this.this$0.getMBrushPenModel();
                    Integer numValueOf = mBrushPenModel != null ? Integer.valueOf(mBrushPenModel.getMPenThickness()) : null;
                    Intrinsics.checkNotNull(numValueOf);
                    mPenThickness = numValueOf.intValue();
                    BrushPenModelManager brushPenModelManager2 = this.this$0;
                    brushPenModelManager2.updatePenInfo(brushPenModelManager2.getMBrushPenModel());
                }
                AbstractC6670b.m4761v(mPenThickness, "OBSV_PEN_MODEL_SIZE_CHANGED - ", BrushPenModelManager.TAG);
                return;
            }
            Logger.m7100d(BrushPenModelManager.TAG, "OBSV_PEN_MODEL_SELECTION_CHANGED - receive");
            PenModelList mPenModelList3 = this.this$0.getMPenModelList();
            if ((mPenModelList3 != null ? mPenModelList3.getSelectedModel() : null) != null) {
                BrushPenModelManager brushPenModelManager3 = this.this$0;
                PenModelList mPenModelList4 = brushPenModelManager3.getMPenModelList();
                brushPenModelManager3.updatePenModel(mPenModelList4 != null ? mPenModelList4.getSelectedModel() : null);
                if (this.this$0.getMColorModelsManager() != null && (this.this$0.getMBrushPenModel() instanceof ColorModel)) {
                    ColorModelsManager mColorModelsManager = this.this$0.getMColorModelsManager();
                    Intrinsics.checkNotNull(mColorModelsManager);
                    mColorModelsManager.setMainColorModel((ColorModel) this.this$0.getMBrushPenModel());
                }
                BrushPenModelManager.BrushModelZoomListener brushModelZoomListener = this.this$0.mBrushModelListener;
                if (brushModelZoomListener != null) {
                    brushModelZoomListener.notifyPenSelectionChange();
                }
                if (this.this$0.getMColorModelsManager() != null) {
                    IPenModel mBrushPenModel2 = this.this$0.getMBrushPenModel();
                    Intrinsics.checkNotNull(mBrushPenModel2);
                    if (StringsKt.m14162r(mBrushPenModel2.getMPenType(), "Smudge")) {
                        IPenModel iPenModel = this.this$0.mBrushPrevPenModel;
                        String mPenType = iPenModel != null ? iPenModel.getMPenType() : null;
                        Intrinsics.checkNotNull(mPenType);
                        if (StringsKt.m14162r(mPenType, "Smudge")) {
                            BrushPenModelManager brushPenModelManager4 = this.this$0;
                            PenModelList mPenModelList5 = brushPenModelManager4.getMPenModelList();
                            brushPenModelManager4.mBrushPrevPenModel = mPenModelList5 != null ? mPenModelList5.getPenModel(0) : null;
                        }
                        ColorModelsManager mColorModelsManager2 = this.this$0.getMColorModelsManager();
                        if (mColorModelsManager2 != null) {
                            mColorModelsManager2.changeMainColorModel(this.this$0.mBrushPrevPenModel);
                        }
                    }
                }
                this.this$0.mIsPenChanged = true;
            }
        }
    };

    @Nullable
    private IBaseModel.Observer mFacadeCallback = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.model.BrushPenModelManager$mFacadeCallback$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            ColorModelsManager mColorModelsManager;
            IPenModel mBrushPenModel;
            Integer id = info != null ? info.getId() : null;
            Intrinsics.checkNotNull(id);
            int iIntValue = id.intValue();
            if (iIntValue == 11006) {
                SettingsModel settingsModel = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel);
                if (settingsModel.isMode(2)) {
                    if (this.this$0.getMBrushPenModel() != null) {
                        IPenModel mBrushPenModel2 = this.this$0.getMBrushPenModel();
                        Intrinsics.checkNotNull(mBrushPenModel2);
                        if (!StringsKt.m14162r(mBrushPenModel2.getMPenType(), "Smudge")) {
                            this.this$0.addRecent();
                            ColorModelsManager mColorModelsManager2 = this.this$0.getMColorModelsManager();
                            if (mColorModelsManager2 != null) {
                                IPenModel mBrushPenModel3 = this.this$0.getMBrushPenModel();
                                Intrinsics.checkNotNull(mBrushPenModel3);
                                mColorModelsManager2.updateSelectPosition(mBrushPenModel3);
                            }
                        }
                    }
                    if (this.this$0.mIsPenChanged) {
                        SystemLogManager.INSTANCE.onObjectAdded(this.this$0.getCurrentPenName());
                    }
                    this.this$0.mIsPenChanged = false;
                    BrushFacade mFacade = this.this$0.getMFacade();
                    if (mFacade != null) {
                        mFacade.setMIsDrawing(false);
                    }
                    Logger.m7104i(BrushPenModelManager.TAG, "onUpdate: mIsDrawing: false");
                    return;
                }
                return;
            }
            if (iIntValue == 11009) {
                BrushFacade mFacade2 = this.this$0.getMFacade();
                if (mFacade2 != null) {
                    mFacade2.setMIsDrawing(true);
                }
                Logger.m7104i(BrushPenModelManager.TAG, "onUpdate: mIsDrawing: true");
                BrushPenModelManager brushPenModelManager = this.this$0;
                IPenModel mBrushPenModel4 = this.this$0.getMBrushPenModel();
                Integer numValueOf = mBrushPenModel4 != null ? Integer.valueOf(mBrushPenModel4.getMColor()) : null;
                Intrinsics.checkNotNull(numValueOf);
                int iIntValue2 = numValueOf.intValue();
                IPenModel mBrushPenModel5 = this.this$0.getMBrushPenModel();
                Integer numValueOf2 = mBrushPenModel5 != null ? Integer.valueOf(mBrushPenModel5.getMPosition()) : null;
                Intrinsics.checkNotNull(numValueOf2);
                brushPenModelManager.mRecentModel = new ColorModel(iIntValue2, numValueOf2.intValue());
                return;
            }
            if (iIntValue != 11303) {
                if (iIntValue != 11401) {
                    return;
                }
                this.this$0.initialize();
                return;
            }
            SettingsModel settingsModel2 = this.this$0.mSettingsModel;
            if (settingsModel2 == null || settingsModel2.getCurrentMode() != 4) {
                BrushFacade mFacade3 = this.this$0.getMFacade();
                IExtendedColor currentColor = mFacade3 != null ? mFacade3.getCurrentColor() : null;
                IPenModel mBrushPenModel6 = this.this$0.getMBrushPenModel();
                Boolean boolValueOf = mBrushPenModel6 != null ? Boolean.valueOf(mBrushPenModel6.getMHasAlpha()) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue() && (mBrushPenModel = this.this$0.getMBrushPenModel()) != null) {
                    Intrinsics.checkNotNull(currentColor);
                    mBrushPenModel.setAlpha(((currentColor.getMColor() >> 24) & 255) / 255.0f);
                }
                IPenModel mBrushPenModel7 = this.this$0.getMBrushPenModel();
                if (mBrushPenModel7 != null) {
                    Intrinsics.checkNotNull(currentColor);
                    mBrushPenModel7.setColor(currentColor);
                }
                String str = BrushPenModelManager.TAG;
                Integer numValueOf3 = currentColor != null ? Integer.valueOf(currentColor.getMColor()) : null;
                IPenModel mBrushPenModel8 = this.this$0.getMBrushPenModel();
                Integer numValueOf4 = mBrushPenModel8 != null ? Integer.valueOf(mBrushPenModel8.getMColor()) : null;
                IPenModel mBrushPenModel9 = this.this$0.getMBrushPenModel();
                Integer numValueOf5 = mBrushPenModel9 != null ? Integer.valueOf(mBrushPenModel9.getAlphaColor()) : null;
                IPenModel mBrushPenModel10 = this.this$0.getMBrushPenModel();
                Logger.m7100d(str, "OBSV_PROPERTY_PEN_COLOR_CHANGED - " + numValueOf3 + " /  " + numValueOf4 + SQLKeyword.COMMA + numValueOf5 + SQLKeyword.COMMA + (mBrushPenModel10 != null ? mBrushPenModel10.getMPenType() : null));
                SettingsModel settingsModel3 = this.this$0.mSettingsModel;
                Intrinsics.checkNotNull(settingsModel3);
                if (settingsModel3.getCurrentMode() != 5 || (mColorModelsManager = this.this$0.getMColorModelsManager()) == null) {
                    return;
                }
                Intrinsics.checkNotNull(currentColor);
                mColorModelsManager.setColorPickerColor(currentColor);
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/BrushPenModelManager$BrushModelZoomListener;", "", "notifyPenSelectionChange", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface BrushModelZoomListener {
        void notifyPenSelectionChange();
    }

    public BrushPenModelManager(@Nullable IBrushCanvasScreenModel iBrushCanvasScreenModel, @Nullable SettingsModel settingsModel, @Nullable IColorModelInjector iColorModelInjector) {
        this.mSettingsModel = settingsModel;
        this.mFacade = new BrushFacade(this.mSettingsModel, iBrushCanvasScreenModel);
        this.mPenModelList = new PenModelList(this.mFacade, iBrushCanvasScreenModel);
        SettingsModel settingsModel2 = this.mSettingsModel;
        if (settingsModel2 != null) {
            IBaseModel.Observer observer = this.mSettingsCallback;
            Intrinsics.checkNotNull(observer);
            settingsModel2.addObserver(observer);
        }
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            IBaseModel.Observer observer2 = this.mFacadeCallback;
            Intrinsics.checkNotNull(observer2);
            brushFacade.addObserver(observer2);
        }
        PenModelList penModelList = this.mPenModelList;
        if (penModelList != null) {
            IBaseModel.Observer observer3 = this.mPenListCallback;
            Intrinsics.checkNotNull(observer3);
            penModelList.addObserver(observer3);
        }
        PenModelList penModelList2 = this.mPenModelList;
        PenModel mEraserPenModel = penModelList2 != null ? penModelList2.getMEraserPenModel() : null;
        Intrinsics.checkNotNull(mEraserPenModel);
        IBaseModel.Observer observer4 = this.mEraserChangeCallback;
        Intrinsics.checkNotNull(observer4);
        mEraserPenModel.addObserver(observer4);
        PenModelList penModelList3 = this.mPenModelList;
        updatePenModel(penModelList3 != null ? penModelList3.getSelectedModel() : null);
        Intrinsics.checkNotNull(iColorModelInjector);
        SettingsModel settingsModel3 = this.mSettingsModel;
        Intrinsics.checkNotNull(settingsModel3);
        ColorModelsManager colorModelsManager = new ColorModelsManager(iColorModelInjector, settingsModel3);
        this.mColorModelsManager = colorModelsManager;
        colorModelsManager.setMainColorModel(this.mBrushPenModel);
        ColorModelsManager colorModelsManager2 = this.mColorModelsManager;
        if (colorModelsManager2 != null) {
            IBaseModel.Observer observer5 = this.mColorChangeCallback;
            Intrinsics.checkNotNull(observer5);
            colorModelsManager2.addObserver(observer5);
        }
        IPenModel iPenModel = this.mBrushPenModel;
        String mPenType = iPenModel != null ? iPenModel.getMPenType() : null;
        Intrinsics.checkNotNull(mPenType);
        if (StringsKt.m14162r(mPenType, "Smudge")) {
            IPenModel iPenModel2 = this.mBrushPrevPenModel;
            String mPenType2 = iPenModel2 != null ? iPenModel2.getMPenType() : null;
            Intrinsics.checkNotNull(mPenType2);
            if (StringsKt.m14162r(mPenType2, "Smudge")) {
                PenModelList penModelList4 = this.mPenModelList;
                Intrinsics.checkNotNull(penModelList4);
                this.mBrushPrevPenModel = penModelList4.getPenModel(0);
            }
            ColorModelsManager colorModelsManager3 = this.mColorModelsManager;
            if (colorModelsManager3 != null) {
                colorModelsManager3.changeMainColorModel(this.mBrushPrevPenModel);
            }
        }
        this.mIsPenChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addRecent() {
        if (this.mRecentModel != null) {
            ColorModelsManager colorModelsManager = this.mColorModelsManager;
            Intrinsics.checkNotNull(colorModelsManager);
            ColorModel colorModel = this.mRecentModel;
            Intrinsics.checkNotNull(colorModel);
            colorModelsManager.addRecentColor(colorModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initialize() {
        Logger.m7100d(TAG, "initialize");
        PenModelList penModelList = this.mPenModelList;
        if (penModelList != null) {
            penModelList.updateSize();
        }
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            PenModelList penModelList2 = this.mPenModelList;
            brushFacade.setPenEraserInfo(makePenInfo(penModelList2 != null ? penModelList2.getMEraserPenModel() : null));
        }
        PenModelList penModelList3 = this.mPenModelList;
        updatePenModel(penModelList3 != null ? penModelList3.getSelectedModel() : null);
    }

    private final SpenSettingUIPenInfo makePenInfo(IPenModel penModel) {
        if (penModel == null) {
            return null;
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
        String mPenClassName = penModel.getMPenClassName();
        if (mPenClassName == null) {
            mPenClassName = "";
        }
        spenSettingUIPenInfo.name = mPenClassName;
        spenSettingUIPenInfo.color = penModel.getAlphaColor();
        spenSettingUIPenInfo.hsv = penModel.getMHSV();
        spenSettingUIPenInfo.size = penModel.getPenSize();
        spenSettingUIPenInfo.sizeLevel = penModel.getMPenThickness();
        if (StringsKt.m14162r(spenSettingUIPenInfo.name, "ColoredPencil")) {
            spenSettingUIPenInfo.particleDensity = penModel.getMPenThickness();
        }
        return spenSettingUIPenInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePenInfo(IPenModel penModel) {
        if (penModel == null) {
            Logger.m7105w(TAG, "updatePenInfo : penModel is null.");
            return;
        }
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade == null) {
            Logger.m7105w(TAG, "updatePenInfo : mFacade is null.");
            return;
        }
        Intrinsics.checkNotNull(brushFacade);
        if (!brushFacade.isDocLoaded()) {
            Logger.m7105w(TAG, "updatePenInfo : doc is not loaded.");
            return;
        }
        SpenSettingUIPenInfo spenSettingUIPenInfoMakePenInfo = makePenInfo(penModel);
        if (spenSettingUIPenInfoMakePenInfo != null) {
            BrushFacade brushFacade2 = this.mFacade;
            Intrinsics.checkNotNull(brushFacade2);
            brushFacade2.setPenSettingInfo(spenSettingUIPenInfoMakePenInfo);
        }
        SettingsModel settingsModel = this.mSettingsModel;
        Boolean boolValueOf = settingsModel != null ? Boolean.valueOf(settingsModel.getColorPickerVisibility()) : null;
        Intrinsics.checkNotNull(boolValueOf);
        if (boolValueOf.booleanValue()) {
            return;
        }
        String str = spenSettingUIPenInfoMakePenInfo != null ? spenSettingUIPenInfoMakePenInfo.name : null;
        Intrinsics.checkNotNull(str);
        if (StringsKt.m14162r(str, "Eraser")) {
            Logger.m7100d(TAG, "updatePenInfo ERASER ");
            SettingsModel settingsModel2 = this.mSettingsModel;
            Intrinsics.checkNotNull(settingsModel2);
            settingsModel2.setMode(4);
            return;
        }
        Logger.m7100d(TAG, "updatePenInfo PEN ");
        SettingsModel settingsModel3 = this.mSettingsModel;
        Intrinsics.checkNotNull(settingsModel3);
        settingsModel3.setMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePenModel(IPenModel model) {
        if (model == null) {
            Logger.m7105w(TAG, "updatePenModel - null");
            return;
        }
        AbstractC6670b.m4763x("updatePenModel - ", model.getMPenType(), TAG);
        if (!Intrinsics.areEqual(model, this.mBrushPenModel)) {
            IPenModel iPenModel = this.mBrushPenModel;
            if (iPenModel != null) {
                Intrinsics.checkNotNull(iPenModel);
                IBaseModel.Observer observer = this.mColorChangeCallback;
                Intrinsics.checkNotNull(observer);
                iPenModel.removeObserver(observer);
            }
            this.mBrushPrevPenModel = this.mBrushPenModel;
            this.mBrushPenModel = model;
            IBaseModel.Observer observer2 = this.mColorChangeCallback;
            Intrinsics.checkNotNull(observer2);
            model.addObserver(observer2);
        }
        IPenModel iPenModel2 = this.mBrushPrevPenModel;
        if (iPenModel2 == null) {
            PenModelList penModelList = this.mPenModelList;
            Intrinsics.checkNotNull(penModelList);
            this.mBrushPrevPenModel = penModelList.getPrevSelectedModel();
        } else {
            PenModelList penModelList2 = this.mPenModelList;
            if (penModelList2 != null) {
                Intrinsics.checkNotNull(iPenModel2);
                penModelList2.setPrevSelectedPenName(iPenModel2.getMPenType());
            }
        }
        IPenModel iPenModel3 = this.mBrushPenModel;
        Intrinsics.checkNotNull(iPenModel3);
        if (iPenModel3.getMEnabled()) {
            updatePenInfo(this.mBrushPenModel);
        }
    }

    public final void close() {
        this.mBrushPrevPenModel = null;
        this.mBrushPenModel = null;
        ColorModelsManager colorModelsManager = this.mColorModelsManager;
        if (colorModelsManager != null) {
            Intrinsics.checkNotNull(colorModelsManager);
            IBaseModel.Observer observer = this.mColorChangeCallback;
            Intrinsics.checkNotNull(observer);
            colorModelsManager.removeObserver(observer);
            ColorModelsManager colorModelsManager2 = this.mColorModelsManager;
            Intrinsics.checkNotNull(colorModelsManager2);
            colorModelsManager2.close();
            this.mColorModelsManager = null;
        }
        SettingsModel settingsModel = this.mSettingsModel;
        if (settingsModel != null) {
            Intrinsics.checkNotNull(settingsModel);
            IBaseModel.Observer observer2 = this.mSettingsCallback;
            Intrinsics.checkNotNull(observer2);
            settingsModel.removeObserver(observer2);
            this.mSettingsModel = null;
        }
        PenModelList penModelList = this.mPenModelList;
        if (penModelList != null) {
            Intrinsics.checkNotNull(penModelList);
            PenModel mEraserPenModel = penModelList.getMEraserPenModel();
            Intrinsics.checkNotNull(mEraserPenModel);
            IBaseModel.Observer observer3 = this.mEraserChangeCallback;
            Intrinsics.checkNotNull(observer3);
            mEraserPenModel.removeObserver(observer3);
            PenModelList penModelList2 = this.mPenModelList;
            Intrinsics.checkNotNull(penModelList2);
            IBaseModel.Observer observer4 = this.mPenListCallback;
            Intrinsics.checkNotNull(observer4);
            penModelList2.removeObserver(observer4);
            PenModelList penModelList3 = this.mPenModelList;
            Intrinsics.checkNotNull(penModelList3);
            penModelList3.close();
            this.mPenModelList = null;
        }
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            Intrinsics.checkNotNull(brushFacade);
            IBaseModel.Observer observer5 = this.mFacadeCallback;
            Intrinsics.checkNotNull(observer5);
            brushFacade.removeObserver(observer5);
            BrushFacade brushFacade2 = this.mFacade;
            Intrinsics.checkNotNull(brushFacade2);
            brushFacade2.close();
            this.mFacade = null;
        }
        this.mPenListCallback = null;
        this.mEraserChangeCallback = null;
        this.mColorChangeCallback = null;
        this.mSettingsCallback = null;
        this.mFacadeCallback = null;
        this.mBrushModelListener = null;
    }

    @NotNull
    public final String getCurrentPenName() {
        IPenModel iPenModel = this.mBrushPenModel;
        if (iPenModel == null) {
            return "";
        }
        Intrinsics.checkNotNull(iPenModel);
        return iPenModel.getMPenType();
    }

    @Nullable
    public final IPenModel getMBrushPenModel() {
        return this.mBrushPenModel;
    }

    @Nullable
    public final ColorModelsManager getMColorModelsManager() {
        return this.mColorModelsManager;
    }

    @Nullable
    public final BrushFacade getMFacade() {
        return this.mFacade;
    }

    @Nullable
    public final PenModelList getMPenModelList() {
        return this.mPenModelList;
    }

    public final void savePenInfo() {
        PenModelList penModelList = this.mPenModelList;
        if (penModelList != null) {
            Intrinsics.checkNotNull(penModelList);
            penModelList.savePenInfo();
        }
    }

    public final void setBrushModelListener(@Nullable BrushModelZoomListener listener) {
        this.mBrushModelListener = listener;
    }

    public final void setPenEraserInfo() {
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            Intrinsics.checkNotNull(brushFacade);
            PenModelList penModelList = this.mPenModelList;
            Intrinsics.checkNotNull(penModelList);
            brushFacade.setPenEraserInfo(makePenInfo(penModelList.getMEraserPenModel()));
            PenModelList penModelList2 = this.mPenModelList;
            Intrinsics.checkNotNull(penModelList2);
            updatePenModel(penModelList2.getSelectedModel());
        }
    }

    public final void updateCurrentPenInfo() {
        updatePenInfo(this.mBrushPenModel);
    }
}
