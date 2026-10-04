package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.AbstractCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt", m14021f = "TestBuilders.kt", m14022i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m14023l = {622, 521, 521}, m14024m = "runTestCoroutineLegacy-SYHnMyU", m14025n = {"$this$runTestCoroutineLegacy_u2dSYHnMyU", "coroutine", "tryGetCompletionCause", "cleanup", "scheduler", "completed", "backgroundWorkRunner", "dispatchTimeout", "$this$runTestCoroutineLegacy_u2dSYHnMyU", "coroutine", "tryGetCompletionCause", "cleanup", "scheduler", "completed", "dispatchTimeout"}, m14026s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
public final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1<T extends AbstractCoroutine<? super Unit>> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    public TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1(Continuation<? super TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TestBuildersKt.m23781runTestCoroutineLegacySYHnMyU(null, null, 0L, null, null, null, this);
    }
}
