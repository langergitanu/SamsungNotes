package org.apache.http.p225io;

import org.apache.http.HttpMessage;
import org.apache.http.config.MessageConstraints;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface HttpMessageParserFactory<T extends HttpMessage> {
    HttpMessageParser create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints);
}
