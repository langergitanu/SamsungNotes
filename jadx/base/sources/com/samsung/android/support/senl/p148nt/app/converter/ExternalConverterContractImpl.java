package com.samsung.android.support.senl.p148nt.app.converter;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.reflect.DocumentDataContractImpl;
import com.samsung.android.support.senl.document.contract.DocumentDataContract;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.document.memoconverter.core.SNoteConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ConvertUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertItem;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskFactory;
import com.samsung.android.support.senl.p148nt.model.converter.task.ConvertTaskGroup;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.ConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p086V.InterfaceC0316b;
import p086V.InterfaceC0317c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ExternalConverterContractImpl implements InterfaceC0317c {
    private static final String TAG = "ExternalConverterContractImpl";
    private DocumentDataContractImpl mDocDataContractImpl;
    private boolean mIsActive;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SNoteFolderNameCreator {
        private static final String SDOC_FOR_CATEGORY = "SDocData";
        private static final String SMEMO2_FOR_CATEGORY = "SMemo2";
        private static final String SMEMO_FOR_CATEGORY = "SMemo";
        private static final String SNOTE3_FOR_CATEGORY = "SNote3";
        private static final String SNOTEPATH_FOR_CATEGORY = "SnoteData";
        private static final String SNOTE_FOR_CATEGORY = "SNote";
        private static final String TAG = "SNoteCategoryExtractor";
        private static final int TYPE_SDOCDATA = 6;
        private static final int TYPE_SMEMO = 2;
        private static final int TYPE_SMEMO2 = 3;
        private static final int TYPE_SNOTE = 4;
        private static final int TYPE_SNOTE3 = 5;
        private static final int TYPE_SNOTEDATA = 1;

        public /* synthetic */ SNoteFolderNameCreator(int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getFolderNameByPath(String str) {
            int type = getType(str);
            if (type <= 0) {
                return null;
            }
            int iLastIndexOf = str.lastIndexOf(47);
            int iLastIndexOf2 = str.lastIndexOf(47, iLastIndexOf - 1) + 1;
            String strSubstring = str.substring(iLastIndexOf2, iLastIndexOf);
            StringBuilder sbM1173s = AbstractC0622a.m1173s(iLastIndexOf2, iLastIndexOf, "getFolderNameByPath() : subCatPosStart[", "] subCatPosEnd[", "], folderName : ");
            sbM1173s.append(strSubstring);
            Logger.m8702i(TAG, sbM1173s.toString());
            if ((type == 1 && SNOTEPATH_FOR_CATEGORY.equals(strSubstring)) || ((type == 2 && SMEMO_FOR_CATEGORY.equals(strSubstring)) || ((type == 3 && SMEMO2_FOR_CATEGORY.equals(strSubstring)) || ((type == 4 && SNOTE_FOR_CATEGORY.equals(strSubstring)) || ((type == 5 && SNOTE3_FOR_CATEGORY.equals(strSubstring)) || (type == 6 && "SDocData".equals(strSubstring))))))) {
                while (iLastIndexOf2 > 0 && iLastIndexOf > 0) {
                    iLastIndexOf = iLastIndexOf2 - 1;
                    iLastIndexOf2 = str.lastIndexOf(47, iLastIndexOf2 - 2) + 1;
                    if (strSubstring.equals(iLastIndexOf > iLastIndexOf2 ? str.substring(iLastIndexOf2, iLastIndexOf) : "")) {
                    }
                }
                return null;
            }
            return strSubstring;
        }

        private int getType(String str) {
            StringBuilder sb = new StringBuilder(SNOTEPATH_FOR_CATEGORY);
            String str2 = File.separator;
            sb.append(str2);
            if (str.contains(sb.toString())) {
                return 1;
            }
            if (str.contains(SMEMO2_FOR_CATEGORY + str2)) {
                return 3;
            }
            if (str.contains(SMEMO_FOR_CATEGORY + str2)) {
                return 2;
            }
            if (str.contains(SNOTE3_FOR_CATEGORY + str2)) {
                return 5;
            }
            if (str.contains(SNOTE_FOR_CATEGORY + str2)) {
                return 4;
            }
            StringBuilder sb2 = new StringBuilder("SDocData");
            sb2.append(str2);
            return str.contains(sb2.toString()) ? 6 : 0;
        }

        private SNoteFolderNameCreator() {
        }
    }

    private void deletePrevFile(String str) {
        Context appContext;
        String strFindConvertedSNoteFileByPath = findConvertedSNoteFileByPath(str);
        if (strFindConvertedSNoteFileByPath == null || (appContext = ApplicationManager.getInstance().getAppContext()) == null) {
            return;
        }
        getDocumentDataContract().deleteSDoc(appContext, getDocumentDataContract().getSDocUUID(appContext, strFindConvertedSNoteFileByPath), true);
    }

    private String findConvertedSNoteFileByPath(String str) {
        String title;
        if (str == null || (title = ConverterUtils.getTitle(str)) == null) {
            return null;
        }
        return findConvertedSNoteFileByTitle(title);
    }

    private String findConvertedSNoteFileByTitle(String str) {
        Context appContext = ApplicationManager.getInstance().getAppContext();
        if (appContext == null) {
            return null;
        }
        ArrayList<String> noteFilePathList = getDocumentDataContract().getNoteFilePathList(appContext, false);
        if (noteFilePathList != null && !noteFilePathList.isEmpty()) {
            int size = noteFilePathList.size();
            for (int i = 0; i < size; i++) {
                String str2 = noteFilePathList.get(i);
                if (isConvertedFile(str2, str)) {
                    return str2;
                }
            }
        }
        return null;
    }

    private DocumentDataContract getDocumentDataContract() {
        if (this.mDocDataContractImpl == null) {
            this.mDocDataContractImpl = new DocumentDataContractImpl();
        }
        return this.mDocDataContractImpl;
    }

    private boolean isConvertedFile(String str, String str2) {
        if (str == null) {
            return false;
        }
        int iIndexOf = str.indexOf("[");
        int iLastIndexOf = str.lastIndexOf("]");
        if (iIndexOf >= 0 && iLastIndexOf >= 0 && iLastIndexOf > iIndexOf) {
            int i = iIndexOf + 1;
            if (iLastIndexOf - i > 0) {
                String strSubstring = str.substring(i, iLastIndexOf);
                if (!strSubstring.isEmpty() && strSubstring.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void convert(@Nullable Context context, final List<IConvertItem> list, final InterfaceC0316b interfaceC0316b) {
        int i = 0;
        if (context == null) {
            Logger.m8698e(TAG, "convert, context is null");
            if (interfaceC0316b != null) {
                interfaceC0316b.onEnd(list.size(), 0, list.size());
                return;
            }
            return;
        }
        ConvertTaskGroup.IGroupTaskCallback iGroupTaskCallback = new ConvertTaskGroup.IGroupTaskCallback() { // from class: com.samsung.android.support.senl.nt.app.converter.ExternalConverterContractImpl.1
            private void onProgress(String str, IConvertResult iConvertResult) {
                interfaceC0316b.onProgressed(iConvertResult.getProgressCount(), str);
                Logger.m8697d(ExternalConverterContractImpl.TAG, "onProgress : " + iConvertResult.getProgressCount() + " / " + iConvertResult.getTotalCount());
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
            public void onCreated() {
                Logger.m8697d(ExternalConverterContractImpl.TAG, "onCreated");
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskGroup.IGroupTaskCallback
            public void onEnd(boolean z, IConvertResult iConvertResult) {
                interfaceC0316b.onEnd(iConvertResult.getTotalCount(), iConvertResult.getSuccessCount(), iConvertResult.getFailedCount());
            }

            @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
            public void onFailed(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                onProgress(iConvertInfo.getSrcPath(), iConvertResult);
                Logger.m8698e(ExternalConverterContractImpl.TAG, "onFailed : " + iConvertResult.getFailedCount());
            }

            @Override // com.samsung.android.support.senl.nt.model.converter.task.ConvertTaskFactory.IConvertTaskFactoryCallback
            public void onPreFailed(ConvertTaskFactory.IConvertTaskFactoryCallback.ErrorMsg errorMsg) {
                int size = list.size();
                interfaceC0316b.onEnd(size, 0, size);
                Logger.m8698e(ExternalConverterContractImpl.TAG, "onPreFailed : " + errorMsg.getStatus());
            }

            @Override // com.samsung.android.support.senl.p148nt.model.converter.task.IConvertTaskCallback
            public void onSuccess(IConvertInfo iConvertInfo, IConvertResult iConvertResult) {
                onProgress(iConvertInfo.getSrcPath(), iConvertResult);
                Logger.m8697d(ExternalConverterContractImpl.TAG, "onSuccess : " + iConvertResult.getSuccessCount());
            }
        };
        ArrayList arrayList = new ArrayList();
        for (IConvertItem iConvertItem : list) {
            String srcPath = iConvertItem.getSrcPath();
            if (iConvertItem.getWritingMode() == 1) {
                deletePrevFile(srcPath);
            }
            String folderNameByPath = new SNoteFolderNameCreator(i).getFolderNameByPath(srcPath);
            String title = srcPath == null ? "tmp" : ConverterUtils.getTitle(srcPath);
            arrayList.add(new ConvertInfo(srcPath, hashCode()).setDstFilePrefix("[" + title + "]").setWriteMode(iConvertItem.getWritingMode()).setIsWrappingWhenLocked(iConvertItem.isWrappingWhenLocked()).setFolderName(folderNameByPath));
        }
        ConvertTaskManager.getInstance().put(new ConvertTaskGroup(context, arrayList, hashCode(), -1, iGroupTaskCallback));
    }

    public long getLastModifiedTime(String str) {
        if (ConvertUtils.getConverterType(str) == 1) {
            return new SNoteConverter(ApplicationManager.getInstance().getAppContext()).getLastModifiedTime(str);
        }
        return 0L;
    }

    @Override // p086V.InterfaceC0317c
    public synchronized void init() {
        ConvertTaskManager.connect(ApplicationManager.getInstance().getAppContext());
        this.mIsActive = true;
    }

    public boolean isAlreadyConverted(String str) {
        int converterType = ConvertUtils.getConverterType(str);
        return (converterType == 1 || converterType == 2) && findConvertedSNoteFileByPath(str) != null;
    }

    public boolean isReady() {
        return this.mIsActive;
    }

    @Override // p086V.InterfaceC0317c
    public void release() {
        this.mIsActive = false;
        ConvertTaskManager.disconnect();
    }

    @Override // p086V.InterfaceC0317c
    public void convert(@Nullable Context context, IConvertItem iConvertItem, InterfaceC0316b interfaceC0316b) {
        if (context == null) {
            Logger.m8698e(TAG, "convert, context is null");
            if (interfaceC0316b != null) {
                interfaceC0316b.onEnd(1, 0, 1);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(iConvertItem);
        convert(context, arrayList, interfaceC0316b);
    }
}
