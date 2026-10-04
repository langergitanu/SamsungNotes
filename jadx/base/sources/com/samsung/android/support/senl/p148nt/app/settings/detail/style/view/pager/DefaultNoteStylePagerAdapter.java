package com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.DefaultTemplateStyleView;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.PageStyleLayout;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0011\u0018\u0000 G2\u00020\u0001:\u0002FGB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010!\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\fJ\u001a\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010!\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u0014J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0005J\u0010\u0010/\u001a\u00020\u00142\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u00100\u001a\u00020\u0014J\u0006\u00101\u001a\u00020\u0014J\u0006\u00102\u001a\u00020\u0014J(\u00103\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\f2\b\u00106\u001a\u0004\u0018\u000107J1\u00108\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u0010<\u001a\u00020=¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\f2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0019J\u0012\u0010D\u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010E\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mFragment", "Landroidx/fragment/app/Fragment;", "savedInstanceState", "Landroid/os/Bundle;", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter$Contract;", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter$Contract;)V", "mPages", "", "", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage;", "mPageTitles", "mPageIcons", "pageContract", "com/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter$pageContract$1", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter$pageContract$1;", "initPages", "", "initPageTitles", "initPageIcons", "getCount", "isViewFromObject", "", "view", "Landroid/view/View;", "o", "", "destroyItem", "container", "Landroid/view/ViewGroup;", "position", CoeditServiceConstants.Element.NAME_OBJECT, "getItemPosition", "instantiateItem", "getPageTitle", "", "getPageIcon", "Landroid/graphics/drawable/Drawable;", "createPage", "context", "Landroid/content/Context;", "onConfigurationChanged", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onViewStateRestored", "onResume", "onDestroy", "updateScrollStyle", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(II[Ljava/lang/String;[I)V", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "updateBackPressedCallBack", "isEnabled", "getPage", "isCallFromOtherApps", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DefaultNoteStylePagerAdapter extends PagerAdapter {
    private static final int NUM_OF_PAGE = 2;

    @NotNull
    private static final String TAG = "DefaultNoteStylePagerAdapter";

    @NotNull
    private final Contract contract;

    @NotNull
    private final Fragment mFragment;

    @NotNull
    private final Map<Integer, Integer> mPageIcons;

    @NotNull
    private final Map<Integer, Integer> mPageTitles;

    @NotNull
    private final Map<Integer, StyleOfNewNotesPage> mPages;

    @NotNull
    private final DefaultNoteStylePagerAdapter$pageContract$1 pageContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/DefaultNoteStylePagerAdapter$Contract;", "", "isCallFromOtherApps", "", "updateBackPressedCallBack", "", "isEnabled", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        boolean isCallFromOtherApps();

        void updateBackPressedCallBack(boolean isEnabled);
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.DefaultNoteStylePagerAdapter$pageContract$1] */
    public DefaultNoteStylePagerAdapter(@NotNull Fragment mFragment, @Nullable Bundle bundle, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mFragment = mFragment;
        this.contract = contract;
        this.mPages = new HashMap();
        this.mPageTitles = new HashMap();
        this.mPageIcons = new HashMap();
        this.pageContract = new StyleOfNewNotesPage.Contract() { // from class: com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.DefaultNoteStylePagerAdapter$pageContract$1
            @Override // com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage.Contract
            public boolean isCallFromOtherApps() {
                return this.this$0.isCallFromOtherApps();
            }

            @Override // com.samsung.android.support.senl.nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage.Contract
            public void updateBackPressedCallBack(boolean isEnabled) {
                this.this$0.updateBackPressedCallBack(isEnabled);
            }
        };
        initPages(bundle);
        initPageTitles();
        initPageIcons();
    }

    private final StyleOfNewNotesPage getPage(int position) {
        return this.mPages.get(Integer.valueOf(position));
    }

    private final void initPageIcons() {
        this.mPageIcons.put(0, Integer.valueOf(C8003R.drawable.ic_default_note_style_bottom_tab_page));
        this.mPageIcons.put(1, Integer.valueOf(C8003R.drawable.ic_default_note_style_bottom_tab_template));
    }

    private final void initPageTitles() {
        this.mPageTitles.put(0, Integer.valueOf(C8003R.string.settings_layout_page));
        this.mPageTitles.put(1, Integer.valueOf(C8003R.string.settings_template_style));
    }

    private final void initPages(Bundle savedInstanceState) {
        for (int i = 0; i < 2; i++) {
            StyleOfNewNotesPage page = getPage(i);
            if (page != null) {
                page.initialize(this.mFragment, savedInstanceState);
                this.mPages.put(Integer.valueOf(i), page);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCallFromOtherApps() {
        return this.contract.isCallFromOtherApps();
    }

    @Nullable
    public final StyleOfNewNotesPage createPage(@Nullable Context context, int position) {
        AbstractC8014b.m7201c(position, "createPage# position: ", TAG);
        StyleOfNewNotesPage page = getPage(position);
        if (page != null) {
            return page;
        }
        if (position == 0) {
            Intrinsics.checkNotNull(context);
            return new PageStyleLayout(context, this.pageContract);
        }
        if (position != 1) {
            return null;
        }
        Intrinsics.checkNotNull(context);
        return new DefaultTemplateStyleView(context, this.pageContract);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        this.mPages.remove(Integer.valueOf(position));
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        return -2;
    }

    @Nullable
    public final Drawable getPageIcon(int position) {
        Integer num = this.mPageIcons.get(Integer.valueOf(position));
        if (num != null) {
            int iIntValue = num.intValue();
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext != null) {
                return applicationContext.getDrawable(iIntValue);
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int position) {
        Integer num = this.mPageTitles.get(Integer.valueOf(position));
        if (num == null) {
            return "";
        }
        int iIntValue = num.intValue();
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext.getString(iIntValue);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Object instantiateItem(@NotNull ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        MainLogger.m7258i(TAG, "instantiateItem# position: " + position);
        StyleOfNewNotesPage styleOfNewNotesPageCreatePage = createPage(container.getContext(), position);
        if (styleOfNewNotesPageCreatePage == null) {
            return container;
        }
        if (!styleOfNewNotesPageCreatePage.getIsIsInitialized()) {
            styleOfNewNotesPageCreatePage.initialize(this.mFragment, null);
        }
        if (styleOfNewNotesPageCreatePage instanceof DefaultTemplateStyleView) {
            ((DefaultTemplateStyleView) styleOfNewNotesPageCreatePage).onResume();
        }
        styleOfNewNotesPageCreatePage.updateScrollStyle();
        this.mPages.put(Integer.valueOf(position), styleOfNewNotesPageCreatePage);
        try {
            container.addView(styleOfNewNotesPageCreatePage, position);
            return styleOfNewNotesPageCreatePage;
        } catch (IndexOutOfBoundsException unused) {
            container.addView(styleOfNewNotesPageCreatePage);
            return styleOfNewNotesPageCreatePage;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NotNull View view, @NotNull Object o) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(o, "o");
        return Intrinsics.areEqual(view, o);
    }

    public final void onActivityResult(int position, int requestCode, int resultCode, @Nullable Intent data) {
        StyleOfNewNotesPage page = getPage(position);
        if (page == null) {
            return;
        }
        page.onActivityResult(requestCode, resultCode, data);
    }

    public final void onConfigurationChanged() {
        Iterator<StyleOfNewNotesPage> it = this.mPages.values().iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged();
        }
    }

    public final void onDestroy() {
        Iterator<StyleOfNewNotesPage> it = this.mPages.values().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
    }

    public final boolean onOptionsItemSelected(int position, @NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        StyleOfNewNotesPage page = getPage(position);
        if (page == null) {
            return false;
        }
        return page.onOptionsItemSelected(item);
    }

    public final void onRequestPermissionsResult(int position, int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        StyleOfNewNotesPage page = getPage(position);
        if (page == null) {
            return;
        }
        page.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public final void onResume() {
        Iterator<StyleOfNewNotesPage> it = this.mPages.values().iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public final void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Iterator<StyleOfNewNotesPage> it = this.mPages.values().iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(outState);
        }
    }

    public final void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Iterator<StyleOfNewNotesPage> it = this.mPages.values().iterator();
        while (it.hasNext()) {
            it.next().onViewStateRestored(savedInstanceState);
        }
    }

    public final void updateBackPressedCallBack(boolean isEnabled) {
        this.contract.updateBackPressedCallBack(isEnabled);
    }

    public final void updateScrollStyle() {
        Iterator<StyleOfNewNotesPage> it = this.mPages.values().iterator();
        while (it.hasNext()) {
            it.next().updateScrollStyle();
        }
    }
}
