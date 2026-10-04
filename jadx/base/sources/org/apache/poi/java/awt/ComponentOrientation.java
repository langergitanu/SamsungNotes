package org.apache.poi.java.awt;

import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes10.dex */
public final class ComponentOrientation implements Serializable {
    private static final int HORIZ_BIT = 2;
    private static final int LTR_BIT = 4;
    private static final int UNK_BIT = 1;
    private static final long serialVersionUID = -4113291392143563828L;
    private int orientation;
    public static final ComponentOrientation LEFT_TO_RIGHT = new ComponentOrientation(6);
    public static final ComponentOrientation RIGHT_TO_LEFT = new ComponentOrientation(2);
    public static final ComponentOrientation UNKNOWN = new ComponentOrientation(7);

    private ComponentOrientation(int i) {
        this.orientation = i;
    }

    public static ComponentOrientation getOrientation(Locale locale) {
        String language = locale.getLanguage();
        return ("iw".equals(language) || "ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language) || "ur".equals(language)) ? RIGHT_TO_LEFT : LEFT_TO_RIGHT;
    }

    public boolean isHorizontal() {
        return (this.orientation & 2) != 0;
    }

    public boolean isLeftToRight() {
        return (this.orientation & 4) != 0;
    }

    @Deprecated
    public static ComponentOrientation getOrientation(ResourceBundle resourceBundle) {
        ComponentOrientation orientation;
        try {
            orientation = (ComponentOrientation) resourceBundle.getObject(ExifInterface.TAG_ORIENTATION);
        } catch (Exception unused) {
            orientation = null;
        }
        if (orientation == null) {
            orientation = getOrientation(resourceBundle.getLocale());
        }
        return orientation == null ? getOrientation(Locale.getDefault()) : orientation;
    }
}
