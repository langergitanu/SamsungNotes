package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ai/scs/SCSExecutor;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CHN_POOL_COUNT", "", "DEF_POOL_COUNT", "sExecutorService", "Ljava/util/concurrent/ExecutorService;", "execute", "", "runnable", "Ljava/lang/Runnable;", "poolCount", "getPoolCount", "()I", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SCSExecutor {
    private static final int CHN_POOL_COUNT = 8;
    private static final int DEF_POOL_COUNT = 4;

    @NotNull
    public static final SCSExecutor INSTANCE;

    @NotNull
    private static final String TAG = "Ai$SCSExecutor";

    @NotNull
    private static final ExecutorService sExecutorService;

    static {
        SCSExecutor sCSExecutor = new SCSExecutor();
        INSTANCE = sCSExecutor;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(sCSExecutor.getPoolCount(), new SenlThreadFactory(TAG));
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        sExecutorService = executorServiceNewFixedThreadPool;
    }

    private SCSExecutor() {
    }

    private final int getPoolCount() {
        return CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? 8 : 4;
    }

    public final void execute(@Nullable Runnable runnable) {
        sExecutorService.execute(runnable);
    }
}
