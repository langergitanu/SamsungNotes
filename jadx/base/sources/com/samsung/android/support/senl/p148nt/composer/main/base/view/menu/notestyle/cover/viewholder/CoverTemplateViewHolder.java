package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006\u00126\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\tJ\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0004H\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverTemplateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "templateMap", "", "", "", "", "selectCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "templateUuid", "", "<init>", "(Landroid/view/View;Ljava/util/Map;Lkotlin/jvm/functions/Function2;)V", "containerView", "templateView", "marginView", "borderView", "coverLineView", "Landroid/widget/ImageView;", "selectedTypeIndex", "selectedColor", "bind", "selectedPosition", "typeIndex", "color", "updateWidth", "setAccessibility", "setSelectedTemplate", "isSelected", "", "onClick", VPathDataCmd.RCurveTo, "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverTemplateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @NotNull
    public static final String TAG = "CoverTemplateViewHolder";

    @NotNull
    private final View borderView;

    @NotNull
    private final View containerView;

    @NotNull
    private final ImageView coverLineView;

    @NotNull
    private final View marginView;

    @NotNull
    private final Function2<Integer, String, Unit> selectCallback;

    @NotNull
    private String selectedColor;
    private int selectedTypeIndex;

    @NotNull
    private final Map<Integer, List<String>> templateMap;

    @NotNull
    private final View templateView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoverTemplateViewHolder(@NotNull View itemView, @NotNull Map<Integer, ? extends List<String>> templateMap, @NotNull Function2<? super Integer, ? super String, Unit> selectCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(templateMap, "templateMap");
        Intrinsics.checkNotNullParameter(selectCallback, "selectCallback");
        this.templateMap = templateMap;
        this.selectCallback = selectCallback;
        View viewFindViewById = itemView.findViewById(C9086R.id.cover_style_template_item_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.containerView = viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(C9086R.id.cover_style_template_item_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.templateView = viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(C9086R.id.cover_style_template_item_margin_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.marginView = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(C9086R.id.cover_style_template_item_border);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.borderView = viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(C9086R.id.cover_style_template_item_cover_line);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.coverLineView = (ImageView) viewFindViewById5;
        this.selectedColor = "";
        viewFindViewById2.setOnClickListener(this);
    }

    private final void setAccessibility() {
        this.templateView.setContentDescription(this.itemView.getResources().getString(C9086R.string.ai_cover_style) + " " + (getPosition() + 1));
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.templateView);
    }

    private final void setSelectedTemplate(boolean isSelected) {
        ViewGroup.LayoutParams layoutParams = this.marginView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(isSelected ? C9086R.dimen.cover_editor_new_template_item_margin_select : C9086R.dimen.cover_editor_new_template_item_margin_unselect);
        marginLayoutParams.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.marginView.setLayoutParams(marginLayoutParams);
        this.borderView.setVisibility(isSelected ? 0 : 8);
        this.templateView.setSelected(isSelected);
    }

    private final void updateWidth() {
        ViewGroup.LayoutParams layoutParams = this.containerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Pair pairM13893to = this.selectedTypeIndex == CoverStyleConstants.CoverType.TEXT.ordinal() ? TuplesKt.m13893to(Integer.valueOf(C9086R.dimen.cover_style_template_item_width_4_span), Integer.valueOf(C9086R.dimen.cover_style_template_item_margin_vertical_4_span)) : TuplesKt.m13893to(Integer.valueOf(C9086R.dimen.cover_style_template_item_width_3_span), Integer.valueOf(C9086R.dimen.cover_style_template_item_margin_vertical_3_span));
        int iIntValue = ((Number) pairM13893to.component1()).intValue();
        int iIntValue2 = ((Number) pairM13893to.component2()).intValue();
        marginLayoutParams.width = this.itemView.getResources().getDimensionPixelSize(iIntValue);
        int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(iIntValue2);
        marginLayoutParams.setMargins(0, dimensionPixelSize, 0, dimensionPixelSize);
        this.containerView.setLayoutParams(marginLayoutParams);
    }

    public final void bind(int position, int selectedPosition, int typeIndex, @NotNull String color) {
        String str;
        Intrinsics.checkNotNullParameter(color, "color");
        this.selectedTypeIndex = typeIndex;
        this.selectedColor = color;
        List<String> list = this.templateMap.get(Integer.valueOf(typeIndex));
        if (list == null || (str = list.get(position)) == null) {
            return;
        }
        updateWidth();
        this.templateView.setBackground(CoverEditorUtils.getTemplateDrawable(this.itemView.getContext(), str, this.selectedColor));
        this.templateView.setSelected(position == selectedPosition);
        setSelectedTemplate(this.templateView.isSelected());
        this.coverLineView.setVisibility(this.selectedTypeIndex == CoverStyleConstants.CoverType.TEXT.ordinal() ? 8 : 0);
        setAccessibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int bindingAdapterPosition = getBindingAdapterPosition();
        List<String> list = this.templateMap.get(Integer.valueOf(this.selectedTypeIndex));
        List<String> list2 = list;
        if (list2 == null || list2.isEmpty() || bindingAdapterPosition < 0 || bindingAdapterPosition >= list2.size()) {
            return;
        }
        String str = list.get(bindingAdapterPosition);
        Logger.m10999d(TAG, "onClick# position : " + bindingAdapterPosition + ", templateUuid : " + str);
        setSelectedTemplate(true);
        this.selectCallback.invoke(Integer.valueOf(bindingAdapterPosition), str);
    }
}
