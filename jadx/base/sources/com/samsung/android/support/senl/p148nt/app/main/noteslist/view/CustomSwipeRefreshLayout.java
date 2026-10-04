package com.samsung.android.support.senl.p148nt.app.main.noteslist.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    private Contract mContract;
    private final Runnable mFinishRefreshingRunnable;
    private final Handler mHandler;
    private boolean mIsSwipeEnabled;
    private int mRefreshDuration;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        boolean canChildScrollUp();

        boolean isPenMultiSelectionMode(MotionEvent motionEvent);

        boolean onSwipeRefresh();
    }

    public CustomSwipeRefreshLayout(@NonNull Context context) {
        super(context);
        this.mRefreshDuration = 3000;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mIsSwipeEnabled = false;
        this.mFinishRefreshingRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.CustomSwipeRefreshLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CustomSwipeRefreshLayout.this.setRefreshing(false);
            }
        };
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    public boolean canChildScrollUp() {
        Contract contract = this.mContract;
        return contract != null ? contract.canChildScrollUp() : super.canChildScrollUp();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Contract contract = this.mContract;
        if (contract != null && contract.isPenMultiSelectionMode(motionEvent)) {
            if (motionEvent.getAction() == 0 || motionEvent.getAction() == 211) {
                this.mIsSwipeEnabled = isEnabled();
                setSwipeRefreshLayoutEnabled(false);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 212 || motionEvent.getAction() == 214) {
                setSwipeRefreshLayoutEnabled(this.mIsSwipeEnabled);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void initView(Contract contract) {
        this.mContract = contract;
        setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.CustomSwipeRefreshLayout.2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (CustomSwipeRefreshLayout.this.mContract == null || !CustomSwipeRefreshLayout.this.mContract.onSwipeRefresh()) {
                    CustomSwipeRefreshLayout.this.setRefreshing(false);
                } else {
                    if (CustomSwipeRefreshLayout.this.mRefreshDuration == 0) {
                        return;
                    }
                    CustomSwipeRefreshLayout.this.mHandler.postDelayed(CustomSwipeRefreshLayout.this.mFinishRefreshingRunnable, CustomSwipeRefreshLayout.this.mRefreshDuration);
                }
            }
        });
    }

    public void setRefreshLayoutDuration(int i) {
        this.mRefreshDuration = i;
    }

    public void setSwipeRefreshLayoutEnabled(boolean z) {
        setRefreshing(false);
        setEnabled(z);
    }

    public void stopSwipeRefreshLayout() {
        this.mHandler.postDelayed(this.mFinishRefreshingRunnable, 0L);
    }

    public CustomSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshDuration = 3000;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mIsSwipeEnabled = false;
        this.mFinishRefreshingRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.CustomSwipeRefreshLayout.1
            @Override // java.lang.Runnable
            public void run() {
                CustomSwipeRefreshLayout.this.setRefreshing(false);
            }
        };
    }
}
