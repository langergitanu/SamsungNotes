package com.samsung.android.sdk.pen.recogengine.hwrsampler;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rJ\u0010\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\fJ\r\u0010 \u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010!J\u001a\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrsampler/SpenCrowdSource;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mWordList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mSamsungAccountHash", "mSamsungAccountName", "mProductName", "mModelName", "mDpiX", "", "mDpiY", "mDatetime", "mLanguage", "mTargetLabelList", "initWordList", "", "words", "generateRandomTargetLabel", "labelLength", "", "appendLabel", "label", "getTargetLabelCount", "()Ljava/lang/Integer;", "getTargetLabelList", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenCrowdSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenCrowdSource.kt\ncom/samsung/android/sdk/pen/recogengine/hwrsampler/SpenCrowdSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,99:1\n1#2:100\n*E\n"})
public final class SpenCrowdSource {

    @NotNull
    private static final String ASSET_WORDS = "words/words(10000).txt";
    public static final int MAX_TARGET_LABEL_LENGTH = 10;

    @NotNull
    private static final String TAG = "SpenCrowdSampler";

    @Nullable
    private Context mContext;

    @Nullable
    private String mDatetime;
    private float mDpiX;
    private float mDpiY;

    @Nullable
    private String mLanguage;

    @Nullable
    private String mModelName;

    @Nullable
    private String mProductName;

    @Nullable
    private String mSamsungAccountHash;

    @Nullable
    private String mSamsungAccountName;

    @Nullable
    private ArrayList<String> mTargetLabelList = new ArrayList<>();

    @Nullable
    private ArrayList<String> mWordList;

    public SpenCrowdSource(@Nullable Context context) throws Throwable {
        this.mContext = context;
        initWordList();
    }

    public static /* synthetic */ String generateRandomTargetLabel$default(SpenCrowdSource spenCrowdSource, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        return spenCrowdSource.generateRandomTargetLabel(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initWordList() throws Throwable {
        BufferedReader bufferedReader;
        InputStream inputStreamOpen;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        AssetManager assets = context.getResources().getAssets();
        this.mWordList = new ArrayList<>();
        InputStream inputStream = null;
        if (assets != null) {
            try {
                inputStreamOpen = assets.open(ASSET_WORDS);
            } catch (Exception e) {
                e = e;
                bufferedReader = null;
                try {
                    Log.e(TAG, "Asset file open error : " + e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader == null) {
                        bufferedReader.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } else {
            inputStreamOpen = null;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    ArrayList<String> arrayList = this.mWordList;
                    Intrinsics.checkNotNull(arrayList);
                    arrayList.add(line);
                } catch (Exception e2) {
                    inputStream = inputStreamOpen;
                    e = e2;
                    Log.e(TAG, "Asset file open error : " + e);
                    if (inputStream != null) {
                    }
                    if (bufferedReader == null) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStreamOpen;
                    th = th;
                    if (inputStream != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            Log.i(TAG, "Initialized Complete");
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            bufferedReader.close();
        } catch (Exception e3) {
            inputStream = inputStreamOpen;
            e = e3;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public final void appendLabel(@NotNull String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        ArrayList<String> arrayList = this.mTargetLabelList;
        if (arrayList != null) {
            arrayList.add(label);
        }
    }

    @NotNull
    public final String generateRandomTargetLabel(int labelLength) {
        ArrayList<String> arrayList = this.mWordList;
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 0;
        while (true) {
            int iNextInt = random.nextInt(size);
            ArrayList<String> arrayList2 = this.mWordList;
            Intrinsics.checkNotNull(arrayList2);
            String str = arrayList2.get(iNextInt);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            String str2 = str;
            length += str2.length();
            if (length > labelLength) {
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
            sb.append(str2);
            sb.append(" ");
        }
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @Nullable
    public final Integer getTargetLabelCount() {
        ArrayList<String> arrayList = this.mTargetLabelList;
        if (arrayList != null) {
            return Integer.valueOf(arrayList.size());
        }
        return null;
    }

    @Nullable
    public final ArrayList<String> getTargetLabelList() {
        return this.mTargetLabelList;
    }

    public final void setMContext(@Nullable Context context) {
        this.mContext = context;
    }

    public final void initWordList(@NotNull ArrayList<String> words) {
        Intrinsics.checkNotNullParameter(words, "words");
        this.mWordList = words;
    }
}
