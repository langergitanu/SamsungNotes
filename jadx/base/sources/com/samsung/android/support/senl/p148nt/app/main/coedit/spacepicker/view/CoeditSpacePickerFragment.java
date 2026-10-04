package com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.CoeditSpaceAdapter;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.SpacePickerSelectListener;
import com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.presenter.CoeditSpacePresenter;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditPickerInfo;
import com.samsung.android.support.senl.p148nt.app.main.common.coedit.CoeditSessionConnector;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditNameDialogFragment;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import p079T.C0283a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpacePickerFragment extends Fragment implements SpacePickerSelectListener {
    public static final String TAG = "CoeditSpacePickerFragment";
    private CoeditPickerInfo mCoeditCreateInfo;
    private final CoeditSessionConnector.CoeditCreateResult mCoeditCreateResult = new CoeditSessionConnector.CoeditCreateResult() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.view.CoeditSpacePickerFragment.1
        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
        public void onFail() {
            MainCoeditLogger.m7250d(CoeditSpacePickerFragment.TAG, "CoeditCreateResult# onFail#");
            CoeditSpacePickerFragment.this.setProgressVisibility(8);
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.coedit.CoeditSessionConnector.CoeditCreateResult
        public void onSuccess(String str, String str2, boolean z) {
            MainCoeditLogger.m7250d(CoeditSpacePickerFragment.TAG, "CoeditCreateResult# onSuccess#");
            CoeditSpacePickerFragment.this.finishActivityWithResult(str, str2);
        }
    };
    private final IEditDialogResult mEditDialogResultListener = new IEditDialogResult() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.view.CoeditSpacePickerFragment.2
        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogDismiss() {
        }

        @Override // com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IEditDialogResult
        public void onEditDialogResult(int i, String str, String str2, int i2) {
            CoeditSpacePickerFragment.this.mCoeditCreateInfo = new CoeditPickerInfo.CreateSpace(str2).setResultCallback(CoeditSpacePickerFragment.this.mCoeditCreateResult);
            CoeditSpacePickerFragment.this.mSessionConnector.launchSocialPicker(CoeditSpacePickerFragment.this.mCoeditCreateInfo);
            CoeditSpacePickerFragment.this.setProgressVisibility(0);
        }
    };
    private boolean mIsOpenedByList;
    private CoeditSpacePresenter mPresenter;
    private SeslProgressBar mProgressCircle;
    private CoeditSessionConnector mSessionConnector;
    private RecyclerView mSpaceList;

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivityWithResult(String str, String str2) {
        MainCoeditLogger.m7250d(TAG, "finishActivityWithResult# groupId: " + str + ", spaceId: " + str2);
        Intent intent = new Intent();
        intent.putExtra(ComposerConstants.ARG_MDE_GROUP_ID, str);
        intent.putExtra(ComposerConstants.ARG_MDE_SPACE_ID, str2);
        C0283a.m562d().getClass();
        intent.putExtra(ComposerConstants.ARG_MDE_OWNER_ID, C0283a.m561c());
        CoeditPickerInfo coeditPickerInfo = this.mCoeditCreateInfo;
        if (coeditPickerInfo != null && coeditPickerInfo.getInvitationLink() != null) {
            intent.putExtra(ComposerConstants.ARG_MDE_COEDIT_INVITE_URL, this.mCoeditCreateInfo.getInvitationLink().getUrl());
        }
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    private void initLayout(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C8003R.id.coedit_invite_space_list);
        this.mSpaceList = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mSpaceList.seslSetGoToTopEnabled(true);
        ViewCompat viewCompat = ViewCompat.getInstance();
        RecyclerView recyclerView2 = this.mSpaceList;
        viewCompat.setRoundedCorners(recyclerView2, 12, Pair.create(Integer.valueOf(recyclerView2.getPaddingStart()), Integer.valueOf(this.mSpaceList.getPaddingEnd())));
        ViewCompat viewCompat2 = ViewCompat.getInstance();
        RecyclerView recyclerView3 = this.mSpaceList;
        viewCompat2.setRoundedCornerColor(recyclerView3, 12, recyclerView3.getResources().getColor(C8003R.color.window_background_color, null));
    }

    private void initProgressView() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewStub viewStub = (ViewStub) activity.findViewById(C8003R.id.comp_progress_circle);
        if (viewStub != null) {
            this.mProgressCircle = (SeslProgressBar) viewStub.inflate();
        } else {
            this.mProgressCircle = (SeslProgressBar) activity.findViewById(C8003R.id.progress_bar);
        }
        this.mProgressCircle.setBackgroundColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgressVisibility(int i) {
        if (this.mProgressCircle == null) {
            initProgressView();
        }
        MainCoeditLogger.m7253i(TAG, "setProgressVisibility# " + i);
        this.mProgressCircle.setVisibility(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.SpacePickerSelectListener
    public void createNewSpace() {
        SeslProgressBar seslProgressBar = this.mProgressCircle;
        if (seslProgressBar != null && seslProgressBar.getVisibility() == 0) {
            MainCoeditLogger.m7250d(TAG, "createNewSpace blocked by progress circle.");
            return;
        }
        MainCoeditLogger.m7250d(TAG, "createNewSpace");
        CoeditNameDialogFragment coeditNameDialogFragment = new CoeditNameDialogFragment();
        coeditNameDialogFragment.setAnchorViewId(C8003R.id.action_create_notebook);
        coeditNameDialogFragment.setEditDialogResultListener(this.mEditDialogResultListener);
        coeditNameDialogFragment.show(getChildFragmentManager(), GcsConstants.DialogTag.ADD_NOTEBOOK);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE_PICKER, this.mIsOpenedByList ? NotesSAConstants.EVENT_COEDIT_LIST_SPACE_PICKER_CREATE_NEW_SPACE : NotesSAConstants.EVENT_COEDIT_COMPOSER_SPACE_PICKER_CREATE_NEW_SPACE);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.coedit_space_picker_fragment, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoeditSpacePresenter coeditSpacePresenter = this.mPresenter;
        if (coeditSpacePresenter != null) {
            coeditSpacePresenter.removeObserver();
        }
        this.mProgressCircle = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(NotesConstants.KEY_OPENED_BY_LIST, this.mIsOpenedByList);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.coedit.spacepicker.adapter.SpacePickerSelectListener
    public void onSpaceSelected(String str, String str2) {
        SeslProgressBar seslProgressBar = this.mProgressCircle;
        if (seslProgressBar != null && seslProgressBar.getVisibility() == 0) {
            MainCoeditLogger.m7250d(TAG, "onSpaceSelected blocked by progress circle.");
            return;
        }
        MainCoeditLogger.m7250d(TAG, "onSpaceSelected");
        finishActivityWithResult(str, str2);
        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_SPACE_PICKER, this.mIsOpenedByList ? NotesSAConstants.EVENT_COEDIT_LIST_SPACE_PICKER_PICK_SPACE : NotesSAConstants.EVENT_COEDIT_COMPOSER_SPACE_PICKER_PICK_SPACE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.mIsOpenedByList = bundle.getBoolean(NotesConstants.KEY_OPENED_BY_LIST, false);
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mIsOpenedByList = arguments.getBoolean(NotesConstants.KEY_OPENED_BY_LIST, false);
            }
        }
        initLayout(view);
        this.mPresenter = new CoeditSpacePresenter(this, this, new CoeditSpacePresenter.ViewContract.IRecyclerView() { // from class: com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.view.CoeditSpacePickerFragment.3
            @Override // com.samsung.android.support.senl.nt.app.main.coedit.spacepicker.presenter.CoeditSpacePresenter.ViewContract.IRecyclerView
            public void setAdapter(CoeditSpaceAdapter coeditSpaceAdapter) {
                CoeditSpacePickerFragment.this.mSpaceList.setAdapter(coeditSpaceAdapter);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        CoeditNameDialogFragment coeditNameDialogFragment = (CoeditNameDialogFragment) getChildFragmentManager().findFragmentByTag(GcsConstants.DialogTag.ADD_NOTEBOOK);
        if (coeditNameDialogFragment != null) {
            coeditNameDialogFragment.setEditDialogResultListener(this.mEditDialogResultListener);
        }
    }

    public void setCoeditSessionConnector(CoeditSessionConnector coeditSessionConnector) {
        this.mSessionConnector = coeditSessionConnector;
    }
}
