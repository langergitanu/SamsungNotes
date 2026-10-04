package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.app.LoaderManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.InterfaceC6699m;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.sdk.mobileservice.social.social.SocialPickerRequest;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.GcsInvitationMenuBadgeUpdater;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.PenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.view.AbsFragment;
import com.samsung.android.support.senl.p148nt.app.main.invitation.GcsInvitationActivity;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupAdpaterManager;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupNetworkUtils;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.presenter.GcsGroupPresenter;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupHolder;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import p079T.AbstractC0294l;
import p207n1.C13541h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupFragment extends AbsFragment implements GcsGroupPresenter.IPresenterContract {
    private static final String ACCOUNT = "account";
    private static final String GROUP = "group";
    private static final String GUID = "guid";
    private static final String NUMBER = "number";
    public static final String TAG = "GcsGroupFragment";
    private FragmentContract mContract;
    private GcsGroupAdpaterManager mGcsGroupAdpaterManager;
    private GcsGroupPresenter mGcsGroupPresenter;
    private Menu mMenu;
    private final GcsGroupHolder.GcsGroupHolderContract mHolderContract = new GcsGroupHolder.GcsGroupHolderContract() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupFragment.1
        @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupHolder.GcsGroupHolderContract
        public boolean onItemLongPressed(GcsGroupHolder gcsGroupHolder) {
            MainLogger.m7258i(GcsGroupFragment.TAG, "GcsGroupHolder# onItemLongPressed");
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.Default;
            if (!UserInputSkipper.isValidEvent(tag)) {
                return false;
            }
            UserInputSkipper.setHoldingEventTime(300L, tag);
            if (!gcsGroupHolder.isOwnedByMe() && !SesGroupReadResolver.getInstance().isLocalGroupType(gcsGroupHolder.getGroupID())) {
                ToastHandler.show(GcsGroupFragment.this.getContext(), C8003R.string.gcs_group_edit_menu_block_toast_message, 1);
                return true;
            }
            GcsGroupFragment.this.mGcsGroupPresenter.setSelectedInfo(gcsGroupHolder.getSpaceId(), gcsGroupHolder.getTitle());
            GcsGroupFragment.this.mGcsGroupPresenter.showGroupEditMenuDialog(gcsGroupHolder.isOwnedByMe());
            if (!DesktopModeCompat.INSTANCE.getInstance().isDexMode(GcsGroupFragment.this.getContext())) {
                gcsGroupHolder.initLongClick();
            }
            return true;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupHolder.GcsGroupHolderContract
        public void onItemSelected(GcsGroupHolder gcsGroupHolder) {
            if (gcsGroupHolder == null) {
                return;
            }
            UserInputSkipper.Tag tag = UserInputSkipper.Tag.Drawer;
            if (UserInputSkipper.isValidEvent(tag)) {
                UserInputSkipper.setHoldingEventTime(1000L, tag);
                GcsGroupFragment.this.mContract.onSpaceSelected(gcsGroupHolder);
            }
        }

        @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupHolder.GcsGroupHolderContract
        public void setNoNoteInVisible(boolean z) {
            View viewFindViewById = GcsGroupFragment.this.getActivity().findViewById(C8003R.id.nonote);
            if (viewFindViewById == null) {
                return;
            }
            AbstractC6670b.m4739D("setNoNoteInVisible : ", GcsGroupFragment.TAG, z);
            if (z) {
                viewFindViewById.setVisibility(8);
                return;
            }
            if (GcsGroupFragment.this.mContract != null) {
                GcsGroupFragment.this.mContract.setNoNoteLayoutVisible(viewFindViewById);
            }
            viewFindViewById.setVisibility(0);
        }
    };
    private final InterfaceC6699m mShareContentObserver = new InterfaceC6699m() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupFragment.2
        @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.InterfaceC6699m
        public void onChange(boolean z) {
            AbstractC6670b.m4739D("SesShareReadResolver. onChange() : ", GcsGroupFragment.TAG, z);
            GcsGroupFragment.this.restartLoader();
        }
    };
    private final SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupFragment.3
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            MainLogger.m7258i(GcsGroupFragment.TAG, "onSharedPreferenceChanged() key : " + str);
            if (!GcsConstants.KEY_GCS_INVITATION_LIST_HAS_BADGE.equals(str) || GcsGroupFragment.this.mMenu == null) {
                return;
            }
            GcsInvitationMenuBadgeUpdater.updateBadge(GcsGroupFragment.this.getContext(), GcsGroupFragment.this.mMenu.findItem(C8003R.id.action_invitation_list), sharedPreferences.getBoolean(str, false));
        }
    };

    private void initLayout(@NonNull View view) throws Exception {
        MainLogger.m7254d(TAG, "initLayout");
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) getActivity().findViewById(C8003R.id.collapsing_toolbar);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setTitle(getString(C8003R.string.shared_notebooks));
            collapsingToolbarLayout.seslSetSubtitle((CharSequence) null);
        }
        ((Toolbar) getActivity().findViewById(C8003R.id.toolbar)).setTitle(C8003R.string.shared_notebooks);
        PenRecyclerView penRecyclerView = (PenRecyclerView) view.findViewById(C8003R.id.shared_notebook_recyclerview);
        this.mGcsGroupAdpaterManager = new GcsGroupAdpaterManager(penRecyclerView, this.mHolderContract);
        ((FloatingToolbarLayout) getActivity().findViewById(C8003R.id.sesl_floating_toolbar_layout)).setRecyclerView(penRecyclerView);
        getActivity().invalidateOptionsMenu();
    }

    private void registerSesDbObserver() {
        MainLogger.m7258i(TAG, "registerSesDbObserver()");
        SesShareReadResolver.getInstance().addContentObserver(this.mShareContentObserver);
    }

    private void releaseBlockView() {
        View viewFindViewById;
        if (getActivity() == null || (viewFindViewById = getActivity().findViewById(C8003R.id.main_view_block)) == null) {
            return;
        }
        MainLogger.m7258i(TAG, "blockView - gone");
        viewFindViewById.setVisibility(8);
    }

    private void unRegisterSesDbObserver() {
        MainLogger.m7258i(TAG, "unRegisterSesDbObserver()");
        SesShareReadResolver.getInstance().removeContentObserver(this.mShareContentObserver);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.IPresenterContract
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return getActivity();
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.IPresenterContract
    public void launchSocialPicker(String str) {
        MainLogger.m7254d(TAG, "launchSocialPicker()");
        if (getActivity() == null || !isAdded()) {
            MainLogger.m7254d(TAG, "launchSocialPicker not isAdded");
            return;
        }
        if (CoeditUtils.isWiFiSyncOnlyAndNotWiFiConnected()) {
            GcsGroupNetworkUtils.showGoToSettingsDialog(new WeakReference(getActivity()));
            return;
        }
        this.mGcsGroupPresenter.setSelectedInfo(str);
        ExecutorService executorService = AbstractC0294l.f760a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(104);
        startActivityForResult(new OpenSessionApi().getIntentForSocialPicker(BaseUtils.getApplicationContext(), new SocialPickerRequest.Builder(CommonUtils.getOldNotesServiceId(), arrayList).setExceptionGuidList(Collections.singletonList(C13541h.m14287e().m14293g())).setEnableSharingAccount(true).setMaxRecipientCount(100).build()).setPackage("com.samsung.android.mobileservice"), 104);
    }

    public void notifyDataSetChanged() {
        this.mGcsGroupAdpaterManager.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        HashMap mapM577d;
        super.onActivityResult(i, i2, intent);
        MainLogger.m7254d(TAG, "onActivityResult# requestCode : " + i + ", resultCode : " + i2);
        int i4 = 1;
        if (i == 10) {
            if (i2 == 1) {
                this.mContract.finish("REQUEST_INTENT_INVITATION_LIST error");
                return;
            }
            return;
        }
        if (i == 104 && i2 == -1 && intent != null && intent.hasExtra("jsonResult") && (mapM577d = AbstractC0294l.m577d(intent.getStringExtra("jsonResult"))) != null) {
            String str = (String) mapM577d.get("type");
            if ("guid".equals(str)) {
                i4 = 0;
            } else if (!"number".equals(str)) {
                if (!"account".equals(str)) {
                    if ("group".equals(str)) {
                        this.mGcsGroupPresenter.createSharedNotebooks((String) mapM577d.get("groupId"));
                        return;
                    } else {
                        AbstractC8014b.m7209k("onActivityResult# REQUEST_CODE_LAUNCH_SOCIAL_PICKER - Unknown type : ", str, TAG);
                        return;
                    }
                }
                i4 = 3;
            }
            this.mGcsGroupPresenter.requestGroupCreation(i4, (ArrayList) mapM577d.get(DialogConstant.BUNDLE_IDS), (ArrayList) mapM577d.get("optIds"));
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mGcsGroupAdpaterManager.onConfigurationChanged(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        releaseBlockView();
        registerSesDbObserver();
        SharedPreferencesCompat.getInstance(GcsConstants.GCS_PREFS_NAME).registerOnSharedPreferenceChangeListener(this.sharedPreferenceChangeListener);
        GcsGroupPresenter gcsGroupPresenter = new GcsGroupPresenter(this);
        this.mGcsGroupPresenter = gcsGroupPresenter;
        gcsGroupPresenter.onloadInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        MainLogger.m7254d(TAG, "onCreateOptionsMenu");
        if (getActivity() == null || !isAdded()) {
            return;
        }
        menuInflater.inflate(C8003R.menu.gcs_grouplist_select, menu);
        menu.removeItem(C8003R.id.action_coedit_list);
        this.mMenu = menu;
        Drawable icon = menu.findItem(C8003R.id.action_add_shared_notebook).getIcon();
        if (icon != null) {
            icon.mutate();
            icon.setColorFilter(getActivity().getResources().getColor(C8003R.color.notes_toolbar_action_menu_color, null), PorterDuff.Mode.SRC_ATOP);
        }
        final MenuItem menuItemFindItem = menu.findItem(C8003R.id.action_invitation_list);
        if (menuItemFindItem == null || menuItemFindItem.getActionView() == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) menuItemFindItem.getActionView().findViewById(C8003R.id.action_invitation_list_menu_layout);
        if (frameLayout != null) {
            ViewCompat.getInstance().setTooltipText(frameLayout, frameLayout.getContext().getString(C8003R.string.gcs_invitations));
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.view.GcsGroupFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_INVITATIONS);
                    GcsGroupFragment.this.onOptionsItemSelected(menuItemFindItem);
                }
            });
        }
        GcsInvitationMenuBadgeUpdater.updateBadge(getContext(), menuItemFindItem);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(C8003R.layout.gcs_group_list_fragment_for_mode, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unRegisterSesDbObserver();
        SharedPreferencesCompat.getInstance(GcsConstants.GCS_PREFS_NAME).unregisterOnSharedPreferenceChangeListener(this.sharedPreferenceChangeListener);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.SharedNoteBooks;
        if (!UserInputSkipper.isValidEvent(tag)) {
            return false;
        }
        UserInputSkipper.setHoldingEventTime(1000L, tag);
        MainLogger.m7258i(TAG, "onOptionsItemSelected# " + ((Object) menuItem.getTitle()));
        int itemId = menuItem.getItemId();
        if (itemId == C8003R.id.action_add_shared_notebook) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_CREATE_SHARED_NOTEBOOKS);
            this.mGcsGroupPresenter.addSharedNotebooks();
        } else if (itemId == C8003R.id.action_invitation_list) {
            CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_INVITATIONS);
            startActivityForResult(new Intent(getContext(), (Class<?>) GcsInvitationActivity.class), 10);
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mGcsGroupAdpaterManager.onResume(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mGcsGroupPresenter.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) throws Exception {
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        initLayout(view);
        this.mGcsGroupAdpaterManager.setLoader(LoaderManager.getInstance(this));
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.IPresenterContract
    public void restartLoader() {
        if (isDetached()) {
            MainLogger.m7255e(TAG, "restartLoader# Can't access ViewModels from detached fragment");
            return;
        }
        try {
            this.mGcsGroupAdpaterManager.restartLoader(LoaderManager.getInstance(this));
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "restartLoader# Can't access ViewModels from detached fragment on restartLoader " + e.getMessage());
        }
    }

    public void setContract(FragmentContract fragmentContract) {
        this.mContract = fragmentContract;
    }

    @Override // com.samsung.android.support.senl.nt.app.main.sharednotebook.presenter.GcsGroupPresenter.IPresenterContract
    public void showGoToSettingsDialog() {
        GcsGroupNetworkUtils.showGoToSettingsDialog(new WeakReference(getActivity()));
    }
}
