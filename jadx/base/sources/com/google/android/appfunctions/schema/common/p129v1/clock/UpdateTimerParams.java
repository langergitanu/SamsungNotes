package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.SetLongField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringField;
import com.google.android.appfunctions.schema.common.p129v1.types.SetStringNullableField;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__UpdateTimerParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/UpdateTimerParams;", "", "namespace", "", "id", "timerId", "label", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "durationMs", "Lcom/google/android/appfunctions/schema/common/v1/types/SetLongField;", "timerState", "Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;Lcom/google/android/appfunctions/schema/common/v1/types/SetLongField;Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getTimerId", "getLabel", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringNullableField;", "getDurationMs", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetLongField;", "getTimerState", "()Lcom/google/android/appfunctions/schema/common/v1/types/SetStringField;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class UpdateTimerParams {

    @Document.DocumentProperty
    @Nullable
    private final SetLongField durationMs;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final SetStringNullableField label;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.StringProperty(required = true)
    @NotNull
    private final String timerId;

    @Document.DocumentProperty
    @Nullable
    private final SetStringField timerState;

    public UpdateTimerParams(@NotNull String namespace, @NotNull String id, @NotNull String timerId, @Nullable SetStringNullableField setStringNullableField, @Nullable SetLongField setLongField, @Nullable SetStringField setStringField) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timerId, "timerId");
        this.namespace = namespace;
        this.id = id;
        this.timerId = timerId;
        this.label = setStringNullableField;
        this.durationMs = setLongField;
        this.timerState = setStringField;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof UpdateTimerParams)) {
            return false;
        }
        UpdateTimerParams updateTimerParams = (UpdateTimerParams) other;
        return Intrinsics.areEqual(this.timerId, updateTimerParams.timerId) && Intrinsics.areEqual(this.label, updateTimerParams.label) && Intrinsics.areEqual(this.durationMs, updateTimerParams.durationMs) && Intrinsics.areEqual(this.timerState, updateTimerParams.timerState);
    }

    @Nullable
    public final SetLongField getDurationMs() {
        return this.durationMs;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final SetStringNullableField getLabel() {
        return this.label;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @NotNull
    public final String getTimerId() {
        return this.timerId;
    }

    @Nullable
    public final SetStringField getTimerState() {
        return this.timerState;
    }

    public int hashCode() {
        return Objects.hash(this.timerId, this.label, this.durationMs, this.timerState);
    }

    public /* synthetic */ UpdateTimerParams(String str, String str2, String str3, SetStringNullableField setStringNullableField, SetLongField setLongField, SetStringField setStringField, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, str3, (i & 8) != 0 ? null : setStringNullableField, (i & 16) != 0 ? null : setLongField, (i & 32) != 0 ? null : setStringField);
    }
}
