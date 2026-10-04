package com.samsung.android.support.senl.p148nt.app.main.common.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FolderCommonHolder extends RecyclerView.ViewHolder {
    public FolderCommonHolder(@NonNull View view) {
        super(view);
    }

    public void decorateRoundedCorner(int i, int i2) {
        RoundCornerOverlayView roundCornerOverlayView;
        if (i != 16 || (roundCornerOverlayView = (RoundCornerOverlayView) this.itemView.findViewById(C8003R.id.folder_list_round_corner)) == null) {
            return;
        }
        roundCornerOverlayView.setVisibility(i2 == 0 ? 8 : 0);
        roundCornerOverlayView.setRoundedCorner(i2);
    }
}
