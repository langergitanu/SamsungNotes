package com.samsung.android.sdk.pen.engine.pointericon;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.PointerIconWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u0000 H2\u00020\u0001:\u0002GHB\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020)H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0002J0\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u000202J\u0018\u0010-\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020\u001cJ8\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\u0006\u00109\u001a\u0002022\u0006\u0010:\u001a\u0002022\u0006\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020#H\u0002J\u000e\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0010J\u0016\u0010-\u001a\u00020)2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u0010J\u0006\u0010?\u001a\u00020)J\u0010\u0010@\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/J\b\u0010A\u001a\u00020)H\u0002J(\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u000202H\u0002J0\u0010B\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u000202H\u0002J8\u0010B\u001a\u00020)2\u0006\u00108\u001a\u00020\u00102\u0006\u00100\u001a\u00020\u00102\u0006\u00109\u001a\u0002022\u0006\u0010:\u001a\u0002022\u0006\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020#H\u0002J\b\u0010F\u001a\u00020)H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b \u0010!R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon;", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "mPointerIconWrapper", "Lcom/samsung/android/spen/libwrapper/PointerIconWrapper;", "mContext", "mView", "mToolTip", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenToolTip;", "mHoverIconMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "penIconStyle", "getPenIconStyle", "()I", "setPenIconStyle", "(I)V", "mCustomPointerIconType", "Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon$CustomPointerIconType;", "mCurrentDrawable", "Landroid/graphics/drawable/Drawable;", "mCurrentPoint", "Landroid/graphics/Point;", "mCurrentToolType", "mCurrentIconType", "hoveringIconDefaultPoint", "getHoveringIconDefaultPoint", "()Landroid/graphics/Point;", "enable", "", "isToolTipEnabled", "()Z", "setToolTipEnabled", "(Z)V", "close", "", "setHoverIconMap", "convertToPlatformHoverIconType", "iconType", "setHoveringSpenIcon", "penName", "", "color", "size", "", "isFixedWidth", "particleSize", "drawable", "point", "setHoveringSpenLaserIcon", "type", "blurSize", "strokeSize", "insideRatio", "isRainbowEnabled", "_toolType", "_iconType", "removeHoveringIcon", "getHoveringPenIconPoint", "resetCustomInfo", "onSetHoverIcon", "toolType", "extraIntParam", "extraFloatParam", "onRemoveHoverIcon", "CustomPointerIconType", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenHoverPointerIcon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenHoverPointerIcon.kt\ncom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,356:1\n1#2:357\n*E\n"})
public final class SpenHoverPointerIcon {
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_MOVE = 1104;
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_RESIZE_0 = 1100;
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_RESIZE_1 = 1101;
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_RESIZE_2 = 1102;
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_RESIZE_3 = 1103;
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_ROTATE = 1105;
    public static final int HOVER_POINTER_ICON_TYPE_CONTROL_SELECTION = 1106;
    public static final int HOVER_POINTER_ICON_TYPE_CUSTOM_MIN = 1000;
    public static final int HOVER_POINTER_ICON_TYPE_DEFAULT = 1;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_CHANGE_STYLE = 1203;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_COLOR_PICKER_ = 1202;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_CUTTER = 1204;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_EMPTY = 1206;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_FILL_COLOR = 1205;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_REMOVER = 1200;
    public static final int HOVER_POINTER_ICON_TYPE_ENGINE_SHAPE_RECOGNITION = 1201;
    public static final int HOVER_POINTER_ICON_TYPE_MORE = 3;
    public static final int HOVER_POINTER_ICON_TYPE_NULL = 0;
    public static final int HOVER_POINTER_ICON_TYPE_SCROLL_DOWN = 5;
    public static final int HOVER_POINTER_ICON_TYPE_SCROLL_LEFT = 6;
    public static final int HOVER_POINTER_ICON_TYPE_SCROLL_RIGHT = 7;
    public static final int HOVER_POINTER_ICON_TYPE_SCROLL_UP = 4;
    public static final int HOVER_POINTER_ICON_TYPE_TEXT = 2;
    public static final int HOVER_POINTER_PEN_ICON_STYLE_CURVER = 1211;
    public static final int HOVER_POINTER_PEN_ICON_STYLE_LINE = 1210;

