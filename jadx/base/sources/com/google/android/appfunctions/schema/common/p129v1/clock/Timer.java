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
@Document(name = C$$__AppSearch__Timer.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\f\u0010\u001c¨\u0006\""}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/Timer;", "", "namespace", "", "id", "label", "originalDurationMillis", "", "durationMillis", "timerState", "remainingDurationMillis", "expireTimeEpochMillis", "isFiring", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;JLjava/lang/Long;Ljava/lang/Boolean;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getLabel", "getOriginalDurationMillis", "()J", "getDurationMillis", "getTimerState", "getRemainingDurationMillis", "getExpireTimeEpochMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "equals", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Timer {

    @Document.LongProperty(required = true)
    private final long durationMillis;

    @Document.LongProperty
    @Nullable
    private final Long expireTimeEpochMillis;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.BooleanProperty
    @Nullable
    private final Boolean isFiring;

    @Document.StringProperty
    @Nullable
    private final String label;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty(required = true)
    private final long originalDurationMillis;

    @Document.LongProperty(required = true)
    private final long remainingDurationMillis;

    @Document.StringProperty(required = true)
    @NotNull
    private final String timerState;

    public Timer(@NotNull String namespace, @NotNull String id, @Nullable String str, long j, long j2, @NotNull String timerState, long j3, @Nullable Long l, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timerState, "timerState");
        this.namespace = namespace;
        this.id = id;
        this.label = str;
        this.originalDurationMillis = j;
        this.durationMillis = j2;
        this.timerState = timerState;
        this.remainingDurationMillis = j3;
        this.expireTimeEpochMillis = l;
        this.isFiring = bool;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Timer)) {
            return false;
        }
        Timer timer = (Timer) other;
        return Intrinsics.areEqual(this.id, timer.id) && Intrinsics.areEqual(this.label, timer.label) && this.originalDurationMillis == timer.originalDurationMillis && this.durationMillis == timer.durationMillis && Intrinsics.areEqual(this.timerState, timer.timerState) && this.remainingDurationMillis == timer.remainingDurationMillis && Intrinsics.areEqual(this.expireTimeEpochMillis, timer.expireTimeEpochMillis) && Intrinsics.areEqual(this.isFiring, timer.isFiring);
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    @Nullable
    public final Long getExpireTimeEpochMillis() {
        return this.expireTimeEpochMillis;
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

    public final long getRemainingDurationMillis() {
        return this.remainingDurationMillis;
    }

    @NotNull
    public final String getTimerState() {
        return this.timerState;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.label, Long.valueOf(this.originalDurationMillis), Long.valueOf(this.durationMillis), this.timerState, Long.valueOf(this.remainingDurationMillis), this.expireTimeEpochMillis, this.isFiring);
    }

    @Nullable
    /* JADX INFO: renamed from: isFiring, reason: from getter */
    public final Boolean getIsFiring() {
        return this.isFiring;
    }

    public /* synthetic */ Timer(String str, String str2, String str3, long j, long j2, String str4, long j3, Long l, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, (i & 4) != 0 ? null : str3, j, j2, str4, j3, (i & 128) != 0 ? null : l, (i & 256) != 0 ? null : bool);
    }
}
