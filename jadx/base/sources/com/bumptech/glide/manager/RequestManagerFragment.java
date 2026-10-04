package com.bumptech.glide.manager;

import android.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {
    @Nullable
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @NonNull
    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new RequestManagerTreeNode() { // from class: com.bumptech.glide.manager.RequestManagerFragment.1
            @Override // com.bumptech.glide.manager.RequestManagerTreeNode
            @NonNull
            public Set<RequestManager> getDescendants() {
                return Collections.EMPTY_SET;
            }
        };
    }

    @Deprecated
    public void setRequestManager(@Nullable RequestManager requestManager) {
    }
}
