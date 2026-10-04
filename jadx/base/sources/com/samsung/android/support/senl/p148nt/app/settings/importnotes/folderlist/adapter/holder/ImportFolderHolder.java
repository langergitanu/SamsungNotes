package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.adapter.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/adapter/holder/ImportFolderHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mName", "Landroid/widget/TextView;", "mTime", "mCheckBox", "Landroid/widget/CheckBox;", "mIcon", "Landroid/widget/ImageView;", "mContainer", "Landroid/widget/LinearLayout;", "mItemContainer", "mAccessibilityFocused", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportFolderHolder extends RecyclerView.ViewHolder {

    @JvmField
    public boolean mAccessibilityFocused;

    @JvmField
    @Nullable
    public final CheckBox mCheckBox;

    @JvmField
    @NotNull
    public final LinearLayout mContainer;

    @JvmField
    @NotNull
    public final ImageView mIcon;

    @JvmField
    @NotNull
    public final LinearLayout mItemContainer;

    @JvmField
    @NotNull
    public final TextView mName;

    @JvmField
    @NotNull
    public final TextView mTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportFolderHolder(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(C8003R.id.name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mName = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(C8003R.id.time);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.mTime = (TextView) viewFindViewById2;
        this.mCheckBox = (CheckBox) itemView.findViewById(C8003R.id.checkbox);
        View viewFindViewById3 = itemView.findViewById(C8003R.id.icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.mIcon = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(C8003R.id.file_picker_item_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.mContainer = (LinearLayout) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(C8003R.id.item_container);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.mItemContainer = (LinearLayout) viewFindViewById5;
    }
}
