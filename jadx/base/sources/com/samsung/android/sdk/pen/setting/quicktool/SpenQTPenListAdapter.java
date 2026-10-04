package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.C4892a;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenView;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenPreviewV2;
import com.samsung.android.sdk.pen.setting.util.SpenGradientDrawableHelper;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.RunnableC4199v;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u0000 B2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0006BCDEFGB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010%\u001a\u00020&J\u0014\u0010'\u001a\u00020&2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0010J\u0010\u0010*\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010\fJ\u0010\u0010,\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010-\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010$J\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u000eJ\u000e\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u0010J\u0016\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u0012J\u0018\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000eH\u0016J\u0010\u0010:\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J\b\u0010;\u001a\u00020\u000eH\u0016J\u0018\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000eH\u0016J&\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0006H\u0016J\u001e\u0010@\u001a\u00020&2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010A\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenPenViewInfo;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "mContext", "mOnItemClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnItemClickListener;", "mSelectedPosition", "", "mAnimateSelectedPen", "", "mSelectedTranslationY", "", "mHideTranslationY", "mTargetScaleX", "mTargetScaleY", "mListPenInfo", "", "mItemTranslationYMap", "", "mIsShow", "mAnimatedPositions", "", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnAnimationListener;", "mAdaptiveColor", "mDrawableHelper", "Lcom/samsung/android/sdk/pen/setting/util/SpenGradientDrawableHelper;", "mAddButtonEnabled", "mOnAddButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnAddButtonClickListener;", "close", "", "setPenList", "setAddButtonEnabled", "enabled", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "setOnAddButtonClickListener", "getSelectedPenPosition", "setSelectedPenPosition", "position", "startAnimation", "isShow", "setItemTranslationY", "index", "translateY", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "getItemCount", "onBindViewHolder", "holder", "payloads", "", "initPenList", "selectedPosition", "Companion", "OnAddButtonClickListener", "OnItemClickListener", "OnAnimationListener", "ViewHolder", "AddViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenQTPenListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final long ADD_BUTTON_ANIMATION_HIDE_DURATION = 100;
    private static final long ADD_BUTTON_ANIMATION_SHOW_DURATION = 200;
    private static final int CHANGE_SELECT = 1;
    private static final float DAMPING_RATIO = 0.75f;
    private static final float HIDE_BASE_ALPHA = 0.0f;
    private static final int MAX_ANIMATION_DELTA_INDEX = 3;
    private static final long PEN_PREVIEW_ANIMATION_DELAY = 300;
    private static final long PEN_PREVIEW_ANIMATION_HIDE_DURATION = 100;
    private static final long PEN_PREVIEW_ANIMATION_SHOW_DURATION = 400;
    private static final long PEN_VIEW_SCALE_ANIMATION_DURATION = 400;
    private static final float SHOW_BASE_ALPHA = 1.0f;
    private static final float STIFFNESS = 300.0f;

    @NotNull
    private static final String TAG = "SpenQTPenListAdapter";
    private static final int VIEW_TYPE_ADD = 2;
    private static final int VIEW_TYPE_PEN = 1;
    private final int mAdaptiveColor;
    private boolean mAddButtonEnabled;
    private boolean mAnimateSelectedPen;

    @NotNull
    private final Set<Integer> mAnimatedPositions;

    @Nullable
    private OnAnimationListener mAnimationListener;

    @NotNull
    private final Context mContext;

    @NotNull
    private SpenGradientDrawableHelper mDrawableHelper;
    private final float mHideTranslationY;
    private boolean mIsShow;

    @NotNull
    private Map<SpenPenViewInfo, Float> mItemTranslationYMap;

    @NotNull
    private final List<SpenPenViewInfo> mListPenInfo;

    @Nullable
    private OnAddButtonClickListener mOnAddButtonClickListener;

    @Nullable
    private OnItemClickListener mOnItemClickListener;
    private int mSelectedPosition;
    private final float mSelectedTranslationY;
    private final float mTargetScaleX;
    private final float mTargetScaleY;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$AddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter;Landroid/view/View;)V", "mAddButton", "mSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "onClick", "", VPathDataCmd.RCurveTo, "setVisibility", "visibility", "", "hasAnimation", "", "setVisibilityWithAnimation", "setVisibilityWithoutAnimation", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class AddViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @NotNull
        private View mAddButton;

        @Nullable
        private SpringAnimation mSpringAnimation;
        final /* synthetic */ SpenQTPenListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddViewHolder(@NotNull SpenQTPenListAdapter spenQTPenListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenQTPenListAdapter;
            View viewFindViewById = itemView.findViewById(C7932R.id.add_icon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.mAddButton = viewFindViewById;
            viewFindViewById.setOnClickListener(this);
            this.mAddButton.setVisibility(8);
            this.mAddButton.setAlpha(0.0f);
            String string = itemView.getResources().getString(C7932R.string.pen_string_add_favorite_pen);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.mAddButton.setContentDescription(string);
            SpenSettingUtilHover.setHoverText(this.mAddButton, string);
        }

        private final void setVisibilityWithAnimation(int visibility) {
            boolean z = visibility == 0;
            this.mAddButton.animate().cancel();
            SpringAnimation springAnimation = this.mSpringAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            if (z) {
                this.mAddButton.setVisibility(0);
            }
            this.mAddButton.animate().alpha(z ? 1.0f : 0.0f).setDuration(z ? 200L : 100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
            SpenSettingUtilAnimation spenSettingUtilAnimation = SpenSettingUtilAnimation.INSTANCE;
            View view = this.mAddButton;
            DynamicAnimation.ViewProperty TRANSLATION_Y = DynamicAnimation.TRANSLATION_Y;
            Intrinsics.checkNotNullExpressionValue(TRANSLATION_Y, "TRANSLATION_Y");
            this.mSpringAnimation = spenSettingUtilAnimation.startSpringAnimation(view, TRANSLATION_Y, this.this$0.mHideTranslationY, 0.75f, 300.0f, this.this$0.mSelectedTranslationY, (64 & 64) != 0 ? null : null);
        }

        private final void setVisibilityWithoutAnimation(int visibility) {
            this.mAddButton.animate().cancel();
            SpringAnimation springAnimation = this.mSpringAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            this.mAddButton.setAlpha(visibility == 0 ? 1.0f : 0.0f);
            this.mAddButton.setVisibility(visibility);
            this.mAddButton.setTranslationY(this.this$0.mSelectedTranslationY);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            OnAddButtonClickListener onAddButtonClickListener = this.this$0.mOnAddButtonClickListener;
            if (onAddButtonClickListener != null) {
                onAddButtonClickListener.onAddButtonClicked();
            }
        }

        public final void setVisibility(int visibility, boolean hasAnimation) {
            if (this.mAddButton.getVisibility() == visibility) {
                return;
            }
            if (hasAnimation) {
                setVisibilityWithAnimation(visibility);
            } else {
                setVisibilityWithoutAnimation(visibility);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnAddButtonClickListener;", "", "onAddButtonClicked", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAddButtonClickListener {
        void onAddButtonClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$OnItemClickListener;", "", "onItemClick", "", "position", "", "selected", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemClickListener {
        void onItemClick(int position, boolean selected);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTPenListAdapter;Landroid/view/View;)V", "penView", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenView;", "penPreview", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPreviewV2;", "mSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mSpringForce", "Landroidx/dynamicanimation/animation/SpringForce;", "mPreviewAnimator", "Landroid/animation/ObjectAnimator;", "onClick", "", VPathDataCmd.RCurveTo, "bindInfo", "penInfo", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenPenViewInfo;", "setSelected", "selected", "", "animation", "startAnimationShow", "penAnimation", "previewAnimation", "startAnimationHide", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Nullable
        private ObjectAnimator mPreviewAnimator;

        @Nullable
        private SpringAnimation mSpringAnimation;

        @NotNull
        private SpringForce mSpringForce;

        @NotNull
        private SpenPenPreviewV2 penPreview;

        @NotNull
        private SpenPenView penView;
        final /* synthetic */ SpenQTPenListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull SpenQTPenListAdapter spenQTPenListAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenQTPenListAdapter;
            View viewFindViewById = itemView.findViewById(C7932R.id.qt_item_pen_view);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.penView = (SpenPenView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C7932R.id.qt_item_pen_preview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.penPreview = (SpenPenPreviewV2) viewFindViewById2;
            this.mSpringForce = new SpringForce();
            this.penView.setOnClickListener(this);
            this.penPreview.setVisibility(8);
            this.penPreview.setBackground(spenQTPenListAdapter.mDrawableHelper.makeDrawable());
            this.mSpringAnimation = new SpringAnimation(this.penView, DynamicAnimation.TRANSLATION_Y);
            this.mSpringForce.setDampingRatio(0.75f);
            this.mSpringForce.setStiffness(300.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startAnimationHide$lambda$3(SpenQTPenListAdapter spenQTPenListAdapter, DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
            OnAnimationListener onAnimationListener = spenQTPenListAdapter.mAnimationListener;
            if (onAnimationListener != null) {
                onAnimationListener.onAnimationEnd(spenQTPenListAdapter.mIsShow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startAnimationShow$lambda$2(ViewHolder viewHolder, SpenQTPenListAdapter spenQTPenListAdapter) {
            viewHolder.penView.setScaleX(spenQTPenListAdapter.mTargetScaleX);
            viewHolder.penView.setScaleY(spenQTPenListAdapter.mTargetScaleY);
            viewHolder.penView.setPivotY(0.0f);
        }

        public final void bindInfo(@NotNull SpenPenViewInfo penInfo) {
            Intrinsics.checkNotNullParameter(penInfo, "penInfo");
            SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
            spenSettingPenInfo.name = penInfo.getName();
            spenSettingPenInfo.color = penInfo.getColor();
            spenSettingPenInfo.sizeLevel = penInfo.getSizeLevel();
            spenSettingPenInfo.particleSize = penInfo.getParticleSize();
            spenSettingPenInfo.isFixedWidth = penInfo.isFixedWidth();
            spenSettingPenInfo.isFixedOpacity = penInfo.isFixedOpacity();
            this.penView.setPenInfo(spenSettingPenInfo);
            this.penPreview.setInfo(penInfo.getName(), penInfo.getSizeLevel());
            this.penPreview.setPenColor(penInfo.getColor());
            this.penPreview.setParticleSize(penInfo.getParticleSize());
            this.itemView.setTranslationY(((Number) this.this$0.mItemTranslationYMap.getOrDefault(penInfo, Float.valueOf(0.0f))).floatValue());
            if (SpenSettingUtil.isAdaptiveColor(this.this$0.mContext, penInfo.getColor())) {
                SpenGradientDrawableHelper.Companion companion = SpenGradientDrawableHelper.INSTANCE;
                Drawable background = this.penPreview.getBackground();
                companion.setColor(background instanceof GradientDrawable ? (GradientDrawable) background : null, this.this$0.mAdaptiveColor);
            } else {
                SpenGradientDrawableHelper.Companion companion2 = SpenGradientDrawableHelper.INSTANCE;
                Drawable background2 = this.penPreview.getBackground();
                companion2.setColor(background2 instanceof GradientDrawable ? (GradientDrawable) background2 : null, 0);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            OnItemClickListener onItemClickListener;
            Intrinsics.checkNotNullParameter(v, "v");
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1 || (onItemClickListener = this.this$0.mOnItemClickListener) == null) {
                return;
            }
            onItemClickListener.onItemClick(adapterPosition, this.this$0.mSelectedPosition == adapterPosition);
        }

        public final void setSelected(boolean selected, boolean animation) {
            this.penView.setSelected(selected, animation && selected);
        }

        public final void startAnimationHide(boolean animation) {
            this.penPreview.setVisibility(8);
            this.penView.setAlpha(1.0f);
            this.penView.setVisibility(0);
            SpringAnimation springAnimation = this.mSpringAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            if (!animation) {
                this.penView.setVisibility(8);
                return;
            }
            this.penView.animate().alpha(0.0f).setDuration(100L).setInterpolator(SpenSettingUtilAnimation.getInterpolator(15)).start();
            this.mSpringForce.setFinalPosition(this.this$0.mHideTranslationY);
            SpringAnimation springAnimation2 = this.mSpringAnimation;
            if (springAnimation2 != null) {
                springAnimation2.setSpring(this.mSpringForce);
            }
            SpringAnimation springAnimation3 = this.mSpringAnimation;
            if (springAnimation3 != null) {
                springAnimation3.addEndListener(new C4892a(this.this$0, 1));
            }
            SpringAnimation springAnimation4 = this.mSpringAnimation;
            if (springAnimation4 != null) {
                springAnimation4.start();
            }
        }

        public final void startAnimationShow(boolean penAnimation, boolean previewAnimation) {
            ViewPropertyAnimator viewPropertyAnimatorScaleX;
            ViewPropertyAnimator viewPropertyAnimatorScaleY;
            ViewPropertyAnimator duration;
            ViewPropertyAnimator interpolator;
            ViewPropertyAnimator viewPropertyAnimatorTranslationY;
            ViewPropertyAnimator duration2;
            ViewPropertyAnimator interpolator2;
            if (previewAnimation) {
                ObjectAnimator objectAnimator = this.mPreviewAnimator;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                this.penPreview.setVisibility(8);
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.penPreview, SpenPenPreviewV2.PEN_PROGRESS, 0.0f, 1.0f);
                objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter$ViewHolder$startAnimationShow$1$1
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
                objectAnimatorOfFloat.setStartDelay(300L);
                objectAnimatorOfFloat.start();
                this.mPreviewAnimator = objectAnimatorOfFloat;
            } else {
                this.penPreview.setAlpha(1.0f);
                this.penPreview.setVisibility(0);
            }
            this.penView.post(new RunnableC4199v(this, this.this$0, 12));
            this.penView.setAlpha(1.0f);
            this.penView.setVisibility(0);
            SpringAnimation springAnimation = this.mSpringAnimation;
            if (springAnimation != null) {
                springAnimation.cancel();
            }
            if (penAnimation) {
                this.penView.setTranslationY(this.this$0.mHideTranslationY);
                this.mSpringForce.setFinalPosition(this.this$0.mSelectedTranslationY);
                SpringAnimation springAnimation2 = this.mSpringAnimation;
                if (springAnimation2 != null) {
                    springAnimation2.setSpring(this.mSpringForce);
                }
                SpringAnimation springAnimation3 = this.mSpringAnimation;
                if (springAnimation3 != null) {
                    springAnimation3.start();
                }
            } else {
                this.penView.setTranslationY(this.this$0.mSelectedTranslationY);
            }
            if (this.penView.isSelected()) {
                this.itemView.setTranslationY(this.this$0.mContext.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_offsetY) * (-1));
                ViewPropertyAnimator viewPropertyAnimatorAnimate = this.itemView.animate();
                if (viewPropertyAnimatorAnimate != null) {
                    viewPropertyAnimatorAnimate.cancel();
                }
                ViewPropertyAnimator viewPropertyAnimatorAnimate2 = this.itemView.animate();
                if (viewPropertyAnimatorAnimate2 != null && (viewPropertyAnimatorTranslationY = viewPropertyAnimatorAnimate2.translationY(this.this$0.mSelectedTranslationY)) != null && (duration2 = viewPropertyAnimatorTranslationY.setDuration(400L)) != null && (interpolator2 = duration2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20))) != null) {
                    interpolator2.start();
                }
                this.penView.setSelected(true, true);
                this.penView.setScaleX(1.0f);
                this.penView.setScaleY(1.0f);
                ViewPropertyAnimator viewPropertyAnimatorAnimate3 = this.penView.animate();
                if (viewPropertyAnimatorAnimate3 != null) {
                    viewPropertyAnimatorAnimate3.cancel();
                }
                ViewPropertyAnimator viewPropertyAnimatorAnimate4 = this.penView.animate();
                if (viewPropertyAnimatorAnimate4 == null || (viewPropertyAnimatorScaleX = viewPropertyAnimatorAnimate4.scaleX(this.this$0.mTargetScaleX)) == null || (viewPropertyAnimatorScaleY = viewPropertyAnimatorScaleX.scaleY(this.this$0.mTargetScaleY)) == null || (duration = viewPropertyAnimatorScaleY.setDuration(400L)) == null || (interpolator = duration.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20))) == null) {
                    return;
                }
                interpolator.start();
            }
        }
    }

    public SpenQTPenListAdapter(@NotNull Context context, @NotNull List<SpenPenViewInfo> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.mContext = context;
        this.mSelectedPosition = -1;
        this.mAnimateSelectedPen = true;
        this.mSelectedTranslationY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_select_translateY);
        this.mHideTranslationY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_hide_translateY);
        this.mTargetScaleX = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_pen_width) / context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_width);
        this.mTargetScaleY = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_pen_list_item_pen_height) / context.getResources().getDimensionPixelSize(C7932R.dimen.qt_circle_center_pen_base_height);
        this.mListPenInfo = new ArrayList();
        this.mItemTranslationYMap = new HashMap();
        this.mAnimatedPositions = new LinkedHashSet();
        initPenList(list, -1);
        this.mAdaptiveColor = SpenSettingUtil.getColor(context, C7932R.color.setting_preview_adaptive_bg_color);
        SpenGradientDrawableHelper spenGradientDrawableHelper = new SpenGradientDrawableHelper();
        this.mDrawableHelper = spenGradientDrawableHelper;
        spenGradientDrawableHelper.setDrawableInfo(0, 0, 0, 0);
        this.mDrawableHelper.setRectRadius(context.getResources().getDimensionPixelSize(C7932R.dimen.setting_pen_layout_preview_radius));
    }

    private final void initPenList(List<SpenPenViewInfo> list, int selectedPosition) {
        this.mListPenInfo.clear();
        Iterator<SpenPenViewInfo> it = list.iterator();
        while (it.hasNext()) {
            this.mListPenInfo.add(SpenPenViewInfo.copy$default(it.next(), null, 0, 0, 0.0f, false, false, 63, null));
        }
        this.mSelectedPosition = selectedPosition;
    }

    public final void close() {
        this.mListPenInfo.clear();
        this.mItemTranslationYMap.clear();
        this.mOnItemClickListener = null;
        this.mAnimationListener = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mListPenInfo.size() + (this.mAddButtonEnabled ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return (this.mAddButtonEnabled && position == this.mListPenInfo.size()) ? 2 : 1;
    }

    /* JADX INFO: renamed from: getSelectedPenPosition, reason: from getter */
    public final int getMSelectedPosition() {
        return this.mSelectedPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if ((holder instanceof ViewHolder ? (ViewHolder) holder : null) == null) {
            if ((holder instanceof AddViewHolder ? (AddViewHolder) holder : null) != null) {
                int iAbs = Math.abs(position - this.mSelectedPosition);
                if (this.mIsShow) {
                    ((AddViewHolder) holder).setVisibility(0, iAbs >= 0 && iAbs < 4);
                    return;
                } else {
                    ((AddViewHolder) holder).setVisibility(8, false);
                    return;
                }
            }
            return;
        }
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.bindInfo(this.mListPenInfo.get(position));
        viewHolder.setSelected(this.mSelectedPosition == position, false);
        int iAbs2 = Math.abs(position - this.mSelectedPosition);
        if (!this.mIsShow) {
            if (iAbs2 == 0) {
                viewHolder.startAnimationHide(false);
            } else {
                viewHolder.startAnimationHide(true);
            }
            this.mAnimatedPositions.clear();
            return;
        }
        if (this.mAnimatedPositions.contains(Integer.valueOf(position))) {
            return;
        }
        this.mAnimatedPositions.add(Integer.valueOf(position));
        if (iAbs2 < 0 || iAbs2 >= 4) {
            viewHolder.startAnimationShow(false, false);
        } else if (iAbs2 == 0) {
            viewHolder.startAnimationShow(this.mAnimateSelectedPen, true);
        } else {
            viewHolder.startAnimationShow(true, true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_qt_pen_list_add_item, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new AddViewHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_qt_pen_list_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
        return new ViewHolder(this, viewInflate2);
    }

    public final void setAddButtonEnabled(boolean enabled) {
        Log.i(TAG, "setAddButtonEnabled() enabled[" + this.mAddButtonEnabled + "->" + enabled + "]");
        this.mAddButtonEnabled = enabled;
    }

    public final void setItemTranslationY(int index, float translateY) {
        if (index >= this.mListPenInfo.size()) {
            return;
        }
        this.mItemTranslationYMap.put(this.mListPenInfo.get(index), Float.valueOf(translateY));
    }

    public final void setOnAddButtonClickListener(@Nullable OnAddButtonClickListener listener) {
        this.mOnAddButtonClickListener = listener;
    }

    public final void setOnAnimationListener(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public final void setPenList(@NotNull List<SpenPenViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        initPenList(list, -1);
        notifyDataSetChanged();
    }

    public final void setSelectedPenPosition(int position) {
        int i = this.mSelectedPosition;
        this.mAnimateSelectedPen = (i == -1 || i == position) ? false : true;
        this.mSelectedPosition = position;
    }

    public final void startAnimation(boolean isShow) {
        this.mIsShow = isShow;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        if ((holder instanceof ViewHolder ? (ViewHolder) holder : null) == null) {
            return;
        }
        Object obj = payloads.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) obj).intValue() == 1) {
            ((ViewHolder) holder).setSelected(this.mSelectedPosition == position, true);
        }
    }
}
