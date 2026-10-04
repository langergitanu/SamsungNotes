package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.generate;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.RunnableC7853e;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.PageSizeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.data.AiDrawingDataController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingPopup;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p001A.AbstractC0000a;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingRequestPresenter {
    private static final String TAG = "AiDrawingRequestPresenter";
    private AiDrawingPopup.ActionContract mActionContract;
    private View mBlockView;
    private ComposerViewPresenter mComposerViewPresenter;
    private Contract mContract;
    private AiDrawingDataController mDataController;
    private Handler mHandler;
    private AiDrawingPopup mPopup;
    private AiDrawingPopup.StateContract mStateContract;
    private final RectF mTouchedViewRect = new RectF();
    private final UpdateTargetViewRectRunnable mUpdateTargetViewRectRunnable = new UpdateTargetViewRectRunnable(this, 0);
    private AiDrawingPopup.ViewCallback mViewCallback;
    private AiDrawingPopup.ViewContract mViewContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void executeCreateImage();

        void notifyComposerViewTouchEnd(RectF rectF);

        void release(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class UpdateTargetViewRectRunnable implements Runnable {
        private String caller;
        boolean withViewUpdate;

        public /* synthetic */ UpdateTargetViewRectRunnable(AiDrawingRequestPresenter aiDrawingRequestPresenter, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            if (AiDrawingRequestPresenter.this.isAttached()) {
                AiDrawingRequestPresenter.this.detachBlockView();
                AiDrawingRequestPresenter.this.mPopup.updateTargetViewRect(AiDrawingRequestPresenter.this.mDataController.getTargetViewRect());
            }
        }

        public void init(String str, boolean z) {
            this.caller = str;
            this.withViewUpdate = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            AiDrawingRequestPresenter.this.mDataController.updateTargetViewRect(this.caller);
            if (this.withViewUpdate && AiDrawingRequestPresenter.this.isAttached()) {
                AiDrawingRequestPresenter.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6846a.lambda$run$0();
                    }
                });
            }
        }

        private UpdateTargetViewRectRunnable() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeCreateImage() {
        this.mContract.executeCreateImage();
    }

    private AiDrawingPopup.ActionContract getActionContract() {
        if (this.mActionContract == null) {
            this.mActionContract = new AiDrawingPopup.ActionContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ActionContract
                public void requestExecuteCreateImage() {
                    AiDrawingRequestPresenter.this.executeCreateImage();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ActionContract
                public void requestRelease() {
                    AiDrawingRequestPresenter.this.release("ReleaseRequestFromPopup");
                }
            };
        }
        return this.mActionContract;
    }

    private AiDrawingPopup.StateContract getStateContract() {
        if (this.mStateContract == null) {
            this.mStateContract = new AiDrawingPopup.StateContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.b
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.StateContract
                public final AiDrawingState getState() {
                    return this.f6845a.lambda$getStateContract$1();
                }
            };
        }
        return this.mStateContract;
    }

    private AiDrawingPopup.ViewCallback getViewCallback() {
        if (this.mViewCallback == null) {
            this.mViewCallback = new AiDrawingPopup.ViewCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewCallback
                public void onComposerViewTouched(MotionEvent motionEvent) {
                    AiDrawingRequestPresenter.this.handleComposerViewTouchEvent(motionEvent);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewCallback
                public void onDismissed() {
                    AiDrawingRequestPresenter.this.mPopup = null;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewCallback
                public void onShow() {
                    AiDrawingRequestPresenter.this.requestVisualCue();
                    AiDrawingRequestPresenter.this.requestHaptic();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewCallback
                public void onViewRectUpdated() {
                    AiDrawingRequestPresenter.this.requestVisualCue();
                    AiDrawingRequestPresenter.this.requestHaptic();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewCallback
                public void onViewVisibilityUpdated() {
                    AiDrawingRequestPresenter.this.requestVisualCue();
                }
            };
        }
        return this.mViewCallback;
    }

    private AiDrawingPopup.ViewContract getViewContract() {
        if (this.mViewContract == null) {
            this.mViewContract = new AiDrawingPopup.ViewContract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewContract
                public ViewGroup getComposerView() {
                    return (ViewGroup) AiDrawingRequestPresenter.this.mComposerViewPresenter.getView();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewContract
                public int getContentFrameBgColor() {
                    return AiDrawingRequestPresenter.this.mComposerViewPresenter.getBackgroundThemeColor();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewContract
                public int getGenerateStyleIndex() {
                    return AiDrawingUtil.getGenerateStyleIndex(AiDrawingRequestPresenter.this.mDataController.getGenerateTheme());
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewContract
                public ViewGroup getView() {
                    return (ViewGroup) AiDrawingRequestPresenter.this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.comp_view_decor_layout);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewContract
                public boolean isDataLoaded() {
                    return AiDrawingRequestPresenter.this.mDataController.isDataLoaded();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.ViewContract
                public void updateGenerateStyleIndex(int i) {
                    AiDrawingRequestPresenter.this.mDataController.setGenerateTheme(AiDrawingUtil.getGenerateStyle(i));
                }
            };
        }
        return this.mViewContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleComposerViewTouchEvent(MotionEvent motionEvent) {
        if (this.mContract == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchedViewRect.set(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(), motionEvent.getY());
            hidePopupView();
        } else if (action == 2) {
            this.mTouchedViewRect.union(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.mTouchedViewRect.union(motionEvent.getX(), motionEvent.getY());
            this.mContract.notifyComposerViewTouchEnd(this.mTouchedViewRect);
        }
    }

    private void initPopup(boolean z) {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        if (aiDrawingPopup == null || z) {
            if (aiDrawingPopup != null) {
                aiDrawingPopup.detachView();
            }
            AiDrawingPopup aiDrawingPopup2 = new AiDrawingPopup(this.mComposerViewPresenter.getActivity());
            this.mPopup = aiDrawingPopup2;
            aiDrawingPopup2.init(this.mHandler, getStateContract(), getActionContract(), getViewContract(), getViewCallback());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AiDrawingState lambda$getStateContract$1() {
        return this.mDataController.getState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadInputData$2(String str, CountDownLatch countDownLatch) {
        StringBuilder sbM15l = AbstractC0000a.m15l("loadSPenObjectsFile finished, caller: ", str, ", selected object size? ");
        sbM15l.append(this.mComposerViewPresenter.getObjectManager().getSelectedObjectList().size());
        Logger.m10999d(TAG, sbM15l.toString());
        this.mComposerViewPresenter.getObjectManager().clearSelection();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadInputData$3(String str, CountDownLatch countDownLatch) {
        StringBuilder sbM15l = AbstractC0000a.m15l("loadSPenObjectsImageContents finished, caller: ", str, ", selected object size? ");
        sbM15l.append(this.mComposerViewPresenter.getObjectManager().getSelectedObjectList().size());
        Logger.m10999d(TAG, sbM15l.toString());
        this.mComposerViewPresenter.getObjectManager().clearSelection();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(boolean z) {
        detachView();
        initPopup(z);
        detachBlockView();
        this.mPopup.show(this.mDataController.getTargetViewRect(), BitmapFactory.decodeFile(this.mDataController.getOriginalFilePath()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatePreferredDisplayMode$4(float f) {
        DeviceUtils.updatePreferredDisplayMode(this.mComposerViewPresenter.getActivity(), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(String str) {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.release(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestHaptic() {
        ViewCompat.getInstance().performHapticFeedback(this.mPopup, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestVisualCue() {
        this.mPopup.requestVisualCue(BitmapFactory.decodeFile(this.mDataController.getOriginalFilePath()));
    }

    private void updatePreferredDisplayMode(float f) {
        this.mHandler.post(new RunnableC7853e(this, f, 1));
    }

    public void attachBlockView() {
        synchronized (this) {
            try {
                if (this.mBlockView != null) {
                    Logger.m11004w(TAG, "attachBlockView, ignore, blockView already created.");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.comp_view_decor_layout);
                if (viewGroup == null) {
                    Logger.m11000e(TAG, "attachBlockView, can not find rootView");
                    return;
                }
                Logger.m10999d(TAG, "attachBlockView");
                View view = new View(this.mComposerViewPresenter.getActivity());
                this.mBlockView = view;
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.AiDrawingRequestPresenter.1
                    @Override // android.view.View.OnTouchListener
                    @SuppressLint({"ClickableViewAccessibility"})
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        return true;
                    }
                });
                viewGroup.addView(this.mBlockView, new ViewGroup.LayoutParams(-1, -1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachBlockView() {
        synchronized (this) {
            try {
                if (this.mBlockView == null) {
                    return;
                }
                Logger.m10999d(TAG, "detachBlockView");
                ViewGroup viewGroup = (ViewGroup) this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.comp_view_decor_layout);
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) this.mBlockView.getParent();
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.mBlockView);
                }
                this.mBlockView = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void detachView() {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        if (aiDrawingPopup == null) {
            return;
        }
        aiDrawingPopup.detachView();
    }

    public void dismissPopup() {
        if (isAttached()) {
            this.mPopup.dismiss();
            updatePreferredDisplayMode(0.0f);
        }
    }

    public RectF getFocusRect() {
        RectF rectFCalculateContentRectForSpenObjects = this.mDataController.calculateContentRectForSpenObjects();
        int maxIntersectPageIdxFromTargetRect = AiDrawingUtil.getMaxIntersectPageIdxFromTargetRect(this.mComposerViewPresenter.getDoc(), rectFCalculateContentRectForSpenObjects);
        if (maxIntersectPageIdxFromTargetRect < 0) {
            Logger.m11004w(TAG, "getFocusRect, invalid targetPageIndex");
            return rectFCalculateContentRectForSpenObjects;
        }
        RectF contentRectInView = this.mDataController.getContentRectInView();
        if (contentRectInView != null) {
            if (rectFCalculateContentRectForSpenObjects.top < contentRectInView.top || contentRectInView.bottom - (contentRectInView.height() / 2.0f) < rectFCalculateContentRectForSpenObjects.bottom) {
                rectFCalculateContentRectForSpenObjects.top = (((int) rectFCalculateContentRectForSpenObjects.top) / 100) * 100;
            } else {
                rectFCalculateContentRectForSpenObjects.top = contentRectInView.top;
            }
        }
        RectF pageBound = PageSizeUtil.getPageBound(this.mComposerViewPresenter.getDoc(), maxIntersectPageIdxFromTargetRect);
        rectFCalculateContentRectForSpenObjects.left = pageBound.left;
        rectFCalculateContentRectForSpenObjects.right = pageBound.right;
        Logger.m11004w(TAG, "getFocusRect, focusRect: " + rectFCalculateContentRectForSpenObjects);
        return rectFCalculateContentRectForSpenObjects;
    }

    public RectF getObjectPasteRect(String str) {
        return this.mDataController.getObjectPasteRect(str);
    }

    public void hidePopupView() {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        if (aiDrawingPopup == null) {
            Logger.m11004w(TAG, "hidePopupView, ignore, mPopup is null");
        } else {
            aiDrawingPopup.hidePopupView();
        }
    }

    public void initLayout(boolean z) {
        attachBlockView();
        initPopup(z);
    }

    public void initialize(Handler handler, ComposerViewPresenter composerViewPresenter, AiDrawingDataController aiDrawingDataController, Contract contract) {
        this.mHandler = handler;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mDataController = aiDrawingDataController;
        this.mContract = contract;
    }

    public void invalidate(AiDrawingPopup.InvalidateRequester invalidateRequester) {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        if (aiDrawingPopup == null) {
            return;
        }
        aiDrawingPopup.invalidate(invalidateRequester);
    }

    public boolean isAttached() {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        return aiDrawingPopup != null && aiDrawingPopup.isAttached();
    }

    public boolean isNeedToUpdatePopupRoot() {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        if (aiDrawingPopup == null) {
            return true;
        }
        return aiDrawingPopup.isNeedToUpdatePopupRoot();
    }

    public boolean isShowing() {
        AiDrawingPopup aiDrawingPopup = this.mPopup;
        return aiDrawingPopup != null && aiDrawingPopup.isShowing();
    }

    public void loadInputData(final String str, Runnable runnable) {
        StringBuilder sb;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!AiDrawingUtil.isDrawingToolkitUsed() || this.mDataController.shouldUseImageInputFileForCreativeStudio()) {
            final int i = 1;
            this.mDataController.loadSPenObjectsImageContents(str, 0, new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiDrawingRequestPresenter f6842b;

                {
                    this.f6842b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i) {
                        case 0:
                            this.f6842b.lambda$loadInputData$2(str, countDownLatch);
                            break;
                        default:
                            this.f6842b.lambda$loadInputData$3(str, countDownLatch);
                            break;
                    }
                }
            });
        } else {
            final int i2 = 0;
            this.mDataController.loadSPenObjectsFile(str, 0, new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.generate.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ AiDrawingRequestPresenter f6842b;

                {
                    this.f6842b = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    switch (i2) {
                        case 0:
                            this.f6842b.lambda$loadInputData$2(str, countDownLatch);
                            break;
                        default:
                            this.f6842b.lambda$loadInputData$3(str, countDownLatch);
                            break;
                    }
                }
            });
        }
        try {
            try {
                sb = AbstractC4539a.m3200j("loadInputData, wait result: ", ", input image exist? ", countDownLatch.await(1L, TimeUnit.MINUTES));
            } catch (InterruptedException e) {
                Logger.m10999d(TAG, "loadInputData, e: " + e.getMessage());
                sb = new StringBuilder("loadInputData, wait result: false, input image exist? ");
            }
            sb.append(FileUtils.isFileExists(this.mDataController.getInputFilePath()));
            Logger.m10999d(TAG, sb.toString());
            if (this.mDataController.isDataLoaded()) {
                this.mDataController.setState(AiDrawingState.READY);
            } else {
                this.mDataController.setState(AiDrawingState.GUIDE);
            }
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            Logger.m10999d(TAG, "loadInputData, wait result: false, input image exist? " + FileUtils.isFileExists(this.mDataController.getInputFilePath()));
            throw th;
        }
    }

    public void show(boolean z) {
        updatePreferredDisplayMode(60.0f);
        this.mHandler.post(new RunnableC0116a(14, this, z));
    }

    public boolean updateTargetContentRect() {
        RectF rectFCalculateContentRectForSpenObjects = this.mDataController.calculateContentRectForSpenObjects();
        boolean targetContentRect = this.mDataController.setTargetContentRect(rectFCalculateContentRectForSpenObjects);
        Logger.m10999d(TAG, "updateTargetContentRect, targetContentRect: " + rectFCalculateContentRectForSpenObjects + ", isUpdated: " + targetContentRect + ", width: " + rectFCalculateContentRectForSpenObjects.width() + ", height: " + rectFCalculateContentRectForSpenObjects.height());
        return targetContentRect;
    }

    public void updateTargetViewRect(String str, boolean z) {
        this.mUpdateTargetViewRectRunnable.init(str, z);
        this.mHandler.removeCallbacks(this.mUpdateTargetViewRectRunnable);
        this.mHandler.post(this.mUpdateTargetViewRectRunnable);
    }
}
