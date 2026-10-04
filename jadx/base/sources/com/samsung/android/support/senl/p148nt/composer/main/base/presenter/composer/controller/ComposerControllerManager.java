package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerControllerManager {
    private final ComposerModeController mComposerModeController;
    private final ComposerSelectionController mComposerSelectionController;
    private final ComposerSipController mCompSipController = new ComposerSipController();
    private final ComposerVoiceController mCompVoiceController = new ComposerVoiceController();
    private final ComposerSearchController mCompSearchController = new ComposerSearchController();
    private final ScrollController mScrollController = new ScrollController();
    private final CvPageSettingController mCvPageSettingController = new CvPageSettingController();
    private final TextOnlyModeController mTextOnlyModeController = new TextOnlyModeController();
    private final ComposerAiController mComposerAiController = new ComposerAiController();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends ConfigurationFactory {
        @NonNull
        ComposerModeController createComposerModeController();

        @NonNull
        ComposerSelectionController createComposerSelectionController();
    }

    public ComposerControllerManager(@NonNull ComponentFactory componentFactory) {
        this.mComposerModeController = componentFactory.createComposerModeController();
        this.mComposerSelectionController = componentFactory.createComposerSelectionController();
    }

    public ComposerSearchController getCompSearchController() {
        return this.mCompSearchController;
    }

    public ComposerSipController getCompSipController() {
        return this.mCompSipController;
    }

    public ComposerVoiceController getCompVoiceController() {
        return this.mCompVoiceController;
    }

    public ComposerAiController getComposerAiController() {
        return this.mComposerAiController;
    }

    public ComposerModeController getComposerModeController() {
        return this.mComposerModeController;
    }

    public ComposerSelectionController getComposerSelectionController() {
        return this.mComposerSelectionController;
    }

    public CvPageSettingController getCvPageSettingController() {
        return this.mCvPageSettingController;
    }

    public HyperTextUpdateController getHyperTextUpdateController() {
        return this.mComposerModeController.getHyperTextUpdateController();
    }

    public ScrollController getScrollController() {
        return this.mScrollController;
    }

    public TextOnlyModeController getTextOnlyModeController() {
        return this.mTextOnlyModeController;
    }

    public void init(ComposerModel composerModel, ControllerManager controllerManager, ModelManager modelManager) {
        this.mComposerSelectionController.init(modelManager, composerModel.getModeManager());
        this.mCompSipController.init(composerModel, controllerManager, modelManager);
        this.mCompVoiceController.init(composerModel);
        this.mComposerModeController.init(composerModel, controllerManager, modelManager, this.mCompSearchController);
        this.mScrollController.init(controllerManager, modelManager.getPageManager());
        this.mCvPageSettingController.init(modelManager.getPageManager(), modelManager.getNoteManager());
        this.mTextOnlyModeController.init(composerModel);
        this.mComposerAiController.init(modelManager.getTextManager(), modelManager.getPdfManager());
    }

    public void onAttachView(ComposerControllerContract composerControllerContract) {
        this.mCompSipController.setView(composerControllerContract);
        this.mCompSearchController.setView(composerControllerContract);
        this.mCompVoiceController.setView(composerControllerContract);
        this.mComposerModeController.setView(composerControllerContract);
        this.mScrollController.setView(composerControllerContract);
        this.mCvPageSettingController.setView(composerControllerContract);
        this.mTextOnlyModeController.setView(composerControllerContract);
    }

    public void onDetachView() {
        this.mCompSipController.setView(null);
        this.mCompSearchController.setView(null);
        this.mCompVoiceController.setView(null);
        this.mComposerModeController.setView(null);
        this.mScrollController.setView(null);
        this.mCvPageSettingController.setView(null);
        this.mTextOnlyModeController.setView(null);
    }
}
