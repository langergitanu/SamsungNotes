package com.samsung.android.support.senl.p148nt.composer.main.cover.adapter;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BadgeListAdapter extends RecyclerView.Adapter<BadgeViewHolder> {
    public static final int HIDE_ANIM = 2;
    public static final int NONE_ANIM = -1;
    public static final int SHOW_ANIM = 1;
    private static final String TAG = Logger.createCoverTag("BadgeListAdapter");
    private final List<Pair<String, Integer>> mCategoryList;
    private final ImageView mPreview;
    private PreviewContract mPreviewContract;
    private int mSelectedPosition = 0;
    private int mAnimOption = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BadgeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static final int TRANSITION_DURATION = 400;
        private Contract mContract;
        private int mCurrentPosition;
        ImageView mImageView;
        private final ImageView mPreview;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public interface Contract {
            void setSelectPosition(int i);
        }

        public BadgeViewHolder(@NonNull View view, ImageView imageView) {
            super(view);
            ImageView imageView2 = (ImageView) view.findViewById(C9086R.id.badge_view_holder);
            this.mImageView = imageView2;
            this.mPreview = imageView;
            imageView2.setOnClickListener(this);
        }

        public void hideAnimation(int i) {
            int i2 = i == 0 ? -50 : i * (-100);
            if (LocaleUtils.isRTLMode()) {
                i2 = -i2;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, i2, 0.0f, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
            this.mImageView.setAnimation(translateAnimation);
            translateAnimation.start();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view instanceof ImageView) {
                this.mPreview.setImageDrawable(((ImageView) view).getDrawable());
            }
            this.mPreview.setTag(view.getTag());
            this.mImageView.setSelected(true);
            this.mImageView.setBackgroundResource(C9086R.drawable.cover_editor_badge_item_select);
            this.mContract.setSelectPosition(this.mCurrentPosition);
        }

        public void setContract(Contract contract) {
            this.mContract = contract;
        }

        public void setImageResource(Pair<String, Integer> pair, int i, int i2) {
            this.mImageView.setImageDrawable(CoverEditorUtils.getCategoryDrawable(this.itemView.getContext(), (String) pair.first));
            if (i2 != i) {
                this.mImageView.setBackgroundResource(C9086R.drawable.cover_editor_badge_item_unselect);
                this.mImageView.setSelected(false);
            } else {
                this.mImageView.setBackgroundResource(C9086R.drawable.cover_editor_badge_item_select);
                this.mImageView.setSelected(true);
            }
            this.mImageView.setContentDescription(this.itemView.getResources().getString(((Integer) pair.second).intValue()));
            this.mImageView.setTag(pair.first);
            this.mCurrentPosition = i;
        }

        public void showAnimation(int i) {
            int i2 = i == 0 ? -50 : i * (-100);
            if (LocaleUtils.isRTLMode()) {
                i2 = -i2;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(i2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
            this.mImageView.setAnimation(translateAnimation);
            translateAnimation.start();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PreviewContract {
        void onSelectPosition(String str);
    }

    public BadgeListAdapter(List<Pair<String, Integer>> list, String str, View view) {
        this.mCategoryList = list;
        this.mPreview = (ImageView) view;
        initSelectedPosition(str);
    }

    private void initSelectedPosition(String str) {
        if (str == null) {
            return;
        }
        String strReplaceAll = str.replaceAll(" ", "");
        this.mSelectedPosition = this.mCategoryList.size() - 1;
        for (int i = 0; i < this.mCategoryList.size(); i++) {
            if (((String) this.mCategoryList.get(i).first).equalsIgnoreCase(strReplaceAll)) {
                this.mSelectedPosition = i;
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mCategoryList.size();
    }

    public int getSelectedPosition() {
        return this.mSelectedPosition;
    }

    public void setAnimOption(int i) {
        this.mAnimOption = i;
    }

    public void setPreviewContract(PreviewContract previewContract) {
        this.mPreviewContract = previewContract;
    }

    public void updateSelectedHolder(String str) {
        notifyItemChanged(this.mSelectedPosition);
        initSelectedPosition(str);
        notifyItemChanged(this.mSelectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull BadgeViewHolder badgeViewHolder, int i) {
        badgeViewHolder.setContract(new BadgeViewHolder.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.adapter.BadgeListAdapter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.cover.adapter.BadgeListAdapter.BadgeViewHolder.Contract
            public void setSelectPosition(int i2) {
                String str = BadgeListAdapter.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i2, "setSelectPosition# position : ", ", mSelectedPosition : ");
                sbM778t.append(BadgeListAdapter.this.mSelectedPosition);
                Logger.m10999d(str, sbM778t.toString());
                if (BadgeListAdapter.this.mSelectedPosition != -1) {
                    BadgeListAdapter badgeListAdapter = BadgeListAdapter.this;
                    badgeListAdapter.notifyItemChanged(badgeListAdapter.mSelectedPosition);
                }
                BadgeListAdapter.this.mSelectedPosition = i2;
                BadgeListAdapter.this.mPreviewContract.onSelectPosition((String) ((Pair) BadgeListAdapter.this.mCategoryList.get(i2)).first);
            }
        });
        badgeViewHolder.setImageResource(this.mCategoryList.get(i), i, this.mSelectedPosition);
        int i2 = this.mAnimOption;
        if (i2 == 1) {
            badgeViewHolder.showAnimation(i);
        } else if (i2 == 2) {
            badgeViewHolder.hideAnimation(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public BadgeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BadgeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.cover_badge_item_view, viewGroup, false), this.mPreview);
    }
}
