package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentAutoTitleCreator {
    private static final String TAG = ModelLogger.createTag("DocumentAutoTitleCreator");

    public String create(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        String str = TAG;
        DataLogger.m12307i(str, "create auto title, start");
        StringBuilder sb = new StringBuilder();
        try {
            if (!TextUtils.isEmpty(spenWNote.getTitle().getText())) {
                String text = spenWNote.getTitle().getText();
                DataLogger.m12307i(str, sb.toString());
                DataLogger.m12307i(str, "create auto title, end");
                return text;
            }
            for (AutoTitleCreator.CreationPriority creationPriority : AutoTitleCreator.CreationPriority.values()) {
                String strCreate = creationPriority.create(resources, spenWNote);
                sb.append("create, created title : ");
                sb.append(strCreate);
                sb.append(", priority : ");
                sb.append(creationPriority);
                sb.append('\n');
                if (!TextUtils.isEmpty(strCreate)) {
                    return strCreate;
                }
            }
            String str2 = TAG;
            DataLogger.m12307i(str2, sb.toString());
            DataLogger.m12307i(str2, "create auto title, end");
            return null;
        } finally {
            String str3 = TAG;
            DataLogger.m12307i(str3, sb.toString());
            DataLogger.m12307i(str3, "create auto title, end");
        }
    }
}
