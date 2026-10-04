package com.samsung.android.sdk.pen.setting.quicktool;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTUtil;", "", "<init>", "()V", "getScrollDirection", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTUtil$ScrollDirection;", "width", "", "height", "e1", "Landroid/view/MotionEvent;", "e2", "getAngleByTouch", "event", "center", "Landroid/graphics/PointF;", "ScrollDirection", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingQTUtil {

    @NotNull
    public static final SpenSettingQTUtil INSTANCE = new SpenSettingQTUtil();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTUtil$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "DIR_NONE", "DIR_CLOCK_WISE", "DIR_COUNTER_CLOCK_WISE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ScrollDirection {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScrollDirection[] $VALUES;
        public static final ScrollDirection DIR_NONE = new ScrollDirection("DIR_NONE", 0);
        public static final ScrollDirection DIR_CLOCK_WISE = new ScrollDirection("DIR_CLOCK_WISE", 1);
        public static final ScrollDirection DIR_COUNTER_CLOCK_WISE = new ScrollDirection("DIR_COUNTER_CLOCK_WISE", 2);

        private static final /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{DIR_NONE, DIR_CLOCK_WISE, DIR_COUNTER_CLOCK_WISE};
        }

        static {
            ScrollDirection[] scrollDirectionArr$values = $values();
            $VALUES = scrollDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scrollDirectionArr$values);
        }

        private ScrollDirection(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ScrollDirection> getEntries() {
            return $ENTRIES;
        }

        public static ScrollDirection valueOf(String str) {
            return (ScrollDirection) Enum.valueOf(ScrollDirection.class, str);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) $VALUES.clone();
        }
    }

    private SpenSettingQTUtil() {
    }

    @JvmStatic
    public static final float getAngleByTouch(@NotNull MotionEvent event, @NotNull PointF center) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(center, "center");
        double degrees = Math.toDegrees(Math.atan2(event.getY() - center.y, event.getX() - center.x));
        if (degrees < 0.0d) {
            degrees += (double) PopOverActivityWrapper.DEFAULT_WIDTH;
        }
        return (float) degrees;
    }

    @JvmStatic
    @NotNull
    public static final ScrollDirection getScrollDirection(float width, float height, @Nullable MotionEvent e12, @NotNull MotionEvent e2) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (e12 == null) {
            return ScrollDirection.DIR_NONE;
        }
        float f = 2;
        float f4 = width / f;
        float f5 = height / f;
        float x = e12.getX();
        float y2 = e12.getY();
        float y3 = ((e2.getY() - y2) * (x - f4)) - ((e2.getX() - x) * (y2 - f5));
        return y3 > 0.0f ? ScrollDirection.DIR_COUNTER_CLOCK_WISE : y3 < 0.0f ? ScrollDirection.DIR_CLOCK_WISE : ScrollDirection.DIR_NONE;
    }
}
