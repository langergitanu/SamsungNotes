package kotlinx.coroutines.test;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u001aN\u0010\u0000\u001a\u00060\u0002j\u0002`\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u000e\u001aL\u0010\u0000\u001a\u00060\u0002j\u0002`\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u000e\u001aH\u0010\u0000\u001a\u00060\u0002j\u0002`\u0001*\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00062'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\f¢\u0006\u0004\b\r\u0010\u0011\u001aF\u0010\u0000\u001a\u00060\u0002j\u0002`\u0001*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0011\u001a\u008c\u0001\u0010\u0016\u001a\u00020\u0002\"\u000e\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u00020\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001b\u001a\u00020\u00062\u0019\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\u0002\b\f2'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\f2\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0!0 H\u0081@¢\u0006\u0004\b\"\u0010#\u001ac\u0010$\u001a\u00060&j\u0002`%\"\u000e\b\u0000\u0010\u0017*\b\u0012\u0004\u0012\u00020\u00020\u00182\u0006\u0010\u001a\u001a\u0002H\u00172\u0006\u0010\u001b\u001a\u00020\u00062\u0019\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\u0002\b\f2\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0!0 H\u0082\b¢\u0006\u0004\b'\u0010(\u001a \u0010)\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u001e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0!H\u0000\u001a=\u0010,\u001a\u0002H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u000b2\u0006\u0010-\u001a\u00020.2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002H\u00170\u001d2\u0006\u00100\u001a\u0002H\u0017H\u0002¢\u0006\u0004\b1\u00102\u001aZ\u00103\u001a\u00060\u0002j\u0002`\u0001*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u0007\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\f2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b7\u00108\"\u000e\u0010\u0012\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u00069"}, m13886d2 = {"runTest", "Lkotlinx/coroutines/test/TestResult;", "", "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Lkotlin/time/Duration;", "testBody", "Lkotlin/Function2;", "Lkotlinx/coroutines/test/TestScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "runTest-8Mi8wO0", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "dispatchTimeoutMs", "", "(Lkotlinx/coroutines/test/TestScope;JLkotlin/jvm/functions/Function2;)V", "DEFAULT_DISPATCH_TIMEOUT_MS", "DEFAULT_TIMEOUT", "Lkotlin/Result;", "Ljava/lang/Object;", "runTestCoroutineLegacy", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/CoroutineScope;", "coroutine", "dispatchTimeout", "tryGetCompletionCause", "Lkotlin/Function1;", "", "cleanup", "Lkotlin/Function0;", "", "runTestCoroutineLegacy-SYHnMyU", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/AbstractCoroutine;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleTimeout", "Lkotlin/AssertionError;", "Ljava/lang/AssertionError;", "handleTimeout-dWUq8MI$TestBuildersKt__TestBuildersKt", "(Lkotlinx/coroutines/AbstractCoroutine;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/AssertionError;", "throwAll", "head", "other", "systemProperty", "name", "", "parse", "default", "systemProperty$TestBuildersKt__TestBuildersKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "runTestLegacy", "marker", "", "unused2", "runTest$default", "(Lkotlinx/coroutines/test/TestScope;JLkotlin/jvm/functions/Function2;ILjava/lang/Object;)V", "kotlinx-coroutines-test"}, m13887k = 5, m13888mv = {2, 0, 0}, m13890xi = 48, m13891xs = "kotlinx/coroutines/test/TestBuildersKt")
@SourceDebugExtension({"SMAP\nTestBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestBuilders.kt\nkotlinx/coroutines/test/TestBuildersKt__TestBuildersKt\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,617:1\n54#2,5:618\n1#3:623\n1863#4,2:624\n1863#4,2:626\n1863#4,2:628\n*S KotlinDebug\n*F\n+ 1 TestBuilders.kt\nkotlinx/coroutines/test/TestBuildersKt__TestBuildersKt\n*L\n508#1:618,5\n566#1:624,2\n572#1:626,2\n577#1:628,2\n*E\n"})
final /* synthetic */ class TestBuildersKt__TestBuildersKt {

    @NotNull
    private static final Object DEFAULT_TIMEOUT;

    static {
        Object objM22215constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(Duration.m23552boximpl(((Duration) systemProperty$TestBuildersKt__TestBuildersKt("kotlinx.coroutines.test.default_timeout", new TestBuildersKt__TestBuildersKt$DEFAULT_TIMEOUT$1$1(Duration.INSTANCE), Duration.m23552boximpl(DurationKt.toDuration(60, DurationUnit.SECONDS)))).getRawValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
        }
        DEFAULT_TIMEOUT = objM22215constructorimpl;
    }

    /* JADX INFO: renamed from: handleTimeout-dWUq8MI$TestBuildersKt__TestBuildersKt, reason: not valid java name */
    private static final <T extends AbstractCoroutine<? super Unit>> AssertionError m23782handleTimeoutdWUq8MI$TestBuildersKt__TestBuildersKt(T t, long j, Function1<? super T, ? extends Throwable> function1, Function0<? extends List<? extends Throwable>> function0) {
        List<? extends Throwable> listEmptyList;
        try {
            listEmptyList = function0.invoke();
        } catch (UncompletedCoroutinesError unused) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List list = SequencesKt.toList(SequencesKt.filter(t.getChildren(), TestBuildersKt__TestBuildersKt$handleTimeout$activeChildren$1.INSTANCE));
        Throwable thInvoke = t.isCancelled() ? function1.invoke(t) : null;
        String string = "After waiting for " + ((Object) Duration.m23594toStringimpl(j));
        if (thInvoke == null) {
            string = AbstractC0541b.m756B(string, ", the test coroutine is not completing");
        }
        if (!list.isEmpty()) {
            string = string + ", there were active child jobs: " + list;
        }
        if (thInvoke != null && list.isEmpty()) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
            sbM1324q.append(t.isCompleted() ? ", the test coroutine completed" : ", the test coroutine was not completed");
            string = sbM1324q.toString();
        }
        UncompletedCoroutinesError uncompletedCoroutinesError = new UncompletedCoroutinesError(string);
        if (thInvoke != null) {
            ExceptionsKt.addSuppressed(uncompletedCoroutinesError, thInvoke);
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(uncompletedCoroutinesError, (Throwable) it.next());
        }
        return uncompletedCoroutinesError;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Define a total timeout for the whole test instead of using dispatchTimeoutMs. Warning: the proposed replacement is not identical as it uses 'dispatchTimeoutMs' as the timeout for the whole test!", replaceWith = @ReplaceWith(expression = "runTest(context, timeout = dispatchTimeoutMs.milliseconds, testBody)", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static final void runTest(@NotNull CoroutineContext coroutineContext, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        RunningInRunTest runningInRunTest = RunningInRunTest.INSTANCE;
        if (coroutineContext.get(runningInRunTest) != null) {
            throw new IllegalStateException("Calls to `runTest` can't be nested. Please read the docs on `TestResult` for details.");
        }
        TestBuildersKt.runTest(TestScopeKt.TestScope(coroutineContext.plus(runningInRunTest)), j, function2);
    }

    public static /* synthetic */ void runTest$default(CoroutineContext coroutineContext, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        TestBuildersKt.runTest(coroutineContext, j, (Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    /* JADX INFO: renamed from: runTest-8Mi8wO0, reason: not valid java name */
    public static final void m23783runTest8Mi8wO0(@NotNull CoroutineContext coroutineContext, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        RunningInRunTest runningInRunTest = RunningInRunTest.INSTANCE;
        if (coroutineContext.get(runningInRunTest) != null) {
            throw new IllegalStateException("Calls to `runTest` can't be nested. Please read the docs on `TestResult` for details.");
        }
        TestBuildersKt.m23778runTest8Mi8wO0(TestScopeKt.TestScope(coroutineContext.plus(runningInRunTest)), j, function2);
    }

    /* JADX INFO: renamed from: runTest-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ void m23785runTest8Mi8wO0$default(CoroutineContext coroutineContext, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            Object obj2 = DEFAULT_TIMEOUT;
            ResultKt.throwOnFailure(obj2);
            j = ((Duration) obj2).getRawValue();
        }
        TestBuildersKt.m23777runTest8Mi8wO0(coroutineContext, j, (Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0171 -> B:37:0x017c). Please report as a decompilation issue!!! */
    @Deprecated(message = "Used for support of legacy behavior")
    @Nullable
    /* JADX INFO: renamed from: runTestCoroutineLegacy-SYHnMyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends AbstractCoroutine<? super Unit>> Object m23787runTestCoroutineLegacySYHnMyU(@NotNull CoroutineScope coroutineScope, @NotNull T t, long j, @NotNull Function1<? super T, ? extends Throwable> function1, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Function0<? extends List<? extends Throwable>> function0, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1 testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1;
        AbstractCoroutine abstractCoroutine;
        long j2;
        TestCoroutineScheduler testCoroutineScheduler;
        TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1 testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12;
        Ref.BooleanRef booleanRef;
        CoroutineScope coroutineScope2;
        Function1<? super T, ? extends Throwable> function12;
        Function0<? extends List<? extends Throwable>> function02;
        Job job;
        Throwable th;
        CoroutineScope coroutineScope3;
        AbstractCoroutine abstractCoroutine2;
        Function1<? super T, ? extends Throwable> function13;
        Function0<? extends List<? extends Throwable>> function03;
        TestCoroutineScheduler testCoroutineScheduler2;
        Ref.BooleanRef booleanRef2;
        long j3;
        char c;
        Throwable completionExceptionOrNull;
        List<? extends Throwable> listEmptyList;
        Job jobLaunch$default;
        if (continuation instanceof TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1) {
            testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1 = (TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1) continuation;
            int i = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.label = i - Integer.MIN_VALUE;
            } else {
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1 = new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1(continuation);
            }
        }
        Object obj = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext.Element element = t.getCoroutineContext().get(TestCoroutineScheduler.INSTANCE);
            Intrinsics.checkNotNull(element);
            abstractCoroutine = t;
            abstractCoroutine.start(CoroutineStart.UNDISPATCHED, abstractCoroutine, new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2(function2, null));
            j2 = j;
            testCoroutineScheduler = (TestCoroutineScheduler) element;
            testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1;
            booleanRef = new Ref.BooleanRef();
            coroutineScope2 = coroutineScope;
            function12 = function1;
            function02 = function0;
            while (!booleanRef.element) {
            }
            completionExceptionOrNull = abstractCoroutine.getCompletionExceptionOrNull();
            if (completionExceptionOrNull != null) {
            }
            TestBuildersKt.throwAll(null, function02.invoke());
            return Unit.INSTANCE;
        }
        if (i2 == 1) {
            j3 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.J$0;
            job = (Job) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$6;
            booleanRef2 = (Ref.BooleanRef) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$5;
            testCoroutineScheduler2 = (TestCoroutineScheduler) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$4;
            function03 = (Function0) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$3;
            function13 = (Function1) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$2;
            abstractCoroutine2 = (AbstractCoroutine) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$1;
            coroutineScope3 = (CoroutineScope) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$0 = coroutineScope3;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$1 = abstractCoroutine2;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$2 = function13;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$3 = function03;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$4 = testCoroutineScheduler2;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$5 = booleanRef2;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$6 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.J$0 = j3;
                c = 2;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.label = 2;
                if (JobKt.cancelAndJoin(job, testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1) != coroutine_suspended) {
                }
            } catch (Throwable th2) {
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1;
                th = th2;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$0 = th;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$1 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$2 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$3 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$4 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$5 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$6 = null;
                testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.label = 3;
                if (JobKt.cancelAndJoin(job, testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw th;
            }
            return coroutine_suspended;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th3 = (Throwable) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$0;
            ResultKt.throwOnFailure(obj);
            throw th3;
        }
        long j5 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.J$0;
        Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$5;
        TestCoroutineScheduler testCoroutineScheduler3 = (TestCoroutineScheduler) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$4;
        Function0<? extends List<? extends Throwable>> function04 = (Function0) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$3;
        Function1<? super T, ? extends Throwable> function14 = (Function1) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$2;
        AbstractCoroutine abstractCoroutine3 = (AbstractCoroutine) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$1;
        CoroutineScope coroutineScope4 = (CoroutineScope) testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$0;
        ResultKt.throwOnFailure(obj);
        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1;
        function12 = function14;
        c = 2;
        booleanRef = booleanRef3;
        function02 = function04;
        testCoroutineScheduler = testCoroutineScheduler3;
        j2 = j5;
        abstractCoroutine = abstractCoroutine3;
        coroutineScope2 = coroutineScope4;
        while (!booleanRef.element) {
            testCoroutineScheduler.advanceUntilIdle();
            if (!abstractCoroutine.isCompleted()) {
                try {
                    SelectImplementation selectImplementation = new SelectImplementation(testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.get$context());
                    selectImplementation.invoke(abstractCoroutine.getOnJoin(), new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$1(booleanRef, null));
                    selectImplementation.invoke(testCoroutineScheduler.getOnDispatchEventForeground$kotlinx_coroutines_test(), new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$2(null));
                    OnTimeoutKt.m23775onTimeout8Mi8wO0(selectImplementation, j2, new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3(abstractCoroutine, j2, function12, function02, null));
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$0 = coroutineScope3;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$1 = abstractCoroutine;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$2 = function12;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$3 = function02;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$4 = testCoroutineScheduler;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$5 = booleanRef;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$6 = jobLaunch$default;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.J$0 = j2;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.label = 1;
                    if (selectImplementation.doSelect(testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12) != coroutine_suspended) {
                        Ref.BooleanRef booleanRef4 = booleanRef;
                        function13 = function12;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12;
                        function03 = function02;
                        job = jobLaunch$default;
                        abstractCoroutine2 = abstractCoroutine;
                        testCoroutineScheduler2 = testCoroutineScheduler;
                        j3 = j2;
                        booleanRef2 = booleanRef4;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$0 = coroutineScope3;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$1 = abstractCoroutine2;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$2 = function13;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$3 = function03;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$4 = testCoroutineScheduler2;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$5 = booleanRef2;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.L$6 = null;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.J$0 = j3;
                        c = 2;
                        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1.label = 2;
                        if (JobKt.cancelAndJoin(job, testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1) != coroutine_suspended) {
                            function02 = function03;
                            testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12 = testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$1;
                            function12 = function13;
                            booleanRef = booleanRef2;
                            long j6 = j3;
                            testCoroutineScheduler = testCoroutineScheduler2;
                            j2 = j6;
                            abstractCoroutine = abstractCoroutine2;
                            coroutineScope4 = coroutineScope3;
                            coroutineScope2 = coroutineScope4;
                            while (!booleanRef.element) {
                            }
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    job = jobLaunch$default;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$0 = th;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$1 = null;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$2 = null;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$3 = null;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$4 = null;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$5 = null;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.L$6 = null;
                    testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12.label = 3;
                    if (JobKt.cancelAndJoin(job, testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$12) != coroutine_suspended) {
                    }
                }
                CoroutineScope coroutineScope5 = coroutineScope2;
                jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope5, new CoroutineName("background work runner"), null, new C13480xa7274f7e(testCoroutineScheduler, null), 2, null);
                coroutineScope3 = coroutineScope5;
                return coroutine_suspended;
            }
            booleanRef.element = true;
        }
        completionExceptionOrNull = abstractCoroutine.getCompletionExceptionOrNull();
        if (completionExceptionOrNull != null) {
            try {
                listEmptyList = function02.invoke();
            } catch (UncompletedCoroutinesError unused) {
                listEmptyList = CollectionsKt.emptyList();
            }
            TestBuildersKt.throwAll(completionExceptionOrNull, listEmptyList);
        }
        TestBuildersKt.throwAll(null, function02.invoke());
        return Unit.INSTANCE;
    }

    private static final <T> T systemProperty$TestBuildersKt__TestBuildersKt(String str, Function1<? super String, ? extends T> function1, T t) {
        String strSystemPropertyImpl = TestBuildersJvmKt.systemPropertyImpl(str);
        return strSystemPropertyImpl == null ? t : function1.invoke(strSystemPropertyImpl);
    }

    public static final void throwAll(@Nullable Throwable th, @NotNull List<? extends Throwable> list) throws Throwable {
        if (th != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ExceptionsKt.addSuppressed(th, (Throwable) it.next());
            }
            throw th;
        }
        Throwable th2 = (Throwable) CollectionsKt.firstOrNull((List) list);
        if (th2 != null) {
            Iterator it2 = CollectionsKt.drop(list, 1).iterator();
            while (it2.hasNext()) {
                ExceptionsKt.addSuppressed(th2, (Throwable) it2.next());
            }
            throw th2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This is for binary compatibility with the `runTest` overload that existed at some point")
    @JvmName(name = "runTest$default")
    public static final /* synthetic */ void runTest$default(TestScope testScope, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) == 0) {
            j = 60000;
        }
        TestBuildersKt.runTest(testScope, j, (Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Define a total timeout for the whole test instead of using dispatchTimeoutMs. Warning: the proposed replacement is not identical as it uses 'dispatchTimeoutMs' as the timeout for the whole test!", replaceWith = @ReplaceWith(expression = "this.runTest(timeout = dispatchTimeoutMs.milliseconds, testBody)", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    public static final void runTest(@NotNull TestScope testScope, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestScopeImpl testScopeImplAsSpecificImplementation = TestScopeKt.asSpecificImplementation(testScope);
        testScopeImplAsSpecificImplementation.enter();
        TestBuildersJvmKt.createTestResult(new TestBuildersKt__TestBuildersKt$runTest$3$1(testScopeImplAsSpecificImplementation, j, function2, testScope, null));
    }

    /* JADX INFO: renamed from: runTest-8Mi8wO0, reason: not valid java name */
    public static final void m23784runTest8Mi8wO0(@NotNull TestScope testScope, long j, @NotNull Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        TestScopeImpl testScopeImplAsSpecificImplementation = TestScopeKt.asSpecificImplementation(testScope);
        testScopeImplAsSpecificImplementation.enter();
        TestBuildersJvmKt.createTestResult(new TestBuildersKt__TestBuildersKt$runTest$2$1(testScopeImplAsSpecificImplementation, j, testScope, function2, null));
    }

    /* JADX INFO: renamed from: runTest-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ void m23786runTest8Mi8wO0$default(TestScope testScope, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            Object obj2 = DEFAULT_TIMEOUT;
            ResultKt.throwOnFailure(obj2);
            j = ((Duration) obj2).getRawValue();
        }
        TestBuildersKt.m23778runTest8Mi8wO0(testScope, j, (Function2<? super TestScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }
}
