package com.samsung.android.sdk.pen.setting.pencommon;

import android.content.Context;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0011J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPensManager;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenManager", "Lcom/samsung/android/sdk/pen/pen/SpenPenManager;", "mPenPluginInfoList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenPenPluginInfo;", "Lkotlin/collections/ArrayList;", "mPenNumber", "", "close", "", "isSystemValidPen", "", "penName", "", "getPenIndexByPenName", "penInfoList", "getPenInfoList", "()Ljava/util/ArrayList;", "loadPenObject", "isPreviewPen", "initPenInfo", "getPenInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPensManager {

    @NotNull
    private static final String TAG = "SpenPensManager";

    @NotNull
    private SpenPenManager mPenManager;
    private int mPenNumber;

    @NotNull
    private final ArrayList<SpenPenPluginInfo> mPenPluginInfoList = new ArrayList<>();

    public SpenPensManager(@Nullable Context context) {
        this.mPenManager = new SpenPenManager(context);
        initPenInfo();
    }

    private final SpenPenPluginInfo getPenInfo(String penName) {
        Iterator<SpenPenPluginInfo> it = this.mPenPluginInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenPenPluginInfo next = it.next();
            if (Intrinsics.areEqual(next.getMPenName(), penName)) {
                return next;
            }
        }
        return null;
    }

    private final void initPenInfo() {
        List<SpenPenInfo> penInfoList = this.mPenManager.getPenInfoList();
        if (penInfoList == null) {
            Log.i(TAG, "list is null");
            return;
        }
        Log.i(TAG, "list count=" + penInfoList.size());
        this.mPenNumber = 0;
        for (SpenPenInfo spenPenInfo : penInfoList) {
            SpenPenPluginInfo spenPenPluginInfo = new SpenPenPluginInfo();
            spenPenPluginInfo.setName(spenPenInfo);
            this.mPenPluginInfoList.add(spenPenPluginInfo);
            this.mPenNumber++;
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        int size = this.mPenPluginInfoList.size();
        for (int i = 0; i < size; i++) {
            SpenPenPluginInfo spenPenPluginInfo = this.mPenPluginInfoList.get(i);
            Intrinsics.checkNotNullExpressionValue(spenPenPluginInfo, "get(...)");
            SpenPenPluginInfo spenPenPluginInfo2 = spenPenPluginInfo;
            if (spenPenPluginInfo2.getMSpenObject() != null) {
                AbstractC6670b.m4756q("destroy pen object. ", spenPenPluginInfo2.getMPenName(), TAG);
                this.mPenManager.destroyPen(spenPenPluginInfo2.getMSpenObject());
            }
            if (spenPenPluginInfo2.getMSpenPreviewObject() != null) {
                AbstractC6670b.m4756q("destroy preview pen object. ", spenPenPluginInfo2.getMPenName(), TAG);
                this.mPenManager.destroyPreviewPen(spenPenPluginInfo2.getMSpenPreviewObject());
            }
            spenPenPluginInfo2.close();
        }
        this.mPenPluginInfoList.clear();
        this.mPenNumber = 0;
        this.mPenManager.close();
    }

    public final int getPenIndexByPenName(@Nullable String penName) {
        Iterator<SpenPenPluginInfo> it = this.mPenPluginInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getMPenName(), penName)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @NotNull
    public final ArrayList<SpenPenPluginInfo> getPenInfoList() {
        return this.mPenPluginInfoList;
    }

    public final boolean isSystemValidPen(@NotNull String penName) {
        boolean z;
        Exception e;
        Intrinsics.checkNotNullParameter(penName, "penName");
        try {
            z = true;
        } catch (Exception e2) {
            z = false;
            e = e2;
        }
        try {
            this.mPenManager.destroyPen(this.mPenManager.createPen(penName));
            return true;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            Log.i(TAG, "invalid pen. (" + penName + ")");
            return z;
        }
    }

    public final void loadPenObject(@NotNull String penName, boolean isPreviewPen) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenPenPluginInfo penInfo = getPenInfo(penName);
        if (penInfo != null) {
            if (!isPreviewPen) {
                try {
                    if (penInfo.getMSpenObject() == null) {
                        Log.i(TAG, "penManager.createPen() -" + penInfo.getMPenName());
                        penInfo.setPenObject(this.mPenManager.createPen(penInfo.getMPenName()));
                        return;
                    }
                } catch (Exception e) {
                    Log.e(TAG, "loadPenObject", e);
                    return;
                }
            }
            if (isPreviewPen && penInfo.getMSpenPreviewObject() == null) {
                Log.i(TAG, "penManager.createPreviewPen() -" + penInfo.getMPenName());
                penInfo.setPreviewPenObject(this.mPenManager.createPreviewPen(penInfo.getMPenName()));
            }
        }
    }
}
