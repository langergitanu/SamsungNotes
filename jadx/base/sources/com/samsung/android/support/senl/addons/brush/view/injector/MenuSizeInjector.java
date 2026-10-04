package com.samsung.android.support.senl.addons.brush.view.injector;

import android.content.Context;
import android.content.res.Resources;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b@\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001a\u0010$\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR\u001a\u0010-\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\t\"\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR\u001a\u00103\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR\u001a\u00106\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u001a\u00109\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR\u001a\u0010<\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR\u001a\u0010?\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR\u001a\u0010B\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR\u0014\u0010E\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\t¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/injector/MenuSizeInjector;", "Lcom/samsung/android/support/senl/addons/brush/model/menu/IMenuSizeInjector;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "zoomTextMarginEndPx", "", "getZoomTextMarginEndPx", "()I", "setZoomTextMarginEndPx", "(I)V", "zoomTextMargiTopPx", "getZoomTextMargiTopPx", "setZoomTextMargiTopPx", "panningBarWidthPx", "getPanningBarWidthPx", "setPanningBarWidthPx", "panningBarHeightPx", "getPanningBarHeightPx", "setPanningBarHeightPx", "penUpButtonWidthHeightPx", "getPenUpButtonWidthHeightPx", "setPenUpButtonWidthHeightPx", "doneButtonWidthPx", "getDoneButtonWidthPx", "setDoneButtonWidthPx", "doneButtonHeightPx", "getDoneButtonHeightPx", "setDoneButtonHeightPx", "panningBarVerticalPaddingEndPx", "getPanningBarVerticalPaddingEndPx", "setPanningBarVerticalPaddingEndPx", "panningBarVerticalMarginEndPx", "getPanningBarVerticalMarginEndPx", "setPanningBarVerticalMarginEndPx", "panningBarVerticalMarginBottomPx", "getPanningBarVerticalMarginBottomPx", "setPanningBarVerticalMarginBottomPx", "panningBarHorizontalMarginEndPx", "getPanningBarHorizontalMarginEndPx", "setPanningBarHorizontalMarginEndPx", "panningBarHorizontalMarginBottomPx", "getPanningBarHorizontalMarginBottomPx", "setPanningBarHorizontalMarginBottomPx", "toolbarWidthPx", "getToolbarWidthPx", "setToolbarWidthPx", "toolbarHeightPx", "getToolbarHeightPx", "setToolbarHeightPx", "toolbarChildButtonSizePx", "getToolbarChildButtonSizePx", "setToolbarChildButtonSizePx", "toolbarChildButtonMarginPx", "getToolbarChildButtonMarginPx", "setToolbarChildButtonMarginPx", "toolbarMarginBottomPx", "getToolbarMarginBottomPx", "setToolbarMarginBottomPx", "toolbarLandMarginBottomPx", "getToolbarLandMarginBottomPx", "setToolbarLandMarginBottomPx", "toolbarIconMarginPx", "getToolbarIconMarginPx", "setToolbarIconMarginPx", "subMenuStrokeSizePx", "getSubMenuStrokeSizePx", "setSubMenuStrokeSizePx", "minWidth", "getMinWidth", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class MenuSizeInjector implements IMenuSizeInjector {
    private final int minWidth;
    private int zoomTextMarginEndPx = -1;
    private int zoomTextMargiTopPx = -1;
    private int panningBarWidthPx = -1;
    private int panningBarHeightPx = -1;
    private int penUpButtonWidthHeightPx = -1;
    private int doneButtonWidthPx = -1;
    private int doneButtonHeightPx = -1;
    private int panningBarVerticalPaddingEndPx = -1;
    private int panningBarVerticalMarginEndPx = -1;
    private int panningBarVerticalMarginBottomPx = -1;
    private int panningBarHorizontalMarginEndPx = -1;
    private int panningBarHorizontalMarginBottomPx = -1;
    private int toolbarWidthPx = -1;
    private int toolbarHeightPx = -1;
    private int toolbarChildButtonSizePx = -1;
    private int toolbarChildButtonMarginPx = -1;
    private int toolbarMarginBottomPx = -1;
    private int toolbarLandMarginBottomPx = -1;
    private int toolbarIconMarginPx = -1;
    private int subMenuStrokeSizePx = -1;

    public MenuSizeInjector(@Nullable Context context) {
        Intrinsics.checkNotNull(context);
        Resources resources = context.getApplicationContext().getResources();
        float f = context.getResources().getDisplayMetrics().densityDpi / context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        if (TabletUtil.isTabletUi()) {
            setZoomTextMarginEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_zoom_percentage_view_margin_end_tablet) * f));
            setZoomTextMargiTopPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_top_tablet) * f));
            setPanningBarWidthPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_width_tablet) * f));
            setPanningBarHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_height_tablet) * f));
            setPanningBarVerticalPaddingEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_vert_padding_end_tablet) * f));
            setPanningBarVerticalMarginEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_vert_margin_end_tablet) * f));
            setPanningBarVerticalMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_vert_margin_bottom_tablet) * f));
            setPanningBarHorizontalMarginEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_horiz_margin_end_tablet) * f));
            setPanningBarHorizontalMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_horiz_margin_bottom_tablet) * f));
            setToolbarMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_icon_margin_bottom) * f));
            setToolbarLandMarginBottomPx(getToolbarMarginBottomPx());
            setToolbarIconMarginPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_icon_margin_left_right_tablet) * f));
            setPenUpButtonWidthHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_penup_layout_size_tablet) * f));
            setDoneButtonWidthPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_done_width_tablet) * f));
            setDoneButtonHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_height_tablet) * f));
            setToolbarWidthPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_width_tablet) * f));
            setToolbarHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_height_tablet) * f));
            setToolbarChildButtonSizePx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_item_size_tablet) * f));
            setToolbarChildButtonMarginPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_item_margin_tablet) * f));
            setSubMenuStrokeSizePx(resources.getDimensionPixelSize(C7944R.dimen.brush_menu_stroke_size));
        } else {
            setZoomTextMarginEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_end) * f));
            setZoomTextMargiTopPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_zoom_percentage_view_margin_top) * f));
            setPanningBarWidthPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_width) * f));
            setPanningBarHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_height) * f));
            setPanningBarVerticalPaddingEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_vert_padding_end) * f));
            setPanningBarVerticalMarginEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_vert_margin_end) * f));
            setPanningBarVerticalMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_vert_margin_bottom) * f));
            setPanningBarHorizontalMarginEndPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_horiz_margin_end) * f));
            setPanningBarHorizontalMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_horiz_margin_bottom) * f));
            setPanningBarHorizontalMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.base_panningbar_guideview_horiz_margin_bottom) * f));
            setToolbarMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_icon_margin_bottom) * f));
            setToolbarLandMarginBottomPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_icon_margin_bottom_phone_land) * f));
            setToolbarIconMarginPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_icon_margin_left_right) * f));
            setPenUpButtonWidthHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_penup_layout_size) * f));
            setDoneButtonWidthPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_done_width) * f));
            setDoneButtonHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_height) * f));
            setToolbarWidthPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_width) * f));
            setToolbarHeightPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_sub_menu_layout_height) * f));
            setToolbarChildButtonSizePx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_item_size) * f));
            setToolbarChildButtonMarginPx((int) (resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_item_margin) * f));
            setSubMenuStrokeSizePx(resources.getDimensionPixelSize(C7944R.dimen.brush_toolbar_item_stroke_size));
        }
        this.minWidth = resources.getDimensionPixelSize(C7944R.dimen.brush_menu_min_tablet_width);
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getDoneButtonHeightPx() {
        return this.doneButtonHeightPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getDoneButtonWidthPx() {
        return this.doneButtonWidthPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getMinWidth() {
        return this.minWidth;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarHeightPx() {
        return this.panningBarHeightPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarHorizontalMarginBottomPx() {
        return this.panningBarHorizontalMarginBottomPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarHorizontalMarginEndPx() {
        return this.panningBarHorizontalMarginEndPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarVerticalMarginBottomPx() {
        return this.panningBarVerticalMarginBottomPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarVerticalMarginEndPx() {
        return this.panningBarVerticalMarginEndPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarVerticalPaddingEndPx() {
        return this.panningBarVerticalPaddingEndPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPanningBarWidthPx() {
        return this.panningBarWidthPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getPenUpButtonWidthHeightPx() {
        return this.penUpButtonWidthHeightPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getSubMenuStrokeSizePx() {
        return this.subMenuStrokeSizePx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarChildButtonMarginPx() {
        return this.toolbarChildButtonMarginPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarChildButtonSizePx() {
        return this.toolbarChildButtonSizePx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarHeightPx() {
        return this.toolbarHeightPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarIconMarginPx() {
        return this.toolbarIconMarginPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarLandMarginBottomPx() {
        return this.toolbarLandMarginBottomPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarMarginBottomPx() {
        return this.toolbarMarginBottomPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getToolbarWidthPx() {
        return this.toolbarWidthPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getZoomTextMargiTopPx() {
        return this.zoomTextMargiTopPx;
    }

    @Override // com.samsung.android.support.senl.addons.brush.model.menu.IMenuSizeInjector
    public int getZoomTextMarginEndPx() {
        return this.zoomTextMarginEndPx;
    }

    public void setDoneButtonHeightPx(int i) {
        this.doneButtonHeightPx = i;
    }

    public void setDoneButtonWidthPx(int i) {
        this.doneButtonWidthPx = i;
    }

    public void setPanningBarHeightPx(int i) {
        this.panningBarHeightPx = i;
    }

    public void setPanningBarHorizontalMarginBottomPx(int i) {
        this.panningBarHorizontalMarginBottomPx = i;
    }

    public void setPanningBarHorizontalMarginEndPx(int i) {
        this.panningBarHorizontalMarginEndPx = i;
    }

    public void setPanningBarVerticalMarginBottomPx(int i) {
        this.panningBarVerticalMarginBottomPx = i;
    }

    public void setPanningBarVerticalMarginEndPx(int i) {
        this.panningBarVerticalMarginEndPx = i;
    }

    public void setPanningBarVerticalPaddingEndPx(int i) {
        this.panningBarVerticalPaddingEndPx = i;
    }

    public void setPanningBarWidthPx(int i) {
        this.panningBarWidthPx = i;
    }

    public void setPenUpButtonWidthHeightPx(int i) {
        this.penUpButtonWidthHeightPx = i;
    }

    public void setSubMenuStrokeSizePx(int i) {
        this.subMenuStrokeSizePx = i;
    }

    public void setToolbarChildButtonMarginPx(int i) {
        this.toolbarChildButtonMarginPx = i;
    }

    public void setToolbarChildButtonSizePx(int i) {
        this.toolbarChildButtonSizePx = i;
    }

    public void setToolbarHeightPx(int i) {
        this.toolbarHeightPx = i;
    }

    public void setToolbarIconMarginPx(int i) {
        this.toolbarIconMarginPx = i;
    }

    public void setToolbarLandMarginBottomPx(int i) {
        this.toolbarLandMarginBottomPx = i;
    }

    public void setToolbarMarginBottomPx(int i) {
        this.toolbarMarginBottomPx = i;
    }

    public void setToolbarWidthPx(int i) {
        this.toolbarWidthPx = i;
    }

    public void setZoomTextMargiTopPx(int i) {
        this.zoomTextMargiTopPx = i;
    }

    public void setZoomTextMarginEndPx(int i) {
        this.zoomTextMarginEndPx = i;
    }
}
