package com.samsung.android.support.senl.p148nt.base.common.livesharing;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.AddonSessionHandler;
import com.google.android.meet.addons.CollaborationStartingState;
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.RunnableC7967b;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.livesharing.ILiveSharingClient;
import com.samsung.android.support.senl.p148nt.livesharing.LiveSharingClientWrapper;
import com.samsung.android.support.senl.p148nt.livesharing.LiveSharingData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p054M1.DialogInterfaceOnShowListenerC0176c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 _2\u00020\u0001:\u0004\\]^_B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010#\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0001J\u000e\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u0001J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\tH\u0016J\u0006\u0010+\u001a\u00020\u0010J0\u0010,\u001a\u00020-2\b\u0010$\u001a\u0004\u0018\u00010%2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\u000eJ\u000e\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u001bJ\u0010\u00105\u001a\u00020(2\b\u00106\u001a\u0004\u0018\u00010\u001bJ\u0010\u00107\u001a\u00020(2\b\u00108\u001a\u0004\u0018\u00010\u001bJ\u001e\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u00020\u00102\u0006\u0010;\u001a\u00020<H\u0002J \u0010A\u001a\u00020B2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010C\u001a\u00020(2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0019H\u0002J\"\u0010E\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010\u001b2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010/J\u0018\u0010E\u001a\u00020-2\u0010\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010/J\b\u0010G\u001a\u00020(H\u0002J\u0010\u0010H\u001a\u00020(2\b\u0010I\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010J\u001a\u00020-2\b\u0010K\u001a\u0004\u0018\u00010LJ\u001e\u0010M\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u0010J\u000e\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\fJ\u000e\u0010Q\u001a\u00020(2\u0006\u0010P\u001a\u00020\fJ\u0010\u0010R\u001a\u00020(2\b\u0010&\u001a\u0004\u0018\u00010 J\b\u0010S\u001a\u00020(H\u0002J\u000e\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020\u001bJ\u0006\u0010V\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u0014\u00109\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0015R$\u0010W\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006`"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager;", "Lcom/google/android/meet/addons/MeetingStatusListener;", "<init>", "()V", "mClient", "Lcom/samsung/android/support/senl/nt/livesharing/LiveSharingClientWrapper;", "mMeetingStatusListenerList", "", "mLastMeetingStatus", "Lcom/google/android/meet/addons/MeetingStatus;", "mAddonSessionHandlers", "", "Lcom/google/android/meet/addons/AddonSessionHandler;", "mStateChangeListeners", "Lcom/samsung/android/support/senl/nt/livesharing/ILiveSharingClient$StateChangeListener;", "mShowConfirmDialogFlag", "", "mConnectionConfirmDialog", "Landroidx/appcompat/app/AlertDialog;", "mIsCanceled", "getMIsCanceled", "()Z", "setMIsCanceled", "(Z)V", "mTipCardType", "", "mCoEditNoteUuid", "", "mInvitationLink", "mCaller", "Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager$Caller;", "mLiveSharingDisconnectionListener", "Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager$LiveSharingDisconnectionListener;", "isInvitationLinkOpenRequested", "setInvitationLinkOpenRequested", "registerMeetingStatusListener", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterMeetingStatusListener", "", "onMeetingStatusChange", "meetingStatus", "canShowConfirmDialog", "connectMeeting", "Lcom/samsung/android/support/senl/nt/livesharing/ILiveSharingClient$ErrorState;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/support/senl/nt/livesharing/ILiveSharingClient$Callback;", "Lcom/google/android/meet/addons/AddonMeetingInfo;", "addonSessionHandler", "stateChangeListener", "isCoEditingNote", "uuid", "setInvitationLink", "invitationLink", "setCoEditNoteUuid", "coEditNoteUuid", "isConnected", "showConfirmDialog", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "isHost", "onClickListener", "Landroid/content/DialogInterface$OnClickListener;", "isActivityAttached", "createConfirmDialog", "Ljava/lang/Runnable;", "onDialogClickSALogging", "buttonId", "disconnectMeeting", "Ljava/lang/Void;", "onEndMeeting", "removeCoDoingDelegate", "coDoingDelegate", "sendSharingData", "liveSharingData", "Lcom/samsung/android/support/senl/nt/livesharing/LiveSharingData;", "runLiveSharingActivity", "selectNote", "registerAddonSessionHandler", "handler", "unregisterAddonSessionHandler", "setLiveSharingDisconnectionListener", "releaseLiveSharingDisconnectionListener", "setCanceled", "msg", "getNotNow", "tipCardType", "getTipCardType", "()I", "setTipCardType", "(I)V", "Caller", "LiveSharingDisconnectionListener", "TipCardCallback", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LiveSharingManager implements MeetingStatusListener {
    public static final int DIALOG_CANCEL_BUTTON = 99;
    public static final int DIALOG_LATER_BUTTON = -3;
    public static final int DIALOG_SELECT_NOTE_BUTTON = -1;

    @NotNull
    public static final String EXTRA_IS_HOST = "I_AM_HOST";

    @NotNull
    public static final String EXTRA_IS_SELECT_NOTE_MENU = "SELECT_NOTE";

    @NotNull
    private static final String TAG = "LS$LiveSharingManager";

    @Nullable
    private static LiveSharingManager mInstance;
    private boolean isInvitationLinkOpenRequested;

    @NotNull
    private final Set<AddonSessionHandler> mAddonSessionHandlers;

    @NotNull
    private final Caller mCaller;

    @NotNull
    private final LiveSharingClientWrapper mClient;

    @Nullable
    private String mCoEditNoteUuid;

    @Nullable
    private AlertDialog mConnectionConfirmDialog;

    @Nullable
    private String mInvitationLink;
    private boolean mIsCanceled;

    @Nullable
    private MeetingStatus mLastMeetingStatus;

    @Nullable
    private LiveSharingDisconnectionListener mLiveSharingDisconnectionListener;

    @NotNull
    private final List<MeetingStatusListener> mMeetingStatusListenerList;
    private boolean mShowConfirmDialogFlag;

    @NotNull
    private final Set<ILiveSharingClient.StateChangeListener> mStateChangeListeners;
    private int mTipCardType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static int NONE = -1;
    private static int DIALOG = 1;

    @JvmField
    public static int TIPCARD_HOST = 2;

    @JvmField
    public static int TIPCARD_GUEST = 3;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager$Caller;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "MAIN_LIST", "COMPOSER", "SETTINGS", "TIP_CARD_NEW", "TIP_CARD_EXIST", "TIP_CARD_JOIN", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Caller {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Caller[] $VALUES;
        public static final Caller NONE = new Caller(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final Caller MAIN_LIST = new Caller("MAIN_LIST", 1);
        public static final Caller COMPOSER = new Caller("COMPOSER", 2);
        public static final Caller SETTINGS = new Caller("SETTINGS", 3);
        public static final Caller TIP_CARD_NEW = new Caller("TIP_CARD_NEW", 4);
        public static final Caller TIP_CARD_EXIST = new Caller("TIP_CARD_EXIST", 5);
        public static final Caller TIP_CARD_JOIN = new Caller("TIP_CARD_JOIN", 6);

        private static final /* synthetic */ Caller[] $values() {
            return new Caller[]{NONE, MAIN_LIST, COMPOSER, SETTINGS, TIP_CARD_NEW, TIP_CARD_EXIST, TIP_CARD_JOIN};
        }

        static {
            Caller[] callerArr$values = $values();
            $VALUES = callerArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(callerArr$values);
        }

        private Caller(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Caller> getEntries() {
            return $ENTRIES;
        }

        public static Caller valueOf(String str) {
            return (Caller) Enum.valueOf(Caller.class, str);
        }

        public static Caller[] values() {
            return (Caller[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "EXTRA_IS_HOST", "EXTRA_IS_SELECT_NOTE_MENU", CoverStickerConstants.Category.NONE.NAME, "", "DIALOG", "getDIALOG", "()I", "setDIALOG", "(I)V", "TIPCARD_HOST", "TIPCARD_GUEST", "DIALOG_LATER_BUTTON", "DIALOG_SELECT_NOTE_BUTTON", "DIALOG_CANCEL_BUTTON", "mInstance", "Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager;", "isSupported", "", "()Z", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        public final int getDIALOG() {
            return LiveSharingManager.DIALOG;
        }

        @Nullable
        public final LiveSharingManager getInstance() {
            if (LiveSharingManager.mInstance == null) {
                LiveSharingManager.mInstance = new LiveSharingManager(null);
            }
            return LiveSharingManager.mInstance;
        }

        public final boolean isSupported() {
            return LiveSharingClientWrapper.isSupported();
        }

        public final void setDIALOG(int i) {
            LiveSharingManager.DIALOG = i;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager$LiveSharingDisconnectionListener;", "", "onDisconnected", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface LiveSharingDisconnectionListener {
        void onDisconnected();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/livesharing/LiveSharingManager$TipCardCallback;", "", Constants.IntentExtraValue.SHOW, "", "tipcardType", "", "dismiss", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface TipCardCallback {
        void dismiss();

        void show(int tipcardType);
    }

    public /* synthetic */ LiveSharingManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectMeeting$lambda$0(LiveSharingManager liveSharingManager, LiveSharingData liveSharingData) {
        Logger.m8697d(TAG, "StateChangeListener#onStateChanged");
        if (liveSharingManager.mStateChangeListeners.isEmpty()) {
            return;
        }
        Iterator<ILiveSharingClient.StateChangeListener> it = liveSharingManager.mStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(liveSharingData);
        }
    }

    private final Runnable createConfirmDialog(Activity activity, boolean isHost, DialogInterface.OnClickListener onClickListener) {
        return new RunnableC7967b(this, activity, isHost, onClickListener, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void createConfirmDialog$lambda$4(final LiveSharingManager liveSharingManager, Activity activity, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        if (!liveSharingManager.isActivityAttached(activity)) {
            Logger.m8698e(TAG, "createConfirmDialog# activity not attached");
            return;
        }
        AlertDialog alertDialog = liveSharingManager.mConnectionConfirmDialog;
        Object[] objArr = 0;
        if (alertDialog != null && alertDialog.isShowing()) {
            try {
                AlertDialog alertDialog2 = liveSharingManager.mConnectionConfirmDialog;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                }
            } catch (IllegalArgumentException e) {
                AbstractC4539a.m3214x("createConfirmDialog# dismiss dialog failed: ", e.getMessage(), TAG);
                liveSharingManager.mConnectionConfirmDialog = null;
            } catch (Exception e2) {
                AbstractC4539a.m3214x("createConfirmDialog# dismiss dialog failed: ", e2.getMessage(), TAG);
                liveSharingManager.mConnectionConfirmDialog = null;
            }
        }
        if (!liveSharingManager.mShowConfirmDialogFlag) {
            Logger.m8697d(TAG, "createConfirmDialog# already show or end meet ");
            return;
        }
        liveSharingManager.mShowConfirmDialogFlag = false;
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(activity, 0, 2, objArr == true ? 1 : 0);
        DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.base.common.livesharing.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveSharingManager.createConfirmDialog$lambda$4$lambda$1(this.f6441a, onClickListener, z, dialogInterface, i);
            }
        };
        if (z) {
            alertDialogBuilderForAppCompat.setTitle(C8875R.string.live_sharing_dialog_host_title).setMessage(C8875R.string.live_sharing_dialog_body).setNeutralButton(C8875R.string.base_string_not_now, onClickListener2).setNegativeButton(C8875R.string.live_sharing_dialog_host_create_note, onClickListener2).setPositiveButton(C8875R.string.live_sharing_dialog_host_select_note, onClickListener2);
        } else {
            alertDialogBuilderForAppCompat.setTitle(C8875R.string.live_sharing_dialog_guest_title).setMessage(C8875R.string.live_sharing_dialog_body).setNeutralButton(C8875R.string.base_string_not_now, onClickListener2).setPositiveButton(C8875R.string.base_string_join, onClickListener2);
        }
        alertDialogBuilderForAppCompat.setIcon(C8875R.drawable.ic_meet);
        alertDialogBuilderForAppCompat.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.samsung.android.support.senl.nt.base.common.livesharing.b
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LiveSharingManager.createConfirmDialog$lambda$4$lambda$2(this.f6444a, onClickListener, dialogInterface);
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        liveSharingManager.mConnectionConfirmDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog3 = liveSharingManager.mConnectionConfirmDialog;
        Window window = alertDialog3 != null ? alertDialog3.getWindow() : null;
        if (window != null) {
            window.setGravity(17);
        }
        AlertDialog alertDialog4 = liveSharingManager.mConnectionConfirmDialog;
        if (alertDialog4 != null) {
            alertDialog4.setOnShowListener(new DialogInterfaceOnShowListenerC0176c(liveSharingManager, 4));
        }
        AlertDialog alertDialog5 = liveSharingManager.mConnectionConfirmDialog;
        if (alertDialog5 != null) {
            alertDialog5.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createConfirmDialog$lambda$4$lambda$1(LiveSharingManager liveSharingManager, DialogInterface.OnClickListener onClickListener, boolean z, DialogInterface dialogInterface, int i) {
        AbstractC4539a.m3203m(i, "showConfirmDialog#onClick: ", TAG);
        if (i == -3) {
            liveSharingManager.setCanceled("onClick cancel");
        }
        onClickListener.onClick(dialogInterface, i);
        liveSharingManager.onDialogClickSALogging(z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createConfirmDialog$lambda$4$lambda$2(LiveSharingManager liveSharingManager, DialogInterface.OnClickListener onClickListener, DialogInterface dialogInterface) {
        Logger.m8697d(TAG, "showConfirmDialog#onCancel");
        liveSharingManager.mShowConfirmDialogFlag = true;
        onClickListener.onClick(dialogInterface, 99);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createConfirmDialog$lambda$4$lambda$3(LiveSharingManager liveSharingManager, DialogInterface dialogInterface) {
        Window window;
        AlertDialog alertDialog = liveSharingManager.mConnectionConfirmDialog;
        if (alertDialog == null) {
            Logger.m8698e(TAG, "ConnectionConfirmDialog#onShow# fail. dialog is null");
            return;
        }
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        ImageView imageView = (ImageView) window.getDecorView().findViewById(R.id.icon);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        int dimensionPixelSize = imageView.getResources().getDimensionPixelSize(C8875R.dimen.live_sharing_confirm_dialog_icon_size);
        layoutParams2.width = dimensionPixelSize;
        layoutParams2.height = dimensionPixelSize;
        imageView.setLayoutParams(layoutParams2);
        Button button = (Button) window.getDecorView().findViewById(R.id.button2);
        ViewGroup.LayoutParams layoutParams3 = button.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.width = window.getDecorView().getWidth();
        button.setLayoutParams(layoutParams4);
        ((LinearLayout) window.getDecorView().findViewById(C8875R.id.title_template)).setGravity(8388627);
    }

    @Nullable
    public static final LiveSharingManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final boolean isActivityAttached(Activity activity) {
        if (activity.isDestroyed() || activity.isFinishing() || activity.getWindow() == null) {
            return false;
        }
        return activity.getWindow().getDecorView().isAttachedToWindow();
    }

    private final boolean isConnected() {
        AddonMeetingInfo meetingInfo = this.mClient.getMeetingInfo();
        if (meetingInfo == null) {
            return false;
        }
        Logger.m8697d(TAG, "isConnected# AddonMeetingInfo status : " + meetingInfo.meetingStatus());
        return meetingInfo.meetingStatus() != AddonMeetingInfo.MeetingStatus.NOT_CONNECTED;
    }

    private final void onDialogClickSALogging(boolean isHost, int buttonId) {
        if (!isHost) {
            if (buttonId == -3) {
                NotesSamsungAnalytics.INSTANCE.insertLog("691", "7675");
                return;
            } else {
                NotesSamsungAnalytics.INSTANCE.insertLog("691", "7676");
                return;
            }
        }
        if (buttonId == -3) {
            NotesSamsungAnalytics.INSTANCE.insertLog("690", "7674");
        } else if (buttonId != -1) {
            NotesSamsungAnalytics.INSTANCE.insertLog("690", "7672");
        } else {
            NotesSamsungAnalytics.INSTANCE.insertLog("690", "7673");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEndMeeting() {
        this.mAddonSessionHandlers.clear();
        this.mStateChangeListeners.clear();
        setCoEditNoteUuid(null);
        setInvitationLink(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseLiveSharingDisconnectionListener() {
        if (this.mLiveSharingDisconnectionListener != null) {
            Logger.m8697d(TAG, "releaseLiveSharingDisconnectionListener");
        }
        this.mLiveSharingDisconnectionListener = null;
    }

    /* JADX INFO: renamed from: canShowConfirmDialog, reason: from getter */
    public final boolean getMShowConfirmDialogFlag() {
        return this.mShowConfirmDialogFlag;
    }

    @NotNull
    public final ILiveSharingClient.ErrorState connectMeeting(@Nullable Context context, @NotNull final ILiveSharingClient.Callback<AddonMeetingInfo> callback, @NotNull AddonSessionHandler addonSessionHandler, @NotNull ILiveSharingClient.StateChangeListener stateChangeListener) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(addonSessionHandler, "addonSessionHandler");
        Intrinsics.checkNotNullParameter(stateChangeListener, "stateChangeListener");
        ILiveSharingClient.ErrorState errorStateConnectMeeting = this.mClient.connectMeeting(context, new ILiveSharingClient.Callback<AddonMeetingInfo>() { // from class: com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager$connectMeeting$errorState$1
            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onFailure(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                AbstractC4539a.m3188B("connectMeeting#onFailure : ", throwable.getMessage(), "LS$LiveSharingManager");
                callback.onFailure(throwable);
            }

            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onSuccess(AddonMeetingInfo addonMeetingInfo) {
                Intrinsics.checkNotNullParameter(addonMeetingInfo, "addonMeetingInfo");
                Logger.m8697d("LS$LiveSharingManager", "connectMeeting#onSuccess AddonMeetingInfo status : " + addonMeetingInfo.meetingStatus());
                callback.onSuccess(addonMeetingInfo);
            }
        }, new AddonSessionHandler() { // from class: com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager$connectMeeting$errorState$2
            @Override // com.google.android.meet.addons.AddonSessionHandler
            public void onCollaborationStartingStateUpdate(CollaborationStartingState collaborationStartingState) {
                Intrinsics.checkNotNullParameter(collaborationStartingState, "collaborationStartingState");
                Logger.m8697d("LS$LiveSharingManager", "addonSessionHandler#onCollaborationStartingStateUpdate");
            }

            @Override // com.google.android.meet.addons.AddonSessionHandler
            public void onParticipantPrivilegeChanged(List<? extends AddonSessionHandler.Privilege> list, List<? extends AddonSessionHandler.Privilege> list1) {
                Intrinsics.checkNotNullParameter(list, "list");
                Intrinsics.checkNotNullParameter(list1, "list1");
                Logger.m8697d("LS$LiveSharingManager", "addonSessionHandler#onParticipantPrivilegeChanged");
            }

            @Override // com.google.android.meet.addons.AddonSessionHandler
            public void onSessionEnded(AddonSessionHandler.EndReason endReason) {
                Intrinsics.checkNotNullParameter(endReason, "endReason");
                Logger.m8697d("LS$LiveSharingManager", "addonSessionHandler#onSessionEnded : " + endReason);
                Iterator it = this.this$0.mAddonSessionHandlers.iterator();
                while (it.hasNext()) {
                    ((AddonSessionHandler) it.next()).onSessionEnded(endReason);
                }
                this.this$0.onEndMeeting();
                this.this$0.releaseLiveSharingDisconnectionListener();
            }
        }, new ILiveSharingClient.StateChangeListener() { // from class: com.samsung.android.support.senl.nt.base.common.livesharing.c
            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.StateChangeListener
            public final void onStateChanged(LiveSharingData liveSharingData) {
                LiveSharingManager.connectMeeting$lambda$0(this.f6446a, liveSharingData);
            }
        });
        this.mStateChangeListeners.add(stateChangeListener);
        if (ILiveSharingClient.ErrorState.NONE == errorStateConnectMeeting) {
            this.mAddonSessionHandlers.clear();
            this.mAddonSessionHandlers.add(addonSessionHandler);
        }
        Logger.m8697d(TAG, "connectMeeting# errorState : " + errorStateConnectMeeting);
        Intrinsics.checkNotNull(errorStateConnectMeeting);
        return errorStateConnectMeeting;
    }

    @NotNull
    public final ILiveSharingClient.ErrorState disconnectMeeting(@Nullable String uuid, @Nullable ILiveSharingClient.Callback<Void> callback) {
        String str = uuid == null ? "null" : uuid;
        String str2 = this.mCoEditNoteUuid;
        Logger.m8697d(TAG, "disconnectMeeting# uuid : " + str + ", CoEditNoteUuid : " + (str2 != null ? str2 : "null"));
        return (uuid == null || !Intrinsics.areEqual(uuid, this.mCoEditNoteUuid)) ? ILiveSharingClient.ErrorState.NONE : disconnectMeeting(callback);
    }

    public final boolean getMIsCanceled() {
        return this.mIsCanceled;
    }

    public final boolean getNotNow() {
        return this.mIsCanceled;
    }

    /* JADX INFO: renamed from: getTipCardType, reason: from getter */
    public final int getMTipCardType() {
        return this.mTipCardType;
    }

    public final boolean isCoEditingNote(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return Intrinsics.areEqual(uuid, this.mCoEditNoteUuid);
    }

    /* JADX INFO: renamed from: isInvitationLinkOpenRequested, reason: from getter */
    public final boolean getIsInvitationLinkOpenRequested() {
        return this.isInvitationLinkOpenRequested;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    @Override // com.google.android.meet.addons.MeetingStatusListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeetingStatusChange(@NotNull MeetingStatus meetingStatus) {
        Intrinsics.checkNotNullParameter(meetingStatus, "meetingStatus");
        Object obj = this.mLastMeetingStatus;
        if (obj == null) {
            obj = "null";
        }
        Logger.m8697d(TAG, "onMeetingStatusChange# meetingStatus : " + meetingStatus + ", last meetingStatus :" + obj);
        MeetingStatus meetingStatus2 = this.mLastMeetingStatus;
        if (meetingStatus2 != null) {
            if ((meetingStatus2 != null ? meetingStatus2.status() : null) == MeetingStatus.Status.NO_MEETING) {
            }
        } else if (meetingStatus.status() != MeetingStatus.Status.NO_MEETING) {
            Logger.m8697d(TAG, "onMeetingStatusChange# set mShowConfirmDialogFlag");
            this.mShowConfirmDialogFlag = true;
        } else {
            this.mShowConfirmDialogFlag = false;
        }
        this.mLastMeetingStatus = meetingStatus;
        Iterator<MeetingStatusListener> it = this.mMeetingStatusListenerList.iterator();
        while (it.hasNext()) {
            it.next().onMeetingStatusChange(meetingStatus);
        }
    }

    public final void registerAddonSessionHandler(@NotNull AddonSessionHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (INSTANCE.isSupported() && isConnected()) {
            boolean zAdd = this.mAddonSessionHandlers.add(handler);
            Logger.m8702i(TAG, "registerAddonSessionHandler# " + this.mAddonSessionHandlers.size() + " r: " + zAdd);
        }
    }

    public final boolean registerMeetingStatusListener(@Nullable Context context, @NotNull MeetingStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (context == null || !INSTANCE.isSupported()) {
            return false;
        }
        if (this.mMeetingStatusListenerList.contains(listener)) {
            Logger.m8702i(TAG, "registerMeetingStatusListener# already registered");
            return false;
        }
        if (!RequestToSyncManager.INSTANCE.isSesAvailable(context)) {
            return false;
        }
        Logger.m8702i(TAG, "registerMeetingStatusListener#");
        if (this.mMeetingStatusListenerList.isEmpty()) {
            Logger.m8702i(TAG, "registerMeetingStatusListener# register");
            try {
                this.mClient.registerMeetingStatusListener(context.getApplicationContext(), this);
            } catch (IllegalStateException e) {
                MeetingStatus meetingStatus = this.mLastMeetingStatus;
                if (meetingStatus == null) {
                    objStatus = "null";
                } else if (meetingStatus != null) {
                    objStatus = meetingStatus.status();
                }
                Logger.m8698e(TAG, "registerMeetingStatusListener# lms: " + objStatus + " " + e.getMessage());
                return false;
            }
        } else {
            MeetingStatus meetingStatus2 = this.mLastMeetingStatus;
            if (meetingStatus2 != null) {
                if ((meetingStatus2 != null ? meetingStatus2.status() : null) != MeetingStatus.Status.NO_MEETING) {
                    MeetingStatus meetingStatus3 = this.mLastMeetingStatus;
                    Intrinsics.checkNotNull(meetingStatus3);
                    listener.onMeetingStatusChange(meetingStatus3);
                }
            }
        }
        this.mMeetingStatusListenerList.add(listener);
        return true;
    }

    public final void removeCoDoingDelegate(@Nullable ILiveSharingClient.StateChangeListener coDoingDelegate) {
        if (coDoingDelegate != null) {
            this.mStateChangeListeners.remove(coDoingDelegate);
        }
    }

    public final void runLiveSharingActivity(@NotNull Activity activity, boolean isHost, boolean selectNote) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (NoteListAccessHandler.getLiveSharingActivityClass() == null) {
            Logger.m8698e(TAG, "runLiveSharingActivity# return - activity is null");
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Logger.m8702i(TAG, "runLiveSharingActivity");
        Intent intent = new Intent(activity.getApplicationContext(), NoteListAccessHandler.getLiveSharingActivityClass());
        intent.putExtra("I_AM_HOST", isHost);
        if (isHost) {
            intent.putExtra(EXTRA_IS_SELECT_NOTE_MENU, selectNote);
        }
        activity.startActivity(intent);
    }

    @NotNull
    public final ILiveSharingClient.ErrorState sendSharingData(@Nullable LiveSharingData liveSharingData) {
        ILiveSharingClient.ErrorState errorStateSendSharingData = this.mClient.sendSharingData(liveSharingData);
        Intrinsics.checkNotNullExpressionValue(errorStateSendSharingData, "sendSharingData(...)");
        return errorStateSendSharingData;
    }

    public final void setCanceled(@NotNull String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Logger.m8697d(TAG, "setCanceled# caller: " + this.mCaller.name() + SQLKeyword.COMMA + msg);
        this.mIsCanceled = true;
    }

    public final void setCoEditNoteUuid(@Nullable String coEditNoteUuid) {
        String str = this.mCoEditNoteUuid;
        if (str == null && coEditNoteUuid != null) {
            AbstractC4539a.m3188B("setCoEditNoteUuid# ", Logger.getEncode(coEditNoteUuid), TAG);
        } else if (str != null) {
            if (coEditNoteUuid == null) {
                Logger.m8697d(TAG, "setCoEditNoteUuid# clear");
            } else {
                AbstractC4539a.m3214x("setCoEditNoteUuid# unexpected case: ", CommonUtils.getCallee(Thread.currentThread().getStackTrace()), TAG);
            }
        }
        this.mCoEditNoteUuid = coEditNoteUuid;
    }

    public final void setInvitationLink(@Nullable String invitationLink) {
        String str = this.mInvitationLink;
        if (str == null && invitationLink != null) {
            AbstractC4539a.m3188B("setInvitationLink# ", Logger.getEncode(invitationLink), TAG);
        } else if (str != null) {
            if (invitationLink == null) {
                Logger.m8697d(TAG, "setInvitationLink# clear");
            } else {
                AbstractC4539a.m3214x("setInvitationLink# unexpected case: ", CommonUtils.getCallee(Thread.currentThread().getStackTrace()), TAG);
            }
        }
        this.mInvitationLink = invitationLink;
    }

    public final void setInvitationLinkOpenRequested(boolean z) {
        this.isInvitationLinkOpenRequested = z;
    }

    public final void setLiveSharingDisconnectionListener(@Nullable LiveSharingDisconnectionListener listener) {
        Logger.m8697d(TAG, "setLiveSharingDisconnectionListener");
        this.mLiveSharingDisconnectionListener = listener;
    }

    public final void setMIsCanceled(boolean z) {
        this.mIsCanceled = z;
    }

    public final void setTipCardType(int i) {
        AbstractC4539a.m3203m(i, "setTipCardType# ", TAG);
        this.mTipCardType = i;
    }

    public final void showConfirmDialog(@NotNull Activity activity, boolean isHost, @NotNull DialogInterface.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        if (!INSTANCE.isSupported()) {
            Logger.m8698e(TAG, "showConfirmDialog# return - LiveSharingManager is not supported");
            return;
        }
        boolean z = this.mIsCanceled;
        if (!z && this.mShowConfirmDialogFlag) {
            activity.runOnUiThread(createConfirmDialog(activity, isHost, onClickListener));
            if (isHost) {
                NotesSamsungAnalytics.INSTANCE.insertLog("690", "7670");
                return;
            } else {
                NotesSamsungAnalytics.INSTANCE.insertLog("691", "7671");
                return;
            }
        }
        Logger.m8697d(TAG, "showConfirmDialog# mIsCanceled: " + z + ", mShowConfirmDialogFlag: " + this.mShowConfirmDialogFlag);
    }

    public final void unregisterAddonSessionHandler(@NotNull AddonSessionHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (INSTANCE.isSupported()) {
            boolean zRemove = this.mAddonSessionHandlers.remove(handler);
            Logger.m8702i(TAG, "unregisterAddonSessionHandler# " + this.mAddonSessionHandlers.size() + " r: " + zRemove);
        }
    }

    public final void unregisterMeetingStatusListener(@NotNull MeetingStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mMeetingStatusListenerList.isEmpty()) {
            Logger.m8697d(TAG, "unregisterMeetingStatusListener# MeetingStatusListenerList is empty");
            this.mLastMeetingStatus = null;
            return;
        }
        this.mMeetingStatusListenerList.remove(listener);
        if (this.mMeetingStatusListenerList.isEmpty()) {
            try {
                this.mClient.unregisterMeetingStatusListener(BaseUtils.getApplicationContext());
            } catch (IllegalStateException e) {
                MeetingStatus meetingStatus = this.mLastMeetingStatus;
                Object objStatus = meetingStatus == null ? "null" : meetingStatus != null ? meetingStatus.status() : null;
                Logger.m8698e(TAG, "unregisterMeetingStatusListener# lms: " + objStatus + " " + e.getMessage());
            }
            this.mLastMeetingStatus = null;
        }
    }

    private LiveSharingManager() {
        this.mClient = new LiveSharingClientWrapper();
        this.mMeetingStatusListenerList = new ArrayList();
        this.mAddonSessionHandlers = new HashSet();
        this.mStateChangeListeners = new HashSet();
        this.mTipCardType = NONE;
        this.mCaller = Caller.NONE;
    }

    @NotNull
    public final ILiveSharingClient.ErrorState disconnectMeeting(@Nullable final ILiveSharingClient.Callback<Void> callback) {
        ILiveSharingClient.ErrorState errorStateDisconnectMeeting = this.mClient.disconnectMeeting(new ILiveSharingClient.Callback<Void>() { // from class: com.samsung.android.support.senl.nt.base.common.livesharing.LiveSharingManager$disconnectMeeting$disconnectResult$1
            private final void onDisconnected() {
                if (this.this$0.mLiveSharingDisconnectionListener != null) {
                    LiveSharingManager.LiveSharingDisconnectionListener liveSharingDisconnectionListener = this.this$0.mLiveSharingDisconnectionListener;
                    if (liveSharingDisconnectionListener != null) {
                        liveSharingDisconnectionListener.onDisconnected();
                    }
                    this.this$0.releaseLiveSharingDisconnectionListener();
                }
            }

            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onFailure(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                AbstractC4539a.m3206p("disconnectMeeting#onFailure : ", throwable.getMessage(), "LS$LiveSharingManager");
                ILiveSharingClient.Callback<Void> callback2 = callback;
                if (callback2 != null) {
                    callback2.onFailure(throwable);
                }
                onDisconnected();
            }

            @Override // com.samsung.android.support.senl.nt.livesharing.ILiveSharingClient.Callback
            public void onSuccess(Void unused) {
                Intrinsics.checkNotNullParameter(unused, "unused");
                Logger.m8702i("LS$LiveSharingManager", "disconnectMeeting#onSuccess unused : " + unused);
                this.this$0.onEndMeeting();
                ILiveSharingClient.Callback<Void> callback2 = callback;
                if (callback2 != null) {
                    callback2.onSuccess(unused);
                }
                onDisconnected();
            }
        });
        Logger.m8702i(TAG, "disconnectMeeting# disconnectResult : " + errorStateDisconnectMeeting);
        Intrinsics.checkNotNull(errorStateDisconnectMeeting);
        return errorStateDisconnectMeeting;
    }
}
