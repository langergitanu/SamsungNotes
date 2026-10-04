package com.samsung.android.support.senl.p148nt.livesharing;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class LiveSharingIntent {
    public static final String EXTRA_START_LIVE_SHARING = "COACTIVITY_START_INFO";
    public static final String NOTES_ENTRY_CLASS = "com.samsung.android.app.notes.memolist.MemoListActivity";
    public static final String NOTES_PACKAGE = "com.samsung.android.app.notes";

    public static Intent createStartNoteIntent() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName("com.samsung.android.app.notes", NOTES_ENTRY_CLASS);
        intent.putExtra(EXTRA_START_LIVE_SHARING, new byte[]{16, 1});
        return intent;
    }
}
