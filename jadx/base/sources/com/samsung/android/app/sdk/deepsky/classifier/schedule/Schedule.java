package com.samsung.android.app.sdk.deepsky.classifier.schedule;

import android.os.Bundle;
import androidx.core.app.FrameMetricsAggregator;
import androidx.glance.AbstractC2821a;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.scsp.common.Header;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003Jz\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\n\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\t\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/Schedule;", "", "title", "", "startDate", "endDate", Header.LOCATION, "allDay", "", "isUntilFlag", "isRelative", "cyclicTime", "extras", "Landroid/os/Bundle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Landroid/os/Bundle;)V", "getAllDay", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCyclicTime", "()Ljava/lang/String;", "getEndDate", "getExtras", "()Landroid/os/Bundle;", "getLocation", "getStartDate", DynamicActionBarProvider.METHOD_GET_DATA, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Landroid/os/Bundle;)Lcom/samsung/android/app/sdk/deepsky/classifier/schedule/Schedule;", "equals", "other", "hashCode", "", "toString", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final /* data */ class Schedule {

    @Nullable
    private final Boolean allDay;

    @Nullable
    private final String cyclicTime;

    @Nullable
    private final String endDate;

    @Nullable
    private final Bundle extras;

    @Nullable
    private final Boolean isRelative;

    @Nullable
    private final Boolean isUntilFlag;

    @Nullable
    private final String location;

    @Nullable
    private final String startDate;

    @Nullable
    private final String title;

    public Schedule() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public static /* synthetic */ Schedule copy$default(Schedule schedule, String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schedule.title;
        }
        if ((i & 2) != 0) {
            str2 = schedule.startDate;
        }
        if ((i & 4) != 0) {
            str3 = schedule.endDate;
        }
        if ((i & 8) != 0) {
            str4 = schedule.location;
        }
        if ((i & 16) != 0) {
            bool = schedule.allDay;
        }
        if ((i & 32) != 0) {
            bool2 = schedule.isUntilFlag;
        }
        if ((i & 64) != 0) {
            bool3 = schedule.isRelative;
        }
        if ((i & 128) != 0) {
            str5 = schedule.cyclicTime;
        }
        if ((i & 256) != 0) {
            bundle = schedule.extras;
        }
        String str6 = str5;
        Bundle bundle2 = bundle;
        Boolean bool4 = bool2;
        Boolean bool5 = bool3;
        Boolean bool6 = bool;
        String str7 = str3;
        return schedule.copy(str, str2, str7, str4, bool6, bool4, bool5, str6, bundle2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getAllDay() {
        return this.allDay;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getIsUntilFlag() {
        return this.isUntilFlag;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getIsRelative() {
        return this.isRelative;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCyclicTime() {
        return this.cyclicTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    @NotNull
    public final Schedule copy(@Nullable String title, @Nullable String startDate, @Nullable String endDate, @Nullable String location, @Nullable Boolean allDay, @Nullable Boolean isUntilFlag, @Nullable Boolean isRelative, @Nullable String cyclicTime, @Nullable Bundle extras) {
        return new Schedule(title, startDate, endDate, location, allDay, isUntilFlag, isRelative, cyclicTime, extras);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Schedule)) {
            return false;
        }
        Schedule schedule = (Schedule) other;
        return Intrinsics.areEqual(this.title, schedule.title) && Intrinsics.areEqual(this.startDate, schedule.startDate) && Intrinsics.areEqual(this.endDate, schedule.endDate) && Intrinsics.areEqual(this.location, schedule.location) && Intrinsics.areEqual(this.allDay, schedule.allDay) && Intrinsics.areEqual(this.isUntilFlag, schedule.isUntilFlag) && Intrinsics.areEqual(this.isRelative, schedule.isRelative) && Intrinsics.areEqual(this.cyclicTime, schedule.cyclicTime) && Intrinsics.areEqual(this.extras, schedule.extras);
    }

    @Nullable
    public final Boolean getAllDay() {
        return this.allDay;
    }

    @Nullable
    public final String getCyclicTime() {
        return this.cyclicTime;
    }

    @Nullable
    public final String getEndDate() {
        return this.endDate;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final String getStartDate() {
        return this.startDate;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.startDate;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.endDate;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.location;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.allDay;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isUntilFlag;
        int iHashCode6 = (iHashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isRelative;
        int iHashCode7 = (iHashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.cyclicTime;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Bundle bundle = this.extras;
        return iHashCode8 + (bundle != null ? bundle.hashCode() : 0);
    }

    @Nullable
    public final Boolean isRelative() {
        return this.isRelative;
    }

    @Nullable
    public final Boolean isUntilFlag() {
        return this.isUntilFlag;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.startDate;
        String str3 = this.endDate;
        String str4 = this.location;
        Boolean bool = this.allDay;
        Boolean bool2 = this.isUntilFlag;
        Boolean bool3 = this.isRelative;
        String str5 = this.cyclicTime;
        Bundle bundle = this.extras;
        StringBuilder sbM16m = AbstractC0000a.m16m("Schedule(title=", str, ", startDate=", str2, ", endDate=");
        AbstractC2821a.m2207B(sbM16m, str3, ", location=", str4, ", allDay=");
        sbM16m.append(bool);
        sbM16m.append(", isUntilFlag=");
        sbM16m.append(bool2);
        sbM16m.append(", isRelative=");
        sbM16m.append(bool3);
        sbM16m.append(", cyclicTime=");
        sbM16m.append(str5);
        sbM16m.append(", extras=");
        sbM16m.append(bundle);
        sbM16m.append(")");
        return sbM16m.toString();
    }

    public Schedule(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str5, @Nullable Bundle bundle) {
        this.title = str;
        this.startDate = str2;
        this.endDate = str3;
        this.location = str4;
        this.allDay = bool;
        this.isUntilFlag = bool2;
        this.isRelative = bool3;
        this.cyclicTime = str5;
        this.extras = bundle;
    }

    public /* synthetic */ Schedule(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : bundle);
    }
}
