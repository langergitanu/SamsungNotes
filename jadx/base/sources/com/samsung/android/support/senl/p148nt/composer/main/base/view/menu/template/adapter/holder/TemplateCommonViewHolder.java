package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TemplateCommonViewHolder extends RecyclerView.ViewHolder {
    protected final CheckBox mCheckBox;
    protected final ImageView mCustomIcon;
    protected final TextView mDetailTextView;
    protected final View mDetailView;
    protected final ImageView mDownloadButton;
    protected final OnItemActionListener mItemActionListener;
    protected final ImageView mTemplateImage;
    protected final View mTemplateItemContainer;
    protected final TextView mTemplateName;
    protected final View mView;
    protected final int mViewType;

    public TemplateCommonViewHolder(@NonNull View view, int i, OnItemActionListener onItemActionListener) {
        super(view);
        this.mViewType = i;
        this.mItemActionListener = onItemActionListener;
        this.mView = view;
        this.mTemplateItemContainer = view.findViewById(C9086R.id.comp_template_item_container);
        this.mTemplateImage = (ImageView) view.findViewById(C9086R.id.comp_template_item_image);
        this.mTemplateName = (TextView) view.findViewById(C9086R.id.comp_template_item_name);
        CheckBox checkBox = (CheckBox) view.findViewById(C9086R.id.comp_template_item_checkbox);
        this.mCheckBox = checkBox;
        ImageView imageView = (ImageView) view.findViewById(C9086R.id.comp_template_item_download_btn);
        this.mDownloadButton = imageView;
        View viewFindViewById = view.findViewById(C9086R.id.comp_template_item_detail_layout);
        this.mDetailView = viewFindViewById;
        this.mDetailTextView = (TextView) view.findViewById(C9086R.id.comp_template_item_detail_text);
        this.mCustomIcon = (ImageView) view.findViewById(C9086R.id.comp_template_custom_item_icon);
        ViewCompat.getInstance().setTooltipText(checkBox);
        ViewCompat.getInstance().setTooltipText(imageView);
        ViewCompat.getInstance().setTooltipText(viewFindViewById);
    }

    private void updateTargetViewSizeToPageRatio(View view, float f) {
        if (view == null) {
            return;
        }
        Resources resources = view.getContext().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.change_template_item_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(C9086R.dimen.change_template_item_height);
        if (1.0f < f) {
            dimensionPixelSize = (int) (dimensionPixelSize2 / f);
        } else {
            dimensionPixelSize2 = (int) (dimensionPixelSize * f);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize2;
        view.setLayoutParams(layoutParams);
    }

    public abstract String getTemplateImageContentDescription(TemplateItem templateItem);

    public abstract void onBind(TemplateItem templateItem);

    public void updateTemplateImageSize(float f) {
        updateTargetViewSizeToPageRatio(this.mTemplateImage, f);
    }
}
