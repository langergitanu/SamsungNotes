package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action;

import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PanningAction {
    private ActionModel mActionModel;
    private float mBeforeDeltaX;
    private float mBeforeDeltaY;
    private float mDownTouchX;
    private float mDownTouchY;

    public PanningAction(ActionModel actionModel) {
        this.mActionModel = actionModel;
    }

    private float getFixedDragTransX(float f) {
        RectF cropRect = this.mActionModel.getCropRect();
        RectF imageRect = this.mActionModel.getImageRect();
        float f4 = imageRect.right;
        float f5 = this.mBeforeDeltaX;
        float f6 = (f4 - f5) + f;
        float f7 = cropRect.right;
        if (f6 < f7) {
            f = (f7 - f4) + f5;
        }
        float f8 = imageRect.left;
        float f9 = (f8 - f5) + f;
        float f10 = cropRect.left;
        return f9 > f10 ? (f10 - f8) + f5 : f;
    }

    private float getFixedDragTransY(float f) {
        RectF cropRect = this.mActionModel.getCropRect();
        RectF imageRect = this.mActionModel.getImageRect();
        float f4 = imageRect.bottom;
        float f5 = this.mBeforeDeltaY;
        float f6 = (f4 - f5) + f;
        float f7 = cropRect.bottom;
        if (f6 < f7) {
            f = (f7 - f4) + f5;
        }
        float f8 = imageRect.top;
        float f9 = (f8 - f5) + f;
        float f10 = cropRect.top;
        return f9 > f10 ? (f10 - f8) + f5 : f;
    }

    public void onActionDown(float f, float f4) {
        this.mDownTouchX = f;
        this.mDownTouchY = f4;
        this.mBeforeDeltaX = 0.0f;
        this.mBeforeDeltaY = 0.0f;
    }

    public void onActionMove(float f, float f4) {
        float fixedDragTransX = getFixedDragTransX(f - this.mDownTouchX);
        float fixedDragTransY = getFixedDragTransY(f4 - this.mDownTouchY);
        this.mActionModel.postTranslate(fixedDragTransX - this.mBeforeDeltaX, fixedDragTransY - this.mBeforeDeltaY);
        this.mBeforeDeltaX = fixedDragTransX;
        this.mBeforeDeltaY = fixedDragTransY;
    }
}
