package androidx.appcompat.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class TooltipCompat {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private TooltipCompat() {
    }

    public static void seslSetNextTooltipForceActionBarPosX(boolean z) {
        TooltipCompatHandler.seslSetTooltipForceActionBarPosX(z);
    }

    public static void seslSetNextTooltipForceBelow(boolean z) {
        TooltipCompatHandler.seslSetTooltipForceBelow(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void seslSetTooltipNull(boolean z) {
        TooltipCompatHandler.seslSetTooltipNull(z);
    }

    public static void seslSetTooltipText(@NonNull View view, @Nullable CharSequence charSequence, boolean z) {
        if (z) {
            TooltipCompatHandler.setTooltipText(view, charSequence);
        } else {
            Api26Impl.setTooltipText(view, charSequence);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated(since = "Use seslSetTooltipNull instead")
    public static void setTooltipNull(boolean z) {
        seslSetTooltipNull(z);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void setTooltipPosition(int i, int i2, int i4) {
        TooltipCompatHandler.seslSetTooltipPosition(i, i2, i4);
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        setTooltipText(view, charSequence, false);
    }

    @Deprecated(since = "Use seslSetTooltipText instead")
    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence, boolean z) {
        seslSetTooltipText(view, charSequence, z);
    }
}
