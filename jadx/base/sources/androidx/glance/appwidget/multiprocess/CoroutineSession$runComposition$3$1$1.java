package androidx.glance.appwidget.multiprocess;

import android.content.Context;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.Recomposer;
import androidx.glance.oneui.common.GlanceLog;
import kotlin.Metadata;
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
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.CoroutineSession$runComposition$3$1$1", m14021f = "CoroutineSession.kt", m14022i = {}, m14023l = {78}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class CoroutineSession$runComposition$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Composition $composition;
    final /* synthetic */ Context $context;
    final /* synthetic */ Recomposer $recomposer;
    int label;
    final /* synthetic */ CoroutineSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineSession$runComposition$3$1$1(Composition composition, CoroutineSession coroutineSession, Context context, Recomposer recomposer, Continuation<? super CoroutineSession$runComposition$3$1$1> continuation) {
        super(2, continuation);
        this.$composition = composition;
        this.this$0 = coroutineSession;
        this.$context = context;
        this.$recomposer = recomposer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CoroutineSession$runComposition$3$1$1(this.$composition, this.this$0, this.$context, this.$recomposer, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$composition.setContent(this.this$0.mo21926provideGlance(this.$context));
                Recomposer recomposer = this.$recomposer;
                this.label = 1;
                if (recomposer.runRecomposeAndApplyChanges(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            GlanceLog.INSTANCE.m2297d("GWT:CoroutineSession", "Exception " + e + " at Coroutine Session's Frame Clock");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CoroutineSession$runComposition$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
