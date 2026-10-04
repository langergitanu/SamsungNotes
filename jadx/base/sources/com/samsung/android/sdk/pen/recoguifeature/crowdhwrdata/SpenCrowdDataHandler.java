package com.samsung.android.sdk.pen.recoguifeature.crowdhwrdata;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.animation.core.AnimationKt;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u0019J\u0006\u0010\"\u001a\u00020\u001cJ\b\u0010#\u001a\u00020\u0007H\u0002J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00190\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdDataHandler;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "accountId", "", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "sentence", "getSentence", "setSentence", "toolType", "", "getToolType", "()I", "setToolType", "(I)V", "mStrokes", "Ljava/util/Stack;", "Ljava/util/ArrayList;", "Landroid/view/MotionEvent;", "Lkotlin/collections/ArrayList;", "mNNFolder", "close", "", "addTouchEvent", "event", "clearData", "saveData", "getData", "undo", "getCurrentSaveFilename", "saveTouchData", "writer", "Ljava/io/PrintWriter;", "deleteFolder", "file", "Ljava/io/File;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenCrowdDataHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenCrowdDataHandler.kt\ncom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdDataHandler\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,240:1\n13579#2,2:241\n*S KotlinDebug\n*F\n+ 1 SpenCrowdDataHandler.kt\ncom/samsung/android/sdk/pen/recoguifeature/crowdhwrdata/SpenCrowdDataHandler\n*L\n225#1:241,2\n*E\n"})
public final class SpenCrowdDataHandler {

    @NotNull
    private static final String NN_PATH = "/nnfiles";

    @NotNull
    private static final String TAG = "SpenCrowdHwrManager";

    @Nullable
    private Context context;

    @NotNull
    private String mNNFolder;

    @NotNull
    private String accountId = "";

    @NotNull
    private String sentence = "";
    private int toolType = 2;

    @NotNull
    private Stack<ArrayList<MotionEvent>> mStrokes = new Stack<>();

