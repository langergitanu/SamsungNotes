package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDay;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__CreateAlarmParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/CreateAlarmParams;", "", "namespace", "", "id", "label", "time", "Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "alarmStatus", "dayPattern", "Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;", "externalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getLabel", "getTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "getAlarmStatus", "getDayPattern", "()Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;", "getExternalId", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreateAlarmParams {

    @Document.StringProperty
    @Nullable
    private final String alarmStatus;

    @Document.DocumentProperty
    @Nullable
    private final DayPattern dayPattern;

    @Document.StringProperty
    @Nullable
    private final String externalId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String label;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final TimeOfDay time;

    public CreateAlarmParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @NotNull TimeOfDay time, @Nullable String str2, @Nullable DayPattern dayPattern, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(time, "time");
        this.namespace = namespace;
        this.id = id;
        this.label = str;
        this.time = time;
        this.alarmStatus = str2;
        this.dayPattern = dayPattern;
        this.externalId = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreateAlarmParams)) {
            return false;
        }
        CreateAlarmParams createAlarmParams = (CreateAlarmParams) other;
        return Intrinsics.areEqual(this.label, createAlarmParams.label) && Intrinsics.areEqual(this.time, createAlarmParams.time) && Intrinsics.areEqual(this.alarmStatus, createAlarmParams.alarmStatus) && Intrinsics.areEqual(this.dayPattern, createAlarmParams.dayPattern) && Intrinsics.areEqual(this.externalId, createAlarmParams.externalId);
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
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final TimeOfDay getTime() {
        return this.time;
    }

    public int hashCode() {
        return Objects.hash(this.label, this.time, this.alarmStatus, this.dayPattern, this.externalId);
    }

    public /* synthetic */ CreateAlarmParams(String str, String str2, String str3, TimeOfDay timeOfDay, String str4, DayPattern dayPattern, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, timeOfDay, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : dayPattern, (i & 64) != 0 ? null : str5);
    }
}
