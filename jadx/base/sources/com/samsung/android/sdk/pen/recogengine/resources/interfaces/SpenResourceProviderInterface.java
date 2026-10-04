package com.samsung.android.sdk.pen.recogengine.resources.interfaces;

import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002\u0014\u0015J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0015\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J)\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface;", "", "setRootDirectory", "", "rootDir", "", "getSupportedLanguages", "", "()[Ljava/lang/String;", "isSupportedLanguage", "", "language", "getResourceData", "", ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;", "(Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;Ljava/lang/String;)[[B", "getDefaultLocale", "getMD5String", "close", "ResourceType", "EngineType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenResourceProviderInterface {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "DOCUMENT", "SHAPE", "MATH", "UNKNOWN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class EngineType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EngineType[] $VALUES;
        public static final EngineType TEXT = new EngineType("TEXT", 0);
        public static final EngineType DOCUMENT = new EngineType("DOCUMENT", 1);
        public static final EngineType SHAPE = new EngineType("SHAPE", 2);
        public static final EngineType MATH = new EngineType("MATH", 3);
        public static final EngineType UNKNOWN = new EngineType("UNKNOWN", 4);

        private static final /* synthetic */ EngineType[] $values() {
            return new EngineType[]{TEXT, DOCUMENT, SHAPE, MATH, UNKNOWN};
        }

        static {
            EngineType[] engineTypeArr$values = $values();
            $VALUES = engineTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(engineTypeArr$values);
        }

        private EngineType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<EngineType> getEntries() {
            return $ENTRIES;
        }

        public static EngineType valueOf(String str) {
            return (EngineType) Enum.valueOf(EngineType.class, str);
        }

        public static EngineType[] values() {
            return (EngineType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$ResourceType;", "", "<init>", "(Ljava/lang/String;I)V", "FRAMEWORK", "ASSETS", "FILE", "UNKNOWN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ResourceType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResourceType[] $VALUES;
        public static final ResourceType FRAMEWORK = new ResourceType("FRAMEWORK", 0);
        public static final ResourceType ASSETS = new ResourceType("ASSETS", 1);
        public static final ResourceType FILE = new ResourceType("FILE", 2);
        public static final ResourceType UNKNOWN = new ResourceType("UNKNOWN", 3);

        private static final /* synthetic */ ResourceType[] $values() {
            return new ResourceType[]{FRAMEWORK, ASSETS, FILE, UNKNOWN};
        }

        static {
            ResourceType[] resourceTypeArr$values = $values();
            $VALUES = resourceTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(resourceTypeArr$values);
        }

        private ResourceType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ResourceType> getEntries() {
            return $ENTRIES;
        }

        public static ResourceType valueOf(String str) {
            return (ResourceType) Enum.valueOf(ResourceType.class, str);
        }

        public static ResourceType[] values() {
            return (ResourceType[]) $VALUES.clone();
        }
    }

    void close();

    @Nullable
    String getDefaultLocale(@Nullable String language);

    @Nullable
    String getMD5String(@Nullable String language);

    @Nullable
    byte[][] getResourceData(@NotNull EngineType engineType, @Nullable String language);

    @Nullable
    String[] getSupportedLanguages();

    boolean isSupportedLanguage(@Nullable String language);

    void setRootDirectory(@Nullable String rootDir);
}
