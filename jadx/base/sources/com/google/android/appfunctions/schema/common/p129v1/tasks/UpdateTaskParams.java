package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetBooleanNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetDateTimeNullableField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateTaskParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u0006%"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/tasks/UpdateTaskParams;", "", "namespace", "", "id", "taskId", "title", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "description", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "completed", "Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;", "dateTime", "Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeNullableField;", "allDay", "recurrenceSchedule", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getTaskId", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getDescription", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getCompleted", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetBooleanNullableField;", "getDateTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeNullableField;", "getAllDay", "getRecurrenceSchedule", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateTaskParams {

    @Document.DocumentProperty
    @Nullable
    private final SetBooleanNullableField allDay;

    @Document.DocumentProperty
    @Nullable
    private final SetBooleanNullableField completed;

    @Document.DocumentProperty
    @Nullable
    private final SetDateTimeNullableField dateTime;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField description;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField recurrenceSchedule;

    @Document.StringProperty(required = true)
    @NotNull
    private final String taskId;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField title;

    public UpdateTaskParams(@NotNull String namespace, @NotNull String id, @NotNull String taskId, @Nullable SetStringField setStringField, @Nullable SetStringNullableField setStringNullableField, @Nullable SetBooleanNullableField setBooleanNullableField, @Nullable SetDateTimeNullableField setDateTimeNullableField, @Nullable SetBooleanNullableField setBooleanNullableField2, @Nullable SetStringNullableField setStringNullableField2) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.namespace = namespace;
        this.id = id;
        this.taskId = taskId;
        this.title = setStringField;
        this.description = setStringNullableField;
        this.completed = setBooleanNullableField;
        this.dateTime = setDateTimeNullableField;
        this.allDay = setBooleanNullableField2;
        this.recurrenceSchedule = setStringNullableField2;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateTaskParams)) {
            return false;
        }
        UpdateTaskParams updateTaskParams = (UpdateTaskParams) other;
        return Intrinsics.areEqual(this.taskId, updateTaskParams.taskId) && Intrinsics.areEqual(this.title, updateTaskParams.title) && Intrinsics.areEqual(this.description, updateTaskParams.description) && Intrinsics.areEqual(this.completed, updateTaskParams.completed) && Intrinsics.areEqual(this.dateTime, updateTaskParams.dateTime) && Intrinsics.areEqual(this.allDay, updateTaskParams.allDay) && Intrinsics.areEqual(this.recurrenceSchedule, updateTaskParams.recurrenceSchedule);
    }

    @Nullable
    public final SetBooleanNullableField getAllDay() {
        return this.allDay;
    }

    @Nullable
    public final SetBooleanNullableField getCompleted() {
        return this.completed;
    }

    @Nullable
    public final SetDateTimeNullableField getDateTime() {
        return this.dateTime;
    }

    @Nullable
    public final SetStringNullableField getDescription() {
        return this.description;
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
    public final SetStringNullableField getRecurrenceSchedule() {
        return this.recurrenceSchedule;
    }

    @NotNull
    public final String getTaskId() {
        return this.taskId;
    }

    @Nullable
    public final SetStringField getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.taskId, this.title, this.description, this.completed, this.dateTime, this.allDay, this.recurrenceSchedule);
    }

    public /* synthetic */ UpdateTaskParams(String str, String str2, String str3, SetStringField setStringField, SetStringNullableField setStringNullableField, SetBooleanNullableField setBooleanNullableField, SetDateTimeNullableField setDateTimeNullableField, SetBooleanNullableField setBooleanNullableField2, SetStringNullableField setStringNullableField2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setStringNullableField, (i & 32) != 0 ? null : setBooleanNullableField, (i & 64) != 0 ? null : setDateTimeNullableField, (i & 128) != 0 ? null : setBooleanNullableField2, (i & 256) != 0 ? null : setStringNullableField2);
    }
}
