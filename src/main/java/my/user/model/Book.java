package my.user.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import my.common.model.Page;

@Data
@Alias("book")
public class Book {

    private String id;

    private String title;

    private String content;

    private String author;

    private String reg_date;

    private String searchWord;

    private Page page;

}
