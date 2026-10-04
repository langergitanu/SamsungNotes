package androidx.glance.oneui.template.preview;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.session.SessionManager;
import androidx.glance.session.SessionManagerScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\b\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/oneui/template/preview/PreviewSessionManager;", "Landroidx/glance/session/SessionManager;", "()V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "scope", "androidx/glance/oneui/template/preview/PreviewSessionManager$scope$1", "Landroidx/glance/oneui/template/preview/PreviewSessionManager$scope$1;", "runWithLock", "T", "block", "Lkotlin/Function2;", "Landroidx/glance/session/SessionManagerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPreviewSessionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewSessionManager.kt\nandroidx/glance/oneui/template/preview/PreviewSessionManager\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,70:1\n120#2,10:71\n*S KotlinDebug\n*F\n+ 1 PreviewSessionManager.kt\nandroidx/glance/oneui/template/preview/PreviewSessionManager\n*L\n66#1:71,10\n*E\n"})
public final class PreviewSessionManager implements SessionManager {

    @NotNull
    public static final PreviewSessionManager INSTANCE = new PreviewSessionManager();

    @NotNull
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    @NotNull
    private static final PreviewSessionManager$scope$1 scope = new PreviewSessionManager$scope$1();
    public static final int $stable = 8;

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewSessionManager$runWithLock$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSessionManager", m14021f = "PreviewSessionManager.kt", m14022i = {0, 0, 1}, m14023l = {76, 66}, m14024m = "runWithLock", m14025n = {"block", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, m14026s = {"L$0", "L$1", "L$0"})
    public static final class C34821<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C34821(Continuation<? super C34821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewSessionManager.this.runWithLock(null, this);
        }
    }

    private PreviewSessionManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.session.SessionManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object runWithLock(@NotNull Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        C34821 c34821;
        Mutex mutex2;
        Throwable th;
        Mutex mutex3;
        if (continuation instanceof C34821) {
            c34821 = (C34821) continuation;
            int i = c34821.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c34821.label = i - Integer.MIN_VALUE;
            } else {
                c34821 = new C34821(continuation);
            }
        }
        Object obj = c34821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c34821.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex2 = mutex;
                c34821.L$0 = function2;
                c34821.L$1 = mutex2;
                c34821.label = 1;
                if (mutex2.lock(null, c34821) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex3 = (Mutex) c34821.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex3.unlock(null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    mutex3.unlock(null);
                    throw th;
                }
            }
            Mutex mutex4 = (Mutex) c34821.L$1;
            Function2<? super SessionManagerScope, ? super Continuation<? super T>, ? extends Object> function22 = (Function2) c34821.L$0;
            ResultKt.throwOnFailure(obj);
            mutex2 = mutex4;
            function2 = function22;
            PreviewSessionManager$scope$1 previewSessionManager$scope$1 = scope;
            Intrinsics.checkNotNull(previewSessionManager$scope$1, "null cannot be cast to non-null type androidx.glance.appwidget.multiprocess.CoroutineSessionManagerScope");
            c34821.L$0 = mutex2;
            c34821.L$1 = null;
            c34821.label = 2;
            Object objInvoke = function2.invoke(previewSessionManager$scope$1, c34821);
            if (objInvoke != coroutine_suspended) {
                Mutex mutex5 = mutex2;
                obj = objInvoke;
                mutex3 = mutex5;
                mutex3.unlock(null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex6 = mutex2;
            th = th3;
            mutex3 = mutex6;
            mutex3.unlock(null);
            throw th;
        }
    }
}
