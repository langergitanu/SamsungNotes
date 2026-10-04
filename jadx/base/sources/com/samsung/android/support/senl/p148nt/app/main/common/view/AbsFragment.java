package com.samsung.android.support.senl.p148nt.app.main.common.view;

import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostResumeManager;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostStartManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class AbsFragment extends Fragment {
    private PostLaunchManager.Token mPostLaunchToken = null;
    private PostResumeManager.Token mPostResumeToken = null;
    private PostStartManager.Token mPostStartToken = null;

    public void filteredInvalidateOptionsMenu() {
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

    public boolean isRunningAnimator() {
        return false;
    }

    public void onFolderDeleteVerifySuccess() {
    }

    public void setPostToken(PostLaunchManager.Token token, PostResumeManager.Token token2, PostStartManager.Token token3) {
        this.mPostLaunchToken = token;
        this.mPostResumeToken = token2;
        this.mPostStartToken = token3;
    }
}
