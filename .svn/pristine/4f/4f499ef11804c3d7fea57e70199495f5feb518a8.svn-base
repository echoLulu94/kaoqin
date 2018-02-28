package com.cxs.framework.utils.pdf;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("restriction")
public class PDFchangToImage {

	private static final Logger logger = LoggerFactory.getLogger(PDFchangToImage.class);

	/**
	 * pdf转img
	 * @param instructiopath pdf绝对路径
	 * @param picturepath pdf转成img后保存的文件夹路径
	 * @return
	 */
	public static Integer changePdfToImg(String instructiopath,String picturepath, String clearFlag) {
		return changePdfToImg(instructiopath,picturepath, false,1f,1000);
	}

	/**
	 * pdf转img
	 * @param instructiopath pdf绝对路径
	 * @param picturepath pdf转成img后保存的文件夹路径
	 * @param clearFlag 是否清空图片目录,true-清空，false-不清空
	 * @return
	 */
	public static Integer ePdfToImg(String instructiopath, String picturepath, boolean clearFlag) {
		return changePdfToImg(instructiopath, picturepath, clearFlag,1f,1000);
	}

	/**
	 * pdf转img
	 * @param instructiopath pdf绝对路径
	 * @param picturepath pdf转成img后保存的文件夹路径
	 * @param clearFlag 是否清空图片目录,true-清空，false-不清空
	 * @param quality 压缩比,取值0~1，Float类型
	 * @param basePage img文件名初始值，文件名为初始值+页码，例如：初始值为1000，则第一张为图片文件名为1001
	 * @return
	 */
	public static Integer changePdfToImg(String instructiopath,String picturepath, boolean clearFlag, Float quality ,int basePage) {
		logger.info("pdf文件路径：《"+instructiopath+"》");
		logger.info("pdf转化后图片文件路径：《"+instructiopath+"》");
		List<String> imgList = new ArrayList<String>();
		int pageCount =0;
		if(null==quality){
			quality=1f;
		}
		try {

			File file = new File(instructiopath);
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			FileChannel channel = raf.getChannel();
			MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
					0, channel.size());
			PDFFile pdffile = new PDFFile(buf);
			//创建图片文件夹
			File dirfile = new File(picturepath);
			if(!dirfile.exists()){
			   	dirfile.mkdirs();
			}else{
//				// 判断是否清除图片目录
				if(clearFlag){
					//循环删除图片目录下的图片
					File[] files = dirfile.listFiles();
					for(File tempFile : files){
						tempFile.delete();
					}
				}
			}
			//获得图片页数
			pageCount = pdffile.getNumPages();
			for (int i = 1; i <= (pdffile.getNumPages()); i++) {
				PDFPage page = pdffile.getPage(i);
				Rectangle rect = new Rectangle(0, 0, ((int) page.getBBox()
						.getWidth()), ((int) page.getBBox().getHeight()));
				int n = 2;
				/** 图片清晰度（n>0且n<7）【pdf放大参数】 */
				Image img = page.getImage(rect.width * n, rect.height * n,
						rect, /** 放大pdf到n倍，创建图片。 */
						null, /** null for the ImageObserver */
						true, /** fill background with white */
						true /** block until drawing is done */
				);
				BufferedImage tag = new BufferedImage(rect.width * n,
						rect.height * n, BufferedImage.TYPE_INT_RGB);
				tag.getGraphics().drawImage(img, 0, 0, rect.width * n,
						rect.height * n, null);
				/**
				 * 创建文件名
				 */
				String fileName =  String.valueOf(basePage+i)+ ".jpg";
				FileOutputStream out = new FileOutputStream(picturepath+"/" + fileName);

				PDFchangToImage.saveAsJPEG(null,tag,quality,out);

				/** JPEG编码 */
				out.close();
				logger.info("文件名：《"+fileName+"》");
				imgList.add(fileName);
			}
			channel.close();
			raf.close();
			unmap(buf);
			/** 如果要在转图片之后删除pdf，就必须要这个关闭流和清空缓冲的方法 */
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(),e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
		return pageCount;
		
	}

	/**
	 * 以JPEG编码保存图片
	 * @param dpi  分辨率
	 * @param imageToSave  要处理的图像图片
	 * @param quality  压缩比
	 * @param fos 文件输出流
	 * @throws IOException
	 */
	public static void saveAsJPEG(Integer dpi ,BufferedImage imageToSave, float quality, FileOutputStream fos) throws IOException {

		ImageWriter imageWriter  =   ImageIO.getImageWritersBySuffix("jpg").next();
		ImageOutputStream ios  =  ImageIO.createImageOutputStream(fos);
		imageWriter.setOutput(ios);
		//and metadata
		IIOMetadata imageMetaData  =  imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(imageToSave), null);


		if(dpi !=  null){
			//new metadata
			Element tree  =  (Element) imageMetaData.getAsTree("javax_imageio_jpeg_image_1.0");
			Element jfif  =  (Element)tree.getElementsByTagName("app0JFIF").item(0);
			jfif.setAttribute("Xdensity", Integer.toString(dpi) );
			jfif.setAttribute("Ydensity", Integer.toString(dpi));

		}


		if(quality >= 0 && quality <= 1f){
			JPEGImageWriteParam jpegParams  =  (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();
			jpegParams.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);
			jpegParams.setCompressionQuality(quality);

		}else{
			logger.error("压缩比《"+quality+"》超出正常范围，正常范围0~1！");
		}

		imageWriter.write(imageMetaData, new IIOImage(imageToSave, null, null), null);
		ios.close();
		imageWriter.dispose();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void unmap(final Object buffer) {
		AccessController.doPrivileged(new PrivilegedAction() {
			public Object run() {
				try {
					Method getCleanerMethod = buffer.getClass().getMethod(
							"cleaner", new Class[0]);
					getCleanerMethod.setAccessible(true);
					sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod
							.invoke(buffer, new Object[0]);
					cleaner.clean();
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
				return null;
			}
		});
	}

	public static void main(String [] args){
		/**
		 * 需要转化的PDF
		 */
		String instructiopath ="/Users/apple/myproject/cxs-extension/doc/相关资料/合络财富月刊/第七期.pdf";
		/**
		 * PDF转化成image之后存储的路径
		 */
		String picturepath = "/Users/apple/myproject/cxs-extension/doc/相关资料/pdf/image/201708";
		int initNum = 1000;
		Integer count = changePdfToImg(instructiopath, picturepath,true,0.2f,initNum);
		
	}
}