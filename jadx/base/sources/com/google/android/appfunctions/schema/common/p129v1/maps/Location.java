package com.google.android.appfunctions.schema.common.p129v1.maps;

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
@Document(name = C$$__AppSearch__Location.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/Location;", "", "namespace", "", "id", "placeUri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "latLng", "Lcom/google/android/appfunctions/schema/common/v1/maps/LatLng;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Lcom/google/android/appfunctions/schema/common/v1/maps/LatLng;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getPlaceUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getLatLng", "()Lcom/google/android/appfunctions/schema/common/v1/maps/LatLng;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Location {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final LatLng latLng;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final Uri placeUri;

    public Location() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Location)) {
            return false;
        }
        Location location = (Location) other;
        return Intrinsics.areEqual(this.placeUri, location.placeUri) && Intrinsics.areEqual(this.latLng, location.latLng);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final LatLng getLatLng() {
        return this.latLng;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final Uri getPlaceUri() {
        return this.placeUri;
    }

    public int hashCode() {
        return Objects.hash(this.placeUri, this.latLng);
    }

    public Location(@NotNull String namespace, @NotNull String id, @Nullable Uri uri, @Nullable LatLng latLng) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.placeUri = uri;
        this.latLng = latLng;
    }

    public /* synthetic */ Location(String str, String str2, Uri uri, LatLng latLng, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : uri, (i & 8) != 0 ? null : latLng);
    }
}
