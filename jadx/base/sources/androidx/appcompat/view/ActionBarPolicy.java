package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0419R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarPolicy {
    private static final float MENU_WIDTH_LIMIT_FACTOR = 0.7f;
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return (int) (this.mContext.getResources().getDisplayMetrics().widthPixels * 0.7f);
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int getStackedTabMaxWidth() {
        return 0;
    }

    public int getTabContainerHeight() {
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(null, C0419R.styleable.ActionBar, C0419R.attr.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(C0419R.styleable.ActionBar_height, 0);
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean hasEmbeddedTabs() {
        return false;
    }

    public boolean hasNavigationBar() {
        return (ViewConfiguration.get(this.mContext).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
