package my.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import my.admin.model.Stats;

import java.util.List;

@Mapper
@Repository
public interface StatsMapper {

    int selectStatsLoginListTotalCount(Stats stats);

    List selectStatsLoginList(Stats stats);

}
