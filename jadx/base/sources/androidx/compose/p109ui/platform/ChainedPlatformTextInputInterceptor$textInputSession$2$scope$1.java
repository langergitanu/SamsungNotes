package androidx.compose.p109ui.platform;

import android.view.View;
import androidx.compose.p109ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, m13886d2 = {"androidx/compose/ui/platform/ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "startInputMethod", "", "request", "Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;", "(Landroidx/compose/ui/platform/PlatformTextInputMethodRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 implements PlatformTextInputSessionScope {
    private final /* synthetic */ PlatformTextInputSessionScope $$delegate_0;
    final /* synthetic */ AtomicReference $inputMethodMutex;
    final /* synthetic */ PlatformTextInputSessionScope $parentSession;
    final /* synthetic */ ChainedPlatformTextInputInterceptor this$0;

    public ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1(PlatformTextInputSessionScope platformTextInputSessionScope, AtomicReference atomicReference, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor) {
        this.$parentSession = platformTextInputSessionScope;
        this.$inputMethodMutex = atomicReference;
        this.this$0 = chainedPlatformTextInputInterceptor;
        this.$$delegate_0 = platformTextInputSessionScope;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.compose.p109ui.platform.PlatformTextInputSession
    @NotNull
    public View getView() {
        return this.$$delegate_0.getView();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.p109ui.platform.PlatformTextInputSession
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object startInputMethod(@NotNull PlatformTextInputMethodRequest platformTextInputMethodRequest, @NotNull Continuation<?> continuation) {
        C2168x61f42b4d c2168x61f42b4d;
        if (continuation instanceof C2168x61f42b4d) {
            c2168x61f42b4d = (C2168x61f42b4d) continuation;
            int i = c2168x61f42b4d.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c2168x61f42b4d.label = i - Integer.MIN_VALUE;
            } else {
                c2168x61f42b4d = new C2168x61f42b4d(this, continuation);
            }
        }
        Object obj = c2168x61f42b4d.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c2168x61f42b4d.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            AtomicReference atomicReference = this.$inputMethodMutex;
            C2169x61f42b4e c2169x61f42b4e = new Function1<CoroutineScope, Unit>() { // from class: androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1$startInputMethod$2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CoroutineScope coroutineScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CoroutineScope coroutineScope) {
                    invoke2(coroutineScope);
                    return Unit.INSTANCE;
                }
            };
            C2170x61f42b4f c2170x61f42b4f = new C2170x61f42b4f(this.this$0, platformTextInputMethodRequest, this.$parentSession, null);
            c2168x61f42b4d.label = 1;
            if (SessionMutex.m18140withSessionCancellingPreviousimpl(atomicReference, c2169x61f42b4e, c2170x61f42b4f, c2168x61f42b4d) == coroutine_suspended) {
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
