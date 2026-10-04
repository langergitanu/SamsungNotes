package com.google.android.appfunctions.schema.common.p129v1.phone;

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
@Document(name = C$$__AppSearch__FindCallRecordsParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\fH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/phone/FindCallRecordsParams;", "", "namespace", "", "id", "query", "contactId", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "callType", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getQuery", "getContactId", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getCallType", "getMaxCount", "()I", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindCallRecordsParams {

    @Document.StringProperty
    @Nullable
    private final String callType;

    @Document.StringProperty
    @Nullable
    private final String contactId;

    @Document.DocumentProperty
    @Nullable
    private final DateTime endTime;

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
    private final String query;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startTime;

    public FindCallRecordsParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable String str2, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str3, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.query = str;
        this.contactId = str2;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.callType = str3;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindCallRecordsParams)) {
            return false;
        }
        FindCallRecordsParams findCallRecordsParams = (FindCallRecordsParams) other;
        return Intrinsics.areEqual(this.query, findCallRecordsParams.query) && Intrinsics.areEqual(this.contactId, findCallRecordsParams.contactId) && Intrinsics.areEqual(this.startTime, findCallRecordsParams.startTime) && Intrinsics.areEqual(this.endTime, findCallRecordsParams.endTime) && Intrinsics.areEqual(this.callType, findCallRecordsParams.callType) && this.maxCount == findCallRecordsParams.maxCount;
    }

    @Nullable
    public final String getCallType() {
        return this.callType;
    }

    @Nullable
    public final String getContactId() {
        return this.contactId;
    }

    @Nullable
    public final DateTime getEndTime() {
        return this.endTime;
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
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.query, this.contactId, this.startTime, this.endTime, this.callType, Integer.valueOf(this.maxCount));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FindCallRecordsParams(String str, String str2, String str3, String str4, DateTime dateTime, DateTime dateTime2, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        String str6;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        str3 = (i2 & 4) != 0 ? null : str3;
        str4 = (i2 & 8) != 0 ? null : str4;
        dateTime = (i2 & 16) != 0 ? null : dateTime;
        dateTime2 = (i2 & 32) != 0 ? null : dateTime2;
        if ((i2 & 64) != 0) {
            i4 = i;
            str6 = null;
        } else {
            i4 = i;
            str6 = str5;
        }
        this(str, str2, str3, str4, dateTime, dateTime2, str6, i4);
    }
}
