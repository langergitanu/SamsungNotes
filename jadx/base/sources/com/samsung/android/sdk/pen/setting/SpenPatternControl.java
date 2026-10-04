package com.samsung.android.sdk.pen.setting;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.SpenPatternControl;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternDataManager;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ6\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0013J\u0018\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0013J\u001a\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0018J\u0010\u0010\"\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u000bJ\b\u0010$\u001a\u00020\u000fH\u0002J\u0012\u0010%\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPatternControl;", "", "<init>", "()V", "mDataManager", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternDataManager;", "mPenName", "", "mPatternLayout", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface;", "mChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenPatternControl$OnPatternChangeListener;", "mPatternLayoutChangedListener", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenPatternLayoutInterface$OnPatternChangeListener;", "close", "", "setPatternLayout", "patternLayout", "setPatternInfo", "", "penName", "resourceList", "", "sizeList", "", "needBitmap", "setPattern", "isPatternOwner", "setSize", "size", "needAnimation", "setResource", "resource", "getResourceString", "setOnPatternChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initDefaultPattern", "setPatternDataInLayout", "Companion", "OnPatternChangeListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPatternControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPatternControl.kt\ncom/samsung/android/sdk/pen/setting/SpenPatternControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,145:1\n1#2:146\n*E\n"})
public final class SpenPatternControl {

    @NotNull
    private static final String TAG = "SpenPatterControl";

    @Nullable
    private OnPatternChangeListener mChangedListener;

    @Nullable
    private SpenPatternLayoutInterface mPatternLayout;

    @Nullable
    private String mPenName;

