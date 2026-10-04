package com.samsung.android.support.senl.p148nt.composer.main.simple.model;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerStateManager {
    private static final String TAG = Logger.createTag("ComposerStateManager", "CV");
    private ComposerState mComposerState = new ComposerState();

    public ComposerState getComposerState() {
        return this.mComposerState;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putSerializable(ComposerState.KEY_STATE, this.mComposerState);
    }

    public void restoreState(@NonNull Bundle bundle) {
        if (!bundle.containsKey(ComposerState.KEY_STATE)) {
            Logger.m10999d(TAG, "restoreState# no data");
            return;
        }
        ComposerState composerState = (ComposerState) bundle.getSerializable(ComposerState.KEY_STATE);
        this.mComposerState = composerState;
        if (composerState == null) {
            Logger.m10999d(TAG, "restoreState# empty data");
            return;
        }
        composerState.setReadyRestore(true);
        Logger.m10999d(TAG, "restoreState# " + this.mComposerState);
    }
}
