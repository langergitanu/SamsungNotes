package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.graphics.Color;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.sdk.pen.setting.pencommon.SpenUIPolicy;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\nH\u0007J\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\nH\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\nH\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020'H\u0007J\u0018\u0010(\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020'H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenUIPolicy;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenUIPolicy;", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mDefaultPenNameList", "", "[Ljava/lang/String;", "MARKER_ALPHA_VALUE", "", "PENCIL2_ALPHA_VALUE", "mPenWithFixedAlpha", "mFixedAlphaValue", "", "CHANGE_TYPE_INVALID", "CHANGE_TYPE_NONE", "CHANGE_TYPE_PEN", "CHANGE_TYPE_SIZE", "CHANGE_TYPE_COLOR", "getPenNameList", "", "context", "Landroid/content/Context;", "checkPenInfo", "uiPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "getSizeLevel", "penName", "uiStage", "getUIStage", "sizeLevel", "isUsingPen", "", "checkPenColor", "perfectlyTransparent", "color", "getCorrectPenColor", "checkPenSize", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setRepresentativeLevel", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenUIPolicy extends SpenUIPolicy {
    public static final int CHANGE_TYPE_COLOR = 4;
    public static final int CHANGE_TYPE_INVALID = -1;
    public static final int CHANGE_TYPE_NONE = 0;
    public static final int CHANGE_TYPE_PEN = 1;
    public static final int CHANGE_TYPE_SIZE = 2;
    private static final int MARKER_ALPHA_VALUE = 115;
    private static final int PENCIL2_ALPHA_VALUE = 160;

    @NotNull
    private static final String TAG = "SpenPenUIPolicy";

    @NotNull
    public static final SpenPenUIPolicy INSTANCE = new SpenPenUIPolicy();

    @NotNull
    private static final String[] mDefaultPenNameList = {SpenPenManager.SPEN_FOUNTAIN_PEN, SpenPenManager.SPEN_OBLIQUE_PEN, SpenPenManager.SPEN_INK_PEN2, SpenPenManager.SPEN_PENCIL2, SpenPenManager.SPEN_BRUSH_PEN};

    @NotNull
    private static final String[] mPenWithFixedAlpha = {PerfConstants.CodeMarkerParameters.MARKER, "Pencil2", "StraightHighlighter", "StraightMarker"};

    @NotNull
    private static final int[] mFixedAlphaValue = {115, 160, 115, 115};

    private SpenPenUIPolicy() {
    }

    @JvmStatic
    public static final boolean checkPenColor(@NotNull SpenSettingUIPenInfo uiPenInfo) {
        Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
        boolean zIsChangedPenColor = SpenUIPolicy.isChangedPenColor(uiPenInfo);
        int i = uiPenInfo.color;
        SpenPenUIPolicy spenPenUIPolicy = INSTANCE;
        if (spenPenUIPolicy.perfectlyTransparent(i)) {
            if (StringsKt.m14162r(uiPenInfo.name, PerfConstants.CodeMarkerParameters.MARKER)) {
                uiPenInfo.color = Color.argb(1, Color.red(uiPenInfo.color), Color.green(uiPenInfo.color), Color.blue(uiPenInfo.color));
            } else {
                uiPenInfo.color = Color.rgb(0, 0, 0);
            }
        }
        int correctPenColor = spenPenUIPolicy.getCorrectPenColor(uiPenInfo.name, uiPenInfo.color);
        uiPenInfo.color = correctPenColor;
        return zIsChangedPenColor || correctPenColor != i;
    }

    @JvmStatic
    public static final int checkPenInfo(@NotNull Context context, @NotNull SpenSettingUIPenInfo uiPenInfo) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
        if (Intrinsics.areEqual(uiPenInfo.name, SpenPenManager.SPEN_BRUSH) || Intrinsics.areEqual(uiPenInfo.name, SpenPenManager.SPEN_MONTBLANC_FOUNTAIN_PEN) || Intrinsics.areEqual(uiPenInfo.name, SpenPenManager.SPEN_MONTBLANC_OBLIQUE_PEN)) {
            uiPenInfo.name = SpenPenManager.SPEN_FOUNTAIN_PEN;
            i = 1;
        } else {
            i = 0;
        }
        if (!INSTANCE.isUsingPen(context, uiPenInfo.name)) {
            return -1;
        }
        boolean zCheckPenColor = checkPenColor(uiPenInfo);
        boolean zCheckPenSize = checkPenSize(context, uiPenInfo);
        AbstractC0000a.m27x(AbstractC2821a.m2226q("isValidPenInfo() changeType=", i, " isChangedColor=", zCheckPenColor, " isChangedSize="), zCheckPenSize, TAG);
        if (i == 1) {
            return i;
        }
        if (zCheckPenColor) {
            i |= 4;
        }
        return zCheckPenSize ? i | 2 : i;
    }

    @JvmStatic
    public static final boolean checkPenSize(@NotNull Context context, @NotNull SpenSettingPenInfo uiPenInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
        boolean zIsChangedPenSize = SpenUIPolicy.isChangedPenSize(context, uiPenInfo);
        if (setRepresentativeLevel(context, uiPenInfo)) {
            return true;
        }
        return zIsChangedPenSize;
    }

    private final int getCorrectPenColor(String penName, int color) {
        int length = mPenWithFixedAlpha.length;
        int i = color;
        for (int i2 = 0; i2 < length; i2++) {
            if (StringsKt.m14162r(penName, mPenWithFixedAlpha[i2])) {
                i = (mFixedAlphaValue[i2] << 24) | (16777215 & color);
            }
        }
        return i;
    }

    @JvmStatic
    @NotNull
    public static final List<String> getPenNameList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        int length = mDefaultPenNameList.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(mDefaultPenNameList[i]);
        }
        return arrayList;
    }

    @JvmStatic
    public static final int getSizeLevel(@NotNull String penName, int uiStage) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        if (uiStage <= 0 || uiStage > 5) {
            return 0;
        }
        return SpenPenSizePolicy.getRepresentativeLevel(penName, uiStage - 1);
    }

    @JvmStatic
    public static final int getUIStage(@Nullable String penName, int sizeLevel) {
        if (penName != null) {
            return SpenPenSizePolicy.getLevelIndex(penName, sizeLevel) + 1;
        }
        return 0;
    }

    private final boolean isUsingPen(Context context, String penName) {
        Iterator<String> it = getPenNameList(context).iterator();
        while (it.hasNext()) {
            if (it.next().compareTo(penName) == 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean perfectlyTransparent(int color) {
        return ((color >> 24) & 255) == 0;
    }

    @JvmStatic
    public static final boolean setRepresentativeLevel(@NotNull Context context, @NotNull SpenSettingPenInfo uiPenInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
        int levelIndex = SpenPenSizePolicy.getLevelIndex(uiPenInfo.name, uiPenInfo.sizeLevel);
        int i = uiPenInfo.sizeLevel;
        if (levelIndex < 0 || levelIndex >= 5) {
            return false;
        }
        int representativeLevel = SpenPenSizePolicy.getRepresentativeLevel(uiPenInfo.name, levelIndex);
        uiPenInfo.sizeLevel = representativeLevel;
        if (i == representativeLevel) {
            return false;
        }
        uiPenInfo.size = SpenPenUtil.convertSizeLevelToDpSize(context, uiPenInfo.name, representativeLevel);
        return true;
    }
}
