package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.content.Context;
import android.os.Bundle;
import android.os.UserHandle;
import com.samsung.android.knox.SemEnterpriseDeviceManager;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/PolicyManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsPolicyManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsPolicyManagerCompatImplFactory$IPolicyManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "PolicyManagerCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PolicyManagerCompatImplFactory extends AbsPolicyManagerCompatImplFactory {

    @NotNull
    private static final String DRAWING_KEY = "key_air_command";
    private static boolean FEATURE_EDM_ACTIVE_GRAYOUT_DRAWING = false;
    private static boolean FEATURE_EDM_ACTIVE_GRAYOUT_NOTE = false;

    @NotNull
    private static final String GRAYOUT = "grayout";

    @NotNull
    private static final String NOTE_KEY = "samsung_note_assist";

    @NotNull
    private static final String OFF = "0";

    /* JADX INFO: renamed from: ON */
    @NotNull
    private static final String f5798ON = "1";

    @NotNull
    private static final String SETTINGS_PACKAGE = "com.samsung.android.knox.galaxyai";

    @NotNull
    private static final String TAG = "PolicyManagerCompatImplFactory";

    @NotNull
    private static final String VALUE = "value";

    @Nullable
    private static Boolean mEdmPolicyActive;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean FEATURE_EDM_ACTIVE_VALUE_NOTE = true;
    private static boolean FEATURE_EDM_ACTIVE_VALUE_DRAWING = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/PolicyManagerCompatImplFactory$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mEdmPolicyActive", "", "Ljava/lang/Boolean;", "FEATURE_EDM_ACTIVE_VALUE_NOTE", "FEATURE_EDM_ACTIVE_GRAYOUT_NOTE", "FEATURE_EDM_ACTIVE_VALUE_DRAWING", "FEATURE_EDM_ACTIVE_GRAYOUT_DRAWING", "SETTINGS_PACKAGE", "VALUE", "GRAYOUT", NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF, NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON, "NOTE_KEY", "DRAWING_KEY", "checkEdmActiveFeature", "", "context", "Landroid/content/Context;", "initValues", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkEdmActiveFeature(Context context) {
            Bundle bundle;
            Bundle bundle2;
            if (PolicyManagerCompatImplFactory.mEdmPolicyActive == null) {
                if (SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() < 70000) {
                    if (PolicyManagerCompatImplFactory.mEdmPolicyActive == null) {
                        PolicyManagerCompatImplFactory.mEdmPolicyActive = Boolean.FALSE;
                        return;
                    }
                    return;
                }
                try {
                    SemEnterpriseDeviceManager semEnterpriseDeviceManager = SemEnterpriseDeviceManager.getInstance(context);
                    Bundle applicationRestrictions = semEnterpriseDeviceManager != null ? semEnterpriseDeviceManager.getApplicationRestrictions(PolicyManagerCompatImplFactory.SETTINGS_PACKAGE, UserHandle.semGetMyUserId()) : null;
                    if (applicationRestrictions != null && !applicationRestrictions.isEmpty()) {
                        initValues();
                        if (applicationRestrictions.containsKey(PolicyManagerCompatImplFactory.NOTE_KEY) && (bundle2 = applicationRestrictions.getBundle(PolicyManagerCompatImplFactory.NOTE_KEY)) != null) {
                            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_NOTE = bundle2.getBoolean(PolicyManagerCompatImplFactory.GRAYOUT);
                            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_NOTE = !Intrinsics.areEqual("0", bundle2.getString("value"));
                            PolicyManagerCompatImplFactory.mEdmPolicyActive = Boolean.TRUE;
                            LoggerBase.INSTANCE.m7137i(PolicyManagerCompatImplFactory.TAG, "checkEdmActiveFeature note : " + PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_NOTE + " dim : " + PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_NOTE);
                        }
                        if (applicationRestrictions.containsKey(PolicyManagerCompatImplFactory.DRAWING_KEY) && (bundle = applicationRestrictions.getBundle(PolicyManagerCompatImplFactory.DRAWING_KEY)) != null) {
                            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_DRAWING = bundle.getBoolean(PolicyManagerCompatImplFactory.GRAYOUT);
                            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_DRAWING = !Intrinsics.areEqual("0", bundle.getString("value"));
                            PolicyManagerCompatImplFactory.mEdmPolicyActive = Boolean.TRUE;
                            LoggerBase.INSTANCE.m7137i(PolicyManagerCompatImplFactory.TAG, "checkEdmActiveFeature drawing assist : " + PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_DRAWING + " dim : " + PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_DRAWING);
                        }
                    }
                    if (PolicyManagerCompatImplFactory.mEdmPolicyActive == null) {
                        PolicyManagerCompatImplFactory.mEdmPolicyActive = Boolean.FALSE;
                    }
                } catch (NoClassDefFoundError unused) {
                    if (PolicyManagerCompatImplFactory.mEdmPolicyActive == null) {
                        PolicyManagerCompatImplFactory.mEdmPolicyActive = Boolean.FALSE;
                    }
                } catch (NoSuchMethodError unused2) {
                    if (PolicyManagerCompatImplFactory.mEdmPolicyActive == null) {
                        PolicyManagerCompatImplFactory.mEdmPolicyActive = Boolean.FALSE;
                    }
                }
            }
        }

        private final void initValues() {
            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_NOTE = true;
            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_NOTE = false;
            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_DRAWING = true;
            PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_DRAWING = false;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/PolicyManagerCompatImplFactory$PolicyManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsPolicyManagerCompatImplFactory$IPolicyManagerCompatImpl;", "<init>", "()V", "isEdmPolicyAiEnabled", "", "context", "Landroid/content/Context;", "isEdmPolicyAiGrayout", "isEdmPolicyAiDrawingEnabled", "isEdmPolicyAiDrawingGrayout", "updateKnoxRestrictions", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nPolicyManagerCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicyManagerCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/app/PolicyManagerCompatImplFactory$PolicyManagerCompatSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,135:1\n1#2:136\n*E\n"})
    public static final class PolicyManagerCompatSemImpl implements AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl
        public boolean isEdmPolicyAiDrawingEnabled(@Nullable Context context) {
            if (context != null) {
                PolicyManagerCompatImplFactory.INSTANCE.checkEdmActiveFeature(context);
            }
            if (Intrinsics.areEqual(PolicyManagerCompatImplFactory.mEdmPolicyActive, Boolean.FALSE)) {
                return true;
            }
            return PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_DRAWING;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl
        public boolean isEdmPolicyAiDrawingGrayout(@Nullable Context context) {
            if (context != null) {
                PolicyManagerCompatImplFactory.INSTANCE.checkEdmActiveFeature(context);
            }
            if (Intrinsics.areEqual(PolicyManagerCompatImplFactory.mEdmPolicyActive, Boolean.FALSE)) {
                return false;
            }
            return PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_DRAWING;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl
        public boolean isEdmPolicyAiEnabled(@Nullable Context context) {
            if (context != null) {
                PolicyManagerCompatImplFactory.INSTANCE.checkEdmActiveFeature(context);
            }
            if (Intrinsics.areEqual(PolicyManagerCompatImplFactory.mEdmPolicyActive, Boolean.FALSE)) {
                return true;
            }
            return PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_VALUE_NOTE;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl
        public boolean isEdmPolicyAiGrayout(@Nullable Context context) {
            if (context != null) {
                PolicyManagerCompatImplFactory.INSTANCE.checkEdmActiveFeature(context);
            }
            if (Intrinsics.areEqual(PolicyManagerCompatImplFactory.mEdmPolicyActive, Boolean.FALSE)) {
                return false;
            }
            return PolicyManagerCompatImplFactory.FEATURE_EDM_ACTIVE_GRAYOUT_NOTE;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl
        public void updateKnoxRestrictions(@Nullable Context context) {
            PolicyManagerCompatImplFactory.mEdmPolicyActive = null;
            if (context != null) {
                PolicyManagerCompatImplFactory.INSTANCE.checkEdmActiveFeature(context);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsPolicyManagerCompatImplFactory
    @NotNull
    public AbsPolicyManagerCompatImplFactory.IPolicyManagerCompatImpl create(int deviceType) {
        return (deviceType == 2 || deviceType == 3) ? new PolicyManagerCompatSemImpl() : super.create(deviceType);
    }
}
