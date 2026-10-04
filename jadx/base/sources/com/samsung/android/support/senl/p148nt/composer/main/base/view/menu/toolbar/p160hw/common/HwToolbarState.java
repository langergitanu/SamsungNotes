package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.app.picker.color.ColorSettingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwToolbarState implements Parcelable {
    public static final Parcelable.Creator<HwToolbarState> CREATOR = new Parcelable.Creator<HwToolbarState>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.common.HwToolbarState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HwToolbarState createFromParcel(Parcel parcel) {
            return new HwToolbarState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HwToolbarState[] newArray(int i) {
            return new HwToolbarState[i];
        }
    };
    private static final String TAG = Logger.createTag("HWToolbarState");
    private final LinkedHashMap<Integer, ColorSettingState> mColorSettingState;
    private int mEyedropperColor;
    private List<Integer> mHWToolbarSelectedMenu;
    private Map<Integer, Integer> mHWToolbarShownSettingViews;
    private boolean mIsLastStateHandwritingHelp;
    private int mLastPenType;
    private int mLayoutOrientation;
    private int mRecentColor;
    private int mRecentStyleColor;
    private int mSelectionChangeStyleViewMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface LastPenType {
    }

    public HwToolbarState() {
        this.mColorSettingState = new LinkedHashMap<>();
        this.mHWToolbarSelectedMenu = new ArrayList();
        this.mHWToolbarShownSettingViews = new HashMap();
        this.mEyedropperColor = 0;
        this.mRecentColor = 0;
        this.mRecentStyleColor = 0;
        this.mLayoutOrientation = -1;
        this.mLastPenType = 2;
        this.mSelectionChangeStyleViewMode = 0;
    }

    public void addSelectedMenu(Integer num) {
        if (this.mHWToolbarSelectedMenu.contains(num)) {
            return;
        }
        this.mHWToolbarSelectedMenu.add(num);
    }

    public void addShownSettingViews(Integer num, Integer num2) {
        if (this.mHWToolbarShownSettingViews.containsKey(num2)) {
            return;
        }
        this.mHWToolbarShownSettingViews.put(num2, num);
    }

    public void clearColorSpoidEnable() {
        Iterator<ColorSettingState> it = this.mColorSettingState.values().iterator();
        while (it.hasNext()) {
            it.next().setColorSpoidEnable(false);
        }
    }

    public void clearShownSettingViews() {
        Logger.m11003i(TAG, "clearShownSettingViews " + this.mHWToolbarShownSettingViews.size());
        this.mHWToolbarShownSettingViews.clear();
    }

    public void copyData(HwToolbarState hwToolbarState) {
        this.mEyedropperColor = hwToolbarState.mEyedropperColor;
        for (Map.Entry<Integer, ColorSettingState> entry : hwToolbarState.mColorSettingState.entrySet()) {
            ColorSettingState colorSettingState = new ColorSettingState();
            colorSettingState.copyData(entry.getValue());
            this.mColorSettingState.put(entry.getKey(), colorSettingState);
        }
        this.mHWToolbarSelectedMenu.clear();
        this.mHWToolbarSelectedMenu.addAll(hwToolbarState.getSelectedMenu());
        this.mHWToolbarShownSettingViews.clear();
        this.mHWToolbarShownSettingViews.putAll(hwToolbarState.getShownSettingViews());
        this.mLayoutOrientation = hwToolbarState.mLayoutOrientation;
        this.mLastPenType = hwToolbarState.mLastPenType;
        this.mSelectionChangeStyleViewMode = hwToolbarState.mSelectionChangeStyleViewMode;
        this.mIsLastStateHandwritingHelp = hwToolbarState.mIsLastStateHandwritingHelp;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getColor(int i) {
        return this.mColorSettingState.get(Integer.valueOf(i)).getColor();
    }

    public int getColorSpoidKey() {
        for (Map.Entry<Integer, ColorSettingState> entry : this.mColorSettingState.entrySet()) {
            if (entry.getValue().isColorSpoidEnable()) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    public int getEyedropperColor() {
        return this.mEyedropperColor;
    }

    public int getLastPenType() {
        return this.mLastPenType;
    }

    public int getLayoutOrientation() {
        return this.mLayoutOrientation;
    }

    public int getPaletteId(int i) {
        return this.mColorSettingState.get(Integer.valueOf(i)).getPaletteId();
    }

    public int getRecentColor() {
        return this.mRecentColor;
    }

    public int getRecentStyleColor() {
        return this.mRecentStyleColor;
    }

    public List<Integer> getSelectedMenu() {
        return this.mHWToolbarSelectedMenu;
    }

    public int getSelectionChangeStyleViewMode() {
        return this.mSelectionChangeStyleViewMode;
    }

    public Map<Integer, Integer> getShownSettingViews() {
        return this.mHWToolbarShownSettingViews;
    }

    public boolean isColorPickerEnable() {
        Iterator<ColorSettingState> it = this.mColorSettingState.values().iterator();
        while (it.hasNext()) {
            if (it.next().isColorPickerEnable()) {
                return true;
            }
        }
        return false;
    }

    public boolean isColorSettingEnable() {
        Iterator<ColorSettingState> it = this.mColorSettingState.values().iterator();
        while (it.hasNext()) {
            if (it.next().isColorSettingEnable()) {
                return true;
            }
        }
        return false;
    }

    public boolean isColorSpoidEnable() {
        Iterator<ColorSettingState> it = this.mColorSettingState.values().iterator();
        while (it.hasNext()) {
            if (it.next().isColorSpoidEnable()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLastStateHandwritingHelp() {
        return this.mIsLastStateHandwritingHelp;
    }

    public boolean isShownSettingViews() {
        return !this.mHWToolbarShownSettingViews.isEmpty();
    }

    public void removeSelectedMenu(Integer num) {
        this.mHWToolbarSelectedMenu.remove(num);
    }

    public void removeShownSettingViews(Integer num) {
        this.mHWToolbarShownSettingViews.remove(num);
    }

    public void setColor(int i, int i2) {
        this.mColorSettingState.get(Integer.valueOf(i)).setColor(i2);
    }

    public void setColorPickerEnable(int i, boolean z) {
        this.mColorSettingState.get(Integer.valueOf(i)).setColorPickerEnable(z);
    }

    public void setColorSettingEnable(int i, boolean z) {
        this.mColorSettingState.get(Integer.valueOf(i)).setColorSettingEnable(z);
    }

    public void setColorSettingState(int i) {
        if (this.mColorSettingState.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.mColorSettingState.put(Integer.valueOf(i), new ColorSettingState());
    }

    public void setColorSpoidEnable(int i, boolean z) {
        this.mColorSettingState.get(Integer.valueOf(i)).setColorSpoidEnable(z);
    }

    public void setEyedropperColor(int i) {
        this.mEyedropperColor = i;
    }

    public void setLastPenType(int i) {
        this.mLastPenType = i;
    }

    public void setLastStateHandwritingHelp(boolean z) {
        this.mIsLastStateHandwritingHelp = z;
        AbstractC8014b.m7224z("setLastStateHandwritingHelp# ", TAG, z);
    }

    public void setLayoutOrientation(int i) {
        this.mLayoutOrientation = i;
    }

    public void setPaletteId(int i, int i2) {
        this.mColorSettingState.get(Integer.valueOf(i)).setPaletteId(i2);
    }

    public void setRecentColor(int i) {
        this.mRecentColor = i;
    }

    public void setRecentStyleColor(int i) {
        this.mRecentStyleColor = i;
    }

    public void setSelectMenu(List<Integer> list) {
        this.mHWToolbarSelectedMenu = list;
    }

    public void setSelectionChangeStyleViewMode(int i) {
        this.mSelectionChangeStyleViewMode = i;
    }

    public String toString() {
        return "\n-@    mHWToolbarSelectedMenu: " + this.mHWToolbarSelectedMenu + "\n-@    mHWToolbarShownSettingViews: " + this.mHWToolbarShownSettingViews + "\n-@    mEyedropperColor: " + this.mEyedropperColor + "\n-@    mColorSettingState: " + this.mColorSettingState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mEyedropperColor);
        parcel.writeInt(this.mColorSettingState.size());
        for (Map.Entry<Integer, ColorSettingState> entry : this.mColorSettingState.entrySet()) {
            parcel.writeInt(entry.getKey().intValue());
            parcel.writeParcelable(entry.getValue(), i);
        }
        parcel.writeList(this.mHWToolbarSelectedMenu);
        parcel.writeMap(this.mHWToolbarShownSettingViews);
        parcel.writeInt(this.mLayoutOrientation);
        parcel.writeInt(this.mLastPenType);
        parcel.writeInt(this.mSelectionChangeStyleViewMode);
        parcel.writeByte(this.mIsLastStateHandwritingHelp ? (byte) 1 : (byte) 0);
    }

    public boolean isShownSettingViews(Integer num) {
        return this.mHWToolbarShownSettingViews.containsKey(num);
    }

    public boolean isColorPickerEnable(int i) {
        return this.mColorSettingState.get(Integer.valueOf(i)).isColorPickerEnable();
    }

    public boolean isColorSettingEnable(int i) {
        return this.mColorSettingState.get(Integer.valueOf(i)).isColorSettingEnable();
    }

    public boolean isColorSpoidEnable(int i) {
        return this.mColorSettingState.get(Integer.valueOf(i)).isColorSpoidEnable();
    }

    public boolean isShownSettingViews(Integer num, Integer num2) {
        return this.mHWToolbarShownSettingViews.containsKey(num2) && Objects.equals(this.mHWToolbarShownSettingViews.get(num2), num);
    }

    public HwToolbarState(Parcel parcel) {
        this.mColorSettingState = new LinkedHashMap<>();
        this.mHWToolbarSelectedMenu = new ArrayList();
        this.mHWToolbarShownSettingViews = new HashMap();
        this.mEyedropperColor = 0;
        this.mRecentColor = 0;
        this.mRecentStyleColor = 0;
        this.mLayoutOrientation = -1;
        this.mLastPenType = 2;
        this.mSelectionChangeStyleViewMode = 0;
        this.mEyedropperColor = parcel.readInt();
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.mColorSettingState.put(Integer.valueOf(parcel.readInt()), (ColorSettingState) ColorSettingState.class.cast(parcel.readParcelable(ColorSettingState.class.getClassLoader())));
        }
        ArrayList arrayList = parcel.readArrayList(Integer.class.getClassLoader());
        this.mHWToolbarSelectedMenu = arrayList;
        if (arrayList == null) {
            this.mHWToolbarSelectedMenu = new ArrayList();
        }
        HashMap hashMap = parcel.readHashMap(Integer.class.getClassLoader());
        this.mHWToolbarShownSettingViews = hashMap;
        if (hashMap == null) {
            this.mHWToolbarShownSettingViews = new HashMap();
        }
        this.mLayoutOrientation = parcel.readInt();
        this.mLastPenType = parcel.readInt();
        this.mSelectionChangeStyleViewMode = parcel.readInt();
        this.mIsLastStateHandwritingHelp = parcel.readByte() != 0;
    }
}
