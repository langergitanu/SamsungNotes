package com.google.android.appfunctions.schema.common.p129v1.notes;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Attachment;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Note.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/notes/Note;", "", "namespace", "", "id", "title", "content", "attachments", "", "Lcom/google/android/appfunctions/schema/common/v1/types/Attachment;", "folderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getContent", "getAttachments", "()Ljava/util/List;", "getFolderId", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Note {

    @Document.DocumentProperty
    @NotNull
    private final List<Attachment> attachments;

    @Document.StringProperty
    @Nullable
    private final String content;

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

    public Note(@NotNull String namespace, @NotNull String id, @NotNull String title, @Nullable String str, @NotNull List<Attachment> attachments, @Nullable String str2) {
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
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Note)) {
            return false;
        }
        Note note = (Note) other;
        return Intrinsics.areEqual(this.id, note.id) && Intrinsics.areEqual(this.title, note.title) && Intrinsics.areEqual(this.content, note.content) && Intrinsics.areEqual(this.attachments, note.attachments) && Intrinsics.areEqual(this.folderId, note.folderId);
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
        return Objects.hash(this.id, this.title, this.content, this.attachments, this.folderId);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Note(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.List r6, java.lang.String r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 8
            r0 = 0
            if (r9 == 0) goto Lc
            r5 = r0
        Lc:
            r9 = r8 & 16
            if (r9 == 0) goto L14
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L14:
            r8 = r8 & 32
            if (r8 == 0) goto L20
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L27
        L20:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L27:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.notes.Note.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
