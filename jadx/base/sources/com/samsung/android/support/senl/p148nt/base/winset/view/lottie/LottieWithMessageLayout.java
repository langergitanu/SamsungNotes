package com.samsung.android.support.senl.p148nt.base.winset.view.lottie;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.addons.base.binding.adapters.RunnableC7949a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieResource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 M2\u00020\u0001:\u0002LMB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u001dH&J\u0010\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001bJ0\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0014H$J\u0018\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0014J\u0010\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\nH\u0016J\u000e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u000fJ\u0006\u00103\u001a\u00020\u001dJ\u0006\u00104\u001a\u00020\u001dJ\u0018\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u00020\nJ\b\u00108\u001a\u00020\u001dH\u0002J\u001c\u00109\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u00102\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010:\u001a\u00020\u001dH\u0002J\u001c\u0010;\u001a\u00020\u001d2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u00102\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020>2\u0006\u00102\u001a\u00020\u000fH\u0002J\u001a\u0010?\u001a\u0004\u0018\u00010>2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u000fH\u0002J\b\u0010@\u001a\u00020\u001dH\u0002J\u0012\u0010A\u001a\u00020\u001d2\b\u0010B\u001a\u0004\u0018\u00010\u000eH\u0002R\u001e\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00148\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00148\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00148\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00148\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\n8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0012\u0010F\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0012\u0010H\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010ER\u0012\u0010J\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010E¨\u0006N"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMessageInfos", "", "", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieResource$MessageInfo;", "mLottieAnimationView", "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieContainer", "mLottieWidthRatio", "", "mLottieHeightRatio", "mDefaultLottieWidth", "mDefaultLottieHeight", "mMessageTextSize", "mMessageTextColor", "mContract", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout$Contract;", "init", "", "initialize", "setContract", "contract", "onLayout", "changed", "", "left", "top", "right", "bottom", "updateLottieContainer", "layoutWidth", "layoutHeight", "updateLottieContainerSize", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRtlPropertiesChanged", "layoutDirection", "addMessageInfo", "messageInfo", "playLottieAnimation", "cancelLottieAnimation", "setLottieAnimation", "assetName", "repeatCount", "updateMessageViews", "updateMessageView", "initTextAnimations", "initTextViewAnimation", "animateMessageView", "messageView", "Landroid/widget/TextView;", "getMessageView", "cancelTextAnimation", "cancelTextViewAnimation", "textViewTag", "lottieWidthRatio", "getLottieWidthRatio", "()F", "lottieHeightRatio", "getLottieHeightRatio", "defaultLottieWidth", "getDefaultLottieWidth", "defaultLottieHeight", "getDefaultLottieHeight", "Contract", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class LottieWithMessageLayout extends FrameLayout {

    @NotNull
    private static final String TAG = "LottieWithMessageLayout";

    @Nullable
    private Contract mContract;

    @JvmField
    protected float mDefaultLottieHeight;

    @JvmField
    protected float mDefaultLottieWidth;

    @Nullable
    private LottieAnimationView mLottieAnimationView;

    @JvmField
    @Nullable
    protected FrameLayout mLottieContainer;

    @JvmField
    protected float mLottieHeightRatio;

    @JvmField
    protected float mLottieWidthRatio;

    @Nullable
    private Map<String, LottieResource.MessageInfo> mMessageInfos;

    @ColorInt
    @JvmField
    protected int mMessageTextColor;

    @JvmField
    protected float mMessageTextSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout$Contract;", "", "onLottieContainerLayoutChange", "", "containerTop", "", "containerBottom", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onLottieContainerLayoutChange(int containerTop, int containerBottom);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieWithMessageLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    private final void animateMessageView(TextView messageView, LottieResource.MessageInfo messageInfo) {
        Logger.m8697d(TAG, "animateMessageView# show: " + messageInfo.getTag());
        messageView.setAlpha(0.0f);
        messageView.setVisibility(0);
        messageView.animate().alpha(1.0f).setStartDelay(messageInfo.getShowDelay()).setDuration(messageInfo.getShowDuration()).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC8515c(messageInfo, messageView, 21)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateMessageView$lambda$2(LottieResource.MessageInfo messageInfo, TextView textView) {
        if (messageInfo.getDismissDelay() < 0) {
            return;
        }
        Logger.m8697d(TAG, "animateMessageView# dismiss: " + messageInfo.getTag());
        textView.animate().alpha(0.0f).setStartDelay(messageInfo.getDismissDelay()).setDuration(messageInfo.getDismissDuration()).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC7949a(textView, 2)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTextAnimation() {
        Map<String, LottieResource.MessageInfo> map = this.mMessageInfos;
        if (map == null) {
            return;
        }
        Intrinsics.checkNotNull(map);
        Iterator<Map.Entry<String, LottieResource.MessageInfo>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            cancelTextViewAnimation(it.next().getValue().getTag());
        }
    }

    private final void cancelTextViewAnimation(String textViewTag) {
        TextView textView = (TextView) findViewWithTag(textViewTag);
        if (textView == null) {
            return;
        }
        textView.animate().cancel();
    }

    private final TextView getMessageView(Context context, LottieResource.MessageInfo messageInfo) {
        if (this.mLottieContainer == null) {
            return null;
        }
        TextView textView = (TextView) findViewWithTag(messageInfo.getTag());
        if (textView != null) {
            return textView;
        }
        View viewInflate = LayoutInflater.from(context).inflate(C8875R.layout.lottie_msg_view, (ViewGroup) this, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) viewInflate;
        textView2.setTag(messageInfo.getTag());
        textView2.setText(messageInfo.getStringRes());
        textView2.setTextColor(this.mMessageTextColor);
        textView2.setLayoutDirection(0);
        textView2.setTextAlignment(messageInfo.getIsLeftSideOfLottie() ? 6 : 5);
        FrameLayout frameLayout = this.mLottieContainer;
        if (frameLayout != null) {
            frameLayout.addView(textView2);
        }
        return textView2;
    }

    private final void init(Context context) {
        initialize();
        LayoutInflater.from(context).inflate(C8875R.layout.lottie_with_message_layout, (ViewGroup) this, true);
        this.mLottieContainer = (FrameLayout) findViewById(C8875R.id.lottie_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initTextAnimations() {
        Map<String, LottieResource.MessageInfo> map = this.mMessageInfos;
        if (map == null) {
            return;
        }
        Intrinsics.checkNotNull(map);
        Iterator<Map.Entry<String, LottieResource.MessageInfo>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            initTextViewAnimation(getContext(), it.next().getValue());
        }
    }

    private final void initTextViewAnimation(Context context, LottieResource.MessageInfo messageInfo) {
        TextView messageView;
        if (context == null || messageInfo == null || (messageView = getMessageView(context, messageInfo)) == null) {
            return;
        }
        animateMessageView(messageView, messageInfo);
    }

    private final void updateLottieContainer(float layoutWidth, float layoutHeight) {
        FrameLayout frameLayout = this.mLottieContainer;
        if (frameLayout == null || layoutHeight <= 0.0f || layoutWidth <= 0.0f) {
            return;
        }
        if (frameLayout != null) {
            frameLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.lottie.LottieWithMessageLayout.updateLottieContainer.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    if (LottieWithMessageLayout.this.mContract != null) {
                        Rect rect = new Rect();
                        v.getGlobalVisibleRect(rect);
                        Contract contract = LottieWithMessageLayout.this.mContract;
                        if (contract != null) {
                            contract.onLottieContainerLayoutChange(rect.top, rect.bottom);
                        }
                    }
                    FrameLayout frameLayout2 = LottieWithMessageLayout.this.mLottieContainer;
                    if (frameLayout2 != null) {
                        frameLayout2.removeOnLayoutChangeListener(this);
                    }
                }
            });
        }
        updateLottieContainerSize(layoutWidth, layoutHeight);
    }

    private final void updateMessageView(Context context, LottieResource.MessageInfo messageInfo) {
        TextView messageView;
        if (context == null || messageInfo == null || (messageView = getMessageView(context, messageInfo)) == null) {
            return;
        }
        messageView.post(new RunnableC8928b(this, 4, messageInfo, messageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMessageView$lambda$0(LottieWithMessageLayout lottieWithMessageLayout, LottieResource.MessageInfo messageInfo, TextView textView) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3 = null;
        if (lottieWithMessageLayout.mLottieAnimationView != null) {
            numValueOf = Integer.valueOf((int) (messageInfo.getStartRatio() * r0.getMeasuredWidth()));
        } else {
            numValueOf = null;
        }
        if (lottieWithMessageLayout.mLottieAnimationView != null) {
            numValueOf2 = Integer.valueOf((int) (messageInfo.getEndRatio() * r2.getMeasuredWidth()));
        } else {
            numValueOf2 = null;
        }
        if (lottieWithMessageLayout.mLottieAnimationView != null) {
            numValueOf3 = Integer.valueOf((int) (messageInfo.getTopRatio() * r4.getMeasuredHeight()));
        }
        if (numValueOf == null || numValueOf3 == null || numValueOf2 == null) {
            return;
        }
        textView.setPaddingRelative(numValueOf.intValue(), numValueOf3.intValue(), numValueOf2.intValue(), textView.getPaddingBottom());
    }

    private final void updateMessageViews() {
        Map<String, LottieResource.MessageInfo> map = this.mMessageInfos;
        if (map == null) {
            return;
        }
        Intrinsics.checkNotNull(map);
        Iterator<Map.Entry<String, LottieResource.MessageInfo>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            updateMessageView(getContext(), it.next().getValue());
        }
    }

    public final void addMessageInfo(@NotNull LottieResource.MessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(messageInfo, "messageInfo");
        if (this.mMessageInfos == null) {
            this.mMessageInfos = new HashMap();
        }
        Map<String, LottieResource.MessageInfo> map = this.mMessageInfos;
        Intrinsics.checkNotNull(map);
        map.put(messageInfo.getTag(), messageInfo);
    }

    public final void cancelLottieAnimation() {
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView == null || lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.cancelAnimation();
    }

    public abstract float getDefaultLottieHeight();

    public abstract float getDefaultLottieWidth();

    public abstract float getLottieHeightRatio();

    public abstract float getLottieWidthRatio();

    public abstract void initialize();

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            updateLottieContainer(Math.abs(left - right), Math.abs(top - bottom));
            updateMessageViews();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        FrameLayout frameLayout = this.mLottieContainer;
        if (frameLayout == null) {
            return;
        }
        float f = this.mMessageTextSize;
        Intrinsics.checkNotNull(frameLayout);
        float f4 = f * frameLayout.getResources().getDisplayMetrics().density;
        Intrinsics.checkNotNull(this.mLottieContainer);
        float measuredWidth = (f4 * r6.getMeasuredWidth()) / this.mDefaultLottieWidth;
        FrameLayout frameLayout2 = this.mLottieContainer;
        Intrinsics.checkNotNull(frameLayout2);
        int childCount = frameLayout2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            FrameLayout frameLayout3 = this.mLottieContainer;
            View childAt = frameLayout3 != null ? frameLayout3.getChildAt(i) : null;
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (((int) measuredWidth) != ((int) textView.getTextSize())) {
                    Logger.m8697d(TAG, "onMeasure# idx :" + i + " textSize: " + measuredWidth);
                    textView.setTextSize(0, measuredWidth);
                }
            }
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        updateMessageViews();
    }

    public final void playLottieAnimation() {
        LottieAnimationView lottieAnimationView = this.mLottieAnimationView;
        if (lottieAnimationView == null || lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.playAnimation();
    }

    public final void setContract(@Nullable Contract contract) {
        this.mContract = contract;
    }

    public final void setLottieAnimation(@Nullable String assetName, int repeatCount) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(C8875R.id.lottie);
        this.mLottieAnimationView = lottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(repeatCount);
        }
        LottieAnimationView lottieAnimationView2 = this.mLottieAnimationView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setAnimation(assetName);
        }
        LottieAnimationView lottieAnimationView3 = this.mLottieAnimationView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.lottie.LottieWithMessageLayout.setLottieAnimation.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    LottieWithMessageLayout.this.cancelTextAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    LottieWithMessageLayout.this.initTextAnimations();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    LottieWithMessageLayout.this.initTextAnimations();
                }
            });
        }
    }

    public abstract void updateLottieContainerSize(float layoutWidth, float layoutHeight);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieWithMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieWithMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        init(context);
    }
}
