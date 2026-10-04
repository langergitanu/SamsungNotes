package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.stt;

import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/stt/ISTTWindow;", "", "init", "", "isShowingState", "", Constants.IntentExtraValue.SHOW, "showHelpView", "position", "", "hide", "toggleShowView", "keySearch", "", "isFromBackward", "indexCurrentSearchSTT", "search", "clearSearchComposer", "IAIContract", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ISTTWindow {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\n\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000fH&J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0012H&J\b\u0010$\u001a\u00020\u0012H&J\b\u0010%\u001a\u00020\u0012H&J\b\u0010&\u001a\u00020\u0012H&J\b\u0010'\u001a\u00020\u0012H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010)\u001a\u00020\u000fH&J\b\u0010*\u001a\u00020\u0012H&J\b\u0010+\u001a\u00020\u0012H&J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0012H&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0012H&J\b\u00100\u001a\u00020\u0012H&¨\u00061"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/stt/ISTTWindow$IAIContract;", "", "initSTTView", "", "sttContainer", "Landroid/view/View;", "getSTTPresenter", "Lcom/samsung/android/support/senl/nt/stt/presenter/STTPresenter;", "getSTTCurrentVoiceItemText", "", "showTabletSTTList", "onReleaseSection", "getCurrentSTTVoiceName", "getCurrentVoiceName", "position", "", "reConvertCurrentItem", "isTranscriptAgain", "", "addAiMenuSTTProcessListener", "index", "aiMenuSTTProcessListener", "Lcom/samsung/android/support/senl/nt/stt/presenter/AiMenuSTTProcessListener;", "removeAiMenuSTTProcessListener", "getCurrentConvertSession", "getOriginalSTTListView", "Lcom/samsung/android/support/senl/nt/stt/view/AiSTTListView;", "getSyncSTTItem", "timeStamp", "", "syncSTT", "voiceIndex", "toggleEditMode", "checkDataChanged", "saveSTTData", "isUpdated", "isEditMode", "isFocusingEditMode", "isSTTSearchMode", "isSTTSelectionSummaryMode", "executeSTT", "getIndexItemToShow", "isCurrentVoiceHaveSTTData", "getShowSpeakerLabel", "setShowSpeakerLabel", "isShowSpeakerLabel", "showRemoveTranscribeDialog", "checkCurrentVoiceEmptyData", "canSummarizeBySubject", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IAIContract {
        void addAiMenuSTTProcessListener(int index, @NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener);

        boolean canSummarizeBySubject();

        boolean checkCurrentVoiceEmptyData();

        void checkDataChanged();

        void executeSTT(int position);

        @Nullable
        String getCurrentConvertSession();

        @Nullable
        String getCurrentSTTVoiceName();

        @NotNull
        String getCurrentVoiceName(int position);

        int getIndexItemToShow();

        @Nullable
        AiSTTListView getOriginalSTTListView();

        @Nullable
        String getSTTCurrentVoiceItemText();

        @NotNull
        STTPresenter getSTTPresenter();

        boolean getShowSpeakerLabel();

        int getSyncSTTItem(long timeStamp);

        void initSTTView(@NotNull View sttContainer);

        boolean isCurrentVoiceHaveSTTData();

        boolean isEditMode();

        boolean isFocusingEditMode();

        boolean isSTTSearchMode();

        boolean isSTTSelectionSummaryMode();

        void onReleaseSection();

        void reConvertCurrentItem(boolean isTranscriptAgain);

        void removeAiMenuSTTProcessListener(int index);

        void saveSTTData(boolean isUpdated);

        void setShowSpeakerLabel(boolean isShowSpeakerLabel);

        void showRemoveTranscribeDialog();

        void showTabletSTTList();

        void syncSTT(int voiceIndex, long timeStamp);

        void toggleEditMode();
    }

    void clearSearchComposer();

    void hide();

    void init();

    boolean isShowingState();

    void search(@NotNull String keySearch, boolean isFromBackward);

    void show();

    void show(@NotNull String keySearch, boolean isFromBackward, int indexCurrentSearchSTT);

    void showHelpView(int position);

    void toggleShowView();
}
