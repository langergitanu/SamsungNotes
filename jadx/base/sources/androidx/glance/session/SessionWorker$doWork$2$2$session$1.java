package androidx.glance.session;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "Landroidx/glance/session/Session;", "Landroidx/glance/session/SessionManagerScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.session.SessionWorker$doWork$2$2$session$1", m14021f = "SessionWorker.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class SessionWorker$doWork$2$2$session$1 extends SuspendLambda implements Function2<SessionManagerScope, Continuation<? super Session>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SessionWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionWorker$doWork$2$2$session$1(SessionWorker sessionWorker, Continuation<? super SessionWorker$doWork$2$2$session$1> continuation) {
        super(2, continuation);
        this.this$0 = sessionWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SessionWorker$doWork$2$2$session$1 sessionWorker$doWork$2$2$session$1 = new SessionWorker$doWork$2$2$session$1(this.this$0, continuation);
        sessionWorker$doWork$2$2$session$1.L$0 = obj;
        return sessionWorker$doWork$2$2$session$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SessionManagerScope sessionManagerScope, @Nullable Continuation<? super Session> continuation) {
        return ((SessionWorker$doWork$2$2$session$1) create(sessionManagerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return ((SessionManagerScope) this.L$0).getSession(this.this$0.key);
    }
}
