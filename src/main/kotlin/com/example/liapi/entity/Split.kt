package com.example.liapi.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * 列表的分页
 */
@ApiModel(value = "Province", description = "省市区-省")
data class Split(
        @ApiModelProperty(value = "分页的下标")
        var pageNum:Int? = 1,
        @ApiModelProperty(value = "分页-每页的数量")
        var pageSize:Int? = 20
)