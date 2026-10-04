package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover;

import androidx.annotation.WorkerThread;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiCoverDataSrcCollector {
    private static final String TAG = Logger.createTag("AiCoverDataSrcCollector");
    AiCoverMenuViewPresenter mAiCoverMenuViewPresenter;
    ComposerViewPresenter mComposerViewPresenter;
    ExecutorService mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
    ResultListener mResultListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        @WorkerThread
        void onFinished(String str);
    }

    public AiCoverDataSrcCollector(ComposerViewPresenter composerViewPresenter, AiCoverMenuViewPresenter aiCoverMenuViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mAiCoverMenuViewPresenter = aiCoverMenuViewPresenter;
    }

    public boolean canCollect() {
        SuggestedCoverEntity suggestedCoverEntity = AiCoverDataCreatorManager.getInstance().getSuggestedCoverEntity(this.mComposerViewPresenter.getComposerModel().getDocInfo().getUuid());
        return suggestedCoverEntity == null || suggestedCoverEntity.getState() == 0 || suggestedCoverEntity.getState() == -2;
    }

    public void collectData(final ResultListener resultListener) {
        if (this.mAiCoverMenuViewPresenter.isCoverMenuEnabled(true)) {
            Logger.m10999d(TAG, "collectData#");
            final String uuid = this.mComposerViewPresenter.getComposerModel().getDocInfo().getUuid();
            if (canCollect()) {
                this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataSrcCollector.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Logger.m10999d(AiCoverDataSrcCollector.TAG, "collectData# start");
                        String strExtractText = new AiCoverSrcExtractor().extractText(AiCoverDataSrcCollector.this.mComposerViewPresenter.getActivity(), AiCoverDataSrcCollector.this.mComposerViewPresenter.getDoc(), AiCoverDataSrcCollector.this.mComposerViewPresenter.getComposerModel().getDocInfo().getDocPath());
                        SuggestedCoverEntity suggestedCoverEntity = AiCoverDataCreatorManager.getInstance().getSuggestedCoverEntity(uuid);
                        if (suggestedCoverEntity == null || suggestedCoverEntity.getState() == -2) {
                            AiCoverDataCreatorManager.getInstance().updateSuggestedCoverEntity(uuid, 0);
                        }
                        AiCoverDataSrcCollector.this.mResultListener.onFinished(strExtractText);
                        ResultListener resultListener2 = resultListener;
                        if (resultListener2 != null) {
                            resultListener2.onFinished(strExtractText);
                        }
                    }
                });
                return;
            }
            SuggestedCoverEntity suggestedCoverEntity = AiCoverDataCreatorManager.getInstance().getSuggestedCoverEntity(uuid);
            if (suggestedCoverEntity == null || suggestedCoverEntity.getState() != 0) {
                return;
            }
            AiCoverDataCreatorManager.getInstance().updateSuggestedCoverEntity(uuid, -2);
        }
    }

    public void setResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }
}
