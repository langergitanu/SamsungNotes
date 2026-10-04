package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int distance(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = this.mSide;
        if (i10 == 8388611) {
            i10 = view.getLayoutDirection() == 1 ? 5 : 3;
        } else if (i10 == 8388613) {
            if (view.getLayoutDirection() == 1) {
            }
        }
        if (i10 == 3) {
            return Math.abs(i5 - i2) + (i8 - i);
        }
        if (i10 == 5) {
            return Math.abs(i5 - i2) + (i - i6);
        }
        if (i10 == 48) {
            return Math.abs(i4 - i) + (i9 - i2);
        }
        if (i10 != 80) {
            return 0;
        }
        return Math.abs(i4 - i) + (i2 - i7);
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i = this.mSide;
        return (i == 3 || i == 5 || i == 8388611 || i == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i;
        int i2;
        int iCenterY;
        int i4;
        ViewGroup viewGroup2;
        int i5;
        int i6;
        int i7;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i = -1;
        } else {
            transitionValues3 = transitionValues2;
            i = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = Math.round(viewGroup.getTranslationX()) + iArr[0];
        int iRound2 = Math.round(viewGroup.getTranslationY()) + iArr[1];
        int width = viewGroup.getWidth() + iRound;
        int height = viewGroup.getHeight() + iRound2;
        if (epicenter != null) {
            int iCenterX = epicenter.centerX();
            i4 = viewY;
            viewGroup2 = viewGroup;
            i5 = iRound2;
            i6 = iRound;
            i7 = height;
            iCenterY = epicenter.centerY();
            i2 = iCenterX;
        } else {
            i2 = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
            i4 = viewY;
            viewGroup2 = viewGroup;
            i5 = iRound2;
            i6 = iRound;
            i7 = height;
        }
        float fDistance = distance(viewGroup2, viewX, i4, i2, iCenterY, i6, i5, width, i7) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * ((long) i)) / this.mPropagationSpeed) * fDistance);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f;
    }

    public void setSide(int i) {
        this.mSide = i;
    }
}
