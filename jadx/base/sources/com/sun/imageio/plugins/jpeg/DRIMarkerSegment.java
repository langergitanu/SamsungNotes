package com.sun.imageio.plugins.jpeg;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DRIMarkerSegment extends MarkerSegment {
    int restartInterval;

    public DRIMarkerSegment(JPEGBuffer jPEGBuffer) {
        super(jPEGBuffer);
        this.restartInterval = 0;
        byte[] bArr = jPEGBuffer.buf;
        int i = jPEGBuffer.bufPtr;
        int i2 = i + 1;
        jPEGBuffer.bufPtr = i2;
        int i4 = (bArr[i] & 255) << 8;
        this.restartInterval = i4;
        jPEGBuffer.bufPtr = i + 2;
        this.restartInterval = (bArr[i2] & 255) | i4;
        jPEGBuffer.bufAvail -= this.length;
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public IIOMetadataNode getNativeNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("dri");
        iIOMetadataNode.setAttribute(MicrosoftAuthorizationResponse.INTERVAL, Integer.toString(this.restartInterval));
        return iIOMetadataNode;
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void print() {
        printTag("DRI");
        System.out.println("Interval: " + Integer.toString(this.restartInterval));
    }

    public void updateFromNativeNode(Node node, boolean z) {
        this.restartInterval = MarkerSegment.getAttributeValue(node, null, MicrosoftAuthorizationResponse.INTERVAL, 0, 65535, true);
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void write(ImageOutputStream imageOutputStream) {
    }

    public DRIMarkerSegment(Node node) {
        super(JPEG.DRI);
        this.restartInterval = 0;
        updateFromNativeNode(node, true);
    }
}
