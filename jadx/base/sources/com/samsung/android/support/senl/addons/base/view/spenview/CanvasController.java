package com.samsung.android.support.senl.addons.base.view.spenview;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.engine.SpenTouchListener;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl;", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "mCanvasView", "Landroid/view/View;", "mListener", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl$ICanvasActionListener;", "mListenerEnableMask", "", "getMListenerEnableMask", "()I", "setMListenerEnableMask", "(I)V", "setCanvas", "", "view", "enableListener", ImageConst.PARAM_MODE_WALLPAPER_MASK, "setCanvasActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCanvasListeners", "close", "mSizeChangeListener", "Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController$CanvasSizeChangeListener;", "Companion", "TouchListener", "PreTouchListener", "CanvasSizeChangeListener", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CanvasController implements ICanvasControl {

    @NotNull
    private static final String TAG = Logger.createTag("CanvasController");

    @Nullable
    private View mCanvasView;

    @Nullable
    private ICanvasControl.ICanvasActionListener mListener;
    private int mListenerEnableMask;

    @NotNull
    private final CanvasSizeChangeListener mSizeChangeListener = new CanvasSizeChangeListener();

    @Nullable
    private IView<?> mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController$CanvasSizeChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController;)V", "onLayoutChange", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class CanvasSizeChangeListener implements View.OnLayoutChangeListener {
        public CanvasSizeChangeListener() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            ICanvasControl.ICanvasActionListener iCanvasActionListener;
            Intrinsics.checkNotNullParameter(v, "v");
            if (right == 0 || bottom == 0) {
                return;
            }
            if ((left == oldLeft && top == oldTop && right == oldRight && bottom == oldBottom) || (iCanvasActionListener = CanvasController.this.mListener) == null) {
                return;
            }
            iCanvasActionListener.onCanvasSizeChanged(left, top, right, bottom);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController$PreTouchListener;", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController;)V", "onTouch", "", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class PreTouchListener implements SpenTouchListener {
        public PreTouchListener() {
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
        public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
            ICanvasControl.ICanvasActionListener iCanvasActionListener = CanvasController.this.mListener;
            if (iCanvasActionListener != null) {
                return iCanvasActionListener.onPreTouch(motionEvent);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController$TouchListener;", "Lcom/samsung/android/sdk/pen/engine/SpenTouchListener;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasController;)V", "onTouch", "", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class TouchListener implements SpenTouchListener {
        public TouchListener() {
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenTouchListener
        public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
            ICanvasControl.ICanvasActionListener iCanvasActionListener = CanvasController.this.mListener;
            if (iCanvasActionListener == null) {
                return false;
            }
            iCanvasActionListener.onTouch(motionEvent);
            return false;
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl
    public void close() {
        this.mListenerEnableMask = 0;
        setCanvasListeners();
        this.mView = null;
        this.mCanvasView = null;
        this.mListener = null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl
    public void enableListener(int mask) {
        if (this.mListenerEnableMask != mask) {
            this.mListenerEnableMask = mask;
            setCanvasListeners();
        }
    }

    public final int getMListenerEnableMask() {
        return this.mListenerEnableMask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl
    public void setCanvas(@Nullable IView<?> view) {
        View view2;
        this.mView = view;
        if (view instanceof View) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.View");
            view2 = (View) view;
        } else {
            view2 = null;
        }
        this.mCanvasView = view2;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl
    public void setCanvasActionListener(@Nullable ICanvasControl.ICanvasActionListener listener) {
        this.mListener = listener;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl
    public void setCanvasListeners() {
        IView<?> iView = this.mView;
        if (iView == null) {
            Logger.m7105w(TAG, "set listeners : not canvas!");
            return;
        }
        if ((this.mListenerEnableMask & 1) != 0) {
            Intrinsics.checkNotNull(iView);
            iView.setZoomListener(this.mListener);
        } else {
            Intrinsics.checkNotNull(iView);
            iView.setZoomListener(null);
        }
        if ((this.mListenerEnableMask & 2) != 0) {
            IView<?> iView2 = this.mView;
            Intrinsics.checkNotNull(iView2);
            iView2.setTouchListener(new TouchListener());
        } else {
            IView<?> iView3 = this.mView;
            Intrinsics.checkNotNull(iView3);
            iView3.setTouchListener(null);
        }
        if ((this.mListenerEnableMask & 4) != 0) {
            IView<?> iView4 = this.mView;
            Intrinsics.checkNotNull(iView4);
            iView4.setPreTouchListener(new PreTouchListener());
        } else {
            IView<?> iView5 = this.mView;
            Intrinsics.checkNotNull(iView5);
            iView5.setPreTouchListener(null);
        }
        if ((this.mListenerEnableMask & 16) != 0) {
            IView<?> iView6 = this.mView;
            Intrinsics.checkNotNull(iView6);
            iView6.setColorPickerListener(this.mListener);
        } else {
            IView<?> iView7 = this.mView;
            Intrinsics.checkNotNull(iView7);
            iView7.setColorPickerListener(null);
        }
        View view = this.mCanvasView;
        if (view == null) {
            Logger.m7105w(TAG, "Canvas is not View!");
        } else if ((this.mListenerEnableMask & 8) != 0) {
            Intrinsics.checkNotNull(view);
            view.addOnLayoutChangeListener(this.mSizeChangeListener);
        } else {
            Intrinsics.checkNotNull(view);
            view.removeOnLayoutChangeListener(this.mSizeChangeListener);
        }
    }

    public final void setMListenerEnableMask(int i) {
        this.mListenerEnableMask = i;
    }
}
