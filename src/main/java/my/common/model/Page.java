package my.common.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("page")
public class Page {

    private int currentPage; // 현재 페이지

    private int pageSize;   // 한 목록 당 페이지 수

    private int totalCount; // 전체 리스트 수

    private int totalPages; // 전체 페이지 수

    private int start; // 해당 페이지의 리스트 시작 인덱스 번호

    private int end; // 해당 페이지의 리스트 마지막 인덱스 번호

    public Page(int currentPage, int pageSize) {
        if(currentPage < 1) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }
        this.pageSize = pageSize;
        this.start = (currentPage - 1) * pageSize;
        this.end = pageSize;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPages = (totalCount / this.pageSize) + 1;
    }

}
