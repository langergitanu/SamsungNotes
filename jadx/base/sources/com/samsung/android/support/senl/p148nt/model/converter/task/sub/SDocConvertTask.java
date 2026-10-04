package com.samsung.android.support.senl.p148nt.model.converter.task.sub;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocPathConvertParams;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask;
import com.samsung.android.support.senl.p148nt.model.converter.utils.ConvertingUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SDocConvertTask extends AbsConvertSubTask<IConvertSubTask.ISubTaskCallback> implements IConvertSubTask {
    private final ISDocConvertParams mConvertParams;
    private ConverterResult mConverterResult;
    private final IDocumentConverter mDocumentConverter;
    private final String mSdocDirPath;

    public SDocConvertTask(int i, IDocumentConverter iDocumentConverter, ISDocConvertParams iSDocConvertParams, String str, IConvertSubTask.ISubTaskCallback iSubTaskCallback) {
        super(i, 8, iSubTaskCallback);
        this.mDocumentConverter = iDocumentConverter;
        this.mConvertParams = iSDocConvertParams;
        this.mSdocDirPath = str;
    }

    private void checkUuidResults() {
        ConverterResult converterResult = this.mConverterResult;
        if (converterResult == null || converterResult.getPathList() != null || this.mConverterResult.getUuidList() == null || this.mConverterResult.getUuidList().isEmpty()) {
            return;
        }
        this.mConverterResult = getResultFromUuidList(this.mConverterResult.getUuidList());
    }

    private ConverterResult getResultFromUuidList(List<String> list) {
        File[] fileArrListFiles;
        File file = new File(this.mSdocDirPath);
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : fileArrListFiles) {
            arrayList.add(file2.getPath());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strM773o = AbstractC0541b.m773o("[", it.next(), "].sdoc");
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    String str = (String) it2.next();
                    if (str.endsWith(strM773o)) {
                        arrayList2.add(str);
                        break;
                    }
                }
            }
        }
        return new ConverterResult(arrayList2, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask
    public long getSrcSize() {
        ISDocConvertParams iSDocConvertParams = this.mConvertParams;
        if (iSDocConvertParams instanceof ISDocPathConvertParams) {
            return FileUtils.getFileSize(((ISDocPathConvertParams) iSDocConvertParams).getFilePath());
        }
        return 0L;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask
    public void postConvert() {
        ConverterResult converterResult = this.mConverterResult;
        if (converterResult == null) {
            this.mTaskResult.setState(1);
        } else {
            this.mTaskResult.setPathList(converterResult.getPathList());
        }
        super.postConvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask
    public void preConvert() {
        if (!ConvertingUtils.isAvailableMemoryForSDocConverting(getSrcSize())) {
            this.mTaskResult.setState(6);
        }
        super.preConvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask, java.lang.Runnable
    public void run() {
        preConvert();
        this.mConverterResult = this.mDocumentConverter.convert(this.mConvertParams);
        checkUuidResults();
        postConvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.model.converter.task.sub.AbsConvertSubTask, com.samsung.android.support.senl.p148nt.model.converter.task.sub.IConvertSubTask
    public void setParams(IConvertSubTask.IConvertParams iConvertParams) {
    }
}
