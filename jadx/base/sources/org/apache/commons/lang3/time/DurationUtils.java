package org.apache.commons.lang3.time;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LongRange;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DurationUtils {
    static final LongRange LONG_TO_INT_RANGE = LongRange.m14656of(NumberUtils.LONG_INT_MIN_VALUE, NumberUtils.LONG_INT_MAX_VALUE);

    /* JADX INFO: renamed from: org.apache.commons.lang3.time.DurationUtils$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C139061 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Deprecated
    public DurationUtils() {
    }

    public static <T extends Throwable> void accept(FailableBiConsumer<Long, Integer, T> failableBiConsumer, Duration duration) {
        if (failableBiConsumer == null || duration == null) {
            return;
        }
        failableBiConsumer.accept(Long.valueOf(duration.toMillis()), Integer.valueOf(getNanosOfMilli(duration)));
    }

    @Deprecated
    public static int getNanosOfMiili(Duration duration) {
        return getNanosOfMilli(duration);
    }

    public static int getNanosOfMilli(Duration duration) {
        return zeroIfNull(duration).getNano() % 1000000;
    }

    public static boolean isPositive(Duration duration) {
        return (duration.isNegative() || duration.isZero()) ? false : true;
    }

    private static <E extends Throwable> Instant now(FailableConsumer<Instant, E> failableConsumer) {
        Instant instantNow = Instant.now();
        failableConsumer.accept(instantNow);
        return instantNow;
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Throwable> Duration m14886of(FailableConsumer<Instant, E> failableConsumer) {
        Objects.requireNonNull(failableConsumer);
        return since(now(new C13922e(failableConsumer, 1)));
    }

    public static Duration since(Temporal temporal) {
        return Duration.between(temporal, Instant.now());
    }

    public static ChronoUnit toChronoUnit(TimeUnit timeUnit) {
        int[] iArr = C139061.$SwitchMap$java$util$concurrent$TimeUnit;
        Objects.requireNonNull(timeUnit);
        switch (iArr[timeUnit.ordinal()]) {
            case 1:
                return ChronoUnit.NANOS;
            case 2:
                return ChronoUnit.MICROS;
            case 3:
                return ChronoUnit.MILLIS;
            case 4:
                return ChronoUnit.SECONDS;
            case 5:
                return ChronoUnit.MINUTES;
            case 6:
                return ChronoUnit.HOURS;
            case 7:
                return ChronoUnit.DAYS;
            default:
                throw new IllegalArgumentException(timeUnit.toString());
        }
    }

    public static Duration toDuration(long j, TimeUnit timeUnit) {
        return Duration.of(j, toChronoUnit(timeUnit));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int toMillisInt(Duration duration) {
        Objects.requireNonNull(duration, XmlErrorCodes.DURATION);
        return ((Long) LONG_TO_INT_RANGE.fit(Long.valueOf(duration.toMillis()))).intValue();
    }

    public static Duration zeroIfNull(Duration duration) {
        return (Duration) ObjectUtils.getIfNull(duration, Duration.ZERO);
    }

    /* JADX INFO: renamed from: of */
    public static <E extends Throwable> Duration m14887of(FailableRunnable<E> failableRunnable) {
        return m14886of(new C13922e(failableRunnable, 0));
    }
}
