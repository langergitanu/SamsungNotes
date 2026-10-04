package com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action;

import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FlingAction {
    private ActionModel mActionModel;

    public FlingAction(ActionModel actionModel) {
        this.mActionModel = actionModel;
    }

    public Rect getFlingArea() {
        RectF imageRect = this.mActionModel.getImageRect();
        RectF cropRect = this.mActionModel.getCropRect();
        return new Rect(Math.round(cropRect.right - imageRect.right), Math.round(cropRect.bottom - imageRect.bottom), Math.round(cropRect.left - imageRect.left), Math.round(cropRect.top - imageRect.top));
    }

    public void onFling(float f, float f4, float f5, float f6) {
        RectF imageRect = this.mActionModel.getImageRect();
        RectF cropRect = this.mActionModel.getCropRect();
        float f7 = imageRect.right;
        float f8 = (f7 - f5) + f;
        float f9 = cropRect.right;
        if (f8 < f9) {
            f = (f9 - f7) + f5;
        }
        float f10 = imageRect.left;
        float f11 = (f10 - f5) + f;
        float f12 = cropRect.left;
        if (f11 > f12) {
            f = (f12 - f10) + f5;
        }
        float f13 = imageRect.bottom;
        float f14 = (f13 - f6) + f4;
        float f15 = cropRect.bottom;
        if (f14 < f15) {
            f4 = (f15 - f13) + f6;
        }
        float f16 = imageRect.top;
        float f17 = (f16 - f6) + f4;
        float f18 = cropRect.top;
        if (f17 > f18) {
            f4 = (f18 - f16) + f6;
        }
        this.mActionModel.postTranslate(f - f5, f4 - f6);
    }
}
