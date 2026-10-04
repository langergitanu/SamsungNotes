package com.samsung.android.sdk.pen.setting.common;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0002HIB\u001d\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB1\b\u0016\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\u000fJ&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJ\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0001H\u0016J \u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0011H\u0016J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J(\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000bH\u0016J\u0018\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0014H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\u0012\u00105\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020\u0014H\u0016J\u0010\u0010:\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020;H\u0014J\u0010\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u000bH\u0014J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0011H\u0014J\b\u0010@\u001a\u00020\u000bH\u0016J\b\u0010A\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020DH\u0016J\n\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010G\u001a\u00020\u0001H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "state", "Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable$InsetState;", "res", "Landroid/content/res/Resources;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable$InsetState;Landroid/content/res/Resources;)V", "drawable", "insetLeft", "", "insetTop", "insetRight", "insetBottom", "(Landroid/graphics/drawable/Drawable;IIII)V", "mTmpRect", "Landroid/graphics/Rect;", "mInsetState", "mMutated", "", "setInsets", "", "canApplyTheme", "invalidateDrawable", "who", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "draw", "canvas", "Landroid/graphics/Canvas;", "getChangingConfigurations", "getPadding", "padding", "setHotspot", "x", "", "y", "setHotspotBounds", "left", "top", "right", "bottom", "setVisible", "visible", "restart", "setAlpha", "alpha", "getAlpha", BaseWidgetConstant.SET_COLOR_FILTER, "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "isStateful", "onStateChange", "", "onLevelChange", "level", "onBoundsChange", "bounds", "getIntrinsicWidth", "getIntrinsicHeight", "getOutline", "outline", "Landroid/graphics/Outline;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "mutate", "Companion", "InsetState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenInsetDrawable extends Drawable implements Drawable.Callback {

    @NotNull
    private static final String TAG = "SpenInsetDrawable";

    @NotNull
    private final InsetState mInsetState;
    private boolean mMutated;

    @NotNull
    private final Rect mTmpRect;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010*\u001a\u00020\u0016H\u0016J\u0012\u0010*\u001a\u00020\u00162\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u0006\u0010,\u001a\u00020(R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable$InsetState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "orig", "owner", "Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;", "res", "Landroid/content/res/Resources;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable$InsetState;Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;Landroid/content/res/Resources;)V", "mThemeAttrs", "", "getMThemeAttrs", "()[I", "setMThemeAttrs", "([I)V", "mChangingConfigurations", "", "getMChangingConfigurations", "()I", "setMChangingConfigurations", "(I)V", "mDrawable", "Landroid/graphics/drawable/Drawable;", "getMDrawable", "()Landroid/graphics/drawable/Drawable;", "setMDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mInsetLeft", "getMInsetLeft", "setMInsetLeft", "mInsetTop", "getMInsetTop", "setMInsetTop", "mInsetRight", "getMInsetRight", "setMInsetRight", "mInsetBottom", "getMInsetBottom", "setMInsetBottom", "mCheckedConstantState", "", "mCanConstantState", "newDrawable", "getChangingConfigurations", "canConstantState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class InsetState extends Drawable.ConstantState {
        private boolean mCanConstantState;
        private int mChangingConfigurations;
        private boolean mCheckedConstantState;
        public Drawable mDrawable;
        private int mInsetBottom;
        private int mInsetLeft;
        private int mInsetRight;
        private int mInsetTop;

        @Nullable
        private int[] mThemeAttrs;

        public InsetState(@Nullable InsetState insetState, @Nullable SpenInsetDrawable spenInsetDrawable, @Nullable Resources resources) {
            Drawable drawableNewDrawable;
            if (insetState == null || insetState.getMDrawable().getConstantState() == null) {
                return;
            }
            this.mThemeAttrs = insetState.mThemeAttrs;
            this.mChangingConfigurations = insetState.mChangingConfigurations;
            if (resources != null) {
                Drawable.ConstantState constantState = insetState.getMDrawable().getConstantState();
                Intrinsics.checkNotNull(constantState);
                drawableNewDrawable = constantState.newDrawable(resources);
                Intrinsics.checkNotNull(drawableNewDrawable);
            } else {
                Drawable.ConstantState constantState2 = insetState.getMDrawable().getConstantState();
                Intrinsics.checkNotNull(constantState2);
                drawableNewDrawable = constantState2.newDrawable();
                Intrinsics.checkNotNull(drawableNewDrawable);
            }
            setMDrawable(drawableNewDrawable);
            getMDrawable().setCallback(spenInsetDrawable);
            getMDrawable().setBounds(insetState.getMDrawable().getBounds());
            getMDrawable().setLevel(insetState.getMDrawable().getLevel());
            this.mInsetLeft = insetState.mInsetLeft;
            this.mInsetTop = insetState.mInsetTop;
            this.mInsetRight = insetState.mInsetRight;
            this.mInsetBottom = insetState.mInsetBottom;
            this.mCanConstantState = true;
            this.mCheckedConstantState = true;
        }

        public final boolean canConstantState() {
            if (!this.mCheckedConstantState) {
                this.mCanConstantState = getMDrawable().getConstantState() != null;
                this.mCheckedConstantState = true;
            }
            return this.mCanConstantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public final int getMChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @NotNull
        public final Drawable getMDrawable() {
            Drawable drawable = this.mDrawable;
            if (drawable != null) {
                return drawable;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mDrawable");
            return null;
        }

        public final int getMInsetBottom() {
            return this.mInsetBottom;
        }

        public final int getMInsetLeft() {
            return this.mInsetLeft;
        }

        public final int getMInsetRight() {
            return this.mInsetRight;
        }

        public final int getMInsetTop() {
            return this.mInsetTop;
        }

        @Nullable
        public final int[] getMThemeAttrs() {
            return this.mThemeAttrs;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable() {
            return new SpenInsetDrawable(this, null, 0 == true ? 1 : 0);
        }

        public final void setMChangingConfigurations(int i) {
            this.mChangingConfigurations = i;
        }

        public final void setMDrawable(@NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "<set-?>");
            this.mDrawable = drawable;
        }

        public final void setMInsetBottom(int i) {
            this.mInsetBottom = i;
        }

        public final void setMInsetLeft(int i) {
            this.mInsetLeft = i;
        }

        public final void setMInsetRight(int i) {
            this.mInsetRight = i;
        }

        public final void setMInsetTop(int i) {
            this.mInsetTop = i;
        }

        public final void setMThemeAttrs(@Nullable int[] iArr) {
            this.mThemeAttrs = iArr;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        public Drawable newDrawable(@Nullable Resources res) {
            return new SpenInsetDrawable(this, res, null);
        }
    }

    public /* synthetic */ SpenInsetDrawable(InsetState insetState, Resources resources, DefaultConstructorMarker defaultConstructorMarker) {
        this(insetState, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.mInsetState.getMThemeAttrs() != null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        this.mInsetState.getMDrawable().draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mInsetState.getMDrawable().getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mInsetState.getMChangingConfigurations() | this.mInsetState.getMDrawable().getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        if (!this.mInsetState.canConstantState()) {
            return null;
        }
        this.mInsetState.setMChangingConfigurations(getChangingConfigurations());
        return this.mInsetState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mInsetState.getMDrawable().getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mInsetState.getMDrawable().getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.mInsetState.getMDrawable().getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@NotNull Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        this.mInsetState.getMDrawable().getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        boolean padding2 = this.mInsetState.getMDrawable().getPadding(padding);
        padding.left = this.mInsetState.getMInsetLeft() + padding.left;
        padding.right = this.mInsetState.getMInsetRight() + padding.right;
        padding.top = this.mInsetState.getMInsetTop() + padding.top;
        padding.bottom = this.mInsetState.getMInsetBottom() + padding.bottom;
        return padding2 || (((this.mInsetState.getMInsetLeft() | this.mInsetState.getMInsetRight()) | this.mInsetState.getMInsetTop()) | this.mInsetState.getMInsetBottom()) != 0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mInsetState.getMDrawable().isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    @NotNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mInsetState.getMDrawable().mutate();
            this.mMutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Rect rect = this.mTmpRect;
        rect.set(bounds);
        rect.left = this.mInsetState.getMInsetLeft() + rect.left;
        rect.top = this.mInsetState.getMInsetTop() + rect.top;
        rect.right -= this.mInsetState.getMInsetRight();
        rect.bottom -= this.mInsetState.getMInsetBottom();
        this.mInsetState.getMDrawable().setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int level) {
        return this.mInsetState.getMDrawable().setLevel(level);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@NotNull int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        boolean state2 = this.mInsetState.getMDrawable().setState(state);
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        onBoundsChange(bounds);
        return state2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mInsetState.getMDrawable().setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter cf) {
        this.mInsetState.getMDrawable().setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float x, float y2) {
        this.mInsetState.getMDrawable().setHotspot(x, y2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.mInsetState.getMDrawable().setHotspotBounds(left, top, right, bottom);
    }

    public final void setInsets(int insetLeft, int insetTop, int insetRight, int insetBottom) {
        this.mInsetState.setMInsetLeft(insetLeft);
        this.mInsetState.setMInsetTop(insetTop);
        this.mInsetState.setMInsetRight(insetRight);
        this.mInsetState.setMInsetBottom(insetBottom);
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        onBoundsChange(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        this.mInsetState.getMDrawable().setVisible(visible, restart);
        return super.setVisible(visible, restart);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    private SpenInsetDrawable(InsetState insetState, Resources resources) {
        this.mTmpRect = new Rect();
        this.mInsetState = new InsetState(insetState, this, resources);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenInsetDrawable(@NotNull Drawable drawable, int i, int i2, int i4, int i5) {
        this(null, null);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mInsetState.setMDrawable(drawable);
        this.mInsetState.setMInsetLeft(i);
        this.mInsetState.setMInsetTop(i2);
        this.mInsetState.setMInsetRight(i4);
        this.mInsetState.setMInsetBottom(i5);
        drawable.setCallback(this);
    }
}
