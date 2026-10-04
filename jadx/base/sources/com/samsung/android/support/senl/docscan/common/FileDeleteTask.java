package com.samsung.android.support.senl.docscan.common;

import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0011\"\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/common/FileDeleteTask;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "job", "Lkotlinx/coroutines/CompletableJob;", "getJob", "()Lkotlinx/coroutines/CompletableJob;", "setJob", "(Lkotlinx/coroutines/CompletableJob;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "execute", "Lkotlinx/coroutines/Job;", "paths", "", "", "([Ljava/lang/String;)Lkotlinx/coroutines/Job;", "doInBackground", "Ljava/lang/Void;", "([Ljava/lang/String;)Ljava/lang/Void;", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FileDeleteTask implements CoroutineScope {

    @NotNull
    private static final String TAG = "FileDeleteTask";

    @NotNull
    private CompletableJob job = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);

    /* JADX INFO: renamed from: com.samsung.android.support.senl.docscan.common.FileDeleteTask$execute$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.docscan.common.FileDeleteTask$execute$1", m14021f = "FileDeleteTask.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C79771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String[] $paths;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79771(String[] strArr, Continuation<? super C79771> continuation) {
            super(2, continuation);
            this.$paths = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FileDeleteTask.this.new C79771(this.$paths, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FileDeleteTask fileDeleteTask = FileDeleteTask.this;
            String[] strArr = this.$paths;
            fileDeleteTask.doInBackground((String[]) Arrays.copyOf(strArr, strArr.length));
            Job.DefaultImpls.cancel$default((Job) FileDeleteTask.this.getJob(), (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C79771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void doInBackground(String... paths) {
        for (String str : paths) {
            if (str != null) {
                try {
                    FileUtils.deleteFile(new File(str));
                } catch (IOException e) {
                    Logger.m7146e(TAG, e.getMessage());
                }
            }
        }
        return null;
    }

    @NotNull
    public final Job execute(@NotNull String... paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        return BuildersKt__Builders_commonKt.launch$default(this, null, null, new C79771(paths, null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.job.plus(Dispatchers.getIO());
    }

    @NotNull
    public final CompletableJob getJob() {
        return this.job;
    }

    public final void setJob(@NotNull CompletableJob completableJob) {
        Intrinsics.checkNotNullParameter(completableJob, "<set-?>");
        this.job = completableJob;
    }
}
