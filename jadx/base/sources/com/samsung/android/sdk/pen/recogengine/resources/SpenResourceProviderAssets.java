package com.samsung.android.sdk.pen.recogengine.resources;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.scs.p140ai.sdkcommon.image.ImageConst;
import com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J\u0015\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J)\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0015\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010\u0019J\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0%2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0002J%\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00122\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010%H\u0002¢\u0006\u0002\u0010(R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderAssets;", "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ImageConst.ImageUpscaleConst.KEY_ENGINE_TYPE, "Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;)V", SearchConstants.TargetContents.TAG, "", "mAssetManager", "Landroid/content/res/AssetManager;", "mRootDir", "Ljava/io/File;", "mCommon", "Lcom/samsung/android/sdk/pen/recogengine/resources/SpenResourceProviderCommon;", "mHWRDBFileNames", "", "[Ljava/lang/String;", "initialize", "", "setRootDirectory", "rootDir", "getSupportedLanguages", "()[Ljava/lang/String;", "isSupportedLanguage", "", "language", "getResourceData", "", "(Lcom/samsung/android/sdk/pen/recogengine/resources/interfaces/SpenResourceProviderInterface$EngineType;Ljava/lang/String;)[[B", "getDefaultLocale", "getMD5String", "close", "getHWRDBfilenames", "getAssetsNameList", "", "getAssetsDataBuffer", "nameList", "(Ljava/util/List;)[[B", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenResourceProviderAssets implements SpenResourceProviderInterface {

    @NotNull
    private final String TAG;

    @Nullable
    private AssetManager mAssetManager;

    @Nullable
    private SpenResourceProviderCommon mCommon;

    @Nullable
    private String[] mHWRDBFileNames;

    @Nullable
    private File mRootDir;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpenResourceProviderInterface.EngineType.values().length];
            try {
                iArr[SpenResourceProviderInterface.EngineType.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpenResourceProviderInterface.EngineType.MATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpenResourceProviderInterface.EngineType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SpenResourceProviderAssets(@Nullable Context context) {
        this.TAG = "SpenResourceProviderAssets";
        this.mRootDir = new File(SpenResourceProviderCommon.HWRDB_TEXT_DEFAULT_ROOT_DIR);
        initialize(context, SpenResourceProviderInterface.EngineType.TEXT);
    }

    private final byte[][] getAssetsDataBuffer(List<String> nameList) throws Throwable {
        InputStream inputStream;
        InputStream inputStreamOpen;
        List<String> list = nameList;
        if (list == null || list.isEmpty()) {
            Log.e(this.TAG, "getAssetsDataBuffer : fileNameList is wrong!");
            return new byte[0][];
        }
        int size = nameList.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            try {
                AssetManager assetManager = this.mAssetManager;
                if (assetManager != null) {
                    File file = this.mRootDir;
                    Intrinsics.checkNotNull(file);
                    inputStreamOpen = assetManager.open(file.getName() + "/" + ((Object) nameList.get(i)));
                } else {
                    inputStreamOpen = null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
            try {
                SpenResourceProviderCommon spenResourceProviderCommon = this.mCommon;
                bArr[i] = spenResourceProviderCommon != null ? spenResourceProviderCommon.getResourceBuffer(inputStreamOpen) : null;
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (IOException e) {
                        Log.e(this.TAG, "getAssetsDataBuffer : cannot open asset file : " + e.getMessage());
                        e.printStackTrace();
                        bArr[i] = null;
                    }
                }
            } catch (Throwable th2) {
                inputStream = inputStreamOpen;
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        }
        return bArr;
    }

    private final List<String> getAssetsNameList(SpenResourceProviderInterface.EngineType engineType, String language) {
        ArrayList arrayList = new ArrayList();
        int i = engineType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[engineType.ordinal()];
        if (i == 1) {
            arrayList.add(SpenResourceProviderCommon.HWRDB_DOCUMENT_MAIN_DBNAME);
            arrayList.add(SpenResourceProviderCommon.HWRDB_DOCUMENT_LS_DBNAME);
            return arrayList;
        }
        if (i == 2) {
            arrayList.add(SpenResourceProviderCommon.HWRDB_MATH_DBNAME);
            return arrayList;
        }
        if (i != 3) {
            Log.e(this.TAG, "getAssetsNameList : not supported engine type , engineType = " + engineType);
            return arrayList;
        }
        SpenResourceProviderCommon spenResourceProviderCommon = this.mCommon;
        if (spenResourceProviderCommon != null) {
            String defaultLocale = spenResourceProviderCommon.getDefaultLocale(language, this.mHWRDBFileNames);
            arrayList.add("hwr_" + defaultLocale + ".dat");
            String secondaryLanguage = spenResourceProviderCommon.getSecondaryLanguage(defaultLocale, this.mHWRDBFileNames);
            if (secondaryLanguage.length() > 1) {
                arrayList.add("hwr_" + secondaryLanguage + ".dat");
            }
        }
        return arrayList;
    }

    private final String[] getHWRDBfilenames() {
        Log.d(this.TAG, "getHWRDBfilenames : start");
        AssetManager assetManager = this.mAssetManager;
        if (assetManager == null) {
            Log.e(this.TAG, "getHWRDBfilenames : asset manager is null!");
            return null;
        }
        try {
            File file = this.mRootDir;
            if (file != null) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String[] list = name.length() > 0 ? assetManager.list(file.getName()) : assetManager.list(SpenResourceProviderCommon.HWRDB_TEXT_DEFAULT_ROOT_DIR);
                if (list != null) {
                    return list;
                }
            }
            return assetManager.list(SpenResourceProviderCommon.HWRDB_TEXT_DEFAULT_ROOT_DIR);
        } catch (IOException e) {
            Log.e(this.TAG, "getHWRDBfilenames : cannot get files from assets : " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private final void initialize(Context context, SpenResourceProviderInterface.EngineType engineType) {
        Log.d(this.TAG, "initialize : engineType = " + engineType);
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.mAssetManager = applicationContext != null ? applicationContext.getAssets() : null;
        this.mCommon = new SpenResourceProviderCommon();
        int i = WhenMappings.$EnumSwitchMapping$0[engineType.ordinal()];
        if (i == 1) {
            setRootDirectory(SpenResourceProviderCommon.HWRDB_DOCUMENT_DEFAULT_ROOT_DIR);
        } else if (i != 2) {
            setRootDirectory(SpenResourceProviderCommon.HWRDB_TEXT_DEFAULT_ROOT_DIR);
        } else {
            setRootDirectory(SpenResourceProviderCommon.HWRDB_MATH_DEFAULT_ROOT_DIR);
        }
        this.mHWRDBFileNames = getHWRDBfilenames();
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    public void close() {
        Log.d(this.TAG, "close : start");
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    @Nullable
    public String getDefaultLocale(@Nullable String language) {
        AbstractC2322a.m1609C("getDefaultLocale : language = ", language, this.TAG);
        String[] strArr = this.mHWRDBFileNames;
        if (strArr == null || strArr.length == 0) {
            Log.e(this.TAG, "getSupportedLanguages : mHWRDBFileNames is null or zero length!");
            return "";
        }
        SpenResourceProviderCommon spenResourceProviderCommon = this.mCommon;
        if (spenResourceProviderCommon != null) {
            return spenResourceProviderCommon.getDefaultLocale(language, strArr);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    @Nullable
    public String getMD5String(@Nullable String language) {
        return "";
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    @Nullable
    public byte[][] getResourceData(@NotNull SpenResourceProviderInterface.EngineType engineType, @Nullable String language) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        Log.d(this.TAG, "getResourceData : engineType = " + engineType.name() + ", language = " + language);
        if (this.mAssetManager != null) {
            return getAssetsDataBuffer(getAssetsNameList(engineType, language));
        }
        Log.e(this.TAG, "getResourceData : asset manager is null!");
        return null;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    @Nullable
    public String[] getSupportedLanguages() {
        Log.d(this.TAG, "getSupportedLanguages : start");
        String[] strArr = this.mHWRDBFileNames;
        if (strArr == null || strArr.length == 0) {
            Log.e(this.TAG, "getSupportedLanguages : mHWRDBFileNames is null or zero length!");
            return new String[0];
        }
        SpenResourceProviderCommon spenResourceProviderCommon = this.mCommon;
        if (spenResourceProviderCommon != null) {
            return spenResourceProviderCommon.getSupportedLanguages(strArr);
        }
        return null;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    public boolean isSupportedLanguage(@Nullable String language) {
        AbstractC2322a.m1609C("isSupportedLanguage : language = ", language, this.TAG);
        String[] strArr = this.mHWRDBFileNames;
        if (strArr == null || strArr.length == 0) {
            Log.e(this.TAG, "getSupportedLanguages : mHWRDBFileNames is null or zero length!");
            return false;
        }
        SpenResourceProviderCommon spenResourceProviderCommon = this.mCommon;
        if (spenResourceProviderCommon != null) {
            return spenResourceProviderCommon.isSupportedLanguage(language, strArr);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.recogengine.resources.interfaces.SpenResourceProviderInterface
    public void setRootDirectory(@Nullable String rootDir) {
        this.mRootDir = new File(rootDir);
        AbstractC2322a.m1609C("setRootDirectory : root dir = ", rootDir, this.TAG);
    }

    public SpenResourceProviderAssets(@Nullable Context context, @NotNull SpenResourceProviderInterface.EngineType engineType) {
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        this.TAG = "SpenResourceProviderAssets";
        this.mRootDir = new File(SpenResourceProviderCommon.HWRDB_TEXT_DEFAULT_ROOT_DIR);
        initialize(context, engineType);
    }
}
