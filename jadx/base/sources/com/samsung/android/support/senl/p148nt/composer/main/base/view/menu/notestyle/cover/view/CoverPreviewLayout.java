package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC4697c;
import com.google.android.material.oneui.floatingdock.ViewOnTouchListenerC4799j;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightEffect;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.BuildCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentCoverUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 [2\u00020\u0001:\u0002Z[B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0011J\u0006\u00104\u001a\u000202J\b\u00105\u001a\u000202H\u0003J\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u000202J\b\u0010:\u001a\u000202H\u0002J\u0006\u0010;\u001a\u000202J\u0010\u0010<\u001a\u0002022\u0006\u0010=\u001a\u000208H\u0002J\b\u0010>\u001a\u000202H\u0003J\u000e\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AJ\b\u0010B\u001a\u000202H\u0002J\b\u0010C\u001a\u000202H\u0002J\b\u0010D\u001a\u000202H\u0002J\b\u0010E\u001a\u000202H\u0002J\b\u0010F\u001a\u000202H\u0002J\u0016\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007J\b\u0010J\u001a\u000202H\u0002J\b\u0010K\u001a\u000202H\u0002J\b\u0010L\u001a\u000202H\u0002J\b\u0010M\u001a\u000202H\u0002J\u0006\u0010N\u001a\u000202J\u000e\u0010O\u001a\u0002022\u0006\u0010P\u001a\u000208J\b\u0010Q\u001a\u000202H\u0003J\b\u0010R\u001a\u000202H\u0003J\b\u0010S\u001a\u000202H\u0003J\u000e\u0010T\u001a\u0002022\u0006\u0010U\u001a\u000208J\u0018\u0010V\u001a\u0002022\u0006\u0010U\u001a\u0002082\b\u0010W\u001a\u0004\u0018\u00010\u0013J\n\u0010X\u001a\u0004\u0018\u00010YH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverPreviewLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "STICKER_CONTAINER_DURATION", "", "STICKER_DURATION", "STICKER_CONTAINER_INTERPOLATOR", "Landroid/view/animation/PathInterpolator;", "STICKER_INTERPOLATOR", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverPreviewLayout$Contract;", "mCoverPreviewContainer", "Landroid/view/View;", "mCoverNewPreview", "mCoverPreview", "Landroid/widget/ImageView;", "mCoverLine", "mCoverSummaryView", "Landroid/widget/EditText;", "mCoverStickerContainer", "mCoverStickerEmptyView", "mCoverStickerView", "mCoverStickerIconView", "mAddButton", "mClearButton", "mCoverText", "Landroid/widget/TextView;", "mScaleAnimatorSet", "Landroid/animation/AnimatorSet;", "mStickerAnimatorSet", "mStickerNoneAnimator", "Landroid/animation/ObjectAnimator;", "mStickerPrevNoneAnimator", "mTransitionLightView", "mCoverBlockView", "mCoverProgressContainer", "mCoverProgress", "Lcom/airbnb/lottie/LottieAnimationView;", "mContentAreaEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightEffect;", "mTransitionEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightEffect;", "setContract", "", "contract", "initCoverPreview", "setListener", "updateCoverPreviewContainer", "isSelected", "", "updateCoverPreviewLayout", "onClickClearButton", "onClickAddButton", "updateCoverPreviewTitle", "isEnable", "setSummaryView", "updateCoverSummary", DBSchema.DocumentCover.SUMMARY, "", "setSummaryTextColor", "setEditorMaxLengthFilter", "showMaxCharToast", "setStickerBackground", "updateStickerBackground", "updateCoverSticker", "stickerPosition", "stickerPrevPosition", "setStickerAnimation", "startStickerAnimation", "startStickerNoneAnimation", "startStickerPrevNoneAnimation", "startGenerateAnimation", "stopGenerateAnimation", "withAnimation", "startProcessingLightEffect", "startTransitionLightEffect", "clearEffect", "animateCoverNewPreview", "isVisible", "animateButton", "targetView", "getCoverData", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverData;", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCoverPreviewLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoverPreviewLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverPreviewLayout\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n*L\n1#1,649:1\n13472#2,2:650\n28#3:652\n*S KotlinDebug\n*F\n+ 1 CoverPreviewLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverPreviewLayout\n*L\n255#1:650,2\n258#1:652\n*E\n"})
public final class CoverPreviewLayout extends ConstraintLayout {

    @NotNull
    public static final String TAG = "CoverPreviewLayout";
    private final long STICKER_CONTAINER_DURATION;

    @NotNull
    private final PathInterpolator STICKER_CONTAINER_INTERPOLATOR;
    private final long STICKER_DURATION;

    @NotNull
    private final PathInterpolator STICKER_INTERPOLATOR;

    @Nullable
    private View mAddButton;

    @Nullable
    private View mClearButton;

    @Nullable
    private ProcessingLightEffect mContentAreaEffect;

    @Nullable
    private Contract mContract;

    @Nullable
    private View mCoverBlockView;

    @Nullable
    private ImageView mCoverLine;

    @Nullable
    private View mCoverNewPreview;

    @Nullable
    private ImageView mCoverPreview;

    @Nullable
    private View mCoverPreviewContainer;

    @Nullable
    private LottieAnimationView mCoverProgress;

    @Nullable
    private View mCoverProgressContainer;

    @Nullable
    private ConstraintLayout mCoverStickerContainer;

    @Nullable
    private ImageView mCoverStickerEmptyView;

    @Nullable
    private ImageView mCoverStickerIconView;

    @Nullable
    private View mCoverStickerView;

    @Nullable
    private EditText mCoverSummaryView;

    @Nullable
    private TextView mCoverText;

    @Nullable
    private AnimatorSet mScaleAnimatorSet;

    @Nullable
    private AnimatorSet mStickerAnimatorSet;

    @Nullable
    private ObjectAnimator mStickerNoneAnimator;

    @Nullable
    private ObjectAnimator mStickerPrevNoneAnimator;

    @Nullable
    private TransitionLightEffect mTransitionEffect;

    @Nullable
    private View mTransitionLightView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverPreviewLayout$Contract;", "", "onClickClearButton", "", "onClickCoverPreview", "isCoverPreviewSelect", "", "getCoverData", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverData;", "setCoverSummary", DBSchema.DocumentCover.SUMMARY, "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        @Nullable
        CoverData getCoverData();

        boolean isCoverPreviewSelect();

        void onClickClearButton();

        void onClickCoverPreview();

        void setCoverSummary(@NotNull String summary);
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$startGenerateAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$startGenerateAnimation$1", m14021f = "CoverPreviewLayout.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C103611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C103611(Continuation<? super C103611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CoverPreviewLayout.this.new C103611(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Logger.m10999d(CoverPreviewLayout.TAG, "startGenerateAnimation");
            View view = CoverPreviewLayout.this.mCoverProgressContainer;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            View view2 = CoverPreviewLayout.this.mCoverProgressContainer;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            EditText editText = CoverPreviewLayout.this.mCoverSummaryView;
            if (editText != null) {
                editText.clearFocus();
            }
            View view3 = CoverPreviewLayout.this.mCoverBlockView;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(CoverPreviewLayout.this.mCoverProgressContainer, (Property<View, Float>) ViewGroup.ALPHA, 0.0f, 1.0f);
            final CoverPreviewLayout coverPreviewLayout = CoverPreviewLayout.this;
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$startGenerateAnimation$1$animator$1$1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    CoverPreviewLayout coverPreviewLayout2 = coverPreviewLayout;
                    coverPreviewLayout2.animateButton(false, coverPreviewLayout2.mClearButton);
                    LottieAnimationView lottieAnimationView = coverPreviewLayout.mCoverProgress;
                    if (lottieAnimationView != null) {
                        lottieAnimationView.playAnimation();
                    }
                    if (BuildCompat.INSTANCE.isAtLeast(BuildCompat.Version.f5797V)) {
                        coverPreviewLayout.startProcessingLightEffect();
                    }
                }
            });
            objectAnimatorOfFloat.start();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C103611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$stopGenerateAnimation$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$stopGenerateAnimation$1", m14021f = "CoverPreviewLayout.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C103621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $withAnimation;
        int label;
        final /* synthetic */ CoverPreviewLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103621(boolean z, CoverPreviewLayout coverPreviewLayout, Continuation<? super C103621> continuation) {
            super(2, continuation);
            this.$withAnimation = z;
            this.this$0 = coverPreviewLayout;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C103621(this.$withAnimation, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AbstractC8014b.m7220v("stopGenerateAnimation# withAnimation : ", CoverPreviewLayout.TAG, this.$withAnimation);
            LottieAnimationView lottieAnimationView = this.this$0.mCoverProgress;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
            }
            View view = this.this$0.mCoverProgressContainer;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.this$0.mCoverBlockView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            CoverPreviewLayout coverPreviewLayout = this.this$0;
            coverPreviewLayout.animateButton(true, coverPreviewLayout.mClearButton);
            if (BuildCompat.INSTANCE.isAtLeast(BuildCompat.Version.f5797V)) {
                if (this.$withAnimation) {
                    this.this$0.startTransitionLightEffect();
                } else {
                    this.this$0.clearEffect();
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C103621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverPreviewLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({WarningType.NewApi})
    public final void clearEffect() {
        TransitionLightEffect transitionLightEffect = this.mTransitionEffect;
        if (transitionLightEffect != null) {
            Intrinsics.checkNotNull(transitionLightEffect);
            transitionLightEffect.stop();
            TransitionLightEffect transitionLightEffect2 = this.mTransitionEffect;
            Intrinsics.checkNotNull(transitionLightEffect2);
            View view = this.mCoverNewPreview;
            Intrinsics.checkNotNull(view);
            transitionLightEffect2.remove(view);
            TransitionLightEffect transitionLightEffect3 = this.mTransitionEffect;
            Intrinsics.checkNotNull(transitionLightEffect3);
            transitionLightEffect3.release();
            this.mTransitionEffect = null;
        }
        ProcessingLightEffect processingLightEffect = this.mContentAreaEffect;
        if (processingLightEffect != null) {
            Intrinsics.checkNotNull(processingLightEffect);
            processingLightEffect.stop();
            ProcessingLightEffect processingLightEffect2 = this.mContentAreaEffect;
            Intrinsics.checkNotNull(processingLightEffect2);
            View view2 = this.mCoverProgressContainer;
            Intrinsics.checkNotNull(view2);
            processingLightEffect2.remove(view2);
            ProcessingLightEffect processingLightEffect3 = this.mContentAreaEffect;
            Intrinsics.checkNotNull(processingLightEffect3);
            processingLightEffect3.release();
            this.mContentAreaEffect = null;
        }
    }

    private final CoverData getCoverData() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getCoverData();
        }
        return null;
    }

    private final void onClickClearButton() {
        View view = this.mTransitionLightView;
        if (view != null) {
            view.setVisibility(8);
        }
        updateCoverPreviewTitle(false);
        updateCoverPreviewContainer(false);
        animateButton(false, this.mClearButton);
        animateButton(true, this.mAddButton);
        animateCoverNewPreview(false);
        Contract contract = this.mContract;
        if (contract != null) {
            contract.onClickClearButton();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$setEditorMaxLengthFilter$1] */
    private final void setEditorMaxLengthFilter() {
        EditText editText = this.mCoverSummaryView;
        if (editText != null) {
            editText.setFilters(new C103591[]{new InputFilter.LengthFilter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.setEditorMaxLengthFilter.1
                {
                    super(200);
                }

                @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                    CharSequence charSequenceFilter = super.filter(source, start, end, dest, dstart, dend);
                    if (charSequenceFilter != null) {
                        CoverPreviewLayout.this.showMaxCharToast();
                    }
                    return charSequenceFilter;
                }
            }});
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void setListener() {
        View view = this.mCoverPreviewContainer;
        if (view != null) {
            final int i = 0;
            view.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CoverPreviewLayout f7171b;

                {
                    this.f7171b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i) {
                        case 0:
                            CoverPreviewLayout.setListener$lambda$0(this.f7171b, view2);
                            break;
                        case 1:
                            CoverPreviewLayout.setListener$lambda$1(this.f7171b, view2);
                            break;
                        default:
                            CoverPreviewLayout.setListener$lambda$2(this.f7171b, view2);
                            break;
                    }
                }
            });
        }
        ImageView imageView = this.mCoverPreview;
        if (imageView != null) {
            final int i2 = 1;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CoverPreviewLayout f7171b;

                {
                    this.f7171b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i2) {
                        case 0:
                            CoverPreviewLayout.setListener$lambda$0(this.f7171b, view2);
                            break;
                        case 1:
                            CoverPreviewLayout.setListener$lambda$1(this.f7171b, view2);
                            break;
                        default:
                            CoverPreviewLayout.setListener$lambda$2(this.f7171b, view2);
                            break;
                    }
                }
            });
        }
        View view2 = this.mClearButton;
        if (view2 != null) {
            final int i4 = 2;
            view2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.b

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ CoverPreviewLayout f7171b;

                {
                    this.f7171b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view22) {
                    switch (i4) {
                        case 0:
                            CoverPreviewLayout.setListener$lambda$0(this.f7171b, view22);
                            break;
                        case 1:
                            CoverPreviewLayout.setListener$lambda$1(this.f7171b, view22);
                            break;
                        default:
                            CoverPreviewLayout.setListener$lambda$2(this.f7171b, view22);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListener$lambda$0(CoverPreviewLayout coverPreviewLayout, View view) {
        Logger.m10999d(TAG, "mCoverPreviewContainer is clicked");
        Contract contract = coverPreviewLayout.mContract;
        if (contract != null) {
            contract.onClickCoverPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListener$lambda$1(CoverPreviewLayout coverPreviewLayout, View view) {
        Logger.m10999d(TAG, "mCoverPreview is clicked");
        Contract contract = coverPreviewLayout.mContract;
        if (contract != null) {
            contract.onClickCoverPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setListener$lambda$2(CoverPreviewLayout coverPreviewLayout, View view) {
        Logger.m10999d(TAG, "mClearButton is clicked");
        coverPreviewLayout.onClickClearButton();
    }

    private final void setStickerAnimation() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mCoverStickerIconView, (Property<ImageView, Float>) ViewGroup.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mCoverStickerIconView, (Property<ImageView, Float>) ViewGroup.SCALE_Y, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(this.STICKER_DURATION);
        animatorSet.setInterpolator(this.STICKER_INTERPOLATOR);
        this.mScaleAnimatorSet = animatorSet;
        View view = this.mCoverStickerView;
        Intrinsics.checkNotNull(this.mCoverStickerContainer);
        Property property = ViewGroup.TRANSLATION_X;
        this.mStickerPrevNoneAnimator = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, r4.getMeasuredWidth(), 0.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(this.mStickerPrevNoneAnimator, objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet2.setDuration(this.STICKER_CONTAINER_DURATION);
        animatorSet2.setInterpolator(this.STICKER_CONTAINER_INTERPOLATOR);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$setStickerAnimation$2$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                ImageView imageView = this.this$0.mCoverStickerEmptyView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                View view2 = this.this$0.mCoverStickerView;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ImageView imageView2 = this.this$0.mCoverStickerIconView;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
            }
        });
        this.mStickerAnimatorSet = animatorSet2;
        View view2 = this.mCoverStickerView;
        Intrinsics.checkNotNull(this.mCoverStickerContainer);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 0.0f, r2.getMeasuredWidth());
        objectAnimatorOfFloat3.setDuration(this.STICKER_CONTAINER_DURATION);
        objectAnimatorOfFloat3.setInterpolator(this.STICKER_CONTAINER_INTERPOLATOR);
        objectAnimatorOfFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$setStickerAnimation$3$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                ImageView imageView = this.this$0.mCoverStickerEmptyView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.this$0.mCoverStickerIconView;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                View view3 = this.this$0.mCoverStickerView;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            }
        });
        this.mStickerNoneAnimator = objectAnimatorOfFloat3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setStickerBackground() {
        boolean z;
        CoverData coverData = getCoverData();
        AbstractC8014b.m7196B("setStickerBackground# categoryUuid : ", coverData != null ? coverData.getCategoryUuid() : null, TAG);
        CoverData coverData2 = getCoverData();
        if (Intrinsics.areEqual(coverData2 != null ? coverData2.getCategoryUuid() : null, CoverStickerConstants.Category.NONE.UUID)) {
            z = false;
        } else {
            CoverData coverData3 = getCoverData();
            if (!NotesDocumentCoverUtils.isHigherCoverVersion(coverData3 != null ? coverData3.getCategoryUuid() : null)) {
                z = true;
            }
        }
        ImageView imageView = this.mCoverStickerEmptyView;
        if (imageView != null) {
            imageView.setVisibility(z ? 8 : 0);
        }
        View view = this.mCoverStickerView;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
        ImageView imageView2 = this.mCoverStickerIconView;
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 0 : 8);
        }
        ImageView imageView3 = this.mCoverStickerIconView;
        if (imageView3 != null) {
            Context context = getContext();
            CoverData coverData4 = getCoverData();
            imageView3.setImageDrawable(CoverEditorUtils.getCategoryDrawable(context, coverData4 != null ? coverData4.getCategoryUuid() : null));
        }
    }

    private final void setSummaryTextColor() {
        Context context = getContext();
        CoverData coverData = getCoverData();
        String colorId = coverData != null ? coverData.getColorId() : null;
        CoverData coverData2 = getCoverData();
        Pair<Integer, Integer> summaryColor = CoverEditorUtils.getSummaryColor(context, colorId, coverData2 != null ? coverData2.getTemplateUuid() : null);
        EditText editText = this.mCoverSummaryView;
        if (editText != null) {
            Object first = summaryColor.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            editText.setTextColor(((Number) first).intValue());
        }
        EditText editText2 = this.mCoverSummaryView;
        if (editText2 != null) {
            Object second = summaryColor.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            editText2.setHintTextColor(((Number) second).intValue());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void setSummaryView() {
        EditText editText;
        EditText editText2 = this.mCoverSummaryView;
        if (editText2 != null) {
            CoverData coverData = getCoverData();
            editText2.setText(coverData != null ? coverData.getSummary() : null);
        }
        CoverData coverData2 = getCoverData();
        if (!TextUtils.isEmpty(coverData2 != null ? coverData2.getSummary() : null) && (editText = this.mCoverSummaryView) != null) {
            editText.setBackground(new ColorDrawable(0));
        }
        EditText editText3 = this.mCoverSummaryView;
        if (editText3 != null) {
            editText3.setOnFocusChangeListener(new ViewOnFocusChangeListenerC4697c(this, 6));
        }
        EditText editText4 = this.mCoverSummaryView;
        if (editText4 != null) {
            editText4.setOnTouchListener(new ViewOnTouchListenerC4799j(this, 18));
        }
        EditText editText5 = this.mCoverSummaryView;
        if (editText5 != null) {
            editText5.addTextChangedListener(new TextWatcher() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.setSummaryView.3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    Contract contract = CoverPreviewLayout.this.mContract;
                    if (contract != null) {
                        contract.setCoverSummary(String.valueOf(s));
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }
            });
        }
        setEditorMaxLengthFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSummaryView$lambda$4(CoverPreviewLayout coverPreviewLayout, View view, boolean z) {
        String string;
        EditText editText;
        Editable text;
        Logger.m10999d(TAG, "onFocusChange# hasFocus : " + z);
        EditText editText2 = coverPreviewLayout.mCoverSummaryView;
        if (editText2 == null || (text = editText2.getText()) == null || (string = text.toString()) == null) {
            string = "";
        }
        SpannableString spannableString = new SpannableString(string);
        if (!z) {
            EditText editText3 = coverPreviewLayout.mCoverSummaryView;
            if (editText3 != null) {
                editText3.setVerticalScrollBarEnabled(false);
            }
            UnderlineSpan[] underlineSpanArr = (UnderlineSpan[]) spannableString.getSpans(0, spannableString.length(), UnderlineSpan.class);
            Intrinsics.checkNotNull(underlineSpanArr);
            for (UnderlineSpan underlineSpan : underlineSpanArr) {
                spannableString.removeSpan(underlineSpan);
            }
            EditText editText4 = coverPreviewLayout.mCoverSummaryView;
            if (editText4 != null) {
                editText4.setText(Editable.Factory.getInstance().newEditable(spannableString));
            }
            if (spannableString.length() > 0 && (editText = coverPreviewLayout.mCoverSummaryView) != null) {
                editText.setBackground(new ColorDrawable(0));
            }
            InputMethodCompat.INSTANCE.getInstance().hideSoftInput(coverPreviewLayout.getContext(), coverPreviewLayout.mCoverSummaryView);
            return;
        }
        EditText editText5 = coverPreviewLayout.mCoverSummaryView;
        if (editText5 != null) {
            editText5.setVerticalScrollBarEnabled(true);
        }
        EditText editText6 = coverPreviewLayout.mCoverSummaryView;
        Integer numValueOf = editText6 != null ? Integer.valueOf(editText6.getSelectionEnd()) : null;
        if (spannableString.length() > 0) {
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
        }
        EditText editText7 = coverPreviewLayout.mCoverSummaryView;
        if (editText7 != null) {
            editText7.setText(Editable.Factory.getInstance().newEditable(spannableString));
        }
        int iCoerceIn = RangesKt.coerceIn(numValueOf != null ? numValueOf.intValue() : spannableString.length(), 0, spannableString.length());
        try {
            EditText editText8 = coverPreviewLayout.mCoverSummaryView;
            if (editText8 != null) {
                editText8.setSelection(iCoerceIn);
            }
        } catch (Exception e) {
            AbstractC8014b.m7198D("setSelection failed: ", e.getMessage(), TAG);
        }
        EditText editText9 = coverPreviewLayout.mCoverSummaryView;
        if (editText9 != null) {
            editText9.setBackground(ResourcesCompat.getDrawable(coverPreviewLayout.getResources(), C9086R.drawable.cover_editor_new_preview_edit_summary_bg, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setSummaryView$lambda$5(CoverPreviewLayout coverPreviewLayout, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        Contract contract = coverPreviewLayout.mContract;
        Intrinsics.checkNotNull(contract);
        boolean zIsCoverPreviewSelect = contract.isCoverPreviewSelect();
        AbstractC8014b.m7220v("mCoverSummaryView# onTouch# isCoverSelected : ", TAG, zIsCoverPreviewSelect);
        if (zIsCoverPreviewSelect) {
            EditText editText = coverPreviewLayout.mCoverSummaryView;
            Intrinsics.checkNotNull(editText);
            if (!editText.hasFocus()) {
                return false;
            }
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
        Contract contract2 = coverPreviewLayout.mContract;
        if (contract2 != null) {
            contract2.onClickCoverPreview();
        }
        EditText editText2 = coverPreviewLayout.mCoverSummaryView;
        if (editText2 != null) {
            editText2.clearFocus();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMaxCharToast() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            Context context = getContext();
            String string = getContext().getString(C9086R.string.composer_maximum_input, 200);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ToastHandler.show(context, string, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({WarningType.NewApi})
    public final void startProcessingLightEffect() {
        if (BuildCompat.INSTANCE.isAtLeast(BuildCompat.Version.f5797V)) {
            View view = this.mCoverProgressContainer;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.mCoverProgressContainer;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            if (this.mContentAreaEffect == null) {
                ProcessingLightConfig vi_config_default = ProcessingLightConfig.INSTANCE.getVI_CONFIG_DEFAULT();
                vi_config_default.setAngle(84.0f);
                vi_config_default.setBlendMode(ProcessingLightConfig.BlendMode.ADD);
                this.mContentAreaEffect = new ProcessingLightEffect(getContext(), this.mCoverProgressContainer, vi_config_default);
            }
            ProcessingLightEffect processingLightEffect = this.mContentAreaEffect;
            if (processingLightEffect != null) {
                processingLightEffect.start();
            }
        }
    }

    private final void startStickerAnimation() {
        Logger.m10999d(TAG, "startStickerAnimation");
        updateStickerBackground();
        AnimatorSet animatorSet = this.mScaleAnimatorSet;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    private final void startStickerNoneAnimation() {
        float measuredWidth;
        Logger.m10999d(TAG, "startStickerNoneAnimation");
        updateStickerBackground();
        if (LocaleUtils.isRTLMode()) {
            Intrinsics.checkNotNull(this.mCoverStickerContainer);
            measuredWidth = -r0.getMeasuredWidth();
        } else {
            ConstraintLayout constraintLayout = this.mCoverStickerContainer;
            Intrinsics.checkNotNull(constraintLayout);
            measuredWidth = constraintLayout.getMeasuredWidth();
        }
        ObjectAnimator objectAnimator = this.mStickerNoneAnimator;
        if (objectAnimator != null) {
            objectAnimator.setFloatValues(0.0f, measuredWidth);
        }
        ObjectAnimator objectAnimator2 = this.mStickerNoneAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.start();
        }
    }

    private final void startStickerPrevNoneAnimation() {
        float measuredWidth;
        Logger.m10999d(TAG, "startStickerPrevNoneAnimation");
        updateStickerBackground();
        if (LocaleUtils.isRTLMode()) {
            Intrinsics.checkNotNull(this.mCoverStickerContainer);
            measuredWidth = -r0.getMeasuredWidth();
        } else {
            ConstraintLayout constraintLayout = this.mCoverStickerContainer;
            Intrinsics.checkNotNull(constraintLayout);
            measuredWidth = constraintLayout.getMeasuredWidth();
        }
        ObjectAnimator objectAnimator = this.mStickerPrevNoneAnimator;
        if (objectAnimator != null) {
            objectAnimator.setFloatValues(measuredWidth, 0.0f);
        }
        AnimatorSet animatorSet = this.mStickerAnimatorSet;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({WarningType.NewApi})
    public final void startTransitionLightEffect() {
        View view = this.mTransitionLightView;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.mTransitionEffect == null && this.mCoverNewPreview != null) {
            TransitionLightConfig vi_config_default = TransitionLightConfig.INSTANCE.getVI_CONFIG_DEFAULT();
            vi_config_default.setAngle(84.0f);
            vi_config_default.setDurationInMillis(2000L);
            vi_config_default.setRevealMode(TransitionLightConfig.RevealMode.VIEW);
            vi_config_default.setFrameRate(60.0f);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            View view2 = this.mCoverNewPreview;
            Intrinsics.checkNotNull(view2);
            this.mTransitionEffect = new TransitionLightEffect(context, view2, vi_config_default);
        }
        TransitionLightEffect transitionLightEffect = this.mTransitionEffect;
        if (transitionLightEffect != null) {
            transitionLightEffect.start();
        }
    }

    private final void updateCoverPreviewTitle(boolean isEnable) {
        TextView textView = this.mCoverText;
        if (textView != null) {
            textView.setText(isEnable ? C9086R.string.note_style_cover : C9086R.string.note_style_add_cover);
        }
    }

    private final void updateStickerBackground() {
        EditText editText = this.mCoverSummaryView;
        if (editText != null) {
            editText.setFocusable(false);
        }
        EditText editText2 = this.mCoverSummaryView;
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
        ImageView imageView = this.mCoverStickerIconView;
        if (imageView != null) {
            Context context = getContext();
            CoverData coverData = getCoverData();
            imageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(context, coverData != null ? coverData.getCategoryUuid() : null));
        }
    }

    public final void animateButton(final boolean isVisible, @Nullable final View targetView) {
        float f = isVisible ? 0.0f : 1.0f;
        float f4 = isVisible ? 1.0f : 0.0f;
        long j = isVisible ? 400L : 300L;
        PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        if (isVisible) {
            if (targetView != null) {
                targetView.setScaleX(f);
            }
            if (targetView != null) {
                targetView.setScaleY(f);
            }
            if (targetView != null) {
                targetView.setVisibility(0);
            }
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) ViewGroup.SCALE_X, f, f4);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(targetView, (Property<View, Float>) ViewGroup.SCALE_Y, f, f4);
        objectAnimatorOfFloat2.setDuration(j);
        objectAnimatorOfFloat2.setInterpolator(pathInterpolator);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$animateButton$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                View view = targetView;
                if (view != null) {
                    view.setVisibility(isVisible ? 0 : 8);
                }
            }
        });
        animatorSet.start();
    }

    public final void animateCoverNewPreview(final boolean isVisible) {
        float f = isVisible ? 0.0f : 1.0f;
        float f4 = isVisible ? 1.0f : 0.0f;
        long j = isVisible ? 400L : 300L;
        long j2 = isVisible ? 200L : 100L;
        PathInterpolator pathInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        if (isVisible) {
            View view = this.mCoverNewPreview;
            if (view != null) {
                view.setScaleX(f);
            }
            View view2 = this.mCoverNewPreview;
            if (view2 != null) {
                view2.setScaleY(f);
            }
            View view3 = this.mCoverNewPreview;
            if (view3 != null) {
                view3.setAlpha(f);
            }
            View view4 = this.mCoverNewPreview;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mCoverNewPreview, (Property<View, Float>) ViewGroup.SCALE_X, f, f4);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mCoverNewPreview, (Property<View, Float>) ViewGroup.SCALE_Y, f, f4);
        objectAnimatorOfFloat2.setDuration(j);
        objectAnimatorOfFloat2.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.mCoverNewPreview, (Property<View, Float>) ViewGroup.ALPHA, f, f4);
        objectAnimatorOfFloat3.setDuration(j2);
        objectAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout$animateCoverNewPreview$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (isVisible) {
                    return;
                }
                this.updateCoverPreviewLayout();
            }
        });
        animatorSet.start();
    }

    public final void initCoverPreview() {
        Logger.m10999d(TAG, "initCoverPreview");
        updateCoverPreviewLayout();
        setListener();
        setSummaryView();
        setStickerAnimation();
        CoverData coverData = getCoverData();
        boolean z = false;
        if (coverData != null && coverData.isEnabled()) {
            z = true;
        }
        updateCoverPreviewTitle(z);
    }

    public final void onClickAddButton() {
        updateCoverPreviewTitle(true);
        updateCoverPreviewContainer(true);
        animateButton(true, this.mClearButton);
        animateButton(false, this.mAddButton);
        animateCoverNewPreview(true);
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final void startGenerateAnimation() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C103611(null), 3, null);
    }

    public final void stopGenerateAnimation(boolean withAnimation) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C103621(withAnimation, this, null), 3, null);
    }

    public final void updateCoverPreviewContainer(boolean isSelected) {
        if (this.mContract == null) {
            return;
        }
        AbstractC8014b.m7220v("updateCoverPreviewContainer# isSelected : ", TAG, isSelected);
        View view = this.mCoverPreviewContainer;
        if (view != null) {
            view.setSelected(isSelected);
        }
        if (!isSelected) {
            EditText editText = this.mCoverSummaryView;
            if (editText != null) {
                editText.setFocusable(false);
            }
            EditText editText2 = this.mCoverSummaryView;
            if (editText2 != null) {
                editText2.setFocusableInTouchMode(true);
            }
        }
        TextView textView = this.mCoverText;
        if (textView != null) {
            textView.setTextAppearance(isSelected ? C9086R.style.RobotoMediumStyle : C9086R.style.RobotoRegularStyle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateCoverPreviewLayout() {
        String string;
        CoverData coverData = getCoverData();
        if (coverData == null) {
            Logger.m10999d(TAG, "updateCoverPreviewLayout cover data is null");
        }
        Boolean boolValueOf = coverData != null ? Boolean.valueOf(coverData.isEnabled()) : null;
        Logger.m10999d(TAG, "updateCoverPreviewLayout# isCoverEnabled : " + boolValueOf);
        Resources resources = getContext().getResources();
        View view = this.mCoverPreviewContainer;
        if (view != null) {
            if (Intrinsics.areEqual(boolValueOf, Boolean.TRUE)) {
                string = resources != null ? resources.getString(C9086R.string.note_style_cover) : null;
                view.setContentDescription(string);
            } else {
                if (resources != null) {
                    string = resources.getString(C9086R.string.note_style_add_cover);
                }
                view.setContentDescription(string);
            }
        }
        if (!Intrinsics.areEqual(boolValueOf, Boolean.TRUE)) {
            View view2 = this.mCoverNewPreview;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this.mClearButton;
            if (view3 != null) {
                view3.setVisibility(8);
                return;
            }
            return;
        }
        View view4 = this.mClearButton;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        CoverStyleUtils coverStyleUtils = CoverStyleUtils.INSTANCE;
        String templateUuid = coverData.getTemplateUuid();
        Intrinsics.checkNotNullExpressionValue(templateUuid, "getTemplateUuid(...)");
        String coverType = coverStyleUtils.getCoverType(templateUuid);
        View view5 = this.mCoverNewPreview;
        if (view5 != null) {
            view5.setVisibility(0);
        }
        if (Intrinsics.areEqual(coverType, CoverStyleConstants.CoverType.PATTERN.getValue()) || Intrinsics.areEqual(coverType, CoverStyleConstants.CoverType.ILLUST.getValue())) {
            ImageView imageView = this.mCoverLine;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ConstraintLayout constraintLayout = this.mCoverStickerContainer;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            EditText editText = this.mCoverSummaryView;
            if (editText != null) {
                editText.setVisibility(8);
            }
        } else {
            ImageView imageView2 = this.mCoverLine;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ConstraintLayout constraintLayout2 = this.mCoverStickerContainer;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(0);
            }
            EditText editText2 = this.mCoverSummaryView;
            if (editText2 != null) {
                editText2.setVisibility(0);
            }
            setSummaryTextColor();
            setStickerBackground();
        }
        ImageView imageView3 = this.mCoverPreview;
        if (imageView3 != null) {
            imageView3.setContentDescription(resources != null ? resources.getString(C9086R.string.note_style_cover) : null);
        }
        ImageView imageView4 = this.mCoverPreview;
        if (imageView4 != null) {
            Context context = getContext();
            CoverData coverData2 = getCoverData();
            Intrinsics.checkNotNull(coverData2);
            String templateUuid2 = coverData2.getTemplateUuid();
            CoverData coverData3 = getCoverData();
            imageView4.setBackground(CoverEditorUtils.getTemplateDrawable(context, templateUuid2, coverData3 != null ? coverData3.getColorId() : null));
        }
    }

    public final void updateCoverSticker(int stickerPosition, int stickerPrevPosition) {
        if (stickerPosition == 0) {
            startStickerNoneAnimation();
        } else if (stickerPrevPosition == 0) {
            startStickerPrevNoneAnimation();
        } else {
            startStickerAnimation();
        }
    }

    public final void updateCoverSummary(@NotNull String summary) {
        Intrinsics.checkNotNullParameter(summary, "summary");
        EditText editText = this.mCoverSummaryView;
        if (editText != null) {
            editText.setText(Editable.Factory.getInstance().newEditable(summary));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CoverPreviewLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CoverPreviewLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.STICKER_CONTAINER_DURATION = 350L;
        this.STICKER_DURATION = 400L;
        this.STICKER_CONTAINER_INTERPOLATOR = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        this.STICKER_INTERPOLATOR = new PathInterpolator(0.2f, 0.2f, 0.0f, 1.2f);
        View.inflate(context, C9086R.layout.cover_preview_layout, this);
        this.mCoverPreviewContainer = findViewById(C9086R.id.cover_preview_container);
        this.mCoverNewPreview = findViewById(C9086R.id.cover_new_preview);
        this.mCoverPreview = (ImageView) findViewById(C9086R.id.cover_preview);
        this.mCoverLine = (ImageView) findViewById(C9086R.id.cover_line_view);
        this.mCoverSummaryView = (EditText) findViewById(C9086R.id.edit_summary);
        this.mCoverStickerContainer = (ConstraintLayout) findViewById(C9086R.id.sticker_container);
        this.mCoverStickerEmptyView = (ImageView) findViewById(C9086R.id.sticker_empty_view);
        this.mCoverStickerView = findViewById(C9086R.id.sticker_view);
        this.mCoverStickerIconView = (ImageView) findViewById(C9086R.id.sticker_icon_view);
        this.mAddButton = findViewById(C9086R.id.cover_add_btn);
        this.mClearButton = findViewById(C9086R.id.cover_clear_btn);
        this.mCoverText = (TextView) findViewById(C9086R.id.cover_text);
        this.mCoverProgressContainer = findViewById(C9086R.id.cover_progress_container);
        this.mCoverProgress = (LottieAnimationView) findViewById(C9086R.id.cover_progress);
        this.mTransitionLightView = findViewById(C9086R.id.cover_transition_light_view);
        View viewFindViewById = findViewById(C9086R.id.cover_block_view);
        this.mCoverBlockView = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View v, MotionEvent event) {
                    Logger.m10999d(CoverPreviewLayout.TAG, "block");
                    return true;
                }
            });
        }
    }
}
