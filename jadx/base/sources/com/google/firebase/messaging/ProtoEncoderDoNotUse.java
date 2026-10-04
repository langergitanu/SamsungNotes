package com.google.firebase.messaging;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Encodable
public abstract class ProtoEncoderDoNotUse {
    private static final ProtobufEncoder ENCODER = ProtobufEncoder.builder().configureWith(AutoProtoEncoderDoNotUseEncoder.CONFIG).build();

    private ProtoEncoderDoNotUse() {
    }

    public static byte[] encode(Object obj) {
        return ENCODER.encode(obj);
    }

    public abstract MessagingClientEventExtension getMessagingClientEventExtension();

    public static void encode(Object obj, OutputStream outputStream) {
        ENCODER.encode(obj, outputStream);
    }
}
