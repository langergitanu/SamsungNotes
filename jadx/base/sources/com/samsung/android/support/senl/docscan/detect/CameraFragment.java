package com.samsung.android.support.senl.docscan.detect;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Size;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.CommonUtils;
import com.samsung.android.support.senl.docscan.detect.MainLayout;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.docscan.detect.controller.DetectLibWrapper;
import com.samsung.android.support.senl.docscan.detect.controller.ShutterSoundManager;
import com.samsung.android.support.senl.docscan.detect.presenter.CameraPresenter;
import com.samsung.android.support.senl.docscan.detect.presenter.DetectTask;
import com.samsung.android.support.senl.docscan.detect.presenter.ViewContract;
import com.samsung.android.support.senl.docscan.detect.util.CameraHelper;
import com.samsung.android.support.senl.docscan.detect.view.AutoTextureView;
import com.samsung.android.support.senl.docscan.detect.view.CameraMenu;
import com.samsung.android.support.senl.docscan.detect.view.DetectOverlayView;
import com.samsung.android.support.senl.docscan.dialog.CameraInUseDialog;
import com.samsung.android.support.senl.docscan.dialog.CheckAddToNoteDialog;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.model.ScanDataModel;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.PinnedEdge;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000Ç\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001z\u0018\u0000 ³\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006±\u0001²\u0001³\u0001B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010+J\u0010\u0010L\u001a\u00020J2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010O\u001a\u00020J2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J&\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u001a\u0010X\u001a\u00020J2\u0006\u0010Y\u001a\u00020S2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010Z\u001a\u00020J2\u0006\u0010[\u001a\u00020QH\u0016J\b\u0010\\\u001a\u00020JH\u0016J\b\u0010]\u001a\u00020JH\u0002J\u0010\u0010^\u001a\u00020J2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020JH\u0002J\b\u0010b\u001a\u00020JH\u0016J\u0006\u0010c\u001a\u00020JJ\b\u0010d\u001a\u00020JH\u0002J\b\u0010e\u001a\u00020JH\u0016J\b\u0010f\u001a\u00020JH\u0016J\b\u0010g\u001a\u00020JH\u0002J\b\u0010h\u001a\u00020JH\u0002J\b\u0010i\u001a\u00020JH\u0002J\b\u0010j\u001a\u00020JH\u0002J\b\u0010k\u001a\u00020JH\u0002J\u0018\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020#2\u0006\u0010n\u001a\u00020#H\u0002J\b\u0010o\u001a\u00020JH\u0002J\b\u0010p\u001a\u00020%H\u0002J\u0010\u0010q\u001a\u00020!2\u0006\u0010r\u001a\u00020sH\u0002J\u0018\u0010t\u001a\u00020J2\u0006\u0010m\u001a\u00020#2\u0006\u0010n\u001a\u00020#H\u0002J \u0010u\u001a\u00020!2\u0006\u0010r\u001a\u00020s2\u0006\u0010v\u001a\u00020#2\u0006\u0010w\u001a\u00020#H\u0002J\b\u0010x\u001a\u00020JH\u0002J\b\u0010|\u001a\u00020JH\u0002J\u0010\u0010}\u001a\u00020J2\u0006\u0010~\u001a\u00020\u007fH\u0002J\t\u0010\u0080\u0001\u001a\u00020JH\u0002J\t\u0010\u0081\u0001\u001a\u00020JH\u0002J\t\u0010\u0082\u0001\u001a\u00020JH\u0002J\t\u0010\u0084\u0001\u001a\u00020JH\u0002J\t\u0010\u0085\u0001\u001a\u00020%H\u0002J\t\u0010\u0086\u0001\u001a\u00020JH\u0002J\u0014\u0010\u0087\u0001\u001a\u00020J2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u007fH\u0002J\u001e\u0010\u0089\u0001\u001a\u00020J2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020#H\u0016J\t\u0010\u008d\u0001\u001a\u00020@H\u0016J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u0013\u0010\u0090\u0001\u001a\u00020J2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020J2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001J\u0007\u0010\u0094\u0001\u001a\u00020JJ\u0007\u0010\u0095\u0001\u001a\u00020JJ\u0007\u0010\u009e\u0001\u001a\u00020JJ\u001a\u0010\u009f\u0001\u001a\u00020%2\u0007\u0010 \u0001\u001a\u00020#2\b\u0010¡\u0001\u001a\u00030¢\u0001J\u0010\u0010£\u0001\u001a\u00020J2\u0007\u0010¤\u0001\u001a\u00020%J\u0010\u0010¥\u0001\u001a\u00020J2\u0007\u0010¦\u0001\u001a\u00020%J\u0012\u0010§\u0001\u001a\u00020J2\u0007\u0010¨\u0001\u001a\u00020#H\u0002J\t\u0010©\u0001\u001a\u00020JH\u0002J\t\u0010ª\u0001\u001a\u00020JH\u0002J\t\u0010«\u0001\u001a\u00020JH\u0002J\u0015\u0010¬\u0001\u001a\u00020J2\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001H\u0002J\u0012\u0010¯\u0001\u001a\u00020J2\u0007\u0010°\u0001\u001a\u00020#H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010M\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0010\u0010y\u001a\u00020zX\u0082\u0004¢\u0006\u0004\n\u0002\u0010{R\u0016\u0010\u0083\u0001\u001a\u00020%8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010NR\u001c\u0010\u0096\u0001\u001a\n\u0012\u0005\u0012\u00030\u0098\u00010\u0097\u00018F¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010\u009b\u0001\u001a\u00020#8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001¨\u0006´\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/CameraFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/samsung/android/support/senl/docscan/detect/presenter/ViewContract$Fragment;", "Lcom/samsung/android/support/senl/docscan/detect/MainLayout$OrientationEventListener;", "<init>", "()V", "scanDataModel", "Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;", "(Lcom/samsung/android/support/senl/docscan/model/ScanDataModel;)V", "mCameraOpenCloseLock", "Ljava/util/concurrent/Semaphore;", "mCameraStateLock", "", "mUIHandler", "Landroid/os/Handler;", "mCameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "mCameraDevice", "Landroid/hardware/camera2/CameraDevice;", "mImageReader", "Landroid/media/ImageReader;", "mPictureReader", "mCameraProperty", "Lcom/samsung/android/support/senl/docscan/detect/controller/CameraProperty;", "mDetectOverlayView", "Lcom/samsung/android/support/senl/docscan/detect/view/DetectOverlayView;", "mTextureView", "Lcom/samsung/android/support/senl/docscan/detect/view/AutoTextureView;", "mCameraLayout", "Landroid/widget/FrameLayout;", "mShutterManager", "Lcom/samsung/android/support/senl/docscan/detect/controller/ShutterSoundManager;", "mPreviewSize", "Landroid/util/Size;", "mFlashMode", "", "mAFSupported", "", "mCaptureTimer", "", "mPendingUserCaptures", "mIsTopResumedActivity", "mContract", "Lcom/samsung/android/support/senl/docscan/detect/CameraFragment$Contract;", "mScanDataModel", "mCameraPresenter", "Lcom/samsung/android/support/senl/docscan/detect/presenter/CameraPresenter;", "mCameraMenu", "Lcom/samsung/android/support/senl/docscan/detect/view/CameraMenu;", "mCameraManager", "Landroid/hardware/camera2/CameraManager;", "mPinnedEdge", "Lcom/samsung/android/support/senl/nt/base/common/util/PinnedEdge;", "mIsRunningDetectLib", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mMainLayout", "Lcom/samsung/android/support/senl/docscan/detect/MainLayout;", "mStateChangeListener", "Lcom/samsung/android/support/senl/nt/base/common/util/PinnedEdge$StateChangeListener;", "mSurfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "mCameraStateCallback", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "mPreviewCaptureCallback", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "mPicImageAvailableListener", "Landroid/media/ImageReader$OnImageAvailableListener;", "mIsDetecting", "mOnImageAvailableListener", "mDetectResult", "Lcom/samsung/android/support/senl/docscan/detect/controller/DetectLibWrapper$DetectResult;", "mClickListener", "Landroid/view/View$OnClickListener;", "setContract", "", "contract", "setScanDataModel", "isScanDataModelInitialized", "()Z", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onStart", "setupWindowAttributes", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onResumeCamera", "onStop", "onPauseCamera", "clearDetectView", "onDestroyView", "onDestroy", "startSmartScan", "destroySmartScan", "initCameraLayout", "updateCameraMenuLayout", "adjustTextureView", "openCamera", "viewWidth", "viewHeight", "closeCamera", "setUpCameraOutputs", "setupTextureView", "displaySize", "Landroid/graphics/Point;", "configureTransform", "getAspectRatio", "previewWidth", "previewHeight", "createCameraPreviewSession", "mStateCallback", "com/samsung/android/support/senl/docscan/detect/CameraFragment$mStateCallback$1", "Lcom/samsung/android/support/senl/docscan/detect/CameraFragment$mStateCallback$1;", "captureStillPicture", "setup3AControlsLocked", "requestBuilder", "Landroid/hardware/camera2/CaptureRequest$Builder;", "takePicture", "showRectifyView", "showRectifyListView", "isLegacyLocked", "startTimerLocked", "hitTimeoutLocked", "initFlashMode", "setFlashMode", "captureRequest", "updateThumbnailView", "thumbnailBitmap", "Landroid/graphics/Bitmap;", "scanDataListSize", "getPreviewCaptureCallback", StateHandler.ACTION_GET_APP_STATE, "Landroid/content/Context;", "finishWithSuccess", "cause", "", "finishWithFailed", "restartCameraTimer", "showCheckAddToNoteDialog", "scanDataList", "", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "getScanDataList", "()Ljava/util/List;", "scanDataCount", "getScanDataCount", "()I", "dismissCheckAddToNoteDialog", "onKeyShortcut", "keyCode", "event", "Landroid/view/KeyEvent;", "onTopResumedActivityChanged", "isTopResumedActivity", "onWindowFocusChanged", "hasFocus", "handleCameraAccessException", "errorCode", "handleCameraInUseError", "handleCameraDisabled", "handleCameraDisconnected", "runOnUiThread", "runnable", "Ljava/lang/Runnable;", "onOrientationChanged", "orientation", "Contract", "HandlerExecutor", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCameraFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraFragment.kt\ncom/samsung/android/support/senl/docscan/detect/CameraFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,1321:1\n1#2:1322\n37#3:1323\n36#3,3:1324\n*S KotlinDebug\n*F\n+ 1 CameraFragment.kt\ncom/samsung/android/support/senl/docscan/detect/CameraFragment\n*L\n600#1:1323\n600#1:1324,3\n*E\n"})
public final class CameraFragment extends Fragment implements ViewContract.Fragment, MainLayout.OrientationEventListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long DELAY_FOR_RELEASE_IMAGE = 100;
    private static final long PRECAPTURE_TIMEOUT_MS = 1000;

    @NotNull
    public static final String TAG = "CameraFragment";

    @Nullable
    private static ExecutorService mDetectExecutor;

    @Nullable
    private CameraCharacteristics mCameraCharacteristics;

    @Nullable
    private CameraDevice mCameraDevice;

    @Nullable
    private FrameLayout mCameraLayout;

    @Nullable
    private CameraManager mCameraManager;

    @Nullable
    private CameraMenu mCameraMenu;

    @Nullable
    private CameraPresenter mCameraPresenter;

    @Nullable
    private CameraProperty mCameraProperty;
    private long mCaptureTimer;

    @Nullable
    private Contract mContract;

    @Nullable
    private DetectOverlayView mDetectOverlayView;
    private int mFlashMode;

    @Nullable
    private ImageReader mImageReader;
    private boolean mIsDetecting;
    private boolean mIsTopResumedActivity;

    @Nullable
    private MainLayout mMainLayout;
    private int mPendingUserCaptures;

    @Nullable
    private ImageReader mPictureReader;

    @Nullable
    private PinnedEdge mPinnedEdge;

    @Nullable
    private Size mPreviewSize;

    @Nullable
    private ScanDataModel mScanDataModel;

    @Nullable
    private ShutterSoundManager mShutterManager;

    @Nullable
    private AutoTextureView mTextureView;

    @Nullable
    private Handler mUIHandler;

    @NotNull
    private final Semaphore mCameraOpenCloseLock = new Semaphore(1);

    @NotNull
    private final Object mCameraStateLock = new Object();
    private boolean mAFSupported = true;

    @NotNull
    private final AtomicBoolean mIsRunningDetectLib = new AtomicBoolean();

    @NotNull
    private final PinnedEdge.StateChangeListener mStateChangeListener = new C7737b(this, 10);

    @NotNull
    private final TextureView.SurfaceTextureListener mSurfaceTextureListener = new CameraFragment$mSurfaceTextureListener$1(this);

    @NotNull
    private final CameraDevice.StateCallback mCameraStateCallback = new CameraFragment$mCameraStateCallback$1(this);

    @NotNull
    private final CameraCaptureSession.CaptureCallback mPreviewCaptureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$mPreviewCaptureCallback$1
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0107  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0116 A[Catch: all -> 0x0057, LOOP:0: B:65:0x0110->B:67:0x0116, LOOP_END, TryCatch #0 {, blocks: (B:4:0x000f, B:7:0x0042, B:11:0x0052, B:16:0x005a, B:28:0x007d, B:30:0x00bb, B:35:0x00c5, B:37:0x00cb, B:42:0x00d6, B:48:0x00e3, B:50:0x00ea, B:58:0x00f9, B:60:0x00ff, B:63:0x010a, B:65:0x0110, B:67:0x0116, B:68:0x0123, B:69:0x012f), top: B:74:0x000f }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void process(CaptureResult result) {
            boolean z;
            Object obj = this.this$0.mCameraStateLock;
            CameraFragment cameraFragment = this.this$0;
            synchronized (obj) {
                Integer num = (Integer) result.get(CaptureResult.CONTROL_AE_STATE);
                Integer num2 = (Integer) result.get(CaptureResult.CONTROL_AF_STATE);
                Integer num3 = (Integer) result.get(CaptureResult.CONTROL_AWB_STATE);
                Object obj2 = (Integer) result.get(CaptureResult.FLASH_STATE);
                CameraProperty cameraProperty = cameraFragment.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                boolean z2 = true;
                if (cameraProperty.getMCameraState() == CameraProperty.CameraState.PREVIEW && num != null) {
                    CameraMenu cameraMenu = cameraFragment.mCameraMenu;
                    Intrinsics.checkNotNull(cameraMenu);
                    cameraMenu.setFlashModeActivated(num.intValue() == 4);
                    return;
                }
                CameraProperty cameraProperty2 = cameraFragment.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty2);
                CameraProperty.CameraState mCameraState = cameraProperty2.getMCameraState();
                Object obj3 = num == null ? "null" : num;
                Object obj4 = num2 == null ? "null" : num2;
                Object obj5 = num3 == null ? "null" : num3;
                if (obj2 == null) {
                    obj2 = "null";
                }
                Logger.m7145d("CameraFragment", "CaptureCallback# CameraState : " + mCameraState + ", aeState : " + obj3 + ", afState : " + obj4 + ", awbState : " + obj5 + ", flashMode : " + obj2);
                CameraProperty cameraProperty3 = cameraFragment.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty3);
                if (cameraProperty3.getMCameraState() == CameraProperty.CameraState.WAIT_CONVERGENCE) {
                    if (!cameraFragment.mAFSupported) {
                        z = true;
                        if (!cameraFragment.isLegacyLocked()) {
                            if (num != null && num3 != null) {
                                z = z && num.intValue() == 2 && num3.intValue() == 2;
                            }
                            return;
                        }
                        if (z && cameraFragment.hitTimeoutLocked()) {
                            Logger.m7150w("CameraFragment", "PreviewCallback process# Timed out waiting for pre=capture sequence to completed.");
                        } else {
                            z2 = z;
                        }
                        if (z2 && cameraFragment.mPendingUserCaptures > 0) {
                            while (cameraFragment.mPendingUserCaptures > 0) {
                                cameraFragment.captureStillPicture();
                                cameraFragment.mPendingUserCaptures--;
                            }
                            CameraProperty cameraProperty4 = cameraFragment.mCameraProperty;
                            Intrinsics.checkNotNull(cameraProperty4);
                            cameraProperty4.setMCameraState(CameraProperty.CameraState.PREVIEW);
                        }
                    } else {
                        if (num2 == null) {
                            return;
                        }
                        if (num2.intValue() != 4 && num2.intValue() != 5) {
                            z = false;
                        }
                        if (!cameraFragment.isLegacyLocked()) {
                        }
                        if (z) {
                            z2 = z;
                            if (z2) {
                                while (cameraFragment.mPendingUserCaptures > 0) {
                                }
                                CameraProperty cameraProperty42 = cameraFragment.mCameraProperty;
                                Intrinsics.checkNotNull(cameraProperty42);
                                cameraProperty42.setMCameraState(CameraProperty.CameraState.PREVIEW);
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(result, "result");
            process(result);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession session, CaptureRequest request, CaptureResult partialResult) {
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(partialResult, "partialResult");
            process(partialResult);
        }
    };

    @NotNull
    private final ImageReader.OnImageAvailableListener mPicImageAvailableListener = new CameraFragment$mPicImageAvailableListener$1(this);

    @NotNull
    private final ImageReader.OnImageAvailableListener mOnImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$mOnImageAvailableListener$1
        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader reader) {
            Image imageAcquireLatestImage;
            Intrinsics.checkNotNullParameter(reader, "reader");
            try {
                imageAcquireLatestImage = reader.acquireLatestImage();
            } catch (IllegalStateException e) {
                Logger.m7146e("CameraFragment", "onImageAvailable# acquireLatestImage IllegalStateException, " + e.getMessage());
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return;
            }
            if (!this.this$0.mIsDetecting) {
                CameraProperty cameraProperty = this.this$0.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                if (cameraProperty.getMCameraState() == CameraProperty.CameraState.PREVIEW) {
                    this.this$0.mIsDetecting = true;
                    ByteBuffer buffer = imageAcquireLatestImage.getPlanes()[0].getBuffer();
                    Intrinsics.checkNotNullExpressionValue(buffer, "getBuffer(...)");
                    Handler handler = new Handler(Looper.getMainLooper());
                    final CameraFragment cameraFragment = this.this$0;
                    handler.post(new DetectTask(imageAcquireLatestImage, buffer, new DetectTask.Contract() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$mOnImageAvailableListener$1$onImageAvailable$1
                        @Override // com.samsung.android.support.senl.docscan.detect.presenter.DetectTask.Contract
                        public boolean isRunningDetectLib() {
                            return cameraFragment.mIsRunningDetectLib.get();
                        }
                    }));
                    return;
                }
            }
            imageAcquireLatestImage.close();
        }
    };

    @NotNull
    private final DetectLibWrapper.DetectResult mDetectResult = new DetectLibWrapper.DetectResult() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$mDetectResult$1
        @Override // com.samsung.android.support.senl.docscan.detect.controller.DetectLibWrapper.DetectResult
        public void onSmartScanResult(boolean isDetected, float[] corners) {
            this.this$0.mIsDetecting = false;
            CameraMenu cameraMenu = this.this$0.mCameraMenu;
            Intrinsics.checkNotNull(cameraMenu);
            cameraMenu.activeTakePictureBtn(isDetected);
            if (isDetected) {
                DetectOverlayView detectOverlayView = this.this$0.mDetectOverlayView;
                Intrinsics.checkNotNull(detectOverlayView);
                detectOverlayView.setResult(corners);
            } else {
                DetectOverlayView detectOverlayView2 = this.this$0.mDetectOverlayView;
                Intrinsics.checkNotNull(detectOverlayView2);
                detectOverlayView2.clearCanvas();
            }
        }
    };

    @NotNull
    private final View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$mClickListener$1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.DocumentScan;
            if (UserInputSkipper.isValidEvent(tag) && v.isEnabled()) {
                UserInputSkipper.setHoldingEventTime(1000L, tag);
                int id = v.getId();
                if (id == C7976R.id.take_picture) {
                    this.this$0.takePicture();
                    return;
                }
                if (id == C7976R.id.add_to_note) {
                    if (this.this$0.getScanDataList().isEmpty()) {
                        this.this$0.finishWithFailed("No ScanData");
                        return;
                    } else {
                        this.this$0.finishWithSuccess("Save to note");
                        return;
                    }
                }
                if (id == C7976R.id.thumbnail) {
                    this.this$0.showRectifyView();
                    return;
                }
                if (id == C7976R.id.flash_mode) {
                    CameraMenu cameraMenu = this.this$0.mCameraMenu;
                    Intrinsics.checkNotNull(cameraMenu);
                    cameraMenu.showFlashOptions(0, this.this$0.mFlashMode);
                    return;
                }
                if (id == C7976R.id.flash_auto) {
                    this.this$0.mFlashMode = 2;
                } else if (id == C7976R.id.flash_on) {
                    this.this$0.mFlashMode = 3;
                } else if (id == C7976R.id.flash_off) {
                    this.this$0.mFlashMode = 1;
                }
                CameraFragment cameraFragment = this.this$0;
                CameraPresenter cameraPresenter = cameraFragment.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter);
                cameraFragment.setFlashMode(cameraPresenter.getMCaptureRequestBuilder());
                CameraPresenter cameraPresenter2 = this.this$0.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter2);
                cameraPresenter2.startPreviewRepeating();
                CameraMenu cameraMenu2 = this.this$0.mCameraMenu;
                Intrinsics.checkNotNull(cameraMenu2);
                cameraMenu2.showFlashOptions(8, this.this$0.mFlashMode);
                this.this$0.initFlashMode();
            }
        }
    };

    @NotNull
    private final CameraFragment$mStateCallback$1 mStateCallback = new CameraCaptureSession.StateCallback() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$mStateCallback$1
        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession session) {
            Intrinsics.checkNotNullParameter(session, "session");
            super.onClosed(session);
            CameraPresenter cameraPresenter = this.this$0.mCameraPresenter;
            if (cameraPresenter != null) {
                cameraPresenter.stopBackgroundThread();
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Intrinsics.checkNotNullParameter(cameraCaptureSession, "cameraCaptureSession");
            Logger.m7146e("CameraFragment", "createCameraPreviewSession# onConfigureFailed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Intrinsics.checkNotNullParameter(cameraCaptureSession, "cameraCaptureSession");
            Object obj = this.this$0.mCameraStateLock;
            CameraFragment cameraFragment = this.this$0;
            synchronized (obj) {
                try {
                    if (cameraFragment.mCameraDevice == null) {
                        return;
                    }
                    Logger.m7148i("CameraFragment", "createCameraPreviewSession# onConfigured");
                    cameraFragment.initFlashMode();
                    CameraPresenter cameraPresenter = cameraFragment.mCameraPresenter;
                    CaptureRequest.Builder mCaptureRequestBuilder = cameraPresenter != null ? cameraPresenter.getMCaptureRequestBuilder() : null;
                    Intrinsics.checkNotNull(mCaptureRequestBuilder);
                    try {
                        try {
                            try {
                                cameraFragment.setup3AControlsLocked(mCaptureRequestBuilder);
                                CaptureRequest captureRequestBuild = mCaptureRequestBuilder.build();
                                CameraCaptureSession.CaptureCallback captureCallback = cameraFragment.mPreviewCaptureCallback;
                                CameraPresenter cameraPresenter2 = cameraFragment.mCameraPresenter;
                                cameraCaptureSession.setRepeatingRequest(captureRequestBuild, captureCallback, cameraPresenter2 != null ? cameraPresenter2.getMBackgroundHandler() : null);
                                CameraProperty cameraProperty = cameraFragment.mCameraProperty;
                                if (cameraProperty != null) {
                                    cameraProperty.setMCameraState(CameraProperty.CameraState.PREVIEW);
                                }
                                CameraPresenter cameraPresenter3 = cameraFragment.mCameraPresenter;
                                if (cameraPresenter3 != null) {
                                    cameraPresenter3.setMCameraCaptureSession(cameraCaptureSession);
                                }
                                Unit unit = Unit.INSTANCE;
                            } catch (CameraAccessException e) {
                                Logger.m7146e("CameraFragment", "createCameraPreviewSession# onConfigured : " + e.getMessage());
                            }
                        } catch (IllegalStateException e2) {
                            Logger.m7146e("CameraFragment", "createCameraPreviewSession# onConfigured : " + e2.getMessage());
                        }
                    } catch (SecurityException e3) {
                        Logger.m7146e("CameraFragment", "createCameraPreviewSession# onConfigured : " + e3.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/CameraFragment$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PRECAPTURE_TIMEOUT_MS", "", "DELAY_FOR_RELEASE_IMAGE", "mDetectExecutor", "Ljava/util/concurrent/ExecutorService;", "detectExecutor", "getDetectExecutor", "()Ljava/util/concurrent/ExecutorService;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final synchronized ExecutorService getDetectExecutor() {
            try {
                if (CameraFragment.mDetectExecutor == null) {
                    CameraFragment.mDetectExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory("CameraFragment"));
                }
            } catch (Throwable th) {
                throw th;
            }
            return CameraFragment.mDetectExecutor;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/CameraFragment$Contract;", "", "showRectifyEditView", "", "docScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", NotesConstants.KEY_CALLER, "", "showRectifyListView", "finishWithFailed", "cause", "finishWithSuccess", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void finishWithFailed(@Nullable String cause);

        void finishWithSuccess(@Nullable String cause);

        void showRectifyEditView(@Nullable DocScanData docScanData, @Nullable String caller);

        void showRectifyListView();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/CameraFragment$HandlerExecutor;", "Ljava/util/concurrent/Executor;", "mHandler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "execute", "", "runCmd", "Ljava/lang/Runnable;", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class HandlerExecutor implements Executor {

        @Nullable
        private final Handler mHandler;

        public HandlerExecutor(@Nullable Handler handler) {
            this.mHandler = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NotNull Runnable runCmd) {
            Intrinsics.checkNotNullParameter(runCmd, "runCmd");
            try {
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.post(runCmd);
                }
            } catch (RejectedExecutionException unused) {
                Logger.m7146e("CameraFragment", "Handler thread unavailable, skipping message!");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.samsung.android.support.senl.docscan.detect.CameraFragment$mStateCallback$1] */
    public CameraFragment() {
    }

    private final void adjustTextureView() {
        FragmentActivity activity = getActivity();
        if (CommonUtils.isNotAvailableActivity(activity)) {
            return;
        }
        if (this.mTextureView == null) {
            this.mTextureView = new AutoTextureView(getContext(), this.mCameraPresenter);
            FrameLayout frameLayout = this.mCameraLayout;
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.addView(this.mTextureView, 0);
        }
        Intrinsics.checkNotNull(activity);
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getDefaultDisplay(...)");
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        cameraProperty.setMOrientation(CameraHelper.INSTANCE.getORIENTATIONS().get(defaultDisplay.getRotation()));
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        Size size = setupTextureView(point);
        configureTransform(size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void captureStillPicture() {
        try {
            if (this.mCameraDevice != null) {
                CameraProperty cameraProperty = this.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                if (cameraProperty.getMCameraState() != CameraProperty.CameraState.WAIT_CONVERGENCE) {
                    return;
                }
                Logger.m7148i("CameraFragment", "captureStillPicture");
                ShutterSoundManager shutterSoundManager = this.mShutterManager;
                Intrinsics.checkNotNull(shutterSoundManager);
                shutterSoundManager.playShutterSound();
                CameraMenu cameraMenu = this.mCameraMenu;
                Intrinsics.checkNotNull(cameraMenu);
                cameraMenu.performHapticTakePicture(48);
                CameraDevice cameraDevice = this.mCameraDevice;
                Intrinsics.checkNotNull(cameraDevice);
                CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(2);
                Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "createCaptureRequest(...)");
                ImageReader imageReader = this.mPictureReader;
                Intrinsics.checkNotNull(imageReader);
                builderCreateCaptureRequest.addTarget(imageReader.getSurface());
                setup3AControlsLocked(builderCreateCaptureRequest);
                CameraProperty cameraProperty2 = this.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty2);
                CameraProperty cameraProperty3 = this.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty3);
                int mOrientation = cameraProperty3.getMOrientation();
                CameraPresenter cameraPresenter = this.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter);
                Integer mSensorOrientation = cameraPresenter.getMSensorOrientation();
                Intrinsics.checkNotNull(mSensorOrientation);
                cameraProperty2.setMJpegOrientation(CameraHelper.getCameraOrientation(mOrientation, mSensorOrientation.intValue()));
                CameraPresenter cameraPresenter2 = this.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter2);
                final CameraCaptureSession mCameraCaptureSession = cameraPresenter2.getMCameraCaptureSession();
                Intrinsics.checkNotNull(mCameraCaptureSession);
                CaptureRequest.Key key = CaptureRequest.JPEG_ORIENTATION;
                CameraProperty cameraProperty4 = this.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty4);
                builderCreateCaptureRequest.set(key, Integer.valueOf(cameraProperty4.getMJpegOrientation()));
                CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$captureStillPicture$pictureCallback$1
                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) throws CameraAccessException {
                        Intrinsics.checkNotNullParameter(session, "session");
                        Intrinsics.checkNotNullParameter(request, "request");
                        Intrinsics.checkNotNullParameter(result, "result");
                        CameraProperty cameraProperty5 = this.this$0.mCameraProperty;
                        Intrinsics.checkNotNull(cameraProperty5);
                        if (cameraProperty5.getMCameraState() != CameraProperty.CameraState.CLOSED) {
                            mCameraCaptureSession.abortCaptures();
                        }
                        Logger.m7148i("CameraFragment", "captureStillPicture# onCaptureCompleted");
                    }

                    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
                    public void onCaptureFailed(CameraCaptureSession session, CaptureRequest request, CaptureFailure failure) {
                        Intrinsics.checkNotNullParameter(session, "session");
                        Intrinsics.checkNotNullParameter(request, "request");
                        Intrinsics.checkNotNullParameter(failure, "failure");
                        Logger.m7146e("CameraFragment", "captureStillPicture# onCaptureFailed : " + failure + ", reason: " + failure.getReason());
                        this.this$0.finishWithFailed("onCaptureFailed");
                    }
                };
                ImageReader imageReader2 = this.mImageReader;
                Intrinsics.checkNotNull(imageReader2);
                imageReader2.setOnImageAvailableListener(null, null);
                mCameraCaptureSession.stopRepeating();
                new Handler(Looper.getMainLooper()).post(new RunnableC0218a(7, mCameraCaptureSession, builderCreateCaptureRequest, captureCallback, this));
            }
        } catch (CameraAccessException e) {
            Logger.m7146e("CameraFragment", "captureStillPicture# CameraAccessException : " + e.getMessage());
        } catch (IllegalArgumentException e2) {
            Logger.m7146e("CameraFragment", "captureStillPicture# IllegalArgumentException : " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void captureStillPicture$lambda$6(CameraCaptureSession cameraCaptureSession, CaptureRequest.Builder builder, CameraCaptureSession.CaptureCallback captureCallback, CameraFragment cameraFragment) {
        try {
            CaptureRequest captureRequestBuild = builder.build();
            CameraPresenter cameraPresenter = cameraFragment.mCameraPresenter;
            Intrinsics.checkNotNull(cameraPresenter);
            cameraCaptureSession.capture(captureRequestBuild, captureCallback, cameraPresenter.getMBackgroundHandler());
        } catch (CameraAccessException e) {
            Logger.m7146e("CameraFragment", "captureStillPicture# mainThread CameraAccessException : " + e.getMessage());
        } catch (IllegalArgumentException e2) {
            Logger.m7146e("CameraFragment", "captureStillPicture# mainThread IllegalArgumentException : " + e2.getMessage());
        } catch (Exception e3) {
            Logger.m7146e("CameraFragment", "captureStillPicture# mainThread: " + e3.getMessage());
        }
    }

    private final void clearDetectView() {
        this.mIsDetecting = false;
        DetectOverlayView detectOverlayView = this.mDetectOverlayView;
        Intrinsics.checkNotNull(detectOverlayView);
        detectOverlayView.setResult(null);
    }

    private final void closeCamera() {
        try {
            try {
                Logger.m7148i("CameraFragment", "closeCamera");
                ShutterSoundManager shutterSoundManager = this.mShutterManager;
                if (shutterSoundManager != null) {
                    Intrinsics.checkNotNull(shutterSoundManager);
                    shutterSoundManager.releaseShutterSound();
                }
                this.mCameraOpenCloseLock.acquire();
                synchronized (this.mCameraStateLock) {
                    try {
                        this.mPendingUserCaptures = 0;
                        CameraProperty cameraProperty = this.mCameraProperty;
                        Intrinsics.checkNotNull(cameraProperty);
                        cameraProperty.setMCameraState(CameraProperty.CameraState.CLOSED);
                        CameraPresenter cameraPresenter = this.mCameraPresenter;
                        Intrinsics.checkNotNull(cameraPresenter);
                        cameraPresenter.closeCameraImpl();
                        CameraDevice cameraDevice = this.mCameraDevice;
                        if (cameraDevice != null) {
                            Intrinsics.checkNotNull(cameraDevice);
                            cameraDevice.close();
                            this.mCameraDevice = null;
                        }
                        ImageReader imageReader = this.mImageReader;
                        if (imageReader != null) {
                            Intrinsics.checkNotNull(imageReader);
                            imageReader.close();
                            this.mImageReader = null;
                        }
                        ImageReader imageReader2 = this.mPictureReader;
                        if (imageReader2 != null) {
                            Intrinsics.checkNotNull(imageReader2);
                            imageReader2.close();
                            this.mPictureReader = null;
                        }
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                Logger.m7146e("CameraFragment", "Interrupted while trying to lock camera closing.");
            }
            this.mCameraOpenCloseLock.release();
            runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment.closeCamera.2
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraFragment.this.mTextureView != null) {
                        CameraProperty cameraProperty2 = CameraFragment.this.mCameraProperty;
                        Intrinsics.checkNotNull(cameraProperty2);
                        if (cameraProperty2.getMCameraState() == CameraProperty.CameraState.OPENED) {
                            return;
                        }
                        FrameLayout frameLayout = CameraFragment.this.mCameraLayout;
                        Intrinsics.checkNotNull(frameLayout);
                        frameLayout.removeView(CameraFragment.this.mTextureView);
                        CameraFragment.this.mTextureView = null;
                        FrameLayout frameLayout2 = CameraFragment.this.mCameraLayout;
                        Intrinsics.checkNotNull(frameLayout2);
                        frameLayout2.setKeepScreenOn(false);
                    }
                }
            });
        } catch (Throwable th) {
            this.mCameraOpenCloseLock.release();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureTransform(int viewWidth, int viewHeight) {
        if (this.mTextureView == null || this.mPreviewSize == null) {
            return;
        }
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        int mOrientation = (360 - cameraProperty.getMOrientation()) % PopOverActivityWrapper.DEFAULT_WIDTH;
        Matrix matrix = new Matrix();
        float f = viewWidth;
        float f4 = viewHeight;
        RectF rectF = new RectF(0.0f, 0.0f, f, f4);
        Size size = this.mPreviewSize;
        Intrinsics.checkNotNull(size);
        float height = size.getHeight();
        Intrinsics.checkNotNull(this.mPreviewSize);
        RectF rectF2 = new RectF(0.0f, 0.0f, height, r8.getWidth());
        float fCenterX = rectF.centerX();
        float fCenterY = rectF.centerY();
        Point point = new Point();
        requireActivity().getWindowManager().getDefaultDisplay().getRealSize(point);
        if (!CameraHelper.isLandscape(point.x, point.y)) {
            DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
            if (companion.getInstance().isDexDualModeOnScreen(getContext()) && companion.getInstance().isDexDualModeConnected(getContext())) {
                rectF2.offset(fCenterX - rectF2.centerX(), fCenterY - rectF2.centerY());
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                Intrinsics.checkNotNull(this.mPreviewSize);
                float height2 = f4 / r2.getHeight();
                Intrinsics.checkNotNull(this.mPreviewSize);
                float fMax = Math.max(height2, f / r2.getWidth());
                matrix.postScale(fMax, fMax, fCenterX, fCenterY);
            }
        }
        DetectOverlayView detectOverlayView = this.mDetectOverlayView;
        Intrinsics.checkNotNull(detectOverlayView);
        CameraProperty cameraProperty2 = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty2);
        detectOverlayView.setTransform(matrix, cameraProperty2.getMOrientation(), point, new Size(viewWidth, viewHeight));
        Logger.m7145d("CameraFragment", "configureTransform# viewRotation : " + mOrientation + ", PreviewSize : " + this.mPreviewSize + ", viewWidth : " + viewWidth + ", viewHeight : " + viewHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createCameraPreviewSession() {
        try {
            Logger.m7148i("CameraFragment", "createCameraPreviewSession");
            if (this.mImageReader != null && this.mPictureReader != null) {
                AutoTextureView autoTextureView = this.mTextureView;
                Intrinsics.checkNotNull(autoTextureView);
                SurfaceTexture surfaceTexture = autoTextureView.getSurfaceTexture();
                if (surfaceTexture == null) {
                    Logger.m7146e("CameraFragment", "surfaceTexture is null");
                    return;
                }
                Size size = this.mPreviewSize;
                Intrinsics.checkNotNull(size);
                int width = size.getWidth();
                Size size2 = this.mPreviewSize;
                Intrinsics.checkNotNull(size2);
                surfaceTexture.setDefaultBufferSize(width, size2.getHeight());
                Surface surface = new Surface(surfaceTexture);
                ImageReader imageReader = this.mImageReader;
                Intrinsics.checkNotNull(imageReader);
                Surface surface2 = imageReader.getSurface();
                Intrinsics.checkNotNullExpressionValue(surface2, "getSurface(...)");
                CameraDevice cameraDevice = this.mCameraDevice;
                Intrinsics.checkNotNull(cameraDevice);
                CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(1);
                Intrinsics.checkNotNullExpressionValue(builderCreateCaptureRequest, "createCaptureRequest(...)");
                builderCreateCaptureRequest.addTarget(surface);
                builderCreateCaptureRequest.addTarget(surface2);
                CameraPresenter cameraPresenter = this.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter);
                cameraPresenter.setMCaptureRequestBuilder(builderCreateCaptureRequest);
                if (Build.VERSION.SDK_INT < 34) {
                    CameraDevice cameraDevice2 = this.mCameraDevice;
                    if (cameraDevice2 != null) {
                        ImageReader imageReader2 = this.mPictureReader;
                        Intrinsics.checkNotNull(imageReader2);
                        List<Surface> listMutableListOf = CollectionsKt.mutableListOf(surface, surface2, imageReader2.getSurface());
                        CameraFragment$mStateCallback$1 cameraFragment$mStateCallback$1 = this.mStateCallback;
                        CameraPresenter cameraPresenter2 = this.mCameraPresenter;
                        cameraDevice2.createCaptureSession(listMutableListOf, cameraFragment$mStateCallback$1, cameraPresenter2 != null ? cameraPresenter2.getMBackgroundHandler() : null);
                        return;
                    }
                    return;
                }
                Logger.m7145d("CameraFragment", "createCameraPreviewSession# API version is higher than UPSIDE_DOWN_CAKE, so use SessionConfiguration.");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new OutputConfiguration(surface));
                arrayList.add(new OutputConfiguration(surface2));
                ImageReader imageReader3 = this.mPictureReader;
                Surface surface3 = imageReader3 != null ? imageReader3.getSurface() : null;
                Intrinsics.checkNotNull(surface3);
                arrayList.add(new OutputConfiguration(surface3));
                AbstractC7150s.m5493A();
                CameraPresenter cameraPresenter3 = this.mCameraPresenter;
                SessionConfiguration sessionConfigurationM5508l = AbstractC7150s.m5508l(arrayList, new HandlerExecutor(cameraPresenter3 != null ? cameraPresenter3.getMBackgroundHandler() : null), this.mStateCallback);
                CameraDevice cameraDevice3 = this.mCameraDevice;
                if (cameraDevice3 != null) {
                    cameraDevice3.createCaptureSession(sessionConfigurationM5508l);
                }
            }
        } catch (CameraAccessException e) {
            Logger.m7146e("CameraFragment", "createCameraPreviewSession# CameraAccessException : " + e.getMessage());
        }
    }

    private final void destroySmartScan() {
        DetectLibWrapper.destroyEngine();
        DetectLibWrapper.release();
        this.mIsRunningDetectLib.set(false);
        Logger.m7145d("CameraFragment", "destroySmartScan");
    }

    private final Size getAspectRatio(Point displaySize, int previewWidth, int previewHeight) {
        int i = displaySize.x;
        int i2 = displaySize.y;
        if (i < (i2 * previewWidth) / previewHeight) {
            displaySize.y = (i * previewHeight) / previewWidth;
        } else {
            displaySize.x = (i2 * previewWidth) / previewHeight;
        }
        return new Size(displaySize.x, displaySize.y);
    }

    private final int getScanDataCount() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return 0;
        }
        Intrinsics.checkNotNull(scanDataModel);
        return scanDataModel.getScanDataCount();
    }

    private final void handleCameraAccessException(int errorCode) {
        Logger.m7145d("CameraFragment", "handleCameraAccessException# errorCode " + errorCode);
        if (errorCode == 1) {
            handleCameraDisabled();
            return;
        }
        if (errorCode == 2 || errorCode == 3) {
            handleCameraDisconnected();
            return;
        }
        if (errorCode == 4 || errorCode == 5) {
            handleCameraInUseError();
            return;
        }
        Logger.m7146e("CameraFragment", "handleCameraAccessException# unexpected errorCode " + errorCode);
    }

    private final void handleCameraDisabled() {
        Context context = getContext();
        if (context != null) {
            String string = context.getString(C7976R.string.camera_access_error_camera_security_policy_prevents_use_of_ps, context.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C7976R.string.notes_jp : C7976R.string.notes));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 0);
        }
        runOnUiThread(new RunnableC7980a(this, 0));
    }

    private final void handleCameraDisconnected() {
        synchronized (this.mCameraStateLock) {
            CameraProperty cameraProperty = this.mCameraProperty;
            Intrinsics.checkNotNull(cameraProperty);
            if (cameraProperty.getMCameraState() != CameraProperty.CameraState.CLOSED) {
                Logger.m7145d("CameraFragment", "handleCameraDisconnected# Camera will be paused.");
                onPauseCamera();
                return;
            }
            Logger.m7145d("CameraFragment", "handleCameraDisconnected# Camera was already paused.");
            if (this.mIsTopResumedActivity) {
                Logger.m7148i("CameraFragment", "handleCameraDisconnected# Camera should try to open the camera again!");
                onResumeCamera();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void handleCameraInUseError() {
        CameraInUseDialog cameraInUseDialog = new CameraInUseDialog();
        cameraInUseDialog.setContract(new CameraInUseDialog.Contract() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment.handleCameraInUseError.1
            @Override // com.samsung.android.support.senl.docscan.dialog.CameraInUseDialog.Contract
            public void onDismissed() {
                CameraFragment.this.finishWithFailed("handleCameraInUseError");
            }
        });
        cameraInUseDialog.show(getChildFragmentManager(), CameraInUseDialog.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hitTimeoutLocked() {
        return SystemClock.elapsedRealtime() - this.mCaptureTimer > 1000;
    }

    private final void initCameraLayout() {
        adjustTextureView();
        updateCameraMenuLayout();
        CameraMenu cameraMenu = this.mCameraMenu;
        Intrinsics.checkNotNull(cameraMenu);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        cameraMenu.updateFlashLayout(contextRequireContext, CameraHelper.INSTANCE.getORIENTATIONS().get(requireActivity().getWindowManager().getDefaultDisplay().getRotation()));
        initFlashMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initFlashMode() {
        if (this.mFlashMode == -1) {
            return;
        }
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        this.mFlashMode = cameraProperty.getFlashMode();
        CameraMenu cameraMenu = this.mCameraMenu;
        Intrinsics.checkNotNull(cameraMenu);
        cameraMenu.showFlashOptions(8, this.mFlashMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLegacyLocked() {
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        Intrinsics.checkNotNull(cameraCharacteristics);
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        return num != null && num.intValue() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mStateChangeListener$lambda$0(CameraFragment cameraFragment, boolean z) {
        SystemUi.setImmersiveModeEnable(cameraFragment.getActivity(), z);
    }

    private final void onResumeCamera() {
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        Logger.m7145d("CameraFragment", "onResumeCamera states : " + cameraProperty.getMCameraState());
        CameraProperty cameraProperty2 = this.mCameraProperty;
        CameraProperty.CameraState mCameraState = cameraProperty2 != null ? cameraProperty2.getMCameraState() : null;
        CameraProperty.CameraState cameraState = CameraProperty.CameraState.CLOSED;
        if (mCameraState != cameraState) {
            Logger.m7145d("CameraFragment", "onResumeCamera : Camera already open");
            return;
        }
        CameraMenu cameraMenu = this.mCameraMenu;
        Intrinsics.checkNotNull(cameraMenu);
        cameraMenu.showCameraMenu();
        CameraPresenter cameraPresenter = this.mCameraPresenter;
        Intrinsics.checkNotNull(cameraPresenter);
        cameraPresenter.restartCameraTimer();
        runOnUiThread(new RunnableC7980a(this, 2));
        CameraPresenter cameraPresenter2 = this.mCameraPresenter;
        if (cameraPresenter2 != null) {
            cameraPresenter2.startBackgroundThread();
        }
        if (!setUpCameraOutputs()) {
            finishWithFailed("setUpCameraOutputs failed");
            return;
        }
        this.mIsRunningDetectLib.set(true);
        initCameraLayout();
        AutoTextureView autoTextureView = this.mTextureView;
        if (autoTextureView == null) {
            Logger.m7146e("CameraFragment", "onResumeCamera# mTextureView is null");
            return;
        }
        Intrinsics.checkNotNull(autoTextureView);
        if (autoTextureView.isAvailable()) {
            CameraProperty cameraProperty3 = this.mCameraProperty;
            Intrinsics.checkNotNull(cameraProperty3);
            if (cameraProperty3.getMCameraState() == cameraState) {
                AutoTextureView autoTextureView2 = this.mTextureView;
                Intrinsics.checkNotNull(autoTextureView2);
                int width = autoTextureView2.getWidth();
                AutoTextureView autoTextureView3 = this.mTextureView;
                Intrinsics.checkNotNull(autoTextureView3);
                openCamera(width, autoTextureView3.getHeight());
                return;
            }
        }
        AutoTextureView autoTextureView4 = this.mTextureView;
        Intrinsics.checkNotNull(autoTextureView4);
        autoTextureView4.setSurfaceTextureListener(this.mSurfaceTextureListener);
        createCameraPreviewSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResumeCamera$lambda$2(CameraFragment cameraFragment) {
        FrameLayout frameLayout = cameraFragment.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        frameLayout.setKeepScreenOn(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openCamera(int viewWidth, int viewHeight) {
        String[] strArr = (String[]) ArraysKt.filterNotNull(PermissionCompat.getStoragePermissions(8)).toArray(new String[0]);
        if (PermissionHelper.isPermissionGrantedWithoutNotice(getContext(), (String[]) Arrays.copyOf(strArr, strArr.length))) {
            Logger.m7148i("CameraFragment", "openCamera# viewWith : " + viewWidth + ", viewHeight : " + viewHeight);
            if (this.mCameraManager == null) {
                return;
            }
            if (this.mShutterManager == null) {
                this.mShutterManager = new ShutterSoundManager();
            }
            ShutterSoundManager shutterSoundManager = this.mShutterManager;
            Intrinsics.checkNotNull(shutterSoundManager);
            shutterSoundManager.loadShutterSound();
            try {
                CameraManager cameraManager = this.mCameraManager;
                Intrinsics.checkNotNull(cameraManager);
                CameraPresenter cameraPresenter = this.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter);
                String mCameraId = cameraPresenter.getMCameraId();
                Intrinsics.checkNotNull(mCameraId);
                CameraDevice.StateCallback stateCallback = this.mCameraStateCallback;
                CameraPresenter cameraPresenter2 = this.mCameraPresenter;
                Intrinsics.checkNotNull(cameraPresenter2);
                cameraManager.openCamera(mCameraId, stateCallback, cameraPresenter2.getMBackgroundHandler());
            } catch (CameraAccessException e) {
                Logger.m7146e("CameraFragment", "openCamera# CameraAccessException : " + e.getMessage());
                handleCameraAccessException(e.getReason());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.mUIHandler;
        Intrinsics.checkNotNull(handler);
        handler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFlashMode(CaptureRequest.Builder captureRequest) {
        boolean z;
        int i = this.mFlashMode;
        if (i == -1 || captureRequest == null) {
            Logger.m7146e("CameraFragment", "setFlashMode# FLASH_UNAVAILABLE or captureRequest is null");
            return;
        }
        Logger.m7145d("CameraFragment", "setFlashMode# flashMode : " + i);
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        Intrinsics.checkNotNull(cameraCharacteristics);
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        boolean z2 = false;
        int i2 = 1;
        if (CameraHelper.modeContains(iArr, 2)) {
            z = false;
            z2 = true;
        } else {
            z = CameraHelper.modeContains(iArr, 3);
        }
        int i4 = this.mFlashMode;
        if (i4 == 2 ? z2 : i4 != 3 || z || z2) {
            i2 = i4;
        }
        captureRequest.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(i2));
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        cameraProperty.setFlashMode(this.mFlashMode);
    }

    private final boolean setUpCameraOutputs() {
        StreamConfigurationMap streamConfigurationMap;
        CameraManager cameraManager = this.mCameraManager;
        if (cameraManager == null) {
            Logger.m7146e("CameraFragment", "setUpCameraOutputs# camera is null");
            return false;
        }
        try {
            Intrinsics.checkNotNull(cameraManager);
            String[] cameraIdList = cameraManager.getCameraIdList();
            Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
            for (String str : cameraIdList) {
                try {
                    CameraManager cameraManager2 = this.mCameraManager;
                    Intrinsics.checkNotNull(cameraManager2);
                    CameraCharacteristics cameraCharacteristics = cameraManager2.getCameraCharacteristics(str);
                    Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if ((num == null || num.intValue() != 0) && (streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)) != null) {
                        synchronized (this.mCameraStateLock) {
                            try {
                                CameraPresenter cameraPresenter = this.mCameraPresenter;
                                Intrinsics.checkNotNull(cameraPresenter);
                                cameraPresenter.setMSensorOrientation((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION));
                                Point point = new Point();
                                requireActivity().getWindowManager().getDefaultDisplay().getRealSize(point);
                                int i = point.x;
                                int i2 = point.y;
                                CameraPresenter cameraPresenter2 = this.mCameraPresenter;
                                Intrinsics.checkNotNull(cameraPresenter2);
                                Size previewSize = cameraPresenter2.setPreviewSize(streamConfigurationMap, i, i2);
                                Intrinsics.checkNotNull(previewSize, "null cannot be cast to non-null type android.util.Size");
                                this.mPreviewSize = previewSize;
                                Intrinsics.checkNotNull(previewSize);
                                int width = previewSize.getWidth();
                                Size size = this.mPreviewSize;
                                Intrinsics.checkNotNull(size);
                                ImageReader imageReaderNewInstance = ImageReader.newInstance(width, size.getHeight(), 35, 2);
                                this.mImageReader = imageReaderNewInstance;
                                Intrinsics.checkNotNull(imageReaderNewInstance);
                                ImageReader.OnImageAvailableListener onImageAvailableListener = this.mOnImageAvailableListener;
                                CameraPresenter cameraPresenter3 = this.mCameraPresenter;
                                Intrinsics.checkNotNull(cameraPresenter3);
                                imageReaderNewInstance.setOnImageAvailableListener(onImageAvailableListener, cameraPresenter3.getMBackgroundHandler());
                                CameraPresenter cameraPresenter4 = this.mCameraPresenter;
                                Intrinsics.checkNotNull(cameraPresenter4);
                                Size size2 = this.mPreviewSize;
                                Intrinsics.checkNotNull(size2);
                                Size pictureSize = cameraPresenter4.setPictureSize(streamConfigurationMap, size2);
                                if (pictureSize != null) {
                                    ImageReader imageReaderNewInstance2 = ImageReader.newInstance(pictureSize.getWidth(), pictureSize.getHeight(), 256, 2);
                                    this.mPictureReader = imageReaderNewInstance2;
                                    if (imageReaderNewInstance2 != null) {
                                        ImageReader.OnImageAvailableListener onImageAvailableListener2 = this.mPicImageAvailableListener;
                                        CameraPresenter cameraPresenter5 = this.mCameraPresenter;
                                        imageReaderNewInstance2.setOnImageAvailableListener(onImageAvailableListener2, cameraPresenter5 != null ? cameraPresenter5.getMBackgroundHandler() : null);
                                    }
                                    Object obj = cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                                    Intrinsics.checkNotNull(obj);
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    this.mFlashMode = zBooleanValue ? 1 : -1;
                                    this.mCameraCharacteristics = cameraCharacteristics;
                                    CameraPresenter cameraPresenter6 = this.mCameraPresenter;
                                    Intrinsics.checkNotNull(cameraPresenter6);
                                    cameraPresenter6.setMCameraId(str);
                                    Logger.m7148i("CameraFragment", "setUpCameraOutputs# cameraId : " + str + ", cameraCharacteristics : " + cameraCharacteristics + ", flashAvailable : " + zBooleanValue);
                                }
                                Unit unit = Unit.INSTANCE;
                            } finally {
                            }
                        }
                        return true;
                    }
                } catch (IllegalArgumentException e) {
                    Logger.m7146e("CameraFragment", "setUpCameraOutputs# IllegalArgumentException: " + e.getMessage());
                }
            }
        } catch (CameraAccessException e2) {
            Logger.m7146e("CameraFragment", "setUpCameraOutputs# CameraAccessException : " + e2.getMessage());
        }
        Logger.m7146e("CameraFragment", "setUpCameraOutputs# Cannot found camera id");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setup3AControlsLocked(CaptureRequest.Builder requestBuilder) {
        requestBuilder.set(CaptureRequest.CONTROL_MODE, 1);
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        Intrinsics.checkNotNull(cameraCharacteristics);
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        boolean z = f != null && f.floatValue() > 0.0f;
        this.mAFSupported = z;
        Logger.m7145d("CameraFragment", "setup3AControlsLocked# mAFSupported : " + z);
        if (this.mAFSupported) {
            CameraCharacteristics cameraCharacteristics2 = this.mCameraCharacteristics;
            Intrinsics.checkNotNull(cameraCharacteristics2);
            if (CameraHelper.modeContains((int[]) cameraCharacteristics2.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES), 4)) {
                requestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            } else {
                requestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 1);
            }
        }
        setFlashMode(requestBuilder);
        CameraCharacteristics cameraCharacteristics3 = this.mCameraCharacteristics;
        Intrinsics.checkNotNull(cameraCharacteristics3);
        if (CameraHelper.modeContains((int[]) cameraCharacteristics3.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES), 1)) {
            requestBuilder.set(CaptureRequest.CONTROL_AWB_MODE, 1);
        }
    }

    private final Size setupTextureView(Point displaySize) {
        Size aspectRatio;
        AutoTextureView autoTextureView = this.mTextureView;
        Intrinsics.checkNotNull(autoTextureView);
        ViewGroup.LayoutParams layoutParams = autoTextureView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (getResources().getConfiguration().orientation == 2) {
            Size size = this.mPreviewSize;
            Intrinsics.checkNotNull(size);
            int width = size.getWidth();
            Size size2 = this.mPreviewSize;
            Intrinsics.checkNotNull(size2);
            aspectRatio = getAspectRatio(displaySize, width, size2.getHeight());
            layoutParams2.width = aspectRatio.getHeight();
            layoutParams2.height = aspectRatio.getWidth();
        } else {
            Size size3 = this.mPreviewSize;
            Intrinsics.checkNotNull(size3);
            int height = size3.getHeight();
            Size size4 = this.mPreviewSize;
            Intrinsics.checkNotNull(size4);
            aspectRatio = getAspectRatio(displaySize, height, size4.getWidth());
            layoutParams2.width = aspectRatio.getWidth();
            layoutParams2.height = aspectRatio.getHeight();
        }
        layoutParams2.gravity = 17;
        AutoTextureView autoTextureView2 = this.mTextureView;
        Intrinsics.checkNotNull(autoTextureView2);
        autoTextureView2.setLayoutParams(layoutParams2);
        Logger.m7145d("CameraFragment", "setupTextureView# textureViewSize : " + aspectRatio);
        return aspectRatio;
    }

    private final void setupWindowAttributes() {
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 512);
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.setNavigationBarColor(0);
        attributes.rotationAnimation = 2;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRectifyListView() {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        Intrinsics.checkNotNull(contract);
        contract.showRectifyListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRectifyView() {
        CameraPresenter cameraPresenter = this.mCameraPresenter;
        Intrinsics.checkNotNull(cameraPresenter);
        Handler mBackgroundHandler = cameraPresenter.getMBackgroundHandler();
        Intrinsics.checkNotNull(mBackgroundHandler);
        mBackgroundHandler.post(new RunnableC7980a(this, 1));
    }

    private final void startSmartScan() {
        boolean zCreateEngine = DetectLibWrapper.createEngine();
        DetectLibWrapper.setDetectListener(this.mDetectResult);
        this.mIsRunningDetectLib.set(true);
        Logger.m7145d("CameraFragment", "startSmartScan# result : " + zCreateEngine);
    }

    private final void startTimerLocked() {
        this.mCaptureTimer = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void takePicture() {
        CameraCaptureSession mCameraCaptureSession;
        synchronized (this.mCameraStateLock) {
            try {
                this.mPendingUserCaptures++;
                CameraProperty cameraProperty = this.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                if (cameraProperty.getMCameraState() != CameraProperty.CameraState.PREVIEW) {
                    return;
                }
                try {
                    Logger.m7145d("CameraFragment", "takePicture()");
                    CameraMenu cameraMenu = this.mCameraMenu;
                    Intrinsics.checkNotNull(cameraMenu);
                    cameraMenu.performHapticTakePicture(37);
                    CameraPresenter cameraPresenter = this.mCameraPresenter;
                    Intrinsics.checkNotNull(cameraPresenter);
                    CaptureRequest.Builder mCaptureRequestBuilder = cameraPresenter.getMCaptureRequestBuilder();
                    Intrinsics.checkNotNull(mCaptureRequestBuilder);
                    if (this.mAFSupported) {
                        mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                    }
                    if (!isLegacyLocked()) {
                        mCaptureRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
                    }
                    CameraProperty cameraProperty2 = this.mCameraProperty;
                    Intrinsics.checkNotNull(cameraProperty2);
                    cameraProperty2.setMCameraState(CameraProperty.CameraState.WAIT_CONVERGENCE);
                    startTimerLocked();
                    CameraPresenter cameraPresenter2 = this.mCameraPresenter;
                    if (cameraPresenter2 != null && (mCameraCaptureSession = cameraPresenter2.getMCameraCaptureSession()) != null) {
                        CaptureRequest captureRequestBuild = mCaptureRequestBuilder.build();
                        CameraCaptureSession.CaptureCallback captureCallback = this.mPreviewCaptureCallback;
                        CameraPresenter cameraPresenter3 = this.mCameraPresenter;
                        mCameraCaptureSession.capture(captureRequestBuild, captureCallback, cameraPresenter3 != null ? cameraPresenter3.getMBackgroundHandler() : null);
                    }
                } catch (CameraAccessException unused) {
                    Logger.m7146e("CameraFragment", "takePicture# CameraAccessException");
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void updateCameraMenuLayout() {
        runOnUiThread(new RunnableC7980a(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCameraMenuLayout$lambda$3(CameraFragment cameraFragment) {
        if (cameraFragment.getContext() != null) {
            CameraMenu cameraMenu = cameraFragment.mCameraMenu;
            Intrinsics.checkNotNull(cameraMenu);
            Context contextRequireContext = cameraFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            CameraPresenter cameraPresenter = cameraFragment.mCameraPresenter;
            Intrinsics.checkNotNull(cameraPresenter);
            int size = cameraFragment.getScanDataList().size();
            CameraProperty cameraProperty = cameraFragment.mCameraProperty;
            Intrinsics.checkNotNull(cameraProperty);
            cameraMenu.updateCameraMenuLayout(contextRequireContext, cameraPresenter, size, cameraProperty.getMOrientation());
        }
    }

    public final void dismissCheckAddToNoteDialog() {
        CheckAddToNoteDialog checkAddToNoteDialog = (CheckAddToNoteDialog) getChildFragmentManager().findFragmentByTag(CheckAddToNoteDialog.TAG);
        if (checkAddToNoteDialog == null || !checkAddToNoteDialog.isAdded()) {
            return;
        }
        checkAddToNoteDialog.dismiss();
    }

    public final void finishWithFailed(@Nullable String cause) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        Intrinsics.checkNotNull(contract);
        contract.finishWithFailed(cause);
    }

    @Override // com.samsung.android.support.senl.docscan.detect.presenter.ViewContract.Fragment
    public void finishWithSuccess(@NotNull String cause) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        Intrinsics.checkNotNull(contract);
        contract.finishWithSuccess(cause);
    }

    @Override // com.samsung.android.support.senl.docscan.detect.presenter.ViewContract.Fragment
    @NotNull
    public Context getAppContext() {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return contextRequireContext;
    }

    @Override // com.samsung.android.support.senl.docscan.detect.presenter.ViewContract.Fragment
    @NotNull
    /* JADX INFO: renamed from: getPreviewCaptureCallback, reason: from getter */
    public CameraCaptureSession.CaptureCallback getMPreviewCaptureCallback() {
        return this.mPreviewCaptureCallback;
    }

    @NotNull
    public final List<DocScanData> getScanDataList() {
        ScanDataModel scanDataModel = this.mScanDataModel;
        if (scanDataModel == null) {
            return CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(scanDataModel);
        return scanDataModel.getScanDataList();
    }

    public final boolean isScanDataModelInitialized() {
        return this.mScanDataModel != null;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        setupWindowAttributes();
        initCameraLayout();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context applicationContext = BaseUtils.getApplicationContext();
        PinnedEdge pinnedEdge = applicationContext != null ? new PinnedEdge(applicationContext) : null;
        this.mPinnedEdge = pinnedEdge;
        Intrinsics.checkNotNull(pinnedEdge);
        pinnedEdge.setStateChangeListener(this.mStateChangeListener);
        PinnedEdge pinnedEdge2 = this.mPinnedEdge;
        Intrinsics.checkNotNull(pinnedEdge2);
        pinnedEdge2.registerSettingsContentObserver();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C7976R.layout.camera_fragment, container, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        this.mCameraLayout = frameLayout;
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PinnedEdge pinnedEdge = this.mPinnedEdge;
        Intrinsics.checkNotNull(pinnedEdge);
        pinnedEdge.unregisterSettingsContentObserver();
        ExecutorService executorService = mDetectExecutor;
        if (executorService != null) {
            Intrinsics.checkNotNull(executorService);
            if (!executorService.isShutdown()) {
                ExecutorService executorService2 = mDetectExecutor;
                Intrinsics.checkNotNull(executorService2);
                if (!executorService2.isTerminated()) {
                    ExecutorService executorService3 = mDetectExecutor;
                    Intrinsics.checkNotNull(executorService3);
                    executorService3.shutdownNow();
                }
            }
        }
        mDetectExecutor = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Logger.m7145d("CameraFragment", "onDestroyView");
        destroySmartScan();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (CommonUtils.isStandardViewOfFoldDevice(contextRequireContext)) {
            Window window = requireActivity().getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            window.getDecorView().setSystemUiVisibility(0);
        }
        super.onDestroyView();
    }

    public final boolean onKeyShortcut(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((event.getFlags() & 33554432) == 0) {
            return false;
        }
        int metaState = event.getMetaState();
        if (keyCode != 44 || (metaState & 4096) == 0 || (metaState & 1) == 0) {
            return false;
        }
        takePicture();
        return true;
    }

    @Override // com.samsung.android.support.senl.docscan.detect.MainLayout.OrientationEventListener
    public void onOrientationChanged(int orientation) {
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        cameraProperty.setMOrientation(orientation);
    }

    public final void onPauseCamera() {
        Logger.m7145d("CameraFragment", "onPauseCamera");
        CameraMenu cameraMenu = this.mCameraMenu;
        if (cameraMenu != null) {
            cameraMenu.dismissCameraMenu();
        }
        this.mIsRunningDetectLib.set(false);
        closeCamera();
        CameraPresenter cameraPresenter = this.mCameraPresenter;
        if (cameraPresenter != null) {
            cameraPresenter.stopBackgroundThread();
        }
        CameraPresenter cameraPresenter2 = this.mCameraPresenter;
        if (cameraPresenter2 != null) {
            cameraPresenter2.stopCameraTimer();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        CameraPresenter cameraPresenter = this.mCameraPresenter;
        if (cameraPresenter != null) {
            Intrinsics.checkNotNull(cameraPresenter);
            cameraPresenter.onSaveInstanceState(outState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setupWindowAttributes();
        onResumeCamera();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        Logger.m7145d("CameraFragment", "onStop# CameraState : " + cameraProperty.getMCameraState());
        CameraProperty cameraProperty2 = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty2);
        if (cameraProperty2.getMCameraState() != CameraProperty.CameraState.CLOSED) {
            onPauseCamera();
            clearDetectView();
        }
        super.onStop();
    }

    public final void onTopResumedActivityChanged(boolean isTopResumedActivity) {
        this.mIsTopResumedActivity = isTopResumedActivity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WindowManagerCompat.INSTANCE.getInstance().disableSystemBarInsets(view);
        FrameLayout frameLayout = this.mCameraLayout;
        Intrinsics.checkNotNull(frameLayout);
        MainLayout mainLayout = (MainLayout) frameLayout.findViewById(C7976R.id.camera_view);
        this.mMainLayout = mainLayout;
        Intrinsics.checkNotNull(mainLayout);
        mainLayout.refreshLayoutRotation();
        MainLayout mainLayout2 = this.mMainLayout;
        Intrinsics.checkNotNull(mainLayout2);
        mainLayout2.setOrientationEventListener(this);
        this.mCameraProperty = new CameraProperty();
        ScanDataModel scanDataModel = this.mScanDataModel;
        CameraProperty cameraProperty = this.mCameraProperty;
        Intrinsics.checkNotNull(cameraProperty);
        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
        }
        Intrinsics.checkNotNull(savedInstanceState);
        this.mCameraPresenter = new CameraPresenter(this, scanDataModel, cameraProperty, savedInstanceState);
        this.mDetectOverlayView = (DetectOverlayView) view.findViewById(C7976R.id.overlay_view);
        CameraMenu cameraMenu = new CameraMenu(this.mCameraLayout, this.mClickListener);
        this.mCameraMenu = cameraMenu;
        Intrinsics.checkNotNull(cameraMenu);
        cameraMenu.initMenuLayout(getScanDataList().size());
        Object systemService = requireContext().getSystemService("camera");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
        this.mCameraManager = (CameraManager) systemService;
        startSmartScan();
    }

    public final void onWindowFocusChanged(boolean hasFocus) {
        Logger.m7148i("CameraFragment", "onWindowFocusChanged : " + hasFocus);
        if (hasFocus) {
            if (this.mIsTopResumedActivity) {
                CameraProperty cameraProperty = this.mCameraProperty;
                Intrinsics.checkNotNull(cameraProperty);
                if (cameraProperty.getMCameraState() == CameraProperty.CameraState.CLOSED) {
                    onResumeCamera();
                    return;
                }
                return;
            }
            return;
        }
        if (this.mIsTopResumedActivity) {
            CameraProperty cameraProperty2 = this.mCameraProperty;
            Intrinsics.checkNotNull(cameraProperty2);
            if (cameraProperty2.getMCameraState() != CameraProperty.CameraState.CLOSED) {
                onPauseCamera();
                clearDetectView();
            }
        }
    }

    public final void restartCameraTimer() {
        if (this.mCameraPresenter != null) {
            if (!this.mIsTopResumedActivity) {
                onResumeCamera();
            }
            CameraPresenter cameraPresenter = this.mCameraPresenter;
            Intrinsics.checkNotNull(cameraPresenter);
            cameraPresenter.restartCameraTimer();
        }
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void setScanDataModel(@Nullable ScanDataModel scanDataModel) {
        this.mScanDataModel = scanDataModel;
    }

    public final void showCheckAddToNoteDialog() {
        int scanDataCount = getScanDataCount();
        Logger.m7145d("CameraFragment", "showCheckAddToNoteDialog# scanDataListSize : " + scanDataCount);
        new CheckAddToNoteDialog(scanDataCount, new CheckAddToNoteDialog.Contract() { // from class: com.samsung.android.support.senl.docscan.detect.CameraFragment$showCheckAddToNoteDialog$checkAddToNoteDialog$1
            @Override // com.samsung.android.support.senl.docscan.dialog.CheckAddToNoteDialog.Contract
            public void onNeutralButtonClicked() {
                this.this$0.finishWithFailed("onNeutralButtonClicked");
            }

            @Override // com.samsung.android.support.senl.docscan.dialog.CheckAddToNoteDialog.Contract
            public void onPositiveButtonClicked() {
                this.this$0.finishWithSuccess("Save to note");
            }
        }).show(getChildFragmentManager(), CheckAddToNoteDialog.TAG);
    }

    @Override // com.samsung.android.support.senl.docscan.detect.presenter.ViewContract.Fragment
    public void updateThumbnailView(@Nullable Bitmap thumbnailBitmap, int scanDataListSize) {
        CameraMenu cameraMenu = this.mCameraMenu;
        Intrinsics.checkNotNull(cameraMenu);
        cameraMenu.updateThumbnailView(thumbnailBitmap, scanDataListSize);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.samsung.android.support.senl.docscan.detect.CameraFragment$mStateCallback$1] */
    public CameraFragment(@Nullable ScanDataModel scanDataModel) {
        this.mScanDataModel = scanDataModel;
    }
}
