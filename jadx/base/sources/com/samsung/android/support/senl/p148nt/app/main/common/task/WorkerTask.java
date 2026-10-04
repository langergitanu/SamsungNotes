package com.samsung.android.support.senl.p148nt.app.main.common.task;

import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002#$B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0017\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0017\u0010\u0019\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0017J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\n¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "TaskParams", "", "hashCode", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(ILkotlinx/coroutines/CoroutineDispatcher;)V", "getHashCode", "()I", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Callback;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "workingJob", "Lkotlinx/coroutines/Job;", "activityHashCode", "getActivityHashCode", "setCallback", "", "run", "taskParams", "(Ljava/lang/Object;)V", "onPreExecute", "execute", "onPostExecute", "getTag", "", "getResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "cancel", "isCancelled", "", "isCompleted", "Result", "Callback", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class WorkerTask<TaskParams> {

    @Nullable
    private Callback callback;
    private final int hashCode;

    @NotNull
    private final CoroutineScope workerScope;

    @Nullable
    private Job workingJob;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Callback;", "", "onStart", "", "task", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "onEnd", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Callback {
        void onEnd(@NotNull Result result);

        void onStart(@NotNull WorkerTask<?> task);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "", "tag", "", "getTag", "()Ljava/lang/String;", "hashCode", "", "getHashCode", "()I", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Result {
        int getHashCode();

        @NotNull
        String getTag();
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask$run$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask$run$1", m14021f = "WorkerTask.kt", m14022i = {}, m14023l = {28, 31}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C82161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TaskParams $taskParams;
        int label;
        final /* synthetic */ WorkerTask<TaskParams> this$0;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask$run$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask$run$1$1", m14021f = "WorkerTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ WorkerTask<TaskParams> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(WorkerTask<TaskParams> workerTask, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = workerTask;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.onPreExecute();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask$run$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask$run$1$2", m14021f = "WorkerTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TaskParams $taskParams;
            int label;
            final /* synthetic */ WorkerTask<TaskParams> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(WorkerTask<TaskParams> workerTask, TaskParams taskparams, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = workerTask;
                this.$taskParams = taskparams;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$taskParams, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.execute(this.$taskParams);
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C82161(WorkerTask<TaskParams> workerTask, TaskParams taskparams, Continuation<? super C82161> continuation) {
            super(2, continuation);
            this.this$0 = workerTask;
            this.$taskParams = taskparams;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C82161(this.this$0, this.$taskParams, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0075, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r8, r1, r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Thread.currentThread().setName(this.this$0.getTag());
                MainLogger.m7254d(this.this$0.getTag(), "start " + Thread.currentThread().getName());
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.getDefault();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$taskParams, null);
            this.label = 2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C82161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkerTask() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void run$default(WorkerTask workerTask, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: run");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        workerTask.run(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit run$lambda$0(WorkerTask workerTask, Throwable th) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WorkerTask$run$2$1(workerTask, null), 3, null);
        AbstractC0000a.m25v("end ", Thread.currentThread().getName(), workerTask.getTag());
        return Unit.INSTANCE;
    }

    public void cancel() {
        Job job = this.workingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public abstract void execute(@Nullable TaskParams taskParams);

    /* JADX INFO: renamed from: getActivityHashCode, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    @NotNull
    public abstract Result getResult();

    @NotNull
    public abstract String getTag();

    public final boolean isCancelled() {
        Job job = this.workingJob;
        return job != null && job.isCancelled();
    }

    public final boolean isCompleted() {
        Job job = this.workingJob;
        return job != null && job.isCompleted();
    }

    public void onPostExecute() {
        Callback callback = this.callback;
        if (callback != null) {
            callback.onEnd(getResult());
        }
    }

    public void onPreExecute() {
        Callback callback = this.callback;
        if (callback != null) {
            callback.onStart(this);
        }
    }

    public final void run(@Nullable TaskParams taskParams) {
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(this.workerScope, null, null, new C82161(this, taskParams, null), 3, null);
        this.workingJob = jobLaunch$default;
        if (jobLaunch$default != null) {
            jobLaunch$default.invokeOnCompletion(new C4202b(this, 6));
        }
    }

    public final void setCallback(@Nullable Callback callback) {
        this.callback = callback;
    }

    public WorkerTask(int i, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.hashCode = i;
        this.workerScope = CoroutineScopeKt.CoroutineScope(dispatcher);
    }

    public /* synthetic */ WorkerTask(int i, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? Dispatchers.getDefault() : coroutineDispatcher);
    }
}
