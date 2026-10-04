package com.google.android.material.appbar.model.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.appcompat.util.theme.resource.SeslThemeResourceDrawable;
import com.google.android.material.C4548R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/google/android/material/appbar/model/view/SuggestAppBarItemWhiteCaseView;", "Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCloseDrawable", "Landroid/graphics/drawable/Drawable;", "getSuggestButtonTextColorWithWhiteCase", "", "getSuggestTitleWithWhiteCaseColor", "getViewPagerItemBackgroundWhiteWhiteCaseColor", "updateResource", "", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public class SuggestAppBarItemWhiteCaseView extends SuggestAppBarItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestAppBarItemWhiteCaseView(@NotNull Context context) {
        super(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable getCloseDrawable(Context context) {
        return Build.VERSION.SDK_INT >= 29 ? SeslThemeResourceHelper.INSTANCE.getDrawable(context, new SeslThemeResourceDrawable.OpenThemeResourceDrawable(new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_close_button_recoil_background_with_white_case, C4548R.drawable.sesl_close_button_recoil_background_dark), new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_close_button_recoil_background_with_white_case_for_theme, C4548R.drawable.sesl_close_button_recoil_background_dark_for_theme))) : SeslThemeResourceHelper.INSTANCE.getDrawable(context, new SeslThemeResourceDrawable.OpenThemeResourceDrawable(new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_ic_close_with_white_case, C4548R.drawable.sesl_ic_close_dark), new SeslThemeResourceDrawable.ThemeResourceDrawable(C4548R.drawable.sesl_ic_close_with_white_case_for_theme, C4548R.drawable.sesl_ic_close_dark_for_theme)));
    }

    private final int getSuggestButtonTextColorWithWhiteCase() {
        SeslThemeResourceHelper.Companion companion = SeslThemeResourceHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_suggest_button_text_color_with_white_case, C4548R.color.sesl_suggest_button_text_color_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_suggest_button_text_color_with_white_case, C4548R.color.sesl_suggest_button_text_color_dark_for_theme)));
    }

    private final int getSuggestTitleWithWhiteCaseColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_suggest_title_with_white_case, C4548R.color.sesl_appbar_suggest_title_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_appbar_suggest_title_with_white_case, C4548R.color.sesl_appbar_suggest_title_dark_for_theme)));
    }

    private final int getViewPagerItemBackgroundWhiteWhiteCaseColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_viewpager_item_background_with_white_case, C4548R.color.sesl_viewpager_item_background_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_viewpager_item_background_with_white_case_for_theme, C4548R.color.sesl_viewpager_item_background_dark)));
    }

    @Override // com.google.android.material.appbar.model.view.SuggestAppBarItemView, com.google.android.material.appbar.model.view.SuggestAppBarView, com.google.android.material.appbar.model.view.AppBarView
    public void updateResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.updateResource(context);
        SeslMisc.isLightTheme(context);
        ViewGroup rootView = getRootView();
        if (rootView != null) {
            rootView.setBackgroundTintList(ColorStateList.valueOf(getViewPagerItemBackgroundWhiteWhiteCaseColor(context)));
        }
        TextView titleView = getTitleView();
        if (titleView != null) {
            titleView.setTextColor(getSuggestTitleWithWhiteCaseColor(context));
        }
        ImageButton close = getClose();
        if (close != null) {
            close.setBackground(getCloseDrawable(context));
        }
        updateButtons(getButtons());
    }
}
