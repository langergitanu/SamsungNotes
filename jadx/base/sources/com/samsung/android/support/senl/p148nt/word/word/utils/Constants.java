package com.samsung.android.support.senl.p148nt.word.word.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/word/utils/Constants;", "", "<init>", "()V", "LEVEL_TYPE", "", "ABSTRACT_NUM", "CONFIG_PAGE_SIZE", "cTAbstractCheckXML", "getCTAbstractCheckXML", "()Ljava/lang/String;", "setCTAbstractCheckXML", "(Ljava/lang/String;)V", "cTAbstractUnCheckXML", "getCTAbstractUnCheckXML", "setCTAbstractUnCheckXML", "cTAbstractNumBulletXML", "getCTAbstractNumBulletXML", "setCTAbstractNumBulletXML", "cTAbstractNumDecimalXML", "getCTAbstractNumDecimalXML", "setCTAbstractNumDecimalXML", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constants {

    @NotNull
    private static final String ABSTRACT_NUM = "</w:abstractNum>";

    @NotNull
    public static final String CONFIG_PAGE_SIZE = "<w:pgSz xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:h=\"16840\" w:w=\"11900\"/>";

    @NotNull
    private static final String LEVEL_TYPE = "<w:multiLevelType w:val=\"hybridMultilevel\"/>";

    @NotNull
    public static final Constants INSTANCE = new Constants();

    @NotNull
    private static String cTAbstractCheckXML = "<w:abstractNum xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:abstractNumId=\"0\"><w:multiLevelType w:val=\"hybridMultilevel\"/><w:lvl w:ilvl=\"0\"><w:start w:val=\"1\"/><w:numFmt w:val=\"bullet\"/><w:lvlText w:val=\"þ\"/><w:lvlJc w:val=\"left\"/><w:pPr><w:ind w:left=\"360\" w:hanging=\"360\"/></w:pPr><w:rPr><w:sz w:val=\"22\"/><w:rFonts w:ascii=\"Wingdings\" w:hAnsi=\"Wingdings\" w:hint=\"default\"/></w:rPr></w:lvl></w:abstractNum>";

    @NotNull
    private static String cTAbstractUnCheckXML = "<w:abstractNum xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:abstractNumId=\"1\"><w:multiLevelType w:val=\"hybridMultilevel\"/><w:lvl w:ilvl=\"0\"><w:start w:val=\"1\"/><w:numFmt w:val=\"bullet\"/><w:lvlText w:val=\"o\"/><w:lvlJc w:val=\"left\"/><w:pPr><w:ind w:left=\"360\" w:hanging=\"360\"/></w:pPr><w:rPr><w:sz w:val=\"22\"/><w:rFonts w:ascii=\"Wingdings\" w:hAnsi=\"Wingdings\" w:hint=\"default\"/></w:rPr></w:lvl></w:abstractNum>";

    @NotNull
    private static String cTAbstractNumBulletXML = "<w:abstractNum xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:abstractNumId=\"2\"><w:multiLevelType w:val=\"hybridMultilevel\"/><w:lvl w:ilvl=\"0\"><w:start w:val=\"1\"/><w:numFmt w:val=\"bullet\"/><w:lvlText w:val=\"\u009f\"/><w:lvlJc w:val=\"left\"/><w:pPr><w:ind w:left=\"360\" w:hanging=\"360\"/></w:pPr><w:rPr><w:sz w:val=\"22\"/><w:rFonts w:ascii=\"Wingdings\" w:hAnsi=\"Wingdings\" w:hint=\"default\"/></w:rPr></w:lvl></w:abstractNum>";

    @NotNull
    private static String cTAbstractNumDecimalXML = "<w:abstractNum xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\" w:abstractNumId=\"3\"><w:multiLevelType w:val=\"hybridMultilevel\"/><w:lvl w:ilvl=\"0\"><w:start w:val=\"1\"/><w:numFmt w:val=\"decimal\"/><w:lvlText w:val=\"%1.\"/><w:lvlJc w:val=\"left\"/><w:pPr><w:ind w:left=\"360\" w:hanging=\"360\"/></w:pPr><w:rPr><w:sz w:val=\"22\"/></w:rPr></w:lvl></w:abstractNum>";

    private Constants() {
    }

    @NotNull
    public final String getCTAbstractCheckXML() {
        return cTAbstractCheckXML;
    }

    @NotNull
    public final String getCTAbstractNumBulletXML() {
        return cTAbstractNumBulletXML;
    }

    @NotNull
    public final String getCTAbstractNumDecimalXML() {
        return cTAbstractNumDecimalXML;
    }

    @NotNull
    public final String getCTAbstractUnCheckXML() {
        return cTAbstractUnCheckXML;
    }

    public final void setCTAbstractCheckXML(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        cTAbstractCheckXML = str;
    }

    public final void setCTAbstractNumBulletXML(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        cTAbstractNumBulletXML = str;
    }

    public final void setCTAbstractNumDecimalXML(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        cTAbstractNumDecimalXML = str;
    }

    public final void setCTAbstractUnCheckXML(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        cTAbstractUnCheckXML = str;
    }
}
