package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.annotation.Document;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Attachment.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/Attachment;", "", "namespace", "", "id", "displayName", "mimeType", "uri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getDisplayName", "getMimeType", "getUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "equals", "", "other", "hashCode", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Attachment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Document.StringProperty(required = true)
    @NotNull
    private final String displayName;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String mimeType;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri uri;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/Attachment$Companion;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "Lcom/google/android/appfunctions/schema/common/v1/types/Attachment;", "<init>", "()V", "setField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetAttachmentField;", "value", "setNullableField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetAttachmentNullableField;", "setListField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetAttachmentListField;", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements SetFieldCompanion<Attachment> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetAttachmentField setField(@NotNull Attachment value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetAttachmentField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetField<List<Attachment>> setListField(@NotNull List<? extends Attachment> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetAttachmentListField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetAttachmentNullableField setNullableField(@Nullable Attachment value) {
            return new SetAttachmentNullableField(null, null, value, 3, null);
        }
    }

    public Attachment(@NotNull String namespace, @NotNull String id, @NotNull String displayName, @Nullable String str, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.namespace = namespace;
        this.id = id;
        this.displayName = displayName;
        this.mimeType = str;
        this.uri = uri;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) other;
        return Intrinsics.areEqual(this.displayName, attachment.displayName) && Intrinsics.areEqual(this.mimeType, attachment.mimeType) && Intrinsics.areEqual(this.uri, attachment.uri);
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return Objects.hash(this.displayName, this.mimeType, this.uri);
    }

    public /* synthetic */ Attachment(String str, String str2, String str3, String str4, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : str4, uri);
    }
}
