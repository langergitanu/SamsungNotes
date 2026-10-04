package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Editable;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.animation.C0421a;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingAware;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingTopLayout;
import com.samsung.android.sdk.pen.setting.handwriting.RunnableC7599e;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.badge.BadgeHelper;
import com.samsung.android.support.senl.p148nt.app.common.badge.DrawerBadgeIcon;
import com.samsung.android.support.senl.p148nt.app.common.listener.OffsetUpdateListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewModeUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.ViewShapeManager;
import com.samsung.android.support.senl.p148nt.app.common.widget.FolderPathLayout;
import com.samsung.android.support.senl.p148nt.app.common.widget.IFolderPathLayoutListener;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ActionMenuController {
    public static final String TAG = "ActionMenuController";
    private View mActionModeView;
    private AppBarLayout mAppBar;
    private TextView mCheckAllText;
    private TextView mCheckInfoText;
    protected CollapsingToolbarLayout mCollapsingToolbar;
    private final Contract mContract;
    private FloatingToolbarLayout mFloatingToolbarLayout;
    private AppBarLayout.AppBarStateChangedListener mFloatingToolbarStateListener;
    private AnimatorSet mFolderPathGoneAnimation;
    private FolderPathLayout mFolderPathLayout;
    private AnimatorSet mFolderPathVisibleAnimation;
    private final AbsFragment mFragment;
    private AppBarLayout.AppBarStateChangedListener mMultiFloatingStateListener;
    private FloatingTopLayout mMultiFloatingView;
    private OffsetUpdateListener mOffsetUpdateListener;
    private final OnClickNavigateListener mOnClickNavigateListener;
    private final PenRecyclerView mRecyclerView;
    private CheckBox mSelectAll;
    private ViewGroup mSelectAllLayout;
    private TextView mSubTitleTextView;
    private Toolbar mToolbar;
    private boolean mVerticalOffset = true;
    private long mToolbarStatus = 0;
    private int mAppBarOffset = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getModeIndex();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickNavigateListener {
        void onClick(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickSelectAllListener {
        void onClick(boolean z);
    }

    public ActionMenuController(AbsFragment absFragment, PenRecyclerView penRecyclerView, OnClickNavigateListener onClickNavigateListener, Contract contract) {
        this.mFragment = absFragment;
        this.mRecyclerView = penRecyclerView;
        this.mOnClickNavigateListener = onClickNavigateListener;
        this.mContract = contract;
    }

    private void addFolderPathStateChangeListener() {
        if (this.mMultiFloatingStateListener != null || this.mFolderPathLayout == null || this.mMultiFloatingView == null) {
            return;
        }
        C8236b c8236b = new C8236b(this, 1);
        this.mMultiFloatingStateListener = c8236b;
        this.mAppBar.seslAddAppBarStateChangedListener(c8236b);
    }

    private String getSelectAllContentDescription(int i) {
        if (this.mSelectAll.isChecked()) {
            return ContentUtils.convertToArabicNumber(i) + " " + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_selected) + SQLKeyword.COMMA + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_double_tap_to_deselect_all) + SQLKeyword.COMMA + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_tick_box) + SQLKeyword.COMMA + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_selected);
        }
        if (i == 0) {
            return this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_nothing_selected) + SQLKeyword.COMMA + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_double_tap_to_select_all) + SQLKeyword.COMMA + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_tick_box) + SQLKeyword.COMMA + this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_not_selected);
        }
        StringBuilder sbM1322o = AbstractC1974b.m1322o(i, " ");
        sbM1322o.append(this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_selected));
        sbM1322o.append(SQLKeyword.COMMA);
        sbM1322o.append(this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_double_tap_to_select_all));
        sbM1322o.append(SQLKeyword.COMMA);
        sbM1322o.append(this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_tick_box));
        sbM1322o.append(SQLKeyword.COMMA);
        sbM1322o.append(this.mFragment.getActivity().getString(C8003R.string.selectall_voice_ass_not_selected));
        return sbM1322o.toString();
    }

    private Toolbar getToolbar() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            return toolbar;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
            return null;
        }
        Toolbar toolbar2 = (Toolbar) appCompatActivity.findViewById(C8003R.id.toolbar);
        this.mToolbar = toolbar2;
        return toolbar2;
    }

    private TextView getToolbarTitle() {
        Toolbar toolbar = getToolbar();
        if (toolbar == null) {
            return null;
        }
        return toolbar.getTitleTextView();
    }

    private Drawable getViewToDrawable(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, measuredWidth, measuredHeight);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return new BitmapDrawable(view.getResources(), bitmapCreateBitmap);
    }

    private void initSelectAllLayout(final OnClickSelectAllListener onClickSelectAllListener, boolean z) {
        initExtendedToolbar();
        MainLogger.m7258i(getTag(), "inflateSelectAllLayout()");
        if (this.mSelectAllLayout == null) {
            ViewGroup viewGroup = (ViewGroup) this.mActionModeView.findViewById(C8003R.id.checkbox_withtext);
            this.mSelectAllLayout = viewGroup;
            if (viewGroup == null) {
                return;
            } else {
                this.mSelectAll = (CheckBox) viewGroup.findViewById(C8003R.id.checkbox_all);
            }
        }
        this.mSelectAllLayout.setVisibility(0);
        this.mSelectAllLayout.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ActionMenuController.this.mSelectAll == null) {
                    return;
                }
                ActionMenuController.this.mSelectAll.setChecked(!ActionMenuController.this.mSelectAll.isChecked());
                onClickSelectAllListener.onClick(ActionMenuController.this.mSelectAll.isChecked());
            }
        });
        if (this.mCheckInfoText == null) {
            this.mCheckInfoText = (TextView) this.mActionModeView.findViewById(C8003R.id.check_info);
            CharUtils.applyTextSizeUntilLargeSize(this.mFragment.getContext(), this.mCheckInfoText, 19.0f);
        }
        TextView textView = this.mCheckInfoText;
        if (textView != null) {
            textView.setVisibility(0);
            if (z) {
                this.mOffsetUpdateListener.setTextView(null);
                this.mCheckInfoText.setAlpha(1.0f);
            } else {
                OffsetUpdateListener offsetUpdateListener = this.mOffsetUpdateListener;
                if (offsetUpdateListener != null) {
                    offsetUpdateListener.setTextView(this.mCheckInfoText);
                }
            }
        }
        if (this.mCheckAllText == null) {
            this.mCheckAllText = (TextView) this.mSelectAllLayout.findViewById(C8003R.id.check_all_text);
        }
        setDisplayHomeAsUpEnabled(isPickEditSearchWidgetMode(), true);
    }

    private void initSupportActionBar(AppCompatActivity appCompatActivity, Toolbar toolbar) {
        if (appCompatActivity.getSupportActionBar() != null) {
            return;
        }
        appCompatActivity.setSupportActionBar(toolbar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFolderPathStateChangeListener$3(int i, int i2) {
        if (this.mMultiFloatingView.getVisibility() != 0) {
            return;
        }
        if (i <= 3 && i2 > 3) {
            this.mFolderPathLayout.updateBackgroundColor(C8003R.color.transparent);
        } else {
            if (i <= 3 || i2 > 3) {
                return;
            }
            this.mFolderPathLayout.updateBackgroundColor(C8003R.color.folderpath_bg_color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDisplayHomeAsUpEnabledInternal$1(boolean z, View view) {
        OnClickNavigateListener onClickNavigateListener = this.mOnClickNavigateListener;
        if (onClickNavigateListener == null) {
            return;
        }
        onClickNavigateListener.onClick(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFloatingToolbarStateListener$0(int i, int i2) {
        if ((i >= 4 || i2 < 4) && (i < 4 || i2 >= 4)) {
            return;
        }
        updateCheckAllTextVisibility(true);
        updateCheckInfoText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFolderPathLayoutVisibleAnimation$4(ValueAnimator valueAnimator) {
        this.mFolderPathLayout.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFolderPathLayoutVisibleAnimation$5(boolean z, ValueAnimator valueAnimator) {
        this.mFolderPathLayout.setOutlineProvider(ViewShapeManager.getInstance().getFolderPathOutlineProvider(((Float) valueAnimator.getAnimatedValue()).floatValue(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateCheckInfoText$2() {
        String string;
        AppBarLayout appBarLayout;
        if (this.mCheckInfoText == null) {
            return;
        }
        CheckBox checkBox = this.mSelectAll;
        if (checkBox == null || checkBox.getTag() == null || (appBarLayout = this.mAppBar) == null || appBarLayout.seslGetAppBarState().getState() < 3) {
            if (this.mCheckInfoText.getTag() == null) {
                return;
            } else {
                string = this.mCheckInfoText.getTag().toString();
            }
        } else if (this.mSelectAll.getTag() == null) {
            return;
        } else {
            string = this.mSelectAll.getTag().toString();
        }
        if (string.contentEquals(this.mCheckInfoText.getText())) {
            return;
        }
        MainLogger.m7254d(getTag(), "updateCheckInfoText ".concat(string));
        try {
            this.mCheckInfoText.setText(ContentUtils.convertToArabicNumber(Integer.parseInt(string)));
        } catch (NumberFormatException unused) {
            this.mCheckInfoText.setText(string);
        }
        FloatingToolbarLayout floatingToolbarLayout = this.mFloatingToolbarLayout;
        if (floatingToolbarLayout == null || !floatingToolbarLayout.isShowingFloatingItemBackground()) {
            return;
        }
        this.mFloatingToolbarLayout.showFloatingItemBackground(true, true);
    }

    private void releaseCoeditMemberCountView() {
        if (CommonUtil.isNotAvailableActivity((AppCompatActivity) this.mFragment.getActivity())) {
            return;
        }
        updateToolbarTitleCompoundDrawableToEndWithView(null, 0);
    }

    private void setDisplayHomeAsUpEnabledInternal(boolean z, boolean z2, final boolean z3) {
        int i;
        Toolbar toolbar;
        if (z) {
            this.mToolbarStatus = 0L;
            i = 1;
        } else {
            i = 3;
        }
        if (z3) {
            i |= 4;
        }
        int i2 = z2 ? i | 8 : i | 16;
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity) || (toolbar = getToolbar()) == null) {
            return;
        }
        long j = i2;
        if (this.mToolbarStatus == j) {
            return;
        }
        this.mToolbarStatus = j;
        if (!z) {
            toolbar.setNavigationIcon((Drawable) null);
        } else if (z3) {
            toolbar.setNavigationIcon(C8003R.drawable.ic_back);
            toolbar.setNavigationContentDescription(C8003R.string.action_navigate_up);
        } else {
            if (z2) {
                toolbar.setNavigationIcon(new LayerDrawable(new Drawable[]{ResourcesCompat.getDrawable(toolbar.getContext().getResources(), C8003R.drawable.ic_drawer, null), new DrawerBadgeIcon(toolbar.getContext())}));
            } else {
                toolbar.setNavigationIcon(C8003R.drawable.ic_drawer);
            }
            toolbar.setNavigationContentDescription(BadgeHelper.getDrawerButtonContentDescription(z2));
        }
        initSupportActionBar(appCompatActivity, toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6165a.lambda$setDisplayHomeAsUpEnabledInternal$1(z3, view);
            }
        });
        setToolbarContentInsetsAbsolute(toolbar);
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        MainLogger.m7258i(getTag(), "setDisplayHomeAsUpEnabled : " + z);
        supportActionBar.setDisplayHomeAsUpEnabled(z);
    }

    private void setFloatingToolbarStateListener() {
        if (this.mFloatingToolbarStateListener != null) {
            return;
        }
        C8236b c8236b = new C8236b(this, 0);
        this.mFloatingToolbarStateListener = c8236b;
        this.mAppBar.seslAddAppBarStateChangedListener(c8236b);
    }

    private void setFolderPathLayoutGoneAnimation() {
        if (this.mFolderPathGoneAnimation != null) {
            return;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mFolderPathLayout, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, 0.95f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, 0.95f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.22f, 0.25f, 0.0f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(500L);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.mFolderPathLayout, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 1.0f, 0.0f));
        objectAnimatorOfPropertyValuesHolder2.setDuration(100L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.7
            private void onFinishAnimation() {
                ActionMenuController.this.mMultiFloatingView.setVisibility(8);
                ActionMenuController.this.mFolderPathLayout.setScaleX(1.0f);
                ActionMenuController.this.mFolderPathLayout.setScaleY(1.0f);
                ActionMenuController.this.mFolderPathLayout.onVisibilityGone(true, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NonNull Animator animator) {
                onFinishAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NonNull Animator animator) {
                onFinishAnimation();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NonNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NonNull Animator animator) {
            }
        });
        this.mFolderPathGoneAnimation = animatorSet;
    }

    private void setFolderPathLayoutVisibilityWithoutAnimation(int i) {
        this.mMultiFloatingView.setVisibility(i);
        if (i != 0) {
            this.mFolderPathLayout.onVisibilityGone(true, true);
        }
    }

    private void setFolderPathLayoutVisibleAnimation() {
        if (this.mFolderPathVisibleAnimation != null) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                ActionMenuController.this.mFolderPathLayout.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ActionMenuController.this.mFolderPathLayout.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                ActionMenuController.this.mMultiFloatingView.setVisibility(0);
                ActionMenuController.this.mFolderPathLayout.setAlpha(0.0f);
            }
        });
        duration.addUpdateListener(new C0421a(this, 17));
        ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(450L);
        duration2.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        duration2.addUpdateListener(new C8235a(0, this, DesktopModeCompat.INSTANCE.getInstance().isDexMode(this.mFolderPathLayout.getContext())));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2);
        this.mFolderPathVisibleAnimation = animatorSet;
    }

    private void updateCheckAllTextVisibility(boolean z) {
        final ActionBar supportActionBar;
        if (this.mSelectAllLayout == null || this.mCheckAllText == null) {
            return;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity) || (supportActionBar = appCompatActivity.getSupportActionBar()) == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.2
            @Override // java.lang.Runnable
            public void run() {
                if (ActionMenuController.this.mSelectAllLayout == null) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ActionMenuController.this.mSelectAllLayout.getLayoutParams();
                int height = supportActionBar.getHeight();
                if (height <= 0 || ActionMenuController.this.mAppBar.seslGetAppBarState().getState() >= 4) {
                    height = (int) ResourceUtils.convertDpToPixel(ActionMenuController.this.mSelectAllLayout.getContext(), 48.0f);
                }
                if (height <= 0 || layoutParams.height == height) {
                    return;
                }
                layoutParams.height = height;
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.3
            @Override // java.lang.Runnable
            public void run() {
                if (ActionMenuController.this.mCheckAllText == null) {
                    return;
                }
                int i = ActionMenuController.this.mAppBar.seslGetAppBarState().getState() < 4 ? 0 : 8;
                if (i != ActionMenuController.this.mCheckAllText.getVisibility()) {
                    ActionMenuController.this.mCheckAllText.setVisibility(i);
                }
            }
        };
        if (z) {
            this.mSelectAllLayout.post(runnable);
            this.mCheckAllText.post(runnable2);
        } else {
            runnable.run();
            runnable2.run();
        }
    }

    private void updateCheckInfoText() {
        TextView textView = this.mCheckInfoText;
        if (textView == null) {
            return;
        }
        textView.post(new RunnableC7599e(this, 21));
    }

    private void updateToolbarTitleCompoundDrawableToEndWithView(View view, int i) {
        TextView toolbarTitle = getToolbarTitle();
        if (toolbarTitle == null) {
            return;
        }
        if (view == null) {
            toolbarTitle.setCompoundDrawablesRelative(null, null, null, null);
            return;
        }
        Drawable viewToDrawable = getViewToDrawable(view);
        viewToDrawable.setBounds(0, 0, viewToDrawable.getIntrinsicWidth(), viewToDrawable.getIntrinsicHeight());
        toolbarTitle.setCompoundDrawablePadding(i);
        toolbarTitle.setCompoundDrawablesRelative(null, null, viewToDrawable, null);
    }

    public void enableEditCustomToolbarTitle() {
        CheckBox checkBox = this.mSelectAll;
        if (checkBox != null) {
            checkBox.setChecked(false);
            this.mSelectAll.jumpDrawablesToCurrentState();
            this.mSelectAll = null;
        }
        ViewGroup viewGroup = this.mSelectAllLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.mSelectAllLayout = null;
        }
        TextView textView = this.mCheckInfoText;
        if (textView == null || this.mFragment == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = this.mFragment.getResources().getDimensionPixelSize(C8003R.dimen.note_picker_title_margin_top_bottom);
        layoutParams.leftMargin = isPickEditSearchWidgetMode() ? 0 : this.mFragment.getResources().getDimensionPixelSize(C8003R.dimen.note_picker_title_margin_start_end);
        layoutParams.rightMargin = this.mFragment.getResources().getDimensionPixelSize(C8003R.dimen.note_picker_title_margin_start_end);
        layoutParams.bottomMargin = this.mFragment.getResources().getDimensionPixelSize(C8003R.dimen.note_picker_title_margin_top_bottom);
        this.mCheckInfoText.setLayoutParams(layoutParams);
    }

    public void enableScrollTransitionOfFloating(boolean z) {
        if (this.mFloatingToolbarLayout == null) {
            FragmentActivity activity = this.mFragment.getActivity();
            if (!CommonUtil.isNotAvailableActivity(activity)) {
                this.mFloatingToolbarLayout = (FloatingToolbarLayout) activity.findViewById(C8003R.id.sesl_floating_toolbar_layout);
            }
        }
        FloatingToolbarLayout floatingToolbarLayout = this.mFloatingToolbarLayout;
        if (floatingToolbarLayout != null) {
            floatingToolbarLayout.enableScrollTransition(z, true);
        }
        FloatingTopLayout floatingTopLayout = this.mMultiFloatingView;
        if (floatingTopLayout == null || floatingTopLayout.getVisibility() != 0) {
            return;
        }
        this.mMultiFloatingView.enableScrollTransition(z, true);
    }

    public void finishActionMode() {
        View view = this.mActionModeView;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mActionModeView);
        }
        this.mActionModeView = null;
        updateDrawerIconWithBadge();
    }

    public AppBarLayout getAppBarLayout() {
        AppBarLayout appBarLayout = this.mAppBar;
        if (appBarLayout != null) {
            return appBarLayout;
        }
        if (this.mFragment.getActivity() == null) {
            return null;
        }
        AppBarLayout appBarLayout2 = (AppBarLayout) this.mFragment.getActivity().findViewById(C8003R.id.appbar_layout);
        this.mAppBar = appBarLayout2;
        return appBarLayout2;
    }

    public int getAppBarOffset() {
        return this.mAppBarOffset;
    }

    public FloatingToolbarLayout getFloatingToolbarLayout() {
        return this.mFloatingToolbarLayout;
    }

    public boolean getHasPaddingForFolderpathLayout() {
        FolderPathLayout folderPathLayout = this.mFolderPathLayout;
        return folderPathLayout != null && folderPathLayout.getHasPaddingInActivity();
    }

    public FloatingTopLayout getMultiFloatingView() {
        return this.mMultiFloatingView;
    }

    public String getTag() {
        return TAG;
    }

    public boolean getVerticalOffset() {
        return this.mVerticalOffset;
    }

    public void initExtendedToolbar() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
            return;
        }
        if (this.mCollapsingToolbar == null) {
            this.mCollapsingToolbar = (CollapsingToolbarLayout) appCompatActivity.findViewById(C8003R.id.collapsing_toolbar);
        }
        getAppBarLayout();
        if (this.mAppBar == null) {
            this.mVerticalOffset = false;
        } else if (this.mOffsetUpdateListener == null) {
            OffsetUpdateListener offsetUpdateListener = new OffsetUpdateListener(appCompatActivity) { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.1
                @Override // com.samsung.android.support.senl.p148nt.app.common.listener.OffsetUpdateListener, com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                    super.onOffsetChanged(appBarLayout, i);
                    ActionMenuController.this.mVerticalOffset = i == 0;
                    ActionMenuController.this.mAppBarOffset = appBarLayout.getMeasuredHeight() + i;
                    if (ActionMenuController.this.mAppBar.seslIsCollapsed()) {
                        ActionMenuController.this.mVerticalOffset = false;
                    }
                    if (ActionMenuController.this.mCheckInfoText == null) {
                        return;
                    }
                    if (ActionMenuController.this.mVerticalOffset) {
                        ActionMenuController.this.mCheckInfoText.setImportantForAccessibility(2);
                    } else {
                        ActionMenuController.this.mCheckInfoText.setImportantForAccessibility(1);
                    }
                }
            };
            this.mOffsetUpdateListener = offsetUpdateListener;
            this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) offsetUpdateListener);
        }
        releaseCoeditBetaView();
        releaseCoeditMemberCountView();
        setFloatingToolbarStateListener();
    }

    public void initFolderPathLayoutForImportList(IFolderPathLayoutListener iFolderPathLayoutListener) throws Exception {
        FragmentActivity activity = this.mFragment.getActivity();
        if (this.mFolderPathLayout != null || activity == null || this.mAppBar == null) {
            return;
        }
        if (this.mMultiFloatingView == null) {
            this.mMultiFloatingView = (FloatingTopLayout) activity.findViewById(C8003R.id.multi_floating_bar);
        }
        FloatingTopLayout floatingTopLayout = this.mMultiFloatingView;
        if (floatingTopLayout == null) {
            return;
        }
        floatingTopLayout.setRecyclerView(this.mRecyclerView);
        FolderPathLayout folderPathLayout = (FolderPathLayout) ViewModeUtils.getInflatedView(activity, C8003R.id.folderpath_layout_container, C8003R.id.inflate_folderpath_layout_container);
        this.mFolderPathLayout = folderPathLayout;
        if (folderPathLayout == null) {
            return;
        }
        folderPathLayout.setFolderHomeButtonVisibility(false);
        this.mFolderPathLayout.setIFolderPathLayoutListener(iFolderPathLayoutListener);
        this.mFolderPathLayout.setClipToOutline(true);
        this.mFolderPathLayout.setHasPaddingInActivity(true);
        setFolderPathLayoutVisibility(0, false);
        this.mFolderPathLayout.updateBackgroundColor(C8003R.color.transparent);
    }

    public void initFolderpathLayout(NotesFolder notesFolder, IFolderPathLayoutListener iFolderPathLayoutListener) throws Exception {
        FragmentActivity activity = this.mFragment.getActivity();
        if (this.mFolderPathLayout != null || activity == null || this.mAppBar == null) {
            return;
        }
        if (this.mMultiFloatingView == null) {
            this.mMultiFloatingView = (FloatingTopLayout) activity.findViewById(C8003R.id.multi_floating_bar);
        }
        FloatingTopLayout floatingTopLayout = this.mMultiFloatingView;
        if (floatingTopLayout == null) {
            return;
        }
        floatingTopLayout.setRecyclerView(this.mRecyclerView);
        FolderPathLayout folderPathLayout = (FolderPathLayout) ViewModeUtils.getInflatedView(activity, C8003R.id.folderpath_layout_container, C8003R.id.inflate_folderpath_layout_container);
        this.mFolderPathLayout = folderPathLayout;
        if (folderPathLayout == null) {
            return;
        }
        folderPathLayout.setFolderHomeButtonVisibility(true);
        this.mFolderPathLayout.setIFolderPathLayoutListener(iFolderPathLayoutListener);
        this.mFolderPathLayout.setClipToOutline(true);
        updateCurrentFolderPath(notesFolder, false);
        setFolderPathLayoutVisibleAnimation();
        setFolderPathLayoutGoneAnimation();
        setFolderPathLayoutVisibility(0, true);
        if (this.mAppBar.seslGetAppBarState().getState() > 3) {
            this.mFolderPathLayout.updateBackgroundColor(C8003R.color.transparent);
        } else {
            this.mFolderPathLayout.updateBackgroundColor(C8003R.color.folderpath_bg_color);
        }
        addFolderPathStateChangeListener();
    }

    public boolean isExpandedState() {
        return this.mAppBar.seslGetAppBarState().getState() == 1;
    }

    public boolean isFolderpathLayoutEmpty() {
        return this.mFolderPathLayout == null;
    }

    public boolean isFolderpathLayoutVisible() {
        FolderPathLayout folderPathLayout = this.mFolderPathLayout;
        return folderPathLayout != null && folderPathLayout.getVisibility() == 0;
    }

    public boolean isPickEditSearchWidgetMode() {
        Contract contract = this.mContract;
        if (contract == null) {
            return false;
        }
        return FeatureUtils.isPickEditSearchWidgetMode(contract.getModeIndex());
    }

    public void onDestroy() {
        AppBarLayout.AppBarStateChangedListener appBarStateChangedListener = this.mFloatingToolbarStateListener;
        if (appBarStateChangedListener != null) {
            this.mAppBar.seslRemoveAppBarStateChangedListener(appBarStateChangedListener);
            this.mFloatingToolbarStateListener = null;
        }
        AppBarLayout.AppBarStateChangedListener appBarStateChangedListener2 = this.mMultiFloatingStateListener;
        if (appBarStateChangedListener2 != null) {
            this.mAppBar.seslRemoveAppBarStateChangedListener(appBarStateChangedListener2);
            this.mMultiFloatingStateListener = null;
        }
        AppBarLayout appBarLayout = this.mAppBar;
        if (appBarLayout == null) {
            return;
        }
        appBarLayout.removeOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this.mOffsetUpdateListener);
    }

    public void releaseCoeditBetaView() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
            return;
        }
        updateToolbarTitleCompoundDrawableToEndWithView(null, 0);
        if (this.mSubTitleTextView == null) {
            this.mSubTitleTextView = (TextView) appCompatActivity.findViewById(C8003R.id.collapsing_appbar_extended_subtitle);
        }
        TextView textView = this.mSubTitleTextView;
        if (textView != null) {
            textView.setMaxLines(1);
        }
    }

    public void resetCheckItems() {
        this.mSelectAllLayout = null;
        this.mCheckInfoText = null;
        this.mSelectAll = null;
        this.mCheckAllText = null;
        FloatingToolbarLayout floatingToolbarLayout = this.mFloatingToolbarLayout;
        if (floatingToolbarLayout != null) {
            floatingToolbarLayout.setFloatingAware(null);
        }
    }

    public void setAppbarCollapsedState() {
        this.mAppBar.seslSetCustomHeightProportion(true, 0.0f);
    }

    public void setCoeditBetaView() {
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
            return;
        }
        releaseCoeditBetaView();
        if (this.mSubTitleTextView == null) {
            this.mSubTitleTextView = (TextView) appCompatActivity.findViewById(C8003R.id.collapsing_appbar_extended_subtitle);
        }
        TextView textView = this.mSubTitleTextView;
        if (textView != null) {
            textView.setMaxLines(2);
        }
        updateToolbarTitleCompoundDrawableToEndWithView(LayoutInflater.from(appCompatActivity).inflate(C8003R.layout.notes_coedit_beta_layout, (ViewGroup) null), 0);
    }

    public void setCoeditInfoView(View view) {
        if (CommonUtil.isNotAvailableActivity((AppCompatActivity) this.mFragment.getActivity())) {
            return;
        }
        releaseCoeditBetaView();
        updateToolbarTitleCompoundDrawableToEndWithView(view, 10);
    }

    public void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayHomeAsUpEnabledInternal(z, false, false);
    }

    public void setEnabledSelectAll(boolean z) {
        TextView textView = this.mCheckAllText;
        if (textView != null) {
            textView.setAlpha(z ? 1.0f : 0.4f);
        }
        TextView textView2 = this.mCheckInfoText;
        if (textView2 != null) {
            textView2.setAlpha(z ? 1.0f : 0.4f);
        }
        ViewGroup viewGroup = this.mSelectAllLayout;
        if (viewGroup != null) {
            viewGroup.setEnabled(z);
        }
    }

    public void setExpanded(boolean z, boolean z2) {
        AppBarLayout appBarLayout = this.mAppBar;
        if (appBarLayout == null) {
            return;
        }
        appBarLayout.setExpanded(z, z2);
    }

    public void setFloatingToolbarExpanded(boolean z) {
        AppBarLayout appBarLayout = this.mAppBar;
        if (appBarLayout == null) {
            return;
        }
        appBarLayout.seslSetExpanded(z);
    }

    public void setFolderPathLayoutVisibility(int i, boolean z) {
        AnimatorSet animatorSet;
        MainLogger.m7254d(TAG, "setFolderPathLayoutVisibility#" + i + ", anim : " + z);
        if (this.mMultiFloatingView == null || this.mFolderPathLayout == null) {
            return;
        }
        if (!z) {
            setFolderPathLayoutVisibilityWithoutAnimation(i);
            return;
        }
        AnimatorSet animatorSet2 = this.mFolderPathGoneAnimation;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        if (i == 0 && this.mMultiFloatingView.getVisibility() != 0 && (animatorSet = this.mFolderPathVisibleAnimation) != null) {
            animatorSet.cancel();
            this.mFolderPathVisibleAnimation.start();
            this.mFolderPathLayout.playHomeIcAnimation();
        } else {
            if (i == 0 || this.mMultiFloatingView.getVisibility() != 0 || this.mFolderPathGoneAnimation == null) {
                setFolderPathLayoutVisibilityWithoutAnimation(i);
                return;
            }
            AnimatorSet animatorSet3 = this.mFolderPathVisibleAnimation;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            this.mFolderPathGoneAnimation.start();
            this.mFolderPathLayout.onVisibilityGone(false, true);
        }
    }

    public void setHasPaddingForFolderpathLayout(boolean z) {
        FolderPathLayout folderPathLayout = this.mFolderPathLayout;
        if (folderPathLayout == null) {
            return;
        }
        folderPathLayout.setHasPaddingInActivity(z);
    }

    public void setHideSelectAllCheckbox() {
        CheckBox checkBox = this.mSelectAll;
        if (checkBox != null) {
            checkBox.setChecked(false);
            this.mSelectAll.jumpDrawablesToCurrentState();
            this.mSelectAll = null;
        }
        ViewGroup viewGroup = this.mSelectAllLayout;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            this.mSelectAllLayout = null;
        }
        TextView textView = this.mCheckInfoText;
        if (textView != null) {
            textView.setVisibility(8);
            this.mCheckInfoText = null;
        }
    }

    public void setStartMarginToToolbarTitle(boolean z) {
        Toolbar toolbar = getToolbar();
        if (toolbar == null) {
            return;
        }
        int dimensionPixelSize = z ? toolbar.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_toolbar_title_margin_start_widget) : toolbar.getResources().getDimensionPixelSize(C8003R.dimen.noteslist_toolbar_default_title_margin_start_widget);
        if (dimensionPixelSize == toolbar.getTitleMarginStart()) {
            return;
        }
        toolbar.setTitleMargin(dimensionPixelSize, toolbar.getTitleMarginTop(), toolbar.getTitleMarginEnd(), toolbar.getTitleMarginBottom());
    }

    public void setToolbarContentInsetsAbsolute(Toolbar toolbar) {
        toolbar.setContentInsetsAbsolute(toolbar.getResources().getDimensionPixelSize(C8003R.dimen.tablet_drawer_setting_holder_margin_bottom), toolbar.getContentInsetEnd());
    }

    public void setToolbarCustomSubTitle(View view) {
        MainLogger.m7258i(getTag(), "setToolbarCustomSubTitle#");
        initExtendedToolbar();
        CollapsingToolbarLayout collapsingToolbarLayout = this.mCollapsingToolbar;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.seslSetSubtitle((CharSequence) null);
            if (this.mCollapsingToolbar.seslGetCustomSubtitle() != null) {
                this.mCollapsingToolbar.seslSetCustomSubtitle(null);
            }
            if (view != null) {
                this.mCollapsingToolbar.seslSetCustomSubtitle(view);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                this.mCollapsingToolbar.seslGetCustomSubtitle().setLayoutParams(layoutParams);
            }
        }
    }

    public void setToolbarSubTitle(String str) {
        setToolbarSubTitle(str != null ? Editable.Factory.getInstance().newEditable(str) : null);
    }

    public void setToolbarTitle(String str) {
        setToolbarTitle(str, false);
    }

    public void setVerticalView(View view) {
        OffsetUpdateListener offsetUpdateListener = this.mOffsetUpdateListener;
        if (offsetUpdateListener == null) {
            return;
        }
        offsetUpdateListener.setVerticalView(view);
    }

    public void startActionMode(OnClickSelectAllListener onClickSelectAllListener) {
        startActionMode(onClickSelectAllListener, false);
    }

    public void toggleActionModeToolbar(boolean z) {
        if (this.mActionModeView == null) {
            return;
        }
        AbstractC8014b.m7210l("toggleActionModeToolbar : ", TAG, z);
        if (!z) {
            setHideSelectAllCheckbox();
            resetCheckItems();
            setToolbarTitle(C8003R.string.select_notes);
        } else {
            if (this.mCheckInfoText == null) {
                startActionMode(null, false);
            }
            if (getToolbarTitle() != null) {
                setToolbarTitle((String) null);
            }
            enableEditCustomToolbarTitle();
        }
    }

    public void updateCurrentFolderPath(NotesFolder notesFolder, boolean z) {
        FolderPathLayout folderPathLayout = this.mFolderPathLayout;
        if (folderPathLayout == null) {
            return;
        }
        folderPathLayout.updateCurrentPath(notesFolder, z);
    }

    public void updateDrawerIconWithBadge() {
        if (this.mContract == null) {
            return;
        }
        boolean zHasDrawerIconNewBadge = BadgeHelper.hasDrawerIconNewBadge();
        int modeIndex = this.mContract.getModeIndex();
        if (FeatureUtils.isPickMode(modeIndex)) {
            return;
        }
        MainLogger.m7259w(TAG, "updateDrawerIconWithBadge# hasBadge, " + zHasDrawerIconNewBadge + ", modeIndex: " + modeIndex);
        setDisplayHomeAsUpEnabledInternal(FeatureUtils.isEditMode(modeIndex) ^ true, zHasDrawerIconNewBadge, FeatureUtils.isSearchMode(modeIndex));
    }

    public void updateFolderPathLayoutVisibility(int i) {
        FolderPathLayout folderPathLayout = this.mFolderPathLayout;
        if (folderPathLayout == null) {
            return;
        }
        folderPathLayout.setVisibility(i);
    }

    public void updateSelectedFolderCount(boolean z, int i) {
        AbstractC8014b.m7201c(i, "updateSelectedFolderCount ", getTag());
        if (this.mFragment.getActivity() == null || this.mSelectAll == null || this.mCheckInfoText == null) {
            return;
        }
        if (!this.mRecyclerView.isLongPressed() || this.mRecyclerView.isPenMultiSelectionOn()) {
            this.mFragment.getActivity().invalidateOptionsMenu();
        }
        this.mCheckInfoText.setTag(i == 0 ? this.mFragment.getString(C8003R.string.select_folder) : this.mFragment.getString(C8003R.string.selected_check_info, Integer.valueOf(i)));
        this.mSelectAll.setTag(Integer.valueOf(i));
        this.mSelectAll.setChecked(z);
        this.mSelectAllLayout.setContentDescription(getSelectAllContentDescription(i));
        updateCheckInfoText();
    }

    public void updateSelectedNoteCount(boolean z, int i) {
        String string;
        String strM1615e;
        AbstractC8014b.m7201c(i, "updateSelectedNoteCount ", getTag());
        if (this.mSelectAllLayout != null && this.mSelectAll != null) {
            string = i == 0 ? this.mFragment.getString(C8003R.string.select_notes) : this.mFragment.getString(C8003R.string.selected_check_info, Integer.valueOf(i));
            TextView textView = this.mCheckInfoText;
            if (textView != null) {
                textView.setTag(string);
            }
            this.mSelectAll.setTag(Integer.valueOf(i));
            this.mSelectAll.setChecked(z);
            this.mSelectAllLayout.setContentDescription(getSelectAllContentDescription(i));
        } else if (i == 0) {
            string = this.mFragment.getString(C8003R.string.select_notes);
            TextView textView2 = this.mCheckInfoText;
            if (textView2 != null) {
                textView2.setTag(string);
            }
            FloatingToolbarLayout floatingToolbarLayout = this.mFloatingToolbarLayout;
            if (floatingToolbarLayout != null) {
                floatingToolbarLayout.setFloatingAware(null);
            }
        } else {
            string = this.mFragment.getString(C8003R.string.selected_check_info, Integer.valueOf(i));
            if (LocaleUtils.isRTLMode()) {
                strM1615e = LocaleUtils.convertToArabicNumber(10) + "/" + LocaleUtils.convertToArabicNumber(i);
            } else {
                strM1615e = AbstractC2322a.m1615e(i, "/10");
            }
            TextView textView3 = this.mCheckInfoText;
            if (textView3 != null) {
                textView3.setTag(strM1615e);
            }
            final Toolbar toolbar = getToolbar();
            if (toolbar == null || this.mFloatingToolbarLayout == null || !isPickEditSearchWidgetMode()) {
                FloatingToolbarLayout floatingToolbarLayout2 = this.mFloatingToolbarLayout;
                if (floatingToolbarLayout2 != null) {
                    floatingToolbarLayout2.setFloatingAware(null);
                }
            } else {
                final View navButtonView = toolbar.getNavButtonView();
                if (navButtonView != null) {
                    this.mFloatingToolbarLayout.setFloatingAware(new FloatingAware() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.5
                        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingAware
                        @Nullable
                        public View getReferenceView(@NonNull FloatingAware.PositionType positionType) {
                            if (positionType == FloatingAware.PositionType.START_FIRST) {
                                return navButtonView;
                            }
                            if (positionType == FloatingAware.PositionType.END_FIRST) {
                                return toolbar.seslGetMenuView();
                            }
                            return null;
                        }

                        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingAware
                        @NonNull
                        public Rect getReferenceViewInset(@NonNull FloatingAware.PositionType positionType) {
                            Resources resources = ActionMenuController.this.mFloatingToolbarLayout.getResources();
                            int dimensionPixelSize = ActionMenuController.this.mFragment.getResources().getDimensionPixelSize(C8003R.dimen.note_picker_title_margin_top_bottom);
                            if (positionType == FloatingAware.PositionType.START_FIRST) {
                                return new Rect(resources.getDimensionPixelSize(C8003R.dimen.sesl_projection_bg_navup_start_padding), dimensionPixelSize, ActionMenuController.this.mCheckInfoText == null ? 0 : (-ActionMenuController.this.mFragment.getResources().getDimensionPixelSize(C8003R.dimen.note_picker_title_margin_start_end)) / 2, dimensionPixelSize);
                            }
                            return positionType == FloatingAware.PositionType.START_SECOND ? new Rect() : new Rect(resources.getDimensionPixelSize(C8003R.dimen.sesl_projection_bg_menu_start_padding_inset), dimensionPixelSize, resources.getDimensionPixelSize(C8003R.dimen.sesl_projection_bg_menu_end_padding_inset), dimensionPixelSize);
                        }

                        @Override // com.google.android.material.oneui.floatingactioncontainer.FloatingAware
                        @Nullable
                        public List<View> getReferenceViews(@NonNull FloatingAware.PositionType positionType) {
                            if (positionType == FloatingAware.PositionType.START_FIRST) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(navButtonView);
                                if (ActionMenuController.this.mCheckInfoText != null) {
                                    arrayList.add(ActionMenuController.this.mCheckInfoText);
                                }
                                return arrayList;
                            }
                            if (positionType != FloatingAware.PositionType.END_FIRST) {
                                return null;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(toolbar.seslGetMenuView());
                            return arrayList2;
                        }
                    });
                }
            }
        }
        updateCheckInfoText();
        setToolbarTitle(string);
        this.mFragment.filteredInvalidateOptionsMenu();
    }

    public void setDisplayHomeAsUpEnabled(boolean z, boolean z2) {
        setDisplayHomeAsUpEnabledInternal(z, false, z2);
    }

    public void setToolbarTitle(String str, boolean z) {
        if (this.mFragment.getActivity() == null) {
            return;
        }
        setToolbarTitle(str != null ? Editable.Factory.getInstance().newEditable(str) : null, z);
    }

    public void startActionMode(OnClickSelectAllListener onClickSelectAllListener, boolean z) {
        FragmentActivity activity = this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        if (this.mActionModeView != null) {
            initSelectAllLayout(onClickSelectAllListener, z);
            updateCheckAllTextVisibility(false);
            return;
        }
        Toolbar toolbar = getToolbar();
        if (toolbar == null) {
            return;
        }
        setDisplayHomeAsUpEnabled(false);
        View viewInflate = LayoutInflater.from(activity).inflate(C8003R.layout.noteslist_action_mode_layout, (ViewGroup) null, false);
        this.mActionModeView = viewInflate;
        toolbar.addView(viewInflate);
        this.mActionModeView.setVisibility(0);
        initSelectAllLayout(onClickSelectAllListener, z);
        updateCheckAllTextVisibility(false);
    }

    public void setToolbarSubTitle(Editable editable) {
        MainLogger.m7258i(getTag(), "setToolbarSubTitle# subTitle : " + ((Object) editable));
        initExtendedToolbar();
        CollapsingToolbarLayout collapsingToolbarLayout = this.mCollapsingToolbar;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.seslSetSubtitle(editable);
        }
    }

    public void updateCurrentFolderPath(String[] strArr) {
        FolderPathLayout folderPathLayout = this.mFolderPathLayout;
        if (folderPathLayout == null) {
            return;
        }
        folderPathLayout.updateCurrentPath(strArr);
    }

    public void setToolbarTitle(int i) {
        setToolbarTitle(i, false);
    }

    public void setToolbarTitle(int i, boolean z) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
            return;
        }
        setToolbarTitle(Editable.Factory.getInstance().newEditable(appCompatActivity.getResources().getString(i)), z);
    }

    private void setToolbarTitle(Editable editable, boolean z) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.mFragment.getActivity();
        if (CommonUtil.isNotAvailableActivity(appCompatActivity)) {
            return;
        }
        MainLogger.m7258i(getTag(), "setToolbarTitle# title : " + MainLogger.getEncode(String.valueOf(editable)));
        Toolbar toolbar = getToolbar();
        if (toolbar != null && toolbar.getVisibility() == 4) {
            toolbar.setVisibility(0);
        }
        initSupportActionBar(appCompatActivity, toolbar);
        initExtendedToolbar();
        CollapsingToolbarLayout collapsingToolbarLayout = this.mCollapsingToolbar;
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(editable);
        }
        if (this.mCheckInfoText != null || z) {
            editable = Editable.Factory.getInstance().newEditable("");
        }
        ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(editable);
        }
    }
}
