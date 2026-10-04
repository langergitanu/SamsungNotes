package com.google.android.appfunctions.schema.common.p129v1.messages;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
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
@Document(name = C$$__AppSearch__Message.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019¨\u0006$"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/messages/Message;", "", "namespace", "", "id", "messageType", "body", "senderId", "recipientsIds", "", "dateSent", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "dateReceived", "dateRead", "messageAttachments", "Lcom/google/android/appfunctions/schema/common/v1/types/Attachment;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getMessageType", "getBody", "getSenderId", "getRecipientsIds", "()Ljava/util/List;", "getDateSent", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getDateReceived", "getDateRead", "getMessageAttachments", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Message {

    @Document.StringProperty(required = true)
    @NotNull
    private final String body;

    @Document.DocumentProperty
    @Nullable
    private final DateTime dateRead;

    @Document.DocumentProperty
    @Nullable
    private final DateTime dateReceived;

    @Document.DocumentProperty
    @Nullable
    private final DateTime dateSent;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @NotNull
    private final List<Attachment> messageAttachments;

    @Document.StringProperty(required = true)
    @NotNull
    private final String messageType;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @NotNull
    private final List<String> recipientsIds;

    @Document.StringProperty(required = true)
    @NotNull
    private final String senderId;

    public Message(@NotNull String namespace, @NotNull String id, @NotNull String messageType, @NotNull String body, @NotNull String senderId, @NotNull List<String> recipientsIds, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable DateTime dateTime3, @NotNull List<Attachment> messageAttachments) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(senderId, "senderId");
        Intrinsics.checkNotNullParameter(recipientsIds, "recipientsIds");
        Intrinsics.checkNotNullParameter(messageAttachments, "messageAttachments");
        this.namespace = namespace;
        this.id = id;
        this.messageType = messageType;
        this.body = body;
        this.senderId = senderId;
        this.recipientsIds = recipientsIds;
        this.dateSent = dateTime;
        this.dateReceived = dateTime2;
        this.dateRead = dateTime3;
        this.messageAttachments = messageAttachments;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Message)) {
            return false;
        }
        Message message = (Message) other;
        return Intrinsics.areEqual(this.id, message.id) && Intrinsics.areEqual(this.messageType, message.messageType) && Intrinsics.areEqual(this.body, message.body) && Intrinsics.areEqual(this.senderId, message.senderId) && Intrinsics.areEqual(this.recipientsIds, message.recipientsIds) && Intrinsics.areEqual(this.dateSent, message.dateSent) && Intrinsics.areEqual(this.dateReceived, message.dateReceived) && Intrinsics.areEqual(this.dateRead, message.dateRead) && Intrinsics.areEqual(this.messageAttachments, message.messageAttachments);
    }

    @NotNull
    public final String getBody() {
        return this.body;
    }

    @Nullable
    public final DateTime getDateRead() {
        return this.dateRead;
    }

    @Nullable
    public final DateTime getDateReceived() {
        return this.dateReceived;
    }

    @Nullable
    public final DateTime getDateSent() {
        return this.dateSent;
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
    public final String getMessageType() {
        return this.messageType;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final List<String> getRecipientsIds() {
        return this.recipientsIds;
    }

    @NotNull
    public final String getSenderId() {
        return this.senderId;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.messageType, this.body, this.senderId, this.recipientsIds, this.dateSent, this.dateReceived, this.dateRead, this.messageAttachments);
    }

    public /* synthetic */ Message(String str, String str2, String str3, String str4, String str5, List list, DateTime dateTime, DateTime dateTime2, DateTime dateTime3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, str3, str4, str5, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? null : dateTime, (i & 128) != 0 ? null : dateTime2, (i & 256) != 0 ? null : dateTime3, (i & 512) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
