package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.title.coedit.TitleCoeditMemberInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListAdapter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TitleCoeditMemberListView implements TitleCoeditMemberListAdapter.TitleCoeditMemberListAdapterContract {
    private static final String TAG = Logger.createTag("TitleCoeditMemberListView");
    private TitleEditorPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private TitleCoeditMemberListAdapter mTitleCoeditMemberListAdapter;

    public int getHeight() {
        if (!isShowing()) {
            return 0;
        }
        Resources resources = this.mRecyclerView.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(C9086R.dimen.comp_title_coedit_member_top_margin);
        this.mRecyclerView.measure(0, 0);
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        if (measuredHeight <= 0) {
            measuredHeight = resources.getDimensionPixelSize(C9086R.dimen.comp_title_coedit_member_height);
        }
        return measuredHeight + dimensionPixelSize;
    }

    public View getView() {
        return this.mRecyclerView;
    }

    public void init(ViewGroup viewGroup, TitleEditorPresenter titleEditorPresenter) {
        this.mPresenter = titleEditorPresenter;
        this.mRecyclerView = (RecyclerView) viewGroup.findViewById(C9086R.id.comp_title_coedit_member_list);
        TitleCoeditMemberListAdapter titleCoeditMemberListAdapter = new TitleCoeditMemberListAdapter(this);
        this.mTitleCoeditMemberListAdapter = titleCoeditMemberListAdapter;
        titleCoeditMemberListAdapter.setCoeditMemberList(this.mPresenter.getTitleCoeditMemberListPresenter().getCoeditMemberList());
        this.mRecyclerView.setAdapter(this.mTitleCoeditMemberListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        linearLayoutManager.setOrientation(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListAdapter.TitleCoeditMemberListAdapterContract
    public boolean isBackgroundDarkTheme() {
        return this.mPresenter.isBackgroundDarkTheme();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListAdapter.TitleCoeditMemberListAdapterContract
    public boolean isEditMode() {
        return this.mPresenter.isEditMode();
    }

    public boolean isShowing() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.getVisibility() == 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListAdapter.TitleCoeditMemberListAdapterContract
    public boolean isStandAlone() {
        return this.mPresenter.isStandAlone();
    }

    public void setAlpha(float f) {
        this.mRecyclerView.setAlpha(f);
    }

    public void setBackgroundColor(int i) {
        this.mTitleCoeditMemberListAdapter.setBackgroundColor(i);
    }

    public void setVisibility(int i) {
        if (this.mPresenter.isCoeditNote()) {
            this.mRecyclerView.setVisibility(i);
        } else {
            this.mRecyclerView.setVisibility(8);
            Logger.m11003i(TAG, "setVisibility# CoeditMode is off");
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.coedit.TitleCoeditMemberListAdapter.TitleCoeditMemberListAdapterContract
    public void showCoeditMemberManage() {
        this.mPresenter.showCoeditMemberManage();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void updateCoeditMemberListView() {
        List<TitleCoeditMemberInfo> coeditMemberList = this.mPresenter.getTitleCoeditMemberListPresenter().getCoeditMemberList();
        if (coeditMemberList == null || coeditMemberList.isEmpty()) {
            Logger.m11003i(TAG, "updateCoeditMemberListView# memberList is empty");
            this.mRecyclerView.setVisibility(8);
            return;
        }
        Logger.m11003i(TAG, "updateCoeditMemberListView# " + coeditMemberList.size());
        setVisibility(0);
        TitleCoeditMemberListAdapter titleCoeditMemberListAdapter = this.mTitleCoeditMemberListAdapter;
        if (titleCoeditMemberListAdapter != null) {
            titleCoeditMemberListAdapter.setCoeditMemberList(coeditMemberList);
            this.mTitleCoeditMemberListAdapter.notifyDataSetChanged();
        }
    }
}
