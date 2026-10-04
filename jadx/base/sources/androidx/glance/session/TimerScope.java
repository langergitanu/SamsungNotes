package androidx.glance.session;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, m13886d2 = {"Landroidx/glance/session/TimerScope;", "Lkotlinx/coroutines/CoroutineScope;", "timeLeft", "Lkotlin/time/Duration;", "getTimeLeft-UwyO8pc", "()J", "addTime", "", "time", "addTime-LRDsOJo", "(J)V", "startTimer", "initialTimeout", "startTimer-LRDsOJo", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public interface TimerScope extends CoroutineScope {
    /* JADX INFO: renamed from: addTime-LRDsOJo, reason: not valid java name */
    void mo21977addTimeLRDsOJo(long time);

    /* JADX INFO: renamed from: getTimeLeft-UwyO8pc, reason: not valid java name */
    long mo21978getTimeLeftUwyO8pc();

    /* JADX INFO: renamed from: startTimer-LRDsOJo, reason: not valid java name */
    void mo21979startTimerLRDsOJo(long initialTimeout);
}
