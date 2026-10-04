package com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.widget.NestedScrollViewCustom;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p095X2.SharedPreferencesOnSharedPreferenceChangeListenerC0340a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/PageStyleLayout;", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage;", "context", "Landroid/content/Context;", "contract", "Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/support/senl/nt/app/settings/detail/style/view/pager/page/StyleOfNewNotesPage$Contract;)V", "mSharedPreferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "inflateLayout", "", "onAttachedToWindow", "onDetachedFromWindow", "initLayout", "updateLayout", "updateScrollStyle", "isSupportLayoutAndScrollDirectionSettings", "", "()Z", "getTAG", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class PageStyleLayout extends StyleOfNewNotesPage {

    @NotNull
    public static final String TAG = "LayoutStyleLayout";

    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mSharedPreferenceChangeListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageStyleLayout(@NotNull Context context, @NotNull StyleOfNewNotesPage.Contract contract) {
        super(context, contract);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mSharedPreferenceChangeListener = new SharedPreferencesOnSharedPreferenceChangeListenerC0340a(this, 4);
    }

    private final void initLayout() {
        findViewById(C8003R.id.settings_page_style_pages_title).setContentDescription(getContext().getString(C8003R.string.settings_default_note_style_pages) + " " + getContext().getString(C8003R.string.settings_layout_settings_sub_header));
        findViewById(C8003R.id.settings_page_style_layout_title).setContentDescription(getContext().getString(C8003R.string.composer_page_setting_page_layout) + " " + getContext().getString(C8003R.string.settings_layout_settings_sub_header));
        findViewById(C8003R.id.settings_page_style_scroll_direction_title).setContentDescription(getContext().getString(C8003R.string.settings_layout_settings_scroll_direction) + " " + getContext().getString(C8003R.string.settings_layout_settings_sub_header));
        findViewById(C8003R.id.settings_page_style_color_title).setContentDescription(getContext().getString(C8003R.string.settings_color_style) + " " + getContext().getString(C8003R.string.settings_layout_settings_sub_header));
    }

    private final boolean isSupportLayoutAndScrollDirectionSettings() {
        return 1 == SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSharedPreferenceChangeListener$lambda$0(PageStyleLayout pageStyleLayout, SharedPreferences sharedPreferences, String str) {
        if (Intrinsics.areEqual(SettingsConstants.SETTINGS_PREFERRED_NOTE_STYLE, str)) {
            pageStyleLayout.updateLayout();
        }
    }

    private final void updateLayout() {
        View viewFindViewById = findViewById(C8003R.id.layout_settings_container);
        if (viewFindViewById == null) {
            return;
        }
        viewFindViewById.setVisibility(isSupportLayoutAndScrollDirectionSettings() ? 0 : 8);
        View viewFindViewById2 = findViewById(C8003R.id.scroll_direction_setting_container);
        if (viewFindViewById2 == null) {
            return;
        }
        viewFindViewById2.setVisibility(isSupportLayoutAndScrollDirectionSettings() ? 0 : 8);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    @NotNull
    public String getTAG() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void inflateLayout(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C8003R.layout.settings_page_style_layout, (ViewGroup) this, true);
        initLayout();
        updateLayout();
        updateScrollStyle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").registerOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").unregisterOnSharedPreferenceChangeListener(this.mSharedPreferenceChangeListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.settings.detail.style.view.pager.page.StyleOfNewNotesPage
    public void updateScrollStyle() {
        updateScrollStyle((NestedScrollViewCustom) findViewById(C8003R.id.layout_style_container_scroll_view));
        updateViewSpacing(findViewById(C8003R.id.layout_style_container_scroll_view));
    }
}
