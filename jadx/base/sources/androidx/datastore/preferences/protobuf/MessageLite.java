package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder clear();

        /* JADX INFO: renamed from: clone */
        Builder mo21248clone();

        boolean mergeDelimitedFrom(InputStream inputStream);

        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(ByteString byteString);

        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(CodedInputStream codedInputStream);

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(MessageLite messageLite);

        Builder mergeFrom(InputStream inputStream);

        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(byte[] bArr);

        Builder mergeFrom(byte[] bArr, int i, int i2);

        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream outputStream);

    void writeTo(CodedOutputStream codedOutputStream);

    void writeTo(OutputStream outputStream);
}
