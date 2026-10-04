package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import android.view.View;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract;", "", "IView", "IParent", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface VoiceRecordMenuContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J*\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&J\u0012\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\nH&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\bH&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IParent;", "", "updateVoiceMenu", "", "showAudioPlayView", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "time", "", "isPlay", "", "isClearState", "showRecordingView", "showInitView", "runWithAnimation", "setSPDVoiceTagPath", "voiceTagPath", "", "getSPDVoiceTagPath", "seekToSTTTouchedWord", "progress", "onVoiceDataListChange", "voiceIndex", "onDialogClickedConvertButton", "onUpdateListVoiceBtnState", "isEnabled", "onUpdateMoveBtnState", "updateVoiceSync", "showRecordingPlayView", "showDeleteConfirmDialog", "anchorView", "Landroid/view/View;", "onVoiceDataSetChanged", "showRealtimeTranscribe", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IParent {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void showInitView$default(IParent iParent, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInitView");
                }
                if ((i & 1) != 0) {
                    z = false;
                }
                iParent.showInitView(z);
            }
        }

        @NotNull
        /* JADX INFO: renamed from: getSPDVoiceTagPath */
        String getMSPDVoiceTagPath();

        void onDialogClickedConvertButton();

        void onUpdateListVoiceBtnState(boolean isEnabled);

        void onUpdateMoveBtnState();

        void onVoiceDataListChange(int voiceIndex);

        void onVoiceDataSetChanged();

        void seekToSTTTouchedWord(int progress);

        void setSPDVoiceTagPath(@NotNull String voiceTagPath);

        void showAudioPlayView(@Nullable SpenObjectVoice objectVoice, int time, boolean isPlay, boolean isClearState);

        void showDeleteConfirmDialog(@Nullable View anchorView);

        void showInitView(boolean runWithAnimation);

        void showRealtimeTranscribe();

        void showRecordingPlayView();

        void showRecordingView();

        void updateVoiceMenu();

        void updateVoiceSync(int voiceIndex);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0003H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0016H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0016H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0016H&J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0016H&J\b\u0010!\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\nH&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\nH&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\nH&J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H&J*\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u0005H&J\u0010\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0005H&J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&J\u0018\u00102\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH&J\b\u00103\u001a\u00020\u0005H&J\u0012\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u000106H&J\b\u00107\u001a\u00020\u0005H&J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\nH&J(\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\nH&J\b\u0010=\u001a\u00020\u0003H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\b\u0010@\u001a\u00020\u0003H&J\b\u0010A\u001a\u00020\u0003H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\nH&J\b\u0010C\u001a\u00020\u0003H&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0005H&J\u0018\u0010F\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u0005H&J\b\u0010G\u001a\u00020\u0003H&J\u000f\u0010H\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u0003H&J\u0012\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020\u0005H&J\b\u0010M\u001a\u00020\u0003H&J\u0010\u0010N\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0005H&J\b\u0010O\u001a\u00020\u0005H&¨\u0006P"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IView;", "", "showInitView", "", "isPlay", "", "runWithAnimation", "showRecordingView", "showRecordingPlayView", "progress", "", "isHidePrevViews", "selectedItem", "hideEditTrashView", "showAudioPlayView", "maxProgress", "time", "hideAudioPlayView", "hideAllView", "onUpdateListVoiceBtnState", "isEnabled", "setRecordTime", "", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState$Type;", "setRecordingTime", "setPlayPauseIcon", "showRecordSimpleMenu", "setPlayTime", "setProgress", "setTotalRecordTime", "setPlaySpeed", "speed", "notifyDataChanged", "notifyItemRemoved", "position", "notifyItemChanged", "notifyItemInserted", "changeMode", "isEditMode", "viewState", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceViewState;", "updateBackground", "color", "invert", "hasBackgroundImage", "updateDialog", "setItemSelectedMode", "selectedMode", "updateSelectedItemMenu", "showEditView", "toggleExpendVoicePanel", "initSTT", "sttContainer", "Landroid/view/View;", "sttOnBackPressed", "onSTTItemStateButtonClick", "index", "keySearch", "isFromBackward", "indexCurrentSearchSTT", "showSTTWindow", "hideSTTWindow", "expandRecordingListVerticalMenu", "updateRecording", "onConfigurationChanged", "updateSTTShowItem", "hideRecordingListView", "updateStatusAnimation", "isAnimation", "search", "clearSearchComposer", "isShowingAiResultView", "()Ljava/lang/Boolean;", "executeAudioEraser", "updateViewForEraser", "needUpdateAnimation", "releaseAudioEraser", "updateAudioEraserAnimation", "isLineVoiceLayout", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IView {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void updateBackground$default(IView iView, int i, boolean z, boolean z2, boolean z3, int i2, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBackground");
                }
                if ((i2 & 8) != 0) {
                    z3 = false;
                }
                iView.updateBackground(i, z, z2, z3);
            }

            public static /* synthetic */ void updateViewForEraser$default(IView iView, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateViewForEraser");
                }
                if ((i & 1) != 0) {
                    z = true;
                }
                iView.updateViewForEraser(z);
            }
        }

        void changeMode(boolean isEditMode, @NotNull VoiceViewState viewState);

        void clearSearchComposer();

        void executeAudioEraser();

        void expandRecordingListVerticalMenu();

        void hideAllView();

        void hideAudioPlayView();

        void hideEditTrashView();

        void hideRecordingListView();

        void hideSTTWindow();

        void initSTT(@Nullable View sttContainer);

        boolean isLineVoiceLayout();

        @Nullable
        Boolean isShowingAiResultView();

        void notifyDataChanged();

        void notifyItemChanged(int position);

        void notifyItemInserted(int position);

        void notifyItemRemoved(int position);

        void onConfigurationChanged();

        void onSTTItemStateButtonClick(int index);

        void onSTTItemStateButtonClick(int index, @NotNull String keySearch, boolean isFromBackward, int indexCurrentSearchSTT);

        void onUpdateListVoiceBtnState(boolean isEnabled);

        void releaseAudioEraser();

        void search(@NotNull String keySearch, boolean isFromBackward);

        void setItemSelectedMode(boolean selectedMode);

        void setPlayPauseIcon(boolean isPlay);

        void setPlaySpeed(@NotNull String speed);

        void setPlayTime(@NotNull String time);

        void setProgress(int progress);

        void setRecordTime(@NotNull String time, @NotNull VoiceViewState.Type type);

        void setRecordingTime(@NotNull String time);

        void setTotalRecordTime(@NotNull String time);

        void showAudioPlayView(int maxProgress, int time, boolean isPlay);

        void showEditView(boolean selectedMode, int selectedItem);

        void showInitView(boolean isPlay, boolean runWithAnimation);

        void showRecordSimpleMenu(boolean isPlay);

        void showRecordingPlayView(boolean isPlay, int progress, boolean isHidePrevViews, int selectedItem);

        void showRecordingView();

        void showSTTWindow();

        boolean sttOnBackPressed();

        boolean toggleExpendVoicePanel();

        void updateAudioEraserAnimation(boolean isEnabled);

        void updateBackground(int color, boolean invert, boolean hasBackgroundImage, boolean updateDialog);

        void updateRecording();

        void updateSTTShowItem(int position);

        void updateSelectedItemMenu(int selectedItem);

        void updateStatusAnimation(boolean isAnimation);

        void updateViewForEraser(boolean needUpdateAnimation);
    }
}
