package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.util.Map;

/* JADX INFO: renamed from: com.google.firebase.encoders.proto.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5968a implements ObjectEncoder {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3500a;

    public /* synthetic */ C5968a(int i) {
        this.f3500a = i;
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
        switch (this.f3500a) {
            case 0:
                ProtobufDataEncoderContext.lambda$static$0((Map.Entry) obj, objectEncoderContext);
                break;
            default:
                ProtobufEncoder.Builder.lambda$static$0(obj, objectEncoderContext);
                break;
        }
    }
}
