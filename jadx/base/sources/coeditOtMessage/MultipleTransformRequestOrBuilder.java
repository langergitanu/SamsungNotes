package coeditOtMessage;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface MultipleTransformRequestOrBuilder extends MessageLiteOrBuilder {
    IdxCedOpsPair getFirst(int i);

    int getFirstCount();

    List<IdxCedOpsPair> getFirstList();

    IdxCedOpsPair getSecond();

    boolean hasSecond();
}
