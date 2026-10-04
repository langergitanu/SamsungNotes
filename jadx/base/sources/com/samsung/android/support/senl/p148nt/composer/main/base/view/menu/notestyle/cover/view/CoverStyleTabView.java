package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverStyleTabView;", "Lcom/google/android/material/tabs/TabLayout;", "context", "Landroid/content/Context;", "tabLayout", "<init>", "(Landroid/content/Context;Lcom/google/android/material/tabs/TabLayout;)V", "tabTitles", "", "contract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverStyleTabView$Contract;", "setContract", "", "initView", "getSelectedTabPosition", "", "setSelectedTab", "position", "setVisibility", "visibility", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoverStyleTabView extends TabLayout {

    @NotNull
    public static final String TAG = "CoverTabView";

    @Nullable
    private Contract contract;

    @NotNull
    private final TabLayout tabLayout;

    @NotNull
    private final int[] tabTitles;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverStyleTabView$Contract;", "", "onSelectTab", "", "position", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onSelectTab(int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverStyleTabView(@NotNull Context context, @NotNull TabLayout tabLayout) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.tabLayout = tabLayout;
        this.tabTitles = new int[]{C9086R.string.cover_type_pattern, C9086R.string.cover_type_illust, C9086R.string.cover_type_text};
        initView();
    }

    private final void initView() {
        for (int i : this.tabTitles) {
            TabLayout.Tab tabNewTab = this.tabLayout.newTab();
            Intrinsics.checkNotNullExpressionValue(tabNewTab, "newTab(...)");
            tabNewTab.setCustomView(C9086R.layout.cover_editor_tab);
            View customView = tabNewTab.getCustomView();
            TextView textView = customView != null ? (TextView) customView.findViewById(C9086R.id.tab_text) : null;
            if (textView != null) {
                if (i == C9086R.string.ai_cover) {
                    textView.setTextAppearance(C9086R.style.RobotoMediumStyle);
                }
                textView.setText(i);
            }
            this.tabLayout.addTab(tabNewTab);
        }
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverStyleTabView.initView.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                Logger.m10999d(CoverStyleTabView.TAG, "onTabSelected# " + tab.getPosition());
                View customView2 = tab.getCustomView();
                if (customView2 != null) {
                    customView2.setSelected(true);
                }
                TextView textView2 = customView2 != null ? (TextView) customView2.findViewById(C9086R.id.tab_text) : null;
                if (textView2 != null) {
                    textView2.setTextAppearance(C9086R.style.RobotoMediumStyle);
                }
                Contract contract = CoverStyleTabView.this.contract;
                if (contract != null) {
                    contract.onSelectTab(tab.getPosition());
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                Logger.m10999d(CoverStyleTabView.TAG, "onTabUnselected# " + tab.getPosition());
                View customView2 = tab.getCustomView();
                if (customView2 != null) {
                    customView2.setSelected(false);
                }
                TextView textView2 = customView2 != null ? (TextView) customView2.findViewById(C9086R.id.tab_text) : null;
                if (textView2 != null) {
                    textView2.setTextAppearance(C9086R.style.RobotoRegularStyle);
                }
            }
        });
    }

    @Override // com.google.android.material.tabs.TabLayout
    public int getSelectedTabPosition() {
        return this.tabLayout.getSelectedTabPosition();
    }

    public final void setContract(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.contract = contract;
    }

    public final void setSelectedTab(int position) {
        TabLayout tabLayout = this.tabLayout;
        tabLayout.selectTab(tabLayout.getTabAt(position));
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        this.tabLayout.setVisibility(visibility);
    }
}
