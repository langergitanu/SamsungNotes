package com.samsung.android.sdk.pen.setting.patternpalette;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewInterface;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface;
import com.samsung.android.spen.C7932R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\b\u0000\u0018\u0000 32\u00020\u0001:\u000234B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014J$\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001eJ\u0016\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001cJ\u0016\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0012H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u000f2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\tH\u0002J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\tH\u0002J\u0010\u00100\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\tH\u0002J\u0012\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternViewControl;", "", "mContext", "Landroid/content/Context;", "mPaletteView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewInterface;)V", "value", "", "mSelectedResId", "getMSelectedResId", "()I", "mPatternResList", "", "", "mPatternResIdList", "mPatternSizeList", "", "mListener", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface$OnPatternChangeListener;", "mPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteViewActionListener;", "close", "", "setOnPatternChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPatternList", "", "patternRes", "", "sizeList", "setPattern", "patternResId", "needAnimation", "setPatternSize", "patternSize", "findChildIdx", "id", "findChildIdxBySize", "size", "getPatternString", "childIdx", "getPatternId", "getPatternSize", "setPatternByChildIdx", "clearChecked", "pageIndex", "notifyPatternChanged", "getDrawableId", "drawable", "Companion", "OnPatternChangeListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPatternViewControl {
    private static final int NO_SELECTED_PATTERN = 0;

    @NotNull
    private static final String TAG = "SpenPatternViewControl";
    private static final int TOTAL_PATTERN_COUNT = 9;

    @NotNull
    private final Context mContext;

    @Nullable
    private SpenPatternLayoutInterface.OnPatternChangeListener mListener;

    @NotNull
    private final SpenPaletteViewActionListener mPaletteActionListener;

    @NotNull
    private SpenPaletteViewInterface mPaletteView;

    @NotNull
    private List<Integer> mPatternResIdList;

    @NotNull
    private List<String> mPatternResList;

    @NotNull
    private List<Float> mPatternSizeList;
    private int mSelectedResId;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternViewControl$OnPatternChangeListener;", "", "onPatternChanged", "", "resName", "", "resId", "", "size", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPatternChangeListener {
        void onPatternChanged(@Nullable String resName, int resId, float size);
    }

    public SpenPatternViewControl(@NotNull Context mContext, @NotNull SpenPaletteViewInterface mPaletteView) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mPaletteView, "mPaletteView");
        this.mContext = mContext;
        this.mPaletteView = mPaletteView;
        this.mPaletteActionListener = new SpenPaletteViewActionListener() { // from class: com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternViewControl$mPaletteActionListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onButtonClick(int pageIndex, int childAt, boolean isSelected) {
                if (isSelected) {
                    this.this$0.setPatternByChildIdx(childAt, true);
                    return;
                }
                AbstractC2322a.m1631u(childAt, "onButtonClick() childAt=", "SpenPatternViewControl");
                this.this$0.setPatternByChildIdx(childAt, true);
                this.this$0.notifyPatternChanged(childAt);
            }

            @Override // com.samsung.android.sdk.pen.setting.colorpalette.SpenPaletteViewActionListener
            public void onPaletteSwipe(int pageIndex, int direction) {
            }
        };
        this.mSelectedResId = 0;
        this.mPatternResList = new ArrayList();
        this.mPatternResIdList = new ArrayList();
        this.mPatternSizeList = new ArrayList();
    }

    private final void clearChecked(int pageIndex) {
        int size = this.mPatternResList.size();
        for (int i = 0; i < size; i++) {
            this.mPaletteView.setSelected(pageIndex, i, false, false);
        }
    }

    private final int findChildIdx(int id) {
        if (id == 0) {
            return -1;
        }
        return this.mPatternResIdList.indexOf(Integer.valueOf(id));
    }

    private final int findChildIdxBySize(float size) {
        if (size == 0.0f) {
            return -1;
        }
        return this.mPatternSizeList.indexOf(Float.valueOf(size));
    }

    private final int getDrawableId(String drawable) {
        int identifier = this.mContext.getResources().getIdentifier(drawable, "drawable", this.mContext.getPackageName());
        if (identifier == 0) {
            Log.e(TAG, "Resource is not founded");
        }
        return identifier;
    }

    private final int getPatternId(int childIdx) {
        if (childIdx == -1 || this.mPatternResIdList.size() <= childIdx) {
            return 0;
        }
        return this.mPatternResIdList.get(childIdx).intValue();
    }

    private final float getPatternSize(int childIdx) {
        if (childIdx == -1 || this.mPatternSizeList.size() <= childIdx) {
            return 0.0f;
        }
        return this.mPatternSizeList.get(childIdx).floatValue();
    }

    private final String getPatternString(int childIdx) {
        if (childIdx == -1 || this.mPatternResList.size() <= childIdx) {
            return null;
        }
        return this.mPatternResList.get(childIdx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPatternChanged(int childIdx) {
        AbstractC2322a.m1631u(childIdx, "notifyPatternChanged() childIdx=", TAG);
        SpenPatternLayoutInterface.OnPatternChangeListener onPatternChangeListener = this.mListener;
        if (onPatternChangeListener != null) {
            onPatternChangeListener.onPatternChanged(getPatternString(childIdx), getPatternId(childIdx), getPatternSize(childIdx));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setPatternByChildIdx(int childIdx, boolean needAnimation) {
        this.mSelectedResId = getPatternId(childIdx);
        clearChecked(0);
        if (this.mSelectedResId == 0) {
            AbstractC2322a.m1631u(childIdx, "pattern is not existed. id=", TAG);
            return false;
        }
        this.mPaletteView.setSelected(0, childIdx, true, needAnimation);
        return true;
    }

    public final void close() {
        this.mPatternResList.clear();
        this.mPatternResIdList.clear();
        this.mPatternSizeList.clear();
        this.mListener = null;
    }

    public final int getMSelectedResId() {
        return this.mSelectedResId;
    }

    public final void setOnPatternChangedListener(@Nullable SpenPatternLayoutInterface.OnPatternChangeListener listener) {
        this.mListener = listener;
    }

    public final boolean setPattern(int patternResId, boolean needAnimation) {
        return setPatternByChildIdx(findChildIdx(patternResId), needAnimation);
    }

    public final boolean setPatternList(@NotNull List<String> patternRes, @Nullable List<Float> sizeList) {
        Intrinsics.checkNotNullParameter(patternRes, "patternRes");
        AbstractC2322a.m1631u(patternRes.size(), "setPatternList() size=", TAG);
        this.mPatternResList.clear();
        this.mPatternResIdList.clear();
        this.mPatternSizeList.clear();
        int iMin = (int) Math.min(patternRes.size(), 9.0d);
        for (int i = 0; i < iMin; i++) {
            int drawableId = getDrawableId(patternRes.get(i));
            if (drawableId != 0) {
                this.mPatternResList.add(patternRes.get(i));
                this.mPatternResIdList.add(Integer.valueOf(drawableId));
                if (sizeList == null || sizeList.size() <= i) {
                    this.mPatternSizeList.add(Float.valueOf(0.0f));
                } else {
                    this.mPatternSizeList.add(sizeList.get(i));
                }
            }
        }
        SpenPaletteViewInterface spenPaletteViewInterface = this.mPaletteView;
        spenPaletteViewInterface.setPaletteActionListener(null);
        spenPaletteViewInterface.setPaletteInfo(1);
        int size = this.mPatternResIdList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Resources resources = this.mContext.getResources();
            SpenPaletteViewInterface.DefaultImpls.setResource$default(this.mPaletteView, 0, i2, this.mPatternResIdList.get(i2).intValue(), resources != null ? resources.getString(C7932R.string.pen_string_lever, Integer.valueOf(i2 + 1), Integer.valueOf(this.mPatternResIdList.size())) : null, 0, 16, null);
        }
        int i4 = this.mSelectedResId;
        if (i4 != 0) {
            setPattern(i4, false);
        }
        this.mPaletteView.setPaletteActionListener(this.mPaletteActionListener);
        return true;
    }

    public final boolean setPatternSize(float patternSize, boolean needAnimation) {
        return setPatternByChildIdx(findChildIdxBySize(patternSize), needAnimation);
    }
}
