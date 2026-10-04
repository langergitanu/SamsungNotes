package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import androidx.collection.AbstractC0622a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.Common;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HolderInfoMap {
    private static final String TAG = "HolderInfoMap";
    private final StateInfo mStateInfo;
    private final Map<Integer, Integer> mHolderInfoMap = new LinkedHashMap();
    private final Map<SyncInfoMap, Boolean> mSyncInfoMap = new LinkedHashMap();

    public HolderInfoMap(StateInfo stateInfo) {
        this.mStateInfo = stateInfo;
    }

    private boolean canDeleteConvertedNotesMessage() {
        return FeatureUtils.isOldMode(this.mStateInfo.getModeIndex());
    }

    private boolean canRecyclebinMessage() {
        return FeatureUtils.isRecyclebinMode(this.mStateInfo.getModeIndex());
    }

    private boolean canSearchFilter() {
        return FeatureUtils.isSearchMode(this.mStateInfo.getModeIndex());
    }

    private boolean canShowSyncProgressBar() {
        return FeatureUtils.canShowSyncProgressBar(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeSyncProgressInfoMap$0(long j, SyncInfoMap syncInfoMap) {
        return syncInfoMap.getSyncProgressId() == j;
    }

    private boolean needRecognizedCardVisible() {
        return FeatureUtils.canShowSOMRecognizedCard(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid());
    }

    private boolean needSyncProgressBarVisible() {
        return FeatureUtils.needToShowSyncProgressBar(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid());
    }

    public void clearSyncProgressInfoMap() {
        MainLogger.m7254d(TAG, "clearSyncProgressInfoMap");
        this.mSyncInfoMap.clear();
    }

    public int getHolderInfoCount(int i) {
        if (this.mHolderInfoMap.containsKey(Integer.valueOf(i))) {
            return this.mHolderInfoMap.get(Integer.valueOf(i)).intValue();
        }
        return 0;
    }

    public int getHolderInfoDisplayedCount() {
        int i = 0;
        int holderInfoCount = (hasHolderInfo(9) ? 1 : 0) + (hasHolderInfo(8) ? 1 : 0) + (hasHolderInfo(7) ? 1 : 0) + (hasHolderInfo(5) ? 1 : 0) + (hasHolderInfo(4) ? 1 : 0) + (hasHolderInfo(3) ? 1 : 0) + (hasHolderInfo(1) ? 1 : 0) + (hasHolderInfo(0) ? 1 : 0) + (hasHolderInfo(6) ? getHolderInfoCount(6) : 0) + ((hasHolderInfo(10) && needSyncProgressBarVisible()) ? 1 : 0);
        if (hasHolderInfo(2) && needRecognizedCardVisible()) {
            i = 1;
        }
        return (hasHolderInfo(11) ? 1 : 0) + (hasHolderInfo(14) ? 1 : 0) + (hasHolderInfo(13) ? 1 : 0) + (hasHolderInfo(12) ? 1 : 0) + holderInfoCount + i;
    }

    public List<Common> getRelatedTagDisplayData() {
        putHolderInfoMap(9, true);
        MainLogger.m7254d(TAG, "getRelatedTagDisplayData# selected tag size : " + this.mStateInfo.getSelectedTags().size());
        return Collections.singletonList(new Common.HashTag(-17L, this.mStateInfo.getSelectedTags()));
    }

    public boolean hasHolderInfo(int i) {
        return this.mHolderInfoMap.containsKey(Integer.valueOf(i)) && this.mHolderInfoMap.get(Integer.valueOf(i)).intValue() > 0;
    }

    public int indexOfHolderInfoMap(List<Common> list, int i) {
        if (list == null) {
            return -1;
        }
        if (i == 3 || i == 4) {
            if (!this.mStateInfo.isGcsSpaceMode()) {
                return -1;
            }
        } else if (i == 2) {
            if (!needRecognizedCardVisible()) {
                return -1;
            }
        } else if (i == 10) {
            if (!canShowSyncProgressBar()) {
                return -1;
            }
        } else if (i == 13) {
            if (!canRecyclebinMessage()) {
                return -1;
            }
        } else if (i == 14) {
            if (!canDeleteConvertedNotesMessage()) {
                return -1;
            }
        } else if (i == 6) {
            if (FeatureUtils.isSearchMode(this.mStateInfo.getModeIndex())) {
                return -1;
            }
        } else if (i == 11) {
            if (!canSearchFilter()) {
                return -1;
            }
        } else if ((i == 7 || i == 8) && !FeatureUtils.isSearchMode(this.mStateInfo.getModeIndex())) {
            return -1;
        }
        int holderType = FeatureUtils.getHolderType(i);
        int size = list.size();
        int length = FeatureUtils.getTopHolderInfoMapOrder().length;
        if (length > i) {
            size = Math.min(length, size);
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2).type == holderType) {
                return i2;
            }
        }
        return -1;
    }

    public int indexOfSortTopHolder(List<Common> list, int i) {
        if (list == null) {
            return -1;
        }
        int iIndexOfHolderInfoMap = indexOfHolderInfoMap(list, i);
        if (hasHolderInfo(i) && iIndexOfHolderInfoMap == -1) {
            int i2 = 0;
            for (int i4 : FeatureUtils.getTopHolderInfoMapOrder()) {
                if (i4 == i) {
                    return i2;
                }
                i2 += indexOfHolderInfoMap(list, i4) == -1 ? 0 : 1;
            }
        }
        return iIndexOfHolderInfoMap;
    }

    public void initHolderInfoMap() {
        for (Integer num : this.mHolderInfoMap.keySet()) {
            int iIntValue = num.intValue();
            if (iIntValue != 0 && iIntValue != 1 && iIntValue != 13 && this.mHolderInfoMap.containsKey(num) && (iIntValue != 2 || !needRecognizedCardVisible())) {
                if (iIntValue != 10 || !needSyncProgressBarVisible()) {
                    if (iIntValue != 11 || !canSearchFilter()) {
                        this.mHolderInfoMap.put(num, 0);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0061, code lost:
    
        if (8 == r5) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void putHolderInfoMap(int i, boolean z) {
        ?? r6;
        int iIntValue = 1;
        if (i == 0) {
            r6 = (z && FeatureUtils.needToShowSSMProgressBar(this.mStateInfo.getModeIndex(), this.mStateInfo.getFolderUuid())) ? 1 : 0;
        } else if (2 == i) {
            if (!z || !needRecognizedCardVisible()) {
            }
        } else if (10 == i) {
            if (!z || !needSyncProgressBarVisible()) {
            }
        } else if (11 == i) {
            if (!z || !canSearchFilter()) {
            }
        } else if (13 == i) {
            if (!z || !canRecyclebinMessage()) {
            }
        } else if (14 != i) {
            if (7 != i) {
                r6 = z;
            }
            if (!z || !this.mStateInfo.isSearchMode()) {
            }
        } else if (!z || !canDeleteConvertedNotesMessage()) {
        }
        MainLogger.m7254d(TAG, "putHolderInfoMap# holderType : " + i + ", show : " + ((boolean) r6));
        if (6 != i) {
            this.mHolderInfoMap.put(Integer.valueOf(i), Integer.valueOf((int) r6));
            return;
        }
        if (FeatureUtils.isSearchMode(this.mStateInfo.getModeIndex())) {
            this.mHolderInfoMap.put(Integer.valueOf(i), 0);
            return;
        }
        if (this.mHolderInfoMap.containsKey(Integer.valueOf(i))) {
            iIntValue = this.mHolderInfoMap.get(Integer.valueOf(i)).intValue() + r6;
        } else if (r6 == 0) {
            iIntValue = 0;
        }
        this.mHolderInfoMap.put(Integer.valueOf(i), Integer.valueOf(iIntValue));
    }

    public void putSyncProgressInfoMap(long j) {
        Iterator<SyncInfoMap> it = this.mSyncInfoMap.keySet().iterator();
        while (it.hasNext()) {
            if (it.next().getSyncProgressId() == j) {
                return;
            }
        }
        MainLogger.m7254d(TAG, "putSyncProgressInfoMap# syncProgressId : " + j);
        this.mSyncInfoMap.put(new SyncInfoMap(j), Boolean.TRUE);
    }

    public void removeHolderInfoMap(int i) {
        AbstractC6670b.m4736A(i, "removeHolderInfoMap# holderType : ", TAG);
        this.mHolderInfoMap.remove(Integer.valueOf(i));
    }

    public void removeSyncProgressInfoMap(long j) {
        MainLogger.m7254d(TAG, "removeSyncProgressInfoMap# syncProgressId : " + j);
        this.mSyncInfoMap.keySet().removeIf(new C8365a(j, 0));
    }

    public void setSyncProgressInfoCount(long j, int i) {
        for (SyncInfoMap syncInfoMap : this.mSyncInfoMap.keySet()) {
            if (syncInfoMap.getSyncProgressId() == j) {
                syncInfoMap.setSyncNoteCount(i);
            }
        }
    }

    public int sortTopHolderDisplayList(List<Common> list, int i) {
        if (list == null) {
            return -1;
        }
        int iIndexOfHolderInfoMap = indexOfHolderInfoMap(list, i);
        boolean zHasHolderInfo = hasHolderInfo(i);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, iIndexOfHolderInfoMap, "sortTopHolderDisplayList# holderType : ", " , index : ", ", hasHolderInfo : ");
        sbM1173s.append(zHasHolderInfo);
        MainLogger.m7258i(TAG, sbM1173s.toString());
        if (zHasHolderInfo) {
            if (iIndexOfHolderInfoMap == -1) {
                int i2 = 0;
                for (int i4 : FeatureUtils.getTopHolderInfoMapOrder()) {
                    if (i4 == i) {
                        if (i == 10) {
                            for (SyncInfoMap syncInfoMap : this.mSyncInfoMap.keySet()) {
                                list.add(i2, new Common.SyncProgressBar(syncInfoMap.getSyncProgressId(), syncInfoMap.getSyncNoteCount()));
                            }
                            return i2;
                        }
                        if (i == 13) {
                            list.add(i2, new Common.RecyclebinMessage());
                            return i2;
                        }
                        if (i == 14) {
                            list.add(i2, new Common.DeleteConvertedNotesMessage());
                            return i2;
                        }
                        if (i == 11) {
                            list.add(i2, new Common.SearchFilter());
                            return i2;
                        }
                        list.add(i2, new Common(FeatureUtils.getHolderType(i4)));
                        return i2;
                    }
                    i2 += indexOfHolderInfoMap(list, i4) == -1 ? 0 : 1;
                }
            }
        } else if (iIndexOfHolderInfoMap != -1) {
            list.remove(iIndexOfHolderInfoMap);
        }
        return iIndexOfHolderInfoMap;
    }
}
