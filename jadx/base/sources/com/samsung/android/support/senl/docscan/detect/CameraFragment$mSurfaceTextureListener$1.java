package com.samsung.android.support.senl.docscan.detect;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.PinnedEdge;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0014\u0010\r\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"com/samsung/android/support/senl/docscan/detect/CameraFragment$mSurfaceTextureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "", "onSurfaceTextureUpdated", "isPinnedPanelRunning", "()Z", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CameraFragment$mSurfaceTextureListener$1 implements TextureView.SurfaceTextureListener {
    final /* synthetic */ CameraFragment this$0;

    public CameraFragment$mSurfaceTextureListener$1(CameraFragment cameraFragment) {
        this.this$0 = cameraFragment;
    }

    private final boolean isPinnedPanelRunning() {
        if (!DisplayDeviceTypeCompat.INSTANCE.getInstance().isMainDisplay(this.this$0.getResources().getConfiguration())) {
            return false;
        }
        PinnedEdge pinnedEdge = this.this$0.mPinnedEdge;
        Intrinsics.checkNotNull(pinnedEdge);
        return pinnedEdge.getIsPinnedPanelRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSurfaceTextureAvailable$lambda$0(CameraFragment cameraFragment) {
        CameraProperty cameraProperty = cameraFragment.mCameraProperty;
        if (cameraProperty != null) {
            cameraProperty.setNavigationBarFlag(cameraFragment.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSurfaceTextureDestroyed$lambda$3(CameraFragment cameraFragment) {
        CameraProperty cameraProperty = cameraFragment.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        cameraProperty.clearNavigationBarFlag(cameraFragment.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSurfaceTextureSizeChanged$lambda$1(CameraFragment cameraFragment) {
        CameraProperty cameraProperty = cameraFragment.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        FragmentActivity activity = cameraFragment.getActivity();
        Intrinsics.checkNotNull(activity);
        cameraProperty.reloadNavigationBarFlag(activity);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Logger.m7148i("CameraFragment", "onSurfaceTextureAvailable# width : " + width + ", height : " + height);
        CameraProperty cameraProperty = this.this$0.mCameraProperty;
        if ((cameraProperty != null ? cameraProperty.getMCameraState() : null) == CameraProperty.CameraState.CLOSED) {
            this.this$0.openCamera(width, height);
        }
        CameraFragment cameraFragment = this.this$0;
        cameraFragment.runOnUiThread(new RunnableC7980a(cameraFragment, 7));
        SystemUi.setImmersiveModeEnable(this.this$0.getActivity(), isPinnedPanelRunning());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Logger.m7145d("CameraFragment", "onSurfaceTextureDestroyed");
        Object obj = this.this$0.mCameraStateLock;
        CameraFragment cameraFragment = this.this$0;
        synchronized (obj) {
            try {
                CameraProperty cameraProperty = cameraFragment.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                if (cameraProperty.getMCameraState() != CameraProperty.CameraState.CLOSED) {
                    cameraFragment.onPauseCamera();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        CameraFragment cameraFragment2 = this.this$0;
        cameraFragment2.runOnUiThread(new RunnableC7980a(cameraFragment2, 8));
        SystemUi.setImmersiveModeEnable(this.this$0.getActivity(), false);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Logger.m7145d("CameraFragment", "onSurfaceTextureSizeChanged# width : " + width + ", height : " + height);
        CameraFragment cameraFragment = this.this$0;
        cameraFragment.runOnUiThread(new RunnableC7980a(cameraFragment, 6));
        SystemUi.setImmersiveModeEnable(this.this$0.getActivity(), isPinnedPanelRunning());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }
}
