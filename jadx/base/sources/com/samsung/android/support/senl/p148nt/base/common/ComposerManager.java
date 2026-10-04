package com.samsung.android.support.senl.p148nt.base.common;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.glance.AbstractC2821a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.glance.list.setting.view.C6955h;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.AppTaskCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 a2\u00020\u0001:\bZ[\\]^_`aB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u000fJ\u0015\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020*2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n00J\u000e\u0010-\u001a\u00020\u00112\u0006\u00101\u001a\u000202J\"\u0010-\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u000104J\u0018\u00105\u001a\u00020\u00112\u000e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000707H\u0002J\u0018\u00108\u001a\u00020\u00112\u000e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000707H\u0002J\u001a\u00109\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u00103\u001a\u0004\u0018\u000104J\u0018\u0010=\u001a\u00020\n2\u0006\u0010$\u001a\u0002022\b\u0010#\u001a\u0004\u0018\u00010\u0006J\u0010\u0010>\u001a\u0004\u0018\u0001022\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010?\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0006J\u0010\u0010@\u001a\u0004\u0018\u0001022\u0006\u0010A\u001a\u00020*J\u0012\u0010E\u001a\u0004\u0018\u0001022\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010N\u001a\u00020\n2\b\u0010O\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0006J\u0016\u0010S\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\nJ\u000e\u0010V\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u0006J\u000e\u0010W\u001a\u00020\n2\u0006\u0010X\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\u0006R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010:\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b<\u0010;R\u0013\u0010B\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0011\u0010H\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0013\u0010K\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bN\u0010;R\u0011\u0010P\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bP\u0010;¨\u0006b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", "mInfoMap", "Ljava/util/HashMap;", "", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$ComposerInfo;", "Lkotlin/collections/HashMap;", "mCoeditMemberManagerResultMap", "", "mClosedListener", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IClosedListener;", "getMapKey", "fragment", "Landroidx/fragment/app/Fragment;", "onAttach", "", "onCreate", "addInfo", "onDetach", "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStartComposer", "onStopComposer", "onDestroyComposer", "remove", "printInfoMap", "doClosedListener", "isInvalid", "info", "isOpen", "uuid", NotesConstants.KEY_CALLER, "folderIdsInUse", "", "getFolderIdsInUse", "()Ljava/util/Set;", "findTaskIdByNotification", "", "name", "(Ljava/lang/String;)Ljava/lang/Integer;", "closeComposer", "taskId", "closableFunction", "Landroidx/core/util/Function;", "target", "Landroid/app/Activity;", "postAction", "Ljava/lang/Runnable;", "closeComposerOverCount", "infoList", "", "closeComposerOverMaintenanceTime", "closeCoeditComposer", "isRunningOnEditMode", "()Z", "isRunningOnCoeditMode", "hasComposerInSameTask", "getComposerActivity", "requestViewMode", "getComposerToAddContent", "callerTaskId", "composerForActionSend", "getComposerForActionSend", "()Landroid/app/Activity;", "getLatestComposer", "invalidCondition", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IfStatement;", "latestComposerUuid", "getLatestComposerUuid", "()Ljava/lang/String;", "currentScreen", "getCurrentScreen", "()Ljava/lang/Integer;", "isRunningComposer", "exclusion", "isFocusOnComposer", "isActivityResumed", Bixby2Constants.BIXBY_PARAM_ACTIVITY_NAME, "setCoeditMemberManagerLeaveResult", "groupId", "ret", "getCoeditMemberManagerLeaveResult", "closeAllComposer", "closedListener", "clearCoeditMemberManagerLeaveResult", "IComponentFinalizer", "IfStatement", Bixby2Constants.BIXBY_TYPE_COMPOSER_INFO, "IComposer", "IComposerResolver", "IClosedListener", "ComposerScreen", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nComposerManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposerManager.kt\ncom/samsung/android/support/senl/nt/base/common/ComposerManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,599:1\n1#2:600\n*E\n"})
public final class ComposerManager implements LifecycleEventObserver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_COMPOSER_COUNT = 5;

    @NotNull
    private static final String TAG = "ComposerManager";
    private static final int TIME_ONE_DAY = 86400000;

    @Nullable
    private static ComposerManager mInstance;

    @Nullable
    private IClosedListener mClosedListener;

    @NotNull
    private final HashMap<String, Boolean> mCoeditMemberManagerResultMap;

    @NotNull
    private final HashMap<String, ComposerInfo> mInfoMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_COMPOSER_COUNT", "", "TIME_ONE_DAY", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/ComposerManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final synchronized ComposerManager getInstance() {
            ComposerManager composerManager;
            try {
                if (ComposerManager.mInstance == null) {
                    ComposerManager.mInstance = new ComposerManager(null);
                }
                composerManager = ComposerManager.mInstance;
                Intrinsics.checkNotNull(composerManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.ComposerManager");
            } catch (Throwable th) {
                throw th;
            }
            return composerManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0015J\r\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$ComposerInfo;", "", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V", "mFragmentWeakReference", "Ljava/lang/ref/WeakReference;", GroupContract.Group.CREATED_TIME, "", "getCreatedTime", "()J", "lastStoppedTime", "getLastStoppedTime", "setLastStoppedTime", "(J)V", "lastStartedTime", "getLastStartedTime", "setLastStartedTime", "getFragment", "isInvalid", "", "getTaskId", "", "()Ljava/lang/Integer;", "getResolver", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IComposerResolver;", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ComposerInfo {
        private final long createdTime = System.currentTimeMillis();
        private long lastStartedTime;
        private long lastStoppedTime;

        @NotNull
        private final WeakReference<Fragment> mFragmentWeakReference;

        public ComposerInfo(@Nullable Fragment fragment) {
            this.mFragmentWeakReference = new WeakReference<>(fragment);
            setLastStartedTime();
        }

        public final long getCreatedTime() {
            return this.createdTime;
        }

        @Nullable
        public final Fragment getFragment() {
            return this.mFragmentWeakReference.get();
        }

        public final long getLastStartedTime() {
            return this.lastStartedTime;
        }

        public final long getLastStoppedTime() {
            return this.lastStoppedTime;
        }

        @Nullable
        public final IComposerResolver getResolver() {
            IComposer iComposer = (IComposer) this.mFragmentWeakReference.get();
            if (iComposer != null) {
                return iComposer.getComposerResolver();
            }
            return null;
        }

        @Nullable
        public final Integer getTaskId() {
            FragmentActivity activity;
            Fragment fragment = getFragment();
            if (fragment == null || (activity = fragment.getActivity()) == null) {
                return null;
            }
            return Integer.valueOf(activity.getTaskId());
        }

        public final boolean isInvalid() {
            Fragment fragment = getFragment();
            return fragment == null || fragment.isRemoving() || fragment.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED;
        }

        public final void setLastStartedTime(long j) {
            this.lastStartedTime = j;
        }

        public final void setLastStoppedTime(long j) {
            this.lastStoppedTime = j;
        }

        @NotNull
        public String toString() {
            Object objValueOf;
            if (this.mFragmentWeakReference.get() == null) {
                objValueOf = "null";
            } else {
                Fragment fragment = this.mFragmentWeakReference.get();
                objValueOf = Integer.valueOf(fragment != null ? fragment.hashCode() : 0);
            }
            return "ComposerInfo {" + objValueOf + ", createdTime: " + this.createdTime + ", lastStoppedTime: " + this.lastStoppedTime + "}";
        }

        public final long setLastStartedTime() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.lastStartedTime = jCurrentTimeMillis;
            return jCurrentTimeMillis;
        }

        public final long setLastStoppedTime() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.lastStoppedTime = jCurrentTimeMillis;
            return jCurrentTimeMillis;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$ComposerScreen;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ComposerScreen {
        public static final int AI_RESULT_SCREEN_AUTO_FORMAT_HEADERS_AND_BULLETS = 90011;
        public static final int AI_RESULT_SCREEN_AUTO_FORMAT_MEETING_NOTES = 90012;
        public static final int AI_RESULT_SCREEN_CORRECT_SPELLING = 9003;
        public static final int AI_RESULT_SCREEN_NONE = 9000;
        public static final int AI_RESULT_SCREEN_RECOGNIZED_HW = 9007;
        public static final int AI_RESULT_SCREEN_SKETCH_TO_IMAGE = 9006;
        public static final int AI_RESULT_SCREEN_STT_FAST_CONVERT = 9005;
        public static final int AI_RESULT_SCREEN_SUMMARIZE = 9002;
        public static final int AI_RESULT_SCREEN_TRANSLATION = 9004;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$ComposerScreen$Companion;", "", "<init>", "()V", "AI_RESULT_SCREEN_NONE", "", "AI_RESULT_SCREEN_AUTO_FORMAT_HEADERS_AND_BULLETS", "AI_RESULT_SCREEN_AUTO_FORMAT_MEETING_NOTES", "AI_RESULT_SCREEN_SUMMARIZE", "AI_RESULT_SCREEN_CORRECT_SPELLING", "AI_RESULT_SCREEN_TRANSLATION", "AI_RESULT_SCREEN_STT_FAST_CONVERT", "AI_RESULT_SCREEN_SKETCH_TO_IMAGE", "AI_RESULT_SCREEN_RECOGNIZED_HW", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int AI_RESULT_SCREEN_AUTO_FORMAT_HEADERS_AND_BULLETS = 90011;
            public static final int AI_RESULT_SCREEN_AUTO_FORMAT_MEETING_NOTES = 90012;
            public static final int AI_RESULT_SCREEN_CORRECT_SPELLING = 9003;
            public static final int AI_RESULT_SCREEN_NONE = 9000;
            public static final int AI_RESULT_SCREEN_RECOGNIZED_HW = 9007;
            public static final int AI_RESULT_SCREEN_SKETCH_TO_IMAGE = 9006;
            public static final int AI_RESULT_SCREEN_STT_FAST_CONVERT = 9005;
            public static final int AI_RESULT_SCREEN_SUMMARIZE = 9002;
            public static final int AI_RESULT_SCREEN_TRANSLATION = 9004;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IClosedListener;", "", "onClosedAllComposer", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IClosedListener {
        boolean onClosedAllComposer();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IComponentFinalizer;", "", "finalizeAll", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IComponentFinalizer {
        void finalizeAll();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IComposer;", "", "composerResolver", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IComposerResolver;", "getComposerResolver", "()Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IComposerResolver;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IComposer {
        @NotNull
        IComposerResolver getComposerResolver();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u001b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0012\u0010\u0010\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IComposerResolver;", "", "uuid", "", "getUuid", "()Ljava/lang/String;", "folderId", "getFolderId", "hasNotification", "", "name", "isEditMode", "()Z", "isSearchMode", "isEditable", "isCoeditMode", "isCoeditNote", "close", "postAction", "Ljava/lang/Runnable;", "closeCoeditComposer", "", "requestViewMode", "currentScreen", "", "getCurrentScreen", "()I", "isInitialLockDismissed", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IComposerResolver {
        boolean close(@Nullable String uuid, @Nullable Runnable postAction);

        void closeCoeditComposer(@Nullable Runnable postAction);

        int getCurrentScreen();

        @NotNull
        String getFolderId();

        @NotNull
        String getUuid();

        boolean hasNotification(@NotNull String name);

        boolean isCoeditMode();

        boolean isCoeditNote();

        boolean isEditMode();

        boolean isEditable();

        boolean isInitialLockDismissed();

        boolean isSearchMode();

        void requestViewMode();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$IfStatement;", "", "isMatched", "", "info", "Lcom/samsung/android/support/senl/nt/base/common/ComposerManager$ComposerInfo;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IfStatement {
        boolean isMatched(@Nullable ComposerInfo info);
    }

    public /* synthetic */ ComposerManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void addInfo(Fragment fragment) {
        if (this.mInfoMap.containsKey(getMapKey(fragment))) {
            return;
        }
        fragment.getLifecycle().addObserver(this);
        this.mInfoMap.put(getMapKey(fragment), new ComposerInfo(fragment));
        printInfoMap();
    }

    private final void closeComposerOverCount(List<ComposerInfo> infoList) {
        IComposerResolver resolver;
        if (infoList.size() < 5) {
            return;
        }
        CollectionsKt.sortedWith(infoList, new C8878a(new C6955h(1), 0));
        for (ComposerInfo composerInfo : infoList) {
            Boolean boolValueOf = null;
            if (composerInfo != null && (resolver = composerInfo.getResolver()) != null) {
                boolValueOf = Boolean.valueOf(resolver.close(null, null));
            }
            Intrinsics.checkNotNull(boolValueOf);
            if (!boolValueOf.booleanValue()) {
                Logger.m8702i(TAG, "closeComposerOverCount# ");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int closeComposerOverCount$lambda$1(ComposerInfo composerInfo, ComposerInfo composerInfo2) {
        Long lValueOf = composerInfo != null ? Long.valueOf(composerInfo.getCreatedTime()) : null;
        Intrinsics.checkNotNull(lValueOf);
        long jLongValue = lValueOf.longValue();
        Long lValueOf2 = composerInfo2 != null ? Long.valueOf(composerInfo2.getCreatedTime()) : null;
        Intrinsics.checkNotNull(lValueOf2);
        long jLongValue2 = jLongValue - lValueOf2.longValue();
        if (jLongValue2 > 0) {
            return 1;
        }
        return jLongValue2 < 0 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int closeComposerOverCount$lambda$2(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private final void closeComposerOverMaintenanceTime(List<ComposerInfo> infoList) {
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) TIME_ONE_DAY);
        Iterator<ComposerInfo> it = infoList.iterator();
        while (it.hasNext()) {
            ComposerInfo next = it.next();
            if (next == null || next.getLastStoppedTime() != 0) {
                Long lValueOf = next != null ? Long.valueOf(next.getLastStoppedTime()) : null;
                Intrinsics.checkNotNull(lValueOf);
                if (lValueOf.longValue() <= jCurrentTimeMillis) {
                    IComposerResolver resolver = next.getResolver();
                    Boolean boolValueOf = resolver != null ? Boolean.valueOf(resolver.close(null, null)) : null;
                    Intrinsics.checkNotNull(boolValueOf);
                    if (!boolValueOf.booleanValue()) {
                        Logger.m8702i(TAG, "closeComposerOverMaintenanceTime# ");
                    }
                }
            }
        }
    }

    private final void doClosedListener() {
        IClosedListener iClosedListener;
        if (!this.mInfoMap.isEmpty() || (iClosedListener = this.mClosedListener) == null) {
            return;
        }
        if (iClosedListener != null) {
            iClosedListener.onClosedAllComposer();
        }
        this.mClosedListener = null;
        Logger.m8702i(TAG, "onClosedAllComposer");
    }

    @NotNull
    public static final synchronized ComposerManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final Activity getLatestComposer(IfStatement invalidCondition) {
        FragmentActivity activity;
        long lastStoppedTime = 0;
        loop0: while (true) {
            activity = null;
            for (ComposerInfo composerInfo : this.mInfoMap.values()) {
                Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
                ComposerInfo composerInfo2 = composerInfo;
                if (!invalidCondition.isMatched(composerInfo2)) {
                    if (composerInfo2.getLastStartedTime() >= lastStoppedTime) {
                        lastStoppedTime = composerInfo2.getLastStartedTime();
                        Fragment fragment = composerInfo2.getFragment();
                        activity = fragment != null ? fragment.getActivity() : null;
                    }
                    if (composerInfo2.getLastStoppedTime() >= lastStoppedTime) {
                        lastStoppedTime = composerInfo2.getLastStoppedTime();
                        Fragment fragment2 = composerInfo2.getFragment();
                        if (fragment2 != null) {
                            activity = fragment2.getActivity();
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (activity != null) {
            Logger.m8697d(TAG, "getLatestComposer# lastActivity: ".concat(activity.getClass().getSimpleName()));
        }
        return activity;
    }

    private final String getMapKey(Fragment fragment) {
        return AbstractC2821a.m2218i(fragment.hashCode(), fragment.getClass().getSimpleName(), "$");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInvalid(ComposerInfo info) {
        return info == null || info.isInvalid();
    }

    private final void onDestroyComposer(LifecycleOwner source) {
        Intrinsics.checkNotNull(source, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        remove((Fragment) source);
        if (this.mInfoMap.isEmpty() && (source instanceof IComponentFinalizer)) {
            ((IComponentFinalizer) source).finalizeAll();
        }
    }

    private final void onStartComposer(LifecycleOwner source) {
        AbstractC4539a.m3203m(source.hashCode(), "onStartComposer# ", TAG);
        HashMap<String, ComposerInfo> map = this.mInfoMap;
        Intrinsics.checkNotNull(source, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        ComposerInfo composerInfo = map.get(getMapKey((Fragment) source));
        if (composerInfo == null) {
            return;
        }
        composerInfo.setLastStartedTime();
    }

    private final void onStopComposer(LifecycleOwner source) {
        AbstractC4539a.m3203m(source.hashCode(), "onStopComposer# ", TAG);
        HashMap<String, ComposerInfo> map = this.mInfoMap;
        Intrinsics.checkNotNull(source, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        ComposerInfo composerInfo = map.get(getMapKey((Fragment) source));
        if (composerInfo == null) {
            return;
        }
        composerInfo.setLastStoppedTime();
    }

    private final void printInfoMap() {
        if (this.mInfoMap.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            sb.append(composerInfo.toString());
            sb.append("\t");
        }
        Logger.m8697d(TAG, sb.toString());
    }

    private final void remove(Fragment fragment) {
        fragment.getLifecycle().removeObserver(this);
        if (this.mInfoMap.remove(getMapKey(fragment)) != null) {
            AbstractC4539a.m3203m(fragment.hashCode(), "remove# ", TAG);
        }
        printInfoMap();
        doClosedListener();
    }

    public final void clearCoeditMemberManagerLeaveResult(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mCoeditMemberManagerResultMap.remove(groupId);
    }

    public final boolean closeAllComposer(@NotNull IClosedListener closedListener) {
        Intrinsics.checkNotNullParameter(closedListener, "closedListener");
        if (this.mInfoMap.isEmpty()) {
            return closedListener.onClosedAllComposer();
        }
        this.mClosedListener = closedListener;
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            IComposerResolver resolver = composerInfo.getResolver();
            if (resolver != null) {
                resolver.close(null, null);
            }
        }
        return true;
    }

    public final void closeCoeditComposer(@Nullable Fragment caller, @Nullable Runnable postAction) {
        IComposerResolver resolver;
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && !Intrinsics.areEqual(composerInfo2.getFragment(), caller) && (resolver = composerInfo2.getResolver()) != null) {
                resolver.closeCoeditComposer(postAction);
            }
        }
    }

    public final void closeComposer(int taskId, @NotNull Function<ComposerInfo, Boolean> closableFunction) {
        Integer taskId2;
        Intrinsics.checkNotNullParameter(closableFunction, "closableFunction");
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && (taskId2 = composerInfo2.getTaskId()) != null && taskId2.intValue() == taskId) {
                if (!closableFunction.apply(composerInfo2).booleanValue()) {
                    Logger.m8697d(TAG, "closeComposer# not closable");
                    return;
                }
                IComposerResolver resolver = composerInfo2.getResolver();
                if (resolver != null) {
                    resolver.close(null, null);
                    return;
                }
                return;
            }
        }
        Logger.m8698e(TAG, "closeComposer# not found activity");
    }

    @Nullable
    public final Integer findTaskIdByNotification(@NotNull String name) {
        IComposerResolver resolver;
        Intrinsics.checkNotNullParameter(name, "name");
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && (resolver = composerInfo2.getResolver()) != null && resolver.hasNotification(name)) {
                return composerInfo2.getTaskId();
            }
        }
        return -1;
    }

    public final boolean getCoeditMemberManagerLeaveResult(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Boolean bool = this.mCoeditMemberManagerResultMap.get(groupId);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Nullable
    public final Activity getComposerActivity(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Iterator<ComposerInfo> it = this.mInfoMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ComposerInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ComposerInfo composerInfo = next;
            if (!isInvalid(composerInfo)) {
                IComposerResolver resolver = composerInfo.getResolver();
                if (Intrinsics.areEqual(uuid, resolver != null ? resolver.getUuid() : null)) {
                    Fragment fragment = composerInfo.getFragment();
                    if (fragment != null) {
                        return fragment.getActivity();
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public final Activity getComposerForActionSend() {
        return getLatestComposer(new IfStatement() { // from class: com.samsung.android.support.senl.nt.base.common.ComposerManager$composerForActionSend$invalidCondition$1
            @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IfStatement
            public boolean isMatched(ComposerManager.ComposerInfo info) {
                Lifecycle lifecycle;
                Lifecycle.State currentState;
                if (this.this$0.isInvalid(info)) {
                    return true;
                }
                Fragment fragment = info != null ? info.getFragment() : null;
                FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
                if (activity != null) {
                    AppTaskCompat companion = AppTaskCompat.INSTANCE.getInstance();
                    Context applicationContext = activity.getApplicationContext();
                    int taskId = activity.getTaskId();
                    String name = activity.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!companion.isEqualTopActivity(applicationContext, taskId, name)) {
                        return true;
                    }
                }
                ComposerManager.IComposerResolver resolver = info != null ? info.getResolver() : null;
                return fragment == null || (lifecycle = fragment.getLifecycle()) == null || (currentState = lifecycle.getCurrentState()) == null || !currentState.isAtLeast(Lifecycle.State.RESUMED) || resolver == null || !resolver.isEditable() || !resolver.isEditMode() || resolver.isCoeditNote();
            }
        });
    }

    @Nullable
    public final Activity getComposerToAddContent(final int callerTaskId) {
        return getLatestComposer(new IfStatement() { // from class: com.samsung.android.support.senl.nt.base.common.ComposerManager$getComposerToAddContent$invalidCondition$1
            @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IfStatement
            public boolean isMatched(ComposerManager.ComposerInfo info) {
                Fragment fragment;
                if (this.this$0.isInvalid(info)) {
                    return true;
                }
                FragmentActivity activity = (info == null || (fragment = info.getFragment()) == null) ? null : fragment.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
                if (activity.getTaskId() != callerTaskId) {
                    AppTaskCompat companion = AppTaskCompat.INSTANCE.getInstance();
                    Context applicationContext = activity.getApplicationContext();
                    int taskId = activity.getTaskId();
                    String name = activity.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!companion.isEqualTopActivity(applicationContext, taskId, name)) {
                        return true;
                    }
                }
                ComposerManager.IComposerResolver resolver = info.getResolver();
                Boolean boolValueOf = resolver != null ? Boolean.valueOf(resolver.isEditable()) : null;
                Intrinsics.checkNotNull(boolValueOf);
                return !boolValueOf.booleanValue() || resolver.isCoeditNote();
            }
        });
    }

    @Nullable
    public final Integer getCurrentScreen() {
        Lifecycle lifecycle;
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                Fragment fragment = composerInfo2.getFragment();
                if (((fragment == null || (lifecycle = fragment.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED) {
                    IComposerResolver resolver = composerInfo2.getResolver();
                    if (resolver != null) {
                        return Integer.valueOf(resolver.getCurrentScreen());
                    }
                    return null;
                }
            }
        }
        return 9000;
    }

    @NotNull
    public final Set<String> getFolderIdsInUse() {
        IComposerResolver resolver;
        HashSet hashSet = new HashSet();
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && (resolver = composerInfo2.getResolver()) != null) {
                hashSet.add(resolver.getFolderId());
            }
        }
        return hashSet;
    }

    @NotNull
    public final String getLatestComposerUuid() {
        return getLatestComposerUuid(new IfStatement() { // from class: com.samsung.android.support.senl.nt.base.common.ComposerManager$latestComposerUuid$invalidCondition$1
            @Override // com.samsung.android.support.senl.nt.base.common.ComposerManager.IfStatement
            public boolean isMatched(ComposerManager.ComposerInfo info) {
                Lifecycle lifecycle;
                Lifecycle.State currentState;
                if (this.this$0.isInvalid(info)) {
                    return true;
                }
                Fragment fragment = info != null ? info.getFragment() : null;
                FragmentActivity activity = fragment != null ? fragment.getActivity() : null;
                if (activity != null) {
                    AppTaskCompat companion = AppTaskCompat.INSTANCE.getInstance();
                    Context applicationContext = activity.getApplicationContext();
                    int taskId = activity.getTaskId();
                    String name = activity.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (!companion.isEqualTopActivity(applicationContext, taskId, name)) {
                        return true;
                    }
                }
                ComposerManager.IComposerResolver resolver = info != null ? info.getResolver() : null;
                return fragment == null || (lifecycle = fragment.getLifecycle()) == null || (currentState = lifecycle.getCurrentState()) == null || !currentState.isAtLeast(Lifecycle.State.RESUMED) || resolver == null || !resolver.isEditable() || !resolver.isEditMode() || resolver.isCoeditNote();
            }
        });
    }

    public final boolean hasComposerInSameTask(@NotNull Activity caller, @Nullable String uuid) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        if (TextUtils.isEmpty(uuid)) {
            Logger.m8697d(TAG, "hasComposerInSameTask - uuid is empty ");
            return false;
        }
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                Integer taskId = composerInfo2.getTaskId();
                int taskId2 = caller.getTaskId();
                if (taskId != null && taskId.intValue() == taskId2) {
                    IComposerResolver resolver = composerInfo2.getResolver();
                    if (Intrinsics.areEqual(uuid, resolver != null ? resolver.getUuid() : null)) {
                        Logger.m8697d(TAG, "hasComposerInSameTask - same task ");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean isActivityResumed(@NotNull String activityName) {
        Lifecycle lifecycle;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                Fragment fragment = composerInfo2.getFragment();
                Lifecycle.State currentState = null;
                if (Intrinsics.areEqual((fragment == null || (activity = fragment.getActivity()) == null) ? null : activity.getClass().getName(), activityName)) {
                    Fragment fragment2 = composerInfo2.getFragment();
                    if (fragment2 != null && (lifecycle = fragment2.getLifecycle()) != null) {
                        currentState = lifecycle.getCurrentState();
                    }
                    if (currentState == Lifecycle.State.RESUMED) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public final boolean isFocusOnComposer() {
        FragmentActivity activity;
        Lifecycle lifecycle;
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                Fragment fragment = composerInfo2.getFragment();
                String name = null;
                if (((fragment == null || (lifecycle = fragment.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED) {
                    Fragment fragment2 = composerInfo2.getFragment();
                    if (fragment2 != null && (activity = fragment2.getActivity()) != null) {
                        name = activity.getClass().getName();
                    }
                    AbstractC4539a.m3188B("isFocusOnComposer# activity: ", name, TAG);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isOpen(@NotNull String uuid, @Nullable Fragment caller) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (TextUtils.isEmpty(uuid)) {
            return false;
        }
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && !Intrinsics.areEqual(composerInfo2.getFragment(), caller)) {
                IComposerResolver resolver = composerInfo2.getResolver();
                if (Intrinsics.areEqual(uuid, resolver != null ? resolver.getUuid() : null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isRunningComposer() {
        return isRunningComposer(null);
    }

    public final boolean isRunningOnCoeditMode() {
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                IComposerResolver resolver = composerInfo2.getResolver();
                Boolean boolValueOf = resolver != null ? Boolean.valueOf(resolver.isCoeditMode()) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isRunningOnEditMode() {
        IComposerResolver resolver;
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && (resolver = composerInfo2.getResolver()) != null && resolver.isEditMode()) {
                return true;
            }
        }
        return false;
    }

    public final void onAttach(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        AbstractC4539a.m3203m(fragment.hashCode(), "onAttached# ", TAG);
        addInfo(fragment);
    }

    public final void onCreate(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        AbstractC4539a.m3203m(fragment.hashCode(), "onCreate# ", TAG);
        addInfo(fragment);
    }

    public final void onDetach(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        remove(fragment);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (Lifecycle.Event.ON_START == event) {
            onStartComposer(source);
        } else if (Lifecycle.Event.ON_STOP == event) {
            onStopComposer(source);
        } else if (Lifecycle.Event.ON_DESTROY == event) {
            onDestroyComposer(source);
        }
    }

    public final void requestViewMode(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                IComposerResolver resolver = composerInfo2.getResolver();
                if (Intrinsics.areEqual(uuid, resolver != null ? resolver.getUuid() : null)) {
                    IComposerResolver resolver2 = composerInfo2.getResolver();
                    if (resolver2 != null) {
                        resolver2.requestViewMode();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void setCoeditMemberManagerLeaveResult(@NotNull String groupId, boolean ret) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.mCoeditMemberManagerResultMap.put(groupId, Boolean.valueOf(ret));
    }

    private ComposerManager() {
        this.mInfoMap = new HashMap<>();
        this.mCoeditMemberManagerResultMap = new HashMap<>();
    }

    public final boolean isRunningComposer(@Nullable Fragment exclusion) {
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && (exclusion == null || !Intrinsics.areEqual(exclusion, composerInfo2.getFragment()))) {
                return true;
            }
        }
        return false;
    }

    private final String getLatestComposerUuid(IfStatement invalidCondition) {
        long lastStoppedTime = 0;
        String strValueOf = "";
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!invalidCondition.isMatched(composerInfo2) && composerInfo2.getLastStoppedTime() >= lastStoppedTime) {
                lastStoppedTime = composerInfo2.getLastStoppedTime();
                IComposerResolver resolver = composerInfo2.getResolver();
                strValueOf = String.valueOf(resolver != null ? resolver.getUuid() : null);
            }
        }
        return strValueOf;
    }

    public final void closeComposer(@NotNull Activity target) {
        Intrinsics.checkNotNullParameter(target, "target");
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2)) {
                Fragment fragment = composerInfo2.getFragment();
                if (Intrinsics.areEqual(fragment != null ? fragment.getActivity() : null, target)) {
                    IComposerResolver resolver = composerInfo2.getResolver();
                    if (resolver != null) {
                        resolver.close(null, null);
                        return;
                    }
                    return;
                }
            }
        }
        Logger.m8698e(TAG, "closeComposer# not found activity");
        target.finish();
    }

    public final boolean closeComposer(@NotNull Fragment caller, @Nullable String uuid, @Nullable Runnable postAction) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        ArrayList arrayList = new ArrayList();
        for (ComposerInfo composerInfo : this.mInfoMap.values()) {
            Intrinsics.checkNotNullExpressionValue(composerInfo, "next(...)");
            ComposerInfo composerInfo2 = composerInfo;
            if (!isInvalid(composerInfo2) && !Intrinsics.areEqual(composerInfo2.getFragment(), caller)) {
                IComposerResolver resolver = composerInfo2.getResolver();
                Boolean boolValueOf = resolver != null ? Boolean.valueOf(resolver.close(uuid, postAction)) : null;
                Intrinsics.checkNotNull(boolValueOf);
                if (!boolValueOf.booleanValue()) {
                    Logger.m8697d(TAG, "closeComposer# false : prev(" + composerInfo2.getTaskId() + ")/curr(" + caller.requireActivity().getTaskId() + ")");
                    return false;
                }
                arrayList.add(composerInfo2);
            }
        }
        closeComposerOverCount(arrayList);
        closeComposerOverMaintenanceTime(arrayList);
        return true;
    }
}
