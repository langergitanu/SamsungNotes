package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.RequestManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class SupportRequestManagerFragment extends Fragment {
    @Nullable
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @NonNull
    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new EmptyRequestManagerTreeNode();
    }

    @Deprecated
    public void setRequestManager(@Nullable RequestManager requestManager) {
    }
}
