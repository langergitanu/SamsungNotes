package com.google.android.appfunctions.schema.common.p129v1.calendar;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
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
@Document(name = C$$__AppSearch__FindEventsParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006 "}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/calendar/FindEventsParams;", "", "namespace", "", "id", "startDate", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endDate", "query", "attendeeIds", "", "maxCount", "", "orderBy", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getStartDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndDate", "getQuery", "getAttendeeIds", "()Ljava/util/List;", "getMaxCount", "()I", "getOrderBy", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindEventsParams {

    @Document.StringProperty
    @NotNull
    private final List<String> attendeeIds;

    @Document.DocumentProperty
    @Nullable
    private final DateTime endDate;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.LongProperty(required = true)
    private final int maxCount;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String orderBy;

    @Document.StringProperty
    @Nullable
    private final String query;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startDate;

    public FindEventsParams(@NotNull String namespace, @NotNull String id, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str, @NotNull List<String> attendeeIds, int i, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(attendeeIds, "attendeeIds");
        this.namespace = namespace;
        this.id = id;
        this.startDate = dateTime;
        this.endDate = dateTime2;
        this.query = str;
        this.attendeeIds = attendeeIds;
        this.maxCount = i;
        this.orderBy = str2;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindEventsParams)) {
            return false;
        }
        FindEventsParams findEventsParams = (FindEventsParams) other;
        return Intrinsics.areEqual(this.startDate, findEventsParams.startDate) && Intrinsics.areEqual(this.endDate, findEventsParams.endDate) && Intrinsics.areEqual(this.query, findEventsParams.query) && Intrinsics.areEqual(this.attendeeIds, findEventsParams.attendeeIds) && this.maxCount == findEventsParams.maxCount && Intrinsics.areEqual(this.orderBy, findEventsParams.orderBy);
    }

    @NotNull
    public final List<String> getAttendeeIds() {
        return this.attendeeIds;
    }

    @Nullable
    public final DateTime getEndDate() {
        return this.endDate;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getOrderBy() {
        return this.orderBy;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final DateTime getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        return Objects.hash(this.startDate, this.endDate, this.query, this.attendeeIds, Integer.valueOf(this.maxCount), this.orderBy);
    }

    public /* synthetic */ FindEventsParams(String str, String str2, DateTime dateTime, DateTime dateTime2, String str3, List list, int i, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : dateTime, (i2 & 8) != 0 ? null : dateTime2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list, i, (i2 & 128) != 0 ? null : str4);
    }
}
