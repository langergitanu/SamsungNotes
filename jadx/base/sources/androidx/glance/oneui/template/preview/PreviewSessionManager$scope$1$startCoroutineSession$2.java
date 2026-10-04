package androidx.glance.oneui.template.preview;

import android.content.Context;
import androidx.glance.appwidget.multiprocess.CoroutineSession;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m13886d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSessionManager$scope$1$startCoroutineSession$2", m14021f = "PreviewSessionManager.kt", m14022i = {}, m14023l = {50}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class PreviewSessionManager$scope$1$startCoroutineSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CoroutineSession $session;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewSessionManager$scope$1$startCoroutineSession$2(CoroutineSession coroutineSession, Context context, Continuation<? super PreviewSessionManager$scope$1$startCoroutineSession$2> continuation) {
        super(2, continuation);
        this.$session = coroutineSession;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PreviewSessionManager$scope$1$startCoroutineSession$2(this.$session, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objM21352runComposition0E7RQCE$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineSession coroutineSession = this.$session;
            Context context = this.$context;
            this.label = 1;
            objM21352runComposition0E7RQCE$default = CoroutineSession.m21352runComposition0E7RQCE$default(coroutineSession, context, null, this, 2, null);
            if (objM21352runComposition0E7RQCE$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM21352runComposition0E7RQCE$default = ((Result) obj).getValue();
        }
        return Result.m22214boximpl(objM21352runComposition0E7RQCE$default);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Result<Unit>> continuation) {
        return ((PreviewSessionManager$scope$1$startCoroutineSession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
