package androidx.core.widget;

import android.R;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.core.widget.SeslGoToTopController;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class SeslNestedGoToTopController extends SeslGoToTopController {
    private static final int MOTION_EVENT_ACTION_PEN_DOWN = 211;
    private static final int MOTION_EVENT_ACTION_PEN_MOVE = 213;
    private static final int MOTION_EVENT_ACTION_PEN_UP = 212;
    private static final int NSV_AUTO_HIDE_DELAY_MS = 2500;
    private static final String TAG = "SeslNestedGoToTopController";
    private boolean mIsSupportGoToTop;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder extends SeslGoToTopControllerBuilder<SeslNestedGoToTopController, Builder> {
        @Override // androidx.core.widget.SeslGoToTopControllerBuilder
        public SeslNestedGoToTopController build() {
            validate();
            return new SeslNestedGoToTopController(this.host, this.config);
        }
    }

    public SeslNestedGoToTopController(@NonNull SeslGoToTopController.Host host, @NonNull SeslGoToTopConfig seslGoToTopConfig) {
        super(host, seslGoToTopConfig);
        this.mIsSupportGoToTop = false;
        this.mHost = host;
    }

    @Override // androidx.core.widget.SeslGoToTopController
    public int getAutoHideDelayMs() {
        return 2500;
    }

    public int getScrollToTopDurationMs() {
        return this.mConfig.getScrollToTopDurationMs();
    }

    @Override // androidx.core.widget.SeslGoToTopController
    public boolean isAvailable() {
        return Build.VERSION.SDK_INT >= 33 && isSupportGoToTop() && super.isAvailable();
    }

    public boolean isSupportGoToTop() {
        return this.mIsSupportGoToTop;
    }

    @Override // androidx.core.widget.SeslGoToTopController
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (isAvailable()) {
            int actionMasked = motionEvent.getActionMasked();
            int x = (int) (motionEvent.getX() + 0.5f);
            int y2 = (int) (motionEvent.getY() + 0.5f);
            if (actionMasked == 0) {
                setScrollRunning(false);
                if (this.mGoToTopView != null && getState() != 2 && this.mGoToTopRect.contains(x, y2)) {
                    applyState(2);
                    this.mGoToTopImage.setHotspot(x, y2);
                    this.mGoToTopImage.setState(new int[]{R.attr.state_pressed, R.attr.state_enabled, R.attr.state_selected});
                    return true;
                }
            } else if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3 && this.mGoToTopState != 0) {
                        this.mGoToTopImage.setState(StateSet.NOTHING);
                        return false;
                    }
                } else if (getState() == 2) {
                    if (!this.mGoToTopRect.contains(x, y2)) {
                        setState(1);
                        this.mGoToTopImage.setState(StateSet.NOTHING);
                        autoHide(1);
                        return true;
                    }
                    return true;
                }
            } else if (getState() == 2) {
                if (this.mHost.canScrollUp()) {
                    SeslGoToTopController.OnGoToTopClickListener onGoToTopClickListener = this.mOnClickListener;
                    if (onGoToTopClickListener == null || !onGoToTopClickListener.onGoToTopClick()) {
                        this.mHost.smoothScrollToTop();
                    }
                    return true;
                }
                setState(1);
                autoHide(1);
                this.mGoToTopImage.setState(StateSet.NOTHING);
                this.mHost.playSoundEffect(0);
                return true;
            }
        }
        return false;
    }

    public boolean onTouchPenEvent(@NonNull MotionEvent motionEvent) {
        if (!isAvailable()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int x = (int) (motionEvent.getX() + 0.5f);
        int y2 = (int) (motionEvent.getY() + 0.5f);
        switch (actionMasked) {
            case 211:
                if (this.mGoToTopState != 2 && this.mGoToTopRect.contains(x, y2)) {
                    applyState(2);
                    this.mGoToTopImage.setHotspot(x, y2);
                    this.mGoToTopImage.setState(new int[]{R.attr.state_pressed, R.attr.state_enabled, R.attr.state_selected});
                    return true;
                }
                return false;
            case 212:
                if (this.mGoToTopState == 2) {
                    Log.d(TAG, "pen up false GOTOTOP");
                    if (this.mHost.canScrollUp()) {
                        this.mHost.smoothScrollToTop();
                        this.mHost.showTopEdgeEffect();
                    }
                    applyState(0);
                    this.mGoToTopImage.setState(StateSet.NOTHING);
                    return true;
                }
                return false;
            case 213:
                if (this.mGoToTopState == 2 && !this.mGoToTopRect.contains(x, y2)) {
                    this.mGoToTopState = 1;
                    this.mGoToTopImage.setState(StateSet.NOTHING);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public void setSupportGoToTop(boolean z) {
        this.mIsSupportGoToTop = z;
    }
}
