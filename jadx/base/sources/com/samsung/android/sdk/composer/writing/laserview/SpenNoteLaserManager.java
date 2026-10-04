package com.samsung.android.sdk.composer.writing.laserview;

import android.content.Context;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.engine.SpenLatencyConfiguration;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R(\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager;", "", "mContext", "Landroid/content/Context;", "handle", "", "<init>", "(Landroid/content/Context;J)V", "mLaserView", "mSpenLatencyConfiguration", "Lcom/samsung/android/sdk/pen/engine/SpenLatencyConfiguration;", "mIsPredictionEnabled", "", "mInfo", "Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "mDocumentWidth", "", "mDocumentHeight", "close", "", "setDocumentSize", "width", "height", "type", "getType", "()I", "setPredictionEnabled", "enable", "info", "laserPenInfo", "getLaserPenInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "setLaserPenInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;)V", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenNoteLaserManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int LASERPEN_TYPE_MAX = 2;
    public static final int LASERPEN_TYPE_POINT = 0;
    public static final int LASERPEN_TYPE_STROKE = 1;

    @NotNull
    private static final String TAG = "SpenNoteLaserManager";

    @NotNull
    private final Context mContext;
    private int mDocumentHeight;
    private int mDocumentWidth;

    @Nullable
    private SpenSettingUILaserPenInfo mInfo;
    private boolean mIsPredictionEnabled;
    private long mLaserView;

    @Nullable
    private SpenLatencyConfiguration mSpenLatencyConfiguration;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0083 J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/writing/laserview/SpenNoteLaserManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "LASERPEN_TYPE_POINT", "", "LASERPEN_TYPE_STROKE", "LASERPEN_TYPE_MAX", "Native_setPredictionType", "", "nativeHandle", "", "type", "Native_setLaserPenInfo", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean Native_setLaserPenInfo(long nativeHandle, SpenSettingUILaserPenInfo info) {
            return SpenNoteLaserManager.Native_setLaserPenInfo(nativeHandle, info);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setPredictionType(long nativeHandle, int type) {
            SpenNoteLaserManager.Native_setPredictionType(nativeHandle, type);
        }

        private Companion() {
        }
    }

    public SpenNoteLaserManager(@NotNull Context mContext, long j) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mLaserView = j;
        this.mSpenLatencyConfiguration = new SpenLatencyConfiguration(mContext);
        setPredictionEnabled(true);
        this.mInfo = new SpenSettingUILaserPenInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_setLaserPenInfo(long j, SpenSettingUILaserPenInfo spenSettingUILaserPenInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setPredictionType(long j, int i);

    public final void close() {
        this.mLaserView = 0L;
        SpenLatencyConfiguration spenLatencyConfiguration = this.mSpenLatencyConfiguration;
        if (spenLatencyConfiguration != null) {
            spenLatencyConfiguration.close();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: getLaserPenInfo, reason: from getter */
    public final SpenSettingUILaserPenInfo getMInfo() {
        return this.mInfo;
    }

    public final int getType() {
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = this.mInfo;
        if (spenSettingUILaserPenInfo != null) {
            return spenSettingUILaserPenInfo.type;
        }
        return 0;
    }

    public final void setDocumentSize(int width, int height) {
        this.mDocumentWidth = width;
        this.mDocumentHeight = height;
    }

    public final void setLaserPenInfo(@Nullable SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        if (this.mLaserView == 0 || spenSettingUILaserPenInfo == null) {
            return;
        }
        this.mInfo = new SpenSettingUILaserPenInfo(spenSettingUILaserPenInfo);
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo2 = new SpenSettingUILaserPenInfo(spenSettingUILaserPenInfo);
        if (spenSettingUILaserPenInfo2.fillInside) {
            spenSettingUILaserPenInfo2.insideRatio = 0.0f;
        }
        float fConvertSizeLevelToPxSize = SpenPenUtil.convertSizeLevelToPxSize(SpenPenManager.SPEN_LASER_PEN, (int) spenSettingUILaserPenInfo.strokeSize, this.mDocumentWidth, this.mDocumentHeight);
        spenSettingUILaserPenInfo2.strokeSize = fConvertSizeLevelToPxSize;
        Log.i(TAG, "setLaserPenInfo: sizeLevel= " + spenSettingUILaserPenInfo.strokeSize + " size= " + fConvertSizeLevelToPxSize);
        INSTANCE.Native_setLaserPenInfo(this.mLaserView, spenSettingUILaserPenInfo2);
    }

    public final void setPredictionEnabled(boolean enable) {
        AbstractC6670b.m4759t("setPredictionEnabled() enable = ", TAG, enable);
        SpenLatencyConfiguration spenLatencyConfiguration = this.mSpenLatencyConfiguration;
        int supportPrediction = spenLatencyConfiguration != null ? spenLatencyConfiguration.getSupportPrediction() : 0;
        if (supportPrediction == 0) {
            return;
        }
        this.mIsPredictionEnabled = enable;
        long j = this.mLaserView;
        if (j != 0) {
            INSTANCE.Native_setPredictionType(j, supportPrediction);
        }
    }
}
