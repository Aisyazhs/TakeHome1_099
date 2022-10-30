/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.hiling;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AISYAH SUHERMAN
 */
@Controller
public class HilController {
    @RequestMapping("/view")
    //@ResponseBody
    public String tampil(
            @RequestParam(value = "nama") String nama,
            @RequestParam(value = "lokasi") String lokasi,
            @RequestParam(value = "gambar") MultipartFile gambar,
            Model model
            
    ) throws IOException{  
        byte[] img = gambar.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String pic= "data:image/png;base64,".concat(base64Image);
      
        
        
        model.addAttribute("nama", nama);
        model.addAttribute("lokasi", lokasi);
        model.addAttribute("gmb", pic);
        
        return "view";
    
    
    }
}
