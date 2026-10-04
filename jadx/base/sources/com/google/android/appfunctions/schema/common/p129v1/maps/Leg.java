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
@Document(name = C$$__AppSearch__Leg.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/Leg;", "", "namespace", "", "id", "durationInSecond", "", "durationDisplayString", "distanceInMeter", "distanceDisplayString", "startAddress", "endAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getDurationInSecond", "()J", "getDurationDisplayString", "getDistanceInMeter", "getDistanceDisplayString", "getStartAddress", "getEndAddress", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Leg {

    @Document.StringProperty
    @Nullable
    private final String distanceDisplayString;

    @Document.LongProperty(required = true)
    private final long distanceInMeter;

    @Document.StringProperty
    @Nullable
    private final String durationDisplayString;

    @Document.LongProperty(required = true)
    private final long durationInSecond;

    @Document.StringProperty
    @Nullable
    private final String endAddress;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String startAddress;

    public Leg(@NotNull String namespace, @NotNull String id, long j, @Nullable String str, long j2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.durationInSecond = j;
        this.durationDisplayString = str;
        this.distanceInMeter = j2;
        this.distanceDisplayString = str2;
        this.startAddress = str3;
        this.endAddress = str4;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Leg)) {
            return false;
        }
        Leg leg = (Leg) other;
        return this.durationInSecond == leg.durationInSecond && Intrinsics.areEqual(this.durationDisplayString, leg.durationDisplayString) && this.distanceInMeter == leg.distanceInMeter && Intrinsics.areEqual(this.distanceDisplayString, leg.distanceDisplayString) && Intrinsics.areEqual(this.startAddress, leg.startAddress) && Intrinsics.areEqual(this.endAddress, leg.endAddress);
    }

    @Nullable
    public final String getDistanceDisplayString() {
        return this.distanceDisplayString;
    }

    public final long getDistanceInMeter() {
        return this.distanceInMeter;
    }

    @Nullable
    public final String getDurationDisplayString() {
        return this.durationDisplayString;
    }

    public final long getDurationInSecond() {
        return this.durationInSecond;
    }

    @Nullable
    public final String getEndAddress() {
        return this.endAddress;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getStartAddress() {
        return this.startAddress;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.durationInSecond), this.durationDisplayString, Long.valueOf(this.distanceInMeter), this.distanceDisplayString, this.startAddress, this.endAddress);
    }

    public /* synthetic */ Leg(String str, String str2, long j, String str3, long j2, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, j, (i & 8) != 0 ? null : str3, j2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6);
    }
}
