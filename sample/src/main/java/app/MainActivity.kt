package app

import android.annotation.TargetApi
import android.app.Activity
import android.graphics.*
import android.os.Build
import android.os.Bundle
import android.renderscript.RenderScript
import android.widget.ImageView
import io.github.crow_misia.libyuv.*

/**
 * This activity demonstrates how to use JNI to encode and decode ogg/vorbis audio
 */
class MainActivity : Activity() {
    private lateinit var origin: ImageView
    private lateinit var toBitmap: ImageView
    private lateinit var convert: ImageView
    private lateinit var rotate90: ImageView
    private lateinit var mirror: ImageView
    private lateinit var scale: ImageView
    private lateinit var origin2: ImageView
    private lateinit var toBitmap2: ImageView
    private lateinit var convert2: ImageView
    private lateinit var rotate902: ImageView
    private lateinit var mirror2: ImageView
    private lateinit var scale2: ImageView

    private lateinit var rs: RenderScript

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rs = RenderScript.create(this)

        setContentView(R.layout.activity_main)

        origin = findViewById(R.id.origin)
        toBitmap = findViewById(R.id.to_bitmap)
        convert = findViewById(R.id.convert)
        rotate90 = findViewById(R.id.rotate90)
        mirror = findViewById(R.id.mirror)
        origin2 = findViewById(R.id.origin_2)
        toBitmap2 = findViewById(R.id.to_bitmap_2)
        convert2 = findViewById(R.id.convert_2)
        rotate902 = findViewById(R.id.rotate90_2)
        mirror2 = findViewById(R.id.mirror_2)
        scale = findViewById(R.id.scale)
        scale2 = findViewById(R.id.scale_2)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onResume() {
        super.onResume()

        val bitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888)
        val bitmap2 = Bitmap.createBitmap(1920, 1080, Bitmap.Config.RGB_565)
        val width = bitmap.width
        val height = bitmap.height
        val originalBuffer = AbgrBuffer.allocate(width, height)
        val original2Buffer = Rgb565Buffer.allocate(width, height)
        val i420Buffer = I420Buffer.allocate(width, height)
        val nv21Buffer = Nv21Buffer.allocate(width, height)
        val rotate90Buffer = I420Buffer.allocate(height, width)
        val nv21Rotate90Buffer = Nv21Buffer.allocate(height, width)
        val nv21MirrorBuffer = Nv21Buffer.allocate(height, width)
        val nv21ScaleBuffer = Nv21Buffer.allocate(100, 100)

        // dummy draw
        Canvas(bitmap).also {
            it.drawRect(0f, 0f, 1920f, 1080f, Paint().also { p ->
                p.shader = LinearGradient(0f, 0f, 0f, 1080f, Color.GREEN, Color.YELLOW, Shader.TileMode.CLAMP)
            })
            it.drawRect(50f, 50f, 150f, 150f, Paint().also { p -> p.color = Color.BLACK })
        }
        bitmap.copyPixelsToBuffer(originalBuffer.bufferABGR)
        origin.setImageBitmap(bitmap)
        toBitmap.setImageBitmap(originalBuffer.toBitmap(rs))

        Canvas(bitmap2).also {
            it.drawRect(0f, 0f, 1920f, 1080f, Paint().also { p ->
                p.shader = LinearGradient(0f, 0f, 0f, 1080f, Color.GREEN, Color.YELLOW, Shader.TileMode.CLAMP)
            })
            it.drawRect(50f, 50f, 150f, 150f, Paint().also { p -> p.color = Color.BLACK })
        }
        bitmap2.copyPixelsToBuffer(original2Buffer.bufferRGB565)
        origin2.setImageBitmap(bitmap2)
        toBitmap2.setImageBitmap(original2Buffer.toBitmap(rs))

        originalBuffer.convertTo(nv21Buffer)
        nv21Buffer.rotate(nv21Rotate90Buffer, RotateMode.ROTATE_90)
        nv21Rotate90Buffer.mirrorTo(nv21MirrorBuffer)
        nv21Buffer.scale(nv21ScaleBuffer, FilterMode.BILINEAR)
        convert.setImageBitmap(nv21Buffer.toBitmap(rs))
        rotate90.setImageBitmap(nv21Rotate90Buffer.toBitmap(rs))
        mirror.setImageBitmap(nv21MirrorBuffer.toBitmap(rs))
        scale.setImageBitmap(nv21ScaleBuffer.toBitmap(rs))

        original2Buffer.convertTo(i420Buffer)
        i420Buffer.convertTo(nv21Buffer)
        nv21Buffer.rotate(nv21Rotate90Buffer, RotateMode.ROTATE_90)
        nv21Rotate90Buffer.mirrorTo(nv21MirrorBuffer)
        nv21Buffer.scale(nv21ScaleBuffer, FilterMode.BILINEAR)
        convert2.setImageBitmap(nv21Buffer.toBitmap(rs))
        rotate902.setImageBitmap(nv21Rotate90Buffer.toBitmap(rs))
        mirror2.setImageBitmap(nv21MirrorBuffer.toBitmap(rs))
        scale2.setImageBitmap(nv21ScaleBuffer.toBitmap(rs))

        originalBuffer.release()
        rotate90Buffer.release()
        nv21Buffer.release()
        nv21Rotate90Buffer.release()
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    override fun onDestroy() {
        rs.destroy()

        super.onDestroy()
    }
}
