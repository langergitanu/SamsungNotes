package com.samsung.android.support.senl.p148nt.app.common.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import androidx.appcompat.C0419R;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.oneui.floatingactioncontainer.FloatingBottomLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ViewModeUtils {
    private static final String TAG = "ViewModeUtils";

    private static int getBottomInsets() {
        WindowInsetsCompat windowInsets = WindowInsetsManager.getInstance().getWindowInsets();
        return Math.max(windowInsets.getInsets(WindowInsetsCompat.Type.displayCutout()).bottom, windowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
    }

    public static View getInflatedView(View view, int i, int i2) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById == null) {
            return view.findViewById(i2);
        }
        try {
            return ((ViewStub) viewFindViewById).inflate();
        } catch (Resources.NotFoundException e) {
            MainLogger.m7255e(TAG, "getInflatedView, e: " + e.getMessage());
            return null;
        }
    }

    public static void initGoToTopButtonPosition(RecyclerView recyclerView, FloatingToolbarLayout floatingToolbarLayout, FloatingBottomLayout floatingBottomLayout) {
        if (recyclerView == null) {
            return;
        }
        int dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_recycler_gototop_default_padding_bottom) + getBottomInsets();
        if (floatingBottomLayout != null && recyclerView.seslGetGoToTopBottomPadding() > dimensionPixelSize) {
            floatingBottomLayout.disableAutoGoToTopOffsetMove();
            floatingBottomLayout.setWindowBottomInset(dimensionPixelSize);
            floatingBottomLayout.enableAutoGoToTopOffsetMove();
        } else {
            if (floatingToolbarLayout == null || recyclerView.seslGetGoToTopBottomPadding() <= dimensionPixelSize) {
                return;
            }
            floatingToolbarLayout.disableAutoGoToTopOffsetMove();
            floatingToolbarLayout.setWindowBottomInset(dimensionPixelSize);
            floatingToolbarLayout.enableAutoGoToTopOffsetMove();
        }
    }

    private static boolean isViewOverlapping(View view, View view2) {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        view.getGlobalVisibleRect(rect);
        view2.getGlobalVisibleRect(rect2);
        return Rect.intersects(rect, rect2);
    }

    public static void runOnUiThread(Activity activity, Runnable runnable) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.runOnUiThread(runnable);
    }

    public static void updateFloatingLayoutShadow(RecyclerView recyclerView, FloatingBottomLayout floatingBottomLayout, FloatingTopLayout floatingTopLayout, FloatingToolbarLayout floatingToolbarLayout) {
        if (recyclerView == null) {
            return;
        }
        float dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(C0419R.dimen.sesl_figma_elevation_sm);
        float dimensionPixelSize2 = recyclerView.getResources().getDimensionPixelSize(C0419R.dimen.sesl_figma_elevation_md);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i2));
            if (childViewHolder == null) {
                return;
            }
            if (floatingBottomLayout != null && isViewOverlapping(floatingBottomLayout, childViewHolder.itemView)) {
                floatingBottomLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize2));
                i |= 2;
            }
            if (floatingTopLayout != null && isViewOverlapping(floatingTopLayout, childViewHolder.itemView)) {
                floatingTopLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize2));
                i |= 4;
            }
            if (floatingToolbarLayout != null && isViewOverlapping(floatingToolbarLayout, childViewHolder.itemView)) {
                floatingToolbarLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize2));
                i |= 8;
            }
        }
        if (floatingBottomLayout != null && (i & 2) == 0) {
            floatingBottomLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize));
        }
        if (floatingTopLayout != null && (i & 4) == 0) {
            floatingTopLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize));
        }
        if (floatingToolbarLayout != null && (i & 8) == 0) {
            floatingToolbarLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize));
        }
        AbstractC8014b.m7201c(i, "updateFloatingLayoutShadow set# ", TAG);
    }

    public static void updateGoToTopButtonPosition(FloatingBottomLayout floatingBottomLayout, boolean z) {
        int bottomInsets;
        int dimensionPixelSize;
        if (floatingBottomLayout == null) {
            return;
        }
        if (z) {
            bottomInsets = getBottomInsets();
            dimensionPixelSize = floatingBottomLayout.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_recycler_gototop_edit_mode_padding_bottom);
        } else {
            bottomInsets = getBottomInsets();
            dimensionPixelSize = floatingBottomLayout.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_recycler_gototop_default_padding_bottom);
        }
        int i = dimensionPixelSize + bottomInsets;
        if (i == floatingBottomLayout.getWindowInsetBottom()) {
            return;
        }
        floatingBottomLayout.disableAutoGoToTopOffsetMove();
        floatingBottomLayout.setWindowBottomInset(i);
        floatingBottomLayout.enableAutoGoToTopOffsetMove();
    }

    public static void updateRecyclerViewFadingEdge(RecyclerView recyclerView, boolean z) {
        if (recyclerView == null) {
            return;
        }
        AbstractC8014b.m7210l("updateRecyclerViewFadingEdge# bottom : ", TAG, z);
        recyclerView.seslSetFadingEdgeEnabled(true, z);
    }

    public static void updateRecyclerViewPaddingBottom(RecyclerView recyclerView, boolean z) {
        if (recyclerView == null) {
            return;
        }
        recyclerView.setPadding(recyclerView.getPaddingStart(), recyclerView.getPaddingTop(), recyclerView.getPaddingEnd(), recyclerView.getResources().getDimensionPixelSize(z ? C8003R.dimen.noteslist_recycler_padding_bottom_with_footer : C8003R.dimen.noteslist_recycler_padding_bottom));
    }

    public static void updateScrollingFloatingLayoutShadow(RecyclerView recyclerView, FloatingBottomLayout floatingBottomLayout, FloatingTopLayout floatingTopLayout, FloatingToolbarLayout floatingToolbarLayout) {
        if (recyclerView == null) {
            return;
        }
        float dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(C0419R.dimen.sesl_figma_elevation_md);
        if (floatingBottomLayout != null) {
            floatingBottomLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize));
        }
        if (floatingTopLayout != null) {
            floatingTopLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize));
        }
        if (floatingToolbarLayout != null) {
            floatingToolbarLayout.setElevationForFloatingBackground(Float.valueOf(dimensionPixelSize));
        }
    }

    @Nullable
    public static View getInflatedView(Activity activity, int i, int i2) {
        if (activity == null) {
            return null;
        }
        View viewFindViewById = activity.findViewById(i);
        if (viewFindViewById == null) {
            return activity.findViewById(i2);
        }
        try {
            return ((ViewStub) viewFindViewById).inflate();
        } catch (Resources.NotFoundException e) {
            MainLogger.m7255e(TAG, "getInflatedView, e: " + e.getMessage());
            return null;
        }
    }

    public static void updateRecyclerViewFadingEdge(RecyclerView recyclerView, boolean z, boolean z2) {
        if (recyclerView == null) {
            return;
        }
        MainLogger.m7254d(TAG, "updateRecyclerViewFadingEdge# top : " + z + ", bottom : " + z2);
        recyclerView.seslSetFadingEdgeEnabled(true, z, z2);
    }
}
