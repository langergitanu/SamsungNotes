package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectLongMap;
import androidx.collection.ObjectLongMapKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J&\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0080\b¢\u0006\u0002\b\u0018J&\u0010\u0019\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0080\b¢\u0006\u0002\b\u001bR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, m13886d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "", "()V", "<set-?>", "", "averageCompositionTimeNanos", "getAverageCompositionTimeNanos", "()J", "averageCompositionTimeNanosByContentType", "Landroidx/collection/MutableObjectLongMap;", "getAverageCompositionTimeNanosByContentType", "()Landroidx/collection/MutableObjectLongMap;", "averageMeasureTimeNanos", "getAverageMeasureTimeNanos", "averageMeasureTimeNanosByContentType", "getAverageMeasureTimeNanosByContentType", "calculateAverageTime", "new", "current", "recordCompositionTiming", "", "contentType", "doComposition", "Lkotlin/Function0;", "recordCompositionTiming$foundation_release", "recordMeasureTiming", "doMeasure", "recordMeasureTiming$foundation_release", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@ExperimentalFoundationApi
@SourceDebugExtension({"SMAP\nLazyLayoutPrefetchState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyLayoutPrefetchState.kt\nandroidx/compose/foundation/lazy/layout/PrefetchMetrics\n+ 2 LazyLayoutPrefetchState.jvm.kt\nandroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState_jvmKt\n+ 3 Timing.kt\nkotlin/system/TimingKt\n*L\n1#1,506:1\n20#2:507\n20#2:514\n31#3,6:508\n31#3,6:515\n*S KotlinDebug\n*F\n+ 1 LazyLayoutPrefetchState.kt\nandroidx/compose/foundation/lazy/layout/PrefetchMetrics\n*L\n176#1:507\n192#1:514\n176#1:508,6\n192#1:515,6\n*E\n"})
public final class PrefetchMetrics {
    public static final int $stable = 8;
    private long averageCompositionTimeNanos;
    private long averageMeasureTimeNanos;

    @NotNull
    private final MutableObjectLongMap<Object> averageCompositionTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();

    @NotNull
    private final MutableObjectLongMap<Object> averageMeasureTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateAverageTime(long j, long current) {
        if (current == 0) {
            return j;
        }
        long j2 = 4;
        return (j / j2) + ((current / j2) * ((long) 3));
    }

    public final long getAverageCompositionTimeNanos() {
        return this.averageCompositionTimeNanos;
    }

    @NotNull
    public final MutableObjectLongMap<Object> getAverageCompositionTimeNanosByContentType() {
        return this.averageCompositionTimeNanosByContentType;
    }

    public final long getAverageMeasureTimeNanos() {
        return this.averageMeasureTimeNanos;
    }

    @NotNull
    public final MutableObjectLongMap<Object> getAverageMeasureTimeNanosByContentType() {
        return this.averageMeasureTimeNanosByContentType;
    }

    public final void recordCompositionTiming$foundation_release(@Nullable Object contentType, @NotNull Function0<Unit> doComposition) {
        long jNanoTime = System.nanoTime();
        doComposition.invoke();
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        if (contentType != null) {
            getAverageCompositionTimeNanosByContentType().set(contentType, calculateAverageTime(jNanoTime2, getAverageCompositionTimeNanosByContentType().getOrDefault(contentType, 0L)));
        }
        this.averageCompositionTimeNanos = calculateAverageTime(jNanoTime2, getAverageCompositionTimeNanos());
    }

    public final void recordMeasureTiming$foundation_release(@Nullable Object contentType, @NotNull Function0<Unit> doMeasure) {
        long jNanoTime = System.nanoTime();
        doMeasure.invoke();
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        if (contentType != null) {
            getAverageMeasureTimeNanosByContentType().set(contentType, calculateAverageTime(jNanoTime2, getAverageMeasureTimeNanosByContentType().getOrDefault(contentType, 0L)));
        }
        this.averageMeasureTimeNanos = calculateAverageTime(jNanoTime2, getAverageMeasureTimeNanos());
    }
}
