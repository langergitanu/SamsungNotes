package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appsearch.annotation.Document;
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
@Document(name = C$$__AppSearch__FindDirectionsParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u001b"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/FindDirectionsParams;", "", "namespace", "", "id", "origin", "Lcom/google/android/appfunctions/schema/common/v1/maps/Location;", "destinations", "", "transportationType", "avoidTypes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/maps/Location;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getOrigin", "()Lcom/google/android/appfunctions/schema/common/v1/maps/Location;", "getDestinations", "()Ljava/util/List;", "getTransportationType", "getAvoidTypes", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindDirectionsParams {

    @Document.StringProperty
    @NotNull
    private final List<String> avoidTypes;

    @Document.DocumentProperty
    @NotNull
    private final List<Location> destinations;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Location origin;

    @Document.StringProperty
    @Nullable
    private final String transportationType;

    public FindDirectionsParams(@NotNull String namespace, @NotNull String id, @NotNull Location origin, @NotNull List<Location> destinations, @Nullable String str, @NotNull List<String> avoidTypes) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(destinations, "destinations");
        Intrinsics.checkNotNullParameter(avoidTypes, "avoidTypes");
        this.namespace = namespace;
        this.id = id;
        this.origin = origin;
        this.destinations = destinations;
        this.transportationType = str;
        this.avoidTypes = avoidTypes;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindDirectionsParams)) {
            return false;
        }
        FindDirectionsParams findDirectionsParams = (FindDirectionsParams) other;
        return Intrinsics.areEqual(this.origin, findDirectionsParams.origin) && Intrinsics.areEqual(this.destinations, findDirectionsParams.destinations) && Intrinsics.areEqual(this.transportationType, findDirectionsParams.transportationType) && Intrinsics.areEqual(this.avoidTypes, findDirectionsParams.avoidTypes);
    }

    @NotNull
    public final List<String> getAvoidTypes() {
        return this.avoidTypes;
    }

    @NotNull
    public final List<Location> getDestinations() {
        return this.destinations;
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
    public final Location getOrigin() {
        return this.origin;
    }

    @Nullable
    public final String getTransportationType() {
        return this.transportationType;
    }

    public int hashCode() {
        return Objects.hash(this.origin, this.destinations, this.transportationType, this.avoidTypes);
    }

    public /* synthetic */ FindDirectionsParams(String str, String str2, Location location, List list, String str3, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, location, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
