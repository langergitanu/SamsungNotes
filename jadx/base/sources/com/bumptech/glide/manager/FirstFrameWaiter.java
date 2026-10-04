package com.bumptech.glide.manager;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(26)
final class FirstFrameWaiter implements FrameWaiter {
    volatile boolean isFirstFrameSet;
    final Set<Activity> pendingActivities = Collections.newSetFromMap(new WeakHashMap());

    public static void removeListener(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }

    @Override // com.bumptech.glide.manager.FrameWaiter
    public void registerSelf(Activity activity) {
        if (!this.isFirstFrameSet && this.pendingActivities.add(activity)) {
            final View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: com.bumptech.glide.manager.FirstFrameWaiter.1
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    Util.postOnUiThread(new Runnable() { // from class: com.bumptech.glide.manager.FirstFrameWaiter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HardwareConfigState.getInstance().unblockHardwareBitmaps();
                            FirstFrameWaiter.this.isFirstFrameSet = true;
                            FirstFrameWaiter.removeListener(decorView, this);
                            FirstFrameWaiter.this.pendingActivities.clear();
                        }
                    });
                }
            });
        }
    }
}
