package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.scsp.common.Header;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__CreateEventParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015¨\u0006)"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/calendar/CreateEventParams;", "", "namespace", "", "id", "title", "description", "startDate", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endDate", "attendeeIds", "", "allDay", "", Header.LOCATION, "recurrenceSchedule", "eventStatus", "externalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getDescription", "getStartDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndDate", "getAttendeeIds", "()Ljava/util/List;", "getAllDay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocation", "getRecurrenceSchedule", "getEventStatus", "getExternalId", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreateEventParams {

    @Document.BooleanProperty
    @Nullable
    private final Boolean allDay;

    @Document.StringProperty
    @NotNull
    private final List<String> attendeeIds;

    @Document.StringProperty
    @Nullable
    private final String description;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final DateTime endDate;

    @Document.StringProperty
    @Nullable
    private final String eventStatus;

    @Document.StringProperty
    @Nullable
    private final String externalId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String location;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String recurrenceSchedule;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final DateTime startDate;

    @Document.StringProperty(required = true)
    @NotNull
    private final String title;

    public CreateEventParams(@NotNull String namespace, @NotNull String id, @NotNull String title, @Nullable String str, @NotNull DateTime startDate, @NotNull DateTime endDate, @NotNull List<String> attendeeIds, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        Intrinsics.checkNotNullParameter(attendeeIds, "attendeeIds");
        this.namespace = namespace;
        this.id = id;
        this.title = title;
        this.description = str;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attendeeIds = attendeeIds;
        this.allDay = bool;
        this.location = str2;
        this.recurrenceSchedule = str3;
        this.eventStatus = str4;
        this.externalId = str5;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreateEventParams)) {
            return false;
        }
        CreateEventParams createEventParams = (CreateEventParams) other;
        return Intrinsics.areEqual(this.title, createEventParams.title) && Intrinsics.areEqual(this.description, createEventParams.description) && Intrinsics.areEqual(this.startDate, createEventParams.startDate) && Intrinsics.areEqual(this.endDate, createEventParams.endDate) && Intrinsics.areEqual(this.attendeeIds, createEventParams.attendeeIds) && Intrinsics.areEqual(this.allDay, createEventParams.allDay) && Intrinsics.areEqual(this.location, createEventParams.location) && Intrinsics.areEqual(this.recurrenceSchedule, createEventParams.recurrenceSchedule) && Intrinsics.areEqual(this.eventStatus, createEventParams.eventStatus) && Intrinsics.areEqual(this.externalId, createEventParams.externalId);
    }

    @Nullable
    public final Boolean getAllDay() {
        return this.allDay;
    }

    @NotNull
    public final List<String> getAttendeeIds() {
        return this.attendeeIds;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final DateTime getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final String getEventStatus() {
        return this.eventStatus;
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
    public final String getLocation() {
        return this.location;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getRecurrenceSchedule() {
        return this.recurrenceSchedule;
    }

    @NotNull
    public final DateTime getStartDate() {
        return this.startDate;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.title, this.description, this.startDate, this.endDate, this.attendeeIds, this.allDay, this.location, this.recurrenceSchedule, this.eventStatus, this.externalId);
    }

    public /* synthetic */ CreateEventParams(String str, String str2, String str3, String str4, DateTime dateTime, DateTime dateTime2, List list, Boolean bool, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : str4, dateTime, dateTime2, (i & 64) != 0 ? CollectionsKt.emptyList() : list, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8);
    }
}
