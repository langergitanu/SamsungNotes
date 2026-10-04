package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Instant;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u001a"}, m13886d2 = {"Lkotlin/time/UnboundLocalDateTime;", "", "year", "", "month", "day", "hour", "minute", "second", "nanosecond", "<init>", "(IIIIIII)V", "getYear", "()I", "getMonth", "getDay", "getHour", "getMinute", "getSecond", "getNanosecond", "toInstant", "Lkotlin/time/Instant;", "offsetSeconds", "toString", "", "Companion", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@ExperimentalTime
final class UnboundLocalDateTime {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanosecond;
    private final int second;
    private final int year;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lkotlin/time/UnboundLocalDateTime$Companion;", "", "<init>", "()V", "fromInstant", "Lkotlin/time/UnboundLocalDateTime;", "instant", "Lkotlin/time/Instant;", "kotlin-stdlib"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UnboundLocalDateTime fromInstant(@NotNull Instant instant) {
            long j;
            long j2;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j3 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j3 * 86400 != epochSeconds) {
                j3--;
            }
            long j5 = epochSeconds % 86400;
            int i = (int) (j5 + (86400 & (((j5 ^ 86400) & ((-j5) | j5)) >> 63)));
            long j6 = (j3 + ((long) 719528)) - ((long) 60);
            if (j6 < 0) {
                j = -1;
                long j7 = 146097;
                long j8 = ((j6 + 1) / j7) - 1;
                j2 = ((long) 400) * j8;
                j6 += (-j8) * j7;
            } else {
                j = -1;
                j2 = 0;
            }
            long j9 = 400;
            long j10 = ((j9 * j6) + ((long) 591)) / ((long) 146097);
            long j11 = 365;
            long j12 = 4;
            long j13 = 100;
            long j14 = j6 - ((j10 / j9) + (((j10 / j12) + (j11 * j10)) - (j10 / j13)));
            if (j14 < 0) {
                j10 += j;
                j14 = j6 - ((j10 / j9) + (((j10 / j12) + (j11 * j10)) - (j10 / j13)));
            }
            int i2 = (int) j14;
            int i4 = ((i2 * 5) + 2) / 153;
            int i5 = i / 3600;
            int i6 = i - (i5 * 3600);
            int i7 = i6 / 60;
            return new UnboundLocalDateTime((int) (j10 + j2 + ((long) (i4 / 10))), ((i4 + 2) % 12) + 1, (i2 - (((i4 * 306) + 5) / 10)) + 1, i5, i7, i6 - (i7 * 60), instant.getNanosecondsOfSecond());
        }

        private Companion() {
        }
    }

    public UnboundLocalDateTime(int i, int i2, int i4, int i5, int i6, int i7, int i8) {
        this.year = i;
        this.month = i2;
        this.day = i4;
        this.hour = i5;
        this.minute = i6;
        this.second = i7;
        this.nanosecond = i8;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNanosecond() {
        return this.nanosecond;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getYear() {
        return this.year;
    }

    @NotNull
    public final Instant toInstant(int offsetSeconds) {
        int i = this.year;
        long j = i;
        long j2 = ((long) 365) * j;
        long j3 = j >= 0 ? ((j + ((long) 399)) / ((long) 400)) + (((((long) 3) + j) / ((long) 4)) - ((((long) 99) + j) / ((long) 100))) + j2 : j2 - ((j / ((long) (-400))) + ((j / ((long) (-4))) - (j / ((long) (-100)))));
        long j5 = j3 + ((long) (((r3 * 367) - 362) / 12)) + ((long) (this.day - 1));
        if (this.month > 2) {
            j5 = !InstantKt.isLeapYear(i) ? j5 - 2 : (-1) + j5;
        }
        long j6 = (((j5 - ((long) 719528)) * ((long) 86400)) + ((long) (((this.minute * 60) + (this.hour * 3600)) + this.second))) - ((long) offsetSeconds);
        Instant.Companion companion = Instant.INSTANCE;
        if (j6 >= companion.getMIN$kotlin_stdlib().getEpochSeconds() && j6 <= companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
            return companion.fromEpochSeconds(j6, this.nanosecond);
        }
        throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + j6 + PropertyUtils.MAPPED_DELIM2);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder("UnboundLocalDateTime(");
        sb.append(this.year);
        sb.append('-');
        sb.append(this.month);
        sb.append('-');
        sb.append(this.day);
        sb.append(' ');
        sb.append(this.hour);
        sb.append(':');
        sb.append(this.minute);
        sb.append(':');
        sb.append(this.second);
        sb.append('.');
        return AbstractC0000a.m13j(sb, this.nanosecond, PropertyUtils.MAPPED_DELIM2);
    }
}
