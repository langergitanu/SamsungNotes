package com.google.android.appfunctions.schema.common.p129v1.maps;

import androidx.appsearch.annotation.Document;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.appfunctions.schema.common.p129v1.types.TimeOfDayRange;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Document(name = C$$__AppSearch__OpeningHours.SCHEMA_NAME)
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001f"}, m13886d2 = {"Lcom/google/android/appfunctions/schema/common/v1/maps/OpeningHours;", "", "namespace", "", "id", "monday", "Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getMonday", "()Lcom/google/android/appfunctions/schema/common/v1/types/TimeOfDayRange;", "getTuesday", "getWednesday", "getThursday", "getFriday", "getSaturday", "getSunday", "equals", "", "other", "hashCode", "", "java.com.google.android.libraries.llm.appfunctions.appfunctions_schema_appfunctions_schema"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class OpeningHours {

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange friday;

    @Document.InterfaceC0555Id
    @NotNull
    private final String id;

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange monday;

    @Document.Namespace
    @NotNull
    private final String namespace;

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange saturday;

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange sunday;

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange thursday;

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange tuesday;

    @Document.DocumentProperty
    @Nullable
    private final TimeOfDayRange wednesday;

    public OpeningHours() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof OpeningHours)) {
            return false;
        }
        OpeningHours openingHours = (OpeningHours) other;
        return Intrinsics.areEqual(this.monday, openingHours.monday) && Intrinsics.areEqual(this.tuesday, openingHours.tuesday) && Intrinsics.areEqual(this.wednesday, openingHours.wednesday) && Intrinsics.areEqual(this.thursday, openingHours.thursday) && Intrinsics.areEqual(this.friday, openingHours.friday) && Intrinsics.areEqual(this.saturday, openingHours.saturday) && Intrinsics.areEqual(this.sunday, openingHours.sunday);
    }

    @Nullable
    public final TimeOfDayRange getFriday() {
        return this.friday;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final TimeOfDayRange getMonday() {
        return this.monday;
    }

    @NotNull
    public final String getNamespace() {
        return this.namespace;
    }

    @Nullable
    public final TimeOfDayRange getSaturday() {
        return this.saturday;
    }

    @Nullable
    public final TimeOfDayRange getSunday() {
        return this.sunday;
    }

    @Nullable
    public final TimeOfDayRange getThursday() {
        return this.thursday;
    }

    @Nullable
    public final TimeOfDayRange getTuesday() {
        return this.tuesday;
    }

    @Nullable
    public final TimeOfDayRange getWednesday() {
        return this.wednesday;
    }

    public int hashCode() {
        return Objects.hash(this.monday, this.tuesday, this.wednesday, this.thursday, this.friday, this.saturday, this.sunday);
    }

    public OpeningHours(@NotNull String namespace, @NotNull String id, @Nullable TimeOfDayRange timeOfDayRange, @Nullable TimeOfDayRange timeOfDayRange2, @Nullable TimeOfDayRange timeOfDayRange3, @Nullable TimeOfDayRange timeOfDayRange4, @Nullable TimeOfDayRange timeOfDayRange5, @Nullable TimeOfDayRange timeOfDayRange6, @Nullable TimeOfDayRange timeOfDayRange7) {
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.monday = timeOfDayRange;
        this.tuesday = timeOfDayRange2;
        this.wednesday = timeOfDayRange3;
        this.thursday = timeOfDayRange4;
        this.friday = timeOfDayRange5;
        this.saturday = timeOfDayRange6;
        this.sunday = timeOfDayRange7;
    }

    public /* synthetic */ OpeningHours(String str, String str2, TimeOfDayRange timeOfDayRange, TimeOfDayRange timeOfDayRange2, TimeOfDayRange timeOfDayRange3, TimeOfDayRange timeOfDayRange4, TimeOfDayRange timeOfDayRange5, TimeOfDayRange timeOfDayRange6, TimeOfDayRange timeOfDayRange7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : timeOfDayRange, (i & 8) != 0 ? null : timeOfDayRange2, (i & 16) != 0 ? null : timeOfDayRange3, (i & 32) != 0 ? null : timeOfDayRange4, (i & 64) != 0 ? null : timeOfDayRange5, (i & 128) != 0 ? null : timeOfDayRange6, (i & 256) != 0 ? null : timeOfDayRange7);
    }
}
