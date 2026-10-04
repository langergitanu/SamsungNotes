package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__FindAlarmsParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\rH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006\""}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/FindAlarmsParams;", "", "namespace", "", "id", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "label", "alarmStatus", "dayPattern", "Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;", "maxCount", "", "sortingOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;ILjava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getLabel", "getAlarmStatus", "getDayPattern", "()Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;", "getMaxCount", "()I", "getSortingOrder", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindAlarmsParams {

    @Document.StringProperty
    @Nullable
    private final String alarmStatus;

    @Document.DocumentProperty
    @Nullable
    private final DayPattern dayPattern;

    @Document.DocumentProperty
    @Nullable
    private final DateTime endTime;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String label;

    @Document.LongProperty(required = true)
    private final int maxCount;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String sortingOrder;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startTime;

    public FindAlarmsParams(@NotNull String namespace, @NotNull String id, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str, @Nullable String str2, @Nullable DayPattern dayPattern, int i, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.label = str;
        this.alarmStatus = str2;
        this.dayPattern = dayPattern;
        this.maxCount = i;
        this.sortingOrder = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindAlarmsParams)) {
            return false;
        }
        FindAlarmsParams findAlarmsParams = (FindAlarmsParams) other;
        return Intrinsics.areEqual(this.startTime, findAlarmsParams.startTime) && Intrinsics.areEqual(this.endTime, findAlarmsParams.endTime) && Intrinsics.areEqual(this.label, findAlarmsParams.label) && Intrinsics.areEqual(this.alarmStatus, findAlarmsParams.alarmStatus) && Intrinsics.areEqual(this.dayPattern, findAlarmsParams.dayPattern) && this.maxCount == findAlarmsParams.maxCount && Intrinsics.areEqual(this.sortingOrder, findAlarmsParams.sortingOrder);
    }

    @Nullable
    public final String getAlarmStatus() {
        return this.alarmStatus;
    }

    @Nullable
    public final DayPattern getDayPattern() {
        return this.dayPattern;
    }

    @Nullable
    public final DateTime getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getSortingOrder() {
        return this.sortingOrder;
    }

    @Nullable
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.startTime, this.endTime, this.label, this.alarmStatus, this.dayPattern, Integer.valueOf(this.maxCount), this.sortingOrder);
    }

    public /* synthetic */ FindAlarmsParams(String str, String str2, DateTime dateTime, DateTime dateTime2, String str3, String str4, DayPattern dayPattern, int i, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : dateTime, (i2 & 8) != 0 ? null : dateTime2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : dayPattern, i, (i2 & 256) != 0 ? null : str5);
    }
}
