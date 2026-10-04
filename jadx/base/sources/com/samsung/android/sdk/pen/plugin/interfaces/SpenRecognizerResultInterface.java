package com.samsung.android.sdk.pen.plugin.interfaces;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface;", "", "getResultType", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface$ResultType;", "ResultType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenRecognizerResultInterface {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultInterface$ResultType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "DOCUMENT", "SHAPE", "MATH", "CONTEXT", "BEAUTIFIER", "UNKNOWN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ResultType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResultType[] $VALUES;
        public static final ResultType TEXT = new ResultType("TEXT", 0);
        public static final ResultType DOCUMENT = new ResultType("DOCUMENT", 1);
        public static final ResultType SHAPE = new ResultType("SHAPE", 2);
        public static final ResultType MATH = new ResultType("MATH", 3);
        public static final ResultType CONTEXT = new ResultType("CONTEXT", 4);
        public static final ResultType BEAUTIFIER = new ResultType("BEAUTIFIER", 5);
        public static final ResultType UNKNOWN = new ResultType("UNKNOWN", 6);

        private static final /* synthetic */ ResultType[] $values() {
            return new ResultType[]{TEXT, DOCUMENT, SHAPE, MATH, CONTEXT, BEAUTIFIER, UNKNOWN};
        }

        static {
            ResultType[] resultTypeArr$values = $values();
            $VALUES = resultTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(resultTypeArr$values);
        }

        private ResultType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ResultType> getEntries() {
            return $ENTRIES;
        }

        public static ResultType valueOf(String str) {
            return (ResultType) Enum.valueOf(ResultType.class, str);
        }

        public static ResultType[] values() {
            return (ResultType[]) $VALUES.clone();
        }
    }

    @NotNull
    ResultType getResultType();
}
