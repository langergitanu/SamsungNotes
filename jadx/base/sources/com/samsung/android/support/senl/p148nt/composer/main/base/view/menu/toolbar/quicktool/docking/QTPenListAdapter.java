package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.util.GradientDrawableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 92\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u00049:;<B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\u00020\"2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010$\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010\u0010J\u0010\u0010&\u001a\u00020\"2\b\u0010%\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010'\u001a\u00020\u0012J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u0012J\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u000bJ\u001c\u0010-\u001a\u00060\u0002R\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0012H\u0016J\b\u00101\u001a\u00020\u0012H\u0016J\u001c\u00102\u001a\u00020\"2\n\u00103\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020\u0012H\u0016J*\u00102\u001a\u00020\"2\n\u00103\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020\u00122\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0006H\u0016J\u001e\u00106\u001a\u00020\"2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u00107\u001a\u00020\u0012H\u0002J\u0014\u00108\u001a\u00020\"2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$ViewHolder;", "context", "Landroid/content/Context;", XmlErrorCodes.LIST, "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenViewInfo;", WiggleAnimationConfig.KEY_SCALE, "", "isFavorite", "", "<init>", "(Landroid/content/Context;Ljava/util/List;FZ)V", "mContext", "mOnItemClickListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$OnItemClickListener;", "mPreviousSelectedPosition", "", "mSelectedPosition", "mAddFavoritePosition", "mSelectedTranslationY", "mHideTranslationY", "mListPenInfo", "", "mIsShow", "mAnimatedPositions", "", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$OnAnimationListener;", "mAdaptiveColor", "mDrawableHelper", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/util/GradientDrawableHelper;", "close", "", "setPenList", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "getSelectedPenPosition", "setSelectedPenPosition", "position", "getAddFavoritePosition", "startAnimation", "isShow", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "payloads", "", "initPenList", "selectedPosition", "updatePenList", "Companion", "OnItemClickListener", "OnAnimationListener", "ViewHolder", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTPenListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int CHANGE_SELECT = 1;
    private static final float DAMPING_RATIO = 0.75f;
    private static final int MAX_ANIMATION_DELTA_INDEX = 6;
    private static final long PEN_ANIMATION_HIDE_DURATION = 250;
    private static final long PEN_PREVIEW_ANIMATION_DELAY = 350;
    private static final long PEN_PREVIEW_ANIMATION_HIDE_DURATION = 100;
    private static final long PEN_PREVIEW_ANIMATION_SHOW_DURATION = 400;
    private static final float STIFFNESS = 300.0f;

    @NotNull
    private static final String TAG = "SpenQTPenListAdapter";
    private final boolean isFavorite;
    private final int mAdaptiveColor;
    private int mAddFavoritePosition;

    @NotNull
    private final Set<Integer> mAnimatedPositions;

    @Nullable
    private OnAnimationListener mAnimationListener;

    @NotNull
    private final Context mContext;

    @NotNull
    private GradientDrawableHelper mDrawableHelper;
    private float mHideTranslationY;
    private boolean mIsShow;

    @NotNull
    private final List<QTPenViewInfo> mListPenInfo;

    @Nullable
    private OnItemClickListener mOnItemClickListener;
    private int mPreviousSelectedPosition;
    private int mSelectedPosition;
    private float mSelectedTranslationY;
    private final float scale;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "selected", "", "onAddFavoriteClicked", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onAddFavoriteClicked();

        void onItemClick(int position, boolean selected);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010%\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0014J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter;Landroid/view/View;)V", "penView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenView;", "penPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "addFavorite", "Landroid/widget/ImageButton;", "mPreviewAnimator", "Landroid/animation/ObjectAnimator;", "mSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mSpringForce", "Landroidx/dynamicanimation/animation/SpringForce;", "mIsHiding", "", "getMIsHiding$ntComposer_release", "()Z", "setMIsHiding$ntComposer_release", "(Z)V", "onClick", "", VPathDataCmd.RCurveTo, "bindView", "position", "", "bindInfo", "penInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenViewInfo;", "setSelected", "selected", "animation", "showPenPreview", "startAnimationShow", "runOtherItemAnim", "startAnimationHide", "fadeOut", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nQTPenListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTPenListAdapter.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenListAdapter$ViewHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,354:1\n1#2:355\n*E\n"})
    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @NotNull
        private ImageButton addFavorite;
        private boolean mIsHiding;

        @Nullable
        private ObjectAnimator mPreviewAnimator;

        @Nullable
        private SpringAnimation mSpringAnimation;

        @NotNull
        private SpringForce mSpringForce;

        @NotNull
        private SpenPenPreviewV2 penPreview;

        @Nullable
        private QTPenView penView;
        final /* synthetic */ QTPenListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull QTPenListAdapter qTPenListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = qTPenListAdapter;
            this.penView = (QTPenView) itemView.findViewById(C9086R.id.qt_item_pen_view);
            View viewFindViewById = itemView.findViewById(C9086R.id.qt_item_pen_preview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.penPreview = (SpenPenPreviewV2) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C9086R.id.plus_icon_fvr);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.addFavorite = (ImageButton) viewFindViewById2;
            this.mSpringForce = new SpringForce();
            QTPenView qTPenView = this.penView;
            if (qTPenView != null) {
                qTPenView.setOnClickListener(this);
            }
            QTPenView qTPenView2 = this.penView;
            if (qTPenView2 != null) {
                qTPenView2.setScaleX(qTPenListAdapter.scale);
            }
            this.addFavorite.setOnClickListener(this);
            this.penPreview.setVisibility(8);
            this.addFavorite.setVisibility(8);
            this.penPreview.setBackground(qTPenListAdapter.mDrawableHelper.makeDrawable());
            this.mSpringAnimation = new SpringAnimation(this.penView, DynamicAnimation.TRANSLATION_Y);
            this.mSpringForce.setDampingRatio(0.75f);
            this.mSpringForce.setStiffness(300.0f);
        }

        public final void bindInfo(@NotNull QTPenViewInfo penInfo) {
            Intrinsics.checkNotNullParameter(penInfo, "penInfo");
            if (Intrinsics.areEqual(penInfo.getName(), "AddFavorite")) {
                this.addFavorite.setVisibility(0);
                this.this$0.mAddFavoritePosition = r0.mListPenInfo.size() - 1;
                this.penPreview.setBackgroundColor(0);
                QTPenView qTPenView = this.penView;
                if (qTPenView != null) {
                    qTPenView.setVisibility(8);
                }
                this.penView = null;
            } else {
                this.addFavorite.setVisibility(8);
                if (this.penView == null) {
                    QTPenView qTPenView2 = (QTPenView) this.itemView.findViewById(C9086R.id.qt_item_pen_view);
                    this.penView = qTPenView2;
                    if (qTPenView2 != null) {
                        qTPenView2.setVisibility(0);
                    }
                    QTPenView qTPenView3 = this.penView;
                    if (qTPenView3 != null) {
                        qTPenView3.setOnClickListener(this);
                    }
                }
            }
            QTPenView qTPenView4 = this.penView;
            if (qTPenView4 != null) {
                qTPenView4.setPenInfo(penInfo.getName(), penInfo.getColor(), penInfo.getSizeLevel(), penInfo.getParticleSize(), penInfo.isFixedWidth());
            }
            this.penPreview.setInfo(penInfo.getName(), penInfo.getSizeLevel());
            this.penPreview.setPenColor(penInfo.getColor());
            this.penPreview.setParticleSize(penInfo.getParticleSize());
            if (SpenSettingUtil.isAdaptiveColor(this.this$0.mContext, penInfo.getColor())) {
                GradientDrawableHelper.Companion companion = GradientDrawableHelper.INSTANCE;
                Drawable background = this.penPreview.getBackground();
                companion.setColor(background instanceof GradientDrawable ? (GradientDrawable) background : null, this.this$0.mAdaptiveColor);
            } else {
                GradientDrawableHelper.Companion companion2 = GradientDrawableHelper.INSTANCE;
                Drawable background2 = this.penPreview.getBackground();
                companion2.setColor(background2 instanceof GradientDrawable ? (GradientDrawable) background2 : null, 0);
            }
        }

        public final void bindView(int position) {
            int dimensionPixelSize;
            if (this.this$0.isFavorite) {
                dimensionPixelSize = this.this$0.mContext.getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_favorite_margin) + (this.this$0.mContext.getResources().getDimensionPixelSize(C9086R.dimen.qt_docking_pen_list_favorite) / 2);
            } else {
                dimensionPixelSize = this.this$0.mContext.getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_pen_list_width) / 2;
            }
            float dimensionPixelSize2 = this.this$0.mContext.getResources().getDimensionPixelSize(C9086R.dimen.qt_pen_list_item_offset_translateY);
            float dimensionPixelSize3 = this.this$0.mContext.getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_arch_background_radius_docking);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            float fCoerceAtMost = RangesKt.coerceAtMost(Math.abs((((itemView.getRight() + itemView.getLeft()) / 2.0f) - (this.this$0.mContext.getResources().getDimensionPixelSize(C9086R.dimen.qt_pen_list_item_margin_right) / 2.0f)) - dimensionPixelSize), dimensionPixelSize3);
            float fSqrt = dimensionPixelSize3 - ((float) Math.sqrt((dimensionPixelSize3 * dimensionPixelSize3) - (fCoerceAtMost * fCoerceAtMost)));
            if (position != this.this$0.mAddFavoritePosition && position != this.this$0.mSelectedPosition) {
                fSqrt += dimensionPixelSize2;
            }
            itemView.setTranslationY(fSqrt);
        }

        /* JADX INFO: renamed from: getMIsHiding$ntComposer_release, reason: from getter */
        public final boolean getMIsHiding() {
            return this.mIsHiding;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            OnItemClickListener onItemClickListener;
            OnItemClickListener onItemClickListener2;
            Intrinsics.checkNotNullParameter(v, "v");
            if (this.mIsHiding) {
                return;
            }
            if (Intrinsics.areEqual(v, this.addFavorite) && (onItemClickListener2 = this.this$0.mOnItemClickListener) != null) {
                onItemClickListener2.onAddFavoriteClicked();
            }
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || Intrinsics.areEqual(((QTPenViewInfo) this.this$0.mListPenInfo.get(bindingAdapterPosition)).getName(), "AddFavorite") || (onItemClickListener = this.this$0.mOnItemClickListener) == null) {
                return;
            }
            onItemClickListener.onItemClick(bindingAdapterPosition, this.this$0.mSelectedPosition == bindingAdapterPosition);
        }

        public final void setMIsHiding$ntComposer_release(boolean z) {
            this.mIsHiding = z;
        }

        public final void setSelected(boolean selected, boolean animation) {
            QTPenView qTPenView = this.penView;
            if (qTPenView != null) {
                qTPenView.setSelected(selected, animation);
            }
        }

        public final void showPenPreview() {
            ObjectAnimator objectAnimator = this.mPreviewAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            this.penPreview.setAlpha(1.0f);
            this.penPreview.setVisibility(0);
        }

        public final void startAnimationHide(boolean fadeOut) {
            ObjectAnimator objectAnimator = this.mPreviewAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            SpringAnimation springAnimation = this.mSpringAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            this.penPreview.setVisibility(8);
            this.addFavorite.setVisibility(8);
            QTPenView qTPenView = this.penView;
            if (qTPenView == null) {
                return;
            }
            qTPenView.setAlpha(1.0f);
            qTPenView.setVisibility(0);
            qTPenView.setScaleX(this.this$0.scale * 1.0f);
            qTPenView.setScaleY(1.0f);
            ViewPropertyAnimator viewPropertyAnimatorAnimate = qTPenView.animate();
            if (fadeOut) {
                viewPropertyAnimatorAnimate.alpha(0.0f);
            }
            viewPropertyAnimatorAnimate.scaleX(this.this$0.scale * 1.2f).scaleY(1.2f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
            qTPenView.animate().translationY(ResourceUtils.convertDpToPixel(this.this$0.mContext, 57.0f)).setDuration(250L).setInterpolator(new OvershootInterpolator()).start();
        }

        public final void startAnimationShow(boolean runOtherItemAnim) {
            ObjectAnimator objectAnimator = this.mPreviewAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.penPreview, SpenPenPreviewV2.PEN_PROGRESS, 0.0f, 1.0f);
            this.mPreviewAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTPenListAdapter$ViewHolder$startAnimationShow$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    this.this$0.penPreview.setAlpha(1.0f);
                    this.this$0.penPreview.setVisibility(0);
                }
            });
            objectAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(2));
            objectAnimatorOfFloat.setDuration(400L);
            objectAnimatorOfFloat.setStartDelay(350L);
            objectAnimatorOfFloat.start();
            QTPenView qTPenView = this.penView;
            if (qTPenView == null) {
                return;
            }
            qTPenView.setAlpha(1.0f);
            qTPenView.setVisibility(0);
            SpringAnimation springAnimation = this.mSpringAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            if (runOtherItemAnim) {
                qTPenView.setTranslationY(this.this$0.mHideTranslationY);
                this.mSpringForce.setFinalPosition(this.this$0.mSelectedTranslationY);
                SpringAnimation springAnimation2 = this.mSpringAnimation;
                if (springAnimation2 != null) {
                    springAnimation2.setSpring(this.mSpringForce);
                }
                SpringAnimation springAnimation3 = this.mSpringAnimation;
                if (springAnimation3 != null) {
                    springAnimation3.start();
                    return;
                }
                return;
            }
            qTPenView.setTranslationY(ResourceUtils.convertDpToPixel(this.this$0.mContext, 57.0f));
            qTPenView.setScaleX(this.this$0.scale * 1.2f);
            qTPenView.setScaleY(1.2f);
            qTPenView.animate().scaleX(this.this$0.scale * 1.0f).scaleY(1.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
            this.mSpringForce.setFinalPosition(this.this$0.mSelectedTranslationY);
            SpringAnimation springAnimation4 = this.mSpringAnimation;
            if (springAnimation4 != null) {
                springAnimation4.setSpring(this.mSpringForce);
            }
            SpringAnimation springAnimation5 = this.mSpringAnimation;
            if (springAnimation5 != null) {
                springAnimation5.start();
            }
        }
    }

    public QTPenListAdapter(@NotNull Context context, @NotNull List<QTPenViewInfo> list, float f, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.scale = f;
        this.isFavorite = z;
        this.mContext = context;
        this.mPreviousSelectedPosition = -1;
        this.mSelectedPosition = -1;
        this.mAddFavoritePosition = -1;
        this.mListPenInfo = new ArrayList();
        this.mAnimatedPositions = new LinkedHashSet();
        this.mSelectedTranslationY = context.getResources().getDimensionPixelSize(C9086R.dimen.qt_pen_list_item_select_translateY);
        this.mHideTranslationY = context.getResources().getDimensionPixelSize(C9086R.dimen.qt_pen_list_item_hide_translateY);
        initPenList(list, -1);
        this.mAdaptiveColor = SpenSettingUtil.getColor(context, C9086R.color.setting_preview_adaptive_bg_color);
        GradientDrawableHelper gradientDrawableHelper = new GradientDrawableHelper();
        this.mDrawableHelper = gradientDrawableHelper;
        gradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
        this.mDrawableHelper.setRectRadius(context.getResources().getDimensionPixelSize(C9086R.dimen.setting_pen_layout_preview_radius));
    }

    private final void initPenList(List<QTPenViewInfo> list, int selectedPosition) {
        this.mListPenInfo.clear();
        Iterator<QTPenViewInfo> it = list.iterator();
        while (it.hasNext()) {
            this.mListPenInfo.add(QTPenViewInfo.copy$default(it.next(), null, 0, 0, 0.0f, false, 31, null));
        }
        this.mPreviousSelectedPosition = this.mSelectedPosition;
        this.mSelectedPosition = selectedPosition;
    }

    public final void close() {
        this.mListPenInfo.clear();
        this.mOnItemClickListener = null;
        this.mAnimationListener = null;
    }

    /* JADX INFO: renamed from: getAddFavoritePosition, reason: from getter */
    public final int getMAddFavoritePosition() {
        return this.mAddFavoritePosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mListPenInfo.size();
    }

    /* JADX INFO: renamed from: getSelectedPenPosition, reason: from getter */
    public final int getMSelectedPosition() {
        return this.mSelectedPosition;
    }

    public final void setOnAnimationListener(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public final void setPenList(@NotNull List<QTPenViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        initPenList(list, -1);
        notifyDataSetChanged();
    }

    public final void setSelectedPenPosition(int position) {
        int i = this.mSelectedPosition;
        if (i != position) {
            this.mPreviousSelectedPosition = i;
            this.mSelectedPosition = position;
            notifyDataSetChanged();
        }
    }

    public final void startAnimation(boolean isShow) {
        this.mIsShow = isShow;
        notifyDataSetChanged();
    }

    public final void updatePenList(@NotNull List<QTPenViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        boolean z = list.size() > this.mListPenInfo.size();
        this.mListPenInfo.clear();
        Iterator<QTPenViewInfo> it = list.iterator();
        while (it.hasNext()) {
            this.mListPenInfo.add(QTPenViewInfo.copy$default(it.next(), null, 0, 0, 0.0f, false, 31, null));
        }
        this.mPreviousSelectedPosition = this.mSelectedPosition;
        this.mSelectedPosition = z ? list.size() - 2 : 0;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ViewHolder) viewHolder, i, (List<? extends Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C9086R.layout.qt_pen_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(this, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bindInfo(this.mListPenInfo.get(position));
        holder.bindView(position);
        boolean z = this.mPreviousSelectedPosition == position;
        int i = this.mSelectedPosition;
        boolean z2 = i == position;
        int iAbs = Math.abs(position - i);
        if (!this.mIsShow) {
            holder.startAnimationHide(this.isFavorite || !z2);
            holder.setSelected(false, true);
            this.mAnimatedPositions.clear();
        } else {
            if (iAbs >= 0 && iAbs < 7) {
                if (this.mAnimatedPositions.add(Integer.valueOf(position))) {
                    holder.startAnimationShow(this.isFavorite || !z2);
                    holder.setSelected(z2, z2);
                    return;
                } else {
                    holder.showPenPreview();
                    holder.setSelected(z2, z != z2);
                    return;
                }
            }
            this.mAnimatedPositions.add(Integer.valueOf(position));
            holder.showPenPreview();
            holder.setSelected(z2, z2);
        }
    }

    public void onBindViewHolder(@NotNull ViewHolder holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, (List<Object>) payloads);
            return;
        }
        Object obj = payloads.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) obj).intValue() == 1) {
            holder.setSelected(this.mSelectedPosition == position, true);
        }
    }
}
