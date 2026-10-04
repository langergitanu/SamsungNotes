package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomWebView extends WebView {
    private GestureDetector mGestureDetector;
    GestureDetector.OnGestureListener mGestureListener;
    private OnSingleTapUpListener mOnSingleTapUpListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSingleTapUpListener {
        void onSingleTapUp();
    }

    public CustomWebView(Context context) {
        super(context);
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.CustomWebView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (CustomWebView.this.mOnSingleTapUpListener == null) {
                    return true;
                }
                CustomWebView.this.mOnSingleTapUpListener.onSingleTapUp();
                return true;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        stopLoading();
        getSettings().setJavaScriptEnabled(false);
        clearHistory();
        removeAllViews();
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setOnSingleTapUpListener(OnSingleTapUpListener onSingleTapUpListener) {
        this.mOnSingleTapUpListener = onSingleTapUpListener;
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.CustomWebView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (CustomWebView.this.mOnSingleTapUpListener == null) {
                    return true;
                }
                CustomWebView.this.mOnSingleTapUpListener.onSingleTapUp();
                return true;
            }
        };
        init(context);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.CustomWebView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (CustomWebView.this.mOnSingleTapUpListener == null) {
                    return true;
                }
                CustomWebView.this.mOnSingleTapUpListener.onSingleTapUp();
                return true;
            }
        };
        init(context);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mGestureListener = new GestureDetector.OnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.external.scrapbook.CustomWebView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f4) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (CustomWebView.this.mOnSingleTapUpListener == null) {
                    return true;
                }
                CustomWebView.this.mOnSingleTapUpListener.onSingleTapUp();
                return true;
            }
        };
        init(context);
    }
}
