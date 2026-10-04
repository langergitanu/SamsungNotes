package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.directwrite.item.DwMenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DirectWriteContainerLayout extends AbsToolbarContainerLayout {
    private static final String PREF_KEY_DIRECT_WRITE_TOOLBAR_CLOSE = "direct_write_toolbar_close_state";
    private static final String PREF_KEY_DIRECT_WRITE_TOOLBAR_X = "direct_write_toolbar_pos_x";
    private static final String PREF_KEY_DIRECT_WRITE_TOOLBAR_Y = "direct_write_toolbar_pos_y";
    private static final String TAG = Logger.createTag("ToolbarDirectWriteContainerLayout");
    private HashMap<Integer, DwMenuItem> mMenuItemMap;

    public DirectWriteContainerLayout(Context context) {
        super(context);
        this.mMenuItemMap = new HashMap<>();
        init(context);
    }

    private List<Animator> addEnterAnimation(PathInterpolator pathInterpolator, LinearInterpolator linearInterpolator) {
        View viewFindViewById = findViewById(C9086R.id.dw_toolbar_menu_item_enter);
        View viewFindViewById2 = findViewById(C9086R.id.dw_enter_icon);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFindViewById, "scaleX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(700L);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewFindViewById, "scaleY", 0.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(700L);
        objectAnimatorOfFloat2.setInterpolator(pathInterpolator);
        viewFindViewById2.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(viewFindViewById2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setDuration(200L);
        objectAnimatorOfFloat3.setStartDelay(300L);
        objectAnimatorOfFloat3.setInterpolator(linearInterpolator);
        ArrayList arrayList = new ArrayList();
        arrayList.add(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        return arrayList;
    }

    private List<Animator> addStretchAnimation(final View view, PathInterpolator pathInterpolator, LinearInterpolator linearInterpolator) {
        view.setPivotX(getStretchPivotX(view));
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(pathInterpolator);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setStartDelay(400L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.DirectWriteContainerLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setBackground(DirectWriteContainerLayout.this.getResources().getDrawable(C9086R.drawable.comp_direct_write_floating_menu_background, DirectWriteContainerLayout.this.getContext().getTheme()));
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(objectAnimatorOfFloat);
        if (this.mMenuItemMap.isEmpty()) {
            Logger.m11004w(TAG, "addStretchAnimation# menu item empty");
            return arrayList;
        }
        for (Map.Entry<Integer, DwMenuItem> entry : this.mMenuItemMap.entrySet()) {
            if (entry.getKey().intValue() != 16 && entry.getValue() != null) {
                arrayList.add(getIconAlphaAnimator(entry.getValue().getView(), linearInterpolator));
            }
        }
        return arrayList;
    }

    private ObjectAnimator getIconAlphaAnimator(View view, LinearInterpolator linearInterpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, view.getAlpha());
        view.setAlpha(0.0f);
        objectAnimatorOfFloat.setInterpolator(linearInterpolator);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.setStartDelay(500L);
        return objectAnimatorOfFloat;
    }

    private int getStretchPivotX(View view) {
        if (LocaleUtils.isRTLMode()) {
            return getResources().getDimensionPixelSize(C9086R.dimen.comp_dw_toolbar_enter_size) / 2;
        }
        int width = view.getWidth();
        if (width == 0) {
            view.measure(0, 0);
            width = view.getMeasuredWidth();
        }
        return width - (getResources().getDimensionPixelSize(C9086R.dimen.comp_dw_toolbar_enter_size) / 2);
    }

    private void visibleWithAnimation(boolean z) {
        AbstractC8014b.m7224z("visibleWithAnimation ", TAG, z);
        if (!z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final View viewFindViewById = findViewById(C9086R.id.dw_toolbar_menu_item_container);
        setBackground(null);
        PathInterpolator pathInterpolator = new PathInterpolator(0.17f, 0.89f, 0.32f, 1.05f);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.directwrite.DirectWriteContainerLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                DirectWriteContainerLayout directWriteContainerLayout = DirectWriteContainerLayout.this;
                directWriteContainerLayout.setBackground(directWriteContainerLayout.getResources().getDrawable(C9086R.drawable.comp_direct_write_floating_menu_background, DirectWriteContainerLayout.this.getContext().getTheme()));
                viewFindViewById.setPivotX(0.0f);
                viewFindViewById.setBackground(null);
                Logger.m11003i(DirectWriteContainerLayout.TAG, "visibleWithAnimation end");
            }
        });
        animatorSet.playTogether(addEnterAnimation(pathInterpolator, linearInterpolator));
        animatorSet.playTogether(addStretchAnimation(viewFindViewById, pathInterpolator, linearInterpolator));
        animatorSet.start();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout
    public void dispatchLongPress(MotionEvent motionEvent) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public String getChildName() {
        return getClass().getSimpleName();
    }

    public void hide() {
        if (isShowing()) {
            visibleWithAnimation(false);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public void init(Context context) {
        super.init(context);
        this.pref_key_toolbar_x = PREF_KEY_DIRECT_WRITE_TOOLBAR_X;
        this.pref_key_toolbar_y = PREF_KEY_DIRECT_WRITE_TOOLBAR_Y;
        boolean z = this.mIsTabletLayout;
        this.mInitialPositionX = z ? 0.55f : 0.1f;
        this.mInitialPositionY = z ? 0.1f : 0.05f;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout
    public boolean isShowing() {
        boolean z = getVisibility() == 0;
        Logger.m11003i(TAG, "isShowing visibility " + getVisibility());
        return z;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i4, int i5) {
        super.onLayout(z, i, i2, i4, i5);
        if (z) {
            setEndEdgeSize(i4 - i);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, com.samsung.android.support.senl.p148nt.base.winset.view.floater.IFloater
    public void onLongPress() {
    }

    public void setMenuItemMap(HashMap<Integer, DwMenuItem> map) {
        if (!this.mMenuItemMap.isEmpty()) {
            this.mMenuItemMap.clear();
        }
        this.mMenuItemMap.putAll(map);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AbsToolbarContainerLayout, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        AbstractC8014b.m7217s(i, "setVisibility ", TAG);
    }

    public void show() {
        super.updateRelayoutPosition();
        visibleWithAnimation(true);
    }

    public DirectWriteContainerLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuItemMap = new HashMap<>();
        init(context);
    }

    public DirectWriteContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMenuItemMap = new HashMap<>();
        init(context);
    }

    public DirectWriteContainerLayout(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMenuItemMap = new HashMap<>();
        init(context);
    }
}
