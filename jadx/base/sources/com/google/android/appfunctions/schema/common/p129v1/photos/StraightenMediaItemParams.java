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
@Document(name = C$$__AppSearch__StraightenMediaItemParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/photos/StraightenMediaItemParams;", "", "namespace", "", "id", "mediaItemId", "mediaItemUri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "autoStraighten", "", "straightenDegrees", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Ljava/lang/Boolean;Ljava/lang/Double;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getMediaItemId", "getMediaItemUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getAutoStraighten", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStraightenDegrees", "()Ljava/lang/Double;", "Ljava/lang/Double;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class StraightenMediaItemParams {

    @Document.BooleanProperty
    @Nullable
    private final Boolean autoStraighten;

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

    @Document.DoubleProperty
    @Nullable
    private final Double straightenDegrees;

    public StraightenMediaItemParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof StraightenMediaItemParams)) {
            return false;
        }
        StraightenMediaItemParams straightenMediaItemParams = (StraightenMediaItemParams) other;
        return Intrinsics.areEqual(this.mediaItemId, straightenMediaItemParams.mediaItemId) && Intrinsics.areEqual(this.mediaItemUri, straightenMediaItemParams.mediaItemUri) && Intrinsics.areEqual(this.autoStraighten, straightenMediaItemParams.autoStraighten) && Intrinsics.areEqual(this.straightenDegrees, straightenMediaItemParams.straightenDegrees);
    }

    @Nullable
    public final Boolean getAutoStraighten() {
        return this.autoStraighten;
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

    @Nullable
    public final Double getStraightenDegrees() {
        return this.straightenDegrees;
    }

    public int hashCode() {
        return Objects.hash(this.mediaItemId, this.mediaItemUri, this.autoStraighten, this.straightenDegrees);
    }

    public StraightenMediaItemParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable Uri uri, @Nullable Boolean bool, @Nullable Double d) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.mediaItemId = str;
        this.mediaItemUri = uri;
        this.autoStraighten = bool;
        this.straightenDegrees = d;
    }

    public /* synthetic */ StraightenMediaItemParams(String str, String str2, String str3, Uri uri, Boolean bool, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : uri, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : d);
    }
}
