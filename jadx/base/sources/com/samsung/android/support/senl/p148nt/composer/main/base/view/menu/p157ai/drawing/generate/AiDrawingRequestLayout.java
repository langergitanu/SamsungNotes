package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.widget.NestedScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.PresetEffectColor;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingGenerateStyleAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingRequestLayout extends FrameLayout {
    private static final String TAG = "AiDrawingRequestLayout";
    private View mContentView;
    private Contract mContract;
    private TextView mGenerate;
    private GuidingLightEffect mGenerateEffect;
    private View mGenerateEffectView;
    private Integer mGenerateStyleIndex;
    private SpringAnimation mPressAnimation;
    private SpringAnimation mReleaseAnimation;
    private ViewGroup mRootView;
    private NestedScrollView mScrollView;
    private AiDrawingGenerateStyleAdapter mStyleAdapter;
    private RecyclerView mStyleList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getGenerateStyleIndex();

        void requestExecuteCreateImage();

        void requestUpdateGenerateStyleIndex(int i);
    }

    public AiDrawingRequestLayout(@NonNull Context context) {
        super(context);
        inflateLayout(context);
    }

    private SpringAnimation createSpringAnimation(DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener) {
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(1.0f));
        springAnimation.setSpring(new SpringForce(100.0f).setDampingRatio(1.0f).setStiffness(361.0f));
        springAnimation.addUpdateListener(onAnimationUpdateListener);
        return springAnimation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGenerateButtonTouchDown(final PointF pointF, final PointF pointF2) {
        if (AiViewUtils.isAtLeastOneUI7()) {
            SpringAnimation springAnimation = this.mPressAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            SpringAnimation springAnimationCreateSpringAnimation = createSpringAnimation(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.4
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                @RequiresApi(api = 33)
                public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                    PointF pointF3 = pointF;
                    float f5 = pointF3.x;
                    PointF pointF4 = pointF2;
                    float f6 = (((pointF4.x - f5) * f) / 100.0f) + f5;
                    float f7 = pointF3.y;
                    AiDrawingRequestLayout.this.mGenerateEffect.setLightPositionInView(new PointF(f6, (((pointF4.y - f7) * f) / 100.0f) + f7));
                }
            });
            this.mPressAnimation = springAnimationCreateSpringAnimation;
            springAnimationCreateSpringAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 33)
    public void handleGenerateButtonTouchMove(PointF pointF) {
        if (AiViewUtils.isAtLeastOneUI7()) {
            SpringAnimation springAnimation = this.mPressAnimation;
            if (springAnimation == null || !springAnimation.isRunning()) {
                this.mGenerateEffect.setLightPositionInView(pointF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 33)
    public void handleGenerateButtonTouchUp(final PointF pointF, final PointF pointF2) {
        if (AiViewUtils.isAtLeastOneUI7()) {
            this.mGenerateEffect.setLightPositionInView(pointF2);
            SpringAnimation springAnimation = this.mReleaseAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            SpringAnimation springAnimationCreateSpringAnimation = createSpringAnimation(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.5
                @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
                @RequiresApi(api = 33)
                public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                    PointF pointF3 = pointF;
                    float f5 = pointF3.x;
                    PointF pointF4 = pointF2;
                    float f6 = (((pointF4.x - f5) * f) / 100.0f) + f5;
                    float f7 = pointF3.y;
                    AiDrawingRequestLayout.this.mGenerateEffect.setLightPositionInView(new PointF(f6, (((pointF4.y - f7) * f) / 100.0f) + f7));
                }
            });
            this.mReleaseAnimation = springAnimationCreateSpringAnimation;
            springAnimationCreateSpringAnimation.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void inflateLayout(Context context) {
        LayoutInflater.from(context).inflate(C9086R.layout.ai_drawing_request_layout, (ViewGroup) this, true);
        this.mRootView = (ViewGroup) findViewById(C9086R.id.ai_drawing_request_root_view);
        this.mScrollView = (NestedScrollView) findViewById(C9086R.id.ai_drawing_request_scroll_view);
        this.mContentView = findViewById(C9086R.id.ai_drawing_request_content_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                int lastRowStartIndex = AiDrawingUtil.getLastRowStartIndex();
                if (lastRowStartIndex > i) {
                    return 2;
                }
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null) {
                    return 0;
                }
                return 6 / (AiDrawingUtil.getImageStyleCount(applicationContext) - lastRowStartIndex);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(C9086R.id.ai_drawing_request_style_list);
        this.mStyleList = recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        TextView textView = (TextView) findViewById(C9086R.id.ai_drawing_generate);
        this.mGenerate = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.2
            @Override // android.view.View.OnClickListener
            @RequiresApi(api = 29)
            public void onClick(View view) {
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.ComposerActivity;
                if (UserInputSkipper.isValidSingleActionEvent(false, tag)) {
                    UserInputSkipper.setHoldingSingleActionEventTime(1000L, tag);
                    AiDrawingRequestLayout.this.requestExecuteCreateImage();
                }
            }
        });
        this.mGenerateEffectView = findViewById(C9086R.id.ai_drawing_generate_effect_view);
        this.mGenerate.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.3
            @Override // android.view.View.OnTouchListener
            @RequiresApi(api = 33)
            public boolean onTouch(View view, MotionEvent motionEvent) {
                PointF pointF = new PointF(Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / view.getWidth())), Math.max(0.0f, Math.min(1.0f, motionEvent.getY() / view.getHeight())));
                PointF pointF2 = new PointF(0.5f, 0.5f);
                int action = motionEvent.getAction();
                if (action == 0) {
                    AiDrawingRequestLayout.this.handleGenerateButtonTouchDown(pointF, pointF2);
                    return false;
                }
                if (action != 2) {
                    AiDrawingRequestLayout.this.handleGenerateButtonTouchUp(pointF, pointF2);
                    return false;
                }
                AiDrawingRequestLayout.this.handleGenerateButtonTouchMove(pointF);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(ValueAnimator valueAnimator) {
        setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        setScaleX(fFloatValue);
        setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$2() {
        final int i = 0;
        setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AiDrawingRequestLayout f7159b;

            {
                this.f7159b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        this.f7159b.lambda$show$0(valueAnimator);
                        break;
                    default:
                        this.f7159b.lambda$show$1(valueAnimator);
                        break;
                }
            }
        });
        setPivotX(getMeasuredWidth() / 2.0f);
        setPivotY(getMeasuredHeight() / 2.0f);
        setScaleX(0.8f);
        setScaleY(0.8f);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(400L);
        valueAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        final int i2 = 1;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ AiDrawingRequestLayout f7159b;

            {
                this.f7159b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        this.f7159b.lambda$show$0(valueAnimator);
                        break;
                    default:
                        this.f7159b.lambda$show$1(valueAnimator);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfFloat2, valueAnimatorOfFloat);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateThemeContainer$3() {
        this.mStyleList.scrollToPosition(getGenerateStyleIndexForView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestExecuteCreateImage() {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.requestExecuteCreateImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUpdateGenerateStyleIndex(int i) {
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        contract.requestUpdateGenerateStyleIndex(i);
    }

    @RequiresApi(api = 33)
    private void updateGenerateEffect(boolean z) {
        boolean z2 = z || (!ResourceUtils.isTabletLayout(getContext()) && getResources().getConfiguration().orientation == 2);
        if (!AiViewUtils.isAtLeastOneUI7()) {
            this.mGenerateEffectView.setBackground(null);
            this.mGenerate.setForeground(getResources().getDrawable(z ? C9086R.drawable.ai_drawing_generate_button_round_fg_for_scroll : C9086R.drawable.ai_drawing_generate_button_round_fg, null));
            this.mGenerate.setBackgroundResource(z2 ? C9086R.drawable.ai_drawing_generate_button_round_bg_for_scroll : C9086R.drawable.ai_drawing_generate_button_round_bg);
            return;
        }
        if (this.mGenerateEffect == null) {
            Context context = this.mGenerateEffectView.getContext();
            View view = this.mGenerateEffectView;
            GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, view, ContextUtils.isNightMode(view.getContext()) ? GuidingLightConfig.DEFAULT_DARK : GuidingLightConfig.DEFAULT_LIGHT);
            this.mGenerateEffect = guidingLightEffect;
            guidingLightEffect.setColorState(PresetEffectColor.State.Common);
            this.mGenerateEffect.setLightMovement(GuidingLightEffect.Movement.NONE);
        }
        this.mGenerateEffect.setCornerRadiusPixel(getResources().getDimension(z ? C9086R.dimen.ai_drawing_generate_button_radius_for_scroll : C9086R.dimen.ai_drawing_generate_button_radius), GuidingLightEffect.CornerRadiusSide.ALL);
        this.mGenerateEffect.show(GuidingLightEffect.ShowAnimationType.NONE);
        this.mGenerate.setForeground(null);
        this.mGenerate.setBackground(null);
    }

    private void updateGenerateLayout(boolean z) {
        if (z || (!ResourceUtils.isTabletLayout(getContext()) && getResources().getConfiguration().orientation == 2)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mGenerate.getLayoutParams();
            marginLayoutParams.topMargin = (int) getResources().getDimension(C9086R.dimen.ai_drawing_generate_button_margin_top_for_scroll);
            this.mGenerate.setLayoutParams(marginLayoutParams);
            this.mGenerate.setMinimumHeight((int) getResources().getDimension(C9086R.dimen.ai_drawing_generate_button_container_min_height_for_scroll));
            this.mGenerate.setMinimumWidth((int) getResources().getDimension(C9086R.dimen.ai_drawing_generate_button_container_min_width_for_scroll));
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mGenerate.getLayoutParams();
        marginLayoutParams2.topMargin = (int) getResources().getDimension(C9086R.dimen.ai_drawing_generate_button_margin_top);
        this.mGenerate.setLayoutParams(marginLayoutParams2);
        this.mGenerate.setMinimumHeight((int) getResources().getDimension(C9086R.dimen.ai_drawing_generate_button_container_min_height));
        this.mGenerate.setMinimumWidth((int) getResources().getDimension(C9086R.dimen.ai_drawing_generate_button_container_min_width));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void updateThemeContainer(boolean z) {
        if (this.mStyleAdapter == null) {
            this.mStyleAdapter = new AiDrawingGenerateStyleAdapter(new AiDrawingGenerateStyleAdapter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingRequestLayout.6
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingGenerateStyleAdapter.Contract
                public int getGenerateStyleIndex() {
                    return AiDrawingRequestLayout.this.getGenerateStyleIndexForView();
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.ai.drawing.generate.AiDrawingGenerateStyleAdapter.Contract
                public void requestUpdateGenerateStyleIndex(int i) {
                    AiDrawingRequestLayout.this.setGenerateStyleIndexForView(i);
                    AiDrawingUtil.saveLastUsedGenerateStyle(AiDrawingUtil.getGenerateStyle(i));
                    AiDrawingRequestLayout.this.requestUpdateGenerateStyleIndex(i);
                }
            });
        }
        this.mStyleList.setAdapter(this.mStyleAdapter);
        this.mStyleAdapter.notifyDataSetChanged();
        if (z) {
            this.mStyleList.post(new RunnableC10266e(this, 0));
        }
    }

    private void updateViewParent(@NonNull View view, ViewGroup viewGroup) {
        if (view.getParent() == viewGroup) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
        viewGroup.addView(view);
    }

    public void dismiss() {
        if (getVisibility() != 4) {
            setVisibility(4);
            return;
        }
        Logger.m11004w(TAG, "show, ignore, " + getVisibility());
    }

    public int getGenerateStyleIndexForView() {
        if (this.mGenerateStyleIndex == null) {
            Contract contract = this.mContract;
            if (contract != null) {
                this.mGenerateStyleIndex = Integer.valueOf(contract.getGenerateStyleIndex());
            } else {
                this.mGenerateStyleIndex = 0;
            }
        }
        return this.mGenerateStyleIndex.intValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        boolean z = View.MeasureSpec.getSize(i2) < ((int) com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils.convertDpToPixel(getContext(), 160.0f));
        updateViewParent(this.mContentView, z ? this.mScrollView : this.mRootView);
        if (Build.VERSION.SDK_INT >= 33) {
            updateGenerateEffect(z);
        }
        updateGenerateLayout(z);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(size, (int) getResources().getDimension(C9086R.dimen.ai_drawing_request_layout_max_width)), 1073741824), i2);
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void setGenerateStyleIndexForView(int i) {
        this.mGenerateStyleIndex = Integer.valueOf(i);
    }

    public void show() {
        if (getVisibility() != 0) {
            updateLayout(Constants.IntentExtraValue.SHOW, true);
            post(new RunnableC10266e(this, 1));
        } else {
            Logger.m11004w(TAG, "show, ignore, " + getVisibility());
        }
    }

    public void updateLayout(String str, boolean z) {
        StringBuilder sbM2229t = AbstractC2821a.m2229t("updateLayout, caller: ", str, ", withFocusCurrentStyle: ", z, ", hashCode: ");
        sbM2229t.append(hashCode());
        Logger.m10999d(TAG, sbM2229t.toString());
        updateThemeContainer(z);
    }

    public AiDrawingRequestLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        inflateLayout(context);
    }

    public AiDrawingRequestLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        inflateLayout(context);
    }
}
