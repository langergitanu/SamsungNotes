package androidx.glance.session;

import android.content.Context;
import com.sun.imageio.plugins.jpeg.JPEG;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.session.SessionWorkerKt$runSession$effectExceptionHandler$1$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {JPEG.EXP}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class SessionWorkerKt$runSession$effectExceptionHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Session $session;
    final /* synthetic */ TimerScope $this_runSession;
    final /* synthetic */ Throwable $throwable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionWorkerKt$runSession$effectExceptionHandler$1$1(Session session, Context context, Throwable th, TimerScope timerScope, Continuation<? super SessionWorkerKt$runSession$effectExceptionHandler$1$1> continuation) {
        super(2, continuation);
        this.$session = session;
        this.$context = context;
        this.$throwable = th;
        this.$this_runSession = timerScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SessionWorkerKt$runSession$effectExceptionHandler$1$1(this.$session, this.$context, this.$throwable, this.$this_runSession, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Session session = this.$session;
            Context context = this.$context;
            Throwable th = this.$throwable;
            this.label = 1;
            if (session.onCompositionError(context, th, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CoroutineScopeKt.cancel(this.$this_runSession, "Error in composition effect coroutine", this.$throwable);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SessionWorkerKt$runSession$effectExceptionHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