    public SpenCrowdDataHandler(@Nullable Context context) {
        File filesDir;
        this.context = context;
        Context context2 = this.context;
        this.mNNFolder = AbstractC0541b.m756B((context2 == null || (filesDir = context2.getFilesDir()) == null) ? null : filesDir.getAbsolutePath(), NN_PATH);
        File file = new File(this.mNNFolder);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private final void deleteFolder(File file) {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        Intrinsics.checkNotNull(file2);
                        deleteFolder(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    private final String getCurrentSaveFilename() {
        String str = this.mNNFolder;
        String str2 = this.accountId;
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        sb.append("_");
        return AbstractC2821a.m2224o(sb, ".nn", jCurrentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getData$lambda$3(File file, String str) {
        Intrinsics.checkNotNull(str);
        return StringsKt.m14167w(str, ".nn");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [int] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4, types: [int] */
    /* JADX WARN: Type inference failed for: r18v5 */
    private final void saveTouchData(PrintWriter writer) {
        long j;
        ?? IsResampled;
        if (writer == null) {
            return;
        }
        while (!this.mStrokes.empty()) {
            ArrayList<MotionEvent> arrayListPop = this.mStrokes.pop();
            if (!arrayListPop.isEmpty()) {
                int i = 0;
                try {
                    MotionEvent motionEvent = arrayListPop.get(0);
                    Intrinsics.checkNotNullExpressionValue(motionEvent, "get(...)");
                    MotionEvent motionEvent2 = motionEvent;
                    int i2 = Build.VERSION.SDK_INT;
                    long j2 = AnimationKt.MillisToNanos;
                    long eventTime = i2 < 34 ? motionEvent2.getEventTime() * AnimationKt.MillisToNanos : motionEvent2.getEventTimeNanos();
                    Iterator<MotionEvent> it = arrayListPop.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        MotionEvent next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        MotionEvent motionEvent3 = next;
                        int historySize = motionEvent3.getHistorySize();
                        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                        motionEvent3.getPointerCoords(i, pointerCoords);
                        int i4 = i;
                        while (true) {
                            j = j2;
                            if (i4 >= historySize) {
                                break;
                            }
                            int i5 = Build.VERSION.SDK_INT;
                            long historicalEventTime = i5 < 34 ? motionEvent3.getHistoricalEventTime(i4) * j : motionEvent3.getHistoricalEventTimeNanos(i4);
                            if (i5 > 34) {
                                MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords();
                                motionEvent3.getHistoricalPointerCoords(i, i4, pointerCoords2);
                                IsResampled = pointerCoords2.isResampled();
                            } else {
                                IsResampled = -1;
                            }
                            int i6 = this.toolType;
                            if (i6 == 2) {
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String str = String.format(Locale.US, "%d %.4f %.4f %d %.4f %.4f %.4f H %d", Arrays.copyOf(new Object[]{Long.valueOf((historicalEventTime - eventTime) / ((long) 1000)), Float.valueOf(motionEvent3.getHistoricalX(i4)), Float.valueOf(motionEvent3.getHistoricalY(i4)), Integer.valueOf(motionEvent3.getAction()), Float.valueOf(motionEvent3.getHistoricalOrientation(i4)), Float.valueOf(motionEvent3.getHistoricalAxisValue(25, i4)), Float.valueOf(motionEvent3.getHistoricalPressure(i4)), Integer.valueOf((int) IsResampled)}, 8));
                                Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
                                writer.println(str);
                            } else if (i6 == 1) {
                                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                String str2 = String.format(Locale.US, "%d %.4f %.4f %d %.4f %.4f %.4f H %d", Arrays.copyOf(new Object[]{Long.valueOf((historicalEventTime - eventTime) / ((long) 1000)), Float.valueOf(motionEvent3.getHistoricalX(i4)), Float.valueOf(motionEvent3.getHistoricalY(i4)), Integer.valueOf(motionEvent3.getAction()), Float.valueOf(motionEvent3.getHistoricalTouchMinor(i4)), Float.valueOf(motionEvent3.getHistoricalTouchMajor(i4)), Float.valueOf(motionEvent3.getHistoricalSize(i4)), Integer.valueOf((int) IsResampled)}, 8));
                                Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
                                writer.println(str2);
                            }
                            i4++;
                            j2 = j;
                            i = 0;
                        }
                        int i7 = Build.VERSION.SDK_INT;
                        long eventTime2 = i7 < 34 ? motionEvent3.getEventTime() * j : motionEvent3.getEventTimeNanos();
                        ?? IsResampled2 = i7 > 34 ? pointerCoords.isResampled() : -1;
                        int i8 = this.toolType;
                        if (i8 == 2) {
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            String str3 = String.format(Locale.US, "%d %.4f %.4f %d %.4f %.4f %.4f M %d", Arrays.copyOf(new Object[]{Long.valueOf((eventTime2 - eventTime) / ((long) 1000)), Float.valueOf(motionEvent3.getX()), Float.valueOf(motionEvent3.getY()), Integer.valueOf(motionEvent3.getAction()), Float.valueOf(motionEvent3.getOrientation()), Float.valueOf(motionEvent3.getAxisValue(25)), Float.valueOf(motionEvent3.getPressure()), Integer.valueOf((int) IsResampled2)}, 8));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(locale, format, *args)");
                            writer.println(str3);
                        } else if (i8 == 1) {
                            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                            String str4 = String.format(Locale.US, "%d %.4f %.4f %d %.4f %.4f %.4f M %d", Arrays.copyOf(new Object[]{Long.valueOf((eventTime2 - eventTime) / ((long) 1000)), Float.valueOf(motionEvent3.getX()), Float.valueOf(motionEvent3.getY()), Integer.valueOf(motionEvent3.getAction()), Float.valueOf(motionEvent3.getTouchMinor()), Float.valueOf(motionEvent3.getTouchMajor()), Float.valueOf(motionEvent3.getSize()), Integer.valueOf((int) IsResampled2)}, 8));
                            Intrinsics.checkNotNullExpressionValue(str4, "format(locale, format, *args)");
                            writer.println(str4);
                        }
                        j2 = j;
                        i = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void addTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.toolType != event.getToolType(0)) {
            return;
        }
        int action = event.getAction();
        if (1 == action || action == 0 || 2 == action) {
            synchronized (this.mStrokes) {
                if (action == 0) {
                    try {
                        this.mStrokes.push(new ArrayList<>());
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (!this.mStrokes.empty()) {
                    this.mStrokes.peek().add(MotionEvent.obtain(event));
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void clearData() {
        synchronized (this.mStrokes) {
            try {
                if (!this.mStrokes.empty()) {
                    this.mStrokes.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void close() {
        deleteFolder(new File(this.mNNFolder));
    }

    @NotNull
    public final String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public final ArrayList<String> getData() {
        File[] fileArrListFiles = new File(this.mNNFolder).listFiles(new C0035a(4));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            Log.i(TAG, "There is no nn file.");
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator it = ArrayIteratorKt.iterator(fileArrListFiles);
        while (it.hasNext()) {
            arrayList.add(((File) it.next()).getAbsolutePath());
        }
        return arrayList;
    }

    @NotNull
    public final String getSentence() {
        return this.sentence;
    }

    public final int getToolType() {
        return this.toolType;
    }

    public final void saveData() {
        PrintWriter printWriter;
        Resources resources;
        DisplayMetrics displayMetrics;
        try {
            printWriter = new PrintWriter(getCurrentSaveFilename(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            printWriter = null;
        }
        Context context = this.context;
        if (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        if (printWriter != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            printWriter.println(AbstractC11014a.m12323h(new Object[]{Float.valueOf(displayMetrics.xdpi), Float.valueOf(displayMetrics.ydpi), Build.FINGERPRINT}, 3, Locale.US, "%.4f %.4f %s", "format(locale, format, *args)"));
        }
        if (printWriter != null) {
            printWriter.println(this.sentence);
        }
        synchronized (this.mStrokes) {
            saveTouchData(printWriter);
            Unit unit = Unit.INSTANCE;
        }
        if (printWriter != null) {
            printWriter.close();
        }
    }

    public final void setAccountId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public final void setSentence(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sentence = str;
    }

    public final void setToolType(int i) {
        this.toolType = i;
    }

    public final void undo() {
        synchronized (this.mStrokes) {
            try {
                if (!this.mStrokes.empty()) {
                    this.mStrokes.pop();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
