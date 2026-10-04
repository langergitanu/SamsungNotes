package com.samsung.android.sdk.scs.p142ai.visual.c2pa;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\bu\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bw¨\u0006x"}, m13886d2 = {"Lcom/samsung/android/sdk/scs/ai/visual/c2pa/Exif;", "", "str", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "EXIF_APERTURE_VALUE", "EXIF_BRIGHTNESS_VALUE", "EXIF_CFAPATTERN", "EXIF_COLORSPACE", "EXIF_COMPRESSED_BITS_PER_PIXEL", "EXIF_CONTRAST", "EXIF_CUSTOM_RENDERED", "EXIF_DATE_TIME_DIGITIZED", "EXIF_DATE_TIME_ORIGINAL", "EXIF_DEVICE_SETTING_DESCRIPTION", "EXIF_DIGITAL_ZOOM_RATIO", "EXIF_EXIF_VERSION", "EXIF_EXPOSURE_BIAS_VALUE", "EXIF_EXPOSURE_INDEX", "EXIF_EXPOSURE_MODE", "EXIF_EXPOSURE_PROGRAM", "EXIF_EXPOSURE_TIME", "EXIF_FILE_SOURCE", "EXIF_FLASH", "EXIF_FLASH_ENERGY", "EXIF_FLASHPIX_VERSION", "EXIF_FNUMBER", "EXIF_FOCAL_LENGTH", "EXIF_FOCAL_LENGTH_IN_35MM_FILM", "EXIF_FOCAL_PLANE_RESOLUTION_UNIT", "EXIF_FOCAL_PLANE_X_RESOLUTION", "EXIF_FOCAL_PLANE_Y_RESOLUTION", "EXIF_GAIN_CONTROL", "EXIF_IMAGE_UNIQUE_ID", "EXIF_ISO_SPEED_RATINGS", "EXIF_LIGHT_SOURCE", "EXIF_MAX_APERTURE_VALUE", "EXIF_METERING_MODE", "EXIF_OECF", "EXIF_PIXEL_X_DIMENSION", "EXIF_PIXEL_Y_DIMENSION", "EXIF_RELATED_SOUND_FILE", "EXIF_SATURATION", "EXIF_SCENE_CAPTURE_TYPE", "EXIF_SCENE_TYPE", "EXIF_SENSING_METHOD", "EXIF_SHARPNESS", "EXIF_SHUTTER_SPEED_VALUE", "EXIF_SPATIAL_FREQUENCY_RESPONSE", "EXIF_SPECTRAL_SENSITIVITY", "EXIF_SUBJECT_AREA", "EXIF_SUBJECT_DISTANCE", "EXIF_SUBJECT_DISTANCE_RANGE", "EXIF_SUBJECT_LOCATION", "EXIF_WHITE_BALANCE", "EXIF_GPS_ALTITUDE", "EXIF_GPS_ALTITUDE_REF", "EXIF_GPS_DEST_BEARING", "EXIF_GPS_DEST_BEARING_REF", "EXIF_GPS_DEST_DISTANCE", "EXIF_GPS_DEST_DISTANCE_REF", "EXIF_GPS_DEST_LATITUDE", "EXIF_GPS_DEST_LONGITUDE", "EXIF_GPS_DIFFERENTIAL", "EXIF_GPS_DOP", "EXIF_GPS_HPOSITIONING_ERROR", "EXIF_GPS_IMG_DIRECTION", "EXIF_GPS_IMG_DIRECTION_REF", "EXIF_GPS_LATITUDE", "EXIF_GPS_LONGITUDE", "EXIF_GPS_MAP_DATUM", "EXIF_GPS_MEASURE_MODE", "EXIF_GPS_PROCESSING_METHOD", "EXIF_GPS_SATELLITES", "EXIF_GPS_SPEED", "EXIF_GPS_SPEED_REF", "EXIF_GPS_STATUS", "EXIF_GPS_TIMESTAMP", "EXIF_GPS_TRACK", "EXIF_GPS_TRACK_REF", "EXIF_GPS_VERSION_ID", "EXIFEX_BODY_SERIAL_NUMBER", "EXIFEX_GAMMA", "EXIFEX_INTEROPERABILITY_INDEX", "EXIFEX_ISO_SPEED", "EXIFEX_ISO_SPEED_LATITUDEYYY", "EXIFEX_ISO_SPEED_LATITUDEZZZ", "EXIFEX_LENS_MAKE", "EXIFEX_LENS_MODEL", "EXIFEX_LENS_SERIAL_NUMBER", "EXIFEX_LENS_SPECIFICATION", "EXIFEX_PHOTOGRAPHIC_SENSITIVITY", "EXIFEX_RECOMMENDED_EXPOSURE_INDEX", "EXIFEX_SENSITIVITY_TYPE", "EXIFEX_STANDARD_OUTPUT_SENSITIVITY", "TIFF_BITS_PER_SAMPLE", "TIFF_COMPRESSION", "TIFF_DATE_TIME", "TIFF_IMAGE_LENGTH", "TIFF_IMAGE_WIDTH", "TIFF_MAKE", "TIFF_MODEL", "TIFF_ORIENTATION", "TIFF_PHOTOMETRIC_INTERPRETATION", "TIFF_PLANAR_CONFIGURATION", "TIFF_PRIMARY_CHROMATICITIES", "TIFF_REFERENCE_BLACK_WHITE", "TIFF_RESOLUTION_UNIT", "TIFF_SAMPLES_PER_PIXEL", "TIFF_SOFTWARE", "TIFF_TRANSFER_FUNCTION", "TIFF_WHITE_POINT", "TIFF_X_RESOLUTION", "TIFF_Y_RESOLUTION", "TIFF_YCBCR_COEFFICIENTS", "TIFF_YCBCR_POSITIONING", "TIFF_YCBCR_SUBSAMPLING", "scs-ai-4.0.55_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class Exif {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Exif[] $VALUES;

    @NotNull
    private final String str;
    public static final Exif EXIF_APERTURE_VALUE = new Exif("EXIF_APERTURE_VALUE", 0, "exif:ApertureValue");
    public static final Exif EXIF_BRIGHTNESS_VALUE = new Exif("EXIF_BRIGHTNESS_VALUE", 1, "exif:BrightnessValue");
    public static final Exif EXIF_CFAPATTERN = new Exif("EXIF_CFAPATTERN", 2, "exif:CFAPattern");
    public static final Exif EXIF_COLORSPACE = new Exif("EXIF_COLORSPACE", 3, "exif:ColorSpace");
    public static final Exif EXIF_COMPRESSED_BITS_PER_PIXEL = new Exif("EXIF_COMPRESSED_BITS_PER_PIXEL", 4, "exif:CompressedBitsPerPixel");
    public static final Exif EXIF_CONTRAST = new Exif("EXIF_CONTRAST", 5, "exif:Contrast");
    public static final Exif EXIF_CUSTOM_RENDERED = new Exif("EXIF_CUSTOM_RENDERED", 6, "exif:CustomRendered");
    public static final Exif EXIF_DATE_TIME_DIGITIZED = new Exif("EXIF_DATE_TIME_DIGITIZED", 7, "exif:DateTimeDigitized");
    public static final Exif EXIF_DATE_TIME_ORIGINAL = new Exif("EXIF_DATE_TIME_ORIGINAL", 8, "exif:DateTimeOriginal");
    public static final Exif EXIF_DEVICE_SETTING_DESCRIPTION = new Exif("EXIF_DEVICE_SETTING_DESCRIPTION", 9, "exif:DeviceSettingDescription");
    public static final Exif EXIF_DIGITAL_ZOOM_RATIO = new Exif("EXIF_DIGITAL_ZOOM_RATIO", 10, "exif:DigitalZoomRatio");
    public static final Exif EXIF_EXIF_VERSION = new Exif("EXIF_EXIF_VERSION", 11, "exif:ExifVersion");
    public static final Exif EXIF_EXPOSURE_BIAS_VALUE = new Exif("EXIF_EXPOSURE_BIAS_VALUE", 12, "exif:ExposureBiasValue");
    public static final Exif EXIF_EXPOSURE_INDEX = new Exif("EXIF_EXPOSURE_INDEX", 13, "exif:ExposureIndex");
    public static final Exif EXIF_EXPOSURE_MODE = new Exif("EXIF_EXPOSURE_MODE", 14, "exif:ExposureMode");
    public static final Exif EXIF_EXPOSURE_PROGRAM = new Exif("EXIF_EXPOSURE_PROGRAM", 15, "exif:ExposureProgram");
    public static final Exif EXIF_EXPOSURE_TIME = new Exif("EXIF_EXPOSURE_TIME", 16, "exif:ExposureTime");
    public static final Exif EXIF_FILE_SOURCE = new Exif("EXIF_FILE_SOURCE", 17, "exif:FileSource");
    public static final Exif EXIF_FLASH = new Exif("EXIF_FLASH", 18, "exif:Flash");
    public static final Exif EXIF_FLASH_ENERGY = new Exif("EXIF_FLASH_ENERGY", 19, "exif:FlashEnergy");
    public static final Exif EXIF_FLASHPIX_VERSION = new Exif("EXIF_FLASHPIX_VERSION", 20, "exif:FlashpixVersion");
    public static final Exif EXIF_FNUMBER = new Exif("EXIF_FNUMBER", 21, "exif:FNumber");
    public static final Exif EXIF_FOCAL_LENGTH = new Exif("EXIF_FOCAL_LENGTH", 22, "exif:FocalLength");
    public static final Exif EXIF_FOCAL_LENGTH_IN_35MM_FILM = new Exif("EXIF_FOCAL_LENGTH_IN_35MM_FILM", 23, "exif:FocalLengthIn35mmFilm");
    public static final Exif EXIF_FOCAL_PLANE_RESOLUTION_UNIT = new Exif("EXIF_FOCAL_PLANE_RESOLUTION_UNIT", 24, "exif:FocalPlaneResolutionUnit");
    public static final Exif EXIF_FOCAL_PLANE_X_RESOLUTION = new Exif("EXIF_FOCAL_PLANE_X_RESOLUTION", 25, "exif:FocalPlaneXResolution");
    public static final Exif EXIF_FOCAL_PLANE_Y_RESOLUTION = new Exif("EXIF_FOCAL_PLANE_Y_RESOLUTION", 26, "exif:FocalPlaneYResolution");
    public static final Exif EXIF_GAIN_CONTROL = new Exif("EXIF_GAIN_CONTROL", 27, "exif:GainControl");
    public static final Exif EXIF_IMAGE_UNIQUE_ID = new Exif("EXIF_IMAGE_UNIQUE_ID", 28, "exif:ImageUniqueID");
    public static final Exif EXIF_ISO_SPEED_RATINGS = new Exif("EXIF_ISO_SPEED_RATINGS", 29, "exif:ISOSpeedRatings");
    public static final Exif EXIF_LIGHT_SOURCE = new Exif("EXIF_LIGHT_SOURCE", 30, "exif:LightSource");
    public static final Exif EXIF_MAX_APERTURE_VALUE = new Exif("EXIF_MAX_APERTURE_VALUE", 31, "exif:MaxApertureValue");
    public static final Exif EXIF_METERING_MODE = new Exif("EXIF_METERING_MODE", 32, "exif:MeteringMode");
    public static final Exif EXIF_OECF = new Exif("EXIF_OECF", 33, "exif:OECF");
    public static final Exif EXIF_PIXEL_X_DIMENSION = new Exif("EXIF_PIXEL_X_DIMENSION", 34, "exif:PixelXDimension");
    public static final Exif EXIF_PIXEL_Y_DIMENSION = new Exif("EXIF_PIXEL_Y_DIMENSION", 35, "exif:PixelYDimension");
    public static final Exif EXIF_RELATED_SOUND_FILE = new Exif("EXIF_RELATED_SOUND_FILE", 36, "exif:RelatedSoundFile");
    public static final Exif EXIF_SATURATION = new Exif("EXIF_SATURATION", 37, "exif:Saturation");
    public static final Exif EXIF_SCENE_CAPTURE_TYPE = new Exif("EXIF_SCENE_CAPTURE_TYPE", 38, "exif:SceneCaptureType");
    public static final Exif EXIF_SCENE_TYPE = new Exif("EXIF_SCENE_TYPE", 39, "exif:SceneType");
    public static final Exif EXIF_SENSING_METHOD = new Exif("EXIF_SENSING_METHOD", 40, "exif:SensingMethod");
    public static final Exif EXIF_SHARPNESS = new Exif("EXIF_SHARPNESS", 41, "exif:Sharpness");
    public static final Exif EXIF_SHUTTER_SPEED_VALUE = new Exif("EXIF_SHUTTER_SPEED_VALUE", 42, "exif:ShutterSpeedValue");
    public static final Exif EXIF_SPATIAL_FREQUENCY_RESPONSE = new Exif("EXIF_SPATIAL_FREQUENCY_RESPONSE", 43, "exif:SpatialFrequencyResponse");
    public static final Exif EXIF_SPECTRAL_SENSITIVITY = new Exif("EXIF_SPECTRAL_SENSITIVITY", 44, "exif:SpectralSensitivity");
    public static final Exif EXIF_SUBJECT_AREA = new Exif("EXIF_SUBJECT_AREA", 45, "exif:SubjectArea");
    public static final Exif EXIF_SUBJECT_DISTANCE = new Exif("EXIF_SUBJECT_DISTANCE", 46, "exif:SubjectDistance");
    public static final Exif EXIF_SUBJECT_DISTANCE_RANGE = new Exif("EXIF_SUBJECT_DISTANCE_RANGE", 47, "exif:SubjectDistanceRange");
    public static final Exif EXIF_SUBJECT_LOCATION = new Exif("EXIF_SUBJECT_LOCATION", 48, "exif:SubjectLocation");
    public static final Exif EXIF_WHITE_BALANCE = new Exif("EXIF_WHITE_BALANCE", 49, "exif:WhiteBalance");
    public static final Exif EXIF_GPS_ALTITUDE = new Exif("EXIF_GPS_ALTITUDE", 50, "exif:GPSAltitude");
    public static final Exif EXIF_GPS_ALTITUDE_REF = new Exif("EXIF_GPS_ALTITUDE_REF", 51, "exif:GPSAltitudeRef");
    public static final Exif EXIF_GPS_DEST_BEARING = new Exif("EXIF_GPS_DEST_BEARING", 52, "exif:GPSDestBearing");
    public static final Exif EXIF_GPS_DEST_BEARING_REF = new Exif("EXIF_GPS_DEST_BEARING_REF", 53, "exif:GPSDestBearingRef");
    public static final Exif EXIF_GPS_DEST_DISTANCE = new Exif("EXIF_GPS_DEST_DISTANCE", 54, "exif:GPSDestDistance");
    public static final Exif EXIF_GPS_DEST_DISTANCE_REF = new Exif("EXIF_GPS_DEST_DISTANCE_REF", 55, "exif:GPSDestDistanceRef");
    public static final Exif EXIF_GPS_DEST_LATITUDE = new Exif("EXIF_GPS_DEST_LATITUDE", 56, "exif:GPSDestLatitude");
    public static final Exif EXIF_GPS_DEST_LONGITUDE = new Exif("EXIF_GPS_DEST_LONGITUDE", 57, "exif:GPSDestLongitude");
    public static final Exif EXIF_GPS_DIFFERENTIAL = new Exif("EXIF_GPS_DIFFERENTIAL", 58, "exif:GPSDifferential");
    public static final Exif EXIF_GPS_DOP = new Exif("EXIF_GPS_DOP", 59, "exif:GPSDOP");
    public static final Exif EXIF_GPS_HPOSITIONING_ERROR = new Exif("EXIF_GPS_HPOSITIONING_ERROR", 60, "exif:GPSHPositioningError");
    public static final Exif EXIF_GPS_IMG_DIRECTION = new Exif("EXIF_GPS_IMG_DIRECTION", 61, "exif:GPSImgDirection");
    public static final Exif EXIF_GPS_IMG_DIRECTION_REF = new Exif("EXIF_GPS_IMG_DIRECTION_REF", 62, "exif:GPSImgDirectionRef");
    public static final Exif EXIF_GPS_LATITUDE = new Exif("EXIF_GPS_LATITUDE", 63, "exif:GPSLatitude");
    public static final Exif EXIF_GPS_LONGITUDE = new Exif("EXIF_GPS_LONGITUDE", 64, "exif:GPSLongitude");
    public static final Exif EXIF_GPS_MAP_DATUM = new Exif("EXIF_GPS_MAP_DATUM", 65, "exif:GPSMapDatum");
    public static final Exif EXIF_GPS_MEASURE_MODE = new Exif("EXIF_GPS_MEASURE_MODE", 66, "exif:GPSMeasureMode");
    public static final Exif EXIF_GPS_PROCESSING_METHOD = new Exif("EXIF_GPS_PROCESSING_METHOD", 67, "exif:GPSProcessingMethod");
    public static final Exif EXIF_GPS_SATELLITES = new Exif("EXIF_GPS_SATELLITES", 68, "exif:GPSSatellites");
    public static final Exif EXIF_GPS_SPEED = new Exif("EXIF_GPS_SPEED", 69, "exif:GPSSpeed");
    public static final Exif EXIF_GPS_SPEED_REF = new Exif("EXIF_GPS_SPEED_REF", 70, "exif:GPSSpeedRef");
    public static final Exif EXIF_GPS_STATUS = new Exif("EXIF_GPS_STATUS", 71, "exif:GPSStatus");
    public static final Exif EXIF_GPS_TIMESTAMP = new Exif("EXIF_GPS_TIMESTAMP", 72, "exif:GPSTimeStamp");
    public static final Exif EXIF_GPS_TRACK = new Exif("EXIF_GPS_TRACK", 73, "exif:GPSTrack");
    public static final Exif EXIF_GPS_TRACK_REF = new Exif("EXIF_GPS_TRACK_REF", 74, "exif:GPSTrackRef");
    public static final Exif EXIF_GPS_VERSION_ID = new Exif("EXIF_GPS_VERSION_ID", 75, "exif:GPSVersionID");
    public static final Exif EXIFEX_BODY_SERIAL_NUMBER = new Exif("EXIFEX_BODY_SERIAL_NUMBER", 76, "exifEX:BodySerialNumber");
    public static final Exif EXIFEX_GAMMA = new Exif("EXIFEX_GAMMA", 77, "exifEX:Gamma");
    public static final Exif EXIFEX_INTEROPERABILITY_INDEX = new Exif("EXIFEX_INTEROPERABILITY_INDEX", 78, "exifEX:InteroperabilityIndex");
    public static final Exif EXIFEX_ISO_SPEED = new Exif("EXIFEX_ISO_SPEED", 79, "exifEX:ISOSpeed");
    public static final Exif EXIFEX_ISO_SPEED_LATITUDEYYY = new Exif("EXIFEX_ISO_SPEED_LATITUDEYYY", 80, "exifEX:ISOSpeedLatitudeyyy");
    public static final Exif EXIFEX_ISO_SPEED_LATITUDEZZZ = new Exif("EXIFEX_ISO_SPEED_LATITUDEZZZ", 81, "exifEX:ISOSpeedLatitudezzz");
    public static final Exif EXIFEX_LENS_MAKE = new Exif("EXIFEX_LENS_MAKE", 82, "exifEX:LensMake");
    public static final Exif EXIFEX_LENS_MODEL = new Exif("EXIFEX_LENS_MODEL", 83, "exifEX:LensModel");
    public static final Exif EXIFEX_LENS_SERIAL_NUMBER = new Exif("EXIFEX_LENS_SERIAL_NUMBER", 84, "exifEX:LensSerialNumber");
    public static final Exif EXIFEX_LENS_SPECIFICATION = new Exif("EXIFEX_LENS_SPECIFICATION", 85, "exifEX:LensSpecification");
    public static final Exif EXIFEX_PHOTOGRAPHIC_SENSITIVITY = new Exif("EXIFEX_PHOTOGRAPHIC_SENSITIVITY", 86, "exifEX:PhotographicSensitivity");
    public static final Exif EXIFEX_RECOMMENDED_EXPOSURE_INDEX = new Exif("EXIFEX_RECOMMENDED_EXPOSURE_INDEX", 87, "exifEX:RecommendedExposureIndex");
    public static final Exif EXIFEX_SENSITIVITY_TYPE = new Exif("EXIFEX_SENSITIVITY_TYPE", 88, "exifEX:SensitivityType");
    public static final Exif EXIFEX_STANDARD_OUTPUT_SENSITIVITY = new Exif("EXIFEX_STANDARD_OUTPUT_SENSITIVITY", 89, "exifEX:StandardOutput-Sensitivity");
    public static final Exif TIFF_BITS_PER_SAMPLE = new Exif("TIFF_BITS_PER_SAMPLE", 90, "tiff:BitsPerSample");
    public static final Exif TIFF_COMPRESSION = new Exif("TIFF_COMPRESSION", 91, "tiff:Compression");
    public static final Exif TIFF_DATE_TIME = new Exif("TIFF_DATE_TIME", 92, "tiff:DateTime");
    public static final Exif TIFF_IMAGE_LENGTH = new Exif("TIFF_IMAGE_LENGTH", 93, "tiff:ImageLength");
    public static final Exif TIFF_IMAGE_WIDTH = new Exif("TIFF_IMAGE_WIDTH", 94, "tiff:ImageWidth");
    public static final Exif TIFF_MAKE = new Exif("TIFF_MAKE", 95, "tiff:Make");
    public static final Exif TIFF_MODEL = new Exif("TIFF_MODEL", 96, "tiff:Model");
    public static final Exif TIFF_ORIENTATION = new Exif("TIFF_ORIENTATION", 97, "tiff:Orientation");
    public static final Exif TIFF_PHOTOMETRIC_INTERPRETATION = new Exif("TIFF_PHOTOMETRIC_INTERPRETATION", 98, "tiff:PhotometricInterpretation");
    public static final Exif TIFF_PLANAR_CONFIGURATION = new Exif("TIFF_PLANAR_CONFIGURATION", 99, "tiff:PlanarConfiguration");
    public static final Exif TIFF_PRIMARY_CHROMATICITIES = new Exif("TIFF_PRIMARY_CHROMATICITIES", 100, "tiff:PrimaryChromaticities");
    public static final Exif TIFF_REFERENCE_BLACK_WHITE = new Exif("TIFF_REFERENCE_BLACK_WHITE", 101, "tiff:ReferenceBlackWhite");
    public static final Exif TIFF_RESOLUTION_UNIT = new Exif("TIFF_RESOLUTION_UNIT", 102, "tiff:ResolutionUnit");
    public static final Exif TIFF_SAMPLES_PER_PIXEL = new Exif("TIFF_SAMPLES_PER_PIXEL", 103, "tiff:SamplesPerPixel");
    public static final Exif TIFF_SOFTWARE = new Exif("TIFF_SOFTWARE", 104, "tiff:Software");
    public static final Exif TIFF_TRANSFER_FUNCTION = new Exif("TIFF_TRANSFER_FUNCTION", 105, "tiff:TransferFunction");
    public static final Exif TIFF_WHITE_POINT = new Exif("TIFF_WHITE_POINT", 106, "tiff:WhitePoint");
    public static final Exif TIFF_X_RESOLUTION = new Exif("TIFF_X_RESOLUTION", 107, "tiff:XResolution");
    public static final Exif TIFF_Y_RESOLUTION = new Exif("TIFF_Y_RESOLUTION", 108, "tiff:YResolution");
    public static final Exif TIFF_YCBCR_COEFFICIENTS = new Exif("TIFF_YCBCR_COEFFICIENTS", 109, "tiff:YCbCrCoefficients");
    public static final Exif TIFF_YCBCR_POSITIONING = new Exif("TIFF_YCBCR_POSITIONING", 110, "tiff:YCbCrPositioning");
    public static final Exif TIFF_YCBCR_SUBSAMPLING = new Exif("TIFF_YCBCR_SUBSAMPLING", 111, "tiff:YCbCrSubSampling");

    private static final /* synthetic */ Exif[] $values() {
        return new Exif[]{EXIF_APERTURE_VALUE, EXIF_BRIGHTNESS_VALUE, EXIF_CFAPATTERN, EXIF_COLORSPACE, EXIF_COMPRESSED_BITS_PER_PIXEL, EXIF_CONTRAST, EXIF_CUSTOM_RENDERED, EXIF_DATE_TIME_DIGITIZED, EXIF_DATE_TIME_ORIGINAL, EXIF_DEVICE_SETTING_DESCRIPTION, EXIF_DIGITAL_ZOOM_RATIO, EXIF_EXIF_VERSION, EXIF_EXPOSURE_BIAS_VALUE, EXIF_EXPOSURE_INDEX, EXIF_EXPOSURE_MODE, EXIF_EXPOSURE_PROGRAM, EXIF_EXPOSURE_TIME, EXIF_FILE_SOURCE, EXIF_FLASH, EXIF_FLASH_ENERGY, EXIF_FLASHPIX_VERSION, EXIF_FNUMBER, EXIF_FOCAL_LENGTH, EXIF_FOCAL_LENGTH_IN_35MM_FILM, EXIF_FOCAL_PLANE_RESOLUTION_UNIT, EXIF_FOCAL_PLANE_X_RESOLUTION, EXIF_FOCAL_PLANE_Y_RESOLUTION, EXIF_GAIN_CONTROL, EXIF_IMAGE_UNIQUE_ID, EXIF_ISO_SPEED_RATINGS, EXIF_LIGHT_SOURCE, EXIF_MAX_APERTURE_VALUE, EXIF_METERING_MODE, EXIF_OECF, EXIF_PIXEL_X_DIMENSION, EXIF_PIXEL_Y_DIMENSION, EXIF_RELATED_SOUND_FILE, EXIF_SATURATION, EXIF_SCENE_CAPTURE_TYPE, EXIF_SCENE_TYPE, EXIF_SENSING_METHOD, EXIF_SHARPNESS, EXIF_SHUTTER_SPEED_VALUE, EXIF_SPATIAL_FREQUENCY_RESPONSE, EXIF_SPECTRAL_SENSITIVITY, EXIF_SUBJECT_AREA, EXIF_SUBJECT_DISTANCE, EXIF_SUBJECT_DISTANCE_RANGE, EXIF_SUBJECT_LOCATION, EXIF_WHITE_BALANCE, EXIF_GPS_ALTITUDE, EXIF_GPS_ALTITUDE_REF, EXIF_GPS_DEST_BEARING, EXIF_GPS_DEST_BEARING_REF, EXIF_GPS_DEST_DISTANCE, EXIF_GPS_DEST_DISTANCE_REF, EXIF_GPS_DEST_LATITUDE, EXIF_GPS_DEST_LONGITUDE, EXIF_GPS_DIFFERENTIAL, EXIF_GPS_DOP, EXIF_GPS_HPOSITIONING_ERROR, EXIF_GPS_IMG_DIRECTION, EXIF_GPS_IMG_DIRECTION_REF, EXIF_GPS_LATITUDE, EXIF_GPS_LONGITUDE, EXIF_GPS_MAP_DATUM, EXIF_GPS_MEASURE_MODE, EXIF_GPS_PROCESSING_METHOD, EXIF_GPS_SATELLITES, EXIF_GPS_SPEED, EXIF_GPS_SPEED_REF, EXIF_GPS_STATUS, EXIF_GPS_TIMESTAMP, EXIF_GPS_TRACK, EXIF_GPS_TRACK_REF, EXIF_GPS_VERSION_ID, EXIFEX_BODY_SERIAL_NUMBER, EXIFEX_GAMMA, EXIFEX_INTEROPERABILITY_INDEX, EXIFEX_ISO_SPEED, EXIFEX_ISO_SPEED_LATITUDEYYY, EXIFEX_ISO_SPEED_LATITUDEZZZ, EXIFEX_LENS_MAKE, EXIFEX_LENS_MODEL, EXIFEX_LENS_SERIAL_NUMBER, EXIFEX_LENS_SPECIFICATION, EXIFEX_PHOTOGRAPHIC_SENSITIVITY, EXIFEX_RECOMMENDED_EXPOSURE_INDEX, EXIFEX_SENSITIVITY_TYPE, EXIFEX_STANDARD_OUTPUT_SENSITIVITY, TIFF_BITS_PER_SAMPLE, TIFF_COMPRESSION, TIFF_DATE_TIME, TIFF_IMAGE_LENGTH, TIFF_IMAGE_WIDTH, TIFF_MAKE, TIFF_MODEL, TIFF_ORIENTATION, TIFF_PHOTOMETRIC_INTERPRETATION, TIFF_PLANAR_CONFIGURATION, TIFF_PRIMARY_CHROMATICITIES, TIFF_REFERENCE_BLACK_WHITE, TIFF_RESOLUTION_UNIT, TIFF_SAMPLES_PER_PIXEL, TIFF_SOFTWARE, TIFF_TRANSFER_FUNCTION, TIFF_WHITE_POINT, TIFF_X_RESOLUTION, TIFF_Y_RESOLUTION, TIFF_YCBCR_COEFFICIENTS, TIFF_YCBCR_POSITIONING, TIFF_YCBCR_SUBSAMPLING};
    }

    static {
        Exif[] exifArr$values = $values();
        $VALUES = exifArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(exifArr$values);
    }

    private Exif(String str, int i, String str2) {
        this.str = str2;
    }

    @NotNull
    public static EnumEntries<Exif> getEntries() {
        return $ENTRIES;
    }

    public static Exif valueOf(String str) {
        return (Exif) Enum.valueOf(Exif.class, str);
    }

    public static Exif[] values() {
        return (Exif[]) $VALUES.clone();
    }

    @NotNull
    public final String getStr() {
        return this.str;
    }
}
