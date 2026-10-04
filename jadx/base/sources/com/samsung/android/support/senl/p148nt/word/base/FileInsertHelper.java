package com.samsung.android.support.senl.p148nt.word.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectLine;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.word.base.utils.ItemUtils;
import com.samsung.android.support.senl.p148nt.word.base.utils.ZipUtils;
import com.samsung.android.support.senl.p148nt.word.common.ConvertUtils;
import com.samsung.android.support.senl.p148nt.word.common.OfficeBackground;
import com.samsung.android.support.senl.p148nt.word.common.OfficeCropHeight;
import com.samsung.android.support.senl.p148nt.word.data.OfficeParams;
import com.samsung.android.support.senl.p148nt.word.powerpoint.PowerPointView;
import com.samsung.android.support.senl.p148nt.word.word.WordView;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.StringsKt;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.C4191n;
import p123b3.C4201a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 l2\u00020\u0001:\u0005hijklB\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010=\u001a\u00020>H\u0002J\u0012\u0010?\u001a\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020\tH\u0016J\u0018\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\tH\u0002J\u0010\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020\tH\u0002J\u0010\u0010G\u001a\u00020>2\u0006\u0010F\u001a\u00020\tH\u0002J\u0010\u0010H\u001a\u00020>2\u0006\u0010F\u001a\u00020\tH\u0002J\u0010\u0010I\u001a\u00020>2\u0006\u0010F\u001a\u00020\tH\u0002J\u001c\u0010J\u001a\u0004\u0018\u00010\r2\b\u0010K\u001a\u0004\u0018\u00010\r2\u0006\u0010L\u001a\u00020MH\u0002J&\u0010N\u001a\u0004\u0018\u00010O2\b\u0010P\u001a\u0004\u0018\u00010\u00102\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010\rH\u0002J&\u0010T\u001a\u0004\u0018\u00010C2\u0006\u0010U\u001a\u00020\u000b2\b\u0010V\u001a\u0004\u0018\u00010O2\b\u0010W\u001a\u0004\u0018\u00010\u0010H\u0002J\u0014\u0010X\u001a\u0004\u0018\u00010\u00102\b\u0010Y\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010Z\u001a\u00020>2\u0006\u0010F\u001a\u00020\tH\u0002J\u0010\u0010[\u001a\u00020>2\u0006\u0010F\u001a\u00020\tH\u0002J)\u0010\\\u001a\u0004\u0018\u00010O\"\b\b\u0000\u0010]*\u00020+2\u0006\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u0002H]H\u0002¢\u0006\u0002\u0010`J\u0010\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020+H\u0002J6\u0010d\u001a\u0004\u0018\u00010C2\b\u0010e\u001a\u0004\u0018\u00010O2\b\u0010f\u001a\u0004\u0018\u00010\u00102\u0006\u0010c\u001a\u00020+2\u0006\u0010F\u001a\u00020\t2\u0006\u0010g\u001a\u00020\u0010H\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R:\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R:\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020#\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020#\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R:\u0010&\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020'\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020'\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R:\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020+\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R:\u0010.\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R:\u00102\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015R:\u00105\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u000206\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100:X\u0082.¢\u0006\u0002\n\u0000R2\u0010;\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper;", "", "mView", "Lcom/samsung/android/support/senl/nt/word/base/OfficeView;", "mContext", "Landroid/content/Context;", "<init>", "(Lcom/samsung/android/support/senl/nt/word/base/OfficeView;Landroid/content/Context;)V", "newOfficeFile", "Ljava/io/File;", "finish", "", "spenWPage", "Lcom/samsung/android/sdk/pen/worddoc/SpenWPage;", "voiceHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getVoiceHashMap", "()Ljava/util/HashMap;", "setVoiceHashMap", "(Ljava/util/HashMap;)V", "partHashMap", "Lorg/apache/poi/openxml4j/opc/PackagePart;", "getPartHashMap", "setPartHashMap", "bgList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/word/common/OfficeBackground;", "Lkotlin/collections/ArrayList;", "getBgList", "()Ljava/util/ArrayList;", "setBgList", "(Ljava/util/ArrayList;)V", "hwHashMap", "", "getHwHashMap", "setHwHashMap", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "getVoiceData", "setVoiceData", "imageHashMap", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "getImageHashMap", "setImageHashMap", "cropBg", "Lcom/samsung/android/support/senl/nt/word/common/OfficeCropHeight;", "getCropBg", "setCropBg", "cropHw", "getCropHw", "setCropHw", "codeBlockHashMap", "Lcom/samsung/android/sdk/pen/document/SpenObjectCodeBlock;", "getCodeBlockHashMap", "setCodeBlockHashMap", "processedPathMap", "", "mBgHashMap", "mBgKey", "initialize", "", "insertFile", "officeFile", "writeFile", "inputStream", "Ljava/io/InputStream;", "outputFile", "insertAudioFile", "mediaFolder", "insertVoiceData", "insertBackground", "insertCodeBlock", "setPageBackground", "inputPageBackground", "noteBackground", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getBitmapContinuousPage", "Landroid/graphics/Bitmap;", "bgName", "captureBackground", "Lcom/samsung/android/support/senl/nt/base/common/NoteCaptureControl;", "pageBackground", "getBackgroundInputStream", "isBackgroundBitmap", "background", "backgroundPath", "getExistBgPath", "currentPage", "insertHandwriting", "insertImage", "captureSpenObject", "T", "base", "copy", "(Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/sdk/pen/document/SpenObjectBase;)Landroid/graphics/Bitmap;", "getImageData", "Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$ImageData;", "objectBase", "getInputStream", "inputBitmap", "filePath", "imageName", "TaskName", "ImageData", "InsertTask", "ImageBuilder", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFileInsertHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileInsertHelper.kt\ncom/samsung/android/support/senl/nt/word/base/FileInsertHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,737:1\n1#2:738\n*E\n"})
public class FileInsertHelper {

    @NotNull
    private static final String PPT_PATH = "ppt/media";

    @NotNull
    private static final String TAG = "FileInsertHelper";

    @NotNull
    private static final String WORD_PATH = "word/media";

    @Nullable
    private ArrayList<OfficeBackground> bgList;

    @Nullable
    private HashMap<String, SpenObjectCodeBlock> codeBlockHashMap;

    @Nullable
    private HashMap<String, OfficeCropHeight> cropBg;

