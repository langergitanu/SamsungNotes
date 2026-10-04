package com.samsung.android.support.senl.p148nt.app.common.util;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NoteListToDrag {
    public static final String NOTES_LIST_DRAG_LABEL = "notes_list_drag";
    private static final String TAG = "NoteListToDrag";
    private static Uri mFakedUriForNoteListToDrag;
    private static String mUuidForNoteListToDrag;

    public static void clearNoteListTodDrag(Context context) {
        mUuidForNoteListToDrag = null;
        mFakedUriForNoteListToDrag = null;
        String noteListToDragPath = getNoteListToDragPath(context);
        if (TextUtils.isEmpty(noteListToDragPath)) {
            return;
        }
        File file = new File(noteListToDragPath);
        if (!file.exists() || file.delete()) {
            return;
        }
        MainLogger.m7255e(TAG, "clearNoteListTodDrag# file is not successfully deleted");
    }

    @NonNull
    public static ClipData getClipData(Context context, String str) {
        return new ClipData(NOTES_LIST_DRAG_LABEL, new String[]{Constants.MIME_SDOC}, new ClipData.Item(getUriForNoteListToDrag(context, str)));
    }

    public static Uri getFakedUriForNoteListToDrag() {
        return mFakedUriForNoteListToDrag;
    }

    @Nullable
    private static String getNoteListToDragPath(Context context) {
        return ClipboardCacheManager.getClipboardFileName(context, Constants.NOTES_LIST, "NotesList.sdocx");
    }

    @Nullable
    private static Uri getUriForNoteListToDrag(Context context, String str) {
        String noteListToDragPath = getNoteListToDragPath(context);
        if (TextUtils.isEmpty(noteListToDragPath)) {
            return null;
        }
        File file = new File(noteListToDragPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                MainLogger.m7256e(TAG, "getUriForNoteListToDrag# ", e);
            }
        }
        mUuidForNoteListToDrag = str;
        Uri uri = ClipDataContentProvider.getUri(noteListToDragPath);
        mFakedUriForNoteListToDrag = uri;
        return uri;
    }

    public static String getUuidForNoteListToDrag() {
        return mUuidForNoteListToDrag;
    }
}
