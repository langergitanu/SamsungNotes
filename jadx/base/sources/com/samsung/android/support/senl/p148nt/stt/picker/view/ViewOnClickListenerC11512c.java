package com.samsung.android.support.senl.p148nt.stt.picker.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.stt.picker.model.RecordingItem;
import com.samsung.android.support.senl.p148nt.stt.picker.view.LabelHistorySearchAdapter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.picker.view.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class ViewOnClickListenerC11512c implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7872a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RecyclerView.Adapter f7873b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7874c;

    public /* synthetic */ ViewOnClickListenerC11512c(RecyclerView.Adapter adapter, Object obj, int i) {
        this.f7872a = i;
        this.f7873b = adapter;
        this.f7874c = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7872a) {
            case 0:
                LabelHistorySearchAdapter.LabelHistoryViewHolder._init_$lambda$0((LabelHistorySearchAdapter) this.f7873b, (LabelHistorySearchAdapter.LabelHistoryViewHolder) this.f7874c, view);
                break;
            case 1:
                LabelHistorySearchAdapter.LabelHistoryViewHolder._init_$lambda$1((LabelHistorySearchAdapter) this.f7873b, (LabelHistorySearchAdapter.LabelHistoryViewHolder) this.f7874c, view);
                break;
            default:
                AudioPickerListViewAdapter.onBindViewHolder$lambda$2((AudioPickerListViewAdapter) this.f7873b, (RecordingItem) this.f7874c, view);
                break;
        }
    }
}
