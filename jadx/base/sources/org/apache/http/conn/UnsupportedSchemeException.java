package org.apache.http.conn;

import java.io.IOException;
import org.apache.http.annotation.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Immutable
public class UnsupportedSchemeException extends IOException {
    private static final long serialVersionUID = 3597127619218687636L;

    public UnsupportedSchemeException(String str) {
        super(str);
    }
}
