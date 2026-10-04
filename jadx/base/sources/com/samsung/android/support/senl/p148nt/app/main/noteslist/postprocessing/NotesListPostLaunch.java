package com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing;

import android.os.Trace;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostStartManager;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesListPostLaunch extends AbsNotesListPostProcess {
    private static final String TAG = "NotesListPostLaunch";
    private final PostStartManager.Token mStartToken;
    private final PostLaunchManager.Token mToken;

    public NotesListPostLaunch(PostLaunchManager.Token token, PostStartManager.Token token2) {
        this.mToken = token;
        this.mStartToken = token2;
    }

    public void activate() {
        if (this.mRunnable != null) {
            this.mRunnable = null;
            PostStartManager.getInstance().addLogic(this.mStartToken, 2, new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.postprocessing.NotesListPostLaunch.1
                @Override // java.lang.Runnable
                public void run() {
                    PostLaunchManager.getInstance().executeLogics(NotesListPostLaunch.this.mToken);
                }
            });
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.AbsNotesListPostProcess
    public void executeLogics() {
        AppLaunchLog.m8605d(TAG, "executeLogics()");
        Trace.beginSection("NotesListPostLaunch executeLogics(MainList)");
        PostLaunchManager.getInstance().executeLogics(this.mToken);
        Trace.endSection();
    }

    public void executeOnPreDraw(@NonNull View view, long j) {
        executeOnPreDraw(view, j, new AppLaunchLog.LogParam(TAG, "executeOnPreDraw#onPreDraw()", true));
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.postprocessing.AbsNotesListPostProcess
    public String getTag() {
        return TAG;
    }

    public void inactivate() {
        if (inactivate(false)) {
            reserveExecution();
        }
    }

    public void reserveExecution() {
        this.mRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.postprocessing.NotesListPostLaunch.2
            @Override // java.lang.Runnable
            public void run() {
                PostLaunchManager.getInstance().executeLogics(NotesListPostLaunch.this.mToken);
            }
        };
    }
}
