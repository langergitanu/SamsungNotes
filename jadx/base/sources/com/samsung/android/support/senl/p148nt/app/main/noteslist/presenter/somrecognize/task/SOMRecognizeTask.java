package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.task;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.util.Pair;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.SOMRecognizeUtil;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.model.RecognizeTextInfo;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.CustomLinkSpec;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.link.CustomLinkify;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f*\u0001\u000e\u0018\u0000 C2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0005?@ABCB!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J*\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J:\u0010\u001f\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0003H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0)H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0)2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u001a\u00100\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\bH\u0002J \u00104\u001a\u0002052\u0006\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u000205H\u0002J\b\u00109\u001a\u00020\nH\u0002J \u0010:\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\bH\u0002J\u0018\u0010<\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010=\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010>\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006D"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Landroidx/core/util/Pair;", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "Lcom/samsung/android/support/senl/nt/data/database/core/document/entity/NotesOrganizedDocumentEntity;", "contract", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$Contract;", NotesConstants.KEY_CALLER, "", "doNotRetry", "", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$Contract;Ljava/lang/String;Z)V", "result", "com/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$result$1", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$result$1;", "execute", "", "taskParams", "getTag", "getResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "getRecognizeState", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$RecognizeState;", "organizeDocumentEntity", "modifiedTime", "", "recognizedLanguage", "recognizerDBVersion", "getRecognizeStateMsg", "recognizeState", "setOrganizeDocumentEntity", "uuid", "contents", RestoreDialogFragment.KEY_LAST_MODIFIED_TIME, "recognizeNoteHandwritingData", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/model/RecognizeTextInfo;", "context", "Landroid/content/Context;", "noteData", "generateCustomTextInfoFromTextInfo", "", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$CustomTextInfo;", "textInfos", "Lcom/samsung/android/support/senl/nt/model/collector/recognition/data/TextInfo;", "generateRecognizeInfoFromCustomTextInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$RecognizeInfo;", "customTextInfos", "closeWNote", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "filePath", "getWordCount", "", "customTextInfo", "strBlock", "wordIndex", "isNeedToStopTask", "onSuccess", "msg", "onIgnored", "onRetry", "onFailed", "RecognizeState", "RecognizeInfo", "CustomTextInfo", "Contract", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSOMRecognizeTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SOMRecognizeTask.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,375:1\n37#2:376\n36#2,3:377\n*S KotlinDebug\n*F\n+ 1 SOMRecognizeTask.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask\n*L\n187#1:376\n187#1:377,3\n*E\n"})
public final class SOMRecognizeTask extends WorkerTask<Pair<MainListDocumentData, NotesOrganizedDocumentEntity>> {

    @NotNull
    private static final String TAG = "SOMRecognizeTask";

    @NotNull
    private final String caller;

    @NotNull
    private final Contract contract;
    private final boolean doNotRetry;

    @NotNull
    private final SOMRecognizeTask$result$1 result;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$Contract;", "", "onSuccess", "", "uuid", "", "modifiedTime", "", "msg", "onIgnored", "onRetry", "onFailed", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onFailed(@Nullable String uuid, long modifiedTime);

        void onIgnored(@Nullable String uuid, long modifiedTime);

        void onRetry(@Nullable String uuid);

        void onSuccess(@Nullable String uuid, long modifiedTime, @Nullable String msg);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$CustomTextInfo;", "", "<init>", "()V", "originalStr", "", "getOriginalStr", "()Ljava/lang/String;", "setOriginalStr", "(Ljava/lang/String;)V", "words", "", "getWords", "()Ljava/util/List;", "wordColors", "", "getWordColors", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CustomTextInfo {

        @NotNull
        private String originalStr = "";

        @NotNull
        private final List<String> words = new ArrayList();

        @NotNull
        private final List<Integer> wordColors = new ArrayList();

        @NotNull
        public final String getOriginalStr() {
            return this.originalStr;
        }

        @NotNull
        public final List<Integer> getWordColors() {
            return this.wordColors;
        }

        @NotNull
        public final List<String> getWords() {
            return this.words;
        }

        public final void setOriginalStr(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.originalStr = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$RecognizeInfo;", "", "str", "", "strokeColor", "", "<init>", "(Ljava/lang/String;I)V", "getStr", "()Ljava/lang/String;", "getStrokeColor", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class RecognizeInfo {

        @NotNull
        private final String str;
        private final int strokeColor;

        public RecognizeInfo(@NotNull String str, int i) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.str = str;
            this.strokeColor = i;
        }

