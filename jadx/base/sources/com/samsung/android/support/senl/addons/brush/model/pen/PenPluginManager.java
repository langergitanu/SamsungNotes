package com.samsung.android.support.senl.addons.brush.model.pen;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0002J.\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u0015\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenPluginManager;", "", "<init>", "()V", "mSpenManager", "Lcom/samsung/android/sdk/pen/pen/SpenPenManager;", "mPenPluginInfoList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenPluginInfo;", "Lkotlin/collections/ArrayList;", "initialize", "", "manager", "close", "initPenPlugin", "updatePenInfo", "model", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModel;", "loadPenObject", "penName", "", "penPluginInfo", "enableAlpha", "penInfoBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenPluginManager {

    @NotNull
    private final ArrayList<PenPluginInfo> mPenPluginInfoList = new ArrayList<>();

    @Nullable
    private SpenPenManager mSpenManager;

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenPluginManager");

    @JvmField
    @NotNull
    public static final PenPluginManager INSTANCE = new PenPluginManager();

    private PenPluginManager() {
    }

    private final void enableAlpha(PenModel model, String penName, StringBuilder penInfoBuilder, PenPluginInfo penPluginInfo) {
        if (penPluginInfo.getPenObject() != null) {
            SpenPen penObject = penPluginInfo.getPenObject();
            Intrinsics.checkNotNull(penObject);
            boolean penAttribute = penObject.getPenAttribute(1);
            if (penAttribute) {
                model.enableAlpha();
            }
            penInfoBuilder.append(penName);
            penInfoBuilder.append('/');
            penInfoBuilder.append(penAttribute);
            penInfoBuilder.append(':');
        }
    }

    private final void initPenPlugin() {
        List<SpenPenInfo> penInfoList;
        SpenPenManager spenPenManager = this.mSpenManager;
        if (spenPenManager == null || (penInfoList = spenPenManager.getPenInfoList()) == null) {
            return;
        }
        int i = 0;
        for (SpenPenInfo spenPenInfo : penInfoList) {
            if (spenPenInfo != null) {
                PenPluginInfo penPluginInfo = new PenPluginInfo();
                penPluginInfo.setName(spenPenInfo);
                this.mPenPluginInfoList.add(penPluginInfo);
                i++;
            }
        }
        Logger.m7104i(TAG, "init pen : #" + i);
    }

    private final void loadPenObject(String penName, PenPluginInfo penPluginInfo) {
        try {
            SpenPenManager spenPenManager = this.mSpenManager;
            Intrinsics.checkNotNull(spenPenManager);
            SpenPen spenPenCreatePreviewPen = spenPenManager.createPreviewPen(penName);
            if (spenPenCreatePreviewPen != null) {
                penPluginInfo.setPenObject(spenPenCreatePreviewPen);
            }
        } catch (Exception e) {
            Logger.m7101e(TAG, "updatePenInfo : " + penName + " / " + e.getMessage());
        }
    }

    public final void close() {
        Iterator<PenPluginInfo> it = this.mPenPluginInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            PenPluginInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            PenPluginInfo penPluginInfo = next;
            if (penPluginInfo.getPenObject() != null) {
                SpenPen penObject = penPluginInfo.getPenObject();
                Intrinsics.checkNotNull(penObject);
                penObject.setBitmap(null);
                SpenPenManager spenPenManager = this.mSpenManager;
                Intrinsics.checkNotNull(spenPenManager);
                spenPenManager.destroyPreviewPen(penPluginInfo.getPenObject());
                penPluginInfo.close();
            }
        }
        this.mPenPluginInfoList.clear();
        SpenPenManager spenPenManager2 = this.mSpenManager;
        if (spenPenManager2 != null) {
            Intrinsics.checkNotNull(spenPenManager2);
            spenPenManager2.close();
            this.mSpenManager = null;
        }
    }

    public final void initialize(@Nullable SpenPenManager manager) {
        this.mSpenManager = manager;
        initPenPlugin();
    }

    public final void updatePenInfo(@NotNull PenModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (this.mSpenManager == null) {
            return;
        }
        String mPenClassName = model.getMPenClassName();
        StringBuilder sbM1324q = AbstractC1974b.m1324q("update pen info : ");
        Iterator<PenPluginInfo> it = this.mPenPluginInfoList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            PenPluginInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            PenPluginInfo penPluginInfo = next;
            if (Intrinsics.areEqual(penPluginInfo.getPenName(), mPenClassName)) {
                if (penPluginInfo.getPenObject() == null) {
                    loadPenObject(mPenClassName, penPluginInfo);
                }
                Intrinsics.checkNotNull(sbM1324q);
                enableAlpha(model, mPenClassName, sbM1324q, penPluginInfo);
            }
        }
        Logger.m7100d(TAG, String.valueOf(sbM1324q));
    }
}
