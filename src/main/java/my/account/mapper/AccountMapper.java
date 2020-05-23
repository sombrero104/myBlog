package my.account.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import my.account.model.Account;

@Mapper
@Repository
public interface AccountMapper {

    Account findByUsername(String username);

    int createNewAccount(Account account);

    int insertLoginLog(String username);

}
