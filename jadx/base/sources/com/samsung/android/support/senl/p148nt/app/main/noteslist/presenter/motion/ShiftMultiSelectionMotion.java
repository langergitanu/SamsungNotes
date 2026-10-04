package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.motion;

import android.text.TextUtils;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnShiftMultiSelectionListener;
import com.samsung.android.support.senl.p148nt.app.main.common.view.NotesPenRecyclerView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.DocumentMap;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.StateInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShiftMultiSelectionMotion {
    private final int LEFT = 0;
    private final int RIGHT = 1;
    private OnShiftMultiSelectionListener mOnShiftMultiSelectionListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ShiftMultiSelectionEventListener {
        DocumentMap getDocumentMap();

        NotesPenRecyclerView getNotesPenRecyclerView();

        StateInfo getStateInfo();

        void onSelectedItemPosition(ArrayList<Integer> arrayList, int i, int i2, int i4, boolean z);

        void selectAllNotes(boolean z);
    }

    public ShiftMultiSelectionMotion(final ShiftMultiSelectionEventListener shiftMultiSelectionEventListener) {
        this.mOnShiftMultiSelectionListener = new OnShiftMultiSelectionListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion.1
            private int[] makePenDragArea(int i, ShiftDragInfo shiftDragInfo, ShiftDragInfo shiftDragInfo2) {
                NotesPenRecyclerView notesPenRecyclerView = shiftMultiSelectionEventListener.getNotesPenRecyclerView();
                int[] iArr = new int[2];
                int subFoldersSpan = i / shiftMultiSelectionEventListener.getStateInfo().getSubFoldersSpan();
                boolean z = shiftDragInfo.isFolder;
                if (z && shiftDragInfo2.isFolder) {
                    int i2 = shiftDragInfo.holderItemPosition;
                    int i4 = shiftDragInfo2.holderItemPosition;
                    if (i2 > i4 || (i2 == i4 && shiftDragInfo.lineOfSpan > shiftDragInfo2.lineOfSpan)) {
                        iArr[0] = shiftDragInfo2.lineOfSpan * subFoldersSpan;
                        iArr[1] = subFoldersSpan * shiftDragInfo.lineOfSpan;
                        return iArr;
                    }
                    iArr[0] = shiftDragInfo.lineOfSpan * subFoldersSpan;
                    iArr[1] = subFoldersSpan * shiftDragInfo2.lineOfSpan;
                    return iArr;
                }
                if (shiftDragInfo2.isFolder) {
                    iArr[0] = subFoldersSpan * shiftDragInfo2.lineOfSpan;
                    iArr[1] = notesPenRecyclerView.getWidth();
                    return iArr;
                }
                if (z) {
                    iArr[0] = subFoldersSpan * shiftDragInfo.lineOfSpan;
                    iArr[1] = notesPenRecyclerView.getWidth();
                    return iArr;
                }
                iArr[0] = 0;
                iArr[1] = notesPenRecyclerView.getWidth();
                return iArr;
            }

            private ArrayList<Integer> makeSelectedItemPosition(int i, int i2) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (i <= i2) {
                    i = AbstractC1038a.m1200a(i, i, 1, arrayList);
                }
                return arrayList;
            }

            @Override // com.samsung.android.support.senl.p148nt.app.common.penrecyclerview.OnShiftMultiSelectionListener
            public void onSelcted(String str, int i, boolean z) {
                NotesPenRecyclerView notesPenRecyclerView = shiftMultiSelectionEventListener.getNotesPenRecyclerView();
                DocumentMap documentMap = shiftMultiSelectionEventListener.getDocumentMap();
                ShiftDragInfo shiftDragInfoMakeInfo = new ShiftDragInfo().makeInfo(documentMap, i, z, shiftMultiSelectionEventListener.getStateInfo().getSubFoldersSpan());
                ShiftDragInfo shiftDragInfoMakeInfo2 = new ShiftDragInfo().makeInfo(documentMap, str, shiftDragInfoMakeInfo.holderItemPosition);
                int width = notesPenRecyclerView.getWidth();
                int[] iArrMakePenDragArea = makePenDragArea(width, shiftDragInfoMakeInfo2, shiftDragInfoMakeInfo);
                notesPenRecyclerView.setLastClickedUuid(shiftDragInfoMakeInfo.uuid);
                shiftMultiSelectionEventListener.selectAllNotes(false);
                shiftMultiSelectionEventListener.onSelectedItemPosition(makeSelectedItemPosition(Math.min(shiftDragInfoMakeInfo2.holderItemPosition, shiftDragInfoMakeInfo.holderItemPosition), Math.max(shiftDragInfoMakeInfo2.holderItemPosition, shiftDragInfoMakeInfo.holderItemPosition)), width, iArrMakePenDragArea[0], iArrMakePenDragArea[1], false);
            }

            /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.motion.ShiftMultiSelectionMotion$1$ShiftDragInfo */
            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            public class ShiftDragInfo {
                public int holderItemPosition;
                public boolean isFolder;
                public int lineOfSpan;
                public String uuid;

                public ShiftDragInfo() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public ShiftDragInfo makeInfo(DocumentMap documentMap, int i, boolean z, int i2) {
                    int i4 = z ? i : i / i2;
                    this.holderItemPosition = i4;
                    this.isFolder = !z;
                    if (z) {
                        this.uuid = documentMap.getCommonDisplayData(i4).uuid;
                    } else {
                        NotesFolder notesFolder = documentMap.getCommonDisplayData(i / i2).folders.get(i % i2);
                        if (notesFolder != null) {
                            this.uuid = notesFolder.getUuid();
                        } else {
                            this.uuid = "";
                        }
                    }
                    this.lineOfSpan = documentMap.indexOfSpanSubFolderDisplayData(this.uuid);
                    return this;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public ShiftDragInfo makeInfo(DocumentMap documentMap, String str, int i) {
                    this.isFolder = documentMap.isDisplayedFolderData(str);
                    if (!TextUtils.isEmpty(str)) {
                        i = this.isFolder ? documentMap.indexOfSubFolderDisplayData(str) : documentMap.indexOfDisplayData(str);
                    }
                    this.holderItemPosition = i;
                    this.uuid = str;
                    this.lineOfSpan = documentMap.indexOfSpanSubFolderDisplayData(str);
                    return this;
                }
            }
        };
    }

    public OnShiftMultiSelectionListener getOnShiftMultiSelectionListener() {
        return this.mOnShiftMultiSelectionListener;
    }

    public void reset() {
        this.mOnShiftMultiSelectionListener = null;
    }
}
