package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.viewholder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fBa\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\u00126\u0010\n\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tJ\b\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\n\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/viewholder/CoverColorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "colorList", "", "Landroid/util/Pair;", "", "", "selectCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "colorUuid", "", "<init>", "(Landroid/view/View;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "colorView", "colorBorder", "bind", "selectedPosition", "setAccessibility", "getSelectedBackground", "Landroid/graphics/drawable/Drawable;", "setSelectedColor", "isSelected", "", "onClick", VPathDataCmd.RCurveTo, "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @NotNull
    public static final String TAG = "CoverColorViewHolder";

    @NotNull
    private final View colorBorder;

    @NotNull
    private final List<Pair<String, Integer>> colorList;

    @NotNull
    private final View colorView;

    @NotNull
    private final Function2<Integer, String, Unit> selectCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoverColorViewHolder(@NotNull View itemView, @NotNull List<? extends Pair<String, Integer>> colorList, @NotNull Function2<? super Integer, ? super String, Unit> selectCallback) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        Intrinsics.checkNotNullParameter(selectCallback, "selectCallback");
        this.colorList = colorList;
        this.selectCallback = selectCallback;
        View viewFindViewById = itemView.findViewById(C9086R.id.cover_style_color_item_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.colorView = viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(C9086R.id.cover_style_color_item_border);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.colorBorder = viewFindViewById2;
        viewFindViewById.setOnClickListener(this);
    }

    private final Drawable getSelectedBackground(String colorUuid) {
        Drawable drawableMutate = this.colorView.getBackground().mutate();
        Intrinsics.checkNotNull(drawableMutate, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) drawableMutate;
        if (!StringsKt.m14162r(colorUuid, CoverConstants.COLOR_SET) && !Intrinsics.areEqual(colorUuid, "DEFAULT:///")) {
            layerDrawable.setTint(CoverEditorUtils.getBackgroundColor(this.itemView.getContext(), colorUuid));
            return layerDrawable;
        }
        int[] colorSet = CoverEditorUtils.getColorSet(colorUuid);
        layerDrawable.findDrawableByLayerId(C9086R.id.cover_color_set_first).setTint(ContextCompat.getColor(this.itemView.getContext(), colorSet[0]));
        layerDrawable.findDrawableByLayerId(C9086R.id.cover_color_set_second).setTint(ContextCompat.getColor(this.itemView.getContext(), colorSet[1]));
        layerDrawable.findDrawableByLayerId(C9086R.id.cover_color_set_third).setTint(ContextCompat.getColor(this.itemView.getContext(), colorSet[2]));
        return layerDrawable;
    }

    private final void setAccessibility() {
        View view = this.colorView;
        Resources resources = this.itemView.getResources();
        Object second = this.colorList.get(getPosition()).second;
        Intrinsics.checkNotNullExpressionValue(second, "second");
        view.setContentDescription(resources.getString(((Number) second).intValue()));
        ViewCompat.INSTANCE.getInstance().setTooltipText(this.colorView);
    }

    private final void setSelectedColor(boolean isSelected) {
        this.colorBorder.setVisibility(isSelected ? 0 : 8);
        this.colorView.setSelected(isSelected);
    }

    public final void bind(int position, int selectedPosition) {
        String str = (String) this.colorList.get(position).first;
        View view = this.colorView;
        Intrinsics.checkNotNull(str);
        view.setBackground(getSelectedBackground(str));
        this.colorView.setSelected(position == selectedPosition);
        setSelectedColor(this.colorView.isSelected());
        setAccessibility();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        int bindingAdapterPosition = getBindingAdapterPosition();
        if (bindingAdapterPosition < 0 || bindingAdapterPosition >= this.colorList.size()) {
            return;
        }
        String str = (String) this.colorList.get(bindingAdapterPosition).first;
        Logger.m10999d(TAG, "onClick# position : " + bindingAdapterPosition + ", colorUuid : " + str);
        setSelectedColor(true);
        Function2<Integer, String, Unit> function2 = this.selectCallback;
        Integer numValueOf = Integer.valueOf(bindingAdapterPosition);
        Intrinsics.checkNotNull(str);
        function2.invoke(numValueOf, str);
    }
}
