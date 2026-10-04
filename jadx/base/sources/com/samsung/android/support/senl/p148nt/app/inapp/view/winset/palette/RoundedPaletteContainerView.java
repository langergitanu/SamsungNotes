package com.samsung.android.support.senl.p148nt.app.inapp.view.winset.palette;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J&\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0014J \u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/winset/palette/RoundedPaletteContainerView;", "Lcom/samsung/android/support/senl/nt/base/winset/view/palette/PaletteContainerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRadius", "getMRadius", "()I", "setColor", "", "index", "color", "name", "", "isSelected", "", "setResource", "bgPatten", "updatePaletteItem", "paletteItem", "Landroid/view/View;", "withAnimation", "setRadius", "drawable", "Landroid/graphics/drawable/GradientDrawable;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRoundedPaletteContainerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoundedPaletteContainerView.kt\ncom/samsung/android/support/senl/nt/app/inapp/view/winset/palette/RoundedPaletteContainerView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,89:1\n1#2:90\n*E\n"})
public final class RoundedPaletteContainerView extends PaletteContainerView {
    private final int mRadius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedPaletteContainerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadius = getResources().getDimensionPixelSize(C8003R.dimen.in_app_text_mode_color_palette_radius);
    }

    private final void setRadius(int index, boolean isSelected, GradientDrawable drawable) {
        if (isSelected) {
            drawable.setCornerRadius(this.mRadius);
            return;
        }
        if (index == 0) {
            int i = this.mRadius;
            drawable.setCornerRadii(new float[]{i, i, 0.0f, 0.0f, 0.0f, 0.0f, i, i});
            return;
        }
        List<View> list = this.mPaletteItemList;
        Intrinsics.checkNotNull(list);
        if (index != list.size() - 1) {
            drawable.setCornerRadius(0.0f);
        } else {
            int i2 = this.mRadius;
            drawable.setCornerRadii(new float[]{0.0f, 0.0f, i2, i2, i2, i2, 0.0f, 0.0f});
        }
    }

    public final int getMRadius() {
        return this.mRadius;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView
    public void setColor(int index, int color, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        setColor(index, color, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView
    public void setResource(int index, int bgPatten, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        setResource(index, bgPatten, name, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.palette.PaletteContainerView
    public void updatePaletteItem(@NotNull View paletteItem, boolean isSelected, boolean withAnimation) {
        Intrinsics.checkNotNullParameter(paletteItem, "paletteItem");
        super.updatePaletteItem(paletteItem, isSelected, withAnimation);
        Drawable background = paletteItem.getBackground();
        if (background instanceof GradientDrawable) {
            Object tag = paletteItem.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            setRadius(((Integer) tag).intValue(), isSelected, (GradientDrawable) background);
        }
    }

    public final void setColor(int index, int color, boolean isSelected) {
        List<View> list = this.mPaletteItemList;
        if (list == null || index < 0) {
            return;
        }
        Intrinsics.checkNotNull(list);
        if (list.size() <= index) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        setRadius(index, isSelected, gradientDrawable);
        List<View> list2 = this.mPaletteItemList;
        if (list2 != null) {
            list2.get(index).setBackground(gradientDrawable);
        }
    }

    public final void setResource(int index, int bgPatten, @NotNull String name, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        super.setResource(index, bgPatten, name);
        List<View> list = this.mPaletteItemList;
        if (list != null) {
            Drawable background = list.get(index).getBackground();
            if (background instanceof GradientDrawable) {
                setRadius(index, isSelected, (GradientDrawable) background);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedPaletteContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadius = getResources().getDimensionPixelSize(C8003R.dimen.in_app_text_mode_color_palette_radius);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedPaletteContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadius = getResources().getDimensionPixelSize(C8003R.dimen.in_app_text_mode_color_palette_radius);
    }
}
