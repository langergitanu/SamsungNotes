package com.samsung.android.support.senl.p148nt.app.quicknote;

import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.samsung.android.app.notes.popupnote.PopupNoteService;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.framework.support.ActivityManagerUtil;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import p004A2.RunnableC0015b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class QuickNoteTileService extends TileService {
    private static final String TAG = "QuickNoteTileService";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$0() {
        PopupNoteService.startPopupNoteService(getApplicationContext(), false, TAG);
    }

    private void updateTile() {
        Tile qsTile = getQsTile();
        if (qsTile == null) {
            return;
        }
        qsTile.setState(1);
        qsTile.setLabel(getResources().getString(C8003R.string.aircommand_create_note));
        qsTile.setIcon(Icon.createWithResource(this, C8003R.drawable.ic_quickpanel_create_note_white));
        qsTile.updateTile();
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_LOCK_SCREEN_ON_MEMO, ComposerSAConstants.EVENT_INITIATE_SCREEN_ON_MEMO);
        boolean zIsLocked = isLocked();
        Logger.m8697d(TAG, "onClick, isScreenLocked: " + zIsLocked + ", isSecure: " + isSecure());
        if (zIsLocked && ActivityManagerUtil.isAppLocked(getApplicationContext())) {
            unlockAndRun(new RunnableC0015b(this, 13));
        } else {
            PopupNoteService.startPopupNoteService(getApplicationContext(), zIsLocked, TAG);
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        Logger.m8697d(TAG, "onStartListening");
        updateTile();
    }

    @Override // android.service.quicksettings.TileService
    public void onStopListening() {
        super.onStopListening();
        Logger.m8697d(TAG, "onStopListening");
    }

    @Override // android.service.quicksettings.TileService
    public void onTileAdded() {
        super.onTileAdded();
        Logger.m8697d(TAG, "onTileAdded");
        updateTile();
    }
}
