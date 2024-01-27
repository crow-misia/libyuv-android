import csv
import string

plane_num_mapping = {
  'I400': ['Y'],
  'I420': ['Y', 'U', 'V'],
  'I422': ['Y', 'U', 'V'],
  'I444': ['Y', 'U', 'V'],
  'J400': ['Y'],
  'J420': ['Y', 'U', 'V'],
  'J422': ['Y', 'U', 'V'],
  'J444': ['Y', 'U', 'V'],
  'H420': ['Y', 'U', 'V'],
  'H422': ['Y', 'U', 'V'],
  'H444': ['Y', 'U', 'V'],
  'U420': ['Y', 'U', 'V'],
  'U422': ['Y', 'U', 'V'],
  'U444': ['Y', 'U', 'V'],
  'NV12': ['Y', 'UV'],
  'NV21': ['Y', 'VU'],
  'Android420': ['Y', 'U', 'V'],
  'ARGB': ['ARGB'],
  'ABGR': ['ABGR'],
  'BGRA': ['BGRA'],
  'RGBA': ['RGBA'],
  'RGB24': ['RGB24'],
  'RGB565': ['RGB565'],
  'RAW': ['RAW'],
  'ARGB1555': ['ARGB1555'],
  'ARGB4444': ['ARGB4444'],
  'AYUV': ['AYUV'],
  'UYVY': ['UYVY'],
  'YUY2': ['YUY2'],
  'YUV24': ['YUV24'],
  'AB30': ['AB30'],
  'AR30': ['AR30'],
  'Plane': [''],
  'A': ['A'],
  'Y': ['Y'],
  'UV': ['UV'],
  'SplitUV': ['U', 'V'],
}

def processConvertPart():
  convert_code = 'convert.cpp\n'
  with open('./convert.csv', 'r', encoding='utf-8') as convert_file:
    f = csv.reader(convert_file, escapechar='\\', delimiter=',', doublequote=True, quotechar='"', skipinitialspace=True)
    next(f)
    for row in f:
      src_format = row[0]
      dst_format = row[1]
      src_planes = plane_num_mapping[src_format]
      dst_planes = plane_num_mapping[dst_format]

      if src_format == dst_format:
        comment = f"Copy {src_format} to {dst_format}"
        function_name = f"convert{src_format}Copy"
      else:
        comment = f"Convert {src_format} to {dst_format}"
        function_name = f"convert{src_format}To{dst_format}"

      if row[2] != '':
        function_name = row[2]
      if row[3] != '':
        comment = row[3]

      convert_code += f"\n    /** {comment} */\n"
      convert_code += f"    external fun {function_name}(\n"
      for plane in src_planes:
        convert_code += f"        src{plane}: ByteBuffer, srcStride{plane}: Int,\n"
      for plane in dst_planes:
        convert_code += f"        dst{plane}: ByteBuffer, dstStride{plane}: Int,\n"
      convert_code += '        width: Int, height: Int,\n'
      convert_code += '    )\n'
  return convert_code

def processRotatePart():
  convert_code = 'rotate.cpp\n'
  with open('./rotate.csv', 'r', encoding='utf-8') as convert_file:
    f = csv.reader(convert_file, escapechar='\\',delimiter=',', doublequote=True, quotechar='"', skipinitialspace=True)
    next(f)
    for row in f:
      src_format = row[0]
      dst_format = row[1]
      src_planes = plane_num_mapping[src_format]
      dst_planes = plane_num_mapping[dst_format]

      if src_format == dst_format:
        comment = f"Rotate {src_format} Frame"
        function_name = f"rotate{src_format}Rotate"
      else:
        comment = f"Rotate {src_format} to {dst_format}"
        function_name = f"rotate{src_format}To{dst_format}Rotate"

      if row[2] != '':
        function_name = row[2]
      if row[3] != '':
        comment = row[3]

      convert_code += f"\n    /** {comment} */\n"
      convert_code += f"    external fun {function_name}(\n"
      for plane in src_planes:
        convert_code += f"        src{plane}: ByteBuffer, srcStride{plane}: Int,\n"
      if row[0] == 'Android420':
        convert_code += '        srcPixelStrideUV: Int,\n'
      for plane in dst_planes:
        convert_code += f"        dst{plane}: ByteBuffer, dstStride{plane}: Int,\n"
      convert_code += '        width: Int, height: Int,\n'
      convert_code += '        rotateMode: Int,\n'
      convert_code += '    )\n'
  return convert_code

