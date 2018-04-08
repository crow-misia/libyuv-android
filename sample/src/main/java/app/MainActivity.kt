package app


import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import app.converter.JavaConverter
import app.converter.LibYuvConverter
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

        val width = 1920
        val height = 1080
        val size = width * height
        val rgb = ByteArray(size * 4)
        val yuvjava = ByteArray(size * 3 / 2)
        val yuvlibyuv = ByteArray(size * 3 / 2)

        val random = SecureRandom()
        random.nextBytes(rgb)

        val textView: TextView = findViewById(R.id.textView)

        textView.text = buildString {
            appendln(executor.execute(JavaConverter(), rgb, width, height, yuvjava))
            appendln(executor.execute(LibYuvConverter(), rgb, width, height, yuvlibyuv))
        }
    }
}
