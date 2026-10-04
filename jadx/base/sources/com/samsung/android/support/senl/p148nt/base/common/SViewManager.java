package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.cover.ScoverManager;
import com.samsung.android.sdk.cover.ScoverState;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 62\u00020\u0001:\u00043456B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0012J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\u0018\u0010*\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010+\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\rj\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00120\rj\b\u0012\u0004\u0012\u00020\u0012`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0011\u00101\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/SViewManager;", "", "<init>", "()V", "isCoverSupported", "", "mCoverState", "Lcom/samsung/android/support/senl/nt/base/common/SViewManager$CoverState;", "mCoverManager", "Lcom/samsung/android/sdk/cover/ScoverManager;", "mCoverStateListener", "Lcom/samsung/android/sdk/cover/ScoverManager$CoverStateListener;", "mListeners", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/samsung/android/support/senl/nt/base/common/SViewManager$SCoverListener;", "Lkotlin/collections/ArrayList;", "mRegistedID", "Lcom/samsung/android/support/senl/nt/base/common/SViewManager$RegisterID;", "registerListener", "", "l", "unregisterListener", "removeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "containsListener", "callStageChangedListeners", "isOpened", "removeListenerFromList", "index", "", "mContextHashCode", "register", "context", "Landroid/content/Context;", "id", "unregister", "isRegistered", "registerID", "unregisterID", "enableScoverManager", "disableScoverManager", "isCoverClosed", "cold", "coverWindowWidth", "getCoverWindowWidth", "()I", "coverWindowHeight", "getCoverWindowHeight", "coverType", "getCoverType", "RegisterID", "CoverState", "SCoverListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SViewManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SViewManager";

    @Nullable
    private static SViewManager mInstance;
    private boolean isCoverSupported;
    private int mContextHashCode;

    @Nullable
    private ScoverManager mCoverManager;

    @NotNull
    private CoverState mCoverState;

    @Nullable
    private ScoverManager.CoverStateListener mCoverStateListener;

    @NotNull
    private final ArrayList<WeakReference<SCoverListener>> mListeners;

    @NotNull
    private final ArrayList<RegisterID> mRegistedID;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/SViewManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/SViewManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/SViewManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized SViewManager getInstance() {
            SViewManager sViewManager;
            try {
                if (SViewManager.mInstance == null) {
                    SViewManager.mInstance = new SViewManager(null);
                }
                sViewManager = SViewManager.mInstance;
                Intrinsics.checkNotNull(sViewManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.SViewManager");
            } catch (Throwable th) {
                throw th;
            }
            return sViewManager;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/SViewManager$CoverState;", "", "<init>", "(Ljava/lang/String;I)V", "NEED_TO_CHECK", "CLOSED", "OPENED", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CoverState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CoverState[] $VALUES;
        public static final CoverState NEED_TO_CHECK = new CoverState("NEED_TO_CHECK", 0);
        public static final CoverState CLOSED = new CoverState("CLOSED", 1);
        public static final CoverState OPENED = new CoverState("OPENED", 2);

        private static final /* synthetic */ CoverState[] $values() {
            return new CoverState[]{NEED_TO_CHECK, CLOSED, OPENED};
        }

        static {
            CoverState[] coverStateArr$values = $values();
            $VALUES = coverStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(coverStateArr$values);
        }

        private CoverState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<CoverState> getEntries() {
            return $ENTRIES;
        }

        public static CoverState valueOf(String str) {
            return (CoverState) Enum.valueOf(CoverState.class, str);
        }

        public static CoverState[] values() {
            return (CoverState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/SViewManager$RegisterID;", "", "<init>", "(Ljava/lang/String;I)V", "NOTIFICATION", "COMPOSER", "SCREEN_OFF_MEMO", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class RegisterID {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RegisterID[] $VALUES;
        public static final RegisterID NOTIFICATION = new RegisterID("NOTIFICATION", 0);
        public static final RegisterID COMPOSER = new RegisterID("COMPOSER", 1);
        public static final RegisterID SCREEN_OFF_MEMO = new RegisterID("SCREEN_OFF_MEMO", 2);

        private static final /* synthetic */ RegisterID[] $values() {
            return new RegisterID[]{NOTIFICATION, COMPOSER, SCREEN_OFF_MEMO};
        }

        static {
            RegisterID[] registerIDArr$values = $values();
            $VALUES = registerIDArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(registerIDArr$values);
        }

        private RegisterID(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RegisterID> getEntries() {
            return $ENTRIES;
        }

        public static RegisterID valueOf(String str) {
            return (RegisterID) Enum.valueOf(RegisterID.class, str);
        }

        public static RegisterID[] values() {
            return (RegisterID[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/SViewManager$SCoverListener;", "", "onCoverStateChanged", "", "isOpened", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface SCoverListener {
        void onCoverStateChanged(boolean isOpened);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoverState.values().length];
            try {
                iArr[CoverState.OPENED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoverState.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SViewManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callStageChangedListeners(boolean isOpened) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            SCoverListener sCoverListener = this.mListeners.get(i).get();
            if (sCoverListener == null) {
                removeListenerFromList(i);
            } else {
                sCoverListener.onCoverStateChanged(isOpened);
            }
        }
    }

    private final boolean containsListener(SCoverListener listener) {
        if (listener == null) {
            return false;
        }
        for (int size = this.mListeners.size() - 1; -1 < size; size--) {
            SCoverListener sCoverListener = this.mListeners.get(size).get();
            if (sCoverListener == null) {
                removeListenerFromList(size);
            } else if (Intrinsics.areEqual(sCoverListener, listener)) {
                return true;
            }
        }
        return false;
    }

    private final void disableScoverManager() {
        ScoverManager.CoverStateListener coverStateListener;
        this.mCoverState = CoverState.NEED_TO_CHECK;
        try {
            Logger.m8697d(TAG, "disableScoverManager");
            ScoverManager scoverManager = this.mCoverManager;
            if (scoverManager != null && (coverStateListener = this.mCoverStateListener) != null && scoverManager != null) {
                scoverManager.unregisterListener(coverStateListener);
            }
            this.mCoverManager = null;
            this.mCoverStateListener = null;
            Logger.m8697d(TAG, "disableScoverManager] success");
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null || message.length() == 0) {
                Logger.m8697d(TAG, "disableScoverManager] got exception from unregisterListener");
            } else {
                AbstractC4539a.m3188B("disableScoverManager] ", message, TAG);
            }
        }
    }

    private final boolean enableScoverManager(Context context) {
        Logger.m8697d(TAG, "enableScoverManager");
        this.mCoverState = CoverState.NEED_TO_CHECK;
        try {
            this.mCoverManager = new ScoverManager(context);
            ScoverManager.CoverStateListener coverStateListener = new ScoverManager.CoverStateListener() { // from class: com.samsung.android.support.senl.nt.base.common.SViewManager.enableScoverManager.1
                @Override // com.samsung.android.sdk.cover.ScoverManager.CoverStateListener
                public void onCoverSwitchStateChanged(boolean switchState) {
                    super.onCoverSwitchStateChanged(switchState);
                    if (switchState) {
                        Logger.m8697d(SViewManager.TAG, "enableScoverManager] cover open");
                        SViewManager.this.mCoverState = CoverState.OPENED;
                        SViewManager.this.callStageChangedListeners(true);
                        return;
                    }
                    Logger.m8697d(SViewManager.TAG, "enableScoverManager] cover close");
                    SViewManager.this.mCoverState = CoverState.CLOSED;
                    SViewManager.this.callStageChangedListeners(false);
                }
            };
            this.mCoverStateListener = coverStateListener;
            ScoverManager scoverManager = this.mCoverManager;
            if (scoverManager != null) {
                scoverManager.registerListener(coverStateListener);
            }
            Logger.m8697d(TAG, "enableScoverManager] success");
            return true;
        } catch (Exception e) {
            this.isCoverSupported = false;
            this.mCoverManager = null;
            this.mCoverStateListener = null;
            this.mCoverState = CoverState.OPENED;
            String message = e.getMessage();
            if (message == null || message.length() == 0) {
                Logger.m8697d(TAG, "got exception in enableScoverManager");
            } else {
                AbstractC4539a.m3188B("enableScoverManager] ", message, TAG);
            }
            return false;
        }
    }

    @NotNull
    public static final synchronized SViewManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void registerID(RegisterID id) {
        if (this.mRegistedID.contains(id)) {
            return;
        }
        this.mRegistedID.add(id);
    }

    private final void removeListener(SCoverListener listener) {
        if (listener == null) {
            return;
        }
        int size = this.mListeners.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            WeakReference<SCoverListener> weakReference = this.mListeners.get(size);
            Intrinsics.checkNotNullExpressionValue(weakReference, "get(...)");
            WeakReference<SCoverListener> weakReference2 = weakReference;
            if (weakReference2.get() == null || Intrinsics.areEqual(weakReference2.get(), listener)) {
                removeListenerFromList(size);
            }
        }
    }

    private final void removeListenerFromList(int index) {
        this.mListeners.remove(index);
    }

    private final void unregisterID(RegisterID id) {
        if (this.mRegistedID.contains(id)) {
            this.mRegistedID.remove(id);
        }
    }

    public final int getCoverType() {
        ScoverManager scoverManager = this.mCoverManager;
        ScoverState coverState = scoverManager != null ? scoverManager.getCoverState() : null;
        if (coverState == null) {
            Logger.m8698e(TAG, "getCoverType: getCoverState is null");
            return 2;
        }
        int type = coverState.getType();
        AbstractC4539a.m3203m(type, "getCoverType type ", TAG);
        return type;
    }

    public final int getCoverWindowHeight() {
        ScoverState coverState;
        ScoverManager scoverManager = this.mCoverManager;
        if (scoverManager == null || scoverManager == null || (coverState = scoverManager.getCoverState()) == null) {
            return 0;
        }
        return coverState.getWindowHeight();
    }

    public final int getCoverWindowWidth() {
        ScoverManager scoverManager = this.mCoverManager;
        if (scoverManager == null) {
            return 0;
        }
        Intrinsics.checkNotNull(scoverManager);
        ScoverState coverState = scoverManager.getCoverState();
        if (coverState == null) {
            return 0;
        }
        return coverState.getWindowWidth();
    }

    public final boolean isCoverClosed(@Nullable Context context, boolean cold) {
        ScoverManager scoverManager;
        ScoverState coverState;
        int i = WhenMappings.$EnumSwitchMapping$0[this.mCoverState.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (!this.isCoverSupported) {
            return false;
        }
        if (cold) {
            scoverManager = this.mCoverManager;
            if (scoverManager == null) {
                scoverManager = new ScoverManager(context);
            }
        } else {
            scoverManager = this.mCoverManager;
        }
        return (scoverManager == null || (coverState = scoverManager.getCoverState()) == null || coverState.getSwitchState()) ? false : true;
    }

    public final boolean isRegistered(@NotNull RegisterID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.mRegistedID.contains(id);
    }

    public final synchronized void register(@NotNull Context context, @NotNull RegisterID id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(id, "id");
        if (this.mCoverManager != null) {
            if (this.mContextHashCode == context.hashCode()) {
                registerID(id);
                return;
            }
            disableScoverManager();
        }
        if (enableScoverManager(context)) {
            this.mContextHashCode = context.hashCode();
            registerID(id);
        } else {
            this.mContextHashCode = 0;
            unregisterID(id);
        }
    }

    public final void registerListener(@Nullable SCoverListener l) {
        if (l == null || containsListener(l)) {
            return;
        }
        this.mListeners.add(new WeakReference<>(l));
        AbstractC4539a.m3203m(this.mListeners.size(), "registerListener: mListener.count = ", TAG);
    }

    public final synchronized void unregister(@NotNull RegisterID id) {
        Intrinsics.checkNotNullParameter(id, "id");
        unregisterID(id);
        if (this.mCoverManager != null && this.mRegistedID.isEmpty()) {
            disableScoverManager();
        }
    }

    public final void unregisterListener(@Nullable SCoverListener l) {
        if (l != null && containsListener(l)) {
            removeListener(l);
        }
        AbstractC4539a.m3203m(this.mListeners.size(), "unregisterListener: mListener.count = ", TAG);
    }

    private SViewManager() {
        this.isCoverSupported = true;
        this.mCoverState = CoverState.NEED_TO_CHECK;
        this.mListeners = new ArrayList<>();
        this.mRegistedID = new ArrayList<>();
    }
}