    @NotNull
    private static final String TAG = "SpenHoverPointerIcon";

    @Nullable
    private Context mContext;

    @Nullable
    private Drawable mCurrentDrawable;

    @Nullable
    private PointerIconWrapper mPointerIconWrapper;

    @Nullable
    private final SpenToolTip mToolTip;

    @Nullable
    private View mView;
    private int penIconStyle;

    @Nullable
    private HashMap<Integer, Integer> mHoverIconMap = new HashMap<>();

    @NotNull
    private CustomPointerIconType mCustomPointerIconType = CustomPointerIconType.CUSTOM_NONE;

    @NotNull
    private final Point mCurrentPoint = new Point(-1, -1);
    private int mCurrentToolType = -1;
    private int mCurrentIconType = -1;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/engine/pointericon/SpenHoverPointerIcon$CustomPointerIconType;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM_NONE", "CUSTOM_DRAWABLE", "CUSTOM_ICONTYPE", "CUSTOM_ICONTYPE_TOOLTYPE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class CustomPointerIconType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CustomPointerIconType[] $VALUES;
        public static final CustomPointerIconType CUSTOM_NONE = new CustomPointerIconType("CUSTOM_NONE", 0);
        public static final CustomPointerIconType CUSTOM_DRAWABLE = new CustomPointerIconType("CUSTOM_DRAWABLE", 1);
        public static final CustomPointerIconType CUSTOM_ICONTYPE = new CustomPointerIconType("CUSTOM_ICONTYPE", 2);
        public static final CustomPointerIconType CUSTOM_ICONTYPE_TOOLTYPE = new CustomPointerIconType("CUSTOM_ICONTYPE_TOOLTYPE", 3);

        private static final /* synthetic */ CustomPointerIconType[] $values() {
            return new CustomPointerIconType[]{CUSTOM_NONE, CUSTOM_DRAWABLE, CUSTOM_ICONTYPE, CUSTOM_ICONTYPE_TOOLTYPE};
        }

        static {
            CustomPointerIconType[] customPointerIconTypeArr$values = $values();
            $VALUES = customPointerIconTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(customPointerIconTypeArr$values);
        }

        private CustomPointerIconType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<CustomPointerIconType> getEntries() {
            return $ENTRIES;
        }

        public static CustomPointerIconType valueOf(String str) {
            return (CustomPointerIconType) Enum.valueOf(CustomPointerIconType.class, str);
        }

