package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetTimeOfDayField;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateAlarmParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/UpdateAlarmParams;", "", "namespace", "", "id", "alarmId", "label", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "time", "Lcom/google/android/appfunctions/schema/common/v1/types/SetTimeOfDayField;", "alarmStatus", "dayPattern", "Lcom/google/android/appfunctions/schema/common/v1/clock/SetDayPatternNullableField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetTimeOfDayField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/clock/SetDayPatternNullableField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getAlarmId", "getLabel", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetTimeOfDayField;", "getAlarmStatus", "getDayPattern", "()Lcom/google/android/appfunctions/schema/common/v1/clock/SetDayPatternNullableField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateAlarmParams {

    @Document.StringProperty(required = true)
    @NotNull
    private final String alarmId;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField alarmStatus;

    @Document.DocumentProperty
    @Nullable
    private final SetDayPatternNullableField dayPattern;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField label;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final SetTimeOfDayField time;

    public UpdateAlarmParams(@NotNull String namespace, @NotNull String id, @NotNull String alarmId, @Nullable SetStringNullableField setStringNullableField, @Nullable SetTimeOfDayField setTimeOfDayField, @Nullable SetStringNullableField setStringNullableField2, @Nullable SetDayPatternNullableField setDayPatternNullableField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(alarmId, "alarmId");
        this.namespace = namespace;
        this.id = id;
        this.alarmId = alarmId;
        this.label = setStringNullableField;
        this.time = setTimeOfDayField;
        this.alarmStatus = setStringNullableField2;
        this.dayPattern = setDayPatternNullableField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateAlarmParams)) {
            return false;
        }
        UpdateAlarmParams updateAlarmParams = (UpdateAlarmParams) other;
        return Intrinsics.areEqual(this.alarmId, updateAlarmParams.alarmId) && Intrinsics.areEqual(this.label, updateAlarmParams.label) && Intrinsics.areEqual(this.time, updateAlarmParams.time) && Intrinsics.areEqual(this.alarmStatus, updateAlarmParams.alarmStatus) && Intrinsics.areEqual(this.dayPattern, updateAlarmParams.dayPattern);
    }

    @NotNull
    public final String getAlarmId() {
        return this.alarmId;
    }

    @Nullable
    public final SetStringNullableField getAlarmStatus() {
        return this.alarmStatus;
    }

    @Nullable
    public final SetDayPatternNullableField getDayPattern() {
        return this.dayPattern;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SetStringNullableField getLabel() {
        return this.label;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final SetTimeOfDayField getTime() {
        return this.time;
    }

    public int hashCode() {
        return Objects.hash(this.alarmId, this.label, this.time, this.alarmStatus, this.dayPattern);
    }

    public /* synthetic */ UpdateAlarmParams(String str, String str2, String str3, SetStringNullableField setStringNullableField, SetTimeOfDayField setTimeOfDayField, SetStringNullableField setStringNullableField2, SetDayPatternNullableField setDayPatternNullableField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringNullableField, (i & 16) != 0 ? null : setTimeOfDayField, (i & 32) != 0 ? null : setStringNullableField2, (i & 64) != 0 ? null : setDayPatternNullableField);
    }
}
