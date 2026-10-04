package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonStreamContext;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class JsonWriteContext extends JsonStreamContext {
    public static final int STATUS_EXPECT_NAME = 5;
    public static final int STATUS_EXPECT_VALUE = 4;
    public static final int STATUS_OK_AFTER_COLON = 2;
    public static final int STATUS_OK_AFTER_COMMA = 1;
    public static final int STATUS_OK_AFTER_SPACE = 3;
    public static final int STATUS_OK_AS_IS = 0;
    protected JsonWriteContext _child = null;
    protected String _currentName;
    protected final JsonWriteContext _parent;

    public JsonWriteContext(int i, JsonWriteContext jsonWriteContext) {
        this._type = i;
        this._parent = jsonWriteContext;
        this._index = -1;
    }

    public static JsonWriteContext createRootContext() {
        return new JsonWriteContext(0, null);
    }

    private JsonWriteContext reset(int i) {
        this._type = i;
        this._index = -1;
        this._currentName = null;
        return this;
    }

    public final void appendDesc(StringBuilder sb) {
        int i = this._type;
        if (i != 2) {
            if (i != 1) {
                sb.append("/");
                return;
            }
            sb.append(PropertyUtils.INDEXED_DELIM);
            sb.append(getCurrentIndex());
            sb.append(PropertyUtils.INDEXED_DELIM2);
            return;
        }
        sb.append('{');
        if (this._currentName != null) {
            sb.append('\"');
            sb.append(this._currentName);
            sb.append('\"');
        } else {
            sb.append('?');
        }
        sb.append('}');
    }

    public final JsonWriteContext createChildArrayContext() {
        JsonWriteContext jsonWriteContext = this._child;
        if (jsonWriteContext != null) {
            return jsonWriteContext.reset(1);
        }
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(1, this);
        this._child = jsonWriteContext2;
        return jsonWriteContext2;
    }

    public final JsonWriteContext createChildObjectContext() {
        JsonWriteContext jsonWriteContext = this._child;
        if (jsonWriteContext != null) {
            return jsonWriteContext.reset(2);
        }
        JsonWriteContext jsonWriteContext2 = new JsonWriteContext(2, this);
        this._child = jsonWriteContext2;
        return jsonWriteContext2;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final String getCurrentName() {
        return this._currentName;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        appendDesc(sb);
        return sb.toString();
    }

    public final int writeFieldName(String str) {
        if (this._type != 2 || this._currentName != null) {
            return 4;
        }
        this._currentName = str;
        return this._index < 0 ? 0 : 1;
    }

    public final int writeValue() {
        int i = this._type;
        if (i == 2) {
            if (this._currentName == null) {
                return 5;
            }
            this._currentName = null;
            this._index++;
            return 2;
        }
        if (i == 1) {
            int i2 = this._index;
            this._index = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i4 = this._index + 1;
        this._index = i4;
        return i4 == 0 ? 0 : 3;
    }

    @Override // com.fasterxml.jackson.core.JsonStreamContext
    public final JsonWriteContext getParent() {
        return this._parent;
    }
}
