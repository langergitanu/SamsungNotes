package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.C0419R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Landroidx/appcompat/widget/SeslArrayAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "resource", "", "(Landroid/content/Context;I)V", "mInitPaddingBottom", "mInitPaddingTop", "getDropDownView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "appcompat_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SeslArrayAdapter extends ArrayAdapter<Object> {
    private int mInitPaddingBottom;
    private int mInitPaddingTop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeslArrayAdapter(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = super.getDropDownView(position, convertView, parent);
        if (convertView == null) {
            this.mInitPaddingTop = view.getPaddingTop();
            this.mInitPaddingBottom = view.getPaddingBottom();
        }
        int dimensionPixelSize = view.getResources().getDimensionPixelSize(C0419R.dimen.sesl_popup_menu_first_last_item_vertical_edge_padding);
        int i = this.mInitPaddingTop + dimensionPixelSize;
        int i2 = this.mInitPaddingBottom + dimensionPixelSize;
        int paddingLeft = view.getPaddingLeft();
        if (position != 0) {
            i = this.mInitPaddingTop;
        }
        int paddingRight = view.getPaddingRight();
        if (position != getCount() - 1) {
            i2 = this.mInitPaddingBottom;
        }
        view.setPadding(paddingLeft, i, paddingRight, i2);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }
}
