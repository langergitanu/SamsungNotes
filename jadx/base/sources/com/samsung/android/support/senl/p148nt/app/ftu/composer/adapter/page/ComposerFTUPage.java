package com.samsung.android.support.senl.p148nt.app.ftu.composer.adapter.page;

import android.content.Context;
import android.util.AttributeSet;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayoutImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/ftu/composer/adapter/page/ComposerFTUPage;", "Lcom/samsung/android/support/senl/nt/base/winset/view/lottie/LottieWithMessageLayoutImpl;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialize", "", "lottieWidthRatio", "", "getLottieWidthRatio", "()F", "lottieHeightRatio", "getLottieHeightRatio", "defaultLottieWidth", "getDefaultLottieWidth", "defaultLottieHeight", "getDefaultLottieHeight", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ComposerFTUPage extends LottieWithMessageLayoutImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerFTUPage(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayoutImpl, com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getDefaultLottieHeight() {
        return this.mDefaultLottieHeight;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayoutImpl, com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getDefaultLottieWidth() {
        return this.mDefaultLottieWidth;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayoutImpl, com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getLottieHeightRatio() {
        return this.mLottieHeightRatio;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayoutImpl, com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public float getLottieWidthRatio() {
        if (getResources().getConfiguration().orientation == 2) {
            return this.mLottieWidthRatio;
        }
        return 1.0f;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayoutImpl, com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout
    public void initialize() {
        this.mLottieWidthRatio = 0.625f;
        this.mLottieHeightRatio = 0.5f;
        this.mDefaultLottieWidth = getResources().getDimension(C8003R.dimen.ftu_composer_lottie_default_width);
        this.mDefaultLottieHeight = getResources().getDimension(C8003R.dimen.ftu_composer_lottie_default_height);
        this.mMessageTextSize = getResources().getDimension(C8003R.dimen.ftu_composer_msg_text_size);
        this.mMessageTextColor = getResources().getColor(C8003R.color.ftu_msg_text_color, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerFTUPage(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerFTUPage(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