        public static /* synthetic */ RecognizeInfo copy$default(RecognizeInfo recognizeInfo, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = recognizeInfo.str;
            }
            if ((i2 & 2) != 0) {
                i = recognizeInfo.strokeColor;
            }
            return recognizeInfo.copy(str, i);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getStr() {
            return this.str;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStrokeColor() {
            return this.strokeColor;
        }

        @NotNull
        public final RecognizeInfo copy(@NotNull String str, int strokeColor) {
            Intrinsics.checkNotNullParameter(str, "str");
            return new RecognizeInfo(str, strokeColor);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecognizeInfo)) {
                return false;
            }
            RecognizeInfo recognizeInfo = (RecognizeInfo) other;
            return Intrinsics.areEqual(this.str, recognizeInfo.str) && this.strokeColor == recognizeInfo.strokeColor;
        }

        @NotNull
        public final String getStr() {
            return this.str;
        }

        public final int getStrokeColor() {
            return this.strokeColor;
        }

        public int hashCode() {
            return Integer.hashCode(this.strokeColor) + (this.str.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return AbstractC1974b.m1319l("RecognizeInfo(str=", this.strokeColor, this.str, ", strokeColor=", ")");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/somrecognize/task/SOMRecognizeTask$RecognizeState;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "CREATE_ENTITY", "UPDATE_ENTITY_BY_CHANGED_MODIFIED_TIME", "UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_LANGUAGE", "UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_DB_VERSION", "UPDATE_ENTITY_BY_EMPTY_CONTENT", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class RecognizeState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecognizeState[] $VALUES;
        public static final RecognizeState NONE = new RecognizeState(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final RecognizeState CREATE_ENTITY = new RecognizeState("CREATE_ENTITY", 1);
        public static final RecognizeState UPDATE_ENTITY_BY_CHANGED_MODIFIED_TIME = new RecognizeState("UPDATE_ENTITY_BY_CHANGED_MODIFIED_TIME", 2);
        public static final RecognizeState UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_LANGUAGE = new RecognizeState("UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_LANGUAGE", 3);
        public static final RecognizeState UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_DB_VERSION = new RecognizeState("UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_DB_VERSION", 4);
        public static final RecognizeState UPDATE_ENTITY_BY_EMPTY_CONTENT = new RecognizeState("UPDATE_ENTITY_BY_EMPTY_CONTENT", 5);

        private static final /* synthetic */ RecognizeState[] $values() {
            return new RecognizeState[]{NONE, CREATE_ENTITY, UPDATE_ENTITY_BY_CHANGED_MODIFIED_TIME, UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_LANGUAGE, UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_DB_VERSION, UPDATE_ENTITY_BY_EMPTY_CONTENT};
        }

        static {
            RecognizeState[] recognizeStateArr$values = $values();
            $VALUES = recognizeStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(recognizeStateArr$values);
        }

        private RecognizeState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RecognizeState> getEntries() {
            return $ENTRIES;
        }

        public static RecognizeState valueOf(String str) {
            return (RecognizeState) Enum.valueOf(RecognizeState.class, str);
        }

        public static RecognizeState[] values() {
            return (RecognizeState[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecognizeState.values().length];
            try {
                iArr[RecognizeState.CREATE_ENTITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecognizeState.UPDATE_ENTITY_BY_CHANGED_MODIFIED_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RecognizeState.UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_LANGUAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RecognizeState.UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_DB_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RecognizeState.UPDATE_ENTITY_BY_EMPTY_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SOMRecognizeTask(Contract contract, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(contract, str, (i & 4) != 0 ? false : z);
    }

    private final void closeWNote(SpenWNote wNote, String filePath) {
        if (wNote == null || wNote.isClosed()) {
            return;
        }
        try {
            DocumentFileManager.getInstance().close(filePath, wNote, true);
        } catch (IOException e) {
            MainLogger.m7259w(getTag(), "closeWNote, e: " + e.getMessage());
        }
    }

    private final List<CustomTextInfo> generateCustomTextInfoFromTextInfo(List<? extends TextInfo> textInfos) {
        ArrayList arrayList = new ArrayList();
        for (TextInfo textInfo : textInfos) {
            if (textInfo.linkType == -1 && !TextUtils.isEmpty(textInfo.originalStr)) {
                CustomTextInfo customTextInfo = new CustomTextInfo();
                String originalStr = textInfo.originalStr;
                Intrinsics.checkNotNullExpressionValue(originalStr, "originalStr");
                customTextInfo.setOriginalStr(originalStr);
                arrayList.add(customTextInfo);
            }
        }
        int i = -1;
        for (TextInfo textInfo2 : textInfos) {
            if (textInfo2.linkType == -1) {
                if (!TextUtils.isEmpty(textInfo2.originalStr)) {
                    i++;
                }
                List<String> words = ((CustomTextInfo) arrayList.get(i)).getWords();
                String str = textInfo2.str;
                Intrinsics.checkNotNullExpressionValue(str, "str");
                words.add(str);
                ((CustomTextInfo) arrayList.get(i)).getWordColors().add(Integer.valueOf(textInfo2.strokeColor));
            }
        }
        return arrayList;
    }

    private final List<RecognizeInfo> generateRecognizeInfoFromCustomTextInfo(List<CustomTextInfo> customTextInfos) {
        ArrayList arrayList = new ArrayList();
        int size = customTextInfos.size();
        int i = 0;
        while (i < size) {
            CustomTextInfo customTextInfo = customTextInfos.get(i);
            ArrayList<CustomLinkSpec> arrayListAddLinks = CustomLinkify.getInstance(BaseUtils.getApplicationContext()).addLinks(customTextInfo.getOriginalStr(), 63);
            Intrinsics.checkNotNullExpressionValue(arrayListAddLinks, "addLinks(...)");
            int size2 = arrayListAddLinks.size();
            String str = i == 0 ? "" : Constant.NEW_LINE_STRING;
            int i2 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i2 < size2) {
                int start = arrayListAddLinks.get(i2).getStart();
                int end = arrayListAddLinks.get(i2).getEnd();
                if (i4 < start) {
                    String strSubstring = customTextInfo.getOriginalStr().substring(i4, start);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    for (int wordCount = getWordCount(customTextInfo, strSubstring, i5); i5 < wordCount; wordCount = wordCount) {
                        int i6 = size;
                        arrayList.add(new RecognizeInfo(str + ((Object) customTextInfo.getWords().get(i5)), customTextInfo.getWordColors().get(i5).intValue()));
                        str = Constant.WHITE_SPACE_STRING;
                        i5++;
                        size = i6;
                    }
                }
                int i7 = size;
                String strSubstring2 = customTextInfo.getOriginalStr().substring(start, end);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                int wordCount2 = getWordCount(customTextInfo, strSubstring2, i5);
                while (i5 < wordCount2) {
                    arrayList.add(new RecognizeInfo(str + ((Object) customTextInfo.getWords().get(i5)), customTextInfo.getWordColors().get(i5).intValue()));
                    str = Constant.WHITE_SPACE_STRING;
                    i5++;
                }
                i2++;
                i4 = end;
                size = i7;
            }
            int i8 = size;
            while (i5 < customTextInfo.getWords().size()) {
                arrayList.add(new RecognizeInfo(str + ((Object) customTextInfo.getWords().get(i5)), customTextInfo.getWordColors().get(i5).intValue()));
                str = Constant.WHITE_SPACE_STRING;
                i5++;
            }
            i++;
            size = i8;
        }
        return arrayList;
    }

    private final RecognizeState getRecognizeState(NotesOrganizedDocumentEntity organizeDocumentEntity, long modifiedTime, String recognizedLanguage, String recognizerDBVersion) {
        if (organizeDocumentEntity == null) {
            return RecognizeState.CREATE_ENTITY;
        }
        Long modifiedTime2 = organizeDocumentEntity.getModifiedTime();
        return (modifiedTime2 != null && modifiedTime == modifiedTime2.longValue()) ? !Intrinsics.areEqual(recognizedLanguage, organizeDocumentEntity.getRecognizedLanguage()) ? RecognizeState.UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_LANGUAGE : (Intrinsics.areEqual(recognizerDBVersion, organizeDocumentEntity.getRecognizerDBVersion()) || !Intrinsics.areEqual(recognizedLanguage, organizeDocumentEntity.getRecognizedLanguage())) ? TextUtils.isEmpty(organizeDocumentEntity.getContents()) ? RecognizeState.UPDATE_ENTITY_BY_EMPTY_CONTENT : RecognizeState.NONE : RecognizeState.UPDATE_ENTITY_BY_CHANGED_RECOGNIZED_DB_VERSION : RecognizeState.UPDATE_ENTITY_BY_CHANGED_MODIFIED_TIME;
    }

    private final String getRecognizeStateMsg(RecognizeState recognizeState) {
        int i = WhenMappings.$EnumSwitchMapping$0[recognizeState.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "[update entity, content is invalid]" : "[update entity, recognized db version changed]" : "[update entity, recognized language changed]" : "[update entity, modified time changed]" : "[create entity]";
    }

    private final int getWordCount(CustomTextInfo customTextInfo, String strBlock, int wordIndex) {
        while (wordIndex < customTextInfo.getWords().size() && StringsKt.m14162r(strBlock, customTextInfo.getWords().get(wordIndex))) {
            wordIndex++;
        }
        return wordIndex;
    }

    private final boolean isNeedToStopTask() {
        return ComposerManager.INSTANCE.getInstance().isRunningOnEditMode();
    }

    private final void onFailed(String uuid, String caller) {
        MainLogger.m7255e(getTag(), "onFailed, uuid: " + uuid + ", caller: " + caller);
        if (TextUtils.isEmpty(uuid)) {
            return;
        }
        this.contract.onFailed(uuid, -1L);
    }

    private final void onIgnored(String uuid, long modifiedTime) {
        MainLogger.m7254d(getTag(), "onIgnored, uuid: " + uuid + ", caller: " + this.caller);
        this.contract.onIgnored(uuid, modifiedTime);
    }

    private final void onRetry(String uuid, String caller) {
        MainLogger.m7254d(getTag(), "onRetry, uuid: " + uuid + ", caller: " + caller);
        this.contract.onRetry(uuid);
    }

    private final void onSuccess(String uuid, long modifiedTime, String msg) {
        MainLogger.m7254d(getTag(), "onSuccess, uuid: " + uuid + ", caller: " + this.caller);
        this.contract.onSuccess(uuid, modifiedTime, msg);
    }

    private final RecognizeTextInfo recognizeNoteHandwritingData(Context context, MainListDocumentData noteData) {
        SpenWNote spenWNote = NotesUtils.INSTANCE.getSpenWNote(context, noteData.getFilePath(), false, SpenDocumentDisplayUtils.getScreenWidth(context));
        if (spenWNote == null) {
            MainLogger.m7259w(getTag(), "recognizeNoteHandwritingData, SPenWNote is null");
            return null;
        }
        if (isNeedToStopTask()) {
            MainLogger.m7259w(getTag(), "recognizeNoteHandwritingData, isNeedToStopTask");
            String filePath = noteData.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            closeWNote(spenWNote, filePath);
            return null;
        }
        List<TextInfo> listRecognizeWord = SOMRecognizeUtil.recognizeWord(context, spenWNote, noteData.getUuid());
        if (isNeedToStopTask()) {
            Intrinsics.checkNotNull(listRecognizeWord);
            String string = Arrays.toString(listRecognizeWord.toArray(new TextInfo[0]));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            MainLogger.m7259w(TAG, "recognizeNoteHandwritingData, isNeedToStopTask, " + MainLogger.getEncode(string));
            String filePath2 = noteData.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath2, "getFilePath(...)");
            closeWNote(spenWNote, filePath2);
            return null;
        }
        RecognizeTextInfo recognizeTextInfo = new RecognizeTextInfo("");
        Intrinsics.checkNotNull(listRecognizeWord);
        for (RecognizeInfo recognizeInfo : generateRecognizeInfoFromCustomTextInfo(generateCustomTextInfoFromTextInfo(listRecognizeWord))) {
            recognizeTextInfo.putContentInfo(recognizeInfo.getStr(), SOMRecognizeUtil.getConvertedColor(recognizeInfo.getStrokeColor()));
        }
        MainLogger.m7254d(TAG, "recognizeNoteHandwritingData, " + MainLogger.getEncode(recognizeTextInfo.toString()));
        String filePath3 = noteData.getFilePath();
        Intrinsics.checkNotNullExpressionValue(filePath3, "getFilePath(...)");
        closeWNote(spenWNote, filePath3);
        return recognizeTextInfo;
    }

    private final void setOrganizeDocumentEntity(NotesOrganizedDocumentEntity organizeDocumentEntity, String uuid, String contents, String recognizedLanguage, String recognizerDBVersion, long lastModifiedTime) {
        if (organizeDocumentEntity == null || TextUtils.isEmpty(contents)) {
            return;
        }
        organizeDocumentEntity.setUuid(uuid);
        organizeDocumentEntity.setContents(contents);
        organizeDocumentEntity.setRecognizedLanguage(recognizedLanguage);
        organizeDocumentEntity.setRecognizerDBVersion(recognizerDBVersion);
        organizeDocumentEntity.setModifiedTime(Long.valueOf(lastModifiedTime));
        SOMRecognizeUtil.setOrganizeDocumentEntity(organizeDocumentEntity);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult */
    public WorkerTask.Result getTaskResult() {
        return this.result;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return AbstractC0541b.m767i(hashCode(), "SOMRecognizeTask[", "]");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask$result$1] */
    public SOMRecognizeTask(@NotNull Contract contract, @NotNull String caller, boolean z) {
        super(0, null, 3, null);
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(caller, "caller");
        this.contract = contract;
        this.caller = caller;
        this.doNotRetry = z;
        this.result = new WorkerTask.Result() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.somrecognize.task.SOMRecognizeTask$result$1
            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public int getHashCode() {
                return 0;
            }

            @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
            public String getTag() {
                return "SOMRecognizeTask";
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable Pair<MainListDocumentData, NotesOrganizedDocumentEntity> taskParams) throws Throwable {
        if (taskParams == null) {
            return;
        }
        MainListDocumentData mainListDocumentData = taskParams.first;
        NotesOrganizedDocumentEntity notesOrganizedDocumentEntity = taskParams.second;
        String uuid = mainListDocumentData.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid, "getUuid(...)");
        long lastModifiedAt = mainListDocumentData.getLastModifiedAt();
        String str = this.caller;
        int isSavingByWhichPid = mainListDocumentData.getIsSavingByWhichPid();
        boolean z = this.doNotRetry;
        StringBuilder sbM16m = AbstractC0000a.m16m("execute, uuid: ", uuid, ", caller: ", str, ", saving pid: ");
        sbM16m.append(isSavingByWhichPid);
        sbM16m.append(", DoNotRetry : ");
        sbM16m.append(z);
        MainLogger.m7254d(TAG, sbM16m.toString());
        if (mainListDocumentData.getIsSavingByWhichPid() != 0) {
            if (this.doNotRetry) {
                onFailed(uuid, AbstractC0541b.m773o("execute, caller: [", this.caller, "] (Note File Still Saving)"));
                return;
            } else {
                onRetry(uuid, AbstractC0541b.m773o("execute, caller: [", this.caller, "] (Note File Still Saving)"));
                return;
            }
        }
        String hWRLanguage = RecognitionUtil.getHWRLanguage(BaseUtils.getContext());
        String recognizerDBVersion = RecognitionUtil.getRecognizerDBVersion();
        Intrinsics.checkNotNull(hWRLanguage);
        Intrinsics.checkNotNull(recognizerDBVersion);
        RecognizeState recognizeState = getRecognizeState(notesOrganizedDocumentEntity, lastModifiedAt, hWRLanguage, recognizerDBVersion);
        String recognizeStateMsg = getRecognizeStateMsg(recognizeState);
        if (TextUtils.isEmpty(recognizeStateMsg)) {
            onIgnored(uuid, lastModifiedAt);
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        Intrinsics.checkNotNull(mainListDocumentData);
        RecognizeTextInfo recognizeTextInfoRecognizeNoteHandwritingData = recognizeNoteHandwritingData(applicationContext, mainListDocumentData);
        if (recognizeTextInfoRecognizeNoteHandwritingData == null) {
            if (this.doNotRetry) {
                onFailed(uuid, AbstractC0541b.m773o("execute, caller: [", this.caller, "] (recognizeNoteHandwritingData failed)"));
                return;
            } else {
                onRetry(uuid, AbstractC0541b.m773o("execute, caller: [", this.caller, "] (recognizeNoteHandwritingData failed)"));
                return;
            }
        }
        if (recognizeState == RecognizeState.CREATE_ENTITY) {
            notesOrganizedDocumentEntity = new NotesOrganizedDocumentEntity();
        }
        String string = recognizeTextInfoRecognizeNoteHandwritingData.getContentsInfo().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        setOrganizeDocumentEntity(notesOrganizedDocumentEntity, uuid, string, hWRLanguage, recognizerDBVersion, lastModifiedAt);
        onSuccess(uuid, lastModifiedAt, recognizeStateMsg);
    }
}
