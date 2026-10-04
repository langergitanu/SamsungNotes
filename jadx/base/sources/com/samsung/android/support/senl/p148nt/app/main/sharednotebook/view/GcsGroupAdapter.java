package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.view.GcsGroupHolder;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsGroupAdapter extends RecyclerView.Adapter<GcsGroupHolder> {
    public static final String TAG = "GcsGroupAdapter";
    private Cursor mCursor;
    private final GcsGroupHolder.GcsGroupHolderContract mHolderContract;

    public GcsGroupAdapter(GcsGroupHolder.GcsGroupHolderContract gcsGroupHolderContract) {
        this.mHolderContract = gcsGroupHolderContract;
    }

    private Cursor swapCursor(Cursor cursor) {
        MainLogger.m7258i(TAG, "swapCursor ");
        Cursor cursor2 = this.mCursor;
        this.mCursor = cursor;
        notifyDataSetChanged();
        return cursor2;
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursorSwapCursor;
        if (Objects.equals(cursor, this.mCursor) || (cursorSwapCursor = swapCursor(cursor)) == null) {
            return;
        }
        cursorSwapCursor.close();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.mCursor != null) {
            return -1L;
        }
        throw new IllegalStateException("Cursor is null");
    }

    public void setNoNoteInVisible(boolean z) {
        this.mHolderContract.setNoNoteInVisible(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i, @NonNull List list) throws Throwable {
        onBindViewHolder((GcsGroupHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public GcsGroupHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GcsGroupHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C8003R.layout.gcs_group_list_item, viewGroup, false), this.mHolderContract);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull GcsGroupHolder gcsGroupHolder, int i) {
        if (this.mCursor != null) {
            return;
        }
        MainLogger.m7255e(TAG, "GcsGroupAdapter#onBindViewHolder Cursor is null");
        throw new IllegalStateException("Cursor is null");
    }

    public void onBindViewHolder(@NonNull GcsGroupHolder gcsGroupHolder, int i, @NonNull List<Object> list) throws Throwable {
        super.onBindViewHolder(gcsGroupHolder, i, list);
        if (this.mCursor.isClosed()) {
            MainLogger.m7255e(TAG, "GcsGroupAdapter#onBindViewHolder Cursor is closed.");
            return;
        }
        try {
            this.mCursor.moveToPosition(i);
            gcsGroupHolder.decorate(this.mCursor);
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "GcsGroupAdapter#onBindViewHolder IllegalStateException : " + e);
        }
    }
}
