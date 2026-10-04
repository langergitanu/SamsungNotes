package com.samsung.android.support.senl.p148nt.model.converter.task;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.util.LockFileUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ConvertUtils;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.ConverterWrapperFactory;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx.WrappingConverter;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.converter.task.common.IConvertInfo;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.ExternalToSDocXConvertTask;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.SDocConvertTask;
import com.samsung.android.support.senl.p148nt.model.converter.task.sub.SDocXConvertTask;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConvertTaskFactory {
    private static final String TAG = ModelLogger.createConverterTag("ConvertTaskFactory");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IConvertTaskFactoryCallback extends IConvertTaskCallback {
        void onCreated();

        void onPreFailed(ErrorMsg errorMsg);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class ErrorMsg {
            private String mPath;
            private int mSrcType;
            private final int mStatus;

            public ErrorMsg(int i) {
                this.mStatus = i;
            }

            public String getPath() {
                return this.mPath;
            }

            public int getSrcType() {
                return this.mSrcType;
            }

            public int getStatus() {
                return this.mStatus;
            }

            public ErrorMsg(int i, int i2, String str) {
                this(i);
                this.mSrcType = i2;
                this.mPath = str;
            }
        }
    }

    private static void checkWrappedSdocx(Context context, boolean z, IConvertInfo iConvertInfo) {
        String path = NotesDataRepositoryFactory.newInstance(context).createMainListDocumentDataRepository().getPath(iConvertInfo.getUuid());
        if (TextUtils.isEmpty(path) || !path.endsWith(".sdocx")) {
            return;
        }
        iConvertInfo.setDstUuid(iConvertInfo.getUuid());
        if (z && iConvertInfo.getIsAuthenticated()) {
            iConvertInfo.setLockType(5);
        }
    }

    public static ConvertTask createTaskWithValidCheck(Context context, IConvertInfo iConvertInfo, @Nullable List<String> list, IConvertTaskFactoryCallback iConvertTaskFactoryCallback) {
        if (isValid(context, iConvertInfo, iConvertTaskFactoryCallback)) {
            return createTaskWithoutValidCheck(context, iConvertInfo, null, list, iConvertTaskFactoryCallback);
        }
        return null;
    }

    public static ConvertTask createTaskWithoutValidCheck(Context context, IConvertInfo iConvertInfo, String str, @Nullable List<String> list, IConvertTaskFactoryCallback iConvertTaskFactoryCallback) {
        int converterType = ConvertUtils.getConverterType(iConvertInfo.getSrcPath());
        ConvertTask convertTask = new ConvertTask(iConvertInfo, iConvertTaskFactoryCallback);
        String str2 = TAG;
        DataLogger.m12302d(str2, "createTaskWithoutValidCheck : srcType: " + converterType);
        if (converterType != 8) {
            IDocumentConverter<?> iDocumentConverterCreateDocumentConverter = new ConverterWrapperFactory(context).createDocumentConverter(converterType);
            int resultType = iDocumentConverterCreateDocumentConverter.getResultType();
            DataLogger.m12302d(str2, "createTaskWithoutValidCheck: convertType: " + resultType);
            if (resultType == 8) {
                DataLogger.m12302d(str2, "createTaskWithoutValidCheck - info.getSrcPath(): " + DataLogger.getEncode(iConvertInfo.getSrcPath()));
                convertTask.addSubTask(new SDocConvertTask(converterType, iDocumentConverterCreateDocumentConverter, iDocumentConverterCreateDocumentConverter.makeParams(iConvertInfo.getSrcPath(), str), WDocUtils.getNoteFilePath(context), convertTask.getCallback()));
                convertTask.addSubTask(new SDocXConvertTask(convertTask.getCallback()));
            } else {
                IDocumentConverter<?> wrappingConverter = iDocumentConverterCreateDocumentConverter;
                if (resultType == 9) {
                    DataLogger.m12302d(str2, "createTaskWithoutValidCheck - info.getSrcPath(): " + DataLogger.getEncode(iConvertInfo.getSrcPath()));
                    if (wrappingConverter.getStatus(iConvertInfo.getSrcPath()) == 3 && iConvertInfo.isWrappingWhenLocked()) {
                        wrappingConverter = new WrappingConverter();
                    }
                    convertTask.addSubTask(new ExternalToSDocXConvertTask(converterType, wrappingConverter, wrappingConverter.makeParams(iConvertInfo.getSrcPath(), str), iConvertInfo.getSrcPath(), convertTask.getCallback()));
                    if (wrappingConverter instanceof ISDocXConverter) {
                        iConvertInfo.setConverter((ISDocXConverter) wrappingConverter);
                        iConvertInfo.setIsIndividualPage(true);
                    }
                }
            }
            checkWrappedSdocx(context, !TextUtils.isEmpty(str), iConvertInfo);
        } else {
            int lockType = NotesDataRepositoryFactory.newInstance(context).createNotesLockDocumentRepository().getLockType(iConvertInfo.getUuid());
            convertTask.addSubTask(new SDocXConvertTask(iConvertInfo.getUuid(), iConvertInfo.getSrcPath(), convertTask.getCallback()));
            if (LockUtils.isLockedSdocType(lockType)) {
                lockType = 5;
            }
            iConvertInfo.setLockType(lockType).setIsWidgetMemo(BaseWidgetUtils.INSTANCE.isWidgetNote(context, iConvertInfo.getUuid(), list));
        }
        iConvertInfo.setSrcType(converterType);
        if (iConvertTaskFactoryCallback != null) {
            iConvertTaskFactoryCallback.onCreated();
        }
        return convertTask;
    }

    private static boolean isValid(Context context, IConvertInfo iConvertInfo, IConvertTaskFactoryCallback iConvertTaskFactoryCallback) {
        String srcPath = iConvertInfo.getSrcPath();
        if (!FileUtils.exists(srcPath)) {
            iConvertTaskFactoryCallback.onPreFailed(new IConvertTaskFactoryCallback.ErrorMsg(2));
            return false;
        }
        int converterType = ConvertUtils.getConverterType(srcPath);
        if (converterType != 8 && converterType != 9) {
            int status = new ConverterWrapperFactory(context).createDocumentConverter(converterType).getStatus(srcPath);
            if (status == 3 && iConvertInfo.isWrappingWhenLocked()) {
                iConvertInfo.setLockType(LockFileUtils.getLockType(context, srcPath));
                return true;
            }
            if (status != 0) {
                iConvertTaskFactoryCallback.onPreFailed(new IConvertTaskFactoryCallback.ErrorMsg(status, converterType, srcPath));
                return false;
            }
        }
        return true;
    }
}
