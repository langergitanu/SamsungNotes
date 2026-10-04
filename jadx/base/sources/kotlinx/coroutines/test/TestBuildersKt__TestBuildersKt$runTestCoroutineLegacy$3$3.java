package kotlinx.coroutines.test;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.AbstractCoroutine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m13886d2 = {"<anonymous>", ""}, m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3", m14021f = "TestBuilders.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
@SourceDebugExtension({"SMAP\nTestBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestBuilders.kt\nkotlinx/coroutines/test/TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3\n+ 2 TestBuilders.kt\nkotlinx/coroutines/test/TestBuildersKt__TestBuildersKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,617:1\n545#2,21:618\n566#2:640\n567#2:643\n1#3:639\n1863#4,2:641\n*S KotlinDebug\n*F\n+ 1 TestBuilders.kt\nkotlinx/coroutines/test/TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3\n*L\n517#1:618,21\n517#1:640\n517#1:643\n517#1:639\n517#1:641,2\n*E\n"})
public final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<List<Throwable>> $cleanup;

    /* JADX INFO: Incorrect field signature: TT; */
    final /* synthetic */ AbstractCoroutine $coroutine;
    final /* synthetic */ long $dispatchTimeout;
    final /* synthetic */ Function1<T, Throwable> $tryGetCompletionCause;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (TT;JLkotlin/jvm/functions/Function1<-TT;+Ljava/lang/Throwable;>;Lkotlin/jvm/functions/Function0<+Ljava/util/List<+Ljava/lang/Throwable;>;>;Lkotlin/coroutines/Continuation<-Lkotlinx/coroutines/test/TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3;>;)V */
    public TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3(AbstractCoroutine abstractCoroutine, long j, Function1 function1, Function0 function0, Continuation continuation) {
        super(1, continuation);
        this.$coroutine = abstractCoroutine;
        this.$dispatchTimeout = j;
        this.$tryGetCompletionCause = function1;
        this.$cleanup = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3(this.$coroutine, this.$dispatchTimeout, this.$tryGetCompletionCause, this.$cleanup, continuation);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List<Throwable> listEmptyList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AbstractCoroutine abstractCoroutine = this.$coroutine;
        long j = this.$dispatchTimeout;
        Function1<T, Throwable> function1 = this.$tryGetCompletionCause;
        try {
            listEmptyList = this.$cleanup.invoke();
        } catch (UncompletedCoroutinesError unused) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = SequencesKt.toList(SequencesKt.filter(abstractCoroutine.getChildren(), TestBuildersKt__TestBuildersKt$handleTimeout$activeChildren$1.INSTANCE));
        Throwable thInvoke = abstractCoroutine.isCancelled() ? function1.invoke((T) abstractCoroutine) : null;
        String string = "After waiting for " + ((Object) Duration.m23594toStringimpl(j));
        if (thInvoke == null) {
            string = AbstractC0541b.m756B(string, ", the test coroutine is not completing");
        }
        if (!list.isEmpty()) {
            string = string + ", there were active child jobs: " + list;
        }
        if (thInvoke != null && list.isEmpty()) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
            sbM1324q.append(abstractCoroutine.isCompleted() ? ", the test coroutine completed" : ", the test coroutine was not completed");
            string = sbM1324q.toString();
        }
        UncompletedCoroutinesError uncompletedCoroutinesError = new UncompletedCoroutinesError(string);
        if (thInvoke != null) {
            ExceptionsKt.addSuppressed(uncompletedCoroutinesError, thInvoke);
        }
        Iterator<T> it = listEmptyList.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(uncompletedCoroutinesError, (Throwable) it.next());
        }
        throw uncompletedCoroutinesError;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
