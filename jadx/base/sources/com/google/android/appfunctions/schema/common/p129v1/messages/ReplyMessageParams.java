package com.google.android.appfunctions.schema.common.p129v1.messages;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
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
@Document(name = C$$__AppSearch__ReplyMessageParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/messages/ReplyMessageParams;", "", "namespace", "", "id", "originalMessageId", "body", "messageAttachments", "", "Lcom/google/android/appfunctions/schema/common/v1/types/Attachment;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getOriginalMessageId", "getBody", "getMessageAttachments", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ReplyMessageParams {

    @Document.StringProperty(required = true)
    @NotNull
    private final String body;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @NotNull
    private final List<Attachment> messageAttachments;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String originalMessageId;

    public ReplyMessageParams(@NotNull String namespace, @NotNull String id, @NotNull String originalMessageId, @NotNull String body, @NotNull List<Attachment> messageAttachments) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(originalMessageId, "originalMessageId");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(messageAttachments, "messageAttachments");
        this.namespace = namespace;
        this.id = id;
        this.originalMessageId = originalMessageId;
        this.body = body;
        this.messageAttachments = messageAttachments;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof ReplyMessageParams)) {
            return false;
        }
        ReplyMessageParams replyMessageParams = (ReplyMessageParams) other;
        return Intrinsics.areEqual(this.originalMessageId, replyMessageParams.originalMessageId) && Intrinsics.areEqual(this.body, replyMessageParams.body) && Intrinsics.areEqual(this.messageAttachments, replyMessageParams.messageAttachments);
    }

    @NotNull
    public final String getBody() {
        return this.body;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<Attachment> getMessageAttachments() {
        return this.messageAttachments;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final String getOriginalMessageId() {
        return this.originalMessageId;
    }

    public int hashCode() {
        return Objects.hash(this.originalMessageId, this.body, this.messageAttachments);
    }

    public /* synthetic */ ReplyMessageParams(String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, str4, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }
}
