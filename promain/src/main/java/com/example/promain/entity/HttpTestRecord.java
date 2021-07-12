package com.example.promain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.sql.Blob;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 请求你记录表
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class HttpTestRecord extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModify;

    private Integer isDeleted;

    private String method;

    private String postData;

    private Blob responseText;

    private String url;

    private String author;


}
