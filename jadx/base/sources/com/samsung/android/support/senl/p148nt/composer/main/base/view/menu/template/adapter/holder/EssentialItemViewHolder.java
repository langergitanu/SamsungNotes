package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.data.TemplateItem;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.listener.OnItemActionListener;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAManager;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EssentialItemViewHolder extends TemplateCommonViewHolder {
    private static final String TAG = CTLogger.createTag("TemplateItemViewHolder");

    public EssentialItemViewHolder(View view, int i, OnItemActionListener onItemActionListener) {
        super(view, i, onItemActionListener);
    }

    private void updateImageTemplateTint(TemplateItem templateItem) {
        if (templateItem.getType() != 10) {
            return;
        }
        String string = this.mTemplateImage.getContext().getString(C9086R.string.change_tempalte_default_image_template_oxford);
        if (DesktopModeCompat.INSTANCE.getInstance().isNotDexModeOrStandAloneMode(this.mTemplateImage.getContext())) {
            if (templateItem.getName().equals(string)) {
                return;
            }
            this.mTemplateImage.setColorFilter(ContextCompat.getColor(this.mTemplateImage.getContext(), C9086R.color.change_template_essential_template_tint_color));
            return;
        }
        if (!templateItem.getName().equals(string)) {
            this.mTemplateImage.setColorFilter(ContextCompat.getColor(this.mTemplateImage.getContext(), C9086R.color.change_template_essential_template_tint_color_dex));
        } else {
            if (ContextUtils.isNightMode(this.mTemplateImage.getContext())) {
                return;
            }
            ImageView imageView = this.mTemplateImage;
            imageView.setImageDrawable(imageView.getContext().getDrawable(C9086R.drawable.change_template_essential_item_oxford_dex));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.TemplateCommonViewHolder
    public String getTemplateImageContentDescription(TemplateItem templateItem) {
        Resources resources = this.mTemplateImage.getContext().getResources();
        if (templateItem.getType() == 10 || templateItem.getType() == 11) {
            StringBuilder sb = new StringBuilder();
            AbstractC8014b.m7202d(resources, C9086R.string.change_template_type_basic, sb, " ");
            sb.append(resources.getString(C9086R.string.change_template_essential_menu));
            sb.append(" ");
            sb.append(templateItem.getName());
            return sb.toString();
        }
        if (templateItem.getType() == 13 || templateItem.getType() == 14) {
            StringBuilder sb2 = new StringBuilder();
            AbstractC8014b.m7202d(resources, C9086R.string.change_template_type_academic, sb2, " ");
            sb2.append(resources.getString(C9086R.string.change_template_essential_menu));
            sb2.append(" ");
            sb2.append(templateItem.getName());
            return sb2.toString();
        }
        if (templateItem.getType() == 16 || templateItem.getType() == 17) {
            StringBuilder sb3 = new StringBuilder();
            AbstractC8014b.m7202d(resources, C9086R.string.change_template_type_planners, sb3, " ");
            sb3.append(resources.getString(C9086R.string.change_template_essential_menu));
            sb3.append(" ");
            sb3.append(templateItem.getName());
            return sb3.toString();
        }
        if (templateItem.getType() == 19 || templateItem.getType() == 20) {
            StringBuilder sb4 = new StringBuilder();
            AbstractC8014b.m7202d(resources, C9086R.string.change_template_type_journal, sb4, " ");
            sb4.append(resources.getString(C9086R.string.change_template_essential_menu));
            sb4.append(" ");
            sb4.append(templateItem.getName());
            return sb4.toString();
        }
        StringBuilder sb5 = new StringBuilder();
        AbstractC8014b.m7202d(resources, C9086R.string.change_template_type_creative, sb5, " ");
        sb5.append(resources.getString(C9086R.string.change_template_essential_menu));
        sb5.append(" ");
        sb5.append(templateItem.getName());
        return sb5.toString();
    }

    public void initDetailViewOnBind(final TemplateItem templateItem) {
        this.mDetailView.setVisibility(0);
        this.mDetailView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.EssentialItemViewHolder.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
                if (UserInputSkipper.isValidEvent(tag)) {
                    UserInputSkipper.setHoldingEventTime(1000L, tag);
                    EssentialItemViewHolder essentialItemViewHolder = EssentialItemViewHolder.this;
                    essentialItemViewHolder.mItemActionListener.onShowTemplatePreviewDialog(essentialItemViewHolder.mDetailView.getContext(), templateItem);
                }
            }
        });
        int pageCount = templateItem.getPageCount();
        if (pageCount >= 100000) {
            this.mDetailTextView.setText(String.format(Locale.getDefault(), "%.0fk", Float.valueOf(pageCount / 1000.0f)));
        } else {
            this.mDetailTextView.setText(ContentUtils.convertToArabicNumber(pageCount));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter.holder.TemplateCommonViewHolder
    public void onBind(final TemplateItem templateItem) {
        Logger.m11000e(TAG, "onBind");
        this.mTemplateImage.setContentDescription(getTemplateImageContentDescription(templateItem));
        this.mTemplateImage.setSelected(templateItem.getSelected());
        if (TextUtils.isEmpty(templateItem.getDrawablePath())) {
            this.mTemplateImage.setImageResource(templateItem.getDrawableResId());
        } else {
            this.mTemplateImage.setImageBitmap(BitmapFactory.decodeFile(templateItem.getDrawablePath()));
        }
        updateTemplateImageSize(this.mTemplateImage.getDrawable().getIntrinsicHeight() / this.mTemplateImage.getDrawable().getIntrinsicWidth());
        updateImageTemplateTint(templateItem);
        this.mTemplateName.setText(templateItem.getName());
        if (templateItem.getSelected()) {
            this.mTemplateName.setTextAppearance(C9086R.style.RobotoBoldStyle);
        } else {
            this.mTemplateName.setTextAppearance(C9086R.style.RobotoRegularStyle);
        }
        String string = this.mTemplateImage.getContext().getResources().getString(C9086R.string.download);
        final boolean zIsPdfType = TemplateViewType.isPdfType(templateItem.getType());
        if (zIsPdfType) {
            string = templateItem.getName() + " " + string;
        }
        this.mDownloadButton.setContentDescription(string);
        if (templateItem.getMode() == 0) {
            this.mTemplateImage.setEnabled(true);
            this.mTemplateImage.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.EssentialItemViewHolder.1
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Logger.m10999d(EssentialItemViewHolder.TAG, "onClick#");
                    boolean z = zIsPdfType;
                    EssentialItemViewHolder.this.mItemActionListener.onSelectTemplate(z ? 1 : 0, templateItem);
                }
            });
            if (zIsPdfType) {
                initDetailViewOnBind(templateItem);
                this.mDownloadButton.setVisibility(4);
                this.mDownloadButton.setOnClickListener(null);
                return;
            }
            return;
        }
        this.mTemplateImage.setEnabled(false);
        this.mTemplateImage.setOnClickListener(null);
        if (zIsPdfType) {
            this.mDetailView.setVisibility(8);
            this.mDownloadButton.setVisibility(0);
            this.mDownloadButton.setEnabled(true);
            this.mDownloadButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.adapter.holder.EssentialItemViewHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
                    if (UserInputSkipper.isValidEvent(tag)) {
                        UserInputSkipper.setHoldingEventTime(1000L, tag);
                        SAManager.INSTANCE.onDownloadDefaultPdf();
                        EssentialItemViewHolder essentialItemViewHolder = EssentialItemViewHolder.this;
                        if (essentialItemViewHolder.mItemActionListener.onDownloadTemplate(essentialItemViewHolder.mDownloadButton.getContext(), templateItem)) {
                            EssentialItemViewHolder.this.mDownloadButton.setEnabled(false);
                        }
                    }
                }
            });
        }
    }
}
