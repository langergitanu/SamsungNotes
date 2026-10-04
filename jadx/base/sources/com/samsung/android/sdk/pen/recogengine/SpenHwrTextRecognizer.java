package com.samsung.android.sdk.pen.recogengine;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.handwriting.UninitializedException;
import com.samsung.android.sdk.handwriting.text.TextRecognizer;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 72\u00020\u0001:\u0006234567B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J$\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0005J\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*J\u0006\u0010+\u001a\u00020\u000fJ\u0014\u00100\u001a\u00020\u000f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00120-R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120-8F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer;", "", "context", "Landroid/content/Context;", "asyncMode", "", "<init>", "(Landroid/content/Context;Z)V", "useFw", "(Landroid/content/Context;ZZ)V", "mRecognizer", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer;", "mbIsRecognizing", "mbIsClosing", "close", "", "setLanguage", "language", "", "setLanguageData", "languageData", "", "englishData", "setRecognitionType", "type", "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionType;", "setRecognitionMode", "mode", "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionMode;", "addStroke", "x", "", "y", "stroke", "Lcom/samsung/android/sdk/pen/document/SpenObjectStroke;", "clearStrokes", "setStrokeModeEnabled", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, "recognize", "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$Result;", "requestRecognition", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionListener;", "cancel", "supportedLanguages", "", "getSupportedLanguages", "()Ljava/util/List;", "setUserDictionary", "userWords", "RecognitionType", "RecognitionMode", "Result", "RecognitionListener", "EventListener", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenHwrTextRecognizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenHwrTextRecognizer.kt\ncom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,699:1\n1#2:700\n*E\n"})
public final class SpenHwrTextRecognizer {
    public static final int STATUS_FAILURE_INTERNAL_ERROR = 1;
    public static final int STATUS_SUCCESS = 0;

    @NotNull
    private static final String TAG = "SpenHwrTextRecognizer";

    @Nullable
    private TextRecognizer mRecognizer;
    private boolean mbIsClosing;
    private boolean mbIsRecognizing;

