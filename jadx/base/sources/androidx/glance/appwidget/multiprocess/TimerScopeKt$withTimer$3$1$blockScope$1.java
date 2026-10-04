package androidx.glance.appwidget.multiprocess;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0003\u001a\u00020\u0004X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, m13886d2 = {"androidx/glance/appwidget/multiprocess/TimerScopeKt$withTimer$3$1$blockScope$1", "Landroidx/glance/appwidget/multiprocess/TimerScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "startTimer", "", "initialTimeout", "Lkotlin/time/Duration;", "startTimer-LRDsOJo", "(J)V", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TimerScopeKt$withTimer$3$1$blockScope$1 implements TimerScope, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ String $key;
    final /* synthetic */ Function2<TimerScope, Continuation<? super Unit>, Object> $timerCallback;
    final /* synthetic */ AtomicReference<Job> $timerJob;
    final /* synthetic */ CoroutineScope $timerScope;

    /* JADX WARN: Multi-variable type inference failed */
    public TimerScopeKt$withTimer$3$1$blockScope$1(CoroutineScope coroutineScope, AtomicReference<Job> atomicReference, CoroutineScope coroutineScope2, String str, Function2<? super TimerScope, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function22) {
        this.$timerJob = atomicReference;
        this.$timerScope = coroutineScope2;
        this.$key = str;
        this.$timerCallback = function2;
        this.$block = function22;
        this.$$delegate_0 = coroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.glance.appwidget.multiprocess.TimerScope
    /* JADX INFO: renamed from: startTimer-LRDsOJo */
    public void mo21354startTimerLRDsOJo(long initialTimeout) {
        AtomicReference<Job> atomicReference = this.$timerJob;
        CoroutineScope coroutineScope = this.$timerScope;
        Job andSet = atomicReference.getAndSet(BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TimerScopeKt$withTimer$3$1$blockScope$1$startTimer$1(this.$key, initialTimeout, this.$timerCallback, this, coroutineScope, this.$block, null), 3, null));
        if (andSet != null) {
            Job.DefaultImpls.cancel$default(andSet, (CancellationException) null, 1, (Object) null);
        }
    }
}
