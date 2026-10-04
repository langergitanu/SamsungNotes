package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__SetMediaItemFilterParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0017"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/photos/SetMediaItemFilterParams;", "", "namespace", "", "id", "mediaItemId", "mediaItemUri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "filter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getMediaItemId", "getMediaItemUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getFilter", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SetMediaItemFilterParams {

    @Document.StringProperty(required = true)
    @NotNull
    private final String filter;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String mediaItemId;

    @Document.DocumentProperty
    @Nullable
    private final Uri mediaItemUri;

    @Document.Namespace
    @NotNull
    private final String namespace;

    public SetMediaItemFilterParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable Uri uri, @NotNull String filter) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.namespace = namespace;
        this.id = id;
        this.mediaItemId = str;
        this.mediaItemUri = uri;
        this.filter = filter;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof SetMediaItemFilterParams)) {
            return false;
        }
        SetMediaItemFilterParams setMediaItemFilterParams = (SetMediaItemFilterParams) other;
        return Intrinsics.areEqual(this.mediaItemId, setMediaItemFilterParams.mediaItemId) && Intrinsics.areEqual(this.mediaItemUri, setMediaItemFilterParams.mediaItemUri) && Intrinsics.areEqual(this.filter, setMediaItemFilterParams.filter);
    }

    @NotNull
    public final String getFilter() {
        return this.filter;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMediaItemId() {
        return this.mediaItemId;
    }

    @Nullable
    public final Uri getMediaItemUri() {
        return this.mediaItemUri;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return Objects.hash(this.mediaItemId, this.mediaItemUri, this.filter);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SetMediaItemFilterParams(String str, String str2, String str3, Uri uri, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str5;
        Uri uri2;
        str = (i & 1) != 0 ? "" : str;
        str2 = (i & 2) != 0 ? "" : str2;
        str3 = (i & 4) != 0 ? null : str3;
        if ((i & 8) != 0) {
            str5 = str4;
            uri2 = null;
        } else {
            str5 = str4;
            uri2 = uri;
        }
        this(str, str2, str3, uri2, str5);
    }
}
