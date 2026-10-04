package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetDateTimeField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.scsp.common.Header;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateEventParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020,H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001b¨\u0006-"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/calendar/UpdateEventParams;", "", "namespace", "", "id", "eventId", "title", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "description", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "startDate", "Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeField;", "endDate", "attendeeIds", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;", "allDay", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;", Header.LOCATION, "recurrenceSchedule", "eventStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeField;Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getEventId", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getDescription", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getStartDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeField;", "getEndDate", "getAttendeeIds", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;", "getAllDay", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;", "getLocation", "getRecurrenceSchedule", "getEventStatus", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateEventParams {

    @Document.DocumentProperty
    @Nullable
    private final SetBooleanField allDay;

    @Document.DocumentProperty
    @Nullable
    private final SetStringListField attendeeIds;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField description;

    @Document.DocumentProperty
    @Nullable
    private final SetDateTimeField endDate;

    @Document.StringProperty(required = true)
    @NotNull
    private final String eventId;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField eventStatus;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField location;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField recurrenceSchedule;

    @Document.DocumentProperty
    @Nullable
    private final SetDateTimeField startDate;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField title;

    public UpdateEventParams(@NotNull String namespace, @NotNull String id, @NotNull String eventId, @Nullable SetStringField setStringField, @Nullable SetStringNullableField setStringNullableField, @Nullable SetDateTimeField setDateTimeField, @Nullable SetDateTimeField setDateTimeField2, @Nullable SetStringListField setStringListField, @Nullable SetBooleanField setBooleanField, @Nullable SetStringNullableField setStringNullableField2, @Nullable SetStringNullableField setStringNullableField3, @Nullable SetStringField setStringField2) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.namespace = namespace;
        this.id = id;
        this.eventId = eventId;
        this.title = setStringField;
        this.description = setStringNullableField;
        this.startDate = setDateTimeField;
        this.endDate = setDateTimeField2;
        this.attendeeIds = setStringListField;
        this.allDay = setBooleanField;
        this.location = setStringNullableField2;
        this.recurrenceSchedule = setStringNullableField3;
        this.eventStatus = setStringField2;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateEventParams)) {
            return false;
        }
        UpdateEventParams updateEventParams = (UpdateEventParams) other;
        return Intrinsics.areEqual(this.eventId, updateEventParams.eventId) && Intrinsics.areEqual(this.title, updateEventParams.title) && Intrinsics.areEqual(this.description, updateEventParams.description) && Intrinsics.areEqual(this.startDate, updateEventParams.startDate) && Intrinsics.areEqual(this.endDate, updateEventParams.endDate) && Intrinsics.areEqual(this.attendeeIds, updateEventParams.attendeeIds) && Intrinsics.areEqual(this.allDay, updateEventParams.allDay) && Intrinsics.areEqual(this.location, updateEventParams.location) && Intrinsics.areEqual(this.recurrenceSchedule, updateEventParams.recurrenceSchedule) && Intrinsics.areEqual(this.eventStatus, updateEventParams.eventStatus);
    }

    @Nullable
    public final SetBooleanField getAllDay() {
        return this.allDay;
    }

    @Nullable
    public final SetStringListField getAttendeeIds() {
        return this.attendeeIds;
    }

    @Nullable
    public final SetStringNullableField getDescription() {
        return this.description;
    }

    @Nullable
    public final SetDateTimeField getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    public final SetStringField getEventStatus() {
        return this.eventStatus;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SetStringNullableField getLocation() {
        return this.location;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final SetStringNullableField getRecurrenceSchedule() {
        return this.recurrenceSchedule;
    }

    @Nullable
    public final SetDateTimeField getStartDate() {
        return this.startDate;
    }

    @Nullable
    public final SetStringField getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.eventId, this.title, this.description, this.startDate, this.endDate, this.attendeeIds, this.allDay, this.location, this.recurrenceSchedule, this.eventStatus);
    }

    public /* synthetic */ UpdateEventParams(String str, String str2, String str3, SetStringField setStringField, SetStringNullableField setStringNullableField, SetDateTimeField setDateTimeField, SetDateTimeField setDateTimeField2, SetStringListField setStringListField, SetBooleanField setBooleanField, SetStringNullableField setStringNullableField2, SetStringNullableField setStringNullableField3, SetStringField setStringField2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setStringNullableField, (i & 32) != 0 ? null : setDateTimeField, (i & 64) != 0 ? null : setDateTimeField2, (i & 128) != 0 ? null : setStringListField, (i & 256) != 0 ? null : setBooleanField, (i & 512) != 0 ? null : setStringNullableField2, (i & 1024) != 0 ? null : setStringNullableField3, (i & 2048) != 0 ? null : setStringField2);
    }
}
