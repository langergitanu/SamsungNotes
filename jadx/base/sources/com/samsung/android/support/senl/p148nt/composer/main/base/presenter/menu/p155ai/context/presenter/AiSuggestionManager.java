package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAiSuggestionPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.AiSuggestionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/presenter/AiSuggestionManager;", "", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mControllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/presenter/AiSuggestionManager$Contract;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/presenter/AiSuggestionManager$Contract;)V", "mAiSuggestionView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/composer/AiSuggestionView;", "hideAiSuggestionView", "", "isSupported", "", "doAiSuggestionForTranslation", "runnableAiSuggestionForAutoFormat", "Ljava/lang/Runnable;", "getRunnableAiSuggestionForAutoFormat", "()Ljava/lang/Runnable;", "release", "isShowing", "()Z", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiSuggestionManager {

    @NotNull
    private static final String TAG;

    @Nullable
    private AiSuggestionView mAiSuggestionView;

    @NotNull
    private final ComposerViewPresenter mComposerViewPresenter;

    @Nullable
    private Contract mContract;

    @NotNull
    private ControllerManager mControllerManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/presenter/AiSuggestionManager$Contract;", "", "executeAiSuggestion", "", "type", "", "isDirectAction", "", "args", "", "hideResultView", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void executeAiSuggestion(int type, boolean isDirectAction, @Nullable String args);

        void hideResultView();
    }

    static {
        String strCreateTag = Logger.createTag("AiSuggestionManager", AiConstants.PREFIX_TAG);
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public AiSuggestionManager(@NotNull ComposerViewPresenter mComposerViewPresenter, @NotNull ControllerManager mControllerManager, @Nullable Contract contract) {
        Intrinsics.checkNotNullParameter(mComposerViewPresenter, "mComposerViewPresenter");
        Intrinsics.checkNotNullParameter(mControllerManager, "mControllerManager");
        this.mComposerViewPresenter = mComposerViewPresenter;
        this.mControllerManager = mControllerManager;
        this.mContract = contract;
        this.mAiSuggestionView = new AiSuggestionView(mComposerViewPresenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_runnableAiSuggestionForAutoFormat_$lambda$1(AiSuggestionManager aiSuggestionManager, int i, int i2) {
        String text = aiSuggestionManager.mComposerViewPresenter.getComposerModel().getDoc().getBodyText().getText();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Intrinsics.checkNotNull(text);
        int length = text.length() - i;
        if (200 >= length || aiSuggestionManager.mAiSuggestionView == null) {
            return;
        }
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_AI_SUGGESTION_AUTO_FORMAT);
        AiSuggestionView aiSuggestionView = aiSuggestionManager.mAiSuggestionView;
        if (aiSuggestionView != null) {
            aiSuggestionView.show(3, null, new RunnableC9349i(aiSuggestionManager, i2, length, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _get_runnableAiSuggestionForAutoFormat_$lambda$1$lambda$0(AiSuggestionManager aiSuggestionManager, int i, int i2) {
        try {
            Intrinsics.checkNotNull(aiSuggestionManager.mComposerViewPresenter.getComposerModel().getDoc().getBodyText().getText());
            int iMin = (int) Math.min(i2 + i, r0.length());
            boolean z = iMin - i < AiMaxLength.LEN_SELECTED_MAX;
            aiSuggestionManager.mComposerViewPresenter.getComposerModel().getDoc().getBodyText().setSelection(i, iMin);
            ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, ComposerSAConstants.EVENT_AI_SUGGESTION_EXECUTE_AUTO_FORMAT);
            Contract contract = aiSuggestionManager.mContract;
            if (contract != null) {
                contract.executeAiSuggestion(3, z, null);
            }
        } catch (Exception e) {
            AbstractC8014b.m7207i("identifyLanguage#getRunnableAiSuggestionForAutoFormat# Runnable e = ", e, TAG);
        }
    }

    private final boolean isSupported() {
        if (this.mComposerViewPresenter.getComposerModel().getComposerState().isSupportedAiMenu() && FeatureInfo.isAiFeatureEnabled()) {
            return (this.mComposerViewPresenter.getComposerModel().isPDFReader() && this.mComposerViewPresenter.getComposerModel().isSimpleMode()) ? false : true;
        }
        return false;
    }

    public final void doAiSuggestionForTranslation() {
        if (isSupported()) {
            this.mControllerManager.getTaskController().execute(new TaskAiSuggestionPdf(), new TaskAiSuggestionPdf.InputValues(this.mComposerViewPresenter.getPdfManager(), this.mComposerViewPresenter.getTextManager(), this.mComposerViewPresenter.getDoc(), this.mComposerViewPresenter.getCurrentPageIndex()), new C9336xa4dd8d3(this), false);
        }
    }

    @Nullable
    public final Runnable getRunnableAiSuggestionForAutoFormat() {
        int length;
        if (!isSupported()) {
            return null;
        }
        SpenObjectTextBox bodyText = this.mComposerViewPresenter.getComposerModel().getDoc().getBodyText();
        if (bodyText.getText() != null) {
            String text = this.mComposerViewPresenter.getComposerModel().getDoc().getBodyText().getText();
            Intrinsics.checkNotNull(text);
            length = text.length();
        } else {
            length = 0;
        }
        int selectedStart = bodyText.getSelectedStart();
        if (selectedStart < 0) {
            selectedStart = bodyText.getCursorPosition();
        }
        return new RunnableC9349i(this, length, selectedStart, 1);
    }

    public final void hideAiSuggestionView() {
        AiSuggestionView aiSuggestionView = this.mAiSuggestionView;
        if (aiSuggestionView != null) {
            aiSuggestionView.hide();
        }
    }

    public final boolean isShowing() {
        AiSuggestionView aiSuggestionView = this.mAiSuggestionView;
        return aiSuggestionView != null && aiSuggestionView.isShowing();
    }

    public final void release() {
        AiSuggestionView aiSuggestionView = this.mAiSuggestionView;
        if (aiSuggestionView != null) {
            aiSuggestionView.release();
        }
        this.mAiSuggestionView = null;
        this.mContract = null;
    }
}
