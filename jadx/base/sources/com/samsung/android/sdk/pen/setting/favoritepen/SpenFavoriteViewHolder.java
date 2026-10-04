package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.common.SpenVoiceAssistantAsButton;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenResource;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenBaseView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000 +2\u00020\u0001:\u0001+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\"\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0016J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dJ$\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0005H\u0002R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "favoriteId", "", "deleteId", "roundBgId", "<init>", "(Landroid/view/View;III)V", "mFavoritePenView", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenBaseView;", "mDeleteButton", "Landroid/widget/ImageButton;", "mContainer", "Landroid/view/ViewGroup;", "mRoundBgView", "mStringComma", "", "mRoundBgHoverElevation", "finalize", "", "setInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "visibleColor", "colorName", "setSelected", "selected", "", "hasAnimation", "setRoundBackgroundVisibility", "visibility", "setDeleteButtonVisibility", "setAccessibilityText", "view", "getPenNameId", "penName", "initFavoritePenView", "initDeleteButton", "res", "Landroid/content/res/Resources;", "initRoundBgView", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenFavoriteViewHolder extends RecyclerView.ViewHolder {
    private static final int DELETE_BUTTON_HIDE_ALPHA_ANIMATION_DURATION = 100;
    private static final int DELETE_BUTTON_SHOW_SCALE_ANIMATION_DURATION = 300;
    private static final int ROUND_BG_HIDE_ALPHA_ANIMATION_DURATION = 100;
    private static final int ROUND_BG_SHOW_ALPHA_ANIMATION_DURATION = 200;

    @JvmField
    @NotNull
    public ViewGroup mContainer;

    @JvmField
    @Nullable
    public ImageButton mDeleteButton;

    @JvmField
    @Nullable
    public SpenFavoritePenBaseView mFavoritePenView;
    private int mRoundBgHoverElevation;

    @JvmField
    @Nullable
    public View mRoundBgView;

    @JvmField
    @Nullable
    public String mStringComma;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenFavoriteViewHolder(@NotNull View itemView, int i, int i2, int i4) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ViewGroup viewGroup = (ViewGroup) itemView;
        this.mContainer = viewGroup;
        viewGroup.setClipChildren(false);
        viewGroup.setAccessibilityDelegate(new SpenVoiceAssistantAsButton());
        Resources resources = itemView.getResources();
        initFavoritePenView(i);
        Intrinsics.checkNotNull(resources);
        initDeleteButton(i2, resources);
        initRoundBgView(i4);
        this.mRoundBgHoverElevation = itemView.getResources().getDimensionPixelSize(C7932R.dimen.setting_favorite_item_round_bg_elevation);
        this.mStringComma = resources.getString(C7932R.string.pen_string_comma);
    }

    private final int getPenNameId(String penName) {
        return SpenPenResource.getPenDescriptionID(penName);
    }

    private final void initDeleteButton(int deleteId, Resources res) {
        ImageButton imageButton = (ImageButton) this.itemView.findViewById(deleteId);
        this.mDeleteButton = imageButton;
        if (imageButton != null) {
            final String string = res.getString(C7932R.string.pen_string_remove_from_favorites);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            imageButton.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$initDeleteButton$1$1
                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View host, int eventType) {
                    Intrinsics.checkNotNullParameter(host, "host");
                    if (eventType == 1) {
                        host.announceForAccessibility(string);
                    }
                    super.sendAccessibilityEvent(host, eventType);
                }
            });
            SpenSettingUtilHover.setHoverText(imageButton, string);
        }
    }

    private final void initFavoritePenView(int favoriteId) {
        View viewFindViewById = this.itemView.findViewById(favoriteId);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenBaseView");
        final SpenFavoritePenBaseView spenFavoritePenBaseView = (SpenFavoritePenBaseView) viewFindViewById;
        this.mFavoritePenView = spenFavoritePenBaseView;
        if (spenFavoritePenBaseView != null) {
            spenFavoritePenBaseView.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$initFavoritePenView$1$1
                @Override // android.view.View.OnHoverListener
                public boolean onHover(View v, MotionEvent event) {
                    Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
                    if (numValueOf != null && numValueOf.intValue() == 9) {
                        spenFavoritePenBaseView.setHoverResourceEnabled(true);
                    } else if (numValueOf != null && numValueOf.intValue() == 10) {
                        spenFavoritePenBaseView.setHoverResourceEnabled(false);
                    }
                    return false;
                }
            });
        }
    }

    private final void initRoundBgView(int roundBgId) {
        final View viewFindViewById = this.itemView.findViewById(roundBgId);
        this.mRoundBgView = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$initRoundBgView$1$1
                @Override // android.view.View.OnHoverListener
                public boolean onHover(View v, MotionEvent event) {
                    Integer numValueOf = event != null ? Integer.valueOf(event.getAction()) : null;
                    if (numValueOf != null && numValueOf.intValue() == 9) {
                        viewFindViewById.setElevation(this.mRoundBgHoverElevation);
                        return false;
                    }
                    if (numValueOf == null || numValueOf.intValue() != 10) {
                        return false;
                    }
                    viewFindViewById.setElevation(0.0f);
                    return false;
                }
            });
        }
    }

    private final void setAccessibilityText(View view, SpenSettingUIPenInfo info, String colorName) {
        String strM1624n;
        SpenPenBaseView penView;
        if (info == null) {
            view.setTag(null);
            SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
            SpenSettingUtilHover.setHoverText(spenFavoritePenBaseView != null ? spenFavoritePenBaseView.getPenView() : null, null);
            return;
        }
        Object tag = view.getTag(C7932R.id.target_pen);
        if (tag != null) {
            String string = view.getResources().getString(((Integer) tag).intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (info.name.compareTo(SpenPenManager.SPEN_MOSAIC_PEN) == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                strM1624n = AbstractC2322a.m1624n("%s%s %d", new Object[]{string, this.mStringComma, Integer.valueOf(info.sizeLevel)}, 3, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str = this.mStringComma;
                strM1624n = AbstractC2322a.m1624n("%s%s %s%s %d", new Object[]{string, str, colorName, str, Integer.valueOf(info.sizeLevel)}, 5, "format(format, *args)");
            }
            view.setTag(strM1624n);
            SpenFavoritePenBaseView spenFavoritePenBaseView2 = this.mFavoritePenView;
            if (spenFavoritePenBaseView2 != null && (penView = spenFavoritePenBaseView2.getPenView()) != null) {
                penView.setContentDescription(strM1624n);
            }
            SpenFavoritePenBaseView spenFavoritePenBaseView3 = this.mFavoritePenView;
            SpenSettingUtilHover.setHoverText(spenFavoritePenBaseView3 != null ? spenFavoritePenBaseView3.getPenView() : null, strM1624n);
        }
    }

    public void finalize() {
        SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
        if (spenFavoritePenBaseView != null) {
            spenFavoritePenBaseView.close();
        }
        this.mFavoritePenView = null;
        this.mDeleteButton = null;
        this.mStringComma = null;
    }

    public final void setDeleteButtonVisibility(int visibility, boolean hasAnimation) {
        final ImageButton imageButton = this.mDeleteButton;
        if (imageButton == null || imageButton.getVisibility() == visibility) {
            return;
        }
        if (!hasAnimation) {
            imageButton.setAlpha(1.0f);
            imageButton.setVisibility(visibility);
        } else if (visibility == 0) {
            SpenSettingUtilAnimation.scaleUpVisibleAnimator(imageButton, 11, 300L, new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$setDeleteButtonVisibility$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    imageButton.setScaleX(1.0f);
                    imageButton.setScaleY(1.0f);
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
                    imageButton.setAlpha(1.0f);
                    imageButton.setVisibility(0);
                }
            });
        } else {
            SpenSettingUtilAnimation.alphaGoneAnimator(imageButton, 15, 100L, new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$setDeleteButtonVisibility$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    imageButton.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    imageButton.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }
            });
        }
    }

    public void setInfo(@NotNull SpenSettingUIPenInfo info, int visibleColor, @Nullable String colorName) {
        Intrinsics.checkNotNullParameter(info, "info");
        SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
        if (spenFavoritePenBaseView == null || spenFavoritePenBaseView.isSamePenInfo(info.name, visibleColor, info.sizeLevel, info.particleSize, info.isFixedWidth, info.isFixedOpacity)) {
            return;
        }
        this.mContainer.setTag(C7932R.id.target_pen, Integer.valueOf(getPenNameId(info.name)));
        info.color = visibleColor;
        spenFavoritePenBaseView.setPenInfo(info);
        setAccessibilityText(this.mContainer, info, colorName);
        ImageButton imageButton = this.mDeleteButton;
        if (imageButton != null) {
            String string = imageButton.getResources().getString(C7932R.string.pen_string_remove_from_favorites);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(this.mStringComma + " ");
            sb.append(this.mContainer.getTag());
            imageButton.setContentDescription(sb);
        }
    }

    public final void setRoundBackgroundVisibility(int visibility, boolean hasAnimation) {
        SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
        if (spenFavoritePenBaseView != null) {
            spenFavoritePenBaseView.setInterceptHoverEvent(visibility == 0);
        }
        final View view = this.mRoundBgView;
        if (view == null || view.getVisibility() == visibility) {
            return;
        }
        if (!hasAnimation) {
            view.setAlpha(1.0f);
            view.setVisibility(visibility);
        } else if (visibility == 0) {
            SpenSettingUtilAnimation.alphaVisibleAnimator(view, 15, 200L, new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$setRoundBackgroundVisibility$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    view.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    view.setVisibility(0);
                }
            });
        } else {
            SpenSettingUtilAnimation.alphaGoneAnimator(view, 15, 100L, new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewHolder$setRoundBackgroundVisibility$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    view.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                    view.setVisibility(8);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.checkNotNullParameter(animator, "animator");
                }
            });
        }
    }

    public final void setSelected(boolean selected, boolean hasAnimation) {
        SpenFavoritePenBaseView spenFavoritePenBaseView = this.mFavoritePenView;
        if (spenFavoritePenBaseView != null) {
            spenFavoritePenBaseView.setSelected(selected, hasAnimation);
        }
    }
}