    @Nullable
    private HashMap<String, OfficeCropHeight> cropHw;
    private boolean finish;

    @Nullable
    private HashMap<String, Integer> hwHashMap;

    @Nullable
    private HashMap<String, SpenObjectBase> imageHashMap;

    @Nullable
    private HashMap<String, String> mBgHashMap;

    @Nullable
    private String mBgKey;

    @NotNull
    private final Context mContext;

    @NotNull
    private final OfficeView<?, ?> mView;

    @Nullable
    private File newOfficeFile;

    @Nullable
    private HashMap<String, PackagePart> partHashMap;
    private Map<String, String> processedPathMap;

    @Nullable
    private SpenWPage spenWPage;

    @Nullable
    private HashMap<String, SpenVoiceData> voiceData;

    @Nullable
    private HashMap<String, String> voiceHashMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$ImageBuilder;", "", "<init>", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", Key.ROTATION, "", "getRotation", "()Ljava/lang/Float;", "setRotation", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "wh", "Landroid/util/Pair;", "", "getWh", "()Landroid/util/Pair;", "setWh", "(Landroid/util/Pair;)V", "exec", "hashCode", "toString", "", "build", "", "bm", "objectBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "equals", "", "other", "Companion", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ImageBuilder {

        @NotNull
        private static final String TAG = "ImageBuilder";

        @Nullable
        private Bitmap bitmap;

        @Nullable
        private Rect cropRect;

        @Nullable
        private Float rotation;

        @Nullable
        private Pair<Integer, Integer> wh;

