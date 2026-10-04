package androidx.glance.oneui.template.preview;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.glance.oneui.template.GlanceTemplateAppWidget;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a,\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\b\u00060\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, m13886d2 = {"providePreviewContent", "", "Landroidx/glance/oneui/template/GlanceTemplateAppWidget;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "(Landroidx/glance/oneui/template/GlanceTemplateAppWidget;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runGlance", "Lkotlinx/coroutines/flow/Flow;", "context", "Landroid/content/Context;", "glance-oneui-template_release"}, m13887k = 2, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class PreviewContentReceiverKt {

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewContentReceiverKt$providePreviewContent$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewContentReceiverKt", m14021f = "PreviewContentReceiver.kt", m14022i = {}, m14023l = {43}, m14024m = "providePreviewContent", m14025n = {}, m14026s = {})
    public static final class C34741 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C34741(Continuation<? super C34741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewContentReceiverKt.providePreviewContent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewContentReceiverKt$runGlance$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Function0;", "Landroidx/glance/GlanceComposable;", "Landroidx/compose/runtime/Composable;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewContentReceiverKt$runGlance$1", m14021f = "PreviewContentReceiver.kt", m14022i = {}, m14023l = {37}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C34751 extends SuspendLambda implements Function2<ProducerScope<? super Function2<? super Composer, ? super Integer, ? extends Unit>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ GlanceTemplateAppWidget $this_runGlance;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.glance.oneui.template.preview.PreviewContentReceiverKt$runGlance$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
        @DebugMetadata(m14020c = "androidx.glance.oneui.template.preview.PreviewContentReceiverKt$runGlance$1$1", m14021f = "PreviewContentReceiver.kt", m14022i = {}, m14023l = {37}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ GlanceTemplateAppWidget $this_runGlance;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GlanceTemplateAppWidget glanceTemplateAppWidget, Context context, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$this_runGlance = glanceTemplateAppWidget;
                this.$context = context;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_runGlance, this.$context, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GlanceTemplateAppWidget glanceTemplateAppWidget = this.$this_runGlance;
                    Context context = this.$context;
                    this.label = 1;
                    if (glanceTemplateAppWidget.providePreview$glance_oneui_template_release(context, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C34751(GlanceTemplateAppWidget glanceTemplateAppWidget, Context context, Continuation<? super C34751> continuation) {
            super(2, continuation);
            this.$this_runGlance = glanceTemplateAppWidget;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C34751 c34751 = new C34751(this.$this_runGlance, this.$context, continuation);
            c34751.L$0 = obj;
            return c34751;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Function2<? super Composer, ? super Integer, ? extends Unit>> producerScope, Continuation<? super Unit> continuation) {
            return invoke2((ProducerScope<? super Function2<? super Composer, ? super Integer, Unit>>) producerScope, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PreviewContentReceiverKt$runGlance$1$receiver$1 previewContentReceiverKt$runGlance$1$receiver$1 = new PreviewContentReceiverKt$runGlance$1$receiver$1(new AtomicReference(null), (ProducerScope) this.L$0);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_runGlance, this.$context, null);
                this.label = 1;
                if (BuildersKt.withContext(previewContentReceiverKt$runGlance$1$receiver$1, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull ProducerScope<? super Function2<? super Composer, ? super Integer, Unit>> producerScope, @Nullable Continuation<? super Unit> continuation) {
            return ((C34751) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object providePreviewContent(@NotNull GlanceTemplateAppWidget glanceTemplateAppWidget, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull Continuation<?> continuation) {
        C34741 c34741;
        if (continuation instanceof C34741) {
            c34741 = (C34741) continuation;
            int i = c34741.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c34741.label = i - Integer.MIN_VALUE;
            } else {
                c34741 = new C34741(continuation);
            }
        }
        Object obj = c34741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c34741.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            PreviewContentReceiver previewContentReceiver = (PreviewContentReceiver) c34741.get$context().get(PreviewContentReceiver.INSTANCE);
            if (previewContentReceiver == null) {
                throw new IllegalStateException("provideContent requires a ContentReceiver and should only be called from GlanceAppWidget.provideGlance");
            }
            c34741.label = 1;
            if (previewContentReceiver.providePreviewContent(function2, c34741) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @NotNull
    public static final Flow<Function2<Composer, Integer, Unit>> runGlance(@NotNull GlanceTemplateAppWidget glanceTemplateAppWidget, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(glanceTemplateAppWidget, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return FlowKt.channelFlow(new C34751(glanceTemplateAppWidget, context, null));
    }
}
