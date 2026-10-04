package com.samsung.android.sdk.pen.setting.favoritepen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0001\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\b*J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001fH\u0000¢\u0006\u0002\b-J%\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tH\u0000¢\u0006\u0002\b2J%\u00103\u001a\u00020)2\u0006\u00101\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020%H\u0000¢\u0006\u0002\b6J\u0017\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b9J\r\u0010:\u001a\u00020%H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020%H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020%H\u0000¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u00020)2\u0006\u00101\u001a\u00020\tH\u0002J\u0010\u0010C\u001a\u00020)2\u0006\u00101\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\tH\u0002J\b\u0010F\u001a\u00020)H\u0002J\"\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0002J\"\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010K\u001a\u00020N2\u0006\u0010L\u001a\u00020N2\u0006\u0010O\u001a\u00020%H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayoutControl;", "", "context", "Landroid/content/Context;", "parent", "Landroid/widget/RelativeLayout;", "<init>", "(Landroid/content/Context;Landroid/widget/RelativeLayout;)V", "mAniViewPaddingTop", "", "mAniViewPaddingBottom", "mPaddingTop", "mPaddingLeft", "mPaddingRight", "mPaddingBottom", "mViewPenListGroupHeight", "mEditPenListGroupHeight", "mTitleHeight", "mPenListViewWrapper", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenSettingViewAnimationWrapper;", "mAnimateEditMode", "Landroid/animation/AnimatorSet;", "mAnimateViewMode", "mPenListBody", "mListGroup", "Landroid/view/ViewGroup;", "mActionLayout", "Landroid/view/View;", "mNoItemText", "mContext", "mPenViewList", "Landroidx/recyclerview/widget/RecyclerView;", "layoutOrientation", "getLayoutOrientation", "()I", "mColumnCount", "mHasAnimation", "", "mPenAnimationListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayoutControl$OnFavoritePenLayoutAnimationListener;", "close", "", "close$SDK_fullRelease", "addPenView", "penView", "addPenView$SDK_fullRelease", "setLayoutOrientation", "orientation", "columnCount", "mode", "setLayoutOrientation$SDK_fullRelease", "setMode", "favoriteCount", "isModeChanged", "setMode$SDK_fullRelease", "setOnFavoritePenAnimationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFavoritePenAnimationListener$SDK_fullRelease", "NeedAnimation", "NeedAnimation$SDK_fullRelease", "setAnimation", "hasAnimation", "setAnimation$SDK_fullRelease", "setPanelModeEnabled", "enabled", "setPanelModeEnabled$SDK_fullRelease", "updateContentBody", "adjustPenLayout", "updatePenListGroupHeight", "height", "createAnimatorSet", "getListViewAnimator", "Landroid/animation/ObjectAnimator;", "propertyName", "", "fromValue", "toValue", "getActionTranslateYAnimator", "", "isShow", "Companion", "OnFavoritePenLayoutAnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenFavoritePenLayoutControl {
    private static final int ANIMATE_PADDING_CHANGE_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenFavoritePenLayoutControl";
    private final int layoutOrientation;

    @NotNull
    private View mActionLayout;
    private int mAniViewPaddingBottom;
    private int mAniViewPaddingTop;

    @Nullable
    private AnimatorSet mAnimateEditMode;

    @Nullable
    private AnimatorSet mAnimateViewMode;
    private int mColumnCount;

    @NotNull
    private Context mContext;
    private int mEditPenListGroupHeight;
    private boolean mHasAnimation;

    @NotNull
    private ViewGroup mListGroup;

    @NotNull
    private View mNoItemText;
    private final int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private final int mPaddingTop;

    @Nullable
    private OnFavoritePenLayoutAnimationListener mPenAnimationListener;

    @NotNull
    private RelativeLayout mPenListBody;

    @Nullable
    private SpenSettingViewAnimationWrapper mPenListViewWrapper;

    @Nullable
    private RecyclerView mPenViewList;
    private final int mTitleHeight;
    private int mViewPenListGroupHeight;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayoutControl$OnFavoritePenLayoutAnimationListener;", "", "onAnimationComplete", "", "isDone", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnFavoritePenLayoutAnimationListener {
        void onAnimationComplete(boolean isDone);
    }

    /* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl$createAnimatorSet$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayoutControl$createAnimatorSet$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class C75752 extends AnimatorListenerAdapter {
        public C75752() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationEnd$lambda$0(SpenFavoritePenLayoutControl spenFavoritePenLayoutControl) {
            SpenSettingViewAnimationWrapper spenSettingViewAnimationWrapper = spenFavoritePenLayoutControl.mPenListViewWrapper;
            if (spenSettingViewAnimationWrapper != null) {
                spenSettingViewAnimationWrapper.setPaddingBottom(spenFavoritePenLayoutControl.mAniViewPaddingBottom);
            }
            RecyclerView recyclerView = spenFavoritePenLayoutControl.mPenViewList;
            if (recyclerView != null) {
                recyclerView.invalidateItemDecorations();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            new Handler().post(new RunnableC4617a(SpenFavoritePenLayoutControl.this, 28));
        }
    }

    public SpenFavoritePenLayoutControl(@NotNull Context context, @NotNull RelativeLayout parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.mContext = context;
        Resources resources = context.getResources();
        this.layoutOrientation = 0;
        this.mColumnCount = 0;
        this.mHasAnimation = false;
        this.mAniViewPaddingTop = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_view_animation_padding_top);
        this.mAniViewPaddingBottom = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_view_animation_padding_bottom);
        this.mPaddingLeft = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_horizontal);
        this.mPaddingTop = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_top);
        this.mPaddingRight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_horizontal);
        this.mPaddingBottom = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_bottom);
        this.mTitleHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_common_popup_title_height);
        this.mViewPenListGroupHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_height);
        this.mEditPenListGroupHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_edit_height);
        this.mListGroup = (ViewGroup) parent.findViewById(C7932R.id.list_layout);
        updatePenListGroupHeight(this.mEditPenListGroupHeight);
        this.mPenListBody = (RelativeLayout) parent.findViewById(C7932R.id.pen_list_body);
        this.mActionLayout = parent.findViewById(C7932R.id.action_button_layout);
        this.mNoItemText = parent.findViewById(C7932R.id.no_item_text);
    }

    private final void adjustPenLayout(int mode) {
        AbstractC2322a.m1631u(mode, "adjustPenLayout() mode=", TAG);
        if (mode == 1) {
            this.mActionLayout.setVisibility(8);
        } else if (mode == 2) {
            this.mActionLayout.setVisibility(0);
        }
        RecyclerView recyclerView = this.mPenViewList;
        if (recyclerView != null) {
            recyclerView.invalidateItemDecorations();
        }
    }

    private final void createAnimatorSet() {
        char c;
        Log.i(TAG, "Init AnimatorSet");
        this.mAnimateEditMode = new AnimatorSet();
        ObjectAnimator listViewAnimator = getListViewAnimator("paddingTop", this.mAniViewPaddingTop, this.mPaddingTop);
        ObjectAnimator listViewAnimator2 = getListViewAnimator("paddingBottom", this.mPaddingBottom, this.mAniViewPaddingBottom);
        int i = 1;
        ObjectAnimator actionTranslateYAnimator = getActionTranslateYAnimator(this.mAniViewPaddingBottom, 0.0f, true);
        int i2 = 0;
        if (listViewAnimator != null) {
            listViewAnimator.addUpdateListener(new C7581b(this, i2));
            listViewAnimator.addListener(new C75752());
        }
        AnimatorSet animatorSet = this.mAnimateEditMode;
        if (animatorSet != null) {
            animatorSet.setDuration(400L);
            animatorSet.setStartDelay(150L);
            c = 2;
            animatorSet.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
            animatorSet.playTogether(listViewAnimator, listViewAnimator2, actionTranslateYAnimator);
        } else {
            c = 2;
        }
        this.mAnimateViewMode = new AnimatorSet();
        ObjectAnimator listViewAnimator3 = getListViewAnimator("paddingTop", this.mPaddingTop, this.mAniViewPaddingTop);
        if (listViewAnimator3 != null) {
            listViewAnimator3.addUpdateListener(new C7581b(this, i));
            listViewAnimator3.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl.createAnimatorSet.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onAnimationEnd(animation);
                    OnFavoritePenLayoutAnimationListener onFavoritePenLayoutAnimationListener = SpenFavoritePenLayoutControl.this.mPenAnimationListener;
                    if (onFavoritePenLayoutAnimationListener != null) {
                        onFavoritePenLayoutAnimationListener.onAnimationComplete(true);
                    }
                    SpenFavoritePenLayoutControl spenFavoritePenLayoutControl = SpenFavoritePenLayoutControl.this;
                    spenFavoritePenLayoutControl.updatePenListGroupHeight(spenFavoritePenLayoutControl.mViewPenListGroupHeight);
                    SpenSettingViewAnimationWrapper spenSettingViewAnimationWrapper = SpenFavoritePenLayoutControl.this.mPenListViewWrapper;
                    if (spenSettingViewAnimationWrapper != null) {
                        spenSettingViewAnimationWrapper.setPaddingTop(SpenFavoritePenLayoutControl.this.mPaddingTop);
                    }
                    SpenFavoritePenLayoutControl.this.mNoItemText.setTranslationY(0.0f);
                }
            });
        }
        ObjectAnimator listViewAnimator4 = getListViewAnimator("paddingBottom", this.mAniViewPaddingBottom, this.mPaddingBottom);
        ObjectAnimator actionTranslateYAnimator2 = getActionTranslateYAnimator(0.0f, this.mAniViewPaddingBottom, false);
        AnimatorSet animatorSet2 = this.mAnimateViewMode;
        if (animatorSet2 != null) {
            animatorSet2.setDuration(400L);
            animatorSet2.setStartDelay(150L);
            animatorSet2.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
            Animator[] animatorArr = new Animator[3];
            animatorArr[0] = listViewAnimator3;
            animatorArr[1] = listViewAnimator4;
            animatorArr[c] = actionTranslateYAnimator2;
            animatorSet2.playTogether(animatorArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAnimatorSet$lambda$0(SpenFavoritePenLayoutControl spenFavoritePenLayoutControl, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RecyclerView recyclerView = spenFavoritePenLayoutControl.mPenViewList;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAnimatorSet$lambda$2(SpenFavoritePenLayoutControl spenFavoritePenLayoutControl, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RecyclerView recyclerView = spenFavoritePenLayoutControl.mPenViewList;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    private final ObjectAnimator getActionTranslateYAnimator(float fromValue, float toValue, boolean isShow) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mActionLayout, "translationY", fromValue, toValue);
        if (isShow) {
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl.getActionTranslateYAnimator.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SpenFavoritePenLayoutControl.this.mActionLayout.setVisibility(0);
                    super.onAnimationStart(animation);
                }
            });
            return objectAnimatorOfFloat;
        }
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl.getActionTranslateYAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                SpenFavoritePenLayoutControl.this.mActionLayout.setVisibility(8);
            }
        });
        return objectAnimatorOfFloat;
    }

    private final ObjectAnimator getListViewAnimator(String propertyName, int fromValue, int toValue) {
        SpenSettingViewAnimationWrapper spenSettingViewAnimationWrapper = this.mPenListViewWrapper;
        if (spenSettingViewAnimationWrapper == null) {
            return null;
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(spenSettingViewAnimationWrapper, propertyName, fromValue, toValue);
        objectAnimatorOfInt.addUpdateListener(new C7581b(this, 2));
        return objectAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getListViewAnimator$lambda$4(SpenFavoritePenLayoutControl spenFavoritePenLayoutControl, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RecyclerView recyclerView = spenFavoritePenLayoutControl.mPenViewList;
        if (recyclerView != null) {
            recyclerView.invalidateItemDecorations();
        }
    }

    private final void updateContentBody(int mode) {
        if (this.mPenViewList == null || this.mPenListViewWrapper == null) {
            return;
        }
        if (!getMHasAnimation()) {
            updatePenListGroupHeight(mode == 1 ? this.mViewPenListGroupHeight : this.mEditPenListGroupHeight);
            adjustPenLayout(mode);
            return;
        }
        if (this.mAnimateViewMode == null || this.mAnimateEditMode == null) {
            createAnimatorSet();
        }
        if (mode == 2) {
            updatePenListGroupHeight(this.mEditPenListGroupHeight);
            SpenSettingViewAnimationWrapper spenSettingViewAnimationWrapper = this.mPenListViewWrapper;
            if (spenSettingViewAnimationWrapper != null) {
                spenSettingViewAnimationWrapper.setPaddingTop(this.mAniViewPaddingTop);
            }
            RecyclerView recyclerView = this.mPenViewList;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            AnimatorSet animatorSet = this.mAnimateEditMode;
            if (animatorSet != null) {
                animatorSet.start();
            }
        } else {
            AnimatorSet animatorSet2 = this.mAnimateViewMode;
            if (animatorSet2 != null) {
                animatorSet2.start();
            }
        }
        setAnimation$SDK_fullRelease(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePenListGroupHeight(int height) {
        ViewGroup.LayoutParams layoutParams = this.mListGroup.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.height = height;
        this.mListGroup.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: renamed from: NeedAnimation$SDK_fullRelease, reason: from getter */
    public final boolean getMHasAnimation() {
        return this.mHasAnimation;
    }

    public final void addPenView$SDK_fullRelease(@NotNull RecyclerView penView) {
        Intrinsics.checkNotNullParameter(penView, "penView");
        this.mPenViewList = penView;
        Intrinsics.checkNotNull(penView);
        this.mPenListViewWrapper = new SpenSettingViewAnimationWrapper(penView);
        penView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        this.mPenListBody.addView(this.mPenViewList, new RelativeLayout.LayoutParams(-1, -1));
        penView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayoutControl$addPenView$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                super.getItemOffsets(outRect, view, parent, state);
                int width = (((parent.getWidth() - parent.getPaddingStart()) - parent.getPaddingEnd()) - (this.this$0.mColumnCount * view.getLayoutParams().width)) / (this.this$0.mColumnCount * 2);
                outRect.left = width;
                outRect.right = width;
            }
        });
        penView.setClipToPadding(false);
        penView.setClipChildren(false);
    }

    public final void close$SDK_fullRelease() {
        this.mPenAnimationListener = null;
        AnimatorSet animatorSet = this.mAnimateEditMode;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        this.mAnimateEditMode = null;
        AnimatorSet animatorSet2 = this.mAnimateViewMode;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        this.mAnimateViewMode = null;
        SpenSettingViewAnimationWrapper spenSettingViewAnimationWrapper = this.mPenListViewWrapper;
        if (spenSettingViewAnimationWrapper != null) {
            spenSettingViewAnimationWrapper.close();
        }
        this.mPenListViewWrapper = null;
    }

    public final int getLayoutOrientation() {
        return this.layoutOrientation;
    }

    public final void setAnimation$SDK_fullRelease(boolean hasAnimation) {
        this.mHasAnimation = hasAnimation;
    }

    public final void setLayoutOrientation$SDK_fullRelease(int orientation, int columnCount, int mode) {
        this.mColumnCount = columnCount;
        Resources resources = this.mContext.getResources();
        if (orientation == 2) {
            this.mViewPenListGroupHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_landscape_height);
            this.mEditPenListGroupHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_edit_landscape_height);
            this.mPaddingLeft = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_horizontal_land);
            this.mPaddingRight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_horizontal_land);
        } else {
            this.mViewPenListGroupHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_height);
            this.mEditPenListGroupHeight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_edit_height);
            this.mPaddingLeft = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_horizontal);
            this.mPaddingRight = resources.getDimensionPixelOffset(C7932R.dimen.setting_favorite_padding_horizontal);
        }
        updatePenListGroupHeight(mode == 1 ? this.mViewPenListGroupHeight : this.mEditPenListGroupHeight);
        RecyclerView recyclerView = this.mPenViewList;
        if (recyclerView != null) {
            recyclerView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, mode == 1 ? this.mPaddingBottom : this.mAniViewPaddingBottom);
        }
        adjustPenLayout(mode);
    }

    public final void setMode$SDK_fullRelease(int mode, int favoriteCount, boolean isModeChanged) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (mode == 2) {
            if (isModeChanged) {
                updateContentBody(2);
            }
            this.mNoItemText.setVisibility(8);
            RecyclerView recyclerView3 = this.mPenViewList;
            if ((recyclerView3 == null || recyclerView3.getVisibility() != 0) && (recyclerView2 = this.mPenViewList) != null) {
                recyclerView2.setVisibility(0);
                return;
            }
            return;
        }
        if (isModeChanged) {
            updateContentBody(1);
        }
        if (favoriteCount > 0) {
            this.mNoItemText.setVisibility(8);
            RecyclerView recyclerView4 = this.mPenViewList;
            if ((recyclerView4 == null || recyclerView4.getVisibility() != 0) && (recyclerView = this.mPenViewList) != null) {
                recyclerView.setVisibility(0);
                return;
            }
            return;
        }
        RecyclerView recyclerView5 = this.mPenViewList;
        if (recyclerView5 != null) {
            recyclerView5.setVisibility(8);
        }
        if (this.mListGroup.getHeight() == this.mEditPenListGroupHeight) {
            this.mNoItemText.setTranslationY(this.mTitleHeight / 2.0f);
        } else {
            this.mNoItemText.setTranslationY(0.0f);
        }
        this.mNoItemText.setVisibility(0);
    }

    public final void setOnFavoritePenAnimationListener$SDK_fullRelease(@Nullable OnFavoritePenLayoutAnimationListener listener) {
        this.mPenAnimationListener = listener;
    }

    public final void setPanelModeEnabled$SDK_fullRelease(boolean enabled) {
        if (enabled) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(C7932R.dimen.setting_favorite_content_edit_height);
            this.mEditPenListGroupHeight = dimensionPixelOffset;
            this.mViewPenListGroupHeight = dimensionPixelOffset;
            this.mAniViewPaddingBottom = 0;
            this.mAniViewPaddingTop = 0;
            updatePenListGroupHeight(dimensionPixelOffset);
            this.mNoItemText.setVisibility(8);
        }
    }
}
