package com.samsung.android.support.senl.docscan.detect.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraCaptureSession;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/presenter/ViewContract;", "", "Fragment", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ViewContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/presenter/ViewContract$Fragment;", "", "getPreviewCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", StateHandler.ACTION_GET_APP_STATE, "Landroid/content/Context;", "updateThumbnailView", "", "bitmap", "Landroid/graphics/Bitmap;", "scanDataListSize", "", "isAdded", "", "finishWithSuccess", "cause", "", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Fragment {
        void finishWithSuccess(@NotNull String cause);

        @NotNull
        Context getAppContext();

        @NotNull
        /* JADX INFO: renamed from: getPreviewCaptureCallback */
        CameraCaptureSession.CaptureCallback getMPreviewCaptureCallback();

        boolean isAdded();

        void updateThumbnailView(@Nullable Bitmap bitmap, int scanDataListSize);
    }
}
