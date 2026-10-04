package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.SpeakerRenameDialog;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0007J$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J$\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010\u001b\u001a\u00020\u001c2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mSpeakerRenameListener", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogResultListener;", "DIALOG_STACK", "Ljava/util/Stack;", "getDIALOG_STACK$ntStt_release", "()Ljava/util/Stack;", Constants.IntentExtraValue.SHOW, "Landroidx/fragment/app/DialogFragment;", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "bundle", "Landroid/os/Bundle;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "createDialogByTag", "Lcom/samsung/android/support/senl/nt/stt/view/dialog/AbsSTTDialogFragment;", "getListenerByTag", "isEditDialog", "", "createEditDialog", "createSpeakerRenameDialog", "showDialogFragment", "", "dialog", "destroyListener", "DialogResultListener", "DialogDestroyListener", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class STTDialogFactory {

    @NotNull
    private static final String TAG = "STTDialogFactory";

    @Nullable
    private static DialogResultListener mSpeakerRenameListener;

    @NotNull
    public static final STTDialogFactory INSTANCE = new STTDialogFactory();

    @NotNull
    private static final Stack<String> DIALOG_STACK = new Stack<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogDestroyListener;", "", "onDialogDestroy", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DialogDestroyListener {
        void onDialogDestroy(@Nullable FragmentManager fragmentManager);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&R \u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/view/dialog/STTDialogFactory$DialogResultListener;", "", "onDialogResult", "", "dialog", "Landroidx/fragment/app/DialogFragment;", "bundle", "Landroid/os/Bundle;", "speakerNameMap", "", "", "", "getSpeakerNameMap", "()Ljava/util/Map;", "isShowing", "", "()Z", "setShowing", "(Z)V", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DialogResultListener {
        @Nullable
        Map<Integer, String> getSpeakerNameMap();

        boolean isShowing();

        void onDialogResult(@Nullable DialogFragment dialog, @Nullable Bundle bundle);

        void setShowing(boolean z);
    }

    private STTDialogFactory() {
    }

    private final AbsSTTDialogFragment createDialogByTag(String tag, Bundle bundle, DialogResultListener listener) {
        if (Intrinsics.areEqual(tag, DialogConstant.SPEAKER_RENAME_DIALOG)) {
            return createSpeakerRenameDialog(bundle, listener);
        }
        return null;
    }

    private final AbsSTTDialogFragment createEditDialog(String tag, Bundle bundle, DialogResultListener listener) {
        if (Intrinsics.areEqual(tag, DialogConstant.SPEAKER_RENAME_DIALOG)) {
            return createSpeakerRenameDialog(bundle, listener);
        }
        return null;
    }

    private final AbsSTTDialogFragment createSpeakerRenameDialog(Bundle bundle, DialogResultListener listener) {
        Logger.m12713i(TAG, "createSpeakerRenameDialog");
        mSpeakerRenameListener = listener;
        SpeakerRenameDialog.Companion companion = SpeakerRenameDialog.INSTANCE;
        Intrinsics.checkNotNull(listener);
        return companion.newInstance(bundle, listener);
    }

    @JvmStatic
    public static final void destroyListener() {
        mSpeakerRenameListener = null;
    }

    private final boolean isEditDialog(String tag) {
        return Intrinsics.areEqual(tag, DialogConstant.EDIT_STT_DIALOG) || Intrinsics.areEqual(tag, DialogConstant.SPEAKER_RENAME_DIALOG);
    }

    public static /* synthetic */ DialogFragment show$default(STTDialogFactory sTTDialogFactory, FragmentManager fragmentManager, String str, Bundle bundle, DialogResultListener dialogResultListener, int i, Object obj) {
        if ((i & 8) != 0) {
            dialogResultListener = null;
        }
        return sTTDialogFactory.show(fragmentManager, str, bundle, dialogResultListener);
    }

    private final void showDialogFragment(FragmentManager manager, DialogFragment dialog, String tag) {
        if (manager == null) {
            return;
        }
        FragmentManager childFragmentManager = manager.getFragments().get(0).getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        childFragmentManager.beginTransaction().add(dialog, tag).commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    @NotNull
    public final Stack<String> getDIALOG_STACK$ntStt_release() {
        return DIALOG_STACK;
    }

    @Nullable
    public final DialogResultListener getListenerByTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (Intrinsics.areEqual(tag, DialogConstant.SPEAKER_RENAME_DIALOG)) {
            return mSpeakerRenameListener;
        }
        return null;
    }

    @JvmOverloads
    @Nullable
    public final DialogFragment show(@Nullable FragmentManager fragmentManager, @NotNull String tag, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return show$default(this, fragmentManager, tag, bundle, null, 8, null);
    }

    @JvmOverloads
    @Nullable
    public final DialogFragment show(@Nullable FragmentManager manager, @NotNull String tag, @NotNull Bundle bundle, @Nullable DialogResultListener listener) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Logger.m12713i(TAG, "show - tag : " + tag);
        AbsSTTDialogFragment absSTTDialogFragmentCreateEditDialog = isEditDialog(tag) ? createEditDialog(tag, bundle, listener) : createDialogByTag(tag, bundle, listener);
        if (absSTTDialogFragmentCreateEditDialog != null && !absSTTDialogFragmentCreateEditDialog.isAdded()) {
            DIALOG_STACK.push(tag);
            try {
                showDialogFragment(manager, absSTTDialogFragmentCreateEditDialog, tag);
                return absSTTDialogFragmentCreateEditDialog;
            } catch (IllegalStateException e) {
                Logger.m12711e(TAG, "show IllegalStateException : " + e);
                DIALOG_STACK.pop();
            }
        }
        return absSTTDialogFragmentCreateEditDialog;
    }
}
