package io.netty.handler.codec.marshalling;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ContextBoundUnmarshallerProvider extends DefaultUnmarshallerProvider {
    private static final AttributeKey<Unmarshaller> UNMARSHALLER = AttributeKey.valueOf(ContextBoundUnmarshallerProvider.class, "UNMARSHALLER");

    public ContextBoundUnmarshallerProvider(MarshallerFactory marshallerFactory, MarshallingConfiguration marshallingConfiguration) {
        super(marshallerFactory, marshallingConfiguration);
    }

    @Override // io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider, io.netty.handler.codec.marshalling.UnmarshallerProvider
    public Unmarshaller getUnmarshaller(ChannelHandlerContext channelHandlerContext) {
        Attribute attributeAttr = channelHandlerContext.channel().attr(UNMARSHALLER);
        Unmarshaller unmarshaller = (Unmarshaller) attributeAttr.get();
        if (unmarshaller != null) {
            return unmarshaller;
        }
        Unmarshaller unmarshaller2 = super.getUnmarshaller(channelHandlerContext);
        attributeAttr.set(unmarshaller2);
        return unmarshaller2;
    }
}
