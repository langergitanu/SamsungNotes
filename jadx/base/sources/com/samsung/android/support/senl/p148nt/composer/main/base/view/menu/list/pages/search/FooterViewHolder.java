package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.search;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FooterViewHolder extends RecyclerView.ViewHolder {
    public FooterViewHolder(@NonNull View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(C9086R.id.clear_search_history);
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(textView.getContext())) {
            textView.setBackgroundResource(C9086R.drawable.recent_search_button_shape_bg);
            textView.setTextColor(view.getContext().getResources().getColor(C9086R.color.recent_search_list_clear_history_text_color_btn_shape, null));
        }
        CharUtils.applyTextSizeUntilLargeSize(textView.getContext(), textView, 16.0f);
    }
}
