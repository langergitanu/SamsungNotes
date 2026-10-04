package androidx.glance.session;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\nJ\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/glance/session/TimeoutOptions;", "", "initialTimeout", "Lkotlin/time/Duration;", "additionalTime", "idleTimeout", "timeSource", "Landroidx/glance/session/TimeSource;", "(JJJLandroidx/glance/session/TimeSource;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdditionalTime-UwyO8pc", "()J", "J", "getIdleTimeout-UwyO8pc", "getInitialTimeout-UwyO8pc", "getTimeSource", "()Landroidx/glance/session/TimeSource;", "component1", "component1-UwyO8pc", "component2", "component2-UwyO8pc", "component3", "component3-UwyO8pc", "component4", "copy", "copy-2d-g_3Q", "(JJJLandroidx/glance/session/TimeSource;)Landroidx/glance/session/TimeoutOptions;", "equals", "", "other", "hashCode", "", "toString", "", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class TimeoutOptions {
    public static final int $stable = 8;
    private final long additionalTime;
    private final long idleTimeout;
    private final long initialTimeout;

    @NotNull
    private final TimeSource timeSource;

    public /* synthetic */ TimeoutOptions(long j, long j2, long j3, TimeSource timeSource, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, timeSource);
    }

    /* JADX INFO: renamed from: copy-2d-g_3Q$default, reason: not valid java name */
    public static /* synthetic */ TimeoutOptions m21969copy2dg_3Q$default(TimeoutOptions timeoutOptions, long j, long j2, long j3, TimeSource timeSource, int i, Object obj) {
        if ((i & 1) != 0) {
            j = timeoutOptions.initialTimeout;
        }
        long j5 = j;
        if ((i & 2) != 0) {
            j2 = timeoutOptions.additionalTime;
        }
        long j6 = j2;
        if ((i & 4) != 0) {
            j3 = timeoutOptions.idleTimeout;
        }
        long j7 = j3;
        if ((i & 8) != 0) {
            timeSource = timeoutOptions.timeSource;
        }
        return timeoutOptions.m21973copy2dg_3Q(j5, j6, j7, timeSource);
    }

    /* JADX INFO: renamed from: component1-UwyO8pc, reason: not valid java name and from getter */
    public final long getInitialTimeout() {
        return this.initialTimeout;
    }

    /* JADX INFO: renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
    public final long getAdditionalTime() {
        return this.additionalTime;
    }

    /* JADX INFO: renamed from: component3-UwyO8pc, reason: not valid java name and from getter */
    public final long getIdleTimeout() {
        return this.idleTimeout;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final TimeSource getTimeSource() {
        return this.timeSource;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-2d-g_3Q, reason: not valid java name */
    public final TimeoutOptions m21973copy2dg_3Q(long initialTimeout, long additionalTime, long idleTimeout, @NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        return new TimeoutOptions(initialTimeout, additionalTime, idleTimeout, timeSource, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeoutOptions)) {
            return false;
        }
        TimeoutOptions timeoutOptions = (TimeoutOptions) other;
        return Duration.m23559equalsimpl0(this.initialTimeout, timeoutOptions.initialTimeout) && Duration.m23559equalsimpl0(this.additionalTime, timeoutOptions.additionalTime) && Duration.m23559equalsimpl0(this.idleTimeout, timeoutOptions.idleTimeout) && Intrinsics.areEqual(this.timeSource, timeoutOptions.timeSource);
    }

    /* JADX INFO: renamed from: getAdditionalTime-UwyO8pc, reason: not valid java name */
    public final long m21974getAdditionalTimeUwyO8pc() {
        return this.additionalTime;
    }

    /* JADX INFO: renamed from: getIdleTimeout-UwyO8pc, reason: not valid java name */
    public final long m21975getIdleTimeoutUwyO8pc() {
        return this.idleTimeout;
    }

    /* JADX INFO: renamed from: getInitialTimeout-UwyO8pc, reason: not valid java name */
    public final long m21976getInitialTimeoutUwyO8pc() {
        return this.initialTimeout;
    }

    @NotNull
    public final TimeSource getTimeSource() {
        return this.timeSource;
    }

    public int hashCode() {
        return this.timeSource.hashCode() + ((Duration.m23575hashCodeimpl(this.idleTimeout) + ((Duration.m23575hashCodeimpl(this.additionalTime) + (Duration.m23575hashCodeimpl(this.initialTimeout) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        String strM23594toStringimpl = Duration.m23594toStringimpl(this.initialTimeout);
        String strM23594toStringimpl2 = Duration.m23594toStringimpl(this.additionalTime);
        String strM23594toStringimpl3 = Duration.m23594toStringimpl(this.idleTimeout);
        TimeSource timeSource = this.timeSource;
        StringBuilder sbM16m = AbstractC0000a.m16m("TimeoutOptions(initialTimeout=", strM23594toStringimpl, ", additionalTime=", strM23594toStringimpl2, ", idleTimeout=");
        sbM16m.append(strM23594toStringimpl3);
        sbM16m.append(", timeSource=");
        sbM16m.append(timeSource);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    private TimeoutOptions(long j, long j2, long j3, TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.initialTimeout = j;
        this.additionalTime = j2;
        this.idleTimeout = j3;
        this.timeSource = timeSource;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TimeoutOptions(long j, long j2, long j3, TimeSource timeSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long duration;
        long duration2;
        long duration3;
        if ((i & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            duration = DurationKt.toDuration(20, DurationUnit.SECONDS);
        } else {
            duration = j;
        }
        if ((i & 2) != 0) {
            Duration.Companion companion2 = Duration.INSTANCE;
            duration2 = DurationKt.toDuration(5, DurationUnit.SECONDS);
        } else {
            duration2 = j2;
        }
        if ((i & 4) != 0) {
            Duration.Companion companion3 = Duration.INSTANCE;
            duration3 = DurationKt.toDuration(5, DurationUnit.SECONDS);
        } else {
            duration3 = j3;
        }
        this(duration, duration2, duration3, (i & 8) != 0 ? TimeSource.INSTANCE.getMonotonic() : timeSource, null);
    }
}
