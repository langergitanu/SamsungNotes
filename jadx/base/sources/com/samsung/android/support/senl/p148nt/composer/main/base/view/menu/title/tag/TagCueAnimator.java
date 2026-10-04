package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.tag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut80;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TagCueAnimator {
    private static final String TAG = Logger.createTag("TagCueAnimator");
    private AnimatorSet mAnimator;
    private View mContainer;
    private AnimatorSet mExcludedTagAnimatorSet;
    private int mLastToolbarVisibility;
    private LinearLayoutManager mLinearLayoutManager;
    private View mParentLockView;
    private HashTagContract.Presenter mPresenter;
    private SineInOut33 mSineInOut33;
    private SineInOut70 mSineInOut70;
    private SineInOut80 mSineInOut80;
    private View mTagContainer;
    private RecyclerView mTagRecyclerView;
    private ImageView mTitleCoverView;
    private View mToolbar;

    private Animator createTagItemsAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        this.mTagRecyclerView.setAlpha(0.0f);
        this.mTagRecyclerView.requestLayout();
        int iFindLastVisibleItemPosition = this.mLinearLayoutManager.findLastVisibleItemPosition();
        Logger.m10999d(TAG, "createTagItemsAnimator# " + iFindLastVisibleItemPosition);
        final ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.9f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (View view : arrayList) {
                    view.setScaleX(fFloatValue);
                    view.setScaleY(fFloatValue);
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                TagCueAnimator.this.mTagRecyclerView.setAlpha(1.0f);
                int iFindLastVisibleItemPosition2 = TagCueAnimator.this.mLinearLayoutManager.findLastVisibleItemPosition();
                for (int i = 0; i <= iFindLastVisibleItemPosition2; i++) {
                    View childAt = TagCueAnimator.this.mLinearLayoutManager.getChildAt(i);
                    if (childAt != null) {
                        childAt.setScaleX(0.9f);
                        childAt.setScaleY(0.9f);
                        childAt.setAlpha(0.0f);
                        arrayList.add(childAt);
                    }
                }
            }
        });
        valueAnimatorOfFloat.setInterpolator(this.mSineInOut70);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setStartDelay(400L);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((View) it.next()).setAlpha(fFloatValue);
                }
            }
        });
        valueAnimatorOfFloat2.setInterpolator(this.mSineInOut33);
        valueAnimatorOfFloat2.setDuration(150L);
        valueAnimatorOfFloat2.setStartDelay(400L);
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        return animatorSet;
    }

    private void initExcludedTagAnimatorSet(int i, final int i2) {
        this.mExcludedTagAnimatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = TagCueAnimator.this.mContainer.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                TagCueAnimator.this.mContainer.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setDuration(300L);
        valueAnimatorOfInt.setInterpolator(this.mSineInOut80);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.3f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TagCueAnimator.this.mParentLockView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(this.mSineInOut33);
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i2, i);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.LayoutParams layoutParams = TagCueAnimator.this.mContainer.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                TagCueAnimator.this.mContainer.setLayoutParams(layoutParams);
                TagCueAnimator.this.mTagContainer.setTranslationY(layoutParams.height - i2);
            }
        });
        valueAnimatorOfInt2.setDuration(300L);
        valueAnimatorOfInt2.setStartDelay(1300L);
        valueAnimatorOfInt2.setInterpolator(this.mSineInOut80);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.3f, 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TagCueAnimator.this.mParentLockView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat2.setDuration(300L);
        valueAnimatorOfFloat2.setStartDelay(1300L);
        valueAnimatorOfFloat2.setInterpolator(this.mSineInOut33);
        this.mExcludedTagAnimatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfFloat, valueAnimatorOfInt2, valueAnimatorOfFloat2);
    }

    private void initRecyclerView() {
        this.mTagRecyclerView.setAlpha(0.0f);
        TagAdapter tagAdapter = new TagAdapter(this.mPresenter, this.mTagRecyclerView.getResources());
        tagAdapter.setTagList(this.mPresenter.getTagList());
        tagAdapter.setEditable(false);
        this.mTagRecyclerView.setAdapter(tagAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mTagRecyclerView.getContext());
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mTagRecyclerView.setLayoutManager(this.mLinearLayoutManager);
        this.mTagRecyclerView.setTag(Integer.valueOf(C9086R.drawable.comp_title_tag_item_background));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndState() {
        this.mTagContainer.setTranslationY(0.0f);
        this.mContainer.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mParentLockView.getLayoutParams();
        layoutParams.setMargins(0, this.mParentLockView.getResources().getDimensionPixelSize(C9086R.dimen.comp_actionbar_height), 0, 0);
        layoutParams.addRule(3, C9086R.id.comp_title_container);
        this.mParentLockView.setVisibility(8);
        this.mTitleCoverView.setVisibility(0);
        if (this.mToolbar.getVisibility() == 0) {
            Drawable drawable = this.mTitleCoverView.getDrawable();
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                final Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                this.mTitleCoverView.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 == null || bitmap2.isRecycled()) {
                            return;
                        }
                        Logger.m10999d(TagCueAnimator.TAG, "recycle bitmap");
                        bitmap.recycle();
                    }
                });
            }
            this.mTitleCoverView.setImageBitmap(null);
        }
    }

    public void animate() {
        Resources resources = this.mToolbar.getResources();
        int height = this.mToolbar.getVisibility() != 0 ? 0 : this.mToolbar.getHeight();
        int dimensionPixelSize = (resources.getDimensionPixelSize(C9086R.dimen.comp_title_tag_cue_animation_vertical_margin) * 2) + resources.getDimensionPixelSize(C9086R.dimen.comp_title_tag_item_height) + height;
        if (this.mExcludedTagAnimatorSet == null || this.mLastToolbarVisibility != this.mToolbar.getVisibility()) {
            initExcludedTagAnimatorSet(height, dimensionPixelSize);
            this.mLastToolbarVisibility = this.mToolbar.getVisibility();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimator = animatorSet;
        animatorSet.playTogether(createTagItemsAnimator(), this.mExcludedTagAnimatorSet);
        this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagCueAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TagCueAnimator.this.setEndState();
                TagCueAnimator.this.mAnimator = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TagCueAnimator.this.setEndState();
                TagCueAnimator.this.mAnimator = null;
            }
        });
        this.mAnimator.start();
    }

    public void cancel() {
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void init(ViewGroup viewGroup, View view, View view2, HashTagContract.Presenter presenter) {
        this.mContainer = viewGroup;
        this.mToolbar = view;
        this.mParentLockView = view2;
        this.mTitleCoverView = (ImageView) viewGroup.findViewById(C9086R.id.comp_title_tag_cue_animation_title);
        this.mTagContainer = viewGroup.findViewById(C9086R.id.comp_title_tag_cue_animation_tag_list_container);
        this.mTagRecyclerView = (RecyclerView) viewGroup.findViewById(C9086R.id.comp_title_tag_cue_animation_tag_list);
        this.mPresenter = presenter;
        initRecyclerView();
        this.mSineInOut33 = new SineInOut33();
        this.mSineInOut80 = new SineInOut80();
        this.mSineInOut70 = new SineInOut70();
    }

    public boolean isAnimating() {
        AnimatorSet animatorSet = this.mAnimator;
        return animatorSet != null && animatorSet.isRunning();
    }

    public boolean ready(boolean z) {
        List<String> tagList;
        if (this.mTagRecyclerView.getAdapter() != null && (tagList = this.mPresenter.getTagList()) != null && !tagList.isEmpty()) {
            ((TagAdapter) this.mTagRecyclerView.getAdapter()).setDarkTheme(z);
            TagAdapter tagAdapter = (TagAdapter) this.mTagRecyclerView.getAdapter();
            if (tagAdapter != null) {
                tagAdapter.setTagList(this.mPresenter.getTagList());
                tagAdapter.notifyDataSetChanged();
            }
            RecyclerView recyclerView = this.mTagRecyclerView;
            recyclerView.scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);
            if (this.mToolbar.getBackground() instanceof ColorDrawable) {
                this.mContainer.setBackgroundColor(((ColorDrawable) this.mToolbar.getBackground()).getColor());
            }
            if (this.mToolbar.getVisibility() != 0) {
                this.mTitleCoverView.setVisibility(8);
            } else if (this.mToolbar.getHeight() >= 0 && this.mToolbar.getWidth() >= 0) {
                this.mTitleCoverView.setVisibility(0);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.mToolbar.getWidth(), this.mToolbar.getHeight(), Bitmap.Config.ARGB_8888);
                this.mToolbar.draw(new Canvas(bitmapCreateBitmap));
                this.mTitleCoverView.setImageBitmap(bitmapCreateBitmap);
            }
            this.mContainer.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mParentLockView.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.addRule(3, C9086R.id.comp_title_tag_cue_animation_container);
            this.mParentLockView.setVisibility(0);
            return true;
        }
        return false;
    }
}
