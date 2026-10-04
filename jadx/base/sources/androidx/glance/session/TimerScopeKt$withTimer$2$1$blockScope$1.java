package androidx.glance.session;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012R\u0012\u0010\u0003\u001a\u00020\u0004X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000b8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, m13886d2 = {"androidx/glance/session/TimerScopeKt$withTimer$2$1$blockScope$1", "Landroidx/glance/session/TimerScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "deadline", "Ljava/util/concurrent/atomic/AtomicReference;", "", "timeLeft", "Lkotlin/time/Duration;", "getTimeLeft-UwyO8pc", "()J", "addTime", "", "time", "addTime-LRDsOJo", "(J)V", "startTimer", "initialTimeout", "startTimer-LRDsOJo", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TimerScopeKt$withTimer$2$1$blockScope$1 implements TimerScope, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    final /* synthetic */ Function2<TimerScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ TimeSource $timeSource;
    final /* synthetic */ AtomicReference<Job> $timerJob;
    final /* synthetic */ CoroutineScope $timerScope;

    @NotNull
    private final AtomicReference<Long> deadline = new AtomicReference<>(null);

    /* JADX WARN: Multi-variable type inference failed */
    public TimerScopeKt$withTimer$2$1$blockScope$1(CoroutineScope coroutineScope, TimeSource timeSource, CoroutineScope coroutineScope2, Function2<? super TimerScope, ? super Continuation<? super T>, ? extends Object> function2, AtomicReference<Job> atomicReference) {
        this.$timeSource = timeSource;
        this.$timerScope = coroutineScope2;
        this.$block = function2;
        this.$timerJob = atomicReference;
        this.$$delegate_0 = coroutineScope;
    }

    @Override // androidx.glance.session.TimerScope
    /* JADX INFO: renamed from: addTime-LRDsOJo */
    public void mo21977addTimeLRDsOJo(final long time) {
        TimerScopeKt.update(this.deadline, new Function1<Long, Long>() { // from class: androidx.glance.session.TimerScopeKt$withTimer$2$1$blockScope$1$addTime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@Nullable Long l) {
                if (l == null) {
                    throw new IllegalStateException("Start the timer with startTimer before calling addTime");
                }
                if (!Duration.m23581isPositiveimpl(time)) {
                    throw new IllegalArgumentException("Cannot call addTime with a negative duration");
                }
                return Long.valueOf(Duration.m23565getInWholeMillisecondsimpl(time) + l.longValue());
            }
        });
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.glance.session.TimerScope
    /* JADX INFO: renamed from: getTimeLeft-UwyO8pc */
    public long getTimeLeft() {
        Long l = this.deadline.get();
        if (l == null) {
            return Duration.INSTANCE.m23643getINFINITEUwyO8pc();
        }
        long jLongValue = l.longValue() - this.$timeSource.markNow();
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(jLongValue, DurationUnit.MILLISECONDS);
    }

    @Override // androidx.glance.session.TimerScope
    /* JADX INFO: renamed from: startTimer-LRDsOJo */
    public void mo21979startTimerLRDsOJo(long initialTimeout) {
        if (Duration.m23565getInWholeMillisecondsimpl(initialTimeout) <= 0) {
            CoroutineScopeKt.cancel(this.$timerScope, new TimeoutCancellationException("Timed out immediately", this.$block.hashCode()));
            return;
        }
        if (Duration.m23553compareToLRDsOJo(getTimeLeft(), initialTimeout) < 0) {
            return;
        }
        this.deadline.set(Long.valueOf(Duration.m23565getInWholeMillisecondsimpl(initialTimeout) + this.$timeSource.markNow()));
        AtomicReference<Job> atomicReference = this.$timerJob;
        CoroutineScope coroutineScope = this.$timerScope;
        Job andSet = atomicReference.getAndSet(BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1(this, this.$timeSource, coroutineScope, this.$block, null), 3, null));
        if (andSet != null) {
            Job.DefaultImpls.cancel$default(andSet, (CancellationException) null, 1, (Object) null);
        }
    }
}
