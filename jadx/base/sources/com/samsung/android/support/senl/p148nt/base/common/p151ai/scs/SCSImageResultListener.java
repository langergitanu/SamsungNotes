package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorResult;
import com.samsung.android.sdk.scs.p142ai.visual.VisualErrorCode;
import com.samsung.android.sdk.scs.p142ai.visual.VisualResultErrorException;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 !2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0017J\u001e\u0010\r\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010\u001f\u001a\u00020\u001dH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSAbsResultListener;", "Lcom/samsung/android/sdk/scs/ai/visual/ImageEditorResult;", "latch", "Ljava/util/concurrent/CountDownLatch;", "mCallback", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener$Callback;", "<init>", "(Ljava/util/concurrent/CountDownLatch;Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener$Callback;)V", "onComplete", "", "task", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "onSuccess", "outputBitmaps", "", "Landroid/graphics/Bitmap;", "isComplete", "", "onFailed", "error", "", "mgsData", "Landroid/os/Bundle;", "release", "getVisualErrorMessage", "visualErrorCode", "Lcom/samsung/android/sdk/scs/ai/visual/VisualErrorCode;", "serverErrCode", "", "getSafetyError", "resultCode", "Callback", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSCSImageResultListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SCSImageResultListener.kt\ncom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class SCSImageResultListener extends SCSAbsResultListener<ImageEditorResult> {

    @NotNull
    private static final String TAG = "Ai$LVM$SCSImageResultListener";

    @Nullable
    private Callback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSImageResultListener$Callback;", "", "onSuccess", "", "bitmaps", "", "Landroid/graphics/Bitmap;", "isComplete", "", "onFailed", "message", "", "mgsData", "Landroid/os/Bundle;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        boolean onFailed(@NotNull Bundle mgsData);

        boolean onFailed(@NotNull String message);

        void onSuccess(@NotNull List<Bitmap> bitmaps, boolean isComplete);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SCSImageResultListener(@Nullable CountDownLatch countDownLatch, @Nullable Callback callback) {
        super(countDownLatch);
        Intrinsics.checkNotNull(countDownLatch);
        this.mCallback = callback;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSAbsResultListener
    @Nullable
    public String getSafetyError(@IntRange(from = 5000, m706to = 5999) int resultCode) {
        if (resultCode != 5340 && resultCode != 5341 && resultCode != 5350 && resultCode != 5353 && resultCode != 5531 && resultCode != 5600 && resultCode != 5551 && resultCode != 5552 && resultCode != 5560 && resultCode != 5561) {
            Logger.m8698e(TAG, "getSafetyError, unchecked resultCode: " + resultCode);
        }
        return "SAFE_FILTER_ERROR";
    }

    @Nullable
    public final String getVisualErrorMessage(@NotNull VisualErrorCode visualErrorCode, int serverErrCode) {
        Intrinsics.checkNotNullParameter(visualErrorCode, "visualErrorCode");
        if (VisualErrorCode.TIME_OUT == visualErrorCode) {
            return "TIMEOUT_ERROR";
        }
        if (VisualErrorCode.NETWORK_ERROR == visualErrorCode) {
            return "NETWORK_ERROR";
        }
        if (VisualErrorCode.INPUT_DATA_ERROR == visualErrorCode) {
            return "INPUT_DATA_ERROR";
        }
        if (VisualErrorCode.MISSING_MANDATORY_FIELD == visualErrorCode) {
            return "MISSING_MANDATORY_FIELD";
        }
        if (VisualErrorCode.CLIENT_ERROR == visualErrorCode) {
            return "CLIENT_ERROR";
        }
        if (VisualErrorCode.AUTH_ERROR == visualErrorCode) {
            return "AUTH_ERROR";
        }
        if (VisualErrorCode.AUTH_SA_ERROR == visualErrorCode) {
            return "AUTH_SA_ERROR";
        }
        if (VisualErrorCode.SAFETY_FILTER_ERROR == visualErrorCode) {
            return getSafetyError(serverErrCode);
        }
        if (VisualErrorCode.SERVER_ERROR == visualErrorCode) {
            return "SERVER_ERROR";
        }
        if (VisualErrorCode.SERVER_QUOTA_ERROR == visualErrorCode) {
            return "SERVER_QUOTA_ERROR";
        }
        String errorMessage = getErrorMessage(serverErrCode);
        return TextUtils.isEmpty(errorMessage) ? "UNEXPECTED_ERROR" : errorMessage;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    @SuppressLint({"RestrictedApi"})
    public void onComplete(@NotNull Task<ImageEditorResult> task) {
        String string;
        Bundle bundle;
        ArrayList parcelableArrayList;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            ArrayList arrayList = new ArrayList();
            ImageEditorResult result = task.getResult();
            if (result != null && (bundle = result.getBundle()) != null && (parcelableArrayList = bundle.getParcelableArrayList(ImageEditorConst.KEY_PARAM_OUTPUT_BITMAP_LIST)) != null) {
                arrayList.addAll(parcelableArrayList);
            }
            onSuccess(arrayList, task.isComplete());
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            string = "service exception is null";
        } else if (exception instanceof DeadObjectException) {
            string = "service died";
        } else if (exception instanceof VisualResultErrorException) {
            VisualResultErrorException visualResultErrorException = (VisualResultErrorException) exception;
            int serverErrorCode = visualResultErrorException.getServerErrorCode();
            VisualErrorCode errorCode = visualResultErrorException.getErrorCode();
            Logger.m8698e(TAG, "onComplete# ServerErrorCode : " + serverErrorCode + ", VisualErrorCode : " + errorCode);
            Intrinsics.checkNotNull(errorCode);
            string = getVisualErrorMessage(errorCode, serverErrorCode);
        } else {
            string = exception.getMessage() == null ? exception.toString() : exception.getMessage();
        }
        onFailed(string);
    }

    public final void onFailed(@Nullable String error) {
        boolean zAreEqual;
        Callback callback = this.mCallback;
        if (callback != null) {
            if (error != null) {
                zAreEqual = Intrinsics.areEqual(callback != null ? Boolean.valueOf(callback.onFailed(error)) : null, Boolean.TRUE);
            } else {
                zAreEqual = false;
            }
            if (zAreEqual) {
                release();
            }
        }
        CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void onSuccess(@Nullable List<Bitmap> outputBitmaps, boolean isComplete) {
        Callback callback = this.mCallback;
        if (callback != null && outputBitmaps != null && callback != null) {
            callback.onSuccess(outputBitmaps, isComplete);
        }
        CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void release() {
        Logger.m8697d(TAG, "release");
        this.mCallback = null;
    }

    public final void onFailed(@Nullable Bundle mgsData) {
        boolean zAreEqual;
        Callback callback = this.mCallback;
        if (callback != null) {
            if (mgsData != null) {
                zAreEqual = Intrinsics.areEqual(callback != null ? Boolean.valueOf(callback.onFailed(mgsData)) : null, Boolean.TRUE);
            } else {
                zAreEqual = false;
            }
            if (zAreEqual) {
                release();
            }
        }
        CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
