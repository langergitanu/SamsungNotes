package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.search;

import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.view.HoverCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ItemViewHolder extends RecyclerView.ViewHolder {
    private final ImageView mDeleteButton;
    private final LinearLayout mItemContainer;
    private final TextView mKeywordView;
    private final TextView mUpdateTimeView;

    public ItemViewHolder(View view) {
        super(view);
        this.mKeywordView = (TextView) view.findViewById(C9086R.id.keyword);
        this.mUpdateTimeView = (TextView) view.findViewById(C9086R.id.update_time);
        this.mItemContainer = (LinearLayout) view.findViewById(C9086R.id.contents_container);
        ImageView imageView = (ImageView) view.findViewById(C9086R.id.delete_button);
        this.mDeleteButton = imageView;
        imageView.setColorFilter(view.getContext().getResources().getColor(C9086R.color.notes_clear_search_icon_color, null), PorterDuff.Mode.SRC_ATOP);
        HoverCompat.getInstance().setPopupType(imageView, 1);
    }

    public ImageView getDeleteButton() {
        return this.mDeleteButton;
    }

    public LinearLayout getItemContainer() {
        return this.mItemContainer;
    }

    public TextView getKeywordView() {
        return this.mKeywordView;
    }

    public TextView getUpdateTimeView() {
        return this.mUpdateTimeView;
    }
}
