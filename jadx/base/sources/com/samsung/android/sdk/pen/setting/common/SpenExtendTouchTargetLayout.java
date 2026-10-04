package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0014J&\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\nJ\u001a\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenExtendTouchTargetLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mExtendTouchTop", "", "mExtendTouchBottom", "mExtendTouchStart", "mExtendTouchEnd", "onLayout", "", "changed", "", "left", "top", "right", "bottom", "setExtendTouchArea", "extendTouchStart", "extendTouchEnd", "extendTouchTop", "extendTouchBottom", "setExtendTouchAreaStart", "setExtendTouchAreaEnd", "getAttributes", "addTouchDelegate", "parentView", "Landroid/view/View;", "removeTouchDelegate", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenExtendTouchTargetLayout extends FrameLayout {

    @NotNull
    private static final String TAG = "SpenExtendTouchTargetLayout";
    private int mExtendTouchBottom;
    private int mExtendTouchEnd;
    private int mExtendTouchStart;
    private int mExtendTouchTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenExtendTouchTargetLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void addTouchDelegate(View parentView) {
        Rect rect = new Rect();
        getHitRect(rect);
        boolean z = getContext().getResources().getConfiguration().getLayoutDirection() == 1;
        rect.left -= !z ? this.mExtendTouchStart : this.mExtendTouchEnd;
        rect.right += !z ? this.mExtendTouchEnd : this.mExtendTouchStart;
        rect.top -= this.mExtendTouchTop;
        rect.bottom += this.mExtendTouchBottom;
        SpenTouchDelegateComposite spenTouchDelegateComposite = (SpenTouchDelegateComposite) parentView.getTouchDelegate();
        if (spenTouchDelegateComposite == null) {
            spenTouchDelegateComposite = new SpenTouchDelegateComposite(this);
            parentView.setTouchDelegate(spenTouchDelegateComposite);
        }
        spenTouchDelegateComposite.addDelegate(this, new TouchDelegate(rect, this));
    }

    private final void getAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenExtendTouchTargetLayout, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.mExtendTouchStart = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenExtendTouchTargetLayout_layout_extendTouchStart, 0);
            this.mExtendTouchEnd = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenExtendTouchTargetLayout_layout_extendTouchEnd, 0);
            this.mExtendTouchTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenExtendTouchTargetLayout_layout_extendTouchTop, 0);
            this.mExtendTouchBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(C7932R.styleable.SpenExtendTouchTargetLayout_layout_extendTouchBottom, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final void removeTouchDelegate(View parentView) {
        SpenTouchDelegateComposite spenTouchDelegateComposite = (SpenTouchDelegateComposite) parentView.getTouchDelegate();
        if (spenTouchDelegateComposite != null) {
            spenTouchDelegateComposite.removeDelegate(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Object parent = getParent();
        if (changed && parent != null && View.class.isInstance(parent)) {
            if (this.mExtendTouchStart == 0 && this.mExtendTouchTop == 0 && this.mExtendTouchEnd == 0 && this.mExtendTouchBottom == 0) {
                return;
            }
            if (changed && left == right && top == bottom) {
                removeTouchDelegate((View) parent);
            } else {
                addTouchDelegate((View) parent);
            }
        }
    }

    public final void setExtendTouchArea(int extendTouchStart, int extendTouchEnd, int extendTouchTop, int extendTouchBottom) {
        this.mExtendTouchStart = extendTouchStart;
        this.mExtendTouchEnd = extendTouchEnd;
        this.mExtendTouchTop = extendTouchTop;
        this.mExtendTouchBottom = extendTouchBottom;
    }

    public final void setExtendTouchAreaEnd(int extendTouchEnd) {
        this.mExtendTouchEnd = extendTouchEnd;
    }

    public final void setExtendTouchAreaStart(int extendTouchStart) {
        this.mExtendTouchStart = extendTouchStart;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenExtendTouchTargetLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        getAttributes(context, attributeSet);
    }
}
