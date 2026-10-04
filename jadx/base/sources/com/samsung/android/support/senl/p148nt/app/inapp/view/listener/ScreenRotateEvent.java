package com.samsung.android.support.senl.p148nt.app.inapp.view.listener;

import android.content.Context;
import android.view.OrientationEventListener;
import com.samsung.android.support.senl.p148nt.base.common.inapp.common.InAppLogger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/listener/ScreenRotateEvent;", "Landroid/view/OrientationEventListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mOrientation", "", "mScreenRotateListener", "Lcom/samsung/android/support/senl/nt/app/inapp/view/listener/ScreenRotateEvent$ScreenRotateListener;", "setOrientationListener", "", "screenRotateListener", "onResume", "onPause", "onOrientationChanged", "orientation", "changeToPortrait", "changeToLandscape", "surfaceType", ScreenRotateEvent.TAG, "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenRotateEvent extends OrientationEventListener {
    private static final int ORIENTATION_MARGIN = 45;

    @NotNull
    private static final String TAG = "ScreenRotateListener";
    private int mOrientation;

    @Nullable
    private ScreenRotateListener mScreenRotateListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/inapp/view/listener/ScreenRotateEvent$ScreenRotateListener;", "", "onOrientationChanged", "", "orientation", "", "surfaceType", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ScreenRotateListener {
        void onOrientationChanged(int orientation, int surfaceType);
    }

    public ScreenRotateEvent(@Nullable Context context) {
        super(context);
        this.mOrientation = 1;
    }

    private final void changeToLandscape(int surfaceType) {
        if (this.mOrientation == 1) {
            InAppLogger.m8595d(TAG, "changeToLandscape");
            this.mOrientation = 2;
            ScreenRotateListener screenRotateListener = this.mScreenRotateListener;
            if (screenRotateListener != null) {
                screenRotateListener.onOrientationChanged(2, surfaceType);
            }
        }
    }

    private final void changeToPortrait() {
        if (this.mOrientation == 2) {
            InAppLogger.m8595d(TAG, "changeToPortrait");
            this.mOrientation = 1;
            ScreenRotateListener screenRotateListener = this.mScreenRotateListener;
            if (screenRotateListener != null) {
                screenRotateListener.onOrientationChanged(1, 0);
            }
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int orientation) {
        if (orientation < 0) {
            InAppLogger.m8595d(TAG, "onOrientationChanged# no changed, orientation : " + orientation);
        } else {
            if (orientation <= 45 || orientation >= 315) {
                changeToPortrait();
                return;
            }
            if (orientation <= 135) {
                changeToLandscape(3);
            } else if (orientation <= 225) {
                changeToPortrait();
            } else {
                changeToLandscape(1);
            }
        }
    }

    public final void onPause() {
        disable();
    }

    public final void onResume() {
        enable();
    }

    public final void setOrientationListener(@Nullable ScreenRotateListener screenRotateListener) {
        this.mScreenRotateListener = screenRotateListener;
    }
}
