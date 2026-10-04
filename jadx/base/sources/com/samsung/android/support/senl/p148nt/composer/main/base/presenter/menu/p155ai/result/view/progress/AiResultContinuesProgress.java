package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiResultContinuesProgress {
    BaseProgress mProgressImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BaseProgress {
        View.OnLayoutChangeListener mContinueContainerOnLayoutChangeListener;
        View mContinuesContainer;
        TextView mContinuesMessage;
        LottieAnimationView mContinuesProgress;
        View mContinuesStopBtn;
        StateListener mStateListener;

        public BaseProgress(StateListener stateListener) {
            this.mStateListener = stateListener;
        }

        public void clear() {
            LottieAnimationView lottieAnimationView = this.mContinuesProgress;
            if (lottieAnimationView != null) {
                lottieAnimationView.clearAnimation();
            }
            View.OnLayoutChangeListener onLayoutChangeListener = this.mContinueContainerOnLayoutChangeListener;
            if (onLayoutChangeListener != null) {
                this.mContinuesContainer.removeOnLayoutChangeListener(onLayoutChangeListener);
                this.mContinueContainerOnLayoutChangeListener = null;
            }
        }

        public void init(View view) {
            View viewFindViewById = view.findViewById(C9086R.id.ai_menu_result_continues_progress_layout);
            this.mContinuesContainer = viewFindViewById;
            this.mContinuesProgress = (LottieAnimationView) viewFindViewById.findViewById(C9086R.id.ai_menu_result_continues_progress);
            initProgressAnimationView();
            this.mContinuesMessage = (TextView) this.mContinuesContainer.findViewById(C9086R.id.ai_menu_result_continues_progress_text);
            View viewFindViewById2 = this.mContinuesContainer.findViewById(C9086R.id.ai_menu_result_continues_stop);
            this.mContinuesStopBtn = viewFindViewById2;
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultContinuesProgress.BaseProgress.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    BaseProgress.this.stop();
                }
            });
            setContinuesProgress(false);
            initOnLayoutChangeListener();
        }

        public void initOnLayoutChangeListener() {
            if (this.mContinueContainerOnLayoutChangeListener == null) {
                this.mContinueContainerOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiResultContinuesProgress.BaseProgress.2
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (BaseProgress.this.mContinuesProgress.getLeft() < 0) {
                            if (BaseProgress.this.mContinuesMessage.getLayoutParams().width != 0) {
                                BaseProgress.this.mContinuesMessage.getLayoutParams().width = 0;
                                BaseProgress.this.mContinuesMessage.requestLayout();
                                return;
                            }
                            return;
                        }
                        if (BaseProgress.this.mContinuesMessage.getLayoutParams().width != -2) {
                            BaseProgress.this.mContinuesMessage.getLayoutParams().width = -2;
                            BaseProgress.this.mContinuesMessage.requestLayout();
                        }
                    }
                };
            }
            this.mContinuesContainer.addOnLayoutChangeListener(this.mContinueContainerOnLayoutChangeListener);
        }

        public void initProgressAnimationView() {
            this.mContinuesProgress.clearAnimation();
            this.mContinuesProgress.setAnimation(ComposerConstants.COVER_PROGRESS_LOTTIE_FILE);
            this.mContinuesProgress.setRepeatCount(-1);
        }

        public boolean isShowing() {
            return this.mContinuesContainer.getVisibility() == 0;
        }

        public void playProgressAnimation() {
            this.mContinuesProgress.playAnimation();
        }

        public void setContinuesProgress(boolean z) {
            if (z) {
                if (this.mContinuesContainer.getVisibility() == 0) {
                    return;
                }
                this.mContinuesContainer.setVisibility(0);
                playProgressAnimation();
                return;
            }
            if (this.mContinuesContainer.getVisibility() == 8) {
                return;
            }
            this.mContinuesContainer.setVisibility(8);
            stopProgressAnimation();
        }

        public void show(int i) {
            Context context = this.mContinuesMessage.getContext();
            this.mContinuesMessage.setText(i != 2 ? (i == 3 || i == 4) ? context.getString(C9086R.string.ai_auto_formatting_arrangement_ing) : i != 5 ? null : context.getString(C9086R.string.ai_correction_spelling_checking_your_text_ing) : context.getString(C9086R.string.ai_summarize_summarizing_text_ing));
            setContinuesProgress(true);
        }

        public void stop() {
            this.mStateListener.onStopped();
            setContinuesProgress(false);
        }

        public void stopProgressAnimation() {
            this.mContinuesProgress.cancelAnimation();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ProgressOneUI7 extends BaseProgress {
        public ProgressOneUI7(StateListener stateListener) {
            super(stateListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface StateListener {
        void onStopped();
    }

    public AiResultContinuesProgress(StateListener stateListener) {
        if (AiViewUtils.isAtLeastOneUI7()) {
            this.mProgressImpl = new ProgressOneUI7(stateListener);
        } else {
            this.mProgressImpl = new BaseProgress(stateListener);
        }
    }

    public void callStop() {
        this.mProgressImpl.stop();
    }

    public void clear() {
        this.mProgressImpl.clear();
    }

    public void init(View view) {
        this.mProgressImpl.init(view);
    }

    public boolean isShowing() {
        return this.mProgressImpl.isShowing();
    }

    public void setEnable(boolean z) {
        this.mProgressImpl.setContinuesProgress(z);
    }

    public void show(int i) {
        this.mProgressImpl.show(i);
    }
}
