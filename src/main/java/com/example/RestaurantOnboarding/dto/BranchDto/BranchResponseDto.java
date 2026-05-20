package com.example.RestaurantOnboarding.dto.BranchDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchResponseDto {

    private Long branchId;
    private String ChainName;
    private String location;
    private String status;

    private String gstType;


}