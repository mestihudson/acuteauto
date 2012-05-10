package com.acminds.acuteauto.ui.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.acminds.acuteauto.persistence.BaseDAO;
import com.acminds.acuteauto.persistence.dto.Image;
import com.acminds.acuteauto.utils.Utils;

/**
 * 
 * @author MANSUR
 *
 */
public class ImageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final String DEFAULT_IMG = "/images/thumbnails/coming-soon.jpg";
	/*
	 * mime types:
	 * image/bmp
	 * image/gif
	 * image/jpeg
	 * image/png
	 * 
	 * image/tiff
	 * image/svg
	 */
	private Log logger = LogFactory.getLog(ImageServlet.class);
	
	
	public void init() throws ServletException {
		super.init();
		logger.info("Image rendering servlet initialized");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		try {
			String imageId = request.getParameter("imgId");
			logger.info("Image Id: "+imageId);
			if(Utils.isEmpty(imageId))
				return;
			Image image = BaseDAO.getInstance().get(Image.class, Integer.valueOf(imageId.trim()));
			if(image == null)
			{
				writeDefaultImage(request, response);
				return;
			}
			InputStream str = new FileInputStream(new File(image.getRealLocation()));
			response.setContentType(image.getMimeType());		
			OutputStream out = response.getOutputStream();
			out.write(IOUtils.toByteArray(str));
		} catch (NumberFormatException e) {
			logger.error(e.getMessage(), e);
			throw new ServletException(e);
		} catch (FileNotFoundException e) {
			try {
				writeDefaultImage(request, response);
			} catch (URISyntaxException e1) {
				logger.error(e.getMessage(), e);
				throw new ServletException(e);
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new ServletException(e);
		} catch (URISyntaxException e) {
			logger.error(e.getMessage(), e);
			throw new ServletException(e);
		}
		
	}
	
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) 
		throws ServletException, IOException 
	{
		doGet(arg0, arg1);
	}
	
	private void writeDefaultImage(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException{
		response.getWriter().print("Image Coming Soon");
		response.setContentType("text/plain");
		return;				
	}
}
