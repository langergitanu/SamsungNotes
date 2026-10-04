package com.samsung.android.support.senl.p148nt.model.assist.common;

import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.Action;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paAction;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paAssertion;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paClient;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paError;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paManifest;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paResult;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.DigitalSourceType;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.AiServicesManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class C2paHandler {
    private static final String SOFTWARE_AGENT = "Notes assist";
    private static C2paHandler mInstance;
    private final C2paClientManager mC2paClientManager = new C2paClientManager(0);
    private static final String CLAIM_GENERATOR = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_SETTINGS_CONFIG_BRAND_NAME");
    private static final String TAG = "C2paHandler";
    private static final ExecutorService C2PA_EXECUTOR = AbstractC4539a.m3201k(TAG);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class C2paClientManager {
        C2paClient mC2paClient;
        Handler mHandler;
        private final AtomicInteger mRefCnt;

        public /* synthetic */ C2paClientManager(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateRefCount$0() {
            Logger.m8697d(C2paHandler.TAG, "updateRefCount# release " + this.mRefCnt);
            if (this.mRefCnt.get() == 0) {
                getC2paClient().release();
            }
        }

        public C2paClient getC2paClient() {
            if (this.mC2paClient == null) {
                this.mC2paClient = AiServicesManager.getInstance().getC2paClient();
            }
            return this.mC2paClient;
        }

        public void updateRefCount(boolean z) {
            Logger.m8697d(C2paHandler.TAG, "updateRefCount# " + this.mRefCnt + " " + z);
            if (z) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mRefCnt.incrementAndGet();
            } else if (this.mRefCnt.decrementAndGet() == 0) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.common.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7681a.lambda$updateRefCount$0();
                    }
                }, 200L);
            }
        }

        private C2paClientManager() {
            this.mRefCnt = new AtomicInteger(0);
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CallbackImpl implements InnerCallback {
        private final C2paClientManager c2paClientManager;
        private long mWaitTime = AiSTTListView.USER_SCROLL_INTERVAL;
        private Object synchronizer;

        public CallbackImpl(C2paClientManager c2paClientManager) {
            this.c2paClientManager = c2paClientManager;
            c2paClientManager.updateRefCount(true);
        }

        public void notifySync() {
            Object obj = this.synchronizer;
            if (obj == null) {
                return;
            }
            synchronized (obj) {
                this.synchronizer.notify();
            }
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.common.C2paHandler.InnerCallback
        public void onFailed(String str) {
            AbstractC4539a.m3214x("onFailed: ", str, C2paHandler.TAG);
            this.c2paClientManager.updateRefCount(false);
            notifySync();
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.common.C2paHandler.InnerCallback
        public void onSuccess(boolean z) {
            Logger.m8697d(C2paHandler.TAG, "onSuccess");
            this.c2paClientManager.updateRefCount(false);
            notifySync();
        }

        public void setSynchronizer(Object obj) {
            this.synchronizer = obj;
        }

        public void setWaitTime(long j) {
            this.mWaitTime = j;
        }

        public void waitSync() {
            Object obj = this.synchronizer;
            if (obj == null) {
                return;
            }
            synchronized (obj) {
                try {
                    try {
                        this.synchronizer.wait(this.mWaitTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InnerCallback {
        void onFailed(String str);

        void onSuccess(boolean z);
    }

    private void addC2paManifestList(final C2paClient c2paClient, final String str, String str2, final String str3, final InnerCallback innerCallback) {
        if (Features.isSupportC2PAFunction()) {
            Logger.m8702i(TAG, "addC2paManifestList start");
            MediaScannerConnection.scanFile(BaseUtils.getApplicationContext(), new String[]{str2}, new String[]{"jpg", Constants.THUMBNAIL_PNG_EXTENSION}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.samsung.android.support.senl.nt.model.assist.common.b
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str4, Uri uri) {
                    this.f7662a.lambda$addC2paManifestList$5(str, c2paClient, str3, innerCallback, str4, uri);
                }
            });
        }
    }

    private void copyAndAppendC2paManifest(String str, String str2, boolean z) {
        if (Features.isSupportC2PAFunction()) {
            CallbackImpl callbackImpl = new CallbackImpl(this.mC2paClientManager);
            StringBuilder sbM3200j = AbstractC4539a.m3200j("copyAndAppendC2paManifest start, isEdited: ", ", targetPath: ", z);
            sbM3200j.append(Logger.getEncode(str));
            sbM3200j.append(", parentPath: ");
            sbM3200j.append(Logger.getEncode(str2));
            Logger.m8702i(TAG, sbM3200j.toString());
            this.mC2paClientManager.getC2paClient().getManifestsAsString(str2).addOnCompleteListener(new C11402e(this, str, str2, callbackImpl, 1));
        }
    }

    private String createManifest(boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(new Action.Builder().action(C2paAction.C2PA_CREATED).softwareAgent(SOFTWARE_AGENT).digitalSourceType(DigitalSourceType.TRAINED_ALGORITHMIC_MEDIA).build());
        }
        if (z2) {
            arrayList.add(new Action.Builder().action(C2paAction.C2PA_EDITED).build());
        }
        if (arrayList.isEmpty()) {
            return new C2paManifest.Builder().claimGenerator(CLAIM_GENERATOR).build();
        }
        return new C2paManifest.Builder().claimGenerator(CLAIM_GENERATOR).addAssertion(new C2paAssertion.Builder().actions(arrayList).build()).build();
    }

    private String getError(Task task, String str) {
        Exception exception = task.getException();
        if (exception == null) {
            return AbstractC0541b.m756B(str, "/UnknownError");
        }
        if (exception instanceof DeadObjectException) {
            return AbstractC0541b.m756B(str, "/service died");
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(str, "/");
        sbM781w.append(exception.getMessage() == null ? exception.toString() : exception.getMessage());
        return sbM781w.toString();
    }

    public static synchronized C2paHandler getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new C2paHandler();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addC2paCreateManifest$1(InnerCallback innerCallback, Task task) {
        if (!task.isSuccessful()) {
            innerCallback.onFailed(getError(task, "addC2paCreateManifest"));
            return;
        }
        C2paResult c2paResult = (C2paResult) task.getResult();
        if (c2paResult == null) {
            innerCallback.onFailed("addC2paCreateManifest, onError: result is invalid");
            return;
        }
        if (c2paResult.isSuccess()) {
            Logger.m8702i(TAG, "addC2paCreateManifest, onSuccess");
            innerCallback.onSuccess(true);
            return;
        }
        String error = c2paResult.getError();
        innerCallback.onFailed("addC2paCreateManifest, onError: " + C2paError.INSTANCE.fromErrorString(error == null ? "" : error) + ", Error code: " + error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addC2paCreateManifest$2(C2paClient c2paClient, InnerCallback innerCallback, String str, Uri uri) {
        if (AbstractC2322a.m1607A(str)) {
            Logger.m8697d(TAG, "addC2paCreateManifest: onScanCompleted");
            String strCreateManifest = createManifest(true, false);
            Logger.m8702i(TAG, "addC2paCreateManifest: " + Logger.getEncode(strCreateManifest));
            c2paClient.embedManifestToFile(strCreateManifest, str, null, null).addOnCompleteListener(new C11400c(this, innerCallback, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addC2paManifestList$4(InnerCallback innerCallback, Task task) {
        if (!task.isSuccessful()) {
            innerCallback.onFailed(getError(task, "addC2paManifestList"));
            return;
        }
        C2paResult c2paResult = (C2paResult) task.getResult();
        if (c2paResult == null) {
            innerCallback.onFailed("addC2paManifestList onError: result is invalid");
            return;
        }
        if (c2paResult.isSuccess()) {
            Logger.m8702i(TAG, "addC2paManifestList, onSuccess");
            innerCallback.onSuccess(true);
            return;
        }
        String error = c2paResult.getError();
        innerCallback.onFailed("addC2paManifestList, onError: " + C2paError.INSTANCE.fromErrorString(error == null ? "" : error) + " Error code: " + error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addC2paManifestList$5(String str, C2paClient c2paClient, String str2, InnerCallback innerCallback, String str3, Uri uri) {
        Logger.m8702i(TAG, "addC2paManifestList, Manifest: " + Logger.getEncode(str));
        c2paClient.embedManifestToFile(str, str3, str2, null).addOnCompleteListener(new C11400c(this, innerCallback, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyAndAppendC2paManifest$0(String str, String str2, CallbackImpl callbackImpl, Task task) {
        Logger.m8702i(TAG, "copyAndAppendC2paManifest manifest extracted");
        if (!task.isSuccessful()) {
            getError(task, "copyAndAppendC2PAManifest");
            return;
        }
        C2paResult c2paResult = (C2paResult) task.getResult();
        if (c2paResult == null || !c2paResult.isSuccess()) {
            addC2paCreateManifest(this.mC2paClientManager.getC2paClient(), str, callbackImpl);
        } else {
            addC2paManifestList(this.mC2paClientManager.getC2paClient(), createManifest(false, false), str, str2, callbackImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$copyC2paManifestList$3(String str, String str2, CallbackImpl callbackImpl, Task task) {
        if (!task.isSuccessful()) {
            callbackImpl.onFailed(getError(task, "copyC2paManifestList"));
            return;
        }
        C2paResult c2paResult = (C2paResult) task.getResult();
        if (c2paResult == null) {
            callbackImpl.onFailed("copyC2paManifestList onError: result is invalid");
            return;
        }
        if (c2paResult.isSuccess()) {
            Logger.m8702i(TAG, "copyC2paManifestList isComplete: " + c2paResult.isCompleted() + ", isTrusted: " + c2paResult.isTrusted());
            addC2paManifestList(this.mC2paClientManager.getC2paClient(), c2paResult.getManifestResult(), str, str2, callbackImpl);
            return;
        }
        String error = c2paResult.getError();
        callbackImpl.onFailed("copyC2paManifestList, onError: " + C2paError.INSTANCE.fromErrorString(error == null ? "" : error) + ", Error code: " + error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeForGenerativeImage$6(String str, Consumer consumer) {
        if (isC2paExist(str)) {
            consumer.accept(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$isC2paExist$7(AtomicBoolean atomicBoolean, String str, CallbackImpl callbackImpl, Task task) {
        if (!task.isSuccessful()) {
            callbackImpl.onFailed("isC2paExist, fail to get result: " + Logger.getEncode(str));
            return;
        }
        Boolean bool = (Boolean) task.getResult();
        if (bool != null) {
            atomicBoolean.set(bool.booleanValue());
            Logger.m8702i(TAG, "isC2paExist, ret: " + bool + ", sourcePath: " + Logger.getEncode(str));
        }
        callbackImpl.onSuccess(atomicBoolean.get());
    }

    public void addC2paCreateManifest(String str) {
        if (Features.isSupportC2PAFunction()) {
            CallbackImpl callbackImpl = new CallbackImpl(this.mC2paClientManager);
            Logger.m8702i(TAG, "addC2paCreateManifest start");
            addC2paCreateManifest(this.mC2paClientManager.getC2paClient(), str, callbackImpl);
            Logger.m8702i(TAG, "addC2paCreateManifest wait Sync start");
            callbackImpl.waitSync();
            Logger.m8702i(TAG, "addC2paCreateManifest end");
        }
    }

    public void copyAndAppendC2paManifestTargetImage(String str, String str2, String str3, Rect rect) {
        if (str3 == null || str3.equals(str2)) {
            copyAndAppendC2paManifest(str, str2, rect != null && rect.width() > 0 && rect.height() > 0);
        } else {
            copyAndAppendC2paManifest(str, str3, true);
        }
    }

    public void copyC2paManifestList(String str, String str2) {
        if (Features.isSupportC2PAFunction()) {
            Logger.m8702i(TAG, "copyC2paManifestList: parentPath: " + Logger.getEncode(str2) + ", targetPath: " + Logger.getEncode(str));
            CallbackImpl callbackImpl = new CallbackImpl(this.mC2paClientManager);
            callbackImpl.setSynchronizer(new Object());
            this.mC2paClientManager.getC2paClient().getManifestsAsString(str2).addOnCompleteListener(new C11402e(this, str, str2, callbackImpl, 0));
            Logger.m8702i(TAG, "copyC2paManifestList wait Sync start");
            callbackImpl.waitSync();
            Logger.m8702i(TAG, "copyC2paManifestList end");
        }
    }

    public void executeForGenerativeImage(@NonNull final String str, @NonNull final Consumer<String> consumer) {
        if (ImageUtil.isGenerativeEditImage(str)) {
            consumer.accept(str);
            return;
        }
        if (Features.isSupportC2PAFunction()) {
            Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.model.assist.common.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7678a.lambda$executeForGenerativeImage$6(str, consumer);
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                runnable.run();
            } else {
                Logger.m8702i(TAG, "executeForGenerativeImage# runThread");
                C2PA_EXECUTOR.execute(runnable);
            }
        }
    }

    @WorkerThread
    public boolean isC2paExist(@NonNull final String str) {
        Logger.m8702i(TAG, "isC2paExist# start");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final CallbackImpl callbackImpl = new CallbackImpl(this.mC2paClientManager);
        callbackImpl.setSynchronizer(new Object());
        this.mC2paClientManager.getC2paClient().isC2paExist(str).addOnCompleteListener(new OnCompleteListener() { // from class: com.samsung.android.support.senl.nt.model.assist.common.a
            @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                C2paHandler.lambda$isC2paExist$7(atomicBoolean, str, callbackImpl, task);
            }
        });
        if (Looper.myLooper() == Looper.getMainLooper()) {
            callbackImpl.setWaitTime(1000L);
        }
        callbackImpl.waitSync();
        Logger.m8702i(TAG, "isC2paExist# end");
        return atomicBoolean.get();
    }

    private void addC2paCreateManifest(final C2paClient c2paClient, String str, final InnerCallback innerCallback) {
        if (Features.isSupportC2PAFunction()) {
            Logger.m8697d(TAG, "addC2paCreateManifest, start add to targetPath: " + Logger.getEncode(str));
            MediaScannerConnection.scanFile(BaseUtils.getApplicationContext(), new String[]{str}, new String[]{"jpg", Constants.THUMBNAIL_PNG_EXTENSION}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.samsung.android.support.senl.nt.model.assist.common.d
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str2, Uri uri) {
                    this.f7670a.lambda$addC2paCreateManifest$2(c2paClient, innerCallback, str2, uri);
                }
            });
        }
    }

    @WorkerThread
    public void executeForGenerativeImage(@NonNull SpenObjectBase spenObjectBase, @NonNull Runnable runnable) {
        if (spenObjectBase.hasExtraDataInt(Constants.EXTRA_KEY_AI_DRAWING_CREATOR) && spenObjectBase.getExtraDataInt(Constants.EXTRA_KEY_AI_DRAWING_CREATOR) == 1) {
            runnable.run();
            return;
        }
        if (spenObjectBase instanceof SpenObjectImage) {
            SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBase;
            String imagePath = spenObjectImage.getImagePath();
            String originalImagePath = spenObjectImage.getOriginalImagePath();
            if (!ImageUtil.isGenerativeEditImage(originalImagePath) && !ImageUtil.isGenerativeEditImage(imagePath)) {
                if (Features.isSupportC2PAFunction()) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        Logger.m8698e(TAG, "executeForGenerativeImage# run on UiThread");
                    }
                    if (isC2paExist(originalImagePath) || isC2paExist(imagePath)) {
                        runnable.run();
                        return;
                    }
                    return;
                }
                return;
            }
            runnable.run();
        }
    }
}
