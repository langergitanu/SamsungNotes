package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class NetworkFetcher {

    @NonNull
    private final LottieNetworkFetcher fetcher;

    @Nullable
    private final NetworkCache networkCache;

    /* JADX INFO: renamed from: com.airbnb.lottie.network.NetworkFetcher$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C43421 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$network$FileExtension;

        static {
            int[] iArr = new int[FileExtension.values().length];
            $SwitchMap$com$airbnb$lottie$network$FileExtension = iArr;
            try {
                iArr[FileExtension.ZIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$network$FileExtension[FileExtension.GZIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NetworkFetcher(@Nullable NetworkCache networkCache, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache;
        this.fetcher = lottieNetworkFetcher;
    }

    @Nullable
    @WorkerThread
    private LottieComposition fetchFromCache(Context context, @NonNull String str, @Nullable String str2) {
        NetworkCache networkCache;
        Pair<FileExtension, InputStream> pairFetch;
        LottieResult<LottieComposition> lottieResultFromZipStreamSync;
        if (str2 == null || (networkCache = this.networkCache) == null || (pairFetch = networkCache.fetch(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairFetch.first;
        InputStream inputStream = (InputStream) pairFetch.second;
        int i = C43421.$SwitchMap$com$airbnb$lottie$network$FileExtension[fileExtension.ordinal()];
        if (i == 1) {
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), str2);
        } else if (i != 2) {
            lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str2);
        } else {
            try {
                lottieResultFromZipStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), str2);
            } catch (IOException e) {
                lottieResultFromZipStreamSync = new LottieResult<>(e);
            }
        }
        if (lottieResultFromZipStreamSync.getValue() != null) {
            return lottieResultFromZipStreamSync.getValue();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    private LottieResult<LottieComposition> fetchFromNetwork(Context context, @NonNull String str, @Nullable String str2) {
        LottieResult<LottieComposition> lottieResult;
        Logger.debug("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult lottieFetchResultFetchSync = this.fetcher.fetchSync(str);
                if (lottieFetchResultFetchSync.isSuccessful()) {
                    lottieResult = fromInputStream(context, str, lottieFetchResultFetchSync.bodyByteStream(), lottieFetchResultFetchSync.contentType(), str2);
                    StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                    sb.append(lottieResult.getValue() != null);
                    Logger.debug(sb.toString());
                } else {
                    lottieResult = new LottieResult<>(new IllegalArgumentException(lottieFetchResultFetchSync.error()));
                }
                try {
                    lottieFetchResultFetchSync.close();
                    return lottieResult;
                } catch (IOException e) {
                    Logger.warning("LottieFetchResult close failed ", e);
                    return lottieResult;
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    throw th;
                }
                try {
                    closeable.close();
                    throw th;
                } catch (IOException e2) {
                    Logger.warning("LottieFetchResult close failed ", e2);
                    throw th;
                }
            }
        } catch (Exception e3) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e3);
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    Logger.warning("LottieFetchResult close failed ", e5);
                }
            }
            return lottieResult2;
        }
    }

    @NonNull
    private LottieResult<LottieComposition> fromGzipStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.networkCache) == null) ? LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(inputStream), null) : LottieCompositionFactory.fromJsonInputStreamSync(new GZIPInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.GZIP))), str);
    }

    @NonNull
    private LottieResult<LottieComposition> fromInputStream(Context context, @NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) {
        LottieResult<LottieComposition> lottieResultFromZipStream;
        FileExtension fileExtension;
        NetworkCache networkCache;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains(Constants.MINE_ZIP_EXTENSION) || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            lottieResultFromZipStream = fromZipStream(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else if (str2.contains("application/gzip") || str2.contains("application/x-gzip") || str.split("\\?")[0].endsWith(".tgs")) {
            Logger.debug("Handling gzip response.");
            fileExtension = FileExtension.GZIP;
            lottieResultFromZipStream = fromGzipStream(str, inputStream, str3);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            lottieResultFromZipStream = fromJsonStream(str, inputStream, str3);
        }
        if (str3 != null && lottieResultFromZipStream.getValue() != null && (networkCache = this.networkCache) != null) {
            networkCache.renameTempFile(str, fileExtension);
        }
        return lottieResultFromZipStream;
    }

    @NonNull
    private LottieResult<LottieComposition> fromJsonStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.networkCache) == null) ? LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null) : LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    private LottieResult<LottieComposition> fromZipStream(Context context, @NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.networkCache) == null) ? LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(inputStream), (String) null) : LottieCompositionFactory.fromZipStreamSync(context, new ZipInputStream(new FileInputStream(networkCache.writeTempCacheFile(str, inputStream, FileExtension.ZIP))), str);
    }

    @NonNull
    @WorkerThread
    public LottieResult<LottieComposition> fetchSync(Context context, @NonNull String str, @Nullable String str2) {
        LottieComposition lottieCompositionFetchFromCache = fetchFromCache(context, str, str2);
        if (lottieCompositionFetchFromCache != null) {
            return new LottieResult<>(lottieCompositionFetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(context, str, str2);
    }
}
