package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p099Y2.C0347a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 W2\u00020\u0001:\u0003WXYB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0002\u0010\bBç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0017\u0012\b\b\u0002\u0010$\u001a\u00020\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\u0017\u0012\b\b\u0002\u0010&\u001a\u00020\u0017¢\u0006\u0002\u0010'J\u0006\u00107\u001a\u00020\u0011J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0015HÆ\u0003J\t\u0010:\u001a\u00020\u0017HÆ\u0003J\t\u0010;\u001a\u00020\u0019HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\t\u0010>\u001a\u00020\u0011HÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\t\u0010@\u001a\u00020\u001fHÆ\u0003J\t\u0010A\u001a\u00020!HÆ\u0003J\t\u0010B\u001a\u00020\u0017HÆ\u0003J\t\u0010C\u001a\u00020\nHÆ\u0003J\t\u0010D\u001a\u00020\u0017HÆ\u0003J\t\u0010E\u001a\u00020\u0011HÆ\u0003J\t\u0010F\u001a\u00020\u0017HÆ\u0003J\t\u0010G\u001a\u00020\u0017HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u000eHÆ\u0003J\t\u0010K\u001a\u00020\u000eHÆ\u0003J\t\u0010L\u001a\u00020\u0011HÆ\u0003J\t\u0010M\u001a\u00020\u0011HÆ\u0003J\t\u0010N\u001a\u00020\u0011HÆ\u0003Jï\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00172\b\b\u0002\u0010&\u001a\u00020\u0017HÆ\u0001J\u0013\u0010P\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010Q\u001a\u00020\u001fJ\t\u0010R\u001a\u00020\u0017HÖ\u0001J\u000e\u0010S\u001a\u00020T2\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010U\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010U\u001a\u00020T2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010V\u001a\u00020\u0003H\u0016R\u0012\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b,\u0010+R\u0012\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001e\u0010%\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010)\"\u0004\b2\u00103R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u00103R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, m13886d2 = {"Landroidx/work/impl/model/WorkSpec;", "", "id", "", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "state", "Landroidx/work/WorkInfo$State;", "workerClassName", "inputMergerClassName", "input", "Landroidx/work/Data;", "output", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "expedited", "", "outOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "periodCount", "generation", "nextScheduleTimeOverride", "nextScheduleTimeOverrideGeneration", "stopReason", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;IIJII)V", "getGeneration", "()I", "isBackedOff", "()Z", "isPeriodic", "getNextScheduleTimeOverride", "()J", "setNextScheduleTimeOverride", "(J)V", "getNextScheduleTimeOverrideGeneration", "setNextScheduleTimeOverrideGeneration", "(I)V", "getPeriodCount", "setPeriodCount", "getStopReason", "calculateNextRunTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "hasConstraints", "hashCode", "setBackoffDelayDuration", "", "setPeriodic", "toString", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nWorkSpec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,544:1\n1549#2:545\n1620#2,3:546\n*S KotlinDebug\n*F\n+ 1 WorkSpec.kt\nandroidx/work/impl/model/WorkSpec\n*L\n482#1:545\n482#1:546,3\n*E\n"})
public final /* data */ class WorkSpec {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;

    @NotNull
    private static final String TAG;

    @JvmField
    @NotNull
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER;

    @JvmField
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;

    @JvmField
    @ColumnInfo(name = "backoff_policy")
    @NotNull
    public BackoffPolicy backoffPolicy;

    @Embedded
    @JvmField
    @NotNull
    public Constraints constraints;

    @JvmField
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;

    @JvmField
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @PrimaryKey
    @JvmField
    @ColumnInfo(name = "id")
    @NotNull
    public final String id;

    @JvmField
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;

    @JvmField
    @ColumnInfo(name = "input")
    @NotNull
    public Data input;

    @JvmField
    @ColumnInfo(name = "input_merger_class_name")
    @NotNull
    public String inputMergerClassName;

    @JvmField
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;

    @JvmField
    @ColumnInfo(defaultValue = "-1", name = "last_enqueue_time")
    public long lastEnqueueTime;

    @JvmField
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;

    @ColumnInfo(defaultValue = "9223372036854775807", name = "next_schedule_time_override")
    private long nextScheduleTimeOverride;

    @ColumnInfo(defaultValue = "0", name = "next_schedule_time_override_generation")
    private int nextScheduleTimeOverrideGeneration;

    @JvmField
    @ColumnInfo(name = "out_of_quota_policy")
    @NotNull
    public OutOfQuotaPolicy outOfQuotaPolicy;

    @JvmField
    @ColumnInfo(name = "output")
    @NotNull
    public Data output;

    @ColumnInfo(defaultValue = "0", name = "period_count")
    private int periodCount;

    @JvmField
    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @JvmField
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;

    @JvmField
    @ColumnInfo(name = "state")
    @NotNull
    public WorkInfo.State state;

    @ColumnInfo(defaultValue = "-256", name = "stop_reason")
    private final int stopReason;

    @JvmField
    @ColumnInfo(name = "worker_class_name")
    @NotNull
    public String workerClassName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J^\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", SearchConstants.TargetContents.TAG, "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "calculateNextRunTime", "isBackedOff", "", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "isPeriodic", "initialDelay", "flexDuration", "intervalDuration", "nextScheduleTimeOverride", "work-runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long calculateNextRunTime(boolean isBackedOff, int runAttemptCount, @NotNull BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, int periodCount, boolean isPeriodic, long initialDelay, long flexDuration, long intervalDuration, long nextScheduleTimeOverride) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            if (nextScheduleTimeOverride != Long.MAX_VALUE && isPeriodic) {
                return periodCount == 0 ? nextScheduleTimeOverride : RangesKt.coerceAtLeast(nextScheduleTimeOverride, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS + lastEnqueueTime);
            }
            if (isBackedOff) {
                return RangesKt.coerceAtMost(backoffPolicy == BackoffPolicy.LINEAR ? backoffDelayDuration * ((long) runAttemptCount) : (long) Math.scalb(backoffDelayDuration, runAttemptCount - 1), WorkRequest.MAX_BACKOFF_MILLIS) + lastEnqueueTime;
            }
            if (isPeriodic) {
                long j = periodCount == 0 ? lastEnqueueTime + initialDelay : lastEnqueueTime + intervalDuration;
                return (flexDuration == intervalDuration || periodCount != 0) ? j : (intervalDuration - flexDuration) + j;
            }
            if (lastEnqueueTime == -1) {
                return Long.MAX_VALUE;
            }
            return lastEnqueueTime + initialDelay;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "work-runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class IdAndState {

        @JvmField
        @ColumnInfo(name = "id")
        @NotNull
        public String id;

        @JvmField
        @ColumnInfo(name = "state")
        @NotNull
        public WorkInfo.State state;

        public IdAndState(@NotNull String id, @NotNull WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            this.id = id;
            this.state = state;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndState.id;
            }
            if ((i & 2) != 0) {
                state = idAndState.state;
            }
            return idAndState.copy(str, state);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WorkInfo.State getState() {
            return this.state;
        }

        @NotNull
        public final IdAndState copy(@NotNull String id, @NotNull WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            return new IdAndState(id, state);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) other;
            return Intrinsics.areEqual(this.id, idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return this.state.hashCode() + (this.id.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + PropertyUtils.MAPPED_DELIM2;
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = strTagWithPrefix;
        WORK_INFO_MAPPER = new C0347a(14);
    }

    public WorkSpec(@NotNull String id, @NotNull WorkInfo.State state, @NotNull String workerClassName, @NotNull String inputMergerClassName, @NotNull Data input, @NotNull Data output, long j, long j2, long j3, @NotNull Constraints constraints, @IntRange(from = 0) int i, @NotNull BackoffPolicy backoffPolicy, long j5, long j6, long j7, long j8, boolean z, @NotNull OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i4, long j9, int i5, int i6) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.id = id;
        this.state = state;
        this.workerClassName = workerClassName;
        this.inputMergerClassName = inputMergerClassName;
        this.input = input;
        this.output = output;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy;
        this.backoffDelayDuration = j5;
        this.lastEnqueueTime = j6;
        this.minimumRetentionDuration = j7;
        this.scheduleRequestedAt = j8;
        this.expedited = z;
        this.outOfQuotaPolicy = outOfQuotaPolicy;
        this.periodCount = i2;
        this.generation = i4;
        this.nextScheduleTimeOverride = j9;
        this.nextScheduleTimeOverrideGeneration = i5;
        this.stopReason = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list2));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkInfoPojo) it.next()).toWorkInfo());
        }
        return arrayList;
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j5, long j6, long j7, long j8, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i4, long j9, int i5, int i6, int i7, Object obj) {
        String str4 = (i7 & 1) != 0 ? workSpec.id : str;
        WorkInfo.State state2 = (i7 & 2) != 0 ? workSpec.state : state;
        String str5 = (i7 & 4) != 0 ? workSpec.workerClassName : str2;
        String str6 = (i7 & 8) != 0 ? workSpec.inputMergerClassName : str3;
        Data data3 = (i7 & 16) != 0 ? workSpec.input : data;
        Data data4 = (i7 & 32) != 0 ? workSpec.output : data2;
        long j10 = (i7 & 64) != 0 ? workSpec.initialDelay : j;
        long j11 = (i7 & 128) != 0 ? workSpec.intervalDuration : j2;
        long j12 = (i7 & 256) != 0 ? workSpec.flexDuration : j3;
        Constraints constraints2 = (i7 & 512) != 0 ? workSpec.constraints : constraints;
        int i8 = (i7 & 1024) != 0 ? workSpec.runAttemptCount : i;
        String str7 = str4;
        BackoffPolicy backoffPolicy2 = (i7 & 2048) != 0 ? workSpec.backoffPolicy : backoffPolicy;
        WorkInfo.State state3 = state2;
        long j13 = (i7 & 4096) != 0 ? workSpec.backoffDelayDuration : j5;
        long j14 = (i7 & 8192) != 0 ? workSpec.lastEnqueueTime : j6;
        long j15 = (i7 & 16384) != 0 ? workSpec.minimumRetentionDuration : j7;
        long j16 = (i7 & 32768) != 0 ? workSpec.scheduleRequestedAt : j8;
        return workSpec.copy(str7, state3, str5, str6, data3, data4, j10, j11, j12, constraints2, i8, backoffPolicy2, j13, j14, j15, j16, (i7 & 65536) != 0 ? workSpec.expedited : z, (i7 & 131072) != 0 ? workSpec.outOfQuotaPolicy : outOfQuotaPolicy, (i7 & 262144) != 0 ? workSpec.periodCount : i2, (i7 & 524288) != 0 ? workSpec.generation : i4, (i7 & 1048576) != 0 ? workSpec.nextScheduleTimeOverride : j9, (i7 & 2097152) != 0 ? workSpec.nextScheduleTimeOverrideGeneration : i5, (i7 & 4194304) != 0 ? workSpec.stopReason : i6);
    }

    public final long calculateNextRunTime() {
        return INSTANCE.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Constraints getConstraints() {
        return this.constraints;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getRunAttemptCount() {
        return this.runAttemptCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final BackoffPolicy getBackoffPolicy() {
        return this.backoffPolicy;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getBackoffDelayDuration() {
        return this.backoffDelayDuration;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getLastEnqueueTime() {
        return this.lastEnqueueTime;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getMinimumRetentionDuration() {
        return this.minimumRetentionDuration;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getScheduleRequestedAt() {
        return this.scheduleRequestedAt;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getExpedited() {
        return this.expedited;
    }

    @NotNull
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final OutOfQuotaPolicy getOutOfQuotaPolicy() {
        return this.outOfQuotaPolicy;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getPeriodCount() {
        return this.periodCount;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WorkInfo.State getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getGeneration() {
        return this.generation;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final int getStopReason() {
        return this.stopReason;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWorkerClassName() {
        return this.workerClassName;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getInputMergerClassName() {
        return this.inputMergerClassName;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Data getInput() {
        return this.input;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Data getOutput() {
        return this.output;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getInitialDelay() {
        return this.initialDelay;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getIntervalDuration() {
        return this.intervalDuration;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getFlexDuration() {
        return this.flexDuration;
    }

    @NotNull
    public final WorkSpec copy(@NotNull String id, @NotNull WorkInfo.State state, @NotNull String workerClassName, @NotNull String inputMergerClassName, @NotNull Data input, @NotNull Data output, long initialDelay, long intervalDuration, long flexDuration, @NotNull Constraints constraints, @IntRange(from = 0) int runAttemptCount, @NotNull BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, long minimumRetentionDuration, long scheduleRequestedAt, boolean expedited, @NotNull OutOfQuotaPolicy outOfQuotaPolicy, int periodCount, int generation, long nextScheduleTimeOverride, int nextScheduleTimeOverrideGeneration, int stopReason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        return new WorkSpec(id, state, workerClassName, inputMergerClassName, input, output, initialDelay, intervalDuration, flexDuration, constraints, runAttemptCount, backoffPolicy, backoffDelayDuration, lastEnqueueTime, minimumRetentionDuration, scheduleRequestedAt, expedited, outOfQuotaPolicy, periodCount, generation, nextScheduleTimeOverride, nextScheduleTimeOverrideGeneration, stopReason);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) other;
        return Intrinsics.areEqual(this.id, workSpec.id) && this.state == workSpec.state && Intrinsics.areEqual(this.workerClassName, workSpec.workerClassName) && Intrinsics.areEqual(this.inputMergerClassName, workSpec.inputMergerClassName) && Intrinsics.areEqual(this.input, workSpec.input) && Intrinsics.areEqual(this.output, workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && Intrinsics.areEqual(this.constraints, workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation && this.nextScheduleTimeOverride == workSpec.nextScheduleTimeOverride && this.nextScheduleTimeOverrideGeneration == workSpec.nextScheduleTimeOverrideGeneration && this.stopReason == workSpec.stopReason;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final long getNextScheduleTimeOverride() {
        return this.nextScheduleTimeOverride;
    }

    public final int getNextScheduleTimeOverrideGeneration() {
        return this.nextScheduleTimeOverrideGeneration;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final int getStopReason() {
        return this.stopReason;
    }

    public final boolean hasConstraints() {
        return !Intrinsics.areEqual(Constraints.NONE, this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    public int hashCode() {
        int iM1311d = AbstractC1974b.m1311d(this.scheduleRequestedAt, AbstractC1974b.m1311d(this.minimumRetentionDuration, AbstractC1974b.m1311d(this.lastEnqueueTime, AbstractC1974b.m1311d(this.backoffDelayDuration, (this.backoffPolicy.hashCode() + AbstractC0622a.m1157c(this.runAttemptCount, (this.constraints.hashCode() + AbstractC1974b.m1311d(this.flexDuration, AbstractC1974b.m1311d(this.intervalDuration, AbstractC1974b.m1311d(this.initialDelay, (this.output.hashCode() + ((this.input.hashCode() + AbstractC1038a.m1202c(AbstractC1038a.m1202c((this.state.hashCode() + (this.id.hashCode() * 31)) * 31, 31, this.workerClassName), 31, this.inputMergerClassName)) * 31)) * 31, 31), 31), 31)) * 31, 31)) * 31, 31), 31), 31), 31);
        boolean z = this.expedited;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        return Integer.hashCode(this.stopReason) + AbstractC0622a.m1157c(this.nextScheduleTimeOverrideGeneration, AbstractC1974b.m1311d(this.nextScheduleTimeOverride, AbstractC0622a.m1157c(this.generation, AbstractC0622a.m1157c(this.periodCount, (this.outOfQuotaPolicy.hashCode() + ((iM1311d + r2) * 31)) * 31, 31), 31), 31), 31);
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final void setBackoffDelayDuration(long backoffDelayDuration) {
        if (backoffDelayDuration > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (backoffDelayDuration < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = RangesKt.coerceIn(backoffDelayDuration, 10000L, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setNextScheduleTimeOverride(long j) {
        this.nextScheduleTimeOverride = j;
    }

    public final void setNextScheduleTimeOverrideGeneration(int i) {
        this.nextScheduleTimeOverrideGeneration = i;
    }

    public final void setPeriodCount(int i) {
        this.periodCount = i;
    }

    public final void setPeriodic(long intervalDuration) {
        if (intervalDuration < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(RangesKt.coerceAtLeast(intervalDuration, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS), RangesKt.coerceAtLeast(intervalDuration, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS));
    }

    @NotNull
    public String toString() {
        return AbstractC1038a.m1213n('}', this.id, new StringBuilder("{WorkSpec: "));
    }

    public final void setPeriodic(long intervalDuration, long flexDuration) {
        if (intervalDuration < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = RangesKt.coerceAtLeast(intervalDuration, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
        if (flexDuration < 300000) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (flexDuration > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + intervalDuration);
        }
        this.flexDuration = RangesKt.coerceIn(flexDuration, 300000L, this.intervalDuration);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0002\u0010\u001bJ\b\u0010@\u001a\u00020\tH\u0002J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019HÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\t\u0010O\u001a\u00020\rHÆ\u0003J\t\u0010P\u001a\u00020\u000fHÆ\u0003J\t\u0010Q\u001a\u00020\u0011HÆ\u0003J¿\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019HÆ\u0001J\u0013\u0010S\u001a\u00020.2\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\t\u0010W\u001a\u00020\u000fHÖ\u0001J\t\u0010X\u001a\u00020\u0003HÖ\u0001J\u0006\u0010Y\u001a\u00020ZR\u001e\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b-\u0010/R\u0011\u00100\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b0\u0010/R\u001e\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u0010\u001fR\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010(\"\u0004\b7\u00108R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u0017\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010:¨\u0006["}, m13886d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "output", "Landroidx/work/Data;", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "periodCount", "generation", "nextScheduleTimeOverride", "stopReason", "tags", "", "progress", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJIIJILjava/util/List;Ljava/util/List;)V", "getBackoffDelayDuration", "()J", "setBackoffDelayDuration", "(J)V", "getBackoffPolicy", "()Landroidx/work/BackoffPolicy;", "setBackoffPolicy", "(Landroidx/work/BackoffPolicy;)V", "getConstraints", "()Landroidx/work/Constraints;", "getFlexDuration", "getGeneration", "()I", "getId", "()Ljava/lang/String;", "getInitialDelay", "getIntervalDuration", "isBackedOff", "", "()Z", "isPeriodic", "getLastEnqueueTime", "setLastEnqueueTime", "getNextScheduleTimeOverride", "getOutput", "()Landroidx/work/Data;", "getPeriodCount", "setPeriodCount", "(I)V", "getProgress", "()Ljava/util/List;", "getRunAttemptCount", "getState", "()Landroidx/work/WorkInfo$State;", "getStopReason", "getTags", "calculateNextRunTimeMillis", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPeriodicityOrNull", "Landroidx/work/WorkInfo$PeriodicityInfo;", "hashCode", "toString", "toWorkInfo", "Landroidx/work/WorkInfo;", "work-runtime_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final /* data */ class WorkInfoPojo {

        @ColumnInfo(name = "backoff_delay_duration")
        private long backoffDelayDuration;

        @ColumnInfo(name = "backoff_policy")
        @NotNull
        private BackoffPolicy backoffPolicy;

        @Embedded
        @NotNull
        private final Constraints constraints;

        @ColumnInfo(name = "flex_duration")
        private final long flexDuration;

        @ColumnInfo(name = "generation")
        private final int generation;

        @ColumnInfo(name = "id")
        @NotNull
        private final String id;

        @ColumnInfo(name = "initial_delay")
        private final long initialDelay;

        @ColumnInfo(name = "interval_duration")
        private final long intervalDuration;

        @ColumnInfo(name = "last_enqueue_time")
        private long lastEnqueueTime;

        @ColumnInfo(name = "next_schedule_time_override")
        private final long nextScheduleTimeOverride;

        @ColumnInfo(name = "output")
        @NotNull
        private final Data output;

        @ColumnInfo(defaultValue = "0", name = "period_count")
        private int periodCount;

        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"progress"})
        @NotNull
        private final List<Data> progress;

        @ColumnInfo(name = "run_attempt_count")
        private final int runAttemptCount;

        @ColumnInfo(name = "state")
        @NotNull
        private final WorkInfo.State state;

        @ColumnInfo(name = "stop_reason")
        private final int stopReason;

        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = "id", projection = {"tag"})
        @NotNull
        private final List<String> tags;

        public WorkInfoPojo(@NotNull String id, @NotNull WorkInfo.State state, @NotNull Data output, long j, long j2, long j3, @NotNull Constraints constraints, int i, @NotNull BackoffPolicy backoffPolicy, long j5, long j6, int i2, int i4, long j7, int i5, @NotNull List<String> tags, @NotNull List<Data> progress) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.id = id;
            this.state = state;
            this.output = output;
            this.initialDelay = j;
            this.intervalDuration = j2;
            this.flexDuration = j3;
            this.constraints = constraints;
            this.runAttemptCount = i;
            this.backoffPolicy = backoffPolicy;
            this.backoffDelayDuration = j5;
            this.lastEnqueueTime = j6;
            this.periodCount = i2;
            this.generation = i4;
            this.nextScheduleTimeOverride = j7;
            this.stopReason = i5;
            this.tags = tags;
            this.progress = progress;
        }

        private final long calculateNextRunTimeMillis() {
            if (this.state == WorkInfo.State.ENQUEUED) {
                return WorkSpec.INSTANCE.calculateNextRunTime(isBackedOff(), this.runAttemptCount, this.backoffPolicy, this.backoffDelayDuration, this.lastEnqueueTime, this.periodCount, isPeriodic(), this.initialDelay, this.flexDuration, this.intervalDuration, this.nextScheduleTimeOverride);
            }
            return Long.MAX_VALUE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state, Data data, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j5, long j6, int i2, int i4, long j7, int i5, List list, List list2, int i6, Object obj) {
            String str2 = (i6 & 1) != 0 ? workInfoPojo.id : str;
            WorkInfo.State state2 = (i6 & 2) != 0 ? workInfoPojo.state : state;
            return workInfoPojo.copy(str2, state2, (i6 & 4) != 0 ? workInfoPojo.output : data, (i6 & 8) != 0 ? workInfoPojo.initialDelay : j, (i6 & 16) != 0 ? workInfoPojo.intervalDuration : j2, (i6 & 32) != 0 ? workInfoPojo.flexDuration : j3, (i6 & 64) != 0 ? workInfoPojo.constraints : constraints, (i6 & 128) != 0 ? workInfoPojo.runAttemptCount : i, (i6 & 256) != 0 ? workInfoPojo.backoffPolicy : backoffPolicy, (i6 & 512) != 0 ? workInfoPojo.backoffDelayDuration : j5, (i6 & 1024) != 0 ? workInfoPojo.lastEnqueueTime : j6, (i6 & 2048) != 0 ? workInfoPojo.periodCount : i2, (i6 & 4096) != 0 ? workInfoPojo.generation : i4, (i6 & 8192) != 0 ? workInfoPojo.nextScheduleTimeOverride : j7, (i6 & 16384) != 0 ? workInfoPojo.stopReason : i5, (32768 & i6) != 0 ? workInfoPojo.tags : list, (i6 & 65536) != 0 ? workInfoPojo.progress : list2);
        }

        private final WorkInfo.PeriodicityInfo getPeriodicityOrNull() {
            long j = this.intervalDuration;
            if (j != 0) {
                return new WorkInfo.PeriodicityInfo(j, this.flexDuration);
            }
            return null;
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final int getPeriodCount() {
            return this.periodCount;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final int getGeneration() {
            return this.generation;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final int getStopReason() {
            return this.stopReason;
        }

        @NotNull
        public final List<String> component16() {
            return this.tags;
        }

        @NotNull
        public final List<Data> component17() {
            return this.progress;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final WorkInfo.State getState() {
            return this.state;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Data getOutput() {
            return this.output;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getInitialDelay() {
            return this.initialDelay;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getFlexDuration() {
            return this.flexDuration;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Constraints getConstraints() {
            return this.constraints;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        @NotNull
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        @NotNull
        public final WorkInfoPojo copy(@NotNull String id, @NotNull WorkInfo.State state, @NotNull Data output, long initialDelay, long intervalDuration, long flexDuration, @NotNull Constraints constraints, int runAttemptCount, @NotNull BackoffPolicy backoffPolicy, long backoffDelayDuration, long lastEnqueueTime, int periodCount, int generation, long nextScheduleTimeOverride, int stopReason, @NotNull List<String> tags, @NotNull List<Data> progress) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(progress, "progress");
            return new WorkInfoPojo(id, state, output, initialDelay, intervalDuration, flexDuration, constraints, runAttemptCount, backoffPolicy, backoffDelayDuration, lastEnqueueTime, periodCount, generation, nextScheduleTimeOverride, stopReason, tags, progress);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) other;
            return Intrinsics.areEqual(this.id, workInfoPojo.id) && this.state == workInfoPojo.state && Intrinsics.areEqual(this.output, workInfoPojo.output) && this.initialDelay == workInfoPojo.initialDelay && this.intervalDuration == workInfoPojo.intervalDuration && this.flexDuration == workInfoPojo.flexDuration && Intrinsics.areEqual(this.constraints, workInfoPojo.constraints) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.backoffPolicy == workInfoPojo.backoffPolicy && this.backoffDelayDuration == workInfoPojo.backoffDelayDuration && this.lastEnqueueTime == workInfoPojo.lastEnqueueTime && this.periodCount == workInfoPojo.periodCount && this.generation == workInfoPojo.generation && this.nextScheduleTimeOverride == workInfoPojo.nextScheduleTimeOverride && this.stopReason == workInfoPojo.stopReason && Intrinsics.areEqual(this.tags, workInfoPojo.tags) && Intrinsics.areEqual(this.progress, workInfoPojo.progress);
        }

        public final long getBackoffDelayDuration() {
            return this.backoffDelayDuration;
        }

        @NotNull
        public final BackoffPolicy getBackoffPolicy() {
            return this.backoffPolicy;
        }

        @NotNull
        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final long getFlexDuration() {
            return this.flexDuration;
        }

        public final int getGeneration() {
            return this.generation;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        public final long getInitialDelay() {
            return this.initialDelay;
        }

        public final long getIntervalDuration() {
            return this.intervalDuration;
        }

        public final long getLastEnqueueTime() {
            return this.lastEnqueueTime;
        }

        public final long getNextScheduleTimeOverride() {
            return this.nextScheduleTimeOverride;
        }

        @NotNull
        public final Data getOutput() {
            return this.output;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        @NotNull
        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        @NotNull
        public final WorkInfo.State getState() {
            return this.state;
        }

        public final int getStopReason() {
            return this.stopReason;
        }

        @NotNull
        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return this.progress.hashCode() + AbstractC0622a.m1159e(this.tags, AbstractC0622a.m1157c(this.stopReason, AbstractC1974b.m1311d(this.nextScheduleTimeOverride, AbstractC0622a.m1157c(this.generation, AbstractC0622a.m1157c(this.periodCount, AbstractC1974b.m1311d(this.lastEnqueueTime, AbstractC1974b.m1311d(this.backoffDelayDuration, (this.backoffPolicy.hashCode() + AbstractC0622a.m1157c(this.runAttemptCount, (this.constraints.hashCode() + AbstractC1974b.m1311d(this.flexDuration, AbstractC1974b.m1311d(this.intervalDuration, AbstractC1974b.m1311d(this.initialDelay, (this.output.hashCode() + ((this.state.hashCode() + (this.id.hashCode() * 31)) * 31)) * 31, 31), 31), 31)) * 31, 31)) * 31, 31), 31), 31), 31), 31), 31), 31);
        }

        public final boolean isBackedOff() {
            return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
        }

        public final boolean isPeriodic() {
            return this.intervalDuration != 0;
        }

        public final void setBackoffDelayDuration(long j) {
            this.backoffDelayDuration = j;
        }

        public final void setBackoffPolicy(@NotNull BackoffPolicy backoffPolicy) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "<set-?>");
            this.backoffPolicy = backoffPolicy;
        }

        public final void setLastEnqueueTime(long j) {
            this.lastEnqueueTime = j;
        }

        public final void setPeriodCount(int i) {
            this.periodCount = i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder("WorkInfoPojo(id=");
            sb.append(this.id);
            sb.append(", state=");
            sb.append(this.state);
            sb.append(", output=");
            sb.append(this.output);
            sb.append(", initialDelay=");
            sb.append(this.initialDelay);
            sb.append(", intervalDuration=");
            sb.append(this.intervalDuration);
            sb.append(", flexDuration=");
            sb.append(this.flexDuration);
            sb.append(", constraints=");
            sb.append(this.constraints);
            sb.append(", runAttemptCount=");
            sb.append(this.runAttemptCount);
            sb.append(", backoffPolicy=");
            sb.append(this.backoffPolicy);
            sb.append(", backoffDelayDuration=");
            sb.append(this.backoffDelayDuration);
            sb.append(", lastEnqueueTime=");
            sb.append(this.lastEnqueueTime);
            sb.append(", periodCount=");
            sb.append(this.periodCount);
            sb.append(", generation=");
            sb.append(this.generation);
            sb.append(", nextScheduleTimeOverride=");
            sb.append(this.nextScheduleTimeOverride);
            sb.append(", stopReason=");
            sb.append(this.stopReason);
            sb.append(", tags=");
            sb.append(this.tags);
            sb.append(", progress=");
            return AbstractC1974b.m1321n(sb, this.progress, PropertyUtils.MAPPED_DELIM2);
        }

        @NotNull
        public final WorkInfo toWorkInfo() {
            Data progress = !this.progress.isEmpty() ? this.progress.get(0) : Data.EMPTY;
            UUID uuidFromString = UUID.fromString(this.id);
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(id)");
            WorkInfo.State state = this.state;
            HashSet hashSet = new HashSet(this.tags);
            Data data = this.output;
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            return new WorkInfo(uuidFromString, state, hashSet, data, progress, this.runAttemptCount, this.generation, this.constraints, this.initialDelay, getPeriodicityOrNull(), calculateNextRunTimeMillis(), this.stopReason);
        }

        public /* synthetic */ WorkInfoPojo(String str, WorkInfo.State state, Data data, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j5, long j6, int i2, int i4, long j7, int i5, List list, List list2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, state, data, (i6 & 8) != 0 ? 0L : j, (i6 & 16) != 0 ? 0L : j2, (i6 & 32) != 0 ? 0L : j3, constraints, i, (i6 & 256) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i6 & 512) != 0 ? 30000L : j5, (i6 & 1024) != 0 ? 0L : j6, (i6 & 2048) != 0 ? 0 : i2, i4, j7, i5, list, list2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints, int i, BackoffPolicy backoffPolicy, long j5, long j6, long j7, long j8, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i2, int i4, long j9, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i7 & 2) != 0 ? WorkInfo.State.ENQUEUED : state;
        if ((i7 & 8) != 0) {
            String name = OverwritingInputMerger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "OverwritingInputMerger::class.java.name");
            str4 = name;
        } else {
            str4 = str3;
        }
        if ((i7 & 16) != 0) {
            Data EMPTY = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i7 & 32) != 0) {
            Data EMPTY2 = Data.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, str4, data3, data4, (i7 & 64) != 0 ? 0L : j, (i7 & 128) != 0 ? 0L : j2, (i7 & 256) != 0 ? 0L : j3, (i7 & 512) != 0 ? Constraints.NONE : constraints, (i7 & 1024) != 0 ? 0 : i, (i7 & 2048) != 0 ? BackoffPolicy.EXPONENTIAL : backoffPolicy, (i7 & 4096) != 0 ? 30000L : j5, (i7 & 8192) != 0 ? -1L : j6, (i7 & 16384) == 0 ? j7 : 0L, (32768 & i7) != 0 ? -1L : j8, (65536 & i7) != 0 ? false : z, (131072 & i7) != 0 ? OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST : outOfQuotaPolicy, (262144 & i7) != 0 ? 0 : i2, (524288 & i7) != 0 ? 0 : i4, (1048576 & i7) != 0 ? Long.MAX_VALUE : j9, (2097152 & i7) != 0 ? 0 : i5, (i7 & 4194304) != 0 ? -256 : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(@NotNull String id, @NotNull String workerClassName_) {
        this(id, null, workerClassName_, null, null, null, 0L, 0L, 0L, null, 0, null, 0L, 0L, 0L, 0L, false, null, 0, 0, 0L, 0, 0, 8388602, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(workerClassName_, "workerClassName_");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkSpec(@NotNull String newId, @NotNull WorkSpec other) {
        this(newId, other.state, other.workerClassName, other.inputMergerClassName, new Data(other.input), new Data(other.output), other.initialDelay, other.intervalDuration, other.flexDuration, new Constraints(other.constraints), other.runAttemptCount, other.backoffPolicy, other.backoffDelayDuration, other.lastEnqueueTime, other.minimumRetentionDuration, other.scheduleRequestedAt, other.expedited, other.outOfQuotaPolicy, other.periodCount, 0, other.nextScheduleTimeOverride, other.nextScheduleTimeOverrideGeneration, other.stopReason, 524288, null);
        Intrinsics.checkNotNullParameter(newId, "newId");
        Intrinsics.checkNotNullParameter(other, "other");
    }
}
