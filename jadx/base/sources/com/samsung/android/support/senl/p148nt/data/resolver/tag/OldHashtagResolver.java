package com.samsung.android.support.senl.p148nt.data.resolver.tag;

import android.content.Context;
import android.database.ContentObserver;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OldHashtagResolver {
    private static final String TAG = DataLogger.createTag("OldHashtagResolver");

    public static boolean hashTagExists(@NonNull List<String> list) {
        return NotesDatabaseManager.getInstance().getHashtagContentDao().hashTagExists(list);
    }

    private static void notifyTagBoard(@NonNull Context context) {
        try {
            if (DeviceUtils.isPowerManageMode(context)) {
                return;
            }
            context.getContentResolver().notifyChange(ExternalDataConstants.BASE_URI_NOTE_TAG, (ContentObserver) null, false);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("notifyTagBoard, e : "), TAG);
        }
    }

    public static void notifyTagBoardByUuid(@NonNull Context context, @NonNull String str) {
        notifyTagBoardByUuid(context, (List<String>) Collections.singletonList(str));
    }

    public static void notifyTagBoardByUuid(@NonNull Context context, @NonNull List<String> list) {
        if (hashTagExists(list)) {
            notifyTagBoard(context);
        }
    }
}
