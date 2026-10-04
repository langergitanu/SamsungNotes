package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util;

import android.util.Pair;
import coeditOperation.ChangeType;
import coeditOperation.CoeditOperation;
import com.samsung.android.support.senl.ntnl.coedit.common.raw.Element;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpReplaceAttributes;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpSetAnnotations;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpType;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOpUpdateAttributes;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Serializer {
    private static final String TAG = "Serializer";

    private static CoeditOperation.Elements convert(List<Element> list) {
        if (list == null) {
            return CoeditOperation.Elements.newBuilder().build();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Element element : list) {
            ArrayList arrayList3 = new ArrayList();
            for (String str : element.getAttributeKeys()) {
                arrayList3.add(CoeditOperation.KeyValuePair.newBuilder().setKey(str).setValue(element.getAttribute(str)).build());
            }
            if (arrayList2.contains(element.getName()) || !element.isEnd()) {
                arrayList.add(CoeditOperation.Element.newBuilder().setElementEnd(element.isEnd()).setTagName(element.getName()).addAllAttribute(arrayList3).build());
                if (element.isEnd()) {
                    arrayList2.remove(element.getName());
                } else {
                    arrayList2.add(element.getName());
                }
            } else {
                arrayList.add(CoeditOperation.Element.newBuilder().setTagName(element.getName()).addAllAttribute(arrayList3).build());
                arrayList.add(CoeditOperation.Element.newBuilder().setElementEnd(element.isEnd()).setTagName(element.getName()).build());
            }
        }
        return CoeditOperation.Elements.newBuilder().addAllElement(arrayList).build();
    }

    private static ChangeType convertType(@NoteOpType int i) {
        ChangeType changeType = ChangeType.UNRECOGNIZED;
        switch (i) {
            case 0:
                return ChangeType.INSERT_CHARACTERS;
            case 1:
                return ChangeType.DELETE_CHARACTERS;
            case 2:
                return ChangeType.INSERT_ELEMENTS;
            case 3:
                return ChangeType.DELETE_ELEMENTS;
            case 4:
                return ChangeType.UPDATE_ATTRIBUTES;
            case 5:
                return ChangeType.REPLACE_ATTRIBUTES;
            case 6:
                return ChangeType.SET_ANNOTATIONS;
            case 7:
                return ChangeType.INSERT_OBJECT_SPAN;
            case 8:
                return ChangeType.DELETE_OBJECT_SPAN;
            case 9:
                return ChangeType.RETAIN;
            default:
                return changeType;
        }
    }

    public static List<CoeditOperation> serialize(List<NoteOp> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<NoteOp> it = list.iterator();
        while (it.hasNext()) {
            CoeditOperation coeditOperationSerialize = serialize(it.next());
            if (coeditOperationSerialize != null) {
                arrayList.add(coeditOperationSerialize);
            }
        }
        return arrayList;
    }

    private static CoeditOperation serializeDeleteCharacterOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setDeleteCharacters(noteOp.getDeleteCharacters()).build();
    }

    private static CoeditOperation serializeDeleteElementsOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setDeleteElements(convert(noteOp.getDeleteElements())).build();
    }

    private static CoeditOperation serializeDeleteObjectSpanOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setDeleteObjectSpan(convert(noteOp.getDeleteObjectSpan())).build();
    }

    private static CoeditOperation serializeInsertCharacterOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setInsertCharacters(noteOp.getInsertCharacters()).build();
    }

    private static CoeditOperation serializeInsertElementsOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setInsertElements(convert(noteOp.getInsertElements())).build();
    }

    private static CoeditOperation serializeInsertObjectSpanOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setInsertObjectSpan(convert(noteOp.getInsertObjectSpan())).build();
    }

    private static CoeditOperation serializeReplaceAttributeOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setReplaceAttributes(convert(noteOp.getReplaceAttributes())).build();
    }

    private static CoeditOperation serializeRetainOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).build();
    }

    private static CoeditOperation serializeSetAnnotationOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setSetAnnotations(convert(noteOp.getSetAnnotations())).build();
    }

    private static CoeditOperation serializeUpdateAttributeOp(NoteOp noteOp) {
        return CoeditOperation.newBuilder().setChangeType(convertType(noteOp.getType())).setIndex(noteOp.getPos()).setSize(noteOp.getSize()).setUpdateAttributes(convert(noteOp.getUpdateAttributes())).build();
    }

    private static CoeditOperation serialize(NoteOp noteOp) {
        switch (noteOp.getType()) {
            case 0:
                return serializeInsertCharacterOp(noteOp);
            case 1:
                return serializeDeleteCharacterOp(noteOp);
            case 2:
                return serializeInsertElementsOp(noteOp);
            case 3:
                return serializeDeleteElementsOp(noteOp);
            case 4:
                return serializeUpdateAttributeOp(noteOp);
            case 5:
                return serializeReplaceAttributeOp(noteOp);
            case 6:
                return serializeSetAnnotationOp(noteOp);
            case 7:
                return serializeInsertObjectSpanOp(noteOp);
            case 8:
                return serializeDeleteObjectSpanOp(noteOp);
            case 9:
                return serializeRetainOp(noteOp);
            default:
                CoeditLogger.m8919d(TAG, "Unsupported type");
                return null;
        }
    }

    private static CoeditOperation.UpdateAttributes convert(NoteOpUpdateAttributes noteOpUpdateAttributes) {
        if (noteOpUpdateAttributes == null) {
            return CoeditOperation.UpdateAttributes.newBuilder().build();
        }
        ArrayList arrayList = new ArrayList();
        List<String> attributeKeys = noteOpUpdateAttributes.getAttributeKeys();
        List<String> oldAttributes = noteOpUpdateAttributes.getOldAttributes();
        List<String> newAttributes = noteOpUpdateAttributes.getNewAttributes();
        int size = attributeKeys.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(CoeditOperation.KeyValueUpdate.newBuilder().setKey(attributeKeys.get(i)).setOldValue(oldAttributes.get(i)).setNewValue(newAttributes.get(i)).build());
        }
        return CoeditOperation.UpdateAttributes.newBuilder().addAllChange(arrayList).build();
    }

    private static CoeditOperation.ReplaceAttributes convert(NoteOpReplaceAttributes noteOpReplaceAttributes) {
        if (noteOpReplaceAttributes == null) {
            return CoeditOperation.ReplaceAttributes.newBuilder().build();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> attributeKeys = noteOpReplaceAttributes.getAttributeKeys();
        List<String> oldAttributes = noteOpReplaceAttributes.getOldAttributes();
        List<String> newAttributes = noteOpReplaceAttributes.getNewAttributes();
        int size = attributeKeys.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(CoeditOperation.KeyValuePair.newBuilder().setKey(attributeKeys.get(i)).setValue(oldAttributes.get(i)).build());
            arrayList2.add(CoeditOperation.KeyValuePair.newBuilder().setKey(attributeKeys.get(i)).setValue(newAttributes.get(i)).build());
        }
        return CoeditOperation.ReplaceAttributes.newBuilder().addAllOldAttribute(arrayList).addAllNewAttribute(arrayList2).build();
    }

    private static CoeditOperation.ObjectSpan convert(Pair<String, String> pair) {
        if (pair == null) {
            return CoeditOperation.ObjectSpan.newBuilder().build();
        }
        return CoeditOperation.ObjectSpan.newBuilder().setObjectSpan(CoeditOperation.KeyValuePair.newBuilder().setKey((String) pair.first).setValue((String) pair.second).build()).build();
    }

    private static CoeditOperation.SetAnnotations convert(NoteOpSetAnnotations noteOpSetAnnotations) {
        if (noteOpSetAnnotations == null) {
            return CoeditOperation.SetAnnotations.newBuilder().build();
        }
        ArrayList arrayList = new ArrayList();
        Map<String, String> oldAnnotation = noteOpSetAnnotations.getOldAnnotation();
        Map<String, String> newAnnotation = noteOpSetAnnotations.getNewAnnotation();
        for (Map.Entry<String, String> entry : oldAnnotation.entrySet()) {
            arrayList.add(CoeditOperation.KeyValueUpdate.newBuilder().setKey(entry.getKey()).setOldValue(entry.getValue()).setNewValue(newAnnotation.get(entry.getKey())).build());
        }
        return CoeditOperation.SetAnnotations.newBuilder().setEndIndex(noteOpSetAnnotations.getEndIndex()).addAllAnnotation(arrayList).build();
    }
}
