package com.samsung.android.sdk.pen.setting.colorpalette;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b%\b\u0007\u0018\u0000 J2\u00020\u0001:\u0003JKLB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005J\u0010\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\fJ\u0016\u0010#\u001a\u00020\u001e2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%J\u0016\u0010'\u001a\u00020\u00072\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010(J\u0010\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010+\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020\u0005J\u0012\u0010.\u001a\u00020\u001e2\b\b\u0002\u0010/\u001a\u00020\u0007H\u0002J\u000e\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u0007J\u0018\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000fH\u0002J\u0006\u00102\u001a\u00020\u001eJ\u000e\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0012J\u000e\u00107\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0005J\u0016\u00108\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0007J\u0006\u0010:\u001a\u00020\u001eJ\u001e\u0010;\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u0007J\u0010\u0010>\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010\u0012J\u0018\u0010?\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0012H\u0002J\b\u0010A\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u00020\u001eH\u0002J\u0018\u0010C\u001a\u00020\u001e2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010G¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl;", "", "context", "Landroid/content/Context;", "mRecentPageIndex", "", "eyedropperEnable", "", "RECENT_COLOR_MAX", "<init>", "(Landroid/content/Context;IZI)V", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "mRecentColors", "Ljava/util/LinkedList;", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl$RecentHsvColor;", "mSelectedIdx", "mBackupSelectedColor", "", "mRecentIndexList", "", "mColorHelper", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorHelper;", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mIsEyedropperEnable", "mEyedropperResource", "mOnColorChangeListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl$OnColorChangeListener;", "close", "", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setPaletteView", "paletteView", "setRecentColors", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "getRecentColors", "", "setOnColorChangeListener", "onColorChangeListener", "initPage", "recentIndexList", "eyedropperResourceId", "updateEyedropper", "reset", "setEyedropperEnabled", "enabled", "updateColor", "childAt", "recentColor", "addColor", "color", "isEyedropperButton", "onButtonClick", "isSelected", "clearChecked", "setSelected", "selected", "needAnimation", "getChildIndex", "getVisibleColor", "visibleColor", "backupSelectedColor", "restoreSelectedColor", "initColorList", "colors", "possibleColorCount", "getPossibleColorCount", "()I", "displayColorCount", "getDisplayColorCount", "Companion", "OnColorChangeListener", "RecentHsvColor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
@SourceDebugExtension({"SMAP\nSpenPaletteRecentControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPaletteRecentControl.kt\ncom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,439:1\n1#2:440\n*E\n"})
public final class SpenPaletteRecentControl {

    @NotNull
    private static final String TAG = "SpenPaletteRecentControl";
    private final int RECENT_COLOR_MAX;

    @Nullable
    private float[] mBackupSelectedColor;

    @NotNull
    private SpenPaletteColorHelper mColorHelper;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;
    private int mEyedropperResource;
    private boolean mIsEyedropperEnable;

    @Nullable
    private OnColorChangeListener mOnColorChangeListener;

    @Nullable
    private SpenPaletteViewInterface mPaletteView;

    @NotNull
    private LinkedList<RecentHsvColor> mRecentColors;

