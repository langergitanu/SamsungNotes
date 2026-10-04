package com.fasterxml.jackson.core;

import com.microsoft.identity.client.internal.MsalUtils;
import org.slf4j.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class JsonStreamContext {
    protected static final int TYPE_ARRAY = 1;
    protected static final int TYPE_OBJECT = 2;
    protected static final int TYPE_ROOT = 0;
    protected int _index;
    protected int _type;

    public final int getCurrentIndex() {
        int i = this._index;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract String getCurrentName();

    public final int getEntryCount() {
        return this._index + 1;
    }

    public abstract JsonStreamContext getParent();

    public final String getTypeDesc() {
        int i = this._type;
        return i != 0 ? i != 1 ? i != 2 ? MsalUtils.QUERY_STRING_SYMBOL : "OBJECT" : "ARRAY" : Logger.ROOT_LOGGER_NAME;
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }
}
