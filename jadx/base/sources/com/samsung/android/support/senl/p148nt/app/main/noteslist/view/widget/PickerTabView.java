package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget;

import android.content.Context;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class PickerTabView {
    private int mCurrentPage;
    private final AbsFragment mFragment;
    private TabViewContract mTabViewContract;
    private TabLayout mTabs;
    private final Runnable mUpdateRunnable = new RunnableC8669a(this, 2);
    private final TabLayout.OnTabSelectedListener mTabSelectedListener = new TabLayout.OnTabSelectedListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.PickerTabView.1
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            int position = tab.getPosition();
            if (PickerTabView.this.mCurrentPage != position) {
                PickerTabView.this.mCurrentPage = position;
                PickerTabView.this.mFragment.getView().removeCallbacks(PickerTabView.this.mUpdateRunnable);
                PickerTabView.this.mFragment.getView().post(PickerTabView.this.mUpdateRunnable);
            }
            if (PickerTabView.this.mTabs != null) {
                PickerTabView.this.mTabs.getTabAt(0).setIcon(PickerTabView.this.mCurrentPage == 0 ? C8003R.drawable.ic_all_solid : C8003R.drawable.ic_all);
                PickerTabView.this.mTabs.getTabAt(1).setIcon(PickerTabView.this.mCurrentPage == 1 ? C8003R.drawable.ic_drawer_folder_solid : C8003R.drawable.ic_folder);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TabViewContract {
        void onTabSelected(String str);
    }

    public PickerTabView(AbsFragment absFragment) {
        this.mFragment = absFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.mTabViewContract.onTabSelected(this.mCurrentPage == 0 ? FolderConstants.AllNotes.UUID : FolderConstants.MyFolders.UUID);
    }

    public TabLayout getBottomTab() {
        return this.mTabs;
    }

    public void setBottomTab(int i, String str) {
        TabLayout tabLayout = this.mTabs;
        if (tabLayout != null) {
            if (tabLayout.getVisibility() != i) {
                this.mTabs.setVisibility(i);
                return;
            }
            return;
        }
        if (i == 8) {
            return;
        }
        Context context = this.mFragment.getContext();
        this.mCurrentPage = !FolderConstants.AllNotes.UUID.equals(str) ? 1 : 0;
        TabLayout tabLayout2 = (TabLayout) this.mFragment.getActivity().findViewById(C8003R.id.tab_layout);
        this.mTabs = tabLayout2;
        if (tabLayout2 == null) {
            return;
        }
        tabLayout2.removeAllTabs();
        TabLayout tabLayout3 = this.mTabs;
        tabLayout3.addTab(tabLayout3.newTab().setText(context.getResources().getString(C8003R.string.all_notes)).setIcon(this.mCurrentPage == 0 ? C8003R.drawable.ic_all_solid : C8003R.drawable.ic_all));
        TabLayout tabLayout4 = this.mTabs;
        tabLayout4.addTab(tabLayout4.newTab().setText(context.getResources().getString(C8003R.string.settings_my_folders)).setIcon(this.mCurrentPage == 1 ? C8003R.drawable.ic_drawer_folder_solid : C8003R.drawable.ic_folder));
        TabLayout.Tab tabAt = this.mTabs.getTabAt(this.mCurrentPage);
        if (tabAt != null) {
            tabAt.select();
        }
        this.mTabs.addOnTabSelectedListener(this.mTabSelectedListener);
        this.mTabs.setVisibility(0);
    }

    public void setTabContract(TabViewContract tabViewContract) {
        this.mTabViewContract = tabViewContract;
    }
}
