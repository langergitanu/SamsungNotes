package com.google.android.appfunctions.schema.common.p129v1.messages;

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
@Document(name = C$$__AppSearch__FindMessagesParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020\u000fH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/messages/FindMessagesParams;", "", "namespace", "", "id", "senderId", "recipientsIds", "", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "query", "read", "", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;Ljava/lang/Boolean;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getSenderId", "getRecipientsIds", "()Ljava/util/List;", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getQuery", "getRead", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxCount", "()I", "equals", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindMessagesParams {

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

    @Document.BooleanProperty
    @Nullable
    private final Boolean read;

    @Document.StringProperty
    @NotNull
    private final List<String> recipientsIds;

    @Document.StringProperty
    @Nullable
    private final String senderId;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startTime;

    public FindMessagesParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @NotNull List<String> recipientsIds, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str2, @Nullable Boolean bool, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(recipientsIds, "recipientsIds");
        this.namespace = namespace;
        this.id = id;
        this.senderId = str;
        this.recipientsIds = recipientsIds;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.query = str2;
        this.read = bool;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindMessagesParams)) {
            return false;
        }
        FindMessagesParams findMessagesParams = (FindMessagesParams) other;
        return Intrinsics.areEqual(this.senderId, findMessagesParams.senderId) && Intrinsics.areEqual(this.recipientsIds, findMessagesParams.recipientsIds) && Intrinsics.areEqual(this.startTime, findMessagesParams.startTime) && Intrinsics.areEqual(this.endTime, findMessagesParams.endTime) && Intrinsics.areEqual(this.query, findMessagesParams.query) && Intrinsics.areEqual(this.read, findMessagesParams.read) && this.maxCount == findMessagesParams.maxCount;
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
    public final Boolean getRead() {
        return this.read;
    }

    @NotNull
    public final List<String> getRecipientsIds() {
        return this.recipientsIds;
    }

    @Nullable
    public final String getSenderId() {
        return this.senderId;
    }

    @Nullable
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.senderId, this.recipientsIds, this.startTime, this.endTime, this.query, this.read, Integer.valueOf(this.maxCount));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FindMessagesParams(String str, String str2, String str3, List list, DateTime dateTime, DateTime dateTime2, String str4, Boolean bool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        Boolean bool2;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        str3 = (i2 & 4) != 0 ? null : str3;
        list = (i2 & 8) != 0 ? CollectionsKt.emptyList() : list;
        dateTime = (i2 & 16) != 0 ? null : dateTime;
        dateTime2 = (i2 & 32) != 0 ? null : dateTime2;
        str4 = (i2 & 64) != 0 ? null : str4;
        if ((i2 & 128) != 0) {
            i4 = i;
            bool2 = null;
        } else {
            i4 = i;
            bool2 = bool;
        }
        this(str, str2, str3, list, dateTime, dateTime2, str4, bool2, i4);
    }
}
