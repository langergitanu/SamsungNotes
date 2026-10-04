package com.google.android.material.appbar.model.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.appcompat.widget.SeslIndicator;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.C4548R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u000e"}, m13886d2 = {"Lcom/google/android/material/appbar/model/view/BasicViewPagerAppBarWhiteCaseView;", "Lcom/google/android/material/appbar/model/view/BasicViewPagerAppBarView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getViewPagerBackgroundColorStateList", "Landroid/content/res/ColorStateList;", "getViewPagerIndicatorOffWithWhiteCaseColor", "", "getViewPagerIndicatorOnWithWhiteCaseColor", "updateResource", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nBasicViewPagerAppBarWhiteCaseView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicViewPagerAppBarWhiteCaseView.kt\ncom/google/android/material/appbar/model/view/BasicViewPagerAppBarWhiteCaseView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
public abstract class BasicViewPagerAppBarWhiteCaseView extends BasicViewPagerAppBarView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BasicViewPagerAppBarWhiteCaseView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ColorStateList getViewPagerBackgroundColorStateList(Context context) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_viewpager_background, C4548R.color.sesl_viewpager_background_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_viewpager_background_for_theme))));
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(\n            Ses…)\n            )\n        )");
        return colorStateListValueOf;
    }

    private final int getViewPagerIndicatorOffWithWhiteCaseColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_viewpager_indicator_off_with_white_case, C0419R.color.sesl_appbar_viewpager_indicator_off_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_viewpager_indicator_off_with_white_case_for_theme, C0419R.color.sesl_appbar_viewpager_indicator_off_dark_for_theme)));
    }

    private final int getViewPagerIndicatorOnWithWhiteCaseColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_viewpager_indicator_on_with_white_case), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_viewpager_indicator_on_with_white_case_for_theme)));
    }

    @Override // com.google.android.material.appbar.model.view.ViewPagerAppBarView, com.google.android.material.appbar.model.view.AppBarView
    public void updateResource(@NotNull Context context) {
        Drawable drawableMutate;
        Drawable drawableMutate2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.updateResource(context);
        ViewPager2 viewpager = getViewpager();
        if (viewpager != null) {
            viewpager.setBackgroundTintList(getViewPagerBackgroundColorStateList(context));
        }
        SeslIndicator indicator = getIndicator();
        if (indicator != null) {
            Drawable drawable = context.getDrawable(C0419R.drawable.sesl_viewpager_indicator_on_off);
            Drawable drawable2 = null;
            if (drawable == null || (drawableMutate = drawable.mutate()) == null) {
                drawableMutate = null;
            } else {
                drawableMutate.setTint(getViewPagerIndicatorOffWithWhiteCaseColor(context));
            }
            indicator.setDefaultCircle(drawableMutate);
            Drawable drawable3 = context.getDrawable(C0419R.drawable.sesl_viewpager_indicator_on_off);
            if (drawable3 != null && (drawableMutate2 = drawable3.mutate()) != null) {
                drawableMutate2.setTint(getViewPagerIndicatorOnWithWhiteCaseColor(context));
                drawable2 = drawableMutate2;
            }
            indicator.setSelectCircle(drawable2);
        }
    }

    public /* synthetic */ BasicViewPagerAppBarWhiteCaseView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BasicViewPagerAppBarWhiteCaseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
