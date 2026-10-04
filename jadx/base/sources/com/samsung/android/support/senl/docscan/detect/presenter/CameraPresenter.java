package com.samsung.android.support.senl.docscan.detect.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.WindowManager;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.docscan.detect.presenter.ViewContract;
import com.samsung.android.support.senl.docscan.detect.util.CameraHelper;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.io.File;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 i2\u00020\u0001:\u0002hiB+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\tJ\u0006\u00106\u001a\u000204J \u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u001dJC\u0010=\u001a\u0002082\f\u0010>\u001a\b\u0012\u0004\u0012\u0002080?2\u0006\u0010@\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u000208H\u0002¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\u0006\u0010G\u001a\u000208J/\u0010H\u001a\u0004\u0018\u0001082\u000e\u0010>\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010?2\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010KJ\u000e\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020NJ\u0010\u0010O\u001a\u0002042\u0006\u0010P\u001a\u00020QH\u0002J'\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020X2\u0010\u0010Y\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010Z0?¢\u0006\u0002\u0010[J\u0006\u0010\\\u001a\u000204J\u0006\u0010a\u001a\u000204J\u0006\u0010b\u001a\u000204J\b\u0010c\u001a\u000204H\u0002J\u0006\u0010d\u001a\u000204J\u0006\u0010e\u001a\u000204J\u0006\u0010f\u001a\u000204J\u0006\u0010g\u001a\u000204R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020S8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010TR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020V0^8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`¨\u0006j"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter;", "", "mIFragment", "Lcom/samsung/android/support/senl/docscan/detect/presenter/ViewContract$Fragment;", "mScanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "mCameraProperty", "Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty;", "args", "Landroid/os/Bundle;", "<init>", "(Lcom/samsung/android/support/senl/docscan/detect/presenter/ViewContract$Fragment;Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty;Landroid/os/Bundle;)V", "getMCameraProperty", "()Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty;", "mCameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "getMCameraCaptureSession", "()Landroid/hardware/camera2/CameraCaptureSession;", "setMCameraCaptureSession", "(Landroid/hardware/camera2/CameraCaptureSession;)V", "mCaptureRequestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "getMCaptureRequestBuilder", "()Landroid/hardware/camera2/CaptureRequest$Builder;", "setMCaptureRequestBuilder", "(Landroid/hardware/camera2/CaptureRequest$Builder;)V", "mPreviewRequest", "Landroid/hardware/camera2/CaptureRequest;", "mSensorOrientation", "", "getMSensorOrientation", "()Ljava/lang/Integer;", "setMSensorOrientation", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mCameraId", "", "getMCameraId", "()Ljava/lang/String;", "setMCameraId", "(Ljava/lang/String;)V", "mSaveFilePath", "mDocUuid", "mBackgroundThread", "Landroid/os/HandlerThread;", "value", "Landroid/os/Handler;", "mBackgroundHandler", "getMBackgroundHandler", "()Landroid/os/Handler;", "mHandlerMessage", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "startPreviewRepeating", "setPreviewSize", "Landroid/util/Size;", "map", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "viewWidth", "viewHeight", "choosePreviewOptimalSize", "choices", "", "textureViewWidth", "textureViewHeight", "maxWidth", "maxHeight", "aspectRatio", "([Landroid/util/Size;IIIILandroid/util/Size;)Landroid/util/Size;", "setPictureSize", "previewSize", "choosePictureOptimalSize", "previewWidth", "previewHeight", "([Landroid/util/Size;II)Landroid/util/Size;", "autoFocus", "focusTouchArea", "Landroid/hardware/camera2/params/MeteringRectangle;", "runAfterAF", "delay", "", "isMeteringAreaAFSupported", "", "()Z", "makeDocScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "image", "Landroid/media/Image;", "resultPoints", "Landroid/graphics/PointF;", "(Landroid/media/Image;[Landroid/graphics/PointF;)Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "loadThumbnail", "scanDataList", "", "getScanDataList", "()Ljava/util/List;", "restartCameraTimer", "stopCameraTimer", "startCameraTimer", "startBackgroundThread", "stopBackgroundThread", "closeCameraImpl", "destroy", "CompareSizesByArea", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCameraPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraPresenter.kt\ncom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,522:1\n1#2:523\n*E\n"})
public final class CameraPresenter {
    private static final int CAMERA_TIMEOUT = 120000;

