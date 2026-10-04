package com.samsung.android.support.senl.p148nt.app.main.invitation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationListResult;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.invitation.adapter.AdapterContract;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsInvitationAdapter extends RecyclerView.Adapter<GcsInvitationHolder> {
    private static final String TAG = "GcsInvitationAdapter";
    private final Context mContext;
    private List<GroupInvitationListResult.GroupInvitation> mInvitationList;
    private final AdapterContract.IPresenter mPresenter;

    public GcsInvitationAdapter(Context context, AdapterContract.IPresenter iPresenter) {
        this.mContext = context;
        this.mPresenter = iPresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<GroupInvitationListResult.GroupInvitation> list = this.mInvitationList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void removeInvitationItemByPosition(int i) {
        List<GroupInvitationListResult.GroupInvitation> list = this.mInvitationList;
        if (list == null || i >= list.size()) {
            return;
        }
        this.mInvitationList.remove(i);
    }

    public void setInvitationList(List<GroupInvitationListResult.GroupInvitation> list) {
        this.mInvitationList = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull final GcsInvitationHolder gcsInvitationHolder, int i) {
        gcsInvitationHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.adapter.GcsInvitationAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GcsInvitationAdapter.this.mInvitationList == null) {
                    return;
                }
                int layoutPosition = gcsInvitationHolder.getLayoutPosition();
                AbstractC8014b.m7201c(layoutPosition, "onClick(). ", GcsInvitationAdapter.TAG);
                if (layoutPosition < 0 || layoutPosition >= GcsInvitationAdapter.this.mInvitationList.size()) {
                    return;
                }
                GcsInvitationAdapter.this.mPresenter.onItemSelected(layoutPosition, (GroupInvitationListResult.GroupInvitation) GcsInvitationAdapter.this.mInvitationList.get(layoutPosition));
            }
        });
        gcsInvitationHolder.decorate(this.mInvitationList.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public GcsInvitationHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GcsInvitationHolder(this.mContext, LayoutInflater.from(this.mContext).inflate(C8003R.layout.gcs_invitation_list_item, viewGroup, false));
    }
}
