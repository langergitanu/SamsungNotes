package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanNullableField;
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
@Document(name = C$$__AppSearch__UpdateMediaItemParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/photos/UpdateMediaItemParams;", "", "namespace", "", "id", "mediaItemId", "title", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "starred", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;", "albumId", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getMediaItemId", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getStarred", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;", "getAlbumId", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateMediaItemParams {

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField albumId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty(required = true)
    @NotNull
    private final String mediaItemId;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final SetBooleanNullableField starred;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField title;

    public UpdateMediaItemParams(@NotNull String namespace, @NotNull String id, @NotNull String mediaItemId, @Nullable SetStringField setStringField, @Nullable SetBooleanNullableField setBooleanNullableField, @Nullable SetStringNullableField setStringNullableField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(mediaItemId, "mediaItemId");
        this.namespace = namespace;
        this.id = id;
        this.mediaItemId = mediaItemId;
        this.title = setStringField;
        this.starred = setBooleanNullableField;
        this.albumId = setStringNullableField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateMediaItemParams)) {
            return false;
        }
        UpdateMediaItemParams updateMediaItemParams = (UpdateMediaItemParams) other;
        return Intrinsics.areEqual(this.mediaItemId, updateMediaItemParams.mediaItemId) && Intrinsics.areEqual(this.title, updateMediaItemParams.title) && Intrinsics.areEqual(this.starred, updateMediaItemParams.starred) && Intrinsics.areEqual(this.albumId, updateMediaItemParams.albumId);
    }

    @Nullable
    public final SetStringNullableField getAlbumId() {
        return this.albumId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getMediaItemId() {
        return this.mediaItemId;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final SetBooleanNullableField getStarred() {
        return this.starred;
    }

    @Nullable
    public final SetStringField getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.mediaItemId, this.title, this.starred, this.albumId);
    }

    public /* synthetic */ UpdateMediaItemParams(String str, String str2, String str3, SetStringField setStringField, SetBooleanNullableField setBooleanNullableField, SetStringNullableField setStringNullableField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setBooleanNullableField, (i & 32) != 0 ? null : setStringNullableField);
    }
}
