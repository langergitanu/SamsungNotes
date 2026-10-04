package androidx.glance.session;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0003\u001a\u00020\u0004X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\bX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, m13886d2 = {"androidx/glance/session/TimerScopeKt$noopTimer$2$timerScope$1", "Landroidx/glance/session/TimerScope;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "timeLeft", "Lkotlin/time/Duration;", "getTimeLeft-UwyO8pc", "()J", "J", "addTime", "", "time", "addTime-LRDsOJo", "(J)V", "startTimer", "initialTimeout", "startTimer-LRDsOJo", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TimerScopeKt$noopTimer$2$timerScope$1 implements TimerScope, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final long timeLeft = Duration.INSTANCE.m23643getINFINITEUwyO8pc();

    public TimerScopeKt$noopTimer$2$timerScope$1(CoroutineScope coroutineScope) {
        this.$$delegate_0 = coroutineScope;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.glance.session.TimerScope
    /* JADX INFO: renamed from: getTimeLeft-UwyO8pc, reason: from getter */
    public long getTimeLeft() {
        return this.timeLeft;
    }

    @Override // androidx.glance.session.TimerScope
    /* JADX INFO: renamed from: addTime-LRDsOJo */
    public void mo21977addTimeLRDsOJo(long time) {
    }

    @Override // androidx.glance.session.TimerScope
    /* JADX INFO: renamed from: startTimer-LRDsOJo */
    public void mo21979startTimerLRDsOJo(long initialTimeout) {
    }
}
