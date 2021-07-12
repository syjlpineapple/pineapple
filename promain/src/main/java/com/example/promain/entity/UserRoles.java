package com.example.promain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhilee
 * @since 2021-06-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRoles extends Model {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long roleId;


}
