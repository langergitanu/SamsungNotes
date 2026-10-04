package com.samsung.android.sdk.scs.p142ai.text.event;

import androidx.annotation.RestrictTo;
import java.time.LocalDateTime;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Event {
    boolean allDay;
    String cyclicTime;
    LocalDateTime endDateTime;
    int endIndex;
    boolean hasDay;
    boolean hasMonth;
    boolean hasYear;
    boolean isRelative;
    String location;
    LocalDateTime startDateTime;
    int startIndex;
    String title;
    boolean untilFlag;

    public static Event create() {
        return new Event();
    }

    public String getCyclicTime() {
        return this.cyclicTime;
    }

    public LocalDateTime getEndDateTime() {
        return this.endDateTime;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public String getLocation() {
        return this.location;
    }

    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean hasDay() {
        return this.hasDay;
    }

    public boolean hasMonth() {
        return this.hasMonth;
    }

    public boolean hasYear() {
        return this.hasYear;
    }

    public boolean isAllDay() {
        return this.allDay;
    }

    public boolean isRelative() {
        return this.isRelative;
    }

    public boolean isUntilFlag() {
        return this.untilFlag;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setAllDay(boolean z) {
        this.allDay = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setCyclicTime(String str) {
        this.cyclicTime = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEndDateTime(LocalDateTime localDateTime) {
        this.endDateTime = localDateTime;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasDay(boolean z) {
        this.hasDay = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasMonth(boolean z) {
        this.hasMonth = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasYear(boolean z) {
        this.hasYear = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setLocation(String str) {
        this.location = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setRelative(boolean z) {
        this.isRelative = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStartDateTime(LocalDateTime localDateTime) {
        this.startDateTime = localDateTime;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setTitle(String str) {
        this.title = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setUntilFlag(boolean z) {
        this.untilFlag = z;
    }
}
