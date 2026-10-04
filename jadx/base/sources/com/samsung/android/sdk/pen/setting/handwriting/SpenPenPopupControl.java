package com.samsung.android.sdk.pen.setting.handwriting;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.setting.common.SpenConsumedListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilDrawable;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\u001b¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mRadius", "", "mBgColor", "mIsRTL", "", "mRadiusDir", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl$RadiusDir;", "mConsumedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenConsumedListener;", "close", "", "initView", "root", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "radiusDir", "initBackground", "view", "topLeftRadius", "getTopLeftRadius", "()I", "topRightRadius", "getTopRightRadius", "bottomLeftRadius", "getBottomLeftRadius", "bottomRightRadius", "getBottomRightRadius", "containsLeft", "containsRight", "RadiusDir", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPenPopupControl {
    private final int mBgColor;

    @Nullable
    private SpenConsumedListener mConsumedListener;
    private final boolean mIsRTL;
    private final int mRadius;

    @Nullable
    private RadiusDir mRadiusDir;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenPopupControl$RadiusDir;", "", "<init>", "(Ljava/lang/String;I)V", "RADIUS_DIR_TOP", "RADIUS_DIR_BOTTOM", "RADIUS_DIR_START", "RADIUS_DIR_END", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RadiusDir {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RadiusDir[] $VALUES;
        public static final RadiusDir RADIUS_DIR_TOP = new RadiusDir("RADIUS_DIR_TOP", 0);
        public static final RadiusDir RADIUS_DIR_BOTTOM = new RadiusDir("RADIUS_DIR_BOTTOM", 1);
        public static final RadiusDir RADIUS_DIR_START = new RadiusDir("RADIUS_DIR_START", 2);
        public static final RadiusDir RADIUS_DIR_END = new RadiusDir("RADIUS_DIR_END", 3);

        private static final /* synthetic */ RadiusDir[] $values() {
            return new RadiusDir[]{RADIUS_DIR_TOP, RADIUS_DIR_BOTTOM, RADIUS_DIR_START, RADIUS_DIR_END};
        }

        static {
            RadiusDir[] radiusDirArr$values = $values();
            $VALUES = radiusDirArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(radiusDirArr$values);
        }

        private RadiusDir(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RadiusDir> getEntries() {
            return $ENTRIES;
        }

        public static RadiusDir valueOf(String str) {
            return (RadiusDir) Enum.valueOf(RadiusDir.class, str);
        }

        public static RadiusDir[] values() {
            return (RadiusDir[]) $VALUES.clone();
        }
    }

    public SpenPenPopupControl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadius = context.getResources().getDimensionPixelOffset(C7932R.dimen.mini_pen_sub_popup_radius);
        this.mBgColor = SpenSettingUtil.getColor(context, C7932R.color.mini_setting_sub_popup_bg);
        this.mIsRTL = AbstractC0541b.m759a(context) == 1;
    }

    private final boolean containsLeft() {
        boolean z = this.mIsRTL;
        if (z || this.mRadiusDir != RadiusDir.RADIUS_DIR_START) {
            return z && this.mRadiusDir == RadiusDir.RADIUS_DIR_END;
        }
        return true;
    }

    private final boolean containsRight() {
        boolean z = this.mIsRTL;
        if (z || this.mRadiusDir != RadiusDir.RADIUS_DIR_END) {
            return z && this.mRadiusDir == RadiusDir.RADIUS_DIR_START;
        }
        return true;
    }

    private final void initBackground(View view) {
        Drawable roundedRectDrawable = SpenSettingUtilDrawable.getRoundedRectDrawable(getTopLeftRadius(), getTopRightRadius(), getBottomLeftRadius(), getBottomRightRadius());
        Intrinsics.checkNotNull(roundedRectDrawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) roundedRectDrawable;
        gradientDrawable.setColor(this.mBgColor);
        view.setBackground(gradientDrawable);
    }

    public static /* synthetic */ void initView$default(SpenPenPopupControl spenPenPopupControl, ViewGroup viewGroup, View view, RadiusDir radiusDir, int i, Object obj) {
        if ((i & 4) != 0) {
            radiusDir = RadiusDir.RADIUS_DIR_TOP;
        }
        spenPenPopupControl.initView(viewGroup, view, radiusDir);
    }

    public final void close() {
        SpenConsumedListener spenConsumedListener = this.mConsumedListener;
        if (spenConsumedListener != null) {
            Intrinsics.checkNotNull(spenConsumedListener);
            spenConsumedListener.close();
            this.mConsumedListener = null;
        }
    }

    public final int getBottomLeftRadius() {
        if (this.mRadiusDir == RadiusDir.RADIUS_DIR_BOTTOM || containsLeft()) {
            return this.mRadius;
        }
        return 0;
    }

    public final int getBottomRightRadius() {
        if (this.mRadiusDir == RadiusDir.RADIUS_DIR_BOTTOM || containsRight()) {
            return this.mRadius;
        }
        return 0;
    }

    public final int getTopLeftRadius() {
        if (this.mRadiusDir == RadiusDir.RADIUS_DIR_TOP || containsLeft()) {
            return this.mRadius;
        }
        return 0;
    }

    public final int getTopRightRadius() {
        if (this.mRadiusDir == RadiusDir.RADIUS_DIR_TOP || containsRight()) {
            return this.mRadius;
        }
        return 0;
    }

    @JvmOverloads
    public final void initView(@NotNull ViewGroup root, @Nullable View view) {
        Intrinsics.checkNotNullParameter(root, "root");
        initView$default(this, root, view, null, 4, null);
    }

    @JvmOverloads
    public final void initView(@NotNull ViewGroup root, @Nullable View child, @Nullable RadiusDir radiusDir) {
        Intrinsics.checkNotNullParameter(root, "root");
        SpenConsumedListener spenConsumedListener = new SpenConsumedListener();
        this.mConsumedListener = spenConsumedListener;
        Intrinsics.checkNotNull(spenConsumedListener);
        spenConsumedListener.setConsumedListener(root, child);
        this.mRadiusDir = radiusDir;
        initBackground(root);
    }
}
