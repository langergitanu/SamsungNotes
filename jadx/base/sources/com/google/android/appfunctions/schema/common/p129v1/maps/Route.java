package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.Uri;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
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
@Document(name = C$$__AppSearch__Route.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001e"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/Route;", "", "namespace", "", "id", "legs", "", "Lcom/google/android/appfunctions/schema/common/v1/maps/Leg;", DBSchema.DocumentCover.SUMMARY, "directionUri", "Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "navigationUri", "directionImageUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;Lcom/google/android/appfunctions/schema/common/v1/types/Uri;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getLegs", "()Ljava/util/List;", "getSummary", "getDirectionUri", "()Lcom/google/android/appfunctions/schema/common/v1/types/Uri;", "getNavigationUri", "getDirectionImageUri", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Route {

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri directionImageUri;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri directionUri;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @NotNull
    private final List<Leg> legs;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Uri navigationUri;

    @Document.StringProperty
    @Nullable
    private final String summary;

    public Route(@NotNull String namespace, @NotNull String id, @NotNull List<Leg> legs, @Nullable String str, @NotNull Uri directionUri, @NotNull Uri navigationUri, @NotNull Uri directionImageUri) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(legs, "legs");
        Intrinsics.checkNotNullParameter(directionUri, "directionUri");
        Intrinsics.checkNotNullParameter(navigationUri, "navigationUri");
        Intrinsics.checkNotNullParameter(directionImageUri, "directionImageUri");
        this.namespace = namespace;
        this.id = id;
        this.legs = legs;
        this.summary = str;
        this.directionUri = directionUri;
        this.navigationUri = navigationUri;
        this.directionImageUri = directionImageUri;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Route)) {
            return false;
        }
        Route route = (Route) other;
        return Intrinsics.areEqual(this.legs, route.legs) && Intrinsics.areEqual(this.summary, route.summary) && Intrinsics.areEqual(this.directionUri, route.directionUri) && Intrinsics.areEqual(this.navigationUri, route.navigationUri) && Intrinsics.areEqual(this.directionImageUri, route.directionImageUri);
    }

    @NotNull
    public final Uri getDirectionImageUri() {
        return this.directionImageUri;
    }

    @NotNull
    public final Uri getDirectionUri() {
        return this.directionUri;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<Leg> getLegs() {
        return this.legs;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final Uri getNavigationUri() {
        return this.navigationUri;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    public int hashCode() {
        return Objects.hash(this.legs, this.summary, this.directionUri, this.navigationUri, this.directionImageUri);
    }

    public /* synthetic */ Route(String str, String str2, List list, String str3, Uri uri, Uri uri2, Uri uri3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : str3, uri, uri2, uri3);
    }
}
