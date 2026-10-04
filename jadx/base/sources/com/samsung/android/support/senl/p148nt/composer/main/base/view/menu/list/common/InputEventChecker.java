package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.common;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InputEventChecker implements View.OnTouchListener {
    private PointF mPosition = new PointF();
    private int mToolType;

    public PointF getPosition() {
        return this.mPosition;
    }

    public int getToolType() {
        return this.mToolType;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mToolType = motionEvent.getToolType(0);
            this.mPosition.set(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
