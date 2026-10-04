package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.main.common.adapter.AdapterContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GridRatioView extends FrameLayout {
    private AdapterContract mAdapterContract;
    private boolean mHasGlobalLayoutListener;
    private Listener mListener;
    private final float mRatio;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        void onError(String str);

        void requestLayout();
    }

    public GridRatioView(Context context) {
        super(context);
        this.mRatio = 1.0f;
    }

    private void setGlobalLayoutListener() {
        if (this.mHasGlobalLayoutListener) {
            return;
        }
        this.mHasGlobalLayoutListener = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.GridRatioView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!GridRatioView.this.mAdapterContract.isRunningAnimator()) {
                    GridRatioView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    GridRatioView.this.mHasGlobalLayoutListener = false;
                }
                GridRatioView.this.requestLayout();
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        AdapterContract adapterContract = this.mAdapterContract;
        if (adapterContract != null && adapterContract.isRunningAnimator()) {
            setGlobalLayoutListener();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * 1.0f), 1073741824);
        setClipToOutline(true);
        try {
            try {
                super.onMeasure(i, iMakeMeasureSpec);
            } finally {
                Listener listener = this.mListener;
                if (listener != null) {
                    listener.requestLayout();
                }
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            Listener listener2 = this.mListener;
            if (listener2 != null) {
                listener2.onError(e.getMessage());
            }
            throw e;
        }
    }

    public void setAdapterContract(AdapterContract adapterContract) {
        this.mAdapterContract = adapterContract;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public GridRatioView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRatio = 1.0f;
    }

    public GridRatioView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 1.0f;
    }
}
