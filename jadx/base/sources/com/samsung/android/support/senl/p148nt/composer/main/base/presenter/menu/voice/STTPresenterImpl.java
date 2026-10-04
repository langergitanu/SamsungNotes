package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.transition.C3970a;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DocInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.stt.base.model.SpenVoiceTextDataReaderCache;
import com.samsung.android.support.senl.p148nt.stt.common.util.STTDataUtils;
import com.samsung.android.support.senl.p148nt.stt.controller.STTVoiceDataController;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTSearchPresenter;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTUpdateDataTask;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001<B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0013J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0015H\u0016J \u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0017H\u0016J\u0010\u00102\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0015H\u0016J\u0018\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020\u0013H\u0016J\u0010\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u0017H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/STTPresenterImpl;", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/NoteManager$ObserverBackgroundColor;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter$ObserverConfigurationChanged;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "parent", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IParent;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IParent;)V", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mDocInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/info/DocInfo;", "mParent", "mComposerViewPresenter", "mSipListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/SoftInputManager$OnSipListener;", "init", "", "getCurrentIndex", "", "isFromBackward", "", "canForward", "searchForward", "canBackward", "searchBackward", "updateSTTData", "onDestroy", "showRecordingPlayView", "showRealtimeTranscribe", "getDocumentPath", "", "onSeekToSTTTouchedWord", "voiceIndex", "currentPlayingTime", "", "updateVoiceSync", "onChangedBackgroundColor", "color", "invert", "hasBackgroundImage", "voiceDataList", "", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "getVoiceDataList", "()Ljava/util/List;", "setVoiceDataList", "(Ljava/util/List;)V", "onVoiceDataListChange", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "isOrientationChanged", "onDialogClickedConvertButton", "onEditWordTouch", "onUpdateListVoiceBtnState", "isEnabled", "onUpdateMoveBtnState", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTPresenterImpl extends STTPresenter implements NoteManager.ObserverBackgroundColor, ComposerViewPresenter.ObserverConfigurationChanged {

    @NotNull
    private static final String TAG;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private DocInfo mDocInfo;

    @Nullable
    private VoiceRecordMenuContract.IParent mParent;

    @NotNull
    private final SoftInputManager.OnSipListener mSipListener;

    @Nullable
    private List<SpenVoiceData> voiceDataList;

    static {
        String strCreateTag = Logger.createTag("STTPresenterImpl");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public STTPresenterImpl(@NotNull ComposerViewPresenter composerViewPresenter, @Nullable VoiceRecordMenuContract.IParent iParent) {
        super(composerViewPresenter.getActivity(), composerViewPresenter.getComposerModel().getVoiceModel().getVoiceDataList());
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.mSipListener = new SoftInputManager.OnSipListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.voice.STTPresenterImpl$mSipListener$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
            public void onHide() {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.SoftInputManager.OnSipListener
            public void onShow() {
                this.this$0.dismissSelectLanguageDialog();
                this.this$0.dismissTranscribeDialog();
            }
        };
        init(composerViewPresenter, iParent);
        ComposerModel composerModel = this.mComposerModel;
        List<SpenVoiceData> voiceDataList = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getVoiceModel() != null) {
            ComposerModel composerModel2 = this.mComposerModel;
            if (composerModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                composerModel2 = null;
            }
            VoiceModel voiceModel = composerModel2.getVoiceModel();
            if (voiceModel != null) {
                voiceDataList = voiceModel.getVoiceDataList();
            }
        }
        this.voiceDataList = voiceDataList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSTTData$lambda$0(ArrayList arrayList, Activity activity, STTPresenterImpl sTTPresenterImpl, boolean z) {
        if (!arrayList.isEmpty()) {
            Intrinsics.checkNotNull(activity);
            STTDataUtils.insertAllToDatabase(activity, arrayList);
        }
        VoiceRecordMenuContract.IParent iParent = sTTPresenterImpl.mParent;
        if (iParent != null) {
            iParent.onVoiceDataSetChanged();
        }
    }

    public final boolean canBackward() {
        STTSearchPresenter mSTTSearchPresenter = getMSTTSearchPresenter();
        return mSTTSearchPresenter != null && mSTTSearchPresenter.canBackward();
    }

    public final boolean canForward() {
        STTSearchPresenter mSTTSearchPresenter = getMSTTSearchPresenter();
        return mSTTSearchPresenter != null && mSTTSearchPresenter.canForward();
    }

    public final int getCurrentIndex(boolean isFromBackward) {
        STTSearchPresenter mSTTSearchPresenter = getMSTTSearchPresenter();
        if (mSTTSearchPresenter != null) {
            return mSTTSearchPresenter.getCurrentSearchSTTIndex(isFromBackward);
        }
        return -1;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    @NotNull
    public String getDocumentPath() {
        DocInfo docInfo = this.mDocInfo;
        if (docInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDocInfo");
            docInfo = null;
        }
        String docPath = docInfo.getDocPath();
        Intrinsics.checkNotNullExpressionValue(docPath, "getDocPath(...)");
        return docPath;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    @Nullable
    public List<SpenVoiceData> getVoiceDataList() {
        return this.voiceDataList;
    }

    public final void init(@NotNull ComposerViewPresenter composerViewPresenter, @Nullable VoiceRecordMenuContract.IParent parent) {
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.mComposerViewPresenter = composerViewPresenter;
        ComposerViewPresenter composerViewPresenter2 = null;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        ComposerModel composerModel = composerViewPresenter.getComposerModel();
        this.mComposerModel = composerModel;
        this.mParent = parent;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        this.mDocInfo = composerModel.getDocInfo();
        ComposerViewPresenter composerViewPresenter3 = this.mComposerViewPresenter;
        if (composerViewPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter3 = null;
        }
        composerViewPresenter3.getNoteManager().removeBackgroundColorObserver(this);
        ComposerViewPresenter composerViewPresenter4 = this.mComposerViewPresenter;
        if (composerViewPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter4 = null;
        }
        composerViewPresenter4.getNoteManager().addBackgroundColorObserver(this);
        ComposerViewPresenter composerViewPresenter5 = this.mComposerViewPresenter;
        if (composerViewPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter5 = null;
        }
        composerViewPresenter5.removeConfigurationObserverChanged(this);
        ComposerViewPresenter composerViewPresenter6 = this.mComposerViewPresenter;
        if (composerViewPresenter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter6 = null;
        }
        composerViewPresenter6.addConfigurationObserverChanged(this);
        ComposerViewPresenter composerViewPresenter7 = this.mComposerViewPresenter;
        if (composerViewPresenter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter7 = null;
        }
        composerViewPresenter7.getSoftInputManager().removeOnSipListener(this.mSipListener);
        ComposerViewPresenter composerViewPresenter8 = this.mComposerViewPresenter;
        if (composerViewPresenter8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
        } else {
            composerViewPresenter2 = composerViewPresenter8;
        }
        composerViewPresenter2.getSoftInputManager().addOnSipListener(this.mSipListener);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int color, boolean invert, boolean hasBackgroundImage) {
        ComposerModel composerModel = this.mComposerModel;
        ComposerModel composerModel2 = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        int recordPlayingIndex = composerModel.getVoiceModel().getRecordPlayingIndex();
        ComposerModel composerModel3 = this.mComposerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
        } else {
            composerModel2 = composerModel3;
        }
        onChangedBackgroundColor(color, invert, hasBackgroundImage, recordPlayingIndex, composerModel2.getVoiceModel().getRecordPlayingProgress());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.ObserverConfigurationChanged
    public void onConfigurationChanged(@NotNull Configuration newConfig, boolean isOrientationChanged) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        onSTTConfigurationChanged(newConfig, isOrientationChanged);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void onDestroy() {
        super.onDestroy();
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        ComposerViewPresenter composerViewPresenter2 = null;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        composerViewPresenter.getSoftInputManager().removeOnSipListener(this.mSipListener);
        ComposerViewPresenter composerViewPresenter3 = this.mComposerViewPresenter;
        if (composerViewPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter3 = null;
        }
        composerViewPresenter3.getNoteManager().removeBackgroundColorObserver(this);
        ComposerViewPresenter composerViewPresenter4 = this.mComposerViewPresenter;
        if (composerViewPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
        } else {
            composerViewPresenter2 = composerViewPresenter4;
        }
        composerViewPresenter2.removeConfigurationObserverChanged(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void onDialogClickedConvertButton() {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.onDialogClickedConvertButton();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.contract.STTPresenterContract
    public void onEditWordTouch() {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        composerViewPresenter.getSoftInputManager().setTemporarySoftInputMode(16);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void onSeekToSTTTouchedWord(int voiceIndex, long currentPlayingTime) {
        int i = 0;
        for (int i2 = 0; i2 < voiceIndex; i2++) {
            ComposerModel composerModel = this.mComposerModel;
            ComposerModel composerModel2 = null;
            if (composerModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                composerModel = null;
            }
            int recordingTime = (int) composerModel.getVoiceModel().getVoiceDataList().get(i2).getRecordingTime();
            if (recordingTime <= 0) {
                VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
                ComposerModel composerModel3 = this.mComposerModel;
                if (composerModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                } else {
                    composerModel2 = composerModel3;
                }
                recordingTime = voiceUtil.changeTimeType(composerModel2.getVoiceModel().getVoiceDataList().get(i2).getPlayTime()) * 1000;
            }
            i += recordingTime;
        }
        int i4 = i + ((int) currentPlayingTime);
        Logger.m10999d(TAG, "currentIdx: " + voiceIndex + "|" + currentPlayingTime + "|" + i4);
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.seekToSTTTouchedWord(i4);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void onUpdateListVoiceBtnState(boolean isEnabled) {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.onUpdateListVoiceBtnState(isEnabled);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void onUpdateMoveBtnState() {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.onUpdateMoveBtnState();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void onVoiceDataListChange(int voiceIndex) {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.onVoiceDataListChange(voiceIndex);
        }
    }

    public final boolean searchBackward() {
        if (!canBackward()) {
            return false;
        }
        STTSearchPresenter mSTTSearchPresenter = getMSTTSearchPresenter();
        if (mSTTSearchPresenter == null) {
            return true;
        }
        mSTTSearchPresenter.searchBackward();
        return true;
    }

    public final boolean searchForward() {
        if (!canForward()) {
            return false;
        }
        STTSearchPresenter mSTTSearchPresenter = getMSTTSearchPresenter();
        if (mSTTSearchPresenter == null) {
            return true;
        }
        mSTTSearchPresenter.searchForward();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void setVoiceDataList(@Nullable List<SpenVoiceData> list) {
        this.voiceDataList = list;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void showRealtimeTranscribe() {
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        if (voiceDataList != null && VoiceManager.isRecordingActivated()) {
            Logger.m10999d(TAG, "showRealtimeTranscribe: " + voiceDataList.size());
            setIndexItemToShow(voiceDataList.size() + (-1));
            VoiceRecordMenuContract.IParent iParent = this.mParent;
            if (iParent != null) {
                iParent.showRealtimeTranscribe();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void showRecordingPlayView() {
        Logger.m10999d(TAG, "showRecordingPlayView");
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.showRecordingPlayView();
        }
    }

    public final void updateSTTData() {
        List<SpenVoiceData> voiceDataList = getVoiceDataList();
        if (voiceDataList == null) {
            return;
        }
        SpenVoiceTextDataReaderCache companion = SpenVoiceTextDataReaderCache.INSTANCE.getInstance();
        companion.clear();
        DocInfo docInfo = this.mDocInfo;
        ComposerViewPresenter composerViewPresenter = null;
        if (docInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDocInfo");
            docInfo = null;
        }
        String uuid = docInfo.getUuid();
        DocInfo docInfo2 = this.mDocInfo;
        if (docInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDocInfo");
            docInfo2 = null;
        }
        String docPath = docInfo2.getDocPath();
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
        } else {
            composerViewPresenter = composerViewPresenter2;
        }
        Activity activity = composerViewPresenter.getActivity();
        ArrayList<SttContentEntity> arrayList = new ArrayList<>();
        STTUpdateDataTask sTTUpdateDataTask = new STTUpdateDataTask();
        Intrinsics.checkNotNull(docPath);
        Intrinsics.checkNotNull(uuid);
        STTVoiceDataController voiceDataController = getVoiceDataController();
        Intrinsics.checkNotNull(activity);
        sTTUpdateDataTask.updateSTTData(docPath, uuid, voiceDataController, companion, voiceDataList, activity, arrayList, new C3970a(arrayList, 4, activity, this));
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter
    public void updateVoiceSync(int voiceIndex) {
        VoiceRecordMenuContract.IParent iParent = this.mParent;
        if (iParent != null) {
            iParent.updateVoiceSync(voiceIndex);
        }
    }
}
