package com.samsung.android.support.senl.p148nt.composer.main.recyclebin.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.factory.BaseComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.factory.RecycleBinComponentFactory;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.presenter.RecycleBinContract;
import com.samsung.android.support.senl.p148nt.composer.main.recyclebin.view.menu.title.RecyclerBinTitleEditor;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentTimeUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RecycleBinFragment extends BaseComposerFragment implements RecycleBinContract.IView {
    private void initDueDateView(TextView textView, long j) {
        int recycleBinDueDate = DocumentTimeUtils.getRecycleBinDueDate(j);
        if (recycleBinDueDate == 0) {
            textView.setText(getResources().getString(C9086R.string.recycle_bin_remain_time_tonight));
        } else if (recycleBinDueDate == 1) {
            textView.setText(getResources().getString(C9086R.string.recycle_bin_remain_time_tomorrow));
        } else {
            textView.setText(getResources().getQuantityString(C9086R.plurals.recycle_bin_remain_time, recycleBinDueDate, Integer.valueOf(recycleBinDueDate)));
        }
    }

    private void setThemeToView(ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt instanceof ViewGroup) {
                childAt.setBackgroundColor(i);
                setThemeToView((ViewGroup) childAt, i, i2);
            } else if (childAt instanceof ImageView) {
                ((ImageView) childAt).setColorFilter(i2);
                childAt.invalidate();
            } else if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(i2);
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.recyclebin.presenter.RecycleBinContract.IView
    public void attachDueDateView(long j, int i, boolean z, boolean z2) {
        ViewGroup viewGroup = (ViewGroup) getView().findViewById(C9086R.id.comp_bottom_container);
        viewGroup.setVisibility(0);
        initDueDateView((TextView) getLayoutInflater().inflate(C9086R.layout.comp_recycle_bin_due_date_bar, viewGroup, true).findViewById(C9086R.id.comp_recycle_bin_remain_time), j);
        int[] backgroundThemeColorTable = BackgroundColorUtil.getBackgroundThemeColorTable(getActivity(), i, z, z2);
        setThemeToView(viewGroup, backgroundThemeColorTable[0], backgroundThemeColorTable[1]);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment, com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.ComposerSubContract.IView
    public void attachTitle(TitleEditorPresenter titleEditorPresenter) {
        setHasOptionsMenu(true);
        if (this.mTitle == null) {
            this.mTitle = new RecyclerBinTitleEditor(getActivity(), this, titleEditorPresenter);
        }
        attachSubTitle();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment
    public BaseComponentFactory createComponentFactory() {
        return new RecycleBinComponentFactory();
    }
}
