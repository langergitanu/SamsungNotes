package androidx.glance.appwidget;

import androidx.compose.runtime.Composer;
import androidx.glance.appwidget.ContentReceiver;
import androidx.glance.oneui.common.GlanceLog;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, m13886d2 = {"<anonymous>", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/glance/GlanceComposable;", "provideContent", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAppWidgetUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppWidgetUtils.kt\nandroidx/glance/appwidget/AppWidgetUtilsKt$runGlance$1$receiver$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,331:1\n314#2,11:332\n*S KotlinDebug\n*F\n+ 1 AppWidgetUtils.kt\nandroidx/glance/appwidget/AppWidgetUtilsKt$runGlance$1$receiver$1\n*L\n260#1:332,11\n*E\n"})
public final class AppWidgetUtilsKt$runGlance$1$receiver$1 implements ContentReceiver {
    final /* synthetic */ ProducerScope<Function2<? super Composer, ? super Integer, Unit>> $$this$channelFlow;
    final /* synthetic */ AtomicReference<CancellableContinuation<?>> $contentCoroutine;

    /* JADX WARN: Multi-variable type inference failed */
    public AppWidgetUtilsKt$runGlance$1$receiver$1(AtomicReference<CancellableContinuation<?>> atomicReference, ProducerScope<? super Function2<? super Composer, ? super Integer, Unit>> producerScope) {
        this.$contentCoroutine = atomicReference;
        this.$$this$channelFlow = producerScope;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) ContentReceiver.DefaultImpls.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) ContentReceiver.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return ContentReceiver.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return ContentReceiver.DefaultImpls.plus(this, coroutineContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.appwidget.ContentReceiver
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object provideContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @NotNull Continuation<?> continuation) {
        AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1;
        if (continuation instanceof AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1) {
            appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 = (AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1) continuation;
            int i = appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.label = i - Integer.MIN_VALUE;
            } else {
                appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1 = new AppWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1(this, continuation);
            }
        }
        Object obj = appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AtomicReference<CancellableContinuation<?>> atomicReference = this.$contentCoroutine;
            final ProducerScope<Function2<? super Composer, ? super Integer, Unit>> producerScope = this.$$this$channelFlow;
            appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.L$0 = function2;
            appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.L$1 = atomicReference;
            appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.L$2 = producerScope;
            appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1), 1);
            cancellableContinuationImpl.initCancellability();
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.glance.appwidget.AppWidgetUtilsKt$runGlance$1$receiver$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    producerScope.mo23705trySendJP2dKIU(null);
                }
            });
            CancellableContinuation<?> andSet = atomicReference.getAndSet(cancellableContinuationImpl);
            if (andSet != null) {
                Boxing.boxBoolean(CancellableContinuation.DefaultImpls.cancel$default(andSet, null, 1, null));
            }
            GlanceLog.INSTANCE.m2297d("GWT:AppWidgetUtils", "trySend " + function2 + " / " + producerScope + "@runGlance");
            producerScope.mo23705trySendJP2dKIU(function2);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(appWidgetUtilsKt$runGlance$1$receiver$1$provideContent$1);
            }
            if (result == coroutine_suspended) {
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
}
