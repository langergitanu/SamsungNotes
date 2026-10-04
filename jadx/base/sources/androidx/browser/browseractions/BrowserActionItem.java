package androidx.browser.browseractions;

import android.app.PendingIntent;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class BrowserActionItem {
    private final PendingIntent mAction;

    @DrawableRes
    private final int mIconId;
    private final String mTitle;

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent, @DrawableRes int i) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i;
    }

    public PendingIntent getAction() {
        return this.mAction;
    }

    public int getIconId() {
        return this.mIconId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public BrowserActionItem(@NonNull String str, @NonNull PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }
}
