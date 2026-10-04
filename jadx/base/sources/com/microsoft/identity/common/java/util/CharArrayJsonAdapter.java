package com.microsoft.identity.common.java.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CharArrayJsonAdapter extends TypeAdapter<char[]> {
    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
    public char[] read2(JsonReader jsonReader) {
        return jsonReader.nextString().toCharArray();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, char[] cArr) {
        jsonWriter.value(new String(cArr));
    }
}
