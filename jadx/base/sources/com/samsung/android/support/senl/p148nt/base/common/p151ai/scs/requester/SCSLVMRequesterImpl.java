package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.C7737b;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorGenerator;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorParam;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorResult;
import com.samsung.android.sdk.scs.p142ai.visual.VisualAppInfo;
import com.samsung.android.support.senl.p145cm.base.common.util.EnvironmentUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSExecutor;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSImageResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.VirtualScsAiServiceConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.option.ScribbleWeight;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p070Q1.RunnableC0218a;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J$\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J,\u0010\u0019\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\b\u0010#\u001a\u00020\u0010H\u0002J\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010(\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010)\u001a\u00020\u0010H\u0016J\u000e\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020,R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/SCSLVMRequesterImpl;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/ILVMRequester;", "<init>", "()V", "mCallback", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener$Callback;", "mServicePrepareTask", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "", "mImageTask", "Lcom/samsung/android/sdk/scs/ai/visual/ImageEditorResult;", "mServiceConnection", "Landroid/content/ServiceConnection;", "mRetryCount", "", "setCallback", "", Profile.PhoneNumberData.TYPE_CALLBACK, "requestImage", TextConst.KEY_PARAM_REQUEST_TYPE, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "content", "Landroid/graphics/Bitmap;", "options", "Landroid/os/Bundle;", "requestToService", "requestInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener;", "createImageResultListener", "latch", "Ljava/util/concurrent/CountDownLatch;", "timeOut", "getTimeOut", "()I", "makeAppInfoError", "prepare", "prepareSuccessAction", "Ljava/lang/Runnable;", "release", "cancel", "close", "couldRetry", NotificationCompat.CATEGORY_ERROR, "", "couldTokenRetry", "message", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SCSLVMRequesterImpl implements ILVMRequester {

    @NotNull
    private static final String TAG = "Ai$LVM$SCSLVMRequesterImpl";

    @Nullable
    private SCSImageResultListener.Callback mCallback;

    @Nullable
    private Task<ImageEditorResult> mImageTask;
    private int mRetryCount;

    @Nullable
    private ServiceConnection mServiceConnection;

    @Nullable
    private Task<Boolean> mServicePrepareTask;
    private final int timeOut;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SCSRequesterType.values().length];
            try {
                iArr[SCSRequesterType.SketchToImage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SCSRequesterType.TextToImage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SCSRequesterType.VirtualScsDrawing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SCSLVMRequesterImpl() {
        this.timeOut = EnvironmentUtils.isRunningLaboratoryMode() ? 180 : 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancel$lambda$11(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "cancel sketchToImage, imageTask#onComplete : " + task.getResult());
        } else {
            Logger.m8697d(TAG, "cancel sketchToImage, imageTask#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancel$lambda$12(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancel$lambda$13(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "cancel sketchToImage, servicePrepareTask#onComplete : " + task.getResult());
        } else {
            Logger.m8697d(TAG, "cancel sketchToImage, servicePrepareTask#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancel$lambda$14(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancel$lambda$15(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "cancel textToImage, imageTask#onComplete : " + task.getResult());
        } else {
            Logger.m8697d(TAG, "cancel textToImage, imageTask#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancel$lambda$16(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancel$lambda$17(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "cancel textToImage, servicePrepareTask#onComplete : " + task.getResult());
        } else {
            Logger.m8697d(TAG, "cancel textToImage, servicePrepareTask#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancel$lambda$18(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    private final void makeAppInfoError() {
        if (this.mCallback != null) {
            String appInfoErrMsg = SCSTools.getAppInfoErrMsg();
            SCSImageResultListener.Callback callback = this.mCallback;
            if (callback != null) {
                callback.onFailed(appInfoErrMsg);
            }
        }
    }

    private final Task<Boolean> prepare(SCSRequesterType requestType, final Runnable prepareSuccessAction) {
        Task<Boolean> taskPrepare;
        ImageEditorGenerator textToImageGenerator;
        Task<Boolean> taskPrepare2;
        int i = WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        if (i != 1) {
            if (i != 2 || (textToImageGenerator = AiServicesManager.INSTANCE.getInstance().getTextToImageGenerator()) == null || (taskPrepare2 = textToImageGenerator.prepare()) == null) {
                return null;
            }
            final int i2 = 1;
            return taskPrepare2.addOnCompleteListener(new C8886c(new Function1() { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    switch (i2) {
                        case 0:
                            return SCSLVMRequesterImpl.prepare$lambda$3(prepareSuccessAction, (Task) obj);
                        default:
                            return SCSLVMRequesterImpl.prepare$lambda$5(prepareSuccessAction, (Task) obj);
                    }
                }
            }, 0));
        }
        ImageEditorGenerator sketchToImageGenerator = AiServicesManager.INSTANCE.getInstance().getSketchToImageGenerator();
        if (sketchToImageGenerator == null || (taskPrepare = sketchToImageGenerator.prepare()) == null) {
            return null;
        }
        final int i4 = 0;
        return taskPrepare.addOnCompleteListener(new C7737b(new Function1() { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i4) {
                    case 0:
                        return SCSLVMRequesterImpl.prepare$lambda$3(prepareSuccessAction, (Task) obj);
                    default:
                        return SCSLVMRequesterImpl.prepare$lambda$5(prepareSuccessAction, (Task) obj);
                }
            }
        }, 29));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepare$lambda$3(Runnable runnable, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "prepare#onComplete : " + task.getResult());
            if (runnable != null && Intrinsics.areEqual(Boolean.TRUE, task.getResult())) {
                runnable.run();
            }
        } else {
            Logger.m8697d(TAG, "prepare#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepare$lambda$4(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit prepare$lambda$5(Runnable runnable, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "prepare#onComplete : " + task.getResult());
            if (runnable != null && Intrinsics.areEqual(Boolean.TRUE, task.getResult())) {
                runnable.run();
            }
        } else {
            Logger.m8697d(TAG, "prepare#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepare$lambda$6(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void release$lambda$10(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit release$lambda$7(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "release#onComplete : " + task.getResult());
        } else {
            Logger.m8697d(TAG, "release#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void release$lambda$8(Function1 function1, Task p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        function1.invoke(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit release$lambda$9(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            Logger.m8697d(TAG, "release#onComplete : " + task.getResult());
        } else {
            Logger.m8697d(TAG, "release#onComplete : is not successful");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestImage$lambda$0(Bundle bundle, SCSLVMRequesterImpl sCSLVMRequesterImpl, SCSRequesterType sCSRequesterType, Bitmap bitmap) {
        Logger.m8697d(TAG, "[LVM:I]requestImage: options: " + bundle.size());
        CountDownLatch countDownLatch = new CountDownLatch(1);
        SCSImageResultListener sCSImageResultListenerCreateImageResultListener = sCSLVMRequesterImpl.createImageResultListener(countDownLatch, sCSLVMRequesterImpl.mCallback);
        try {
            if (!sCSLVMRequesterImpl.requestToService(sCSRequesterType, bitmap, bundle, sCSImageResultListenerCreateImageResultListener) || countDownLatch.await(sCSLVMRequesterImpl.timeOut, TimeUnit.SECONDS)) {
                return;
            }
            Logger.m8698e(TAG, "requestImage, timeout");
            sCSImageResultListenerCreateImageResultListener.onFailed("TIMEOUT_ERROR");
        } catch (InterruptedException e) {
            Logger.m8698e(TAG, "requestImage, e: " + e.getMessage());
            sCSImageResultListenerCreateImageResultListener.onFailed("UNEXPECTED_ERROR");
        }
    }

    @SuppressLint({"RestrictedApi"})
    private final boolean requestToService(SCSRequesterType requestType, Bitmap content, final Bundle requestInfo, final SCSImageResultListener listener) {
        int i = requestType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        if (i == 1) {
            final VisualAppInfo visualAppInfoMakeVisualAppInfo = SCSTools.INSTANCE.makeVisualAppInfo();
            if (visualAppInfoMakeVisualAppInfo == null) {
                Logger.m8703w(TAG, "requestToService, visualAppInfo is null");
                makeAppInfoError();
                return false;
            }
            if (content == null) {
                Logger.m8703w(TAG, "requestToService, inputFilePath is null");
                listener.onFailed("UNEXPECTED_ERROR");
                return false;
            }
            final Bundle bundleBuild = new ImageEditorParam.ParamBuilder().asBitmap().input(content).sampleCount2(1).asSketch2ImageMode().style(requestInfo.getString("style")).followSketchStrength(ScribbleWeight.INSTANCE.getCode(requestInfo.getFloat("scribble_weight"))).build();
            final int i2 = 0;
            this.mServicePrepareTask = prepare(requestType, new Runnable(this) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SCSLVMRequesterImpl f6431b;

                {
                    this.f6431b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            SCSLVMRequesterImpl.requestToService$lambda$1(this.f6431b, visualAppInfoMakeVisualAppInfo, bundleBuild, listener);
                            break;
                        default:
                            SCSLVMRequesterImpl.requestToService$lambda$2(this.f6431b, visualAppInfoMakeVisualAppInfo, bundleBuild, listener);
                            break;
                    }
                }
            });
            return true;
        }
        if (i == 2) {
            final VisualAppInfo visualAppInfoMakeVisualAppInfo2 = SCSTools.INSTANCE.makeVisualAppInfo();
            if (visualAppInfoMakeVisualAppInfo2 == null) {
                Logger.m8703w(TAG, "requestToService, visualAppInfo is null");
                makeAppInfoError();
                return false;
            }
            final Bundle bundleBuild2 = new ImageEditorParam.ParamBuilder().asText().input(requestInfo.getString("textInfo")).sampleCount2(1).serviceVersion2("serviceVersion").asImageConversion().style(requestInfo.getString("style")).conversionInputType("text_only").build();
            final int i4 = 1;
            this.mServicePrepareTask = prepare(requestType, new Runnable(this) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ SCSLVMRequesterImpl f6431b;

                {
                    this.f6431b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i4) {
                        case 0:
                            SCSLVMRequesterImpl.requestToService$lambda$1(this.f6431b, visualAppInfoMakeVisualAppInfo2, bundleBuild2, listener);
                            break;
                        default:
                            SCSLVMRequesterImpl.requestToService$lambda$2(this.f6431b, visualAppInfoMakeVisualAppInfo2, bundleBuild2, listener);
                            break;
                    }
                }
            });
            return true;
        }
        if (i != 3) {
            Logger.m8698e(TAG, "requestToService, requestType is invalid: " + (requestType == null ? "null" : requestType));
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(VirtualScsAiServiceConstants.SERVICE_PACKAGE, VirtualScsAiServiceConstants.SERVICE_CLASS));
        intent.addCategory(VirtualScsAiServiceConstants.SERVICE_CATEGORY);
        intent.setAction(VirtualScsAiServiceConstants.SERVICE_ACTION);
        this.mServiceConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.SCSLVMRequesterImpl.requestToService.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(service, "service");
                Logger.m8697d(SCSLVMRequesterImpl.TAG, "onServiceConnected");
                String string = requestInfo.getString("style");
                String string2 = requestInfo.getString("textInfo");
                Message messageObtain = Message.obtain((Handler) null, 4);
                messageObtain.getData().putString(VirtualScsAiServiceConstants.IMAGE_STYLE, string);
                messageObtain.getData().putString("textInfo", string2);
                messageObtain.getData().putInt("sampleCount", 1);
                final Looper mainLooper = Looper.getMainLooper();
                final SCSImageResultListener sCSImageResultListener = listener;
                messageObtain.replyTo = new Messenger(new Handler(mainLooper) { // from class: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.SCSLVMRequesterImpl$requestToService$3$onServiceConnected$1
                    @Override // android.os.Handler
                    public void handleMessage(Message msg) {
                        Intrinsics.checkNotNullParameter(msg, "msg");
                        if (msg.getData().getBoolean("result")) {
                            sCSImageResultListener.onSuccess(msg.getData().getParcelableArrayList("content"), true);
                        } else {
                            sCSImageResultListener.onFailed(msg.getData());
                        }
                    }
                });
                try {
                    new Messenger(service).send(messageObtain);
                } catch (RemoteException unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Intrinsics.checkNotNullParameter(name, "name");
                Logger.m8697d(SCSLVMRequesterImpl.TAG, "onServiceDisconnected");
            }
        };
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            ServiceConnection serviceConnection = this.mServiceConnection;
            Intrinsics.checkNotNull(serviceConnection, "null cannot be cast to non-null type android.content.ServiceConnection");
            applicationContext.bindService(intent, serviceConnection, 1);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestToService$lambda$1(SCSLVMRequesterImpl sCSLVMRequesterImpl, VisualAppInfo visualAppInfo, Bundle bundle, SCSImageResultListener sCSImageResultListener) {
        ImageEditorGenerator sketchToImageGenerator = AiServicesManager.INSTANCE.getInstance().getSketchToImageGenerator();
        Task<ImageEditorResult> taskGenerate = sketchToImageGenerator != null ? sketchToImageGenerator.generate(visualAppInfo, bundle) : null;
        sCSLVMRequesterImpl.mImageTask = taskGenerate;
        if (taskGenerate != null) {
            taskGenerate.addOnCompleteListener(sCSImageResultListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestToService$lambda$2(SCSLVMRequesterImpl sCSLVMRequesterImpl, VisualAppInfo visualAppInfo, Bundle bundle, SCSImageResultListener sCSImageResultListener) {
        ImageEditorGenerator textToImageGenerator = AiServicesManager.INSTANCE.getInstance().getTextToImageGenerator();
        Task<ImageEditorResult> taskGenerate = textToImageGenerator != null ? textToImageGenerator.generate(visualAppInfo, bundle) : null;
        sCSLVMRequesterImpl.mImageTask = taskGenerate;
        if (taskGenerate != null) {
            taskGenerate.addOnCompleteListener(sCSImageResultListener);
        }
    }

    public final void cancel(@Nullable SCSRequesterType requestType) {
        int i = requestType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        if (i == 1) {
            if (this.mImageTask != null) {
                ImageEditorGenerator sketchToImageGenerator = AiServicesManager.INSTANCE.getInstance().getSketchToImageGenerator();
                if (sketchToImageGenerator != null) {
                    Task<ImageEditorResult> task = this.mImageTask;
                    Intrinsics.checkNotNull(task);
                    Task<Boolean> taskCancel = sketchToImageGenerator.cancel(task.getTaskId());
                    if (taskCancel != null) {
                        taskCancel.addOnCompleteListener(new C8886c(new C0348a(9), 1));
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mServicePrepareTask == null) {
                Logger.m8698e(TAG, "cancel sketchToImage, target task is null");
                return;
            }
            ImageEditorGenerator sketchToImageGenerator2 = AiServicesManager.INSTANCE.getInstance().getSketchToImageGenerator();
            if (sketchToImageGenerator2 != null) {
                Task<Boolean> task2 = this.mServicePrepareTask;
                Intrinsics.checkNotNull(task2);
                Task<Boolean> taskCancel2 = sketchToImageGenerator2.cancel(task2.getTaskId());
                if (taskCancel2 != null) {
                    taskCancel2.addOnCompleteListener(new C8886c(new C0348a(10), 2));
                    return;
                }
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        if (this.mImageTask != null) {
            ImageEditorGenerator textToImageGenerator = AiServicesManager.INSTANCE.getInstance().getTextToImageGenerator();
            if (textToImageGenerator != null) {
                Task<ImageEditorResult> task3 = this.mImageTask;
                Intrinsics.checkNotNull(task3);
                Task<Boolean> taskCancel3 = textToImageGenerator.cancel(task3.getTaskId());
                if (taskCancel3 != null) {
                    taskCancel3.addOnCompleteListener(new C8886c(new C0348a(11), 3));
                    return;
                }
                return;
            }
            return;
        }
        if (this.mServicePrepareTask == null) {
            Logger.m8698e(TAG, "cancel textToImage, target task is null");
            return;
        }
        ImageEditorGenerator textToImageGenerator2 = AiServicesManager.INSTANCE.getInstance().getTextToImageGenerator();
        if (textToImageGenerator2 != null) {
            Task<Boolean> task4 = this.mServicePrepareTask;
            Intrinsics.checkNotNull(task4);
            Task<Boolean> taskCancel4 = textToImageGenerator2.cancel(task4.getTaskId());
            if (taskCancel4 != null) {
                taskCancel4.addOnCompleteListener(new C7737b(new C0348a(6), 26));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.ILVMRequester, java.lang.AutoCloseable
    public void close() {
        Logger.m8697d(TAG, "close");
    }

    public final boolean couldRetry(@NotNull String err) {
        Intrinsics.checkNotNullParameter(err, "err");
        if (!Intrinsics.areEqual("REMOTE_SERVER_ERROR", err) && !Intrinsics.areEqual("INTERNAL_SERVER_ERROR", err)) {
            return false;
        }
        int i = this.mRetryCount + 1;
        this.mRetryCount = i;
        return i <= 1;
    }

    public final boolean couldTokenRetry(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!Intrinsics.areEqual(SCSTools.getAppInfoErrMsg(), message) && !Intrinsics.areEqual("AUTH_ERROR", message) && !Intrinsics.areEqual("AUTH_SA_ERROR", message)) {
            return false;
        }
        int i = this.mRetryCount + 1;
        this.mRetryCount = i;
        return i <= 1;
    }

    @NotNull
    public final SCSImageResultListener createImageResultListener(@Nullable CountDownLatch latch, @Nullable SCSImageResultListener.Callback callback) {
        return new SCSImageResultListener(latch, callback);
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public final void release(@Nullable SCSRequesterType requestType) {
        Task<Boolean> taskRelease;
        Task<Boolean> taskRelease2;
        int i = requestType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        if (i == 1) {
            ImageEditorGenerator sketchToImageGenerator = AiServicesManager.INSTANCE.getInstance().getSketchToImageGenerator();
            if (sketchToImageGenerator == null || (taskRelease = sketchToImageGenerator.release()) == null) {
                return;
            }
            taskRelease.addOnCompleteListener(new C7737b(new C0348a(7), 27));
            return;
        }
        if (i == 2) {
            ImageEditorGenerator textToImageGenerator = AiServicesManager.INSTANCE.getInstance().getTextToImageGenerator();
            if (textToImageGenerator == null || (taskRelease2 = textToImageGenerator.release()) == null) {
                return;
            }
            taskRelease2.addOnCompleteListener(new C7737b(new C0348a(8), 28));
            return;
        }
        if (i == 3 && this.mServiceConnection != null) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                ServiceConnection serviceConnection = this.mServiceConnection;
                Intrinsics.checkNotNull(serviceConnection);
                applicationContext.unbindService(serviceConnection);
            }
            this.mServiceConnection = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.ILVMRequester
    public void requestImage(@Nullable SCSRequesterType requestType, @Nullable Bitmap content, @NotNull Bundle options) {
        Intrinsics.checkNotNullParameter(options, "options");
        SCSExecutor.INSTANCE.execute(new RunnableC0218a(options, this, requestType, content));
    }

    public final void setCallback(@Nullable SCSImageResultListener.Callback callback) {
        this.mCallback = callback;
    }
}
