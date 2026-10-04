package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u0019\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\b\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0086@¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0012¢\u0006\u0002\u0010\u0014\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0002H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0019\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0012¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u0019\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0002\u001a\n\u0010\u001b\u001a\u00020\u000e*\u00020\u0017\u001a\u001e\u0010\u0019\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015\u001a\u0018\u0010\u0019\u001a\u00020\u0004*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a!\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0012¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u0010\u001a\u00020\u000e*\u00020\u0017H\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u000e*\u00020\u00172\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0007\u001a\u001b\u0010!\u001a\u00020\u0015*\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\"\"\u0015\u0010\u0016\u001a\u00020\u0004*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018\"\u0015\u0010\u001e\u001a\u00020\u0002*\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, m13886d2 = {"invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Job;", "invokeImmediately", "", "handler", "Lkotlinx/coroutines/JobNode;", "Job", "Lkotlinx/coroutines/CompletableJob;", "parent", "Job0", "disposeOnCompletion", "handle", "cancelAndJoin", "", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelChildren", "cause", "Lkotlinx/coroutines/CancellationException;", "Ljava/util/concurrent/CancellationException;", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/CancellationException;)V", "", "isActive", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)Z", "cancel", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "message", "", "job", "getJob", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Job;", "orCancellation", "orCancellation$JobKt__JobKt", "kotlinx-coroutines-core"}, m13887k = 5, m13888mv = {2, 0, 0}, m13890xi = 48, m13891xs = "kotlinx/coroutines/JobKt")
@SourceDebugExtension({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,677:1\n1317#2,2:678\n1317#2,2:680\n1317#2,2:682\n1317#2,2:684\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n505#1:678,2\n519#1:680,2\n613#1:682,2\n637#1:684,2\n*E\n"})
public final /* synthetic */ class JobKt__JobKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class C132671 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
        public C132671(Object obj) {
            super(1, obj, JobNode.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ((JobNode) this.receiver).invoke(th);
        }
    }

    @NotNull
    public static final CompletableJob Job(@Nullable Job job) {
        return new JobImpl(job);
    }

    public static /* synthetic */ CompletableJob Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return JobKt.Job(job);
    }

    public static final void cancel(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancel(coroutineContext, cancellationException);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        Object objJoin = job.join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    public static final void cancelChildren(@NotNull Job job, @Nullable CancellationException cancellationException) {
        Iterator<Job> it = job.getChildren().iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancelChildren$default(Job job, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(job, cancellationException);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return invokeOnCompletion$default(job, false, new DisposeOnCompletion(disposableHandle), 1, null);
    }

    public static final void ensureActive(@NotNull Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    @NotNull
    public static final Job getJob(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    @NotNull
    public static final DisposableHandle invokeOnCompletion(@NotNull Job job, boolean z, @NotNull JobNode jobNode) {
        return job instanceof JobSupport ? ((JobSupport) job).invokeOnCompletionInternal$kotlinx_coroutines_core(z, jobNode) : job.invokeOnCompletion(jobNode.getOnCancelling(), z, new C132671(jobNode));
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, JobNode jobNode, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return JobKt.invokeOnCompletion(job, z, jobNode);
    }

    public static final boolean isActive(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }

    private static final Throwable orCancellation$JobKt__JobKt(Throwable th, Job job) {
        return th == null ? new JobCancellationException("Job was cancelled", null, job) : th;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @JvmName(name = "Job")
    /* JADX INFO: renamed from: Job, reason: collision with other method in class */
    public static final /* synthetic */ Job m23699Job(Job job) {
        return JobKt.Job(job);
    }

    /* JADX INFO: renamed from: Job$default, reason: collision with other method in class */
    public static /* synthetic */ Job m23700Job$default(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return m23699Job(job);
    }

    public static /* synthetic */ void cancel$default(Job job, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        JobKt.cancel(job, str, th);
    }

    public static /* synthetic */ void cancelChildren$default(Job job, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(job, th);
    }

    public static final void ensureActive(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job != null) {
            JobKt.ensureActive(job);
        }
    }

    public static final void cancel(@NotNull Job job, @NotNull String str, @Nullable Throwable th) {
        job.cancel(ExceptionsKt.CancellationException(str, th));
    }

    public static /* synthetic */ boolean cancel$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        return cancel(coroutineContext, th);
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean cancel(CoroutineContext coroutineContext, Throwable th) {
        CoroutineContext.Element element = coroutineContext.get(Job.INSTANCE);
        JobSupport jobSupport = element instanceof JobSupport ? (JobSupport) element : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, jobSupport));
        return true;
    }

    public static /* synthetic */ void cancelChildren$default(CoroutineContext coroutineContext, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        cancelChildren(coroutineContext, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(Job job, Throwable th) {
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
            }
        }
    }

    public static final void cancelChildren(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Sequence<Job> children;
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null || (children = job.getChildren()) == null) {
            return;
        }
        Iterator<Job> it = children.iterator();
        while (it.hasNext()) {
            it.next().cancel(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void cancelChildren(CoroutineContext coroutineContext, Throwable th) {
        Job job = (Job) coroutineContext.get(Job.INSTANCE);
        if (job == null) {
            return;
        }
        for (Job job2 : job.getChildren()) {
            JobSupport jobSupport = job2 instanceof JobSupport ? (JobSupport) job2 : null;
            if (jobSupport != null) {
                jobSupport.cancelInternal(orCancellation$JobKt__JobKt(th, job));
            }
        }
    }
}
