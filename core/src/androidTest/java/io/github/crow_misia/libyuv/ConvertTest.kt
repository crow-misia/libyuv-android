package io.github.crow_misia.libyuv

import android.graphics.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

@RunWith(AndroidJUnit4::class)
class ConvertTest {
    private val parentDir by lazy {
        val context = InstrumentationRegistry.getInstrumentation().context
        context.getExternalFilesDir(null)
    }

    @Test
    fun output() {
        writeImageFromArgb("argb_le.raw") { AbgrBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }

        writeImageFromArgb("argb_to_abgr_le.raw") { AbgrBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_argb1555_le.raw") { Argb1555Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_argb4444_le.raw") { Argb4444Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_bgra_le.raw") { BgraBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_i400_le.raw") { I400Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_i420_le.raw") { I420Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_i422_le.raw") { I422Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_i444_le.raw") { I444Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_nv12_le.raw") { Nv12Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_nv21_le.raw") { Nv21Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_raw_le.raw") { RawBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_rgb24_le.raw") { Rgb24Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_rgb565_le.raw") { Rgb565Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromArgb("argb_to_rgba_le.raw") { RgbaBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }

        writeImageFromAbgr("abgr_to_i420_le.raw") { I420Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromAbgr("abgr_to_nv12_le.raw") { Nv12Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromAbgr("abgr_to_nv21_le.raw") { Nv21Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }

        writeImageFromNv21("nv21_to_abgr_le.raw") { AbgrBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_i400_le.raw") { I400Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_i420_le.raw") { I420Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_nv12_le.raw") { Nv12Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_nv21_le.raw") { Nv21Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_raw_le.raw") { RawBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_rgb24_le.raw") { Rgb24Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
        writeImageFromNv21("nv21_to_yuv24_le.raw") { Yuv24Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) } }
    }

    private fun <DESC: Buffer> writeImageFromAbgr(filename: String, convert: (AbgrBuffer) -> DESC) {
        writeImage(
            filename = filename,
            srcGenerate = {
                generateBitmap().use {
                    return@use AbgrBuffer.allocate(it.width, it.height).also { d -> it.convertTo(d) }
                }
            },
            convert = convert,
        )
    }

    private fun <DESC: Buffer> writeImageFromNv21(filename: String, convert: (Nv21Buffer) -> DESC) {
        writeImage(
            filename = filename,
            srcGenerate = {
                generateBitmap().use {
                    return@use Nv21Buffer.allocate(it.width, it.height).also { d -> it.convertTo(d) }
                }
            },
            convert = convert,
        )
    }

    private fun <DESC: Buffer> writeImageFromArgb(filename: String, convert: (ArgbBuffer) -> DESC) {
        writeImage(
            filename = filename,
            srcGenerate = { generateBitmap() },
            convert = convert,
        )
    }

    private fun <SRC : Buffer, DESC: Buffer> writeImage(filename: String, srcGenerate: () -> SRC, convert: (SRC) -> DESC) {
        srcGenerate().use { srcBuffer ->
            convert(srcBuffer).use { descBuffer ->
                File(parentDir, filename).outputStream().buffered().use {
                    descBuffer.write(it)
                }
            }
        }
    }

    private fun generateBitmap(): ArgbBuffer {
        val buffer = ArgbBuffer.allocate(512, 512)
        val colorGenerator = ColorGenerator(512)
        val bitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888)
        Canvas(bitmap).also {
            for (x in 0 until colorGenerator.steps) {
                it.drawLine(x.toFloat(), 0f, x.toFloat(), 512f, Paint().also { p ->
                    p.color = colorGenerator.nextColor()
                })
            }
        }
        bitmap.copyPixelsToBuffer(buffer.asBuffer())
        return buffer
    }
}
