package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.scs.base.ResultException;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u001b\u001cB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u0014J\u0018\u0010\u0012\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u0004J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0004J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0014J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSAbsResultListener;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "latch", "Ljava/util/concurrent/CountDownLatch;", "mCallback", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "<init>", "(Ljava/util/concurrent/CountDownLatch;Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;)V", "getMCallback", "()Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "setMCallback", "(Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;)V", "onComplete", "", "task", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "onTaskSuccess", "onTaskFailed", "onFailed", "error", "", "release", "getSafetyError", "resultCode", "", "getLanguageError", "Callback", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SCSTextResultListener extends SCSAbsResultListener<Result> {

    @NotNull
    private static final String TAG = "Ai$LLM$SCSTextResultListener";

    @Nullable
    private Callback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "", "onSuccess", "", "result", "", "isCompleted", "", "onFailed", "message", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        boolean onFailed(@NotNull String message);

        void onSuccess(@NotNull String result, boolean isCompleted);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SCSTextResultListener(@Nullable CountDownLatch countDownLatch, @Nullable Callback callback) {
        super(countDownLatch);
        Intrinsics.checkNotNull(countDownLatch);
        this.mCallback = callback;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSAbsResultListener
    @Nullable
    public String getLanguageError(int resultCode) {
        if (resultCode == 1900) {
            return "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE";
        }
        return null;
    }

    @Nullable
    public final Callback getMCallback() {
        return this.mCallback;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSAbsResultListener
    @Nullable
    public String getSafetyError(@IntRange(from = 5000, m706to = 5999) int resultCode) {
        if (resultCode == 5000) {
            return CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? "SAFE_FILTER_ERROR_CHN_SENSITIVE" : "SAFE_FILTER_ERROR";
        }
        if (resultCode == 5120) {
            return "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE";
        }
        if (resultCode == 5140) {
            return "SAFE_FILTER_ERROR_CHILD";
        }
        if (resultCode == 5210) {
            return "SAFE_FILTER_ERROR_RECITATION";
        }
        if (resultCode == 5220) {
            return "SAFE_FILTER_ERROR_UNSUPPORTED_LANGUAGE";
        }
        if (resultCode == 5240) {
            return "SAFE_FILTER_ERROR_CHILD";
        }
        switch (resultCode) {
            case 5150:
            case 5151:
            case 5152:
            case 5153:
                return "SAFE_FILTER_ERROR_CHILD";
            default:
                switch (resultCode) {
                    case 5250:
                    case 5251:
                    case 5252:
                    case 5253:
                        return "SAFE_FILTER_ERROR_CHILD";
                    default:
                        return "SAFE_FILTER_ERROR";
                }
        }
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(@NotNull Task<Result> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        CountDownLatch countDownLatch = this.mLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        if (this.mCallback == null) {
            return;
        }
        if (task.isSuccessful()) {
            onTaskSuccess(task);
        } else {
            onTaskFailed(task);
        }
    }

    public final void onFailed(@NotNull String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Callback callback = this.mCallback;
        if (callback == null || !callback.onFailed(error)) {
            return;
        }
        release();
    }

    public final void onTaskFailed(@NotNull Task<Result> task) {
        Integer numValueOf;
        String str;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.getException() == null) {
            onFailed("UNEXPECTED_ERROR");
            return;
        }
        Exception exception = task.getException();
        if (exception instanceof ResultException) {
            int resultCode = ((ResultException) exception).getResultCode();
            numValueOf = Integer.valueOf(resultCode);
            Logger.m8698e(TAG, "onComplete# error resultCode : " + numValueOf);
            String errorMessage = getErrorMessage(resultCode);
            if (errorMessage != null) {
                onFailed(errorMessage);
                return;
            }
        } else {
            numValueOf = null;
        }
        Exception exception2 = task.getException();
        if ((exception2 != null ? exception2.getMessage() : null) != null) {
            Exception exception3 = task.getException();
            String message = exception3 != null ? exception3.getMessage() : null;
            if (numValueOf == null) {
                str = "";
            } else {
                str = " " + numValueOf;
            }
            Logger.m8698e(TAG, "onTaskFailed# error : " + message + str);
        }
        onFailed("UNEXPECTED_ERROR");
    }

    public void onTaskSuccess(@NotNull Task<Result> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Result result = task.getResult();
        if (!task.isSuccessful() || result == null) {
            Logger.m8698e(TAG, "[LLM:O]onTaskSuccess# success but empty result");
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onFailed("UNEXPECTED_ERROR");
            }
        } else if (TextUtils.isEmpty(result.getContent())) {
            Callback callback2 = this.mCallback;
            if (callback2 != null) {
                callback2.onFailed("SAFE_FILTER_ERROR");
            }
        } else {
            String content = result.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
            AbstractC4539a.m3203m(content.length(), "[LLM:O]onTaskSuccess# : ", TAG);
            Callback callback3 = this.mCallback;
            if (callback3 != null) {
                callback3.onSuccess(content, true);
            }
        }
        release();
    }

    public final void release() {
        Logger.m8697d(TAG, "release");
        this.mCallback = null;
    }

    public final void setMCallback(@Nullable Callback callback) {
        this.mCallback = callback;
    }
}
