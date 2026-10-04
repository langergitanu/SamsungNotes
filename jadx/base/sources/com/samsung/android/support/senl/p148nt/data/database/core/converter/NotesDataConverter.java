package com.samsung.android.support.senl.p148nt.data.database.core.converter;

import android.text.TextUtils;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDataConverter {
    @TypeConverter
    public static String byteToString(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : new String(bArr, StandardCharsets.UTF_8);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    @TypeConverter
    public static List<String> fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (List) new Gson().fromJson(str, new TypeToken<List<String>>() { // from class: com.samsung.android.support.senl.nt.data.database.core.converter.NotesDataConverter.1
        }.getType());
    }

    @TypeConverter
    public static Date fromTimestamp(Long l) {
        if (l == null) {
            return null;
        }
        return new Date(l.longValue());
    }

    @TypeConverter
    public static String stringListToJson(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new Gson().toJson(list);
    }

    @TypeConverter
    public static byte[] stringToByteArray(String str) {
        if (str == null) {
            str = "";
        }
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
