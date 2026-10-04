package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingGuide extends FrameLayout {
    private static final String TAG = "AiDrawingGuide";
    private View mCancel;
    private Contract mContract;
    private View mGuideContainer;
    private View mGuideMessageContainer;
    private Handler mHandler;
    private boolean mIsDismissRequested;
    private boolean mIsShowRequested;
    private TextView mMessage;

    @StringRes
    private int mMessageRes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getBackgroundThemeColor();

        ViewGroup getComposerDecorView();

        View getComposerView();

        void release();
    }

    public AiDrawingGuide(@NonNull Context context) {
        super(context);
        this.mIsShowRequested = false;
        this.mIsDismissRequested = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getComposerDecorView() {
        Contract contract = this.mContract;
        if (contract == null) {
            return null;
        }
        return contract.getComposerDecorView();
    }

    private View getComposerView() {
        Contract contract = this.mContract;
        if (contract == null) {
            return null;
        }
        return contract.getComposerView();
    }

    private void hideContainer() {
        this.mGuideContainer.animate().alpha(0.0f).setDuration(100L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.3
            @Override // java.lang.Runnable
            public void run() {
                AiDrawingGuide.this.mGuideContainer.setVisibility(8);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(View view) {
        release();
        ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_GUIDE, ComposerSAConstants.EVENT_AI_DRAWING_GUIDE_CANCEL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$1(MotionEvent motionEvent) {
        Rect rect = new Rect();
        this.mGuideMessageContainer.getGlobalVisibleRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            hideContainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showContainer$2() {
        this.mGuideContainer.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGuideLayout$3() {
        ViewGroup composerDecorView = getComposerDecorView();
        if (composerDecorView == null) {
            return;
        }
        float fConvertPxToDp = ResourceUtils.convertPxToDp(getContext(), composerDecorView.getMeasuredHeight());
        LinearLayout linearLayout = (LinearLayout) findViewById(C9086R.id.ai_drawing_guide_message_container);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        View viewFindViewById = findViewById(C9086R.id.ai_drawing_guide_container);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        TextView textView = (TextView) findViewById(C9086R.id.ai_drawing_guide_message);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        float fConvertPxToDp2 = ResourceUtils.convertPxToDp(getContext(), (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_screen_height_upper_bound));
        if (fConvertPxToDp >= ResourceUtils.convertPxToDp(getContext(), (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_screen_height_lower_bound))) {
            textView.setTextSize(ResourceUtils.convertPixelToSp(getContext(), viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_text_size_large)));
            marginLayoutParams2.topMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_margin_bottom_medium);
            marginLayoutParams2.bottomMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_margin_bottom_medium);
            if (fConvertPxToDp >= fConvertPxToDp2) {
                marginLayoutParams.bottomMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_margin_bottom_large);
                layoutParams.height = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_container_height_large);
            } else {
                marginLayoutParams.bottomMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_margin_bottom_medium);
                layoutParams.height = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_container_height_medium);
            }
        } else {
            textView.setTextSize(ResourceUtils.convertPixelToSp(getContext(), viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_text_size_small)));
            marginLayoutParams2.topMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_text_margin_bottom);
            marginLayoutParams2.bottomMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_text_margin_bottom);
            marginLayoutParams.bottomMargin = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_margin_bottom_small);
            layoutParams.height = (int) viewFindViewById.getResources().getDimension(C9086R.dimen.ai_drawing_guide_container_height_small);
        }
        viewFindViewById.setLayoutParams(layoutParams);
        linearLayout.setLayoutParams(marginLayoutParams);
        textView.setLayoutParams(marginLayoutParams2);
    }

    private void release() {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.release();
    }

    private void showContainer() {
        this.mHandler.post(new RunnableC10271a(this, 1));
    }

    public void dismiss(final Runnable runnable) {
        if (getParent() != null) {
            this.mIsDismissRequested = true;
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AiDrawingGuide.this.getParent() != null) {
                        AiDrawingGuide.this.animate().alpha(0.0f).setInterpolator(new LinearInterpolator()).setDuration(100L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.2.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (AiDrawingGuide.this.getParent() != null) {
                                    ((ViewGroup) AiDrawingGuide.this.getParent()).removeView(AiDrawingGuide.this);
                                }
                                AiDrawingGuide.this.mIsDismissRequested = false;
                                Runnable runnable2 = runnable;
                                if (runnable2 != null) {
                                    runnable2.run();
                                }
                            }
                        }).start();
                        return;
                    }
                    AiDrawingGuide.this.mIsDismissRequested = false;
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

    public String getGuideMessage() {
        return this.mMessage.getText().toString();
    }

    public int getGuideMessageRes() {
        return this.mMessageRes;
    }

    public void init(Handler handler, Contract contract) {
        this.mHandler = handler;
        this.mContract = contract;
        LayoutInflater.from(getContext()).inflate(C9086R.layout.ai_drawing_guide, (ViewGroup) this, true);
        this.mMessage = (TextView) findViewById(C9086R.id.ai_drawing_guide_message);
        this.mCancel = findViewById(C9086R.id.ai_drawing_cancel_btn);
        this.mGuideContainer = findViewById(C9086R.id.ai_drawing_guide_container);
        this.mGuideMessageContainer = findViewById(C9086R.id.ai_drawing_guide_message_container);
        this.mCancel.setOnClickListener(new ViewOnClickListenerC8556a(this, 14));
        setTag(TAG);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        View composerView;
        if (!this.mIsShowRequested && (composerView = getComposerView()) != null) {
            composerView.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2 && this.mGuideContainer.getVisibility() == 0) {
            this.mHandler.post(new RunnableC9844c(this, motionEvent, 18));
            return true;
        }
        if ((motionEvent.getAction() == 9 || motionEvent.getAction() == 1 || motionEvent.getAction() == 7) && this.mGuideContainer.getVisibility() == 8) {
            showContainer();
        }
        return true;
    }

    public void setGuideMessageRes(int i) {
        TextView textView;
        if (i <= 0) {
            return;
        }
        this.mMessageRes = i;
        if (getParent() == null || (textView = this.mMessage) == null || this.mGuideMessageContainer == null) {
            return;
        }
        textView.setText(this.mMessageRes);
        this.mGuideMessageContainer.setVisibility(0);
    }

    public void show() {
        if (getParent() != null) {
            Logger.m10999d(TAG, "show, ignore already added");
            return;
        }
        if (this.mIsShowRequested) {
            Logger.m10999d(TAG, "show, ignore already requested");
            return;
        }
        this.mIsShowRequested = true;
        if (!this.mIsDismissRequested) {
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AiDrawingGuide.this.mIsDismissRequested) {
                        Logger.m10999d(AiDrawingGuide.TAG, "show runnable, ignore dismiss requested");
                        AiDrawingGuide.this.mIsShowRequested = false;
                        return;
                    }
                    ViewGroup composerDecorView = AiDrawingGuide.this.getComposerDecorView();
                    if (composerDecorView == null) {
                        return;
                    }
                    AiDrawingGuide.this.setVisibility(4);
                    AiDrawingGuide.this.mMessage.setText(AiDrawingGuide.this.mMessageRes);
                    composerDecorView.addView(AiDrawingGuide.this, new ViewGroup.LayoutParams(-1, -1));
                    AiDrawingGuide.this.getDrawingRect(new Rect());
                    composerDecorView.getDrawingRect(new Rect());
                    AiDrawingGuide.this.updateGuideLayout();
                    AiDrawingGuide.this.setTranslationY(r2.bottom + r1.top);
                    AiDrawingGuide.this.mGuideContainer.setVisibility(0);
                    AiDrawingGuide.this.setVisibility(0);
                    AiDrawingGuide.this.animate().translationY(0.0f).setDuration(450L).setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.5f, 1.0f)).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.guide.AiDrawingGuide.1.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            AiDrawingGuide.this.mIsShowRequested = false;
                        }
                    }).start();
                }
            });
        } else {
            Logger.m10999d(TAG, "show, ignore dismiss requested");
            this.mIsShowRequested = false;
        }
    }

    public void updateGuideLayout() {
        this.mHandler.post(new RunnableC10271a(this, 0));
    }

    public AiDrawingGuide(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsShowRequested = false;
        this.mIsDismissRequested = false;
    }

    public AiDrawingGuide(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsShowRequested = false;
        this.mIsDismissRequested = false;
    }
}
