package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import android.text.TextUtils;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.language.Result;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0014¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextStreamingResultListener;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener;", "latch", "Ljava/util/concurrent/CountDownLatch;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "<init>", "(Ljava/util/concurrent/CountDownLatch;Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;)V", "onComplete", "", "task", "Lcom/samsung/android/sdk/scs/base/tasks/Task;", "Lcom/samsung/android/sdk/scs/ai/language/Result;", "onTaskSuccess", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SCSTextStreamingResultListener extends SCSTextResultListener {

    @NotNull
    private static final String SCS_TAG_STREAMING_END = "<STREAM_REQUEST_END>";

    @NotNull
    private static final String TAG = "Ai$SCSTextStreamingResultListener";

    public SCSTextStreamingResultListener(@Nullable CountDownLatch countDownLatch, @Nullable SCSTextResultListener.Callback callback) {
        super(countDownLatch, callback);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener, com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(@NotNull Task<Result> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (getMCallback() == null) {
            CountDownLatch countDownLatch = this.mLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                return;
            }
            return;
        }
        Logger.m8697d(TAG, "task isSuccessful: " + task.isSuccessful() + " isComplete: " + task.isComplete());
        if (task.isSuccessful()) {
            onTaskSuccess(task);
            return;
        }
        CountDownLatch countDownLatch2 = this.mLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        onTaskFailed(task);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener
    public void onTaskSuccess(@NotNull Task<Result> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Result result = task.getResult();
        if (result == null) {
            CountDownLatch countDownLatch = this.mLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            Logger.m8698e(TAG, "onTaskSuccess#onComplete - success but empty result");
            SCSTextResultListener.Callback mCallback = getMCallback();
            if (mCallback != null) {
                mCallback.onFailed("UNEXPECTED_ERROR");
            }
            release();
            return;
        }
        String content = result.getContent();
        Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
        if (TextUtils.isEmpty(content)) {
            Logger.m8703w(TAG, "onTaskSuccess# empty");
            return;
        }
        int iM14129C = StringsKt.m14129C(SCS_TAG_STREAMING_END, 0, 6, content);
        if (iM14129C < 0) {
            Logger.m8697d(TAG, "onTaskSuccess");
            SCSTextResultListener.Callback mCallback2 = getMCallback();
            if (mCallback2 != null) {
                mCallback2.onSuccess(content, false);
                return;
            }
            return;
        }
        Logger.m8697d(TAG, "onTaskSuccess# StreamingCompleted");
        CountDownLatch countDownLatch2 = this.mLatch;
        if (countDownLatch2 != null) {
            countDownLatch2.countDown();
        }
        SCSTextResultListener.Callback mCallback3 = getMCallback();
        if (mCallback3 != null) {
            String strSubstring = content.substring(0, iM14129C);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            mCallback3.onSuccess(strSubstring, true);
        }
        release();
    }
}
