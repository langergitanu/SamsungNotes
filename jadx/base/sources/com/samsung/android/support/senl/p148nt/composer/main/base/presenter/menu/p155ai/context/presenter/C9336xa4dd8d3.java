package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiSuggestionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAiSuggestionPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.AiSuggestionView;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiSuggestionManager$doAiSuggestionForTranslation$resultValuesCallback$1 */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/context/presenter/AiSuggestionManager$doAiSuggestionForTranslation$resultValuesCallback$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/Task$Callback;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/task/TaskAiSuggestionPdf$ResultValues;", "onSuccess", "", "result", "onError", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class C9336xa4dd8d3 implements Task.Callback<TaskAiSuggestionPdf.ResultValues> {
    final /* synthetic */ AiSuggestionManager this$0;

    public C9336xa4dd8d3(AiSuggestionManager aiSuggestionManager) {
        this.this$0 = aiSuggestionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccess$lambda$0(AiSuggestionManager aiSuggestionManager, String str) {
        AiSuggestionManager.Contract contract = aiSuggestionManager.mContract;
        if (contract != null) {
            contract.hideResultView();
        }
        ComposerSA.insertLog(aiSuggestionManager.mComposerViewPresenter.getComposerModel().isPDFReader() ? ComposerSAConstants.SCREEN_PDF_VIEWER : "401", ComposerSAConstants.EVENT_AI_SUGGESTION_EXECUTE_TRANSLATE);
        AiSuggestionManager.Contract contract2 = aiSuggestionManager.mContract;
        if (contract2 != null) {
            contract2.executeAiSuggestion(1, false, str);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
    public void onError(TaskAiSuggestionPdf.ResultValues result) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
    public void onSuccess(TaskAiSuggestionPdf.ResultValues result) {
        if ((result != null ? result.getIdentifiedLocale() : null) == null) {
            Logger.m10999d(AiSuggestionManager.TAG, "ai suggestion identifiedLocale is null ");
            return;
        }
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Logger.m10999d(AiSuggestionManager.TAG, "ai suggestion from " + result.getIdentifiedLocale().getLanguage() + " to " + language);
        if (Intrinsics.areEqual(language, result.getIdentifiedLocale().getLanguage())) {
            return;
        }
        String str = BaseComposerSAConstants.SCREEN_NONE;
        ComposerSA.insertLog(str, ComposerSAConstants.EVENT_AI_SUGGESTION_TRANSLATE);
        ComposerSA.insertLog(str, ComposerSAConstants.EVENT_AI_SUGGESTION_TRANSLATE_TARGET_LANGUAGE, result.getIdentifiedLocale().toLanguageTag());
        ComposerSA.insertLog(str, ComposerSAConstants.EVENT_AI_SUGGESTION_TRANSLATE_SYSTEM_LANGUAGE, locale.toLanguageTag());
        AiSuggestionView aiSuggestionView = this.this$0.mAiSuggestionView;
        if (aiSuggestionView != null) {
            aiSuggestionView.show(1, locale.getDisplayLanguage(), new RunnableC9344d(this.this$0, language, 3));
        }
    }
}