        public static CustomPointerIconType[] values() {
            return (CustomPointerIconType[]) $VALUES.clone();
        }
    }

    public SpenHoverPointerIcon(@Nullable Context context, @Nullable View view) {
        if (context == null) {
            throw new IllegalArgumentException("Context must be not null");
        }
        this.mContext = context;
        this.mView = view;
        this.mToolTip = new SpenToolTip(context);
        boolean z = FloatingFeatureWrapper.create(context).getInt("SEC_FLOATING_FEATURE_FRAMEWORK_CONFIG_SPEN_VERSION") > 0;
        if (!z) {
            PackageManager packageManager = context.getPackageManager();
            z = packageManager != null && packageManager.hasSystemFeature("com.sec.feature.hovering_ui");
        }
        if (z) {
            try {
                this.mPointerIconWrapper = PointerIconWrapper.create(context);
            } catch (PlatformException e) {
                e.printStackTrace();
            }
        } else {
            Log.d(TAG, "hovering ui disabled. May be a feature problem.");
        }
        this.penIconStyle = HOVER_POINTER_PEN_ICON_STYLE_LINE;
        setHoverIconMap();
    }

    private final int convertToPlatformHoverIconType(int iconType) {
        HashMap<Integer, Integer> map = this.mHoverIconMap;
        if (map == null) {
            throw new InvalidParameterException();
        }
        Integer num = map.get(Integer.valueOf(iconType));
        if (num != null) {
            return num.intValue();
        }
        throw new InvalidParameterException();
    }

    private final void onRemoveHoverIcon() {
        removeHoveringIcon();
    }

    private final void onSetHoverIcon(int toolType, int iconType, int extraIntParam, float extraFloatParam) {
        if (isToolTipEnabled()) {
            if (iconType < 1000) {
                setHoveringSpenIcon(toolType, iconType);
            }
            Point hoveringIconDefaultPoint = getHoveringIconDefaultPoint();
            SpenToolTip spenToolTip = this.mToolTip;
            if (spenToolTip == null) {
                return;
            }
            switch (iconType) {
                case 1100:
                    setHoveringSpenIcon(spenToolTip.getDrawableControlImage("pen_basic_ic_resizing_mtrl_00", extraFloatParam, hoveringIconDefaultPoint), hoveringIconDefaultPoint);
                    break;
                case 1101:
                    setHoveringSpenIcon(spenToolTip.getDrawableControlImage("pen_basic_ic_resizing_mtrl_01", extraFloatParam, hoveringIconDefaultPoint), hoveringIconDefaultPoint);
                    break;
                case 1102:
                    setHoveringSpenIcon(spenToolTip.getDrawableControlImage("pen_basic_ic_resizing_mtrl_02", extraFloatParam, hoveringIconDefaultPoint), hoveringIconDefaultPoint);
                    break;
                case 1103:
                    setHoveringSpenIcon(spenToolTip.getDrawableControlImage("pen_basic_ic_resizing_mtrl_03", extraFloatParam, hoveringIconDefaultPoint), hoveringIconDefaultPoint);
                    break;
                case HOVER_POINTER_ICON_TYPE_CONTROL_MOVE /* 1104 */:
                    setHoveringSpenIcon(spenToolTip.getDrawableControlImage("pen_basic_ic_moving_mtrl", extraFloatParam, hoveringIconDefaultPoint), hoveringIconDefaultPoint);
                    break;
                case HOVER_POINTER_ICON_TYPE_CONTROL_ROTATE /* 1105 */:
                    setHoveringSpenIcon(spenToolTip.getDrawableControlImage("pen_basic_ic_rotating_mtrl_00", extraFloatParam, hoveringIconDefaultPoint), hoveringIconDefaultPoint);
                    break;
                case HOVER_POINTER_ICON_TYPE_CONTROL_SELECTION /* 1106 */:
                    setHoveringSpenIcon(spenToolTip.getDrawableSelectionImage(extraIntParam), hoveringIconDefaultPoint);
                    break;
                default:
                    switch (iconType) {
                        case 1200:
                            setHoveringSpenIcon(spenToolTip.getDrawableRemoverImage(), hoveringIconDefaultPoint);
                            break;
                        case HOVER_POINTER_ICON_TYPE_ENGINE_SHAPE_RECOGNITION /* 1201 */:
                            setHoveringSpenIcon(spenToolTip.getDrawableShapeImage(), hoveringIconDefaultPoint);
                            break;
                        case HOVER_POINTER_ICON_TYPE_ENGINE_COLOR_PICKER_ /* 1202 */:
                            setHoveringSpenIcon(spenToolTip.getDrawableSpoidImage(), spenToolTip.getHoveringIconSpoidPoint());
                            break;
                        case HOVER_POINTER_ICON_TYPE_ENGINE_CHANGE_STYLE /* 1203 */:
                            setHoveringSpenIcon(spenToolTip.getDrawableChangeStyleImage(extraIntParam), hoveringIconDefaultPoint);
                            break;
                        case HOVER_POINTER_ICON_TYPE_ENGINE_CUTTER /* 1204 */:
                            setHoveringSpenIcon(spenToolTip.getDrawableCutterImage(extraFloatParam, extraIntParam), new Point(300, 300));
                            break;
                        case HOVER_POINTER_ICON_TYPE_ENGINE_FILL_COLOR /* 1205 */:
                            setHoveringSpenIcon(spenToolTip.getDrawableFillColorImage(), hoveringIconDefaultPoint);
                            break;
                        case HOVER_POINTER_ICON_TYPE_ENGINE_EMPTY /* 1206 */:
                            setHoveringSpenIcon(spenToolTip.getEmptyDrawableImage(), hoveringIconDefaultPoint);
                            break;
                        default:
                            setHoveringSpenIcon(toolType, 0);
                            break;
                    }
                    break;
            }
        }
    }

    private final void resetCustomInfo() {
        this.mCurrentDrawable = null;
        this.mCurrentPoint.set(-1, -1);
        this.mCurrentToolType = -1;
        this.mCurrentIconType = -1;
    }

    private final void setHoverIconMap() {
        HashMap<Integer, Integer> map = this.mHoverIconMap;
        if (map == null) {
            return;
        }
        map.put(0, Integer.valueOf(PointerIconWrapper.TYPE_NULL));
        map.put(1, Integer.valueOf(PointerIconWrapper.TYPE_STYLUS_DEFAULT));
        map.put(2, Integer.valueOf(PointerIconWrapper.TYPE_TEXT));
        map.put(3, Integer.valueOf(PointerIconWrapper.TYPE_STYLUS_MORE));
        map.put(4, Integer.valueOf(PointerIconWrapper.TYPE_STYLUS_SCROLL_UP));
        map.put(5, Integer.valueOf(PointerIconWrapper.TYPE_STYLUS_SCROLL_DOWN));
        map.put(6, Integer.valueOf(PointerIconWrapper.TYPE_STYLUS_SCROLL_LEFT));
        map.put(7, Integer.valueOf(PointerIconWrapper.TYPE_STYLUS_SCROLL_RIGHT));
    }

    private final void setHoveringSpenLaserIcon(int type, int color, float blurSize, float strokeSize, float insideRatio, boolean isRainbowEnabled) {
        SpenToolTip spenToolTip;
        if (this.mPointerIconWrapper == null || !isToolTipEnabled() || (spenToolTip = this.mToolTip) == null) {
            return;
        }
        setHoveringSpenIcon(spenToolTip.getDrawableLaserPenImage(SpenPenManager.SPEN_LASER_PEN, type, color, blurSize, strokeSize, insideRatio, isRainbowEnabled), getHoveringPenIconPoint(SpenPenManager.SPEN_LASER_PEN));
    }

    public final void close() {
        this.mPointerIconWrapper = null;
        this.mContext = null;
        this.mView = null;
        this.mHoverIconMap = null;
        SpenToolTip spenToolTip = this.mToolTip;
        if (spenToolTip != null) {
            spenToolTip.close();
        }
    }

    @NotNull
    public final Point getHoveringIconDefaultPoint() {
        Point hoveringIconDefaultPoint;
        SpenToolTip spenToolTip = this.mToolTip;
        return (spenToolTip == null || (hoveringIconDefaultPoint = spenToolTip.getHoveringIconDefaultPoint()) == null) ? new Point() : hoveringIconDefaultPoint;
    }

    @NotNull
    public final Point getHoveringPenIconPoint(@Nullable String penName) {
        Point hoveringPenIconPoint;
        SpenToolTip spenToolTip = this.mToolTip;
        return (spenToolTip == null || (hoveringPenIconPoint = spenToolTip.getHoveringPenIconPoint(penName, this.penIconStyle)) == null) ? new Point() : hoveringPenIconPoint;
    }

    public final int getPenIconStyle() {
        return this.penIconStyle;
    }

    public final boolean isToolTipEnabled() {
        SpenToolTip spenToolTip = this.mToolTip;
        if (spenToolTip != null) {
            return spenToolTip.getIsEnabled();
        }
        return false;
    }

    public final void removeHoveringIcon() {
        PointerIconWrapper pointerIconWrapper = this.mPointerIconWrapper;
        if (pointerIconWrapper != null) {
            try {
                resetCustomInfo();
                pointerIconWrapper.removeHoveringSpenCustomIcon();
                setHoveringSpenIcon(2, 1);
            } catch (PlatformException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setHoveringSpenIcon(@Nullable String penName, int color, float size, boolean isFixedWidth, float particleSize) {
        SpenToolTip spenToolTip;
        if (this.mPointerIconWrapper == null || !isToolTipEnabled() || (spenToolTip = this.mToolTip) == null) {
            return;
        }
        setHoveringSpenIcon(spenToolTip.getDrawablePenImage(penName, color, size, isFixedWidth, particleSize, this.penIconStyle), getHoveringPenIconPoint(penName));
    }

    public final void setPenIconStyle(int i) {
        this.penIconStyle = i;
    }

    public final void setToolTipEnabled(boolean z) {
        SpenToolTip spenToolTip = this.mToolTip;
        if (spenToolTip != null) {
            spenToolTip.setEnabled(z);
        }
    }

    public final void setHoveringSpenIcon(@Nullable Drawable drawable, @NotNull Point point) {
        PointerIconWrapper pointerIconWrapper;
        Intrinsics.checkNotNullParameter(point, "point");
        if (!isToolTipEnabled() || drawable == null || (pointerIconWrapper = this.mPointerIconWrapper) == null) {
            return;
        }
        CustomPointerIconType customPointerIconType = this.mCustomPointerIconType;
        CustomPointerIconType customPointerIconType2 = CustomPointerIconType.CUSTOM_DRAWABLE;
        if (customPointerIconType != customPointerIconType2) {
            resetCustomInfo();
            this.mCustomPointerIconType = customPointerIconType2;
        }
        Drawable drawable2 = this.mCurrentDrawable;
        if (drawable2 != null && Intrinsics.areEqual(drawable2, drawable) && Intrinsics.areEqual(this.mCurrentPoint, point)) {
            return;
        }
        this.mCurrentDrawable = drawable;
        this.mCurrentPoint.set(point.x, point.y);
        try {
            pointerIconWrapper.setHoveringSpenIcon(this.mView, drawable, this.mCurrentPoint);
        } catch (PlatformException e) {
            e.printStackTrace();
        }
    }

    public final void setHoveringSpenIcon(int iconType) {
        PointerIconWrapper pointerIconWrapper;
        if (isToolTipEnabled() && (pointerIconWrapper = this.mPointerIconWrapper) != null) {
            CustomPointerIconType customPointerIconType = this.mCustomPointerIconType;
            CustomPointerIconType customPointerIconType2 = CustomPointerIconType.CUSTOM_ICONTYPE;
            if (customPointerIconType != customPointerIconType2) {
                resetCustomInfo();
                this.mCustomPointerIconType = customPointerIconType2;
            }
            if (this.mCurrentIconType == iconType) {
                return;
            }
            this.mCurrentIconType = iconType;
            try {
                pointerIconWrapper.setHoveringSpenIcon(this.mContext, this.mView, iconType);
            } catch (PlatformException e) {
                e.printStackTrace();
            }
        }
    }

    private final void onSetHoverIcon(String penName, int color, float size, boolean isFixedWidth, float particleSize) {
        if (isToolTipEnabled()) {
            setHoveringSpenIcon(penName, color, size, isFixedWidth, particleSize);
        }
    }

    private final void onSetHoverIcon(int type, int color, float blurSize, float strokeSize, float insideRatio, boolean isRainbowEnabled) {
        if (isToolTipEnabled()) {
            setHoveringSpenLaserIcon(type, color, blurSize, strokeSize, insideRatio, isRainbowEnabled);
        }
    }

    public final void setHoveringSpenIcon(int _toolType, int _iconType) {
        PointerIconWrapper pointerIconWrapper;
        int iConvertToPlatformHoverIconType;
        if (isToolTipEnabled() && (pointerIconWrapper = this.mPointerIconWrapper) != null) {
            CustomPointerIconType customPointerIconType = this.mCustomPointerIconType;
            CustomPointerIconType customPointerIconType2 = CustomPointerIconType.CUSTOM_ICONTYPE_TOOLTYPE;
            if (customPointerIconType != customPointerIconType2) {
                resetCustomInfo();
                this.mCustomPointerIconType = customPointerIconType2;
            }
            if (_iconType != 1) {
                if (_iconType == 2 && _toolType != 3) {
                    _toolType = 2;
                }
                iConvertToPlatformHoverIconType = convertToPlatformHoverIconType(_iconType);
            } else {
                iConvertToPlatformHoverIconType = _toolType != 2 ? 1000 : PointerIconWrapper.TYPE_STYLUS_DEFAULT;
            }
            if (this.mCurrentToolType == _toolType && this.mCurrentIconType == iConvertToPlatformHoverIconType) {
                return;
            }
            this.mCurrentToolType = _toolType;
            this.mCurrentIconType = iConvertToPlatformHoverIconType;
            try {
                pointerIconWrapper.setHoveringSpenIcon(this.mContext, this.mView, _toolType, iConvertToPlatformHoverIconType);
            } catch (PlatformException e) {
                e.printStackTrace();
            }
        }
    }
}
