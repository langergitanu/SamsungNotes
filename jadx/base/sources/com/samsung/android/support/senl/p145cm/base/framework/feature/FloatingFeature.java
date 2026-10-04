package com.samsung.android.support.senl.p145cm.base.framework.feature;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.sem.feature.FloatingFeatureImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BOOLEAN;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\fJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001a\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/feature/FloatingFeature;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$IFloatingFeatureCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/FloatingFeatureImplFactory$IFloatingFeatureCompatImpl;)V", "getBoolean", "", "tag", "", "defaultValue", "getInt", "", "getString", "mDisableRecycleBinModel", "Lcom/samsung/android/support/senl/cm/base/framework/support/BOOLEAN;", "isDisableRecycleBinModel", "()Z", "mIsAiSupported", "isAiSupported", "mIsC2paSupported", "isC2paSupported", "mConfigAiVersion", "Ljava/lang/Integer;", "configAiVersion", "getConfigAiVersion", "()Ljava/lang/Integer;", "semanticSearchVersion", "isSemanticSearchSupportedVersion", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FloatingFeature {
    public static final int AI_CONFIG_VERSION_20242 = 20242;
    public static final int AI_CONFIG_VERSION_20251 = 20251;
    public static final int AI_CONFIG_VERSION_20261 = 20261;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "FloatingFeature";
    private static int mAntiGreenishColor;

    @Nullable
    private static FloatingFeature mInstance;

    @Nullable
    private Integer mConfigAiVersion;

    @Nullable
    private BOOLEAN mDisableRecycleBinModel;

    @NotNull
    private final FloatingFeatureImplFactory.IFloatingFeatureCompatImpl mImpl;

    @Nullable
    private BOOLEAN mIsAiSupported;

    @Nullable
    private BOOLEAN mIsC2paSupported;
    private int semanticSearchVersion;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/feature/FloatingFeature$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "AI_CONFIG_VERSION_20261", "", "AI_CONFIG_VERSION_20251", "AI_CONFIG_VERSION_20242", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/feature/FloatingFeature;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/feature/FloatingFeature;", "mAntiGreenishColor", "antiGreenishColor", "getAntiGreenishColor", "()I", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nFloatingFeature.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatingFeature.kt\ncom/samsung/android/support/senl/cm/base/framework/feature/FloatingFeature$Companion\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,128:1\n439#2:129\n*S KotlinDebug\n*F\n+ 1 FloatingFeature.kt\ncom/samsung/android/support/senl/cm/base/framework/feature/FloatingFeature$Companion\n*L\n123#1:129\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getAntiGreenishColor() {
            if (FloatingFeature.mAntiGreenishColor == 0) {
                String string = getInstance().getString("SEC_FLOATING_FEATURE_LCD_CONFIG_REPLACE_COLOR_FOR_DARKMODE", "#FF171717");
                FloatingFeature.mAntiGreenishColor = Color.parseColor(TextUtils.isEmpty(string) ? "#FF171717" : string);
            }
            return FloatingFeature.mAntiGreenishColor;
        }

        @NotNull
        public final synchronized FloatingFeature getInstance() {
            FloatingFeature floatingFeature;
            try {
                if (FloatingFeature.mInstance == null) {
                    FloatingFeature.mInstance = new FloatingFeature(new FloatingFeatureImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                floatingFeature = FloatingFeature.mInstance;
                Intrinsics.checkNotNull(floatingFeature, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.feature.FloatingFeature");
            } catch (Throwable th) {
                throw th;
            }
            return floatingFeature;
        }

        private Companion() {
        }
    }

    public /* synthetic */ FloatingFeature(FloatingFeatureImplFactory.IFloatingFeatureCompatImpl iFloatingFeatureCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iFloatingFeatureCompatImpl);
    }

    public final boolean getBoolean(@Nullable String tag, boolean defaultValue) {
        return this.mImpl.getBoolean(tag, defaultValue);
    }

    @Nullable
    public final Integer getConfigAiVersion() {
        if (this.mConfigAiVersion == null) {
            this.mConfigAiVersion = Integer.valueOf(getInt("SEC_FLOATING_FEATURE_COMMON_CONFIG_AI_VERSION"));
        }
        return this.mConfigAiVersion;
    }

    public final int getInt(@Nullable String tag, int defaultValue) {
        return this.mImpl.getInt(tag, defaultValue);
    }

    @NotNull
    public final String getString(@Nullable String tag, @Nullable String defaultValue) {
        return this.mImpl.getString(tag, defaultValue);
    }

    public final boolean isAiSupported() {
        if (this.mIsAiSupported == null) {
            this.mIsAiSupported = new BOOLEAN(getBoolean("SEC_FLOATING_FEATURE_COMMON_DISABLE_NATIVE_AI", false));
        }
        BOOLEAN r02 = this.mIsAiSupported;
        return (r02 == null || r02.getValue()) ? false : true;
    }

    public final boolean isC2paSupported() {
        if (this.mIsC2paSupported == null) {
            this.mIsC2paSupported = new BOOLEAN(getBoolean("SEC_FLOATING_FEATURE_GENAI_SUPPORT_C2PA", false));
        }
        BOOLEAN r02 = this.mIsC2paSupported;
        return r02 != null && r02.getValue();
    }

    public final boolean isDisableRecycleBinModel() {
        if (this.mDisableRecycleBinModel == null) {
            this.mDisableRecycleBinModel = new BOOLEAN(getBoolean("SEC_FLOATING_FEATURE_COMMON_DISABLE_RECYCLE_BIN", false));
        }
        BOOLEAN r02 = this.mDisableRecycleBinModel;
        return r02 != null && r02.getValue();
    }

    public final boolean isSemanticSearchSupportedVersion() {
        if (this.semanticSearchVersion == -1) {
            int i = getInt("SEC_FLOATING_FEATURE_SAMSUNG_SEARCH_SEMANTIC_SEARCH_VERSION", 0);
            this.semanticSearchVersion = i;
            AbstractC0541b.m755A(i, "isSemanticSearchSupportedVersion: ", TAG);
        }
        return this.semanticSearchVersion >= 510;
    }

    private FloatingFeature(FloatingFeatureImplFactory.IFloatingFeatureCompatImpl iFloatingFeatureCompatImpl) {
        this.mImpl = iFloatingFeatureCompatImpl;
        this.semanticSearchVersion = -1;
    }

    public final boolean getBoolean(@Nullable String tag) {
        return this.mImpl.getBoolean(tag);
    }

    public final int getInt(@Nullable String tag) {
        return this.mImpl.getInt(tag);
    }

    @NotNull
    public final String getString(@Nullable String tag) {
        return this.mImpl.getString(tag);
    }
}
