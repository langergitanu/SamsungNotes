package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appsearch.annotation.Document;
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
@Document(name = C$$__AppSearch__CreateEmailDraftParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/email/CreateEmailDraftParams;", "", "namespace", "", "id", "subject", "message", "senderAccountId", "recipientIds", "", "ccRecipientIds", "bccRecipientIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getSubject", "getMessage", "getSenderAccountId", "getRecipientIds", "()Ljava/util/List;", "getCcRecipientIds", "getBccRecipientIds", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreateEmailDraftParams {

    @Document.StringProperty
    @NotNull
    private final List<String> bccRecipientIds;

    @Document.StringProperty
    @NotNull
    private final List<String> ccRecipientIds;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String message;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @NotNull
    private final List<String> recipientIds;

    @Document.StringProperty(required = true)
    @NotNull
    private final String senderAccountId;

    @Document.StringProperty
    @Nullable
    private final String subject;

    public CreateEmailDraftParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable String str2, @NotNull String senderAccountId, @NotNull List<String> recipientIds, @NotNull List<String> ccRecipientIds, @NotNull List<String> bccRecipientIds) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(senderAccountId, "senderAccountId");
        Intrinsics.checkNotNullParameter(recipientIds, "recipientIds");
        Intrinsics.checkNotNullParameter(ccRecipientIds, "ccRecipientIds");
        Intrinsics.checkNotNullParameter(bccRecipientIds, "bccRecipientIds");
        this.namespace = namespace;
        this.id = id;
        this.subject = str;
        this.message = str2;
        this.senderAccountId = senderAccountId;
        this.recipientIds = recipientIds;
        this.ccRecipientIds = ccRecipientIds;
        this.bccRecipientIds = bccRecipientIds;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreateEmailDraftParams)) {
            return false;
        }
        CreateEmailDraftParams createEmailDraftParams = (CreateEmailDraftParams) other;
        return Intrinsics.areEqual(this.subject, createEmailDraftParams.subject) && Intrinsics.areEqual(this.message, createEmailDraftParams.message) && Intrinsics.areEqual(this.senderAccountId, createEmailDraftParams.senderAccountId) && Intrinsics.areEqual(this.recipientIds, createEmailDraftParams.recipientIds) && Intrinsics.areEqual(this.ccRecipientIds, createEmailDraftParams.ccRecipientIds) && Intrinsics.areEqual(this.bccRecipientIds, createEmailDraftParams.bccRecipientIds);
    }

    @NotNull
    public final List<String> getBccRecipientIds() {
        return this.bccRecipientIds;
    }

    @NotNull
    public final List<String> getCcRecipientIds() {
        return this.ccRecipientIds;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final List<String> getRecipientIds() {
        return this.recipientIds;
    }

    @NotNull
    public final String getSenderAccountId() {
        return this.senderAccountId;
    }

    @Nullable
    public final String getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return Objects.hash(this.subject, this.message, this.senderAccountId, this.recipientIds, this.ccRecipientIds, this.bccRecipientIds);
    }

    public /* synthetic */ CreateEmailDraftParams(String str, String str2, String str3, String str4, String str5, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2, (i & 128) != 0 ? CollectionsKt.emptyList() : list3);
    }
}
