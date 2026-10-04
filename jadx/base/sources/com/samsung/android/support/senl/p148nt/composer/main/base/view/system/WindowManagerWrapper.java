package com.samsung.android.support.senl.p148nt.composer.main.base.view.system;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerWrapper {
    private Callback mCallback;
    private DeviceStateChangeCallback mDeviceChangeCallback;
    private WindowInfoTrackerCallbackAdapter mWindowInfoTracker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onChangedDeviceState(FoldingFeature foldingFeature);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DeviceStateChangeCallback implements Consumer<WindowLayoutInfo> {
        public /* synthetic */ DeviceStateChangeCallback(WindowManagerWrapper windowManagerWrapper, int i) {
            this();
        }

        private DeviceStateChangeCallback() {
        }

        @Override // androidx.core.util.Consumer
        public void accept(WindowLayoutInfo windowLayoutInfo) {
            for (DisplayFeature displayFeature : windowLayoutInfo.getDisplayFeatures()) {
                if (displayFeature instanceof FoldingFeature) {
                    WindowManagerWrapper.this.mCallback.onChangedDeviceState((FoldingFeature) displayFeature);
                }
            }
        }
    }

    public WindowManagerWrapper(Activity activity, Callback callback) {
        this.mWindowInfoTracker = null;
        if (FoldStateCompat.getInstance().isFoldableDevice()) {
            this.mCallback = callback;
            this.mDeviceChangeCallback = new DeviceStateChangeCallback(this, 0);
            WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter = new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.getOrCreate(activity));
            this.mWindowInfoTracker = windowInfoTrackerCallbackAdapter;
            windowInfoTrackerCallbackAdapter.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(activity), this.mDeviceChangeCallback);
        }
    }

    public void release() {
        WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter = this.mWindowInfoTracker;
        if (windowInfoTrackerCallbackAdapter == null) {
            return;
        }
        windowInfoTrackerCallbackAdapter.removeWindowLayoutInfoListener(this.mDeviceChangeCallback);
        this.mWindowInfoTracker = null;
        this.mDeviceChangeCallback = null;
    }
}
