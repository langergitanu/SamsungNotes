package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__CreateTaskParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001f\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006#"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/tasks/CreateTaskParams;", "", "namespace", "", "id", "title", "description", "completed", "", "dateTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "allDay", "recurrenceSchedule", "externalId", "taskCategoryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getDescription", "getCompleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDateTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getAllDay", "getRecurrenceSchedule", "getExternalId", "getTaskCategoryId", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreateTaskParams {

    @Document.BooleanProperty
    @Nullable
    private final Boolean allDay;

    @Document.BooleanProperty
    @Nullable
    private final Boolean completed;

    @Document.DocumentProperty
    @Nullable
    private final DateTime dateTime;

    @Document.StringProperty
    @Nullable
    private final String description;

    @Document.StringProperty
    @Nullable
    private final String externalId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty
    @Nullable
    private final String recurrenceSchedule;

    @Document.StringProperty
    @Nullable
    private final String taskCategoryId;

    @Document.StringProperty(required = true)
    @NotNull
    private final String title;

    public CreateTaskParams(@NotNull String namespace, @NotNull String id, @NotNull String title, @Nullable String str, @Nullable Boolean bool, @Nullable DateTime dateTime, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.namespace = namespace;
        this.id = id;
        this.title = title;
        this.description = str;
        this.completed = bool;
        this.dateTime = dateTime;
        this.allDay = bool2;
        this.recurrenceSchedule = str2;
        this.externalId = str3;
        this.taskCategoryId = str4;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreateTaskParams)) {
            return false;
        }
        CreateTaskParams createTaskParams = (CreateTaskParams) other;
        return Intrinsics.areEqual(this.title, createTaskParams.title) && Intrinsics.areEqual(this.description, createTaskParams.description) && Intrinsics.areEqual(this.completed, createTaskParams.completed) && Intrinsics.areEqual(this.dateTime, createTaskParams.dateTime) && Intrinsics.areEqual(this.allDay, createTaskParams.allDay) && Intrinsics.areEqual(this.recurrenceSchedule, createTaskParams.recurrenceSchedule) && Intrinsics.areEqual(this.externalId, createTaskParams.externalId) && Intrinsics.areEqual(this.taskCategoryId, createTaskParams.taskCategoryId);
    }

    @Nullable
    public final Boolean getAllDay() {
        return this.allDay;
    }

    @Nullable
    public final Boolean getCompleted() {
        return this.completed;
    }

    @Nullable
    public final DateTime getDateTime() {
        return this.dateTime;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
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
    public final String getRecurrenceSchedule() {
        return this.recurrenceSchedule;
    }

    @Nullable
    public final String getTaskCategoryId() {
        return this.taskCategoryId;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.title, this.description, this.completed, this.dateTime, this.allDay, this.recurrenceSchedule, this.externalId, this.taskCategoryId);
    }

    public /* synthetic */ CreateTaskParams(String str, String str2, String str3, String str4, Boolean bool, DateTime dateTime, Boolean bool2, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : dateTime, (i & 64) != 0 ? null : bool2, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6, (i & 512) != 0 ? null : str7);
    }
}
