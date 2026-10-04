package com.google.android.appfunctions.schema.common.p129v1.clock;

import androidx.appsearch.annotation.Document;
import com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDay;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__Alarm.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/clock/Alarm;", "", "namespace", "", "id", "label", "time", "Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "alarmStatus", "dayPattern", "Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getLabel", "getTime", "()Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "getAlarmStatus", "getDayPattern", "()Lcom/google/android/appfunctions/schema/common/v1/clock/DayPattern;", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Alarm {

    @Document.StringProperty
    @Nullable
    private final String alarmStatus;

    @Document.DocumentProperty
    @Nullable
    private final DayPattern dayPattern;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.StringProperty
    @Nullable
    private final String label;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final TimeOfDay time;

    public Alarm(@NotNull String namespace, @NotNull String id, @Nullable String str, @NotNull TimeOfDay time, @Nullable String str2, @Nullable DayPattern dayPattern) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(time, "time");
        this.namespace = namespace;
        this.id = id;
        this.label = str;
        this.time = time;
        this.alarmStatus = str2;
        this.dayPattern = dayPattern;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof Alarm)) {
            return false;
        }
        Alarm alarm = (Alarm) other;
        return Intrinsics.areEqual(this.id, alarm.id) && Intrinsics.areEqual(this.label, alarm.label) && Intrinsics.areEqual(this.time, alarm.time) && Intrinsics.areEqual(this.alarmStatus, alarm.alarmStatus) && Intrinsics.areEqual(this.dayPattern, alarm.dayPattern);
    }

    @Nullable
    public final String getAlarmStatus() {
        return this.alarmStatus;
    }

    @Nullable
    public final DayPattern getDayPattern() {
        return this.dayPattern;
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

    @NotNull
    public final TimeOfDay getTime() {
        return this.time;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.label, this.time, this.alarmStatus, this.dayPattern);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ Alarm(java.lang.String r2, java.lang.String r3, java.lang.String r4, com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDay r5, java.lang.String r6, com.google.android.appfunctions.schema.common.p129v1.clock.DayPattern r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto Lc
            r4 = r0
        Lc:
            r9 = r8 & 16
            if (r9 == 0) goto L11
            r6 = r0
        L11:
            r8 = r8 & 32
            if (r8 == 0) goto L1d
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L24
        L1d:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L24:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.appfunctions.schema.common.p129v1.clock.Alarm.<init>(java.lang.String, java.lang.String, java.lang.String, com.google.android.appfunctions.schema.common.v1.types.TimeOfDay, java.lang.String, com.google.android.appfunctions.schema.common.v1.clock.DayPattern, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