def processScalePart():
  convert_code = 'scale.cpp\n'
  with open('./scale.csv', 'r', encoding='utf-8') as convert_file:
    f = csv.reader(convert_file, escapechar='\\',delimiter=',', doublequote=True, quotechar='"', skipinitialspace=True)
    next(f)
    for row in f:
      format = row[0]
      function_name = row[1]
      comment = row[2]
      planes = plane_num_mapping[format]

      if function_name == '':
        function_name = f"scale{format}Scale"
      if comment == '':
        comment = f"Scale {format} Frame"

      convert_code += f"\n    /** {comment} */\n"
      convert_code += f"    external fun {function_name}(\n"
      for plane in planes:
        convert_code += f"        src{plane}: ByteBuffer, srcStride{plane}: Int,\n"
      convert_code += '        srcWidth: Int, srcHeight: Int,\n'
      for plane in planes:
        convert_code += f"        dst{plane}: ByteBuffer, dstStride{plane}: Int,\n"
      convert_code += '        dstWidth: Int, dstHeight: Int,\n'
      convert_code += '        filterMode: Int,\n'
      convert_code += '    )\n'
  return convert_code

def processPlanerPart():
  convert_code = 'planar_functions.cpp\n'
  with open('./planer.csv', 'r', encoding='utf-8') as convert_file:
    f = csv.reader(convert_file, escapechar='\\',delimiter=',', doublequote=True, quotechar='"', skipinitialspace=True)
    next(f)
    for row in f:
      src_format = row[0]
      dst_format = row[1]
      isMirror = dst_format == 'mirror'
      src_planes = plane_num_mapping[src_format]

      if isMirror:
        dst_planes = src_planes
        comment = f"Mirror {src_format}"
        function_name = f"planer{src_format}Mirror"
      elif src_format == dst_format:
        dst_planes = plane_num_mapping[dst_format]
        comment = f"Copy {src_format} to {dst_format}"
        function_name = f"planer{src_format}Copy"
      else:
        dst_planes = plane_num_mapping[dst_format]
        comment = f"Convert {src_format} to {dst_format}"
        function_name = f"planer{src_format}To{dst_format}"

      if row[2] != '':
        function_name = row[2]
      if row[3] != '':
        comment = row[3]

      convert_code += f"\n    /** {comment} */\n"
      convert_code += f"    external fun {function_name}(\n"
      for plane in src_planes:
        convert_code += f"        src{plane}: ByteBuffer, srcStride{plane}: Int,\n"
      for plane in dst_planes:
        convert_code += f"        dst{plane}: ByteBuffer, dstStride{plane}: Int,\n"
      convert_code += '        width: Int, height: Int,\n'
      convert_code += '    )\n'
  return convert_code


kotlin_template = string.Template('')
with open('./yuv_class.kt', 'r', encoding='utf-8') as f:
  kotlin_template = string.Template(f.read())

with open('../src/main/java/io/github/crow_misia/libyuv/Yuv.kt', 'w', encoding='utf-8') as kotlin_file:
  dict = {
    'convert_code': processConvertPart(),
    'rotate_code': processRotatePart(),
    'scale_code': processScalePart(),
    'planar_code': processPlanerPart(),
  }
  print(kotlin_template.safe_substitute(dict), file=kotlin_file)
