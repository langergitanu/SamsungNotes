package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class CustomTabsCallback {
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    public void onMessageChannelReady(Bundle bundle) {
    }

    public void extraCallback(String str, Bundle bundle) {
    }

    public void onNavigationEvent(int i, Bundle bundle) {
    }

    public void onPostMessage(String str, Bundle bundle) {
    }

    public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
    }
}
