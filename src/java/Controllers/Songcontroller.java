package Controllers;

import DAO.SongDAO;
import Songs.Mp3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class Songcontroller {

    @Autowired
    private SongDAO dao;

    @RequestMapping(value = "/showform")
    public ModelAndView getuserform() {
        Mp3 a = new Mp3();
        a.setTitle("mpaxalo");
        a.setId(999);
        dao.insert(a);
        ModelAndView mva = new ModelAndView("songlist");
        mva.addObject("userEntity", a);
        return mva;
    }

    @RequestMapping(value = "findname1", method = RequestMethod.GET)
    public String findname(ModelMap model, @RequestParam(value = "name") String name) {
        Mp3 a = new Mp3();
       model.addAttribute("list",  dao.finder(name));
        
        return "findname";
    }
    //forma pou vazw gramata kai kanw submit

}
