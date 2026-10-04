package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostResumeManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostStartManager;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.NotesActivityResultCallback;
import com.samsung.android.support.senl.p148nt.app.common.listener.OnCustomKeyListener;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.base.common.ActivityLifecycleTracker;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.MainListStartManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AbsAppCompatActivity extends AppCompatActivity implements ActivityLifecycleTracker.NoteEditable {
    private final String TAG = "AbsAppCompatActivity";
    private final PostLaunchManager.Token mPostLaunchToken = PostLaunchManager.getInstance().createToken();
    private final PostResumeManager.Token mPostResumeToken = PostResumeManager.getInstance().createToken();
    private final PostStartManager.Token mPostStartToken = PostStartManager.getInstance().createToken();
    final Stack<NotesActivityResultCallback> mCallbackList = new Stack<>();
    private final ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.samsung.android.support.senl.nt.app.main.common.view.AbsAppCompatActivity.1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            if (AbsAppCompatActivity.this.mCallbackList.empty()) {
                MainLogger.m7258i("AbsAppCompatActivity", "onActivityResult# resultCode: " + activityResult.getResultCode());
            } else {
                StringBuilder sb = new StringBuilder("onActivityResult# resultCode: ");
                sb.append(activityResult.getResultCode());
                sb.append(" remains : ");
                sb.append(AbsAppCompatActivity.this.mCallbackList.size() - 1);
                MainLogger.m7258i("AbsAppCompatActivity", sb.toString());
                AbsAppCompatActivity.this.mCallbackList.pop().onActivityResult(activityResult.getResultCode(), activityResult.getData());
            }
        }
    });

    public void changedGcsEnableStatus() {
    }

    public boolean closeDrawer(boolean z, int i) {
        return false;
    }

    public void dragAndDropFinished(String str) {
    }

    public View getDrawerView() {
        return null;
    }

    public View getNoteParentView() {
        return null;
    }

    public PostLaunchManager.Token getPostLaunchToken() {
        return this.mPostLaunchToken;
    }

    public PostResumeManager.Token getPostResumeToken() {
        return this.mPostResumeToken;
    }

    public PostStartManager.Token getPostStartToken() {
        return this.mPostStartToken;
    }

    public void initFolderDataMap() {
    }

    public boolean isRunningAnimator() {
        return false;
    }

    public boolean isScrolling() {
        return false;
    }

    public void launchActivity(Intent intent, @NonNull NotesActivityResultCallback notesActivityResultCallback) {
        this.mCallbackList.push(notesActivityResultCallback);
        try {
            this.mActivityResultLauncher.launch(intent);
        } catch (ActivityNotFoundException e) {
            MainLogger.m7255e("AbsAppCompatActivity", "launchActivity, ActivityNotFoundException# " + e.getMessage());
            this.mCallbackList.pop();
        } catch (IllegalStateException e2) {
            MainLogger.m7255e("AbsAppCompatActivity", "launchActivity, IllegalStateException# " + e2.getMessage());
            this.mCallbackList.pop();
        }
    }

    public void launchPopOverActivity(Intent intent, int i, @NonNull NotesActivityResultCallback notesActivityResultCallback) {
        this.mCallbackList.push(notesActivityResultCallback);
        try {
            PopOverActivityWrapper.startActivityForResult(this, intent, 13, i);
        } catch (ActivityNotFoundException e) {
            MainLogger.m7255e("AbsAppCompatActivity", "launchActivity# " + e.getMessage());
            this.mCallbackList.pop();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 13 || this.mCallbackList.empty()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i2, "onActivityResult# resultCode: ", " remains : ");
            sbM778t.append(this.mCallbackList.size());
            MainLogger.m7258i("AbsAppCompatActivity", sbM778t.toString());
        } else {
            StringBuilder sbM778t2 = AbstractC0541b.m778t(i2, "onActivityResult# REQUEST_LAUNCH_POPOVER resultCode: ", " remains : ");
            sbM778t2.append(this.mCallbackList.size() - 1);
            MainLogger.m7258i("AbsAppCompatActivity", sbM778t2.toString());
            this.mCallbackList.pop().onActivityResult(i2, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (MainListStartManager.INSTANCE.getInstance().canNotUseNoteList()) {
            ToastHandler.show(getApplicationContext(), C8003R.string.updating_note_try_again_later, 1);
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mActivityResultLauncher.unregister();
        this.mCallbackList.clear();
    }

    public void onExecuteItemSelected(int i) {
    }

    public void onFolderDeleteVerifySuccess() {
    }

    public void onFolderSelected(String str) {
    }

    public void onFoldersDataMove(ArrayList<String> arrayList, String str) {
    }

    public void onImportPdf(String str, int i, List<Uri> list) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onKeyDown(int i, KeyEvent keyEvent, String str) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag != 0 && fragmentFindFragmentByTag.isAdded()) {
            try {
                if (((OnCustomKeyListener) fragmentFindFragmentByTag).onCustomKeyEvent(i, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                AbstractC14516b.m15115c(e, new StringBuilder("onBackPressed, e : "), "AbsAppCompatActivity");
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onKeyUp(int i, KeyEvent keyEvent, String str) {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag != 0 && fragmentFindFragmentByTag.isAdded()) {
            try {
                if (((OnCustomKeyListener) fragmentFindFragmentByTag).onCustomKeyEvent(i, keyEvent)) {
                    return true;
                }
            } catch (Exception e) {
                AbstractC14516b.m15115c(e, new StringBuilder("onBackPressed, e : "), "AbsAppCompatActivity");
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onModeChanged(int i) {
    }

    public void onNewCoeditNote(String str, String str2, String str3, int i) {
    }

    public void onNewNote(String str, int i) {
    }

    public void onNewNoteStyleNote(Intent intent) {
    }

    public void onNoteSelected(MainEntryParam mainEntryParam) {
    }

    public void onNotesDataMove(String str) {
    }

    public void openDrawer(int i) {
    }

    public void resultVerifyLockNote(Intent intent) {
    }

    public void setDrawerIconDimDragStatus(boolean z, ArrayList<String> arrayList) {
    }

    public void setDrawerTitleBold(String str) {
    }

    public void updateDocumentCountMap(Map<String, NotesDocumentCountEntry> map) {
    }

    public void updateDrawerIconWithBadge() {
    }

    public void updateNoteViewByDrawerObserver(boolean z) {
    }

    public void verifyForDelete() {
    }
}
