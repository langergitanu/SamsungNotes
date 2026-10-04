package com.samsung.android.support.senl.p148nt.app.common.penrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerViewContract;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerViewModel;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PenRecyclerView extends BasePenRecyclerView implements PenRecyclerViewContract.PenRecyclerView {
    protected int mLayoutMode;
    protected PenRecyclerViewModel mViewModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LongPressMultiSelectionListener implements RecyclerView.SeslLongPressMultiSelectionListener {
        protected final ArrayList<Integer> selectedItemPositionList = new ArrayList<>();

        @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
        public void onItemSelected(RecyclerView recyclerView, View view, int i, long j) {
            if (this.selectedItemPositionList.contains(Integer.valueOf(i))) {
                this.selectedItemPositionList.remove(Integer.valueOf(i));
            } else {
                this.selectedItemPositionList.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
        public void onLongPressMultiSelectionEnded(int i, int i2) {
            this.selectedItemPositionList.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SeslLongPressMultiSelectionListener
        public void onLongPressMultiSelectionStarted(int i, int i2) {
            this.selectedItemPositionList.clear();
        }
    }

    public PenRecyclerView(Context context) {
        super(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView
    public BasePenRecyclerViewModel createViewModel() {
        PenRecyclerViewModel penRecyclerViewModel = new PenRecyclerViewModel(this);
        this.mViewModel = penRecyclerViewModel;
        return penRecyclerViewModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView, com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.IBasePenRecyclerView
    public int getGapStrategy() {
        if (NotesUtils.isStaggeredGridLayout(getLayoutMode())) {
            return ((StaggeredGridLayoutManager) getLayoutManager()).getGapStrategy();
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getLayoutMode() {
        return this.mLayoutMode;
    }

    public OnLongPressMultiSelectionListener getOnLongPressMultiSelectionListener() {
        return this.mViewModel.getOnLongPressMultiSelectionListener();
    }

    @Override // com.samsung.android.support.senl.nt.app.common.penrecyclerview.PenRecyclerViewContract.PenRecyclerView
    public boolean isLongPressed() {
        return this.mViewModel.isLongPressed();
    }

    public boolean isPenMultiSelectionMode(MotionEvent motionEvent) {
        return this.mViewModel.isPenMultiSelectionMode(motionEvent);
    }

    public boolean isPenMultiSelectionOn() {
        return this.mViewModel.getIsPenMultiSelectionOn();
    }

    public void removeOnLongPressMultiSelectionListener() {
        this.mViewModel.removeOnLongPressMultiSelectionListener();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.BasePenRecyclerView, com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview.IBasePenRecyclerView
    public void setGapStrategy(int i) {
        if (NotesUtils.isStaggeredGridLayout(getLayoutMode())) {
            ((StaggeredGridLayoutManager) getLayoutManager()).setGapStrategy(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (layoutManager instanceof LinearLayoutManager) {
            this.mLayoutMode = 1;
            return;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            this.mLayoutMode = 2;
        } else if (layoutManager instanceof GridLayoutManager) {
            this.mLayoutMode = 4;
        } else {
            this.mLayoutMode = 0;
        }
    }

    public void setLongPressed(boolean z) {
        this.mViewModel.setLongPressed(z);
    }

    public void setOnLongPressMultiSelectionListener(OnLongPressMultiSelectionListener onLongPressMultiSelectionListener) {
        this.mViewModel.setOnLongPressMultiSelectionListener(onLongPressMultiSelectionListener);
        seslSetLongPressMultiSelectionListener((RecyclerView.SeslLongPressMultiSelectionListener) onLongPressMultiSelectionListener);
    }

    public void startLongPressMultiSelection() {
        setLongPressed(true);
        seslStartLongPressMultiSelection();
    }

    public PenRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PenRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLayoutManager(RecyclerView.LayoutManager layoutManager, int i) {
        super.setLayoutManager(layoutManager);
        this.mLayoutMode = i;
    }
}
