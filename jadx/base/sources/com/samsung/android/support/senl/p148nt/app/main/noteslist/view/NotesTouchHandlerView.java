package com.samsung.android.support.senl.p148nt.app.main.noteslist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesTouchHandlerView extends CustomSwipeRefreshLayout {
    private Context mContext;
    private float mInitialX;
    private float mInitialY;
    private boolean mIsScrolling;
    private float mTouchSlop;

    public NotesTouchHandlerView(@NonNull Context context) {
        super(context);
        this.mTouchSlop = 10.0f;
        init(context);
    }

    private void hideSoftInput() {
        InputMethodCompat.getInstance().hideSoftInput(this.mContext, this);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean isShownInput(View view) {
        return !FeatureUtils.isEnabledDeltaDA() && InputMethodCompat.getInstance().isInputMethodShown(this.mContext, view, InputMethodCompat.getInstance().isEnabledMobileKeyboard(this.mContext));
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isShownInput(this)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mInitialX = motionEvent.getX();
            this.mInitialY = motionEvent.getY();
            this.mIsScrolling = false;
        } else if (actionMasked == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.mInitialX);
            float fAbs2 = Math.abs(motionEvent.getY() - this.mInitialY);
            if (fAbs2 > this.mTouchSlop && fAbs2 > fAbs && this.mInitialX != -1.0f && this.mInitialY != -1.0f) {
                this.mIsScrolling = true;
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mIsScrolling || !isShownInput(this)) {
            return super.onTouchEvent(motionEvent);
        }
        hideSoftInput();
        this.mIsScrolling = false;
        this.mInitialX = -1.0f;
        this.mInitialY = -1.0f;
        return true;
    }

    public NotesTouchHandlerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = 10.0f;
        init(context);
    }

    public NotesTouchHandlerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mTouchSlop = 10.0f;
        init(context);
    }

    public NotesTouchHandlerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.mTouchSlop = 10.0f;
        init(context);
    }
}
