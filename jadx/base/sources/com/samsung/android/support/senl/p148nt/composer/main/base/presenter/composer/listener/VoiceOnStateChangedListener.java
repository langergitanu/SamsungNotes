package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.media.AudioManager;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.emergencymode.EmergencyManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.VoiceRecordingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 E2\u00020\u0001:\u0001EB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0016J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010$\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,H\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,H\u0016J\u0010\u00106\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,H\u0016J\u0010\u00107\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,H\u0016J\u0018\u00108\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u00109\u001a\u00020\u001a2\u0006\u00101\u001a\u00020,2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010:\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u001fH\u0016J\b\u0010=\u001a\u00020\u001aH\u0002J\u001a\u0010>\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010,2\u0006\u00102\u001a\u000203H\u0002J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/VoiceOnStateChangedListener;", "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnStateChanged;", "presenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;", "mDialogManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IDialogPresenter;", "cManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/ListenerImplContract$IDialogPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;)V", "mActivity", "Landroid/app/Activity;", "mAudioManager", "Landroid/media/AudioManager;", "mVoiceRecordingController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/VoiceRecordingController;", "mDocState", "Lcom/samsung/android/support/senl/nt/model/repository/data/NotesDocument;", "Lcom/samsung/android/support/senl/nt/model/documents/spen/SpenWordDocument;", "mModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mPageManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/page/PageManager;", "setRingerMute", "", "isRecordingOrPlaying", "", "onPlayError", "spenObjectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "i", "", "onPlayPrepared", "onPlayInfo", "mediaInfo", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "onPlayComplete", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "errorCode", XmlErrorCodes.DURATION, "position", "onRecordStarted", "spenVoiceData", "cachePath", "", "onRecordStopped", "onRecordCancelled", "onRecordPaused", "onRecordResumed", "onRecordError", "onRecordUpdateTime", "onInfo", "onPlayClicked", "objectVoice", "clearVoiceContentInfo", "setVoiceContentInfo", "currentPageIndex", "getCurrentPageIndex", "()I", "mIsKeepScreenOn", "enableScreenOn", "enable", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceOnStateChangedListener implements SpenVoiceListenerManager.OnStateChanged {

    @NotNull
    private static final String TAG;

    @Nullable
    private final Activity mActivity;

    @NotNull
    private final AudioManager mAudioManager;

    @NotNull
    private final ListenerImplContract.IDialogPresenter mDialogManager;

    @Nullable
    private final NotesDocument<SpenWordDocument> mDocState;
    private boolean mIsKeepScreenOn;

    @NotNull
    private final ComposerModel mModel;

    @NotNull
    private final PageManager mPageManager;

    @Nullable
    private final VoiceModel mVoiceModel;

    @NotNull
    private final VoiceRecordingController mVoiceRecordingController;

    static {
        String strCreateTag = Logger.createTag("VoiceOnStateChangedListener");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceOnStateChangedListener(@NotNull ListenerImplContract.IPresenter presenter, @NotNull ListenerImplContract.IDialogPresenter mDialogManager, @NotNull ControllerManager cManager) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(mDialogManager, "mDialogManager");
        Intrinsics.checkNotNullParameter(cManager, "cManager");
        this.mDialogManager = mDialogManager;
        Activity activity = presenter.getActivity();
        this.mActivity = activity;
        Object systemService = activity != null ? activity.getSystemService("audio") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.mAudioManager = (AudioManager) systemService;
        VoiceRecordingController voiceRecordingController = cManager.getVoiceRecordingController();
        Intrinsics.checkNotNullExpressionValue(voiceRecordingController, "getVoiceRecordingController(...)");
        this.mVoiceRecordingController = voiceRecordingController;
        this.mDocState = presenter.getComposerModel().getDocState();
        ComposerModel composerModel = presenter.getComposerModel();
        Intrinsics.checkNotNullExpressionValue(composerModel, "getComposerModel(...)");
        this.mModel = composerModel;
        VoiceModel voiceModel = composerModel.getVoiceModel();
        this.mVoiceModel = voiceModel;
        PageManager pageManager = presenter.getPageManager();
        Intrinsics.checkNotNullExpressionValue(pageManager, "getPageManager(...)");
        this.mPageManager = pageManager;
        if (voiceModel != null) {
            voiceModel.setUpdateVoiceSyncListener(new VoiceModel.UpdateVoiceSyncListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.VoiceOnStateChangedListener.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.model.voice.VoiceModel.UpdateVoiceSyncListener
                public void onEnabled(boolean enabled) {
                    if (VoiceOnStateChangedListener.this.mVoiceModel.isPlayingVoiceData()) {
                        VoiceOnStateChangedListener.this.enableScreenOn(enabled);
                    } else {
                        if (enabled) {
                            return;
                        }
                        VoiceOnStateChangedListener.this.enableScreenOn(false);
                    }
                }
            });
        }
    }

    private final void clearVoiceContentInfo() {
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument != null) {
            notesDocument.clearVoiceRecordingInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableScreenOn(boolean enable) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isDestroyed() || SettingsCompat.INSTANCE.getInstance().isUPSM(this.mActivity) || EmergencyManagerCompat.INSTANCE.getInstance().isEmergencyMode(this.mActivity) || this.mIsKeepScreenOn == enable) {
            return;
        }
        if (enable) {
            this.mActivity.getWindow().addFlags(128);
        } else {
            this.mActivity.getWindow().clearFlags(128);
        }
        this.mIsKeepScreenOn = enable;
        AbstractC8014b.m7220v("screen is keep on : ", TAG, enable);
    }

    private final int getCurrentPageIndex() {
        return this.mPageManager.getDocPageInfo().getCurrentPageIndex();
    }

    private final void setRingerMute(boolean isRecordingOrPlaying) {
        if (this.mAudioManager.getRingerMode() != 2) {
            return;
        }
        if (!isRecordingOrPlaying) {
            this.mAudioManager.adjustStreamVolume(2, 100, 0);
        } else if (this.mAudioManager.getStreamVolume(2) != 0) {
            this.mAudioManager.adjustStreamVolume(2, -100, 0);
        }
    }

    private final void setVoiceContentInfo(SpenVoiceData spenVoiceData, String cachePath) {
        SpenWNote spenWNote;
        NotesDocument<SpenWordDocument> notesDocument = this.mDocState;
        if (notesDocument == null || spenVoiceData == null || (spenWNote = (SpenWNote) notesDocument.getDoc()) == null || spenWNote.isClosed()) {
            return;
        }
        VoiceModel voiceModel = this.mVoiceModel;
        Intrinsics.checkNotNull(voiceModel);
        if (voiceModel.getVoiceDataList().isEmpty()) {
            return;
        }
        this.mDocState.setVoiceRecordingInfo(cachePath, this.mVoiceModel.getVoiceDataIndex(spenVoiceData), getCurrentPageIndex());
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onInfo(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayClicked(@NotNull SpenObjectVoice objectVoice) {
        Intrinsics.checkNotNullParameter(objectVoice, "objectVoice");
        this.mVoiceRecordingController.onPlayClicked(objectVoice);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayComplete(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        Logger.m10999d(TAG, "onPlayComplete, SpenObjectVoice: " + spenObjectVoice);
        this.mVoiceRecordingController.onPlayComplete(spenObjectVoice);
        clearVoiceContentInfo();
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayError(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        Logger.m11004w(TAG, "onPlayError, SpenObjectVoice: " + spenObjectVoice);
        this.mVoiceRecordingController.onPlayError(spenObjectVoice, i);
        clearVoiceContentInfo();
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayInfo(@NotNull SpenObjectVoice spenObjectVoice, int mediaInfo) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayPaused(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        Logger.m10999d(TAG, "onPlayPaused, SpenObjectVoice: " + spenObjectVoice);
        this.mVoiceRecordingController.onPlayPaused(spenObjectVoice);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayPrepared(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        this.mVoiceRecordingController.onPlayPrepared(spenObjectVoice, i);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayResumed(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        Logger.m10999d(TAG, "onPlayResumed, SpenObjectVoice: " + spenObjectVoice);
        this.mVoiceRecordingController.onPlayResumed(spenObjectVoice);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlaySeekComplete(@NotNull SpenObjectVoice spenObjectVoice, int i) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        this.mVoiceRecordingController.onPlaySeekComplete(spenObjectVoice, i);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayStarted(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        Logger.m10999d(TAG, "onPlayStarted, SpenObjectVoice: " + spenObjectVoice);
        this.mVoiceRecordingController.onPlayStarted(spenObjectVoice);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayStopped(@NotNull SpenObjectVoice spenObjectVoice) {
        Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        Logger.m10999d(TAG, "onPlayStopped, SpenObjectVoice: " + spenObjectVoice);
        this.mVoiceRecordingController.onPlayStopped(spenObjectVoice);
        clearVoiceContentInfo();
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordCancelled(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Logger.m10999d(TAG, "onRecordCancelled, SpenVoiceData: " + spenVoiceData);
        clearVoiceContentInfo();
        this.mDialogManager.dismissConfirmVoiceDialog();
        setRingerMute(false);
        this.mVoiceRecordingController.onRecordCancel(spenVoiceData);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordError(@NotNull SpenVoiceData spenVoiceData, int i) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Logger.m10999d(TAG, "onRecordError, SpenVoiceData: " + spenVoiceData + ", i: " + i);
        clearVoiceContentInfo();
        setRingerMute(false);
        this.mVoiceRecordingController.onRecordError(spenVoiceData, i);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordPaused(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Logger.m10999d(TAG, "onRecordPaused, SpenVoiceData: " + spenVoiceData);
        setRingerMute(false);
        this.mVoiceRecordingController.onRecordPause(spenVoiceData);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordResumed(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Logger.m10999d(TAG, "onRecordResumed, SpenVoiceData: " + spenVoiceData);
        setRingerMute(true);
        this.mVoiceRecordingController.onRecordResume(spenVoiceData);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordStarted(@NotNull SpenVoiceData spenVoiceData, @NotNull String cachePath) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Logger.m10999d(TAG, "onRecordStarted, SpenVoiceData: " + spenVoiceData);
        setVoiceContentInfo(spenVoiceData, cachePath);
        setRingerMute(true);
        this.mVoiceRecordingController.onRecordStart(spenVoiceData, cachePath);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordStopped(@NotNull SpenVoiceData spenVoiceData) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Logger.m10999d(TAG, "onRecordStopped, SpenVoiceData: " + spenVoiceData);
        clearVoiceContentInfo();
        this.mDialogManager.dismissConfirmVoiceDialog();
        setRingerMute(false);
        this.mVoiceRecordingController.onRecordStop(spenVoiceData);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onRecordUpdateTime(@NotNull SpenVoiceData spenVoiceData, int i) {
        Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
        Logger.m10999d(TAG, "onRecordUpdateTime, SpenVoiceData: " + spenVoiceData + ", i: " + i);
        this.mVoiceRecordingController.onUpdateRecordTime(spenVoiceData, i);
        setRingerMute(true);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayInfo(@NotNull SpenVoiceData voiceData, int mediaInfo) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mVoiceRecordingController.onRecordPlayInfo(voiceData, mediaInfo);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayPrepared(@NotNull SpenVoiceData voiceData, int duration) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mVoiceRecordingController.onRecordPlayPrepared(voiceData, duration);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlaySeekComplete(@NotNull SpenVoiceData voiceData, int position) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        this.mVoiceRecordingController.onUpdateRecordPlayTime(voiceData, position);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayPaused(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Logger.m10999d(TAG, "onPlayPaused, SpenVoiceData: " + voiceData);
        this.mVoiceRecordingController.onRecordPlayPause(voiceData);
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null || !voiceModel.getMSyncEnabled()) {
            return;
        }
        enableScreenOn(false);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayResumed(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Logger.m10999d(TAG, "onPlayResumed, SpenVoiceData: " + voiceData);
        this.mVoiceRecordingController.onRecordPlayResume(voiceData);
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null || !voiceModel.getMSyncEnabled()) {
            return;
        }
        enableScreenOn(true);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayStarted(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Logger.m10999d(TAG, "onPlayStarted, SpenVoiceData: " + voiceData);
        this.mVoiceRecordingController.onRecordPlayStart(voiceData);
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null || !voiceModel.getMSyncEnabled()) {
            return;
        }
        enableScreenOn(true);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayComplete(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Logger.m10999d(TAG, "onPlayComplete, SpenVoiceData: " + voiceData);
        this.mVoiceRecordingController.onRecordPlayComplete(voiceData);
        clearVoiceContentInfo();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null || !voiceModel.getMSyncEnabled()) {
            return;
        }
        enableScreenOn(false);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayError(@NotNull SpenVoiceData voiceData, int errorCode) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Logger.m10999d(TAG, "onPlayError, SpenVoiceData: " + voiceData + ", errCode: " + errorCode);
        this.mVoiceRecordingController.onRecordPlayError(voiceData, errorCode);
        clearVoiceContentInfo();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null || !voiceModel.getMSyncEnabled()) {
            return;
        }
        enableScreenOn(false);
    }

    @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
    public void onPlayStopped(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Logger.m10999d(TAG, "onPlayStopped, SpenVoiceData: " + voiceData);
        this.mVoiceRecordingController.onRecordPlayStop(voiceData);
        clearVoiceContentInfo();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null || !voiceModel.getMSyncEnabled()) {
            return;
        }
        enableScreenOn(false);
    }
}
