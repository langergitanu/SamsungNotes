package com.samsung.android.support.senl.docscan.detect.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter;
import com.samsung.android.support.senl.docscan.detect.util.CameraHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/view/AutoTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "presenter", "Lcom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter;)V", "mPresenter", "initView", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "getManualFocusArea", "Landroid/hardware/camera2/params/MeteringRectangle;", "x", "", "y", "focusRect", "Landroid/graphics/Rect;", "getFocusRect", "()Landroid/graphics/Rect;", "sensorActualRect", "getSensorActualRect", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AutoTextureView extends TextureView {

    @NotNull
    private static final String TAG = "AutoTextureView";

    @Nullable
    private CameraPresenter mPresenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoTextureView(@Nullable Context context, @Nullable CameraPresenter cameraPresenter) {
        super(context);
        Intrinsics.checkNotNull(context);
        initView(context, cameraPresenter);
    }

    private final Rect getFocusRect() {
        Logger.m7145d(TAG, "getFocusRect()");
        CameraPresenter cameraPresenter = this.mPresenter;
        Intrinsics.checkNotNull(cameraPresenter);
        if (cameraPresenter.getMCaptureRequestBuilder() != null) {
            CameraPresenter cameraPresenter2 = this.mPresenter;
            Intrinsics.checkNotNull(cameraPresenter2);
            CaptureRequest.Builder mCaptureRequestBuilder = cameraPresenter2.getMCaptureRequestBuilder();
            Intrinsics.checkNotNull(mCaptureRequestBuilder);
            Rect rect = (Rect) mCaptureRequestBuilder.get(CaptureRequest.SCALER_CROP_REGION);
            if (rect != null) {
                return rect;
            }
        }
        return getSensorActualRect();
    }

    private final MeteringRectangle getManualFocusArea(int x, int y2) {
        int width;
        int height;
        Logger.m7145d(TAG, "getManualFocusArea(), " + x + "x" + y2);
        CameraPresenter cameraPresenter = this.mPresenter;
        Intrinsics.checkNotNull(cameraPresenter);
        int mOrientation = cameraPresenter.getMCameraProperty().getMOrientation();
        CameraPresenter cameraPresenter2 = this.mPresenter;
        Intrinsics.checkNotNull(cameraPresenter2);
        Integer mSensorOrientation = cameraPresenter2.getMSensorOrientation();
        Intrinsics.checkNotNull(mSensorOrientation);
        int cameraOrientation = CameraHelper.getCameraOrientation(mOrientation, mSensorOrientation.intValue());
        if (cameraOrientation == 0 || cameraOrientation == 180) {
            width = getWidth();
            height = getHeight();
        } else {
            width = getHeight();
            height = getWidth();
        }
        Rect focusRect = getFocusRect();
        Rect sensorActualRect = getSensorActualRect();
        Object obj = focusRect == null ? "null" : focusRect;
        Object obj2 = sensorActualRect != null ? sensorActualRect : "null";
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "getManualFocusArea(), width : ", ", height : ", ", sensorArraySize : ");
        sbM1173s.append(obj);
        sbM1173s.append(", sensorActualSize : ");
        sbM1173s.append(obj2);
        Logger.m7145d(TAG, sbM1173s.toString());
        if (focusRect == null || sensorActualRect == null) {
            return new MeteringRectangle(new Rect(0, 0, 0, 0), 1000);
        }
        int iWidth = focusRect.width();
        int iHeight = focusRect.height();
        float f = iWidth / width;
        float f4 = iHeight / height;
        int i = ((int) (x * f)) + focusRect.left;
        int i2 = ((int) (y2 * f4)) + focusRect.top;
        int dimensionPixelSize = (int) (getResources().getDimensionPixelSize(C7976R.dimen.camera_auto_focus_size) * f);
        int dimensionPixelSize2 = (int) (getResources().getDimensionPixelSize(C7976R.dimen.camera_auto_focus_size) * f4);
        int i4 = dimensionPixelSize / 2;
        int iClamp = CameraHelper.clamp(i - i4, 0, sensorActualRect.width() - dimensionPixelSize);
        int i5 = dimensionPixelSize2 / 2;
        int iClamp2 = CameraHelper.clamp(i2 - i5, 0, sensorActualRect.height() - dimensionPixelSize2);
        Rect rect = new Rect(iClamp, iClamp2, CameraHelper.clamp(i + i4, iClamp, sensorActualRect.width() - 1), CameraHelper.clamp(i2 + i5, iClamp2, sensorActualRect.height() - 1));
        StringBuilder sbM1173s2 = AbstractC0622a.m1173s(iWidth, iHeight, "getManualFocusArea(), cameraWidth : ", ", cameraHeight : ", " focus on : ");
        sbM1173s2.append(rect);
        Logger.m7145d(TAG, sbM1173s2.toString());
        return new MeteringRectangle(rect, 1000);
    }

    private final Rect getSensorActualRect() {
        CameraCharacteristics cameraCharacteristics;
        Logger.m7145d(TAG, "getSensorActualRect()");
        Object systemService = getContext().getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        CameraManager cameraManager = (CameraManager) systemService;
        try {
            CameraPresenter cameraPresenter = this.mPresenter;
            Intrinsics.checkNotNull(cameraPresenter);
            String mCameraId = cameraPresenter.getMCameraId();
            Intrinsics.checkNotNull(mCameraId);
            cameraCharacteristics = cameraManager.getCameraCharacteristics(mCameraId);
        } catch (CameraAccessException unused) {
            Logger.m7146e(TAG, "getSensorActualRect# CameraAccessException");
            cameraCharacteristics = null;
        }
        if (cameraCharacteristics == null) {
            return null;
        }
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect == null) {
            Logger.m7146e(TAG, "getSensorActualRect# sensorRect is null");
            return null;
        }
        rect.right -= rect.left;
        rect.left = 0;
        rect.bottom -= rect.top;
        rect.top = 0;
        return rect;
    }

    public final void initView(@Nullable Context context, @Nullable CameraPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) throws Throwable {
        MotionEvent motionEventObtain;
        Intrinsics.checkNotNullParameter(event, "event");
        CameraPresenter cameraPresenter = this.mPresenter;
        Intrinsics.checkNotNull(cameraPresenter);
        if (cameraPresenter.getMCameraProperty().getMCameraState() != CameraProperty.CameraState.PREVIEW) {
            return true;
        }
        try {
            motionEventObtain = MotionEvent.obtain(event);
            try {
                int dimensionPixelSize = getResources().getDimensionPixelSize(C7976R.dimen.camera_auto_focus_size);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(C7976R.dimen.camera_auto_focus_size);
                int width = getWidth();
                int height = getHeight();
                ViewParent parent = getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
                if (width > ((FrameLayout) parent).getHeight()) {
                    motionEventObtain.setLocation(CameraHelper.clamp((int) motionEventObtain.getX(), dimensionPixelSize / 2, width - (dimensionPixelSize / 2)), CameraHelper.clamp((int) motionEventObtain.getY(), ((height - r6) / 2) + (dimensionPixelSize2 / 2), height - (dimensionPixelSize2 / 2)));
                } else {
                    motionEventObtain.setLocation(CameraHelper.clamp((int) motionEventObtain.getX(), dimensionPixelSize / 2, width - (dimensionPixelSize / 2)), CameraHelper.clamp((int) motionEventObtain.getY(), dimensionPixelSize2 / 2, height - (dimensionPixelSize2 / 2)));
                }
                CameraPresenter cameraPresenter2 = this.mPresenter;
                Intrinsics.checkNotNull(cameraPresenter2);
                int mOrientation = cameraPresenter2.getMCameraProperty().getMOrientation();
                Intrinsics.checkNotNull(motionEventObtain);
                CameraHelper.transformEventByScreenOrientation(motionEventObtain, mOrientation, width, height);
                if (event.getAction() == 1) {
                    MeteringRectangle manualFocusArea = getManualFocusArea((int) motionEventObtain.getX(), (int) motionEventObtain.getY());
                    CameraPresenter cameraPresenter3 = this.mPresenter;
                    Intrinsics.checkNotNull(cameraPresenter3);
                    cameraPresenter3.autoFocus(manualFocusArea);
                }
                if (motionEventObtain != null) {
                    motionEventObtain.recycle();
                }
                return true;
            } catch (Throwable th) {
                th = th;
                if (motionEventObtain != null) {
                    motionEventObtain.recycle();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            motionEventObtain = null;
        }
    }
}
