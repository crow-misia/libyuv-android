package app


import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import app.converter.JavaConverter
import app.converter.LibYuvConverter
import java.nio.Buffer
import java.nio.ByteBuffer
import java.security.SecureRandom
import java.util.*

/**
 * This activity demonstrates how to use JNI to encode and decode ogg/vorbis audio
 */
class MainActivity : Activity() {
    private val executor = ConverterExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val bitmap = Bitmap.createBitmap(1920, 1080, Bitmap.Config.ARGB_8888)
        val width = bitmap.width
        val height = bitmap.height
        val size = width * height
        val rgbBufferSize = bitmap.rowBytes * height
        val yuvBufferSize = size * 3 / 2
        val rgbBuffer = ByteBuffer.allocate(rgbBufferSize)
        val yuvJavaBuffer = ByteArray(yuvBufferSize)
        val yuvLibYuvBuffer = ByteArray(yuvBufferSize)

        // dummy draw
        bitmap.setPixel(0,0, Color.argb(255, 128, 0, 0))
        bitmap.setPixel(1,0, Color.argb(255, 0, 128, 0))
        bitmap.setPixel(2,0, Color.argb(255, 0, 0, 128))
        bitmap.setPixel(3,0, Color.argb(255, 128, 128, 128))

        bitmap.copyPixelsToBuffer(rgbBuffer)

        val textView: TextView = findViewById(R.id.textView)

        textView.text = buildString {
            appendln(executor.execute(JavaConverter(), rgbBuffer.array(), width, height, yuvJavaBuffer))
            appendln(executor.execute(LibYuvConverter(), rgbBuffer.array(), width, height, yuvLibYuvBuffer))

            append("RGB byte: ").appendln(rgbBuffer.array().copyOfRange(0, 16).toHex())
            append("Java(Y) byte: ").appendln(yuvJavaBuffer.copyOfRange(0, 4).toHex())
            append("Java(UV) byte: ").appendln(yuvJavaBuffer.copyOfRange(size, size + 8).toHex())
            append("LibYuv(Y) byte: ").appendln(yuvLibYuvBuffer.copyOfRange(0, 4).toHex())
            append("LibYuv(UV) byte: ").appendln(yuvLibYuvBuffer.copyOfRange(size, size + 8).toHex())
        }
    }
}

fun ByteArray.toHex() = this.joinToString(separator = " ") { it.toInt().and(0xff).toString(16).padStart(2, '0') }
