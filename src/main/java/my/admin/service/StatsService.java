package my.admin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my.admin.mapper.StatsMapper;
import my.admin.model.Stats;

import java.util.List;

@Slf4j
@Service
@Transactional
public class StatsService {

    @Autowired
    StatsMapper statsMapper;

    public int getStatsLoginListTotalCount(Stats stats) {
        return statsMapper.selectStatsLoginListTotalCount(stats);
    }

    public List getStatsLoginList(Stats stats) {
        return statsMapper.selectStatsLoginList(stats);
    }

}