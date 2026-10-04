package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringListField;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateTaskCategoryParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/tasks/UpdateTaskCategoryParams;", "", "namespace", "", "id", "taskCategoryId", "title", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "taskIds", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getTaskCategoryId", DynamicActionBarProvider.METHOD_GET_DATA, "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "getTaskIds", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringListField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateTaskCategoryParams {

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String taskCategoryId;

    @Document.DocumentProperty
    @Nullable
    private final SetStringListField taskIds;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField title;

    public UpdateTaskCategoryParams(@NotNull String namespace, @NotNull String id, @NotNull String taskCategoryId, @Nullable SetStringField setStringField, @Nullable SetStringListField setStringListField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(taskCategoryId, "taskCategoryId");
        this.namespace = namespace;
        this.id = id;
        this.taskCategoryId = taskCategoryId;
        this.title = setStringField;
        this.taskIds = setStringListField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateTaskCategoryParams)) {
            return false;
        }
        UpdateTaskCategoryParams updateTaskCategoryParams = (UpdateTaskCategoryParams) other;
        return Intrinsics.areEqual(this.taskCategoryId, updateTaskCategoryParams.taskCategoryId) && Intrinsics.areEqual(this.title, updateTaskCategoryParams.title) && Intrinsics.areEqual(this.taskIds, updateTaskCategoryParams.taskIds);
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
    public final String getTaskCategoryId() {
        return this.taskCategoryId;
    }

    @Nullable
    public final SetStringListField getTaskIds() {
        return this.taskIds;
    }

    @Nullable
    public final SetStringField getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Objects.hash(this.taskCategoryId, this.title, this.taskIds);
    }

    public /* synthetic */ UpdateTaskCategoryParams(String str, String str2, String str3, SetStringField setStringField, SetStringListField setStringListField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringField, (i & 16) != 0 ? null : setStringListField);
    }
}
