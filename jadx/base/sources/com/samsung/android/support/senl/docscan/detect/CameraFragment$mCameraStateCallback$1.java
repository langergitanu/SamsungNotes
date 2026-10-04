package com.samsung.android.support.senl.docscan.detect;

import android.content.Context;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.docscan.detect.view.AutoTextureView;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"com/samsung/android/support/senl/docscan/detect/CameraFragment$mCameraStateCallback$1", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "onOpened", "", "cameraDevice", "Landroid/hardware/camera2/CameraDevice;", "onDisconnected", "onError", "errorCode", "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CameraFragment$mCameraStateCallback$1 extends CameraDevice.StateCallback {
    final /* synthetic */ CameraFragment this$0;

    public CameraFragment$mCameraStateCallback$1(CameraFragment cameraFragment) {
        this.this$0 = cameraFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onError$lambda$3(CameraFragment cameraFragment) {
        Context context = cameraFragment.getContext();
        if (context != null) {
            String string = context.getString(C7976R.string.camera_access_error_camera_busy_to_open);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 1);
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onDisconnected(CameraDevice cameraDevice) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Logger.m7148i("CameraFragment", "cameraStateCallback# onDisconnected");
        CameraProperty cameraProperty = this.this$0.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        if (cameraProperty.getMCameraState() == CameraProperty.CameraState.CLOSED || (activity = this.this$0.getActivity()) == null) {
            return;
        }
        activity.runOnUiThread(new RunnableC7980a(this.this$0, 5));
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onError(CameraDevice cameraDevice, int errorCode) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        new Handler(Looper.getMainLooper()).post(new RunnableC7980a(this.this$0, 4));
        Logger.m7146e("CameraFragment", "cameraStateCallback# onError errorCode : " + errorCode);
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onOpened(CameraDevice cameraDevice) {
        Intrinsics.checkNotNullParameter(cameraDevice, "cameraDevice");
        Logger.m7148i("CameraFragment", "cameraStateCallback# onOpened");
        Object obj = this.this$0.mCameraStateLock;
        CameraFragment cameraFragment = this.this$0;
        synchronized (obj) {
            try {
                CameraProperty cameraProperty = cameraFragment.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                cameraProperty.setMCameraState(CameraProperty.CameraState.OPENED);
                cameraFragment.mCameraOpenCloseLock.release();
                cameraFragment.mCameraDevice = cameraDevice;
                if (cameraFragment.mPreviewSize != null && cameraFragment.mTextureView != null) {
                    AutoTextureView autoTextureView = cameraFragment.mTextureView;
                    Intrinsics.checkNotNull(autoTextureView);
                    if (autoTextureView.isAvailable()) {
                        cameraFragment.createCameraPreviewSession();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
