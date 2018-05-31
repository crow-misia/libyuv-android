package app

import android.app.Activity
import android.graphics.*
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import app.converter.JavaConverter
import app.converter.LibYuvConverter
import app.rotate.LibYuvRotator
import io.github.zncmn.libyuv.Yuv
import io.github.zncmn.libyuv.YuvConvert
import io.github.zncmn.libyuv.YuvFormat
import java.nio.ByteBuffer

/**
 * This activity demonstrates how to use JNI to encode and decode ogg/vorbis audio
 */
class MainActivity : Activity() {
    private val converterExecutor = ConverterExecutor()
    private val rotateExecutor = RotateExecutor()
    private lateinit var origin: ImageView
    private lateinit var convert: ImageView
    private lateinit var rotate90: ImageView
    private val converter = YuvConvert()

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
        val rgbBufferSize = bitmap.rowBytes * height
        val yuvBufferSize = YuvFormat.NV21.getDataSize(width, height)
        val rgbBuffer = ByteBuffer.allocate(rgbBufferSize)
        val argbBuffer = ByteBuffer.allocate(rgbBufferSize)
        val yuvJavaBuffer = ByteArray(yuvBufferSize)
        val yuvLibYuvBuffer = ByteArray(yuvBufferSize)
        val rotateYuvLibYuvBuffer = ByteArray(yuvBufferSize)

        // dummy draw
        Canvas(bitmap).also {
            val paint = Paint()
            val shader = LinearGradient(0f, 0f, 0f, 1080f, Color.RED, Color.BLUE, Shader.TileMode.CLAMP)
            paint.shader = shader
            it.drawRect(0f, 0f, 1920f, 1080f, paint)
        }
        bitmap.copyPixelsToBuffer(rgbBuffer)
        origin.setImageBitmap(bitmap)

        val textView: TextView = findViewById(R.id.textView)

        textView.text = buildString {
            appendln("Convert")
            appendln(converterExecutor.execute(JavaConverter(), rgbBuffer.array(), width, height, yuvJavaBuffer))
            appendln(converterExecutor.execute(LibYuvConverter(), rgbBuffer.array(), width, height, yuvLibYuvBuffer))

            convert.setImageBitmap(yuvToBitmap(yuvLibYuvBuffer, 1920, 1080, argbBuffer))

            appendln("Rotate")
            appendln(rotateExecutor.execute(LibYuvRotator(), yuvLibYuvBuffer, width, height, rotateYuvLibYuvBuffer) { w, h ->
                rotate90.setImageBitmap(yuvToBitmap(rotateYuvLibYuvBuffer, w, h, argbBuffer))
            })
        }
    }

    fun yuvToBitmap(yuv: ByteArray, width: Int, height: Int, argb: ByteBuffer): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        argb.clear()
        converter.toARGB(yuv, argb.array(), width, height, YuvFormat.NV21)
        argb.limit(width * height * 4)
        bitmap.copyPixelsFromBuffer(argb)
        return bitmap
    }
}

fun ByteArray.toHex() = this.joinToString(separator = " ") { it.toInt().and(0xff).toString(16).padStart(2, '0') }
