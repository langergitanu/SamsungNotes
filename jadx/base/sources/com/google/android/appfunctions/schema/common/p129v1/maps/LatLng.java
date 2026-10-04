package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__LatLng.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0015"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/LatLng;", "", "namespace", "", "id", "latitude", "", "longitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;DD)V", "getNamespace", "()Ljava/lang/String;", "getId", "getLatitude", "()D", "getLongitude", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class LatLng {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DoubleProperty(required = true)
    private final double latitude;

    @Document.DoubleProperty(required = true)
    private final double longitude;

    @Document.Namespace
    @NotNull
    private final String namespace;

    public LatLng(@NotNull String namespace, @NotNull String id, double d, double d2) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.latitude = d;
        this.longitude = d2;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) other;
        return this.latitude == latLng.latitude && this.longitude == latLng.longitude;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.latitude), Double.valueOf(this.longitude));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LatLng(String str, String str2, double d, double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        double d3;
        double d4;
        String str3;
        str = (i & 1) != 0 ? "" : str;
        if ((i & 2) != 0) {
            d3 = d2;
            d4 = d;
            str3 = "";
        } else {
            d3 = d2;
            d4 = d;
            str3 = str2;
        }
        this(str, str3, d4, d3);
    }
}
