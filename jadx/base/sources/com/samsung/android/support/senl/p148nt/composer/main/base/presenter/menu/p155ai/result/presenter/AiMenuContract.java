package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.ResultOperation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public interface AiMenuContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IAiAction {
        void addTo(ResultOperation.AddTo addTo);

        boolean canDoAction();

        void copy();

        String getDetailSAAiType();

        SpenObjectTextBox getResultToCopy();

        SrcContentInfo getSrcContentInfo();

        void onSaveInstanceState(@NonNull Bundle bundle);

        void overwrite();

        void restoreState(Bundle bundle, SrcContentInfo srcContentInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IAiActionResultContainer {
        Activity getActivity();

        default void updateContinuesResultState(boolean z) {
        }

        void updateResultState(boolean z, boolean z2);

        default void updateStreamingState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IAiActionResultView {
        void clear();

        IAiAction getAction();

        View inflateView(ViewGroup viewGroup);

        void initView(View view, View view2);

        default boolean isBottomMenuSupported() {
            return true;
        }

        boolean isInitialized();

        default boolean isStreaming() {
            return false;
        }

        void onOrientationChanged(int i);

        void onPageSelected();

        default void onResume() {
        }

        void setTitle();

        void updateLayout(boolean z, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IAiActionSTTResultContainer extends IAiActionResultContainer {
        void executeSummarize(boolean z);

        default void executeTranscribeAgain() {
        }

        default boolean isMinimizeView() {
            return false;
        }

        default void onTabSelected(int i) {
        }

        default void onVoiceInfoChanged() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IView {
        void clearCurrentAiAction();

        void expandView();

        int getCurrentPageIndex();

        boolean getSavedInstanceState();

        void hide(boolean... zArr);

        void hideNormalProgress();

        default boolean isSTTSearchViewFocusing() {
            return false;
        }

        boolean isShowing();

        void minimizeView();

        void onResume();

        void onSaveInstanceState(@NonNull Bundle bundle);

        void onShowSip();

        void setDisableSettingBtn();

        void setEnableReplace(boolean z);

        void setFocusEditResult(boolean z);

        void show(Activity activity);

        void show(Activity activity, String str, boolean z, int i);

        void show(Activity activity, boolean z, Integer num, boolean z2);

        void showNormalProgress();

        void updateNewAiAction();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onCompleted(boolean z);

        void onFailed(String str);

        void onNextCompleted(boolean z);

        void onProgressing();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface STTTranslateResultListener {
        void onTranslateCompleted(boolean z, int i);

        void onTranslateFailed(String str);

        void onTranslateStart();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SubTransition {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface IParentAction {
            int getMaxLength();

            SpenWNote getResultNote();

            String getResultText();

            SpenObjectTextBox getResultToCopy();

            SrcContentInfo getSrcContentInfo();

            SubTranslation getSubTranslation();
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface IParentView {
            boolean isShowingSubTranslation();

            void onLanguageDownload();

            void toggleTranslate();
        }
    }
}
