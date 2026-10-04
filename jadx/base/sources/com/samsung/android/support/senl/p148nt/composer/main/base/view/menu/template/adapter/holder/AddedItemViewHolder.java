package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.PopupMenu;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AddedItemViewHolder extends TemplateCommonViewHolder {
    private static final String TAG = CTLogger.createTag("AddedItemViewHolder");
    public Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int addSelectedItem(TemplateItem templateItem);

        boolean isSelectedItem(TemplateItem templateItem);

        int removeSelectedItem(TemplateItem templateItem);

        void updateMode(int i);
    }

    public AddedItemViewHolder(View view, int i, OnItemActionListener onItemActionListener, Contract contract) {
        super(view, i, onItemActionListener);
        this.mContract = contract;
    }

    private void decorateCustomDefaultItem(TemplateItem templateItem, boolean z) {
        this.mCustomIcon.setVisibility(0);
        this.mCustomIcon.setAlpha(z ? 0.5f : 1.0f);
        this.mCheckBox.setVisibility(8);
        updateTemplateImage(templateItem, "decorateCustomDefaultItem");
        this.mTemplateImage.setEnabled(!z);
        this.mTemplateImage.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddedItemViewHolder.this.onClickDefaultItem(view);
            }
        });
        updateTemplateImageSize(this.mTemplateImage.getDrawable().getIntrinsicHeight() / this.mTemplateImage.getDrawable().getIntrinsicWidth());
        updateTemplateItemContainerParentSize();
    }

    private void decorateCustomImageTemplate(TemplateItem templateItem, boolean z) {
        decorateCustomItem(templateItem);
        decorateCustomItemMode(templateItem, z);
        this.mCustomIcon.setVisibility(4);
        updateTemplateImage(templateItem, "decorateCustomImageTemplate");
        this.mTemplateImage.setEnabled(true);
        Drawable drawable = this.mTemplateImage.getDrawable();
        updateTemplateImageSize(drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth());
        updateTemplateItemContainerParentSize();
    }

    private void decorateCustomItem(TemplateItem templateItem) {
        Resources resources = this.mTemplateImage.getContext().getResources();
        this.mTemplateImage.setSelected(templateItem.getSelected());
        this.mTemplateImage.setBackgroundColor(resources.getColor(C9086R.color.change_template_added_item_bg_color, null));
        this.mTemplateImage.setContentDescription(getTemplateImageContentDescription(templateItem));
        this.mTemplateName.setText(templateItem.getName());
        if (templateItem.getSelected()) {
            this.mTemplateName.setTextAppearance(C9086R.style.RobotoBoldStyle);
        } else {
            this.mTemplateName.setTextAppearance(C9086R.style.RobotoRegularStyle);
        }
    }

    private void decorateCustomItemMode(final TemplateItem templateItem, boolean z) {
        if (!z) {
            this.mCheckBox.setVisibility(8);
            this.mTemplateImage.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.m10999d(AddedItemViewHolder.TAG, "onClick# template");
                    AddedItemViewHolder.this.mItemActionListener.onSelectTemplate(1, templateItem);
                }
            });
            this.mTemplateImage.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.4
                private void enterEditMode() {
                    AddedItemViewHolder.this.mContract.updateMode(3);
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (templateItem.getMode() == 3) {
                        return true;
                    }
                    Logger.m10999d(AddedItemViewHolder.TAG, "onLongClick# template");
                    enterEditMode();
                    return AddedItemViewHolder.this.onLongClick(templateItem.getType());
                }
            });
        } else {
            this.mCheckBox.setChecked(this.mContract.isSelectedItem(templateItem));
            this.mCheckBox.setVisibility(0);
            this.mTemplateImage.setEnabled(true);
            this.mTemplateImage.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.m10999d(AddedItemViewHolder.TAG, "onClick# template");
                    int iRemoveSelectedItem = AddedItemViewHolder.this.mCheckBox.isChecked() ? AddedItemViewHolder.this.mContract.removeSelectedItem(templateItem) : AddedItemViewHolder.this.mContract.addSelectedItem(templateItem);
                    AddedItemViewHolder.this.mCheckBox.setChecked(!r0.isChecked());
                    AddedItemViewHolder.this.onItemClicked(iRemoveSelectedItem);
                }
            });
        }
    }

    private void decorateCustomPDFTemplate(TemplateItem templateItem, boolean z) {
        decorateCustomItem(templateItem);
        decorateCustomItemMode(templateItem, z);
        this.mCustomIcon.setVisibility(4);
        updateTemplateImage(templateItem, "decorateCustomPDFTemplate");
        this.mTemplateImage.setEnabled(true);
        Drawable drawable = this.mTemplateImage.getDrawable();
        updateTemplateImageSize(drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth());
        updateTemplateItemContainerParentSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickDefaultItem(View view) {
        PopupMenu popupMenu = new PopupMenu(view.getContext(), ((ViewGroup) view.getParent()).findViewById(C9086R.id.comp_template_custom_item_icon), 8388611);
        popupMenu.getMenuInflater().inflate(C9086R.menu.settings_template_change_custom_item_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.AddedItemViewHolder.5
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
                if (!UserInputSkipper.isValidEvent(tag)) {
                    return true;
                }
                UserInputSkipper.setHoldingEventTime(1000L, tag);
                if (itemId == C9086R.id.image) {
                    AddedItemViewHolder.this.mItemActionListener.onAddTemplate(false);
                    return true;
                }
                if (itemId != C9086R.id.pdf) {
                    return false;
                }
                AddedItemViewHolder.this.mItemActionListener.onAddTemplate(true);
                return true;
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClicked(int i) {
        this.mItemActionListener.onItemClicked(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onLongClick(int i) {
        this.mItemActionListener.onItemLongPressed(i);
        return false;
    }

    private void updateTemplateImage(TemplateItem templateItem, String str) {
        if (templateItem == null || this.mTemplateImage == null) {
            return;
        }
        String drawablePath = templateItem.getDrawablePath();
        if (!TextUtils.isEmpty(drawablePath) && FileUtils.isFileExists(drawablePath)) {
            this.mTemplateImage.setImageBitmap(BitmapFactory.decodeFile(drawablePath));
            return;
        }
        if (templateItem.getDrawableResId() > 0) {
            this.mTemplateImage.setImageResource(templateItem.getDrawableResId());
            return;
        }
        this.mTemplateImage.setImageResource(C9086R.drawable.comp_template_pdf_load_failed);
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("updateTemplateImage# caller: ", str, ", DrawablePath is wrong: ");
        sbM15l.append(Logger.getEncode(templateItem.getDrawablePath()));
        Logger.m11000e(str2, sbM15l.toString());
    }

    private void updateTemplateItemContainerParentSize() {
        Resources resources = this.mTemplateItemContainer.getContext().getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.change_template_item_width);
        float pageRatio = DocumentPageRatio.PageRatioType.A4_PORTRAIT.getPageRatio();
        int dimensionPixelSize2 = pageRatio < 1.0f ? (int) (dimensionPixelSize * pageRatio) : resources.getDimensionPixelSize(C9086R.dimen.change_template_item_height);
        ViewGroup.LayoutParams layoutParams = this.mTemplateItemContainer.getLayoutParams();
        layoutParams.height = dimensionPixelSize2;
        this.mTemplateItemContainer.setLayoutParams(layoutParams);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.TemplateCommonViewHolder
    public String getTemplateImageContentDescription(TemplateItem templateItem) {
        return BaseUtils.getContext().getString(C9086R.string.change_template_added_menu);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.TemplateCommonViewHolder
    public void onBind(TemplateItem templateItem) {
        int type = templateItem.getType();
        String str = TAG;
        Logger.m11000e(str, "onBind, itemType " + templateItem.getWidth() + " /" + templateItem.getHeight());
        boolean z = templateItem.getMode() == 3;
        if (type == 25) {
            decorateCustomDefaultItem(templateItem, z);
            return;
        }
        if (type == 3) {
            decorateCustomImageTemplate(templateItem, z);
        } else {
            if (type == 5) {
                decorateCustomPDFTemplate(templateItem, z);
                return;
            }
            Logger.m11000e(str, "onBind, unexpected itemType Used: " + type);
        }
    }
}
