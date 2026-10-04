package com.samsung.android.sdk.scs.p142ai.text.reminder;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ReminderEntity {
    int endIndex;
    Place place;
    int startIndex;
    State state;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Place {
        HOME,
        WORK,
        SCHOOL,
        CAR
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        GET_IN,
        GET_OUT
    }

    public ReminderEntity(Place place, State state, int i, int i2) {
        this.place = place;
        this.state = state;
        this.startIndex = i;
        this.endIndex = i2;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public Place getPlace() {
        return this.place;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public State getState() {
        return this.state;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setEndIndex(int i) {
        this.endIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPlace(Place place) {
        this.place = place;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setStartIndex(int i) {
        this.startIndex = i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setState(State state) {
        this.state = state;
    }
}
