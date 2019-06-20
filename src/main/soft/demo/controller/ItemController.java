package soft.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import soft.demo.pojo.Items;
import soft.demo.pojo.QueryVo;
import soft.demo.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
   商品管理
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    //入门程序 第一 包类+类包+方法名
    @RequestMapping(value = "/soft/itemlist.action")
    public ModelAndView itemlist(){
        //从mysql中查询
        List<Items> list = itemService.selectIteList();

        //数据
        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList",list);
        mav.setViewName("itemList");
        return mav;
    }
    //去修改界面 入参id
    @RequestMapping(value = "/itemEdit.action")
    public ModelAndView toEdit(Integer id,HttpServletRequest request, HttpServletResponse response,
                               HttpSession session, Model model){
        //Servlet时开发
//        String id = request.getParameter("id");
//        Items items = itemService.selectItemById(Integer.parseInt(id));
        Items items = itemService.selectItemById(id);
        //数据
        ModelAndView mav = new ModelAndView();
        mav.addObject("item",items);
        mav.setViewName("editItem");
        return mav;
    }
    //提交修改界面 入参为 Items对象
    @RequestMapping(value = "/updateitem.action")
//    public ModelAndView updateitem(Items items){
    public ModelAndView updateitem(QueryVo vo){

        //修改
        itemService.updateItemById(vo.getItems());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        return mav;
    }

}
