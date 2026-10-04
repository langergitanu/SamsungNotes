package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter.BaseTemplatePresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplatePagerAdapter extends PagerAdapter {
    private static final String TAG = CTLogger.createTag("TemplatePagerAdapter");
    private static final int TEMPLATE_PAGE_COUNT = 6;
    private final BaseTemplatePresenter mBaseTemplatePresenter;
    private final Context mContext;
    private int mPageCount = 6;

    public TemplatePagerAdapter(Context context, BaseTemplatePresenter baseTemplatePresenter) {
        this.mContext = context;
        this.mBaseTemplatePresenter = baseTemplatePresenter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mPageCount;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        if (i == 0) {
            return this.mContext.getString(C9086R.string.change_template_type_basic);
        }
        if (i == 1) {
            return this.mContext.getString(C9086R.string.change_template_type_academic);
        }
        if (i == 2) {
            return this.mContext.getString(C9086R.string.change_template_type_planners);
        }
        if (i == 3) {
            return this.mContext.getString(C9086R.string.change_template_type_journal);
        }
        if (i == 4) {
            return this.mContext.getString(C9086R.string.change_template_type_creative);
        }
        if (i == 5) {
            return this.mContext.getString(C9086R.string.change_template_type_custom);
        }
        Logger.m11000e(TAG, "getPageTitle# unexpected pageIndex: " + i);
        return super.getPageTitle(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        Logger.m11000e(TAG, "instantiateItem, " + i);
        View tabView = this.mBaseTemplatePresenter.getTabView(i);
        if (tabView == null) {
            return super.instantiateItem(viewGroup, i);
        }
        ViewGroup viewGroup2 = (ViewGroup) tabView.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(tabView);
        }
        viewGroup.addView(tabView);
        return tabView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view.equals(obj);
    }
}
