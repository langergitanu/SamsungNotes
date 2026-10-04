package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.graphics.RectF;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandwritingUtil {
    public static RectF getObjectsRect(List<SpenObjectBase> list) {
        RectF rectF = new RectF(list.get(0).getDrawnRect());
        int size = list.size();
        for (int i = 1; i < size; i++) {
            RectF drawnRect = list.get(i).getDrawnRect();
            if (drawnRect != null) {
                updateBoundPosition(rectF, drawnRect);
            }
        }
        return rectF;
    }

    public static void updateBoundPosition(RectF rectF, RectF rectF2) {
        float f = rectF2.left;
        if (f < rectF.left) {
            rectF.left = f;
        }
        float f4 = rectF2.right;
        if (f4 > rectF.right) {
            rectF.right = f4;
        }
        float f5 = rectF2.top;
        if (f5 < rectF.top) {
            rectF.top = f5;
        }
        float f6 = rectF2.bottom;
        if (f6 > rectF.bottom) {
            rectF.bottom = f6;
        }
    }
}
