package com.cxs.framework.utils.qrcode;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 
 * @Description: 二维码生成
 * @ClassName: com.cxs.framework.utils.QRCodeUtil
 * @author: ryan.guo   
 * @email: chinazan@qq.com
 * @date: 2017年6月8日
 */
public class QRCodeUtil {

	private static final String CHARSET = "utf-8";
	private static final String FORMAT_NAME = "JPG";
	
	// 二维码尺寸
	private static final int QRCODE_SIZE = 300;
    // LOGO宽度  
	private static final int WIDTH = 60;
    // LOGO高度  
	private static final int HEIGHT = 60;

	private static final int MULTIPLE = 3;

	private static BufferedImage createImage(String content, String imgPath, boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE * MULTIPLE,
				QRCODE_SIZE * MULTIPLE, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
		if (imgPath == null || "".equals(imgPath)) {
			return image;
		}
		// 插入图片  
		QRCodeUtil.insertImage(image, imgPath, needCompress);
		return image;
	}
	  
    /** 
     * 插入LOGO 
     * @param source  二维码图片 
     * @param logoFileName  LOGO图片地址 
     * @param needCompress 是否压缩 
     * @throws Exception 
     */
	private static void insertImage(BufferedImage source, String logoFileName, boolean needCompress) throws Exception {
		File file = new File(logoFileName);
		if (!file.exists()) {
			System.err.println("" + logoFileName + "file not exits!");
			return;
		}
		Image src = ImageIO.read(new File(logoFileName));

		if (needCompress) {
			// 压缩LOGO  
			Image image = src.getScaledInstance(WIDTH * MULTIPLE, HEIGHT * MULTIPLE, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(WIDTH * MULTIPLE, HEIGHT * MULTIPLE, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			// 绘制缩小后的图 
			g.drawImage(image, 0, 0, null);
			g.dispose();
			src = image;
		}
        // 插入LOGO  
		Graphics2D graph = source.createGraphics();
		int x = (QRCODE_SIZE * MULTIPLE - WIDTH * MULTIPLE) / 2;
		int y = (QRCODE_SIZE * MULTIPLE - HEIGHT * MULTIPLE) / 2;
		graph.drawImage(src, x, y, WIDTH * MULTIPLE, HEIGHT * MULTIPLE, null);
		Shape shape = new RoundRectangle2D.Float(x, y, WIDTH * MULTIPLE, WIDTH * MULTIPLE, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	/**
     * 生成二维码(内嵌LOGO) 
	 * @param content   二维码对应的内容（一般为url）
	 * @param logoFileName  logo文件
	 * @param qrCodeDestPath  二维存储路径
	 * @param qrCodeFileName  二维码文件名
	 * @param needCompress  是否压缩logo
	 * @throws Exception
	 */
	public static void encode(String content, String logoFileName, String qrCodeDestPath, String qrCodeFileName, boolean needCompress)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, logoFileName, needCompress);
		mkdirs(qrCodeDestPath);
		// String file = new Random().nextInt(99999999) + ".jpg";
		ImageIO.write(image, FORMAT_NAME, new File(qrCodeDestPath + qrCodeFileName));
	}
	  
    /** 
     * 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常) 
     * @author lanyuan 
     * Email: mmm333zzz520@163.com 
     * @date 2013-12-11 上午10:16:36 
     * @param destPath 存放目录 
     */
	public static void mkdirs(String destPath) {
		File file = new File(destPath);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
	}
	  
	/**
     * 生成二维码(内嵌LOGO) 
	 * @param content   二维码对应的内容（一般为url）
	 * @param logoFileName  logo文件
	 * @param qrCodeDestPath  二维存储路径
	 * @param qrCodeFileName  二维码文件名
	 * @throws Exception
	 */
	public static void encode(String content, String logoFileName, String qrCodeDestPath, String qrCodeFileName) throws Exception {
		QRCodeUtil.encode(content, logoFileName, qrCodeDestPath, qrCodeFileName, false);
	}
	  
    /** 
     * 生成二维码(无内嵌LOGO) 
	 * @param content   二维码对应的内容（一般为url）
	 * @param qrCodeDestPath  二维存储路径
	 * @param qrCodeFileName  二维码文件名
	 * @throws Exception
     */ 
	public static void encode(String content, String qrCodeDestPath, String qrCodeFileName) throws Exception {
		QRCodeUtil.encode(content,null, qrCodeDestPath, qrCodeFileName, false);
	}
  
	/**
	 * 生成二维码(内嵌LOGO) 
	 * @param content   二维码对应的内容（一般为url）
	 * @param logoFileName  logo文件
	 * @param outputStream 二维码输出流
	 * @param needCompress 是否压缩LOGO 
	 * @throws Exception
	 */
	public static void encode(String content, String logoFileName, OutputStream outputStream, boolean needCompress)
			throws Exception {
		BufferedImage image = QRCodeUtil.createImage(content, logoFileName, needCompress);
		ImageIO.write(image, FORMAT_NAME, outputStream);
	}

 
	/**
	 * 生成二维码(无内嵌LOGO) 
	 * @param content   二维码对应的内容（一般为url）
	 * @param outputStream 二维码输出流
	 * @throws Exception
	 */
	public static void encode(String content, OutputStream outputStream) throws Exception {
		QRCodeUtil.encode(content, null, outputStream, false);
	}
	
	/**
     * 解析二维码 
	 * @param qrCodeFile 二维码文件
	 * @return
	 * @throws Exception
	 */
	public static String decode(File qrCodeFile) throws Exception {
		BufferedImage image;
		image = ImageIO.read(qrCodeFile);
		if (image == null) {
			return null;
		}
		BufferedImageLuminanceSource source = new BufferedImageLuminanceSource(image);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Result result;
		Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
		hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
		result = new MultiFormatReader().decode(bitmap, hints);
		String resultStr = result.getText();
		return resultStr;
	}
	  
    /** 
     * 解析二维码 
     * @param qrCodeFilePath 二维码图片地址 
     * @return 
     * @throws Exception 
     */ 
	public static String decode(String qrCodeFilePath) throws Exception {
		return QRCodeUtil.decode(new File(qrCodeFilePath));
	}


	/**
	 *
	 * 生成二维码
	 *
	 * @param projectName		项目名称
	 * @param codeBasePath      二维码跟路径
	 * @param url			请求Url前缀
	 * @param requestPath		请求
	 * @param paramMap			参数列表
	 * @param fileName				文件名
	 * @param needCompress		是否压缩
	 * @throws Exception
	 */
	public static void encode(String projectName, String codeBasePath, String url, String requestPath, Map<String,String> paramMap, String fileName, boolean needCompress) throws Exception {
		
		String content = url;
		if(null!=requestPath){
			content=content+requestPath;
		}
		if(null!=paramMap&&!paramMap.isEmpty()){
			content=content+"?";
			Iterator<String> keyIterator = paramMap.keySet().iterator();
			String params ="";
			while(keyIterator.hasNext()){
				String key = keyIterator.next();
				params=params+"&"+key+"="+paramMap.get(key);
			}
			content=content+params.substring(1);
		}
		String imgPath=codeBasePath+projectName+"/logo/logo.png";
		String destBasePath=codeBasePath+projectName+"/";
		QRCodeUtil.encode(content, imgPath, destBasePath, fileName, false);
	}

	public static void main(String [] args){
		String url = "https://www.hellorich.com/msite/html/activity/meeting.html";
		String imgPath = "/Users/apple/myproject/cxs-extension/sourcecode/cxs-extension/logo/hellorich.png";
		String destBasePath = "/Users/apple/myproject/cxs-extension/sourcecode/cxs-extension/logo/";
		String fileName = "会议议程.png";
		try {
			QRCodeUtil.encode(url,imgPath,destBasePath,fileName,false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
