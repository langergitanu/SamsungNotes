package com.google.android.appfunctions.schema.common.p129v1.email;

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
@Document(name = C$$__AppSearch__FindEmailsParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020\u0011H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006("}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/email/FindEmailsParams;", "", "namespace", "", "id", "query", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "sent", "", "read", "senderIds", "", "recipientIds", "labels", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getQuery", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getSent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRead", "getSenderIds", "()Ljava/util/List;", "getRecipientIds", "getLabels", "getMaxCount", "()I", "equals", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindEmailsParams {

    @Document.DocumentProperty
    @Nullable
    private final DateTime endTime;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @NotNull
    private final List<String> labels;

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
    private final List<String> recipientIds;

    @Document.StringProperty
    @NotNull
    private final List<String> senderIds;

    @Document.BooleanProperty
    @Nullable
    private final Boolean sent;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startTime;

    public FindEmailsParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull List<String> senderIds, @NotNull List<String> recipientIds, @NotNull List<String> labels, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(senderIds, "senderIds");
        Intrinsics.checkNotNullParameter(recipientIds, "recipientIds");
        Intrinsics.checkNotNullParameter(labels, "labels");
        this.namespace = namespace;
        this.id = id;
        this.query = str;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.sent = bool;
        this.read = bool2;
        this.senderIds = senderIds;
        this.recipientIds = recipientIds;
        this.labels = labels;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindEmailsParams)) {
            return false;
        }
        FindEmailsParams findEmailsParams = (FindEmailsParams) other;
        return Intrinsics.areEqual(this.query, findEmailsParams.query) && Intrinsics.areEqual(this.startTime, findEmailsParams.startTime) && Intrinsics.areEqual(this.endTime, findEmailsParams.endTime) && Intrinsics.areEqual(this.sent, findEmailsParams.sent) && Intrinsics.areEqual(this.read, findEmailsParams.read) && Intrinsics.areEqual(this.senderIds, findEmailsParams.senderIds) && Intrinsics.areEqual(this.recipientIds, findEmailsParams.recipientIds) && Intrinsics.areEqual(this.labels, findEmailsParams.labels) && this.maxCount == findEmailsParams.maxCount;
    }

    @Nullable
    public final DateTime getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<String> getLabels() {
        return this.labels;
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
    public final List<String> getRecipientIds() {
        return this.recipientIds;
    }

    @NotNull
    public final List<String> getSenderIds() {
        return this.senderIds;
    }

    @Nullable
    public final Boolean getSent() {
        return this.sent;
    }

    @Nullable
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.query, this.startTime, this.endTime, this.sent, this.read, this.senderIds, this.recipientIds, this.labels, Integer.valueOf(this.maxCount));
    }

    public /* synthetic */ FindEmailsParams(String str, String str2, String str3, DateTime dateTime, DateTime dateTime2, Boolean bool, Boolean bool2, List list, List list2, List list3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : dateTime, (i2 & 16) != 0 ? null : dateTime2, (i2 & 32) != 0 ? null : bool, (i2 & 64) != 0 ? null : bool2, (i2 & 128) != 0 ? CollectionsKt.emptyList() : list, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list3, i);
    }
}
