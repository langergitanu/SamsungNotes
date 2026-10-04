package com.google.android.appfunctions.schema.common.p129v1.browser;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__GetHistoriesParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/browser/GetHistoriesParams;", "", "namespace", "", "id", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "query", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getQuery", "getMaxCount", "()I", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class GetHistoriesParams {

    @Document.DocumentProperty
    @Nullable
    private final DateTime endTime;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.LongProperty(required = true)
    private final int maxCount;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String query;

    @Document.DocumentProperty
    @Nullable
    private final DateTime startTime;

    public GetHistoriesParams(@NotNull String namespace, @NotNull String id, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.query = str;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof GetHistoriesParams)) {
            return false;
        }
        GetHistoriesParams getHistoriesParams = (GetHistoriesParams) other;
        return Intrinsics.areEqual(this.startTime, getHistoriesParams.startTime) && Intrinsics.areEqual(this.endTime, getHistoriesParams.endTime) && Intrinsics.areEqual(this.query, getHistoriesParams.query) && this.maxCount == getHistoriesParams.maxCount;
    }

    @Nullable
    public final DateTime getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final String getId() {
        return this.id;
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
    public final DateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return Objects.hash(this.startTime, this.endTime, this.query, Integer.valueOf(this.maxCount));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GetHistoriesParams(String str, String str2, DateTime dateTime, DateTime dateTime2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        String str4;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        dateTime = (i2 & 4) != 0 ? null : dateTime;
        dateTime2 = (i2 & 8) != 0 ? null : dateTime2;
        if ((i2 & 16) != 0) {
            i4 = i;
            str4 = null;
        } else {
            i4 = i;
            str4 = str3;
        }
        this(str, str2, dateTime, dateTime2, str4, i4);
    }
}
