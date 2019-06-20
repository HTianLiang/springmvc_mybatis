package soft.demo.conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    转换日期类型的数据
    S:页面传递过来的类型
    T：转换后的类型
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        try {
            if (null != s){ //2019:03-30 11_12-59
                DateFormat dateFormat = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
                return dateFormat.parse(s);
            }
        }catch (Exception e){

        }
        return null;
    }
}
