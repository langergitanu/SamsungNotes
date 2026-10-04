package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenUIPolicy;", "", "<init>", "()V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenUIPolicy {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenUIPolicy";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0005J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0012H\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenUIPolicy$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setPenSizeToSizeLevel", "", "context", "Landroid/content/Context;", "uiPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "minValue", "", "maxValue", "isChangedPenSize", "penInfo", "isChangedPenColor", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "getRGBColor", "", "color", "isDefaultValue", "hsv", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getRGBColor(int color) {
            return Color.rgb(Color.red(color), Color.green(color), Color.blue(color));
        }

        private final boolean isDefaultValue(float[] hsv) {
            return hsv[0] == 0.0f && hsv[1] == 0.0f && hsv[2] == 0.0f;
        }

        @JvmStatic
        public final boolean isChangedPenColor(@NotNull SpenSettingUIPenInfo uiPenInfo) {
            Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
            if (!isDefaultValue(uiPenInfo.hsv) || getRGBColor(uiPenInfo.color) == 0) {
                return false;
            }
            Color.colorToHSV(uiPenInfo.color, uiPenInfo.hsv);
            return true;
        }

        @JvmStatic
        public final boolean isChangedPenSize(@NotNull Context context, @NotNull SpenSettingPenInfo penInfo) {
            boolean z;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(penInfo, "penInfo");
            if (penInfo.size == 0.0f) {
                int i = penInfo.sizeLevel;
                if (i > 0) {
                    penInfo.size = SpenPenUtil.convertSizeLevelToDpSize(context, penInfo.name, i);
                } else {
                    penInfo.size = 10.0f;
                }
                Log.i(SpenUIPolicy.TAG, "checkPenSize() :: changed size[0->" + penInfo.size + "]");
                z = true;
            } else {
                z = false;
            }
            if (setPenSizeToSizeLevel(context, penInfo)) {
                return true;
            }
            return z;
        }

        public final boolean setPenSizeToSizeLevel(@NotNull Context context, @NotNull SpenSettingPenInfo uiPenInfo) {
            float maxSettingValue;
            float minSettingValue;
            SpenPen spenPenCreatePen;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
            int i = uiPenInfo.sizeLevel;
            if (i < 0 || i > 100) {
                uiPenInfo.sizeLevel = 0;
            }
            if (uiPenInfo.sizeLevel == 0) {
                SpenPenManager spenPenManager = new SpenPenManager(context);
                try {
                    spenPenCreatePen = spenPenManager.createPen(uiPenInfo.name);
                    maxSettingValue = spenPenCreatePen.getMaxSettingValue();
                    try {
                        minSettingValue = spenPenCreatePen.getMinSettingValue();
                    } catch (Exception e) {
                        e = e;
                        minSettingValue = -1.0f;
                    }
                } catch (Exception e2) {
                    e = e2;
                    maxSettingValue = -1.0f;
                    minSettingValue = -1.0f;
                }
                try {
                    spenPenManager.destroyPen(spenPenCreatePen);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
                if (maxSettingValue > -1.0f) {
                    return setPenSizeToSizeLevel(context, minSettingValue, maxSettingValue, uiPenInfo);
                }
            }
            return false;
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean setPenSizeToSizeLevel(@NotNull Context context, float minValue, float maxValue, @NotNull SpenSettingPenInfo uiPenInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
            int i = uiPenInfo.sizeLevel;
            boolean z = false;
            if (i < 0 || i > 100) {
                uiPenInfo.sizeLevel = 0;
                z = true;
            }
            if (uiPenInfo.sizeLevel != 0) {
                return z;
            }
            DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
            float f = uiPenInfo.size;
            int i2 = displayMetrics.densityDpi;
            float f4 = (160.0f / i2) * f;
            if (f4 <= minValue) {
                uiPenInfo.sizeLevel = 1;
                uiPenInfo.size = (i2 / 160.0f) * minValue;
            } else if (f4 >= maxValue) {
                uiPenInfo.sizeLevel = 100;
                uiPenInfo.size = (i2 / 160.0f) * maxValue;
            } else {
                int iRoundToInt = MathKt.roundToInt(((f4 - minValue) / (maxValue - minValue)) * 100);
                uiPenInfo.sizeLevel = iRoundToInt;
                if (iRoundToInt < 1) {
                    uiPenInfo.sizeLevel = 1;
                } else if (iRoundToInt > 100) {
                    uiPenInfo.sizeLevel = 100;
                }
            }
            return true;
        }
    }

    @JvmStatic
    public static final boolean isChangedPenColor(@NotNull SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return INSTANCE.isChangedPenColor(spenSettingUIPenInfo);
    }

    @JvmStatic
    public static final boolean isChangedPenSize(@NotNull Context context, @NotNull SpenSettingPenInfo spenSettingPenInfo) {
        return INSTANCE.isChangedPenSize(context, spenSettingPenInfo);
    }

    @JvmStatic
    public static final boolean setPenSizeToSizeLevel(@NotNull Context context, float f, float f4, @NotNull SpenSettingPenInfo spenSettingPenInfo) {
        return INSTANCE.setPenSizeToSizeLevel(context, f, f4, spenSettingPenInfo);
    }
}
