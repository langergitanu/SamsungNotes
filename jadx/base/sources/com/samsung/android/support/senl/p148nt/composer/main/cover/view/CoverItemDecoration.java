package com.samsung.android.support.senl.p148nt.composer.main.cover.view;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverItemDecoration extends RecyclerView.ItemDecoration {
    private final int mMarginStartEnd;
    private final int mMarginTopBottom;

    public CoverItemDecoration(int i) {
        this.mMarginStartEnd = i;
        this.mMarginTopBottom = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.left = childAdapterPosition == 0 ? 0 : this.mMarginStartEnd;
        rect.right = childAdapterPosition != state.getItemCount() + (-1) ? this.mMarginStartEnd : 0;
        int i = this.mMarginTopBottom;
        rect.top = i;
        rect.bottom = i;
    }

    public CoverItemDecoration(int i, int i2) {
        this.mMarginStartEnd = i;
        this.mMarginTopBottom = i2;
    }
}