    @NotNull
    private static final Object mLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$EventListener;", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$RecognitionListener;", "<init>", "()V", "mListener", "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionListener;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onResult", "status", "", "result", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$Result;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class EventListener implements TextRecognizer.RecognitionListener {

        @Nullable
        private RecognitionListener mListener;

        @Override // com.samsung.android.sdk.handwriting.text.TextRecognizer.RecognitionListener
        public void onResult(int status, @NotNull TextRecognizer.Result result) {
            Intrinsics.checkNotNullParameter(result, "result");
            RecognitionListener recognitionListener = this.mListener;
            if (recognitionListener == null) {
                Log.e(SpenHwrTextRecognizer.TAG, "EventListener : onResult : mListener is null!");
                return;
            }
            Log.d(SpenHwrTextRecognizer.TAG, "onResult: status = " + status);
            recognitionListener.onResult(status, new Result(result));
        }

        public final void setListener(@Nullable RecognitionListener listener) {
            this.mListener = listener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionListener;", "", "onResult", "", "status", "", "result", "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$Result;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface RecognitionListener {
        void onResult(int status, @Nullable Result result);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionMode;", "", "<init>", "(Ljava/lang/String;I)V", "CHARACTER", "SINGLE_LINE", "MULTI_LINE", "OVERLAY", "toString", "", "value", "", "getValue", "()I", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RecognitionMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecognitionMode[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final RecognitionMode CHARACTER = new RecognitionMode("CHARACTER", 0);
        public static final RecognitionMode SINGLE_LINE = new RecognitionMode("SINGLE_LINE", 1);
        public static final RecognitionMode MULTI_LINE = new RecognitionMode("MULTI_LINE", 2);
        public static final RecognitionMode OVERLAY = new RecognitionMode("OVERLAY", 3);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\u0004\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionMode$Companion;", "", "<init>", "()V", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionType;", "type", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$RecognitionType;", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$RecognitionMode;", "mode", "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionMode;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final RecognitionType convert(TextRecognizer.RecognitionType type) {
                for (RecognitionType recognitionType : RecognitionType.values()) {
                    if (Intrinsics.areEqual(recognitionType.toString(), type.toString())) {
                        return recognitionType;
                    }
                }
                return RecognitionType.TEXT_PLAIN;
            }

            private Companion() {
            }

            @NotNull
            public final TextRecognizer.RecognitionMode convert(@NotNull RecognitionMode mode) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Iterator it = ArrayIteratorKt.iterator(TextRecognizer.RecognitionMode.getValues());
                while (it.hasNext()) {
                    TextRecognizer.RecognitionMode recognitionMode = (TextRecognizer.RecognitionMode) it.next();
                    if (Intrinsics.areEqual(recognitionMode.toString(), mode.toString())) {
                        Intrinsics.checkNotNull(recognitionMode);
                        return recognitionMode;
                    }
                }
                return TextRecognizer.RecognitionMode.MULTI_LINE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RecognitionMode.values().length];
                try {
                    iArr[RecognitionMode.CHARACTER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RecognitionMode.SINGLE_LINE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RecognitionMode.MULTI_LINE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RecognitionMode.OVERLAY.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ RecognitionMode[] $values() {
            return new RecognitionMode[]{CHARACTER, SINGLE_LINE, MULTI_LINE, OVERLAY};
        }

        static {
            RecognitionMode[] recognitionModeArr$values = $values();
            $VALUES = recognitionModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(recognitionModeArr$values);
            INSTANCE = new Companion(null);
        }

        private RecognitionMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RecognitionMode> getEntries() {
            return $ENTRIES;
        }

        private final int getValue() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return 0;
            }
            int i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    if (i == 4) {
                        return 4;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
            return i2;
        }

        public static RecognitionMode valueOf(String str) {
            return (RecognitionMode) Enum.valueOf(RecognitionMode.class, str);
        }

        public static RecognitionMode[] values() {
            return (RecognitionMode[]) $VALUES.clone();
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
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT_PLAIN", "TEXT_SYMBOL", "EMAIL", TextConst.ENTITY_TYPE_URL, "NUMBER", "PHONE", "toString", "", "value", "", "getValue", "()I", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RecognitionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecognitionType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final RecognitionType TEXT_PLAIN = new RecognitionType("TEXT_PLAIN", 0);
        public static final RecognitionType TEXT_SYMBOL = new RecognitionType("TEXT_SYMBOL", 1);
        public static final RecognitionType EMAIL = new RecognitionType("EMAIL", 2);

        @Deprecated(message = "")
        public static final RecognitionType URL = new RecognitionType(TextConst.ENTITY_TYPE_URL, 3);
        public static final RecognitionType NUMBER = new RecognitionType("NUMBER", 4);
        public static final RecognitionType PHONE = new RecognitionType("PHONE", 5);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionType$Companion;", "", "<init>", "()V", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$RecognitionType;", "type", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$RecognitionType;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final RecognitionType convert(TextRecognizer.RecognitionType type) {
                for (RecognitionType recognitionType : RecognitionType.values()) {
                    if (Intrinsics.areEqual(recognitionType.toString(), type.toString())) {
                        return recognitionType;
                    }
                }
                return RecognitionType.TEXT_PLAIN;
            }

            private Companion() {
            }

            @NotNull
            public final TextRecognizer.RecognitionType convert(@NotNull RecognitionType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Iterator it = ArrayIteratorKt.iterator(TextRecognizer.RecognitionType.getValues());
                while (it.hasNext()) {
                    TextRecognizer.RecognitionType recognitionType = (TextRecognizer.RecognitionType) it.next();
                    if (Intrinsics.areEqual(recognitionType.toString(), type.toString())) {
                        Intrinsics.checkNotNull(recognitionType);
                        return recognitionType;
                    }
                }
                return TextRecognizer.RecognitionType.TEXT_PLAIN;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RecognitionType.values().length];
                try {
                    iArr[RecognitionType.TEXT_PLAIN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RecognitionType.TEXT_SYMBOL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RecognitionType.EMAIL.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RecognitionType.URL.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RecognitionType.NUMBER.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RecognitionType.PHONE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ RecognitionType[] $values() {
            return new RecognitionType[]{TEXT_PLAIN, TEXT_SYMBOL, EMAIL, URL, NUMBER, PHONE};
        }

        static {
            RecognitionType[] recognitionTypeArr$values = $values();
            $VALUES = recognitionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(recognitionTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private RecognitionType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RecognitionType> getEntries() {
            return $ENTRIES;
        }

        private final int getValue() {
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
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public static RecognitionType valueOf(String str) {
            return (RecognitionType) Enum.valueOf(RecognitionType.class, str);
        }

        public static RecognitionType[] values() {
            return (RecognitionType[]) $VALUES.clone();
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
                    return "email";
                case 4:
                    return "url";
                case 5:
                    return TextConst.KEY_PARAM_NUMBER;
                case 6:
                    return "phone";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/SpenHwrTextRecognizer$Result;", "", "result", "Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$Result;", "<init>", "(Lcom/samsung/android/sdk/handwriting/text/TextRecognizer$Result;)V", "mResult", "NULL_STRING_ARRAY", "", "", "[Ljava/lang/String;", "candidates", "getCandidates", "()[Ljava/lang/String;", "getStartStrokeIndex", "", "characterIndex", "getStartPointOffset", "getEndStrokeIndex", "getEndPointOffset", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Result {

        @NotNull
        private final String[] NULL_STRING_ARRAY = new String[0];

        @Nullable
        private TextRecognizer.Result mResult;

        public Result(@Nullable TextRecognizer.Result result) {
            if (result == null) {
                Log.e(SpenHwrTextRecognizer.TAG, "Result() : result is null!");
                result = null;
            }
            this.mResult = result;
        }

        @NotNull
        public final String[] getCandidates() {
            TextRecognizer.Result result = this.mResult;
            if (result == null) {
                Log.e(SpenHwrTextRecognizer.TAG, "result is null");
                return this.NULL_STRING_ARRAY;
            }
            String[] candidates = result.getCandidates();
            Intrinsics.checkNotNullExpressionValue(candidates, "getCandidates(...)");
            return candidates;
        }

        @Deprecated(message = " Returns end point offset of the end stroke index for the character located at characterIndex\n          ")
        public final int getEndPointOffset(int characterIndex) {
            TextRecognizer.Result result = this.mResult;
            if (result != null) {
                return result.getEndPointOffset(characterIndex);
            }
            Log.e(SpenHwrTextRecognizer.TAG, "result is null");
            return -1;
        }

        public final int getEndStrokeIndex(int characterIndex) {
            TextRecognizer.Result result = this.mResult;
            if (result != null) {
                return result.getEndStrokeIndex(characterIndex);
            }
            Log.e(SpenHwrTextRecognizer.TAG, "result is null");
            return -1;
        }

        @Deprecated(message = " Returns start point offset of the start stroke index for the character located at characterIndex\n          ")
        public final int getStartPointOffset(int characterIndex) {
            TextRecognizer.Result result = this.mResult;
            if (result != null) {
                return result.getStartPointOffset(characterIndex);
            }
            Log.e(SpenHwrTextRecognizer.TAG, "result is null");
            return -1;
        }

        public final int getStartStrokeIndex(int characterIndex) {
            TextRecognizer.Result result = this.mResult;
            if (result != null) {
                return result.getStartStrokeIndex(characterIndex);
            }
            Log.e(SpenHwrTextRecognizer.TAG, "result is null");
            return -1;
        }
    }

    public SpenHwrTextRecognizer(@Nullable Context context, boolean z) {
        try {
            this.mbIsRecognizing = false;
            this.mbIsClosing = false;
            this.mRecognizer = new TextRecognizer(context, z);
        } catch (UninitializedException e) {
            throw new SpenUninitializedException(e.getMessage());
        }
    }

    public final void addStroke(@Nullable float[] x, @Nullable float[] y2) {
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (x == null) {
            throw new IllegalArgumentException("stroke x point data is null");
        }
        if (y2 == null) {
            throw new IllegalArgumentException("stroke y point data is null");
        }
        if (x.length != y2.length) {
            throw new IllegalArgumentException("invalid stroke");
        }
        if (x.length <= 0) {
            throw new IllegalArgumentException("stroke x point data is invalid");
        }
        if (y2.length <= 0) {
            throw new IllegalArgumentException("stroke y point data is invalid");
        }
        if (this.mbIsClosing) {
            Log.d(TAG, "addstroke: this task is closing...");
            return;
        }
        synchronized (mLock) {
            TextRecognizer textRecognizer = this.mRecognizer;
            if (textRecognizer != null) {
                textRecognizer.addStroke(x, y2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void cancel() {
        Log.d(TAG, "cancel() is called");
        this.mbIsRecognizing = false;
        TextRecognizer textRecognizer = this.mRecognizer;
        if (textRecognizer != null) {
            try {
                textRecognizer.cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void clearStrokes() {
        TextRecognizer textRecognizer = this.mRecognizer;
        if (textRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (textRecognizer != null) {
            textRecognizer.clearStrokes();
        }
    }

    public final void close() {
        this.mbIsClosing = true;
        AbstractC6670b.m4759t("close() : mbIsRecognizing = ", TAG, this.mbIsRecognizing);
        while (this.mbIsRecognizing) {
            try {
                Thread.sleep(5L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TextRecognizer textRecognizer = this.mRecognizer;
        if (textRecognizer != null) {
            textRecognizer.close();
        }
        this.mRecognizer = null;
    }

    @NotNull
    public final List<String> getSupportedLanguages() {
        TextRecognizer textRecognizer = this.mRecognizer;
        if (textRecognizer == null) {
            throw new IllegalStateException("mRecognizer is null");
        }
        List<String> supportedLanguages = textRecognizer != null ? textRecognizer.getSupportedLanguages() : null;
        Intrinsics.checkNotNull(supportedLanguages, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        return supportedLanguages;
    }

    @Nullable
    public final Result recognize() {
        Result result;
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (this.mbIsClosing) {
            Log.d(TAG, "recognize(): this task is closing...");
            return null;
        }
        synchronized (mLock) {
            try {
                try {
                    this.mbIsRecognizing = true;
                    TextRecognizer textRecognizer = this.mRecognizer;
                    result = new Result(textRecognizer != null ? textRecognizer.recognize() : null);
                    this.mbIsRecognizing = false;
                } catch (Exception e) {
                    throw new SpenIncorrectUsageException(e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return result;
    }

    public final void requestRecognition(@Nullable RecognitionListener listener) throws SpenIncorrectUsageException {
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (listener == null) {
            throw new IllegalArgumentException("Listener is null");
        }
        EventListener eventListener = new EventListener();
        eventListener.setListener(listener);
        try {
            TextRecognizer textRecognizer = this.mRecognizer;
            if (textRecognizer != null) {
                textRecognizer.requestRecognition(eventListener);
            }
        } catch (Exception e) {
            throw new SpenIncorrectUsageException(e.getMessage());
        }
    }

    public final void setLanguage(@Nullable String language) {
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (language == null) {
            throw new IllegalArgumentException("language is null");
        }
        Log.d(TAG, "language = ".concat(language));
        synchronized (mLock) {
            TextRecognizer textRecognizer = this.mRecognizer;
            if (textRecognizer != null) {
                textRecognizer.setLanguage(language);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void setLanguageData(@Nullable String language, @Nullable byte[] languageData, @Nullable byte[] englishData) {
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (language == null) {
            throw new IllegalArgumentException("language is null");
        }
        Log.d(TAG, "language = ".concat(language));
        synchronized (mLock) {
            throw new IllegalArgumentException("There is no API to set language data!!");
        }
    }

    public final void setRecognitionMode(@Nullable RecognitionMode mode) {
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (mode == null) {
            throw new IllegalArgumentException("recognition mode is null");
        }
        synchronized (mLock) {
            TextRecognizer textRecognizer = this.mRecognizer;
            if (textRecognizer != null) {
                textRecognizer.setRecognitionMode(RecognitionMode.INSTANCE.convert(mode));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void setRecognitionType(@Nullable RecognitionType type) {
        if (this.mRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (type == null) {
            throw new IllegalArgumentException("recognition type is null");
        }
        synchronized (mLock) {
            TextRecognizer textRecognizer = this.mRecognizer;
            if (textRecognizer != null) {
                textRecognizer.setRecognitionType(RecognitionType.INSTANCE.convert(type));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void setStrokeModeEnabled(boolean set) {
        TextRecognizer textRecognizer = this.mRecognizer;
        if (textRecognizer == null) {
            throw new IllegalStateException("SpenRecognizer is null");
        }
        if (textRecognizer != null) {
            textRecognizer.setStrokeModeEnabled(set);
        }
    }

    public final void setUserDictionary(@NotNull List<String> userWords) {
        Intrinsics.checkNotNullParameter(userWords, "userWords");
        TextRecognizer textRecognizer = this.mRecognizer;
        if (textRecognizer == null) {
            throw new IllegalStateException("mRecognizer is null");
        }
        if (textRecognizer != null) {
            textRecognizer.setUserDictionary(userWords);
        }
    }

    @Deprecated(message = " ")
    public SpenHwrTextRecognizer(@Nullable Context context, boolean z, boolean z2) {
        try {
            this.mbIsRecognizing = false;
            this.mbIsClosing = false;
            this.mRecognizer = new TextRecognizer(context, z, z2);
        } catch (UninitializedException e) {
            throw new SpenUninitializedException(e.getMessage());
        }
    }

    public final void addStroke(@NotNull SpenObjectStroke stroke) {
        Intrinsics.checkNotNullParameter(stroke, "stroke");
        if (this.mRecognizer != null) {
            float[] xPoints = stroke.getXPoints();
            float[] yPoints = stroke.getYPoints();
            if (xPoints == null) {
                throw new IllegalArgumentException("stroke x point data is null");
            }
            if (yPoints != null) {
                if (xPoints.length == yPoints.length) {
                    if (xPoints.length > 0) {
                        if (yPoints.length > 0) {
                            if (this.mbIsClosing) {
                                Log.d(TAG, "addstroke: this task is closing...");
                                return;
                            }
                            synchronized (mLock) {
                                TextRecognizer textRecognizer = this.mRecognizer;
                                if (textRecognizer != null) {
                                    textRecognizer.addStroke(xPoints, yPoints);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                            return;
                        }
                        throw new IllegalArgumentException("stroke y point data is invalid");
                    }
                    throw new IllegalArgumentException("stroke x point data is invalid");
                }
                throw new IllegalArgumentException("invalid stroke");
            }
            throw new IllegalArgumentException("stroke y point data is null");
        }
        throw new IllegalStateException("SpenRecognizer is null");
    }
}
