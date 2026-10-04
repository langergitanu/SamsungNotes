package com.samsung.android.support.senl.p148nt.app.labs.createnote.task;

import android.content.ComponentName;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Task implements Runnable {
    private static final String PACKAGE_NAME_POPUP_NOTE_SERVICE = "com.samsung.android.app.notes.popupnote.PopupNoteService";

    public ComponentName createComponentName() {
        return new ComponentName(BaseUtils.getApplicationContext().getPackageName(), PACKAGE_NAME_POPUP_NOTE_SERVICE);
    }
}
