package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.tag;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TagListView implements HashTagContract.View {
    private static final String TAG = Logger.createTag("TagListView");
    private LinearLayoutManager mLinearLayoutManager;
    private HashTagContract.Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private SineInOut33 mSineInOut33;
    private SineInOut70 mSineInOut70;
    private TagAdapter mTagAdapter;

    public Animator getHideAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagListView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TagListView.this.mRecyclerView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimatorOfFloat;
    }

    public Animator getShowAnimator() {
        int iFindLastVisibleItemPosition = this.mLinearLayoutManager.findLastVisibleItemPosition();
        Logger.m10999d(TAG, String.valueOf(iFindLastVisibleItemPosition));
        this.mRecyclerView.setAlpha(1.0f);
        this.mRecyclerView.requestLayout();
        AnimatorSet animatorSet = new AnimatorSet();
        for (int i = 0; i <= iFindLastVisibleItemPosition; i++) {
            final View childAt = this.mLinearLayoutManager.getChildAt(i);
            if (childAt != null) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(80, 0);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagListView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        childAt.setTranslationX(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                valueAnimatorOfInt.setInterpolator(this.mSineInOut70);
                valueAnimatorOfInt.setDuration(250L);
                long j = ((long) i) * 50;
                valueAnimatorOfInt.setStartDelay(j);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagListView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        childAt.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                valueAnimatorOfFloat.setInterpolator(this.mSineInOut33);
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.setStartDelay(j);
                childAt.setAlpha(0.0f);
                animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfFloat);
            }
        }
        return animatorSet;
    }

    public int getTag() {
        return ((Integer) this.mRecyclerView.getTag()).intValue();
    }

    public View getView() {
        return this.mRecyclerView;
    }

    public int getVisibility() {
        return this.mRecyclerView.getVisibility();
    }

    public void init(ViewGroup viewGroup, HashTagContract.Presenter presenter, float f) {
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(C9086R.id.comp_title_tag_list);
        this.mRecyclerView = recyclerView;
        recyclerView.setAlpha(f);
        this.mPresenter = presenter;
        presenter.setView(this);
        TagAdapter tagAdapter = new TagAdapter(this.mPresenter, this.mRecyclerView.getResources());
        this.mTagAdapter = tagAdapter;
        tagAdapter.setTagList(this.mPresenter.getTagList());
        this.mRecyclerView.setAdapter(this.mTagAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        this.mLinearLayoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(this.mLinearLayoutManager);
        this.mSineInOut33 = new SineInOut33();
        this.mSineInOut70 = new SineInOut70();
        this.mRecyclerView.setTag(Integer.valueOf(C9086R.drawable.comp_title_tag_item_background));
    }

    public boolean isDarkTheme() {
        return this.mTagAdapter.isDarkTheme();
    }

    public void setDarkTheme(boolean z) {
        this.mTagAdapter.setDarkTheme(z);
    }

    public void setEditable(boolean z) {
        this.mTagAdapter.setEditable(z);
    }

    public void setVisibility(int i) {
        this.mRecyclerView.setVisibility(i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.hashtag.HashTagContract.View
    public void updateTagListView() {
        List<String> tagList = this.mPresenter.getTagList();
        if (tagList == null || tagList.isEmpty()) {
            this.mRecyclerView.setVisibility(8);
            return;
        }
        this.mRecyclerView.setVisibility(0);
        TagAdapter tagAdapter = (TagAdapter) this.mRecyclerView.getAdapter();
        if (tagAdapter != null) {
            tagAdapter.setTagList(this.mPresenter.getTagList());
            tagAdapter.notifyDataSetChanged();
        }
    }
}
