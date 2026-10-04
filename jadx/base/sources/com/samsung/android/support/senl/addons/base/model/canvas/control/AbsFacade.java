package com.samsung.android.support.senl.addons.base.model.canvas.control;

import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPreTouchListener;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.IPenSettingPopup;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.color.IExtendedColor;
import com.samsung.android.support.senl.addons.base.model.common.AbsBaseModel;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.mode.IMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0002mnB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016J\u0016\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016J\u0016\u0010.\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0016J\u000e\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u00102\u001a\u00020,2\f\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fH\u0014J\b\u00103\u001a\u00020,H\u0016J\b\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u00020,H\u0004J\b\u00106\u001a\u00020\"H\u0014J\b\u00107\u001a\u00020,H\u0004J\u0012\u0010<\u001a\u00020,2\b\u0010=\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010>\u001a\u00020?H\u0014J(\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\"H\u0004J\u0016\u0010E\u001a\u00020,2\f\u0010F\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0016J\u000e\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eH\u0016J\u0010\u0010H\u001a\u00020,2\u0006\u0010I\u001a\u00020\"H\u0014J\b\u0010J\u001a\u00020,H\u0004J\b\u0010K\u001a\u00020\u0010H\u0016J \u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NH\u0014J\b\u0010Q\u001a\u00020,H\u0014J\b\u0010R\u001a\u00020,H\u0014J\b\u0010S\u001a\u00020,H\u0016J\b\u0010T\u001a\u00020,H\u0016J\b\u0010U\u001a\u00020,H\u0016J\b\u0010V\u001a\u00020,H\u0016J\b\u0010W\u001a\u00020\u001aH\u0016J\b\u0010X\u001a\u00020\u001aH\u0016J\b\u0010Y\u001a\u00020,H\u0016J\b\u0010Z\u001a\u00020,H\u0004J\u0010\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020\"H\u0004J\n\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0010\u0010_\u001a\u00020,2\u0006\u0010\\\u001a\u00020^H\u0014J\u0012\u0010`\u001a\u00020,2\b\u0010a\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010b\u001a\u00020,H\u0016J\u000f\u0010c\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0002\u0010dJ\b\u0010e\u001a\u00020,H\u0016J\b\u0010f\u001a\u00020,H\u0016J\u0010\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\u001aH\u0016J\u0012\u0010i\u001a\u00020\u001a2\b\u0010j\u001a\u0004\u0018\u00010kH\u0014J\u0012\u0010l\u001a\u00020\u001a2\b\u0010j\u001a\u0004\u0018\u00010kH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u001a8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b;\u0010%¨\u0006o"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade;", "Lcom/samsung/android/support/senl/addons/base/model/common/AbsBaseModel;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/IFacade;", "mMode", "Lcom/samsung/android/support/senl/addons/base/model/mode/IMode;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/mode/IMode;)V", "mCanvasController", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl;", "mDocModel", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "mView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "mSettingView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "mCanvasContainer", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer;", "mColor", "Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "getMColor", "()Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;", "setMColor", "(Lcom/samsung/android/support/senl/addons/base/model/color/ColorModel;)V", "mWindowPosition", "", "mIsLockForSaving", "", "mPreTouchListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPreTouchListener;", "getMPreTouchListener", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPreTouchListener;", "setMPreTouchListener", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPreTouchListener;)V", "mCanvasListenerEnableMask", "", "mIsDrawing", "getMIsDrawing", "()Z", "setMIsDrawing", "(Z)V", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "getDocModel", "setDoc", "", "doc", "setView", "view", "getView", "getViewPositionInWindow", "setSettingInfo", "clearViews", "initToolType", "setEraserToolTypeAction", "getEraserActionType", "setTooltype", "toolTypeAction", "getToolTypeAction", "()I", "isSpenOnlyMode", "setCanvasContainer", DBSchema.DocumentThumbnail.LAYOUT, "createCanvasActionListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl$ICanvasActionListener;", "onCanvasSizeChanged", "left", "top", "right", "bottom", "setSettingView", "settingView", "getSettingView", "enableCanvasListener", ImageConst.PARAM_MODE_WALLPAPER_MASK, "setListeners", "getCanvasContainer", "setZoom", WiggleAnimationConfig.KEY_SCALE, "", "centerX", "centerY", "closeViewControl", "resetViewState", "undo", "undoAll", "redo", "redoAll", "isUndoable", "isRedoable", "clearAll", "onZoom", "onColorPicked", "color", "getCurrentColor", "Lcom/samsung/android/support/senl/addons/base/model/color/IExtendedColor;", "setCurrentColor", "setPreTouchListener", "listner", "close", "getObjectCount", "()Ljava/lang/Integer;", "lockForSave", "unlockForSave", "enableFBR", "enable", "onPreTouch", "event", "Landroid/view/MotionEvent;", "onTouch", "CanvasActionListener", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAbsFacade.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbsFacade.kt\ncom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,415:1\n1#2:416\n*E\n"})
public abstract class AbsFacade extends AbsBaseModel implements IFacade {

