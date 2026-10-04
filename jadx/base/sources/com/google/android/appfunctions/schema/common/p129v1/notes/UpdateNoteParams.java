package com.google.android.appfunctions.schema.common.p129v1.notes;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetAttachmentListField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateNoteParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001f"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/notes/UpdateNoteParams;", "", "namespace", "", "id", "noteId", "title", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "content", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "attachments", "Lcom/google/android/appfunctions/schema/common/v1/types/SetAttachmentListField;", "folderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetAttachmentListField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getNoteId", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getContent", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getAttachments", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetAttachmentListField;", "getFolderId", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateNoteParams {

    @Document.DocumentProperty
    @Nullable
    private final SetAttachmentListField attachments;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField content;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField folderId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String noteId;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField title;

    public UpdateNoteParams(@NotNull String namespace, @NotNull String id, @NotNull String noteId, @Nullable SetStringField setStringField, @Nullable SetStringNullableField setStringNullableField, @Nullable SetAttachmentListField setAttachmentListField, @Nullable SetStringNullableField setStringNullableField2) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(noteId, "noteId");
        this.namespace = namespace;
        this.id = id;
        this.noteId = noteId;
        this.title = setStringField;
        this.content = setStringNullableField;
        this.attachments = setAttachmentListField;
        this.folderId = setStringNullableField2;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateNoteParams)) {
            return false;
        }
        UpdateNoteParams updateNoteParams = (UpdateNoteParams) other;
        return Intrinsics.areEqual(this.noteId, updateNoteParams.noteId) && Intrinsics.areEqual(this.title, updateNoteParams.title) && Intrinsics.areEqual(this.content, updateNoteParams.content) && Intrinsics.areEqual(this.attachments, updateNoteParams.attachments) && Intrinsics.areEqual(this.folderId, updateNoteParams.folderId);
    }

    @Nullable
    public final SetAttachmentListField getAttachments() {
        return this.attachments;
    }

    @Nullable
    public final SetStringNullableField getContent() {
        return this.content;
    }

    @Nullable
    public final SetStringNullableField getFolderId() {
        return this.folderId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final String getNoteId() {
        return this.noteId;
    }

    @Nullable
    public final SetStringField getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.noteId, this.title, this.content, this.attachments, this.folderId);
    }

    public /* synthetic */ UpdateNoteParams(String str, String str2, String str3, SetStringField setStringField, SetStringNullableField setStringNullableField, SetAttachmentListField setAttachmentListField, SetStringNullableField setStringNullableField2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setStringNullableField, (i & 32) != 0 ? null : setAttachmentListField, (i & 64) != 0 ? null : setStringNullableField2);
    }
}
