package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.pencommon.SpenUIPolicy;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushUIPolicy;", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenUIPolicy;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPenList", "", "", "close", "", "checkPenInfo", "", "uiPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushUIPolicy extends SpenUIPolicy {
    public static final int CHANGE_TYPE_COLOR = 4;
    public static final int CHANGE_TYPE_INVALID = -1;
    public static final int CHANGE_TYPE_NONE = 0;
    public static final int CHANGE_TYPE_PEN = 1;
    public static final int CHANGE_TYPE_SIZE = 2;

    @NotNull
    private static final String TAG = "SpenPenUIPolicy";

    @NotNull
    private Context mContext;

    @NotNull
    private List<String> mPenList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String[] mDefaultPenNameList = {SpenPenManager.SPEN_WATER_BRUSH, SpenPenManager.SPEN_OIL_BRUSH3, SpenPenManager.SPEN_BRUSH_PEN, SpenPenManager.SPEN_PENCIL3, SpenPenManager.SPEN_SMUDGE, SpenPenManager.SPEN_AIR_BRUSH_PEN, SpenPenManager.SPEN_MARKER2, SpenPenManager.SPEN_CRAYON2};

    @NotNull
    private static final String[] mPenDevicePenNameList = {SpenPenManager.SPEN_COLORED_PENCIL};

    @NotNull
    private static final int[] mPenDevicePenPosList = {4};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010#\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushUIPolicy$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mDefaultPenNameList", "", "[Ljava/lang/String;", "mPenDevicePenNameList", "mPenDevicePenPosList", "", "getPenNameList", "", "context", "Landroid/content/Context;", "hasPenFeature", "", "CHANGE_TYPE_INVALID", "", "CHANGE_TYPE_NONE", "CHANGE_TYPE_PEN", "CHANGE_TYPE_SIZE", "CHANGE_TYPE_COLOR", "checkPenInfo", "uiPenInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "getChangeType", "changeType", "isChangedColor", "isChangedSize", "isUsingPen", "penName", "isEraserPen", "checkPenColor", "checkPenSize", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean checkPenColor(SpenSettingUIPenInfo uiPenInfo) {
            SpenUIPolicy.Companion companion = SpenUIPolicy.INSTANCE;
            return SpenUIPolicy.isChangedPenColor(uiPenInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean checkPenSize(Context context, SpenSettingUIPenInfo uiPenInfo) {
            int i = uiPenInfo.sizeLevel;
            if (i < 0 || i > 100) {
                uiPenInfo.sizeLevel = 0;
            }
            SpenUIPolicy.Companion companion = SpenUIPolicy.INSTANCE;
            return SpenUIPolicy.isChangedPenSize(context, uiPenInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getChangeType(int changeType, boolean isChangedColor, boolean isChangedSize) {
            if (changeType == 1) {
                return changeType;
            }
            if (isChangedColor) {
                changeType |= 4;
            }
            return isChangedSize ? changeType | 2 : changeType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isEraserPen(String penName) {
            return StringsKt.m14162r(penName, "Eraser");
        }

        private final boolean isUsingPen(Context context, String penName) {
            for (String str : getPenNameList(hasPenFeature(context))) {
                Intrinsics.checkNotNullExpressionValue(str, "next(...)");
                if (str.compareTo(penName) == 0) {
                    return true;
                }
            }
            return isEraserPen(penName);
        }

        @JvmStatic
        public final int checkPenInfo(@NotNull Context context, @NotNull SpenSettingUIPenInfo uiPenInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
            if (!isUsingPen(context, uiPenInfo.name)) {
                return -1;
            }
            boolean zCheckPenColor = checkPenColor(uiPenInfo);
            boolean zCheckPenSize = checkPenSize(context, uiPenInfo);
            AbstractC6670b.m4758s("isValidPenInfo() changeType=0 isChangedColor=", " isChangedSize=", SpenBrushUIPolicy.TAG, zCheckPenColor, zCheckPenSize);
            return getChangeType(0, zCheckPenColor, zCheckPenSize);
        }

        @JvmStatic
        @NotNull
        public final List<String> getPenNameList(@Nullable Context context) {
            return getPenNameList(hasPenFeature(context));
        }

        @JvmStatic
        public final boolean hasPenFeature(@Nullable Context context) {
            if (context != null) {
                return Spen.INSTANCE.hasPenFeature(context);
            }
            return false;
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final List<String> getPenNameList(boolean hasPenFeature) {
            ArrayList arrayList = new ArrayList();
            int length = SpenBrushUIPolicy.mDefaultPenNameList.length;
            for (int i = 0; i < length; i++) {
                arrayList.add(SpenBrushUIPolicy.mDefaultPenNameList[i]);
            }
            if (hasPenFeature) {
                int length2 = SpenBrushUIPolicy.mPenDevicePenNameList.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    arrayList.add(SpenBrushUIPolicy.mPenDevicePenPosList[i2], SpenBrushUIPolicy.mPenDevicePenNameList[i2]);
                }
            }
            return arrayList;
        }
    }

    public SpenBrushUIPolicy(@NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mPenList = new ArrayList();
        Companion companion = INSTANCE;
        this.mPenList.addAll(companion.getPenNameList(companion.hasPenFeature(this.mContext)));
    }

    @JvmStatic
    public static final int checkPenInfo(@NotNull Context context, @NotNull SpenSettingUIPenInfo spenSettingUIPenInfo) {
        return INSTANCE.checkPenInfo(context, spenSettingUIPenInfo);
    }

    @JvmStatic
    @NotNull
    public static final List<String> getPenNameList(@Nullable Context context) {
        return INSTANCE.getPenNameList(context);
    }

    @JvmStatic
    public static final boolean hasPenFeature(@Nullable Context context) {
        return INSTANCE.hasPenFeature(context);
    }

    public final void close() {
        this.mPenList.clear();
    }

    @JvmStatic
    @NotNull
    public static final List<String> getPenNameList(boolean z) {
        return INSTANCE.getPenNameList(z);
    }

    public final int checkPenInfo(@NotNull SpenSettingUIPenInfo uiPenInfo) {
        Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
        Iterator<String> it = this.mPenList.iterator();
        while (true) {
            if (it.hasNext()) {
                String next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (next.compareTo(uiPenInfo.name) == 0) {
                    break;
                }
            } else if (!INSTANCE.isEraserPen(uiPenInfo.name)) {
                return -1;
            }
        }
        Companion companion = INSTANCE;
        boolean zCheckPenColor = companion.checkPenColor(uiPenInfo);
        boolean zCheckPenSize = companion.checkPenSize(this.mContext, uiPenInfo);
        AbstractC6670b.m4758s("checkPenInfo() changeType=0 isChangedColor=", " isChangedSize=", TAG, zCheckPenColor, zCheckPenSize);
        return companion.getChangeType(0, zCheckPenColor, zCheckPenSize);
    }
}
