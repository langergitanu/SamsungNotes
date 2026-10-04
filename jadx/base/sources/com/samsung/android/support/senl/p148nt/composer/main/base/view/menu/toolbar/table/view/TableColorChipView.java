package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.content.ContextCompat;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010J\"\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010J\u001a\u0010\u001d\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0016J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001fR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/table/view/TableColorChipView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mColorView", "Landroid/widget/ImageView;", "mSelectView", "Landroid/view/View;", "mDrawable", "Landroid/graphics/drawable/GradientDrawable;", "mStringColorPrefix", "", "mStringComma", "construct", "", "setColor", "colorId", "", "hoverString", "setResource", "drawable", "Landroid/graphics/drawable/Drawable;", "alpha", "", "setHoverString", "isColorView", "", "updateSelectViewResource", "color", "setSelected", "selected", "animation", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TableColorChipView extends FrameLayout {
    private ImageView mColorView;

    @NotNull
    private GradientDrawable mDrawable;
    private View mSelectView;

    @Nullable
    private String mStringColorPrefix;

    @Nullable
    private String mStringComma;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableColorChipView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDrawable = new GradientDrawable();
        construct(context, null);
    }

    private final void construct(Context context, AttributeSet attrs) {
        View.inflate(getContext(), C9086R.layout.setting_color_view, this);
        setClickable(true);
        ImageView imageView = (ImageView) findViewById(C9086R.id.brush_color);
        this.mColorView = imageView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            imageView = null;
        }
        imageView.setImportantForAccessibility(2);
        ImageView imageView2 = this.mColorView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            imageView2 = null;
        }
        imageView2.setClipToOutline(true);
        View viewFindViewById = findViewById(C9086R.id.color_select_icon);
        this.mSelectView = viewFindViewById;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
            viewFindViewById = null;
        }
        viewFindViewById.setBackgroundResource(C9086R.drawable.selected_white);
        View view2 = this.mSelectView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
            view2 = null;
        }
        view2.setBackgroundTintList(ColorStateList.valueOf(context.getColor(C9086R.color.black)));
        View view3 = this.mSelectView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
        } else {
            view = view3;
        }
        view.setImportantForAccessibility(2);
        this.mDrawable.setShape(1);
        this.mDrawable.setStroke(getResources().getDimensionPixelSize(C9086R.dimen.table_color_palette_chip_stroke), ContextCompat.getColor(context, C9086R.color.table_color_palette_chip_stroke_color));
        this.mStringColorPrefix = context.getResources().getString(C9086R.string.pen_string_color);
        this.mStringComma = context.getResources().getString(C9086R.string.pen_string_comma);
    }

    private final void setHoverString(String hoverString, boolean isColorView) {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(hoverString);
        if (isColorView) {
            sbM1324q.append(this.mStringComma + " ");
            sbM1324q.append(this.mStringColorPrefix);
        }
        setContentDescription(sbM1324q.toString());
    }

    public final void setColor(int colorId, @Nullable String hoverString) {
        this.mDrawable.setColor(colorId);
        ImageView imageView = this.mColorView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            imageView = null;
        }
        imageView.setBackground(this.mDrawable);
        setHoverString(hoverString, true);
    }

    public final void setResource(@Nullable Drawable drawable, @Nullable String hoverString) {
        setResource(drawable, 1.0f, hoverString);
    }

    public final boolean setSelected(boolean selected, boolean animation) {
        setSelected(selected);
        View view = null;
        if (selected) {
            View view2 = this.mSelectView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
                view2 = null;
            }
            view2.setVisibility(0);
        } else {
            View view3 = this.mSelectView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
                view3 = null;
            }
            view3.setVisibility(8);
        }
        if (!selected || !animation) {
            return true;
        }
        View view4 = this.mSelectView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
        } else {
            view = view4;
        }
        SpenSettingUtilAnimation.colorSelectAnimation(view);
        return true;
    }

    public final void updateSelectViewResource(int color) {
        View view = this.mSelectView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
            view = null;
        }
        view.setBackgroundResource(C9086R.drawable.color_picker_icon_selector);
        View view3 = this.mSelectView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectView");
        } else {
            view2 = view3;
        }
        view2.setBackgroundTintList(ColorStateList.valueOf(color));
    }

    public final void setResource(@Nullable Drawable drawable, float alpha, @Nullable String hoverString) {
        ImageView imageView = this.mColorView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            imageView = null;
        }
        imageView.setBackground(drawable);
        ImageView imageView3 = this.mColorView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setAlpha(alpha);
        setHoverString(hoverString, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableColorChipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDrawable = new GradientDrawable();
        construct(context, attributeSet);
    }
}
