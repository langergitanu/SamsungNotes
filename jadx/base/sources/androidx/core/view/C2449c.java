package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.DifferentialMotionFlingController;

/* JADX INFO: renamed from: androidx.core.view.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2449c implements DifferentialMotionFlingController.FlingVelocityThresholdCalculator, DifferentialMotionFlingController.DifferentialVelocityProvider {
    @Override // androidx.core.view.DifferentialMotionFlingController.FlingVelocityThresholdCalculator
    public void calculateFlingVelocityThresholds(Context context, int[] iArr, MotionEvent motionEvent, int i) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(context, iArr, motionEvent, i);
    }

    @Override // androidx.core.view.DifferentialMotionFlingController.DifferentialVelocityProvider
    public float getCurrentVelocity(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
        return DifferentialMotionFlingController.getCurrentVelocity(velocityTracker, motionEvent, i);
    }
}
