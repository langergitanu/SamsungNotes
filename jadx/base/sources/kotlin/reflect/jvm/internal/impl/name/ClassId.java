package kotlin.reflect.jvm.internal.impl.name;

import androidx.compose.runtime.AbstractC1974b;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@SourceDebugExtension({"SMAP\nClassId.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 addToStdlib.kt\norg/jetbrains/kotlin/utils/addToStdlib/AddToStdlibKt\n*L\n1#1,141:1\n1#2:142\n226#3:143\n226#3:144\n*S KotlinDebug\n*F\n+ 1 ClassId.kt\norg/jetbrains/kotlin/name/ClassId\n*L\n37#1:143\n47#1:144\n*E\n"})
public final class ClassId {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean isLocal;

    @NotNull
    private final FqName packageFqName;

    @NotNull
    private final FqName relativeClassName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromString(str, z);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final ClassId fromString(@NotNull String string, boolean z) {
            String strM14139M;
            Intrinsics.checkNotNullParameter(string, "string");
            int iM14128B = StringsKt.m14128B(string, '`', 0, 6);
            if (iM14128B == -1) {
                iM14128B = string.length();
            }
            int iM14131E = StringsKt.m14131E("/", iM14128B, 4, string);
            String str = "";
            if (iM14131E == -1) {
                strM14139M = StringsKt.m14139M(string, "`", "");
            } else {
                String strSubstring = string.substring(0, iM14131E);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strReplace$default = StringsKt__StringsJVMKt.replace$default(strSubstring, '/', '.', false, 4, (Object) null);
                String strSubstring2 = string.substring(iM14131E + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                strM14139M = StringsKt.m14139M(strSubstring2, "`", "");
                str = strReplace$default;
            }
            return new ClassId(new FqName(str), new FqName(strM14139M), z);
        }

        @JvmStatic
        @NotNull
        public final ClassId topLevel(@NotNull FqName topLevelFqName) {
            Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            FqName fqNameParent = topLevelFqName.parent();
            Intrinsics.checkNotNullExpressionValue(fqNameParent, "parent(...)");
            Name nameShortName = topLevelFqName.shortName();
            Intrinsics.checkNotNullExpressionValue(nameShortName, "shortName(...)");
            return new ClassId(fqNameParent, nameShortName);
        }

        private Companion() {
        }
    }

    public ClassId(@NotNull FqName packageFqName, @NotNull FqName relativeClassName, boolean z) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = z;
        relativeClassName.isRoot();
    }

    private static final String asString$escapeSlashes(FqName fqName) {
        String strAsString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return StringsKt__StringsKt.contains$default((CharSequence) strAsString, '/', false, 2, (Object) null) ? AbstractC1974b.m1315h('`', "`", strAsString) : strAsString;
    }

    @JvmStatic
    @NotNull
    public static final ClassId topLevel(@NotNull FqName fqName) {
        return Companion.topLevel(fqName);
    }

    @NotNull
    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            return this.relativeClassName;
        }
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    @NotNull
    public final String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        StringBuilder sb = new StringBuilder();
        String strAsString = this.packageFqName.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        sb.append(StringsKt__StringsJVMKt.replace$default(strAsString, '.', '/', false, 4, (Object) null));
        sb.append("/");
        sb.append(asString$escapeSlashes(this.relativeClassName));
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @NotNull
    public final ClassId createNestedClassId(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        FqName fqName = this.packageFqName;
        FqName fqNameChild = this.relativeClassName.child(name);
        Intrinsics.checkNotNullExpressionValue(fqNameChild, "child(...)");
        return new ClassId(fqName, fqNameChild, this.isLocal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassId)) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
    }

    @Nullable
    public final ClassId getOuterClassId() {
        FqName fqNameParent = this.relativeClassName.parent();
        Intrinsics.checkNotNullExpressionValue(fqNameParent, "parent(...)");
        if (fqNameParent.isRoot()) {
            return null;
        }
        return new ClassId(this.packageFqName, fqNameParent, this.isLocal);
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    @NotNull
    public final Name getShortClassName() {
        Name nameShortName = this.relativeClassName.shortName();
        Intrinsics.checkNotNullExpressionValue(nameShortName, "shortName(...)");
        return nameShortName;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLocal) + ((this.relativeClassName.hashCode() + (this.packageFqName.hashCode() * 31)) * 31);
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    @NotNull
    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ClassId(@NotNull FqName packageFqName, @NotNull Name topLevelName) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
        FqName fqName = FqName.topLevel(topLevelName);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(...)");
        this(packageFqName, fqName, false);
    }
}
