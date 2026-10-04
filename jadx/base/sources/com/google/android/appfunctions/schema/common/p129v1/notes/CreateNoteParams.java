package com.google.android.appfunctions.schema.common.p129v1.notes;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
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
@Document(name = C$$__AppSearch__CreateNoteParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001c"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/notes/CreateNoteParams;", "", "namespace", "", "id", "title", "content", "attachments", "", "Lcom/google/android/appfunctions/schema/common/v1/types/Attachment;", "folderId", "externalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getContent", "getAttachments", "()Ljava/util/List;", "getFolderId", "getExternalId", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreateNoteParams {

    @Document.DocumentProperty
    @NotNull
    private final List<Attachment> attachments;

    @Document.StringProperty
    @Nullable
    private final String content;

    @Document.StringProperty
    @Nullable
    private final String externalId;

    @Document.StringProperty
    @Nullable
    private final String folderId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String title;

    public CreateNoteParams(@NotNull String namespace, @NotNull String id, @NotNull String title, @Nullable String str, @NotNull List<Attachment> attachments, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        this.namespace = namespace;
        this.id = id;
        this.title = title;
        this.content = str;
        this.attachments = attachments;
        this.folderId = str2;
        this.externalId = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreateNoteParams)) {
            return false;
        }
        CreateNoteParams createNoteParams = (CreateNoteParams) other;
        return Intrinsics.areEqual(this.title, createNoteParams.title) && Intrinsics.areEqual(this.content, createNoteParams.content) && Intrinsics.areEqual(this.attachments, createNoteParams.attachments) && Intrinsics.areEqual(this.folderId, createNoteParams.folderId) && Intrinsics.areEqual(this.externalId, createNoteParams.externalId);
    }

    @NotNull
    public final List<Attachment> getAttachments() {
        return this.attachments;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @Nullable
    public final String getFolderId() {
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
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.title, this.content, this.attachments, this.folderId, this.externalId);
    }

    public /* synthetic */ CreateNoteParams(String str, String str2, String str3, String str4, List list, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
    }
}
