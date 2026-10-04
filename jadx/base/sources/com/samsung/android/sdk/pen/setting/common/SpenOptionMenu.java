package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.ViewOnClickListenerC7538b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAccessibility;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 '2\u00020\u0001:\u0003'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0014J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020!H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenOptionMenu;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mInOutAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenPopupInOutAnimation;", "mContentLayout", "Landroid/view/ViewGroup;", "mIsHiding", "", "mHideListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenOptionMenu$OnHideListener;", "mMenuItemClickListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenOptionMenu$OnMenuItemClickListener;", "mClickListener", "Landroid/view/View$OnClickListener;", "close", "", Constants.IntentExtraValue.SHOW, "needAnimation", "hide", "isShowing", "()Z", "setOnHideListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnMenuItemClickListener", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "initView", "getItemID", "", "id", "construct", "requestAccessibilityFocus", "notifyMenuItemClicked", "itemId", "Companion", "OnHideListener", "OnMenuItemClickListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenOptionMenu extends RelativeLayout {
    public static final int ITEM_ID_NONE = -1;

    @NotNull
    private static final String TAG = "SpenOptionMenu";

    @NotNull
    private final View.OnClickListener mClickListener;

    @Nullable
    private ViewGroup mContentLayout;

    @Nullable
    private OnHideListener mHideListener;

    @Nullable
    private SpenPopupInOutAnimation mInOutAnimation;
    private boolean mIsHiding;

    @Nullable
    private OnMenuItemClickListener mMenuItemClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenOptionMenu$OnHideListener;", "", "onHide", "", "view", "Landroid/view/View;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnHideListener {
        void onHide(@Nullable View view);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenOptionMenu$OnMenuItemClickListener;", "", "onMenuItemClicked", "", "itemID", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnMenuItemClickListener {
        void onMenuItemClicked(int itemID);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenOptionMenu(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mClickListener = new ViewOnClickListenerC7538b(this, 5);
        construct(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void construct(Context context) {
        ViewGroup viewGroupInitView = initView(context);
        this.mContentLayout = viewGroupInitView;
        if (viewGroupInitView != null) {
            viewGroupInitView.setClipToOutline(true);
            viewGroupInitView.setClipChildren(false);
            SpenSettingUtil.setShadowAlpha(viewGroupInitView, 0.5f);
            int childCount = viewGroupInitView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroupInitView.getChildAt(i);
                childAt.setOnClickListener(this.mClickListener);
                if (childAt instanceof TextView) {
                    SpenSettingUtilText.setTypeFace(getContext(), SpenSettingUtilText.FontName.REGULAR, childAt);
                }
            }
            this.mInOutAnimation = new SpenPopupInOutAnimation(viewGroupInitView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mClickListener$lambda$0(SpenOptionMenu spenOptionMenu, View view) {
        spenOptionMenu.notifyMenuItemClicked(spenOptionMenu.getItemID(view.getId()));
    }

    private final void notifyMenuItemClicked(int itemId) {
        OnMenuItemClickListener onMenuItemClickListener;
        if (itemId == -1 || (onMenuItemClickListener = this.mMenuItemClickListener) == null) {
            return;
        }
        onMenuItemClickListener.onMenuItemClicked(itemId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAccessibilityFocus() {
        ViewGroup viewGroup = this.mContentLayout;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        SpenSettingUtilAccessibility.requestAccessibilityFocus(viewGroup.getChildAt(0));
    }

    public void close() {
        this.mContentLayout = null;
        SpenPopupInOutAnimation spenPopupInOutAnimation = this.mInOutAnimation;
        if (spenPopupInOutAnimation != null) {
            spenPopupInOutAnimation.close();
        }
        this.mInOutAnimation = null;
        this.mHideListener = null;
        this.mMenuItemClickListener = null;
    }

    public int getItemID(int id) {
        return -1;
    }

    public final void hide(boolean needAnimation) {
        AbstractC4539a.m3208r("hide() animation=", TAG, needAnimation);
        if (!needAnimation) {
            hide();
            return;
        }
        if (this.mIsHiding) {
            return;
        }
        this.mIsHiding = true;
        SpenPopupInOutAnimation spenPopupInOutAnimation = this.mInOutAnimation;
        if (spenPopupInOutAnimation != null) {
            spenPopupInOutAnimation.hideAnimation(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenOptionMenu.hide.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    SpenOptionMenu.this.hide();
                    SpenOptionMenu.this.mIsHiding = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        }
    }

    @Nullable
    public ViewGroup initView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 0) {
            return super.onTouchEvent(event);
        }
        Log.i(TAG, "onTouchEvent() OutSideTouched()");
        hide(true);
        return true;
    }

    public final void setOnHideListener(@Nullable OnHideListener listener) {
        this.mHideListener = listener;
    }

    public final void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener listener) {
        this.mMenuItemClickListener = listener;
    }

    public final void show(boolean needAnimation) {
        AbstractC4539a.m3208r("show() animation=", TAG, needAnimation);
        if (needAnimation) {
            SpenPopupInOutAnimation spenPopupInOutAnimation = this.mInOutAnimation;
            if (spenPopupInOutAnimation != null) {
                spenPopupInOutAnimation.showAnimation(new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenOptionMenu.show.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        SpenOptionMenu.this.requestAccessibilityFocus();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }
                });
            }
        } else {
            requestAccessibilityFocus();
        }
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hide() {
        setVisibility(8);
        OnHideListener onHideListener = this.mHideListener;
        if (onHideListener != null) {
            onHideListener.onHide(this);
        }
    }
}
