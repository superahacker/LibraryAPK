package pe.edu.idat.utpproject.UTIL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by TORRES on 10/08/2015.
 */
public class Base64Library {
    public static String encodeTobase64(Bitmap image)
    {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }
    public static Bitmap decodeBase64(String input)
    {
        //byte[] decodedString = Base64.decode(oUsuarioBE.getUsu_foto(), Base64.DEFAULT);
        //Bitmap bitMap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
