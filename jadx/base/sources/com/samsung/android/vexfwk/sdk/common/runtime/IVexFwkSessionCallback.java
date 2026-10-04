package com.samsung.android.vexfwk.sdk.common.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/sdk/common/runtime/IVexFwkSessionCallback;", "", "onRequestCompleted", "", "totalResult", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionTotalResult;", "onRequestProgressed", "partialResult", "Lcom/samsung/android/vexfwk/sdk/common/runtime/VexFwkSessionPartialResult;", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public interface IVexFwkSessionCallback {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static void onRequestCompleted(@NotNull IVexFwkSessionCallback iVexFwkSessionCallback, @NotNull VexFwkSessionTotalResult totalResult) {
            Intrinsics.checkNotNullParameter(totalResult, "totalResult");
        }

        public static void onRequestProgressed(@NotNull IVexFwkSessionCallback iVexFwkSessionCallback, @NotNull VexFwkSessionPartialResult partialResult) {
            Intrinsics.checkNotNullParameter(partialResult, "partialResult");
        }
    }

    void onRequestCompleted(@NotNull VexFwkSessionTotalResult totalResult);

    void onRequestProgressed(@NotNull VexFwkSessionPartialResult partialResult);
}
