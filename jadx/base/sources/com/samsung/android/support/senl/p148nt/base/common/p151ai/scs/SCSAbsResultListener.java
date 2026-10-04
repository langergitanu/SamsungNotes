package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import androidx.annotation.IntRange;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH$J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSAbsResultListener;", "TResult", "Lcom/samsung/android/sdk/scs/base/tasks/OnCompleteListener;", "latch", "Ljava/util/concurrent/CountDownLatch;", "<init>", "(Ljava/util/concurrent/CountDownLatch;)V", "mLatch", "getErrorMessage", "", "resultCode", "", "getSafetyError", "getLanguageError", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class SCSAbsResultListener<TResult> implements OnCompleteListener<TResult> {

    @JvmField
    @Nullable
    public CountDownLatch mLatch;

    public SCSAbsResultListener(@NotNull CountDownLatch latch) {
        Intrinsics.checkNotNullParameter(latch, "latch");
        this.mLatch = latch;
    }

    @Nullable
    public final String getErrorMessage(int resultCode) {
        if (resultCode == 14) {
            return "NETWORK_ERROR";
        }
        if (resultCode == 2200) {
            return SCSTools.getAppInfoErrMsg();
        }
        if (resultCode >= 5000 && resultCode <= 5999) {
            return getSafetyError(resultCode);
        }
        if (resultCode >= 8000 && resultCode < 9000) {
            return "REMOTE_SERVER_ERROR";
        }
        if (resultCode >= 9000 && resultCode < 10000) {
            return "INTERNAL_SERVER_ERROR";
        }
        if (resultCode == 2203) {
            return "RESTRICTED_USER_ERROR";
        }
        if (resultCode == 1098) {
            return "SERVICE_IS_BUSY";
        }
        if (resultCode == 1026) {
            return "INPUT_TOO_LONG";
        }
        if (resultCode == 1900) {
            return getLanguageError(resultCode);
        }
        return null;
    }

    @Nullable
    public String getLanguageError(int resultCode) {
        return null;
    }

    @Nullable
    public abstract String getSafetyError(@IntRange(from = 5000, m706to = 5999) int resultCode);
}
