package com.samsung.android.support.senl.addons.brush.view.canvas;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewTreeObserver;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenPaintingDoc;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.canvas.document.IDocModel;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.base.view.spenview.AbsPaintingView;
import com.samsung.android.support.senl.addons.brush.binding.method.BMBrushCanvas;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushDocModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvas;
import com.samsung.android.support.senl.addons.brush.util.ResourceUtil;
import com.samsung.android.support.senl.addons.brush.viewmodel.canvas.PreviewImageViewModel;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p004A2.RunnableC0015b;
import p004A2.ViewTreeObserverOnPreDrawListenerC0014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00018B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\u0012\u0010&\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J(\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\rH\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$¨\u00069"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/canvas/BrushCanvas;", "Lcom/samsung/android/support/senl/addons/base/view/spenview/AbsPaintingView;", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvas;", "Lcom/samsung/android/support/senl/addons/brush/binding/method/BMBrushCanvas;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnDocumentLoadedListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView$OnDocumentLoadedListener;", "mPreviewImageViewModel", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/canvas/PreviewImageViewModel;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "initialize", "", "setOnLoadedDocumentListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initializeDocModel", "", "docModel", "Lcom/samsung/android/support/senl/addons/base/model/canvas/document/IDocModel;", "setPaintingDoc", "paintingDoc", "Lcom/samsung/android/sdk/pen/document/SpenPaintingDoc;", "isUpdate", "clearAll", "requestReadyForSave", "isHScrollable", "()Z", "isVScrollable", "setPreviewImageViewModel", "previewImageViewModel", "surfaceCreated", "holder", "Landroid/view/SurfaceHolder;", "surfaceChanged", "format", "width", "height", "surfaceDestroyed", "setTouchMargin", "marginLeft", "marginTop", "marginRight", "marginBottom", "close", "getConfiguration", "Landroid/content/res/Configuration;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class BrushCanvas extends AbsPaintingView implements IBrushCanvas, BMBrushCanvas, SurfaceHolder.Callback {

    @NotNull
    private static final String TAG = Logger.createBrushTag("BrushCanvas");

    @Nullable
    private IPaintingView.OnDocumentLoadedListener mOnDocumentLoadedListener;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;

    @Nullable
    private PreviewImageViewModel mPreviewImageViewModel;

    public BrushCanvas(@Nullable Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setPaintingDoc$lambda$2(BrushCanvas brushCanvas) {
        brushCanvas.postDelayed(new RunnableC0015b(brushCanvas, 0), 300L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setPaintingDoc$lambda$2$lambda$1(BrushCanvas brushCanvas) {
        IPaintingView.OnDocumentLoadedListener onDocumentLoadedListener = brushCanvas.mOnDocumentLoadedListener;
        if (onDocumentLoadedListener != null) {
            Logger.m7100d(TAG, "onPreDraw @ DrawListener - " + onDocumentLoadedListener);
            IPaintingView.OnDocumentLoadedListener onDocumentLoadedListener2 = brushCanvas.mOnDocumentLoadedListener;
            if (onDocumentLoadedListener2 != null) {
                onDocumentLoadedListener2.onLoaded(brushCanvas);
            }
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void clearAll() {
    }

    @Override // com.samsung.android.support.senl.addons.base.view.spenview.AbsPaintingView, com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView, com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void close() {
        getHolder().removeCallback(this);
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    @Nullable
    public Configuration getConfiguration() {
        return getResources().getConfiguration();
    }

    @Override // com.samsung.android.support.senl.addons.base.view.spenview.AbsPaintingView
    public void initialize() {
        super.initialize();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        setBlankColor(context.getResources().getColor(C7944R.color.brush_canvas_blank_color, null));
        getHolder().addCallback(this);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public boolean initializeDocModel(@NotNull IDocModel<?> docModel) {
        Intrinsics.checkNotNullParameter(docModel, "docModel");
        if (!(docModel instanceof BrushDocModel)) {
            throw new IllegalArgumentException("not matched document model! ".concat(docModel.getClass().getName()).toString());
        }
        BrushDocModel brushDocModel = (BrushDocModel) docModel;
        int width = brushDocModel.getWidth();
        int height = brushDocModel.getHeight();
        String documentFilePath = brushDocModel.getMFilePath();
        String str = TAG;
        String encode = Logger.getEncode(documentFilePath);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "createPaintingDoc : ", "x", " / ");
        sbM1173s.append(encode);
        Logger.m7100d(str, sbM1173s.toString());
        try {
            int color = ResourceUtils.getColor(getContext(), C7944R.color.brush_canvas_background_color);
            Context context = getContext();
            SpenPaintingDoc spenPaintingDoc = new SpenPaintingDoc(context != null ? context.getApplicationContext() : null, width, height, documentFilePath);
            spenPaintingDoc.setBackgroundColor(color);
            ((BrushDocModel) docModel).setDocument(spenPaintingDoc);
            return true;
        } catch (IOException e) {
            Logger.m7101e(TAG, "createPaintingDoc : " + e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.view.spenview.AbsPaintingView, com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public boolean isHScrollable() {
        if (!TabletUtil.isTabletUi()) {
            int height = getWidth() < getHeight() ? 0 : getHeight();
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            int floatRes = (int) (ResourceUtil.getFloatRes(resources, C7944R.dimen.brush_menu_height_fraction) * height);
            if (floatRes > 0) {
                return getZoomScale() * ((float) getCanvasWidth()) > ((float) (getWidth() - floatRes));
            }
        }
        return super.isHScrollable();
    }

    @Override // com.samsung.android.support.senl.addons.base.view.spenview.AbsPaintingView, com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public boolean isVScrollable() {
        if (!TabletUtil.isTabletUi()) {
            int width = getWidth() < getHeight() ? getWidth() : 0;
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            int floatRes = (int) (ResourceUtil.getFloatRes(resources, C7944R.dimen.brush_menu_height_fraction) * width);
            if (floatRes > 0) {
                return getZoomScale() * ((float) getCanvasHeight()) > ((float) (getHeight() - floatRes));
            }
        }
        return super.isVScrollable();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void requestReadyForSave() {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView
    public void setOnLoadedDocumentListener(@Nullable IPaintingView.OnDocumentLoadedListener listener) {
        this.mOnDocumentLoadedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView, com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView
    public synchronized boolean setPaintingDoc(@Nullable SpenPaintingDoc paintingDoc, boolean isUpdate) {
        if (paintingDoc != null) {
            try {
                if (this.mOnPreDrawListener == null) {
                    this.mOnPreDrawListener = new ViewTreeObserverOnPreDrawListenerC0014a(this, 0);
                    getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return super.setPaintingDoc(paintingDoc, isUpdate);
    }

    @Override // com.samsung.android.support.senl.addons.brush.binding.method.BMBrushCanvas
    public void setPreviewImageViewModel(@Nullable PreviewImageViewModel previewImageViewModel) {
        this.mPreviewImageViewModel = previewImageViewModel;
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView, com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvas
    public void setTouchMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        super.setTouchMargin(marginLeft, marginTop, marginRight, marginBottom);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PreviewImageViewModel previewImageViewModel = this.mPreviewImageViewModel;
        if (previewImageViewModel == null || previewImageViewModel == null) {
            return;
        }
        previewImageViewModel.showCanvas();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PreviewImageViewModel previewImageViewModel = this.mPreviewImageViewModel;
        if (previewImageViewModel != null) {
            if (previewImageViewModel != null) {
                previewImageViewModel.capturePreviewImage();
            }
            PreviewImageViewModel previewImageViewModel2 = this.mPreviewImageViewModel;
            if (previewImageViewModel2 != null) {
                previewImageViewModel2.showPreview();
            }
        }
    }

    public BrushCanvas(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BrushCanvas(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
