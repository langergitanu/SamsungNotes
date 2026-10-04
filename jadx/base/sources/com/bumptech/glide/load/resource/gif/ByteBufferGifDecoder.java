package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.AbstractC0622a;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class GifDecoderFactory {
        public GifDecoder build(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @VisibleForTesting
    public static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool = Util.createQueue(0);

        public synchronized GifHeaderParser obtain(ByteBuffer byteBuffer) {
            GifHeaderParser gifHeaderParserPoll;
            try {
                gifHeaderParserPoll = this.pool.poll();
                if (gifHeaderParserPoll == null) {
                    gifHeaderParserPoll = new GifHeaderParser();
                }
            } catch (Throwable th) {
                throw th;
            }
            return gifHeaderParserPoll.setData(byteBuffer);
        }

        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.get(context).getRegistry().getImageHeaderParsers(), Glide.get(context).getBitmapPool(), Glide.get(context).getArrayPool());
    }

    private static int getSampleSize(GifHeader gifHeader, int i, int i2) {
        int iMin = Math.min(gifHeader.getHeight() / i2, gifHeader.getWidth() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable(TAG, 2) && iMax > 1) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(iMax, i, "Downsampling GIF, sampleSize: ", ", target dimens: [", "x");
            sbM1173s.append(i2);
            sbM1173s.append("], actual dimens: [");
            sbM1173s.append(gifHeader.getWidth());
            sbM1173s.append("x");
            sbM1173s.append(gifHeader.getHeight());
            sbM1173s.append("]");
            Log.v(TAG, sbM1173s.toString());
        }
        return iMax;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) {
        GifHeaderParser gifHeaderParserObtain = this.parserPool.obtain(byteBuffer);
        try {
            return decode(byteBuffer, i, i2, gifHeaderParserObtain, options);
        } finally {
            this.parserPool.release(gifHeaderParserObtain);
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @VisibleForTesting
    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }

    @Nullable
    private GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, GifHeaderParser gifHeaderParser, Options options) {
        StringBuilder sb;
        Bitmap.Config config;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader header = gifHeaderParser.parseHeader();
            if (header.getNumFrames() > 0 && header.getStatus() == 0) {
                if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                GifDecoder gifDecoderBuild = this.gifDecoderFactory.build(this.provider, header, byteBuffer, getSampleSize(header, i, i2));
                gifDecoderBuild.setDefaultBitmapConfig(config);
                gifDecoderBuild.advance();
                Bitmap nextFrame = gifDecoderBuild.getNextFrame();
                if (nextFrame == null) {
                    if (Log.isLoggable(TAG, 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.context, gifDecoderBuild, UnitTransformation.get(), i, i2, nextFrame));
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
                }
                return gifDrawableResource;
            }
            if (!Log.isLoggable(TAG, 2)) {
                return null;
            }
            sb = new StringBuilder("Decoded GIF from stream in ");
            sb.append(LogTime.getElapsedMillis(logTime));
            Log.v(TAG, sb.toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded GIF from stream in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }
}
