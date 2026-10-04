package com.samsung.android.support.senl.addons.brush.model.canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.document.SpenHistoryUpdateInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.document.AbsPaintingDocModel;
import com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.model.color.ColorModel;
import com.samsung.android.support.senl.addons.base.model.mode.IMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 \u0086\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0086\u0001B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0016\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020 H\u0016J\u0018\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0016J\b\u0010.\u001a\u00020 H\u0002J\u000e\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u000bJ\u0010\u00101\u001a\u00020 2\b\u00102\u001a\u0004\u0018\u00010\u001aJ\b\u00103\u001a\u00020 H\u0002J\u000e\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0016J\u000e\u00105\u001a\b\u0012\u0002\b\u0003\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u00010\u0017J\u000e\u00109\u001a\u00020 2\u0006\u00108\u001a\u00020\u0017J\u0010\u0010:\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u0017H\u0002J\u0018\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020 H\u0016J\n\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020 H\u0016J\b\u0010G\u001a\u00020\u001cH\u0016J\u000f\u0010H\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010IJ*\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000bH\u0016J\n\u0010Z\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010[\u001a\u00020 J\u0014\u0010\\\u001a\u0004\u0018\u00010A2\b\u0010]\u001a\u0004\u0018\u00010NH\u0016J6\u0010^\u001a\u00020 2\b\u0010_\u001a\u0004\u0018\u00010W2\u001a\u0010`\u001a\u0016\u0012\u0004\u0012\u00020b\u0018\u00010aj\n\u0012\u0004\u0012\u00020b\u0018\u0001`c2\u0006\u0010d\u001a\u00020\u000bH\u0016J6\u0010e\u001a\u00020 2\b\u0010_\u001a\u0004\u0018\u00010W2\u001a\u0010`\u001a\u0016\u0012\u0004\u0012\u00020b\u0018\u00010aj\n\u0012\u0004\u0012\u00020b\u0018\u0001`c2\u0006\u0010d\u001a\u00020\u000bH\u0016J$\u0010f\u001a\u00020 2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020\u000bH\u0016J\u0018\u0010l\u001a\u00020 2\u0006\u0010m\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000bH\u0016J\b\u0010o\u001a\u00020 H\u0016J\b\u0010p\u001a\u00020\u000bH\u0016J\b\u0010q\u001a\u00020\u000bH\u0016J\n\u0010r\u001a\u0004\u0018\u00010sH\u0016J\b\u0010t\u001a\u00020\u001cH\u0016J\b\u0010u\u001a\u00020 H\u0016J\u0010\u0010z\u001a\u00020 2\u0006\u0010{\u001a\u00020\u001cH\u0016J\b\u0010|\u001a\u00020 H\u0016J\b\u0010}\u001a\u00020 H\u0016J\b\u0010~\u001a\u00020 H\u0016J\b\u0010\u007f\u001a\u00020 H\u0016J\t\u0010\u0080\u0001\u001a\u00020 H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020 2\u0006\u0010_\u001a\u00020WH\u0016J\u001a\u0010\u0082\u0001\u001a\u00020 2\u0006\u0010_\u001a\u00020W2\u0007\u0010\u0083\u0001\u001a\u00020\u001cH\u0016J\u001a\u0010\u0084\u0001\u001a\u00020 2\u0006\u0010_\u001a\u00020W2\u0007\u0010\u0085\u0001\u001a\u00020\u001cH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0016\u0010J\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0016\u0010S\u001a\u0004\u0018\u00010N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0016\u0010V\u001a\u0004\u0018\u00010W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010j\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR$\u0010w\u001a\u00020\u001c2\u0006\u0010v\u001a\u00020\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010k\"\u0004\bx\u0010y¨\u0006\u0087\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/AbsPaintingDocModel$IDocModelListener;", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;", "mode", "Lcom/samsung/android/support/senl/addons/base/model/mode/IMode;", "mScreenModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/mode/IMode;Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasScreenModel;)V", "DEFAULT_THUMBNAIL_HEIGHT", "", "getDEFAULT_THUMBNAIL_HEIGHT$annotations", "()V", "DEFAULT_THUMBNAIL_MARGIN", "getDEFAULT_THUMBNAIL_MARGIN$annotations", "mPaintingDocModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushDocModel;", "mSpenView", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvas;", "mZoomModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushZoomModel;", "mPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mEraserInfo", "mDocPath", "", "mIsDocLoaded", "", "mIsReadySetDocument", "mIsNotifyShowPreview", "close", "", "setView", "view", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "getEraserActionType", "onPreTouch", "event", "Landroid/view/MotionEvent;", "onTouch", "isDrawing", "clearViews", "setThumbnailMargin", "horizontal", "vertical", "setDocument", "updateDisallowTouchDownArea", "navigationBarHeight", "createDocument", "filePath", "initSpenView", "getView", "getDocModel", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "setPenEraserInfo", "info", "setPenSettingInfo", "setPenSetting", "compareInfo", "info1", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "info2", "closeViewControl", "captureAllPage", "Landroid/graphics/Bitmap;", "commitStroke", "drawnRectOfAllObject", "Landroid/graphics/RectF;", "getDrawnRectOfAllObject", "()Landroid/graphics/RectF;", "isEmpty", "getObjectCount", "()Ljava/lang/Integer;", "foregroundImagePath", "getForegroundImagePath", "()Ljava/lang/String;", "getValidRect", "Landroid/graphics/Rect;", "lMargin", "tMargin", "rMargin", "bMargin", "drawnRect", "getDrawnRect", "()Landroid/graphics/Rect;", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "getPaintingDoc", "()Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "captureForegroundPage", "clearPaintingViewDoc", "captureRect", "rect", "onObjectAdded", "spenPaintingDoc", "arrayList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "Lkotlin/collections/ArrayList;", "i", "onObjectRemoved", "onObjectChanged", "objectChangedInfo", "Lcom/samsung/android/sdk/pen/document/changedInfo/SpenObjectChangedInfo;", "type", "isChanged", "()Z", "setZoomRatios", "viewWidth", "viewHeight", "discardDoc", "getPageDocWidth", "getPageDocHeight", "getPreviewBitmap", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "isDocLoaded", "capturePreviewImage", "isDiscard", "isDiscardDoc", "setDiscardDoc", "(Z)V", "setMouseWheelZoomEnabled", "wheelZoomEnabled", "showCanvas", "undo", "undoAll", "redo", "redoAll", "onCommit", "onUndoable", "undoable", "onRedoable", "redoable", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushFacade extends AbsFacade implements AbsPaintingDocModel.IDocModelListener, IBrushCanvasModel {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushFacade");
    private int DEFAULT_THUMBNAIL_HEIGHT;
    private int DEFAULT_THUMBNAIL_MARGIN;

    @Nullable
    private String mDocPath;

    @Nullable
    private SpenSettingUIPenInfo mEraserInfo;
    private boolean mIsDocLoaded;
    private boolean mIsNotifyShowPreview;
    private boolean mIsReadySetDocument;

    @Nullable
    private BrushDocModel mPaintingDocModel;

    @Nullable
    private SpenSettingUIPenInfo mPenInfo;

    @Nullable
    private IBrushCanvasScreenModel mScreenModel;

    @Nullable
    private IBrushCanvas mSpenView;

    @Nullable
    private BrushZoomModel mZoomModel;

    public BrushFacade(@Nullable IMode iMode, @Nullable IBrushCanvasScreenModel iBrushCanvasScreenModel) {
        super(iMode);
        this.mScreenModel = iBrushCanvasScreenModel;
        this.mZoomModel = new BrushZoomModel();
    }

    private final boolean compareInfo(SpenSettingPenInfo info1, SpenSettingPenInfo info2) {
        return Intrinsics.areEqual(info1.name, info2.name) && info1.color == info2.color && info1.sizeLevel == info2.sizeLevel && info1.particleDensity == info2.particleDensity;
    }

    private static /* synthetic */ void getDEFAULT_THUMBNAIL_HEIGHT$annotations() {
    }

    private static /* synthetic */ void getDEFAULT_THUMBNAIL_MARGIN$annotations() {
    }

    private final RectF getDrawnRectOfAllObject() {
        Logger.m7100d(TAG, "getDrawnRectOfAllObject");
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            return brushDocModel.getDrawnRectOfAllObject();
        }
        return null;
    }

    private final void initSpenView() {
        if (this.mSpenView == null) {
            return;
        }
        setListeners();
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            iBrushCanvas.setEraserSettingInfo(this.mEraserInfo);
        }
        IBrushCanvas iBrushCanvas2 = this.mSpenView;
        if (iBrushCanvas2 != null) {
            iBrushCanvas2.setPenSettingInfo(this.mPenInfo);
        }
    }

    private final void setDocument() {
        if (this.mSpenView != null) {
            String str = TAG;
            Logger.m7100d(str, "setDocument");
            if (this.mPaintingDocModel == null) {
                IBrushCanvasScreenModel iBrushCanvasScreenModel = this.mScreenModel;
                Intrinsics.checkNotNull(iBrushCanvasScreenModel);
                this.mPaintingDocModel = new BrushDocModel(iBrushCanvasScreenModel, this.mDocPath);
                IBrushCanvas iBrushCanvas = this.mSpenView;
                Intrinsics.checkNotNull(iBrushCanvas);
                BrushDocModel brushDocModel = this.mPaintingDocModel;
                Intrinsics.checkNotNull(brushDocModel);
                iBrushCanvas.initializeDocModel(brushDocModel);
                AbstractC6670b.m4763x("create doc model : ", Logger.getEncode(this.mDocPath), str);
                setDoc(this.mPaintingDocModel);
                BrushDocModel brushDocModel2 = this.mPaintingDocModel;
                if (brushDocModel2 != null) {
                    Intrinsics.checkNotNull(brushDocModel2);
                    brushDocModel2.setDocModelListener(this);
                }
            }
            if (this.mPaintingDocModel != null) {
                BrushZoomModel brushZoomModel = this.mZoomModel;
                Intrinsics.checkNotNull(brushZoomModel);
                BrushDocModel brushDocModel3 = this.mPaintingDocModel;
                Intrinsics.checkNotNull(brushDocModel3);
                int width = brushDocModel3.getWidth();
                BrushDocModel brushDocModel4 = this.mPaintingDocModel;
                Intrinsics.checkNotNull(brushDocModel4);
                brushZoomModel.setDocSize(width, brushDocModel4.getHeight());
                IBrushCanvas iBrushCanvas2 = this.mSpenView;
                Logger.m7100d(str, "set painting doc to " + Integer.toHexString(iBrushCanvas2 != null ? iBrushCanvas2.hashCode() : 0));
                AbstractC6670b.m4763x("doc Loaded /", Integer.toHexString(hashCode()), str);
                this.mIsDocLoaded = true;
                notifyChanged(11401);
            }
            notifyChanged(11500);
        }
    }

    private final boolean setPenSetting(SpenSettingUIPenInfo info) {
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas == null) {
            return false;
        }
        Intrinsics.checkNotNull(iBrushCanvas);
        SpenSettingPenInfo penSettingInfo = iBrushCanvas.getPenSettingInfo();
        Intrinsics.checkNotNull(penSettingInfo);
        if (compareInfo(info, penSettingInfo)) {
            return false;
        }
        IBrushCanvas iBrushCanvas2 = this.mSpenView;
        Intrinsics.checkNotNull(iBrushCanvas2);
        iBrushCanvas2.setPenSettingInfo(info);
        return true;
    }

    @Nullable
    public Bitmap captureAllPage() {
        Logger.m7100d(TAG, "captureAllPage");
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            return iBrushCanvas.capturePage(1.0f, 273);
        }
        return null;
    }

    @Nullable
    public Bitmap captureForegroundPage() {
        Logger.m7100d(TAG, "captureForegroundPage");
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            return iBrushCanvas.capturePage(1.0f, 273);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel
    public void capturePreviewImage() {
        if (this.mPaintingDocModel == null || !isChanged()) {
            return;
        }
        if (captureForegroundPage() == null) {
            Logger.m7105w(TAG, "set foreground image : failed - null bitmap");
            return;
        }
        SpenPaintingDoc paintingDoc = getPaintingDoc();
        Intrinsics.checkNotNull(paintingDoc);
        paintingDoc.setForegroundImage(captureForegroundPage());
    }

    @Nullable
    public Bitmap captureRect(@Nullable Rect rect) {
        Logger.m7100d(TAG, "captureAllPage");
        if (rect == null || this.mSpenView == null) {
            return null;
        }
        RectF rectF = new RectF(rect.left, rect.top, rect.right, rect.bottom);
        IBrushCanvas iBrushCanvas = this.mSpenView;
        Intrinsics.checkNotNull(iBrushCanvas);
        return iBrushCanvas.captureRect(rectF);
    }

    public final void clearPaintingViewDoc() {
        BrushDocModel brushDocModel;
        if (this.mSpenView == null || (brushDocModel = this.mPaintingDocModel) == null) {
            return;
        }
        String str = TAG;
        Intrinsics.checkNotNull(brushDocModel);
        Logger.m7100d(str, "clearPaintingViewDoc - " + brushDocModel.getMPaintingDoc());
        IBrushCanvas iBrushCanvas = this.mSpenView;
        Intrinsics.checkNotNull(iBrushCanvas);
        iBrushCanvas.setPaintingDoc(null, true);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void clearViews() {
        Logger.m7100d(TAG, "clearViews");
        clearPaintingViewDoc();
        super.clearViews();
        this.mSpenView = null;
        BrushZoomModel brushZoomModel = this.mZoomModel;
        Intrinsics.checkNotNull(brushZoomModel);
        brushZoomModel.initialize();
        this.mIsNotifyShowPreview = false;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade
    public void close() {
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            iBrushCanvas.setOnLoadedDocumentListener(null);
        }
        clearViews();
        this.mScreenModel = null;
        this.mZoomModel = null;
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            Intrinsics.checkNotNull(brushDocModel);
            brushDocModel.close();
            this.mPaintingDocModel = null;
        }
        this.mPenInfo = null;
        this.mEraserInfo = null;
        super.close();
        Logger.m7100d(TAG, "close");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade
    public void closeViewControl() {
        super.closeViewControl();
        IBrushCanvas iBrushCanvas = this.mSpenView;
        Intrinsics.checkNotNull(iBrushCanvas);
        iBrushCanvas.commitStroke();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void commitStroke() {
        Logger.m7100d(TAG, "commitStroke");
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            iBrushCanvas.commitStroke();
        }
    }

    public final void createDocument(@Nullable String filePath) {
        if (this.mIsReadySetDocument) {
            Logger.m7105w(TAG, "createDocument : already created");
            return;
        }
        if (!PlatformUtil.isAvailableMinimumMemory()) {
            Logger.m7101e(TAG, "createDocument fail not enough storage");
            return;
        }
        AbstractC6670b.m4763x("createDocument : ", Logger.getEncode(filePath), TAG);
        if (this.mDocPath == null && filePath != null) {
            this.mDocPath = filePath;
        }
        if (this.mSpenView != null) {
            setDocument();
            initSpenView();
            setEraserToolTypeAction();
        }
        this.mIsReadySetDocument = true;
    }

    public void discardDoc() {
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            brushDocModel.discard();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public IDocModel<?> getDocModel() {
        return this.mPaintingDocModel;
    }

    @Nullable
    public Rect getDrawnRect() {
        Rect validRect = getValidRect(-1, 0, -1, 0);
        if (validRect == null) {
            Logger.m7100d(TAG, "validRect is null");
            return null;
        }
        String str = TAG;
        int iHeight = validRect.height();
        int i = validRect.top;
        int i2 = validRect.bottom;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(iHeight, i, "height of validRect : ", " , t: ", " b: ");
        sbM1173s.append(i2);
        Logger.m7100d(str, sbM1173s.toString());
        if (validRect.height() <= 0) {
            return null;
        }
        int i4 = validRect.top;
        int i5 = this.DEFAULT_THUMBNAIL_MARGIN;
        int i6 = i4 - i5;
        validRect.top = i6;
        if (i6 < 0) {
            validRect.top = 0;
        }
        validRect.bottom += i5;
        int iHeight2 = validRect.height();
        if (getPaintingDoc() != null) {
            SpenPaintingDoc paintingDoc = getPaintingDoc();
            Intrinsics.checkNotNull(paintingDoc);
            iHeight2 = paintingDoc.getHeight();
        }
        if (validRect.bottom > iHeight2) {
            validRect.bottom = iHeight2;
        }
        if (validRect.height() < this.DEFAULT_THUMBNAIL_HEIGHT) {
            int iHeight3 = (int) ((r4 - validRect.height()) / 2.0f);
            int i7 = validRect.top - iHeight3;
            validRect.top = i7;
            int i8 = validRect.bottom + iHeight3;
            validRect.bottom = i8;
            if (i7 < 0) {
                validRect.bottom = i8 - i7;
                validRect.top = 0;
            }
            int i9 = validRect.bottom;
            if (i9 > iHeight2) {
                validRect.top = (iHeight2 - i9) + validRect.top;
                validRect.bottom = iHeight2;
            }
        }
        return validRect;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade
    public int getEraserActionType() {
        return 7;
    }

    @Nullable
    public String getForegroundImagePath() {
        String str = TAG;
        Logger.m7100d(str, "getForegroundImagePath");
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel == null) {
            return null;
        }
        Intrinsics.checkNotNull(brushDocModel);
        String foregroundImagePath = brushDocModel.getForegroundImagePath();
        AbstractC6670b.m4763x("SpenPaintingDoc foregroundImagePath = ", Logger.getEncode(foregroundImagePath), str);
        return foregroundImagePath;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public Integer getObjectCount() {
        String str = TAG;
        Logger.m7100d(str, "getObjectCount");
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel == null) {
            Logger.m7100d(str, "getObjectCount : null model");
            return 0;
        }
        Intrinsics.checkNotNull(brushDocModel);
        Integer objectCount = brushDocModel.getObjectCount(false);
        Logger.m7100d(str, "getObjectCount : " + objectCount);
        return objectCount;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel
    public int getPageDocHeight() {
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            return brushDocModel.getHeight();
        }
        return 0;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel
    public int getPageDocWidth() {
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            return brushDocModel.getWidth();
        }
        return 0;
    }

    @Nullable
    public SpenPaintingDoc getPaintingDoc() {
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            return brushDocModel.getMPaintingDoc();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel
    @Nullable
    public BrushPreviewBitmap getPreviewBitmap() {
        BrushDocModel brushDocModel;
        if (this.mSpenView != null && this.mZoomModel != null && (brushDocModel = this.mPaintingDocModel) != null) {
            Intrinsics.checkNotNull(brushDocModel);
            SpenPaintingDoc mPaintingDoc = brushDocModel.getMPaintingDoc();
            if (mPaintingDoc != null) {
                BrushZoomModel brushZoomModel = this.mZoomModel;
                Intrinsics.checkNotNull(brushZoomModel);
                if (brushZoomModel.isInitZoomRatios()) {
                    Bitmap foregroundImage = mPaintingDoc.getForegroundImage();
                    int width = mPaintingDoc.getWidth();
                    int height = mPaintingDoc.getHeight();
                    IBrushCanvas iBrushCanvas = this.mSpenView;
                    Intrinsics.checkNotNull(iBrushCanvas);
                    float zoomScale = iBrushCanvas.getZoomScale();
                    IBrushCanvas iBrushCanvas2 = this.mSpenView;
                    Intrinsics.checkNotNull(iBrushCanvas2);
                    return new BrushPreviewBitmap(foregroundImage, width, height, zoomScale, iBrushCanvas2.getPan());
                }
            }
        }
        return null;
    }

    @Nullable
    public Rect getValidRect(int lMargin, int tMargin, int rMargin, int bMargin) {
        String str = TAG;
        Logger.m7100d(str, "getValidRect");
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas == null) {
            Logger.m7101e(str, "getValidRect : null SpenView");
            return null;
        }
        try {
            Intrinsics.checkNotNull(iBrushCanvas);
            RectF validRect = iBrushCanvas.getValidRect(lMargin, tMargin, rMargin, bMargin);
            Intrinsics.checkNotNull(validRect);
            return new Rect((int) validRect.left, (int) validRect.top, (int) validRect.right, (int) validRect.bottom);
        } catch (IllegalArgumentException e) {
            Logger.m7101e(TAG, "getValidRect" + e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    @Nullable
    public IView<?> getView() {
        return this.mSpenView;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isChanged() {
        boolean z;
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if ((brushDocModel != null ? brushDocModel.getMPaintingDoc() : null) != null) {
            BrushDocModel brushDocModel2 = this.mPaintingDocModel;
            Intrinsics.checkNotNull(brushDocModel2);
            SpenPaintingDoc mPaintingDoc = brushDocModel2.getMPaintingDoc();
            Intrinsics.checkNotNull(mPaintingDoc);
            z = mPaintingDoc.isChanged();
        }
        AbstractC6670b.m4764y("isChanged : ", TAG, z);
        return z;
    }

    public boolean isDiscardDoc() {
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            return brushDocModel.getMIsTobeDiscardDoc();
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel
    public boolean isDocLoaded() {
        Logger.m7100d(TAG, "isDocLoaded : " + this.mIsDocLoaded + " / " + Integer.toHexString(hashCode()));
        return this.mIsDocLoaded;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public boolean isDrawing() {
        return getMIsDrawing();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public boolean isEmpty() {
        RectF drawnRectOfAllObject = getDrawnRectOfAllObject();
        Rect drawnRect = getDrawnRect();
        if (drawnRectOfAllObject != null) {
            Logger.m7100d(TAG, AbstractC1038a.m1216q(AbstractC0622a.m1176v("isPaintingEmpty >> getDrawnRectOfAllObject = [ ", drawnRectOfAllObject.left, " ][ ", drawnRectOfAllObject.top, " ][ "), drawnRectOfAllObject.right, " ][ ", drawnRectOfAllObject.bottom, " ]"));
        }
        if (drawnRect != null) {
            Logger.m7100d(TAG, AbstractC2322a.m1625o(AbstractC0622a.m1173s(drawnRect.left, drawnRect.top, "isPaintingEmpty >> drawnRect = [ ", " ][ ", " ][ "), drawnRect.right, drawnRect.bottom, " ][ ", " ]"));
        }
        Integer objectCount = getObjectCount();
        boolean z = (objectCount != null && objectCount.intValue() == 0) || drawnRect == null || drawnRectOfAllObject == null || drawnRectOfAllObject.height() <= 0.0f;
        AbstractC6670b.m4764y("isPaintingEmpty, isEmpty: ", TAG, z);
        return z;
    }

    @Override // com.samsung.android.sdk.pen.document.SpenPaintingDoc.HistoryListener
    public void onCommit(@NotNull SpenPaintingDoc spenPaintingDoc) {
        Intrinsics.checkNotNullParameter(spenPaintingDoc, "spenPaintingDoc");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenPaintingDoc.ObjectListener
    public void onObjectAdded(@Nullable SpenPaintingDoc spenPaintingDoc, @Nullable ArrayList<SpenObjectBase> arrayList, int i) {
        String str = TAG;
        Logger.m7100d(str, "onObjectAdded");
        notifyChanged(11006);
        setMIsDrawing(false);
        Logger.m7104i(str, "onObjectAdded: mIsDrawing: false");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenPaintingDoc.ObjectListener
    public void onObjectChanged(@Nullable SpenPaintingDoc paintingDoc, @Nullable SpenObjectChangedInfo objectChangedInfo, int type) {
        Logger.m7100d(TAG, "onObjectChanged");
    }

    @Override // com.samsung.android.sdk.pen.document.SpenPaintingDoc.ObjectListener
    public void onObjectRemoved(@Nullable SpenPaintingDoc spenPaintingDoc, @Nullable ArrayList<SpenObjectBase> arrayList, int i) {
        Logger.m7100d(TAG, "onObjectRemoved");
        notifyChanged(11007);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade
    public boolean onPreTouch(@Nullable MotionEvent event) {
        boolean zOnPreTouch = super.onPreTouch(event);
        if (event != null && event.getAction() == 0) {
            notifyChanged(11009);
        }
        return zOnPreTouch;
    }

    @Override // com.samsung.android.sdk.pen.document.SpenPaintingDoc.HistoryListener
    public void onRedoable(@NotNull SpenPaintingDoc spenPaintingDoc, boolean redoable) {
        Intrinsics.checkNotNullParameter(spenPaintingDoc, "spenPaintingDoc");
        AbstractC6670b.m4764y("onRedoable. ", TAG, redoable);
        if (redoable) {
            notifyChanged(11003);
        } else {
            notifyChanged(11005);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade
    public boolean onTouch(@Nullable MotionEvent event) {
        if (event != null && event.getActionMasked() == 1) {
            notifyChanged(11103);
        } else if (event != null && event.getActionMasked() == 3) {
            setMIsDrawing(false);
            Logger.m7100d(TAG, "onTouch: mIsDrawing = false");
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.document.SpenPaintingDoc.HistoryListener
    public void onUndoable(@NotNull SpenPaintingDoc spenPaintingDoc, boolean undoable) {
        Intrinsics.checkNotNullParameter(spenPaintingDoc, "spenPaintingDoc");
        AbstractC6670b.m4764y("onUndoable. ", TAG, undoable);
        if (undoable) {
            notifyChanged(11002);
        } else {
            notifyChanged(11004);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void redo() {
        if (this.mSpenView == null || this.mPaintingDocModel == null || getMIsDrawing()) {
            return;
        }
        closeViewControl();
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        Intrinsics.checkNotNull(brushDocModel);
        if (brushDocModel.isRedoable()) {
            BrushDocModel brushDocModel2 = this.mPaintingDocModel;
            Intrinsics.checkNotNull(brushDocModel2);
            SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrRedo = brushDocModel2.redo();
            IBrushCanvas iBrushCanvas = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas);
            iBrushCanvas.updateRedo(spenHistoryUpdateInfoArrRedo);
            Logger.m7104i(TAG, "redo #" + (spenHistoryUpdateInfoArrRedo != null ? Integer.valueOf(spenHistoryUpdateInfoArrRedo.length) : "0"));
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void redoAll() {
        if (this.mSpenView == null || this.mPaintingDocModel == null || getMIsDrawing()) {
            return;
        }
        closeViewControl();
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        Intrinsics.checkNotNull(brushDocModel);
        if (brushDocModel.isRedoable()) {
            BrushDocModel brushDocModel2 = this.mPaintingDocModel;
            Intrinsics.checkNotNull(brushDocModel2);
            SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrRedoAll = brushDocModel2.redoAll();
            IBrushCanvas iBrushCanvas = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas);
            iBrushCanvas.updateRedo(spenHistoryUpdateInfoArrRedoAll);
            Logger.m7104i(TAG, "redo all #" + (spenHistoryUpdateInfoArrRedoAll != null ? Integer.valueOf(spenHistoryUpdateInfoArrRedoAll.length) : "0"));
        }
    }

    public void setDiscardDoc(boolean z) {
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        if (brushDocModel != null) {
            brushDocModel.setDiscardDoc(z);
        }
    }

    public void setMouseWheelZoomEnabled(boolean wheelZoomEnabled) {
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            iBrushCanvas.setMouseWheelZoomEnabled(wheelZoomEnabled);
        }
    }

    public final void setPenEraserInfo(@Nullable SpenSettingUIPenInfo info) {
        this.mEraserInfo = info;
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            iBrushCanvas.setEraserSettingInfo(info);
        }
    }

    public final void setPenSettingInfo(@NotNull SpenSettingUIPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.mPenInfo = info;
        ColorModel mColor = getMColor();
        if (mColor != null) {
            mColor.setColor(info.color, info.hsv);
        }
        if (setPenSetting(info)) {
            notifyChanged(11303);
        }
    }

    public void setThumbnailMargin(int horizontal, int vertical) {
        this.DEFAULT_THUMBNAIL_MARGIN = horizontal;
        this.DEFAULT_THUMBNAIL_HEIGHT = vertical;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void setView(@Nullable IView<?> view) {
        if (!(view instanceof IBrushCanvas)) {
            throw new IllegalArgumentException("IView is not SpenPaintingView!!");
        }
        this.mSpenView = (IBrushCanvas) view;
        super.setView(view);
        if (this.mIsReadySetDocument) {
            setDocument();
            initSpenView();
            showCanvas();
        }
    }

    public void setZoomRatios(int viewWidth, int viewHeight) {
        BrushZoomModel brushZoomModel;
        if (this.mPaintingDocModel == null || (brushZoomModel = this.mZoomModel) == null || this.mSpenView == null) {
            Logger.m7101e(TAG, "setZoomRatios. fail.");
            return;
        }
        float f = viewWidth * 0.9f;
        float f4 = viewHeight * 0.9f;
        int i = viewWidth < viewHeight ? 1 : 2;
        Intrinsics.checkNotNull(brushZoomModel);
        brushZoomModel.setZoomRatios(viewWidth, viewHeight, f, f4, i);
        BrushZoomModel brushZoomModel2 = this.mZoomModel;
        Intrinsics.checkNotNull(brushZoomModel2);
        float mMinZoomRatio = brushZoomModel2.getMMinZoomRatio();
        BrushZoomModel brushZoomModel3 = this.mZoomModel;
        Intrinsics.checkNotNull(brushZoomModel3);
        float mFitZoomRatio = brushZoomModel3.getMFitZoomRatio();
        if (mMinZoomRatio > 0.0f) {
            IBrushCanvas iBrushCanvas = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas);
            if (iBrushCanvas.getMinZoomScale() != mMinZoomRatio) {
                Logger.m7100d(TAG, "setMinZoomRatio. " + mMinZoomRatio);
                IBrushCanvas iBrushCanvas2 = this.mSpenView;
                Intrinsics.checkNotNull(iBrushCanvas2);
                iBrushCanvas2.setMinZoomScale(mMinZoomRatio);
                if (this.mIsNotifyShowPreview) {
                    notifyChanged(Integer.valueOf(IBrushCanvasModel.INSTANCE.getOBSV_PROPERTY_UPDATE_PREVIEW()));
                }
            }
        }
        if (mFitZoomRatio > 0.0f) {
            BrushZoomModel brushZoomModel4 = this.mZoomModel;
            Intrinsics.checkNotNull(brushZoomModel4);
            IBrushCanvas iBrushCanvas3 = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas3);
            if (brushZoomModel4.isNeedSetFitZoom(iBrushCanvas3.getZoomScale())) {
                Logger.m7100d(TAG, "set fit zoom : " + mFitZoomRatio);
                setZoom(mFitZoomRatio, 0.0f, 0.0f);
                BrushZoomModel brushZoomModel5 = this.mZoomModel;
                Intrinsics.checkNotNull(brushZoomModel5);
                brushZoomModel5.setFitZoomUpdated();
            }
        }
        if (mMinZoomRatio > 0.0f) {
            IBrushCanvas iBrushCanvas4 = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas4);
            if (mMinZoomRatio > iBrushCanvas4.getZoomScale()) {
                setZoom(mMinZoomRatio, 0.0f, 0.0f);
            }
        }
        BrushZoomModel brushZoomModel6 = this.mZoomModel;
        Intrinsics.checkNotNull(brushZoomModel6);
        if (brushZoomModel6.isInitZoomRatios()) {
            notifyChanged(11101);
            if (!isDocLoaded() || this.mIsNotifyShowPreview) {
                return;
            }
            notifyChanged(Integer.valueOf(IBrushCanvasModel.INSTANCE.getOBSV_PROPERTY_SHOW_PREVIEW_IMAGES()));
            this.mIsNotifyShowPreview = true;
        }
    }

    public void showCanvas() {
        BrushDocModel brushDocModel;
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas == null || (brushDocModel = this.mPaintingDocModel) == null) {
            return;
        }
        if (iBrushCanvas != null) {
            iBrushCanvas.setPaintingDoc(brushDocModel != null ? brushDocModel.getMPaintingDoc() : null, true);
        }
        IBrushCanvas iBrushCanvas2 = this.mSpenView;
        if (iBrushCanvas2 != null) {
            iBrushCanvas2.setOnLoadedDocumentListener(new IPaintingView.OnDocumentLoadedListener() { // from class: com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade.showCanvas.1
                @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView.OnDocumentLoadedListener
                public void onLoaded(IPaintingView view) {
                    if (Intrinsics.areEqual(view, BrushFacade.this.mSpenView)) {
                        BrushFacade.this.notifyChanged(Integer.valueOf(IBrushCanvasModel.INSTANCE.getOBSV_PROPERTY_SHOW_CANVAS()));
                        if (view != null) {
                            view.setOnLoadedDocumentListener(null);
                        }
                    }
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void undo() {
        if (this.mSpenView == null || this.mPaintingDocModel == null || getMIsDrawing()) {
            Logger.m7100d(TAG, "undo false: mPaintingDocModel: " + this.mPaintingDocModel + ", mIsDrawing: " + getMIsDrawing());
            return;
        }
        closeViewControl();
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        Intrinsics.checkNotNull(brushDocModel);
        if (brushDocModel.isUndoable()) {
            BrushDocModel brushDocModel2 = this.mPaintingDocModel;
            Intrinsics.checkNotNull(brushDocModel2);
            SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrUndo = brushDocModel2.undo();
            IBrushCanvas iBrushCanvas = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas);
            iBrushCanvas.updateUndo(spenHistoryUpdateInfoArrUndo);
            Logger.m7104i(TAG, "undo #" + (spenHistoryUpdateInfoArrUndo != null ? Integer.valueOf(spenHistoryUpdateInfoArrUndo.length) : "0"));
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade, com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade
    public void undoAll() {
        if (this.mSpenView == null || this.mPaintingDocModel == null || getMIsDrawing()) {
            return;
        }
        closeViewControl();
        BrushDocModel brushDocModel = this.mPaintingDocModel;
        Intrinsics.checkNotNull(brushDocModel);
        if (brushDocModel.isUndoable()) {
            BrushDocModel brushDocModel2 = this.mPaintingDocModel;
            Intrinsics.checkNotNull(brushDocModel2);
            SpenHistoryUpdateInfo[] spenHistoryUpdateInfoArrUndoAll = brushDocModel2.undoAll();
            IBrushCanvas iBrushCanvas = this.mSpenView;
            Intrinsics.checkNotNull(iBrushCanvas);
            iBrushCanvas.updateUndo(spenHistoryUpdateInfoArrUndoAll);
            Logger.m7104i(TAG, "undo all #" + (spenHistoryUpdateInfoArrUndoAll != null ? Integer.valueOf(spenHistoryUpdateInfoArrUndoAll.length) : "0"));
        }
    }

    public final void updateDisallowTouchDownArea(int navigationBarHeight) {
        IBrushCanvas iBrushCanvas = this.mSpenView;
        if (iBrushCanvas != null) {
            iBrushCanvas.setTouchMargin(0, 0, 0, navigationBarHeight / 4);
        }
    }
}
