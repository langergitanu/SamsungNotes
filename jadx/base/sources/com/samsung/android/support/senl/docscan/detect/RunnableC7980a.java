package com.samsung.android.support.senl.docscan.detect;

/* JADX INFO: renamed from: com.samsung.android.support.senl.docscan.detect.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC7980a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5886a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CameraFragment f5887b;

    public /* synthetic */ RunnableC7980a(CameraFragment cameraFragment, int i) {
        this.f5886a = i;
        this.f5887b = cameraFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5886a) {
            case 0:
                this.f5887b.finishWithFailed("handleCameraDisabled");
                break;
            case 1:
                this.f5887b.showRectifyListView();
                break;
            case 2:
                CameraFragment.onResumeCamera$lambda$2(this.f5887b);
                break;
            case 3:
                CameraFragment.updateCameraMenuLayout$lambda$3(this.f5887b);
                break;
            case 4:
                CameraFragment$mCameraStateCallback$1.onError$lambda$3(this.f5887b);
                break;
            case 5:
                this.f5887b.onPauseCamera();
                break;
            case 6:
                CameraFragment$mSurfaceTextureListener$1.onSurfaceTextureSizeChanged$lambda$1(this.f5887b);
                break;
            case 7:
                CameraFragment$mSurfaceTextureListener$1.onSurfaceTextureAvailable$lambda$0(this.f5887b);
                break;
            default:
                CameraFragment$mSurfaceTextureListener$1.onSurfaceTextureDestroyed$lambda$3(this.f5887b);
                break;
        }
    }
}
