package com.yuexin.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class UserPageDTO {
    private List<UserDTO> data;

    private long totalElements;
    private int totalPages;
    private int currentPage;

    @JsonProperty("isFirst")
    private boolean isFirst;

    @JsonProperty("isLast")
    private boolean isLast;

    private boolean hasNext;
    private boolean hasPrevious;

    public UserPageDTO(Page<UserDTO> userPage) {
        this.setData(userPage.getContent());
        this.setTotalElements(userPage.getTotalElements());
        this.setTotalPages(userPage.getTotalPages());
        this.setCurrentPage(userPage.getNumber() + 1);
        this.setFirst(userPage.isFirst());
        this.setLast(userPage.isLast());
        this.setHasNext(userPage.hasNext());
        this.setHasPrevious(userPage.hasPrevious());
    }
}
