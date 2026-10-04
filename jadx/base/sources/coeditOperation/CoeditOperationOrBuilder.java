package coeditOperation;

import coeditOperation.CoeditOperation;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface CoeditOperationOrBuilder extends MessageLiteOrBuilder {
    ChangeType getChangeType();

    int getChangeTypeValue();

    String getDeleteCharacters();

    ByteString getDeleteCharactersBytes();

    CoeditOperation.Elements getDeleteElements();

    CoeditOperation.ObjectSpan getDeleteObjectSpan();

    int getIndex();

    String getInsertCharacters();

    ByteString getInsertCharactersBytes();

    CoeditOperation.Elements getInsertElements();

    CoeditOperation.ObjectSpan getInsertObjectSpan();

    CoeditOperation.ReplaceAttributes getReplaceAttributes();

    CoeditOperation.SetAnnotations getSetAnnotations();

    int getSize();

    CoeditOperation.UpdateAttributes getUpdateAttributes();

    boolean hasDeleteElements();

    boolean hasDeleteObjectSpan();

    boolean hasInsertElements();

    boolean hasInsertObjectSpan();

    boolean hasReplaceAttributes();

    boolean hasSetAnnotations();

    boolean hasUpdateAttributes();
}
