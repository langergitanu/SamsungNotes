package com.samsung.android.support.senl.addons.base.utils;

import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ModelFeature;", "", "<init>", "()V", "Companion", "Feature", "FoldSupportHideNavigationBar", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ModelFeature {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "ModelFeature";

    @Nullable
    private static Feature mFeature;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\t\u001a\u00020\u0007H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005J\b\u0010\u000b\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ModelFeature$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mFeature", "Lcom/samsung/android/support/senl/addons/base/utils/ModelFeature$Feature;", "getFeature", "Factory", "subName", "getSubModelName", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Feature Factory() {
            String subModelName = getSubModelName();
            Logger.m7104i(ModelFeature.TAG, "getFeature# " + subModelName);
            return Factory(subModelName);
        }

        private final String getSubModelName() {
            StringBuilder sb = new StringBuilder();
            if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
                sb.append(SystemPropertiesCompat.INSTANCE.getInstance().getFactoryName());
            }
            if (sb.length() == 0) {
                sb.append(DeviceInfo.getModelName());
            }
            for (int length = sb.length(); length < 6; length++) {
                sb.append('@');
            }
            String strSubstring = sb.substring(3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }

        @Nullable
        public final synchronized Feature getFeature() {
            try {
                if (ModelFeature.mFeature == null) {
                    ModelFeature.mFeature = Factory();
                }
            } catch (Throwable th) {
                throw th;
            }
            return ModelFeature.mFeature;
        }

        private Companion() {
        }

        @NotNull
        public final Feature Factory(@NotNull String subName) {
            Intrinsics.checkNotNullParameter(subName, "subName");
            if (subName.length() >= 4 && subName.charAt(0) == 'F' && !StringsKt.m14145S(subName, "F90")) {
                return new FoldSupportHideNavigationBar();
            }
            return new Feature();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ModelFeature$Feature;", "", "<init>", "()V", "mIsFoldSupportHideNavigationBar", "", "getMIsFoldSupportHideNavigationBar", "()Z", "setMIsFoldSupportHideNavigationBar", "(Z)V", "isFoldSupportHideNavigationBar", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class Feature {
        private boolean mIsFoldSupportHideNavigationBar;

        public final boolean getMIsFoldSupportHideNavigationBar() {
            return this.mIsFoldSupportHideNavigationBar;
        }

        public boolean isFoldSupportHideNavigationBar() {
            return this.mIsFoldSupportHideNavigationBar;
        }

        public final void setMIsFoldSupportHideNavigationBar(boolean z) {
            this.mIsFoldSupportHideNavigationBar = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/ModelFeature$FoldSupportHideNavigationBar;", "Lcom/samsung/android/support/senl/addons/base/utils/ModelFeature$Feature;", "<init>", "()V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class FoldSupportHideNavigationBar extends Feature {
        public FoldSupportHideNavigationBar() {
            setMIsFoldSupportHideNavigationBar(true);
        }
    }
}
