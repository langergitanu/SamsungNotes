package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.parse.KeyParser;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: renamed from: androidx.constraintlayout.core.motion.parse.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2295a implements KeyParser.Ids, KeyParser.DataType {
    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.DataType
    public int get(int i) {
        return TypedValues.Attributes.getType(i);
    }

    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
    public int get(String str) {
        return TypedValues.Attributes.getId(str);
    }
}
