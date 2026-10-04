package com.google.android.material.navigation.strategy;

import android.content.res.Resources;
import androidx.annotation.DimenRes;
import androidx.appcompat.view.menu.MenuView;
import com.google.android.material.C4548R;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005!\"#$%B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0004J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\bH\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0016\u0010\f\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0016\u0010\u0010\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006\u0082\u0001\u0003&'(¨\u0006)"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/ViewTypeStrategy;", "", "()V", "horizontalPaddingRes", "", "getHorizontalPaddingRes", "()I", "isFloatingStyle", "", "()Z", "itemSeparatorMarginRes", "getItemSeparatorMarginRes", "itemSeparatorPaddingRes", "getItemSeparatorPaddingRes", "minHeightRes", "getMinHeightRes", "selectedSidePaddingRes", "getSelectedSidePaddingRes", "applyNavigationBarStyle", "", "navigationBarView", "Lcom/google/android/material/navigation/NavigationBarView;", "getDimensionPixelSize", "resources", "Landroid/content/res/Resources;", "res", "getItemMinWidth", "visibleCount", "getItemSeparatorMargin", "isMaxCount", "getItemSeparatorPadding", "getSelectedSidePadding", "updateNavigationBarPadding", "FloatingIconLabelType", "FloatingIconOnlyType", "IconLabelType", "IconOnlyType", "LabelOnlyType", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$IconLabelType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$IconOnlyType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$LabelOnlyType;", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class ViewTypeStrategy {
    private final boolean isFloatingStyle;

    @DimenRes
    private final int itemSeparatorMarginRes;

    @DimenRes
    private final int itemSeparatorPaddingRes;

    @DimenRes
    private final int selectedSidePaddingRes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$FloatingIconLabelType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$IconLabelType;", "()V", "horizontalPaddingMaxCaseRes", "", "getHorizontalPaddingMaxCaseRes", "()I", "horizontalPaddingRes", "getHorizontalPaddingRes", "isFloatingStyle", "", "()Z", "itemSeparatorMarginMaxCaseRes", "getItemSeparatorMarginMaxCaseRes", "itemSeparatorMarginRes", "getItemSeparatorMarginRes", "itemSeparatorPaddingMaxCaseRes", "itemSeparatorPaddingRes", "getItemSeparatorPaddingRes", "minHeightRes", "getMinHeightRes", "selectedSidePaddingRes", "getSelectedSidePaddingRes", "getItemMinWidth", "resources", "Landroid/content/res/Resources;", "visibleCount", "getItemSeparatorPadding", "isMaxCount", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class FloatingIconLabelType extends IconLabelType {
        private final int minHeightRes = C4548R.dimen.sesl_bottom_navigation_floating_height;
        private final int horizontalPaddingRes = C4548R.dimen.f2197x4a5c8b55;
        private final int horizontalPaddingMaxCaseRes = C4548R.dimen.f2198x5701621b;
        private final int itemSeparatorPaddingRes = C4548R.dimen.sesl_bottom_navigation_floating_padding_horizontal;
        private final int itemSeparatorPaddingMaxCaseRes = C4548R.dimen.f2195x4b33e53a;
        private final int itemSeparatorMarginRes = -1;
        private final int itemSeparatorMarginMaxCaseRes = getItemSeparatorMarginRes();
        private final int selectedSidePaddingRes = C4548R.dimen.sesl_bottom_navigation_floating_icon_text_selected_side_padding;
        private final boolean isFloatingStyle = true;

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconLabelType
        public int getHorizontalPaddingMaxCaseRes() {
            return this.horizontalPaddingMaxCaseRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconLabelType, com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getHorizontalPaddingRes() {
            return this.horizontalPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemMinWidth(@NotNull Resources resources, int visibleCount) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            return resources.getDimensionPixelSize(visibleCount != 1 ? visibleCount != 2 ? C4548R.dimen.sesl_navigation_bar_floating_icon_text_min_width_count_over_3 : C4548R.dimen.sesl_navigation_bar_floating_icon_text_min_width_count_2 : C4548R.dimen.sesl_navigation_bar_floating_icon_text_min_width_count_1);
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconLabelType
        public int getItemSeparatorMarginMaxCaseRes() {
            return this.itemSeparatorMarginMaxCaseRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconLabelType, com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorMarginRes() {
            return this.itemSeparatorMarginRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorPadding(@NotNull Resources resources, boolean isMaxCount) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            return getDimensionPixelSize(resources, isMaxCount ? this.itemSeparatorPaddingMaxCaseRes : getItemSeparatorPaddingRes());
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorPaddingRes() {
            return this.itemSeparatorPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconLabelType, com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getMinHeightRes() {
            return this.minHeightRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getSelectedSidePaddingRes() {
            return this.selectedSidePaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        /* JADX INFO: renamed from: isFloatingStyle, reason: from getter */
        public boolean getIsFloatingStyle() {
            return this.isFloatingStyle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0016"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$FloatingIconOnlyType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$IconOnlyType;", "()V", "horizontalPaddingRes", "", "getHorizontalPaddingRes", "()I", "isFloatingStyle", "", "()Z", "itemSeparatorMarginRes", "getItemSeparatorMarginRes", "itemSeparatorPaddingRes", "getItemSeparatorPaddingRes", "minHeightRes", "getMinHeightRes", "selectedSidePaddingRes", "getSelectedSidePaddingRes", "getItemMinWidth", "resources", "Landroid/content/res/Resources;", "visibleCount", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class FloatingIconOnlyType extends IconOnlyType {
        private final int minHeightRes = C4548R.dimen.sesl_bottom_navigation_floating_height;
        private final int horizontalPaddingRes = C4548R.dimen.f2196x8b9c3d94;
        private final int itemSeparatorMarginRes = -1;
        private final int itemSeparatorPaddingRes = C4548R.dimen.sesl_bottom_navigation_floating_padding_horizontal;
        private final int selectedSidePaddingRes = C4548R.dimen.sesl_bottom_navigation_floating_icon_only_selected_side_padding;
        private final boolean isFloatingStyle = true;

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconOnlyType, com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getHorizontalPaddingRes() {
            return this.horizontalPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemMinWidth(@NotNull Resources resources, int visibleCount) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            return resources.getDimensionPixelSize(visibleCount != 1 ? visibleCount != 2 ? C4548R.dimen.sesl_navigation_bar_floating_icon_only_min_width_count_over_3 : C4548R.dimen.sesl_navigation_bar_floating_icon_only_min_width_count_2 : C4548R.dimen.sesl_navigation_bar_floating_icon_only_min_width_count_1);
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorMarginRes() {
            return this.itemSeparatorMarginRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorPaddingRes() {
            return this.itemSeparatorPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy.IconOnlyType, com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getMinHeightRes() {
            return this.minHeightRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getSelectedSidePaddingRes() {
            return this.selectedSidePaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        /* JADX INFO: renamed from: isFloatingStyle, reason: from getter */
        public boolean getIsFloatingStyle() {
            return this.isFloatingStyle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0019"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$IconLabelType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy;", "()V", "horizontalPaddingMaxCaseRes", "", "getHorizontalPaddingMaxCaseRes", "()I", "horizontalPaddingRes", "getHorizontalPaddingRes", "itemSeparatorMarginMaxCaseRes", "getItemSeparatorMarginMaxCaseRes", "itemSeparatorMarginRes", "getItemSeparatorMarginRes", "minHeightRes", "getMinHeightRes", "applyNavigationBarStyle", "", "navigationBarView", "Lcom/google/android/material/navigation/NavigationBarView;", "getItemSeparatorMargin", "resources", "Landroid/content/res/Resources;", "isMaxCount", "", "updateNavigationBarPadding", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class IconLabelType extends ViewTypeStrategy {
        private final int horizontalPaddingMaxCaseRes;
        private final int horizontalPaddingRes;
        private final int itemSeparatorMarginMaxCaseRes;
        private final int itemSeparatorMarginRes;
        private final int minHeightRes;

        public IconLabelType() {
            super(null);
            this.minHeightRes = C4548R.dimen.sesl_bottom_navigation_icon_mode_height;
            this.horizontalPaddingRes = C4548R.dimen.sesl_navigation_bar_icon_text_mode_padding_horizontal;
            this.horizontalPaddingMaxCaseRes = C4548R.dimen.sesl_navigation_bar_icon_text_mode_min_padding_horizontal;
            this.itemSeparatorMarginRes = C4548R.dimen.sesl_bottom_navigation_icon_mode_padding_horizontal;
            this.itemSeparatorMarginMaxCaseRes = C4548R.dimen.sesl_bottom_navigation_icon_mode_min_padding_horizontal;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public void applyNavigationBarStyle(@NotNull NavigationBarView navigationBarView) {
            Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
            MenuView menuView = navigationBarView.getMenuView();
            NavigationBarMenuView navigationBarMenuView = menuView instanceof NavigationBarMenuView ? (NavigationBarMenuView) menuView : null;
            if (navigationBarMenuView != null) {
                Resources resources = navigationBarMenuView.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                int dimensionPixelSize = getDimensionPixelSize(resources, getMinHeightRes());
                navigationBarMenuView.setMinimumHeight(dimensionPixelSize);
                updateNavigationBarPadding(navigationBarView);
                navigationBarView.setMinimumHeight(dimensionPixelSize);
            }
        }

        public int getHorizontalPaddingMaxCaseRes() {
            return this.horizontalPaddingMaxCaseRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getHorizontalPaddingRes() {
            return this.horizontalPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorMargin(@NotNull Resources resources, boolean isMaxCount) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            return getDimensionPixelSize(resources, isMaxCount ? getItemSeparatorMarginMaxCaseRes() : getItemSeparatorMarginRes());
        }

        public int getItemSeparatorMarginMaxCaseRes() {
            return this.itemSeparatorMarginMaxCaseRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getItemSeparatorMarginRes() {
            return this.itemSeparatorMarginRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getMinHeightRes() {
            return this.minHeightRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public void updateNavigationBarPadding(@NotNull NavigationBarView navigationBarView) {
            Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
            MenuView menuView = navigationBarView.getMenuView();
            NavigationBarMenuView navigationBarMenuView = menuView instanceof NavigationBarMenuView ? (NavigationBarMenuView) menuView : null;
            int visibleItemCount = navigationBarMenuView != null ? navigationBarMenuView.getVisibleItemCount() : 0;
            Resources resources = navigationBarView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            int dimensionPixelSize = getDimensionPixelSize(resources, visibleItemCount == navigationBarView.getMaxItemCount() ? getHorizontalPaddingMaxCaseRes() : getHorizontalPaddingRes());
            navigationBarView.setPadding(dimensionPixelSize, navigationBarView.getPaddingTop(), dimensionPixelSize, navigationBarView.getPaddingBottom());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$IconOnlyType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy;", "()V", "horizontalPaddingRes", "", "getHorizontalPaddingRes", "()I", "minHeightRes", "getMinHeightRes", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static class IconOnlyType extends ViewTypeStrategy {
        private final int horizontalPaddingRes;
        private final int minHeightRes;

        public IconOnlyType() {
            super(null);
            this.minHeightRes = C4548R.dimen.sesl_bottom_navigation_icon_only_mode_height;
            this.horizontalPaddingRes = C4548R.dimen.f2196x8b9c3d94;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getHorizontalPaddingRes() {
            return this.horizontalPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getMinHeightRes() {
            return this.minHeightRes;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Lcom/google/android/material/navigation/strategy/ViewTypeStrategy$LabelOnlyType;", "Lcom/google/android/material/navigation/strategy/ViewTypeStrategy;", "()V", "horizontalPaddingRes", "", "getHorizontalPaddingRes", "()I", "minHeightRes", "getMinHeightRes", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class LabelOnlyType extends ViewTypeStrategy {
        private final int horizontalPaddingRes;
        private final int minHeightRes;

        public LabelOnlyType() {
            super(null);
            this.minHeightRes = C4548R.dimen.sesl_bottom_navigation_text_mode_height;
            this.horizontalPaddingRes = C4548R.dimen.sesl_navigation_bar_text_mode_padding_horizontal;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getHorizontalPaddingRes() {
            return this.horizontalPaddingRes;
        }

        @Override // com.google.android.material.navigation.strategy.ViewTypeStrategy
        public int getMinHeightRes() {
            return this.minHeightRes;
        }
    }

    public /* synthetic */ ViewTypeStrategy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ int getItemSeparatorMargin$default(ViewTypeStrategy viewTypeStrategy, Resources resources, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItemSeparatorMargin");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return viewTypeStrategy.getItemSeparatorMargin(resources, z);
    }

    public static /* synthetic */ int getItemSeparatorPadding$default(ViewTypeStrategy viewTypeStrategy, Resources resources, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getItemSeparatorPadding");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return viewTypeStrategy.getItemSeparatorPadding(resources, z);
    }

    public void applyNavigationBarStyle(@NotNull NavigationBarView navigationBarView) {
        Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
        MenuView menuView = navigationBarView.getMenuView();
        NavigationBarMenuView navigationBarMenuView = menuView instanceof NavigationBarMenuView ? (NavigationBarMenuView) menuView : null;
        if (navigationBarMenuView != null) {
            Resources resources = navigationBarMenuView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            int dimensionPixelSize = getDimensionPixelSize(resources, getMinHeightRes());
            navigationBarMenuView.setMinimumHeight(dimensionPixelSize);
            updateNavigationBarPadding(navigationBarView);
            navigationBarView.setMinimumHeight(dimensionPixelSize);
        }
    }

    public final int getDimensionPixelSize(@NotNull Resources resources, @DimenRes int res) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (res == -1) {
            return 0;
        }
        return resources.getDimensionPixelSize(res);
    }

    @DimenRes
    public abstract int getHorizontalPaddingRes();

    public int getItemMinWidth(@NotNull Resources resources, int visibleCount) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return 0;
    }

    public int getItemSeparatorMargin(@NotNull Resources resources, boolean isMaxCount) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return getDimensionPixelSize(resources, getItemSeparatorMarginRes());
    }

    public int getItemSeparatorMarginRes() {
        return this.itemSeparatorMarginRes;
    }

    public int getItemSeparatorPadding(@NotNull Resources resources, boolean isMaxCount) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return getDimensionPixelSize(resources, getItemSeparatorPaddingRes());
    }

    public int getItemSeparatorPaddingRes() {
        return this.itemSeparatorPaddingRes;
    }

    @DimenRes
    public abstract int getMinHeightRes();

    public final int getSelectedSidePadding(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return getDimensionPixelSize(resources, getSelectedSidePaddingRes());
    }

    public int getSelectedSidePaddingRes() {
        return this.selectedSidePaddingRes;
    }

    /* JADX INFO: renamed from: isFloatingStyle, reason: from getter */
    public boolean getIsFloatingStyle() {
        return this.isFloatingStyle;
    }

    public void updateNavigationBarPadding(@NotNull NavigationBarView navigationBarView) {
        Intrinsics.checkNotNullParameter(navigationBarView, "navigationBarView");
        Resources resources = navigationBarView.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        int dimensionPixelSize = getDimensionPixelSize(resources, getHorizontalPaddingRes());
        navigationBarView.setPadding(dimensionPixelSize, navigationBarView.getPaddingTop(), dimensionPixelSize, navigationBarView.getPaddingBottom());
    }

    private ViewTypeStrategy() {
        this.itemSeparatorMarginRes = -1;
        this.itemSeparatorPaddingRes = -1;
        this.selectedSidePaddingRes = -1;
    }
}
