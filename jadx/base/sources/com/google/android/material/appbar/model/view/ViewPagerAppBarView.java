package com.google.android.material.appbar.model.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.appcompat.C0419R;
import androidx.appcompat.util.theme.SeslThemeResourceHelper;
import androidx.appcompat.util.theme.resource.SeslThemeResourceColor;
import androidx.appcompat.widget.SeslIndicator;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.C4548R;
import com.google.android.material.appbar.SeslAppBarHelper;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020 H\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, m13886d2 = {"Lcom/google/android/material/appbar/model/view/ViewPagerAppBarView;", "Lcom/google/android/material/appbar/model/view/AppBarView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bottomLayout", "Landroid/view/ViewGroup;", "getBottomLayout", "()Landroid/view/ViewGroup;", "setBottomLayout", "(Landroid/view/ViewGroup;)V", "indicator", "Landroidx/appcompat/widget/SeslIndicator;", "getIndicator", "()Landroidx/appcompat/widget/SeslIndicator;", "setIndicator", "(Landroidx/appcompat/widget/SeslIndicator;)V", "viewPagerContainer", "getViewPagerContainer", "setViewPagerContainer", "viewPagerParent", "getViewPagerParent", "setViewPagerParent", "viewpager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewpager", "()Landroidx/viewpager2/widget/ViewPager2;", "setViewpager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "adjustViewPagerLayout", "", "getViewPagerBackgroundColorStateList", "Landroid/content/res/ColorStateList;", "getViewPagerIndicatorOffColor", "", "getViewPagerIndicatorOnColor", "inflate", "updateResource", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nViewPagerAppBarView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewPagerAppBarView.kt\ncom/google/android/material/appbar/model/view/ViewPagerAppBarView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,194:1\n366#2:195\n348#2:196\n1#3:197\n*S KotlinDebug\n*F\n+ 1 ViewPagerAppBarView.kt\ncom/google/android/material/appbar/model/view/ViewPagerAppBarView\n*L\n98#1:195\n98#1:196\n*E\n"})
public class ViewPagerAppBarView extends AppBarView {

    @Nullable
    private ViewGroup bottomLayout;

    @Nullable
    private SeslIndicator indicator;

    @Nullable
    private ViewGroup viewPagerContainer;

    @Nullable
    private ViewGroup viewPagerParent;

    @Nullable
    private ViewPager2 viewpager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ViewPagerAppBarView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void adjustViewPagerLayout() {
        SeslAppBarHelper.Companion companion = SeslAppBarHelper.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Pair<Integer, Integer> suggestionAppBarSize = companion.getSuggestionAppBarSize(context, this);
        int iIntValue = suggestionAppBarSize.component1().intValue();
        int iIntValue2 = suggestionAppBarSize.component2().intValue();
        if (iIntValue == 0) {
            iIntValue = -1;
        }
        if (iIntValue2 == 0) {
            iIntValue2 = -1;
        }
        ViewPager2 viewPager2 = this.viewpager;
        if (viewPager2 != null) {
            viewPager2.setLayoutParams(new LinearLayout.LayoutParams(iIntValue, iIntValue2));
        }
        if (iIntValue == -1) {
            ViewGroup viewGroup = this.viewPagerParent;
            ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(0);
        }
    }

