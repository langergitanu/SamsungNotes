package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.tag;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TagAdapter extends RecyclerView.Adapter<TagHolder> {
    private HashTagContract.Presenter mPresenter;
    private Float mTagFontSize;
    private List<String> tagList;
    private boolean mIsEditable = true;
    private boolean mDarkTheme = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TagHolder extends RecyclerView.ViewHolder {
        ImageButton deleteBtn;
        LinearLayout tagNameContainer;
        LinearLayout tagNameContainerBackground;
        TextView tagNameView;

        public TagHolder(@NonNull View view) {
            super(view);
            this.tagNameContainerBackground = (LinearLayout) view.findViewById(C9086R.id.comp_title_tag_container_background);
            this.tagNameContainer = (LinearLayout) view.findViewById(C9086R.id.comp_title_tag_container);
            this.tagNameView = (TextView) view.findViewById(C9086R.id.comp_title_tag_name);
            this.deleteBtn = (ImageButton) view.findViewById(C9086R.id.comp_title_tag_delete_btn);
        }
    }

    public TagAdapter(HashTagContract.Presenter presenter, Resources resources) {
        this.mPresenter = presenter;
        initFontSize(resources);
    }

    private void initFontSize(Resources resources) {
        Float fValueOf = Float.valueOf(CommonUtil.getFontSizeByPx(resources, C9086R.dimen.comp_title_tag_item_text_height, C9086R.dimen.comp_title_tag_item_text_size));
        this.mTagFontSize = fValueOf;
        if (fValueOf.floatValue() < 0.0f) {
            this.mTagFontSize = Float.valueOf(resources.getDimension(C9086R.dimen.comp_title_tag_item_text_size));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tagList.size();
    }

    public boolean isDarkTheme() {
        return this.mDarkTheme;
    }

    public void setDarkTheme(boolean z) {
        this.mDarkTheme = z;
    }

    public void setEditable(boolean z) {
        this.mIsEditable = z;
    }

    public void setTagList(List<String> list) {
        this.tagList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull TagHolder tagHolder, int i) {
        final String str = this.tagList.get(i);
        tagHolder.tagNameView.setText(str);
        tagHolder.tagNameView.setTextSize(0, this.mTagFontSize.floatValue());
        tagHolder.tagNameContainer.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TagAdapter.this.mPresenter.onHashTagClicked(view.getContext(), str);
                if (TagAdapter.this.mIsEditable) {
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_TAG);
                } else {
                    ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_TAG);
                }
            }
        });
        tagHolder.deleteBtn.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.tag.TagAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TagAdapter.this.mPresenter.onHashTagRemoved(str);
                int iIndexOf = TagAdapter.this.tagList.indexOf(str);
                if (iIndexOf >= 0) {
                    TagAdapter.this.tagList.remove(iIndexOf);
                    TagAdapter.this.notifyItemRemoved(iIndexOf);
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_REMOVE_TAG, str);
                }
            }
        });
        if (this.mIsEditable) {
            tagHolder.deleteBtn.setVisibility(0);
        } else {
            tagHolder.deleteBtn.setVisibility(8);
        }
        int color = this.mDarkTheme ? ContextCompat.getColor(tagHolder.tagNameContainerBackground.getContext(), C9086R.color.composer_title_tag_item_dark_bg_color) : ContextCompat.getColor(tagHolder.tagNameContainerBackground.getContext(), C9086R.color.composer_title_tag_item_bg_color);
        tagHolder.tagNameContainerBackground.getBackground().clearColorFilter();
        tagHolder.tagNameContainerBackground.getBackground().setColorFilter(color, PorterDuff.Mode.DST_ATOP);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public TagHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TagHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C9086R.layout.comp_title_tag_item_layout, viewGroup, false));
    }
}
