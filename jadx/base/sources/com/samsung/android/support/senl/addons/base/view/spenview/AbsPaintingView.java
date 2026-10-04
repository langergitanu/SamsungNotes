package com.samsung.android.support.senl.addons.base.view.spenview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IPaintingView;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/spenview/AbsPaintingView;", "Lcom/samsung/android/sdk/pen/painting/SpenPaintingSurfaceView;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IPaintingView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIsLockForSaving", "", "initialize", "", "close", "lockForSave", "unlockForSave", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setActionType", "actionType", "isHScrollable", "()Z", "isVScrollable", "closeControl", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPaintingView extends SpenPaintingSurfaceView implements IPaintingView {
    private boolean mIsLockForSaving;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPaintingView(@Nullable Context context) {
        super(context);
        Intrinsics.checkNotNull(context);
        initialize();
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView, com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void close() {
        setPenSettingInfo(null);
        setZoomListener(null);
        setPreTouchListener(null);
        setColorPickerListener(null);
        setPaintingDoc(null, false);
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void closeControl() {
    }

    public void initialize() {
        getHolder().setFormat(-1);
        setToolTipEnabled(!DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext()));
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public boolean isHScrollable() {
        return getZoomScale() * ((float) getCanvasWidth()) > ((float) getWidth());
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public boolean isVScrollable() {
        return getZoomScale() * ((float) getCanvasHeight()) > ((float) getHeight());
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void lockForSave() {
        this.mIsLockForSaving = true;
    }

    @Override // com.samsung.android.sdk.pen.painting.SpenPaintingSurfaceView, android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (this.mIsLockForSaving && (actionMasked == 0 || actionMasked == 211)) {
            return false;
        }
        return super.onTouchEvent(event);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void setActionType(int actionType) {
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.IView
    public void unlockForSave() {
        this.mIsLockForSaving = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPaintingView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNull(context);
        initialize();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPaintingView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        initialize();
    }
}
