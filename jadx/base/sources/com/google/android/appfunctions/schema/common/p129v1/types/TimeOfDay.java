package com.google.android.appfunctions.schema.common.p129v1.types;

import androidx.appsearch.annotation.Document;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__TimeOfDay.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0019"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "", "namespace", "", "id", "hours", "", "minutes", "seconds", "nanos", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIII)V", "getNamespace", "()Ljava/lang/String;", "getId", "getHours", "()I", "getMinutes", "getSeconds", "getNanos", "equals", "", "other", "hashCode", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TimeOfDay {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Document.LongProperty(required = true)
    private final int hours;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.LongProperty(required = true)
    private final int minutes;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.LongProperty(required = true)
    private final int nanos;

    @Document.LongProperty(required = true)
    private final int seconds;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay$Companion;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "<init>", "()V", "setField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetTimeOfDayField;", "value", "setNullableField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetTimeOfDayNullableField;", "setListField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetTimeOfDayListField;", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements SetFieldCompanion<TimeOfDay> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetTimeOfDayField setField(@NotNull TimeOfDay value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetTimeOfDayField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetField<List<TimeOfDay>> setListField(@NotNull List<? extends TimeOfDay> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetTimeOfDayListField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetTimeOfDayNullableField setNullableField(@Nullable TimeOfDay value) {
            return new SetTimeOfDayNullableField(null, null, value, 3, null);
        }
    }

    public TimeOfDay(@NotNull String namespace, @NotNull String id, int i, int i2, int i4, int i5) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.hours = i;
        this.minutes = i2;
        this.seconds = i4;
        this.nanos = i5;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof TimeOfDay)) {
            return false;
        }
        TimeOfDay timeOfDay = (TimeOfDay) other;
        return this.hours == timeOfDay.hours && this.minutes == timeOfDay.minutes && this.seconds == timeOfDay.seconds && this.nanos == timeOfDay.nanos;
    }

    public final int getHours() {
        return this.hours;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    public final int getNanos() {
        return this.nanos;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.hours), Integer.valueOf(this.minutes), Integer.valueOf(this.seconds), Integer.valueOf(this.nanos));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TimeOfDay(String str, String str2, int i, int i2, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        int i7;
        int i8;
        int i9;
        int i10;
        String str3;
        str = (i6 & 1) != 0 ? "" : str;
        if ((i6 & 2) != 0) {
            i7 = i5;
            i8 = i4;
            i9 = i2;
            i10 = i;
            str3 = "";
        } else {
            i7 = i5;
            i8 = i4;
            i9 = i2;
            i10 = i;
            str3 = str2;
        }
        this(str, str3, i10, i9, i8, i7);
    }
}
