package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.scsp.common.Header;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Event.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010(\u001a\u00020\r2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010*\u001a\u00020+H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0011\u0010\"R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0012\u0010\"R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0013\u0010\"R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018¨\u0006,"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/calendar/Event;", "", "namespace", "", "id", "title", "description", "startDate", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endDate", "attendeeIds", "", "allDay", "", Header.LOCATION, "recurrenceSchedule", "eventStatus", "isReadOnly", "isInPublicCalendar", "isOrganizer", "selfAttendeeStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getDescription", "getStartDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndDate", "getAttendeeIds", "()Ljava/util/List;", "getAllDay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLocation", "getRecurrenceSchedule", "getEventStatus", "getSelfAttendeeStatus", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Event {

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

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isInPublicCalendar;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isOrganizer;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isReadOnly;

    @Document.StringProperty
    @Nullable
    private final String location;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String recurrenceSchedule;

    @Document.StringProperty
    @Nullable
    private final String selfAttendeeStatus;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final DateTime startDate;

    @Document.StringProperty(required = true)
    @NotNull
    private final String title;

    public Event(@NotNull String namespace, @NotNull String id, @NotNull String title, @Nullable String str, @NotNull DateTime startDate, @NotNull DateTime endDate, @NotNull List<String> attendeeIds, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str5) {
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
        this.isReadOnly = bool2;
        this.isInPublicCalendar = bool3;
        this.isOrganizer = bool4;
        this.selfAttendeeStatus = str5;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Event)) {
            return false;
        }
        Event event = (Event) other;
        return Intrinsics.areEqual(this.id, event.id) && Intrinsics.areEqual(this.title, event.title) && Intrinsics.areEqual(this.description, event.description) && Intrinsics.areEqual(this.startDate, event.startDate) && Intrinsics.areEqual(this.endDate, event.endDate) && Intrinsics.areEqual(this.attendeeIds, event.attendeeIds) && Intrinsics.areEqual(this.allDay, event.allDay) && Intrinsics.areEqual(this.location, event.location) && Intrinsics.areEqual(this.recurrenceSchedule, event.recurrenceSchedule) && Intrinsics.areEqual(this.eventStatus, event.eventStatus) && Intrinsics.areEqual(this.isReadOnly, event.isReadOnly) && Intrinsics.areEqual(this.isInPublicCalendar, event.isInPublicCalendar) && Intrinsics.areEqual(this.isOrganizer, event.isOrganizer) && Intrinsics.areEqual(this.selfAttendeeStatus, event.selfAttendeeStatus);
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

    @Nullable
    public final String getSelfAttendeeStatus() {
        return this.selfAttendeeStatus;
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
        return Objects.hash(this.id, this.title, this.description, this.startDate, this.endDate, this.attendeeIds, this.allDay, this.location, this.recurrenceSchedule, this.eventStatus, this.isReadOnly, this.isInPublicCalendar, this.isOrganizer, this.selfAttendeeStatus);
    }

    @Nullable
    /* JADX INFO: renamed from: isInPublicCalendar, reason: from getter */
    public final Boolean getIsInPublicCalendar() {
        return this.isInPublicCalendar;
    }

    @Nullable
    /* JADX INFO: renamed from: isOrganizer, reason: from getter */
    public final Boolean getIsOrganizer() {
        return this.isOrganizer;
    }

    @Nullable
    /* JADX INFO: renamed from: isReadOnly, reason: from getter */
    public final Boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Event(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r23, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r24, java.util.List r25, java.lang.Boolean r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.Boolean r30, java.lang.Boolean r31, java.lang.Boolean r32, java.lang.String r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto La
            java.lang.String r1 = ""
            r3 = r1
            goto Lc
        La:
            r3 = r19
        Lc:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L13
            r6 = r2
            goto L15
        L13:
            r6 = r22
        L15:
            r1 = r0 & 64
            if (r1 == 0) goto L1f
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r9 = r1
            goto L21
        L1f:
            r9 = r25
        L21:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L27
            r10 = r2
            goto L29
        L27:
            r10 = r26
        L29:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L2f
            r11 = r2
            goto L31
        L2f:
            r11 = r27
        L31:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L37
            r12 = r2
            goto L39
        L37:
            r12 = r28
        L39:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L3f
            r13 = r2
            goto L41
        L3f:
            r13 = r29
        L41:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L47
            r14 = r2
            goto L49
        L47:
            r14 = r30
        L49:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L4f
            r15 = r2
            goto L51
        L4f:
            r15 = r31
        L51:
            r1 = r0 & 8192(0x2000, float:1.148E-41)
            if (r1 == 0) goto L58
            r16 = r2
            goto L5a
        L58:
            r16 = r32
        L5a:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L6b
            r17 = r2
            r4 = r20
            r5 = r21
            r7 = r23
            r8 = r24
            r2 = r18
            goto L77
        L6b:
            r17 = r33
            r2 = r18
            r4 = r20
            r5 = r21
            r7 = r23
            r8 = r24
        L77:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.calendar.Event.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.appfunctions.schema.common.v1.types.DateTime, com.google.android.appfunctions.schema.common.v1.types.DateTime, java.util.List, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
