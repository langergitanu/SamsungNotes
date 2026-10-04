package com.samsung.android.support.senl.p148nt.model.converter.task.sub;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.SDocXConvertTask;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ExternalToSDocXConvertTask extends SDocXConvertTask {
    public ExternalToSDocXConvertTask(int i, IDocumentConverter iDocumentConverter, ISDocConvertParams iSDocConvertParams, String str, SDocXConvertTask.ISDocXConvertTaskCallback iSDocXConvertTaskCallback) {
        super(i, str, iSDocXConvertTaskCallback);
        iDocumentConverter.convert(iSDocConvertParams);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.SDocXConvertTask
    public long getTargetFileSize(@NonNull Context context, String str) {
        return FileUtils.getFileSize(str);
    }
}
