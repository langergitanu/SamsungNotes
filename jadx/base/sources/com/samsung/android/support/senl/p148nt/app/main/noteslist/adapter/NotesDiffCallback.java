package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesDiffCallback extends DiffUtil.ItemCallback<Common> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    @SuppressLint({"DiffUtilEquals"})
    public boolean areContentsTheSame(@NonNull Common common, @NonNull Common common2) {
        return common.equals(common2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(@NonNull Common common, @NonNull Common common2) {
        return common.type == common2.type;
    }
}
