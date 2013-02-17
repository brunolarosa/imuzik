/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

    import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import org.jsoup.Jsoup;

/**
 *
 * @author dominiquec
 */
public class HTMLUtils {

  private HTMLUtils() {}

  public static String extractText(String sb) throws IOException {
    String textOnly = Jsoup.parse(sb.toString()).text();
    return textOnly;
  }

 
}

