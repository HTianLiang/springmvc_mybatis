package soft.demo.service;

import soft.demo.pojo.Items;

import java.util.List;

public interface ItemService {
    public List<Items> selectIteList();
    public Items selectItemById(Integer id);
    public void updateItemById(Items items);
}
