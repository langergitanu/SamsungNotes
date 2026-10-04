package com.samsung.android.support.senl.addons.brush.viewmodel.canvas;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.control.AbsFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.control.IFacade;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel;
import com.samsung.android.support.senl.addons.base.viewmodel.zoom.AbsZoomViewModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvas;
import com.samsung.android.support.senl.addons.brush.util.ResourceUtil;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\fH\u0014J\b\u0010\u001e\u001a\u00020\fH\u0016JP\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/viewmodel/canvas/BrushCanvasViewModel;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/zoom/AbsZoomViewModel;", "<init>", "()V", "mFacade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "mLayoutWidth", "", "mLayoutHeight", "mCallBack", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "setFacade", "", "facade", "Lcom/samsung/android/support/senl/addons/base/model/canvas/control/AbsFacade;", "perform", "action", "Lcom/samsung/android/support/senl/addons/base/viewmodel/common/IBaseViewModel$Action;", "canvasSize", "Landroid/graphics/Rect;", "getCanvasSize", "()Landroid/graphics/Rect;", "onZoomInClicked", "onZoomOutClicked", "updateZoomButton", "updateZoomRatios", "width", "height", "closeSubViewModels", "closeCallbacks", "clearModels", BrushCanvasViewModel.BINDING_ID_ON_LAYOUT_CHANGE, VPathDataCmd.RCurveTo, "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBrushCanvasViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrushCanvasViewModel.kt\ncom/samsung/android/support/senl/addons/brush/viewmodel/canvas/BrushCanvasViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,178:1\n1#2:179\n*E\n"})
public class BrushCanvasViewModel extends AbsZoomViewModel {

    @NotNull
    private static final String BINDING_ID_ON_LAYOUT_CHANGE = "onLayoutChange";

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushCanvasViewModel");

