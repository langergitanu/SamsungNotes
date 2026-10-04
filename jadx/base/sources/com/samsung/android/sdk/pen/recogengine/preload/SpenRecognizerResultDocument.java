package com.samsung.android.sdk.pen.recogengine.preload;

import android.util.Log;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultInterface;
import com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000b\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n`\nX\u0082\u0004¢\u0006\u0002\n\u0000R~\u0010\r\u001ar\u00124\u00122\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n`\n0\bj8\u00124\u00122\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\n`\n`\nX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000e\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\bj\b\u0012\u0004\u0012\u00020\u000f`\n0\bj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\bj\b\u0012\u0004\u0012\u00020\u000f`\n`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResultDocument;", "Lcom/samsung/android/sdk/pen/recogengine/preload/SpenRecognizerResult;", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultDocumentInterface;", "result", "", "<init>", "(J)V", "mGroupType", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/recogengine/interfaces/SpenRecognizerResultDocumentInterface$GroupType;", "Lkotlin/collections/ArrayList;", "mGroupStroke", "", "mSubGroupStroke", "mSubGroupSkewed", "", "groupCount", "getGroupCount", "()I", "getGroupType", "groupID", "getGroupStroke", "", "getSubGroupCount", "getSubGroupStrokeCount", "subGroupID", "getSubGroupStroke", "isSubGroupSkewed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenRecognizerResultDocument extends SpenRecognizerResult implements SpenRecognizerResultDocumentInterface {

    @NotNull
    private static final String TAG;

    @NotNull
    private final ArrayList<ArrayList<Integer>> mGroupStroke;

    @NotNull
    private final ArrayList<SpenRecognizerResultDocumentInterface.GroupType> mGroupType;

    @NotNull
    private final ArrayList<ArrayList<Boolean>> mSubGroupSkewed;

    @NotNull
    private final ArrayList<ArrayList<ArrayList<Integer>>> mSubGroupStroke;

    static {
        Intrinsics.checkNotNullExpressionValue("SpenRecognizerResultDocument", "getSimpleName(...)");
        TAG = "SpenRecognizerResultDocument";
    }

    public SpenRecognizerResultDocument(long j) {
        super(j, SpenRecognizerResultInterface.ResultType.DOCUMENT);
        this.mGroupType = new ArrayList<>();
        this.mGroupStroke = new ArrayList<>();
        this.mSubGroupStroke = new ArrayList<>();
        this.mSubGroupSkewed = new ArrayList<>();
        if (j == 0) {
            Log.e(TAG, "parameter is null");
            throw new InvalidParameterException("parameter is null");
        }
        int iSPenRecognizerResultDocumentInterface_GetGroupCount = SpenRecognizerLib.SPenRecognizerResultDocumentInterface_GetGroupCount(j);
        for (int i = 0; i < iSPenRecognizerResultDocumentInterface_GetGroupCount; i++) {
            int iSPenRecognizerResultDocumentInterface_GetGroupType = SpenRecognizerLib.SPenRecognizerResultDocumentInterface_GetGroupType(j, i);
            this.mGroupType.add(SpenRecognizerResultDocumentInterface.GroupType.values()[iSPenRecognizerResultDocumentInterface_GetGroupType]);
            int[] iArrSPenRecognizerResultDocumentInterface_GetGroupStroke = SpenRecognizerLib.SPenRecognizerResultDocumentInterface_GetGroupStroke(j, i);
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (iArrSPenRecognizerResultDocumentInterface_GetGroupStroke != null) {
                int length = iArrSPenRecognizerResultDocumentInterface_GetGroupStroke.length;
                for (int iM1200a = 0; iM1200a < length; iM1200a = AbstractC1038a.m1200a(iArrSPenRecognizerResultDocumentInterface_GetGroupStroke[iM1200a], iM1200a, 1, arrayList)) {
                }
            }
            this.mGroupStroke.add(arrayList);
            if (iSPenRecognizerResultDocumentInterface_GetGroupType == 0) {
                int iSPenRecognizerResultDocumentInterface_GetSubGroupCount = SpenRecognizerLib.SPenRecognizerResultDocumentInterface_GetSubGroupCount(j, i);
                ArrayList<ArrayList<Integer>> arrayList2 = new ArrayList<>();
                ArrayList<Boolean> arrayList3 = new ArrayList<>();
                for (int i2 = 0; i2 < iSPenRecognizerResultDocumentInterface_GetSubGroupCount; i2++) {
                    int[] iArrSPenRecognizerResultDocumentInterface_GetSubGroupStroke = SpenRecognizerLib.SPenRecognizerResultDocumentInterface_GetSubGroupStroke(j, i, i2);
                    ArrayList<Integer> arrayList4 = new ArrayList<>();
                    if (iArrSPenRecognizerResultDocumentInterface_GetSubGroupStroke != null) {
                        int length2 = iArrSPenRecognizerResultDocumentInterface_GetSubGroupStroke.length;
                        for (int iM1200a2 = 0; iM1200a2 < length2; iM1200a2 = AbstractC1038a.m1200a(iArrSPenRecognizerResultDocumentInterface_GetSubGroupStroke[iM1200a2], iM1200a2, 1, arrayList4)) {
                        }
                    }
                    arrayList2.add(arrayList4);
                    arrayList3.add(Boolean.valueOf(SpenRecognizerLib.SPenRecognizerResultDocumentInterface_IsSubGroupSkewed(j, i, i2)));
                }
                this.mSubGroupStroke.add(arrayList2);
                this.mSubGroupSkewed.add(arrayList3);
            } else {
                this.mSubGroupStroke.add(new ArrayList<>());
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    public int getGroupCount() {
        checkResult(TAG);
        return this.mGroupType.size();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    @NotNull
    public List<Integer> getGroupStroke(int groupID) {
        String str = TAG;
        checkResult(str);
        int groupCount = getGroupCount();
        if (groupID < 0 || groupID >= groupCount) {
            Log.e(str, AbstractC0622a.m1164j(groupID, groupCount, "Index(", ") out of bound(0 ~ ", ")"));
            throw new InvalidParameterException(AbstractC0622a.m1164j(groupID, groupCount, "Index(", ") out of bound(0 ~ ", ")"));
        }
        ArrayList<Integer> arrayList = this.mGroupStroke.get(groupID);
        Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    @NotNull
    public SpenRecognizerResultDocumentInterface.GroupType getGroupType(int groupID) {
        String str = TAG;
        checkResult(str);
        int groupCount = getGroupCount();
        if (groupID < 0 || groupID >= groupCount) {
            Log.e(str, AbstractC0622a.m1164j(groupID, groupCount, "Index(", ") out of bound(0 ~ ", ")"));
            throw new InvalidParameterException(AbstractC0622a.m1164j(groupID, groupCount, "Index(", ") out of bound(0 ~ ", ")"));
        }
        SpenRecognizerResultDocumentInterface.GroupType groupType = this.mGroupType.get(groupID);
        Intrinsics.checkNotNullExpressionValue(groupType, "get(...)");
        return groupType;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    public int getSubGroupCount(int groupID) {
        String str = TAG;
        checkResult(str);
        int groupCount = getGroupCount();
        if (groupID >= 0 && groupID < groupCount) {
            return this.mSubGroupStroke.get(groupID).size();
        }
        Log.e(str, AbstractC0622a.m1164j(groupID, groupCount, "Index(", ") out of bound(0 ~ ", ")"));
        throw new InvalidParameterException(AbstractC0622a.m1164j(groupID, groupCount, "Index(", ") out of bound(0 ~ ", ")"));
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    @NotNull
    public List<Integer> getSubGroupStroke(int groupID, int subGroupID) {
        String str = TAG;
        checkResult(str);
        int subGroupCount = getSubGroupCount(groupID);
        if (subGroupID < 0 || subGroupID >= subGroupCount) {
            Log.e(str, AbstractC0622a.m1164j(groupID, subGroupCount, "Index(", ") out of bound(0 ~ ", ")"));
            throw new InvalidParameterException(AbstractC0622a.m1164j(subGroupID, subGroupCount, "SubGroup Index(", ") out of bound(0 ~ ", ")"));
        }
        ArrayList<Integer> arrayList = this.mSubGroupStroke.get(groupID).get(subGroupID);
        Intrinsics.checkNotNullExpressionValue(arrayList, "get(...)");
        return arrayList;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    public int getSubGroupStrokeCount(int groupID, int subGroupID) {
        String str = TAG;
        checkResult(str);
        int subGroupCount = getSubGroupCount(groupID);
        if (subGroupID >= 0 && subGroupID < subGroupCount) {
            return this.mSubGroupStroke.get(groupID).get(subGroupID).size();
        }
        Log.e(str, AbstractC0622a.m1164j(groupID, subGroupCount, "Index(", ") out of bound(0 ~ ", ")"));
        throw new InvalidParameterException(AbstractC0622a.m1164j(subGroupID, subGroupCount, "SubGroup Index(", ") out of bound(0 ~ ", ")"));
    }

    @Override // com.samsung.android.sdk.pen.recogengine.interfaces.SpenRecognizerResultDocumentInterface
    public boolean isSubGroupSkewed(int groupID, int subGroupID) {
        String str = TAG;
        checkResult(str);
        int subGroupCount = getSubGroupCount(groupID);
        if (subGroupID < 0 || subGroupID >= subGroupCount) {
            Log.e(str, AbstractC0622a.m1164j(groupID, subGroupCount, "Index(", ") out of bound(0 ~ ", ")"));
            throw new InvalidParameterException(AbstractC0622a.m1164j(subGroupID, subGroupCount, "SubGroup Index(", ") out of bound(0 ~ ", ")"));
        }
        Boolean bool = this.mSubGroupSkewed.get(groupID).get(subGroupID);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }
}
