package com.microsoft.identity.common.internal.p131ui.browser;

import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.logging.Logger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class BrowserBlocklist {
    private static final String TAG = "BrowserBlocklist";
    private List<Browser> mBrowsers;

    public BrowserBlocklist(Browser... browserArr) {
        this.mBrowsers = Arrays.asList(browserArr);
    }

    public boolean matches(@NonNull Browser browser) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":matches", new StringBuilder());
        Iterator<Browser> it = this.mBrowsers.iterator();
        while (it.hasNext()) {
            if (it.next().equals(browser)) {
                Logger.verbose(strM1170p, "The target browser is in the block list.");
                return true;
            }
        }
        return false;
    }
}
