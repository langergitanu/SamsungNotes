package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BuildCompat;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiDisclaimerDialog;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p012C1.RunnableC0050f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0006\u0010\u001c\u001a\u00020\u0013R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverAILayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverAILayout$Contract;", "mCoverAiContainer", "Landroid/view/View;", "mCoverAiButton", "mCoverAiDisclaimer", "mGuidingLightEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightEffect;", "setContract", "", "contract", "setAiButtonAlpha", "activate", "", "setDisclaimerVisibility", "visibility", "setGuidingLightBackground", "applyGuidingLightEffect", "clearGuidingLightEffect", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverAILayout extends ConstraintLayout {

    @NotNull
    public static final String TAG = "CoverAILayout";

    @Nullable
    private Contract mContract;

    @Nullable
    private View mCoverAiButton;

    @Nullable
    private View mCoverAiContainer;

    @Nullable
    private View mCoverAiDisclaimer;

    @Nullable
    private GuidingLightEffect mGuidingLightEffect;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverAILayout$Contract;", "", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "onClickAiButton", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        @NotNull
        FragmentManager getSupportFragmentManager();

        void onClickAiButton();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverAILayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(CoverAILayout coverAILayout, View view) {
        Logger.m10999d(TAG, "mCoverSuggestButton Clicked");
        Contract contract = coverAILayout.mContract;
        if (contract != null) {
            coverAILayout.setDisclaimerVisibility(4);
            contract.onClickAiButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(CoverAILayout coverAILayout, View view) {
        Logger.m10999d(TAG, "mCoverDisclaimer Clicked");
        Contract contract = coverAILayout.mContract;
        if (contract != null) {
            new AiDisclaimerDialog.DisclaimerDialogFragment(false).show(contract.getSupportFragmentManager(), AiDisclaimerDialog.DisclaimerDialogFragment.TAG);
        }
    }

    private final void applyGuidingLightEffect() {
        if (Build.VERSION.SDK_INT < 35 || this.mGuidingLightEffect != null || this.mCoverAiButton == null) {
            return;
        }
        GuidingLightConfig guidingLightConfig = ContextUtils.isNightMode(getContext()) ? GuidingLightConfig.BUTTON_DARK : GuidingLightConfig.BUTTON_LIGHT;
        guidingLightConfig.setLightMovement(GuidingLightEffect.Movement.NONE);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View view = this.mCoverAiButton;
        Intrinsics.checkNotNull(view);
        GuidingLightEffect guidingLightEffect = new GuidingLightEffect(context, view, guidingLightConfig);
        this.mGuidingLightEffect = guidingLightEffect;
        guidingLightEffect.setDefaultTouchInteraction(true);
        GuidingLightEffect guidingLightEffect2 = this.mGuidingLightEffect;
        if (guidingLightEffect2 != null) {
            guidingLightEffect2.setCornerRadiusPixel(ResourceUtils.convertDpToPixel(getContext(), 26.0f));
        }
        GuidingLightEffect guidingLightEffect3 = this.mGuidingLightEffect;
        Intrinsics.checkNotNull(guidingLightEffect3);
        guidingLightEffect3.show(GuidingLightEffect.ShowAnimationType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDisclaimerVisibility$lambda$4(CoverAILayout coverAILayout, int i) {
        View view = coverAILayout.mCoverAiDisclaimer;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public final void clearGuidingLightEffect() {
        GuidingLightEffect guidingLightEffect;
        if (Build.VERSION.SDK_INT < 35 || (guidingLightEffect = this.mGuidingLightEffect) == null) {
            return;
        }
        Intrinsics.checkNotNull(guidingLightEffect);
        guidingLightEffect.hide(GuidingLightEffect.HideAnimationType.NONE);
        GuidingLightEffect guidingLightEffect2 = this.mGuidingLightEffect;
        Intrinsics.checkNotNull(guidingLightEffect2);
        View view = this.mCoverAiButton;
        Intrinsics.checkNotNull(view);
        guidingLightEffect2.remove(view);
        GuidingLightEffect guidingLightEffect3 = this.mGuidingLightEffect;
        Intrinsics.checkNotNull(guidingLightEffect3);
        guidingLightEffect3.release();
        this.mGuidingLightEffect = null;
    }

    public final void setAiButtonAlpha(boolean activate) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        View view = this.mCoverAiButton;
        if (view != null) {
            view.setEnabled(activate);
        }
        View view2 = this.mCoverAiContainer;
        if (view2 == null || (viewPropertyAnimatorAnimate = view2.animate()) == null) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(activate ? 1.0f : 0.4f);
        if (viewPropertyAnimatorAlpha == null || (duration = viewPropertyAnimatorAlpha.setDuration(200L)) == null || (interpolator = duration.setInterpolator(new LinearInterpolator())) == null) {
            return;
        }
        interpolator.start();
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void setDisclaimerVisibility(int visibility) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator viewPropertyAnimatorWithEndAction;
        if (visibility == 0) {
            View view = this.mCoverAiDisclaimer;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            View view2 = this.mCoverAiDisclaimer;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        View view3 = this.mCoverAiDisclaimer;
        if (view3 == null || (viewPropertyAnimatorAnimate = view3.animate()) == null) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(visibility == 0 ? 1.0f : 0.0f);
        if (viewPropertyAnimatorAlpha != null) {
            ViewPropertyAnimator duration = viewPropertyAnimatorAlpha.setDuration(visibility == 0 ? 200L : 100L);
            if (duration == null || (interpolator = duration.setInterpolator(new LinearInterpolator())) == null || (viewPropertyAnimatorWithEndAction = interpolator.withEndAction(new RunnableC0050f(this, visibility, 21))) == null) {
                return;
            }
            viewPropertyAnimatorWithEndAction.start();
        }
    }

    public final void setGuidingLightBackground() {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{ContextCompat.getDrawable(getContext(), C9086R.drawable.cover_ai_view_bg), new GradientDrawable(GradientDrawable.Orientation.TL_BR, !ContextUtils.isNightMode(getContext()) ? new int[]{-1, -327694, -983041, -1510401, -1118209, -461057} : new int[]{-14275793, -14602965, -14471120, -14275016, -14145228, -13948366})});
        View view = this.mCoverAiButton;
        Intrinsics.checkNotNull(view);
        view.setBackground(layerDrawable);
        View view2 = this.mCoverAiButton;
        Intrinsics.checkNotNull(view2);
        view2.setClipToOutline(true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverAILayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CoverAILayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverAILayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, C9086R.layout.cover_ai_layout, this);
        this.mCoverAiContainer = findViewById(C9086R.id.cover_ai_container);
        View viewFindViewById = findViewById(C9086R.id.cover_ai_button);
        this.mCoverAiButton = viewFindViewById;
        if (viewFindViewById != null) {
            final int i2 = 0;
            viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CoverAILayout f7169b;

                {
                    this.f7169b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            CoverAILayout._init_$lambda$1(this.f7169b, view);
                            break;
                        default:
                            CoverAILayout._init_$lambda$3(this.f7169b, view);
                            break;
                    }
                }
            });
        }
        View viewFindViewById2 = findViewById(C9086R.id.cover_ai_disclaimer);
        this.mCoverAiDisclaimer = viewFindViewById2;
        if (viewFindViewById2 != null) {
            final int i4 = 1;
            viewFindViewById2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.a

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CoverAILayout f7169b;

                {
                    this.f7169b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            CoverAILayout._init_$lambda$1(this.f7169b, view);
                            break;
                        default:
                            CoverAILayout._init_$lambda$3(this.f7169b, view);
                            break;
                    }
                }
            });
        }
        if (BuildCompat.INSTANCE.isAtLeast(BuildCompat.Version.f5797V)) {
            applyGuidingLightEffect();
        } else {
            setGuidingLightBackground();
        }
    }
}
