package com.samsung.android.support.senl.p148nt.base.common.util;

import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\bÆ\u0002\u0018\u00002\u00020\u0001:\u001f\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mFeature", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "getFeature", "Factory", "subName", "Feature", "MSeries", "ASeries", "SSeries", "S10S20", "S21S22S23", "S24", "S25", "S26", "NoteSeries", "Note10", "Note20", "TabletSeries", "FlagshipTablet", "TabS7", "TabS8", "TabS9", "TabS10orHigher", "FoldableSeries", "FlipModel", "Flip7", "Fold1", "Fold2", "Fold3", "Fold4", "Fold5", "Fold6", "Fold7", "ChinaModel", "JapanModel", "LowEndModel", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ModelFeature {

    @NotNull
    public static final ModelFeature INSTANCE = new ModelFeature();

    @NotNull
    private static final String TAG = "ModelFeature";

    @Nullable
    private static Feature mFeature;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$ASeries;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ASeries extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$ASeries$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return (StringsKt.m14145S(subName, "A30") || StringsKt.m14145S(subName, "A10") || StringsKt.m14145S(subName, "A20")) ? new LowEndModel() : new ASeries();
            }

            private Companion() {
            }
        }

        public ASeries() {
            setDefaultViewModeGridSmall(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$ChinaModel;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ChinaModel extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$ChinaModel$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return StringsKt.m14145S(subName, "W2022") ? new Fold3() : StringsKt.m14145S(subName, "W9023") ? new Fold4() : StringsKt.m14145S(subName, "W9024") ? new Fold5() : StringsKt.m14145S(subName, "W9025") ? new Fold6() : StringsKt.m14145S(subName, "W9026") ? new Fold7() : (StringsKt.m14145S(subName, "W7023") || StringsKt.m14145S(subName, "W7024") || StringsKt.m14145S(subName, "W7025")) ? new FlipModel() : new ChinaModel();
            }

            private Companion() {
            }
        }

        public ChinaModel() {
            setDefaultViewModeGridSmall(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b-\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001a\u0010#\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001a\u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u0011\u00101\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u0010\u0006¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "", "<init>", "()V", "isWinnerDevice", "", "()Z", "setWinnerDevice", "(Z)V", "isTopDevice", "setTopDevice", "isQ2Device", "setQ2Device", "isQ4Device", "setQ4Device", "isQ5Device", "setQ5Device", "isQ6Device", "setQ6Device", "isQ7Device", "setQ7Device", "isB7Device", "setB7Device", "isS25Device", "setS25Device", "isS26Device", "setS26Device", "isFlipDevice", "setFlipDevice", "isDefaultViewModeSimpleList", "setDefaultViewModeSimpleList", "isDefaultViewModeGridSmall", "setDefaultViewModeGridSmall", "isSupportDocumentScan", "setSupportDocumentScan", "isSupportInAppServer", "setSupportInAppServer", "isSupportInAppClient", "setSupportInAppClient", "mNeedAntiGreenish", "getMNeedAntiGreenish", "setMNeedAntiGreenish", "needAntiGreenish", "mNeedNoThumbnailSimpleList", "getMNeedNoThumbnailSimpleList", "setMNeedNoThumbnailSimpleList", "needNoThumbnailSimpleList", "isSupportSolveMath", "setSupportSolveMath", "isFoldableModel", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class Feature {
        private boolean isB7Device;
        private boolean isDefaultViewModeGridSmall;
        private boolean isDefaultViewModeSimpleList;
        private boolean isFlipDevice;
        private boolean isQ2Device;
        private boolean isQ4Device;
        private boolean isQ5Device;
        private boolean isQ6Device;
        private boolean isQ7Device;
        private boolean isS25Device;
        private boolean isS26Device;
        private boolean isSupportDocumentScan;
        private boolean isSupportInAppClient;
        private boolean isSupportInAppServer;
        private boolean isSupportSolveMath;
        private boolean isTopDevice;
        private boolean isWinnerDevice;
        private boolean mNeedAntiGreenish;
        private boolean mNeedNoThumbnailSimpleList;

        public final boolean getMNeedAntiGreenish() {
            return this.mNeedAntiGreenish;
        }

        public final boolean getMNeedNoThumbnailSimpleList() {
            return this.mNeedNoThumbnailSimpleList;
        }

        /* JADX INFO: renamed from: isB7Device, reason: from getter */
        public final boolean getIsB7Device() {
            return this.isB7Device;
        }

        /* JADX INFO: renamed from: isDefaultViewModeGridSmall, reason: from getter */
        public final boolean getIsDefaultViewModeGridSmall() {
            return this.isDefaultViewModeGridSmall;
        }

        /* JADX INFO: renamed from: isDefaultViewModeSimpleList, reason: from getter */
        public final boolean getIsDefaultViewModeSimpleList() {
            return this.isDefaultViewModeSimpleList;
        }

        /* JADX INFO: renamed from: isFlipDevice, reason: from getter */
        public final boolean getIsFlipDevice() {
            return this.isFlipDevice;
        }

        public final boolean isFoldableModel() {
            return this.isWinnerDevice || this.isTopDevice || this.isQ2Device || this.isQ4Device || this.isQ5Device || this.isQ6Device || this.isQ7Device;
        }

        /* JADX INFO: renamed from: isQ2Device, reason: from getter */
        public final boolean getIsQ2Device() {
            return this.isQ2Device;
        }

        /* JADX INFO: renamed from: isQ4Device, reason: from getter */
        public final boolean getIsQ4Device() {
            return this.isQ4Device;
        }

        /* JADX INFO: renamed from: isQ5Device, reason: from getter */
        public final boolean getIsQ5Device() {
            return this.isQ5Device;
        }

        /* JADX INFO: renamed from: isQ6Device, reason: from getter */
        public final boolean getIsQ6Device() {
            return this.isQ6Device;
        }

        /* JADX INFO: renamed from: isQ7Device, reason: from getter */
        public final boolean getIsQ7Device() {
            return this.isQ7Device;
        }

        /* JADX INFO: renamed from: isS25Device, reason: from getter */
        public final boolean getIsS25Device() {
            return this.isS25Device;
        }

        /* JADX INFO: renamed from: isS26Device, reason: from getter */
        public final boolean getIsS26Device() {
            return this.isS26Device;
        }

        /* JADX INFO: renamed from: isSupportDocumentScan, reason: from getter */
        public final boolean getIsSupportDocumentScan() {
            return this.isSupportDocumentScan;
        }

        /* JADX INFO: renamed from: isSupportInAppClient, reason: from getter */
        public final boolean getIsSupportInAppClient() {
            return this.isSupportInAppClient;
        }

        /* JADX INFO: renamed from: isSupportInAppServer, reason: from getter */
        public final boolean getIsSupportInAppServer() {
            return this.isSupportInAppServer;
        }

        /* JADX INFO: renamed from: isSupportSolveMath, reason: from getter */
        public final boolean getIsSupportSolveMath() {
            return this.isSupportSolveMath;
        }

        /* JADX INFO: renamed from: isTopDevice, reason: from getter */
        public final boolean getIsTopDevice() {
            return this.isTopDevice;
        }

        /* JADX INFO: renamed from: isWinnerDevice, reason: from getter */
        public final boolean getIsWinnerDevice() {
            return this.isWinnerDevice;
        }

        public final boolean needAntiGreenish() {
            return this.mNeedAntiGreenish;
        }

        public final boolean needNoThumbnailSimpleList() {
            return this.mNeedNoThumbnailSimpleList;
        }

        public final void setB7Device(boolean z) {
            this.isB7Device = z;
        }

        public final void setDefaultViewModeGridSmall(boolean z) {
            this.isDefaultViewModeGridSmall = z;
        }

        public final void setDefaultViewModeSimpleList(boolean z) {
            this.isDefaultViewModeSimpleList = z;
        }

        public final void setFlipDevice(boolean z) {
            this.isFlipDevice = z;
        }

        public final void setMNeedAntiGreenish(boolean z) {
            this.mNeedAntiGreenish = z;
        }

        public final void setMNeedNoThumbnailSimpleList(boolean z) {
            this.mNeedNoThumbnailSimpleList = z;
        }

        public final void setQ2Device(boolean z) {
            this.isQ2Device = z;
        }

        public final void setQ4Device(boolean z) {
            this.isQ4Device = z;
        }

        public final void setQ5Device(boolean z) {
            this.isQ5Device = z;
        }

        public final void setQ6Device(boolean z) {
            this.isQ6Device = z;
        }

        public final void setQ7Device(boolean z) {
            this.isQ7Device = z;
        }

        public final void setS25Device(boolean z) {
            this.isS25Device = z;
        }

        public final void setS26Device(boolean z) {
            this.isS26Device = z;
        }

        public final void setSupportDocumentScan(boolean z) {
            this.isSupportDocumentScan = z;
        }

        public final void setSupportInAppClient(boolean z) {
            this.isSupportInAppClient = z;
        }

        public final void setSupportInAppServer(boolean z) {
            this.isSupportInAppServer = z;
        }

        public final void setSupportSolveMath(boolean z) {
            this.isSupportSolveMath = z;
        }

        public final void setTopDevice(boolean z) {
            this.isTopDevice = z;
        }

        public final void setWinnerDevice(boolean z) {
            this.isWinnerDevice = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlagshipTablet;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabletSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class FlagshipTablet extends TabletSeries {
        public FlagshipTablet() {
            setSupportDocumentScan(true);
            setSupportInAppServer(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Flip7;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlipModel;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Flip7 extends FlipModel {
        public Flip7() {
            setB7Device(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlipModel;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class FlipModel extends FoldableSeries {
        public FlipModel() {
            setSupportDocumentScan(true);
            setFlipDevice(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold1;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold1 extends FoldableSeries {
        public Fold1() {
            setWinnerDevice(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold2;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold2 extends FoldableSeries {
        public Fold2() {
            setTopDevice(true);
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold3;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold3 extends FoldableSeries {
        public Fold3() {
            setQ2Device(true);
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold4;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold4 extends FoldableSeries {
        public Fold4() {
            setQ4Device(true);
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold5;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold5 extends FoldableSeries {
        public Fold5() {
            setQ5Device(true);
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold6;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold6 extends FoldableSeries {
        public Fold6() {
            setQ6Device(true);
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Fold7;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Fold7 extends FoldableSeries {
        public Fold7() {
            setQ7Device(true);
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class FoldableSeries extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FoldableSeries$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return StringsKt.m14145S(subName, "F7") ? StringsKt.m14145S(subName, "F76") ? new Flip7() : new FlipModel() : StringsKt.m14145S(subName, "F90") ? new Fold1() : StringsKt.m14145S(subName, "F91") ? new Fold2() : StringsKt.m14145S(subName, "F92") ? new Fold3() : StringsKt.m14145S(subName, "F93") ? new Fold4() : StringsKt.m14145S(subName, "F94") ? new Fold5() : StringsKt.m14145S(subName, "F95") ? new Fold6() : StringsKt.m14145S(subName, "F96") ? new Fold7() : new FoldableSeries();
            }

            private Companion() {
            }
        }

        public FoldableSeries() {
            setDefaultViewModeGridSmall(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$JapanModel;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class JapanModel extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$JapanModel$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return (Intrinsics.areEqual(subName, "42A") || Intrinsics.areEqual(subName, "02M")) ? new LowEndModel() : new JapanModel();
            }

            private Companion() {
            }
        }

        public JapanModel() {
            setDefaultViewModeGridSmall(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$LowEndModel;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LowEndModel extends Feature {
        public LowEndModel() {
            setDefaultViewModeSimpleList(true);
            setDefaultViewModeGridSmall(false);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$MSeries;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MSeries extends Feature {

        @NotNull
        public static final MSeries INSTANCE = new MSeries();

        private MSeries() {
        }

        @NotNull
        public final Feature getInstance() {
            return new LowEndModel();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Note10;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$NoteSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Note10 extends NoteSeries {
        public Note10() {
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Note20;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$NoteSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Note20 extends NoteSeries {
        public Note20() {
            setSupportDocumentScan(true);
            setSupportInAppClient(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$NoteSeries;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class NoteSeries extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$NoteSeries$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return StringsKt.m14145S(subName, "N97") ? new Note10() : StringsKt.m14145S(subName, "N98") ? new Note20() : new NoteSeries();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S10S20;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$SSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class S10S20 extends SSeries {
        public S10S20() {
            setSupportDocumentScan(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S21S22S23;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$SSeries;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class S21S22S23 extends SSeries {
        public S21S22S23() {
            setSupportDocumentScan(true);
            setSupportInAppClient(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S24;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S21S22S23;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class S24 extends S21S22S23 {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S25;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S21S22S23;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class S25 extends S21S22S23 {
        public S25() {
            setS25Device(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S26;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$S21S22S23;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class S26 extends S21S22S23 {
        public S26() {
            setS26Device(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$SSeries;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class SSeries extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$SSeries$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return (StringsKt.m14145S(subName, "G97") || StringsKt.m14145S(subName, "G98")) ? new S10S20() : (StringsKt.m14145S(subName, "G99") || StringsKt.m14145S(subName, "S90") || StringsKt.m14145S(subName, "S91")) ? new S21S22S23() : StringsKt.m14145S(subName, "S92") ? new S24() : StringsKt.m14145S(subName, "S93") ? new S25() : StringsKt.m14145S(subName, "S94") ? new S26() : new SSeries();
            }

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabS10orHigher;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlagshipTablet;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TabS10orHigher extends FlagshipTablet {
        public TabS10orHigher() {
            setSupportSolveMath(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabS7;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlagshipTablet;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TabS7 extends FlagshipTablet {
        public TabS7() {
            setMNeedAntiGreenish(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabS8;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlagshipTablet;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TabS8 extends FlagshipTablet {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabS9;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$FlagshipTablet;", "<init>", "()V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TabS9 extends FlagshipTablet {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabletSeries;", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "<init>", "()V", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class TabletSeries extends Feature {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$TabletSeries$Companion;", "", "<init>", "()V", "getInstance", "Lcom/samsung/android/support/senl/nt/base/common/util/ModelFeature$Feature;", "subName", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Feature getInstance(@NotNull String subName) {
                Intrinsics.checkNotNullParameter(subName, "subName");
                return (StringsKt.m14145S(subName, "T87") || StringsKt.m14145S(subName, "T73")) ? new FlagshipTablet() : StringsKt.m14145S(subName, "T97") ? new TabS7() : (StringsKt.m14145S(subName, "X90") || StringsKt.m14145S(subName, "X80") || StringsKt.m14145S(subName, "X70")) ? new TabS8() : (StringsKt.m14145S(subName, "X91") || StringsKt.m14145S(subName, "X81") || StringsKt.m14145S(subName, "X71")) ? new TabS9() : (StringsKt.m14145S(subName, "X92") || StringsKt.m14145S(subName, "X82")) ? new TabS10orHigher() : new TabletSeries();
            }

            private Companion() {
            }
        }

        public TabletSeries() {
            setDefaultViewModeGridSmall(false);
        }
    }

    private ModelFeature() {
    }

    private final Feature Factory() {
        String subModelName = DeviceUtils.getSubModelName();
        Logger.m8702i(TAG, "getFeature# " + subModelName);
        return Factory(subModelName);
    }

    @JvmStatic
    @NotNull
    public static final Feature getFeature() {
        if (mFeature == null) {
            mFeature = INSTANCE.Factory();
            if (DeviceUtils.isSepLiteModel(BaseUtils.getApplicationContext())) {
                if (DeviceUtils.isRamSizeBelowOf(3)) {
                    Feature feature = mFeature;
                    if (feature != null) {
                        feature.setMNeedNoThumbnailSimpleList(true);
                    }
                    Logger.m8702i(TAG, "getFeature# SepLightModel Below 3G");
                } else {
                    Logger.m8702i(TAG, "getFeature# SepLightModel");
                }
            }
        }
        Feature feature2 = mFeature;
        Intrinsics.checkNotNull(feature2);
        return feature2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        if (r0 != 'X') goto L43;
     */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Feature Factory(@NotNull String subName) {
        Intrinsics.checkNotNullParameter(subName, "subName");
        int length = subName.length();
        if (length >= 4) {
            char cCharAt = subName.charAt(0);
            if (cCharAt != 'A') {
                if (cCharAt != 'J') {
                    if (cCharAt != 'F') {
                        if (cCharAt != 'G') {
                            if (cCharAt != 'M') {
                                if (cCharAt == 'N') {
                                    return NoteSeries.INSTANCE.getInstance(subName);
                                }
                                if (cCharAt != 'S') {
                                    if (cCharAt != 'T') {
                                        if (cCharAt == 'W') {
                                            return ChinaModel.INSTANCE.getInstance(subName);
                                        }
                                    }
                                    return TabletSeries.INSTANCE.getInstance(subName);
                                }
                            }
                        }
                        return SSeries.INSTANCE.getInstance(subName);
                    }
                    return FoldableSeries.INSTANCE.getInstance(subName);
                }
                return MSeries.INSTANCE.getInstance();
            }
            return ASeries.INSTANCE.getInstance(subName);
        }
        if (length == 3) {
            return JapanModel.INSTANCE.getInstance(subName);
        }
        return new Feature();
    }
}
