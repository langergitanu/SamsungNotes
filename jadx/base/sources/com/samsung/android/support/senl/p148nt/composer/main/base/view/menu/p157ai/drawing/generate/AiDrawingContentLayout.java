package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingContentLayout extends FrameLayout {
    private static final String TAG = "AiDrawingContentLayout";
    private View mClose;
    private FrameLayout mContainer;
    private AiDrawingContentFrame mContentFrame;
    private Contract mContract;
    private Handler mHandler;
    private ImageView mInput;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getContentFrameBgColor();

        void requestClose();
    }

    public AiDrawingContentLayout(@NonNull Context context) {
        super(context);
        inflateLayout(context);
    }

    private int getContentFrameBgColor() {
        Contract contract = this.mContract;
        if (contract == null) {
            return 0;
        }
        return contract.getContentFrameBgColor();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void inflateLayout(Context context) {
        LayoutInflater.from(context).inflate(C9086R.layout.ai_drawing_content_layout, (ViewGroup) this, true);
        this.mContainer = (FrameLayout) findViewById(C9086R.id.ai_drawing_content_container);
        this.mInput = (ImageView) findViewById(C9086R.id.ai_drawing_input);
        this.mContentFrame = (AiDrawingContentFrame) findViewById(C9086R.id.ai_drawing_content_frame);
        this.mClose = findViewById(C9086R.id.ai_drawing_close_btn);
        ViewCompat.getInstance().setTooltipText(this.mClose);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setInputImage$2(Bitmap bitmap) {
        this.mInput.setImageBitmap(bitmap);
        this.mInput.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateCloseBtn$0(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.mClose.setScaleX(fFloatValue);
        this.mClose.setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateCloseBtn$1() {
        this.mClose.setVisibility(0);
        this.mClose.setPivotX(r0.getMeasuredWidth() / 2.0f);
        this.mClose.setPivotY(r0.getMeasuredHeight() / 2.0f);
        this.mClose.setScaleX(0.8f);
        this.mClose.setScaleY(0.8f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new C10262a(this, 1));
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestClose() {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.requestClose();
    }

    private void updateCloseBtn() {
        View view = this.mClose;
        if (view == null) {
            return;
        }
        view.post(new RunnableC10266e(this, 2));
    }

    private void updateOverlayFrame() {
        AiDrawingContentFrame aiDrawingContentFrame = this.mContentFrame;
        if (aiDrawingContentFrame == null) {
            return;
        }
        aiDrawingContentFrame.setInnerColor(getContentFrameBgColor());
        this.mContentFrame.setVisibility(0);
    }

    public void hide() {
        if (getVisibility() == 4) {
            return;
        }
        setVisibility(4);
        this.mInput.setVisibility(4);
        this.mContentFrame.stopGradientAnimation();
    }

    public void initialize(Handler handler, Contract contract) {
        this.mHandler = handler;
        this.mContract = contract;
        updateOverlayFrame();
        updateCloseBtn();
        this.mClose.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingContentLayout.1
            @Override // android.view.View.OnClickListener
            @RequiresApi(api = 29)
            public void onClick(View view) {
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
                if (UserInputSkipper.isValidSingleActionEvent(false, tag)) {
                    UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
                    Logger.m11004w(AiDrawingContentLayout.TAG, "close button clicked");
                    AiDrawingContentLayout.this.requestClose();
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_REQUEST, ComposerSAConstants.EVENT_AI_DRAWING_REQUEST_CLOSE);
                }
            }
        });
    }

    public void setInputImage(Bitmap bitmap) {
        this.mHandler.post(new RunnableC9844c(this, bitmap, 17));
    }

    public void show() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        this.mContentFrame.show();
    }

    public void updateLayout(RectF rectF) {
        Logger.m10999d(TAG, "updateLayout, targetViewRect: " + rectF);
        updateOverlayFrame();
        updateCloseBtn();
        float dimension = getResources().getDimension(C9086R.dimen.ai_drawing_result_container_stroke_size);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mContainer.getLayoutParams();
        float f = 2.0f * dimension;
        marginLayoutParams.width = (int) (rectF.width() + f);
        marginLayoutParams.height = (int) (rectF.height() + f);
        this.mContainer.setLayoutParams(marginLayoutParams);
        setTranslationX(rectF.left - dimension);
        setTranslationY(rectF.top - dimension);
    }

    public AiDrawingContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateLayout(context);
    }

    public AiDrawingContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateLayout(context);
    }
}
