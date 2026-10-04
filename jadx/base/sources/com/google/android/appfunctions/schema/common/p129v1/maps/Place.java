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
@Document(name = C$$__AppSearch__Place.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/Place;", "", "namespace", "", "id", "uri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "name", "address", "description", "openingHours", "Lcom/google/android/appfunctions/schema/common/v1/maps/OpeningHours;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/maps/OpeningHours;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getName", "getAddress", "getDescription", "getOpeningHours", "()Lcom/google/android/appfunctions/schema/common/v1/maps/OpeningHours;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Place {

    @Document.StringProperty
    @Nullable
    private final String address;

    @Document.StringProperty
    @Nullable
    private final String description;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty(required = true)
    @NotNull
    private final String name;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final OpeningHours openingHours;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri uri;

    public Place(@NotNull String namespace, @NotNull String id, @NotNull Uri uri, @NotNull String name, @Nullable String str, @Nullable String str2, @Nullable OpeningHours openingHours) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(name, "name");
        this.namespace = namespace;
        this.id = id;
        this.uri = uri;
        this.name = name;
        this.address = str;
        this.description = str2;
        this.openingHours = openingHours;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Place)) {
            return false;
        }
        Place place = (Place) other;
        return Intrinsics.areEqual(this.uri, place.uri) && Intrinsics.areEqual(this.name, place.name) && Intrinsics.areEqual(this.address, place.address) && Intrinsics.areEqual(this.description, place.description) && Intrinsics.areEqual(this.openingHours, place.openingHours);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final OpeningHours getOpeningHours() {
        return this.openingHours;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return Objects.hash(this.uri, this.name, this.address, this.description, this.openingHours);
    }

    public /* synthetic */ Place(String str, String str2, Uri uri, String str3, String str4, String str5, OpeningHours openingHours, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, uri, str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : openingHours);
    }
}
