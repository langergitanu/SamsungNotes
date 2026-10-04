package com.samsung.android.support.senl.addons.base.view.fragmentbase;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import androidx.annotation.MainThread;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.screen.rotation.IRotationMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000eH\u0007J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/ScreenLockRotationListener;", "Landroid/view/OrientationEventListener;", "context", "Landroid/content/Context;", "model", "Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/addons/base/model/screen/rotation/IRotationMode;)V", "mModel", "mRotationAngle", "", "mSurfaceType", "", "onResume", "", "onPause", "stop", "start", "onOrientationChanged", "degree", "onConfigurationChanged", "initialize", "updateRotationAngleMap", "surfaceType", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScreenLockRotationListener extends OrientationEventListener {
    private static final int ANGLE_0 = 0;
    private static final int ANGLE_180 = 2;
    private static final int ANGLE_270 = 3;
    private static final int ANGLE_90 = 1;

    @NotNull
    private static final String TAG = Logger.createTag("ScreenLockRotationListener");

    @Nullable
    private IRotationMode mModel;

    @NotNull
    private final int[] mRotationAngle;
    private int mSurfaceType;

    public ScreenLockRotationListener(@Nullable Context context, @Nullable IRotationMode iRotationMode) {
        super(context);
        this.mModel = iRotationMode;
        this.mRotationAngle = new int[4];
        this.mSurfaceType = -1;
    }

    private final void initialize(Context context) {
        updateRotationAngleMap(context instanceof Activity ? ((Activity) context).getWindowManager().getDefaultDisplay().getRotation() : 0);
    }

    private final void updateRotationAngleMap(int surfaceType) {
        if (this.mSurfaceType == surfaceType) {
            return;
        }
        this.mSurfaceType = surfaceType;
        AbstractC6670b.m4761v(surfaceType, "update rotation angle map : ", TAG);
        if (surfaceType == 0) {
            int[] iArr = this.mRotationAngle;
            iArr[0] = 0;
            iArr[1] = 270;
            iArr[2] = 180;
            iArr[3] = 90;
            return;
        }
        if (surfaceType == 1) {
            int[] iArr2 = this.mRotationAngle;
            iArr2[0] = 270;
            iArr2[1] = 180;
            iArr2[2] = 90;
            iArr2[3] = 0;
            return;
        }
        if (surfaceType == 2) {
            int[] iArr3 = this.mRotationAngle;
            iArr3[0] = 180;
            iArr3[1] = 90;
            iArr3[2] = 0;
            iArr3[3] = 270;
            return;
        }
        if (surfaceType != 3) {
            return;
        }
        int[] iArr4 = this.mRotationAngle;
        iArr4[0] = 90;
        iArr4[1] = 0;
        iArr4[2] = 270;
        iArr4[3] = 180;
    }

    public final void onConfigurationChanged(@Nullable Context context) {
        initialize(context);
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int degree) {
        int i;
        IRotationMode iRotationMode = this.mModel;
        if (iRotationMode == null) {
            Logger.m7105w(TAG, "orientation is changed, but model is null");
            return;
        }
        if (degree < 0) {
            Logger.m7105w(TAG, "laid on desk!");
            return;
        }
        if (degree <= 40 || degree >= 320) {
            i = this.mRotationAngle[0];
        } else if (degree >= 50 && degree <= 130) {
            i = this.mRotationAngle[1];
        } else if (degree >= 140 && degree <= 220) {
            i = this.mRotationAngle[2];
        } else if (degree < 230 || degree > 310) {
            return;
        } else {
            i = this.mRotationAngle[3];
        }
        Intrinsics.checkNotNull(iRotationMode);
        if (iRotationMode.setRotation(i)) {
            Logger.m7100d(TAG, "orientation changed by " + degree + " degree, " + i);
        }
    }

    public final void onPause() {
        disable();
    }

    public final void onResume() {
        enable();
    }

    @MainThread
    public final void start(@Nullable Context context) {
        enable();
        IRotationMode iRotationMode = this.mModel;
        if (iRotationMode != null) {
            iRotationMode.enableRotation(true);
        }
        initialize(context);
    }

    @MainThread
    public final void stop() {
        IRotationMode iRotationMode = this.mModel;
        if (iRotationMode != null) {
            Intrinsics.checkNotNull(iRotationMode);
            iRotationMode.enableRotation(false);
        }
        disable();
    }
}
