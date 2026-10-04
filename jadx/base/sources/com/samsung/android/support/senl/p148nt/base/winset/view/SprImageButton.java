package com.samsung.android.support.senl.p148nt.base.winset.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.spr.drawable.Spr;
import com.samsung.android.spr.drawable.SprDrawable;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0005J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\nH\u0016R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/SprImageButton;", "Landroid/widget/ImageButton;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mTintColor", "backgroundNormal", "Landroid/graphics/drawable/Drawable;", "rippleDrawable", "Landroid/graphics/drawable/RippleDrawable;", "init", "", "setTint", "color", "getSprDrawable", "resId", BaseWidgetConstant.SET_IMAGE_RESOURCE, "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SprImageButton extends ImageButton {
    private static final int COLOR_TINT_NONE = 1;

    @Nullable
    private Drawable backgroundNormal;
    private int mTintColor;

    @Nullable
    private RippleDrawable rippleDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SprImageButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTintColor = 1;
        init(context, null);
    }

    private final Drawable getSprDrawable(int resId) {
        if (getDrawable() instanceof SprDrawable) {
            Drawable drawable = Spr.getDrawable(getResources(), resId, null);
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.samsung.android.spr.drawable.SprDrawable");
            return (SprDrawable) drawable;
        }
        Drawable drawable2 = getDrawable();
        Intrinsics.checkNotNull(drawable2);
        return drawable2;
    }

    @SuppressLint({WarningType.NewApi, "CustomViewStyleable"})
    public final void init(@NotNull Context context, @Nullable AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, C8875R.styleable.SprAttribute);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            int color = typedArrayObtainStyledAttributes.getColor(C8875R.styleable.SprAttribute_tint, 1);
            if (color != 1) {
                this.mTintColor = color;
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(C8875R.styleable.SprAttribute_src, -1);
            if (resourceId > 0) {
                setImageResource(resourceId);
            }
            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C8875R.styleable.SprAttribute_bg, -1);
            if (resourceId2 > 0) {
                Drawable sprDrawable = getSprDrawable(resourceId2);
                this.backgroundNormal = sprDrawable;
                setBackground(sprDrawable);
            } else {
                setBackground(null);
            }
            if (!typedArrayObtainStyledAttributes.getBoolean(C8875R.styleable.SprAttribute_ripple_none, false)) {
                RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{687865856}), this.backgroundNormal, new ColorDrawable(-1));
                this.rippleDrawable = rippleDrawable;
                setBackground(rippleDrawable);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int resId) {
        Drawable drawable = Spr.getDrawable(getResources(), resId, null);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.samsung.android.spr.drawable.SprDrawable");
        SprDrawable sprDrawable = (SprDrawable) drawable;
        int i = this.mTintColor;
        if (i != 1) {
            sprDrawable.setTintList(ColorStateList.valueOf(i));
        }
        setImageDrawable(sprDrawable);
    }

    public final void setTint(int color) {
        this.mTintColor = color;
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof SprDrawable)) {
            return;
        }
        ((SprDrawable) drawable).setTintList(ColorStateList.valueOf(this.mTintColor));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SprImageButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTintColor = 1;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SprImageButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTintColor = 1;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SprImageButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTintColor = 1;
        init(context, attributeSet);
    }
}
