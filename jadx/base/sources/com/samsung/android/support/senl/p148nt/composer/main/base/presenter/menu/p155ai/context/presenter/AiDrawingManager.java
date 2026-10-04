package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import androidx.work.impl.RunnableC4054d;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.DrawingToolkitsPopOverUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.data.AiDrawingDataController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.generate.AiDrawingRequestPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.guide.AiDrawingGuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.CreateImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.DrawingAssistTypePopupWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import p001A.AbstractC0000a;
import p066P2.RunnableC0202d;
import p070Q1.RunnableC0218a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingManager {
    private static final String TAG = "AiDrawingManager";
    private final AiAssistMenuExecutor mAiAssistMenuExecutor;
    private final ComposerViewPresenter mComposerViewPresenter;
    private CreateImage mCreateImage;
    private CreateImage.Contract mCreateImageContract;
    private final AiDrawingDataController mDataController;
    private final AiDrawingGuidePresenter mGuidePresenter;
    private final Handler mHandler;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private ComposerViewPresenter.ObserverConfigurationChanged mObserverConfigurationChanged;
    private AiDrawingRequestPresenter mPopupPresenter;
    private final ReleaseRunnable mReleaseRunnable;
    private AiDrawingRequestPresenter.Contract mRequestPresenterContract;
    private SpenSelectionChangeListener mSpenSelectionChangeListener;
    private final UpdatePopupLayoutRunnable mUpdatePopupLayoutRunnable;
    private PowerManager.WakeLock mWakeLockForDim;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C93281 implements AiDrawingRequestPresenter.Contract {
        public C93281() {
        }

        private String getSADetailForGenerateNumberOfStroke() {
            int handledColorCount = AiDrawingManager.this.mDataController.getHandledColorCount();
            return handledColorCount <= 1 ? "a" : handledColorCount == 2 ? "b" : handledColorCount == 3 ? "c" : handledColorCount == 4 ? "d" : "e";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$executeCreateImage$0() {
            AiDrawingManager.this.wakeLockForDim();
            if (AiDrawingManager.this.mCreateImage == null) {
                AiDrawingManager.this.initCreateImage();
            }
            if (AiDrawingManager.this.mAiAssistMenuExecutor.getExecutor() == null) {
                AiDrawingManager.this.mAiAssistMenuExecutor.setTextBase();
            }
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_REQUEST, ComposerSAConstants.EVENT_AI_DRAWING_REQUEST_GENERATE, AiDrawingManager.this.mDataController.getSrcContentInfo().getGenerateStyle());
            ComposerSA.insertLog("802", ComposerSAConstants.EVENT_AI_DRAWING_GENERATE_NUMBER_OF_STROKE_COLOR, getSADetailForGenerateNumberOfStroke());
            AiDrawingManager.this.mAiAssistMenuExecutor.getExecutor().executeCreateImage(AiDrawingManager.this.mCreateImage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyComposerViewTouchEnd$1() {
            Logger.m10999d(AiDrawingManager.TAG, "handleSelectionPositionUpdate, caller: notifyComposerViewTouchEnd from touchedContentRect, prevState: " + AiDrawingManager.this.mDataController.getState());
            AiDrawingManager.this.requestReSelection();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.Contract
        public void executeCreateImage() {
            AiDrawingManager.this.dismissRequestLayout();
            AiDrawingManager.this.unregisterListeners();
            AiDrawingManager.this.setSelectionConceptAsDefault();
            AiCommonUtil.executeDrawingAction(AiDrawingManager.this.mComposerViewPresenter.getActivity(), new RunnableC9346f(this, 1));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.Contract
        public void notifyComposerViewTouchEnd(RectF rectF) {
            RectF rectFConvertViewRectIntoContentRect = AiDrawingManager.this.mDataController.convertViewRectIntoContentRect(rectF);
            Logger.m10999d(AiDrawingManager.TAG, "notifyComposerViewTouchEnd, touchedViewRect: " + rectF + ", touchedContentRect: " + rectFConvertViewRectIntoContentRect);
            if (rectFConvertViewRectIntoContentRect.width() >= 20.0f || rectFConvertViewRectIntoContentRect.height() >= 20.0f) {
                AiDrawingManager.this.handleSelectionPositionUpdate(rectFConvertViewRectIntoContentRect, "notifyComposerViewTouchEnd from touchedContentRect", new RunnableC9346f(this, 0));
            } else {
                AiDrawingManager aiDrawingManager = AiDrawingManager.this;
                aiDrawingManager.loadObjectInfos(aiDrawingManager.mDataController.getHandledObjects(), "notifyComposerViewTouchEnd use prev data");
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.Contract
        public void release(String str) {
            AiDrawingManager.this.release(str);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C93292 implements SpenSelectionChangeListener {
        public C93292() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPositionUpdated$0() {
            Logger.m10999d(AiDrawingManager.TAG, "handleSelectionPositionUpdate, caller: onPositionUpdated, prevState: " + AiDrawingManager.this.mDataController.getState());
            AiDrawingManager.this.requestReSelection();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener
        public void onChanged(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSelectionChangeListener
        public void onPositionUpdated(RectF rectF) {
            Logger.m10999d(AiDrawingManager.TAG, "onPositionUpdated, " + rectF);
            AiDrawingManager.this.handleSelectionPositionUpdate(rectF, "onPositionUpdated", new RunnableC9347g(this, 0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ObjectInfosLoadedRunnable implements Runnable {
        private final String caller;
        private final boolean isInfoChanged;
        private boolean isUpdated = false;
        private final boolean withInitialSelection;

        public ObjectInfosLoadedRunnable(String str, boolean z, boolean z2) {
            this.caller = str;
            this.isInfoChanged = z;
            this.withInitialSelection = z2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Runnable runnable) {
            if (AiDrawingManager.this.mDataController.isReadyState()) {
                runnable.run();
            } else {
                AiDrawingManager.this.requestReSelection();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(Runnable runnable) {
            if (AiDrawingManager.this.mDataController.isReadyState()) {
                runnable.run();
            } else {
                AiDrawingManager.this.requestReSelection();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            final AiDrawingState state = AiDrawingManager.this.mDataController.getState();
            if (AiDrawingState.NONE.equals(state)) {
                Logger.m11004w(AiDrawingManager.TAG, "onObjectInfoLoaded, caller: " + this.caller + " ignore, preState is none");
                return;
            }
            if (AiDrawingUtil.isDrawingToolkitUsed()) {
                if (this.isInfoChanged) {
                    final Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.ObjectInfosLoadedRunnable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AiDrawingManager.this.unregisterSpenSelectionChangeListener();
                            ObjectInfosLoadedRunnable objectInfosLoadedRunnable = ObjectInfosLoadedRunnable.this;
                            objectInfosLoadedRunnable.isUpdated = AiDrawingManager.this.updateTargetContentRect();
                            Logger.m10999d(AiDrawingManager.TAG, "onObjectInfoLoaded, caller: " + ObjectInfosLoadedRunnable.this.caller + ", isUpdated: " + ObjectInfosLoadedRunnable.this.isUpdated + ", prevState: " + state);
                            AiDrawingManager.this.dismissGuide();
                            ObjectInfosLoadedRunnable objectInfosLoadedRunnable2 = ObjectInfosLoadedRunnable.this;
                            AiDrawingManager.this.showSketchBookPopup(objectInfosLoadedRunnable2.caller, ObjectInfosLoadedRunnable.this.withInitialSelection);
                        }
                    };
                    AiDrawingManager.this.mDataController.setState(AiDrawingState.VIEW_INIT);
                    final int i = 0;
                    AiDrawingManager.this.mPopupPresenter.loadInputData(this.caller, new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.h

                        /* JADX INFO: renamed from: b */
                        public final /* synthetic */ AiDrawingManager.ObjectInfosLoadedRunnable f6821b;

                        {
                            this.f6821b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i) {
                                case 0:
                                    this.f6821b.lambda$run$0(runnable);
                                    break;
                                default:
                                    this.f6821b.lambda$run$1(runnable);
                                    break;
                            }
                        }
                    });
                    return;
                }
                AiDrawingManager.this.detachPopupBlockView();
                AiDrawingManager.this.mPopupPresenter.invalidate(AiDrawingPopup.InvalidateRequester.VIEW_VISIBILITY_UPDATE);
                Logger.m10999d(AiDrawingManager.TAG, "onObjectInfoLoaded, caller: " + this.caller + ", ignore");
                return;
            }
            final boolean zIsPopupAttached = AiDrawingManager.this.isPopupAttached();
            if (zIsPopupAttached && !this.isInfoChanged) {
                AiDrawingManager.this.detachPopupBlockView();
                AiDrawingManager.this.mPopupPresenter.invalidate(AiDrawingPopup.InvalidateRequester.VIEW_VISIBILITY_UPDATE);
                Logger.m10999d(AiDrawingManager.TAG, "onObjectInfoLoaded, caller: " + this.caller + ", ignore");
                return;
            }
            final Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.ObjectInfosLoadedRunnable.2
                @Override // java.lang.Runnable
                public void run() {
                    AiDrawingManager.this.initCreateImage();
                    AiDrawingManager.this.unregisterSpenSelectionChangeListener();
                    ObjectInfosLoadedRunnable objectInfosLoadedRunnable = ObjectInfosLoadedRunnable.this;
                    objectInfosLoadedRunnable.isUpdated = AiDrawingManager.this.updateTargetContentRect();
                    Logger.m10999d(AiDrawingManager.TAG, "onObjectInfoLoaded, caller: " + ObjectInfosLoadedRunnable.this.caller + ", isPopupAttached: " + zIsPopupAttached + ", isUpdated: " + ObjectInfosLoadedRunnable.this.isUpdated + ", prevState: " + state);
                    if (!zIsPopupAttached) {
                        ObjectInfosLoadedRunnable objectInfosLoadedRunnable2 = ObjectInfosLoadedRunnable.this;
                        AiDrawingManager.this.showPopup(objectInfosLoadedRunnable2.caller, ObjectInfosLoadedRunnable.this.withInitialSelection);
                        return;
                    }
                    Runnable runnable3 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.ObjectInfosLoadedRunnable.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ObjectInfosLoadedRunnable objectInfosLoadedRunnable3 = ObjectInfosLoadedRunnable.this;
                            AiDrawingManager.this.updateTargetViewRect(objectInfosLoadedRunnable3.caller, true);
                        }
                    };
                    if (!ObjectInfosLoadedRunnable.this.isUpdated) {
                        AiDrawingManager.this.mHandler.post(runnable3);
                        return;
                    }
                    AiDrawingManager.this.dismissGuide();
                    AiDrawingManager.this.mPopupPresenter.hidePopupView();
                    AiDrawingManager.this.smoothScrollAndScaleToFitRect(runnable3);
                }
            };
            if (!this.isInfoChanged) {
                AiDrawingManager.this.mDataController.setState(AiDrawingState.READY);
                runnable2.run();
            } else {
                AiDrawingManager.this.mDataController.setState(AiDrawingState.VIEW_INIT);
                final int i2 = 1;
                AiDrawingManager.this.mPopupPresenter.loadInputData(this.caller, new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.h

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ AiDrawingManager.ObjectInfosLoadedRunnable f6821b;

                    {
                        this.f6821b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                this.f6821b.lambda$run$0(runnable2);
                                break;
                            default:
                                this.f6821b.lambda$run$1(runnable2);
                                break;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ReleaseRunnable implements Runnable {
        private String caller;

        public /* synthetic */ ReleaseRunnable(AiDrawingManager aiDrawingManager, int i) {
            this();
        }

        public void init(String str) {
            this.caller = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AiDrawingManager.this.mDataController.isNoneState()) {
                return;
            }
            Logger.m10999d(AiDrawingManager.TAG, "release, caller: " + this.caller + " , state: " + AiDrawingManager.this.mDataController.getState());
            AiDrawingManager.this.mDataController.setState(AiDrawingState.NONE);
            AiDrawingManager.this.mDataController.releaseDataLoadExecutor();
            AiDrawingManager.this.mDataController.releaseData();
            AiDrawingManager.this.wakeLockRelease();
            AiDrawingManager.this.dismissRequestLayout();
            AiDrawingManager.this.unregisterListeners();
            AiDrawingManager.this.setSelectionConceptAsDefault();
            AiDrawingManager.this.setToolbarStateAsDefault();
            AiDrawingManager.this.setZoomEnableStateAsDefault();
        }

        private ReleaseRunnable() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class UpdatePopupLayoutRunnable implements Runnable {
        private static final long DELAY_FOR_RETRY = 1000;
        private String caller;
        private boolean isNewPopupRequired;
        private boolean isUpdatePopupLayoutActionHandled;
        private final Runnable retryUpdatePopupLayoutRunnable;
        private final Runnable updatePopupLayoutAction;

        public /* synthetic */ UpdatePopupLayoutRunnable(AiDrawingManager aiDrawingManager, int i) {
            this();
        }

        public void init(String str) {
            this.caller = str;
            boolean zIsPopupAttached = AiDrawingManager.this.isPopupAttached();
            boolean zIsNeedToUpdatePopupRoot = AiDrawingManager.this.isNeedToUpdatePopupRoot();
            AbstractC8014b.m7215q(AbstractC2821a.m2229t("init, caller: ", str, ", isPopupAttached: ", zIsPopupAttached, ", isNeedToUpdatePopupRoot: "), zIsNeedToUpdatePopupRoot, AiDrawingManager.TAG);
            this.isNewPopupRequired = !zIsPopupAttached || zIsNeedToUpdatePopupRoot;
            AiDrawingManager.this.mDataController.releaseTargetViewRect();
            if (AiDrawingManager.this.mPopupPresenter != null) {
                if (this.isNewPopupRequired) {
                    AiDrawingManager.this.mPopupPresenter.detachView();
                } else {
                    AiDrawingManager.this.mPopupPresenter.hidePopupView();
                }
            }
            AiDrawingManager.this.mComposerViewPresenter.getHWToolbarPresenter().updateSelectionMode();
            AiDrawingManager.this.setTextSelectionStyleForAiDrawing();
            this.isUpdatePopupLayoutActionHandled = false;
            AiDrawingManager.this.mHandler.removeCallbacks(this.retryUpdatePopupLayoutRunnable);
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder sb = new StringBuilder("run, caller : ");
            sb.append(this.caller);
            sb.append(", isNewPopupRequired : ");
            AbstractC8014b.m7215q(sb, this.isNewPopupRequired, AiDrawingManager.TAG);
            AiDrawingManager.this.smoothScrollAndScaleToFitRect(this.updatePopupLayoutAction);
            AiDrawingManager.this.mHandler.postDelayed(this.retryUpdatePopupLayoutRunnable, 1000L);
        }

        private UpdatePopupLayoutRunnable() {
            this.isUpdatePopupLayoutActionHandled = false;
            this.updatePopupLayoutAction = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.UpdatePopupLayoutRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    UpdatePopupLayoutRunnable.this.isUpdatePopupLayoutActionHandled = true;
                    AiDrawingManager.this.updateTargetContentRect();
                    UpdatePopupLayoutRunnable updatePopupLayoutRunnable = UpdatePopupLayoutRunnable.this;
                    AiDrawingManager.this.updateTargetViewRect(updatePopupLayoutRunnable.caller, !UpdatePopupLayoutRunnable.this.isNewPopupRequired);
                    if (UpdatePopupLayoutRunnable.this.isNewPopupRequired) {
                        AiDrawingManager.this.mPopupPresenter.show(true);
                    }
                }
            };
            this.retryUpdatePopupLayoutRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.UpdatePopupLayoutRunnable.2
                @Override // java.lang.Runnable
                public void run() {
                    if (UpdatePopupLayoutRunnable.this.isUpdatePopupLayoutActionHandled) {
                        return;
                    }
                    AiDrawingState state = AiDrawingManager.this.mDataController.getState();
                    if (AiDrawingUtil.isFocusEnabledState(state)) {
                        synchronized (AiDrawingManager.this.mHandler) {
                            AiDrawingManager.this.mHandler.post(AiDrawingManager.this.mUpdatePopupLayoutRunnable);
                        }
                    } else {
                        Logger.m11004w(AiDrawingManager.TAG, "retryUpdatePopupLayoutRunnable, ignore, state: " + state);
                    }
                }
            };
        }
    }

    public AiDrawingManager(Handler handler, ComposerViewPresenter composerViewPresenter, AiAssistMenuExecutor aiAssistMenuExecutor, MenuPresenterContract.IMenuManager iMenuManager) {
        int i = 0;
        this.mUpdatePopupLayoutRunnable = new UpdatePopupLayoutRunnable(this, i);
        this.mReleaseRunnable = new ReleaseRunnable(this, i);
        this.mHandler = handler;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mAiAssistMenuExecutor = aiAssistMenuExecutor;
        this.mMenuManager = iMenuManager;
        this.mDataController = new AiDrawingDataController(handler, composerViewPresenter);
        this.mGuidePresenter = new AiDrawingGuidePresenter(handler, composerViewPresenter, new AiDrawingGuidePresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.e
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.guide.AiDrawingGuidePresenter.Contract
            public final void release() {
                this.f6815a.lambda$new$0();
            }
        });
    }

    private void addResultImageInBound(String str) {
        if (FileUtils.isFileExists(str)) {
            String str2 = this.mComposerViewPresenter.getObjectManager().getCachePath() + FileUtils.getFileNameFromFilePath(str);
            if (!TextUtils.equals(str, str2)) {
                ImageUtil.saveBitmapToFileCache(BitmapFactory.decodeFile(str), str2, str.endsWith(".jpg") ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, 0, true);
            }
            RectF objectPasteRect = this.mPopupPresenter.getObjectPasteRect(str);
            if (objectPasteRect == null) {
                this.mComposerViewPresenter.getObjectManager().addGenerativeEditExtraData(this.mComposerViewPresenter.getObjectManager().insertImage(this.mComposerViewPresenter.getCurrentPageIndex(), str, true, true));
                return;
            }
            if (Features.isCreativeStudioSupported()) {
                objectPasteRect = this.mDataController.adjustRect(objectPasteRect, BitmapFactory.decodeFile(str));
            }
            this.mDataController.setResultHandledContentRect(objectPasteRect);
            insertImageInBound(str, objectPasteRect);
        }
    }

    private void createPopupPresenter() {
        AiDrawingRequestPresenter aiDrawingRequestPresenter = new AiDrawingRequestPresenter();
        this.mPopupPresenter = aiDrawingRequestPresenter;
        aiDrawingRequestPresenter.initialize(this.mHandler, this.mComposerViewPresenter, this.mDataController, getRequestPresenterContract());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachPopupBlockView() {
        AiDrawingRequestPresenter aiDrawingRequestPresenter = this.mPopupPresenter;
        if (aiDrawingRequestPresenter == null) {
            Logger.m10999d(TAG, "detachPopupBlockView, mPopupPresenter is null");
        } else {
            aiDrawingRequestPresenter.detachBlockView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissGuide() {
        this.mGuidePresenter.dismiss();
    }

    private void dismissPopup() {
        AiDrawingRequestPresenter aiDrawingRequestPresenter = this.mPopupPresenter;
        if (aiDrawingRequestPresenter != null) {
            aiDrawingRequestPresenter.dismissPopup();
        } else {
            Logger.m10999d(TAG, "dismissPopup, mPopupPresenter is null");
            this.mHandler.post(new RunnableC9343c(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissRequestLayout() {
        dismissGuide();
        dismissPopup();
        detachPopupBlockView();
    }

    private CreateImage.Contract getCreateImageContract() {
        if (this.mCreateImageContract == null) {
            this.mCreateImageContract = new CreateImage.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.Contract
                public void addResult(String str) {
                    AiDrawingManager.this.addResult(str);
                    AiDrawingManager.this.release("addResult");
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.Contract
                public void overwriteResult(String str) {
                    AiDrawingManager.this.overwriteResult(str);
                    AiDrawingManager.this.release("overwriteResult");
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.CreateImage.Contract
                public void releaseCreateImage(String str) {
                    AiDrawingManager.this.release(str);
                }
            };
        }
        return this.mCreateImageContract;
    }

    private AiDrawingRequestPresenter.Contract getRequestPresenterContract() {
        if (this.mRequestPresenterContract == null) {
            this.mRequestPresenterContract = new C93281();
        }
        return this.mRequestPresenterContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSelectionPositionUpdate(RectF rectF, String str, Runnable runnable) {
        this.mPopupPresenter.initLayout(true);
        this.mDataController.releaseData();
        this.mHandler.post(new RunnableC0218a(this, rectF, str, runnable, 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCreateImage() {
        CreateImage createImage = new CreateImage(this.mDataController, this.mComposerViewPresenter);
        this.mCreateImage = createImage;
        createImage.setContract(getCreateImageContract());
        this.mCreateImage.setSrcContentInfo(this.mDataController.getSrcContentInfo());
        this.mCreateImage.initImageMaker();
    }

    private boolean isGuideAttached() {
        AiDrawingGuidePresenter aiDrawingGuidePresenter = this.mGuidePresenter;
        return aiDrawingGuidePresenter != null && aiDrawingGuidePresenter.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedToUpdatePopupRoot() {
        AiDrawingRequestPresenter aiDrawingRequestPresenter = this.mPopupPresenter;
        if (aiDrawingRequestPresenter == null) {
            return true;
        }
        return aiDrawingRequestPresenter.isNeedToUpdatePopupRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPopupAttached() {
        AiDrawingRequestPresenter aiDrawingRequestPresenter = this.mPopupPresenter;
        return aiDrawingRequestPresenter != null && aiDrawingRequestPresenter.isAttached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissPopup$5() {
        Logger.m11004w(TAG, "dismissPopup, mPopupPresenter is null, remove forcefully");
        View viewFindViewById = this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.ai_drawing_container);
        if (viewFindViewById != null) {
            ((ViewGroup) viewFindViewById.getParent()).removeView(viewFindViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSelectionPositionUpdate$7(String str, ArrayList arrayList, RectF rectF, Runnable runnable) {
        if (!this.mDataController.hasSupportedObjects()) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            StringBuilder sbM15l = AbstractC0000a.m15l("handleSelectionPositionUpdate, caller: ", str, ", selectedObject size: ");
            sbM15l.append(arrayList.size());
            sbM15l.append(", contentRect: ");
            sbM15l.append(rectF);
            Logger.m10999d(TAG, sbM15l.toString());
            loadObjectInfos(arrayList, "handleSelectionPositionUpdate");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleSelectionPositionUpdate$8(RectF rectF, String str, Runnable runnable) {
        ArrayList<SpenObjectBase> selectedObject = this.mComposerViewPresenter.getDoc().getSelectedObject();
        this.mDataController.loadSpenObjectContents(this.mComposerViewPresenter.getNoteManager().getNote(), this.mComposerViewPresenter.getCurrentPageIndex(), selectedObject, rectF, new RunnableC4054d(this, str, selectedObject, rectF, runnable, 1), "handleSelectionPositionUpdate");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        release("GuideCancel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onActivityResult$9(File file) {
        Logger.m11000e(TAG, "onActivityResult, checkImageWithFile: originalPath: " + file.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPopup$3(String str, boolean z) {
        AbstractC8014b.m7196B("showPopup, caller : ", str, TAG);
        if (this.mDataController.isNoneState()) {
            return;
        }
        updateTargetContentRect();
        updateTargetViewRect(AbstractC0541b.m756B(str, "/showPopup"));
        this.mPopupPresenter.show(false);
        ComposerSA.insertLog(ComposerSA.getScreenID(this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode(), this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing), ResourceUtils.isTabletLayout(this.mComposerViewPresenter.getActivity())), ComposerSAConstants.EVENT_AI_DRAWING_ABOUT_SELECTION, z ? "a" : "b");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$smoothScrollAndScaleToFitRect$6(Runnable runnable) {
        AiDrawingState state = this.mDataController.getState();
        if (AiDrawingUtil.isFocusEnabledState(state)) {
            smoothScrollAndScaleToFitRect(this.mPopupPresenter.getFocusRect(), runnable);
            return;
        }
        Logger.m11004w(TAG, "smoothScrollAndScaleToFitRect, ignore, state: " + state);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCreateImage$1(ArrayList arrayList) {
        if (this.mDataController.hasSupportedObjects()) {
            setToolbarStateForAiDrawing();
            this.mComposerViewPresenter.getObjectManager().selectObjectList(arrayList);
            this.mPopupPresenter.initLayout(false);
            loadObjectInfos(arrayList, true, "startCreateImage by selectedObject");
            return;
        }
        setToolbarStateForAiDrawing();
        this.mDataController.setState(AiDrawingState.GUIDE);
        this.mComposerViewPresenter.getObjectManager().clearSelection();
        setControlBitmapForAiDrawing();
        showGuide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCreateImage$2() {
        if (!AiDrawingUtil.hasSupportedObjectsInScreen(this.mComposerViewPresenter.getDoc(), this.mComposerViewPresenter.getObjectManager())) {
            ToastHandler.show(this.mComposerViewPresenter.getActivity(), C9086R.string.f6717xca822215, 0);
            return;
        }
        this.mDataController.setState(AiDrawingState.TRIGGERED);
        registerSpenSelectionChangeListener();
        registerConfigurationChangedObserver();
        setSelectionConceptForAiDrawing();
        this.mMenuManager.onTriggerMenu(MenuPresenterContract.CMenu.AI_DRAWING_TRIGGER);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>(this.mComposerViewPresenter.getObjectManager().getSelectedObjectList());
        this.mDataController.loadSpenObjectContents(this.mComposerViewPresenter.getNoteManager().getNote(), this.mComposerViewPresenter.getCurrentPageIndex(), arrayList, null, new RunnableC9344d(this, arrayList, 2), "startCreateImage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePopupLayout$4(String str) {
        this.mUpdatePopupLayoutRunnable.init(AbstractC0541b.m756B(str, "/updatePopupLayout"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadObjectInfos(ArrayList<SpenObjectBase> arrayList, String str) {
        loadObjectInfos(arrayList, false, str);
    }

    private void overwriteResultImageInBound(String str) {
        Map<Integer, ArrayList<SpenObjectBase>> handledObjectInfos = this.mDataController.getHandledObjectInfos();
        Logger.m10999d(TAG, "overwriteResultImageInBound, deleteObjectInfos size: " + handledObjectInfos.size());
        String str2 = this.mComposerViewPresenter.getObjectManager().getCachePath() + FileUtils.getFileNameFromFilePath(str);
        RectF objectReplaceRect = this.mDataController.getObjectReplaceRect();
        if (objectReplaceRect == null) {
            Logger.m11000e(TAG, "overwriteResultImageInBound# Ignored by null rect.");
            return;
        }
        if (Features.isCreativeStudioSupported()) {
            objectReplaceRect = this.mDataController.adjustRect(objectReplaceRect, BitmapFactory.decodeFile(str));
        } else {
            Bitmap bitmapAdjustResultImage = this.mDataController.adjustResultImage(objectReplaceRect, BitmapFactory.decodeFile(str));
            if (!TextUtils.equals(str, str2)) {
                ImageUtil.saveBitmapToFileCache(bitmapAdjustResultImage, str2, str.endsWith(".jpg") ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, 0, true);
            }
        }
        this.mDataController.setResultHandledContentRect(objectReplaceRect);
        this.mComposerViewPresenter.getDoc().beginHistoryGroup();
        this.mComposerViewPresenter.getObjectManager().deleteMultiplePageObjects(handledObjectInfos);
        insertImageInBound(str2, objectReplaceRect);
        this.mComposerViewPresenter.getDoc().endHistoryGroup();
    }

    private void registerConfigurationChangedObserver() {
        if (this.mObserverConfigurationChanged != null) {
            return;
        }
        Logger.m10999d(TAG, "registerConfigurationChangedObserver");
        ComposerViewPresenter.ObserverConfigurationChanged observerConfigurationChanged = new ComposerViewPresenter.ObserverConfigurationChanged() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.AiDrawingManager.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewPresenter.ObserverConfigurationChanged
            public void onConfigurationChanged(Configuration configuration, boolean z) {
                if (AiDrawingManager.this.mDataController.isNoneState()) {
                    Logger.m11004w(AiDrawingManager.TAG, "onConfigurationChanged, ignore, invalid state: " + AiDrawingManager.this.mDataController.getState());
                    return;
                }
                if (AiDrawingManager.this.mDataController.isGuideState()) {
                    Logger.m11004w(AiDrawingManager.TAG, "onConfigurationChanged, state: " + AiDrawingManager.this.mDataController.getState() + ", isOrientationChanged: " + z);
                    AiDrawingManager.this.updateGuideLayout();
                    return;
                }
                if (AiDrawingManager.this.mPopupPresenter == null) {
                    Logger.m11004w(AiDrawingManager.TAG, "onConfigurationChanged, ignore, popupPresenter is null");
                    return;
                }
                Logger.m10999d(AiDrawingManager.TAG, "onConfigurationChanged, state: " + AiDrawingManager.this.mDataController.getState() + ", isOrientationChanged: " + z);
                AiDrawingManager.this.updatePopupLayout("onConfigurationChanged");
            }
        };
        this.mObserverConfigurationChanged = observerConfigurationChanged;
        this.mComposerViewPresenter.addConfigurationObserverChanged(observerConfigurationChanged);
    }

    private void registerSpenSelectionChangeListener() {
        if (this.mSpenSelectionChangeListener != null) {
            return;
        }
        Logger.m10999d(TAG, "registerSpenSelectionChangeListener");
        this.mSpenSelectionChangeListener = new C93292();
        this.mComposerViewPresenter.getListenerManager().addSpenSelectionChangeListener(this.mSpenSelectionChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestReSelection() {
        this.mDataController.setState(AiDrawingState.GUIDE);
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        detachPopupBlockView();
        registerSpenSelectionChangeListener();
        this.mPopupPresenter.hidePopupView();
        this.mDataController.releaseData();
        showRetryGuide();
    }

    private void restoreCreateImage() {
        CreateImage createImage = this.mCreateImage;
        if (createImage == null) {
            return;
        }
        createImage.setContract(getCreateImageContract());
    }

    private void restoreGuideInstanceState(Bundle bundle) {
        this.mGuidePresenter.restoreGuideInstanceState(bundle);
    }

    private void saveGuideInstanceState(Bundle bundle) {
        this.mGuidePresenter.saveGuideInstanceState(bundle);
    }

    private void setConnectedSelection() {
        if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            return;
        }
        Logger.m10999d(TAG, "setConnectedSelection");
        this.mComposerViewPresenter.getWritingToolManager().setConnectedSelection();
    }

    private void setConnectedSelectionAsDefault() {
        if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            return;
        }
        Logger.m10999d(TAG, "setSelectionAsDefault");
        this.mComposerViewPresenter.getWritingToolManager().setConnectedSelectionAsDefault();
    }

    private void setControlBitmapAsDefault() {
        Logger.m10999d(TAG, "setControlBitmapAsDefault");
        this.mComposerViewPresenter.getObjectManager().clearSelectObject();
        this.mComposerViewPresenter.getObjectManager().setControlBitmap(true);
    }

    private void setControlBitmapForAiDrawing() {
        Logger.m10999d(TAG, "setControlBitmapForAiDrawing");
        this.mComposerViewPresenter.getObjectManager().setControlBitmap(false);
    }

    private void setFingerDrawingOnModeForAiDrawing() {
        if (this.mComposerViewPresenter.getWritingToolManager().isSpenOnlyMode()) {
            this.mComposerViewPresenter.getWritingToolManager().setEnableAiDrawing(true);
        }
    }

    private void setFingerDrawingOnModeToDefault() {
        if (this.mComposerViewPresenter.getWritingToolManager().isSpenOnlyMode()) {
            this.mComposerViewPresenter.getWritingToolManager().setEnableAiDrawing(false);
        }
    }

    private void setObjectControlStyleAsDefault() {
        Logger.m10999d(TAG, "setObjectControlStyleAsDefault");
        this.mComposerViewPresenter.getObjectManager().setControlStyleInfoAsDefault();
    }

    private void setObjectControlStyleForAiDrawing() {
        Logger.m10999d(TAG, "setObjectControlStyleForAiDrawing");
        this.mComposerViewPresenter.getObjectManager().removeControlStyleInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectionConceptAsDefault() {
        setSelectionPenStyleAsDefault();
        setObjectControlStyleAsDefault();
        setConnectedSelectionAsDefault();
        setFingerDrawingOnModeToDefault();
        setTextSelectionStyleForDefault();
        setControlBitmapAsDefault();
    }

    private void setSelectionConceptForAiDrawing() {
        setSelectionPenStyleAsGradient();
        setObjectControlStyleForAiDrawing();
        setConnectedSelection();
        setFingerDrawingOnModeForAiDrawing();
        setTextSelectionStyleForAiDrawing();
    }

    private void setSelectionPenStyleAsDefault() {
        Logger.m10999d(TAG, "setSelectionPenStyleAsDefault");
        this.mComposerViewPresenter.getWritingToolManager().setSelectionPenStyleAsDefault();
    }

    private void setSelectionPenStyleAsGradient() {
        Logger.m10999d(TAG, "setSelectionPenStyleAsGradient");
        this.mComposerViewPresenter.getWritingToolManager().setSelectionPenStyleAsGradient();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextSelectionStyleForAiDrawing() {
        this.mComposerViewPresenter.getTextManager().setAiTextFormat(true);
        this.mComposerViewPresenter.getPdfManager().setAiTextFormat(true);
    }

    private void setTextSelectionStyleForDefault() {
        this.mComposerViewPresenter.getTextManager().setAiTextFormat(false);
        this.mComposerViewPresenter.getPdfManager().setAiTextFormat(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolbarStateAsDefault() {
        HwToolbarState prevHwToolbarState = this.mDataController.getPrevHwToolbarState();
        if (prevHwToolbarState == null) {
            return;
        }
        boolean zContains = this.mComposerViewPresenter.getHWToolbarPresenter().getSettingInstance().getHwToolbarState().getSelectedMenu().contains(8);
        AbstractC8014b.m7220v("restoreHwToolbarState, isSelectionSelected : ", TAG, zContains);
        if (zContains) {
            boolean zContains2 = prevHwToolbarState.getSelectedMenu().contains(65536);
            ModeManager modeManager = this.mComposerViewPresenter.getComposerModel().getModeManager();
            Mode mode = Mode.Text;
            boolean zIsMode = modeManager.isMode(mode);
            Logger.m10999d(TAG, "restoreHwToolbarState, isPrevStateContainsTextMode : " + zContains2 + ", isTextMode : " + zIsMode);
            if (!zContains2) {
                this.mComposerViewPresenter.getHWToolbarPresenter().restoreHwToolbarState(prevHwToolbarState);
            } else if (!zIsMode) {
                this.mComposerViewPresenter.getComposerModel().getModeManager().setMode(mode, "AiDrawingManager/restoreHwToolbarState", true, ComposerConstants.TAG_NO_CURSOR);
            }
        }
        this.mDataController.releasePrevHwToolbarState();
    }

    private void setToolbarStateForAiDrawing() {
        this.mDataController.setPrevHwToolbarState(this.mComposerViewPresenter.getHWToolbarPresenter().updateSelectionMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoomEnableStateAsDefault() {
        Logger.m10999d(TAG, "setZoomEnableStateAsDefault");
        this.mComposerViewPresenter.setScrollingEnabled(!r0.isZoomLocked());
    }

    private void setZoomEnableStateForAiDrawing() {
        Logger.m10999d(TAG, "setZoomEnableStateForAiDrawing");
        this.mComposerViewPresenter.setScrollingEnabled(false);
    }

    private void showGuide() {
        this.mGuidePresenter.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopup(String str, boolean z) {
        dismissGuide();
        dismissPopup();
        this.mDataController.initRestoreZoomScrollInfo();
        setZoomEnableStateForAiDrawing();
        smoothScrollAndScaleToFitRect(new RunnableC0202d(this, str, z, 7));
    }

    private void showRetryGuide() {
        this.mGuidePresenter.showRetry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSketchBookPopup(String str, boolean z) {
        Uri inputSpdFileUri;
        String str2;
        dismissGuide();
        Activity activity = this.mComposerViewPresenter.getActivity();
        if (this.mDataController.shouldUseImageInputFileForCreativeStudio()) {
            inputSpdFileUri = this.mDataController.getInputImageFileUri();
            str2 = Constants.MIME_IMAGE;
        } else {
            inputSpdFileUri = this.mDataController.getInputSpdFileUri();
            str2 = Constants.MIME_SPD;
        }
        StringBuilder sbM2229t = AbstractC2821a.m2229t("showSketchBookPopup, caller : ", str, ", withInitialSelection: ", z, ", inputUri: ");
        sbM2229t.append(Logger.getEncode(inputSpdFileUri.toString()));
        Logger.m10999d(TAG, sbM2229t.toString());
        DrawingToolkitsPopOverUtils.INSTANCE.showDrawingToolkitsPopOver(activity, inputSpdFileUri, str2, ComposerRequestCode.DrawingToolkit.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollAndScaleToFitRect(Runnable runnable) {
        this.mHandler.post(new RunnableC9344d(this, runnable, 0));
    }

    private void unregisterConfigurationChangedObserver() {
        if (this.mObserverConfigurationChanged == null) {
            return;
        }
        Logger.m10999d(TAG, "unregisterConfigurationChangedObserver");
        this.mComposerViewPresenter.removeConfigurationObserverChanged(this.mObserverConfigurationChanged);
        this.mObserverConfigurationChanged = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterListeners() {
        unregisterSpenSelectionChangeListener();
        unregisterConfigurationChangedObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean unregisterSpenSelectionChangeListener() {
        if (this.mSpenSelectionChangeListener == null) {
            return false;
        }
        Logger.m10999d(TAG, "unregisterSpenSelectionChangeListener,");
        this.mComposerViewPresenter.getListenerManager().removeSpenSelectionChangeListener(this.mSpenSelectionChangeListener);
        this.mSpenSelectionChangeListener = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGuideLayout() {
        if (isGuideAttached()) {
            this.mGuidePresenter.updateGuideLayout();
        } else {
            Logger.m11000e(TAG, "updateGuideLayout, guide is not attached");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePopupLayout(String str) {
        if (isPopupAttached()) {
            synchronized (this.mHandler) {
                this.mHandler.post(new RunnableC9344d(this, str, 1));
                this.mHandler.removeCallbacks(this.mUpdatePopupLayoutRunnable);
                this.mHandler.postDelayed(this.mUpdatePopupLayoutRunnable, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateTargetContentRect() {
        return this.mPopupPresenter.updateTargetContentRect();
    }

    private void updateTargetViewRect(String str) {
        updateTargetViewRect(str, false);
    }

    public void addResult(String str) {
        Logger.m11004w(TAG, "addResult, imagePath: " + Logger.getEncode(str));
        setObjectControlStyleAsDefault();
        setControlBitmapAsDefault();
        addResultImageInBound(str);
    }

    public void insertImageInBound(String str, RectF rectF) {
        SpenObjectImage spenObjectImage = new SpenObjectImage();
        this.mComposerViewPresenter.getObjectManager().addGenerativeEditExtraData(spenObjectImage);
        spenObjectImage.setRect(rectF, true);
        spenObjectImage.setLayoutType(1);
        spenObjectImage.setImage(str);
        this.mComposerViewPresenter.getObjectManager().insertImageInBound(spenObjectImage, rectF, true);
    }

    public boolean isAiDrawingActivated() {
        return isPopupAttached() || !this.mDataController.isNoneState();
    }

    public boolean onActivityResult(int i, Intent intent) {
        if (intent == null || i != -1) {
            release("onActivityResult(Error)");
            return false;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("resultBitmaps");
        Uri data = (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) ? intent.getData() != null ? intent.getData() : null : (Uri) parcelableArrayListExtra.get(0);
        if (data == null) {
            release("onActivityResult(Empty result)");
            return false;
        }
        Activity activity = this.mComposerViewPresenter.getActivity();
        String mimeType = UriFileUtils.getMimeType(activity, data);
        Logger.m11003i(TAG, "onActivityResult, download image# mimeType : " + mimeType);
        if (TextUtils.isEmpty(mimeType)) {
            release("onActivityResult(invalid mimeType)");
            return false;
        }
        if (mimeType.startsWith(Constants.MIME_VIDEO_START)) {
            release("onActivityResult(video mimeType)");
            return false;
        }
        String strSaveImageFromUri = DownloadBitmap.saveImageFromUri(activity, data, mimeType, this.mComposerViewPresenter.getObjectManager().getCachePath(), new C8416h(6));
        if (TextUtils.isEmpty(strSaveImageFromUri) || !AbstractC2322a.m1607A(strSaveImageFromUri)) {
            release("onActivityResult(save fail)");
            return false;
        }
        if (Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE.equals(intent.getStringExtra(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE))) {
            overwriteResult(strSaveImageFromUri);
        } else {
            addResult(strSaveImageFromUri);
        }
        release("onActivityResult(overwriteResult)");
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Logger.m10999d(TAG, NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE);
        this.mDataController.saveInstanceState(bundle);
        saveGuideInstanceState(bundle);
    }

    public void overwriteResult(String str) {
        Logger.m11004w(TAG, "overwriteResult, imagePath: " + Logger.getEncode(str));
        setObjectControlStyleAsDefault();
        setControlBitmapAsDefault();
        overwriteResultImageInBound(str);
    }

    public void release(String str) {
        this.mReleaseRunnable.init(str);
        this.mHandler.removeCallbacks(this.mReleaseRunnable);
        this.mHandler.post(this.mReleaseRunnable);
    }

    public void restoreDrawing(Bundle bundle) {
        AiDrawingState state = this.mDataController.getState();
        if (AiDrawingState.NONE.equals(state)) {
            Logger.m10999d(TAG, "restoreDrawing, ignore, noneState");
            return;
        }
        this.mDataController.restoreInstanceState(bundle);
        boolean zIsNoneState = this.mDataController.isNoneState();
        StringBuilder sb = new StringBuilder("restoreDrawing, state: ");
        sb.append(state);
        sb.append(", isShowing: ");
        sb.append(!zIsNoneState);
        Logger.m10999d(TAG, sb.toString());
        if (zIsNoneState) {
            return;
        }
        if (unregisterSpenSelectionChangeListener()) {
            registerSpenSelectionChangeListener();
        }
        if (this.mDataController.isGuideState() || this.mDataController.isViewInitState() || this.mDataController.isReadyState()) {
            setSelectionConceptForAiDrawing();
            setControlBitmapForAiDrawing();
        }
        restoreCreateImage();
        if (this.mDataController.isGuideState()) {
            Logger.m10999d(TAG, "restoreDrawing, show guide");
            restoreGuideInstanceState(bundle);
        } else {
            if (this.mDataController.isRunningState() || this.mDataController.isFinishedState()) {
                return;
            }
            updatePopupLayout("restoreDrawing");
        }
    }

    public void showCreativeStudio(String str, DrawingAssistTypePopupWindow.StudioType studioType) {
        dismissGuide();
        createPopupPresenter();
        Activity activity = this.mComposerViewPresenter.getActivity();
        AbstractC8014b.m7196B("showCreativeStudio, caller : ", str, TAG);
        DrawingToolkitsPopOverUtils.INSTANCE.showDrawingToolkitsStudio(activity, studioType, ComposerRequestCode.DrawingToolkit.getId());
    }

    public void startCreateImage() {
        Logger.m10999d(TAG, "startCreateImage");
        this.mHandler.removeCallbacks(this.mReleaseRunnable);
        this.mDataController.init();
        createPopupPresenter();
        AiCommonUtil.executeDrawingAction(this.mComposerViewPresenter.getActivity(), new RunnableC9343c(this, 1));
    }

    public synchronized void wakeLockForDim() {
        Activity activity = this.mComposerViewPresenter.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        if (this.mWakeLockForDim != null) {
            Logger.m10999d(TAG, "wakeLockForDim#");
            if (this.mWakeLockForDim.isHeld()) {
                Logger.m10999d(TAG, "wakeLockForDim# isHeld");
                return;
            }
        }
        Logger.m10999d(TAG, "wakeLockForDim# acquire");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) activity.getApplicationContext().getSystemService("power")).newWakeLock(805306374, activity.getLocalClassName());
        this.mWakeLockForDim = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire(60000L);
    }

    public synchronized void wakeLockRelease() {
        try {
            if (this.mWakeLockForDim == null) {
                return;
            }
            Logger.m10999d(TAG, "wakeLockRelease#");
            if (this.mWakeLockForDim.isHeld()) {
                Logger.m10999d(TAG, "wakeLockRelease# release");
                this.mWakeLockForDim.release();
            }
            this.mWakeLockForDim = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void loadObjectInfos(ArrayList<SpenObjectBase> arrayList, boolean z, String str) {
        this.mDataController.loadObjectInfos(arrayList, new ObjectInfosLoadedRunnable(str, true, z), new ObjectInfosLoadedRunnable(str, false, z), str);
    }

    private void smoothScrollAndScaleToFitRect(RectF rectF, Runnable runnable) {
        this.mComposerViewPresenter.smoothScrollAndScaleToFitRect(rectF, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTargetViewRect(String str, boolean z) {
        this.mPopupPresenter.updateTargetViewRect(str, z);
    }
}
