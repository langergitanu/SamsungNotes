package os_migration_data_types.p233v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface AttachmentMetaOrBuilder extends MessageLiteOrBuilder {
    String getAttachmentName();

    ByteString getAttachmentNameBytes();

    AttachmentType getAttachmentType();

    int getAttachmentTypeValue();

    String getAudioAttachmentId();

    ByteString getAudioAttachmentIdBytes();

    String getFileName();

    ByteString getFileNameBytes();

    String getNoteId();

    ByteString getNoteIdBytes();
}
