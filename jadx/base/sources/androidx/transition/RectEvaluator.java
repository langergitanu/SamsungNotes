package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - r0) * f));
        int i2 = rect.top + ((int) ((rect2.top - r1) * f));
        int i4 = rect.right + ((int) ((rect2.right - r2) * f));
        int i5 = rect.bottom + ((int) ((rect2.bottom - r6) * f));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i, i2, i4, i5);
        }
        rect3.set(i, i2, i4, i5);
        return this.mRect;
    }
}
