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
import com.samsung.android.support.senl.ntnl.coedit.util.XmlUtil;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class Deserializer {
    private static final String TAG = "Deserializer";

    private static NoteOpReplaceAttributes convert(CoeditOperation.ReplaceAttributes replaceAttributes) {
        NoteOpReplaceAttributes noteOpReplaceAttributes = new NoteOpReplaceAttributes();
        if (replaceAttributes == null) {
            return noteOpReplaceAttributes;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CoeditOperation.KeyValuePair keyValuePair : replaceAttributes.getOldAttributeList()) {
            arrayList.add(keyValuePair.getKey());
            arrayList2.add(keyValuePair.getValue());
        }
        noteOpReplaceAttributes.setOldAttributes(arrayList2);
        for (CoeditOperation.KeyValuePair keyValuePair2 : replaceAttributes.getNewAttributeList()) {
            int iIndexOf = arrayList.indexOf(keyValuePair2.getKey());
            if (iIndexOf < 0) {
                throw new IndexOutOfBoundsException("Key is not matched");
            }
            arrayList3.add(iIndexOf, keyValuePair2.getValue());
        }
        noteOpReplaceAttributes.setNewAttributes(arrayList3);
        return noteOpReplaceAttributes;
    }

    @NoteOpType
    private static int convertType(ChangeType changeType) {
        if (changeType == ChangeType.INSERT_CHARACTERS) {
            return 0;
        }
        if (changeType == ChangeType.DELETE_CHARACTERS) {
            return 1;
        }
        if (changeType == ChangeType.INSERT_ELEMENTS) {
            return 2;
        }
        if (changeType == ChangeType.DELETE_ELEMENTS) {
            return 3;
        }
        if (changeType == ChangeType.UPDATE_ATTRIBUTES) {
            return 4;
        }
        if (changeType == ChangeType.REPLACE_ATTRIBUTES) {
            return 5;
        }
        if (changeType == ChangeType.SET_ANNOTATIONS) {
            return 6;
        }
        if (changeType == ChangeType.INSERT_OBJECT_SPAN) {
            return 7;
        }
        if (changeType == ChangeType.DELETE_OBJECT_SPAN) {
            return 8;
        }
        return changeType == ChangeType.RETAIN ? 9 : -1;
    }

    public static List<NoteOp> deserialize(List<CoeditOperation> list) {
        List<List<CoeditOperation>> coeditOpsList = getCoeditOpsList(list);
        ArrayList arrayList = new ArrayList();
        for (List<CoeditOperation> list2 : coeditOpsList) {
            for (int i = 0; i < list2.size(); i++) {
                CoeditOperation coeditOperation2 = list2.get(i);
                if (coeditOperation2 != null) {
                    if (coeditOperation2.getChangeType() == ChangeType.INSERT_ELEMENTS) {
                        arrayList.add(deserializeInsertElement(list2, i));
                    } else if (coeditOperation2.getChangeType() == ChangeType.DELETE_ELEMENTS) {
                        arrayList.add(deserializeDeleteElement(list2, i));
                    } else {
                        arrayList.add(deserialize(coeditOperation2));
                    }
                }
            }
        }
        return arrayList;
    }

    private static NoteOp deserializeDeleteElement(List<CoeditOperation> list, int i) {
        NoteOp noteOpDeserialize;
        int nextDeletePageIndex = getNextDeletePageIndex(list, i);
        if (list.size() == nextDeletePageIndex) {
            noteOpDeserialize = deserialize(list.get(i));
        } else {
            NoteOp noteOpDeserialize2 = deserialize(list.get(nextDeletePageIndex));
            int i2 = nextDeletePageIndex - 1;
            int i4 = 1;
            while (i2 >= i) {
                CoeditOperation coeditOperation2 = list.get(i2);
                noteOpDeserialize2.addAllDeleteElements(i4, convert(coeditOperation2.getDeleteElements()));
                noteOpDeserialize2.setSize(coeditOperation2.getSize());
                list.remove(i2);
                i2--;
                i4++;
            }
            noteOpDeserialize = noteOpDeserialize2;
        }
        int i5 = 0;
        while (i5 < noteOpDeserialize.getDeleteElementsSize() - 1) {
            int i6 = i5 + 1;
            if (noteOpDeserialize.getDeleteElementName(i5).equals(noteOpDeserialize.getDeleteElementName(i6)) && !noteOpDeserialize.isDeleteElementEnd(i5) && noteOpDeserialize.isDeleteElementEnd(i6)) {
                noteOpDeserialize.setDeleteElementEnd(i5, true);
                noteOpDeserialize.removeDeleteElement(i6);
            }
            i5 = i6;
        }
        noteOpDeserialize.setXmlData(XmlUtil.getXmlString(noteOpDeserialize.getDeleteElements()));
        return noteOpDeserialize;
    }

    private static NoteOp deserializeInsertElement(List<CoeditOperation> list, int i) {
        NoteOp noteOpDeserialize;
        int nextInsertPageIndex = getNextInsertPageIndex(list, i);
        if (list.size() == nextInsertPageIndex) {
            noteOpDeserialize = deserialize(list.get(i));
        } else {
            NoteOp noteOpDeserialize2 = deserialize(list.get(i));
            int i2 = nextInsertPageIndex + 1;
            int i4 = i2;
            int i5 = 1;
            while (i4 < nextInsertPageIndex + 4) {
                noteOpDeserialize2.addAllInsertElements(i5, convert(list.get(i2).getInsertElements()));
                list.remove(i2);
                i4++;
                i5++;
            }
            noteOpDeserialize = noteOpDeserialize2;
        }
        int i6 = 0;
        while (i6 < noteOpDeserialize.getInsertElementsSize() - 1) {
            int i7 = i6 + 1;
            if (noteOpDeserialize.getInsertElementName(i6).equals(noteOpDeserialize.getInsertElementName(i7)) && !noteOpDeserialize.isInsertElementEnd(i6) && noteOpDeserialize.isInsertElementEnd(i7)) {
                noteOpDeserialize.setInsertElementEnd(i6, true);
                noteOpDeserialize.removeInsertElement(i7);
            }
            i6 = i7;
        }
        noteOpDeserialize.setXmlData(XmlUtil.getXmlString(noteOpDeserialize.getInsertElements()));
        return noteOpDeserialize;
    }

    private static List<List<CoeditOperation>> getCoeditOpsList(List<CoeditOperation> list) {
        ArrayList arrayList = new ArrayList();
        ChangeType changeType = ChangeType.UNRECOGNIZED;
        ArrayList arrayList2 = null;
        for (CoeditOperation coeditOperation2 : list) {
            if (changeType == ChangeType.UNRECOGNIZED || changeType != coeditOperation2.getChangeType()) {
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    arrayList.add(arrayList2);
                    arrayList2 = null;
                }
                changeType = coeditOperation2.getChangeType();
            }
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            arrayList2.add(coeditOperation2);
        }
        if (arrayList2 != null) {
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private static int getNextDeletePageIndex(List<CoeditOperation> list, int i) {
        boolean z;
        int index;
        int size = list.size();
        int i2 = i;
        while (true) {
            z = false;
            if (i2 >= list.size()) {
                i2 = i;
                break;
            }
            if (list.get(i2).getChangeType() == ChangeType.DELETE_ELEMENTS && list.get(i2).getDeleteElements().getElement(0).getTagName().equals("page")) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            for (int i4 = i + 1; i4 <= i2; i4++) {
                if (i4 <= 0 || (index = list.get(i4 - 1).getIndex() - list.get(i4).getIndex()) == 1 || index == 0) {
                }
            }
            return i2;
        }
        return size;
    }

    private static int getNextInsertPageIndex(List<CoeditOperation> list, int i) {
        int size = list.size();
        if (list.get(i).getInsertElements().getElement(0).getTagName().equals("page")) {
            for (int i2 = i + 1; i2 < i + 4; i2++) {
                if (list.size() > i2 && list.get(i2).getChangeType() == ChangeType.INSERT_ELEMENTS && list.get(i2).getIndex() - list.get(i2 - 1).getIndex() == 1) {
                }
            }
            return i;
        }
        return size;
    }

    private static NoteOp deserialize(CoeditOperation coeditOperation2) {
        NoteOp noteOp = new NoteOp();
        noteOp.setType(convertType(coeditOperation2.getChangeType()));
        noteOp.setPos(coeditOperation2.getIndex());
        noteOp.setSize(coeditOperation2.getSize());
        switch (noteOp.getType()) {
            case 0:
                noteOp.setInsertCharacters(coeditOperation2.getInsertCharacters());
                noteOp.setXmlData(noteOp.getInsertCharacters());
                return noteOp;
            case 1:
                noteOp.setDeleteCharacters(coeditOperation2.getDeleteCharacters());
                noteOp.setXmlData(noteOp.getDeleteCharacters());
                return noteOp;
            case 2:
                noteOp.setInsertElements(convert(coeditOperation2.getInsertElements()));
                noteOp.setXmlData(XmlUtil.getXmlString(noteOp.getInsertElements()));
                return noteOp;
            case 3:
                noteOp.setDeleteElements(convert(coeditOperation2.getDeleteElements()));
                noteOp.setXmlData(XmlUtil.getXmlString(noteOp.getDeleteElements()));
                return noteOp;
            case 4:
                noteOp.setUpdateAttributes(convert(coeditOperation2.getUpdateAttributes()));
                return noteOp;
            case 5:
                noteOp.setReplaceAttributes(convert(coeditOperation2.getReplaceAttributes()));
                return noteOp;
            case 6:
                noteOp.setSetAnnotations(convert(coeditOperation2.getSetAnnotations()));
                return noteOp;
            case 7:
                noteOp.setInsertObjectSpan(convert(coeditOperation2.getInsertObjectSpan()));
                return noteOp;
            case 8:
                noteOp.setDeleteObjectSpan(convert(coeditOperation2.getDeleteObjectSpan()));
                return noteOp;
            default:
                CoeditLogger.m8919d(TAG, "Unsupported type");
            case 9:
                return noteOp;
        }
    }

    private static NoteOpSetAnnotations convert(CoeditOperation.SetAnnotations setAnnotations) {
        NoteOpSetAnnotations noteOpSetAnnotations = new NoteOpSetAnnotations();
        if (setAnnotations == null) {
            return noteOpSetAnnotations;
        }
        noteOpSetAnnotations.setEndIndex(setAnnotations.getEndIndex());
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (CoeditOperation.KeyValueUpdate keyValueUpdate : setAnnotations.getAnnotationList()) {
            map.put(keyValueUpdate.getKey(), keyValueUpdate.getOldValue());
            map2.put(keyValueUpdate.getKey(), keyValueUpdate.getNewValue());
        }
        noteOpSetAnnotations.setOldAnnotation(map);
        noteOpSetAnnotations.setNewAnnotation(map2);
        return noteOpSetAnnotations;
    }

    private static Pair<String, String> convert(CoeditOperation.ObjectSpan objectSpan) {
        if (objectSpan == null) {
            return Pair.create("", "");
        }
        CoeditOperation.KeyValuePair objectSpan2 = objectSpan.getObjectSpan();
        return Pair.create(objectSpan2.getKey(), objectSpan2.getValue());
    }

    private static NoteOpUpdateAttributes convert(CoeditOperation.UpdateAttributes updateAttributes) {
        NoteOpUpdateAttributes noteOpUpdateAttributes = new NoteOpUpdateAttributes();
        if (updateAttributes == null) {
            return noteOpUpdateAttributes;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (CoeditOperation.KeyValueUpdate keyValueUpdate : updateAttributes.getChangeList()) {
            arrayList.add(keyValueUpdate.getKey());
            arrayList2.add(keyValueUpdate.getOldValue());
            arrayList3.add(keyValueUpdate.getNewValue());
        }
        noteOpUpdateAttributes.setAttributeKeys(arrayList);
        noteOpUpdateAttributes.setOldAttributes(arrayList2);
        noteOpUpdateAttributes.setNewAttributes(arrayList3);
        return noteOpUpdateAttributes;
    }

    private static List<Element> convert(CoeditOperation.Elements elements) {
        ArrayList arrayList = new ArrayList();
        if (elements != null) {
            for (CoeditOperation.Element element : elements.getElementList()) {
                Element element2 = new Element();
                element2.setName(element.getTagName());
                for (CoeditOperation.KeyValuePair keyValuePair : element.getAttributeList()) {
                    element2.addAttribute(keyValuePair.getKey(), keyValuePair.getValue());
                }
                element2.setEnd(element.getElementEnd());
                arrayList.add(element2);
            }
        }
        return arrayList;
    }
}