    @Nullable
    private IBaseModel.Observer mCallBack = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.viewmodel.canvas.BrushCanvasViewModel$mCallBack$1
        @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
        public void onUpdate(IBaseModel.Info info) {
            Integer id = info != null ? info.getId() : null;
            if (id != null && id.intValue() == 11401) {
                this.this$0.updateZoomRatios();
                return;
            }
            if (id == null || id.intValue() != 11100) {
                if (id != null && id.intValue() == 11101) {
                    this.this$0.updateZoomButton();
                    return;
                }
                if (id != null && id.intValue() == 11103) {
                    this.this$0.setMCheckZoomInOut(0);
                    BrushFacade brushFacade = this.this$0.mFacade;
                    if (brushFacade != null) {
                        brushFacade.setMIsDrawing(false);
                    }
                    Logger.m7104i(BrushCanvasViewModel.TAG, "onUpdate: mIsDrawing: false");
                    return;
                }
                return;
            }
            BrushFacade brushFacade2 = this.this$0.mFacade;
            Intrinsics.checkNotNull(brushFacade2);
            IView<?> view = brushFacade2.getView();
            Intrinsics.checkNotNull(view);
            if (view.getZoomScale() <= this.this$0.getMPrevZoomRatio()) {
                BrushFacade brushFacade3 = this.this$0.mFacade;
                Intrinsics.checkNotNull(brushFacade3);
                IView<?> view2 = brushFacade3.getView();
                Intrinsics.checkNotNull(view2);
                if (view2.getZoomScale() < this.this$0.getMPrevZoomRatio() && this.this$0.getMCheckZoomInOut() != 2) {
                    SystemLogManager.INSTANCE.onZoomOut();
                    this.this$0.setMCheckZoomInOut(2);
                }
            } else if (this.this$0.getMCheckZoomInOut() != 1) {
                SystemLogManager.INSTANCE.onZoomIn();
                this.this$0.setMCheckZoomInOut(1);
            }
            this.this$0.updateZoomText();
            this.this$0.updateZoomButton();
        }
    };

    @Nullable
    private BrushFacade mFacade;
    private int mLayoutHeight;
    private int mLayoutWidth;

    private final Rect getCanvasSize() {
        if (this.mLayoutWidth <= 0 || this.mLayoutHeight <= 0) {
            return null;
        }
        Rect rect = new Rect();
        rect.set(0, 0, this.mLayoutWidth, this.mLayoutHeight);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateZoomButton() {
        IView<?> view;
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade == null || (view = brushFacade.getView()) == null) {
            return;
        }
        updateZoomInOutButton(view.getZoomScale(), view.getMinZoomScale(), view.getMaxZoomScale());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateZoomRatios() {
        int i;
        BrushFacade brushFacade;
        int i2 = this.mLayoutWidth;
        if (i2 <= 0 || (i = this.mLayoutHeight) <= 0 || (brushFacade = this.mFacade) == null) {
            return;
        }
        brushFacade.setZoomRatios(i2, i);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.zoom.AbsZoomViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void clearModels() {
        BrushFacade brushFacade;
        IBaseModel.Observer observer = this.mCallBack;
        if (observer != null && (brushFacade = this.mFacade) != null) {
            brushFacade.removeObserver(observer);
        }
        this.mFacade = null;
        super.clearModels();
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeCallbacks() {
        this.mCallBack = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel
    public void closeSubViewModels() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayoutChange(@Nullable View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        int i = oldBottom - oldTop;
        int i2 = right - left;
        int i4 = bottom - top;
        if (i2 == oldRight - oldLeft && i4 == i) {
            return;
        }
        char c = i2 < i4 ? (char) 1 : (char) 2;
        if (v instanceof IBrushCanvas) {
            if (TabletUtil.isTabletUi()) {
                ((IBrushCanvas) v).setMargin(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                float fMin = Math.min(i2, i4);
                Resources resources = v.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                int floatRes = (int) (ResourceUtil.getFloatRes(resources, C7944R.dimen.brush_menu_height_fraction) * fMin);
                if (c == 1) {
                    ((IBrushCanvas) v).setMargin(0.0f, floatRes, 0.0f, 0.0f);
                } else if (v.getResources().getConfiguration().getLayoutDirection() == 0) {
                    ((IBrushCanvas) v).setMargin(floatRes, 0.0f, 0.0f, 0.0f);
                } else {
                    ((IBrushCanvas) v).setMargin(0.0f, 0.0f, floatRes, 0.0f);
                }
            }
        }
        updateZoomRatios(i2, i4);
        Logger.m7100d(TAG, "onLayoutChange. " + i2 + " x " + i4);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.zoom.AbsZoomViewModel
    public void onZoomInClicked() {
        Rect canvasSize = getCanvasSize();
        BrushFacade brushFacade = this.mFacade;
        if ((brushFacade != null ? brushFacade.getView() : null) == null || canvasSize == null) {
            return;
        }
        float fWidth = canvasSize.width() / 2.0f;
        float fHeight = canvasSize.height() / 2.0f;
        BrushFacade brushFacade2 = this.mFacade;
        IView<?> view = brushFacade2 != null ? brushFacade2.getView() : null;
        Intrinsics.checkNotNull(view);
        float zoomScale = view.getZoomScale() / 0.9f;
        BrushFacade brushFacade3 = this.mFacade;
        IView<?> view2 = brushFacade3 != null ? brushFacade3.getView() : null;
        Intrinsics.checkNotNull(view2);
        view2.setZoomScale(zoomScale, fWidth, fHeight);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.zoom.AbsZoomViewModel
    public void onZoomOutClicked() {
        Rect canvasSize = getCanvasSize();
        BrushFacade brushFacade = this.mFacade;
        if ((brushFacade != null ? brushFacade.getView() : null) == null || canvasSize == null) {
            return;
        }
        float fWidth = canvasSize.width() / 2.0f;
        float fHeight = canvasSize.height() / 2.0f;
        BrushFacade brushFacade2 = this.mFacade;
        IView<?> view = brushFacade2 != null ? brushFacade2.getView() : null;
        Intrinsics.checkNotNull(view);
        float zoomScale = view.getZoomScale() * 0.9f;
        BrushFacade brushFacade3 = this.mFacade;
        IView<?> view2 = brushFacade3 != null ? brushFacade3.getView() : null;
        Intrinsics.checkNotNull(view2);
        view2.setZoomScale(zoomScale, fWidth, fHeight);
    }

    @Override // com.samsung.android.support.senl.addons.base.viewmodel.zoom.AbsZoomViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.AbsBaseViewModel, com.samsung.android.support.senl.addons.base.viewmodel.common.IBaseViewModel
    public void perform(@Nullable IBaseViewModel.Action action) {
        if (Intrinsics.areEqual(BINDING_ID_ON_LAYOUT_CHANGE, action != null ? action.getMBindId() : null)) {
            Object data = action.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.base.model.event.LayoutChangeEvent");
            LayoutChangeEvent layoutChangeEvent = (LayoutChangeEvent) data;
            onLayoutChange(layoutChangeEvent.mView, layoutChangeEvent.mLeft, layoutChangeEvent.mTop, layoutChangeEvent.mRight, layoutChangeEvent.mBottom, layoutChangeEvent.mOldLeft, layoutChangeEvent.mOldTop, layoutChangeEvent.mOldRight, layoutChangeEvent.mOldBottom);
        }
        super.perform(action);
    }

    public final void setFacade(@Nullable AbsFacade facade) {
        setFacade((IFacade) facade);
        BrushFacade brushFacade = (BrushFacade) facade;
        this.mFacade = brushFacade;
        IBaseModel.Observer observer = this.mCallBack;
        if (observer == null || brushFacade == null) {
            return;
        }
        brushFacade.addObserver(observer);
    }

    private final void updateZoomRatios(int width, int height) {
        if (width <= 0 || height <= 0) {
            return;
        }
        this.mLayoutWidth = width;
        this.mLayoutHeight = height;
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            brushFacade.setZoomRatios(width, height);
        }
    }
}
