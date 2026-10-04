package com.samsung.android.support.senl.p148nt.coedit.connection.grpc.util;

import coeditOperation.CoeditOperation;
import com.samsung.android.support.senl.ntnl.coedit.domain.operation.NoteOp;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ProtoBufUtils {
    public static List<NoteOp> deserialize(List<CoeditOperation> list) {
        return Deserializer.deserialize(list);
    }

    public static List<CoeditOperation> serialize(List<NoteOp> list) {
        return Serializer.serialize(list);
    }
}
