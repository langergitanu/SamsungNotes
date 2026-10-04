package com.samsung.android.sdk.pen.setting.remover;

import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\b\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bJ\u001b\u0010!\u001a\u00020\u00142\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010#¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0#8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/remover/SpenRemoverDataManager;", "", "<init>", "()V", "mIsSupportStrokeEraseSize", "", "mSizeInfo", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "target", "getTarget", "()I", "setTarget", "(I)V", "currentType", "getCurrentType", "setCurrentType", "close", "", "support", "isSupportStrokeEraseSize", "()Z", "setSupportStrokeEraseSize", "(Z)V", "currentInfo", "Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "getCurrentInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "setCurrentSize", "size", "setInfo", "setInfoList", XmlErrorCodes.LIST, "", "([Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;)V", "getInfo", "type", "infoList", "getInfoList", "()[Lcom/samsung/android/sdk/pen/SpenSettingRemoverInfo;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRemoverDataManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRemoverDataManager.kt\ncom/samsung/android/sdk/pen/setting/remover/SpenRemoverDataManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
public final class SpenRemoverDataManager {

    @NotNull
    private static final String TAG = "SpenRemoverDataManager";
    public static final float TYPE_CUTTER_DEFAULT_SIZE = 1.0f;
    private static final int TYPE_MAX = 2;
    public static final float TYPE_REMOVER_DEFAULT_SIZE = 2.0f;
    private int currentType;
    private boolean mIsSupportStrokeEraseSize;

    @NotNull
    private HashMap<Integer, Float> mSizeInfo;
    private int target;

    public SpenRemoverDataManager() {
        HashMap<Integer, Float> map = new HashMap<>(2);
        this.mSizeInfo = map;
        map.put(0, Float.valueOf(1.0f));
        this.mSizeInfo.put(1, Float.valueOf(2.0f));
        this.target = 0;
        this.currentType = 1;
    }

    public final void close() {
        this.mSizeInfo.clear();
    }

    @NotNull
    public final SpenSettingRemoverInfo getCurrentInfo() {
        if (this.mIsSupportStrokeEraseSize) {
            return getInfo(this.currentType);
        }
        SpenSettingRemoverInfo info = getInfo(0);
        info.type = this.currentType;
        return info;
    }

    public final int getCurrentType() {
        return this.currentType;
    }

    @NotNull
    public final SpenSettingRemoverInfo getInfo(int type) {
        SpenSettingRemoverInfo spenSettingRemoverInfo = new SpenSettingRemoverInfo();
        spenSettingRemoverInfo.type = type;
        Float f = this.mSizeInfo.get(Integer.valueOf(type));
        if (f != null) {
            spenSettingRemoverInfo.size = f.floatValue();
        }
        spenSettingRemoverInfo.target = this.target;
        return spenSettingRemoverInfo;
    }

    @NotNull
    public final SpenSettingRemoverInfo[] getInfoList() {
        int length = getInfoList().length;
        SpenSettingRemoverInfo[] spenSettingRemoverInfoArr = new SpenSettingRemoverInfo[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            spenSettingRemoverInfoArr[i2] = new SpenSettingRemoverInfo();
        }
        for (Map.Entry<Integer, Float> entry : this.mSizeInfo.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            float fFloatValue = entry.getValue().floatValue();
            SpenSettingRemoverInfo spenSettingRemoverInfo = new SpenSettingRemoverInfo();
            spenSettingRemoverInfoArr[i] = spenSettingRemoverInfo;
            spenSettingRemoverInfo.type = iIntValue;
            spenSettingRemoverInfo.size = fFloatValue;
            spenSettingRemoverInfo.target = this.target;
            i++;
        }
        return spenSettingRemoverInfoArr;
    }

    public final int getTarget() {
        return this.target;
    }

    /* JADX INFO: renamed from: isSupportStrokeEraseSize, reason: from getter */
    public final boolean getMIsSupportStrokeEraseSize() {
        return this.mIsSupportStrokeEraseSize;
    }

    public final void setCurrentSize(float size) {
        this.mSizeInfo.put(Integer.valueOf(this.currentType), Float.valueOf(size));
    }

    public final void setCurrentType(int i) {
        this.currentType = i;
    }

    public final void setInfo(@NotNull SpenSettingRemoverInfo currentInfo) {
        Intrinsics.checkNotNullParameter(currentInfo, "currentInfo");
        int i = currentInfo.type;
        float f = currentInfo.size;
        AbstractC0000a.m26w(AbstractC2322a.m1628r("setInfo() type=", i, " size=", f, " target="), TAG, currentInfo.target);
        this.target = currentInfo.target;
        int i2 = currentInfo.type;
        this.currentType = i2;
        if (this.mIsSupportStrokeEraseSize) {
            this.mSizeInfo.put(Integer.valueOf(i2), Float.valueOf(currentInfo.size));
        } else {
            this.mSizeInfo.put(0, Float.valueOf(currentInfo.size));
        }
    }

    public final void setInfoList(@Nullable SpenSettingRemoverInfo[] list) {
        if (this.mIsSupportStrokeEraseSize) {
            if (list != null) {
                AbstractC2322a.m1631u(list.length, "setInfoList() size=", TAG);
            }
            this.mSizeInfo.clear();
            if (list != null) {
                for (SpenSettingRemoverInfo spenSettingRemoverInfo : list) {
                    if (spenSettingRemoverInfo != null) {
                        setInfo(spenSettingRemoverInfo);
                    }
                }
            }
        }
    }

    public final void setSupportStrokeEraseSize(boolean z) {
        Log.i(TAG, "setSupportStrokeEraseSize() [" + this.mIsSupportStrokeEraseSize + " -> " + z + "]");
        this.mIsSupportStrokeEraseSize = z;
    }

    public final void setTarget(int i) {
        this.target = i;
    }
}
