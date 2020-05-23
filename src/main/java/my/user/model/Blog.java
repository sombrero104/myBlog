package my.user.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import my.common.model.Page;

@Data
@Alias("blog")
public class Blog {

    private String id;

    private String title;

    private String content;

    private String reg_date;

    private String category;

    private String category_id;

    private String category_div;

    private Page page;

    private String searchWord;

}
