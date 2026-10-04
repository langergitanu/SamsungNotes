package com.samsung.android.support.senl.p148nt.stt.presenter;

import com.samsung.android.support.senl.p148nt.stt.base.model.mode.STTMode;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\tH\u0016J$\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u001e\u0010\u0017\u001a\u00020\u00032\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/presenter/AiMenuSTTProcessListener;", "", "onCompleted", "", "currentConvertSession", "", "onFailed", "msg", "errorCode", "", "onCancelled", "onConverting", "percent", "onVoiceInfoChanged", "showHelpView", "position", "showAutoDetectHelpView", "messageTranscriptToOtherLanguage", "hideHelpView", "onModeChanged", "prevMode", "Lcom/samsung/android/support/senl/nt/stt/base/model/mode/STTMode;", "onSTTDataSaved", "onSTTItemCheckedChange", "selectedItemMap", "", "", "onLanguageDetected", "languageDetected", "showInfoView", "hideInfoView", "resetSTTViewToDefault", "updateRealtimeCompleteView", "updateAutoTranscribeView", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface AiMenuSTTProcessListener {
    void hideHelpView();

    void hideInfoView();

    void onCancelled(@Nullable String currentConvertSession);

    void onCompleted(@Nullable String currentConvertSession);

    void onConverting(@Nullable String currentConvertSession, int percent);

    void onFailed(@Nullable String currentConvertSession, @Nullable String msg, int errorCode);

    void onLanguageDetected(@Nullable String languageDetected);

    void onModeChanged(@Nullable STTMode prevMode);

    void onSTTDataSaved();

    void onSTTItemCheckedChange(@Nullable Map<Integer, Boolean> selectedItemMap);

    void onVoiceInfoChanged();

    void resetSTTViewToDefault();

    void showAutoDetectHelpView(@Nullable String currentConvertSession, int position, @Nullable String messageTranscriptToOtherLanguage);

    void showHelpView(int position);

    void showInfoView();

    void updateAutoTranscribeView();

    void updateRealtimeCompleteView();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static void hideHelpView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void hideInfoView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void onSTTDataSaved(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void onVoiceInfoChanged(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void resetSTTViewToDefault(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void showInfoView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void updateAutoTranscribeView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void updateRealtimeCompleteView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener) {
        }

        public static void onCancelled(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable String str) {
        }

        public static void onCompleted(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable String str) {
        }

        public static void onLanguageDetected(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable String str) {
        }

        public static void onModeChanged(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable STTMode sTTMode) {
        }

        public static void onSTTItemCheckedChange(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable Map<Integer, Boolean> map) {
        }

        public static void showHelpView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, int i) {
        }

        public static void onFailed(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable String str, @Nullable String str2, int i) {
        }

        public static void showAutoDetectHelpView(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable String str, int i, @Nullable String str2) {
        }

        public static void onConverting(@NotNull AiMenuSTTProcessListener aiMenuSTTProcessListener, @Nullable String str, int i) {
        }
    }
}
