package com.google.android.appfunctions.schema.common.p129v1.email;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateEmailParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001c¨\u0006\""}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/email/UpdateEmailParams;", "", "namespace", "", "id", "emailId", "subject", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "message", "recipientIds", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;", "ccRecipientIds", "bccRecipientIds", "isRead", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getEmailId", "getSubject", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getMessage", "getRecipientIds", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;", "getCcRecipientIds", "getBccRecipientIds", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateEmailParams {

    @Document.DocumentProperty
    @Nullable
    private final SetStringListField bccRecipientIds;

    @Document.DocumentProperty
    @Nullable
    private final SetStringListField ccRecipientIds;

    @Document.StringProperty(required = true)
    @NotNull
    private final String emailId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final SetBooleanField isRead;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField message;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final SetStringListField recipientIds;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField subject;

    public UpdateEmailParams(@NotNull String namespace, @NotNull String id, @NotNull String emailId, @Nullable SetStringNullableField setStringNullableField, @Nullable SetStringNullableField setStringNullableField2, @Nullable SetStringListField setStringListField, @Nullable SetStringListField setStringListField2, @Nullable SetStringListField setStringListField3, @Nullable SetBooleanField setBooleanField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(emailId, "emailId");
        this.namespace = namespace;
        this.id = id;
        this.emailId = emailId;
        this.subject = setStringNullableField;
        this.message = setStringNullableField2;
        this.recipientIds = setStringListField;
        this.ccRecipientIds = setStringListField2;
        this.bccRecipientIds = setStringListField3;
        this.isRead = setBooleanField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateEmailParams)) {
            return false;
        }
        UpdateEmailParams updateEmailParams = (UpdateEmailParams) other;
        return Intrinsics.areEqual(this.emailId, updateEmailParams.emailId) && Intrinsics.areEqual(this.subject, updateEmailParams.subject) && Intrinsics.areEqual(this.message, updateEmailParams.message) && Intrinsics.areEqual(this.recipientIds, updateEmailParams.recipientIds) && Intrinsics.areEqual(this.ccRecipientIds, updateEmailParams.ccRecipientIds) && Intrinsics.areEqual(this.bccRecipientIds, updateEmailParams.bccRecipientIds) && Intrinsics.areEqual(this.isRead, updateEmailParams.isRead);
    }

    @Nullable
    public final SetStringListField getBccRecipientIds() {
        return this.bccRecipientIds;
    }

    @Nullable
    public final SetStringListField getCcRecipientIds() {
        return this.ccRecipientIds;
    }

    @NotNull
    public final String getEmailId() {
        return this.emailId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SetStringNullableField getMessage() {
        return this.message;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final SetStringListField getRecipientIds() {
        return this.recipientIds;
    }

    @Nullable
    public final SetStringNullableField getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return Objects.hash(this.emailId, this.subject, this.message, this.recipientIds, this.ccRecipientIds, this.bccRecipientIds, this.isRead);
    }

    @Nullable
    /* JADX INFO: renamed from: isRead, reason: from getter */
    public final SetBooleanField getIsRead() {
        return this.isRead;
    }

    public /* synthetic */ UpdateEmailParams(String str, String str2, String str3, SetStringNullableField setStringNullableField, SetStringNullableField setStringNullableField2, SetStringListField setStringListField, SetStringListField setStringListField2, SetStringListField setStringListField3, SetBooleanField setBooleanField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringNullableField, (i & 16) != 0 ? null : setStringNullableField2, (i & 32) != 0 ? null : setStringListField, (i & 64) != 0 ? null : setStringListField2, (i & 128) != 0 ? null : setStringListField3, (i & 256) != 0 ? null : setBooleanField);
    }
}
