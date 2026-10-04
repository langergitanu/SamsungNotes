package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.presenter;

import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.document.save.CoverThumbnailCreator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH&J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0011\u001a\u00020\u0003H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/presenter/HolderListener;", "", "getViewMode", "", "setThumbnailScale", "", "imageContentView", "Landroid/widget/ImageView;", "filePath", "", "setThumbnailBackgroundColor", "isLocked", "", "isVoice", DBSchema.DocumentThumbnail.PLAY_TIME, "isUnlockConverting", "uuid", "getModeIndex", "getCoverThumbnailType", "Lcom/samsung/android/support/senl/nt/model/document/save/CoverThumbnailCreator$ThumbnailType;", "registerNoteAnimation", "runnable", "Ljava/lang/Runnable;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface HolderListener {
    @Nullable
    CoverThumbnailCreator.ThumbnailType getCoverThumbnailType();

    int getModeIndex();

    int getViewMode();

    boolean isUnlockConverting(@Nullable String uuid);

    void registerNoteAnimation(@NotNull Runnable runnable);

    void setThumbnailBackgroundColor(boolean isLocked, boolean isVoice, @NotNull String playTime);

    void setThumbnailScale(@NotNull ImageView imageContentView, @Nullable String filePath);
}
