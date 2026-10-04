package com.samsung.android.sdk.pen.recogengine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerResultContainerInterface;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b$\u0018\u0000 m2\u00020\u0001:\u0005ijklmB\u001d\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0007J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)J\u0010\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u000102J\u0018\u00100\u001a\u00020\u00162\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u000204J\u001a\u00100\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000106J\u0006\u00108\u001a\u00020\u0016J\"\u00109\u001a\u00020\u00162\f\u0010:\u001a\b\u0012\u0004\u0012\u0002020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0;J\u0006\u0010>\u001a\u00020\u0016J\u0010\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020=J\b\u0010?\u001a\u0004\u0018\u00010@J\u0018\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CJ\u0010\u0010E\u001a\u00020\u00162\u0006\u00103\u001a\u00020FH\u0007J\u000e\u0010E\u001a\u00020\u00162\u0006\u00103\u001a\u000204J \u0010E\u001a\u00020\u00162\u0006\u00103\u001a\u00020F2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0007J\u001e\u0010E\u001a\u00020\u00162\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CJ\u0006\u0010G\u001a\u00020\u0016J\"\u0010H\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010JJ\u0010\u0010L\u001a\u00020\u00162\b\u0010M\u001a\u0004\u0018\u00010JJ\u0010\u0010N\u001a\u00020\u00162\b\u0010M\u001a\u0004\u0018\u00010JJ\u0010\u0010O\u001a\u00020\u00162\b\u0010M\u001a\u0004\u0018\u00010JJ\u0016\u0010P\u001a\u00020\u00162\u0006\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020CJ\u0006\u0010V\u001a\u00020\u0016J\u000e\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u0005J\u0014\u0010b\u001a\u00020\u00162\f\u0010c\u001a\b\u0012\u0004\u0012\u00020+0;J\u0016\u0010d\u001a\u00020\u00162\u0006\u0010e\u001a\u00020+2\u0006\u0010f\u001a\u00020CJ\b\u0010g\u001a\u00020\u0016H\u0002J\b\u0010h\u001a\u00020\u0016H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u001f\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b \u0010!R(\u0010*\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0013\u0010S\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0013\u0010Z\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b[\u0010-R\u0013\u0010\\\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b]\u0010-R\u0013\u0010^\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\b_\u0010-R\u0013\u0010`\u001a\u0004\u0018\u00010+8F¢\u0006\u0006\u001a\u0004\ba\u0010-¨\u0006n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer;", "", "context", "Landroid/content/Context;", "createPluginObject", "", "<init>", "(Landroid/content/Context;Z)V", "pluginObject", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface;", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface;)V", "mContext", "getPluginObject", "()Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface;", "setPluginObject", "(Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface;)V", "value", "Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider;", "resourceProvider", "getResourceProvider", "()Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider;", "createResourceProvider", "", ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, "Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider$EngineType;", "resourceType", "Lcom/samsung/android/sdk/pen/recogengine/SpenResourceProvider$ResourceType;", "setRecognizerType", "type", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$RecognizerType;", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$RecognizerType;", "recognizerType", "getRecognizerType", "()Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$RecognizerType;", "setTextRecognionType", "textType", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$TextType;", "setTextRecognitionType", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextType;", "setTextRecognitionMode", "textMode", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextMode;", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "addStroke", "stroke", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$ResultListener;", "xdata", "", "ydata", "clearStrokes", "addHwrDataWith", "strokes", "", "strokeIdList", "", "clearHwrDataList", "recognize", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "sleepTime", "refX", "", "refY", "request", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerInterface$SpenRecognizerResultListener;", "cancel", "setLanguageData", "languageData", "", "englishData", "setAnalyzerData", "data", "setLineSplitterData", "setMathData", "setDisplayMetrics", "xdpi", "ydpi", "displayMetrics", "getDisplayMetrics", "()[F", "close", "setStrokeModeEnabled", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "setRefineHyperLinkMode", "textEngineVersion", "getTextEngineVersion", "recognizerDBVersion", "getRecognizerDBVersion", "recognizerDBVersionByHash", "getRecognizerDBVersionByHash", "recognizerDBVersionByHashFully", "getRecognizerDBVersionByHashFully", "setUserDictionary", "userWords", "setConfigurationItem", "configName", "configValue", "checkPluginObject", "checkResourceProvider", "RecognizerType", "TextType", "TextMode", "ResultListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenRecognizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenRecognizer.kt\ncom/samsung/android/sdk/pen/recogengine/SpenRecognizer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,957:1\n1#2:958\n*E\n"})
public final class SpenRecognizer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SpenRecognizer";

    @Nullable
    private Context mContext;

    @Nullable
    private SpenRecognizerInterface pluginObject;

    @Nullable
    private SpenResourceProvider resourceProvider;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getSupportedLanguage", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)[Ljava/lang/String;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = " ")
        @JvmStatic
        @Nullable
        public final String[] getSupportedLanguage(@Nullable Context context) {
            Log.d(SpenRecognizer.TAG, "getSupportedLanguage by static");
            return new SpenResourceProvider(context, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK).getSupportedLanguages();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$RecognizerType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "TEXT_EXTRACTOR", "SHAPE_EXTRACTOR", "TEXT", "SHAPE", "DOCUMENT", "TEXT_MULTILINE", "BEAUTIFIER_LAYOUT", "BEAUTIFIER_LINE_ALIGNMENT", "BEAUTIFIER_ALL", "toString", "", "value", "", "getValue", "()I", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
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
                    throw new NoWhenBranchMatchedException();
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
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$ResultListener;", "", "onResult", "", "status", "", "resultInterface", "Lcom/samsung/android/sdk/pen/plugin/interfaces/SpenRecognizerResultContainerInterface;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface ResultListener {
        void onResult(int status, @Nullable SpenRecognizerResultContainerInterface resultInterface);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextMode;", "", "<init>", "(Ljava/lang/String;I)V", "CHARACTER", "SINGLE_LINE", "MULTI_LINE", "OVERLAY", "toString", "", "value", "", "getValue", "()I", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TextMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TextMode[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final TextMode CHARACTER = new TextMode("CHARACTER", 0);
        public static final TextMode SINGLE_LINE = new TextMode("SINGLE_LINE", 1);
        public static final TextMode MULTI_LINE = new TextMode("MULTI_LINE", 2);
        public static final TextMode OVERLAY = new TextMode("OVERLAY", 3);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextMode$Companion;", "", "<init>", "()V", "getValues", "", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextMode;", "()[Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextMode;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final TextMode[] getValues() {
                return TextMode.values();
            }

            private Companion() {
            }
        }

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
            INSTANCE = new Companion(null);
        }

        private TextMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TextMode> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        @NotNull
        public static final TextMode[] getValues() {
            return INSTANCE.getValues();
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
            if (i == 3) {
                return 2;
            }
            if (i == 4) {
                return 3;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // java.lang.Enum
        @NotNull
        public String toString() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return "char";
            }
            if (i == 2) {
                return "sline";
            }
            if (i == 3) {
                return "mline";
            }
            if (i == 4) {
                return "overlaid";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT_PLAIN", "TEXT_SYMBOL", "NUMBER", "ENTITY", "EMAIL", TextConst.ENTITY_TYPE_URL, "PHONE", "toString", "", "value", "", "getValue", "()I", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class TextType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TextType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final TextType TEXT_PLAIN = new TextType("TEXT_PLAIN", 0);
        public static final TextType TEXT_SYMBOL = new TextType("TEXT_SYMBOL", 1);
        public static final TextType NUMBER = new TextType("NUMBER", 2);
        public static final TextType ENTITY = new TextType("ENTITY", 3);
        public static final TextType EMAIL = new TextType("EMAIL", 4);
        public static final TextType URL = new TextType(TextConst.ENTITY_TYPE_URL, 5);
        public static final TextType PHONE = new TextType("PHONE", 6);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextType$Companion;", "", "<init>", "()V", "getValues", "", "Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextType;", "()[Lcom/samsung/android/sdk/pen/recogengine/SpenRecognizer$TextType;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final TextType[] getValues() {
                return TextType.values();
            }

            private Companion() {
            }
        }

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
            INSTANCE = new Companion(null);
        }

        private TextType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TextType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        @NotNull
        public static final TextType[] getValues() {
            return INSTANCE.getValues();
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
                    throw new NoWhenBranchMatchedException();
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
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    @JvmOverloads
    public SpenRecognizer(@Nullable Context context) {
        this(context, false, 2, null);
    }

    private final void checkPluginObject() {
        if (this.pluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : handwriting recognizer is not loaded");
        }
    }

    private final void checkResourceProvider() {
        if (this.resourceProvider == null) {
            throw new IllegalStateException("E_INVALID_STATE : resource provider is not set");
        }
    }

    @Deprecated(message = " ")
    @JvmStatic
    @Nullable
    public static final String[] getSupportedLanguage(@Nullable Context context) {
        return INSTANCE.getSupportedLanguage(context);
    }

    public final void addHwrDataWith(@NotNull List<SpenObjectStroke> strokes, @NotNull List<Integer> strokeIdList) {
        Intrinsics.checkNotNullParameter(strokes, "strokes");
        Intrinsics.checkNotNullParameter(strokeIdList, "strokeIdList");
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.addHwrDataWith(strokes, strokeIdList);
    }

    public final void addStroke(@Nullable SpenObjectStroke stroke) {
        checkPluginObject();
        if (stroke == null) {
            Log.e(TAG, "Null stroke: skip it!!!");
            return;
        }
        float[] xPoints = stroke.getXPoints();
        if (xPoints != null && xPoints.length == 0) {
            Log.e(TAG, "Empty stroke: skip it!!!");
            return;
        }
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.addStroke(stroke);
    }

    public final void cancel() {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.cancel();
    }

    public final void clearHwrDataList() {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.clearHwrDataList();
    }

    public final void clearStrokes() {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.clearStrokes();
    }

    public final void close() {
        Log.d(TAG, "close : mPluginObject and mResProvider");
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        if (spenRecognizerInterface != null) {
            spenRecognizerInterface.close();
            this.pluginObject = null;
        }
        SpenResourceProvider spenResourceProvider = this.resourceProvider;
        if (spenResourceProvider != null) {
            spenResourceProvider.close();
            this.resourceProvider = null;
        }
        this.mContext = null;
    }

    public final void createResourceProvider(@NotNull SpenResourceProvider.EngineType engineType, @NotNull SpenResourceProvider.ResourceType resourceType) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        Intrinsics.checkNotNullParameter(resourceType, "resourceType");
        SpenResourceProvider spenResourceProvider = this.resourceProvider;
        if (spenResourceProvider != null) {
            spenResourceProvider.close();
        }
        this.resourceProvider = new SpenResourceProvider(this.mContext, engineType, resourceType);
    }

    @Nullable
    public final float[] getDisplayMetrics() {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.getDisplayMetrics();
    }

    @Nullable
    public final String getLanguage() {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.getLanguage();
    }

    @Nullable
    public final SpenRecognizerInterface getPluginObject() {
        return this.pluginObject;
    }

    @Nullable
    public final synchronized String getRecognizerDBVersion() {
        SpenRecognizerInterface spenRecognizerInterface;
        checkPluginObject();
        spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.getRecognizerDBVersion();
    }

    @Nullable
    public final synchronized String getRecognizerDBVersionByHash() {
        checkPluginObject();
        String recognizerDBVersionByHashFully = getRecognizerDBVersionByHashFully();
        if (recognizerDBVersionByHashFully != null) {
            if (TextUtils.isEmpty(recognizerDBVersionByHashFully)) {
                return "";
            }
            if (recognizerDBVersionByHashFully.length() > 7) {
                String strSubstring = recognizerDBVersionByHashFully.substring(0, 7);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return recognizerDBVersionByHashFully;
    }

    @Nullable
    public final synchronized String getRecognizerDBVersionByHashFully() {
        byte[] bytes;
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        String recognizerDBVersion = spenRecognizerInterface.getRecognizerDBVersion();
        if (TextUtils.isEmpty(recognizerDBVersion)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            if (recognizerDBVersion != null) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                bytes = recognizerDBVersion.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            } else {
                bytes = null;
            }
            Intrinsics.checkNotNull(bytes);
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(2);
            for (byte b : bArrDigest) {
                String string = Integer.toString((b & 255) + 256, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                String strSubstring = string.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "getRecognizerDBVersionByHashFully: " + e.getLocalizedMessage());
            return recognizerDBVersion;
        }
    }

    @NotNull
    public final RecognizerType getRecognizerType() {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        SpenRecognizerInterface.RecognizerType recognizerType = spenRecognizerInterface.getRecognizerType();
        for (RecognizerType recognizerType2 : RecognizerType.values()) {
            if (recognizerType2.getValue() == recognizerType.getValue()) {
                return recognizerType2;
            }
        }
        return RecognizerType.DEFAULT;
    }

    @Nullable
    public final SpenResourceProvider getResourceProvider() {
        return this.resourceProvider;
    }

    @Nullable
    public final synchronized String getTextEngineVersion() {
        SpenRecognizerInterface spenRecognizerInterface;
        checkPluginObject();
        spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.getTextEngineVersion();
    }

    @Nullable
    public final SpenRecognizerResultContainerInterface recognize(int sleepTime) {
        checkPluginObject();
        if (getRecognizerType() == RecognizerType.TEXT_EXTRACTOR) {
            setRefineHyperLinkMode(true);
        }
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.recognize(sleepTime);
    }

    @Deprecated(message = " Recognize input strokes by {@link SpenRecognizer#addStroke(SpenObjectStroke)} method. <br>\n      This method returns the recognition result asynchronously.\n     \n      ")
    public final void request(@NotNull SpenRecognizerInterface.SpenRecognizerResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkPluginObject();
        setRefineHyperLinkMode(false);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.request(listener);
    }

    public final void setAnalyzerData(@Nullable byte[] data) {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setAnalyzerData(data);
    }

    public final void setConfigurationItem(@NotNull String configName, float configValue) {
        Intrinsics.checkNotNullParameter(configName, "configName");
        checkPluginObject();
        Log.i(TAG, "setConfigurationItem : [name, value] = [" + configName + SQLKeyword.COMMA + configValue + "]");
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setConfigurationItem(configName, configValue);
    }

    public final void setDisplayMetrics(float xdpi, float ydpi) {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setDisplayMetrics(xdpi, ydpi);
    }

    public final void setLanguage(@Nullable String str) {
        String defaultLocale;
        AbstractC2322a.m1609C("setLanguage : language = ", str, TAG);
        checkResourceProvider();
        if (str != null) {
            SpenResourceProvider spenResourceProvider = this.resourceProvider;
            Intrinsics.checkNotNull(spenResourceProvider);
            defaultLocale = spenResourceProvider.getDefaultLocale(str);
        } else {
            defaultLocale = null;
        }
        checkPluginObject();
        if (defaultLocale != null) {
            SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
            Intrinsics.checkNotNull(spenRecognizerInterface);
            spenRecognizerInterface.setLanguage(defaultLocale);
        }
    }

    public final void setLanguageData(@NotNull String language, @Nullable byte[] languageData, @Nullable byte[] englishData) {
        Intrinsics.checkNotNullParameter(language, "language");
        Log.d(TAG, "setLanguageData : language = " + language);
        checkResourceProvider();
        SpenResourceProvider spenResourceProvider = this.resourceProvider;
        Intrinsics.checkNotNull(spenResourceProvider);
        String defaultLocale = spenResourceProvider.getDefaultLocale(language);
        checkPluginObject();
        if (defaultLocale != null) {
            SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
            Intrinsics.checkNotNull(spenRecognizerInterface);
            spenRecognizerInterface.setLanguageData(defaultLocale, languageData, englishData);
        }
    }

    public final void setLineSplitterData(@Nullable byte[] data) {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setLineSplitterData(data);
    }

    public final void setMathData(@Nullable byte[] data) {
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setMathData(data);
    }

    public final void setPluginObject(@Nullable SpenRecognizerInterface spenRecognizerInterface) {
        this.pluginObject = spenRecognizerInterface;
    }

    @Deprecated(message = " ")
    public final void setRecognizerType(@NotNull SpenRecognizerInterface.RecognizerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setRecognizerType(type);
    }

    public final void setRefineHyperLinkMode(boolean set) {
        checkPluginObject();
        AbstractC6670b.m4759t("setRefineHyperLinkMode() set = ", TAG, set);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setRefineHyperLinkMode(set);
    }

    public final void setStrokeModeEnabled(boolean set) {
        checkPluginObject();
        AbstractC6670b.m4759t("setStrokeModeEnabled() set = ", TAG, set);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setStrokeModeEnabled(set);
    }

    @Deprecated(message = " ")
    public final boolean setTextRecognionType(@NotNull SpenRecognizerInterface.TextType textType) {
        Intrinsics.checkNotNullParameter(textType, "textType");
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.setTextRecognitionType(textType);
    }

    public final boolean setTextRecognitionMode(@NotNull TextMode textMode) {
        Intrinsics.checkNotNullParameter(textMode, "textMode");
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.setTextRecognitionMode(SpenRecognizerInterface.TextMode.values()[textMode.getValue()]);
    }

    public final boolean setTextRecognitionType(@NotNull TextType textType) {
        Intrinsics.checkNotNullParameter(textType, "textType");
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.setTextRecognitionType(SpenRecognizerInterface.TextType.values()[textType.ordinal()]);
    }

    public final void setUserDictionary(@NotNull List<String> userWords) {
        Intrinsics.checkNotNullParameter(userWords, "userWords");
        checkPluginObject();
        if (userWords.isEmpty()) {
            Log.e(TAG, "wrong input parameter -> userWords");
            return;
        }
        AbstractC0541b.m755A(userWords.size(), "userWords size = ", TAG);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setUserDictionary(userWords);
    }

    @JvmOverloads
    public SpenRecognizer(@Nullable Context context, boolean z) {
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mContext = context;
        Log.d(TAG, "SpenRecognizer(Context context) : create default mResProvider");
        createResourceProvider(SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
        if (z) {
            SpenRecognizerPlugin spenRecognizerPlugin = new SpenRecognizerPlugin();
            this.pluginObject = spenRecognizerPlugin;
            try {
                Intrinsics.checkNotNull(spenRecognizerPlugin, "null cannot be cast to non-null type com.samsung.android.sdk.pen.recogengine.preload.SpenRecognizerPlugin");
                spenRecognizerPlugin.onLoadIgnoreInit(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void setRecognizerType(@NotNull RecognizerType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        checkPluginObject();
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.setRecognizerType(SpenRecognizerInterface.RecognizerType.values()[type.getValue()]);
    }

    public final void request(@NotNull final ResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkPluginObject();
        setRefineHyperLinkMode(false);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.request(new SpenRecognizerInterface.SpenRecognizerResultListener() { // from class: com.samsung.android.sdk.pen.recogengine.SpenRecognizer.request.1
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface.SpenRecognizerResultListener
            public void onResult(int status, SpenRecognizerResultContainerInterface resultInterface) {
                Intrinsics.checkNotNullParameter(resultInterface, "resultInterface");
                listener.onResult(status, resultInterface);
            }
        });
    }

    @Nullable
    public final SpenRecognizerResultContainerInterface recognize() {
        checkPluginObject();
        setRefineHyperLinkMode(false);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.recognize();
    }

    public final void addStroke(@Nullable SpenObjectStroke stroke, @NotNull final ResultListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkPluginObject();
        if (stroke == null) {
            Log.e(TAG, "Null stroke: skip it!!!");
            return;
        }
        float[] xPoints = stroke.getXPoints();
        if (xPoints != null && xPoints.length == 0) {
            Log.e(TAG, "Empty stroke: skip it!!!");
            return;
        }
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.addStroke(stroke, new SpenRecognizerInterface.SpenRecognizerResultListener() { // from class: com.samsung.android.sdk.pen.recogengine.SpenRecognizer.addStroke.3
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface.SpenRecognizerResultListener
            public void onResult(int status, SpenRecognizerResultContainerInterface resultInterface) {
                Intrinsics.checkNotNullParameter(resultInterface, "resultInterface");
                listener.onResult(status, resultInterface);
            }
        });
    }

    @Deprecated(message = " Recognize input strokes by {@link SpenRecognizerInterface#addStroke(SpenObjectStroke)} method. <br>\n      This method returns the recognition result asynchronously.\n     \n      ")
    public final void request(@NotNull SpenRecognizerInterface.SpenRecognizerResultListener listener, float refX, float refY) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkPluginObject();
        setRefineHyperLinkMode(false);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.request(listener, refX, refY);
    }

    @Nullable
    public final SpenRecognizerResultContainerInterface recognize(float refX, float refY) {
        checkPluginObject();
        setRefineHyperLinkMode(false);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        return spenRecognizerInterface.recognize(refX, refY);
    }

    public final void request(@NotNull final ResultListener listener, float refX, float refY) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        checkPluginObject();
        setRefineHyperLinkMode(false);
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.request(new SpenRecognizerInterface.SpenRecognizerResultListener() { // from class: com.samsung.android.sdk.pen.recogengine.SpenRecognizer.request.2
            @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognizerInterface.SpenRecognizerResultListener
            public void onResult(int status, SpenRecognizerResultContainerInterface resultInterface) {
                Intrinsics.checkNotNullParameter(resultInterface, "resultInterface");
                listener.onResult(status, resultInterface);
            }
        }, refX, refY);
    }

    public /* synthetic */ SpenRecognizer(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    public SpenRecognizer(@Nullable Context context, @Nullable SpenRecognizerInterface spenRecognizerInterface) {
        this(context, false, 2, null);
        if (spenRecognizerInterface != null) {
            this.pluginObject = spenRecognizerInterface;
            Log.d(TAG, "SpenRecognizer(Context context, SpenRecognizerInterface pluginObject) : create default mResProvider");
            createResourceProvider(SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
            return;
        }
        throw new IllegalArgumentException("E_INVALID_ARG : parameter 'pluginObject' is null");
    }

    public final void addStroke(@Nullable float[] xdata, @Nullable float[] ydata) {
        checkPluginObject();
        if (xdata == null || ydata == null) {
            Log.e(TAG, "null input: skip!!");
            return;
        }
        if (xdata.length == 0 || xdata.length != ydata.length) {
            Log.e(TAG, "wrong input data!");
            return;
        }
        SpenRecognizerInterface spenRecognizerInterface = this.pluginObject;
        Intrinsics.checkNotNull(spenRecognizerInterface);
        spenRecognizerInterface.addStroke(xdata, ydata);
    }
}
