package com.samsung.android.support.senl.p148nt.app.labs.screenoffmemo.task;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TaskFactory {
    private static final String COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DETACH = "Start ScreenOffMemo by pen detach";
    private static final String COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DOUBLE_TAP = "Start ScreenOffMemo by pen double tap";

    @Nullable
    public Task createTask(String str) {
        str.getClass();
        if (str.equals(COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DETACH)) {
            return new StartPenDetach();
        }
        if (str.equals(COMMAND_START_SCREEN_OFF_MEMO_BY_PEN_DOUBLE_TAP)) {
            return new StartPenDoubleTap();
        }
        return null;
    }
}
