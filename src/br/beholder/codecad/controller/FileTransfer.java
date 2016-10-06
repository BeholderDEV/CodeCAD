/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.codecad.controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

/**
 *
 * @author lite
 */
public class FileTransfer {
    public static BufferedImage downloadImage(String urlPath){
        BufferedImage image = null;
        try {
            URL url = new URL(urlPath);
            URLConnection connection = url.openConnection();
            connection.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            image = ImageIO.read(connection.getInputStream());
        } catch (IOException e) {
        }
        return image;
    }
    
    public static void saveFile(String urlPath, String type, BufferedImage image) throws IOException{
        String path=urlPath;
        if(!path.contains(type)){
            path=path.concat("."+type);
        }
        File outputfile = new File(path);
        ImageIO.write(image, type, outputfile);
    }
}
