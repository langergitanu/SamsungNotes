package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.page;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.image.C8971a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.util.CustomAccessibilityDelegate;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageRatioSettingView {
    private static final String TAG = Logger.createTag("PageRatioSettingView");
    private TextView mPageRatio;
    private ListPopupWindow mPageRatioListPopupWindow;
    private Presenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageRatioItem {

        @DrawableRes
        int mDrawableRes;

        @StringRes
        int mStringRes;
        DocumentPageRatio.PageRatioType mType;

        public PageRatioItem(DocumentPageRatio.PageRatioType pageRatioType, int i, int i2) {
            this.mType = pageRatioType;
            this.mStringRes = i;
            this.mDrawableRes = i2;
        }

        public int getDrawableRes() {
            return this.mDrawableRes;
        }

        public int getStringRes() {
            return this.mStringRes;
        }

        public DocumentPageRatio.PageRatioType getType() {
            return this.mType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Presenter {
        DocumentPageRatio.PageRatioType getPageRatio();

        void setPageRatio(DocumentPageRatio.PageRatioType pageRatioType);
    }

    private void initPageRatio(final Context context, View view) {
        View viewFindViewById = view.findViewById(C9086R.id.page_setting_page_ratio_container);
        viewFindViewById.setVisibility(0);
        this.mPageRatio = (TextView) view.findViewById(C9086R.id.page_setting_page_ratio_text);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new PageRatioItem(DocumentPageRatio.PageRatioType.A4_PORTRAIT, C9086R.string.page_layout_setting_portrait, C9086R.drawable.ic_page_layout_setting_ratio_portrait));
        arrayList.add(new PageRatioItem(DocumentPageRatio.PageRatioType.LONG, C9086R.string.page_layout_setting_long, C9086R.drawable.ic_page_layout_setting_ratio_long));
        updatePageRatio(arrayList);
        final int color = context.getResources().getColor(C9086R.color.composer_default_text_color, null);
        this.mPageRatioListPopupWindow = new ListPopupWindow(context);
        OptionMenuPopupWindowHelper.setDefaultState(this.mPageRatioListPopupWindow, new ArrayAdapter<PageRatioItem>(context, C9086R.layout.comp_page_setting_ratio_list_item, arrayList) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.page.PageRatioSettingView.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            @NonNull
            public View getView(int i, View view2, @NonNull ViewGroup viewGroup) {
                String str;
                LinearLayout linearLayout = view2 instanceof LinearLayout ? (LinearLayout) view2 : (LinearLayout) LayoutInflater.from(context).inflate(C9086R.layout.comp_page_setting_ratio_list_item, (ViewGroup) null);
                PageRatioItem pageRatioItem = (PageRatioItem) getItem(i);
                TextView textView = (TextView) linearLayout.findViewById(C9086R.id.page_setting_page_ratio_list_item_text);
                ImageView imageView = (ImageView) linearLayout.findViewById(C9086R.id.page_setting_page_ratio_list_item_img);
                if (pageRatioItem != null) {
                    textView.setText(pageRatioItem.getStringRes());
                    imageView.setImageResource(pageRatioItem.getDrawableRes());
                }
                View viewFindViewById2 = linearLayout.findViewById(C9086R.id.page_setting_page_ratio_list_item_check);
                if (pageRatioItem == null || !pageRatioItem.mType.equals(PageRatioSettingView.this.mPresenter.getPageRatio())) {
                    imageView.setSelected(false);
                    textView.setTextColor(color);
                    viewFindViewById2.setVisibility(4);
                    str = textView.getResources().getString(C9086R.string.rich_text_font_color_popup_not_selected) + SQLKeyword.COMMA;
                } else {
                    int color2 = textView.getResources().getColor(C9086R.color.notes_primary_color, null);
                    imageView.setSelected(true);
                    textView.setTextColor(color2);
                    viewFindViewById2.setVisibility(0);
                    str = textView.getResources().getString(C9086R.string.rich_text_font_color_popup_selected) + SQLKeyword.COMMA;
                }
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                sbM1324q.append((Object) textView.getText());
                textView.setAccessibilityDelegate(new CustomAccessibilityDelegate(textView.getText().toString(), sbM1324q.toString()));
                return linearLayout;
            }
        }, (Activity) context);
        this.mPageRatioListPopupWindow.setOnItemClickListener(new C8971a(this, arrayList, 2));
        this.mPageRatioListPopupWindow.setAnchorView(view.findViewById(C9086R.id.page_setting_page_ratio_button));
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC8556a(this, 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageRatio$0(List list, AdapterView adapterView, View view, int i, long j) {
        this.mPresenter.setPageRatio(((PageRatioItem) adapterView.getAdapter().getItem(i)).getType());
        this.mPageRatioListPopupWindow.dismiss();
        updatePageRatio(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPageRatio$1(View view) {
        this.mPageRatioListPopupWindow.show();
    }

    private void updatePageRatio(List<PageRatioItem> list) {
        DocumentPageRatio.PageRatioType pageRatio = this.mPresenter.getPageRatio();
        for (PageRatioItem pageRatioItem : list) {
            if (pageRatioItem.getType().equals(pageRatio)) {
                this.mPageRatio.setText(pageRatioItem.getStringRes());
                return;
            }
        }
    }

    public void init(Activity activity, ViewGroup viewGroup, Presenter presenter) {
        this.mPresenter = presenter;
        initPageRatio(activity, View.inflate(activity, C9086R.layout.comp_page_ratio_setting_layout, viewGroup));
    }

    public void release() {
        Logger.m10999d(TAG, "release#");
    }
}