    @NotNull
    private int[] mRecentIndexList;
    private final int mRecentPageIndex;
    private int mSelectedIdx;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl$OnColorChangeListener;", "", "OnColorSelected", "", "childAt", "", "hsvColor", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnColorChangeListener {
        void OnColorSelected(int childAt, @NotNull float[] hsvColor);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0004J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteRecentControl$RecentHsvColor;", "", "color", "", "name", "", "<init>", "([FLjava/lang/String;)V", "mColor", "getMColor", "()[F", "setMColor", "([F)V", "mName", "getMName", "()Ljava/lang/String;", "setMName", "(Ljava/lang/String;)V", "equals", "", "other", "finalize", "", "toString", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RecentHsvColor {

        @NotNull
        private float[] mColor;

        @Nullable
        private String mName;

        public RecentHsvColor(@NotNull float[] color, @Nullable String str) {
            Intrinsics.checkNotNullParameter(color, "color");
            float[] fArr = new float[3];
            this.mColor = fArr;
            System.arraycopy(color, 0, fArr, 0, 3);
            this.mName = str;
        }

        public boolean equals(@Nullable Object other) {
            if (!(other instanceof RecentHsvColor)) {
                return super.equals(other);
            }
            for (int i = 0; i < 3; i++) {
                if (((RecentHsvColor) other).mColor[i] != this.mColor[i]) {
                    return false;
                }
            }
            return true;
        }

        public final void finalize() {
            this.mName = null;
        }

        @NotNull
        public final float[] getMColor() {
            return this.mColor;
        }

        @Nullable
        public final String getMName() {
            return this.mName;
        }

        public final void setMColor(@NotNull float[] fArr) {
            Intrinsics.checkNotNullParameter(fArr, "<set-?>");
            this.mColor = fArr;
        }

        public final void setMName(@Nullable String str) {
            this.mName = str;
        }

        @NotNull
        public String toString() {
            float[] fArr = this.mColor;
            float f = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[2];
            String str = this.mName;
            if (str == null) {
                str = "null";
            }
            StringBuilder sbM1176v = AbstractC0622a.m1176v("hue=", f, ", saturation=", f4, " value=");
            sbM1176v.append(f5);
            sbM1176v.append(" Name=");
            sbM1176v.append(str);
            return sbM1176v.toString();
        }
    }

    public SpenPaletteRecentControl(@NotNull Context context, int i, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRecentPageIndex = i;
        this.RECENT_COLOR_MAX = i2;
        this.mIsEyedropperEnable = z;
        this.mSelectedIdx = -1;
        this.mRecentIndexList = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            this.mRecentIndexList[i4] = i4;
        }
        this.mColorHelper = new SpenPaletteColorHelper(context);
        this.mRecentColors = new LinkedList<>();
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
    }

    private final void backupSelectedColor() {
        int i = this.mSelectedIdx;
        if (i == -1 || i >= getDisplayColorCount()) {
            this.mBackupSelectedColor = null;
            return;
        }
        RecentHsvColor recentHsvColor = this.mRecentColors.get(this.mSelectedIdx);
        Intrinsics.checkNotNullExpressionValue(recentHsvColor, "get(...)");
        float[] fArr = new float[3];
        this.mBackupSelectedColor = fArr;
        System.arraycopy(recentHsvColor.getMColor(), 0, fArr, 0, 3);
    }

    private final int getDisplayColorCount() {
        if (this.mPaletteView == null) {
            return 0;
        }
        int size = this.mRecentColors.size();
        return (this.mIsEyedropperEnable && size == this.RECENT_COLOR_MAX) ? size - 1 : size;
    }

    private final int getPossibleColorCount() {
        return this.mIsEyedropperEnable ? this.RECENT_COLOR_MAX - 1 : this.RECENT_COLOR_MAX;
    }

    private final void getVisibleColor(float[] color, float[] visibleColor) {
        Color.colorToHSV(this.mColorThemeUtil.getColor(SpenSettingUtil.HSVToColor(color)), visibleColor);
    }

    private final void initColorList(List<SpenHSVColor> colors) {
        Log.i(TAG, "initColorList()");
        if (colors == null) {
            Log.i(TAG, "initColorList() colors is null.");
            return;
        }
        this.mRecentColors.clear();
        int size = colors.size();
        int size2 = this.RECENT_COLOR_MAX;
        if (size < size2) {
            size2 = colors.size();
        }
        int size3 = colors.size();
        AbstractC0000a.m26w(AbstractC0622a.m1173s(size3, size2, "initColorList() inputCount =", " addCount=", " MAX="), TAG, this.RECENT_COLOR_MAX);
        float[] fArr = new float[3];
        for (int i = 0; i < size2; i++) {
            colors.get(i).getColor(fArr);
            this.mRecentColors.add(new RecentHsvColor(fArr, this.mColorHelper.getColorString(fArr)));
        }
    }

    private final void restoreSelectedColor() {
        float[] fArr = this.mBackupSelectedColor;
        int childIndex = fArr != null ? getChildIndex(fArr) : -1;
        if (childIndex > -1) {
            setSelected(childIndex, true, false);
        } else {
            this.mSelectedIdx = -1;
        }
        this.mBackupSelectedColor = null;
    }

    private final void updateColor(int childAt, RecentHsvColor recentColor) {
        SpenPaletteViewInterface spenPaletteViewInterface;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        getVisibleColor(recentColor.getMColor(), fArr);
        String mName = recentColor.getMName();
        if (mName == null || (spenPaletteViewInterface = this.mPaletteView) == null) {
            return;
        }
        spenPaletteViewInterface.setColor(this.mRecentPageIndex, childAt, fArr, mName);
    }

    private final void updateEyedropper(boolean reset) {
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            int i = this.mRecentIndexList[this.RECENT_COLOR_MAX - 1];
            if (reset) {
                spenPaletteViewInterface.resetColor(this.mRecentPageIndex, i);
            }
            if (this.mIsEyedropperEnable) {
                spenPaletteViewInterface.setResource(this.mRecentPageIndex, i, this.mEyedropperResource, C7932R.string.pen_string_color_spuit);
            }
        }
    }

