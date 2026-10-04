package com.google.android.appfunctions.schema.common.p129v1.tasks;

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
@Document(name = C$$__AppSearch__FindTasksParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020\rH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/tasks/FindTasksParams;", "", "namespace", "", "id", "query", "completed", "", "startTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "endTime", "taskCategoryId", "maxCount", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/String;I)V", "getNamespace", "()Ljava/lang/String;", "getId", "getQuery", "getCompleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStartTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getEndTime", "getTaskCategoryId", "getMaxCount", "()I", "equals", "other", "hashCode", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class FindTasksParams {

    @Document.BooleanProperty
    @Nullable
    private final Boolean completed;

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

    @Document.StringProperty
    @Nullable
    private final String taskCategoryId;

    public FindTasksParams(@NotNull String namespace, @NotNull String id, @Nullable String str, @Nullable Boolean bool, @Nullable DateTime dateTime, @Nullable DateTime dateTime2, @Nullable String str2, int i) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.query = str;
        this.completed = bool;
        this.startTime = dateTime;
        this.endTime = dateTime2;
        this.taskCategoryId = str2;
        this.maxCount = i;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof FindTasksParams)) {
            return false;
        }
        FindTasksParams findTasksParams = (FindTasksParams) other;
        return Intrinsics.areEqual(this.query, findTasksParams.query) && Intrinsics.areEqual(this.completed, findTasksParams.completed) && Intrinsics.areEqual(this.startTime, findTasksParams.startTime) && Intrinsics.areEqual(this.endTime, findTasksParams.endTime) && Intrinsics.areEqual(this.taskCategoryId, findTasksParams.taskCategoryId) && this.maxCount == findTasksParams.maxCount;
    }

    @Nullable
    public final Boolean getCompleted() {
        return this.completed;
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

    @Nullable
    public final String getTaskCategoryId() {
        return this.taskCategoryId;
    }

    public int hashCode() {
        return Objects.hash(this.query, this.completed, this.startTime, this.endTime, this.taskCategoryId, Integer.valueOf(this.maxCount));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FindTasksParams(String str, String str2, String str3, Boolean bool, DateTime dateTime, DateTime dateTime2, String str4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        String str5;
        str = (i2 & 1) != 0 ? "" : str;
        str2 = (i2 & 2) != 0 ? "" : str2;
        str3 = (i2 & 4) != 0 ? null : str3;
        bool = (i2 & 8) != 0 ? null : bool;
        dateTime = (i2 & 16) != 0 ? null : dateTime;
        dateTime2 = (i2 & 32) != 0 ? null : dateTime2;
        if ((i2 & 64) != 0) {
            i4 = i;
            str5 = null;
        } else {
            i4 = i;
            str5 = str4;
        }
        this(str, str2, str3, bool, dateTime, dateTime2, str5, i4);
    }
}
