package it.cnr.isti.ctt.controller;

import it.cnr.isti.ctt.model.SimpleObj;
import it.cnr.isti.ctt.model.request.SaveRequest;
import it.cnr.isti.ctt.model.request.SaveType;
import it.cnr.isti.ctt.model.response.FileListResponse;
import it.cnr.isti.ctt.model.response.OpenFileResponse;
import it.cnr.isti.ctt.model.response.ResponseStatus;
import it.cnr.isti.ctt.model.response.SaveResponse;
import it.cnr.isti.giove.ctt.TaskModel;
import it.cnr.isti.xmlUtils.XmlManager;
import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/rest")
public class CTTController {

    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    SimpleObj getShopInJSON(/*@PathVariable String name*/@RequestBody SimpleObj s) {
        return s;
    }

    @RequestMapping(value = "/open/{fileName}", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    OpenFileResponse getTaskModel(@PathVariable String fileName) {
        OpenFileResponse open = new OpenFileResponse();
        File f = new File("C:/Users/Marco/Documents/Repository/ctteCoop/Examples/xml/" + fileName + ".xml");
        if (!f.exists()) {
            open.setStatus(ResponseStatus.ERROR);
            open.setError("File does not exist");
            return open;
        }
        XmlManager xmlMan = new XmlManager();
        TaskModel tm = xmlMan.unmarshallTaskModel(f);                
        open.setStatus(ResponseStatus.OK);
        open.setTasks(tm);
        return open;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    FileListResponse getFileList() {
        FileListResponse res = new FileListResponse();
        List<String> fList = new LinkedList<String>();
        File folder = new File("C:/Users/Marco/Documents/NetBeansProjects/Spring3MVC/src/main/webapp/xml");
        if (!folder.isDirectory()) {
            res.setStatus(ResponseStatus.ERROR);
            res.setError("Not a directory");
        } else {
            class MyFilter implements FileFilter {
                @Override
                public boolean accept(File file) {
                    return !file.isHidden() && !file.isDirectory() && file.getName().endsWith(".xml");
                }
            }
            File[] fileList = folder.listFiles(new MyFilter());
            for(int i = 0; i < fileList.length; i++) {
                fList.add(fileList[i].getName().substring(0, fileList[i].getName().length()-4));
            }            
            res.setFileList(fList);
        }        
        return res;
    }
    
    private HttpHeaders addAccessControllAllowOrigin() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        return headers;
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody
    SaveResponse saveFile(@RequestBody SaveRequest req) {
        XmlManager xmlMan = new XmlManager();
        File f;
        if (req.getType().equals(SaveType.SAVE)) {
            f = new File("C:/Users/Marco/Documents/NetBeansProjects/Spring3MVC/src/main/webapp/xml/" + req.getFilename() + ".xml");
        } else {
            f = new File("C:/Users/Marco/Documents/NetBeansProjects/Spring3MVC/src/main/webapp/tmp/" + req.getFilename() + "_draft.xml");
        }
        boolean result = xmlMan.saveTM(req.getTask(), f);

        SaveResponse res = new SaveResponse();
        if (result) {
            res.setResponse("File saved");
        } else {
            res.setError("Error marshalling the file");
            res.setStatus(ResponseStatus.ERROR);
        }
        return res;
    }
}