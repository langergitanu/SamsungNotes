package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.JSONObject;
import p012C1.CallableC0047c;
import p035H2.RunnableC0116a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
    private static final Set<LottieTaskIdleListener> taskIdleListeners = new HashSet();
    private static final byte[] ZIP_MAGIC = {80, 75, 3, 4};
    private static final byte[] GZIP_MAGIC = {31, -117, 8};

    private LottieCompositionFactory() {
    }

    private static LottieTask<LottieComposition> cache(@Nullable final String str, Callable<LottieResult<LottieComposition>> callable, @Nullable Runnable runnable) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        LottieTask<LottieComposition> lottieTask = lottieComposition != null ? new LottieTask<>(lottieComposition) : null;
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                lottieTask = map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask<LottieComposition> lottieTask2 = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final int i = 0;
            lottieTask2.addListener(new LottieListener() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    switch (i) {
                        case 0:
                            LottieCompositionFactory.lambda$cache$18(str, atomicBoolean, (LottieComposition) obj);
                            break;
                        default:
                            LottieCompositionFactory.lambda$cache$19(str, atomicBoolean, (Throwable) obj);
                            break;
                    }
                }
            });
            final int i2 = 1;
            lottieTask2.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    switch (i2) {
                        case 0:
                            LottieCompositionFactory.lambda$cache$18(str, atomicBoolean, (LottieComposition) obj);
                            break;
                        default:
                            LottieCompositionFactory.lambda$cache$19(str, atomicBoolean, (Throwable) obj);
                            break;
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, LottieTask<LottieComposition>> map2 = taskCache;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask2;
    }

    public static void clearCache(Context context) {
        clearCache(context, true);
    }

    @Nullable
    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> fromInputStream(@Nullable Context context, InputStream inputStream, @Nullable String str) {
        return cache(str, new CallableC0047c(context == null ? null : context.getApplicationContext(), 3, inputStream, str), null);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromInputStreamSync(@Nullable Context context, InputStream inputStream, @Nullable String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStream));
            return isZipCompressed(bufferedSourceBuffer).booleanValue() ? fromZipStreamSync(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str) : isGzipCompressed(bufferedSourceBuffer).booleanValue() ? fromJsonInputStreamSync(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str) : fromJsonReaderSync(JsonReader.m3056of(bufferedSourceBuffer), str);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, @Nullable String str) {
        return cache(str, new CallableC4323b(5, jSONObject, str), null);
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, @Nullable String str) {
        return cache(str, new CallableC4323b(4, inputStream, str), new RunnableC4326e(inputStream, 2));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, @Nullable String str) {
        return cache(str, new CallableC4323b(3, jsonReader, str), new RunnableC4326e(jsonReader, 0));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, @Nullable String str) {
        return fromJsonReaderSync(jsonReader, str, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, @Nullable String str, boolean z) {
        LottieComposition lottieComposition;
        try {
            if (str == null) {
                lottieComposition = null;
            } else {
                try {
                    lottieComposition = LottieCompositionCache.getInstance().get(str);
                } catch (Exception e) {
                    LottieResult<LottieComposition> lottieResult = new LottieResult<>(e);
                    if (z) {
                        Utils.closeQuietly(jsonReader);
                    }
                    return lottieResult;
                }
            }
            if (lottieComposition != null) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(lottieComposition);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
            LottieComposition lottieComposition2 = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition2);
            }
            LottieResult<LottieComposition> lottieResult3 = new LottieResult<>(lottieComposition2);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult3;
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromJsonSource(Source source, @Nullable String str) {
        return cache(str, new CallableC4323b(1, source, str), new RunnableC4326e(source, 1));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonSourceSync(Source source, @Nullable String str) {
        return fromJsonSourceSync(source, str, true);
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, @Nullable String str2) {
        return cache(str2, new CallableC4323b(str, str2), null);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonStringSync(String str, @Nullable String str2) {
        return fromJsonSourceSync(Okio.source(new ByteArrayInputStream(str.getBytes())), str2);
    }

    @WorkerThread
    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, @Nullable String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes int i) {
        return fromRawRes(context, i, rawResCacheKey(context, i));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i) {
        return fromRawResSync(context, i, rawResCacheKey(context, i));
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, @Nullable String str) {
        return fromZipStream((Context) null, zipInputStream, str);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String str) {
        return fromZipStreamSync(zipInputStream, str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x014b A[Catch: IOException -> 0x02ad, TryCatch #4 {IOException -> 0x02ad, blocks: (B:7:0x0019, B:9:0x001f, B:12:0x0028, B:14:0x0034, B:75:0x017b, B:15:0x0039, B:17:0x0045, B:18:0x004a, B:20:0x0056, B:21:0x006f, B:24:0x0079, B:26:0x0081, B:28:0x0089, B:31:0x0093, B:33:0x009b, B:36:0x00a4, B:37:0x00a9, B:39:0x00bb, B:41:0x00dc, B:70:0x0141, B:72:0x014b, B:73:0x0168, B:69:0x0120, B:74:0x016c, B:5:0x000f, B:42:0x00e5, B:53:0x0106, B:68:0x011f, B:67:0x011c, B:64:0x0117, B:43:0x00ea, B:52:0x0103, B:63:0x0116, B:62:0x0113), top: B:131:0x000f, inners: #1 }] */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str) {
        LottieComposition lottieComposition;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            lottieComposition = null;
        } else {
            try {
                lottieComposition = LottieCompositionCache.getInstance().get(str);
            } catch (IOException e) {
                return new LottieResult<>((Throwable) e);
            }
        }
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        LottieComposition value = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                value = fromJsonReaderSyncInternal(JsonReader.m3056of(Okio.buffer(Okio.source(zipInputStream))), null, false).getValue();
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
                String[] strArrSplit2 = name.split("/");
                String str2 = strArrSplit2[strArrSplit2.length - 1];
                String str3 = str2.split(RemoteConstant.VERSION_DIVIDE)[0];
                if (context == null) {
                    return new LottieResult<>((Throwable) new IllegalStateException("Unable to extract font " + str3 + " please pass a non-null Context parameter"));
                }
                File file = new File(context.getCacheDir(), str2);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i);
                            }
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } finally {
                    }
                } catch (Throwable th3) {
                    Logger.warning("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th3);
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    if (!file.delete()) {
                    }
                    map2.put(str3, typefaceCreateFromFile);
                    nextEntry = zipInputStream.getNextEntry();
                }
                Typeface typefaceCreateFromFile2 = Typeface.createFromFile(file);
                if (!file.delete()) {
                    Logger.warning("Failed to delete temp font file " + file.getAbsolutePath() + Extension.DOT);
                }
                map2.put(str3, typefaceCreateFromFile2);
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (value == null) {
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            LottieImageAsset lottieImageAssetFindImageAssetForFileName = findImageAssetForFileName(value, (String) entry.getKey());
            if (lottieImageAssetFindImageAssetForFileName != null) {
                lottieImageAssetFindImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), lottieImageAssetFindImageAssetForFileName.getWidth(), lottieImageAssetFindImageAssetForFileName.getHeight()));
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z = false;
            for (Font font : value.getFonts().values()) {
                if (font.getFamily().equals(entry2.getKey())) {
                    font.setTypeface((Typeface) entry2.getValue());
                    z = true;
                }
            }
            if (!z) {
                Logger.warning("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator<Map.Entry<String, LottieImageAsset>> it = value.getImages().entrySet().iterator();
            while (it.hasNext()) {
                LottieImageAsset value2 = it.next().getValue();
                if (value2 == null) {
                    return null;
                }
                String fileName = value2.getFileName();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                        if (bitmapDecodeByteArray != null) {
                            value2.setBitmap(Utils.resizeBitmapIfNeeded(bitmapDecodeByteArray, value2.getWidth(), value2.getHeight()));
                        }
                    } catch (IllegalArgumentException e2) {
                        Logger.warning("data URL did not have correct base64 format.", e2);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            LottieCompositionCache.getInstance().put(str, value);
        }
        return new LottieResult<>(value);
    }

    private static Boolean isGzipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, GZIP_MAGIC);
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, ZIP_MAGIC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$18(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$cache$19(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fromJsonInputStream$7(boolean z, InputStream inputStream) {
        if (z) {
            Utils.closeQuietly(inputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromRawRes$3(WeakReference weakReference, Context context, int i, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LottieResult lambda$fromUrl$0(Context context, String str, String str2) {
        LottieResult<LottieComposition> lottieResultFetchSync = C4306L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    private static Boolean matchesMagicBytes(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b : bArr) {
                if (bufferedSourcePeek.readByte() != b) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e) {
            Logger.error("Failed to check zip file header", e);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static void notifyTaskCacheIdleListeners(boolean z) {
        ArrayList arrayList = new ArrayList(taskIdleListeners);
        for (int i = 0; i < arrayList.size(); i++) {
            ((LottieTaskIdleListener) arrayList.get(i)).onIdleChanged(z);
        }
    }

    private static String rawResCacheKey(Context context, @RawRes int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(isNightMode(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    public static void registerLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.add(lottieTaskIdleListener);
        lottieTaskIdleListener.onIdleChanged(taskCache.size() == 0);
    }

    public static void setMaxCacheSize(int i) {
        LottieCompositionCache.getInstance().resize(i);
    }

    public static void unregisterLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.remove(lottieTaskIdleListener);
    }

    public static void clearCache(Context context, boolean z) {
        NetworkCache networkCache;
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        if (!z || (networkCache = C4306L.networkCache(context)) == null) {
            return;
        }
        networkCache.clear();
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, @Nullable final String str, final boolean z) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str, z);
            }
        }, new RunnableC0116a(z, inputStream));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, @Nullable String str, boolean z) {
        return fromJsonSourceSync(Okio.source(inputStream), str, z);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, @Nullable String str, boolean z) {
        return fromJsonReaderSyncInternal(jsonReader, str, z);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromJsonSourceSync(Source source, @Nullable String str, boolean z) {
        return fromJsonReaderSyncInternal(JsonReader.m3056of(Okio.buffer(source)), str, z);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, @RawRes final int i, @Nullable final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.lambda$fromRawRes$3(weakReference, applicationContext, i, str);
            }
        }, null);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromRawResSync(Context context, @RawRes int i, @Nullable String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (isZipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (!isGzipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromJsonReaderSync(JsonReader.m3056of(bufferedSourceBuffer), str);
            }
            try {
                return fromJsonInputStreamSync(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
            } catch (IOException e) {
                return new LottieResult<>((Throwable) e);
            }
        } catch (Resources.NotFoundException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str, @Nullable String str2) {
        return cache(str2, new CallableC4327f(context, str, str2, 1), null);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, @Nullable String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        LottieResult<LottieComposition> lottieResultFetchSync = C4306L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, @Nullable String str, boolean z) {
        return fromZipStream(null, zipInputStream, str, z);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, @Nullable String str, boolean z) {
        return fromZipStreamSync(null, zipInputStream, str, z);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str, @Nullable String str2) {
        return cache(str2, new CallableC4327f(context.getApplicationContext(), str, str2, 0), null);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, @Nullable String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            return fromInputStreamSync(context, context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(Context context, ZipInputStream zipInputStream, @Nullable String str) {
        int i = 0;
        return cache(str, new CallableC4328g(context, zipInputStream, str, i), new RunnableC4329h(zipInputStream, i));
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str) {
        return fromZipStreamSync(context, zipInputStream, str, true);
    }

    public static LottieTask<LottieComposition> fromZipStream(Context context, ZipInputStream zipInputStream, @Nullable String str, boolean z) {
        return cache(str, new CallableC4328g(context, zipInputStream, str, 1), z ? new RunnableC4329h(zipInputStream, 1) : null);
    }

    @WorkerThread
    public static LottieResult<LottieComposition> fromZipStreamSync(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str, boolean z) {
        try {
            return fromZipStreamSyncInternal(context, zipInputStream, str);
        } finally {
            if (z) {
                Utils.closeQuietly(zipInputStream);
            }
        }
    }
}
