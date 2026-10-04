package com.samsung.android.app.notes.widget.capture;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.widget.capture.CacheFileManager;
import com.samsung.android.app.notes.widget.theme.ThemeInfo;
import com.samsung.android.app.notes.widget.util.WidgetUtils;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.display.DisplayDeviceTypeCompat;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.SpenOpenModeManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.HomeScreenUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.widget.util.BaseWidgetUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    jadx.core.utils.exceptions.JadxRuntimeException: CodeVar not initialized for name set in SSAVar: r23v0 ??
    	at jadx.core.dex.instructions.args.SSAVar.setName(SSAVar.java:216)
    	at jadx.core.dex.instructions.args.RegisterArg.setName(RegisterArg.java:111)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.renameMethodArgs(KotlinMetadataDecompilePass.kt:56)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:36)
    */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fJ2\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0002J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J0\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0002JX\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0002J \u0010%\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0011H\u0002J(\u0010(\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000f\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0002J*\u0010+\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\u0011H\u0002J:\u0010+\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010-\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u0015J\u0018\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002J\u0018\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u001bH\u0002J2\u00106\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000eH\u0002J(\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000eH\u0002J0\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0002¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/TextOnlyNoteManager;", "", "<init>", "()V", "captureTextOnlyBitmap", "", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "dataInfo", "Lcom/samsung/android/app/notes/widget/capture/CacheFileManager$CacheDataInfo;", "uuid", "", "widgetId", "", "widgetWidth", "isDarkMode", "", "shortcut", "providerName", "createScaledTextOnlyNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "path", "updateTextSection", "", "wNote", ExternalDataConstants.Column.BODY_TEXT, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "pageWidth", "scaleFontSize", "updateFontSizeSpan", "screenWidth", "spanList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/document/textspan/SpenTextSpanBase;", "Lkotlin/collections/ArrayList;", "widgetAddDisplayType", "getShortcutFontSize", "prevFontSize", "", "getFontSize", "isSingleMedium", "getSingleMediumFontSize", "createTextOnlyNote", "filePath", "isListMode", "originalNote", "copyPageInfo", "srcPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "dstPage", "copyBodyTextInfo", "srcBodyText", "dstBodyText", "copyBodyTextSinglePage", "newTextOnlyNote", "pageHeight", "copyBodyTextPage", "originalBodyText", "newBodyText", "page", "startPosition", "captureBitmap", "captureManager", "Lcom/samsung/android/app/notes/widget/capture/CaptureManager;", "pageCount", "themeInfo", "Lcom/samsung/android/app/notes/widget/theme/ThemeInfo;", "Companion", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TextOnlyNoteManager {
    public static final int $stable = 0;
    private static final float COVER_MEDIUM_WIDGET_FONT_RATIO = 2.0f;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int DEFAULT_FONT_SIZE = 17;
    private static final int FIRST_PAGE = 0;
    private static final float FOLD_SHORTCUT_WIDGET_FONT_RATIO = 2.0f;
    private static final float LARGER_SCREEN_SIZE_ADJUST_VALUE = 6.0f;
    private static final float NEW_ONEUI_SIZE_ADJUST_VALUE = 0.7f;
    private static final int SECOND_PAGE = 1;
    private static final float SHORTCUT_WIDGET_FONT_RATIO = 1.6f;
    private static final float SHORTCUT_WIDGET_FONT_TABLET_RATIO = 1.3f;
    private static final float SMALLER_SCREEN_SIZE_ADJUST_VALUE = 5.0f;

    @NotNull
    private static final String TAG = "TextOnlyNoteManager";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/app/notes/widget/capture/TextOnlyNoteManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DEFAULT_FONT_SIZE", "", "FIRST_PAGE", "SECOND_PAGE", "LARGER_SCREEN_SIZE_ADJUST_VALUE", "", "SMALLER_SCREEN_SIZE_ADJUST_VALUE", "NEW_ONEUI_SIZE_ADJUST_VALUE", "SHORTCUT_WIDGET_FONT_RATIO", "SHORTCUT_WIDGET_FONT_TABLET_RATIO", "FOLD_SHORTCUT_WIDGET_FONT_RATIO", "COVER_MEDIUM_WIDGET_FONT_RATIO", "ntHomeWidget_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final List<Bitmap> captureBitmap(CaptureManager captureManager, int i, int i2, ThemeInfo themeInfo) {
        ArrayList arrayList = new ArrayList(i);
        if (!captureManager.isListPageMode()) {
            return TypeIntrinsics.asMutableList(captureManager.captureSinglePage(i, themeInfo));
        }
        for (int i4 = 0; i4 < i; i4++) {
            Bitmap bitmapCaptureListPage = captureManager.captureListPage(i4, i2, themeInfo);
            if (bitmapCaptureListPage != null) {
                arrayList.add(bitmapCaptureListPage);
            }
        }
        return arrayList;
    }

    private final void copyBodyTextInfo(SpenObjectTextBox spenObjectTextBox, SpenObjectTextBox spenObjectTextBox2) {
        spenObjectTextBox2.setMargin(spenObjectTextBox.getLeftMargin(), spenObjectTextBox.getTopMargin(), spenObjectTextBox.getRightMargin(), spenObjectTextBox.getBottomMargin());
        spenObjectTextBox2.setTextAlignment(spenObjectTextBox.getTextAlignment());
        spenObjectTextBox2.setFontSize(spenObjectTextBox.getFontSize());
        spenObjectTextBox2.setTextColor(spenObjectTextBox.getTextColor());
        spenObjectTextBox2.setTextLimit(spenObjectTextBox.getTextLimit());
        spenObjectTextBox2.setAutoFitOption(spenObjectTextBox.getAutoFitOption());
    }

    private final int copyBodyTextPage(SpenObjectTextBox spenObjectTextBox, SpenObjectTextBox spenObjectTextBox2, int i, int i2) {
        int textSectionStart = spenObjectTextBox.getTextSectionStart(i);
        int textSectionLength = spenObjectTextBox.getTextSectionLength(i);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, textSectionStart, "copyBodyTextPage# ", " - ", SQLKeyword.COMMA);
        sbM1173s.append(textSectionLength);
        Logger.m8697d(TAG, sbM1173s.toString());
        if (textSectionStart >= 0 && textSectionLength > 0) {
            spenObjectTextBox2.insertText(i2, spenObjectTextBox, textSectionStart, textSectionLength);
        }
        return textSectionLength;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void copyBodyTextSinglePage(Context context, SpenWNote spenWNote, SpenWNote spenWNote2, int i, int i2) {
        int i4;
        int lineEndIndex;
        int iMin;
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
        spenBodyTextContext.setDocument(spenWNote);
        spenBodyTextContext.measureText();
        int lineCount = spenBodyTextContext.getLineCount();
        int i5 = lineCount - 1;
        float f = i2 * 2;
        if (spenBodyTextContext.getLinePosition(i5).bottom > f) {
            for (int i6 = 0; i6 < lineCount; i6++) {
                if (spenBodyTextContext.getLinePosition(i6).bottom > f) {
                    lineEndIndex = spenBodyTextContext.getLineEndIndex(i6);
                }
            }
            i4 = 0;
            spenBodyTextContext.close();
            SpenObjectTextBox bodyText = spenWNote.getBodyText();
            iMin = (int) Math.min(i4, bodyText.getText() == null ? r6.length() : 0.0d);
            AbstractC4539a.m3203m(iMin, "copyBodyTextSinglePage# ", TAG);
            if (iMin <= 0) {
                spenWNote2.getBodyText().insertText(0, bodyText, 0, iMin);
                spenWNote2.getPage(0).setSize(i, i2 * 3);
                return;
            }
            return;
        }
        lineEndIndex = spenBodyTextContext.getLineEndIndex(i5);
        i4 = lineEndIndex + 1;
        spenBodyTextContext.close();
        SpenObjectTextBox bodyText2 = spenWNote.getBodyText();
        iMin = (int) Math.min(i4, bodyText2.getText() == null ? r6.length() : 0.0d);
        AbstractC4539a.m3203m(iMin, "copyBodyTextSinglePage# ", TAG);
        if (iMin <= 0) {
        }
    }

    private final void copyPageInfo(SpenWPage spenWPage, SpenWPage spenWPage2) {
        spenWPage2.setBackgroundColor(spenWPage.getBackgroundColor());
        spenWPage2.setTemplateType(spenWPage.getTemplateType());
        spenWPage2.setTemplateURI(spenWPage.getTemplateURI());
        spenWPage2.setBackgroundImageMode(spenWPage.getBackgroundImageMode());
        spenWPage2.setBackgroundImage(spenWPage.getBackgroundImagePath(), true);
    }

    private final SpenWNote createScaledTextOnlyNote(Context context, String path, int widgetWidth, boolean shortcut, String providerName) {
        try {
            SpenWNote spenWNoteOpen = DocumentFileManager.getInstance().open(context, path, widgetWidth, SpenOpenModeManager.INSTANCE.getInstance().use(4000, path), true, false, false);
            Intrinsics.checkNotNullExpressionValue(spenWNoteOpen, "open(...)");
            SpenObjectTextBox bodyText = spenWNoteOpen.getBodyText();
            try {
                scaleFontSize(context, bodyText, widgetWidth, shortcut, providerName);
                int height = DocumentPageRatio.PAGE_RATIO.getHeight(widgetWidth);
                if (spenWNoteOpen.getPageMode() == SpenWNote.PageMode.LIST) {
                    updateTextSection(context, spenWNoteOpen, bodyText, widgetWidth);
                    return spenWNoteOpen;
                }
                spenWNoteOpen.getPage(0).setSize(widgetWidth, height * 3);
                return spenWNoteOpen;
            } catch (Exception e) {
                e = e;
                AbstractC4539a.m3214x("createScaledTextOnlyNote# Failed to open a SpenWNote ", e.getMessage(), TAG);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private final void createTextOnlyNote(Context context, String filePath, String uuid, boolean isListMode) throws Throwable {
        Throwable th;
        SpenWNote spenWNoteOpen;
        int iMin = (int) Math.min(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
        SpenWNote spenWNote = null;
        try {
            try {
                spenWNoteOpen = DocumentFileManager.getInstance().open(context, filePath, iMin, SpenOpenModeManager.INSTANCE.getInstance().use(4000, filePath), true, false, false);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            createTextOnlyNote(context, filePath, uuid, isListMode, iMin, spenWNoteOpen);
            try {
                DocumentFileManager.getInstance().close(filePath, spenWNoteOpen, true);
            } catch (IOException e2) {
                e = e2;
                AbstractC4539a.m3214x("createTextOnlyNote# closeException - ", e.getMessage(), TAG);
            }
        } catch (Exception e3) {
            e = e3;
            spenWNote = spenWNoteOpen;
            Logger.m8698e(TAG, "createTextOnlyNote# exception - " + e.getMessage());
            try {
                DocumentFileManager.getInstance().close(filePath, spenWNote, true);
            } catch (IOException e5) {
                e = e5;
                AbstractC4539a.m3214x("createTextOnlyNote# closeException - ", e.getMessage(), TAG);
            }
        } catch (Throwable th3) {
            th = th3;
            spenWNote = spenWNoteOpen;
            try {
                DocumentFileManager.getInstance().close(filePath, spenWNote, true);
            } catch (IOException e6) {
                AbstractC4539a.m3214x("createTextOnlyNote# closeException - ", e6.getMessage(), TAG);
            }
            SpenOpenModeManager.INSTANCE.getInstance().disuse(filePath);
            throw th;
        }
        SpenOpenModeManager.INSTANCE.getInstance().disuse(filePath);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int getFontSize(Context context, float prevFontSize, float widgetWidth, float screenWidth) {
        int iRoundToInt;
        float f;
        float f4 = screenWidth / widgetWidth;
        float f5 = prevFontSize * f4;
        if (!SpenConfiguration.INSTANCE.isTabletUX(context)) {
            int iRoundToInt2 = MathKt.roundToInt(f5);
            StringBuilder sb = new StringBuilder("getFontSize# previewFontSize: ");
            sb.append(prevFontSize);
            sb.append(", fontSize: ");
            sb.append(iRoundToInt2);
            sb.append(",    adjustSize: 0.0, scale: ");
            AbstractC11014a.m12337v(sb, f4, " screenWidth: ", screenWidth, ", widgetWidth: ");
            sb.append(widgetWidth);
            Logger.m8697d(TAG, sb.toString());
            return MathKt.roundToInt(f5);
        }
        if (screenWidth <= widgetWidth) {
            iRoundToInt = MathKt.roundToInt((1.0f - f4) * 6.0f);
        } else {
            if (BaseWidgetUtils.INSTANCE.isSupportedNewWidget()) {
                f = 0.7f;
                float f6 = f5 * f;
                float f7 = f6 - ((float) 1) >= prevFontSize ? f5 : f6;
                int iRoundToInt3 = MathKt.roundToInt(f7);
                StringBuilder sbM1176v = AbstractC0622a.m1176v("getFontSize# previewFontSize: ", prevFontSize, ", fontSizeScale: ", f5, ", newFontSize: ");
                sbM1176v.append(f6);
                sbM1176v.append(", finalFontSize: ");
                sbM1176v.append(iRoundToInt3);
                sbM1176v.append(", adjustSize: ");
                AbstractC11014a.m12337v(sbM1176v, f, ", scale: ", f4, " screenWidth: ");
                sbM1176v.append(screenWidth);
                sbM1176v.append(", widgetWidth: ");
                sbM1176v.append(widgetWidth);
                Logger.m8697d(TAG, sbM1176v.toString());
                return MathKt.roundToInt(f7);
            }
            iRoundToInt = MathKt.roundToInt((1.0f - f4) * SMALLER_SCREEN_SIZE_ADJUST_VALUE);
        }
        f = iRoundToInt;
        float f62 = f5 * f;
        if (f62 - ((float) 1) >= prevFontSize) {
        }
        int iRoundToInt32 = MathKt.roundToInt(f7);
        StringBuilder sbM1176v2 = AbstractC0622a.m1176v("getFontSize# previewFontSize: ", prevFontSize, ", fontSizeScale: ", f5, ", newFontSize: ");
        sbM1176v2.append(f62);
        sbM1176v2.append(", finalFontSize: ");
        sbM1176v2.append(iRoundToInt32);
        sbM1176v2.append(", adjustSize: ");
        AbstractC11014a.m12337v(sbM1176v2, f, ", scale: ", f4, " screenWidth: ");
        sbM1176v2.append(screenWidth);
        sbM1176v2.append(", widgetWidth: ");
        sbM1176v2.append(widgetWidth);
        Logger.m8697d(TAG, sbM1176v2.toString());
        return MathKt.roundToInt(f7);
    }

    private final int getShortcutFontSize(Context context, float prevFontSize, boolean widgetAddDisplayType) {
        float f = (widgetAddDisplayType ? 2.0f : SpenConfiguration.INSTANCE.isTabletUX(context) ? 1.3f : SHORTCUT_WIDGET_FONT_RATIO) * prevFontSize;
        Logger.m8697d(TAG, "getShortcutFontSize# " + prevFontSize + " / " + f);
        return (int) f;
    }

    private final int getSingleMediumFontSize(float prevFontSize) {
        return (int) (prevFontSize * 2.0f);
    }

    private final boolean isSingleMedium(String providerName) {
        return Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_SINGLE_MEDIUM_COVER_PROVIDER_NAME) || Intrinsics.areEqual(providerName, BaseWidgetConstant.WIDGET_SINGLE_LOCK_BRIEF_PROVIDER_NAME);
    }

    private final void scaleFontSize(Context context, SpenObjectTextBox bodyText, int widgetWidth, boolean shortcut, String providerName) {
        int iMin;
        if (Build.VERSION.SDK_INT >= 30) {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            WindowMetrics maximumWindowMetrics = ((WindowManager) systemService).getMaximumWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(maximumWindowMetrics, "getMaximumWindowMetrics(...)");
            Rect bounds = maximumWindowMetrics.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            iMin = Math.min(bounds.width(), bounds.height());
            if (HomeScreenUtils.INSTANCE.isCurrentCoverScreenMirroringDisplay(context)) {
                iMin = bounds.width() / 2;
            }
        } else {
            iMin = (int) Math.min(Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels);
            if (HomeScreenUtils.INSTANCE.isCurrentCoverScreenMirroringDisplay(context)) {
                iMin = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
            }
        }
        int i = iMin;
        boolean z = HomeScreenUtils.INSTANCE.getWidgetAddDisplayType(context) == DisplayDeviceTypeCompat.DISPLAY_DEVICE_TYPE_SUB;
        ArrayList<SpenTextSpanBase> textSpan = bodyText.getTextSpan();
        if (textSpan != null && !textSpan.isEmpty()) {
            StringBuilder sbM2226q = AbstractC2821a.m2226q("scaleFontSize# screenWidth : ", i, ", updateFontSizeSpan : ", updateFontSizeSpan(context, bodyText, i, widgetWidth, shortcut, textSpan, z, providerName), ", widgetWidth: ");
            sbM2226q.append(widgetWidth);
            Logger.m8702i(TAG, sbM2226q.toString());
            return;
        }
        int shortcutFontSize = shortcut ? getShortcutFontSize(context, 17.0f, z) : isSingleMedium(providerName) ? getSingleMediumFontSize(17.0f) : getFontSize(context, 17.0f, widgetWidth, i);
        String text = bodyText.getText();
        Intrinsics.checkNotNull(text);
        bodyText.appendTextSpan(new SpenFontSizeSpan(0, text.length(), 3, shortcutFontSize));
        Logger.m8703w(TAG, "scaleFontSize# screenWidth : " + i + ", default size scale , widgetWidth: " + widgetWidth);
    }

    private final boolean updateFontSizeSpan(Context context, SpenObjectTextBox bodyText, int screenWidth, int widgetWidth, boolean shortcut, ArrayList<SpenTextSpanBase> spanList, boolean widgetAddDisplayType, String providerName) {
        Iterator<SpenTextSpanBase> it = spanList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        boolean z = false;
        while (it.hasNext()) {
            SpenTextSpanBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SpenTextSpanBase spenTextSpanBase = next;
            if (spenTextSpanBase.getType() == 3) {
                float size = ((SpenFontSizeSpan) spenTextSpanBase).getSize();
                SpenFontSizeSpan spenFontSizeSpan = new SpenFontSizeSpan(spenTextSpanBase.getStart(), spenTextSpanBase.getEnd(), spenTextSpanBase.getExpansion(), shortcut ? getShortcutFontSize(context, size, widgetAddDisplayType) : isSingleMedium(providerName) ? getSingleMediumFontSize(size) : getFontSize(context, size, widgetWidth, screenWidth));
                bodyText.removeTextSpan(spenTextSpanBase);
                bodyText.appendTextSpan(spenFontSizeSpan);
                z = true;
            }
        }
        return z;
    }

    private final void updateTextSection(Context context, SpenWNote wNote, SpenObjectTextBox bodyText, int pageWidth) {
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(context);
        spenBodyTextContext.setDocument(wNote);
        spenBodyTextContext.measureText();
        int i = 0;
        bodyText.setTextSectionData(0, -1, 0);
        bodyText.setTextSectionData(1, -1, 0);
        int height = DocumentPageRatio.PAGE_RATIO.getHeight(pageWidth);
        int lineCount = spenBodyTextContext.getLineCount();
        int i2 = 0;
        int lineStartIndex = 0;
        while (true) {
            if (i >= lineCount) {
                break;
            }
            int i4 = i2 + 1;
            if (spenBodyTextContext.getLinePosition(i).bottom > ((height - bodyText.getBottomMargin()) * i4) - (wNote.getPageVerticalPadding() * i2)) {
                bodyText.setTextSectionData(i2, lineStartIndex, (spenBodyTextContext.getLineEndIndex(i - 1) - lineStartIndex) + 1);
                lineStartIndex = spenBodyTextContext.getLineStartIndex(i);
                if (i4 >= 2) {
                    wNote.appendPage(pageWidth, height);
                    i2 = i4;
                    break;
                }
                i2 = i4;
            }
            i++;
        }
        bodyText.setTextSectionData(i2, lineStartIndex, (spenBodyTextContext.getLineEndIndex(spenBodyTextContext.getLineCount() - 1) - lineStartIndex) + 1);
        spenBodyTextContext.close();
    }

    @Nullable
    public final List<Bitmap> captureTextOnlyBitmap(@NotNull Context context, @Nullable CacheFileManager.CacheDataInfo dataInfo, @Nullable String uuid, int widgetId, int widgetWidth, boolean isDarkMode, boolean shortcut, @NotNull String providerName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        if (dataInfo == null || TextUtils.isEmpty(uuid)) {
            return new ArrayList();
        }
        String widgetCacheFilePath = WidgetUtils.INSTANCE.getWidgetCacheFilePath(context, "textOnly", String.valueOf(uuid));
        if (!FileUtils.exists(widgetCacheFilePath)) {
            Logger.m8702i(TAG, "captureTextOnlyBitmap# does not created text only note. reCreate.");
            createTextOnlyNote(context, String.valueOf(dataInfo.getMFilePath()), uuid, dataInfo.getMListMode());
        }
        SpenWNote spenWNoteCreateScaledTextOnlyNote = createScaledTextOnlyNote(context, widgetCacheFilePath, widgetWidth, shortcut, providerName);
        if (spenWNoteCreateScaledTextOnlyNote == null) {
            Logger.m8703w(TAG, "captureTextOnlyBitmap# fail to create text only wNote");
            return new ArrayList();
        }
        CaptureManager captureManager = new CaptureManager(context, spenWNoteCreateScaledTextOnlyNote, widgetCacheFilePath, true);
        int mPageCount = dataInfo.getMPageCount();
        int iMax = (int) Math.max(1.0d, spenWNoteCreateScaledTextOnlyNote.getPageCount() - 1);
        Logger.m8697d(TAG, "captureTextOnlyBitmap# pageCount: " + mPageCount + ", textPage: " + iMax);
        dataInfo.setTextPageCount(iMax);
        ThemeInfo themeInfo = new ThemeInfo(context, widgetId);
        List<Bitmap> listCaptureBitmap = captureBitmap(captureManager, (int) Math.min(iMax, 2.0d), widgetWidth, isDarkMode ? themeInfo.setForceContentsThemeColor(0) : themeInfo.setForceContentsThemeColor(1));
        captureManager.release();
        SpenOpenModeManager.INSTANCE.getInstance().disuse(widgetCacheFilePath);
        return listCaptureBitmap;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    public final void createTextOnlyNote(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */
}
