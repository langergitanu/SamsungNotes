package com.samsung.android.app.sdk.deepsky.textextraction.entity;

import android.app.RemoteAction;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.view.textclassifier.TextClassification;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.OcrEntityExtractor;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationConstants;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.util.EntityUtils;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import opennlp.tools.namefind.BilouCodec;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001:\u00045678B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J4\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0002J.\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\"J2\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0$0\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u001b\u0010%\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010'J(\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u0017H\u0002J/\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00069"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor;", "", "()V", SearchConstants.TargetContents.TAG, "", OcrEntityExtractor.WHITESPACE_BLOCK, OcrEntityExtractor.WHITESPACE_LINE, OcrEntityExtractor.WHITESPACE_WORD, "adjustEmptyCharacterEndIndex", "", RtspHeaders.Values.SEQ, "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$CharacterSequence;", "index", "adjustEmptyCharacterStartIndex", "createPolyList", "", "", "Landroid/graphics/Point;", "start", "end", "entityType", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "createRectList", "Landroid/graphics/Rect;", "createUnderlineList", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/Underline;", "polyList", "extractEntity", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityExtractionResult;", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "entityTypes", "validRect", "textClassificationHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/textclassification/TextClassificationHelper;", "getLineIndexList", "Lkotlin/Pair;", "getUnderlineFromPoly", "poly", "([Landroid/graphics/Point;)Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/Underline;", "parseActionItems", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityItem;", "classification", "Landroid/view/textclassifier/TextClassification;", "sequence", VElementFormulasCmd.FSUM, "r1", "r2", "p1", "p2", "([Landroid/graphics/Point;[Landroid/graphics/Point;)[Landroid/graphics/Point;", "toCharacterSequence", "Character", "CharacterSequence", "SequenceBuilder", "WordMetaData", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOcrEntityExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1603#2,9:382\n1855#2:391\n1856#2:394\n1612#2:395\n1864#2,3:396\n350#2,7:399\n350#2,7:406\n1#3:392\n1#3:393\n*S KotlinDebug\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor\n*L\n69#1:382,9\n69#1:391\n69#1:394\n69#1:395\n106#1:396,3\n228#1:399,7\n238#1:406,7\n69#1:393\n*E\n"})
public final class OcrEntityExtractor {

    @NotNull
    public static final OcrEntityExtractor INSTANCE = new OcrEntityExtractor();

    @NotNull
    private static final String TAG = "OcrEntityExtractor";

    @NotNull
    private static final String WHITESPACE_BLOCK = "WHITESPACE_BLOCK";

    @NotNull
    private static final String WHITESPACE_LINE = "WHITESPACE_LINE";

    @NotNull
    private static final String WHITESPACE_WORD = "WHITESPACE_WORD";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$CharacterSequence;", "", "text", "", "data", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$Character;", "(Ljava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getText", "()Ljava/lang/String;", "addEntityTypeIdToMetaData", "", "classification", "Landroid/view/textclassifier/TextClassification;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nOcrEntityExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$CharacterSequence\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n766#2:382\n857#2,2:383\n1855#2:385\n1603#2,9:386\n1855#2:395\n1856#2:397\n1612#2:398\n1855#2,2:399\n1856#2:401\n1#3:396\n*S KotlinDebug\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$CharacterSequence\n*L\n249#1:382\n249#1:383,2\n261#1:385\n267#1:386,9\n267#1:395\n267#1:397\n267#1:398\n269#1:399,2\n261#1:401\n267#1:396\n*E\n"})
    public static final /* data */ class CharacterSequence {

        @NotNull
        private final List<Character> data;

        @NotNull
        private final String text;

        public CharacterSequence(@NotNull String text, @NotNull List<Character> data) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(data, "data");
            this.text = text;
            this.data = data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CharacterSequence copy$default(CharacterSequence characterSequence, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = characterSequence.text;
            }
            if ((i & 2) != 0) {
                list = characterSequence.data;
            }
            return characterSequence.copy(str, list);
        }

        public final void addEntityTypeIdToMetaData(@NotNull TextClassification classification) {
            Intrinsics.checkNotNullParameter(classification, "classification");
            List actions = classification.getActions();
            Intrinsics.checkNotNullExpressionValue(actions, "classification.actions");
            ArrayList<RemoteAction> arrayList = new ArrayList();
            for (Object obj : actions) {
                RemoteAction action = (RemoteAction) obj;
                EntityUtils entityUtils = EntityUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(action, "action");
                if (CollectionsKt.listOf((Object[]) new String[]{"phone", "phone_e164", "email", "url", "address", "date", "datetime", BilouCodec.UNIT}).contains(entityUtils.getEntityTypeID(classification, action))) {
                    arrayList.add(obj);
                }
            }
            for (RemoteAction action2 : arrayList) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    EntityUtils entityUtils2 = EntityUtils.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(action2, "action");
                    String entityTypeID = entityUtils2.getEntityTypeID(classification, action2);
                    List<Character> listSubList = this.data.subList(entityUtils2.getEntityStartIndex(classification, action2), entityUtils2.getEntityEndIndex(classification, action2));
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = listSubList.iterator();
                    while (it.hasNext()) {
                        WordMetaData metaData = ((Character) it.next()).getMetaData();
                        if (metaData != null) {
                            arrayList2.add(metaData);
                        }
                    }
                    Iterator it2 = CollectionsKt.toSet(arrayList2).iterator();
                    while (it2.hasNext()) {
                        ((WordMetaData) it2.next()).addEntityTypeId(entityTypeID);
                    }
                    Result.m22215constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
            }
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final List<Character> component2() {
            return this.data;
        }

        @NotNull
        public final CharacterSequence copy(@NotNull String text, @NotNull List<Character> data) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(data, "data");
            return new CharacterSequence(text, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CharacterSequence)) {
                return false;
            }
            CharacterSequence characterSequence = (CharacterSequence) other;
            return Intrinsics.areEqual(this.text, characterSequence.text) && Intrinsics.areEqual(this.data, characterSequence.data);
        }

        @NotNull
        public final List<Character> getData() {
            return this.data;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.data.hashCode() + (this.text.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "CharacterSequence(text=" + this.text + ", data=" + this.data + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ&\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$SequenceBuilder;", "", "()V", "buildBlock", "", "blockInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "isLastBlockInResult", "", RtspHeaders.Values.SEQ, "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$Character;", "buildLine", "lineInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", "isLastLineInBlock", "buildWord", "wordInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "isLastWordInLine", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nOcrEntityExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$SequenceBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1864#2,3:382\n1864#2,3:385\n1855#2:388\n1856#2:390\n1#3:389\n*S KotlinDebug\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$SequenceBuilder\n*L\n316#1:382,3\n338#1:385,3\n359#1:388\n359#1:390\n*E\n"})
    public static final class SequenceBuilder {
        private final void buildLine(OcrResult.LineInfo lineInfo, boolean isLastLineInBlock, List<Character> seq) {
            int lastIndex = CollectionsKt.getLastIndex(lineInfo.getWordInfo());
            int i = 0;
            for (Object obj : lineInfo.getWordInfo()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                buildWord((OcrResult.WordInfo) obj, i == lastIndex, seq, lineInfo);
                i = i2;
            }
            if (isLastLineInBlock) {
                return;
            }
            seq.add(new Character("\n", null, null, OcrEntityExtractor.WHITESPACE_LINE, null, null, 54, null));
        }

        private final void buildWord(OcrResult.WordInfo wordInfo, boolean isLastWordInLine, List<Character> seq, OcrResult.LineInfo lineInfo) {
            WordMetaData wordMetaData = new WordMetaData(wordInfo.getString());
            for (OcrResult.CharInfo charInfo : wordInfo.getCharInfo()) {
                String string = charInfo.getString();
                if (string != null) {
                    seq.add(new Character(string, lineInfo, wordInfo, "", charInfo.getPoly(), wordMetaData));
                }
            }
            if (isLastWordInLine) {
                return;
            }
            seq.add(new Character(" ", null, null, OcrEntityExtractor.WHITESPACE_WORD, null, null, 54, null));
        }

        public final void buildBlock(@NotNull OcrResult.BlockInfo blockInfo, boolean isLastBlockInResult, @NotNull List<Character> seq) {
            Intrinsics.checkNotNullParameter(blockInfo, "blockInfo");
            Intrinsics.checkNotNullParameter(seq, "seq");
            int lastIndex = CollectionsKt.getLastIndex(blockInfo.getLineInfo());
            int i = 0;
            for (Object obj : blockInfo.getLineInfo()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                buildLine((OcrResult.LineInfo) obj, i == lastIndex, seq);
                i = i2;
            }
            if (isLastBlockInResult) {
                return;
            }
            Character character = new Character("\n", null, null, OcrEntityExtractor.WHITESPACE_BLOCK, null, null, 54, null);
            seq.add(character);
            seq.add(character);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$WordMetaData;", "", "text", "", "(Ljava/lang/String;)V", "entityTypeIds", "", "addEntityTypeId", "", "entityTypeId", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class WordMetaData {

        @NotNull
        private final Set<String> entityTypeIds;

        @NotNull
        private final String text;

        public WordMetaData(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.entityTypeIds = new LinkedHashSet();
        }

        public final void addEntityTypeId(@NotNull String entityTypeId) throws IOException {
            Intrinsics.checkNotNullParameter(entityTypeId, "entityTypeId");
            this.entityTypeIds.add(entityTypeId);
            if (this.entityTypeIds.size() > 1) {
                LibLogger.m5429d(OcrEntityExtractor.TAG, "addEntityTypeId, types: " + CollectionsKt.m13955n(this.entityTypeIds, ",", null, null, null, 62) + SQLKeyword.COMMA + AbstractC1038a.m1214o(this.text.hashCode(), this.text.length(), "text hash: ", ", len: "));
            }
        }
    }

    private OcrEntityExtractor() {
    }

    private final int adjustEmptyCharacterEndIndex(CharacterSequence seq, int index) {
        int i = 0;
        List listReversed = seq.getData().subList(0, index).reversed();
        Intrinsics.checkNotNullExpressionValue(listReversed, "seq.data.subList(0, index).reversed()");
        Iterator it = listReversed.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (!Intrinsics.areEqual(((Character) it.next()).getTag(), WHITESPACE_WORD)) {
                break;
            }
            i++;
        }
        return index - i;
    }

    private final int adjustEmptyCharacterStartIndex(CharacterSequence seq, int index) {
        Iterator<Character> it = seq.getData().subList(index, seq.getData().size()).iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (!Intrinsics.areEqual(it.next().getTag(), WHITESPACE_WORD)) {
                break;
            }
            i++;
        }
        return index + i;
    }

    private final List<Point[]> createPolyList(CharacterSequence seq, int start, int end, EntityType entityType) {
        if (EntityUtils.INSTANCE.isDateTimeEntity(entityType)) {
            return new ArrayList();
        }
        List<Pair<Integer, Integer>> lineIndexList = getLineIndexList(seq, start, end);
        ArrayList arrayList = new ArrayList();
        for (Pair<Integer, Integer> pair : lineIndexList) {
            List<Character> listSubList = seq.getData().subList(adjustEmptyCharacterStartIndex(seq, pair.getFirst().intValue()), adjustEmptyCharacterEndIndex(seq, pair.getSecond().intValue()));
            if (!listSubList.isEmpty()) {
                Point[] pointArrSum = sum(((Character) CollectionsKt.first((List) listSubList)).getPoly(), ((Character) CollectionsKt.last((List) listSubList)).getPoly());
                if (!(pointArrSum.length == 0)) {
                    arrayList.add(pointArrSum);
                }
            }
        }
        return arrayList;
    }

    private final List<Rect> createRectList(CharacterSequence seq, int start, int end, EntityType entityType) {
        if (EntityUtils.INSTANCE.isDateTimeEntity(entityType)) {
            return new ArrayList();
        }
        List<Pair<Integer, Integer>> lineIndexList = getLineIndexList(seq, start, end);
        ArrayList arrayList = new ArrayList();
        for (Pair<Integer, Integer> pair : lineIndexList) {
            List<Character> listSubList = seq.getData().subList(adjustEmptyCharacterStartIndex(seq, pair.getFirst().intValue()), adjustEmptyCharacterEndIndex(seq, pair.getSecond().intValue()));
            if (!listSubList.isEmpty()) {
                Rect rectSum = sum(((Character) CollectionsKt.first((List) listSubList)).getRect(), ((Character) CollectionsKt.last((List) listSubList)).getRect());
                if (!rectSum.isEmpty()) {
                    arrayList.add(rectSum);
                }
            }
        }
        return arrayList;
    }

    private final List<Underline> createUnderlineList(List<Point[]> polyList) {
        ArrayList arrayList = new ArrayList();
        for (Point[] pointArr : polyList) {
            if (pointArr.length >= 4) {
                arrayList.add(getUnderlineFromPoly(pointArr));
            }
        }
        LibLogger.m5432i(TAG, "createUnderlineList lines size: " + arrayList.size());
        return arrayList;
    }

    private final List<Pair<Integer, Integer>> getLineIndexList(CharacterSequence seq, int start, int end) {
        String strSubstring = seq.getText().substring(start, end);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        List<String> listSplit$default = StringsKt__StringsKt.split$default(strSubstring, new String[]{"\n"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        int length = 0;
        for (String str : listSplit$default) {
            int i = start + length;
            arrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(str.length() + i)));
            length += str.length() + 1;
        }
        return arrayList;
    }

    private final Underline getUnderlineFromPoly(Point[] poly) {
        return new Underline(new PointF(poly[3]), new PointF(poly[2]));
    }

    private final List<EntityItem> parseActionItems(TextClassification classification, CharacterSequence sequence, Rect validRect) {
        Object objM22215constructorimpl;
        Object objM22215constructorimpl2;
        Object objM22215constructorimpl3;
        Object objM22215constructorimpl4;
        EntityScoreGenerator entityScoreGenerator = new EntityScoreGenerator();
        List<RemoteAction> actions = classification.getActions();
        Intrinsics.checkNotNullExpressionValue(actions, "classification.actions");
        ArrayList arrayList = new ArrayList();
        for (RemoteAction action : actions) {
            EntityUtils entityUtils = EntityUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(action, "action");
            String entityText = entityUtils.getEntityText(classification, action);
            int iCoerceAtLeast = RangesKt.coerceAtLeast(entityUtils.getEntityStartIndex(classification, action), 0);
            int iCoerceAtMost = RangesKt.coerceAtMost(entityUtils.getEntityEndIndex(classification, action), sequence.getText().length());
            EntityType.Companion companion = EntityType.INSTANCE;
            EntityType entityType = companion.toEntityType(entityUtils.getEntityTypeID(classification, action));
            LibLogger.m5432i(TAG, "parsing actionItem with entityType: " + entityType + ", startIndex: " + iCoerceAtLeast + ", endIndex: " + iCoerceAtMost);
            boolean zContains = companion.listOfEntityType().contains(entityType);
            if (zContains) {
                OcrEntityExtractor ocrEntityExtractor = INSTANCE;
                try {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ocrEntityExtractor.createRectList(sequence, iCoerceAtLeast, iCoerceAtMost, entityType));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    objM22215constructorimpl = null;
                }
                List listEmptyList = (List) objM22215constructorimpl;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                List list = listEmptyList;
                try {
                    objM22215constructorimpl2 = Result.m22215constructorimpl(INSTANCE.createPolyList(sequence, iCoerceAtLeast, iCoerceAtMost, entityType));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM22215constructorimpl2 = Result.m22215constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl2)) {
                    objM22215constructorimpl2 = null;
                }
                List<Point[]> listEmptyList2 = (List) objM22215constructorimpl2;
                if (listEmptyList2 == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                List<Point[]> list2 = listEmptyList2;
                try {
                    objM22215constructorimpl3 = Result.m22215constructorimpl(INSTANCE.createUnderlineList(list2));
                } catch (Throwable th3) {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM22215constructorimpl3 = Result.m22215constructorimpl(ResultKt.createFailure(th3));
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl3)) {
                    objM22215constructorimpl3 = null;
                }
                List listEmptyList3 = (List) objM22215constructorimpl3;
                if (listEmptyList3 == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                }
                List list3 = listEmptyList3;
                try {
                    objM22215constructorimpl4 = Result.m22215constructorimpl((Rect) CollectionsKt.first(list));
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.INSTANCE;
                    objM22215constructorimpl4 = Result.m22215constructorimpl(ResultKt.createFailure(th4));
                }
                Rect rect = (Rect) (Result.m22221isFailureimpl(objM22215constructorimpl4) ? null : objM22215constructorimpl4);
                if (rect == null) {
                    rect = new Rect();
                }
                entityItem = new EntityItem(entityType, entityText, list, list2, list3, entityScoreGenerator.measureEntityScore(entityText, entityType, rect, validRect), CollectionsKt.mutableListOf(action));
            }
            if (entityItem != null) {
                arrayList.add(entityItem);
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    private final Rect sum(Rect r12, Rect r2) {
        return new Rect(Math.min(r12.left, r2.left), Math.min(r12.top, r2.top), Math.max(r12.right, r2.right), Math.max(r12.bottom, r2.bottom));
    }

    @NotNull
    public final EntityExtractionResult extractEntity(@NotNull OcrResult ocrResult, @NotNull List<? extends EntityType> entityTypes, @Nullable Rect validRect, @NotNull TextClassificationHelper textClassificationHelper) {
        TextClassification textClassificationClassifyText$default;
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(entityTypes, "entityTypes");
        Intrinsics.checkNotNullParameter(textClassificationHelper, "textClassificationHelper");
        String strM1616f = AbstractC2322a.m1616f(ocrResult.hashCode(), "SSS|", "|", CollectionsKt.m13955n(entityTypes, ",", null, null, null, 62));
        EntityExtractionResult entityExtractionResult = new EntityExtractionResult(strM1616f, new ArrayList(), "");
        if (Build.VERSION.SDK_INT >= 29 && !ocrResult.getBlockInfoList().isEmpty()) {
            CharacterSequence characterSequence = toCharacterSequence(ocrResult);
            if (StringsKt.trim((CharSequence) characterSequence.getText()).toString().length() != 0 && (textClassificationClassifyText$default = TextClassificationHelper.classifyText$default(textClassificationHelper, characterSequence.getText(), null, null, null, true, 14, null)) != null) {
                characterSequence.addEntityTypeIdToMetaData(textClassificationClassifyText$default);
                List<EntityItem> actionItems = INSTANCE.parseActionItems(textClassificationClassifyText$default, characterSequence, validRect);
                String languageTag = textClassificationClassifyText$default.getExtras().getString(TextClassificationConstants.EXTRA_KEY_LANGUAGE_TAG, "");
                LibLogger.m5432i(TAG, "extractEntity, actionItems.size: " + actionItems.size() + ", languageTag: " + languageTag);
                Intrinsics.checkNotNullExpressionValue(languageTag, "languageTag");
                return new EntityExtractionResult(strM1616f, actionItems, languageTag);
            }
        }
        return entityExtractionResult;
    }

    @VisibleForTesting
    @NotNull
    public final CharacterSequence toCharacterSequence(@NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : ocrResult.getBlockInfoList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            new SequenceBuilder().buildBlock((OcrResult.BlockInfo) obj, i == CollectionsKt.getLastIndex(ocrResult.getBlockInfoList()), arrayList);
            i = i2;
        }
        return new CharacterSequence(CollectionsKt.m13955n(arrayList, "", null, null, new Function1<Character, CharSequence>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.entity.OcrEntityExtractor$toCharacterSequence$text$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull OcrEntityExtractor.Character it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getCharText();
            }
        }, 30), arrayList);
    }

    private final Point[] sum(Point[] p1, Point[] p2) {
        Point point = p1[0];
        Point point2 = new Point(point.x, point.y);
        Point point3 = p2[1];
        Point point4 = new Point(point3.x, point3.y);
        Point point5 = p2[2];
        Point point6 = new Point(point5.x, point5.y);
        Point point7 = p1[3];
        return new Point[]{point2, point4, point6, new Point(point7.x, point7.y)};
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$Character;", "", "charText", "", "line", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", DialogConstant.BUNDLE_WORD, "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "tag", "poly", "", "Landroid/graphics/Point;", "metaData", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$WordMetaData;", "(Ljava/lang/String;Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;Ljava/lang/String;[Landroid/graphics/Point;Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$WordMetaData;)V", "getCharText", "()Ljava/lang/String;", "getLine", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", "getMetaData", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$WordMetaData;", "getPoly", "()[Landroid/graphics/Point;", "[Landroid/graphics/Point;", "rect", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", "getTag", "getWord", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nOcrEntityExtractor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrEntityExtractor.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/entity/OcrEntityExtractor$Character\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
    public static final class Character {

        @NotNull
        private final String charText;

        @Nullable
        private final OcrResult.LineInfo line;

        @Nullable
        private final WordMetaData metaData;

        @NotNull
        private final Point[] poly;

        @NotNull
        private final Rect rect;

        @NotNull
        private final String tag;

        @Nullable
        private final OcrResult.WordInfo word;

        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator, kotlin.collections.IntIterator] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
        /* JADX WARN: Type inference failed for: r8v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
        public Character(@NotNull String charText, @Nullable OcrResult.LineInfo lineInfo, @Nullable OcrResult.WordInfo wordInfo, @NotNull String tag, @NotNull Point[] poly, @Nullable WordMetaData wordMetaData) {
            Rect rect;
            Intrinsics.checkNotNullParameter(charText, "charText");
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(poly, "poly");
            this.charText = charText;
            this.line = lineInfo;
            this.word = wordInfo;
            this.tag = tag;
            this.poly = poly;
            this.metaData = wordMetaData;
            if (poly.length < 4) {
                rect = new Rect();
            } else {
                if (poly.length == 0) {
                    throw new NoSuchElementException();
                }
                int i = poly[0].x;
                ?? it = new IntRange(1, ArraysKt.getLastIndex(poly)).iterator();
                while (it.hasNext()) {
                    int i2 = poly[it.nextInt()].x;
                    if (i > i2) {
                        i = i2;
                    }
                }
                Point[] pointArr = this.poly;
                if (pointArr.length == 0) {
                    throw new NoSuchElementException();
                }
                int i4 = pointArr[0].y;
                ?? it2 = new IntRange(1, ArraysKt.getLastIndex(pointArr)).iterator();
                while (it2.hasNext()) {
                    int i5 = pointArr[it2.nextInt()].y;
                    if (i4 > i5) {
                        i4 = i5;
                    }
                }
                Point[] pointArr2 = this.poly;
                if (pointArr2.length == 0) {
                    throw new NoSuchElementException();
                }
                int i6 = pointArr2[0].x;
                ?? it3 = new IntRange(1, ArraysKt.getLastIndex(pointArr2)).iterator();
                while (it3.hasNext()) {
                    int i7 = pointArr2[it3.nextInt()].x;
                    if (i6 < i7) {
                        i6 = i7;
                    }
                }
                Point[] pointArr3 = this.poly;
                if (pointArr3.length == 0) {
                    throw new NoSuchElementException();
                }
                int i8 = pointArr3[0].y;
                ?? it4 = new IntRange(1, ArraysKt.getLastIndex(pointArr3)).iterator();
                while (it4.hasNext()) {
                    int i9 = pointArr3[it4.nextInt()].y;
                    if (i8 < i9) {
                        i8 = i9;
                    }
                }
                rect = new Rect(i, i4, i6, i8);
            }
            this.rect = rect;
        }

        @NotNull
        public final String getCharText() {
            return this.charText;
        }

        @Nullable
        public final OcrResult.LineInfo getLine() {
            return this.line;
        }

        @Nullable
        public final WordMetaData getMetaData() {
            return this.metaData;
        }

        @NotNull
        public final Point[] getPoly() {
            return this.poly;
        }

        @NotNull
        public final Rect getRect() {
            return this.rect;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        public final OcrResult.WordInfo getWord() {
            return this.word;
        }

        public /* synthetic */ Character(String str, OcrResult.LineInfo lineInfo, OcrResult.WordInfo wordInfo, String str2, Point[] pointArr, WordMetaData wordMetaData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : lineInfo, (i & 4) != 0 ? null : wordInfo, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? new Point[0] : pointArr, (i & 32) != 0 ? null : wordMetaData);
        }
    }
}
