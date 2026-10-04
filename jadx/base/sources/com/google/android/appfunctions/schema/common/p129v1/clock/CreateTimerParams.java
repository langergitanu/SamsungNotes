package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appsearch.annotation.Document;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__CreateTimerParams.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0019"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/CreateTimerParams;", "", "namespace", "", "id", "label", "originalDurationMillis", "", "timerState", "externalId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getLabel", "getOriginalDurationMillis", "()J", "getTimerState", "getExternalId", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class CreateTimerParams {

    @Document.StringProperty
    @Nullable
    private final String externalId;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String label;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty(required = true)
    private final long originalDurationMillis;

    @Document.StringProperty
    @Nullable
    private final String timerState;

    public CreateTimerParams(@NotNull String namespace, @NotNull String id, @Nullable String str, long j, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.label = str;
        this.originalDurationMillis = j;
        this.timerState = str2;
        this.externalId = str3;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof CreateTimerParams)) {
            return false;
        }
        CreateTimerParams createTimerParams = (CreateTimerParams) other;
        return Intrinsics.areEqual(this.label, createTimerParams.label) && this.originalDurationMillis == createTimerParams.originalDurationMillis && Intrinsics.areEqual(this.timerState, createTimerParams.timerState) && Intrinsics.areEqual(this.externalId, createTimerParams.externalId);
    }

    @Nullable
    public final String getExternalId() {
        return this.externalId;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public final long getOriginalDurationMillis() {
        return this.originalDurationMillis;
    }

    @Nullable
    public final String getTimerState() {
        return this.timerState;
    }

    public int hashCode() {
        return Objects.hash(this.label, Long.valueOf(this.originalDurationMillis), this.timerState, this.externalId);
    }

    public /* synthetic */ CreateTimerParams(String str, String str2, String str3, long j, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, j, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }
}
