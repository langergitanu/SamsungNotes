package com.samsung.android.support.senl.p148nt.base.winset.view.lottie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayoutImpl;", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialize", "", "updateLottieContainerSize", "layoutWidth", "", "layoutHeight", "lottieWidthRatio", "getLottieWidthRatio", "()F", "lottieHeightRatio", "getLottieHeightRatio", "defaultLottieWidth", "getDefaultLottieWidth", "defaultLottieHeight", "getDefaultLottieHeight", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class LottieWithMessageLayoutImpl extends LottieWithMessageLayout {

    @NotNull
    private static final String TAG = "LottieWithMessageLayout";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieWithMessageLayoutImpl(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getDefaultLottieHeight() {
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getDefaultLottieWidth() {
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getLottieHeightRatio() {
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getLottieWidthRatio() {
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public void initialize() {
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public void updateLottieContainerSize(float layoutWidth, float layoutHeight) {
        float defaultLottieWidth;
        float defaultLottieHeight;
        if (this.mLottieContainer == null || layoutHeight <= 0.0f || layoutWidth <= 0.0f) {
            return;
        }
        if (layoutWidth < layoutHeight) {
            defaultLottieWidth = getLottieWidthRatio() * layoutWidth;
            defaultLottieHeight = (getDefaultLottieHeight() * defaultLottieWidth) / getDefaultLottieWidth();
            if (layoutHeight < defaultLottieHeight) {
                defaultLottieHeight = getLottieHeightRatio() * layoutHeight;
                defaultLottieWidth = (getDefaultLottieWidth() * defaultLottieHeight) / getDefaultLottieHeight();
            }
        } else {
            float lottieHeightRatio = layoutHeight * getLottieHeightRatio();
            defaultLottieWidth = (getDefaultLottieWidth() * lottieHeightRatio) / getDefaultLottieHeight();
            if (layoutWidth < defaultLottieWidth) {
                defaultLottieWidth = getLottieWidthRatio() * layoutWidth;
                defaultLottieHeight = (getDefaultLottieHeight() * defaultLottieWidth) / getDefaultLottieWidth();
            } else {
                defaultLottieHeight = lottieHeightRatio;
            }
        }
        FrameLayout frameLayout = this.mLottieContainer;
        Intrinsics.checkNotNull(frameLayout);
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = (int) defaultLottieWidth;
        layoutParams.height = (int) defaultLottieHeight;
        FrameLayout frameLayout2 = this.mLottieContainer;
        if (frameLayout2 != null) {
            frameLayout2.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieWithMessageLayoutImpl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieWithMessageLayoutImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
