package app

import android.graphics.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.databinding.ActivityMainBinding
import io.github.crow_misia.libyuv.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
    }

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
        val forBitmapBuffer = AbgrBuffer.allocate(width, height)
        val forBitmapRotateBuffer = AbgrBuffer.allocate(height, width)
        val forBitmapScaleBuffer = AbgrBuffer.allocate(100, 100)

        // dummy draw
        Canvas(bitmap).also {
            it.drawRect(0f, 0f, 1920f, 1080f, Paint().also { p ->
                p.shader = LinearGradient(0f, 0f, 0f, 1080f, Color.GREEN, Color.YELLOW, Shader.TileMode.CLAMP)
            })
            it.drawRect(50f, 50f, 150f, 150f, Paint().also { p -> p.color = Color.BLACK })
        }
        bitmap.copyPixelsToBuffer(originalBuffer.asBuffer())
        binding.origin.setImageBitmap(bitmap)
        binding.toBitmap.setImageBitmap(originalBuffer.asBitmap())

        Canvas(bitmap2).also {
            it.drawRect(0f, 0f, 1920f, 1080f, Paint().also { p ->
                p.shader = LinearGradient(0f, 0f, 0f, 1080f, Color.GREEN, Color.YELLOW, Shader.TileMode.CLAMP)
            })
            it.drawRect(50f, 50f, 150f, 150f, Paint().also { p -> p.color = Color.BLACK })
        }
        bitmap2.copyPixelsToBuffer(original2Buffer.asBuffer())
        binding.origin2.setImageBitmap(bitmap2)
        binding.toBitmap2.setImageBitmap(original2Buffer.asBitmap())

        originalBuffer.convertTo(nv21Buffer)
        nv21Buffer.rotate(nv21Rotate90Buffer, RotateMode.ROTATE_90)
        nv21Rotate90Buffer.mirrorTo(nv21MirrorBuffer)
        nv21Buffer.scale(nv21ScaleBuffer, FilterMode.BILINEAR)

        nv21Buffer.convertTo(forBitmapBuffer)
        binding.convert.setImageBitmap(forBitmapBuffer.asBitmap())
        nv21Rotate90Buffer.convertTo(forBitmapRotateBuffer)
        binding.rotate90.setImageBitmap(forBitmapRotateBuffer.asBitmap())
        nv21MirrorBuffer.convertTo(forBitmapBuffer)
        binding.mirror.setImageBitmap(forBitmapBuffer.asBitmap())
        nv21MirrorBuffer.convertTo(forBitmapScaleBuffer)
        binding.scale.setImageBitmap(forBitmapScaleBuffer.asBitmap())

        original2Buffer.convertTo(i420Buffer)
        i420Buffer.convertTo(nv21Buffer)
        nv21Buffer.rotate(nv21Rotate90Buffer, RotateMode.ROTATE_90)
        nv21Rotate90Buffer.mirrorTo(nv21MirrorBuffer)
        nv21Buffer.scale(nv21ScaleBuffer, FilterMode.BILINEAR)

        nv21Buffer.convertTo(forBitmapBuffer)
        binding.convert2.setImageBitmap(forBitmapBuffer.asBitmap())
        nv21Rotate90Buffer.convertTo(forBitmapRotateBuffer)
        binding.rotate902.setImageBitmap(forBitmapRotateBuffer.asBitmap())
        nv21MirrorBuffer.convertTo(forBitmapBuffer)
        binding.mirror2.setImageBitmap(forBitmapBuffer.asBitmap())
        nv21ScaleBuffer.convertTo(forBitmapScaleBuffer)
        binding.scale2.setImageBitmap(forBitmapScaleBuffer.asBitmap())


        originalBuffer.close()
        original2Buffer.close()
        i420Buffer.close()
        nv21Buffer.close()
        rotate90Buffer.close()
        nv21Rotate90Buffer.close()
        nv21MirrorBuffer.close()
        nv21ScaleBuffer.close()
    }
}