    @NotNull
    private static final String FOCUSING = "FOCUSING";
    private static final int LIMIT_TIME_TO_WAIT = 100;
    private static final int MAX_HEIGHT_LIBRARY = 3000;
    private static final int MAX_PREVIEW_HEIGHT = 1080;
    private static final int MAX_PREVIEW_WIDTH = 1920;
    private static final int MAX_WIDTH_LIBRARY = 4000;
    public static final int MSG_EXPIRED_TIMER = 4;
    public static final int MSG_FOCUS_ANIM = 1;
    public static final int MSG_SHOW_TOAST = 2;
    public static final int MSG_THUMBNAIL_UPDATE = 3;

    @NotNull
    private static final String STOP_FOCUS = "STOP_FOCUS";

    @NotNull
    private static final String TAG = "CameraPresenter";

    @Nullable
    private Handler mBackgroundHandler;

    @Nullable
    private HandlerThread mBackgroundThread;

    @Nullable
    private CameraCaptureSession mCameraCaptureSession;

    @Nullable
    private String mCameraId;

    @NotNull
    private final CameraProperty mCameraProperty;

    @Nullable
    private CaptureRequest.Builder mCaptureRequestBuilder;

    @Nullable
    private final String mDocUuid;

    @NotNull
    private final Handler mHandlerMessage;

    @Nullable
    private final ViewContract.Fragment mIFragment;

    @Nullable
    private CaptureRequest mPreviewRequest;

    @NotNull
    private final String mSaveFilePath;

    @Nullable
    private final ScanDataModel mScanDataModel;

    @Nullable
    private Integer mSensorOrientation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u000b2\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u00020\u0004:\u0001\u000bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter$CompareSizesByArea;", "Ljava/util/Comparator;", "Landroid/util/Size;", "Lkotlin/Comparator;", "Ljava/io/Serializable;", "<init>", "()V", "compare", "", "o1", "o2", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CompareSizesByArea implements Comparator<Size>, Serializable {
        private static final long serialVersionUID = 1;

