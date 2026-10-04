package com.samsung.android.support.senl.addons.brush.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushFacade;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\u001aH\u0014J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/PenupButton;", "Landroid/widget/ImageButton;", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penup/IPenupView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mFacadeCallback", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "mFacade", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushFacade;", "mCurrentState", "", "Ljava/lang/Boolean;", "mPreState", "mActionListener", "Lcom/samsung/android/support/senl/addons/brush/viewmodel/penup/IPenupView$IPenupViewListener;", "close", "", "onDetachedFromWindow", "performClick", "setPenUpListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onWindowFocusChanged", "hasWindowFocus", "onAttachedToWindow", "updateVisibility", "getPenUpButtonEnabled", "updatePenupBtnEnable", "setFacadeCallback", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class PenupButton extends ImageButton implements IPenupView {

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenupButton");

    @Nullable
    private IPenupView.IPenupViewListener mActionListener;

    @Nullable
    private Boolean mCurrentState;

    @Nullable
    private BrushFacade mFacade;

    @Nullable
    private IBaseModel.Observer mFacadeCallback;

    @Nullable
    private Boolean mPreState;

    public PenupButton(@Nullable Context context) {
        super(context);
        setEnabled(false);
        setAlpha(0.5f);
    }

    private final void close() {
        Logger.m7100d(TAG, "mFacadeCallback: close");
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null && brushFacade != null) {
            IBaseModel.Observer observer = this.mFacadeCallback;
            Intrinsics.checkNotNull(observer);
            brushFacade.removeObserver(observer);
        }
        this.mFacadeCallback = null;
        IPenupView.IPenupViewListener iPenupViewListener = this.mActionListener;
        Intrinsics.checkNotNull(iPenupViewListener);
        iPenupViewListener.onClosed();
    }

    private final boolean getPenUpButtonEnabled() {
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade == null) {
            return false;
        }
        if ((brushFacade != null ? brushFacade.getObjectCount() : null) == null) {
            return false;
        }
        BrushFacade brushFacade2 = this.mFacade;
        Integer objectCount = brushFacade2 != null ? brushFacade2.getObjectCount() : null;
        Intrinsics.checkNotNull(objectCount);
        return objectCount.intValue() > 0;
    }

    private final void setFacadeCallback() {
        IPenupView.IPenupViewListener iPenupViewListener = this.mActionListener;
        this.mFacade = iPenupViewListener != null ? iPenupViewListener.getFacade() : null;
        IBaseModel.Observer observer = new IBaseModel.Observer() { // from class: com.samsung.android.support.senl.addons.brush.view.PenupButton.setFacadeCallback.1
            @Override // com.samsung.android.support.senl.addons.base.common.IObservable.Observer
            public void onUpdate(IBaseModel.Info info) {
                Integer id = info != null ? info.getId() : null;
                Intrinsics.checkNotNull(id);
                int iIntValue = id.intValue();
                if (iIntValue == 11006 || iIntValue == 11007 || iIntValue == 11008 || iIntValue == 11101 || iIntValue == IBrushCanvasModel.INSTANCE.getOBSV_PROPERTY_SHOW_CANVAS()) {
                    Logger.m7100d(PenupButton.TAG, "mFacadeCallback: updatePenupBtnEnable");
                    PenupButton.this.updatePenupBtnEnable();
                }
            }
        };
        this.mFacadeCallback = observer;
        BrushFacade brushFacade = this.mFacade;
        if (brushFacade != null) {
            Intrinsics.checkNotNull(observer);
            brushFacade.addObserver(observer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePenupBtnEnable() {
        this.mPreState = this.mCurrentState;
        Boolean boolValueOf = Boolean.valueOf(getPenUpButtonEnabled());
        this.mCurrentState = boolValueOf;
        if (Intrinsics.areEqual(boolValueOf, this.mPreState)) {
            return;
        }
        if (Intrinsics.areEqual(this.mCurrentState, Boolean.TRUE)) {
            setEnabled(true);
            setAlpha(1.0f);
        } else {
            setEnabled(false);
            setAlpha(0.5f);
        }
    }

    private final void updateVisibility() {
        Object parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View view = (View) parent;
        boolean z = PlatformUtil.isPackageInstalledAndEnabled("com.sec.penup") && !PlatformUtil.isShopDemoDevice();
        if (z && view.getVisibility() != 0) {
            view.setVisibility(0);
        } else {
            if (z || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.m7100d(TAG, "onDetachedFromWindow#");
        close();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus) {
            updateVisibility();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        Logger.m7100d(TAG, "onClick : PenUp Button");
        SystemLogManager.INSTANCE.onPenUpStart();
        IPenupView.IPenupViewListener iPenupViewListener = this.mActionListener;
        if (iPenupViewListener != null && iPenupViewListener.runSharePenup(getContext())) {
            setEnabled(false);
            this.mCurrentState = Boolean.FALSE;
        }
        return super.performClick();
    }

    @Override // com.samsung.android.support.senl.addons.brush.viewmodel.penup.IPenupView
    public void setPenUpListener(@Nullable IPenupView.IPenupViewListener listener) {
        Logger.m7100d(TAG, "mFacadeCallback: setPenUpListener");
        if (listener != null) {
            this.mActionListener = listener;
        }
        setFacadeCallback();
    }

    public PenupButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setEnabled(false);
        setAlpha(0.5f);
    }

    public PenupButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setEnabled(false);
        setAlpha(0.5f);
    }

    public PenupButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setEnabled(false);
        setAlpha(0.5f);
    }
}
