package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextSwitcher;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\b*\u0001\u001e\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u001f\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u001b\"\u00020\f¢\u0006\u0002\u0010\u001cJ\b\u0010 \u001a\u00020\u0019H\u0002J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\b\u0010#\u001a\u00020\u0019H\u0002J\u0006\u0010$\u001a\u00020\u0019R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/progress/AnimatedHelpTextView;", "Landroid/widget/TextSwitcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Landroid/os/Handler;", "textList", "", "", "currentIndex", "", "isRunning", "", "delay", "", "isInitialAppearance", "createInitialInAnimation", "Landroid/view/animation/Animation;", "createInAnimation", "createOutAnimation", "setHelpText", "", "texts", "", "([Ljava/lang/String;)V", "textSwitcherRunnable", "com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/progress/AnimatedHelpTextView$textSwitcherRunnable$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/progress/AnimatedHelpTextView$textSwitcherRunnable$1;", "startTextSwitching", "appear", "disappear", "stopTextSwitching", "clear", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AnimatedHelpTextView extends TextSwitcher {
    private int currentIndex;
    private final long delay;

    @NotNull
    private final Handler handler;
    private boolean isInitialAppearance;
    private boolean isRunning;

    @NotNull
    private List<String> textList;

    @NotNull
    private final AnimatedHelpTextView$textSwitcherRunnable$1 textSwitcherRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AnimatedHelpTextView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(AnimatedHelpTextView animatedHelpTextView) {
        ViewParent parent = animatedHelpTextView.getParent();
        while (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            parent = viewGroup.getParent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Animation createInAnimation() {
        float fApplyDimension = TypedValue.applyDimension(1, 25.0f, getContext().getResources().getDisplayMetrics());
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, -fApplyDimension, 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setStartOffset(150L);
        alphaAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private final Animation createInitialInAnimation() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    private final Animation createOutAnimation() {
        float fApplyDimension = TypedValue.applyDimension(1, 25.0f, getContext().getResources().getDisplayMetrics());
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0.0f, 0, fApplyDimension, 0, 0.0f, 0, 0.0f);
        translateAnimation.setDuration(500L);
        translateAnimation.setInterpolator(new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private final void startTextSwitching() {
        if (this.isRunning || this.textList.isEmpty() || this.textList.size() <= 1) {
            return;
        }
        this.isRunning = true;
        this.handler.postDelayed(this.textSwitcherRunnable, this.delay);
    }

    private final void stopTextSwitching() {
        this.isRunning = false;
        this.handler.removeCallbacks(this.textSwitcherRunnable);
    }

    public final void appear() {
        if (this.isRunning || getNextView() == null || this.textList.isEmpty()) {
            return;
        }
        this.isRunning = false;
        this.handler.removeCallbacks(this.textSwitcherRunnable);
        this.isInitialAppearance = true;
        setInAnimation(createInitialInAnimation());
        setOutAnimation(createOutAnimation());
        setText("\n\n\n\n\n");
        this.currentIndex = 0;
        setText(this.textList.get(0));
        startTextSwitching();
    }

    public final void clear() {
        reset();
        removeAllViews();
    }

    public final void disappear() {
        stopTextSwitching();
        if (getNextView() != null) {
            setText("");
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
    }

    public final void setHelpText(@NotNull String... texts) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        this.textList = ArraysKt.toList(texts);
        this.currentIndex = 0;
        this.isRunning = false;
    }

    public /* synthetic */ AnimatedHelpTextView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AnimatedHelpTextView$textSwitcherRunnable$1] */
    @JvmOverloads
    public AnimatedHelpTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        this.textList = CollectionsKt.emptyList();
        this.delay = 2000L;
        this.isInitialAppearance = true;
        setClipChildren(false);
        setClipToPadding(false);
        post(new RunnableC8669a(this, 28));
        setInAnimation(createInitialInAnimation());
        setOutAnimation(createOutAnimation());
        this.textSwitcherRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AnimatedHelpTextView$textSwitcherRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (!this.this$0.isRunning || this.this$0.textList.isEmpty()) {
                    return;
                }
                if (this.this$0.isInitialAppearance) {
                    this.this$0.isInitialAppearance = false;
                    AnimatedHelpTextView animatedHelpTextView = this.this$0;
                    animatedHelpTextView.setInAnimation(animatedHelpTextView.createInAnimation());
                }
                AnimatedHelpTextView animatedHelpTextView2 = this.this$0;
                animatedHelpTextView2.currentIndex = (animatedHelpTextView2.currentIndex + 1) % this.this$0.textList.size();
                AnimatedHelpTextView animatedHelpTextView3 = this.this$0;
                animatedHelpTextView3.setText((CharSequence) animatedHelpTextView3.textList.get(this.this$0.currentIndex));
                this.this$0.handler.postDelayed(this, this.this$0.delay);
            }
        };
    }
}
