package androidx.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, m13886d2 = {"reportWhenComplete", "", "Landroidx/activity/FullyDrawnReporter;", "reporter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class FullyDrawnReporterKt {

    /* JADX INFO: renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
    @DebugMetadata(m14020c = "androidx.activity.FullyDrawnReporterKt", m14021f = "FullyDrawnReporter.kt", m14022i = {0}, m14023l = {185}, m14024m = "reportWhenComplete", m14025n = {"$this$reportWhenComplete"}, m14026s = {"L$0"})
    @SourceDebugExtension({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporterKt$reportWhenComplete$1\n*L\n1#1,190:1\n*E\n"})
    public static final class C03691 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03691(Continuation<? super C03691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.Unit] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object reportWhenComplete(@NotNull FullyDrawnReporter fullyDrawnReporter, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1, @NotNull Continuation<? super Unit> continuation) {
        C03691 c03691;
        FullyDrawnReporter fullyDrawnReporter2;
        if (continuation instanceof C03691) {
            c03691 = (C03691) continuation;
            int i = c03691.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c03691.label = i - Integer.MIN_VALUE;
            } else {
                c03691 = new C03691(continuation);
            }
        }
        Object obj = c03691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c03691.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                fullyDrawnReporter.addReporter();
                if (fullyDrawnReporter.isFullyDrawnReported()) {
                    return Unit.INSTANCE;
                }
                c03691.L$0 = fullyDrawnReporter;
                c03691.label = 1;
                fullyDrawnReporter2 = fullyDrawnReporter;
                if (function1.invoke(c03691) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FullyDrawnReporter fullyDrawnReporter3 = (FullyDrawnReporter) c03691.L$0;
                ResultKt.throwOnFailure(obj);
                fullyDrawnReporter2 = fullyDrawnReporter3;
            }
            InlineMarker.finallyStart(1);
            fullyDrawnReporter2.removeReporter();
            InlineMarker.finallyEnd(1);
            fullyDrawnReporter = Unit.INSTANCE;
            return fullyDrawnReporter;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            fullyDrawnReporter.removeReporter();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        fullyDrawnReporter.addReporter();
        if (fullyDrawnReporter.isFullyDrawnReported()) {
            return Unit.INSTANCE;
        }
        try {
            function1.invoke(continuation);
            InlineMarker.finallyStart(1);
            fullyDrawnReporter.removeReporter();
            InlineMarker.finallyEnd(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            fullyDrawnReporter.removeReporter();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
