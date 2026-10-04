package androidx.core.util;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import androidx.core.oneui.OneUI;
import androidx.reflect.content.res.SeslConfigurationReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class SeslDisplayUtils {
    public static final int FLAG_EXTERNAL_DESKTOP_WINDOWING = 131072;
    private static final String TAG = "SeslDisplayUtils";

    public static int getEdgeArea(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "active_edge_area", 1);
    }

    public static int getPinnedEdgeWidth(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "pinned_edge_width");
        } catch (Settings.SettingNotFoundException e) {
            Log.w(TAG, "Failed get EdgeWidth " + e.toString());
            return 0;
        }
    }

    public static boolean isDesktopWindowing(Context context) {
        for (Display display : ((DisplayManager) context.getSystemService("display")).getDisplays()) {
            if ((display.getFlags() & 131072) != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDexEnabled(Context context) {
        return OneUI.isGreaterOrEqual(OneUI.Version.ONEUI_8_0) ? isDesktopWindowing(context) : SeslConfigurationReflector.isDexEnabled(context.getResources().getConfiguration());
    }

    public static boolean isPinEdgeEnabled(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "panel_mode", 0) == 1;
        } catch (Exception e) {
            Log.w(TAG, "Failed get panel mode " + e.toString());
            return false;
        }
    }
}
