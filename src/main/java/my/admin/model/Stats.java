package my.admin.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import my.common.model.Page;

@Data
@Alias("stats")
public class Stats {

    private String id;

    private String username;

    private String activity;

    private String reg_date;

    private String searchWord;

    private Page page;

}
