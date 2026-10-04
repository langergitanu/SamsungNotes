package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.search;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public HeaderViewHolder(@NonNull View view) {
        super(view);
        ((TextView) view.findViewById(C9086R.id.header_title)).setContentDescription(view.getContext().getResources().getString(C9086R.string.recent_search) + SQLKeyword.COMMA + view.getContext().getResources().getString(C9086R.string.base_string_header));
    }
}
