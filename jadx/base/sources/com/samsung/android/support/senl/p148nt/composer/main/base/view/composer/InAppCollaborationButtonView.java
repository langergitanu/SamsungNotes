package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.TooltipCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.ICustomToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InAppCollaborationButtonView extends SystemUiControlView implements View.OnClickListener {
    private static final long ANIMATION_DURATION = 400;
    private static final long ANIMATION_EACH_VIEW_SHOW_DELAY = 50;
    private static final String TAG = Logger.createTag("InAppCollaborationButtonView");
    private AppCompatActivity mActivity;
    private View.OnClickListener mClickListener;
    private View mFullScreenBtn;
    private final LinearLayout mInAppCollaborationBtn;
    private final LinearLayout mInAppCollaborationBtnContainer;
    private final LinearLayout mInAppCollaborationSpecificBtn;

    public InAppCollaborationButtonView(LinearLayout linearLayout) {
        this.mInAppCollaborationBtnContainer = linearLayout;
        this.mInAppCollaborationBtn = (LinearLayout) linearLayout.findViewById(C9086R.id.comp_in_app_collaboration_btn);
        this.mInAppCollaborationSpecificBtn = (LinearLayout) linearLayout.findViewById(C9086R.id.comp_in_app_collaboration_specific_btn);
    }

    private void getButtonViews(List<View> list, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof AppCompatImageView) {
                list.add(childAt);
                childAt.setVisibility(4);
            }
        }
    }

    private void hideInAppCollaborationBtn(final Activity activity, final boolean z) {
        Logger.m10999d(TAG, "hideInAppCollaborationBtn# ");
        if (this.mInAppCollaborationBtnContainer.getVisibility() == 0) {
            this.mInAppCollaborationBtn.animate().translationY(this.mInAppCollaborationBtn.getResources().getDimensionPixelSize(C9086R.dimen.in_app_buttons_animation_translation_y) * (-1)).setDuration(z ? 400L : 0L).setInterpolator(new PathInterpolator(0.9f, 0.0f, 0.83f, 0.83f)).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.InAppCollaborationButtonView.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    InAppCollaborationButtonView.this.mInAppCollaborationBtnContainer.setVisibility(8);
                    InAppCollaborationButtonView.this.showToolbar(activity, z);
                }
            }).start();
            return;
        }
        updateToShowHideStatusBar(activity, false);
        this.mInAppCollaborationBtnContainer.setVisibility(8);
        showToolbar(activity, z);
    }

    private void hideToolbar(final Activity activity, final boolean z) {
        ICustomToolbar customAppToolbar = getCustomAppToolbar(activity);
        if (customAppToolbar == null) {
            return;
        }
        if (z) {
            customAppToolbar.setAnimationListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.InAppCollaborationButtonView.2
                boolean isCanceled = false;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                    this.isCanceled = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (this.isCanceled) {
                        return;
                    }
                    InAppCollaborationButtonView.this.updateToShowHideStatusBar(activity, true);
                    InAppCollaborationButtonView.this.showInAppCollaborationBtn(z);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    this.isCanceled = false;
                }
            });
        }
        customAppToolbar.hideToolbar(null, z);
        if (z) {
            return;
        }
        updateToShowHideStatusBar(activity, true);
        showInAppCollaborationBtn(z);
    }

    private void initCloseBtn() {
        View viewFindViewById = this.mInAppCollaborationBtn.findViewById(C9086R.id.comp_in_app_collaboration_close_btn);
        viewFindViewById.setOnClickListener(this);
        ViewCompat.getInstance().setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    private void initMoreBtn() {
        View viewFindViewById = this.mInAppCollaborationBtn.findViewById(C9086R.id.comp_in_app_collaboration_more_btn);
        viewFindViewById.setOnClickListener(this);
        ViewCompat.getInstance().setTooltipText(viewFindViewById, viewFindViewById.getContentDescription());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInAppCollaborationBtn(boolean z) {
        Logger.m10999d(TAG, "showInAppCollaborationBtn# ");
        if (this.mInAppCollaborationBtnContainer.getVisibility() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        getButtonViews(arrayList, this.mInAppCollaborationSpecificBtn);
        getButtonViews(arrayList, this.mInAppCollaborationBtn);
        this.mInAppCollaborationBtnContainer.setVisibility(0);
        this.mInAppCollaborationBtn.setTranslationY(0.0f);
        int size = arrayList.size();
        float dimensionPixelSize = this.mInAppCollaborationBtn.getResources().getDimensionPixelSize(C9086R.dimen.in_app_buttons_animation_translation_y) * (-1);
        for (int i = 0; i < size; i++) {
            final View view = (View) arrayList.get((size - i) - 1);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(dimensionPixelSize, 0.0f);
            valueAnimatorOfFloat.setDuration(z ? 400L : 0L);
            valueAnimatorOfFloat.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
            valueAnimatorOfFloat.setStartDelay(((long) i) * 50);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.InAppCollaborationButtonView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.InAppCollaborationButtonView.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setVisibility(0);
                }
            });
            valueAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToolbar(final Activity activity, boolean z) {
        ICustomToolbar customAppToolbar = getCustomAppToolbar(activity);
        if (customAppToolbar == null) {
            return;
        }
        String str = TAG;
        View view = this.mFullScreenBtn;
        Logger.m11003i(str, "showToolbar# debug fullbtn: ".concat((view == null || view.getVisibility() != 0) ? "not" : "visible"));
        if (z) {
            customAppToolbar.setAnimationListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.InAppCollaborationButtonView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    InAppCollaborationButtonView.this.updateToShowHideStatusBar(activity, false);
                }
            });
        } else {
            updateToShowHideStatusBar(activity, false);
        }
        customAppToolbar.showToolbar(null, z);
    }

    private void updateViewByInAppCollaborationMode(Activity activity, boolean z, boolean z2) {
        View viewFindViewById = this.mActivity.findViewById(C9086R.id.composer_toolbar_navigate);
        if (z) {
            hideToolbar(activity, z2);
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(false);
            }
        } else {
            hideInAppCollaborationBtn(activity, z2);
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(true);
            }
        }
        AbstractC8014b.m7224z("updateViewByInAppCollaborationMode isInAppCollaborationMode# ", TAG, z);
    }

    public void init(AppCompatActivity appCompatActivity, View.OnClickListener onClickListener) {
        this.mActivity = appCompatActivity;
        this.mClickListener = onClickListener;
        initMoreBtn();
        initCloseBtn();
        this.mFullScreenBtn = this.mActivity.findViewById(C9086R.id.comp_full_screen_btn);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CustomToolbarFragment customToolbarFragment;
        if (this.mClickListener == null) {
            return;
        }
        int id = view.getId();
        if (id == C9086R.id.comp_in_app_collaboration_close_btn) {
            Logger.m10999d(TAG, "onClick# onCloseBtnClicked");
            this.mClickListener.onClick(view);
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_CLOSE_IN_APP_FROM_SERVER);
        } else {
            if (CommonUtil.isNotAvailableActivity(this.mActivity) || (customToolbarFragment = (CustomToolbarFragment) this.mActivity.getSupportFragmentManager().findFragmentByTag("Composer")) == null) {
                return;
            }
            CustomToolbar customToolbar = (CustomToolbar) customToolbarFragment.getSupportedToolbar();
            if (id == C9086R.id.comp_in_app_collaboration_more_btn) {
                customToolbar.showOverflowMenu();
                return;
            }
            MenuItem menuItemFindItem = customToolbar.getMenu().findItem(id);
            if (menuItemFindItem == null) {
                Logger.m11000e(TAG, "InAppCollaborationButtonView# unexpected view clicked ");
            } else {
                customToolbarFragment.onOptionsItemSelected(menuItemFindItem);
            }
        }
    }

    public void onInAppCollaborationModeChanged(Activity activity, boolean z) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.invalidateOptionsMenu();
        updateViewByInAppCollaborationMode(activity, z, true);
    }

    public void onOptionsMenuPrepared() {
        LinearLayout linearLayout = this.mInAppCollaborationSpecificBtn;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        Menu menu = ((CustomToolbar) this.mActivity.findViewById(C9086R.id.toolbar)).getMenu();
        StringBuilder sb = new StringBuilder("onOptionsMenuPrepared# \n");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item != null && item.isVisible()) {
                if (item.getGroupId() == C9086R.id.action_more) {
                    sb.append(PropertyUtils.INDEXED_DELIM);
                    sb.append(item.getTitle());
                    sb.append("] is more menu\n");
                } else {
                    int itemId = item.getItemId();
                    if (itemId == C9086R.id.action_tablet_sort_pages || itemId == C9086R.id.action_add) {
                        sb.append(PropertyUtils.INDEXED_DELIM);
                        sb.append(item.getTitle());
                        sb.append("] is used\n");
                        ImageView imageView = (ImageView) LayoutInflater.from(this.mActivity).inflate(C9086R.layout.comp_view_in_app_collaboration_btn, (ViewGroup) this.mInAppCollaborationSpecificBtn, false);
                        imageView.setId(item.getItemId());
                        imageView.setImageDrawable(item.getIcon());
                        imageView.setColorFilter(imageView.getResources().getColor(C9086R.color.composer_menu_icon_color, null), PorterDuff.Mode.SRC_IN);
                        imageView.setContentDescription(item.getTitle());
                        TooltipCompat.setTooltipText(imageView, imageView.getContentDescription());
                        imageView.setOnClickListener(this);
                        this.mInAppCollaborationSpecificBtn.addView(imageView);
                    } else {
                        sb.append(PropertyUtils.INDEXED_DELIM);
                        sb.append(item.getTitle());
                        sb.append("] is not used on in app mode\n");
                    }
                }
            }
        }
        Logger.m10999d(TAG, sb.toString());
    }

    public void updateInAppCollaborationMode(Activity activity, boolean z) {
        ICustomToolbar customAppToolbar = getCustomAppToolbar(activity);
        if (customAppToolbar == null) {
            return;
        }
        if (!(z && customAppToolbar.getVisibility() == 0) && (z || customAppToolbar.getVisibility() == 0)) {
            return;
        }
        updateViewByInAppCollaborationMode(activity, z, false);
    }
}
