package com.samsung.android.support.senl.p148nt.model.converter.task.common;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTaskStatus {
    private State mState = State.WAITING;
    private int mType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        WAITING,
        PROGRESSING,
        FAILED,
        CANCELLD,
        SUB_TASK_SUCCESS,
        FINISHED
    }

    public ConvertTaskStatus(int i) {
        this.mType = i;
    }

    public State getState() {
        return this.mState;
    }

    public int getType() {
        return this.mType;
    }

    @NonNull
    public String toString() {
        return this.mType + "/" + this.mState;
    }

    public void updateStatus(State state) {
        this.mState = state;
    }

    public void updateStatus(int i, State state) {
        this.mType = i;
        this.mState = state;
    }
}