    public static /* synthetic */ void updateEyedropper$default(SpenPaletteRecentControl spenPaletteRecentControl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        spenPaletteRecentControl.updateEyedropper(z);
    }

    public final boolean addColor(@NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        float f = color[0];
        float f4 = color[1];
        AbstractC2821a.m2234y(AbstractC0622a.m1176v("addColor() [", f, SQLKeyword.COMMA, f4, SQLKeyword.COMMA), color[2], "]", TAG);
        backupSelectedColor();
        RecentHsvColor recentHsvColor = new RecentHsvColor(color, this.mColorHelper.getColorString(color));
        int iIndexOf = this.mRecentColors.indexOf(recentHsvColor);
        if (iIndexOf > -1) {
            this.mRecentColors.remove(iIndexOf);
        }
        this.mRecentColors.addFirst(recentHsvColor);
        if (this.mRecentColors.size() > this.RECENT_COLOR_MAX) {
            this.mRecentColors.removeLast();
        }
        updateColor();
        restoreSelectedColor();
        return true;
    }

    public final void clearChecked() {
        int displayColorCount = getDisplayColorCount();
        if (displayColorCount > 0 && this.mPaletteView != null) {
            for (int i = 0; i < displayColorCount; i++) {
                SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
                if (spenPaletteViewInterface != null) {
                    spenPaletteViewInterface.setSelected(this.mRecentPageIndex, this.mRecentIndexList[i], false, false);
                }
            }
        }
        this.mSelectedIdx = -1;
    }

    public final void close() {
        this.mColorHelper.close();
        this.mPaletteView = null;
        this.mColorThemeUtil.close();
        this.mRecentColors.clear();
        this.mBackupSelectedColor = null;
    }

    public final int getChildIndex(@Nullable float[] color) {
        int iIndexOf = CollectionsKt.indexOf((List<? extends RecentHsvColor>) this.mRecentColors, color != null ? new RecentHsvColor(color, null) : null);
        if (iIndexOf <= -1 || iIndexOf >= getPossibleColorCount()) {
            return -1;
        }
        return this.mRecentIndexList[iIndexOf];
    }

    public final boolean getRecentColors(@Nullable List<SpenHSVColor> list) {
        if (list == null) {
            return false;
        }
        int size = this.mRecentColors.size();
        for (int i = 0; i < size; i++) {
            RecentHsvColor recentHsvColor = this.mRecentColors.get(i);
            Intrinsics.checkNotNullExpressionValue(recentHsvColor, "get(...)");
            list.add(new SpenHSVColor(recentHsvColor.getMColor()));
        }
        return true;
    }

    public final void initPage(@Nullable int[] recentIndexList, int eyedropperResourceId) {
        if (this.mPaletteView == null) {
            return;
        }
        if (recentIndexList != null) {
            int length = recentIndexList.length;
            for (int i = 0; i < length && i != this.RECENT_COLOR_MAX; i++) {
                this.mRecentIndexList[i] = recentIndexList[i];
            }
        }
        this.mEyedropperResource = eyedropperResourceId;
        updateEyedropper(false);
    }

