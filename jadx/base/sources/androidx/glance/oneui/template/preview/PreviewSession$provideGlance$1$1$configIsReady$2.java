package androidx.glance.oneui.template.preview;

import android.content.Context;
import androidx.compose.runtime.ProduceStateScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Landroidx/compose/runtime/ProduceStateScope;", ""}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewSession$provideGlance$1$1$configIsReady$2", m14021f = "PreviewSession.kt", m14022i = {0}, m14023l = {139}, m14024m = "invokeSuspend", m14025n = {"$this$produceState"}, m14026s = {"L$0"})
public final class PreviewSession$provideGlance$1$1$configIsReady$2 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PreviewSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewSession$provideGlance$1$1$configIsReady$2(PreviewSession previewSession, Context context, Continuation<? super PreviewSession$provideGlance$1$1$configIsReady$2> continuation) {
        super(2, continuation);
        this.this$0 = previewSession;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PreviewSession$provideGlance$1$1$configIsReady$2 previewSession$provideGlance$1$1$configIsReady$2 = new PreviewSession$provideGlance$1$1$configIsReady$2(this.this$0, this.$context, continuation);
        previewSession$provideGlance$1$1$configIsReady$2.L$0 = obj;
        return previewSession$provideGlance$1$1$configIsReady$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProduceStateScope<Boolean> produceStateScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PreviewSession$provideGlance$1$1$configIsReady$2) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        ProduceStateScope produceStateScope;
        PreviewSession previewSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            produceStateScope = (ProduceStateScope) this.L$0;
            if (this.this$0.widget.getStateDefinition() != null) {
                PreviewSession previewSession2 = this.this$0;
                Context context = this.$context;
                this.L$0 = produceStateScope;
                this.L$1 = previewSession2;
                this.label = 1;
                Object previewGlanceState$glance_oneui_template_release = previewSession2.getPreviewGlanceState$glance_oneui_template_release(context, this);
                if (previewGlanceState$glance_oneui_template_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
                previewSession = previewSession2;
                obj = previewGlanceState$glance_oneui_template_release;
            }
            produceStateScope.setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        previewSession = (PreviewSession) this.L$1;
        produceStateScope = (ProduceStateScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        previewSession.previewState = (PreviewGlanceState) obj;
        produceStateScope.setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
