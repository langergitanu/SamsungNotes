package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Email.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010$\u001a\u00020\r2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\f\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u0006("}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/email/Email;", "", "namespace", "", "id", "subject", "message", "senderId", "recipientIds", "", "ccRecipientIds", "bccRecipientIds", "isDraft", "", "dateSent", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "dateReceived", "dateRead", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getSubject", "getMessage", "getSenderId", "getRecipientIds", "()Ljava/util/List;", "getCcRecipientIds", "getBccRecipientIds", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDateSent", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getDateReceived", "getDateRead", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Email {

    @Document.StringProperty
    @NotNull
    private final List<String> bccRecipientIds;

    @Document.StringProperty
    @NotNull
    private final List<String> ccRecipientIds;

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

    @Document.BooleanProperty
    @Nullable
    private final Boolean isDraft;

    @Document.StringProperty
    @Nullable
    private final String message;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @NotNull
    private final List<String> recipientIds;

    @Document.StringProperty
    @Nullable
    private final String senderId;

    @Document.StringProperty
    @Nullable
    private final String subject;

    public Email(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull List<String> recipientIds, @NotNull List<String> ccRecipientIds, @NotNull List<String> bccRecipientIds, @Nullable Boolean bool, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable DateTime dateTime3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(recipientIds, "recipientIds");
        Intrinsics.checkNotNullParameter(ccRecipientIds, "ccRecipientIds");
        Intrinsics.checkNotNullParameter(bccRecipientIds, "bccRecipientIds");
        this.namespace = namespace;
        this.id = id;
        this.subject = str;
        this.message = str2;
        this.senderId = str3;
        this.recipientIds = recipientIds;
        this.ccRecipientIds = ccRecipientIds;
        this.bccRecipientIds = bccRecipientIds;
        this.isDraft = bool;
        this.dateSent = dateTime;
        this.dateReceived = dateTime2;
        this.dateRead = dateTime3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Email)) {
            return false;
        }
        Email email = (Email) other;
        return Intrinsics.areEqual(this.id, email.id) && Intrinsics.areEqual(this.subject, email.subject) && Intrinsics.areEqual(this.message, email.message) && Intrinsics.areEqual(this.senderId, email.senderId) && Intrinsics.areEqual(this.recipientIds, email.recipientIds) && Intrinsics.areEqual(this.ccRecipientIds, email.ccRecipientIds) && Intrinsics.areEqual(this.bccRecipientIds, email.bccRecipientIds) && Intrinsics.areEqual(this.isDraft, email.isDraft) && Intrinsics.areEqual(this.dateSent, email.dateSent) && Intrinsics.areEqual(this.dateReceived, email.dateReceived) && Intrinsics.areEqual(this.dateRead, email.dateRead);
    }

    @NotNull
    public final List<String> getBccRecipientIds() {
        return this.bccRecipientIds;
    }

    @NotNull
    public final List<String> getCcRecipientIds() {
        return this.ccRecipientIds;
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

    @Nullable
    public final String getSenderId() {
        return this.senderId;
    }

    @Nullable
    public final String getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.subject, this.message, this.senderId, this.recipientIds, this.ccRecipientIds, this.bccRecipientIds, this.isDraft, this.dateSent, this.dateReceived, this.dateRead);
    }

    @Nullable
    /* JADX INFO: renamed from: isDraft, reason: from getter */
    public final Boolean getIsDraft() {
        return this.isDraft;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Email(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.util.List r7, java.util.List r8, java.util.List r9, java.lang.Boolean r10, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r11, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r12, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r1 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r15 = r14 & 4
            r0 = 0
            if (r15 == 0) goto Lc
            r4 = r0
        Lc:
            r15 = r14 & 8
            if (r15 == 0) goto L11
            r5 = r0
        L11:
            r15 = r14 & 16
            if (r15 == 0) goto L16
            r6 = r0
        L16:
            r15 = r14 & 32
            if (r15 == 0) goto L1e
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L1e:
            r15 = r14 & 64
            if (r15 == 0) goto L26
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L26:
            r15 = r14 & 128(0x80, float:1.8E-43)
            if (r15 == 0) goto L2e
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
        L2e:
            r15 = r14 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L33
            r10 = r0
        L33:
            r15 = r14 & 512(0x200, float:7.17E-43)
            if (r15 == 0) goto L38
            r11 = r0
        L38:
            r15 = r14 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L3d
            r12 = r0
        L3d:
            r14 = r14 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L4f
            r15 = r0
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L5c
        L4f:
            r15 = r13
            r14 = r12
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L5c:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.email.Email.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.util.List, java.lang.Boolean, com.google.android.appfunctions.schema.common.v1.types.DateTime, com.google.android.appfunctions.schema.common.v1.types.DateTime, com.google.android.appfunctions.schema.common.v1.types.DateTime, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
