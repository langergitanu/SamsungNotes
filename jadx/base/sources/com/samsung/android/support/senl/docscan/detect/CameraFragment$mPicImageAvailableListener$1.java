package com.samsung.android.support.senl.docscan.detect;

import android.graphics.PointF;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter;
import com.samsung.android.support.senl.docscan.detect.view.DetectOverlayView;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/support/senl/docscan/detect/CameraFragment$mPicImageAvailableListener$1", "Landroid/media/ImageReader$OnImageAvailableListener;", "onImageAvailable", "", "reader", "Landroid/media/ImageReader;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CameraFragment$mPicImageAvailableListener$1 implements ImageReader.OnImageAvailableListener {
    final /* synthetic */ CameraFragment this$0;

    public CameraFragment$mPicImageAvailableListener$1(CameraFragment cameraFragment) {
        this.this$0 = cameraFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onImageAvailable$lambda$0(CameraFragment cameraFragment, DocScanData docScanData) {
        CameraFragment.Contract contract = cameraFragment.mContract;
        if (contract != null) {
            contract.showRectifyEditView(docScanData, "CameraFragment");
        }
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader reader) {
        PointF[] resultPoint;
        CameraPresenter cameraPresenter;
        Handler mBackgroundHandler;
        Intrinsics.checkNotNullParameter(reader, "reader");
        CameraProperty cameraProperty = this.this$0.mCameraProperty;
        Logger.m7148i("CameraFragment", "PictureReader# onImageAvailable, CameraState : " + (cameraProperty != null ? cameraProperty.getMCameraState() : null));
        Image imageAcquireNextImage = reader.acquireNextImage();
        if (imageAcquireNextImage == null) {
            return;
        }
        DetectOverlayView detectOverlayView = this.this$0.mDetectOverlayView;
        if (detectOverlayView != null) {
            CameraProperty cameraProperty2 = this.this$0.mCameraProperty;
            resultPoint = detectOverlayView.getResultPoint(cameraProperty2 != null ? cameraProperty2.getMOrientation() : 0);
        } else {
            resultPoint = null;
        }
        CameraPresenter cameraPresenter2 = this.this$0.mCameraPresenter;
        DocScanData docScanDataMakeDocScanData = cameraPresenter2 != null ? cameraPresenter2.makeDocScanData(imageAcquireNextImage, resultPoint) : null;
        if (docScanDataMakeDocScanData != null) {
            CameraPresenter cameraPresenter3 = this.this$0.mCameraPresenter;
            if ((cameraPresenter3 != null ? cameraPresenter3.getMBackgroundHandler() : null) == null || (cameraPresenter = this.this$0.mCameraPresenter) == null || (mBackgroundHandler = cameraPresenter.getMBackgroundHandler()) == null) {
                return;
            }
            mBackgroundHandler.postDelayed(new RunnableC4199v(this.this$0, docScanDataMakeDocScanData, 14), 100L);
        }
    }
}
