package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.p159vi;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.SpringAnimator;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ToggleDockingAnimation {
    private static final float DEFAULT_DAMPING_RATIO = 0.39f;
    private static final int DEFAULT_STIFFNESS = 400;
    protected static String TAG = Logger.createTag("ToggleDockingAnimation");
    private SpringAnimator scaleAnimator = new SpringAnimator(new SpringAnimator.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.vi.ToggleDockingAnimation.1
        @Override // com.samsung.android.support.senl.nt.base.winset.view.floater.SpringAnimator.Contract
        public void onAnimationEnd(boolean z) {
            ToggleDockingAnimation.this.resetView(z);
        }
    });
    private WeakReference<View> targetViewRef;

    public ToggleDockingAnimation(View view) {
        this.targetViewRef = new WeakReference<>(view);
    }

    private float getDockingSize(View view) {
        return view.getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_docking_toggle_btn_size);
    }

    private float getFloatingSize(View view) {
        return view.getResources().getDimension(C9086R.dimen.comp_hw_floating_menu_floating_toggle_btn_size);
    }

    private float getScaleFactor(float f, float f4) {
        return (1.0f / f) * f4;
    }

    private void scaleDown(@NonNull View view) {
        this.scaleAnimator.runScaleAnimation(view, getScaleFactor(getFloatingSize(view), getDockingSize(view)), 400.0f, DEFAULT_DAMPING_RATIO);
    }

    private void scaleUp(@NonNull View view) {
        this.scaleAnimator.runScaleAnimation(view, getScaleFactor(getDockingSize(view), getFloatingSize(view)), 400.0f, DEFAULT_DAMPING_RATIO);
    }

    public boolean resetView(boolean z) {
        View view = this.targetViewRef.get();
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (z) {
            int dockingSize = (int) getDockingSize(view);
            layoutParams.height = dockingSize;
            layoutParams.width = dockingSize;
        } else {
            int floatingSize = (int) getFloatingSize(view);
            layoutParams.height = floatingSize;
            layoutParams.width = floatingSize;
        }
        view.setLayoutParams(layoutParams);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.invalidate();
        return true;
    }

    public boolean update(boolean z) {
        View view = this.targetViewRef.get();
        if (view == null) {
            return false;
        }
        if (z) {
            scaleDown(view);
            return true;
        }
        scaleUp(view);
        return true;
    }
}
