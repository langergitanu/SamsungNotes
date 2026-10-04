package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.content.Context;
import android.view.WindowManager;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsFoldStateCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.FoldStateCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001c\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat;", "", "<init>", "()V", "mIsFoldable", "", "Ljava/lang/Boolean;", "mFoldDirection", "", "Ljava/lang/Integer;", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$IFoldStateCompatImpl;", "isFoldableDevice", "()Z", "foldType", "getFoldType", "()I", "getFoldDirection", "context", "Landroid/content/Context;", "getFoldState", "", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$FolderStateCallback;", "registerFoldStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$FoldStateChangeListener;", "unregisterFoldStateListener", "FoldStateChangeListener", "FolderStateCallback", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FoldStateCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FOLD_B_TYPE = 2;
    public static final int FOLD_HORIZONTAL = 8;
    public static final int FOLD_Q_TYPE = 1;
    public static final int FOLD_STATE_CLOSED = 1;
    public static final int FOLD_STATE_FLIPPED = 4;
    public static final int FOLD_STATE_FULL_OPENED = 3;
    public static final int FOLD_STATE_HALF_OPENED = 2;
    public static final int FOLD_STATE_NONE = 0;
    public static final int FOLD_VERTICAL = 4;
    public static final int NOT_FOLD = 0;

    @NotNull
    private static final String TAG = "FoldStateCompat";

    @Nullable
    private static FoldStateCompat mInstance;

    @Nullable
    private Integer mFoldDirection;

    @NotNull
    private final AbsFoldStateCompatImplFactory.IFoldStateCompatImpl mImpl;

    @Nullable
    private Boolean mIsFoldable;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$Companion;", "", "<init>", "()V", "NOT_FOLD", "", "FOLD_Q_TYPE", "FOLD_B_TYPE", "FOLD_VERTICAL", "FOLD_HORIZONTAL", "FOLD_STATE_NONE", "FOLD_STATE_CLOSED", "FOLD_STATE_HALF_OPENED", "FOLD_STATE_FULL_OPENED", "FOLD_STATE_FLIPPED", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat;", SearchConstants.TargetContents.TAG, "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized FoldStateCompat getInstance() {
            FoldStateCompat foldStateCompat;
            try {
                if (FoldStateCompat.mInstance == null) {
                    FoldStateCompat.mInstance = new FoldStateCompat(null);
                }
                foldStateCompat = FoldStateCompat.mInstance;
                Intrinsics.checkNotNull(foldStateCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.FoldStateCompat");
            } catch (Throwable th) {
                throw th;
            }
            return foldStateCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$FoldStateChangeListener;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FoldStateChangeListener;", "<init>", "()V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class FoldStateChangeListener extends AbsFoldStateCompatImplFactory.FoldStateChangeListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/FoldStateCompat$FolderStateCallback;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsFoldStateCompatImplFactory$FolderStateCallback;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface FolderStateCallback extends AbsFoldStateCompatImplFactory.FolderStateCallback {
    }

    public /* synthetic */ FoldStateCompat(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public static final synchronized FoldStateCompat getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getFoldDirection(@NotNull Context context) {
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isFoldableDevice()) {
            return 0;
        }
        int foldType = getFoldType();
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
        boolean z = rotation == 1 || rotation == 3;
        if (foldType != 1) {
            i = foldType == 2 ? z ? 4 : 8 : 0;
        } else if (z) {
        }
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(foldType, rotation, "type : ", "/", MarketingConstants.REFERRER_DELIMITER_U003D);
        sbM1173s.append(i);
        companion.m7137i(TAG, sbM1173s.toString());
        return i;
    }

    public final void getFoldState(@Nullable FolderStateCallback callback) {
        this.mImpl.setFolderStateCallback(callback);
    }

    public final int getFoldType() {
        if (this.mFoldDirection == null) {
            int i = FloatingFeature.INSTANCE.getInstance().getInt("SEC_FLOATING_FEATURE_SIP_CONFIG_FOLD_UX_VERSION");
            if (i < 0) {
                i = 0;
            }
            this.mFoldDirection = Integer.valueOf(i & 15);
        }
        Integer num = this.mFoldDirection;
        Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
        return num.intValue();
    }

    public final boolean isFoldableDevice() {
        if (this.mIsFoldable == null) {
            this.mIsFoldable = Boolean.valueOf(getFoldType() != 0);
        }
        Boolean bool = this.mIsFoldable;
        Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }

    public final void registerFoldStateListener(@Nullable FoldStateChangeListener listener) {
        AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy mProxy;
        AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy mProxy2;
        if ((listener != null ? listener.getMProxy() : null) != null && (mProxy2 = listener.getMProxy()) != null) {
            mProxy2.unregister();
        }
        if (listener != null) {
            listener.setMProxy(this.mImpl.createProxy(listener));
        }
        if (listener == null || (mProxy = listener.getMProxy()) == null) {
            return;
        }
        mProxy.register();
    }

    public final void unregisterFoldStateListener(@Nullable FoldStateChangeListener listener) {
        if ((listener != null ? listener.getMProxy() : null) != null) {
            AbsFoldStateCompatImplFactory.FoldStateChangeListener.FoldStateProxy mProxy = listener.getMProxy();
            if (mProxy != null) {
                mProxy.unregister();
            }
            listener.setMProxy(null);
        }
    }

    private FoldStateCompat() {
        this.mImpl = new FoldStateCompatImplFactory().create(isFoldableDevice());
    }
}
