package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0001\u0018\u0000 82\u00020\u00012\u00020\u0002:\u000689:;<=B1\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0012J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0006H\u0016J&\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\bH\u0016J\u0018\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J \u00104\u001a\u00020\u00142\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u00020\u0014H\u0002R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001a2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u00102\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\"¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseAdapter;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteItemDragHelper$OnItemMoveListener;", "context", "Landroid/content/Context;", "maxCount", "", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "mItemLayoutId", "<init>", "(Landroid/content/Context;ILjava/util/List;I)V", "mOnItemEventListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$OnItemEventListener;", "mDragStartListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$OnItemDragStartListener;", "mIsNeedAnimation", "", "close", "", "setOnItemEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnItemDragStartListener", "setItemAnimation", "isNeedAnimation", "", "favoriteList", "getFavoriteList", "()Ljava/util/List;", "setFavoriteList", "(Ljava/util/List;)V", "mode", "getMode", "()I", "setMode", "(I)V", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "onItemMove", "fromPosition", "toPosition", "itemOffset", "getItemOffset", "updatePenView", "isViewMode", "onItemEvent", "onAddItemEvent", "Companion", "OnItemEventListener", "OnItemDragStartListener", "MiniFavoritePenViewHolder", "MiniAddViewHolder", "EmptyViewHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenFavoritePenMiniAdapter extends SpenFavoritePenBaseAdapter implements SpenFavoriteItemDragHelper.OnItemMoveListener {
    private static final int ADD_BUTTON_ALPHA_ANIMATION_DURATION = 100;
    private static final int ADD_BUTTON_HEIGHT_ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenFavoritePenMiniAdapter";

    @Nullable
    private OnItemDragStartListener mDragStartListener;
    private boolean mIsNeedAnimation;
    private final int mItemLayoutId;

    @Nullable
    private OnItemEventListener mOnItemEventListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter;Landroid/view/View;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class EmptyViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SpenFavoritePenMiniAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptyViewHolder(@NotNull SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenFavoritePenMiniAdapter;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$MiniAddViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter;Landroid/view/View;)V", "mAddButton", "Landroid/widget/ImageView;", "getMAddButton", "()Landroid/widget/ImageView;", "setMAddButton", "(Landroid/widget/ImageView;)V", "mAddViewViewModeHeight", "", "mAddViewEditModeHeight", "mAddViewEditModeWidth", "setVisibility", "", "visibility", "hasAnimation", "", "mAddButtonAniListener", "Landroid/animation/Animator$AnimatorListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class MiniAddViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        private ImageView mAddButton;

        @NotNull
        private final Animator.AnimatorListener mAddButtonAniListener;
        private final int mAddViewEditModeHeight;
        private final int mAddViewEditModeWidth;
        private final int mAddViewViewModeHeight;
        final /* synthetic */ SpenFavoritePenMiniAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MiniAddViewHolder(@NotNull final SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenFavoritePenMiniAdapter;
            this.mAddButtonAniListener = new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter$MiniAddViewHolder$mAddButtonAniListener$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ImageView mAddButton = this.this$0.getMAddButton();
                    if (mAddButton != null) {
                        mAddButton.setVisibility(spenFavoritePenMiniAdapter.getMode() == 1 ? 0 : 8);
                    }
                    ImageView mAddButton2 = this.this$0.getMAddButton();
                    if (mAddButton2 != null) {
                        mAddButton2.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ImageView mAddButton = this.this$0.getMAddButton();
                    if (mAddButton != null) {
                        mAddButton.setVisibility(0);
                    }
                }
            };
            ImageView imageView = (ImageView) itemView.findViewById(C7932R.id.add_icon);
            this.mAddButton = imageView;
            if (imageView != null) {
                SpenSettingUtilHover.setHoverEffect(imageView, itemView.getContext().getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_view_round_bg_elevation_hover), imageView.getElevation());
                imageView.setOnClickListener(new ViewOnClickListenerC7538b(spenFavoritePenMiniAdapter, 11));
            }
            this.mAddViewViewModeHeight = itemView.getContext().getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_view_height);
            this.mAddViewEditModeHeight = itemView.getContext().getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_add_view_edit_mode_height);
            this.mAddViewEditModeWidth = itemView.getContext().getResources().getDimensionPixelSize(C7932R.dimen.mini_favorite_pen_add_view_edit_mode_width);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setVisibility$lambda$0(MiniAddViewHolder miniAddViewHolder, boolean z) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(new ChangeBounds());
            transitionSet.setDuration(400L);
            transitionSet.setInterpolator((TimeInterpolator) SpenSettingUtilAnimation.getInterpolator(11));
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(miniAddViewHolder.mAddButton, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setDuration(100L);
            objectAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
            objectAnimatorOfFloat.addListener(miniAddViewHolder.mAddButtonAniListener);
            if (!z) {
                objectAnimatorOfFloat.setFloatValues(1.0f, 0.0f);
            }
            objectAnimatorOfFloat.start();
            View view = miniAddViewHolder.itemView;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            TransitionManager.beginDelayedTransition((ViewGroup) view, transitionSet);
        }

        @Nullable
        public final ImageView getMAddButton() {
            return this.mAddButton;
        }

        public final void setMAddButton(@Nullable ImageView imageView) {
            this.mAddButton = imageView;
        }

        public final void setVisibility(int visibility, boolean hasAnimation) {
            boolean z = visibility == 0;
            ImageView imageView = this.mAddButton;
            if (imageView != null) {
                imageView.setEnabled(z);
            }
            if (this.itemView.getLayoutParams() != null) {
                int i = z ? this.mAddViewViewModeHeight : this.mAddViewEditModeHeight;
                int i2 = z ? this.mAddViewViewModeHeight : this.mAddViewEditModeWidth;
                this.itemView.getLayoutParams().height = this.this$0.getPenCount() < this.this$0.getMaxCount() ? i : 0;
                this.itemView.getLayoutParams().width = i2;
            }
            if (hasAnimation) {
                this.itemView.post(new RunnableC0116a(7, this, z));
                return;
            }
            ImageView imageView2 = this.mAddButton;
            if (imageView2 != null) {
                imageView2.setVisibility(visibility);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0014J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007J\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0005H\u0016¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$MiniFavoritePenViewHolder;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "favoriteId", "", "deleteId", "roundBgId", "<init>", "(Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter;Landroid/view/View;III)V", "finalize", "", "setViewMode", "viewMode", "setInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "visibleColor", "colorName", "", "onClick", VPathDataCmd.RCurveTo, "onLongClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class MiniFavoritePenViewHolder extends SpenFavoriteViewHolder implements View.OnClickListener, View.OnLongClickListener {
        final /* synthetic */ SpenFavoritePenMiniAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MiniFavoritePenViewHolder(@NotNull SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter, View itemView, int i, int i2, int i4) {
            SpenPenBaseView penView;
            super(itemView, i, i2, i4);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = spenFavoritePenMiniAdapter;
            ImageButton imageButton = this.mDeleteButton;
            if (imageButton != null) {
                imageButton.setOnClickListener(this);
            }
            itemView.setOnLongClickListener(this);
            SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
            if (spenFavoritePenBaseView == null || (penView = spenFavoritePenBaseView.getPenView()) == null) {
                return;
            }
            penView.setOnLongClickListener(this);
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder
        public void finalize() {
            super.finalize();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == -1) {
                return;
            }
            if (this.this$0.getMode() == 1 && this.this$0.getMSelectedPosition() != adapterPosition) {
                int selectedPosition = this.this$0.getMSelectedPosition();
                this.this$0.setSelectedPosition(adapterPosition);
                SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter = this.this$0;
                spenFavoritePenMiniAdapter.notifyItemChanged(spenFavoritePenMiniAdapter.getMSelectedPosition(), 1);
                this.this$0.notifyItemChanged(selectedPosition, 1);
            }
            this.this$0.onItemEvent(adapterPosition);
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(@NotNull View v) {
            OnItemDragStartListener onItemDragStartListener;
            Intrinsics.checkNotNullParameter(v, "v");
            if (this.this$0.getMode() != 1 || this.this$0.getPenCount() <= 1 || (onItemDragStartListener = this.this$0.mDragStartListener) == null) {
                return false;
            }
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
            onItemDragStartListener.onItemDragStart(this);
            return false;
        }

        @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder
        public void setInfo(@NotNull SpenSettingUIPenInfo info, int visibleColor, @Nullable String colorName) {
            SpenPenBaseView penView;
            SpenPenBaseView penView2;
            SpenPenBaseView penView3;
            SpenPenBaseView penView4;
            Intrinsics.checkNotNullParameter(info, "info");
            super.setInfo(info, visibleColor, colorName);
            if (this.this$0.getMode() == 1) {
                setDeleteButtonVisibility(8, this.this$0.mIsNeedAnimation);
                setRoundBackgroundVisibility(8, this.this$0.mIsNeedAnimation);
                this.mContainer.setOnClickListener(this);
                SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
                if (spenFavoritePenBaseView != null && (penView4 = spenFavoritePenBaseView.getPenView()) != null) {
                    penView4.setOnClickListener(this);
                }
                SpenFavoritePenBaseView spenFavoritePenBaseView2 = this.mFavoritePenView;
                if (spenFavoritePenBaseView2 != null && (penView3 = spenFavoritePenBaseView2.getPenView()) != null) {
                    penView3.setImportantForAccessibility(1);
                }
                this.mContainer.setImportantForAccessibility(1);
                return;
            }
            if (this.this$0.getMode() == 2) {
                setDeleteButtonVisibility(0, this.this$0.mIsNeedAnimation);
                setRoundBackgroundVisibility(0, this.this$0.mIsNeedAnimation);
                this.mContainer.setOnClickListener(null);
                SpenFavoritePenBaseView spenFavoritePenBaseView3 = this.mFavoritePenView;
                if (spenFavoritePenBaseView3 != null && (penView2 = spenFavoritePenBaseView3.getPenView()) != null) {
                    penView2.setOnClickListener(null);
                }
                SpenFavoritePenBaseView spenFavoritePenBaseView4 = this.mFavoritePenView;
                if (spenFavoritePenBaseView4 != null && (penView = spenFavoritePenBaseView4.getPenView()) != null) {
                    penView.setImportantForAccessibility(2);
                }
                this.mContainer.setImportantForAccessibility(2);
                this.mContainer.setClickable(false);
            }
        }

        public final void setViewMode(int viewMode) {
            SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
            if (spenFavoritePenBaseView == null || !(spenFavoritePenBaseView instanceof SpenFavoritePenMiniView)) {
                return;
            }
            Intrinsics.checkNotNull(spenFavoritePenBaseView, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniView");
            ((SpenFavoritePenMiniView) spenFavoritePenBaseView).setMode(viewMode);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$OnItemDragStartListener;", "", "onItemDragStart", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemDragStartListener {
        void onItemDragStart(@NotNull RecyclerView.ViewHolder holder);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMiniAdapter$OnItemEventListener;", "", "onItemClick", "", "mode", "", "position", "onAddItemClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnItemEventListener {
        void onAddItemClick();

        void onItemClick(int mode, int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoritePenMiniAdapter(@Nullable Context context, int i, @Nullable List<? extends SpenSettingUIPenInfo> list, int i2) {
        super(context, i, list);
        Intrinsics.checkNotNull(context);
        this.mItemLayoutId = i2;
    }

    public static final /* synthetic */ void access$onAddItemEvent(SpenFavoritePenMiniAdapter spenFavoritePenMiniAdapter) {
        spenFavoritePenMiniAdapter.onAddItemEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAddItemEvent() {
        OnItemEventListener onItemEventListener = this.mOnItemEventListener;
        if (onItemEventListener != null) {
            onItemEventListener.onAddItemClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onItemEvent(int position) {
        OnItemEventListener onItemEventListener = this.mOnItemEventListener;
        if (onItemEventListener == null) {
            return false;
        }
        onItemEventListener.onItemClick(getMode(), position);
        return true;
    }

    private final void updatePenView(RecyclerView.ViewHolder holder, int position, boolean isViewMode) {
        boolean z = false;
        boolean z2 = getMSelectedPosition() == position;
        Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMiniAdapter.MiniFavoritePenViewHolder");
        MiniFavoritePenViewHolder miniFavoritePenViewHolder = (MiniFavoritePenViewHolder) holder;
        SpenSettingUIPenInfo penInfo = getPenInfo(position);
        if (penInfo != null) {
            miniFavoritePenViewHolder.setInfo(penInfo, getVisiblePenColor(penInfo.color), getColorName(penInfo.hsv));
        }
        miniFavoritePenViewHolder.setViewMode(isViewMode ? 1 : 2);
        boolean z3 = isViewMode && z2;
        if (this.mIsNeedAnimation && z2) {
            z = true;
        }
        miniFavoritePenViewHolder.setSelected(z3, z);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public void close() {
        this.mDragStartListener = null;
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    @Nullable
    public List<SpenSettingUIPenInfo> getFavoriteList() {
        return super.getFavoriteList();
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public int getItemOffset() {
        return 1;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter, com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public int getMode() {
        return super.getMode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Log.i(TAG, "onBindViewHolder() position=" + position);
        boolean z = false;
        boolean z2 = getMode() == 1;
        boolean z3 = getPenCount() < getMaxCount();
        if (holder.getItemViewType() != 2) {
            updatePenView(holder, position, z2);
            return;
        }
        MiniAddViewHolder miniAddViewHolder = (MiniAddViewHolder) holder;
        int i = (z2 && z3) ? 0 : 8;
        if (this.mIsNeedAnimation && z3) {
            z = true;
        }
        miniAddViewHolder.setVisibility(i, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Log.i(TAG, "onCreateViewHolder() viewType=" + viewType);
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.mItemLayoutId, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new MiniFavoritePenViewHolder(this, viewInflate, C7932R.id.favorite_pen_item, C7932R.id.delete_icon, C7932R.id.pen_rounded_bg);
        }
        if (viewType != 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_mini_favorite_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
            return new EmptyViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(C7932R.layout.setting_mini_favorite_add_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "inflate(...)");
        return new MiniAddViewHolder(this, viewInflate3);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteItemDragHelper.OnItemMoveListener
    public boolean onItemMove(int fromPosition, int toPosition) {
        return changePen(fromPosition, toPosition);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter
    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        super.setFavoriteList(list);
        setItemAnimation(false);
    }

    public final void setItemAnimation(boolean isNeedAnimation) {
        this.mIsNeedAnimation = isNeedAnimation;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseAdapter, com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public void setMode(int i) {
        super.setMode(i);
    }

    public final void setOnItemDragStartListener(@Nullable OnItemDragStartListener listener) {
        this.mDragStartListener = listener;
    }

    public final void setOnItemEventListener(@Nullable OnItemEventListener listener) {
        this.mOnItemEventListener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!payloads.isEmpty()) {
            if ((payloads.get(0) instanceof Integer) && holder.getItemViewType() == 1) {
                Object obj = payloads.get(0);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue != 1) {
                    if (iIntValue != 2) {
                        Log.i(TAG, "Not support payload.");
                        return;
                    } else {
                        updatePenView(holder, position, getMode() == 1);
                        return;
                    }
                }
                MiniFavoritePenViewHolder miniFavoritePenViewHolder = (MiniFavoritePenViewHolder) holder;
                if (getMode() == 1 && getMSelectedPosition() == position) {
                    z = true;
                }
                miniFavoritePenViewHolder.setSelected(z, true);
                return;
            }
        }
        super.onBindViewHolder(holder, position, payloads);
    }
}
