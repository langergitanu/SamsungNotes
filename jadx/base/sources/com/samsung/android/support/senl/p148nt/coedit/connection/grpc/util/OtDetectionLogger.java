package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import coeditCoreMessage.BinaryInfo;
import coeditCoreMessage.CheckPointCoeditOpPair;
import coeditCoreMessage.DeviceInfo;
import coeditCoreMessage.ObjectInfo;
import coeditCoreMessage.ResponseResult;
import coeditOperation.ChangeType;
import coeditOperation.CoeditOperation;
import coeditOtMessage.IdxCedOpsPair;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import io.grpc.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OtDetectionLogger {
    private static OtDetectionLoggerBase mOtDetectionLoggerBase;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C90241 {
        static final /* synthetic */ int[] $SwitchMap$coeditOperation$ChangeType;

        static {
            int[] iArr = new int[ChangeType.values().length];
            $SwitchMap$coeditOperation$ChangeType = iArr;
            try {
                iArr[ChangeType.INSERT_ELEMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.DELETE_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.UPDATE_ATTRIBUTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.REPLACE_ATTRIBUTES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.INSERT_CHARACTERS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.DELETE_CHARACTERS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.SET_ANNOTATIONS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.INSERT_OBJECT_SPAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.DELETE_OBJECT_SPAN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$coeditOperation$ChangeType[ChangeType.RETAIN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class OtDetectionLoggerBase {
        public abstract String getResponseResultLog(ResponseResult responseResult);

        public abstract String getResponseResultLog(coeditObjectMessage.ResponseResult responseResult);

        public abstract String getResponseResultLog(noteSnapMessage.ResponseResult responseResult);

        public void printCancellationCause(OtDetectionListener otDetectionListener) {
            Throwable thCancellationCause = Context.current().cancellationCause();
            if (thCancellationCause != null) {
                CoeditLogger.m8920e(otDetectionListener.getTag(), "CancellationCause: " + thCancellationCause.getMessage());
            }
        }

        public abstract void printDeleteCharacters(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printDeleteElements(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printDeleteObjectSpan(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printDeviceInfo(OtDetectionListener otDetectionListener, String str, CheckPointCoeditOpPair checkPointCoeditOpPair);

        public abstract void printInsertCharacters(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printInsertElements(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printInsertObjectSpan(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printLog(String str, String str2);

        public abstract void printObjectInfo(OtDetectionListener otDetectionListener, String str, CheckPointCoeditOpPair checkPointCoeditOpPair);

        public abstract void printReplaceAttributes(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printRetains(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printSetAnnotations(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);

        public abstract void printUpdateAttributes(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2);
    }

    private static OtDetectionLoggerBase getLogger() {
        if (mOtDetectionLoggerBase == null) {
            mOtDetectionLoggerBase = new OtDetectionLoggerDebug();
        }
        return mOtDetectionLoggerBase;
    }

    public static String getResponseResultLog(ResponseResult responseResult) {
        return getLogger().getResponseResultLog(responseResult);
    }

    public static void printCancellationCause(OtDetectionListener otDetectionListener) {
        getLogger().printCancellationCause(otDetectionListener);
    }

    public static void printCheckPointOperationPair(OtDetectionListener otDetectionListener, String str, CheckPointCoeditOpPair checkPointCoeditOpPair) {
        if (checkPointCoeditOpPair == null) {
            return;
        }
        if (checkPointCoeditOpPair.getCoeditOperationCount() > 0) {
            StringBuilder sbM781w = AbstractC0541b.m781w(str, "# CoeditOperations# checkPoint :[");
            sbM781w.append(checkPointCoeditOpPair.getCheckpoint());
            sbM781w.append("]");
            printCoeditOperations(otDetectionListener, sbM781w.toString(), str, checkPointCoeditOpPair.getCoeditOperationList());
        }
        if (checkPointCoeditOpPair.getObjectInfoCount() > 0) {
            getLogger().printObjectInfo(otDetectionListener, str, checkPointCoeditOpPair);
        }
        if (checkPointCoeditOpPair.hasDeviceInfo()) {
            getLogger().printDeviceInfo(otDetectionListener, str, checkPointCoeditOpPair);
        }
    }

    private static void printCoeditOperation(OtDetectionListener otDetectionListener, String str, CoeditOperation coeditOperation2) {
        StringBuilder sb = new StringBuilder(str);
        switch (C90241.$SwitchMap$coeditOperation$ChangeType[coeditOperation2.getChangeType().ordinal()]) {
            case 1:
                getLogger().printInsertElements(otDetectionListener, sb, coeditOperation2);
                break;
            case 2:
                getLogger().printDeleteElements(otDetectionListener, sb, coeditOperation2);
                break;
            case 3:
                getLogger().printUpdateAttributes(otDetectionListener, sb, coeditOperation2);
                break;
            case 4:
                getLogger().printReplaceAttributes(otDetectionListener, sb, coeditOperation2);
                break;
            case 5:
                getLogger().printInsertCharacters(otDetectionListener, sb, coeditOperation2);
                break;
            case 6:
                getLogger().printDeleteCharacters(otDetectionListener, sb, coeditOperation2);
                break;
            case 7:
                getLogger().printSetAnnotations(otDetectionListener, sb, coeditOperation2);
                break;
            case 8:
                getLogger().printInsertObjectSpan(otDetectionListener, sb, coeditOperation2);
                break;
            case 9:
                getLogger().printDeleteObjectSpan(otDetectionListener, sb, coeditOperation2);
                break;
            case 10:
                getLogger().printRetains(otDetectionListener, sb, coeditOperation2);
                break;
        }
    }

    private static void printCoeditOperations(OtDetectionListener otDetectionListener, String str, String str2, List<CoeditOperation> list) {
        getLogger().printLog(otDetectionListener.getTag(), str);
        Iterator<CoeditOperation> it = list.iterator();
        while (it.hasNext()) {
            printCoeditOperation(otDetectionListener, str2, it.next());
        }
    }

    public static void printIdxCedOpsPair(OtDetectionListener otDetectionListener, String str, IdxCedOpsPair idxCedOpsPair) {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, ", idxCedOpsPair Idx: ");
        sbM781w.append(idxCedOpsPair.getIdx());
        sbM781w.append(", count: ");
        sbM781w.append(idxCedOpsPair.getCedOps().getCoeditOperationCount());
        printCoeditOperations(otDetectionListener, sbM781w.toString(), str, idxCedOpsPair.getCedOps().getCoeditOperationList());
    }

    public static String getResponseResultLog(coeditObjectMessage.ResponseResult responseResult) {
        return getLogger().getResponseResultLog(responseResult);
    }

    public static String getResponseResultLog(noteSnapMessage.ResponseResult responseResult) {
        return getLogger().getResponseResultLog(responseResult);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OtDetectionLoggerDebug extends OtDetectionLoggerBase {
        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public String getResponseResultLog(noteSnapMessage.ResponseResult responseResult) {
            if (responseResult == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder("Result(noteSnap):: ResultCode: [");
            sb.append(responseResult.getCode());
            sb.append("]");
            if (!responseResult.getLmsg().isEmpty()) {
                sb.append(", Lmsg: [");
                sb.append(responseResult.getLmsg());
                sb.append("]");
            }
            if (!responseResult.getRmsg().isEmpty()) {
                sb.append(", Rmsg: [");
                sb.append(responseResult.getRmsg());
                sb.append("]");
            }
            return sb.toString();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printDeleteCharacters(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            sb.append("# DELETE_CHARACTERS# operationIndex :[");
            sb.append(coeditOperation2.getIndex());
            sb.append("], characters :[");
            sb.append(CoeditLogger.getEncode(coeditOperation2.getDeleteCharacters()));
            sb.append("], size :[");
            sb.append(coeditOperation2.getSize());
            sb.append("]");
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printDeleteElements(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            int index = coeditOperation2.getIndex();
            int size = coeditOperation2.getSize();
            sb.append("# DELETE_ELEMENTS# operationIndex :[");
            sb.append(index);
            sb.append("], elementCount :[");
            sb.append(coeditOperation2.getDeleteElements().getElementCount());
            sb.append("], size :[");
            sb.append(size);
            sb.append("]");
            for (CoeditOperation.Element element : coeditOperation2.getDeleteElements().getElementList()) {
                sb.append(", {TagData# tagName :[");
                sb.append(element.getTagName());
                sb.append("], isEndTag :[");
                sb.append(element.getElementEnd());
                sb.append("}]");
                int attributeCount = element.getAttributeCount();
                if (attributeCount > 0) {
                    AbstractC1974b.m1330w(attributeCount, ", {AttributeData# attributeCount :[", "]", sb);
                    for (int i = 0; i < attributeCount; i++) {
                        CoeditOperation.KeyValuePair attribute = element.getAttribute(i);
                        sb.append("  { attribute(");
                        sb.append(i);
                        sb.append("), key : ");
                        sb.append(attribute.getKey());
                        sb.append(" / value : ");
                        sb.append(attribute.getValue());
                        sb.append("}");
                    }
                    sb.append("}");
                }
            }
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printDeleteObjectSpan(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            sb.append("# DELETE_OBJECT_SPAN# operationIndex :[");
            sb.append(coeditOperation2.getIndex());
            sb.append("], size :[");
            sb.append(coeditOperation2.getSize());
            sb.append(" { key : ");
            sb.append(coeditOperation2.getDeleteObjectSpan().getObjectSpan().getKey());
            sb.append(" / value : [");
            sb.append(coeditOperation2.getDeleteObjectSpan().getObjectSpan().getValue());
            sb.append("]}");
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printDeviceInfo(OtDetectionListener otDetectionListener, String str, CheckPointCoeditOpPair checkPointCoeditOpPair) {
            DeviceInfo deviceInfo = checkPointCoeditOpPair.getDeviceInfo();
            String tag = otDetectionListener.getTag();
            StringBuilder sbM781w = AbstractC0541b.m781w(str, "# DeviceInfo# dvcId :[");
            sbM781w.append(deviceInfo.getDvcId());
            sbM781w.append("], uid :[");
            sbM781w.append(deviceInfo.getUid());
            sbM781w.append("], deviceInfoChangeType :[");
            sbM781w.append(deviceInfo.getDeviceInfoChangeType());
            sbM781w.append("]");
            CoeditLogger.m8923i(tag, sbM781w.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printInsertCharacters(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            sb.append("# INSERT_CHARACTERS# operationIndex :[");
            sb.append(coeditOperation2.getIndex());
            sb.append("], characters :[");
            sb.append(CoeditLogger.getEncode(coeditOperation2.getInsertCharacters()));
            sb.append("], size :[");
            sb.append(coeditOperation2.getSize());
            sb.append("]");
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printInsertElements(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            int index = coeditOperation2.getIndex();
            int size = coeditOperation2.getSize();
            sb.append("# INSERT_ELEMENTS# operationIndex :[");
            sb.append(index);
            sb.append("], elementCount :[");
            sb.append(coeditOperation2.getInsertElements().getElementCount());
            sb.append("], size :[");
            sb.append(size);
            sb.append("]");
            for (CoeditOperation.Element element : coeditOperation2.getInsertElements().getElementList()) {
                sb.append(", {TagData# tagName :[");
                sb.append(element.getTagName());
                sb.append("], isEndTag :[");
                sb.append(element.getElementEnd());
                sb.append("}]");
                int attributeCount = element.getAttributeCount();
                if (attributeCount > 0) {
                    AbstractC1974b.m1330w(attributeCount, ", {AttributeData# attributeCount :[", "]", sb);
                    for (int i = 0; i < attributeCount; i++) {
                        CoeditOperation.KeyValuePair attribute = element.getAttribute(i);
                        sb.append("  { attribute(");
                        sb.append(i);
                        sb.append("), key : ");
                        sb.append(attribute.getKey());
                        sb.append(" / value : ");
                        sb.append(attribute.getValue());
                        sb.append("}");
                    }
                    sb.append("}");
                }
            }
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printInsertObjectSpan(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            sb.append("# INSERT_OBJECT_SPAN# operationIndex :[");
            sb.append(coeditOperation2.getIndex());
            sb.append("], size :[");
            sb.append(coeditOperation2.getSize());
            sb.append(" { key : ");
            sb.append(coeditOperation2.getInsertObjectSpan().getObjectSpan().getKey());
            sb.append(" / value : [");
            sb.append(coeditOperation2.getInsertObjectSpan().getObjectSpan().getValue());
            sb.append("]}");
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printLog(String str, String str2) {
            CoeditLogger.m8923i(str, str2);
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printObjectInfo(OtDetectionListener otDetectionListener, String str, CheckPointCoeditOpPair checkPointCoeditOpPair) {
            for (ObjectInfo objectInfo : checkPointCoeditOpPair.getObjectInfoList()) {
                StringBuilder sbM12325j = AbstractC11014a.m12325j(str, "# ObjectInfo# objectId :[");
                sbM12325j.append(objectInfo.getObjId());
                sbM12325j.append("]");
                if (objectInfo.hasBinaryInfo()) {
                    BinaryInfo binaryInfo = objectInfo.getBinaryInfo();
                    sbM12325j.append(", {BinaryInfo: hash :[");
                    sbM12325j.append(binaryInfo.getHash());
                    sbM12325j.append("], mimeType :[");
                    sbM12325j.append(binaryInfo.getMimetype());
                    sbM12325j.append("], size :[");
                    sbM12325j.append(binaryInfo.getSize());
                    sbM12325j.append("]}");
                }
                CoeditLogger.m8923i(otDetectionListener.getTag(), sbM12325j.toString());
            }
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printReplaceAttributes(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            sb.append("# REPLACE_ATTRIBUTES# operationIndex :[");
            sb.append(coeditOperation2.getIndex());
            sb.append("], newAttributeCount :[");
            sb.append(coeditOperation2.getReplaceAttributes().getNewAttributeCount());
            sb.append("], size :[");
            sb.append(coeditOperation2.getSize());
            sb.append("]");
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printRetains(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            sb.append("# RETAIN# operationIndex :[");
            sb.append(coeditOperation2.getIndex());
            sb.append("], size :[");
            sb.append(coeditOperation2.getSize());
            sb.append("]");
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printSetAnnotations(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            int index = coeditOperation2.getIndex();
            int size = coeditOperation2.getSize();
            sb.append("# SET_ANNOTATIONS# operationIndex :[");
            sb.append(index);
            sb.append("], endIndex :[");
            sb.append(coeditOperation2.getSetAnnotations().getEndIndex());
            sb.append("], size :[");
            sb.append(size);
            sb.append("]");
            int annotationCount = coeditOperation2.getSetAnnotations().getAnnotationCount();
            if (annotationCount > 0) {
                AbstractC1974b.m1330w(annotationCount, " {AttributeData# setAnnotationCount :[", "]", sb);
                for (int i = 0; i < annotationCount; i++) {
                    CoeditOperation.KeyValueUpdate annotation = coeditOperation2.getSetAnnotations().getAnnotation(i);
                    sb.append("  { attribute(");
                    sb.append(i);
                    sb.append("), key : ");
                    sb.append(annotation.getKey());
                    sb.append(" / old value : [");
                    sb.append(annotation.getOldValue());
                    sb.append("] -> new value : [");
                    sb.append(annotation.getNewValue());
                    sb.append("]}");
                }
                sb.append("}");
            }
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public void printUpdateAttributes(OtDetectionListener otDetectionListener, StringBuilder sb, CoeditOperation coeditOperation2) {
            int index = coeditOperation2.getIndex();
            int size = coeditOperation2.getSize();
            sb.append("# UPDATE_ATTRIBUTES# operationIndex :[");
            sb.append(index);
            sb.append("], changeCount :[");
            sb.append(coeditOperation2.getUpdateAttributes().getChangeCount());
            sb.append("], size :[");
            sb.append(size);
            sb.append("]");
            int changeCount = coeditOperation2.getUpdateAttributes().getChangeCount();
            if (changeCount > 0) {
                AbstractC1974b.m1330w(changeCount, " {AttributeData# updateAttributeCount :[", "]", sb);
                for (int i = 0; i < changeCount; i++) {
                    CoeditOperation.KeyValueUpdate change = coeditOperation2.getUpdateAttributes().getChange(i);
                    sb.append("  { attribute(");
                    sb.append(i);
                    sb.append("), key : ");
                    sb.append(change.getKey());
                    sb.append(" / old value : [");
                    sb.append(change.getOldValue());
                    sb.append("] -> new value : [");
                    sb.append(change.getNewValue());
                    sb.append("]}");
                }
                sb.append("}");
            }
            CoeditLogger.m8923i(otDetectionListener.getTag(), sb.toString());
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public String getResponseResultLog(coeditObjectMessage.ResponseResult responseResult) {
            if (responseResult == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder("Result(coeditObject):: ResultCode: [");
            sb.append(responseResult.getCode());
            sb.append("]");
            if (!responseResult.getLmsg().isEmpty()) {
                sb.append(", Lmsg: [");
                sb.append(responseResult.getLmsg());
                sb.append("]");
            }
            if (!responseResult.getRmsg().isEmpty()) {
                sb.append(", Rmsg: [");
                sb.append(responseResult.getRmsg());
                sb.append("]");
            }
            return sb.toString();
        }

        @Override // com.samsung.android.support.senl.nt.coedit.connection.grpc.util.OtDetectionLogger.OtDetectionLoggerBase
        public String getResponseResultLog(ResponseResult responseResult) {
            if (responseResult == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder("Result(coeditCore):: ResultCode: [");
            sb.append(responseResult.getCode());
            sb.append("]");
            if (!responseResult.getLmsg().isEmpty()) {
                sb.append(", Lmsg: [");
                sb.append(responseResult.getLmsg());
                sb.append("]");
            }
            if (!responseResult.getRmsg().isEmpty()) {
                sb.append(", Rmsg: [");
                sb.append(responseResult.getRmsg());
                sb.append("]");
            }
            if (!responseResult.getRequestId().isEmpty()) {
                sb.append(", RequestId: [");
                sb.append(responseResult.getRequestId());
                sb.append("]");
            }
            return sb.toString();
        }
    }
}
