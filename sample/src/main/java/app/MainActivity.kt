package app

import android.graphics.*
import android.os.Bundle
import android.util.Log
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
        val argbBuffer = ArgbBuffer.allocate(width, height)
        val i422Buffer = I422Buffer.allocate(width, height)
        val i420Buffer = I420Buffer.allocate(width, height)
        val ar30Buffer = Ar30Buffer.allocate(width, height)
        val ab30Buffer = Ab30Buffer.allocate(width, height)
        val yuy2Buffer = Yuy2Buffer.allocate(width, height)
        val uyvyBuffer = UyvyBuffer.allocate(width, height)
        val rotate90Buffer = I420Buffer.allocate(height, width)
        val nv12Buffer = Nv12Buffer.allocate(width, height)
        val nv21Buffer = Nv21Buffer.allocate(width, height)
        val nv21Rotate90Buffer = Nv21Buffer.allocate(height, width)
        val nv21MirrorBuffer = Nv21Buffer.allocate(height, width)
        val nv21ScaleBuffer = Nv21Buffer.allocate(100, 100)
        val forBitmapBuffer = AbgrBuffer.allocate(width, height)
        val forBitmapRotateBuffer = AbgrBuffer.allocate(height, width)
        val forBitmapMirrorBuffer = AbgrBuffer.allocate(height, width)
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
        nv21MirrorBuffer.convertTo(forBitmapMirrorBuffer)
        binding.mirror.setImageBitmap(forBitmapMirrorBuffer.asBitmap())
        nv21ScaleBuffer.convertTo(forBitmapScaleBuffer)
        binding.scale.setImageBitmap(forBitmapScaleBuffer.asBitmap())

        original2Buffer.convertTo(i420Buffer)
        i420Buffer.convertTo(nv21Buffer)
        nv21Buffer.rotate(nv21Rotate90Buffer, RotateMode.ROTATE_90)
        nv21Rotate90Buffer.mirrorTo(nv21MirrorBuffer)
        nv21Buffer.scale(nv21ScaleBuffer, FilterMode.BILINEAR)
        i420Buffer.convertTo(ar30Buffer)
        i420Buffer.convertTo(ab30Buffer)
        i420Buffer.convertTo(yuy2Buffer)
        i420Buffer.convertTo(uyvyBuffer)

        nv21Buffer.convertTo(forBitmapBuffer)
        binding.convert2.setImageBitmap(forBitmapBuffer.asBitmap())
        nv21Rotate90Buffer.convertTo(forBitmapRotateBuffer)
        binding.rotate902.setImageBitmap(forBitmapRotateBuffer.asBitmap())
        nv21MirrorBuffer.convertTo(forBitmapMirrorBuffer)
        binding.mirror2.setImageBitmap(forBitmapMirrorBuffer.asBitmap())
        nv21ScaleBuffer.convertTo(forBitmapScaleBuffer)
        binding.scale2.setImageBitmap(forBitmapScaleBuffer.asBitmap())

        ar30Buffer.convertTo(forBitmapBuffer)
        binding.convert3.setImageBitmap(forBitmapBuffer.asBitmap())

        ab30Buffer.convertTo(forBitmapBuffer)
        binding.convert4.setImageBitmap(forBitmapBuffer.asBitmap())

        yuy2Buffer.convertTo(argbBuffer)
        argbBuffer.convertTo(forBitmapBuffer)
        binding.convert5.setImageBitmap(forBitmapBuffer.asBitmap())

        uyvyBuffer.convertTo(argbBuffer)
        argbBuffer.convertTo(forBitmapBuffer)
        binding.convert6.setImageBitmap(forBitmapBuffer.asBitmap())

        yuy2Buffer.convertTo(nv12Buffer)
        nv12Buffer.convertTo(forBitmapBuffer)
        binding.convert7.setImageBitmap(forBitmapBuffer.asBitmap())

        uyvyBuffer.convertTo(nv12Buffer)
        nv12Buffer.convertTo(forBitmapBuffer)
        binding.convert8.setImageBitmap(forBitmapBuffer.asBitmap())

        yuy2Buffer.convertTo(i422Buffer)
        i422Buffer.convertTo(forBitmapBuffer)
        binding.convert9.setImageBitmap(forBitmapBuffer.asBitmap())

        Log.i(TAG, "I422 Y Buffer DJB2 Hash %d".format(i422Buffer.planeY.hashDjb2()))

        uyvyBuffer.convertTo(i422Buffer)
        i422Buffer.convertTo(forBitmapBuffer)
        binding.convert10.setImageBitmap(forBitmapBuffer.asBitmap())

        Log.i(TAG, "I422 Y Buffer DJB2 Hash %d".format(i422Buffer.planeY.hashDjb2()))

        Canvas(bitmap2).also {
            it.drawRect(0f, 0f, 1f, 1f, Paint().also { p -> p.color = Color.BLACK })
        }
        bitmap2.copyPixelsToBuffer(original2Buffer.asBuffer())
        original2Buffer.convertTo(argbBuffer)
        argbBuffer.convertTo(nv12Buffer)
        Log.i(TAG, "Hamming Distance I422:NV12 Y Buffer %d".format(i422Buffer.planeY.hammingDistance(nv12Buffer.planeY)))
        Log.i(TAG, "Sum Square Error I422:NV12 Y Buffer %d".format(i422Buffer.planeY.computeSumSquareError(nv12Buffer.planeY, 1920, 1080)))
        Log.i(TAG, "Sum Square Error NV12:I422 Y Buffer %d".format(nv12Buffer.planeY.computeSumSquareError(i422Buffer.planeY, 1920, 1080)))
        Log.i(TAG, "Frame PSNR NV12:I422 Y Buffer %f".format(nv12Buffer.planeY.calculateFramePsnr(i422Buffer.planeY, 1920, 1080)))
        Log.i(TAG, "Frame SSIM NV12:I422 Y Buffer %f".format(nv12Buffer.planeY.calculateFrameSsim(i422Buffer.planeY, 1920, 1080)))

        originalBuffer.close()
        original2Buffer.close()
        uyvyBuffer.close()
        yuy2Buffer.close()
        ab30Buffer.close()
        ar30Buffer.close()
        i420Buffer.close()
        i422Buffer.close()
        argbBuffer.close()
        rotate90Buffer.close()
        nv12Buffer.close()
        nv21Buffer.close()
        nv21Rotate90Buffer.close()
        nv21MirrorBuffer.close()
        nv21ScaleBuffer.close()
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
