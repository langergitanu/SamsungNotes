package com.google.android.appfunctions.schema.common.p129v1.tasks;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.DateTime;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Task.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006!"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/tasks/Task;", "", "namespace", "", "id", "title", "description", "completed", "", "taskCategoryId", "dateTime", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "allDay", "recurrenceSchedule", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;Ljava/lang/Boolean;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", DynamicActionBarProvider.METHOD_GET_DATA, "getDescription", "getCompleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTaskCategoryId", "getDateTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "getAllDay", "getRecurrenceSchedule", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Task {

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

    public Task(@NotNull String namespace, @NotNull String id, @NotNull String title, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable DateTime dateTime, @Nullable Boolean bool2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.namespace = namespace;
        this.id = id;
        this.title = title;
        this.description = str;
        this.completed = bool;
        this.taskCategoryId = str2;
        this.dateTime = dateTime;
        this.allDay = bool2;
        this.recurrenceSchedule = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Task)) {
            return false;
        }
        Task task = (Task) other;
        return Intrinsics.areEqual(this.id, task.id) && Intrinsics.areEqual(this.title, task.title) && Intrinsics.areEqual(this.description, task.description) && Intrinsics.areEqual(this.completed, task.completed) && Intrinsics.areEqual(this.taskCategoryId, task.taskCategoryId) && Intrinsics.areEqual(this.dateTime, task.dateTime) && Intrinsics.areEqual(this.allDay, task.allDay) && Intrinsics.areEqual(this.recurrenceSchedule, task.recurrenceSchedule);
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
        return Objects.hash(this.id, this.title, this.description, this.completed, this.taskCategoryId, this.dateTime, this.allDay, this.recurrenceSchedule);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Task(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.Boolean r6, java.lang.String r7, com.google.android.appfunctions.schema.common.p129v1.types.DateTime r8, java.lang.Boolean r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r1 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r12 = r11 & 8
            r0 = 0
            if (r12 == 0) goto Lc
            r5 = r0
        Lc:
            r12 = r11 & 16
            if (r12 == 0) goto L11
            r6 = r0
        L11:
            r12 = r11 & 32
            if (r12 == 0) goto L16
            r7 = r0
        L16:
            r12 = r11 & 64
            if (r12 == 0) goto L1b
            r8 = r0
        L1b:
            r12 = r11 & 128(0x80, float:1.8E-43)
            if (r12 == 0) goto L20
            r9 = r0
        L20:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L2f
            r12 = r0
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L39
        L2f:
            r12 = r10
            r11 = r9
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L39:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.tasks.Task.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, com.google.android.appfunctions.schema.common.v1.types.DateTime, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
