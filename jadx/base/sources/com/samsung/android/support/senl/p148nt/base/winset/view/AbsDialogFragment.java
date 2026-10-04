package com.samsung.android.support.senl.p148nt.base.winset.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.RunnableC8669a;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\rH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\u001a\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0016J\b\u0010+\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\t8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/view/AbsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "mAnchorViewId", "", "mParentDialog", "Landroidx/appcompat/app/AlertDialog;", "mAnchorView", "Landroid/view/View;", "mOnLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "setAnchorViewId", "", AbsDialogFragment.KEY_ANCHOR_VIEW_ID, "parentDialog", "setAnchor", "getAnchor", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onStart", "setAnchorWithActivityDecorView", Constants.IntentExtraValue.SHOW, "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "dismiss", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "addLayoutChangeListener", "removeLayoutChangeListener", "onDestroy", "value", "anchorView", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "getLogTag", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsDialogFragment extends DialogFragment {

    @NotNull
    public static final String KEY_ANCHOR_VIEW_ID = "anchorViewId";

    @Nullable
    private View mAnchorView;
    private int mAnchorViewId;

    @Nullable
    private View.OnLayoutChangeListener mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.base.winset.view.AbsDialogFragment$mOnLayoutChangeListener$1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            Logger.m8697d(this.this$0.getLogTag(), "onLayoutChange# call setAnchor ");
            view.removeOnLayoutChangeListener(this);
            this.this$0.setAnchor();
        }
    };

    @Nullable
    private AlertDialog mParentDialog;

    private static final Unit addLayoutChangeListener$lambda$8(AbsDialogFragment absDialogFragment) {
        Logger.m8698e(absDialogFragment.getLogTag(), "addOnLayoutChangeListener# anchorView is null");
        return Unit.INSTANCE;
    }

    private final View getAnchor() {
        FragmentActivity activity;
        AbstractC4539a.m3203m(this.mAnchorViewId, "getAnchor ", getLogTag());
        if (this.mAnchorViewId > 0 && (activity = getActivity()) != null) {
            AlertDialog alertDialog = this.mParentDialog;
            if (alertDialog != null) {
                Intrinsics.checkNotNull(alertDialog);
                return alertDialog.findViewById(this.mAnchorViewId);
            }
            if (CommonUtils.isAvailableActivity(activity)) {
                FragmentActivity activity2 = getActivity();
                Intrinsics.checkNotNull(activity2);
                return activity2.findViewById(this.mAnchorViewId);
            }
        }
        return null;
    }

    private static final Unit getAnchor$lambda$3(AbsDialogFragment absDialogFragment) {
        Logger.m8698e(absDialogFragment.getLogTag(), "getAnchor# anchorView is null");
        return Unit.INSTANCE;
    }

    private final View getAnchorView() {
        if (this.mAnchorView == null) {
            this.mAnchorView = getAnchor();
        }
        return this.mAnchorView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTag() {
        String tag = getTag();
        if (TextUtils.isEmpty(tag)) {
            tag = getClass().getName();
        }
        Intrinsics.checkNotNull(tag);
        return tag;
    }

    private static final Unit removeLayoutChangeListener$lambda$9(AbsDialogFragment absDialogFragment) {
        Logger.m8698e(absDialogFragment.getLogTag(), "removeLayoutChangeListener# anchorView is null");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnchor() {
        View anchorView = getAnchorView();
        if (anchorView != null) {
            Logger.m8702i(getLogTag(), "setAnchor# ");
            AlertDialogWrapper.setAnchorView(getDialog(), anchorView);
            AlertDialogWrapper.anchorLayoutStyle(getDialog());
        }
    }

    private static final Unit setAnchor$lambda$1(AbsDialogFragment absDialogFragment) {
        Logger.m8698e(absDialogFragment.getLogTag(), "setAnchor# anchorView is null");
        return Unit.INSTANCE;
    }

    private final void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    private final void setAnchorWithActivityDecorView() {
        FragmentActivity activity;
        if (getAnchorView() == null || (activity = getActivity()) == null || CommonUtils.isNotAvailableActivity(activity)) {
            return;
        }
        activity.getWindow().getDecorView().post(new RunnableC8669a(this, 21));
    }

    private static final Unit setAnchorWithActivityDecorView$lambda$7(AbsDialogFragment absDialogFragment) {
        Logger.m8698e(absDialogFragment.getLogTag(), "setAnchorWithActivityDecorView, anchorView is null");
        return Unit.INSTANCE;
    }

    public void addLayoutChangeListener() {
        Logger.m8697d(getLogTag(), "addLayoutChangeListener# ");
        View anchorView = getAnchorView();
        if (anchorView != null) {
            anchorView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            if (isAdded()) {
                super.dismiss();
            }
        } catch (IllegalStateException e) {
            Logger.m8699e(getLogTag(), "dismiss : ", e);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        addLayoutChangeListener();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.mAnchorViewId = savedInstanceState.getInt(KEY_ANCHOR_VIEW_ID);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        removeLayoutChangeListener();
        this.mParentDialog = null;
        setAnchorView(null);
        this.mOnLayoutChangeListener = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_ANCHOR_VIEW_ID, this.mAnchorViewId);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Logger.m8697d(getLogTag(), "onStart#");
        setAnchor();
        setAnchorWithActivityDecorView();
    }

    public void removeLayoutChangeListener() {
        Logger.m8697d(getLogTag(), "removeLayoutChangeListener# ");
        View anchorView = getAnchorView();
        if (anchorView != null) {
            anchorView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    public final void setAnchorViewId(int anchorViewId) {
        this.mAnchorViewId = anchorViewId;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e) {
            Logger.m8699e(getLogTag(), "show : ", e);
        }
    }

    public final void setAnchorViewId(@Nullable AlertDialog parentDialog, int anchorViewId) {
        this.mParentDialog = parentDialog;
        this.mAnchorViewId = anchorViewId;
    }
}
