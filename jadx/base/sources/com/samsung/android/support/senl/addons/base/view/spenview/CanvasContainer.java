package com.samsung.android.support.senl.addons.base.view.spenview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.addons.base.binding.methods.BMCanvasContainer;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer;
import com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasControl;
import com.samsung.android.support.senl.addons.base.model.canvas.view.IView;
import com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingView;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001-B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB-\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000fJ\u000e\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011H\u0016J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\"H\u0014J\u0016\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010%\u001a\u00020&H\u0002R \u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/spenview/CanvasContainer;", "Landroid/widget/RelativeLayout;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer;", "Lcom/samsung/android/support/senl/addons/base/binding/methods/BMCanvasContainer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "getMView", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;", "setMView", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/view/IView;)V", "mSettingView", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "getMSettingView", "()Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;", "setMSettingView", "(Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingView;)V", "mCallback", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasContainer$OnInflateCallback;", "mIsInflated", "", "getView", "onDetachedFromWindow", "", "onFinishInflate", "findView", "vg", "Landroid/view/ViewGroup;", "getSettingView", "getCanvasControl", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/ICanvasControl;", "setOnInflateCallback", Profile.PhoneNumberData.TYPE_CALLBACK, "findSettingView", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class CanvasContainer extends RelativeLayout implements ICanvasContainer, BMCanvasContainer {

    @NotNull
    private static final String TAG = Logger.createTag("CanvasContainer");

    @Nullable
    private ICanvasContainer.OnInflateCallback mCallback;
    private boolean mIsInflated;

    @Nullable
    private ISettingView<?> mSettingView;

    @Nullable
    private IView<?> mView;

    public CanvasContainer(@Nullable Context context) {
        super(context);
    }

    private final ISettingView<?> findSettingView(ViewGroup vg) {
        ISettingView<?> iSettingViewFindSettingView;
        int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            KeyEvent.Callback childAt = vg.getChildAt(i);
            if (childAt instanceof ISettingView) {
                return (ISettingView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (iSettingViewFindSettingView = findSettingView((ViewGroup) childAt)) != null) {
                return iSettingViewFindSettingView;
            }
        }
        return null;
    }

    private final IView<?> findView(ViewGroup vg) {
        IView<?> iViewFindView;
        int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            KeyEvent.Callback childAt = vg.getChildAt(i);
            if (childAt instanceof IView) {
                return (IView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (iViewFindView = findView((ViewGroup) childAt)) != null) {
                return iViewFindView;
            }
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer
    @NotNull
    public ICanvasControl getCanvasControl() {
        return new CanvasController();
    }

    @Nullable
    public final ISettingView<?> getMSettingView() {
        return this.mSettingView;
    }

    @Nullable
    public final IView<?> getMView() {
        return this.mView;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer
    @Nullable
    public ISettingView<?> getSettingView() {
        if (this.mSettingView == null) {
            this.mSettingView = findSettingView(this);
        }
        return this.mSettingView;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.ICanvasContainer
    @Nullable
    public IView<?> getView() {
        if (this.mView == null) {
            this.mView = findView(this);
        }
        return this.mView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mView = null;
        this.mSettingView = null;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Logger.m7100d(TAG, "onFinishInflate");
        if (this.mView == null) {
            this.mView = findView(this);
        }
        if (this.mSettingView == null) {
            this.mSettingView = findSettingView(this);
        }
        ICanvasContainer.OnInflateCallback onInflateCallback = this.mCallback;
        if (onInflateCallback != null) {
            Intrinsics.checkNotNull(onInflateCallback);
            onInflateCallback.onInflated(this);
            this.mCallback = null;
        }
        this.mIsInflated = true;
    }

    public final void setMSettingView(@Nullable ISettingView<?> iSettingView) {
        this.mSettingView = iSettingView;
    }

    public final void setMView(@Nullable IView<?> iView) {
        this.mView = iView;
    }

    @Override // com.samsung.android.support.senl.addons.base.binding.methods.BMCanvasContainer
    public void setOnInflateCallback(@Nullable ICanvasContainer.OnInflateCallback callback) {
        if (!this.mIsInflated) {
            this.mCallback = callback;
        } else if (callback != null) {
            callback.onInflated(this);
        }
    }

    public CanvasContainer(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CanvasContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CanvasContainer(@Nullable Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
