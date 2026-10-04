package androidx.glance.session;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresApi;
import androidx.glance.oneui.common.GlanceLog;
import androidx.work.Data;
import androidx.work.DirectExecutor;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H\u0097@¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"androidx/glance/session/SessionManagerImpl$scope$1", "Landroidx/glance/session/SessionManagerScope;", Constants.EXTRA_KEY_SESSIONS, "", "", "Landroidx/glance/session/Session;", "closeSession", "", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSession", "isSessionRunning", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSession", "session", "(Landroid/content/Context;Landroidx/glance/session/Session;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSessionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SessionManager.kt\nandroidx/glance/session/SessionManagerImpl$scope$1\n+ 2 Data.kt\nandroidx/work/DataKt\n+ 3 ListenableFuture.kt\nandroidx/work/ListenableFutureKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n31#2,5:195\n40#3,8:200\n48#3:217\n60#3,7:218\n40#3,8:233\n48#3:250\n60#3,7:251\n314#4,9:208\n323#4,2:225\n314#4,9:241\n323#4,2:258\n766#5:227\n857#5,2:228\n766#5:230\n857#5,2:231\n1747#5,3:260\n*S KotlinDebug\n*F\n+ 1 SessionManager.kt\nandroidx/glance/session/SessionManagerImpl$scope$1\n*L\n114#1:195,5\n122#1:200,8\n122#1:217\n122#1:218,7\n149#1:233,8\n149#1:250\n149#1:251,7\n122#1:208,9\n122#1:225,2\n149#1:241,9\n149#1:258,2\n124#1:227\n124#1:228,2\n126#1:230\n126#1:231,2\n150#1:260,3\n*E\n"})
public final class SessionManagerImpl$scope$1 implements SessionManagerScope {

    @NotNull
    private final Map<String, Session> sessions = new LinkedHashMap();
    final /* synthetic */ SessionManagerImpl this$0;

