package com.samsung.android.support.senl.p148nt.composer.main.cover.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoverTabView extends TabLayout {
    private static final int[] mTabTitles = {C9086R.string.ai_cover, C9086R.string.cover_category_button_tts};
    private Contract mContract;
    private final TabLayout mTabLayout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onTabSelected(int i);
    }

    public CoverTabView(Context context, TabLayout tabLayout) {
        super(context);
        this.mTabLayout = tabLayout;
        initView();
    }

    private void initView() {
        for (int i : mTabTitles) {
            TabLayout.Tab tabNewTab = this.mTabLayout.newTab();
            tabNewTab.setCustomView(C9086R.layout.cover_editor_tab);
            TextView textView = (TextView) tabNewTab.getCustomView().findViewById(C9086R.id.tab_text);
            if (i == C9086R.string.ai_cover) {
                textView.setTextAppearance(C9086R.style.RobotoMediumStyle);
            }
            textView.setText(i);
            this.mTabLayout.addTab(tabNewTab);
        }
        this.mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.view.CoverTabView.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                customView.setSelected(true);
                ((TextView) customView.findViewById(C9086R.id.tab_text)).setTextAppearance(C9086R.style.RobotoMediumStyle);
                CoverTabView.this.mContract.onTabSelected(tab.getPosition());
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                customView.setSelected(false);
                ((TextView) customView.findViewById(C9086R.id.tab_text)).setTextAppearance(C9086R.style.RobotoRegularStyle);
            }
        });
    }

    @Override // com.google.android.material.tabs.TabLayout
    public int getSelectedTabPosition() {
        return this.mTabLayout.getSelectedTabPosition();
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void setSelectedTab(int i) {
        TabLayout tabLayout = this.mTabLayout;
        tabLayout.selectTab(tabLayout.getTabAt(i));
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        this.mTabLayout.setVisibility(i);
    }
}
