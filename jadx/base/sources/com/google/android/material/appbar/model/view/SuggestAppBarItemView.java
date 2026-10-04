package com.google.android.material.appbar.model.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.oneui.common.internal.util.MaxFontScaleRatio;
import androidx.appcompat.oneui.common.internal.util.TextViewHelperKt;
import androidx.appcompat.util.SeslMisc;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.core.content.ContextCompat;
import androidx.reflect.view.SeslViewReflector;
import androidx.reflect.widget.SeslHoverPopupWindowReflector;
import com.google.android.material.C4548R;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Iterator;
import java.util.List;
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
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m13886d2 = {"Lcom/google/android/material/appbar/model/view/SuggestAppBarItemView;", "Lcom/google/android/material/appbar/model/view/SuggestAppBarView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "getButtonTextColor", "", "getSuggestButtonTextColor", "inflate", "", "updateButton", MarketingConstants.BUTTON, "Landroid/widget/Button;", "updateButtons", "buttons", "", "updateResource", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSuggestAppBarItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuggestAppBarItemView.kt\ncom/google/android/material/appbar/model/view/SuggestAppBarItemView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n1855#2,2:136\n*S KotlinDebug\n*F\n+ 1 SuggestAppBarItemView.kt\ncom/google/android/material/appbar/model/view/SuggestAppBarItemView\n*L\n93#1:136,2\n*E\n"})
public class SuggestAppBarItemView extends SuggestAppBarView {

    @Nullable
    private ViewGroup rootView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SuggestAppBarItemView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getButtonTextColor() {
        SeslThemeResourceHelper.Companion companion = SeslThemeResourceHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_button_text_color, C4548R.color.sesl_button_text_color_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_button_text_color, C4548R.color.sesl_button_text_color_dark_for_theme)));
    }

    private final int getSuggestButtonTextColor() {
        SeslThemeResourceHelper.Companion companion = SeslThemeResourceHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_suggest_button_text_color, C4548R.color.sesl_suggest_button_text_color_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_suggest_button_text_color, C4548R.color.sesl_suggest_button_text_color_dark_for_theme)));
    }

    private final void updateButton(Button button) {
        button.setTextColor(getButtonTextColor());
        TextViewHelperKt.checkMaxFontScale(button, C4548R.dimen.sesl_appbar_button_text_size, MaxFontScaleRatio.MEDIUM);
    }

    @Override // android.view.View
    @Nullable
    public final ViewGroup getRootView() {
        return this.rootView;
    }

    @Override // com.google.android.material.appbar.model.view.SuggestAppBarView, com.google.android.material.appbar.model.view.AppBarView
    public void inflate() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_app_bar_suggest_in_viewpager, (ViewGroup) this, false);
        ImageButton imageButton = null;
        ViewGroup viewGroup = viewInflate instanceof ViewGroup ? (ViewGroup) viewInflate : null;
        if (viewGroup == null) {
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(C4548R.id.sesl_appbar_suggest_in_viewpager);
        viewGroup2.setBackgroundResource(C4548R.drawable.sesl_viewpager_item_background);
        this.rootView = viewGroup2;
        setTopImageView((ImageView) viewGroup.findViewById(C4548R.id.suggest_app_bar_top_image));
        setTitleView((TextView) viewGroup.findViewById(C4548R.id.suggest_app_bar_title));
        setSubTitleView((TextView) viewGroup.findViewById(C4548R.id.suggest_app_bar_sub_title));
        ImageButton imageButton2 = (ImageButton) viewGroup.findViewById(C4548R.id.suggest_app_bar_close);
        if (imageButton2 != null) {
            SeslViewReflector.semSetHoverPopupType(imageButton2, SeslHoverPopupWindowReflector.getField_TYPE_NONE());
            imageButton = imageButton2;
        }
        setClose(imageButton);
        setBottomLayout((ViewGroup) viewGroup.findViewById(C4548R.id.suggest_app_bar_bottom_layout));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        updateResource(context);
        addView(viewGroup);
    }

    public final void setRootView(@Nullable ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }

    public final void updateButtons(@NotNull List<? extends Button> buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Iterator<T> it = buttons.iterator();
        while (it.hasNext()) {
            updateButton((Button) it.next());
        }
    }

    @Override // com.google.android.material.appbar.model.view.SuggestAppBarView, com.google.android.material.appbar.model.view.AppBarView
    public void updateResource(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.updateResource(context);
        boolean zIsLightTheme = SeslMisc.isLightTheme(context);
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, zIsLightTheme ? C4548R.color.sesl_viewpager_item_background : C4548R.color.sesl_viewpager_item_background_dark)));
        }
        TextView titleView = getTitleView();
        if (titleView != null) {
            TextViewHelperKt.checkMaxFontScale(titleView, C4548R.dimen.sesl_appbar_suggest_title_text_size, MaxFontScaleRatio.SMALL);
        }
        TextView subTitleView = getSubTitleView();
        if (subTitleView != null) {
            TextViewHelperKt.checkMaxFontScale(subTitleView, C4548R.dimen.sesl_appbar_suggest_sub_title_size, MaxFontScaleRatio.SMALL);
        }
        updateButtons(getButtons());
    }

    public /* synthetic */ SuggestAppBarItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SuggestAppBarItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        inflate();
    }
}