    public SessionManagerImpl$scope$1(SessionManagerImpl sessionManagerImpl) {
        this.this$0 = sessionManagerImpl;
    }

    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    public Object closeSession(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        GlanceLog.INSTANCE.m2297d("GWT:SessionManager", "closeSession(" + str + ")");
        Session sessionRemove = this.sessions.remove(str);
        if (sessionRemove != null) {
            sessionRemove.close();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    public Session getSession(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.sessions.get(key);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:12:0x0035, B:36:0x00a6, B:38:0x00b1, B:47:0x00e3, B:49:0x00ed, B:55:0x00f9, B:41:0x00bc, B:42:0x00c0, B:44:0x00c6, B:19:0x0047, B:21:0x005a, B:29:0x006b, B:31:0x009b, B:24:0x0062, B:28:0x006a), top: B:59:0x0024, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c6 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:12:0x0035, B:36:0x00a6, B:38:0x00b1, B:47:0x00e3, B:49:0x00ed, B:55:0x00f9, B:41:0x00bc, B:42:0x00c0, B:44:0x00c6, B:19:0x0047, B:21:0x005a, B:29:0x006b, B:31:0x009b, B:24:0x0062, B:28:0x006a), top: B:59:0x0024, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ed A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:12:0x0035, B:36:0x00a6, B:38:0x00b1, B:47:0x00e3, B:49:0x00ed, B:55:0x00f9, B:41:0x00bc, B:42:0x00c0, B:44:0x00c6, B:19:0x0047, B:21:0x005a, B:29:0x006b, B:31:0x009b, B:24:0x0062, B:28:0x006a), top: B:59:0x0024, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.SessionManagerScope
    @RequiresApi(23)
    @SuppressLint({"ListIterator"})
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object isSessionRunning(@NotNull Context context, @NotNull String str, @NotNull Continuation<? super Boolean> continuation) throws Throwable {
        SessionManagerImpl$scope$1$isSessionRunning$1 sessionManagerImpl$scope$1$isSessionRunning$1;
        Object obj;
        String str2;
        SessionManagerImpl$scope$1 sessionManagerImpl$scope$1;
        SessionManagerImpl$scope$1 sessionManagerImpl$scope$12;
        Iterable iterable;
        Iterator it;
        boolean z;
        boolean zIsOpen;
        if (continuation instanceof SessionManagerImpl$scope$1$isSessionRunning$1) {
            sessionManagerImpl$scope$1$isSessionRunning$1 = (SessionManagerImpl$scope$1$isSessionRunning$1) continuation;
            int i = sessionManagerImpl$scope$1$isSessionRunning$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                sessionManagerImpl$scope$1$isSessionRunning$1.label = i - Integer.MIN_VALUE;
            } else {
                sessionManagerImpl$scope$1$isSessionRunning$1 = new SessionManagerImpl$scope$1$isSessionRunning$1(this, continuation);
            }
        }
        Object result = sessionManagerImpl$scope$1$isSessionRunning$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = sessionManagerImpl$scope$1$isSessionRunning$1.label;
        boolean z2 = true;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(result);
                final ListenableFuture<List<WorkInfo>> workInfosForUniqueWork = WorkManager.getInstance(context).getWorkInfosForUniqueWork(str);
                Intrinsics.checkNotNullExpressionValue(workInfosForUniqueWork, "getWorkInfosForUniqueWork(...)");
                if (workInfosForUniqueWork.isDone()) {
                    try {
                        obj = workInfosForUniqueWork.get();
                        str2 = str;
                        sessionManagerImpl$scope$1 = this;
                        Intrinsics.checkNotNullExpressionValue(obj, "await(...)");
                        iterable = (Iterable) obj;
                        if ((iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                            it = iterable.iterator();
                            while (it.hasNext()) {
                                if (CollectionsKt.listOf((Object[]) new WorkInfo.State[]{WorkInfo.State.RUNNING, WorkInfo.State.ENQUEUED}).contains(((WorkInfo) it.next()).getState())) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        } else {
                            z = false;
                        }
                        Session session = sessionManagerImpl$scope$1.sessions.get(str2);
                        zIsOpen = session == null ? session.isOpen() : false;
                        if (zIsOpen || !z) {
                            z2 = false;
                        }
                        GlanceLog.INSTANCE.m2301i("GWT:SessionManager", "isSessionRunning(" + str2 + ")==" + z2 + "(" + z + SQLKeyword.COMMA + zIsOpen + ")");
                        return Boxing.boxBoolean(z2);
                    } catch (ExecutionException e) {
                        Throwable cause = e.getCause();
                        if (cause == null) {
                            throw e;
                        }
                        throw cause;
                    }
                }
                sessionManagerImpl$scope$1$isSessionRunning$1.L$0 = this;
                sessionManagerImpl$scope$1$isSessionRunning$1.L$1 = str;
                sessionManagerImpl$scope$1$isSessionRunning$1.L$2 = workInfosForUniqueWork;
                sessionManagerImpl$scope$1$isSessionRunning$1.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(sessionManagerImpl$scope$1$isSessionRunning$1), 1);
                cancellableContinuationImpl.initCancellability();
                workInfosForUniqueWork.addListener(new Runnable() { // from class: androidx.glance.session.SessionManagerImpl$scope$1$isSessionRunning$$inlined$await$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m22215constructorimpl(workInfosForUniqueWork.get()));
                        } catch (Throwable th) {
                            Throwable cause2 = th.getCause();
                            if (cause2 == null) {
                                cause2 = th;
                            }
                            if (th instanceof CancellationException) {
                                cancellableContinuationImpl.cancel(cause2);
                                return;
                            }
                            CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(cause2)));
                        }
                    }
                }, DirectExecutor.INSTANCE);
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.glance.session.SessionManagerImpl$scope$1$isSessionRunning$$inlined$await$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th) {
                        workInfosForUniqueWork.cancel(false);
                    }
                });
                result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(sessionManagerImpl$scope$1$isSessionRunning$1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sessionManagerImpl$scope$12 = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) sessionManagerImpl$scope$1$isSessionRunning$1.L$1;
                sessionManagerImpl$scope$12 = (SessionManagerImpl$scope$1) sessionManagerImpl$scope$1$isSessionRunning$1.L$0;
                ResultKt.throwOnFailure(result);
            }
            String str3 = str;
            sessionManagerImpl$scope$1 = sessionManagerImpl$scope$12;
            obj = result;
            str2 = str3;
            Intrinsics.checkNotNullExpressionValue(obj, "await(...)");
            iterable = (Iterable) obj;
            if (iterable instanceof Collection) {
                it = iterable.iterator();
                while (it.hasNext()) {
                }
                z = false;
            }
            Session session2 = sessionManagerImpl$scope$1.sessions.get(str2);
            if (session2 == null) {
            }
            if (zIsOpen) {
                z2 = false;
            }
            GlanceLog.INSTANCE.m2301i("GWT:SessionManager", "isSessionRunning(" + str2 + ")==" + z2 + "(" + z + SQLKeyword.COMMA + zIsOpen + ")");
            return Boxing.boxBoolean(z2);
        } catch (Exception e2) {
            GlanceLog.INSTANCE.m2299e("GWT:SessionManager", "WorkManager is not initialized / " + e2);
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // androidx.glance.session.SessionManagerScope
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startSession(@NotNull Context context, @NotNull Session session, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        SessionManagerImpl$scope$1$startSession$1 sessionManagerImpl$scope$1$startSession$1;
        WorkManager workManager;
        SessionManagerImpl$scope$1 sessionManagerImpl$scope$1;
        if (continuation instanceof SessionManagerImpl$scope$1$startSession$1) {
            sessionManagerImpl$scope$1$startSession$1 = (SessionManagerImpl$scope$1$startSession$1) continuation;
            int i = sessionManagerImpl$scope$1$startSession$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                sessionManagerImpl$scope$1$startSession$1.label = i - Integer.MIN_VALUE;
            } else {
                sessionManagerImpl$scope$1$startSession$1 = new SessionManagerImpl$scope$1$startSession$1(this, continuation);
            }
        }
        Object obj = sessionManagerImpl$scope$1$startSession$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = sessionManagerImpl$scope$1$startSession$1.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Session sessionPut = this.sessions.put(session.getKey(), session);
                if (sessionPut != null) {
                    sessionPut.close();
                }
                OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(this.this$0.workerClass);
                Pair[] pairArr = {TuplesKt.m13893to(this.this$0.getKeyParam(), session.getKey())};
                Data.Builder builder2 = new Data.Builder();
                Pair pair = pairArr[0];
                builder2.put((String) pair.getFirst(), pair.getSecond());
                Data dataBuild = builder2.build();
                Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
                OneTimeWorkRequest.Builder inputData = builder.setInputData(dataBuild);
                String packageName = context.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                OneTimeWorkRequest oneTimeWorkRequestBuild = inputData.addTag(packageName).addTag(session.getKey()).build();
                workManager = WorkManager.getInstance(context);
                Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(...)");
                final ListenableFuture<Operation.State.SUCCESS> result = workManager.enqueueUniqueWork(session.getKey(), ExistingWorkPolicy.REPLACE, oneTimeWorkRequestBuild).getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                if (result.isDone()) {
                    try {
                        result.get();
                    } catch (ExecutionException e) {
                        Throwable cause = e.getCause();
                        if (cause == null) {
                            throw e;
                        }
                        throw cause;
                    }
                } else {
                    sessionManagerImpl$scope$1$startSession$1.L$0 = this;
                    sessionManagerImpl$scope$1$startSession$1.L$1 = context;
                    sessionManagerImpl$scope$1$startSession$1.L$2 = session;
                    sessionManagerImpl$scope$1$startSession$1.L$3 = workManager;
                    sessionManagerImpl$scope$1$startSession$1.L$4 = result;
                    sessionManagerImpl$scope$1$startSession$1.label = 1;
                    final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(sessionManagerImpl$scope$1$startSession$1), 1);
                    cancellableContinuationImpl.initCancellability();
                    result.addListener(new Runnable() { // from class: androidx.glance.session.SessionManagerImpl$scope$1$startSession$$inlined$await$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m22215constructorimpl(result.get()));
                            } catch (Throwable th) {
                                Throwable cause2 = th.getCause();
                                if (cause2 == null) {
                                    cause2 = th;
                                }
                                if (th instanceof CancellationException) {
                                    cancellableContinuationImpl.cancel(cause2);
                                    return;
                                }
                                CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                                Result.Companion companion2 = Result.INSTANCE;
                                cancellableContinuation2.resumeWith(Result.m22215constructorimpl(ResultKt.createFailure(cause2)));
                            }
                        }
                    }, DirectExecutor.INSTANCE);
                    cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.glance.session.SessionManagerImpl$scope$1$startSession$$inlined$await$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable Throwable th) {
                            result.cancel(false);
                        }
                    });
                    Object result2 = cancellableContinuationImpl.getResult();
                    if (result2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(sessionManagerImpl$scope$1$startSession$1);
                    }
                    if (result2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                sessionManagerImpl$scope$1 = this;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                WorkManager workManager2 = (WorkManager) sessionManagerImpl$scope$1$startSession$1.L$3;
                session = (Session) sessionManagerImpl$scope$1$startSession$1.L$2;
                Context context2 = (Context) sessionManagerImpl$scope$1$startSession$1.L$1;
                sessionManagerImpl$scope$1 = (SessionManagerImpl$scope$1) sessionManagerImpl$scope$1$startSession$1.L$0;
                ResultKt.throwOnFailure(obj);
                workManager = workManager2;
                context = context2;
            }
            List<WorkInfo> list = workManager.getWorkInfosByTag(session.getKey()).get();
            Intrinsics.checkNotNullExpressionValue(list, "get(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                WorkInfo workInfo = (WorkInfo) obj2;
                if (workInfo.getState() == WorkInfo.State.ENQUEUED || workInfo.getState() == WorkInfo.State.RUNNING) {
                    arrayList.add(obj2);
                }
            }
            int size = arrayList.size();
            List<WorkInfo> list2 = workManager.getWorkInfosByTag(context.getPackageName()).get();
            Intrinsics.checkNotNullExpressionValue(list2, "get(...)");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : list2) {
                WorkInfo workInfo2 = (WorkInfo) obj3;
                if (workInfo2.getState() == WorkInfo.State.ENQUEUED || workInfo2.getState() == WorkInfo.State.RUNNING) {
                    arrayList2.add(obj3);
                }
            }
            int size2 = arrayList2.size();
            GlanceLog.INSTANCE.m2301i("GWT:SessionManager", "startSession " + session.getKey() + " ENQUEUED + RUNNING : " + size + " / " + size2);
            sessionManagerImpl$scope$1.this$0.enqueueDelayedWorker(context);
        } catch (Exception e2) {
            GlanceLog.INSTANCE.m2299e("GWT:SessionManager", "WorkManager is still not initialized / " + e2);
        }
        return Unit.INSTANCE;
    }
}
