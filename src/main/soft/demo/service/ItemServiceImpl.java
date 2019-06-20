package soft.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.demo.mapper.ItemsMapper;
import soft.demo.pojo.Items;

import java.util.Date;
import java.util.List;

/*
    查询商品信息
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    //查询商品列表
    public List<Items> selectIteList(){
        return itemsMapper.selectByExampleWithBLOBs(null);
    }
    //修改界面
    public Items selectItemById(Integer id){
        return itemsMapper.selectByPrimaryKey(id);
    }
    //修改
    public void updateItemById(Items items){
        items.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }

}
