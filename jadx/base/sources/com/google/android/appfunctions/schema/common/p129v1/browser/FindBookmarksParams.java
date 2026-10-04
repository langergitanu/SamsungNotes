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
@Document(name = C$$__AppSearch__FindBookmarksParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/browser/FindBookmarksParams;", "", "namespace", "", "id", "query", "startDate", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endDate", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getQuery", "getStartDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndDate", "getMaxCount", "()I", "equals", "", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindBookmarksParams {

    @Document.DocumentProperty
    @Nullable
    private final DateTime endDate;

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
    private final DateTime startDate;

    public FindBookmarksParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.query = str;
        this.startDate = dateTime;
        this.endDate = dateTime2;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindBookmarksParams)) {
            return false;
        }
        FindBookmarksParams findBookmarksParams = (FindBookmarksParams) other;
        return Intrinsics.areEqual(this.query, findBookmarksParams.query) && Intrinsics.areEqual(this.startDate, findBookmarksParams.startDate) && Intrinsics.areEqual(this.endDate, findBookmarksParams.endDate) && this.maxCount == findBookmarksParams.maxCount;
    }

    @Nullable
    public final DateTime getEndDate() {
        return this.endDate;
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
    public final DateTime getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        return Objects.hash(this.query, this.startDate, this.endDate, Integer.valueOf(this.maxCount));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FindBookmarksParams(String str, String str2, String str3, DateTime dateTime, DateTime dateTime2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        DateTime dateTime3;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        str3 = (i2 & 4) != 0 ? null : str3;
        dateTime = (i2 & 8) != 0 ? null : dateTime;
        if ((i2 & 16) != 0) {
            i4 = i;
            dateTime3 = null;
        } else {
            i4 = i;
            dateTime3 = dateTime2;
        }
        this(str, str2, str3, dateTime, dateTime3, i4);
    }
}