        @Override // java.util.Comparator
        public int compare(@NotNull Size o12, @NotNull Size o22) {
            Intrinsics.checkNotNullParameter(o12, "o1");
            Intrinsics.checkNotNullParameter(o22, "o2");
            return Long.signum((((long) o12.getWidth()) * ((long) o12.getHeight())) - (((long) o22.getWidth()) * ((long) o22.getHeight())));
        }
    }

    public CameraPresenter(@Nullable ViewContract.Fragment fragment, @Nullable ScanDataModel scanDataModel, @NotNull CameraProperty mCameraProperty, @NotNull Bundle args) {
        Intrinsics.checkNotNullParameter(mCameraProperty, "mCameraProperty");
        Intrinsics.checkNotNullParameter(args, "args");
        this.mIFragment = fragment;
        this.mScanDataModel = scanDataModel;
        this.mCameraProperty = mCameraProperty;
        final Looper mainLooper = Looper.getMainLooper();
        this.mHandlerMessage = new Handler(mainLooper) { // from class: com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter$mHandlerMessage$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                ViewContract.Fragment fragment2;
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i == 2) {
                    ViewContract.Fragment fragment3 = this.this$0.mIFragment;
                    Intrinsics.checkNotNull(fragment3);
                    ToastHandler.show(fragment3.getAppContext(), "Save", 0);
                } else {
                    if (i != 3) {
                        if (i == 4 && (fragment2 = this.this$0.mIFragment) != null) {
                            fragment2.finishWithSuccess("Timer expired");
                            return;
                        }
                        return;
                    }
                    ViewContract.Fragment fragment4 = this.this$0.mIFragment;
                    Intrinsics.checkNotNull(fragment4);
                    Object obj = msg.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Bitmap");
                    fragment4.updateThumbnailView((Bitmap) obj, msg.arg1);
                }
            }
        };
        this.mSaveFilePath = AbstractC0541b.m756B(args.getString(Constant.INTENT_PATH_TO_SAVE), Constant.DOC_SCAN_FILE_PREFIX);
        this.mDocUuid = args.getString(Constant.INTENT_SDOC_UUID);
    }

    private final Size choosePictureOptimalSize(Size[] choices, int previewWidth, int previewHeight) {
        if (choices == null) {
            return null;
        }
        float f = previewHeight > previewWidth ? previewHeight / previewWidth : previewWidth / previewHeight;
        Size size = null;
        for (float f4 = 0.2f; f4 < f; f4 += 0.2f) {
            Iterator it = ArrayIteratorKt.iterator(choices);
            while (it.hasNext()) {
                Size size2 = (Size) it.next();
                if (size2.getWidth() < 4000 && size2.getHeight() < 3000 && Math.abs(f - (size2.getWidth() / size2.getHeight())) < f4) {
                    if (size != null) {
                        if (size2.getHeight() * size2.getWidth() > size.getHeight() * size.getWidth()) {
                        }
                    }
                    size = size2;
                }
            }
            if (size != null) {
                break;
            }
        }
        if (size == null) {
            Logger.m7145d(TAG, "choosePictureOptimalSize# pictureSize is null");
            return null;
        }
        Logger.m7145d(TAG, "choosePictureOptimalSize# pictureSize :" + size);
        return size;
    }

    private final Size choosePreviewOptimalSize(Size[] choices, int textureViewWidth, int textureViewHeight, int maxWidth, int maxHeight, Size aspectRatio) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int width = aspectRatio.getWidth();
        int height = aspectRatio.getHeight();
        for (Size size : choices) {
            if (size.getWidth() <= maxWidth && size.getHeight() <= maxHeight && size.getHeight() == (size.getWidth() * height) / width) {
                if (size.getWidth() < textureViewWidth || size.getHeight() < textureViewHeight) {
                    arrayList2.add(size);
                } else {
                    arrayList.add(size);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Object objMin = Collections.min(arrayList, new CompareSizesByArea());
            Intrinsics.checkNotNull(objMin);
            return (Size) objMin;
        }
        if (arrayList2.isEmpty()) {
            Logger.m7146e(TAG, "choosePreviewOptimalSize# Couldn't find any suitable preview size");
            return choices[0];
        }
        Object objMax = Collections.max(arrayList2, new CompareSizesByArea());
        Intrinsics.checkNotNull(objMax);
        return (Size) objMax;
    }

    private final List<DocScanData> getScanDataList() {
        List<DocScanData> scanDataList;
        ScanDataModel scanDataModel = this.mScanDataModel;
        return (scanDataModel == null || (scanDataList = scanDataModel.getScanDataList()) == null) ? CollectionsKt.emptyList() : scanDataList;
    }

    private final boolean isMeteringAreaAFSupported() {
        ViewContract.Fragment fragment = this.mIFragment;
        Intrinsics.checkNotNull(fragment);
        Object systemService = fragment.getAppContext().getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        try {
            String str = this.mCameraId;
            Intrinsics.checkNotNull(str);
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            Intrinsics.checkNotNull(cameraCharacteristics);
            Object obj = cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
            Intrinsics.checkNotNull(obj);
            boolean z = ((Number) obj).intValue() >= 1;
            Logger.m7145d(TAG, "isMeteringAreaAFSupported() support : " + z);
            return z;
        } catch (CameraAccessException unused) {
            Logger.m7146e(TAG, "isMeteringAreaAFSupported# CameraAccessException");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runAfterAF(long delay) {
        Logger.m7145d(TAG, "runAfterAF - delay time : " + delay);
        try {
            CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
            Intrinsics.checkNotNull(cameraCaptureSession);
            cameraCaptureSession.stopRepeating();
            CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
            Intrinsics.checkNotNull(builder);
            builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
            Intrinsics.checkNotNull(builder2);
            builder2.setTag(null);
            CameraCaptureSession cameraCaptureSession2 = this.mCameraCaptureSession;
            Intrinsics.checkNotNull(cameraCaptureSession2);
            CaptureRequest.Builder builder3 = this.mCaptureRequestBuilder;
            Intrinsics.checkNotNull(builder3);
            CaptureRequest captureRequestBuild = builder3.build();
            ViewContract.Fragment fragment = this.mIFragment;
            Intrinsics.checkNotNull(fragment);
            cameraCaptureSession2.setRepeatingRequest(captureRequestBuild, fragment.getMPreviewCaptureCallback(), this.mBackgroundHandler);
        } catch (Exception e) {
            Logger.m7146e(TAG, "runAfterAF, e : " + e.getMessage());
        }
        Handler handler = this.mBackgroundHandler;
        if (handler != null) {
            handler.postDelayed(new RunnableC7599e(this, 11), delay);
        }
    }

    private final void startCameraTimer() {
        ViewContract.Fragment fragment = this.mIFragment;
        Intrinsics.checkNotNull(fragment);
        if (fragment.isAdded()) {
            this.mHandlerMessage.sendEmptyMessageDelayed(4, 120000L);
        }
    }

    public final void autoFocus(@NotNull MeteringRectangle focusTouchArea) {
        Intrinsics.checkNotNullParameter(focusTouchArea, "focusTouchArea");
        Logger.m7145d(TAG, "autoFocus# state : " + this.mCameraProperty.getMCameraState());
        if (this.mCameraProperty.getMCameraState() != CameraProperty.CameraState.PREVIEW) {
            return;
        }
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.DocumentScan;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(500L, tag);
            try {
                CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter$autoFocus$manualFocusCaptureCallback$1
                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                        Intrinsics.checkNotNullParameter(session, "session");
                        Intrinsics.checkNotNullParameter(request, "request");
                        Intrinsics.checkNotNullParameter(result, "result");
                        super.onCaptureCompleted(session, request, result);
                        if (Intrinsics.areEqual("FOCUSING", request.getTag())) {
                            Integer num = (Integer) result.get(CaptureResult.CONTROL_AF_STATE);
                            Logger.m7145d("CameraPresenter", "autoFocus onCaptureCompleted# focusing afState : " + (num == null ? "null" : num));
                            if (num != null) {
                                if (num.intValue() == 4 || num.intValue() == 5) {
                                    this.this$0.runAfterAF(AiSTTListView.USER_SCROLL_INTERVAL);
                                }
                            }
                        }
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureFailed(CameraCaptureSession session, CaptureRequest request, CaptureFailure failure) {
                        Intrinsics.checkNotNullParameter(session, "session");
                        Intrinsics.checkNotNullParameter(request, "request");
                        Intrinsics.checkNotNullParameter(failure, "failure");
                        super.onCaptureFailed(session, request, failure);
                        Logger.m7146e("CameraPresenter", "autoFocus onCaptureFailed# failure : " + failure);
                        this.this$0.runAfterAF(0L);
                    }
                };
                CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder);
                CaptureRequest.Key key = CaptureRequest.CONTROL_AF_TRIGGER;
                builder.set(key, 2);
                CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder2);
                builder2.setTag(STOP_FOCUS);
                CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
                Intrinsics.checkNotNull(cameraCaptureSession);
                CaptureRequest.Builder builder3 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder3);
                cameraCaptureSession.capture(builder3.build(), captureCallback, this.mBackgroundHandler);
                if (isMeteringAreaAFSupported()) {
                    CaptureRequest.Builder builder4 = this.mCaptureRequestBuilder;
                    Intrinsics.checkNotNull(builder4);
                    builder4.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{focusTouchArea});
                    CaptureRequest.Builder builder5 = this.mCaptureRequestBuilder;
                    Intrinsics.checkNotNull(builder5);
                    builder5.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{focusTouchArea});
                }
                CaptureRequest.Builder builder6 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder6);
                builder6.set(CaptureRequest.CONTROL_MODE, 1);
                CaptureRequest.Builder builder7 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder7);
                builder7.set(CaptureRequest.CONTROL_AF_MODE, 1);
                CaptureRequest.Builder builder8 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder8);
                builder8.set(key, 1);
                CaptureRequest.Builder builder9 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder9);
                builder9.setTag(FOCUSING);
                CameraCaptureSession cameraCaptureSession2 = this.mCameraCaptureSession;
                Intrinsics.checkNotNull(cameraCaptureSession2);
                CaptureRequest.Builder builder10 = this.mCaptureRequestBuilder;
                Intrinsics.checkNotNull(builder10);
                cameraCaptureSession2.setRepeatingRequest(builder10.build(), captureCallback, this.mBackgroundHandler);
            } catch (CameraAccessException unused) {
                Logger.m7146e(TAG, "autoFocus# CameraAccessException");
            } catch (IllegalStateException unused2) {
                Logger.m7146e(TAG, "autoFocus# IllegalStateException");
            }
        }
    }

    public final void closeCameraImpl() {
        CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
        if (cameraCaptureSession != null) {
            Intrinsics.checkNotNull(cameraCaptureSession);
            cameraCaptureSession.close();
            this.mCameraCaptureSession = null;
        }
    }

    public final void destroy() {
        this.mHandlerMessage.removeMessages(3);
    }

    @Nullable
    public final Handler getMBackgroundHandler() {
        return this.mBackgroundHandler;
    }

    @Nullable
    public final CameraCaptureSession getMCameraCaptureSession() {
        return this.mCameraCaptureSession;
    }

    @Nullable
    public final String getMCameraId() {
        return this.mCameraId;
    }

    @NotNull
    public final CameraProperty getMCameraProperty() {
        return this.mCameraProperty;
    }

    @Nullable
    public final CaptureRequest.Builder getMCaptureRequestBuilder() {
        return this.mCaptureRequestBuilder;
    }

    @Nullable
    public final Integer getMSensorOrientation() {
        return this.mSensorOrientation;
    }

    public final void loadThumbnail() {
        List<DocScanData> scanDataList = getScanDataList();
        if (scanDataList.isEmpty()) {
            return;
        }
        int size = scanDataList.size();
        ViewContract.Fragment fragment = this.mIFragment;
        Intrinsics.checkNotNull(fragment);
        fragment.updateThumbnailView(DocScanUtils.getBitmapImageFromPath(scanDataList.get(size - 1).getThumbnailPath()), size);
    }

    @Nullable
    public final DocScanData makeDocScanData(@NotNull Image image, @NotNull PointF[] resultPoints) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(resultPoints, "resultPoints");
        String string = Arrays.toString(resultPoints);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m7148i(TAG, "makeDocScanData# resultPoints : " + string);
        UserInputSkipper.setHoldingEventTime(1000L, UserInputSkipper.Tag.DocumentScan);
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        int iRemaining = buffer.remaining();
        byte[] bArr = new byte[iRemaining];
        buffer.get(bArr);
        image.close();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.mSaveFilePath + jCurrentTimeMillis + ".jpg";
        File file = new File(str);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return null;
            }
            if (!parentFile.exists() && !parentFile.mkdir()) {
                Logger.m7148i(TAG, "makeDocScanData# The directory was not created");
            }
        }
        String str2 = this.mDocUuid;
        Intrinsics.checkNotNull(str2);
        DocScanData docScanData = new DocScanData(str, DocScanUtils.getEditingPath(this.mDocUuid) + jCurrentTimeMillis + ".jpg", DocScanUtils.getThumbnailPath(str2) + jCurrentTimeMillis + ".jpg", resultPoints);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) this.mCameraProperty.getMJpegOrientation());
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iRemaining);
        if (bitmapDecodeByteArray == null) {
            Logger.m7145d(TAG, "makeDocScanData srcBitmap is null");
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        if (!ImageUtils.makeJpg(bitmapCreateBitmap, file, 100)) {
            return null;
        }
        Logger.m7145d(TAG, "makeDocScanData scanPath : " + Logger.getEncode(str));
        docScanData.setScanBitmap(bitmapCreateBitmap);
        return docScanData;
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString(Constant.INTENT_PATH_TO_SAVE, StringsKt.m14139M(this.mSaveFilePath, Constant.DOC_SCAN_FILE_PREFIX, ""));
        outState.putString(Constant.INTENT_SDOC_UUID, this.mDocUuid);
    }

    public final void restartCameraTimer() {
        Logger.m7145d(TAG, "restartCameraTimer");
        stopCameraTimer();
        startCameraTimer();
    }

    public final void setMCameraCaptureSession(@Nullable CameraCaptureSession cameraCaptureSession) {
        this.mCameraCaptureSession = cameraCaptureSession;
    }

    public final void setMCameraId(@Nullable String str) {
        this.mCameraId = str;
    }

    public final void setMCaptureRequestBuilder(@Nullable CaptureRequest.Builder builder) {
        this.mCaptureRequestBuilder = builder;
    }

    public final void setMSensorOrientation(@Nullable Integer num) {
        this.mSensorOrientation = num;
    }

    @Nullable
    public final Size setPictureSize(@NotNull StreamConfigurationMap map, @NotNull Size previewSize) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(previewSize, "previewSize");
        Size[] outputSizes = map.getOutputSizes(256);
        if (outputSizes != null && outputSizes.length != 0) {
            return choosePictureOptimalSize(outputSizes, previewSize.getWidth(), previewSize.getHeight());
        }
        Logger.m7146e(TAG, "setPictureSize# there is not supportedImageSizes");
        return null;
    }

    @Nullable
    public final Size setPreviewSize(@NotNull StreamConfigurationMap map, int viewWidth, int viewHeight) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(map, "map");
        Size[] outputSizes = map.getOutputSizes(35);
        if (outputSizes == null) {
            Logger.m7145d(TAG, "setPreviewSize# supportedYuvSizes is null");
            return null;
        }
        Size[] outputSizes2 = map.getOutputSizes(SurfaceTexture.class);
        if (outputSizes2 == null) {
            Logger.m7145d(TAG, "setPreviewSize# supportedTextureSizes is null");
            return null;
        }
        int mOrientation = this.mCameraProperty.getMOrientation();
        Integer num = this.mSensorOrientation;
        Intrinsics.checkNotNull(num);
        int cameraOrientation = CameraHelper.getCameraOrientation(mOrientation, num.intValue());
        Point point = new Point();
        ViewContract.Fragment fragment = this.mIFragment;
        Intrinsics.checkNotNull(fragment);
        Object systemService = fragment.getAppContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        boolean z = cameraOrientation == 90 || cameraOrientation == 270;
        int i4 = point.x;
        int i5 = point.y;
        if (z) {
            i4 = i5;
            i5 = i4;
            i2 = viewWidth;
            i = viewHeight;
        } else {
            i = viewWidth;
            i2 = viewHeight;
        }
        int i6 = i4 > MAX_PREVIEW_WIDTH ? MAX_PREVIEW_WIDTH : i4;
        int i7 = i5 > 1080 ? 1080 : i5;
        Size size = (Size) Collections.max(CollectionsKt.mutableListOf(Arrays.copyOf(outputSizes, outputSizes.length)), new CompareSizesByArea());
        Intrinsics.checkNotNull(size);
        Size sizeChoosePreviewOptimalSize = choosePreviewOptimalSize(outputSizes2, i, i2, i6, i7, size);
        StringBuilder sb = new StringBuilder("setPreviewSize# previewSize : ");
        sb.append(sizeChoosePreviewOptimalSize);
        sb.append(", rotatedPreviewWidth : ");
        sb.append(i);
        sb.append(", rotatedPreviewHeight : ");
        AbstractC2821a.m2235z(sb, i2, i6, ", maxPreviewWidth : ", ", maxPreviewHeight : ");
        sb.append(i7);
        sb.append(", largest : ");
        sb.append(size);
        Logger.m7145d(TAG, sb.toString());
        return sizeChoosePreviewOptimalSize;
    }

    public final void startBackgroundThread() {
        Looper looper;
        Logger.m7145d(TAG, "startBackgroundThread");
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        HandlerThread handlerThread2 = this.mBackgroundThread;
        this.mBackgroundHandler = (handlerThread2 == null || (looper = handlerThread2.getLooper()) == null) ? null : new Handler(looper);
    }

    public final synchronized void startPreviewRepeating() {
        try {
            Logger.m7145d(TAG, "startPreviewRepeating# CameraState : " + this.mCameraProperty.getMCameraState());
            if (this.mCameraProperty.getMCameraState() == CameraProperty.CameraState.CLOSED) {
                return;
            }
            CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
            if (builder != null) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            }
            CaptureRequest.Builder builder2 = this.mCaptureRequestBuilder;
            this.mPreviewRequest = builder2 != null ? builder2.build() : null;
            CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
            if (cameraCaptureSession == null) {
                return;
            }
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.stopRepeating();
                } catch (Exception e) {
                    if (!(e instanceof CameraAccessException) && !(e instanceof IllegalStateException)) {
                        throw e;
                    }
                    Logger.m7146e(TAG, "startPreviewRepeating# error : " + e.getMessage());
                }
            }
            CameraCaptureSession cameraCaptureSession2 = this.mCameraCaptureSession;
            if (cameraCaptureSession2 != null) {
                CaptureRequest captureRequest = this.mPreviewRequest;
                Intrinsics.checkNotNull(captureRequest);
                ViewContract.Fragment fragment = this.mIFragment;
                cameraCaptureSession2.setRepeatingRequest(captureRequest, fragment != null ? fragment.getMPreviewCaptureCallback() : null, this.mBackgroundHandler);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void stopBackgroundThread() {
        Logger.m7145d(TAG, "stopBackgroundThread");
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread == null) {
            return;
        }
        Intrinsics.checkNotNull(handlerThread);
        handlerThread.quitSafely();
        try {
            Logger.startTime(TextConst.DATE_TIME_UNIT_TIME, TAG, "stopBackgroundThread.join");
            HandlerThread handlerThread2 = this.mBackgroundThread;
            Intrinsics.checkNotNull(handlerThread2);
            handlerThread2.join(100L);
            Logger.endTime(TextConst.DATE_TIME_UNIT_TIME, TAG, "end stopBackgroundThread.join");
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (InterruptedException unused) {
            Logger.m7146e(TAG, "stopBackgroundThread# InterruptedException");
            Thread.currentThread().interrupt();
        }
    }

    public final void stopCameraTimer() {
        this.mHandlerMessage.removeMessages(4);
    }
}