    public final boolean isEyedropperButton(int childAt) {
        return this.mIsEyedropperEnable && childAt == this.mRecentIndexList[this.RECENT_COLOR_MAX - 1];
    }

    public final void onButtonClick(int childAt, boolean isSelected) {
        if (this.mPaletteView == null) {
            return;
        }
        AbstractC0000a.m26w(AbstractC2821a.m2226q("onButtonClick in Recent. childAt=", childAt, " isSelected=", isSelected, " ColorCount="), TAG, this.mRecentColors.size());
        if (childAt < 0 || childAt >= this.mRecentColors.size()) {
            return;
        }
        if (isSelected) {
            setSelected(childAt, true, true);
            return;
        }
        clearChecked();
        setSelected(childAt, true, true);
        if (this.mOnColorChangeListener != null) {
            RecentHsvColor recentHsvColor = this.mRecentColors.get(childAt);
            Intrinsics.checkNotNullExpressionValue(recentHsvColor, "get(...)");
            float[] fArr = new float[3];
            System.arraycopy(recentHsvColor.getMColor(), 0, fArr, 0, 3);
            OnColorChangeListener onColorChangeListener = this.mOnColorChangeListener;
            if (onColorChangeListener != null) {
                onColorChangeListener.OnColorSelected(0, fArr);
            }
        }
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
        updateColor();
    }

    public final void setEyedropperEnabled(boolean enabled) {
        Log.i(TAG, "setEyedropperEnabled() [" + this.mIsEyedropperEnable + " -> " + enabled + "]");
        if (this.mIsEyedropperEnable == enabled) {
            return;
        }
        this.mIsEyedropperEnable = enabled;
        updateEyedropper(true);
        if (enabled) {
            return;
        }
        int size = this.mRecentColors.size();
        int i = this.RECENT_COLOR_MAX;
        if (size == i) {
            int i2 = this.mRecentIndexList[i - 1];
            RecentHsvColor recentHsvColor = this.mRecentColors.get(i - 1);
            Intrinsics.checkNotNullExpressionValue(recentHsvColor, "get(...)");
            updateColor(i2, recentHsvColor);
        }
    }

    public final void setOnColorChangeListener(@Nullable OnColorChangeListener onColorChangeListener) {
        this.mOnColorChangeListener = onColorChangeListener;
    }

    public final void setPaletteView(@Nullable SpenPaletteViewInterface paletteView) {
        this.mPaletteView = paletteView;
    }

    public final void setRecentColors(@Nullable List<SpenHSVColor> list) {
        initColorList(list);
        updateColor();
    }

    public final void setSelected(int childAt, boolean selected, boolean needAnimation) {
        if (childAt <= -1 || childAt >= getDisplayColorCount()) {
            return;
        }
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        if (spenPaletteViewInterface != null) {
            spenPaletteViewInterface.setSelected(this.mRecentPageIndex, this.mRecentIndexList[childAt], selected, needAnimation);
        }
        if (selected) {
            this.mSelectedIdx = childAt;
        }
    }

    public final void updateColor() {
        int i;
        if (this.mPaletteView != null) {
            int size = this.mRecentColors.size();
            if (this.mIsEyedropperEnable && size == (i = this.RECENT_COLOR_MAX)) {
                size = i - 1;
            }
            for (int i2 = 0; i2 < size; i2++) {
                int i4 = this.mRecentIndexList[i2];
                RecentHsvColor recentHsvColor = this.mRecentColors.get(i2);
                Intrinsics.checkNotNullExpressionValue(recentHsvColor, "get(...)");
                updateColor(i4, recentHsvColor);
            }
            int i5 = this.mIsEyedropperEnable ? this.RECENT_COLOR_MAX - 1 : this.RECENT_COLOR_MAX;
            while (size < i5) {
                SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
                if (spenPaletteViewInterface != null) {
                    spenPaletteViewInterface.resetColor(this.mRecentPageIndex, this.mRecentIndexList[size]);
                }
                size++;
            }
        }
    }
}
