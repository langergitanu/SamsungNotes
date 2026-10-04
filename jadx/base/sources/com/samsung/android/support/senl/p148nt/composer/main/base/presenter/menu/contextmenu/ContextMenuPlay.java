package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.VoiceTimeDataUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuPlay extends ContextMenuItem {
    private static final int EXTRA_DATA_INFO_VIDEO = 12;
    private static final int EXTRA_DATA_INFO_VIDEOFRAME = 13;
    private static final int EXTRA_DATA_INFO_VOICE = 23;
    private static final int EXTRA_DATA_INFO_YOUTUBE = 14;
    private static final String EXTRA_DATA_KEY_TIME = "time";
    private static final String EXTRA_DATA_KEY_TYPE = "Type";
    private static final String EXTRA_DATA_KEY_YOUTUBEID = "YoutubeID";
    private static final String KEY_VOICE_BOOKMARK_IDENTIFIER = "NOTES_APP_BOOKMARK_VOICE_IDENTIFIER";
    private static final String TAG = Logger.createTag("ContextMenuPlay");
    private DialogPresenterManager mDialogPresenterManager;
    private ObjectManager mObjectManager;
    private int mStartTime = 0;
    private VoiceRecordingController.VoicePlayPreparedListener mVoicePlayPreparedListener = new VoiceRecordingController.VoicePlayPreparedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuPlay.1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.VoiceRecordingController.VoicePlayPreparedListener
        public void onPlayPrepared(SpenObjectVoice spenObjectVoice, int i) {
            Logger.m10999d(ContextMenuPlay.TAG, "onPlayPrepared, spenObjectVoice: " + spenObjectVoice + ", index:" + i + ", mStartTime:" + ContextMenuPlay.this.mStartTime);
            VoiceManager.seekTo(ContextMenuPlay.this.mStartTime);
            ContextMenuPlay.this.mVoiceRecordingController.setVoicePlayPreparedListener(null);
        }
    };
    private VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;
    private VoiceRecordingController mVoiceRecordingController;

    public ContextMenuPlay(ComposerViewPresenter composerViewPresenter, DialogPresenterManager dialogPresenterManager, VoiceRecordingController voiceRecordingController, VoiceRecordMenuPresenter voiceRecordMenuPresenter) {
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mVoiceRecordingController = voiceRecordingController;
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
    }

    private SpenObjectBase findVoiceObject(String str) {
        Iterator<SpenWPage> it = this.mObjectManager.getNote().getPageList().iterator();
        while (it.hasNext()) {
            ArrayList<SpenObjectBase> objectList = it.next().getObjectList(512);
            if (!objectList.isEmpty()) {
                for (SpenObjectBase spenObjectBase : objectList) {
                    String attachedFile = spenObjectBase.getAttachedFile();
                    String title = ((SpenObjectVoice) spenObjectBase).getTitle();
                    if ((!TextUtils.isEmpty(attachedFile) && attachedFile.endsWith(str)) || (!TextUtils.isEmpty(title) && str.startsWith(title))) {
                        return spenObjectBase;
                    }
                }
            }
        }
        return null;
    }

    private Intent getIntentToPlayOnYouTubeApp(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + str));
    }

    private Intent getIntentToPlayOnYouTubeHttp(String str) {
        return new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + str));
    }

    private String getYoutubeID(SpenObjectBase spenObjectBase) {
        return spenObjectBase.getSorDataString(EXTRA_DATA_KEY_YOUTUBEID);
    }

    private boolean isVideoObject(SpenObjectBase spenObjectBase) {
        int extraDataInt = spenObjectBase.getExtraDataInt("Type");
        AbstractC0000a.m3D(extraDataInt, "isVideoObject : type = ", TAG);
        return extraDataInt == 12 || extraDataInt == 13;
    }

    private boolean isVoiceMemoObject(SpenObjectBase spenObjectBase) {
        if (spenObjectBase.getExtraDataInt("Type") != 23 || !spenObjectBase.hasExtraDataString(KEY_VOICE_BOOKMARK_IDENTIFIER)) {
            return false;
        }
        if (findVoiceObject(spenObjectBase.getExtraDataString(KEY_VOICE_BOOKMARK_IDENTIFIER)) != null) {
            return true;
        }
        return spenObjectBase.getType() == 4 && spenObjectBase.getExtraDataInt("Type") == 23;
    }

    private boolean isYoutubeObject(SpenObjectBase spenObjectBase) {
        String sorDataString;
        if (spenObjectBase.getExtraDataInt("Type") != 14 || (sorDataString = spenObjectBase.getSorDataString(EXTRA_DATA_KEY_YOUTUBEID)) == null || sorDataString.isEmpty()) {
            return false;
        }
        Logger.m10999d(TAG, "isYoutubeObject() : videoId = ".concat(sorDataString));
        return true;
    }

    private boolean playVideo(SpenObjectBase spenObjectBase) {
        return this.mObjectManager.playVideo(spenObjectBase);
    }

    private void playVoice(SpenObjectBase spenObjectBase) {
        this.mVoiceRecordMenuPresenter.setSPDVoiceTagPath("");
        String extraDataString = spenObjectBase.getExtraDataString(KEY_VOICE_BOOKMARK_IDENTIFIER);
        if (spenObjectBase.hasExtraDataInt("time")) {
            this.mStartTime = spenObjectBase.getExtraDataInt("time");
        }
        String str = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("playVoice( ", extraDataString, " / ");
        sbM15l.append(this.mStartTime);
        sbM15l.append(" ) ");
        Logger.m10999d(str, sbM15l.toString());
        SpenObjectBase spenObjectBaseFindVoiceObject = findVoiceObject(extraDataString);
        if (spenObjectBaseFindVoiceObject != null) {
            Logger.m11003i(str, "playVoice# play start");
            this.mVoiceRecordingController.setVoicePlayPreparedListener(this.mVoicePlayPreparedListener);
            VoiceManager.play((SpenObjectVoice) spenObjectBaseFindVoiceObject);
            return;
        }
        if (spenObjectBase.getType() == 4 && spenObjectBase.getExtraDataInt("Type") == 23) {
            SpenObjectVoice spenObjectVoiceMakeObjectVoice = SpenObjectConstructor.makeObjectVoice();
            String attachedFile = spenObjectBase.getAttachedFile();
            if (attachedFile == null) {
                Logger.m11004w(str, "getAttachedFile null");
                return;
            }
            spenObjectVoiceMakeObjectVoice.attachFile(attachedFile);
            File file = new File(attachedFile);
            if (!file.exists()) {
                Logger.m11004w(str, "attachedFile invalid");
                return;
            }
            spenObjectVoiceMakeObjectVoice.setPlayTime(VoiceTimeDataUtils.createTimeString(VoiceTimeDataUtils.getPlayTime(attachedFile) / 1000, false));
            spenObjectVoiceMakeObjectVoice.setRect(new RectF(0.0f, 0.0f, 0.0f, 0.0f), true);
            spenObjectVoiceMakeObjectVoice.setTitle("title");
            spenObjectVoiceMakeObjectVoice.setExtraDataString(KEY_VOICE_BOOKMARK_IDENTIFIER, file.getName());
            this.mVoiceRecordingController.setVoicePlayPreparedListener(this.mVoicePlayPreparedListener);
            this.mVoiceRecordMenuPresenter.setPlayingAudio(true);
            this.mVoiceRecordMenuPresenter.setSPDVoiceTagPath(attachedFile);
            boolean zPlay = VoiceManager.play(spenObjectVoiceMakeObjectVoice);
            Logger.m10999d(str, "playVoice - filePath: ".concat(attachedFile));
            Logger.m10999d(str, "playVoice - play : " + zPlay);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_PLAY;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.composer_ctx_menu_play).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (this.mObjectManager.getSelectedObjectList() == null || this.mObjectManager.getSelectedObjectList().size() != 1) {
            return false;
        }
        SpenObjectBase spenObjectBase = this.mObjectManager.getSelectedObjectList().get(0);
        return isVideoObject(spenObjectBase) || isYoutubeObject(spenObjectBase) || isVoiceMemoObject(spenObjectBase);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String str = TAG;
        Logger.m10999d(str, "executePlayMenu#");
        SpenObjectBase spenObjectBase = this.mObjectManager.getSelectedObjectList().get(0);
        if (isVideoObject(spenObjectBase)) {
            if (!playVideo(spenObjectBase)) {
                this.mDialogPresenterManager.showVideoErrDialog();
                return;
            }
        } else if (isYoutubeObject(spenObjectBase)) {
            String youtubeID = getYoutubeID(spenObjectBase);
            try {
                IntentUtil.startActivity(this.mActivity, getIntentToPlayOnYouTubeApp(youtubeID));
                Logger.m10999d(str, "onYouTubePlay() : YouTube App");
            } catch (ActivityNotFoundException unused) {
                IntentUtil.startActivity(this.mActivity, getIntentToPlayOnYouTubeHttp(youtubeID));
                Logger.m10999d(TAG, "onYouTubePlay() : Browser");
            } catch (Exception unused2) {
                Logger.m10999d(TAG, "Failed to play YouTube video");
            }
        } else if (isVoiceMemoObject(spenObjectBase)) {
            playVoice(spenObjectBase);
        }
        this.mObjectManager.clearSelectObject();
    }
}
