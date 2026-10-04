package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingContentLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingRequestLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingPopup extends FrameLayout {
    private static final String TAG = "AiDrawingPopup";
    private ActionContract mActionContract;
    private AiDrawingContentLayout mContentLayout;
    private Handler mHandler;
    private final Runnable mInvaildateRunnable;
    private InvalidateRequester mInvalidateRequester;
    private AiDrawingRequestLayout mRequestLayout;
    private StateContract mStateContract;
    private RectF mTargetViewRect;
    private ViewCallback mViewCallback;
    private ViewContract mViewContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ActionContract {
        void requestExecuteCreateImage();

        void requestRelease();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum InvalidateRequester {
        NONE,
        SHOW,
        DATA_LOADED,
        VIEW_RECT_UPDATE,
        VIEW_VISIBILITY_UPDATE
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StateContract {
        AiDrawingState getState();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewCallback {
        void onComposerViewTouched(MotionEvent motionEvent);

        void onDismissed();

        void onShow();

        void onViewRectUpdated();

        void onViewVisibilityUpdated();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ViewContract {
        ViewGroup getComposerView();

        int getContentFrameBgColor();

        int getGenerateStyleIndex();

        ViewGroup getView();

        boolean isDataLoaded();

        void updateGenerateStyleIndex(int i);
    }

    public AiDrawingPopup(@NonNull Context context) {
        super(context);
        this.mInvalidateRequester = InvalidateRequester.NONE;
        this.mInvaildateRunnable = new RunnableC10265d(this, 2);
    }

    private void dismissContentContainer() {
        this.mContentLayout.hide();
    }

    private void dismissRequestLayout() {
        AiDrawingRequestLayout aiDrawingRequestLayout = this.mRequestLayout;
        if (aiDrawingRequestLayout == null) {
            return;
        }
        aiDrawingRequestLayout.dismiss();
    }

    private ViewGroup getComposerView() {
        ViewContract viewContract = this.mViewContract;
        if (viewContract == null) {
            return null;
        }
        return viewContract.getComposerView();
    }

    private AiDrawingState getState() {
        StateContract stateContract = this.mStateContract;
        return stateContract == null ? AiDrawingState.NONE : stateContract.getState();
    }

    private ViewGroup getView() {
        ViewContract viewContract = this.mViewContract;
        if (viewContract == null) {
            return null;
        }
        return viewContract.getView();
    }

    private void inflateLayout() {
        LayoutInflater.from(getContext()).inflate(C9086R.layout.ai_drawing_request_popup, (ViewGroup) this, true);
        initContentLayout();
        initRequestLayout();
        hidePopupView();
    }

    private void initContentLayout() {
        AiDrawingContentLayout aiDrawingContentLayout = (AiDrawingContentLayout) findViewById(C9086R.id.ai_drawing_request_content_layout);
        this.mContentLayout = aiDrawingContentLayout;
        aiDrawingContentLayout.initialize(this.mHandler, new AiDrawingContentLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingContentLayout.Contract
            public int getContentFrameBgColor() {
                if (AiDrawingPopup.this.mViewContract == null) {
                    return 0;
                }
                return AiDrawingPopup.this.mViewContract.getContentFrameBgColor();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingContentLayout.Contract
            public void requestClose() {
                if (AiDrawingPopup.this.mActionContract == null) {
                    return;
                }
                AiDrawingPopup.this.mActionContract.requestRelease();
            }
        });
    }

    private void initRequestLayout() {
        Logger.m10999d(TAG, "initRequestLayout");
        AiDrawingRequestLayout aiDrawingRequestLayout = (AiDrawingRequestLayout) findViewById(C9086R.id.ai_drawing_request_layout);
        this.mRequestLayout = aiDrawingRequestLayout;
        aiDrawingRequestLayout.setContract(new AiDrawingRequestLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
            public int getGenerateStyleIndex() {
                if (AiDrawingPopup.this.mViewContract == null) {
                    return 0;
                }
                return AiDrawingPopup.this.mViewContract.getGenerateStyleIndex();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
            public void requestExecuteCreateImage() {
                if (AiDrawingPopup.this.mActionContract == null) {
                    return;
                }
                AiDrawingPopup.this.mActionContract.requestExecuteCreateImage();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.Contract
            public void requestUpdateGenerateStyleIndex(int i) {
                if (AiDrawingPopup.this.mViewContract == null) {
                    return;
                }
                AiDrawingPopup.this.mViewContract.updateGenerateStyleIndex(i);
            }
        });
    }

    private boolean isDataLoaded() {
        ViewContract viewContract = this.mViewContract;
        if (viewContract == null) {
            return false;
        }
        return viewContract.isDataLoaded();
    }

    private boolean isReadyState() {
        return AiDrawingState.READY.equals(getState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismiss$1() {
        try {
            detachView();
        } catch (IllegalStateException e) {
            Logger.m11000e(TAG, "detach, e: " + e.getMessage());
        } finally {
            onDismissed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        updateRequestLayout(new RunnableC10265d(this, 0));
        updateRequestContentVisibility();
        onInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInvalidated$2() {
        Logger.m10999d(TAG, "onInvalidated, invalidateRequester : " + this.mInvalidateRequester);
        InvalidateRequester invalidateRequester = this.mInvalidateRequester;
        if (invalidateRequester == InvalidateRequester.SHOW) {
            detachView();
            attachView();
            onShow();
        } else if (invalidateRequester == InvalidateRequester.VIEW_RECT_UPDATE) {
            onViewRectUpdated();
        } else if (invalidateRequester == InvalidateRequester.VIEW_VISIBILITY_UPDATE) {
            onViewVisibilityUpdated();
        }
    }

    private void onDismissed() {
        ViewCallback viewCallback = this.mViewCallback;
        if (viewCallback == null) {
            return;
        }
        viewCallback.onDismissed();
    }

    private void onShow() {
        ViewCallback viewCallback = this.mViewCallback;
        if (viewCallback == null) {
            return;
        }
        viewCallback.onShow();
    }

    private void onViewRectUpdated() {
        ViewCallback viewCallback = this.mViewCallback;
        if (viewCallback == null) {
            return;
        }
        viewCallback.onViewRectUpdated();
    }

    private void onViewVisibilityUpdated() {
        ViewCallback viewCallback = this.mViewCallback;
        if (viewCallback == null) {
            return;
        }
        viewCallback.onViewVisibilityUpdated();
    }

    private void setTargetViewRect(RectF rectF) {
        this.mTargetViewRect = rectF;
    }

    private void showContentContainer() {
        this.mContentLayout.updateLayout(this.mTargetViewRect);
        this.mContentLayout.show();
    }

    private void showRequestLayout() {
        AiDrawingRequestLayout aiDrawingRequestLayout = this.mRequestLayout;
        if (aiDrawingRequestLayout == null) {
            return;
        }
        aiDrawingRequestLayout.show();
    }

    private void updateRequestLayout(final Runnable runnable) {
        AiDrawingRequestLayout aiDrawingRequestLayout;
        if (isReadyState() && isDataLoaded() && (aiDrawingRequestLayout = this.mRequestLayout) != null) {
            aiDrawingRequestLayout.updateLayout("updateRequestLayout", false);
            this.mRequestLayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingPopup.3
                private float getRequestLayoutDefaultTranslationX(float f) {
                    float measuredWidth = AiDrawingPopup.this.getMeasuredWidth();
                    float f4 = f / 2.0f;
                    if (AiDrawingPopup.this.mTargetViewRect.centerX() - f4 < 0.0f) {
                        Logger.m10999d(AiDrawingPopup.TAG, "getRequestLayoutDefaultTranslationX, left edge of screen");
                        return 0.0f;
                    }
                    if (AiDrawingPopup.this.mTargetViewRect.centerX() + f4 > measuredWidth) {
                        Logger.m10999d(AiDrawingPopup.TAG, "getRequestLayoutDefaultTranslationX, right edge of screen");
                        return measuredWidth - f;
                    }
                    Logger.m10999d(AiDrawingPopup.TAG, "getRequestLayoutDefaultTranslationX, inside screen");
                    return AiDrawingPopup.this.mTargetViewRect.centerX() - f4;
                }

                private void updateRequestLayoutTranslation(float f) {
                    float fMax;
                    float requestLayoutDefaultTranslationX;
                    float measuredWidth = AiDrawingPopup.this.getMeasuredWidth();
                    float measuredHeight = AiDrawingPopup.this.getMeasuredHeight();
                    float measuredHeight2 = AiDrawingPopup.this.mRequestLayout.getMeasuredHeight();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AiDrawingPopup.this.mRequestLayout.getLayoutParams();
                    float f4 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    if (AiDrawingPopup.this.mTargetViewRect.bottom + measuredHeight2 < measuredHeight) {
                        Logger.m10999d(AiDrawingPopup.TAG, "updateRequestLayoutTranslation, normal, inside of screen");
                        fMax = AiDrawingPopup.this.mTargetViewRect.bottom;
                        requestLayoutDefaultTranslationX = getRequestLayoutDefaultTranslationX(f);
                    } else if (AiDrawingPopup.this.mTargetViewRect.right + f < measuredWidth) {
                        Logger.m10999d(AiDrawingPopup.TAG, "updateRequestLayoutTranslation, right");
                        fMax = Math.max(marginLayoutParams.topMargin, (AiDrawingPopup.this.mTargetViewRect.bottom - measuredHeight2) - f4);
                        requestLayoutDefaultTranslationX = AiDrawingPopup.this.mTargetViewRect.right;
                    } else if (0.0f < AiDrawingPopup.this.mTargetViewRect.left - f) {
                        Logger.m10999d(AiDrawingPopup.TAG, "updateRequestLayoutTranslation, left");
                        fMax = Math.max(marginLayoutParams.topMargin, (AiDrawingPopup.this.mTargetViewRect.bottom - measuredHeight2) - f4);
                        requestLayoutDefaultTranslationX = AiDrawingPopup.this.mTargetViewRect.left - f;
                    } else if (0.0f < (AiDrawingPopup.this.mTargetViewRect.top - measuredHeight2) - f4) {
                        Logger.m10999d(AiDrawingPopup.TAG, "updateRequestLayoutTranslation, top");
                        fMax = (AiDrawingPopup.this.mTargetViewRect.top - measuredHeight2) - f4;
                        requestLayoutDefaultTranslationX = getRequestLayoutDefaultTranslationX(f);
                    } else {
                        Logger.m10999d(AiDrawingPopup.TAG, "updateRequestLayoutTranslation, bottom edge of screen");
                        fMax = (measuredHeight - measuredHeight2) - f4;
                        requestLayoutDefaultTranslationX = getRequestLayoutDefaultTranslationX(f);
                    }
                    StringBuilder sbM1176v = AbstractC0622a.m1176v("updateRequestLayoutTranslation, requestLayoutHeight: ", measuredHeight2, ", translationY: ", fMax, ", translationX: ");
                    sbM1176v.append(requestLayoutDefaultTranslationX);
                    Logger.m10999d(AiDrawingPopup.TAG, sbM1176v.toString());
                    AiDrawingPopup.this.mRequestLayout.setTranslationX(requestLayoutDefaultTranslationX);
                    AiDrawingPopup.this.mRequestLayout.setTranslationY(fMax);
                }

                private float updateRequestLayoutWidth() {
                    float widthPx = DisplayUtils.getWidthPx(AiDrawingPopup.this.mRequestLayout.getContext());
                    float dimension = AiDrawingPopup.this.mRequestLayout.getResources().getDimension(C9086R.dimen.ai_drawing_request_layout_min_width);
                    float dimension2 = AiDrawingPopup.this.mRequestLayout.getResources().getDimension(C9086R.dimen.ai_drawing_request_layout_max_width);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AiDrawingPopup.this.mRequestLayout.getLayoutParams();
                    float fMin = Math.min(Math.max(widthPx, dimension), dimension2);
                    marginLayoutParams.width = ((int) fMin) - (marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart());
                    AiDrawingPopup.this.mRequestLayout.setLayoutParams(marginLayoutParams);
                    Logger.m10999d(AiDrawingPopup.TAG, "updateRequestLayoutWidth, width: " + fMin);
                    return fMin;
                }

                @Override // java.lang.Runnable
                public void run() {
                    updateRequestLayoutTranslation(updateRequestLayoutWidth());
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void attachView() {
        ViewGroup view = getView();
        if (view == null) {
            Logger.m11000e(TAG, "attachView, can not find rootView");
        } else {
            view.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public void detachView() {
        if (isAttached()) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public void dismiss() {
        if (!isAttached()) {
            onDismissed();
            return;
        }
        this.mInvalidateRequester = InvalidateRequester.NONE;
        this.mHandler.removeCallbacks(this.mInvaildateRunnable);
        this.mHandler.post(new RunnableC10265d(this, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 9 || action == 7 || action == 10) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.mContentLayout.getGlobalVisibleRect(rect);
            this.mRequestLayout.getGlobalVisibleRect(rect2);
            if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && !rect2.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                return true;
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public void hidePopupView() {
        if (getVisibility() != 0) {
            return;
        }
        Logger.m10999d(TAG, "hidePopupView");
        dismissContentContainer();
        dismissRequestLayout();
        setVisibility(4);
    }

    public void init(Handler handler, StateContract stateContract, ActionContract actionContract, ViewContract viewContract, ViewCallback viewCallback) {
        this.mHandler = handler;
        this.mStateContract = stateContract;
        this.mActionContract = actionContract;
        this.mViewContract = viewContract;
        this.mViewCallback = viewCallback;
        inflateLayout();
    }

    public void invalidate(InvalidateRequester invalidateRequester) {
        Logger.m10999d(TAG, "invalidate, invalidateRequester: " + invalidateRequester);
        this.mInvalidateRequester = invalidateRequester;
        this.mHandler.removeCallbacks(this.mInvaildateRunnable);
        this.mHandler.post(this.mInvaildateRunnable);
    }

    public boolean isAttached() {
        return getParent() != null;
    }

    public boolean isNeedToUpdatePopupRoot() {
        int iHashCode = getParent() == null ? -1 : getParent().hashCode();
        int iHashCode2 = getView() == null ? -1 : getView().hashCode();
        StringBuilder sb = new StringBuilder("isNeedToUpdatePopupRoot, popupHashCode: ");
        sb.append(hashCode());
        sb.append(", parentHashCode: ");
        sb.append(iHashCode);
        sb.append(", viewHashCode: ");
        AbstractC8014b.m7221w(sb, TAG, iHashCode2);
        return iHashCode == -1 || iHashCode != iHashCode2;
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 8 && AiDrawingUtil.isPopupShowingState(getState())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onInvalidated() {
        this.mHandler.post(new RunnableC10265d(this, 3));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isReadyState() || motionEvent.getButtonState() == 32) {
            return true;
        }
        ViewGroup composerView = getComposerView();
        if (composerView != null) {
            composerView.dispatchTouchEvent(motionEvent);
        }
        ViewCallback viewCallback = this.mViewCallback;
        if (viewCallback == null) {
            return true;
        }
        viewCallback.onComposerViewTouched(motionEvent);
        return true;
    }

    public void requestVisualCue(Bitmap bitmap) {
        Logger.m10999d(TAG, "requestVisualCue");
        this.mContentLayout.setInputImage(bitmap);
    }

    public void show(RectF rectF, Bitmap bitmap) {
        setTargetViewRect(rectF);
        requestVisualCue(bitmap);
        invalidate(InvalidateRequester.SHOW);
    }

    public void updateRequestContentVisibility() {
        Logger.m10999d(TAG, "updateRequestContentVisibility, state: " + getState());
        if (isReadyState()) {
            showContentContainer();
        } else {
            dismissContentContainer();
        }
        setVisibility(0);
    }

    public void updateRequestLayoutVisibility() {
        Logger.m10999d(TAG, "updateRequestLayoutVisibility, state: " + getState());
        if (!isReadyState() || !isDataLoaded()) {
            dismissRequestLayout();
        } else {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_RESULT, ComposerSAConstants.EVENT_AI_DRAWING_RETRY_GENERATE);
            showRequestLayout();
        }
    }

    public void updateTargetViewRect(RectF rectF) {
        setTargetViewRect(rectF);
        invalidate(InvalidateRequester.VIEW_RECT_UPDATE);
    }

    public AiDrawingPopup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInvalidateRequester = InvalidateRequester.NONE;
        this.mInvaildateRunnable = new RunnableC10265d(this, 2);
    }

    public AiDrawingPopup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInvalidateRequester = InvalidateRequester.NONE;
        this.mInvaildateRunnable = new RunnableC10265d(this, 2);
    }
}
