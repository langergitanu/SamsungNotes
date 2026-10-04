package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenList;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl;
import com.samsung.android.sdk.pen.setting.pencommon.SpenPenViewInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J.\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0004J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0004J \u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00182\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0002J\u0016\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0002J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0002R.\u0010\b\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\tj\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenListControl;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenListControl;", "context", "Landroid/content/Context;", "childLayoutId", "", "<init>", "(Landroid/content/Context;I)V", "mViewInfoList", "Ljava/util/HashMap;", "", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenViewInfo;", "Lkotlin/collections/HashMap;", "close", "", "initPenItem", "penName", "penItem", "Landroid/view/View;", "updatePenItem", "setView", "penList", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenList;", "penNames", "", "penViewInfoList", "hasUserBrushInfo", "", "getBrushPenViewInfo", "updatePenNames", "initPenViewInfoList", "setBrushInfo", "brushPenView", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenViewInterface;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenBrushPenListControl extends SpenPenListControl {

    @NotNull
    private HashMap<String, SpenBrushPenViewInfo> mViewInfoList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushPenListControl(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mViewInfoList = new HashMap<>();
    }

    private final void initPenViewInfoList(List<SpenBrushPenViewInfo> penViewInfoList) {
        this.mViewInfoList.clear();
        for (SpenBrushPenViewInfo spenBrushPenViewInfo : penViewInfoList) {
            this.mViewInfoList.put(spenBrushPenViewInfo.getPenName(), spenBrushPenViewInfo);
        }
    }

    private final void setBrushInfo(String penName, SpenBrushPenViewInterface brushPenView) {
        SpenBrushPenViewInfo brushPenViewInfo = getBrushPenViewInfo(penName);
        if (brushPenViewInfo != null) {
            brushPenView.setPenResourceInfo(penName, brushPenViewInfo.getPenStringId(), brushPenViewInfo.getPenResourceId(), brushPenViewInfo.getPenMaskResourceId(), brushPenViewInfo.getPenMaskStrokeResourceId());
            brushPenView.setMaskPosition(brushPenViewInfo.getUpperWeight(), brushPenViewInfo.getMaskWeight(), brushPenViewInfo.getBottomWeight());
        }
    }

    private final List<String> updatePenNames(List<String> penNames) {
        if (penNames == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : penNames) {
            if (hasUserBrushInfo(str) || SpenBrushPenResource.isPenResourceDefaultSupported(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl
    public void close() {
        this.mViewInfoList.clear();
        super.close();
    }

    @Nullable
    public final SpenBrushPenViewInfo getBrushPenViewInfo(@Nullable String penName) {
        return this.mViewInfoList.get(penName);
    }

    public final boolean hasUserBrushInfo(@Nullable String penName) {
        return this.mViewInfoList.containsKey(penName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl
    @Nullable
    public String initPenItem(@Nullable String penName, @Nullable View penItem) {
        if (penName == null || penItem == 0 || !(penItem instanceof SpenPenViewInterface) || !(penItem instanceof SpenBrushPenViewInterface)) {
            return null;
        }
        SpenPenViewInterface spenPenViewInterface = (SpenPenViewInterface) penItem;
        if (hasUserBrushInfo(penName)) {
            setBrushInfo(penName, (SpenBrushPenViewInterface) penItem);
        } else {
            SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
            spenSettingPenInfo.name = penName;
            spenPenViewInterface.setPenInfo(spenSettingPenInfo);
        }
        return spenPenViewInterface.getPenName();
    }

    public final void setView(@Nullable SpenPenList penList, @Nullable List<String> penNames, @NotNull List<SpenBrushPenViewInfo> penViewInfoList) {
        Intrinsics.checkNotNullParameter(penViewInfoList, "penViewInfoList");
        initPenViewInfoList(penViewInfoList);
        super.setView(penList, updatePenNames(penNames));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.sdk.pen.setting.pencommon.SpenPenListControl
    @Nullable
    public String updatePenItem(@Nullable View penItem) {
        SpenPenViewInterface spenPenViewInterface;
        String penName;
        if (penItem == 0 || !(penItem instanceof SpenPenViewInterface) || !(penItem instanceof SpenBrushPenViewInterface) || (penName = (spenPenViewInterface = (SpenPenViewInterface) penItem).getPenName()) == null) {
            return null;
        }
        if (hasUserBrushInfo(penName)) {
            setBrushInfo(penName, (SpenBrushPenViewInterface) penItem);
            return penName;
        }
        SpenSettingPenInfo spenSettingPenInfo = new SpenSettingPenInfo();
        spenSettingPenInfo.name = penName;
        spenPenViewInterface.setPenInfo(spenSettingPenInfo);
        return penName;
    }
}