    @NotNull
    private static final String TAG = Logger.createTag("AbsFacade");

    @Nullable
    private IBaseModel.Observer mCallback;

    @Nullable
    private ICanvasContainer mCanvasContainer;

    @Nullable
    private ICanvasControl mCanvasController;
    private int mCanvasListenerEnableMask;

    @Nullable
    private ColorModel mColor = new ColorModel(0);

    @Nullable
    private IDocModel<?> mDocModel;
    private boolean mIsDrawing;
    private boolean mIsLockForSaving;

    @Nullable
    private IMode mMode;

    @Nullable
    private IPreTouchListener mPreTouchListener;

    @Nullable
    private ISettingView<?> mSettingView;

    @Nullable
    private IView<?> mView;

    @Nullable
    private int[] mWindowPosition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\b\u0084\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0012H\u0016¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade$CanvasActionListener;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl$ICanvasActionListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade;)V", "onPreTouch", "", "motionEvent", "Landroid/view/MotionEvent;", "onCanvasSizeChanged", "", "left", "", "top", "right", "bottom", "onColorPicked", "color", "x", "", "y", "onTouch", "onZoom", "panX", "panY", "zoom", NetworkConfig.API_VERSION, "v4", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class CanvasActionListener implements ICanvasControl.ICanvasActionListener {
        public CanvasActionListener() {
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl.ICanvasActionListener
        public void onCanvasSizeChanged(int left, int top, int right, int bottom) {
            AbsFacade.this.onCanvasSizeChanged(left, top, right, bottom);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenColorPickerListener
        public void onColorPicked(int color, float x, float y2) {
            AbsFacade.this.onColorPicked(color);
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IPreTouchListener
        public boolean onPreTouch(@Nullable MotionEvent motionEvent) {
            return AbsFacade.this.onPreTouch(motionEvent);
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ITouchListener
        public boolean onTouch(@Nullable MotionEvent motionEvent) {
            return AbsFacade.this.onTouch(motionEvent);
        }

        @Override // com.samsung.android.sdk.pen.engine.deltaZoom.SpenZoomListener
        public void onZoom(float panX, float panY, float zoom, float v32, float v4) {
            String str = AbsFacade.TAG;
            StringBuilder sbM1176v = AbstractC0622a.m1176v("onZoom x: ", panX, ", y: ", panY, ", zoom: ");
            sbM1176v.append(zoom);
            Logger.m7100d(str, sbM1176v.toString());
            AbsFacade.this.onZoom();
        }
    }

    public AbsFacade(@Nullable IMode iMode) {
        this.mMode = iMode;
        IBaseModel.Observer observer = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade$mCallback$1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                if ((id != null && id.intValue() == 402) || ((id != null && id.intValue() == 401) || (id != null && id.intValue() == 403))) {
                    this.this$0.setTooltype();
                }
            }
        };
        this.mCallback = observer;
        IMode iMode2 = this.mMode;
        Intrinsics.checkNotNull(iMode2);
        iMode2.addObserver(observer);
        enableCanvasListener(31);
    }

    private final int getToolTypeAction() {
        IMode iMode = this.mMode;
        Intrinsics.checkNotNull(iMode);
        int currentMode = iMode.getCurrentMode();
        if (currentMode == 0) {
            return 0;
        }
        if (currentMode == 2) {
            return 2;
        }
        if (currentMode == 4) {
            return getEraserActionType();
        }
        if (currentMode == 5) {
            return 9;
        }
        if (currentMode == 6) {
            return 10;
        }
        switch (currentMode) {
            case 8:
                return 12;
            case 9:
                return 13;
            case 10:
                return 14;
            case 11:
                return 11;
            default:
                return 0;
        }
    }

    private final void initToolType() {
        setTooltype();
        setEraserToolTypeAction();
        IView<?> iView = this.mView;
        if (iView != null) {
            iView.setToolTypeAction(5, 1);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void clearAll() {
        if (this.mIsLockForSaving) {
            return;
        }
        IDocModel<?> iDocModel = this.mDocModel;
        if (iDocModel != null) {
            Intrinsics.checkNotNull(iDocModel);
            iDocModel.clearAll();
            Logger.m7104i(TAG, "clear all");
        }
        IView<?> iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.clearAll();
            IView<?> iView2 = this.mView;
            Intrinsics.checkNotNull(iView2);
            iView2.update();
        }
        notifyChanged(11008);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void clearViews() {
        Logger.m7100d(TAG, "clear Views");
        ICanvasControl iCanvasControl = this.mCanvasController;
        if (iCanvasControl != null) {
            Intrinsics.checkNotNull(iCanvasControl);
            iCanvasControl.close();
            this.mCanvasController = null;
        }
        IView<?> iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.close();
            this.mView = null;
        }
        ISettingView<?> iSettingView = this.mSettingView;
        if (iSettingView != null) {
            Intrinsics.checkNotNull(iSettingView);
            iSettingView.close();
            this.mSettingView = null;
        }
    }

    public void close() {
        IMode iMode = this.mMode;
        if (iMode != null) {
            IBaseModel.Observer observer = this.mCallback;
            if (observer != null) {
                Intrinsics.checkNotNull(iMode);
                iMode.removeObserver(observer);
            }
            this.mMode = null;
        }
        this.mCallback = null;
        this.mCanvasContainer = null;
        this.mPreTouchListener = null;
        this.mColor = null;
        this.mDocModel = null;
        this.mView = null;
        this.mWindowPosition = null;
    }

    public void closeViewControl() {
        IView<?> iView = this.mView;
        Intrinsics.checkNotNull(iView);
        iView.closeControl();
    }

    @NotNull
    public ICanvasControl.ICanvasActionListener createCanvasActionListener() {
        return new CanvasActionListener();
    }

    public void enableCanvasListener(int mask) {
        this.mCanvasListenerEnableMask = mask;
        ICanvasControl iCanvasControl = this.mCanvasController;
        if (iCanvasControl != null) {
            Intrinsics.checkNotNull(iCanvasControl);
            iCanvasControl.enableListener(mask);
        }
    }

    public void enableFBR(boolean enable) {
        IView<?> iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.setFrontBufferRenderingEnabled(enable);
            Logger.m7104i(TAG, "enabled FBR : " + enable);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @NotNull
    public ICanvasContainer getCanvasContainer() {
        ICanvasContainer iCanvasContainer = this.mCanvasContainer;
        Intrinsics.checkNotNull(iCanvasContainer);
        return iCanvasContainer;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public IExtendedColor getCurrentColor() {
        return this.mColor;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public IDocModel<?> getDocModel() {
        return this.mDocModel;
    }

    public int getEraserActionType() {
        return 8;
    }

    @Nullable
    public final ColorModel getMColor() {
        return this.mColor;
    }

    public final boolean getMIsDrawing() {
        return this.mIsDrawing;
    }

    @Nullable
    public final IPreTouchListener getMPreTouchListener() {
        return this.mPreTouchListener;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public Integer getObjectCount() {
        IDocModel<?> iDocModel = this.mDocModel;
        if (iDocModel != null) {
            return Integer.valueOf(iDocModel.getObjectCount());
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public ISettingView<?> getSettingView() {
        return this.mSettingView;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public IView<?> getView() {
        return this.mView;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public int[] getViewPositionInWindow() {
        IView<?> iView = this.mView;
        if (iView != null) {
            if (this.mWindowPosition == null) {
                this.mWindowPosition = new int[2];
            }
            if (iView != null) {
                iView.getLocationInWindow(this.mWindowPosition);
            }
        }
        return this.mWindowPosition;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public boolean isRedoable() {
        IDocModel<?> iDocModel = this.mDocModel;
        if (iDocModel == null) {
            return false;
        }
        Intrinsics.checkNotNull(iDocModel);
        return iDocModel.isRedoable();
    }

    public final boolean isSpenOnlyMode() {
        IMode iMode = this.mMode;
        if (iMode == null) {
            return true;
        }
        Intrinsics.checkNotNull(iMode);
        return iMode.getSpenOnlyMode();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public boolean isUndoable() {
        IDocModel<?> iDocModel = this.mDocModel;
        if (iDocModel == null) {
            return false;
        }
        Intrinsics.checkNotNull(iDocModel);
        return iDocModel.isUndoable();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void lockForSave() {
        this.mIsLockForSaving = true;
        IView<?> iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.lockForSave();
        }
    }

    public final void onCanvasSizeChanged(int left, int top, int right, int bottom) {
    }

    public final void onColorPicked(int color) {
        ColorModel colorModel = this.mColor;
        if (colorModel != null) {
            colorModel.setColor(color);
        }
        notifyChanged(11303);
    }

    public boolean onPreTouch(@Nullable MotionEvent event) {
        IPreTouchListener iPreTouchListener = this.mPreTouchListener;
        if (iPreTouchListener == null) {
            return false;
        }
        Intrinsics.checkNotNull(iPreTouchListener);
        return iPreTouchListener.onPreTouch(event);
    }

    public boolean onTouch(@Nullable MotionEvent event) {
        return false;
    }

    public final void onZoom() {
        notifyChanged(11100);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void redo() {
        if (this.mIsLockForSaving || this.mView == null || this.mDocModel == null || this.mIsDrawing) {
            return;
        }
        closeViewControl();
        IDocModel<?> iDocModel = this.mDocModel;
        Intrinsics.checkNotNull(iDocModel);
        if (!iDocModel.isRedoable()) {
            notifyChanged(11005);
            return;
        }
        IDocModel<?> iDocModel2 = this.mDocModel;
        Intrinsics.checkNotNull(iDocModel2);
        iDocModel2.redo();
        Logger.m7104i(TAG, "redo");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void redoAll() {
        if (this.mIsLockForSaving || this.mView == null || this.mDocModel == null || this.mIsDrawing) {
            return;
        }
        closeViewControl();
        IDocModel<?> iDocModel = this.mDocModel;
        Intrinsics.checkNotNull(iDocModel);
        if (iDocModel.isRedoable()) {
            IDocModel<?> iDocModel2 = this.mDocModel;
            Intrinsics.checkNotNull(iDocModel2);
            iDocModel2.redoAll();
            Logger.m7104i(TAG, "redoAll");
        }
    }

    public void resetViewState() {
        IView<?> iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.setPan(new PointF());
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void setCanvasContainer(@Nullable ICanvasContainer layout) {
        String str = TAG;
        Logger.m7100d(str, "setCanvasContainer");
        if (Intrinsics.areEqual(layout, this.mCanvasContainer)) {
            Logger.m7100d(str, "setCanvasContainer : call again");
            return;
        }
        ICanvasControl canvasControl = layout != null ? layout.getCanvasControl() : null;
        this.mCanvasController = canvasControl;
        if (canvasControl != null) {
            canvasControl.enableListener(this.mCanvasListenerEnableMask);
        }
        ICanvasControl.ICanvasActionListener iCanvasActionListenerCreateCanvasActionListener = createCanvasActionListener();
        ICanvasControl iCanvasControl = this.mCanvasController;
        if (iCanvasControl != null) {
            iCanvasControl.setCanvasActionListener(iCanvasActionListenerCreateCanvasActionListener);
        }
        setView(layout != null ? layout.getView() : null);
        setSettingView(layout != null ? layout.getSettingView() : null);
        setListeners();
        setSettingInfo(layout != null ? layout.getView() : null);
        initToolType();
        this.mCanvasContainer = layout;
        notifyChanged(11200);
    }

    public void setCurrentColor(@NotNull IExtendedColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        ColorModel colorModel = this.mColor;
        if (colorModel != null) {
            colorModel.setColor(color.getMColor(), color.getMHSV());
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void setDoc(@Nullable IDocModel<?> doc) {
        if (this.mDocModel != null) {
            Logger.m7105w(TAG, "already has doc, but change it");
        }
        this.mDocModel = doc;
    }

    public final void setEraserToolTypeAction() {
        int eraserActionType = getEraserActionType();
        IView<?> iView = this.mView;
        if (iView != null) {
            iView.setToolTypeAction(4, eraserActionType);
        }
        IView<?> iView2 = this.mView;
        if (iView2 != null) {
            iView2.setToolTypeAction(6, eraserActionType);
        }
    }

    public final void setListeners() {
        ICanvasControl iCanvasControl = this.mCanvasController;
        if (iCanvasControl != null) {
            iCanvasControl.setCanvasListeners();
        }
    }

    public final void setMColor(@Nullable ColorModel colorModel) {
        this.mColor = colorModel;
    }

    public final void setMIsDrawing(boolean z) {
        this.mIsDrawing = z;
    }

    public final void setMPreTouchListener(@Nullable IPreTouchListener iPreTouchListener) {
        this.mPreTouchListener = iPreTouchListener;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void setPreTouchListener(@Nullable IPreTouchListener listner) {
        this.mPreTouchListener = listner;
    }

    public void setSettingInfo(@Nullable IView<?> view) {
        ISettingView<?> settingView = getSettingView();
        if (settingView == null) {
            Logger.m7105w(TAG, "there is not general setting view");
        } else if (settingView.getPenSettingPopup() == null || view == null) {
            Logger.m7105w(TAG, "not needed to set pen info");
        } else {
            IPenSettingPopup penSettingPopup = settingView.getPenSettingPopup();
            view.setPenSettingInfo(penSettingPopup != null ? penSettingPopup.getInfo() : null);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void setSettingView(@Nullable ISettingView<?> settingView) {
        this.mSettingView = settingView;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setTooltype() {
        if (this.mView == null || this.mMode == null) {
            return;
        }
        int toolTypeAction = getToolTypeAction();
        Logger.m7100d(TAG, "setTooltype actionType : " + toolTypeAction);
        if (SpenUtils.isSpenActivated()) {
            DesktopModeCompat companion = DesktopModeCompat.INSTANCE.getInstance();
            IView<?> iView = this.mView;
            Intrinsics.checkNotNull(iView);
            if (companion.isNotDexModeOrStandAloneMode(iView.getContext())) {
                IView<?> iView2 = this.mView;
                Intrinsics.checkNotNull(iView2);
                if (SpenUtils.isSupportedSpenDisplay(iView2.getConfiguration()) && isSpenOnlyMode() && toolTypeAction != 0) {
                    IView<?> iView3 = this.mView;
                    Intrinsics.checkNotNull(iView3);
                    iView3.setToolTypeAction(1, 1);
                } else {
                    IView<?> iView4 = this.mView;
                    Intrinsics.checkNotNull(iView4);
                    iView4.setToolTypeAction(1, toolTypeAction);
                }
            }
        }
        IView<?> iView5 = this.mView;
        Intrinsics.checkNotNull(iView5);
        iView5.setToolTypeAction(0, toolTypeAction);
        IView<?> iView6 = this.mView;
        Intrinsics.checkNotNull(iView6);
        iView6.setToolTypeAction(2, toolTypeAction);
        IView<?> iView7 = this.mView;
        Intrinsics.checkNotNull(iView7);
        iView7.setToolTypeAction(3, toolTypeAction);
        IView<?> iView8 = this.mView;
        Intrinsics.checkNotNull(iView8);
        iView8.setActionType(toolTypeAction);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void setView(@Nullable IView<?> view) {
        AbstractC6670b.m4763x("setView : ", Integer.toHexString(view != null ? view.hashCode() : 0), TAG);
        this.mView = view;
        ICanvasControl iCanvasControl = this.mCanvasController;
        if (iCanvasControl != null) {
            iCanvasControl.setCanvas(view);
        }
    }

    public void setZoom(float scale, float centerX, float centerY) {
        String str = TAG;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("setZoom ", centerX, SQLKeyword.COMMA, centerY, " : ");
        sbM1176v.append(scale);
        Logger.m7100d(str, sbM1176v.toString());
        IView<?> iView = this.mView;
        if (iView != null) {
            iView.setZoomScale(scale, centerX, centerY);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void undo() {
        if (this.mIsLockForSaving || this.mView == null || this.mDocModel == null || this.mIsDrawing) {
            return;
        }
        closeViewControl();
        IDocModel<?> iDocModel = this.mDocModel;
        Intrinsics.checkNotNull(iDocModel);
        if (!iDocModel.isUndoable()) {
            notifyChanged(11004);
            return;
        }
        IDocModel<?> iDocModel2 = this.mDocModel;
        Intrinsics.checkNotNull(iDocModel2);
        iDocModel2.undo();
        Logger.m7100d(TAG, "undo");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void undoAll() {
        if (this.mIsLockForSaving || this.mView == null || this.mDocModel == null || this.mIsDrawing) {
            return;
        }
        closeViewControl();
        IDocModel<?> iDocModel = this.mDocModel;
        Intrinsics.checkNotNull(iDocModel);
        if (iDocModel.isUndoable()) {
            IDocModel<?> iDocModel2 = this.mDocModel;
            Intrinsics.checkNotNull(iDocModel2);
            iDocModel2.undoAll();
            Logger.m7100d(TAG, "undoAll");
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void unlockForSave() {
        this.mIsLockForSaving = false;
        IView<?> iView = this.mView;
        if (iView != null) {
            Intrinsics.checkNotNull(iView);
            iView.unlockForSave();
        }
    }
}
