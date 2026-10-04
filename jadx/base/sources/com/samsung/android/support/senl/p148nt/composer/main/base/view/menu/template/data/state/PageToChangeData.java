package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.data.state;

import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.TemplateConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageToChangeData {
    private static final String PREF_KEY_STATE_PAGE_TO_CHANGE = "STATE_PAGE_TO_CHANGE";
    private static final String TAG = CTLogger.createTag("PageToChangeData");
    private int mPageToChange = 1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageToChangeType {
        public static final int ALL = 5;
        public static final int BOTH = 3;
        public static final int CURRENT = 4;
        public static final int LEFT = 1;
        public static final int NONE = 0;
        public static final int RIGHT = 2;
    }

    public PageToChangeData() {
        loadStateData();
    }

    public int getPageToChange() {
        return this.mPageToChange;
    }

    public void loadStateData() {
        this.mPageToChange = SharedPreferencesCompat.getInstance(TemplateConstants.TEMPLATE_PREFERENCE_NAME).getInt(PREF_KEY_STATE_PAGE_TO_CHANGE, 1);
        AbstractC8014b.m7221w(new StringBuilder("loadStateData# PageToChange "), TAG, this.mPageToChange);
    }

    public void saveStateData() {
        Logger.m10999d(TAG, "saveStateData# PageToChange " + this.mPageToChange);
        SharedPreferencesCompat.getInstance(TemplateConstants.TEMPLATE_PREFERENCE_NAME).putInt(PREF_KEY_STATE_PAGE_TO_CHANGE, this.mPageToChange);
    }

    public void setPageToChange(int i) {
        AbstractC8014b.m7217s(i, "setPageToChange#", TAG);
        this.mPageToChange = i;
    }
}
