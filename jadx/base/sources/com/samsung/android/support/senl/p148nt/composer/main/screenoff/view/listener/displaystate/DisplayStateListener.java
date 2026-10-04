package com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.listener.displaystate;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/displaystate/DisplayStateListener;", "", "<init>", "()V", "mDisplayManager", "Landroid/hardware/display/DisplayManager;", "mDisplayListener", "Landroid/hardware/display/DisplayManager$DisplayListener;", "mDisplayState", "", "mIDisplayStateListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/listener/displaystate/IDisplayStateListener;", "registerListener", "", "context", "Landroid/content/Context;", "displayStateListener", "unregisterListener", "isMainDisplay", "", "display", "Landroid/view/Display;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DisplayStateListener {

    @NotNull
    private static final String TAG = SOLogger.createTag("DisplayStateListener");

    @Nullable
    private DisplayManager.DisplayListener mDisplayListener;

    @Nullable
    private DisplayManager mDisplayManager;
    private int mDisplayState;

    @Nullable
    private IDisplayStateListener mIDisplayStateListener;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMainDisplay(Display display) {
        Rect mainScreenSize = DisplayUtils.getMainScreenSize();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        return mainScreenSize.width() == displayMetrics.widthPixels && mainScreenSize.height() == displayMetrics.heightPixels;
    }

    public final void registerListener(@NotNull Context context, @Nullable IDisplayStateListener displayStateListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        SOLogger.INSTANCE.SOLoggerD(TAG, "registerListener#");
        this.mIDisplayStateListener = displayStateListener;
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        this.mDisplayManager = (DisplayManager) systemService;
        DisplayManager.DisplayListener displayListener = new DisplayManager.DisplayListener() { // from class: com.samsung.android.support.senl.nt.composer.main.screenoff.view.listener.displaystate.DisplayStateListener.registerListener.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                DisplayManager displayManager;
                Display display;
                if (DisplayStateListener.this.mDisplayManager == null || (displayManager = DisplayStateListener.this.mDisplayManager) == null || (display = displayManager.getDisplay(displayId)) == null) {
                    return;
                }
                SOLogger sOLogger = SOLogger.INSTANCE;
                sOLogger.SOLoggerD(DisplayStateListener.TAG, AbstractC1038a.m1214o(displayId, display.getState(), "onDisplayChanged# displayId/state ", "/"));
                int state = display.getState();
                if (state == DisplayStateListener.this.mDisplayState || !DisplayStateListener.this.isMainDisplay(display)) {
                    return;
                }
                sOLogger.SOLoggerD(DisplayStateListener.TAG, AbstractC1038a.m1214o(DisplayStateListener.this.mDisplayState, state, "onDisplayChanged# before/after : ", "/"));
                DisplayStateListener.this.mDisplayState = state;
                IDisplayStateListener iDisplayStateListener = DisplayStateListener.this.mIDisplayStateListener;
                if (iDisplayStateListener != null) {
                    iDisplayStateListener.onDisplayStateChanged(DisplayStateListener.this.mDisplayState);
                }
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
            }
        };
        this.mDisplayListener = displayListener;
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null) {
            displayManager.registerDisplayListener(displayListener, null);
        }
    }

    public final void unregisterListener() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "unregisterListener#");
        DisplayManager displayManager = this.mDisplayManager;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayListener);
        }
        this.mDisplayManager = null;
        this.mDisplayListener = null;
    }
}