    private final ColorStateList getViewPagerBackgroundColorStateList(Context context) {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_viewpager_background, C4548R.color.sesl_viewpager_background_dark), new SeslThemeResourceColor.ThemeResourceColor(C4548R.color.sesl_viewpager_background_for_theme))));
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(\n            Ses…)\n            )\n        )");
        return colorStateListValueOf;
    }

    private final int getViewPagerIndicatorOffColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_off, C0419R.color.sesl_appbar_viewpager_indicator_off_dark), new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_off_for_theme, C0419R.color.sesl_appbar_viewpager_indicator_off_dark_for_theme)));
    }

    private final int getViewPagerIndicatorOnColor(Context context) {
        return SeslThemeResourceHelper.INSTANCE.getColorInt(context, new SeslThemeResourceColor.OpenThemeResourceColor(new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_on), new SeslThemeResourceColor.ThemeResourceColor(C0419R.color.sesl_appbar_viewpager_indicator_on_for_theme)));
    }

    @Nullable
    public final ViewGroup getBottomLayout() {
        return this.bottomLayout;
    }

    @Nullable
    public final SeslIndicator getIndicator() {
        return this.indicator;
    }

    @Nullable
    public final ViewGroup getViewPagerContainer() {
        return this.viewPagerContainer;
    }

    @Nullable
    public final ViewGroup getViewPagerParent() {
        return this.viewPagerParent;
    }

    @Nullable
    public final ViewPager2 getViewpager() {
        return this.viewpager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.material.appbar.model.view.AppBarView
    public void inflate() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C4548R.layout.sesl_app_bar_viewpager, (ViewGroup) this, false);
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        ViewGroup viewGroup = viewInflate instanceof ViewGroup ? (ViewGroup) viewInflate : null;
        if (viewGroup == null) {
            return;
        }
        this.viewpager = (ViewPager2) viewGroup.findViewById(C4548R.id.app_bar_viewpager);
        this.viewPagerContainer = (ViewGroup) viewGroup.findViewById(C4548R.id.app_bar_viewpager_container);
        this.viewPagerParent = (ViewGroup) viewGroup.findViewById(C4548R.id.app_bar_viewpager_parent);
        this.bottomLayout = (ViewGroup) viewGroup.findViewById(C4548R.id.bottom_layout);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SeslIndicator seslIndicator = new SeslIndicator(context, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
        seslIndicator.setOnItemClickListener(new SeslIndicator.OnItemClickListener() { // from class: com.google.android.material.appbar.model.view.ViewPagerAppBarView$inflate$1$1
            @Override // androidx.appcompat.widget.SeslIndicator.OnItemClickListener
            public void onItemClick(View view, int position) {
                ViewPager2 viewpager = this.this$0.getViewpager();
                if (viewpager != null) {
                    viewpager.setCurrentItem(position, true);
                }
            }
        });
        this.indicator = seslIndicator;
        ViewPager2 viewPager2 = this.viewpager;
        if (viewPager2 != null) {
            viewPager2.seslSetSuggestionPaging(true);
            Drawable drawable = viewPager2.getContext().getDrawable(C4548R.drawable.sesl_viewpager_background);
            viewPager2.setBackground(drawable != null ? drawable.mutate() : null);
        }
        ViewPager2 viewPager22 = this.viewpager;
        Intrinsics.checkNotNull(viewPager22);
        ViewCompat.setAccessibilityDelegate(viewPager22, new AccessibilityDelegateCompat() { // from class: com.google.android.material.appbar.model.view.ViewPagerAppBarView.inflate.3
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                RecyclerView.Adapter adapter;
                ViewPager2 viewpager;
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                ViewPager2 viewpager2 = ViewPagerAppBarView.this.getViewpager();
                if (viewpager2 == null || (adapter = viewpager2.getAdapter()) == null || adapter.getItemCount() != 1 || (viewpager = ViewPagerAppBarView.this.getViewpager()) == null || viewpager.getCurrentItem() != 0) {
                    return;
                }
                info.setClassName("");
            }
        });
        adjustViewPagerLayout();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C4548R.dimen.sesl_appbar_viewpager_indicator_height);
        ViewGroup viewGroup2 = this.bottomLayout;
        if (viewGroup2 != null) {
            Intrinsics.checkNotNull(viewGroup2);
            ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            int i = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
            ViewGroup viewGroup3 = this.bottomLayout;
            Intrinsics.checkNotNull(viewGroup3);
            ViewGroup.LayoutParams layoutParams2 = viewGroup3.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            i = (marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0) + i;
        }
        int i2 = dimensionPixelSize + i;
        ViewGroup viewGroup4 = this.viewPagerParent;
        ViewGroup.LayoutParams layoutParams3 = viewGroup4 != null ? viewGroup4.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = i2;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        ViewGroup viewGroup5 = this.bottomLayout;
        if (viewGroup5 != null) {
            viewGroup5.addView(this.indicator, layoutParams4);
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        updateResource(context2);
        addView(viewGroup);
    }

    public final void setBottomLayout(@Nullable ViewGroup viewGroup) {
        this.bottomLayout = viewGroup;
    }

    public final void setIndicator(@Nullable SeslIndicator seslIndicator) {
        this.indicator = seslIndicator;
    }

    public final void setViewPagerContainer(@Nullable ViewGroup viewGroup) {
        this.viewPagerContainer = viewGroup;
    }

    public final void setViewPagerParent(@Nullable ViewGroup viewGroup) {
        this.viewPagerParent = viewGroup;
    }

    public final void setViewpager(@Nullable ViewPager2 viewPager2) {
        this.viewpager = viewPager2;
    }

    @Override // com.google.android.material.appbar.model.view.AppBarView
    public void updateResource(@NotNull Context context) {
        Drawable drawableMutate;
        Drawable drawableMutate2;
        Intrinsics.checkNotNullParameter(context, "context");
        ViewPager2 viewPager2 = this.viewpager;
        if (viewPager2 != null) {
            adjustViewPagerLayout();
            viewPager2.setBackgroundTintList(getViewPagerBackgroundColorStateList(context));
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        SeslIndicator seslIndicator = this.indicator;
        if (seslIndicator != null) {
            Drawable drawable = context.getDrawable(C0419R.drawable.sesl_viewpager_indicator_on_off);
            Drawable drawable2 = null;
            if (drawable == null || (drawableMutate = drawable.mutate()) == null) {
                drawableMutate = null;
            } else {
                drawableMutate.setTint(getViewPagerIndicatorOffColor(context));
            }
            seslIndicator.setDefaultCircle(drawableMutate);
            Drawable drawable3 = context.getDrawable(C0419R.drawable.sesl_viewpager_indicator_on_off);
            if (drawable3 != null && (drawableMutate2 = drawable3.mutate()) != null) {
                drawableMutate2.setTint(getViewPagerIndicatorOnColor(context));
                drawable2 = drawableMutate2;
            }
            seslIndicator.setSelectCircle(drawable2);
        }
    }

    public /* synthetic */ ViewPagerAppBarView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewPagerAppBarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        inflate();
    }
}
