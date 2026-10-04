package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpContent;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface InterfaceHttpPostRequestDecoder {
    void cleanFiles();

    InterfaceHttpData currentPartialHttpData();

    void destroy();

    InterfaceHttpData getBodyHttpData(String str);

    List<InterfaceHttpData> getBodyHttpDatas();

    List<InterfaceHttpData> getBodyHttpDatas(String str);

    int getDiscardThreshold();

    boolean hasNext();

    boolean isMultipart();

    InterfaceHttpData next();

    InterfaceHttpPostRequestDecoder offer(HttpContent httpContent);

    void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData);

    void setDiscardThreshold(int i);
}
