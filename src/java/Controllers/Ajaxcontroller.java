
package Controllers;

import DAO.SongDAO;
import Songs.Mp3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ajaxcontroller {
    
      @Autowired
    private SongDAO dao;
    
     @RequestMapping(value = "findname", method = RequestMethod.GET,headers = "Accept=*/*", produces ="application/json" )         //dilwnoume apo pou dexomaste request sto header
    public @ResponseBody String getallbyRest(@RequestParam(value = "userinput") String id) throws JsonProcessingException {
       List<Mp3> m= dao.finder(id);
        ObjectMapper mapper= new ObjectMapper();  // me Jackson lib to kanw json
        
         System.out.println(mapper.writeValueAsString(m));
        return mapper.writeValueAsString(m);
    }
    
}
