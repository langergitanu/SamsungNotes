package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.component;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SOMRecognizedInfoTextView extends TextView {
    private static final String TAG = "SOMRecognizedInfoTextView";
    private GestureDetector mGestureDetector;
    private boolean mIsLongPressed;

    public SOMRecognizedInfoTextView(Context context) {
        super(context);
        this.mIsLongPressed = false;
        init(context);
    }

    private void init(Context context) {
        this.mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.component.SOMRecognizedInfoTextView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(@NonNull MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                SOMRecognizedInfoTextView.this.mIsLongPressed = true;
            }
        });
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Layout layout = getLayout();
        if (motionEvent == null || layout == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        CharSequence text = getText();
        if (!(text instanceof Spanned)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) motionEvent.getY()), motionEvent.getX());
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        boolean z = true;
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 212) {
            z = false;
        }
        if (clickableSpanArr.length <= 0 || this.mIsLongPressed || !z) {
            if (z) {
                this.mIsLongPressed = false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        clearFocus();
        clickableSpanArr[0].onClick(this);
        this.mIsLongPressed = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
    }

    public SOMRecognizedInfoTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsLongPressed = false;
        init(context);
    }

    public SOMRecognizedInfoTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsLongPressed = false;
        init(context);
    }
}
