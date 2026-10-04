package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTextStreamingResultListener;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.SCSTools;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSServiceRequester;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/SCSLLMRequesterStreamingImpl;", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/SCSLLMRequesterImpl;", "<init>", "()V", "mStreamingFullResult", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "createTextResultListener", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener;", "latch", "Ljava/util/concurrent/CountDownLatch;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSTextResultListener$Callback;", "timeOut", "", "getTimeOut", "()I", "saveToCache", "", "key", "", "input", "result", "isCompleted", "", "createServiceRequester", "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSServiceRequester;", TextConst.KEY_PARAM_REQUEST_TYPE, "Lcom/samsung/android/support/senl/nt/base/common/ai/scs/requester/type/SCSRequesterType;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SCSLLMRequesterStreamingImpl extends SCSLLMRequesterImpl {

    @NotNull
    private final StringBuilder mStreamingFullResult = new StringBuilder();

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl
    @Nullable
    public SCSServiceRequester createServiceRequester(@Nullable SCSRequesterType requestType) {
        if (requestType != null) {
            return requestType.create(true);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl
    @NotNull
    public SCSTextResultListener createTextResultListener(@Nullable CountDownLatch latch, @Nullable SCSTextResultListener.Callback callback) {
        return new SCSTextStreamingResultListener(latch, callback);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl
    public int getTimeOut() {
        return SCSTools.INSTANCE.getTimeOut(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl
    public void saveToCache(@Nullable String key, @Nullable String input, @NotNull String result, boolean isCompleted) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (!isCompleted) {
            this.mStreamingFullResult.append(result);
            return;
        }
        String string = this.mStreamingFullResult.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        super.saveToCache(key, input, string, true);
    }
}
