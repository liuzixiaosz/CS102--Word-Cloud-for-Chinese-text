/**
   FileCharsetDetector is designed by MX He
   that help to detetect possible CharsetNames or Encodings of a text file.
  
   It comtains only one class FileCharsetDetector.java
   and a lib chardet.jar from: 
   https://sourceforge.net/projects/jchardet/
  
   The Usage :
   java FileCharsetDetector <path>
  
   The runing results:
  
   ..>java FileCharsetDetector ./test1_utf8_noBOM.txt
   Probable Charset = UTF-8 : ���Ĳ���
   Probable Charset = Shift_JIS : �W?֜?�i��??
   Probable Charset = GB18030 : 中文测试
   Probable Charset = UTF-16LE : ?�GΔ??�
   Probable Charset = windows-1252 : ????�C????��??
   Probable Charset = UTF-16BE : ��?ꞦOڻ?
   
   ..>java FileCharsetDetector ./test2_Default.txt
   Probable Charset = UTF-8 : ?���Ĳ���
   Probable Charset = UTF-16LE : ?��?�|��ڪ??
   Probable Charset = GB18030 : ﻿中文测�?
   Probable Charset = UTF-16BE : ???���n???
   Probable Charset = windows-1252 : ???????�C????��??
   
   ..>java FileCharsetDetector ./test3_utf8.txt
   Probable Charset = UTF-8 : ���Ĳ���
   Probable Charset = Shift_JIS : �W?֜?�i��??
   Probable Charset = GB18030 : 中文测试
   Probable Charset = UTF-16LE : ?�GΔ??�
   Probable Charset = windows-1252 : ????�C????��??
   Probable Charset = UTF-16BE : ��?ꞦOڻ?
   
   ..>java FileCharsetDetector ./test4_ASCII_Escap.txt
   CHARSET = ASCII : \u4E2D\u6587\u6D4B\u8BD5
   
   ..>java FileCharsetDetector ./test5_ASCII.txt
   Probable Charset = GB18030 : ���Ĳ���
   Probable Charset = Shift_JIS : ?????�|?
   Probable Charset = EUC-JP : ��dϼ��
   Probable Charset = UTF-16LE : ??��?
   Probable Charset = EUC-KR : ����?�U
   Probable Charset = UTF-16BE : ????
   Probable Charset = Big5 : ���`����
   Probable Charset = GB2312 : ���Ĳ���

*/