    @NotNull
    private final SpenPatternLayoutInterface.OnPatternChangeListener mPatternLayoutChangedListener = new SpenPatternLayoutInterface.OnPatternChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenPatternControl$mPatternLayoutChangedListener$1
        @Override // com.samsung.android.sdk.pen.setting.patternpalette.SpenPatternLayoutInterface.OnPatternChangeListener
        public void onPatternChanged(String resName, int resId, float size) {
            SpenPatternControl.OnPatternChangeListener onPatternChangeListener = this.this$0.mChangedListener;
            if (onPatternChangeListener != null) {
                onPatternChangeListener.onPatternChanged(resName, size);
            }
        }
    };

    @NotNull
    private SpenPatternDataManager mDataManager = new SpenPatternDataManager();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenPatternControl$OnPatternChangeListener;", "", "onPatternChanged", "", "resName", "", "size", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPatternChangeListener {
        void onPatternChanged(@Nullable String resName, float size);
    }

    public SpenPatternControl() {
        initDefaultPattern();
    }

    private final void initDefaultPattern() {
        Log.i(TAG, "initDefaultPattern()");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("mosaic1");
        arrayList.add("mosaic2");
        arrayList.add("mosaic3");
        arrayList2.add(Float.valueOf(10.0f));
        arrayList2.add(Float.valueOf(15.0f));
        arrayList2.add(Float.valueOf(20.0f));
        setPatternInfo(SpenPenManager.SPEN_MOSAIC_PEN, arrayList, arrayList2, false);
        setPatternInfo(SpenPenManager.SPEN_STRAIGHT_MOSAICPEN, arrayList, arrayList2, false);
        setPatternInfo(SpenPenManager.SPEN_MOSAIC_PEN2, arrayList, arrayList2, false);
        setPatternInfo(SpenPenManager.SPEN_STRAIGHT_MOSAICPEN2, arrayList, arrayList2, false);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        arrayList3.add("draw_blur_1");
        arrayList3.add("draw_blur_2");
        arrayList3.add("draw_blur_3");
        arrayList3.add("draw_blur_4");
        arrayList4.add(Float.valueOf(25.0f));
        arrayList4.add(Float.valueOf(50.0f));
        arrayList4.add(Float.valueOf(75.0f));
        arrayList4.add(Float.valueOf(100.0f));
        setPatternInfo(SpenPenManager.SPEN_BLUR_PEN, arrayList3, arrayList4, false);
        setPatternInfo(SpenPenManager.SPEN_STRAIGHT_BLURPEN, arrayList3, arrayList4, false);
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        arrayList5.add("pattern_1");
        arrayList5.add("pattern_2");
        arrayList5.add("pattern_3");
        arrayList5.add("pattern_4");
        arrayList5.add("pattern_5");
        arrayList5.add("pattern_6");
        arrayList5.add("pattern_7");
        arrayList5.add("pattern_8");
        arrayList6.add(Float.valueOf(0.0f));
        arrayList6.add(Float.valueOf(1.0f));
        arrayList6.add(Float.valueOf(2.0f));
        arrayList6.add(Float.valueOf(3.0f));
        arrayList6.add(Float.valueOf(4.0f));
        arrayList6.add(Float.valueOf(5.0f));
        arrayList6.add(Float.valueOf(6.0f));
        arrayList6.add(Float.valueOf(7.0f));
        setPatternInfo(SpenPenManager.SPEN_PATTERN_IMAGE_PEN, arrayList5, arrayList6, false);
    }

    private final boolean setPatternDataInLayout(String penName) {
        SpenPatternLayoutInterface spenPatternLayoutInterface;
        List<String> resourceList;
        if (penName == null || (spenPatternLayoutInterface = this.mPatternLayout) == null || (resourceList = this.mDataManager.getResourceList(penName)) == null) {
            return false;
        }
        return spenPatternLayoutInterface.setPatternList(resourceList, this.mDataManager.getSizeList(penName));
    }

    public final void close() {
        this.mDataManager.close();
        this.mPatternLayout = null;
    }

    @Nullable
    public final String getResourceString(@Nullable String penName, float size) {
        return this.mDataManager.getResource(penName, size);
    }

    public final boolean isPatternOwner(@Nullable String penName) {
        String str = this.mPenName;
        if (str == null || penName == null) {
            return false;
        }
        Integer numValueOf = str != null ? Integer.valueOf(str.compareTo(penName)) : null;
        return numValueOf != null && numValueOf.intValue() == 0;
    }

    public final void setOnPatternChangedListener(@Nullable OnPatternChangeListener listener) {
        this.mChangedListener = listener;
    }

    public final boolean setPattern(@Nullable String penName) {
        String str = this.mPenName;
        if (str != null && penName != null) {
            Integer numValueOf = str != null ? Integer.valueOf(str.compareTo(penName)) : null;
            if (numValueOf != null && numValueOf.intValue() == 0) {
                return true;
            }
        }
        if (!setPatternDataInLayout(penName)) {
            return false;
        }
        this.mPenName = penName;
        return true;
    }

    public final boolean setPatternInfo(@NotNull String penName, @Nullable List<String> resourceList, @Nullable List<Float> sizeList, boolean needBitmap) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        return this.mDataManager.setPatternInfo(penName, resourceList, sizeList, needBitmap);
    }

    public final void setPatternLayout(@Nullable SpenPatternLayoutInterface patternLayout) {
        String str = this.mPenName;
        if (str == null) {
            str = "null";
        }
        AbstractC6670b.m4756q("setPatternLayout() penName=", str, TAG);
        this.mPatternLayout = patternLayout;
        if (patternLayout != null) {
            patternLayout.setOnPatternChangedListener(this.mPatternLayoutChangedListener);
            setPatternDataInLayout(this.mPenName);
        }
    }

    public final void setResource(@Nullable String resource, boolean needAnimation) {
        SpenPatternLayoutInterface spenPatternLayoutInterface;
        if (resource == null || (spenPatternLayoutInterface = this.mPatternLayout) == null) {
            return;
        }
        spenPatternLayoutInterface.setPattern(resource, needAnimation);
    }

    public final void setSize(float size, boolean needAnimation) {
        Log.i(TAG, "setSize() size=" + size + " animation=" + needAnimation);
        SpenPatternLayoutInterface spenPatternLayoutInterface = this.mPatternLayout;
        if (spenPatternLayoutInterface != null) {
            spenPatternLayoutInterface.setPatternSize(size, needAnimation);
        }
    }
}
