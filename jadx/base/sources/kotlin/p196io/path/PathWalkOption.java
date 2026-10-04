package kotlin.p196io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SinceKotlin(version = "2.1")
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lkotlin/io/path/PathWalkOption;", "", "<init>", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@WasExperimental(markerClass = {ExperimentalPathApi.class})
public final class PathWalkOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PathWalkOption[] $VALUES;
    public static final PathWalkOption INCLUDE_DIRECTORIES = new PathWalkOption("INCLUDE_DIRECTORIES", 0);
    public static final PathWalkOption BREADTH_FIRST = new PathWalkOption("BREADTH_FIRST", 1);
    public static final PathWalkOption FOLLOW_LINKS = new PathWalkOption("FOLLOW_LINKS", 2);

    private static final /* synthetic */ PathWalkOption[] $values() {
        return new PathWalkOption[]{INCLUDE_DIRECTORIES, BREADTH_FIRST, FOLLOW_LINKS};
    }

    static {
        PathWalkOption[] pathWalkOptionArr$values = $values();
        $VALUES = pathWalkOptionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pathWalkOptionArr$values);
    }

    private PathWalkOption(String str, int i) {
    }

    @NotNull
    public static EnumEntries<PathWalkOption> getEntries() {
        return $ENTRIES;
    }

    public static PathWalkOption valueOf(String str) {
        return (PathWalkOption) Enum.valueOf(PathWalkOption.class, str);
    }

    public static PathWalkOption[] values() {
        return (PathWalkOption[]) $VALUES.clone();
    }
}
