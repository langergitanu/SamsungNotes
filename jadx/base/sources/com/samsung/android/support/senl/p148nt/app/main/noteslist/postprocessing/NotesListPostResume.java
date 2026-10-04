package com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing;

import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostResumeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesListPostResume extends AbsNotesListPostProcess {
    private static final String TAG = "NotesListPostResume";
    private final PostResumeManager.Token mToken;

    public NotesListPostResume(PostResumeManager.Token token) {
        this.mToken = token;
    }

    public void activate(@NonNull View view) {
        executeOnPreDraw(view, 500L, new AppLaunchLog.LogParam(TAG, "onResume#onPreDraw()"));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.AbsNotesListPostProcess
    public void executeLogics() {
        PostResumeManager.getInstance().executeNotesListLogics(this.mToken);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.AbsNotesListPostProcess
    public String getTag() {
        return TAG;
    }

    public void inactivate() {
        inactivate(true);
    }
}
