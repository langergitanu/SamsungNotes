package com.google.android.appfunctions.schema.common.p129v1.photos;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.scsp.common.Header;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__FindMediaItemsParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\u000eH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/photos/FindMediaItemsParams;", "", "namespace", "", "id", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "query", Header.LOCATION, "starred", "", "albumId", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getQuery", "getLocation", "getStarred", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAlbumId", "getMaxCount", "()I", "equals", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindMediaItemsParams {

    @Document.StringProperty
    @Nullable
    private final String albumId;

    @Document.DocumentProperty
    @Nullable
    private final DateTime endTime;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String location;

    @Document.LongProperty(required = true)
    private final int maxCount;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String query;

    @Document.BooleanProperty
    @Nullable
    private final Boolean starred;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startTime;

    public FindMediaItemsParams(@NotNull String namespace, @NotNull String id, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.query = str;
        this.location = str2;
        this.starred = bool;
        this.albumId = str3;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindMediaItemsParams)) {
            return false;
        }
        FindMediaItemsParams findMediaItemsParams = (FindMediaItemsParams) other;
        return Intrinsics.areEqual(this.startTime, findMediaItemsParams.startTime) && Intrinsics.areEqual(this.endTime, findMediaItemsParams.endTime) && Intrinsics.areEqual(this.query, findMediaItemsParams.query) && Intrinsics.areEqual(this.location, findMediaItemsParams.location) && Intrinsics.areEqual(this.starred, findMediaItemsParams.starred) && Intrinsics.areEqual(this.albumId, findMediaItemsParams.albumId) && this.maxCount == findMediaItemsParams.maxCount;
    }

    @Nullable
    public final String getAlbumId() {
        return this.albumId;
    }

    @Nullable
    public final DateTime getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final Boolean getStarred() {
        return this.starred;
    }

    @Nullable
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.startTime, this.endTime, this.query, this.location, this.starred, this.albumId, Integer.valueOf(this.maxCount));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FindMediaItemsParams(String str, String str2, DateTime dateTime, DateTime dateTime2, String str3, String str4, Boolean bool, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        String str6;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        dateTime = (i2 & 4) != 0 ? null : dateTime;
        dateTime2 = (i2 & 8) != 0 ? null : dateTime2;
        str3 = (i2 & 16) != 0 ? null : str3;
        str4 = (i2 & 32) != 0 ? null : str4;
        bool = (i2 & 64) != 0 ? null : bool;
        if ((i2 & 128) != 0) {
            i4 = i;
            str6 = null;
        } else {
            i4 = i;
            str6 = str5;
        }
        this(str, str2, dateTime, dateTime2, str3, str4, bool, str6, i4);
    }
}
