package os_migration_data_types.p233v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public interface NoteMetaOrBuilder extends MessageLiteOrBuilder {
    long getCreationDateMillisSinceEpoch();

    String getFolderPath();

    ByteString getFolderPathBytes();

    String getId();

    ByteString getIdBytes();

    boolean getIsCloudSynced();

    long getLastModifiedDateMillisSinceEpoch();

    String getTags(int i);

    ByteString getTagsBytes(int i);

    int getTagsCount();

    List<String> getTagsList();

    String getTitle();

    ByteString getTitleBytes();
}
