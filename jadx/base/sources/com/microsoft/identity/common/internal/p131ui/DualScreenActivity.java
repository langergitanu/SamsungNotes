package com.microsoft.identity.common.internal.p131ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.device.display.DisplayMask;
import com.microsoft.identity.common.C6228R;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class DualScreenActivity extends FragmentActivity {
    private void adjustLayoutForDualScreenActivity() {
        int rotation = getRotation(this);
        boolean zIsAppSpanned = isAppSpanned(this);
        boolean z = rotation == 0 || rotation == 2;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.connect(C6228R.id.dual_screen_content, 1, C6228R.id.dual_screen_layout, 1, 0);
        constraintSet.connect(C6228R.id.dual_screen_content, 2, C6228R.id.dual_screen_layout, 2, 0);
        constraintSet.connect(C6228R.id.dual_screen_content, 3, C6228R.id.dual_screen_layout, 3, 0);
        constraintSet.connect(C6228R.id.dual_screen_content, 4, C6228R.id.dual_screen_layout, 4, 0);
        constraintSet.connect(C6228R.id.dual_screen_empty_view, 1, C6228R.id.dual_screen_layout, 1, 0);
        constraintSet.connect(C6228R.id.dual_screen_empty_view, 2, C6228R.id.dual_screen_layout, 2, 0);
        constraintSet.connect(C6228R.id.dual_screen_empty_view, 3, C6228R.id.dual_screen_layout, 3, 0);
        constraintSet.connect(C6228R.id.dual_screen_empty_view, 4, C6228R.id.dual_screen_layout, 4, 0);
        getWindow().setSoftInputMode(16);
        if (!zIsAppSpanned) {
            constraintSet.clear(C6228R.id.dual_screen_empty_view);
        } else if (z) {
            constraintSet.connect(C6228R.id.dual_screen_content, 1, C6228R.id.vertical_guideline, 2, getHinge(this, rotation).width() / 2);
            constraintSet.connect(C6228R.id.dual_screen_empty_view, 2, C6228R.id.vertical_guideline, 1, 0);
        } else {
            constraintSet.connect(C6228R.id.dual_screen_content, 4, C6228R.id.horizontal_guideline, 3, getHinge(this, rotation).height() / 2);
            constraintSet.connect(C6228R.id.dual_screen_empty_view, 3, C6228R.id.horizontal_guideline, 4, 0);
            getWindow().setSoftInputMode(48);
        }
        ((ConstraintLayout) findViewById(C6228R.id.dual_screen_layout)).setConstraintSet(constraintSet);
    }

    private Rect getHinge(Context context, int i) {
        List boundingRectsForRotation = DisplayMask.fromResourcesRect(context).getBoundingRectsForRotation(i);
        return boundingRectsForRotation.size() == 0 ? new Rect(0, 0, 0, 0) : (Rect) boundingRectsForRotation.get(0);
    }

    private Rect getWindowRect(Activity activity) {
        Rect rect = new Rect();
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        return rect;
    }

    private void initializeContentView() {
        super.setContentView(C6228R.layout.dual_screen_layout);
        adjustLayoutForDualScreenActivity();
    }

    private boolean isDualScreenDevice(Context context) {
        return context.getPackageManager().hasSystemFeature("com.microsoft.device.display.displaymask");
    }

    public int getRotation(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getRotation();
        }
        return 0;
    }

    public boolean isAppSpanned(Activity activity) {
        if (!isDualScreenDevice(activity)) {
            return false;
        }
        Rect hinge = getHinge(activity, getRotation(activity));
        Rect windowRect = getWindowRect(activity);
        if (windowRect.width() <= 0 || windowRect.height() <= 0) {
            return false;
        }
        return hinge.intersect(windowRect);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        adjustLayoutForDualScreenActivity();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initializeContentView();
        LayoutInflater.from(this).inflate(i, (RelativeLayout) findViewById(C6228R.id.dual_screen_content));
    }

    public void setFragment(@NonNull Fragment fragment) {
        initializeContentView();
        getSupportFragmentManager().beginTransaction().setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE).replace(C6228R.id.dual_screen_content, fragment).commit();
    }
}
