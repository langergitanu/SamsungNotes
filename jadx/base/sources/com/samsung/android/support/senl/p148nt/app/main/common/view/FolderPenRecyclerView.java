package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.FolderCommonHolder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderPenRecyclerView extends PenRecyclerView {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RoundedDecoration extends RecyclerView.ItemDecoration {
        private Drawable mDivider;
        private SeslRoundedCorner mListRoundedCorner;

        public RoundedDecoration(Context context) {
        }

        private void initialize() {
            if (this.mDivider == null) {
                this.mDivider = ResourcesCompat.getDrawable(FolderPenRecyclerView.this.getResources(), C8003R.drawable.notes_simple_item_divider_bg, null);
            }
            if (this.mListRoundedCorner == null) {
                SeslRoundedCorner seslRoundedCorner = new SeslRoundedCorner(FolderPenRecyclerView.this.getContext(), false);
                this.mListRoundedCorner = seslRoundedCorner;
                seslRoundedCorner.setRoundedCorners(15);
                this.mListRoundedCorner.setRoundedCornerColor(15, FolderPenRecyclerView.this.getResources().getColor(C8003R.color.round_corner_color, null));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            initialize();
            if ((((PenRecyclerView) FolderPenRecyclerView.this).mLayoutMode & 8) > 0 || (((PenRecyclerView) FolderPenRecyclerView.this).mLayoutMode & 32) > 0) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int i = 0;
            while (i < childCount) {
                RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
                int i2 = i == 0 ? childCount > 1 ? 3 : 15 : i == childCount + (-1) ? 12 : 0;
                if ((((PenRecyclerView) FolderPenRecyclerView.this).mLayoutMode & 16) > 0) {
                    ((FolderCommonHolder) childViewHolder).decorateRoundedCorner(16, i2);
                }
                i++;
            }
            if (childCount > 0) {
                this.mListRoundedCorner.drawRoundedCorner(canvas);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            if ((((PenRecyclerView) FolderPenRecyclerView.this).mLayoutMode & 8) > 0 || (((PenRecyclerView) FolderPenRecyclerView.this).mLayoutMode & 32) > 0 || (((PenRecyclerView) FolderPenRecyclerView.this).mLayoutMode & 16) > 0 || this.mDivider == null) {
                return;
            }
            int dimensionPixelSize = FolderPenRecyclerView.this.getContext().getResources().getDimensionPixelSize(C8003R.dimen.folder_list_item_divider_margin_start_end);
            int width = recyclerView.getWidth() - dimensionPixelSize;
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                int bottom = recyclerView.getChildAt(i).getBottom();
                this.mDivider.setBounds(dimensionPixelSize, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
                this.mDivider.draw(canvas);
            }
        }
    }

    public FolderPenRecyclerView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        addItemDecoration(new RoundedDecoration(context));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void scrollBy(int i, int i2) {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onTouchEvent")) {
                return;
            }
            if (stackTraceElement.getMethodName().equals("doCallbacks")) {
                super.scrollBy(i, i2);
                return;
            }
        }
        super.scrollBy(i, i2);
    }

    public void scrollToBottom() {
        scrollToPosition(getAdapter().getItemCount() - 1);
    }

    public void smoothScrollToPositionForDrawer(int i, final float f) {
        super.smoothScrollToPosition(i);
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(getContext()) { // from class: com.samsung.android.support.senl.nt.app.main.common.view.FolderPenRecyclerView.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return f / displayMetrics.densityDpi;
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        layoutManager.startSmoothScroll(linearSmoothScroller);
    }

    public FolderPenRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FolderPenRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void smoothScrollToPositionForDrawer(int i) {
        smoothScrollToPositionForDrawer(i, 500.0f);
    }

    public void scrollBy(int i) {
        super.scrollBy(0, i);
    }
}
