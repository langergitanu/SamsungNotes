package com.samsung.android.support.senl.p148nt.app.labs.createnote.task;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TaskFactory {
    private static final String COMMAND_START_CREATE_NOTE_BY_AIR_COMMAND = "Start Create note by AirCommand";
    private static final String COMMAND_START_CREATE_NOTE_BY_DOUBLE_TAP = "Start Create note by double tap";

    @Nullable
    public Task createTask(String str) {
        str.getClass();
        if (str.equals(COMMAND_START_CREATE_NOTE_BY_AIR_COMMAND)) {
            return new StartAirCommand();
        }
        if (str.equals(COMMAND_START_CREATE_NOTE_BY_DOUBLE_TAP)) {
            return new StartDoubleTap();
        }
        return null;
    }
}
