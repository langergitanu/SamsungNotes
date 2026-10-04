package com.fasterxml.jackson.core;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class JsonParseException extends JsonProcessingException {
    static final long serialVersionUID = 123;

    public JsonParseException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
    }

    public JsonParseException(String str, JsonLocation jsonLocation, Throwable th) {
        super(str, jsonLocation, th);
    }
}