        public final void build(@NotNull Bitmap bm, @NotNull SpenObjectBase objectBase) {
            Intrinsics.checkNotNullParameter(bm, "bm");
            Intrinsics.checkNotNullParameter(objectBase, "objectBase");
            this.bitmap = bm;
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            Rect cropRect = convertUtils.getCropRect(objectBase);
            if (cropRect == null && !convertUtils.isStrokeType(objectBase.getType())) {
                int width = bm.getWidth();
                int height = bm.getHeight();
                RectF rect = objectBase.getRect();
                int i = (int) (rect.right - rect.left);
                int i2 = (int) (rect.bottom - rect.top);
                if (width / height != i / i2) {
                    this.wh = new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
            if (objectBase.getType() != 7) {
                this.cropRect = cropRect;
                this.rotation = Float.valueOf(objectBase.getRotation());
            }
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(ImageBuilder.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.word.base.FileInsertHelper.ImageBuilder");
            ImageBuilder imageBuilder = (ImageBuilder) other;
            return Intrinsics.areEqual(this.bitmap, imageBuilder.bitmap) && Intrinsics.areEqual(this.cropRect, imageBuilder.cropRect) && Intrinsics.areEqual(this.rotation, imageBuilder.rotation) && Intrinsics.areEqual(this.wh, imageBuilder.wh);
        }

        @Nullable
        public final Bitmap exec() {
            Bitmap bitmapCreateScaledBitmap = this.bitmap;
            if (this.wh != null) {
                Intrinsics.checkNotNull(bitmapCreateScaledBitmap);
                Pair<Integer, Integer> pair = this.wh;
                Intrinsics.checkNotNull(pair);
                Object first = pair.first;
                Intrinsics.checkNotNullExpressionValue(first, "first");
                int iIntValue = ((Number) first).intValue();
                Pair<Integer, Integer> pair2 = this.wh;
                Intrinsics.checkNotNull(pair2);
                Object second = pair2.second;
                Intrinsics.checkNotNullExpressionValue(second, "second");
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateScaledBitmap, iIntValue, ((Number) second).intValue(), true);
            }
            Float f = this.rotation;
            if (f != null) {
                try {
                    ItemUtils itemUtils = ItemUtils.INSTANCE;
                    Intrinsics.checkNotNull(f);
                    return itemUtils.processBitmap(bitmapCreateScaledBitmap, f.floatValue(), this.cropRect);
                } catch (Exception e) {
                    AbstractC8014b.m7198D("insertImage# fail :", e.getMessage(), TAG);
                }
            }
            return bitmapCreateScaledBitmap;
        }

        @Nullable
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @Nullable
        public final Rect getCropRect() {
            return this.cropRect;
        }

        @Nullable
        public final Float getRotation() {
            return this.rotation;
        }

        @Nullable
        public final Pair<Integer, Integer> getWh() {
            return this.wh;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public final void setBitmap(@Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public final void setCropRect(@Nullable Rect rect) {
            this.cropRect = rect;
        }

        public final void setRotation(@Nullable Float f) {
            this.rotation = f;
        }

        public final void setWh(@Nullable Pair<Integer, Integer> pair) {
            this.wh = pair;
        }

        @NotNull
        public String toString() {
            String str;
            String strM756B;
            Pair<Integer, Integer> pair = this.wh;
            if (pair != null) {
                Intrinsics.checkNotNull(pair);
                Object obj = pair.first;
                Pair<Integer, Integer> pair2 = this.wh;
                Intrinsics.checkNotNull(pair2);
                str = "/" + obj + "_" + pair2.second;
            } else {
                str = "/null";
            }
            Float f = this.rotation;
            if (f != null) {
                strM756B = str + "/" + f;
            } else {
                strM756B = AbstractC0541b.m756B(str, "/null");
            }
            Rect rect = this.cropRect;
            if (rect == null) {
                return AbstractC0541b.m756B(strM756B, "/null");
            }
            Intrinsics.checkNotNull(rect);
            int i = rect.left;
            Rect rect2 = this.cropRect;
            Intrinsics.checkNotNull(rect2);
            int i2 = rect2.top;
            Rect rect3 = this.cropRect;
            Intrinsics.checkNotNull(rect3);
            int i4 = rect3.right;
            Rect rect4 = this.cropRect;
            Intrinsics.checkNotNull(rect4);
            return strM756B + "/" + i + "_" + i2 + "_" + i4 + "_" + rect4.bottom;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$ImageData;", "", "bm", "Landroid/graphics/Bitmap;", "filePath", "", "<init>", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getBm", "()Landroid/graphics/Bitmap;", "setBm", "(Landroid/graphics/Bitmap;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class ImageData {

        @Nullable
        private Bitmap bm;

        @Nullable
        private String filePath;

        public ImageData(@Nullable Bitmap bitmap, @Nullable String str) {
            this.bm = bitmap;
            this.filePath = str;
        }

        public static /* synthetic */ ImageData copy$default(ImageData imageData, Bitmap bitmap, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap = imageData.bm;
            }
            if ((i & 2) != 0) {
                str = imageData.filePath;
            }
            return imageData.copy(bitmap, str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getBm() {
            return this.bm;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        @NotNull
        public final ImageData copy(@Nullable Bitmap bm, @Nullable String filePath) {
            return new ImageData(bm, filePath);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageData)) {
                return false;
            }
            ImageData imageData = (ImageData) other;
            return Intrinsics.areEqual(this.bm, imageData.bm) && Intrinsics.areEqual(this.filePath, imageData.filePath);
        }

        @Nullable
        public final Bitmap getBm() {
            return this.bm;
        }

        @Nullable
        public final String getFilePath() {
            return this.filePath;
        }

        public int hashCode() {
            Bitmap bitmap = this.bm;
            int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
            String str = this.filePath;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final void setBm(@Nullable Bitmap bitmap) {
            this.bm = bitmap;
        }

        public final void setFilePath(@Nullable String str) {
            this.filePath = str;
        }

        @NotNull
        public String toString() {
            return "ImageData(bm=" + this.bm + ", filePath=" + this.filePath + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$InsertTask;", "Ljava/util/concurrent/Callable;", "", "taskName", "Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$TaskName;", "mediaFolder", "Ljava/io/File;", "<init>", "(Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper;Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$TaskName;Ljava/io/File;)V", NotificationCompat.CATEGORY_CALL, "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class InsertTask implements Callable<Object> {

        @NotNull
        private final File mediaFolder;

        @NotNull
        private final TaskName taskName;
        final /* synthetic */ FileInsertHelper this$0;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TaskName.values().length];
                try {
                    iArr[TaskName.AUDIO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TaskName.BACKGROUND.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TaskName.IMAGE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TaskName.HANDWRITING.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[TaskName.VOICE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[TaskName.CODE_BLOCK.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public InsertTask(@NotNull FileInsertHelper fileInsertHelper, @NotNull TaskName taskName, File mediaFolder) {
            Intrinsics.checkNotNullParameter(taskName, "taskName");
            Intrinsics.checkNotNullParameter(mediaFolder, "mediaFolder");
            this.this$0 = fileInsertHelper;
            this.taskName = taskName;
            this.mediaFolder = mediaFolder;
        }

        @Override // java.util.concurrent.Callable
        @Nullable
        public Object call() throws Exception {
            switch (WhenMappings.$EnumSwitchMapping$0[this.taskName.ordinal()]) {
                case 1:
                    this.this$0.insertAudioFile(this.mediaFolder);
                    return null;
                case 2:
                    this.this$0.insertBackground(this.mediaFolder);
                    return null;
                case 3:
                    this.this$0.insertImage(this.mediaFolder);
                    return null;
                case 4:
                    this.this$0.insertHandwriting(this.mediaFolder);
                    return null;
                case 5:
                    this.this$0.insertVoiceData(this.mediaFolder);
                    return null;
                case 6:
                    this.this$0.insertCodeBlock(this.mediaFolder);
                    return null;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/FileInsertHelper$TaskName;", "", "<init>", "(Ljava/lang/String;I)V", "AUDIO", "VOICE", "BACKGROUND", "HANDWRITING", "IMAGE", "CODE_BLOCK", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class TaskName {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TaskName[] $VALUES;
        public static final TaskName AUDIO = new TaskName("AUDIO", 0);
        public static final TaskName VOICE = new TaskName("VOICE", 1);
        public static final TaskName BACKGROUND = new TaskName("BACKGROUND", 2);
        public static final TaskName HANDWRITING = new TaskName("HANDWRITING", 3);
        public static final TaskName IMAGE = new TaskName("IMAGE", 4);
        public static final TaskName CODE_BLOCK = new TaskName("CODE_BLOCK", 5);

        private static final /* synthetic */ TaskName[] $values() {
            return new TaskName[]{AUDIO, VOICE, BACKGROUND, HANDWRITING, IMAGE, CODE_BLOCK};
        }

        static {
            TaskName[] taskNameArr$values = $values();
            $VALUES = taskNameArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(taskNameArr$values);
        }

        private TaskName(String str, int i) {
        }

        @NotNull
        public static EnumEntries<TaskName> getEntries() {
            return $ENTRIES;
        }

        public static TaskName valueOf(String str) {
            return (TaskName) Enum.valueOf(TaskName.class, str);
        }

        public static TaskName[] values() {
            return (TaskName[]) $VALUES.clone();
        }
    }

    public FileInsertHelper(@NotNull OfficeView<?, ?> mView, @NotNull Context mContext) {
        Intrinsics.checkNotNullParameter(mView, "mView");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mView = mView;
        this.mContext = mContext;
        initialize();
    }

    private final <T extends SpenObjectBase> Bitmap captureSpenObject(SpenObjectBase base, T copy) {
        SpenWNote spenWNote = new SpenWNote(this.mContext, null, this.mView.wNoteData.getSpenWNoteP().getPageMode(), this.mView.wNoteData.getSpenWNoteP().getOrientation(), this.mView.wNoteData.getWidth(), false);
        SpenWPage spenWPageAppendPage = spenWNote.appendPage(this.mView.wNoteData.getWidth(), this.mView.wNoteData.getHeight());
        copy.copy(base);
        spenWPageAppendPage.appendObject(copy);
        NoteCaptureControl noteCaptureControl = new NoteCaptureControl(this.mContext);
        noteCaptureControl.setWNote(spenWNote);
        noteCaptureControl.setContents(spenWPageAppendPage, spenWNote.getBodyText(), copy.getPageIndex());
        noteCaptureControl.setBackgroundColorEnabled(false);
        return noteCaptureControl.captureRect(copy.getRect());
    }

    private final InputStream getBackgroundInputStream(boolean isBackgroundBitmap, Bitmap background, String backgroundPath) {
        if (!isBackgroundBitmap) {
            return new FileInputStream(backgroundPath != null ? new File(backgroundPath) : null);
        }
        if (background != null) {
            return ConvertUtils.INSTANCE.bitmapToInputStream(background);
        }
        return null;
    }

    private final Bitmap getBitmapContinuousPage(String bgName, NoteCaptureControl captureBackground, SpenWPage pageBackground) {
        HashMap<String, OfficeCropHeight> map = this.cropBg;
        Intrinsics.checkNotNull(map);
        OfficeCropHeight officeCropHeight = map.get(bgName);
        if (officeCropHeight == null) {
            return null;
        }
        int previous = officeCropHeight.getPrevious();
        int current = officeCropHeight.getCurrent();
        if (pageBackground != null) {
            return captureBackground.captureRect(new RectF(0.0f, previous, pageBackground.getWidth(), current));
        }
        return null;
    }

    private final String getExistBgPath(SpenWPage currentPage) {
        String backgroundImagePath = currentPage != null ? currentPage.getBackgroundImagePath() : null;
        String strValueOf = String.valueOf(currentPage != null ? Integer.valueOf(currentPage.getTemplateType()) : null);
        StringBuilder sb = new StringBuilder(String.valueOf(currentPage != null ? Integer.valueOf(currentPage.getBackgroundColor()) : null));
        if (backgroundImagePath == null) {
            sb.append("TT");
            sb.append(strValueOf);
        } else {
            sb.append("IP");
            sb.append(backgroundImagePath);
        }
        this.mBgKey = sb.toString();
        HashMap<String, String> map = this.mBgHashMap;
        Intrinsics.checkNotNull(map);
        if (!map.containsKey(this.mBgKey)) {
            return null;
        }
        HashMap<String, String> map2 = this.mBgHashMap;
        Intrinsics.checkNotNull(map2);
        return map2.get(this.mBgKey);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[PHI: r5
      0x003d: PHI (r5v4 java.lang.String) = (r5v2 java.lang.String), (r5v2 java.lang.String), (r5v7 java.lang.String) binds: [B:16:0x004e, B:18:0x0067, B:13:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ImageData getImageData(SpenObjectBase objectBase) {
        String imagePath;
        String str;
        int type = objectBase.getType();
        Bitmap bitmapDecodeSpi = null;
        if (type == 3) {
            Intrinsics.checkNotNull(objectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectImage");
            imagePath = ((SpenObjectImage) objectBase).getImagePath();
            if (imagePath.length() > 0) {
                String strSubstring = imagePath.substring(StringsKt.m14130D(imagePath, '.') + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                if (Intrinsics.areEqual(strSubstring, "spi")) {
                    str = null;
                    bitmapDecodeSpi = ImageUtils.decodeSpi(imagePath);
                } else {
                    str = imagePath;
                }
            }
        } else if (type != 14) {
            str = "";
            if (type == 7) {
                SpenToBitmap spenToBitmap = SpenToBitmap.INSTANCE;
                Intrinsics.checkNotNull(objectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
                bitmapDecodeSpi = spenToBitmap.drawShape((SpenObjectShape) objectBase);
            } else if (type == 8) {
                SpenToBitmap spenToBitmap2 = SpenToBitmap.INSTANCE;
                Intrinsics.checkNotNull(objectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLine");
                bitmapDecodeSpi = spenToBitmap2.drawLine((SpenObjectLine) objectBase);
            }
        } else {
            Intrinsics.checkNotNull(objectBase, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectPainting");
            imagePath = ((SpenObjectPainting) objectBase).getThumbnailPath();
            str = imagePath;
        }
        return new ImageData(bitmapDecodeSpi, str);
    }

    private final InputStream getInputStream(Bitmap inputBitmap, String filePath, SpenObjectBase objectBase, File mediaFolder, String imageName) {
        if (inputBitmap == null && filePath != null) {
            inputBitmap = BitmapFactory.decodeFile(filePath);
        }
        Map<String, String> map = null;
        if (inputBitmap == null) {
            return null;
        }
        ImageBuilder imageBuilder = new ImageBuilder();
        imageBuilder.build(inputBitmap, objectBase);
        if (filePath == null) {
            return ConvertUtils.INSTANCE.bitmapToInputStream(imageBuilder.exec());
        }
        String str = "/" + filePath + imageBuilder;
        Map<String, String> map2 = this.processedPathMap;
        if (map2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processedPathMap");
            map2 = null;
        }
        String str2 = map2.get(str);
        if (str2 != null && AbstractC2322a.m1607A(str2)) {
            return ConvertUtils.INSTANCE.filePathToInputStream(str2);
        }
        Bitmap bitmapExec = imageBuilder.exec();
        ConvertUtils convertUtils = ConvertUtils.INSTANCE;
        InputStream inputStreamBitmapToInputStream = convertUtils.bitmapToInputStream(bitmapExec);
        if (!convertUtils.isStrokeType(objectBase.getType())) {
            Map<String, String> map3 = this.processedPathMap;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("processedPathMap");
            } else {
                map = map3;
            }
            map.put(str, new File(mediaFolder, imageName).getAbsolutePath());
        }
        return inputStreamBitmapToInputStream;
    }

    private final void initialize() {
        this.voiceHashMap = new HashMap<>();
        this.partHashMap = new HashMap<>();
        this.hwHashMap = new HashMap<>();
        this.voiceData = new HashMap<>();
        this.imageHashMap = new HashMap<>();
        this.cropBg = new HashMap<>();
        this.cropHw = new HashMap<>();
        this.bgList = new ArrayList<>();
        this.mBgHashMap = new HashMap<>();
        this.codeBlockHashMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void insertAudioFile(File mediaFolder) throws Exception {
        Logger.m10999d(TAG, "insertAudioFile(), start");
        HashMap<String, String> map = this.voiceHashMap;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.isEmpty()) {
                Logger.m10999d(TAG, "Don't have any voice");
            } else {
                HashMap<String, String> map2 = this.voiceHashMap;
                Intrinsics.checkNotNull(map2);
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    File file = new File(key);
                    if (file.exists()) {
                        File file2 = new File(mediaFolder, value);
                        if (!file2.createNewFile() && !file2.exists()) {
                            throw new Exception("Sound created failed");
                        }
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            writeFile(fileInputStream, file2);
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileInputStream, null);
                        } finally {
                        }
                    }
                }
            }
        }
        Logger.m10999d(TAG, "insertAudioFile(), end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertBackground(File mediaFolder) throws Throwable {
        SpenWNote spenWNote;
        NoteCaptureControl noteCaptureControl;
        Bitmap bitmapCapturePage;
        Logger.m10999d(TAG, "insertBackground(), start");
        ArrayList<OfficeBackground> arrayList = this.bgList;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.isEmpty()) {
                try {
                    spenWNote = new SpenWNote(this.mContext, null, this.mView.wNoteData.getSpenWNoteP().getPageMode(), this.mView.wNoteData.getSpenWNoteP().getOrientation(), this.mView.wNoteData.getWidth(), false);
                    try {
                        noteCaptureControl = new NoteCaptureControl(this.mContext);
                        try {
                            noteCaptureControl.setWNote(spenWNote);
                            HashMap map = new HashMap();
                            ArrayList<OfficeBackground> arrayList2 = this.bgList;
                            Intrinsics.checkNotNull(arrayList2);
                            Iterator<OfficeBackground> it = arrayList2.iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            SpenWPage pageBackground = null;
                            while (it.hasNext()) {
                                OfficeBackground next = it.next();
                                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                OfficeBackground officeBackground = next;
                                String name = officeBackground.getName();
                                int pageId = officeBackground.getPageId();
                                OfficeView<?, ?> officeView = this.mView;
                                SpenWPage page = (officeView.isContinuousPage && this.spenWPage == null) ? officeView.wNoteData.getSpenWNoteP().getPage(0) : officeView.wNoteData.getSpenWNoteP().getPage(pageId);
                                this.spenWPage = page;
                                this.mBgKey = null;
                                Intrinsics.checkNotNull(page);
                                String existBgPath = (page.hasPDF() || this.mView.isContinuousPage) ? null : getExistBgPath(this.spenWPage);
                                if (this.mView.isContinuousPage || existBgPath == null) {
                                    pageBackground = setPageBackground(pageBackground, spenWNote);
                                    if (this.mView.isContinuousPage) {
                                        noteCaptureControl.setContents(pageBackground, new SpenObjectTextBox(), 0);
                                        bitmapCapturePage = getBitmapContinuousPage(name, noteCaptureControl, pageBackground);
                                    } else {
                                        noteCaptureControl.setContents(pageBackground, new SpenObjectTextBox(), pageId);
                                        bitmapCapturePage = noteCaptureControl.capturePage(1.0f);
                                    }
                                } else {
                                    bitmapCapturePage = null;
                                }
                                if (!this.mView.isContinuousPage) {
                                    pageBackground = null;
                                }
                                map.put(officeBackground, new Triple(this.mBgKey, bitmapCapturePage, existBgPath));
                            }
                            map.entrySet().parallelStream().forEach(new C4191n(new C4201a(this, mediaFolder, 4), 19));
                            try {
                                spenWNote.close(true);
                            } catch (IOException e) {
                                AbstractC8014b.m7198D("insertBackground# close SpenWNote fail e : ", e.getMessage(), TAG);
                            }
                            noteCaptureControl.close();
                            Logger.m10999d(TAG, "insertBackground(), end");
                            return;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            if (spenWNote != null) {
                                try {
                                    spenWNote.close(true);
                                } catch (IOException e2) {
                                    AbstractC8014b.m7198D("insertBackground# close SpenWNote fail e : ", e2.getMessage(), TAG);
                                }
                            }
                            if (noteCaptureControl == null) {
                                throw th2;
                            }
                            noteCaptureControl.close();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        noteCaptureControl = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    spenWNote = null;
                    noteCaptureControl = null;
                }
            }
        }
        Logger.m10999d(TAG, "Don't have any background");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit insertBackground$lambda$7(FileInsertHelper fileInsertHelper, File file, Map.Entry entry) {
        try {
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            Triple triple = (Triple) value;
            InputStream backgroundInputStream = fileInsertHelper.getBackgroundInputStream(fileInsertHelper.mView.isContinuousPage || triple.getThird() == null, (Bitmap) triple.getSecond(), (String) triple.getThird());
            if (backgroundInputStream != null) {
                try {
                    File file2 = new File(file, ((OfficeBackground) entry.getKey()).getName());
                    if (!file2.createNewFile() && !file2.exists()) {
                        throw new Exception("Background file created failed");
                    }
                    fileInsertHelper.writeFile(backgroundInputStream, file2);
                    if (triple.getFirst() != null && triple.getThird() == null) {
                        HashMap<String, String> map = fileInsertHelper.mBgHashMap;
                        Intrinsics.checkNotNull(map);
                        map.put((String) triple.getFirst(), file2.getAbsolutePath());
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(backgroundInputStream, null);
        } catch (Exception e) {
            Logger.m11001e(TAG, "Fail to insertBackground()", e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertCodeBlock(File mediaFolder) throws Throwable {
        Throwable th;
        InputStream inputStream;
        NoteCaptureControl noteCaptureControl;
        Logger.m10999d(TAG, "insertCodeBlock(), start");
        HashMap<String, SpenObjectCodeBlock> map = this.codeBlockHashMap;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (!map.isEmpty()) {
                SpenWNote spenWNote = null;
                inputStreamBitmapToInputStream = null;
                InputStream inputStreamBitmapToInputStream = null;
                try {
                    SpenWNote spenWNote2 = new SpenWNote(this.mContext, null, this.mView.wNoteData.getSpenWNoteP().getPageMode(), this.mView.wNoteData.getSpenWNoteP().getOrientation(), this.mView.wNoteData.getWidth(), false);
                    try {
                        noteCaptureControl = new NoteCaptureControl(this.mContext);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        noteCaptureControl = null;
                    }
                    try {
                        noteCaptureControl.setWNote(spenWNote2);
                        HashMap<String, SpenObjectCodeBlock> map2 = this.codeBlockHashMap;
                        Intrinsics.checkNotNull(map2);
                        SpenWPage spenWPageAppendPage = null;
                        for (Map.Entry<String, SpenObjectCodeBlock> entry : map2.entrySet()) {
                            String key = entry.getKey();
                            SpenObjectCodeBlock value = entry.getValue();
                            SpenObjectCodeBlock spenObjectCodeBlock = new SpenObjectCodeBlock();
                            spenObjectCodeBlock.copy(value);
                            if (spenWPageAppendPage == null || !this.mView.isContinuousPage) {
                                spenWPageAppendPage = spenWNote2.appendPage(this.mView.wNoteData.getWidth(), this.mView.wNoteData.getHeight());
                            }
                            spenWPageAppendPage.appendObject(spenObjectCodeBlock);
                            noteCaptureControl.setContents(spenWPageAppendPage, spenWNote2.getBodyText(), value.getPageIndex());
                            noteCaptureControl.setBackgroundColorEnabled(false);
                            inputStreamBitmapToInputStream = ConvertUtils.INSTANCE.bitmapToInputStream(noteCaptureControl.captureRect(value.getRect()));
                            if (inputStreamBitmapToInputStream != null) {
                                File file = new File(mediaFolder, key);
                                if (!file.createNewFile() && !file.exists()) {
                                    throw new Exception("CodeBlock created failed");
                                }
                                writeFile(inputStreamBitmapToInputStream, file);
                                inputStreamBitmapToInputStream.close();
                            }
                        }
                        spenWNote2.close(true);
                        noteCaptureControl.close();
                        if (inputStreamBitmapToInputStream != null) {
                            inputStreamBitmapToInputStream.close();
                        }
                        Logger.m10999d(TAG, "insertCodeBlock(), end");
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStreamBitmapToInputStream;
                        spenWNote = spenWNote2;
                        if (spenWNote != null) {
                            spenWNote.close(true);
                        }
                        if (noteCaptureControl != null) {
                            noteCaptureControl.close();
                        }
                        if (inputStream == null) {
                            throw th;
                        }
                        inputStream.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    noteCaptureControl = null;
                }
            }
        }
        Logger.m10999d(TAG, "Don't have any CodeBlock");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertFile$lambda$0(FileInsertHelper fileInsertHelper, CancellationSignal cancellationSignal, String str) {
        File file = null;
        try {
            try {
                File file2 = fileInsertHelper.newOfficeFile;
                Intrinsics.checkNotNull(file2);
                String path = file2.getPath();
                String str2 = fileInsertHelper.mView instanceof WordView ? WORD_PATH : PPT_PATH;
                Logger.m10999d(TAG, "Start unzip");
                ZipUtils zipUtils = ZipUtils.INSTANCE;
                Intrinsics.checkNotNull(path);
                zipUtils.unZip(path);
                Logger.m10999d(TAG, "End unzip");
                String strSubstring = path.substring(0, StringsKt.m14130D(path, '.'));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                File file3 = new File(strSubstring);
                if (!file3.exists()) {
                    Logger.m11000e(TAG, "Not found unzip folder");
                }
                File file4 = new File(file3, str2);
                if (!file4.exists() && !file4.mkdir() && !file4.exists()) {
                    Logger.m10999d(TAG, "folder fail");
                    throw new Exception("Media Folder made failed");
                }
                ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5, new SenlThreadFactory(TAG));
                LinkedList linkedList = new LinkedList();
                if (fileInsertHelper.mView instanceof PowerPointView) {
                    InsertTask insertTask = new InsertTask(fileInsertHelper, TaskName.AUDIO, file4);
                    InsertTask insertTask2 = new InsertTask(fileInsertHelper, TaskName.VOICE, file4);
                    linkedList.add(insertTask);
                    linkedList.add(insertTask2);
                }
                InsertTask insertTask3 = new InsertTask(fileInsertHelper, TaskName.BACKGROUND, file4);
                InsertTask insertTask4 = new InsertTask(fileInsertHelper, TaskName.HANDWRITING, file4);
                InsertTask insertTask5 = new InsertTask(fileInsertHelper, TaskName.IMAGE, file4);
                InsertTask insertTask6 = new InsertTask(fileInsertHelper, TaskName.CODE_BLOCK, file4);
                linkedList.add(insertTask3);
                linkedList.add(insertTask4);
                linkedList.add(insertTask5);
                linkedList.add(insertTask6);
                try {
                    executorServiceNewFixedThreadPool.invokeAll(linkedList);
                } catch (InterruptedException e) {
                    Logger.m11000e(TAG, "Insert file exception : " + e);
                }
                executorServiceNewFixedThreadPool.shutdown();
                Logger.m10999d(TAG, "Start zip");
                ZipUtils zipUtils2 = ZipUtils.INSTANCE;
                zipUtils2.zip(file3, fileInsertHelper.newOfficeFile, cancellationSignal);
                Logger.m10999d(TAG, "End zip");
                Logger.m10999d(TAG, "Start delete folder unzip");
                zipUtils2.deleteDirectory(file3);
                UriHelper.requestScanFile(fileInsertHelper.mContext, new String[]{file3.getPath()}, (String[]) null);
                Logger.m10999d(TAG, "End delete folder unzip ");
                File file5 = new File(str);
                fileInsertHelper.finish = true;
                file = file5;
            } catch (Exception e2) {
                Logger.m11000e(TAG, "Insert file error : " + e2);
                fileInsertHelper.finish = true;
            }
            fileInsertHelper.newOfficeFile = file;
        } catch (Throwable th) {
            fileInsertHelper.finish = true;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertHandwriting(File mediaFolder) throws Throwable {
        Throwable th;
        NoteCaptureControl noteCaptureControl;
        SpenWNote spenWNote;
        Bitmap bitmapCreateBitmap;
        Logger.m10999d(TAG, "insertHandwriting(), start");
        HashMap<String, Integer> map = this.hwHashMap;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (!map.isEmpty()) {
                SpenWNote spenWNote2 = null;
                try {
                    spenWNote = new SpenWNote(this.mContext, null, this.mView.wNoteData.getSpenWNoteP().getPageMode(), this.mView.wNoteData.getSpenWNoteP().getOrientation(), this.mView.wNoteData.getWidth(), false);
                    try {
                        noteCaptureControl = new NoteCaptureControl(this.mContext);
                    } catch (Throwable th2) {
                        th = th2;
                        noteCaptureControl = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    noteCaptureControl = null;
                }
                try {
                    noteCaptureControl.setWNote(spenWNote);
                    HashMap<String, Integer> map2 = this.hwHashMap;
                    Intrinsics.checkNotNull(map2);
                    SpenWPage spenWPageAppendPage = null;
                    for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                        String key = entry.getKey();
                        int iIntValue = entry.getValue().intValue();
                        SpenWPage page = this.mView.wNoteData.getSpenWNoteP().getPage(iIntValue);
                        if (spenWPageAppendPage == null || !this.mView.isContinuousPage) {
                            Intrinsics.checkNotNull(page);
                            spenWPageAppendPage = spenWNote.appendPage(page.getWidth(), page.getHeight());
                            Iterator<SpenObjectBase> it = page.getObjectList(1).iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            while (it.hasNext()) {
                                SpenObjectBase next = it.next();
                                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                                SpenObjectStroke spenObjectStroke = new SpenObjectStroke();
                                spenObjectStroke.copy(next);
                                spenWPageAppendPage.appendObject(spenObjectStroke);
                            }
                        }
                        Intrinsics.checkNotNull(spenWPageAppendPage);
                        if (spenWPageAppendPage.getObjectList(1).isEmpty()) {
                            bitmapCreateBitmap = null;
                        } else {
                            noteCaptureControl.setContents(spenWPageAppendPage, spenWNote.getBodyText(), iIntValue);
                            noteCaptureControl.setBackgroundColorEnabled(false);
                            HashMap<String, OfficeCropHeight> map3 = this.cropHw;
                            Intrinsics.checkNotNull(map3);
                            bitmapCreateBitmap = (!this.mView.isContinuousPage || map3.get(key) == null) ? noteCaptureControl.capturePage(1.0f) : noteCaptureControl.captureRect(page != null ? new RectF(0.0f, r8.getPrevious(), page.getWidth(), r8.getCurrent()) : null);
                        }
                        if (bitmapCreateBitmap == null) {
                            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        }
                        InputStream inputStreamBitmapToInputStream = ConvertUtils.INSTANCE.bitmapToInputStream(bitmapCreateBitmap);
                        if (inputStreamBitmapToInputStream != null) {
                            File file = new File(mediaFolder, key);
                            if (!file.createNewFile() && !file.exists()) {
                                throw new Exception("Handwriting created failed");
                            }
                            writeFile(inputStreamBitmapToInputStream, file);
                            inputStreamBitmapToInputStream.close();
                        }
                    }
                    try {
                        spenWNote.close(true);
                    } catch (IOException e) {
                        AbstractC8014b.m7198D("insertHandwriting# close SpenWNote fail e : ", e.getMessage(), TAG);
                    }
                    noteCaptureControl.close();
                    Logger.m10999d(TAG, "insertHandwriting(), end");
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    spenWNote2 = spenWNote;
                    if (spenWNote2 != null) {
                        try {
                            spenWNote2.close(true);
                        } catch (IOException e2) {
                            AbstractC8014b.m7198D("insertHandwriting# close SpenWNote fail e : ", e2.getMessage(), TAG);
                        }
                    }
                    if (noteCaptureControl == null) {
                        throw th;
                    }
                    noteCaptureControl.close();
                    throw th;
                }
            }
        }
        Logger.m10999d(TAG, "Don't have any handwriting");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void insertImage(File mediaFolder) throws Exception {
        File file;
        InputStream inputStream;
        Logger.m10999d(TAG, "insertImage(), start");
        HashMap<String, SpenObjectBase> map = this.imageHashMap;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (map.isEmpty()) {
                Logger.m10999d(TAG, "Don't have any image");
            } else {
                this.processedPathMap = new HashMap();
                HashMap<String, SpenObjectBase> map2 = this.imageHashMap;
                Intrinsics.checkNotNull(map2);
                for (Map.Entry<String, SpenObjectBase> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    SpenObjectBase value = entry.getValue();
                    int type = value.getType();
                    if (type == 3) {
                        ImageData imageData = getImageData(value);
                        String filePath = imageData.getFilePath();
                        Bitmap bm = imageData.getBm();
                        ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                        Rect cropRect = convertUtils.getCropRect(value);
                        if (filePath == null || TextUtils.isEmpty(filePath) || value.getRotation() != 0.0f || cropRect != null) {
                            file = mediaFolder;
                            inputStream = getInputStream(bm, filePath, value, file, key);
                        } else {
                            try {
                                inputStream = convertUtils.filePathToInputStream(filePath);
                            } catch (IOException e) {
                                Logger.m10999d(TAG, "Object type " + value.getType() + " error : " + e);
                                inputStream = null;
                            }
                            file = mediaFolder;
                        }
                    } else {
                        if (type == 10) {
                            inputStream = ConvertUtils.INSTANCE.bitmapToInputStream(captureSpenObject(value, new SpenObjectVoice()));
                        } else if (type == 17) {
                            ItemUtils itemUtils = ItemUtils.INSTANCE;
                            Context context = this.mContext;
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLink");
                            OfficeView<?, ?> officeView = this.mView;
                            inputStream = ConvertUtils.INSTANCE.bitmapToInputStream(itemUtils.drawLink(context, (SpenObjectLink) value, officeView.mDocParams.contentTextSize, officeView.wNoteData.getWidth()));
                        } else if (type != 7 && type != 8) {
                            if (type == 13) {
                                inputStream = ConvertUtils.INSTANCE.bitmapToInputStream(captureSpenObject(value, new SpenObjectWeb()));
                            } else if (type != 14) {
                                inputStream = null;
                            }
                        }
                        file = mediaFolder;
                    }
                    if (inputStream != null) {
                        File file2 = new File(file, key);
                        if (!file2.createNewFile() && !file2.exists()) {
                            throw new Exception("Image created failed");
                        }
                        writeFile(inputStream, file2);
                        inputStream.close();
                    }
                    mediaFolder = file;
                }
            }
        }
        Logger.m10999d(TAG, "insertImage(), end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertVoiceData(File mediaFolder) throws Exception {
        Logger.m10999d(TAG, "insertVoiceData(), start");
        HashMap<String, SpenVoiceData> map = this.voiceData;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            if (!map.isEmpty()) {
                OfficeView<?, ?> officeView = this.mView;
                int i = officeView.mDocParams.contentTextSize;
                SpenWPage page = officeView.wNoteData.getPage(0);
                if (page == null) {
                    Logger.m10999d(TAG, "Failed to get spenWPage");
                    return;
                }
                HashMap<String, SpenVoiceData> map2 = this.voiceData;
                Intrinsics.checkNotNull(map2);
                Set<Map.Entry<String, SpenVoiceData>> setEntrySet = map2.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
                for (Map.Entry<String, SpenVoiceData> entry : setEntrySet) {
                    String key = entry.getKey();
                    SpenVoiceData value = entry.getValue();
                    ItemUtils itemUtils = ItemUtils.INSTANCE;
                    Context context = this.mContext;
                    String name = value.getName();
                    String playTime = value.getPlayTime();
                    OfficeParams officeParams = this.mView.mDocParams;
                    InputStream inputStreamBitmapToInputStream = ConvertUtils.INSTANCE.bitmapToInputStream(itemUtils.drawVoice(context, name, playTime, i, officeParams.contentTextColor, officeParams.borderColor, page.getWidth() / 2));
                    if (inputStreamBitmapToInputStream != null) {
                        File file = new File(mediaFolder, key);
                        if (!file.createNewFile() && !file.exists()) {
                            throw new Exception("Voice created failed");
                        }
                        writeFile(inputStreamBitmapToInputStream, file);
                        inputStreamBitmapToInputStream.close();
                    }
                }
                Logger.m10999d(TAG, "insertVoiceData(), end");
                return;
            }
        }
        Logger.m10999d(TAG, "Don't have any voice data");
    }

    private final SpenWPage setPageBackground(SpenWPage inputPageBackground, SpenWNote noteBackground) {
        if (inputPageBackground != null) {
            return inputPageBackground;
        }
        SpenWPage spenWPage = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage);
        if (spenWPage.hasPDF()) {
            SpenWPage spenWPageCopyPage = noteBackground.copyPage(this.spenWPage, noteBackground.getPageCount());
            spenWPageCopyPage.removeAllObject();
            return spenWPageCopyPage;
        }
        SpenWPage spenWPage2 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage2);
        int width = spenWPage2.getWidth();
        SpenWPage spenWPage3 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage3);
        SpenWPage spenWPageAppendPage = noteBackground.appendPage(width, spenWPage3.getHeight());
        SpenWPage spenWPage4 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage4);
        spenWPageAppendPage.setBackgroundImage(spenWPage4.getBackgroundImagePath());
        SpenWPage spenWPage5 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage5);
        spenWPageAppendPage.setBackgroundColor(spenWPage5.getBackgroundColor());
        SpenWPage spenWPage6 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage6);
        spenWPageAppendPage.setBackgroundImageMode(spenWPage6.getBackgroundImageMode());
        SpenWPage spenWPage7 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage7);
        spenWPageAppendPage.setTemplateType(spenWPage7.getTemplateType());
        SpenWPage spenWPage8 = this.spenWPage;
        Intrinsics.checkNotNull(spenWPage8);
        spenWPageAppendPage.setTemplateURI(spenWPage8.getTemplateURI());
        return spenWPageAppendPage;
    }

    private final void writeFile(InputStream inputStream, File outputFile) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } finally {
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedOutputStream, null);
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        return;
                    }
                    bufferedOutputStream.write(bArr, 0, i);
                }
            } finally {
            }
        } finally {
        }
    }

    @Nullable
    public final ArrayList<OfficeBackground> getBgList() {
        return this.bgList;
    }

    @Nullable
    public final HashMap<String, SpenObjectCodeBlock> getCodeBlockHashMap() {
        return this.codeBlockHashMap;
    }

    @Nullable
    public final HashMap<String, OfficeCropHeight> getCropBg() {
        return this.cropBg;
    }

    @Nullable
    public final HashMap<String, OfficeCropHeight> getCropHw() {
        return this.cropHw;
    }

    @Nullable
    public final HashMap<String, Integer> getHwHashMap() {
        return this.hwHashMap;
    }

    @Nullable
    public final HashMap<String, SpenObjectBase> getImageHashMap() {
        return this.imageHashMap;
    }

    @Nullable
    public final HashMap<String, PackagePart> getPartHashMap() {
        return this.partHashMap;
    }

    @Nullable
    public final HashMap<String, SpenVoiceData> getVoiceData() {
        return this.voiceData;
    }

    @Nullable
    public final HashMap<String, String> getVoiceHashMap() {
        return this.voiceHashMap;
    }

    @Nullable
    public File insertFile(@NotNull File officeFile) {
        HashMap<String, SpenObjectBase> map;
        HashMap<String, Integer> map2;
        HashMap<String, SpenVoiceData> map3;
        ArrayList<OfficeBackground> arrayList;
        HashMap<String, SpenObjectCodeBlock> map4;
        boolean z;
        Intrinsics.checkNotNullParameter(officeFile, "officeFile");
        this.newOfficeFile = officeFile;
        this.finish = false;
        HashMap<String, String> map5 = this.voiceHashMap;
        if ((map5 == null || map5.isEmpty()) && (((map = this.imageHashMap) == null || map.isEmpty()) && (((map2 = this.hwHashMap) == null || map2.isEmpty()) && (((map3 = this.voiceData) == null || map3.isEmpty()) && (((arrayList = this.bgList) == null || arrayList.isEmpty()) && ((map4 = this.codeBlockHashMap) == null || map4.isEmpty())))))) {
            return this.newOfficeFile;
        }
        CancellationSignal cancellationSignal = new CancellationSignal();
        new SenlThreadFactory(TAG).newThread(new RunnableC8928b(this, 23, cancellationSignal, officeFile.getPath())).start();
        while (true) {
            z = this.mView.isAlive;
            if (!z || this.finish) {
                break;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                Logger.m10999d(TAG, "Sleep when insert background error : " + e);
                this.mView.isAlive = false;
                this.newOfficeFile = null;
            }
        }
        if (!z) {
            cancellationSignal.cancel();
        }
        return this.newOfficeFile;
    }

    public final void setBgList(@Nullable ArrayList<OfficeBackground> arrayList) {
        this.bgList = arrayList;
    }

    public final void setCodeBlockHashMap(@Nullable HashMap<String, SpenObjectCodeBlock> map) {
        this.codeBlockHashMap = map;
    }

    public final void setCropBg(@Nullable HashMap<String, OfficeCropHeight> map) {
        this.cropBg = map;
    }

    public final void setCropHw(@Nullable HashMap<String, OfficeCropHeight> map) {
        this.cropHw = map;
    }

    public final void setHwHashMap(@Nullable HashMap<String, Integer> map) {
        this.hwHashMap = map;
    }

    public final void setImageHashMap(@Nullable HashMap<String, SpenObjectBase> map) {
        this.imageHashMap = map;
    }

    public final void setPartHashMap(@Nullable HashMap<String, PackagePart> map) {
        this.partHashMap = map;
    }

    public final void setVoiceData(@Nullable HashMap<String, SpenVoiceData> map) {
        this.voiceData = map;
    }

    public final void setVoiceHashMap(@Nullable HashMap<String, String> map) {
        this.voiceHashMap = map;
    }
}
