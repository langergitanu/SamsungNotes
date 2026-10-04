package androidx.glance.appwidget.multiprocess;

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
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
@DebugMetadata(m14020c = "androidx.glance.appwidget.multiprocess.MultiProcessSessionManagerKt$withMultiProcessContext$2$1", m14021f = "MultiProcessSessionManager.kt", m14022i = {}, m14023l = {91}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
public final class MultiProcessSessionManagerKt$withMultiProcessContext$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ ExecutorCoroutineDispatcher $dispatcher;
    final /* synthetic */ String $key;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MultiProcessSessionManagerKt$withMultiProcessContext$2$1(Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> function2, String str, ExecutorCoroutineDispatcher executorCoroutineDispatcher, Continuation<? super MultiProcessSessionManagerKt$withMultiProcessContext$2$1> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$key = str;
        this.$dispatcher = executorCoroutineDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MultiProcessSessionManagerKt$withMultiProcessContext$2$1(this.$block, this.$key, this.$dispatcher, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        GlanceLog.Companion companion;
        StringBuilder sb;
        String str = "End ";
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<String, Continuation<? super Unit>, Object> function2 = this.$block;
                    String str2 = this.$key;
                    this.label = 1;
                    if (function2.invoke(str2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                companion = GlanceLog.INSTANCE;
                str = this.$key;
                sb = new StringBuilder();
            } catch (Exception unused) {
                companion = GlanceLog.INSTANCE;
                companion.m2301i("GWT:MultiProcessContext", str + this.$key + " multi-process coroutine block / " + this.$dispatcher);
                str = this.$key;
                sb = new StringBuilder();
            }
            sb.append(str);
            sb.append(" thread is closed");
            companion.m2301i("GWT:MultiProcessContext", sb.toString());
            this.$dispatcher.close();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            GlanceLog.INSTANCE.m2301i("GWT:MultiProcessContext", this.$key + " thread is closed");
            this.$dispatcher.close();
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MultiProcessSessionManagerKt$withMultiProcessContext$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
