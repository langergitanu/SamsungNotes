package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ContentTitleCreator {
    private static final String SEPARATOR = ", ";
    private static final String TAG = ModelLogger.createTag("ContentTitleCreator");

    private static void appendSeparator(@NonNull StringBuilder sb, boolean z) {
        if (z) {
            sb.append(", ");
        }
    }

    public static String create(@NonNull SpenWNote spenWNote) {
        boolean z;
        SpenWNoteObjectHelper spenWNoteObjectHelper = new SpenWNoteObjectHelper();
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        if (spenWNoteObjectHelper.hasObject(spenWNote, 14)) {
            sb.append(AutoTitleCreator.CreationPriority.DRAWING);
            z = true;
        } else {
            z = false;
        }
        if (spenWNoteObjectHelper.hasObject(spenWNote, 3)) {
            appendSeparator(sb, z);
            sb.append(AutoTitleCreator.CreationPriority.IMAGE);
        } else {
            z2 = z;
        }
        if (spenWNoteObjectHelper.hasObject(spenWNote, 10)) {
            SpenObjectVoice spenObjectVoice = (SpenObjectVoice) spenWNoteObjectHelper.findFirstObject(spenWNote, 10, 512);
            String str = TAG;
            DataLogger.m12307i(str, "create, find object : " + spenObjectVoice);
            if (spenObjectVoice != null) {
                appendSeparator(sb, z2);
                boolean zIsRecorded = spenObjectVoice.isRecorded();
                AbstractC11014a.m12335t("create, find audio object - isRecorded : ", str, zIsRecorded);
                sb.append(zIsRecorded ? AutoTitleCreator.CreationPriority.RECORDING : spenObjectVoice.getTitle());
            }
        }
        return sb.toString();
    }
}
