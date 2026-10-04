package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface IAdapter {
    void addSubFolderBitmap(int i, int i2, @NotNull Drawable drawable);

    Drawable getSubFolderBitmap(int i, int i2);

    void notifyDataSetChanged();

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);

    void notifyItemInserted(int i);

    void notifyItemRangeChanged(int i, int i2, @Nullable Object obj);

    void release();

    void submitList(@Nullable List<Common> list);
}
