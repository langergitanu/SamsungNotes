package com.samsung.android.sdk.pen.plugin.interfaces;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004EFGHJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0003H&J$\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001bH&J\b\u0010\u001e\u001a\u00020\u0003H&J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u001dH&J\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010%\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H&J\b\u0010&\u001a\u00020\u0003H&J$\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\n\u0010.\u001a\u0004\u0018\u00010)H&J\u0012\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010+H&J\u0012\u00101\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010+H&J\u0012\u00102\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010+H&J\u0018\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020#H&J\n\u00106\u001a\u0004\u0018\u00010\u0016H&J\b\u00107\u001a\u00020\u0003H&J\u0010\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\bH&J\u0010\u0010:\u001a\u00020\u00032\u0006\u00109\u001a\u00020\bH&J\n\u0010;\u001a\u0004\u0018\u00010)H&J\n\u0010<\u001a\u0004\u0018\u00010)H&J\u0016\u0010=\u001a\u00020\u00032\f\u0010>\u001a\b\u0012\u0004\u0012\u00020)0\u001bH&J\u0018\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020#H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020DH&¨\u0006I"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface;", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenPluginInterface;", "setRecognizerType", "", "type", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$RecognizerType;", "getRecognizerType", "setTextRecognitionType", "", "textType", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextType;", "getTextRecognitionType", "setTextRecognitionMode", "textMode", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextMode;", "getTextRecognitionMode", "addStroke", "stroke", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$SpenRecognizerResultListener;", "xdata", "", "ydata", "clearStrokes", "addHwrDataWith", "strokes", "", "strokeIdList", "", "clearHwrDataList", "recognize", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "sleepTime", "refX", "", "refY", "request", "cancel", "setLanguageData", "language", "", "languageData", "", "englishData", "setLanguage", "getLanguage", "setAnalyzerData", "data", "setLineSplitterData", "setMathData", "setDisplayMetrics", "xdpi", "ydpi", "getDisplayMetrics", "close", "setStrokeModeEnabled", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "setRefineHyperLinkMode", "getTextEngineVersion", "getRecognizerDBVersion", "setUserDictionary", "userWords", "setConfigurationItem", "configName", "configValue", "onLoadIgnoreInit", "context", "Landroid/content/Context;", "RecognizerType", "TextType", "TextMode", "SpenRecognizerResultListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenRecognizerInterface extends SpenPluginInterface {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$RecognizerType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "TEXT_EXTRACTOR", "SHAPE_EXTRACTOR", "TEXT", "SHAPE", "DOCUMENT", "TEXT_MULTILINE", "BEAUTIFIER_LAYOUT", "BEAUTIFIER_LINE_ALIGNMENT", "BEAUTIFIER_ALL", "toString", "", "value", "", "getValue", "()I", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RecognizerType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecognizerType[] $VALUES;
        public static final RecognizerType DEFAULT = new RecognizerType("DEFAULT", 0);
        public static final RecognizerType TEXT_EXTRACTOR = new RecognizerType("TEXT_EXTRACTOR", 1);
        public static final RecognizerType SHAPE_EXTRACTOR = new RecognizerType("SHAPE_EXTRACTOR", 2);
        public static final RecognizerType TEXT = new RecognizerType("TEXT", 3);
        public static final RecognizerType SHAPE = new RecognizerType("SHAPE", 4);
        public static final RecognizerType DOCUMENT = new RecognizerType("DOCUMENT", 5);
        public static final RecognizerType TEXT_MULTILINE = new RecognizerType("TEXT_MULTILINE", 6);
        public static final RecognizerType BEAUTIFIER_LAYOUT = new RecognizerType("BEAUTIFIER_LAYOUT", 7);
        public static final RecognizerType BEAUTIFIER_LINE_ALIGNMENT = new RecognizerType("BEAUTIFIER_LINE_ALIGNMENT", 8);
        public static final RecognizerType BEAUTIFIER_ALL = new RecognizerType("BEAUTIFIER_ALL", 9);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RecognizerType.values().length];
                try {
                    iArr[RecognizerType.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RecognizerType.TEXT_EXTRACTOR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RecognizerType.SHAPE_EXTRACTOR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RecognizerType.TEXT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RecognizerType.SHAPE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RecognizerType.DOCUMENT.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[RecognizerType.TEXT_MULTILINE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[RecognizerType.BEAUTIFIER_LAYOUT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[RecognizerType.BEAUTIFIER_LINE_ALIGNMENT.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[RecognizerType.BEAUTIFIER_ALL.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ RecognizerType[] $values() {
            return new RecognizerType[]{DEFAULT, TEXT_EXTRACTOR, SHAPE_EXTRACTOR, TEXT, SHAPE, DOCUMENT, TEXT_MULTILINE, BEAUTIFIER_LAYOUT, BEAUTIFIER_LINE_ALIGNMENT, BEAUTIFIER_ALL};
        }

        static {
            RecognizerType[] recognizerTypeArr$values = $values();
            $VALUES = recognizerTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(recognizerTypeArr$values);
        }

        private RecognizerType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RecognizerType> getEntries() {
            return $ENTRIES;
        }

        public static RecognizerType valueOf(String str) {
            return (RecognizerType) Enum.valueOf(RecognizerType.class, str);
        }

        public static RecognizerType[] values() {
            return (RecognizerType[]) $VALUES.clone();
        }

        public final int getValue() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                    return 4;
                case 6:
                    return 5;
                case 7:
                    return 6;
                case 8:
                    return 7;
                case 9:
                    return 8;
                case 10:
                    return 9;
                default:
                    return -1;
            }
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "All Extraction";
                case 2:
                    return "Text Extraction";
                case 3:
                    return "Shape Extraction";
                case 4:
                    return "Text Recognition";
                case 5:
                    return "Shape Recognition";
                case 6:
                    return "Document Recognition";
                case 7:
                    return "Text Multiline Recognition";
                case 8:
                    return "Beautifier Layout Recognition";
                case 9:
                    return "Beautifier Line Alignment Recognition";
                case 10:
                    return "Beautifier All Recognition";
                default:
                    return super.toString();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$SpenRecognizerResultListener;", "", "onResult", "", "status", "", "resultInterface", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface SpenRecognizerResultListener {
        void onResult(int status, @NotNull SpenRecognizerResultContainerInterface resultInterface);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextMode;", "", "<init>", "(Ljava/lang/String;I)V", "CHARACTER", "SINGLE_LINE", "MULTI_LINE", "OVERLAY", "toString", "", "value", "", "getValue", "()I", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TextMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TextMode[] $VALUES;
        public static final TextMode CHARACTER = new TextMode("CHARACTER", 0);
        public static final TextMode SINGLE_LINE = new TextMode("SINGLE_LINE", 1);
        public static final TextMode MULTI_LINE = new TextMode("MULTI_LINE", 2);
        public static final TextMode OVERLAY = new TextMode("OVERLAY", 3);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TextMode.values().length];
                try {
                    iArr[TextMode.CHARACTER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TextMode.SINGLE_LINE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TextMode.MULTI_LINE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TextMode.OVERLAY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ TextMode[] $values() {
            return new TextMode[]{CHARACTER, SINGLE_LINE, MULTI_LINE, OVERLAY};
        }

        static {
            TextMode[] textModeArr$values = $values();
            $VALUES = textModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(textModeArr$values);
        }

        private TextMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TextMode> getEntries() {
            return $ENTRIES;
        }

        public static TextMode valueOf(String str) {
            return (TextMode) Enum.valueOf(TextMode.class, str);
        }

        public static TextMode[] values() {
            return (TextMode[]) $VALUES.clone();
        }

        public final int getValue() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i != 3) {
                return i != 4 ? -1 : 3;
            }
            return 2;
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? super.toString() : "overlaid" : "mline" : "sline" : "char";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT_PLAIN", "TEXT_SYMBOL", "NUMBER", "ENTITY", "EMAIL", TextConst.ENTITY_TYPE_URL, "PHONE", "toString", "", "value", "", "getValue", "()I", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TextType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TextType[] $VALUES;
        public static final TextType TEXT_PLAIN = new TextType("TEXT_PLAIN", 0);
        public static final TextType TEXT_SYMBOL = new TextType("TEXT_SYMBOL", 1);
        public static final TextType NUMBER = new TextType("NUMBER", 2);
        public static final TextType ENTITY = new TextType("ENTITY", 3);
        public static final TextType EMAIL = new TextType("EMAIL", 4);
        public static final TextType URL = new TextType(TextConst.ENTITY_TYPE_URL, 5);
        public static final TextType PHONE = new TextType("PHONE", 6);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TextType.values().length];
                try {
                    iArr[TextType.TEXT_PLAIN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TextType.TEXT_SYMBOL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TextType.NUMBER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TextType.ENTITY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[TextType.EMAIL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[TextType.URL.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[TextType.PHONE.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ TextType[] $values() {
            return new TextType[]{TEXT_PLAIN, TEXT_SYMBOL, NUMBER, ENTITY, EMAIL, URL, PHONE};
        }

        static {
            TextType[] textTypeArr$values = $values();
            $VALUES = textTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(textTypeArr$values);
        }

        private TextType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TextType> getEntries() {
            return $ENTRIES;
        }

        public static TextType valueOf(String str) {
            return (TextType) Enum.valueOf(TextType.class, str);
        }

        public static TextType[] values() {
            return (TextType[]) $VALUES.clone();
        }

        public final int getValue() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return 0;
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 3;
                case 5:
                    return 4;
                case 6:
                    return 5;
                case 7:
                    return 6;
                default:
                    return -1;
            }
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return "text";
                case 2:
                    return "text_symbol";
                case 3:
                    return TextConst.KEY_PARAM_NUMBER;
                case 4:
                    return "entity";
                case 5:
                    return "email";
                case 6:
                    return "url";
                case 7:
                    return "phone";
                default:
                    return super.toString();
            }
        }
    }

    void addHwrDataWith(@NotNull List<SpenObjectStroke> strokes, @NotNull List<Integer> strokeIdList);

    void addStroke(@NotNull SpenObjectStroke stroke);

    void addStroke(@NotNull SpenObjectStroke stroke, @NotNull SpenRecognizerResultListener listener);

    void addStroke(@NotNull float[] xdata, @NotNull float[] ydata);

    void cancel();

    void clearHwrDataList();

    void clearStrokes();

    void close();

    @Nullable
    float[] getDisplayMetrics();

    @Nullable
    String getLanguage();

    @Nullable
    String getRecognizerDBVersion();

    @NotNull
    RecognizerType getRecognizerType();

    @Nullable
    String getTextEngineVersion();

    @NotNull
    TextMode getTextRecognitionMode();

    @NotNull
    TextType getTextRecognitionType();

    void onLoadIgnoreInit(@NotNull Context context);

    @Nullable
    SpenRecognizerResultContainerInterface recognize();

    @Nullable
    SpenRecognizerResultContainerInterface recognize(float refX, float refY);

    @Nullable
    SpenRecognizerResultContainerInterface recognize(int sleepTime);

    void request(@NotNull SpenRecognizerResultListener listener);

    void request(@NotNull SpenRecognizerResultListener listener, float refX, float refY);

    void setAnalyzerData(@Nullable byte[] data);

    void setConfigurationItem(@NotNull String configName, float configValue);

    void setDisplayMetrics(float xdpi, float ydpi);

    void setLanguage(@NotNull String language);

    void setLanguageData(@NotNull String language, @Nullable byte[] languageData, @Nullable byte[] englishData);

    void setLineSplitterData(@Nullable byte[] data);

    void setMathData(@Nullable byte[] data);

    void setRecognizerType(@NotNull RecognizerType type);

    void setRefineHyperLinkMode(boolean set);

    void setStrokeModeEnabled(boolean set);

    boolean setTextRecognitionMode(@NotNull TextMode textMode);

    boolean setTextRecognitionType(@NotNull TextType textType);

    void setUserDictionary(@NotNull List<String> userWords);
}
