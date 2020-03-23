package app

import android.app.Activity
import android.graphics.*
import android.os.Bundle
import android.widget.ImageView
import io.github.zncmn.libyuv.*
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer


/**
 * This activity demonstrates how to use JNI to encode and decode ogg/vorbis audio
 */
class MainActivity : Activity() {
    private lateinit var origin: ImageView
    private lateinit var convert: ImageView
    private lateinit var rotate90: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        origin = findViewById(R.id.origin)
        convert = findViewById(R.id.convert)
        rotate90 = findViewById(R.id.rotate90)
    }

    override fun onResume() {
        super.onResume()

        val bitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888)
        val width = bitmap.width
        val height = bitmap.height
        val originalBuffer = AbgrBuffer.allocate(width, height)
        val nv21Buffer = Nv21Buffer.allocate(width, height)
        val rotate90Buffer = I420Buffer.allocate(height, width)
        val nv21Rotate90Buffer = Nv21Buffer.allocate(height, width)

        // dummy draw
        Canvas(bitmap).also {
            val paint = Paint()
            val shader = LinearGradient(0f, 0f, 0f, 1080f, Color.RED, Color.BLUE, Shader.TileMode.CLAMP)
            paint.shader = shader
            it.drawRect(0f, 0f, 1920f, 1080f, paint)
        }
        bitmap.copyPixelsToBuffer(originalBuffer.bufferABGR)
        origin.setImageBitmap(bitmap)

        originalBuffer.convertTo(nv21Buffer)
        nv21Buffer.rotate(rotate90Buffer, RotateMode.ROTATE_180)
        rotate90Buffer.convertTo(nv21Rotate90Buffer)

        convert.setImageBitmap(yuvToBitmap(nv21Buffer, width, height))
        rotate90.setImageBitmap(yuvToBitmap(nv21Rotate90Buffer, height, width))
    }

    fun yuvToBitmap(nv21Buffer: Nv21Buffer, width: Int, height: Int): Bitmap {
        val yumData = nv21Buffer.asByteArray()
        val yuvImage = YuvImage(yumData, ImageFormat.NV21, width, height, null)
        val baos = ByteArrayOutputStream()
        yuvImage.compressToJpeg(Rect(0, 0, width, height), 80, baos)
        val jpegData: ByteArray = baos.toByteArray()

        return BitmapFactory.decodeByteArray(jpegData, 0, jpegData.size)
    }
}
