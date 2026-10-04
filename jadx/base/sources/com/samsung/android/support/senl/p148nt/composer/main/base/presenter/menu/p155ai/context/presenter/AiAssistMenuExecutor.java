package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiBixbyParam;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormatStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.CreateImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.STTTabletLayoutAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrection;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SpellingCorrectionStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Summarization;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SummarizationStreaming;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.TranslatorCommonHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.STTPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiAssistMenuExecutor {
    private static final long SCANNING_ANIMATION_TIME = 500;
    private static final String TAG = Logger.createTag("AiAssistMenuExecutor", AiConstants.PREFIX_TAG);
    private AiContextMenu mAiContextMenu;
    private final AiMenuResultManager mAiMenuResultManager;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private BaseExecutor mExecutor;
    private final Handler mHandler;
    private boolean mIsPendingAiResult = false;
    private final VoiceRecordMenuPresenter mVoiceRecordMenuPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void cleanUpText();

        AiBixbyParam getParam();

        SrcContentInfo getSrcContentInfo();

        void matchSelectionRange(SrcContentInfo srcContentInfo);

        void setParam(AiBixbyParam aiBixbyParam);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class HwExecutor extends BaseExecutor {
        public HwExecutor() {
            super();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor
        public boolean checkAutoFormatLimitation() {
            return true;
        }

        public void cleanUpTextAfterShowScanningEffect() {
            AiAssistMenuExecutor aiAssistMenuExecutor = AiAssistMenuExecutor.this;
            aiAssistMenuExecutor.mIsPendingAiResult = aiAssistMenuExecutor.mAiContextMenu.showScanningEffectView();
            if (AiAssistMenuExecutor.this.mIsPendingAiResult) {
                AiAssistMenuExecutor.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.HwExecutor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiAssistMenuExecutor.this.mContract.cleanUpText();
                    }
                }, 500L);
            } else {
                AiAssistMenuExecutor.this.mContract.cleanUpText();
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor
        public void executeAutoFormat(AutoFormat.FormatType formatType) {
            AiAssistMenuExecutor.this.mContract.setParam(new AiBixbyParam(formatType == AutoFormat.FormatType.Meeting ? 4 : 3, AiAssistMenuExecutor.this.mContract.getParam().getResultAction()));
            cleanUpTextAfterShowScanningEffect();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor
        public void executeSpellingCorrection() {
            AiAssistMenuExecutor.this.mContract.setParam(new AiBixbyParam(5, AiAssistMenuExecutor.this.mContract.getParam().getResultAction()));
            cleanUpTextAfterShowScanningEffect();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor
        public void executeSummarize() {
            AiAssistMenuExecutor.this.mContract.setParam(new AiBixbyParam(2, AiAssistMenuExecutor.this.mContract.getParam().getResultAction()));
            cleanUpTextAfterShowScanningEffect();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor
        public void executeTranslate() {
            if (TextUtils.isEmpty(AiAssistMenuExecutor.this.mContract.getParam().getTargetLanguage())) {
                AiAssistMenuExecutor.this.mContract.setParam(new AiBixbyParam(1, AiAssistMenuExecutor.this.mContract.getParam().getResultAction()));
            }
            cleanUpTextAfterShowScanningEffect();
        }
    }

    public AiAssistMenuExecutor(Handler handler, ComposerViewPresenter composerViewPresenter, VoiceRecordMenuPresenter voiceRecordMenuPresenter, AiMenuResultManager aiMenuResultManager, Contract contract) {
        this.mHandler = handler;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mVoiceRecordMenuPresenter = voiceRecordMenuPresenter;
        this.mAiMenuResultManager = aiMenuResultManager;
        this.mContract = contract;
    }

    public void clearPendingFlag() {
        this.mIsPendingAiResult = false;
    }

    public BaseExecutor getExecutor() {
        return this.mExecutor;
    }

    public boolean isPendingAiResult() {
        return this.mIsPendingAiResult;
    }

    public void setAiContextMenu(AiContextMenu aiContextMenu) {
        this.mAiContextMenu = aiContextMenu;
    }

    public void setHwBase() {
        this.mExecutor = new HwExecutor();
    }

    public void setTextBase() {
        this.mExecutor = new BaseExecutor();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class BaseExecutor {
        LanguageIdentifier mLanguageIdentifier = new LanguageIdentifier();

        public BaseExecutor() {
        }

        private void executeSpellingCorrectionInner(final SrcContentInfo srcContentInfo) {
            AiCommonUtil.executeActionByServer(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    srcContentInfo.setSrcNote(AiAssistMenuExecutor.this.mComposerViewPresenter.getDoc());
                    CscFeature.Companion companion = CscFeature.INSTANCE;
                    final SpellingCorrection spellingCorrectionStreaming = companion.getInstance().isChinaAiFeature() ? new SpellingCorrectionStreaming(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter) : new SpellingCorrection(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter);
                    if (!TextUtils.isEmpty(srcContentInfo.getSAForAIScenario())) {
                        ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_CORRECT_SPELLING, srcContentInfo.getSAForAIScenario());
                        ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_LENGTH_FOR_CORRECT_SPELLING, ComposerSA.getDetailAiSelectedTextLength(srcContentInfo.getSelectedText().length(), 10000));
                    }
                    AiAssistMenuExecutor aiAssistMenuExecutor = AiAssistMenuExecutor.this;
                    aiAssistMenuExecutor.mIsPendingAiResult = aiAssistMenuExecutor.mAiContextMenu.showScanningEffectView();
                    if (AiAssistMenuExecutor.this.mIsPendingAiResult) {
                        final boolean zIsChinaAiFeature = companion.getInstance().isChinaAiFeature();
                        if (!zIsChinaAiFeature) {
                            spellingCorrectionStreaming.execute();
                        }
                        AiAssistMenuExecutor.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(spellingCorrectionStreaming);
                                if (zIsChinaAiFeature) {
                                    spellingCorrectionStreaming.execute();
                                }
                            }
                        }, 500L);
                    } else {
                        AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(spellingCorrectionStreaming);
                        spellingCorrectionStreaming.execute();
                    }
                    AiAssistMenuExecutor.this.mAiContextMenu.hide();
                }
            });
        }

        private void executeTranslateInner(final SrcContentInfo srcContentInfo) {
            AiCommonUtil.executeActionByOndevice(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.4
                private void setLanguage(Translation translation) {
                    if (TextUtils.isEmpty(AiAssistMenuExecutor.this.mContract.getParam().getTargetLanguage())) {
                        return;
                    }
                    translation.setLastLanguage(AiAssistMenuExecutor.this.mContract.getParam().getTargetLanguage());
                    AiAssistMenuExecutor.this.mContract.getParam().setTargetLanguage("");
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!Translation.preCheck(srcContentInfo.getSelectedText())) {
                        ToastHandler.show(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), C9086R.string.ai_not_supported_from_language, 1);
                        AiAssistMenuExecutor.this.mAiContextMenu.hide();
                        return;
                    }
                    if (!TextUtils.isEmpty(srcContentInfo.getSAForAIScenario())) {
                        if (srcContentInfo.getSrcType() == 0) {
                            ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_AI_TRANSLATE, srcContentInfo.getSAForAIScenario());
                        } else {
                            ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_TRANSLATE, srcContentInfo.getSAForAIScenario());
                        }
                        ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_LENGTH_FOR_TRANSLATE, ComposerSA.getDetailAiSelectedTextLength(srcContentInfo.getSelectedText().length(), 10000));
                    }
                    srcContentInfo.setSrcNote(AiAssistMenuExecutor.this.mComposerViewPresenter.getDoc());
                    final Translation translation = new Translation(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter);
                    setLanguage(translation);
                    AiAssistMenuExecutor aiAssistMenuExecutor = AiAssistMenuExecutor.this;
                    aiAssistMenuExecutor.mIsPendingAiResult = aiAssistMenuExecutor.mAiContextMenu.showScanningEffectView();
                    if (AiAssistMenuExecutor.this.mIsPendingAiResult) {
                        translation.execute();
                        AiAssistMenuExecutor.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(translation);
                            }
                        }, 500L);
                    } else {
                        AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(translation);
                        translation.execute();
                    }
                    AiAssistMenuExecutor.this.mAiContextMenu.hide();
                }
            });
        }

        private void showResult(final AutoFormat.FormatType formatType, final SrcContentInfo srcContentInfo) {
            AiCommonUtil.executeActionByServer(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    CscFeature.Companion companion = CscFeature.INSTANCE;
                    final AutoFormat autoFormatStreaming = companion.getInstance().isChinaAiFeature() ? new AutoFormatStreaming(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter) : new AutoFormat(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter);
                    autoFormatStreaming.setCurrentFormatType(formatType);
                    if (!TextUtils.isEmpty(srcContentInfo.getSAForAIScenario())) {
                        String sAForAIScenarioScreenID = srcContentInfo.getSAForAIScenarioScreenID();
                        AutoFormat.FormatType formatType2 = formatType;
                        AutoFormat.FormatType formatType3 = AutoFormat.FormatType.Meeting;
                        ComposerSA.insertLog(sAForAIScenarioScreenID, formatType2.equals(formatType3) ? ComposerSAConstants.EVENT_AI_MEETING_NOTES : ComposerSAConstants.EVENT_AI_HEADERS_AND_BULLETS, srcContentInfo.getSAForAIScenario());
                        ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), formatType.equals(formatType3) ? ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_MEETING_NOTES : ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_HEADERS_AND_BULLETS, ComposerSA.getDetailAiSelectedTextLength(srcContentInfo.getSelectedText().length(), 10000));
                    }
                    AiAssistMenuExecutor aiAssistMenuExecutor = AiAssistMenuExecutor.this;
                    aiAssistMenuExecutor.mIsPendingAiResult = aiAssistMenuExecutor.mAiContextMenu.showScanningEffectView();
                    if (AiAssistMenuExecutor.this.mIsPendingAiResult) {
                        final boolean zIsChinaAiFeature = companion.getInstance().isChinaAiFeature();
                        if (!zIsChinaAiFeature) {
                            autoFormatStreaming.execute();
                        }
                        AiAssistMenuExecutor.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(autoFormatStreaming);
                                if (zIsChinaAiFeature) {
                                    autoFormatStreaming.execute();
                                }
                            }
                        }, 500L);
                    } else {
                        AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(autoFormatStreaming);
                        autoFormatStreaming.execute();
                    }
                    AiAssistMenuExecutor.this.mAiContextMenu.hide();
                }
            });
        }

        public boolean checkAutoFormatLimitation() {
            SrcContentInfo srcContentInfo = AiAssistMenuExecutor.this.mContract.getSrcContentInfo();
            if (srcContentInfo == null) {
                return false;
            }
            boolean zCheckLimitationAndSplit = AutoFormat.checkLimitationAndSplit(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), srcContentInfo, this.mLanguageIdentifier.identifyLanguageSync(AiMaxLength.getIdentifyTargetStr(srcContentInfo.getSelectedText())));
            if (!zCheckLimitationAndSplit) {
                AiAssistMenuExecutor.this.mContract.matchSelectionRange(srcContentInfo);
            }
            return zCheckLimitationAndSplit;
        }

        public void executeAutoFormat(AutoFormat.FormatType formatType) {
            SrcContentInfo srcContentInfo = AiAssistMenuExecutor.this.mContract.getSrcContentInfo();
            if (srcContentInfo == null) {
                return;
            }
            if (srcContentInfo.mSrcType == 0) {
                Logger.m11000e(AiAssistMenuExecutor.TAG, "executeAutoFormat# pdf is not supported");
                AiAssistMenuExecutor.this.mAiContextMenu.hide();
            } else if (checkAutoFormatLimitation()) {
                showResult(formatType, srcContentInfo);
            }
        }

        public void executeCreateImage(CreateImage createImage) {
            AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(createImage);
            createImage.execute();
        }

        public void executeSTT() {
            STTTabletLayoutAction sTTTabletLayoutAction = new STTTabletLayoutAction();
            SrcContentInfo srcContentInfo = new SrcContentInfo(-1);
            if (AiAssistMenuExecutor.this.mContract.getParam() != null) {
                srcContentInfo.setAiBixbyParam(AiAssistMenuExecutor.this.mContract.getParam());
            }
            sTTTabletLayoutAction.init(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter, AiAssistMenuExecutor.this.mAiMenuResultManager.getAiSTTContract());
            AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(sTTTabletLayoutAction);
        }

        public void executeSpellingCorrection() {
            SrcContentInfo srcContentInfo = AiAssistMenuExecutor.this.mContract.getSrcContentInfo();
            if (srcContentInfo == null) {
                return;
            }
            if (srcContentInfo.mSrcType == 0) {
                Logger.m11000e(AiAssistMenuExecutor.TAG, "executeSpellingCorrection# pdf is not supported");
                AiAssistMenuExecutor.this.mAiContextMenu.hide();
            } else if (SpellingCorrection.checkLimitationAndSplit(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), srcContentInfo, null)) {
                executeSpellingCorrectionInner(srcContentInfo);
            } else {
                AiAssistMenuExecutor.this.mContract.matchSelectionRange(srcContentInfo);
            }
        }

        public void executeSummarize() {
            Logger.m10999d(AiAssistMenuExecutor.TAG, "executeSummarize#");
            final SrcContentInfo srcContentInfo = AiAssistMenuExecutor.this.mContract.getSrcContentInfo();
            if (srcContentInfo == null) {
                return;
            }
            String selectedText = srcContentInfo.getSelectedText();
            if (Summarization.isLimitedMinLength(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), selectedText, true)) {
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_SUMMARIZE, ComposerSA.getDetailAiSelectedTextLength(selectedText.length(), 10000));
            } else if (!Summarization.checkLimitationAndSplit(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), srcContentInfo, this.mLanguageIdentifier)) {
                AiAssistMenuExecutor.this.mContract.matchSelectionRange(srcContentInfo);
            } else {
                Summarization.executeWithSetting(AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity(), new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final boolean zIsChinaAiFeature = CscFeature.INSTANCE.getInstance().isChinaAiFeature();
                        final Summarization summarizationStreaming = zIsChinaAiFeature ? new SummarizationStreaming(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter) : new Summarization(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter);
                        if (!TextUtils.isEmpty(srcContentInfo.getSAForAIScenario())) {
                            ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_SUMMARIZE, srcContentInfo.getSAForAIScenario());
                            ComposerSA.insertLog(srcContentInfo.getSAForAIScenarioScreenID(), ComposerSAConstants.EVENT_AI_LENGTH_FOR_AF_SUMMARIZE, ComposerSA.getDetailAiSelectedTextLength(srcContentInfo.getSelectedText().length(), 10000));
                        }
                        AiAssistMenuExecutor aiAssistMenuExecutor = AiAssistMenuExecutor.this;
                        aiAssistMenuExecutor.mIsPendingAiResult = aiAssistMenuExecutor.mAiContextMenu.showScanningEffectView();
                        if (AiAssistMenuExecutor.this.mIsPendingAiResult) {
                            if (!zIsChinaAiFeature) {
                                summarizationStreaming.execute();
                            }
                            AiAssistMenuExecutor.this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiAssistMenuExecutor.BaseExecutor.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(summarizationStreaming);
                                    if (zIsChinaAiFeature) {
                                        summarizationStreaming.execute();
                                    }
                                }
                            }, 500L);
                        } else {
                            AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(summarizationStreaming);
                            summarizationStreaming.execute();
                        }
                        AiAssistMenuExecutor.this.mAiContextMenu.hide();
                    }
                });
            }
        }

        public void executeTranscribe() {
            if (AiAssistMenuExecutor.this.mVoiceRecordMenuPresenter == null) {
                Logger.m11000e(AiAssistMenuExecutor.TAG, "executeTranscribe# mVoiceRecordMenuPresenter == null");
                return;
            }
            STTPresenterImpl sTTPresenter = AiAssistMenuExecutor.this.mVoiceRecordMenuPresenter.getSTTPresenter();
            Activity activity = AiAssistMenuExecutor.this.mComposerViewPresenter.getActivity();
            Objects.requireNonNull(sTTPresenter);
            AiCommonUtil.executeActionByOndevice(activity, new RunnableC9347g(sTTPresenter, 1));
        }

        public void executeTranslate() {
            SrcContentInfo srcContentInfo = AiAssistMenuExecutor.this.mContract.getSrcContentInfo();
            if (srcContentInfo == null) {
                return;
            }
            if (AiAssistMenuExecutor.this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
                srcContentInfo.setSelectedText(TranslatorCommonHelper.preProcess(srcContentInfo.getSelectedText()));
            }
            executeTranslateInner(srcContentInfo);
        }

        public void search(String str, boolean z) {
            AiAssistMenuExecutor.this.mAiMenuResultManager.search(str, z);
        }

        public void executeSTT(String str, boolean z, int i) {
            STTTabletLayoutAction sTTTabletLayoutAction = new STTTabletLayoutAction();
            SrcContentInfo srcContentInfo = new SrcContentInfo(-1);
            if (AiAssistMenuExecutor.this.mContract.getParam() != null) {
                srcContentInfo.setAiBixbyParam(AiAssistMenuExecutor.this.mContract.getParam());
            }
            sTTTabletLayoutAction.init(srcContentInfo, AiAssistMenuExecutor.this.mComposerViewPresenter, AiAssistMenuExecutor.this.mAiMenuResultManager.getAiSTTContract());
            AiAssistMenuExecutor.this.mAiMenuResultManager.showResultView(sTTTabletLayoutAction, str, z, i);
        }
    }
}
