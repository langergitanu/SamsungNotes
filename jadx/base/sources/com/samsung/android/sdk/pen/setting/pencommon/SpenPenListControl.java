package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenList;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 =2\u00020\u0001:\u0002=>B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\fJ\u0016\u0010\u001f\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0019J\u0016\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0005J\u0010\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u0010J\u0006\u0010(\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\fJ\b\u0010*\u001a\u00020\u0005H\u0016J\u001e\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0014\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010/\u001a\u00020\u0015H\u0002J\u0018\u00100\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0016\u00102\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0019H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0005H\u0002J \u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020#2\u0006\u0010%\u001a\u00020!H\u0002J\u0018\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0018\u0010;\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl;", "", "context", "Landroid/content/Context;", "mChildLayoutId", "", "<init>", "(Landroid/content/Context;I)V", "mPenList", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList;", "mPenListInfo", "Ljava/util/HashMap;", "", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenViewInfo;", "Lkotlin/collections/HashMap;", "mOnPenClickListener", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl$OnPenClickListener;", "mCurrentPenIdx", "mViewOnItemClickListener", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList$OnItemClickListener;", "close", "", "setView", "penList", "penNames", "", "initPenResource", "penResources", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "getPenResource", "penName", "setPenInfoList", "infoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setPenInfo", "", "color", "penInfo", "setOnPenClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnselectedPen", "findPenIndex", "getSelectedPenIndex", "initPenItem", "penItem", "Landroid/view/View;", "updatePenItem", "resetValue", "addPenViewInfo", "viewIndex", "initPenViews", "updatePenViews", "updateCurrentInfo", "penIndex", "updatePen", "index", "selected", "getPenView", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenViewInterface;", "updatePenResource", "resource", "Companion", "OnPenClickListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenPenListControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenPenListControl.kt\ncom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n1#2:270\n*E\n"})
public class SpenPenListControl {

    @NotNull
    private static final String TAG = "SpenPenListControl";
    private final int mChildLayoutId;
    private int mCurrentPenIdx;

    @Nullable
    private OnPenClickListener mOnPenClickListener;

    @Nullable
    private SpenPenList mPenList;

    @Nullable
    private HashMap<String, SpenPenViewInfo> mPenListInfo;

    @NotNull
    private final SpenPenList.OnItemClickListener mViewOnItemClickListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl$OnPenClickListener;", "", "onPenClicked", "", "name", "", "isSelected", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnPenClickListener {
        void onPenClicked(@Nullable String name, boolean isSelected);
    }

    public SpenPenListControl(@NotNull Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mChildLayoutId = i;
        this.mCurrentPenIdx = -1;
        this.mViewOnItemClickListener = new SpenPenList.OnItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl$mViewOnItemClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenList.OnItemClickListener
            public void onItemClick(View view, int position) {
                Intrinsics.checkNotNullParameter(view, "view");
                SpenPenListControl.OnPenClickListener onPenClickListener = this.this$0.mOnPenClickListener;
                if (onPenClickListener != null) {
                    onPenClickListener.onPenClicked(view.getTag().toString(), view.isSelected());
                }
            }
        };
    }

    private final void addPenViewInfo(String penName, int viewIndex) {
        HashMap<String, SpenPenViewInfo> map;
        if (viewIndex == -1 || (map = this.mPenListInfo) == null) {
            return;
        }
        map.put(penName, new SpenPenViewInfo(viewIndex));
    }

    private final SpenPenViewInterface getPenView(int viewIndex) {
        SpenPenList spenPenList = this.mPenList;
        if (spenPenList == null || viewIndex < 0 || viewIndex >= spenPenList.getPenCount()) {
            return null;
        }
        return (SpenPenViewInterface) spenPenList.getPenView(viewIndex);
    }

    private final void initPenViews(List<String> penList) {
        SpenPenList spenPenList = this.mPenList;
        if (spenPenList != null) {
            spenPenList.setPenList(penList.size(), this.mChildLayoutId);
            int penCount = spenPenList.getPenCount();
            for (int i = 0; i < penCount; i++) {
                String strInitPenItem = initPenItem(penList.get(i), spenPenList.getPenView(i));
                if (strInitPenItem != null) {
                    addPenViewInfo(strInitPenItem, i);
                } else {
                    Log.i(TAG, "initPenViews() - penName is null (input:)" + ((Object) penList.get(i)));
                }
            }
            spenPenList.setOnItemClickListener(this.mViewOnItemClickListener);
        }
    }

    private final void resetValue() {
        HashMap<String, SpenPenViewInfo> map = this.mPenListInfo;
        if (map != null) {
            map.clear();
        }
        updateCurrentInfo(-1);
    }

    private final void updateCurrentInfo(int penIndex) {
        this.mCurrentPenIdx = penIndex;
    }

    private final void updatePen(int index, boolean selected, SpenSettingPenInfo penInfo) {
        SpenPenViewInterface spenPenViewInterface;
        SpenPenList spenPenList = this.mPenList;
        if (spenPenList == null || index < 0 || index >= spenPenList.getPenCount() || (spenPenViewInterface = (SpenPenViewInterface) spenPenList.getPenView(index)) == null) {
            return;
        }
        spenPenViewInterface.setPenSizeLevel(penInfo.sizeLevel);
        spenPenViewInterface.setPenColorEnabled(selected);
        if (selected) {
            spenPenViewInterface.setPenColor(penInfo.color);
            spenPenViewInterface.setParticleSize(penInfo.particleSize);
            spenPenViewInterface.setFixedWidth(penInfo.isFixedWidth);
            spenPenViewInterface.setFixedOpacity(penInfo.isFixedOpacity);
        }
    }

    private final void updatePenResource(int index, SpenSettingPenResource resource) {
        SpenPenViewInterface penView = getPenView(index);
        if (penView == null || !(penView instanceof SpenPenBaseView)) {
            return;
        }
        ((SpenPenBaseView) penView).setPenResourceInfo(resource);
    }

    private final void updatePenViews() {
        SpenPenList spenPenList = this.mPenList;
        if (spenPenList != null) {
            int penCount = spenPenList.getPenCount();
            for (int i = 0; i < penCount; i++) {
                String strUpdatePenItem = updatePenItem(spenPenList.getPenView(i));
                if (strUpdatePenItem != null) {
                    addPenViewInfo(strUpdatePenItem, i);
                    View penView = spenPenList.getPenView(i);
                    if (penView != null && penView.isSelected()) {
                        updateCurrentInfo(i);
                    }
                }
            }
            spenPenList.setOnItemClickListener(this.mViewOnItemClickListener);
        }
    }

    public void close() {
        resetValue();
        HashMap<String, SpenPenViewInfo> map = this.mPenListInfo;
        if (map != null) {
            map.clear();
        }
        this.mPenListInfo = null;
        this.mOnPenClickListener = null;
        this.mPenList = null;
    }

    public final int findPenIndex(@NotNull String penName) {
        SpenPenViewInfo spenPenViewInfo;
        Intrinsics.checkNotNullParameter(penName, "penName");
        HashMap<String, SpenPenViewInfo> map = this.mPenListInfo;
        if (map == null || (spenPenViewInfo = map.get(penName)) == null) {
            return -1;
        }
        return spenPenViewInfo.getViewIndex();
    }

    @Nullable
    public final SpenSettingPenResource getPenResource(@NotNull String penName) {
        SpenPenViewInfo spenPenViewInfo;
        Intrinsics.checkNotNullParameter(penName, "penName");
        HashMap<String, SpenPenViewInfo> map = this.mPenListInfo;
        if (map == null || (spenPenViewInfo = map.get(penName)) == null) {
            return null;
        }
        return spenPenViewInfo.getMPenResource();
    }

    /* JADX INFO: renamed from: getSelectedPenIndex, reason: from getter */
    public int getMCurrentPenIdx() {
        return this.mCurrentPenIdx;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String initPenItem(@Nullable String penName, @Nullable View penItem) {
        if (penName == null || penItem == 0 || !(penItem instanceof SpenPenViewInterface)) {
            return null;
        }
        Log.i(TAG, "ininPenItem() penName=".concat(penName));
        SpenPenViewInterface spenPenViewInterface = (SpenPenViewInterface) penItem;
        SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
        spenSettingPenInfo.name = penName;
        spenPenViewInterface.setPenInfo(spenSettingPenInfo);
        return spenPenViewInterface.getPenName();
    }

    public final void initPenResource(@NotNull List<SpenSettingPenResource> penResources) {
        Intrinsics.checkNotNullParameter(penResources, "penResources");
        HashMap<String, SpenPenViewInfo> map = this.mPenListInfo;
        if (map != null) {
            for (SpenSettingPenResource spenSettingPenResource : penResources) {
                SpenPenViewInfo spenPenViewInfo = map.get(spenSettingPenResource.getName());
                if (spenPenViewInfo != null) {
                    spenPenViewInfo.setPenResource(spenSettingPenResource);
                    updatePenResource(spenPenViewInfo.getViewIndex(), spenSettingPenResource);
                }
            }
        }
    }

    public final void setOnPenClickListener(@Nullable OnPenClickListener listener) {
        this.mOnPenClickListener = listener;
    }

    public final boolean setPenInfo(@NotNull String penName, int color) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        StringBuilder sb = new StringBuilder("setPenInfo() pen=");
        sb.append(penName);
        sb.append(" color=");
        AbstractC0000a.m26w(sb, TAG, color);
        HashMap<String, SpenPenViewInfo> map = this.mPenListInfo;
        if (map == null) {
            Log.i(TAG, "penListInfo is null");
            return false;
        }
        SpenPenViewInfo spenPenViewInfo = map.get(penName);
        if (spenPenViewInfo == null) {
            Log.i(TAG, "penViewInfo is null");
            return false;
        }
        spenPenViewInfo.setPenColor(color);
        SpenPenList spenPenList = this.mPenList;
        if (spenPenList == null) {
            return false;
        }
        int viewIndex = spenPenViewInfo.getViewIndex();
        updatePen(viewIndex, color);
        spenPenList.selectPen(viewIndex);
        updateCurrentInfo(viewIndex);
        return true;
    }

    public final void setPenInfoList(@Nullable List<? extends SpenSettingPenInfo> infoList) {
        HashMap<String, SpenPenViewInfo> map;
        Log.i(TAG, "setPenInfoList()");
        if (infoList == null || (map = this.mPenListInfo) == null) {
            return;
        }
        for (SpenSettingPenInfo spenSettingPenInfo : infoList) {
            SpenPenViewInfo spenPenViewInfo = map.get(spenSettingPenInfo.name);
            if (spenPenViewInfo != null) {
                spenPenViewInfo.setPenColor(spenSettingPenInfo.color);
                updatePen(spenPenViewInfo.getViewIndex(), spenPenViewInfo.getPenColor());
            }
        }
    }

    public final void setUnselectedPen() {
        int i;
        SpenPenList spenPenList = this.mPenList;
        if (spenPenList == null || (i = this.mCurrentPenIdx) <= -1) {
            return;
        }
        spenPenList.unSelectPen(i);
        SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
        spenSettingPenInfo.color = 0;
        spenSettingPenInfo.sizeLevel = 1;
        spenSettingPenInfo.particleSize = 0.0f;
        spenSettingPenInfo.isFixedWidth = false;
        spenSettingPenInfo.isFixedOpacity = false;
        updatePen(this.mCurrentPenIdx, false, spenSettingPenInfo);
        updateCurrentInfo(-1);
    }

    public void setView(@Nullable SpenPenList penList, @Nullable List<String> penNames) {
        resetValue();
        this.mPenList = penList;
        this.mPenListInfo = new HashMap<>();
        if (penList == null) {
            return;
        }
        if (penList.getPenCount() > 0) {
            AbstractC2322a.m1631u(penList.getPenCount(), "SetView() penCount =", TAG);
            updatePenViews();
        } else if (penNames != null) {
            Log.i(TAG, "SetView() penNames is not null");
            initPenViews(penNames);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String updatePenItem(@Nullable View penItem) {
        if (penItem == 0 || !(penItem instanceof SpenPenViewInterface)) {
            return null;
        }
        return ((SpenPenViewInterface) penItem).getPenName();
    }

    private final void updatePen(int index, int color) {
        SpenPenViewInterface penView = getPenView(index);
        if (penView == null) {
            return;
        }
        penView.setPenColor(color);
        penView.setPenColorEnabled(true);
    }

    public boolean setPenInfo(@NotNull SpenSettingPenInfo penInfo) {
        SpenPenList spenPenList;
        Intrinsics.checkNotNullParameter(penInfo, "penInfo");
        int iFindPenIndex = findPenIndex(penInfo.name);
        if (iFindPenIndex == -1 || (spenPenList = this.mPenList) == null) {
            return false;
        }
        int mSelectedIndex = spenPenList.getMSelectedIndex();
        SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
        spenSettingPenInfo.color = 0;
        spenSettingPenInfo.sizeLevel = 1;
        spenSettingPenInfo.particleSize = 0.0f;
        spenSettingPenInfo.isFixedWidth = false;
        spenSettingPenInfo.isFixedOpacity = false;
        updatePen(mSelectedIndex, false, spenSettingPenInfo);
        updatePen(iFindPenIndex, true, penInfo);
        spenPenList.selectPen(iFindPenIndex);
        updateCurrentInfo(iFindPenIndex);
        return true;
    }
}
