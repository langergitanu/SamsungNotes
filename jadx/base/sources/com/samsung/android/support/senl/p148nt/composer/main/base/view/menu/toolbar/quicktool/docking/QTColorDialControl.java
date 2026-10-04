package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.ChipView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.PaletteColorHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.PaletteDataHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.PaletteDefine;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 S2\u00020\u0001:\u0004STUVB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000bJ\u0016\u0010\u001f\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u001aJ\u0014\u0010+\u001a\u00020\u001c2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-J\u001e\u0010.\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0-H\u0002J\u0016\u0010/\u001a\u00020\u001c2\u000e\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010-J \u00102\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010-H\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u0012\u00104\u001a\u0004\u0018\u00010\u00132\u0006\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\u0018\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u001e\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0005J \u0010:\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0018\u0010?\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0018\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0018\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000eH\u0002J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000eH\u0002J\u000e\u0010I\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u000eJ\u000e\u0010K\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u000bJ\u0018\u0010L\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0018\u0010M\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000bH\u0002J \u0010P\u001a\u00020\u001c2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0002J\u000e\u0010M\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u0005J\b\u0010R\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl;", "", "context", "Landroid/content/Context;", "hasRecentColor", "", "<init>", "(Landroid/content/Context;Z)V", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mDialIndex", "", "mFrom", "mOtherColor", "", "mColorDataHelper", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/PaletteDataHelper;", "mPaletteItems", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl$ColorItem;", "mRecentItems", "mDividerIndexes", "mHasRecentColor", "mDialLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout;", "mColorChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl$OnColorChangedListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "updateVisibleColor", XmlErrorCodes.LIST, "getVisibleColor", "contentColor", "applyPickerColor", "view", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/ChipView;", "initColorLayout", "dialLayout", "supportEyedropper", "setColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPaletteList", "paletteList", "", "reconfigureColor", "setRecentColor", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "reconfigureRecentColor", "updateColorDial", "getColorInfo", "dialIndex", "getDefaultPaletteId", "notifyColorChanged", "oldIndex", "newIndex", "setColor", "uiInfo", "color", "moveToCurrent", Constants.MessagePayloadKeys.FROM, "getDialIndex", "getPaletteDialIndex", "viewIndex", "getRecentDialIndex", "copyColor", "srcColor", "destColor", "isSameColor", "color1", "color2", "setPickerColor", "hsvColor", "setEyedropperColor", "onDialColorSelect", "updateLayout", "oldDialIndex", "newDialIndex", "setDialSelected", "selected", "getTotalDialItemCount", "Companion", "ColorItem", "OnActionButtonListener", "OnColorChangedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTColorDialControl {
    private static final int EYEDROPPER_BUTTON_POSITION = 1;
    private static final int PICKER_BUTTON_POSITION = 0;
    private static final int RECENT_COLOR_MAX = 8;

    @NotNull
    private static final String TAG = "QTColorDialControl";

    @NotNull
    private final Context context;

    @Nullable
    private OnColorChangedListener mColorChangedListener;

    @NotNull
    private PaletteDataHelper mColorDataHelper;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;
    private int mDialIndex;

    @Nullable
    private SettingQTColorDialLayout mDialLayout;

    @NotNull
    private List<Integer> mDividerIndexes;
    private int mFrom;
    private boolean mHasRecentColor;

    @NotNull
    private float[] mOtherColor;

    @NotNull
    private List<ColorItem> mPaletteItems;

    @NotNull
    private List<ColorItem> mRecentItems;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl$ColorItem;", "", "colorUIInfo", "", "contentColor", "", "visibleColor", "description", "", "<init>", "(I[FILjava/lang/String;)V", "getColorUIInfo", "()I", "setColorUIInfo", "(I)V", "getContentColor", "()[F", "setContentColor", "([F)V", "getVisibleColor", "setVisibleColor", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class ColorItem {
        private int colorUIInfo;

        @NotNull
        private float[] contentColor;

        @Nullable
        private String description;
        private int visibleColor;

        public ColorItem() {
            this(0, null, 0, null, 15, null);
        }

        public static /* synthetic */ ColorItem copy$default(ColorItem colorItem, int i, float[] fArr, int i2, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = colorItem.colorUIInfo;
            }
            if ((i4 & 2) != 0) {
                fArr = colorItem.contentColor;
            }
            if ((i4 & 4) != 0) {
                i2 = colorItem.visibleColor;
            }
            if ((i4 & 8) != 0) {
                str = colorItem.description;
            }
            return colorItem.copy(i, fArr, i2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getColorUIInfo() {
            return this.colorUIInfo;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float[] getContentColor() {
            return this.contentColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getVisibleColor() {
            return this.visibleColor;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final ColorItem copy(int colorUIInfo, @NotNull float[] contentColor, int visibleColor, @Nullable String description) {
            Intrinsics.checkNotNullParameter(contentColor, "contentColor");
            return new ColorItem(colorUIInfo, contentColor, visibleColor, description);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(ColorItem.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorDialControl.ColorItem");
            ColorItem colorItem = (ColorItem) other;
            if (this.colorUIInfo != colorItem.colorUIInfo) {
                return false;
            }
            float[] fArr = this.contentColor;
            float f = fArr[0];
            float[] fArr2 = colorItem.contentColor;
            return f == fArr2[0] && fArr[1] == fArr2[1] && fArr[2] == fArr2[2] && this.visibleColor == colorItem.visibleColor && Intrinsics.areEqual(this.description, colorItem.description);
        }

        public final int getColorUIInfo() {
            return this.colorUIInfo;
        }

        @NotNull
        public final float[] getContentColor() {
            return this.contentColor;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        public final int getVisibleColor() {
            return this.visibleColor;
        }

        public int hashCode() {
            int iHashCode = (((Arrays.hashCode(this.contentColor) + (this.colorUIInfo * 31)) * 31) + this.visibleColor) * 31;
            String str = this.description;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final void setColorUIInfo(int i) {
            this.colorUIInfo = i;
        }

        public final void setContentColor(@NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.contentColor = fArr;
        }

        public final void setDescription(@Nullable String str) {
            this.description = str;
        }

        public final void setVisibleColor(int i) {
            this.visibleColor = i;
        }

        @NotNull
        public String toString() {
            int i = this.colorUIInfo;
            String string = Arrays.toString(this.contentColor);
            int i2 = this.visibleColor;
            String str = this.description;
            StringBuilder sbM1629s = AbstractC2322a.m1629s("ColorItem(colorUIInfo=", i, ", contentColor=", string, ", visibleColor=");
            sbM1629s.append(i2);
            sbM1629s.append(", description=");
            sbM1629s.append(str);
            sbM1629s.append(")");
            return sbM1629s.toString();
        }

        public ColorItem(int i, @NotNull float[] contentColor, int i2, @Nullable String str) {
            Intrinsics.checkNotNullParameter(contentColor, "contentColor");
            this.colorUIInfo = i;
            this.contentColor = contentColor;
            this.visibleColor = i2;
            this.description = str;
        }

        public /* synthetic */ ColorItem(int i, float[] fArr, int i2, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? new float[]{0.0f, 0.0f, 0.0f} : fArr, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl$OnActionButtonListener;", "", "onColorButtonClicked", "", "index", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnActionButtonListener {
        void onColorButtonClicked(int index);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorDialControl$OnColorChangedListener;", "", "onColorChanged", "", "info", "", "hsvColor", "", "isSame", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnColorChangedListener {
        void onColorChanged(int info, @NotNull float[] hsvColor, boolean isSame);
    }

    public QTColorDialControl(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mDialIndex = -1;
        this.mOtherColor = new float[3];
        this.mColorDataHelper = new PaletteDataHelper();
        this.mPaletteItems = new ArrayList();
        this.mRecentItems = new ArrayList();
        this.mDividerIndexes = new ArrayList();
        this.mHasRecentColor = z;
    }

    private final void copyColor(float[] srcColor, float[] destColor) {
        System.arraycopy(srcColor, 0, destColor, 0, 3);
    }

    private final ColorItem getColorInfo(int dialIndex) {
        if (dialIndex < this.mPaletteItems.size()) {
            return this.mPaletteItems.get(dialIndex);
        }
        int size = (dialIndex - this.mPaletteItems.size()) - 1;
        if (size < this.mRecentItems.size()) {
            return this.mRecentItems.get(size);
        }
        return null;
    }

    private final int getDefaultPaletteId() {
        if (this.mHasRecentColor) {
            return 0;
        }
        return this.mColorDataHelper.getPaletteID(0);
    }

    private final int getDialIndex(int uiInfo, float[] color) {
        int paletteID = PaletteDefine.getPaletteID(uiInfo);
        int fromType = PaletteDefine.getFromType(uiInfo);
        if (fromType == 1) {
            int recentDialIndex = getRecentDialIndex(color);
            return recentDialIndex > -1 ? (this.mColorDataHelper.getPaletteSize() * 8) + 1 + recentDialIndex : recentDialIndex;
        }
        if (fromType != 2) {
            return -1;
        }
        return getPaletteDialIndex(this.mColorDataHelper.getViewIndex(paletteID), color);
    }

    private final int getPaletteDialIndex(int viewIndex, float[] color) {
        if (viewIndex == -1) {
            return -1;
        }
        int i = viewIndex * 8;
        for (int i2 = 0; i2 < 8; i2++) {
            int i4 = i + i2;
            if (isSameColor(this.mPaletteItems.get(i4).getContentColor(), color)) {
                return i4;
            }
        }
        return -1;
    }

    private final int getRecentDialIndex(float[] color) {
        Iterator<T> it = this.mRecentItems.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (isSameColor(((ColorItem) it.next()).getContentColor(), color)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    private final int getTotalDialItemCount() {
        return this.mPaletteItems.size() + (this.mHasRecentColor ? 10 : 0);
    }

    private final int getVisibleColor(float[] contentColor) {
        int iHSVToColor = SpenSettingUtil.HSVToColor(contentColor);
        return this.mColorThemeUtil.getColorTheme() == 1 ? this.mColorThemeUtil.getColor(iHSVToColor) : iHSVToColor;
    }

    private final boolean isSameColor(float[] color1, float[] color2) {
        return color1[0] == color2[0] && color1[1] == color2[1] && color1[2] == color2[2];
    }

    private final void notifyColorChanged(int oldIndex, int newIndex) {
        int i = this.mDialIndex;
        ColorItem colorInfo = i > -1 ? getColorInfo(i) : null;
        if (colorInfo == null) {
            int colorUIInfo = PaletteDefine.getColorUIInfo(getDefaultPaletteId(), this.mFrom);
            float[] fArr = this.mOtherColor;
            float f = fArr[0];
            float f4 = fArr[2];
            StringBuilder sbM1628r = AbstractC2322a.m1628r("notify() uiInfo=", colorUIInfo, ", color=[", f, SQLKeyword.COMMA);
            sbM1628r.append(f);
            sbM1628r.append(SQLKeyword.COMMA);
            sbM1628r.append(f4);
            Logger.m11003i(TAG, sbM1628r.toString());
            OnColorChangedListener onColorChangedListener = this.mColorChangedListener;
            if (onColorChangedListener != null) {
                onColorChangedListener.onColorChanged(colorUIInfo, this.mOtherColor, oldIndex == newIndex);
                return;
            }
            return;
        }
        Logger.m11003i(TAG, "notify() uiInfo=" + colorInfo + ".colorUIInfo, color=[" + colorInfo.getContentColor()[0] + SQLKeyword.COMMA + colorInfo.getContentColor()[0] + SQLKeyword.COMMA + colorInfo.getContentColor()[2]);
        OnColorChangedListener onColorChangedListener2 = this.mColorChangedListener;
        if (onColorChangedListener2 != null) {
            onColorChangedListener2.onColorChanged(colorInfo.getColorUIInfo(), colorInfo.getContentColor(), oldIndex == newIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDialColorSelect(int oldIndex, int newIndex) {
        ColorItem colorInfo = getColorInfo(newIndex);
        if (colorInfo == null) {
            AbstractC8014b.m7217s(newIndex, "Invalid Color Position. index=", TAG);
            return;
        }
        setColor(newIndex, PaletteDefine.getFromType(colorInfo.getColorUIInfo()), colorInfo.getContentColor());
        AbstractC8014b.m7195A(AbstractC0622a.m1173s(oldIndex, newIndex, "dialIndex=", " -> ", ", from="), TAG, this.mFrom);
        updateLayout(oldIndex, newIndex);
        notifyColorChanged(oldIndex, newIndex);
    }

    private final void reconfigureColor(Context context, List<Integer> paletteList) {
        this.mColorDataHelper.setPaletteInfo(context, paletteList, -1);
        this.mPaletteItems.clear();
        Iterator<T> it = paletteList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            int iIntValue = ((Number) it.next()).intValue();
            SpenColorPaletteData paletteData = this.mColorDataHelper.getPaletteData(i);
            if (paletteData != null) {
                int colorUIInfo = PaletteDefine.getColorUIInfo(iIntValue, 2);
                int length = paletteData.values.length;
                for (int i4 = 0; i4 < length; i4++) {
                    ColorItem colorItem = new ColorItem(0, null, 0, null, 15, null);
                    colorItem.setColorUIInfo(colorUIInfo);
                    Color.colorToHSV(paletteData.values[i4], colorItem.getContentColor());
                    colorItem.setDescription(paletteData.names[i4]);
                    colorItem.setVisibleColor(this.mColorThemeUtil.getColorTheme() == 0 ? paletteData.values[i4] : paletteData.themeValues[i4]);
                    this.mPaletteItems.add(colorItem);
                }
            }
            i = i2;
        }
        this.mDividerIndexes.clear();
        if (this.mHasRecentColor) {
            int size = this.mPaletteItems.size();
            this.mDividerIndexes.add(Integer.valueOf(size));
            this.mDividerIndexes.add(Integer.valueOf(size + 7));
        }
    }

    private final void reconfigureRecentColor(Context context, List<SpenHSVColor> recentList) {
        if (!this.mHasRecentColor) {
            Logger.m11003i(TAG, "Not support recent color hasRecentColor=false");
            return;
        }
        this.mRecentItems.clear();
        if (recentList == null) {
            return;
        }
        PaletteColorHelper paletteColorHelper = new PaletteColorHelper(context);
        int colorUIInfo = PaletteDefine.getColorUIInfo(0, 1);
        for (SpenHSVColor spenHSVColor : recentList) {
            ColorItem colorItem = new ColorItem(0, null, 0, null, 15, null);
            colorItem.setColorUIInfo(colorUIInfo);
            spenHSVColor.getColor(colorItem.getContentColor());
            colorItem.setDescription(paletteColorHelper.getColorString(colorItem.getContentColor()));
            colorItem.setVisibleColor(SpenSettingUtil.HSVToColor(colorItem.getContentColor()));
            if (this.mColorThemeUtil.getColorTheme() == 1) {
                colorItem.setVisibleColor(this.mColorThemeUtil.getColor(colorItem.getVisibleColor()));
            }
            this.mRecentItems.add(colorItem);
        }
        paletteColorHelper.close();
    }

    private final void setDialSelected(int dialIndex, boolean selected, boolean moveToCurrent) {
        SettingQTColorDialLayout settingQTColorDialLayout = this.mDialLayout;
        if (settingQTColorDialLayout != null) {
            settingQTColorDialLayout.setDialItemSelected(dialIndex, selected, moveToCurrent);
        }
    }

    private final void updateColorDial() {
        ArrayList arrayList = new ArrayList();
        for (ColorItem colorItem : this.mPaletteItems) {
            arrayList.add(new SettingQTColorDialLayout.ColorDialItem(SettingQTColorDialLayout.DialItemType.COLOR, colorItem.getVisibleColor(), colorItem.getDescription(), false, false, 24, null));
        }
        if (this.mHasRecentColor) {
            arrayList.add(new SettingQTColorDialLayout.ColorDialItem(SettingQTColorDialLayout.DialItemType.DIVIDER, 0, null, false, false, 28, null));
            for (int i = 0; i < 8; i++) {
                if (i < this.mRecentItems.size()) {
                    ColorItem colorItem2 = this.mRecentItems.get(i);
                    arrayList.add(new SettingQTColorDialLayout.ColorDialItem(SettingQTColorDialLayout.DialItemType.COLOR, colorItem2.getVisibleColor(), colorItem2.getDescription(), true, false, 16, null));
                } else {
                    arrayList.add(new SettingQTColorDialLayout.ColorDialItem(SettingQTColorDialLayout.DialItemType.EMPTY, 0, null, false, false, 28, null));
                }
            }
            arrayList.add(new SettingQTColorDialLayout.ColorDialItem(SettingQTColorDialLayout.DialItemType.DIVIDER, 0, null, false, false, 28, null));
        }
        SettingQTColorDialLayout settingQTColorDialLayout = this.mDialLayout;
        if (settingQTColorDialLayout != null) {
            settingQTColorDialLayout.setDialItems(arrayList);
        }
    }

    private final void updateLayout(int oldDialIndex, int newDialIndex) {
        if (this.mDialLayout == null || oldDialIndex == newDialIndex) {
            return;
        }
        setDialSelected(oldDialIndex, false, false);
        setDialSelected(newDialIndex, true, false);
    }

    private final void updateVisibleColor(List<ColorItem> list) {
        for (ColorItem colorItem : list) {
            colorItem.setVisibleColor(getVisibleColor(colorItem.getContentColor()));
        }
    }

    public final void applyPickerColor(@NotNull ChipView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        boolean z = this.mDialIndex <= -1;
        if (view.isSelected() != z) {
            view.setSelected(z);
        }
        if (z) {
            Drawable selectorDrawable = view.getSelectorDrawable();
            LayerDrawable layerDrawable = selectorDrawable instanceof LayerDrawable ? (LayerDrawable) selectorDrawable : null;
            if (layerDrawable == null) {
                return;
            }
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(C9086R.id.selector_color);
            GradientDrawable gradientDrawable = drawableFindDrawableByLayerId instanceof GradientDrawable ? (GradientDrawable) drawableFindDrawableByLayerId : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(getVisibleColor(this.mOtherColor));
            }
        }
    }

    public final void close() {
        this.mColorThemeUtil.close();
    }

    public final boolean initColorLayout(@NotNull SettingQTColorDialLayout dialLayout, boolean supportEyedropper) {
        Intrinsics.checkNotNullParameter(dialLayout, "dialLayout");
        dialLayout.setActionListener(new SettingQTColorDialLayout.ActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorDialControl.initColorLayout.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout.ActionListener
            public void onDialButtonClick(int oldIndex, int newIndex) {
                QTColorDialControl.this.onDialColorSelect(oldIndex, newIndex);
            }
        });
        this.mDialLayout = dialLayout;
        return true;
    }

    public final void setColor(int uiInfo, @NotNull float[] color, boolean moveToCurrent) {
        Intrinsics.checkNotNullParameter(color, "color");
        PaletteDefine.showUIInfo(TAG, "setColor()", uiInfo);
        setColor(getDialIndex(uiInfo, color), PaletteDefine.getFromType(uiInfo), color);
        updateLayout(moveToCurrent);
    }

    public final void setColorChangedListener(@Nullable OnColorChangedListener listener) {
        this.mColorChangedListener = listener;
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
        updateVisibleColor(this.mPaletteItems);
        updateVisibleColor(this.mRecentItems);
        updateColorDial();
    }

    public final void setEyedropperColor(int color) {
        if (this.mHasRecentColor) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            int colorUIInfo = PaletteDefine.getColorUIInfo(0, 8);
            setColor(colorUIInfo, fArr, false);
            notifyColorChanged(this.mDialIndex, getDialIndex(colorUIInfo, fArr));
        }
    }

    public final void setPaletteList(@NotNull List<Integer> paletteList) {
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        reconfigureColor(this.context, paletteList);
        updateColorDial();
    }

    public final void setPickerColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        setColor(-1, 4, hsvColor);
        updateLayout(false);
        notifyColorChanged(this.mDialIndex, -1);
    }

    public final void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        reconfigureRecentColor(this.context, recentList);
        updateColorDial();
    }

    private final void setColor(int dialIndex, int from, float[] color) {
        if (dialIndex > -1) {
            this.mDialIndex = dialIndex;
            this.mFrom = from;
        } else {
            this.mDialIndex = -1;
            this.mFrom = from;
            copyColor(color, this.mOtherColor);
        }
    }

    public final void updateLayout(boolean moveToCurrent) {
        int totalDialItemCount = getTotalDialItemCount();
        int i = -1;
        while (i < totalDialItemCount) {
            setDialSelected(i, i == this.mDialIndex, moveToCurrent);
            i++;
        }
    }
}
