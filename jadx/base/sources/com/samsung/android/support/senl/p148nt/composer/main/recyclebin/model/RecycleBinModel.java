package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.model;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecycleBinModel extends ComposerModel {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RecycleBinModeManager extends ModeManager {
        public /* synthetic */ RecycleBinModeManager(int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager
        public void init(boolean z, boolean z2, boolean z3) {
            setMode(Mode.View, " init#", true, ModeManager.SIPShowType.NONE);
        }

        private RecycleBinModeManager() {
        }
    }

    public RecycleBinModel(Activity activity, @NonNull Config config) {
        super(activity, config);
        getComposerState().setEditable(false);
        getComposerSaveModel().setEditable(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public ModeManager createModeManager() {
        return new RecycleBinModeManager(0);
    }

    public long getRecycleBinTimeMoved() {
        return getNotesDocEntityManager().getRecycleBinTimeMoved();
    }

    public void restore() {
        getNotesDocEntityManager().restore();
    }
}
