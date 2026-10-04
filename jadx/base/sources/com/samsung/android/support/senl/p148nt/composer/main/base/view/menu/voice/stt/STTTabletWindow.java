package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt;

import android.view.View;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import com.samsung.android.support.senl.p148nt.stt.controller.STTFloatingController;
import com.samsung.android.support.senl.p148nt.stt.controller.STTVoiceDataController;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001EB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J \u0010\u0019\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u000eH\u0016J\u0018\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0014H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0016J\b\u00104\u001a\u00020\fH\u0016J\b\u00105\u001a\u00020\fH\u0016J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u000eH\u0016J\b\u00108\u001a\u00020\u000eH\u0016J\b\u00109\u001a\u00020\u000eH\u0016J\b\u0010:\u001a\u00020\u000eH\u0016J\b\u0010;\u001a\u00020\u000eH\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010=\u001a\u00020\u0014H\u0016J\b\u0010>\u001a\u00020\u000eH\u0016J\b\u0010?\u001a\u00020\u000eH\u0016J\u0010\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u000eH\u0016J\b\u0010B\u001a\u00020\fH\u0016J\b\u0010C\u001a\u00020\u000eH\u0016J\b\u0010D\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/stt/STTTabletWindow;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/stt/ISTTWindow;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/stt/ISTTWindow$IAIContract;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;)V", "mSTTPresenter", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;", "mAiContextMenuPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/presenter/AiContextMenuPresenter;", "init", "", "isShowingState", "", Constants.IntentExtraValue.SHOW, "keySearch", "", "isFromBackward", "indexCurrentSearchSTT", "", "search", "clearSearchComposer", "showHelpView", "position", "showState", "hide", "toggleShowView", "initSTTView", "sttContainer", "Landroid/view/View;", "getSTTPresenter", "getSTTCurrentVoiceItemText", "showTabletSTTList", "onReleaseSection", "getCurrentSTTVoiceName", "getCurrentVoiceName", "reConvertCurrentItem", "isTranscriptAgain", "addAiMenuSTTProcessListener", "index", "aiMenuSTTProcessListener", "Lcom/samsung/android/support/senl/nt/stt/presenter/AiMenuSTTProcessListener;", "removeAiMenuSTTProcessListener", "getCurrentConvertSession", "getOriginalSTTListView", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "getSyncSTTItem", "timeStamp", "", "syncSTT", "voiceIndex", "toggleEditMode", "checkDataChanged", "saveSTTData", "isUpdated", "isEditMode", "isFocusingEditMode", "isSTTSearchMode", "isSTTSelectionSummaryMode", "executeSTT", "getIndexItemToShow", "isCurrentVoiceHaveSTTData", "getShowSpeakerLabel", "setShowSpeakerLabel", "isShowSpeakerLabel", "showRemoveTranscribeDialog", "checkCurrentVoiceEmptyData", "canSummarizeBySubject", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTTabletWindow implements ISTTWindow, ISTTWindow.IAIContract {
    public static final int MAX_VOICE_LENGTH_TO_SUMMARIZE_BY_SUBJECT = 10800000;
    private AiContextMenuPresenter mAiContextMenuPresenter;

    @NotNull
    private final VoiceRecordMenuPresenter mPresenter;

    @NotNull
    private final STTPresenter mSTTPresenter;

    public STTTabletWindow(@NotNull VoiceRecordMenuPresenter mPresenter) {
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mPresenter = mPresenter;
        this.mSTTPresenter = mPresenter.getSTTPresenter();
    }

    private final void showState(String keySearch, boolean isFromBackward, int indexCurrentSearchSTT) {
        this.mSTTPresenter.hideHelpView();
        this.mSTTPresenter.getFloatingController().showContainer();
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        aiContextMenuPresenter.executeSTT(keySearch, isFromBackward, indexCurrentSearchSTT);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void addAiMenuSTTProcessListener(int index, @NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        Intrinsics.checkNotNullParameter(aiMenuSTTProcessListener, "aiMenuSTTProcessListener");
        this.mSTTPresenter.addAiMenuSTTProcessListener(index, aiMenuSTTProcessListener);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean canSummarizeBySubject() {
        int mItemIndexToShow = this.mSTTPresenter.getMItemIndexToShow();
        STTVoiceDataController voiceDataController = this.mSTTPresenter.getVoiceDataController();
        List<SpenVoiceData> voiceDataList = this.mSTTPresenter.getVoiceDataList();
        return voiceDataController.getVoiceLength(voiceDataList != null ? voiceDataList.get(mItemIndexToShow) : null) <= 10800000;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean checkCurrentVoiceEmptyData() {
        int mItemIndexToShow = this.mSTTPresenter.getMItemIndexToShow();
        if (mItemIndexToShow < 0) {
            return false;
        }
        List<SpenVoiceData> voiceDataList = this.mSTTPresenter.getVoiceDataList();
        if (mItemIndexToShow >= (voiceDataList != null ? voiceDataList.size() : -1)) {
            return false;
        }
        STTVoiceDataController voiceDataController = this.mSTTPresenter.getVoiceDataController();
        List<SpenVoiceData> voiceDataList2 = this.mSTTPresenter.getVoiceDataList();
        return voiceDataController.checkEmptyVoiceData(voiceDataList2 != null ? voiceDataList2.get(mItemIndexToShow) : null);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void checkDataChanged() {
        this.mSTTPresenter.checkDataChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void clearSearchComposer() {
        if (this.mAiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
        }
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        aiContextMenuPresenter.clearSearchComposer();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void executeSTT(int position) {
        this.mSTTPresenter.onSTTItemConvertClick(position);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    @Nullable
    public String getCurrentConvertSession() {
        return this.mSTTPresenter.getCurrentConvertSession();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    @Nullable
    public String getCurrentSTTVoiceName() {
        return this.mSTTPresenter.getCurrentSTTVoiceName();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    @NotNull
    public String getCurrentVoiceName(int position) {
        return this.mSTTPresenter.getCurrentVoiceName(position);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public int getIndexItemToShow() {
        return this.mSTTPresenter.getMItemIndexToShow();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    @Nullable
    public AiSTTListView getOriginalSTTListView() {
        return this.mSTTPresenter.getOriginalSTTListView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    @Nullable
    public String getSTTCurrentVoiceItemText() {
        return this.mSTTPresenter.getCurrentVoiceItemText();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    @NotNull
    /* JADX INFO: renamed from: getSTTPresenter, reason: from getter */
    public STTPresenter getMSTTPresenter() {
        return this.mSTTPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean getShowSpeakerLabel() {
        return this.mSTTPresenter.getShowSpeakerLabel();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public int getSyncSTTItem(long timeStamp) {
        return this.mSTTPresenter.getSyncSTTItem(timeStamp);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void hide() {
        this.mSTTPresenter.getFloatingController().hideContainer();
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        aiContextMenuPresenter.getAiMenuResultManager().hideResultView(false, new boolean[0]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void init() {
        this.mAiContextMenuPresenter = this.mPresenter.getMenuManager().getAiMenuManager().getAiContextMenuPresenter();
        STTFloatingController floatingController = this.mSTTPresenter.getFloatingController();
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        AiContextMenuPresenter aiContextMenuPresenter2 = null;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        floatingController.setShowingState(aiContextMenuPresenter.getAiMenuResultManager().isShowingSTT());
        AiContextMenuPresenter aiContextMenuPresenter3 = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
        } else {
            aiContextMenuPresenter2 = aiContextMenuPresenter3;
        }
        aiContextMenuPresenter2.setSTTWindow(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void initSTTView(@NotNull View sttContainer) {
        Intrinsics.checkNotNullParameter(sttContainer, "sttContainer");
        this.mSTTPresenter.getFloatingController().init(sttContainer);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean isCurrentVoiceHaveSTTData() {
        return this.mSTTPresenter.getVoiceDataController().isHaveSTTData(this.mSTTPresenter.getMItemIndexToShow());
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean isEditMode() {
        return this.mSTTPresenter.isSTTEditMode();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean isFocusingEditMode() {
        return this.mSTTPresenter.isFocusingSTTEditMode();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean isSTTSearchMode() {
        return this.mSTTPresenter.isSTTSearchMode();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public boolean isSTTSelectionSummaryMode() {
        return this.mSTTPresenter.isSelectionSummaryMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public boolean isShowingState() {
        if (!this.mSTTPresenter.getFloatingController().getIsShowingState()) {
            return false;
        }
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        return aiContextMenuPresenter.getAiMenuResultManager().isShowingResultView();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void onReleaseSection() {
        if (this.mSTTPresenter.isSTTEditMode() || this.mSTTPresenter.isSelectionMode()) {
            this.mSTTPresenter.setMode(STTMode.REPLAY);
        }
        this.mSTTPresenter.getFloatingController().setShowingState(false);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void reConvertCurrentItem(boolean isTranscriptAgain) {
        this.mSTTPresenter.reConvertCurrentItem(isTranscriptAgain);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void removeAiMenuSTTProcessListener(int index) {
        this.mSTTPresenter.removeAiMenuSTTProcessListener(index);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void saveSTTData(boolean isUpdated) {
        this.mSTTPresenter.saveSTTData(isUpdated);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void search(@NotNull String keySearch, boolean isFromBackward) {
        Intrinsics.checkNotNullParameter(keySearch, "keySearch");
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        aiContextMenuPresenter.search(keySearch, isFromBackward);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void setShowSpeakerLabel(boolean isShowSpeakerLabel) {
        this.mSTTPresenter.setShowSpeakerLabel(isShowSpeakerLabel);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void show() {
        showState();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void showHelpView(int position) {
        this.mSTTPresenter.showHelpView(position);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void showRemoveTranscribeDialog() {
        this.mSTTPresenter.showRemoveTranscribeDialog();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void showTabletSTTList() {
        this.mSTTPresenter.showTabletVoiceList();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void syncSTT(int voiceIndex, long timeStamp) {
        this.mSTTPresenter.syncSTT(voiceIndex, timeStamp);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.stt.ISTTWindow.IAIContract
    public void toggleEditMode() {
        if (this.mSTTPresenter.isSTTEditMode()) {
            AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
            if (aiContextMenuPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
                aiContextMenuPresenter = null;
            }
            aiContextMenuPresenter.hideSIP();
        }
        this.mSTTPresenter.toggleSTTEditMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void toggleShowView() {
        if (!isShowingState() && !this.mSTTPresenter.getVoiceDataController().isHaveSTTData()) {
            this.mSTTPresenter.setTranscriptToOtherLanguage(false);
            this.mSTTPresenter.showSettingLanguageDialog();
        }
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        if (!aiContextMenuPresenter.getAiMenuResultManager().isShowingSTT()) {
            showState();
        } else if (isShowingState()) {
            hide();
        } else {
            showState();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt.ISTTWindow
    public void show(@NotNull String keySearch, boolean isFromBackward, int indexCurrentSearchSTT) {
        Intrinsics.checkNotNullParameter(keySearch, "keySearch");
        showState(keySearch, isFromBackward, indexCurrentSearchSTT);
    }

    private final void showState() {
        this.mSTTPresenter.hideHelpView();
        this.mSTTPresenter.getFloatingController().showContainer();
        AiContextMenuPresenter aiContextMenuPresenter = this.mAiContextMenuPresenter;
        if (aiContextMenuPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAiContextMenuPresenter");
            aiContextMenuPresenter = null;
        }
        aiContextMenuPresenter.executeSTT();
    }
}
