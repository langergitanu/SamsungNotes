package com.samsung.android.support.senl.p145cm.base.framework.feature;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.framework.sem.feature.CscFeatureImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000eJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0011¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/feature/CscFeature;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/feature/CscFeatureImplFactory$ICscFeatureCompatImpl;)V", "mIsChinaAiFeature", "", "Ljava/lang/Boolean;", "getBoolean", "tag", "", "defaultValue", "getInt", "", "getString", "isSecBrandAsGalaxy", "()Z", "mSamsungCloudBrandType", "samsungCloudBrandType", "getSamsungCloudBrandType", "()Ljava/lang/String;", "isChinaAiFeature", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCscFeature.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CscFeature.kt\ncom/samsung/android/support/senl/cm/base/framework/feature/CscFeature\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,87:1\n739#2,9:88\n739#2,9:101\n37#3:97\n36#3,3:98\n37#3:110\n36#3,3:111\n*S KotlinDebug\n*F\n+ 1 CscFeature.kt\ncom/samsung/android/support/senl/cm/base/framework/feature/CscFeature\n*L\n50#1:88,9\n53#1:101,9\n50#1:97\n50#1:98,3\n53#1:110\n53#1:111,3\n*E\n"})
public final class CscFeature {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "CscFeature";

    @Nullable
    private static CscFeature mInstance;

    @NotNull
    private final CscFeatureImplFactory.ICscFeatureCompatImpl mImpl;

    @Nullable
    private Boolean mIsChinaAiFeature;

    @Nullable
    private String mSamsungCloudBrandType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/feature/CscFeature$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/feature/CscFeature;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/feature/CscFeature;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized CscFeature getInstance() {
            CscFeature cscFeature;
            try {
                if (CscFeature.mInstance == null) {
                    CscFeature.mInstance = new CscFeature(new CscFeatureImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                cscFeature = CscFeature.mInstance;
                Intrinsics.checkNotNull(cscFeature, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.feature.CscFeature");
            } catch (Throwable th) {
                throw th;
            }
            return cscFeature;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CscFeature(CscFeatureImplFactory.ICscFeatureCompatImpl iCscFeatureCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iCscFeatureCompatImpl);
    }

    public final boolean getBoolean(@Nullable String tag, boolean defaultValue) {
        return this.mImpl.getBoolean(tag, defaultValue);
    }

    public final int getInt(@Nullable String tag, int defaultValue) {
        return this.mImpl.getInt(tag, defaultValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8 A[EDGE_INSN: B:43:0x00b8->B:38:0x00b8 BREAK  A[LOOP:1: B:17:0x004d->B:37:0x00b5], SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getSamsungCloudBrandType() {
        String string;
        List listEmptyList;
        int length;
        int i;
        List listEmptyList2;
        String[] strArr;
        if (this.mSamsungCloudBrandType == null && (string = getString("CscFeature_Common_ConfigSamsungCloudVariation", null)) != null) {
            List listM13999t = AbstractC12991c.m13999t(0, ",", string);
            if (!listM13999t.isEmpty()) {
                ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
                String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                length = strArr2.length;
                i = 0;
                while (true) {
                    if (i < length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (StringsKt.m14162r(str, "SamsungCloudBrandType")) {
                        List listM13999t2 = AbstractC12991c.m13999t(0, ":", str);
                        if (listM13999t2.isEmpty()) {
                            listEmptyList2 = CollectionsKt.emptyList();
                            strArr = (String[]) listEmptyList2.toArray(new String[0]);
                            if (StringsKt__StringsJVMKt.compareTo(strArr[0], "SamsungCloudBrandType", true) == 0) {
                                this.mSamsungCloudBrandType = strArr[2];
                            }
                        } else {
                            ListIterator listIterator2 = listM13999t2.listIterator(listM13999t2.size());
                            while (listIterator2.hasPrevious()) {
                                if (((String) listIterator2.previous()).length() != 0) {
                                    listEmptyList2 = AbstractC12991c.m14000u(listIterator2, 1, listM13999t2);
                                    break;
                                }
                            }
                            listEmptyList2 = CollectionsKt.emptyList();
                            strArr = (String[]) listEmptyList2.toArray(new String[0]);
                            if (StringsKt__StringsJVMKt.compareTo(strArr[0], "SamsungCloudBrandType", true) == 0 && StringsKt__StringsJVMKt.compareTo(strArr[1], "String", true) == 0 && !TextUtils.isEmpty(strArr[2])) {
                                this.mSamsungCloudBrandType = strArr[2];
                            }
                        }
                    } else {
                        i++;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                String[] strArr22 = (String[]) listEmptyList.toArray(new String[0]);
                length = strArr22.length;
                i = 0;
                while (true) {
                    if (i < length) {
                    }
                    i++;
                }
            }
        }
        return this.mSamsungCloudBrandType;
    }

    @Nullable
    public final String getString(@Nullable String tag, @Nullable String defaultValue) {
        return this.mImpl.getString(tag, defaultValue);
    }

    public final boolean isChinaAiFeature() {
        if (this.mIsChinaAiFeature == null) {
            Boolean boolValueOf = Boolean.valueOf(getBoolean("CscFeature_Common_SupportZProjectFunctionInGlobal", false));
            this.mIsChinaAiFeature = boolValueOf;
            LoggerBase.INSTANCE.m7137i(TAG, "isChinaAiFeature# : " + boolValueOf);
        }
        Boolean bool = this.mIsChinaAiFeature;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isSecBrandAsGalaxy() {
        return StringsKt__StringsJVMKt.equals("true", getString("CscFeature_Common_ReplaceSecBrandAsGalaxy", "false"), true);
    }

    private CscFeature(CscFeatureImplFactory.ICscFeatureCompatImpl iCscFeatureCompatImpl) {
        this.mImpl = iCscFeatureCompatImpl;
    }

    public final boolean getBoolean(@Nullable String tag) {
        return this.mImpl.getBoolean(tag);
    }

    public final int getInt(@Nullable String tag) {
        return this.mImpl.getInt(tag);
    }

    @Nullable
    public final String getString(@Nullable String tag) {
        return this.mImpl.getString(tag);
    }
}
