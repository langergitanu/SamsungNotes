package com.samsung.android.support.senl.p148nt.app.main.tablet;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class InterceptTouchLayout extends FrameLayout {
    private static final String TAG = "InterceptTouchLayout";
    private int MAX_DRAG_WIDTH;
    private boolean mDoNotHandleEvent;
    private final Rect mDrawerViewRect;
    private OnInterceptTouchListener mInterceptTouchListener;
    private int mMainViewMode;
    private Mode mMode;
    private int mPrevTouchAction;
    private NotesPenRecyclerView mRecyclerView;
    private final Rect mRecyclerViewRect;
    private float mTouchDownX;
    private float mTouchDownY;
    private int mTouchSlop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Mode {
        COLLAPSE,
        EXPAND
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnInterceptTouchListener {
        void down();

        void move(float f);

        /* JADX INFO: renamed from: up */
        void mo7449up(int i);
    }

    public InterceptTouchLayout(Context context) {
        super(context);
        this.MAX_DRAG_WIDTH = 0;
        this.mMode = Mode.COLLAPSE;
        this.mMainViewMode = 1;
        this.mPrevTouchAction = 0;
        this.mDrawerViewRect = new Rect();
        this.mRecyclerViewRect = new Rect();
    }

    private boolean doNotHandleEvent() {
        return FeatureUtils.isDrawerInvisibleMode(this.mMainViewMode);
    }

    private void initConfiguration() {
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
        AbstractC8014b.m7212n(new StringBuilder("initConfiguration# mTouchSlop : "), TAG, this.mTouchSlop);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        NotesPenRecyclerView notesPenRecyclerView;
        if (motionEvent.getActionMasked() == 2 && (notesPenRecyclerView = this.mRecyclerView) != null && notesPenRecyclerView.isLongPressed() && this.mDrawerViewRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        initConfiguration();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 211) {
            boolean zDoNotHandleEvent = doNotHandleEvent();
            this.mDoNotHandleEvent = zDoNotHandleEvent;
            if (!zDoNotHandleEvent) {
                if (this.mRecyclerView == null) {
                    this.mRecyclerView = (NotesPenRecyclerView) findViewById(C8003R.id.noteslist_recyclerview);
                }
                this.mRecyclerView.getGlobalVisibleRect(this.mRecyclerViewRect);
                int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(this.mRecyclerView.getContext(), 12.0f);
                if (!LocaleUtils.isRTLMode()) {
                    iConvertDpToPixel *= -1;
                }
                this.mDoNotHandleEvent = this.mRecyclerViewRect.contains(((int) x) + iConvertDpToPixel, (int) y2);
            }
        }
        if (this.mDoNotHandleEvent) {
            if (motionEvent.getActionMasked() != 2 && motionEvent.getActionMasked() != 213) {
                MainLogger.m7258i(TAG, "onInterceptTouchEvent# mDoNotHandleEvent!!! getActionMasked : " + motionEvent.getActionMasked());
            }
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float f = x - this.mTouchDownX;
                    float f4 = y2 - this.mTouchDownY;
                    if (!LocaleUtils.isRTLMode() ? !(this.mMode != Mode.EXPAND || f >= 0.0f) : !(this.mMode != Mode.COLLAPSE || f >= 0.0f)) {
                        f *= -1.0f;
                    }
                    if (this.mMode == Mode.EXPAND && f4 < 0.0f) {
                        f4 *= -1.0f;
                    }
                    int i = this.mTouchSlop;
                    if (f > i && f4 < i) {
                        MainLogger.m7254d(TAG, "onInterceptTouchEvent# INTERCEPT!!!!");
                        return true;
                    }
                } else if (actionMasked != 3) {
                    switch (actionMasked) {
                        case 211:
                            break;
                        case 212:
                            break;
                        case 213:
                        default:
                            return false;
                    }
                }
                return false;
            }
            this.mTouchDownX = 0.0f;
            this.mTouchDownY = 0.0f;
            this.mDoNotHandleEvent = false;
            this.mDrawerViewRect.setEmpty();
            this.mRecyclerViewRect.setEmpty();
            return false;
        }
        this.mTouchDownX = x;
        this.mTouchDownY = y2;
        this.mPrevTouchAction = 0;
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (FeatureUtils.isDrawerInvisibleMode(this.mMainViewMode) || this.mInterceptTouchListener == null) {
            MainLogger.m7255e(TAG, "onTouchEvent# isDrawerInvisibleMode or mInterceptTouchListener is null");
            return false;
        }
        float x = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (this.mDoNotHandleEvent) {
            MainLogger.m7258i(TAG, "onTouchEvent# mDoNotHandleEvent!!!");
            return false;
        }
        float fMax = LocaleUtils.isRTLMode() ? this.mMode == Mode.EXPAND ? Math.max(0.0f, this.MAX_DRAG_WIDTH - Math.max(0.0f, x - this.mTouchDownX)) : Math.max(0.0f, Math.min(this.MAX_DRAG_WIDTH, this.mTouchDownX - x)) : this.mMode == Mode.EXPAND ? Math.max(0.0f, this.MAX_DRAG_WIDTH - Math.max(0.0f, this.mTouchDownX - x)) : Math.max(0.0f, Math.min(this.MAX_DRAG_WIDTH, x - this.mTouchDownX));
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mTouchDownX = x;
            this.mTouchDownY = y2;
            if (this.MAX_DRAG_WIDTH != fMax || this.mMode != Mode.EXPAND) {
                this.mInterceptTouchListener.down();
            }
        } else if (actionMasked == 1) {
            this.mInterceptTouchListener.mo7449up((int) fMax);
            MainLogger.m7254d(TAG, "onTouchEvent# up dragLength : " + fMax + ", mode : " + this.mMode);
            this.mTouchDownX = 0.0f;
            this.mTouchDownY = 0.0f;
            this.mPrevTouchAction = 2;
        } else if (actionMasked == 2) {
            if (this.mPrevTouchAction == 0) {
                this.mInterceptTouchListener.down();
                this.mPrevTouchAction = 2;
            }
            this.mInterceptTouchListener.move(fMax);
        } else if (actionMasked != 3) {
            switch (actionMasked) {
            }
        }
        return true;
    }

    public void setDrawerMaxWidth(int i, int i2) {
        this.MAX_DRAG_WIDTH = i - i2;
    }

    public void setMainViewMode(int i) {
        this.mMainViewMode = i;
    }

    public void setMode(Mode mode) {
        this.mMode = mode;
        MainLogger.m7258i(TAG, "setMode : " + mode);
    }

    public void setOnInterceptTouchListener(OnInterceptTouchListener onInterceptTouchListener) {
        this.mInterceptTouchListener = onInterceptTouchListener;
    }

    public InterceptTouchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MAX_DRAG_WIDTH = 0;
        this.mMode = Mode.COLLAPSE;
        this.mMainViewMode = 1;
        this.mPrevTouchAction = 0;
        this.mDrawerViewRect = new Rect();
        this.mRecyclerViewRect = new Rect();
    }

    public InterceptTouchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MAX_DRAG_WIDTH = 0;
        this.mMode = Mode.COLLAPSE;
        this.mMainViewMode = 1;
        this.mPrevTouchAction = 0;
        this.mDrawerViewRect = new Rect();
        this.mRecyclerViewRect = new Rect();
    }
}
