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
@Document(name = C$$__AppSearch__DateTime.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "", "namespace", "", "id", "timeZone", "date", "Lcom/google/android/appfunctions/schema/common/v1/types/Date;", "timeOfDay", "Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/Date;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getTimeZone", "getDate", "()Lcom/google/android/appfunctions/schema/common/v1/types/Date;", "getTimeOfDay", "()Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDay;", "equals", "", "other", "hashCode", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class DateTime {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Document.DocumentProperty(required = true)
    @NotNull
    private final Date date;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty(required = true)
    @NotNull
    private final TimeOfDay timeOfDay;

    @Document.StringProperty(required = true)
    @NotNull
    private final String timeZone;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/types/DateTime$Companion;", "Lcom/google/android/appfunctions/schema/common/v1/types/SetFieldCompanion;", "Lcom/google/android/appfunctions/schema/common/v1/types/DateTime;", "<init>", "()V", "setField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeField;", "value", "setNullableField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeNullableField;", "setListField", "Lcom/google/android/appfunctions/schema/common/v1/types/SetDateTimeListField;", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion implements SetFieldCompanion<DateTime> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetDateTimeField setField(@NotNull DateTime value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetDateTimeField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetField<List<DateTime>> setListField(@NotNull List<? extends DateTime> value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SetDateTimeListField(null, null, value, 3, null);
        }

        @Override // com.google.android.appfunctions.schema.common.p129v1.types.SetFieldCompanion
        @NotNull
        public SetDateTimeNullableField setNullableField(@Nullable DateTime value) {
            return new SetDateTimeNullableField(null, null, value, 3, null);
        }
    }

    public DateTime(@NotNull String namespace, @NotNull String id, @NotNull String timeZone, @NotNull Date date, @NotNull TimeOfDay timeOfDay) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(timeOfDay, "timeOfDay");
        this.namespace = namespace;
        this.id = id;
        this.timeZone = timeZone;
        this.date = date;
        this.timeOfDay = timeOfDay;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) other;
        return Intrinsics.areEqual(this.timeZone, dateTime.timeZone) && Intrinsics.areEqual(this.date, dateTime.date) && Intrinsics.areEqual(this.timeOfDay, dateTime.timeOfDay);
    }

    @NotNull
    public final Date getDate() {
        return this.date;
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
    public final TimeOfDay getTimeOfDay() {
        return this.timeOfDay;
    }

    @NotNull
    public final String getTimeZone() {
        return this.timeZone;
    }

    public int hashCode() {
        return Objects.hash(this.timeZone, this.date, this.timeOfDay);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DateTime(String str, String str2, String str3, Date date, TimeOfDay timeOfDay, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TimeOfDay timeOfDay2;
        Date date2;
        String str4;
        String str5;
        str = (i & 1) != 0 ? "" : str;
        if ((i & 2) != 0) {
            timeOfDay2 = timeOfDay;
            date2 = date;
            str4 = str3;
            str5 = "";
        } else {
            timeOfDay2 = timeOfDay;
            date2 = date;
            str4 = str3;
            str5 = str2;
        }
        this(str, str5, str4, date2, timeOfDay2);
    }
}
