package com.google.android.appfunctions.schema.common.p129v1.browser;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetUriField;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateBookmarkParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/browser/UpdateBookmarkParams;", "", "namespace", "", "id", "bookmarkId", "name", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "url", "Lcom/google/android/appfunctions/schema/common/v1/types/SetUriField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetUriField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getBookmarkId", "getName", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getUrl", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetUriField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateBookmarkParams {

    @Document.StringProperty(required = true)
    @NotNull
    private final String bookmarkId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField name;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final SetUriField url;

    public UpdateBookmarkParams(@NotNull String namespace, @NotNull String id, @NotNull String bookmarkId, @Nullable SetStringField setStringField, @Nullable SetUriField setUriField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(bookmarkId, "bookmarkId");
        this.namespace = namespace;
        this.id = id;
        this.bookmarkId = bookmarkId;
        this.name = setStringField;
        this.url = setUriField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateBookmarkParams)) {
            return false;
        }
        UpdateBookmarkParams updateBookmarkParams = (UpdateBookmarkParams) other;
        return Intrinsics.areEqual(this.bookmarkId, updateBookmarkParams.bookmarkId) && Intrinsics.areEqual(this.name, updateBookmarkParams.name) && Intrinsics.areEqual(this.url, updateBookmarkParams.url);
    }

    @NotNull
    public final String getBookmarkId() {
        return this.bookmarkId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SetStringField getName() {
        return this.name;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final SetUriField getUrl() {
        return this.url;
    }

    public int hashCode() {
        return Objects.hash(this.bookmarkId, this.name, this.url);
    }

    public /* synthetic */ UpdateBookmarkParams(String str, String str2, String str3, SetStringField setStringField, SetUriField setUriField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setUriField);
    }
}
