package coeditOtMessage;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface ComposeRequestOrBuilder extends MessageLiteOrBuilder {
    IdxCedOpsPair getPairs(int i);

    int getPairsCount();

    List<IdxCedOpsPair> getPairsList();
}
